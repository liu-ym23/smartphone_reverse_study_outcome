package com.bytedanceos.preventdisturb;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SqliteWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.ContactsContract;
import android.provider.Telephony;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import bytedanceos.util.LogTag;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.bytedanceos.numberassistant.QueryCallerIdCallback;
import com.bytedanceos.numberassistant.xysdk.XySdkCallBackAdapter;
import com.bytedanceos.securitycenter.SecurityCenterApplication;
import com.obric.olog.OLog;
import com.obric.security.R;
import java.io.IOException;
import java.io.InputStream;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class Contact {
    private static final int CONTACT_METHOD_ID_UNKNOWN = -1;
    public static final int CONTACT_METHOD_TYPE_EMAIL = 2;
    public static final int CONTACT_METHOD_TYPE_PHONE = 1;
    public static final int CONTACT_METHOD_TYPE_SELF = 3;
    public static final int CONTACT_METHOD_TYPE_UNKNOWN = 0;
    public static final String CONTENT_SCHEME = "content";
    private static final String SELF_ITEM_KEY = "Self_Item_Key";
    private static final String TAG = "Contact";
    public static final String TEL_SCHEME = "tel";
    private static final HashSet<UpdateListener> mListeners = null;
    private static ContactsCache sContactCache;
    private BitmapDrawable mAvatar;
    private byte[] mAvatarData;
    private String mClassify;
    private long mContactMethodId;
    private int mContactMethodType;
    private boolean mInBlacklist;
    private boolean mIsMe;
    private boolean mIsStale;
    private String mLabel;
    private Bitmap mLogo;
    private String mName;
    private String mNameAndNumber;
    private String mNotiName;
    private String mNumber;
    private String mNumberE164;
    private boolean mNumberIsModified;
    private Uri mPeopleReferenceUri;
    private long mPersonId;
    private int mPresenceResId;
    private String mPresenceText;
    private boolean mQueryPending;
    private long mRecipientId;
    private boolean mSendToVoicemail;
    private String mSpamName;

    /* JADX INFO: renamed from: com.bytedanceos.preventdisturb.Contact$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class ContactsCache {
        private static final String[] CALLER_ID_PROJECTION = null;
        private static final String CALLER_ID_SELECTION = " Data._ID IN  (SELECT DISTINCT lookup.data_id  FROM  (SELECT data_id, normalized_number, length(normalized_number) as len  FROM phone_lookup  WHERE min_match = ?) AS lookup  WHERE lookup.normalized_number = ? OR (lookup.len <= ? AND  substr(?, ? - lookup.len + 1) = lookup.normalized_number))";
        private static final String CALLER_ID_SELECTION_WITHOUT_E164 = " Data._ID IN  (SELECT DISTINCT lookup.data_id  FROM  (SELECT data_id, normalized_number, length(normalized_number) as len  FROM phone_lookup  WHERE min_match = ?) AS lookup  WHERE  (lookup.len <= ? AND  substr(?, ? - lookup.len + 1) = lookup.normalized_number))";
        private static final int CONTACT_ID_COLUMN = 4;
        private static final int CONTACT_NAME_COLUMN = 3;
        private static final int CONTACT_PRESENCE_COLUMN = 5;
        private static final int CONTACT_STATUS_COLUMN = 6;
        private static final int EMAIL_CONTACT_ID_COLUMN = 3;
        private static final int EMAIL_CONTACT_NAME_COLUMN = 4;
        private static final int EMAIL_ID_COLUMN = 0;
        private static final int EMAIL_NAME_COLUMN = 1;
        private static final String[] EMAIL_PROJECTION = null;
        private static final String EMAIL_SELECTION = "UPPER(data1)=UPPER(?) AND mimetype='vnd.android.cursor.item/email_v2'";
        private static final int EMAIL_SEND_TO_VOICEMAIL_COLUMN = 5;
        private static final int EMAIL_STATUS_COLUMN = 2;
        private static final Uri EMAIL_WITH_PRESENCE_URI = null;
        private static final Uri PHONES_WITH_PRESENCE_URI = null;
        private static final int PHONE_ID_COLUMN = 0;
        private static final int PHONE_LABEL_COLUMN = 2;
        private static final int PHONE_NORMALIZED_NUMBER = 7;
        private static final int PHONE_NUMBER_COLUMN = 1;
        private static final int SELF_CONTACT_ID_COLUMN = 2;
        private static final int SELF_ID_COLUMN = 0;
        private static final int SELF_NAME_COLUMN = 1;
        private static final String[] SELF_PROJECTION = null;
        private static final int SEND_TO_VOICEMAIL = 8;
        private static final String SEPARATOR = ";";
        static final char STATIC_KEY_BUFFER_CHAR = '0';
        static final int STATIC_KEY_BUFFER_MAXIMUM_LENGTH = 5;
        static CharBuffer sStaticKeyBuffer;
        private static ExecutorService singleThreadExecutor;
        private final BlacklistContentObserver mBlacklistContentObserver;
        private final HashMap<String, ArrayList<Contact>> mContactsHash;
        private final Context mContext;
        private final CootekManager mCootekManager;
        private final TaskStack mTaskQueue;

        private class BlacklistContentObserver extends ContentObserver {
            final /* synthetic */ ContactsCache this$0;

            public BlacklistContentObserver(final ContactsCache this$0, Handler handler) {
                this.this$0 = this$0;
                super(handler);
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange, Uri uri) {
                super.onChange(selfChange, uri);
                if (uri != null) goto L5;
                return;
            L5:
                String r6 = uri.getQueryParameter("number");
                if (TextUtils.isEmpty(r6) == false) goto L8;
                return;
            L8:
                String r0 = uri.getQueryParameter("optype");
                String r7 = uri.getQueryParameter("unread_count");
                if (r7 != null) goto L11;
            L13:
                String[] r8 = null;
            L15:
                if ("insert".equals(r0) == false) goto L17;
            L18:
                boolean r1 = "insert".equals(r0);
                String[] r9 = r6.split(" ");
                int r2 = 0;
            L20:
                if (r2 >= r9.length) goto L42;
                String r3 = r9[r2];
                if (r8 == null) goto L25;
                Integer.parseInt(r8[r2]);     // Catch: NumberFormatException -> L34
            L25:
                if (TextUtils.isEmpty(r3) == true) goto L32;
                Contact r4 = ContactsCache.access$3500(this.this$0, r3, false, false);
                if (r4 == null) goto L32;
                if (Contact.access$1100(r4) == r1) goto L32;
                r4.setInBlacklist(r1);
                ContactsCache.access$3100(this.this$0, r4);
            L32:
                r2 = r2 + 1;
                goto L20
            L42:
                return;
            L17:
                if ("delete".equals(r0) == true) goto L18;
                return;
            L11:
                if (TextUtils.isEmpty(r7) == true) goto L13;
                r8 = r7.split(" ");
                goto L15
            }
        }

        private static class TaskStack {
            private Handler mHandler;
            private final ArrayList<Runnable> mThingsToLoad;

            public TaskStack() {
                this.mThingsToLoad = new ArrayList();
                HandlerThread r0 = new HandlerThread("contact task");
                r0.setPriority(1);
                r0.start();
                if (r0.getLooper() == null) goto L6;
                this.mHandler = new Handler(r0.getLooper());
                return;
            }

            public void push(Runnable r) {
                this.mHandler.post(r);
            }
        }

        /* synthetic */ ContactsCache(Context r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ void access$000(ContactsCache r0, Contact r1) {
            r0.remove(r1);
        }

        static /* synthetic */ void access$200(ContactsCache r0) {
            r0.removeAll();
        }

        static /* synthetic */ CootekManager access$3000(ContactsCache r0) {
            return r0.mCootekManager;
        }

        static /* synthetic */ void access$3100(ContactsCache r0, Contact r1) {
            r0.notifyContactUpdate(r1);
        }

        static /* synthetic */ void access$3200(ContactsCache r0, Contact r1) {
            r0.updateClassify(r1);
        }

        static /* synthetic */ void access$3300(ContactsCache r0, Contact r1) {
            r0.updateNumberLogoByXy(r1);
        }

        static /* synthetic */ Contact access$3500(ContactsCache r0, String r1, boolean r2, boolean r3) {
            return r0.internalGet(r1, r2, r3);
        }

        static /* synthetic */ Context access$3600(ContactsCache r0) {
            return r0.mContext;
        }

        static /* synthetic */ void access$3700(ContactsCache r0, Contact r1, Bitmap r2) {
            r0.notifyContactUpdateIfNeedlyByLogo(r1, r2);
        }

        static /* synthetic */ void access$500(ContactsCache r0, Contact r1) {
            r0.updateContact(r1);
        }

        static {
            singleThreadExecutor = Executors.newSingleThreadExecutor();
            PHONES_WITH_PRESENCE_URI = ContactsContract.Data.CONTENT_URI;
            CALLER_ID_PROJECTION = new String[]{"_id", "data1", DBHelper.COL_DATA2, "display_name", "contact_id", "contact_presence", "contact_status", "data4", "send_to_voicemail"};
            SELF_PROJECTION = new String[]{"_id", "display_name", "contact_id"};
            EMAIL_WITH_PRESENCE_URI = ContactsContract.Data.CONTENT_URI;
            EMAIL_PROJECTION = new String[]{"_id", "data4", "contact_presence", "contact_id", "display_name", "send_to_voicemail"};
            sStaticKeyBuffer = CharBuffer.allocate(5);
        }

        private ContactsCache(Context context) {
            this.mTaskQueue = new TaskStack();
            this.mContactsHash = new HashMap();
            this.mBlacklistContentObserver = new BlacklistContentObserver(this, new Handler());
            this.mContext = context;
            this.mCootekManager = CootekManager.getInstance();
        }

        void dump() {
            monitor-enter(this);
            OLog.d(Contact.TAG, "**** Contact cache dump ****");     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public void pushTask(Runnable r) {
            this.mTaskQueue.push(r);
        }

        public Contact getMe(boolean canBlock) {
            return get(Contact.SELF_ITEM_KEY, true, canBlock, false);
        }

        public Contact get(String number, boolean canBlock) {
            return get(number, false, canBlock, false);
        }

        public Contact get(String number, boolean canBlock, boolean forceUpdate) {
            return get(number, false, canBlock, forceUpdate);
        }

        private Contact get(String number, boolean isMe, boolean canBlock, boolean forceUpdate) {
            if (TextUtils.isEmpty(number) == false) goto L5;
            number = "";
        L5:
            final Contact r2 = internalGet(number, isMe);
            monitor-enter(r2);
        L7:
            if (canBlock == false) goto L14;
        L12:
            th = move-exception;
            throw th;
        L9:
            if (Contact.access$300(r2) == false) goto L14;
            r2.wait();     // Catch: InterruptedException -> L29 Throwable -> L12
        L14:
            if (forceUpdate == true) goto L18;
            if (Contact.access$400(r2) == true) goto L18;
        L20:
            Runnable r3 = null;
        L21:
            monitor-exit(r2);     // Catch: Throwable -> L12
            if (r3 == null) goto L26;
            if (canBlock == false) goto L25;
            r3.run();
            goto L26
        L25:
            pushTask(r3);
        L26:
            return r2;
        L18:
            if (Contact.access$300(r2) == true) goto L20;
            Contact.access$402(r2, false);     // Catch: Throwable -> L12
            r3 = new AnonymousClass1(this, r2);     // Catch: Throwable -> L12
            Contact.access$302(r2, true);     // Catch: Throwable -> L12
            goto L21
        }

        private boolean contactChanged(Contact orig, Contact newContactData) {
            if (Contact.access$600(orig) == Contact.access$600(newContactData)) goto L6;
            return true;
        L6:
            if (Contact.access$700(orig) == Contact.access$700(newContactData)) goto L9;
            return true;
        L9:
            if (Contact.access$800(orig) == Contact.access$800(newContactData)) goto L15;
            if (LogTag.DBG == false) goto L13;
            OLog.d(Contact.TAG, "person id changed");
        L13:
            return true;
        L15:
            if (Contact.access$900(orig) == Contact.access$900(newContactData)) goto L21;
            if (LogTag.DBG == false) goto L19;
            OLog.d(Contact.TAG, "presence changed");
        L19:
            return true;
        L21:
            if (Contact.access$1000(orig) == Contact.access$1000(newContactData)) goto L24;
            return true;
        L24:
            if (Contact.access$1100(orig) == Contact.access$1100(newContactData)) goto L27;
            return true;
        L27:
            if (Contact.access$1300(Contact.access$1200(orig)).equals(Contact.access$1300(Contact.access$1200(newContactData))) == true) goto L30;
            return true;
        L30:
            if (Contact.access$1300(Contact.access$1400(orig)).equals(Contact.access$1300(Contact.access$1400(newContactData))) == true) goto L33;
            return true;
        L33:
            if (Arrays.equals(Contact.access$1500(orig), Contact.access$1500(newContactData)) == true) goto L39;
            if (LogTag.DBG == false) goto L37;
            OLog.d(Contact.TAG, "avatar changed");
        L37:
            return true;
        L39:
            if (Contact.access$1300(Contact.access$1600(orig)).equals(Contact.access$1300(Contact.access$1600(newContactData))) == true) goto L41;
            return true;
        L41:
            return false;
        }

        private void updateContact(final Contact c) {
            if (c != null) goto L4;
            return;
        L4:
            Contact r0 = getContactInfo(c);
            monitor-enter(c);
        L21:
            th = move-exception;
            throw th;
        L7:
            if (contactChanged(c, r0) == false) goto L12;
            Contact.access$1702(c, Contact.access$1700(r0));     // Catch: Throwable -> L21
            Contact.access$1402(c, Contact.access$1400(r0));     // Catch: Throwable -> L21
            Contact.access$802(c, Contact.access$800(r0));     // Catch: Throwable -> L21
            Contact.access$902(c, Contact.access$900(r0));     // Catch: Throwable -> L21
            Contact.access$1802(c, Contact.access$1800(r0));     // Catch: Throwable -> L21
            Contact.access$1502(c, Contact.access$1500(r0));     // Catch: Throwable -> L21
            Contact.access$702(c, Contact.access$700(r0));     // Catch: Throwable -> L21
            Contact.access$602(c, Contact.access$600(r0));     // Catch: Throwable -> L21
            Contact.access$1902(c, Contact.access$1900(r0));     // Catch: Throwable -> L21
            Contact.access$1202(c, Contact.access$1200(r0));     // Catch: Throwable -> L21
            Contact.access$1602(c, Contact.access$1600(r0));     // Catch: Throwable -> L21
            if (TextUtils.isEmpty(Contact.access$2000(r0)) == true) goto L11;
            Contact.access$2002(c, Contact.access$2000(r0));     // Catch: Throwable -> L21
        L11:
            Contact.access$2102(c, Contact.access$2100(r0));     // Catch: Throwable -> L21
            Contact.access$2202(c, Contact.access$2200(r0));     // Catch: Throwable -> L21
            Contact.access$1002(c, Contact.access$1000(r0));     // Catch: Throwable -> L21
            Contact.access$2302(c, Contact.access$2300(r0));     // Catch: Throwable -> L21
            Contact.access$1102(c, Contact.access$1100(r0));     // Catch: Throwable -> L21
            Contact.access$2402(c, Contact.access$2400(r0));     // Catch: Throwable -> L21
            Contact.access$2500(c);     // Catch: Throwable -> L21
            notifyContactUpdate(c);     // Catch: Throwable -> L21
        L12:
            monitor-enter(c);     // Catch: Throwable -> L21
            Contact.access$302(c, false);     // Catch: Throwable -> L18
            c.notifyAll();     // Catch: Throwable -> L18
            monitor-exit(c);     // Catch: Throwable -> L18
            monitor-exit(c);     // Catch: Throwable -> L21
            return;
        L18:
            th = move-exception;
            throw th;     // Catch: Throwable -> L21
        }

        private Contact getContactInfo(Contact c) {
            if (Contact.access$2600(c) == false) goto L7;
            return getContactInfoForSelf();
        L7:
            if (Telephony.Mms.isEmailAddress(Contact.access$1700(c)) == false) goto L11;
            return getContactInfoForEmailAddress(Contact.access$1700(c));
        L11:
            if (isAlphaNumber(Contact.access$1700(c)) == false) goto L18;
            Contact r0 = getContactInfoForEmailAddress(Contact.access$1700(c));
            if (r0.existsInDatabase() == false) goto L16;
            return r0;
        L16:
            return getContactInfoForPhoneNumber(c, Contact.access$1700(c));
        L18:
            return getContactInfoForPhoneNumber(c, PhoneNumberUtils.stripSeparators(Contact.access$1700(c)));
        }

        private boolean isAlphaNumber(String number) {
            if (PhoneNumberUtils.isWellFormedSmsAddress(number) == true) goto L6;
            return true;
        L6:
            if (MessageUtils.isAlias(number) == false) goto L8;
            return true;
        L8:
            String r1 = PhoneNumberUtils.extractNetworkPortion(number);
            if (TextUtils.isEmpty(r1) == false) goto L12;
            return true;
        L12:
            if (r1.length() < 3) goto L16;
            return false;
        L16:
            return true;
        }

        private Contact getContactInfoForPhoneNumber(Contact c, String number) {
            Contact r3 = new Contact(number, null);
            Contact.access$602(r3, 1);
            Contact.access$2302(r3, Uri.fromParts(Contact.TEL_SCHEME, number, null));
            String r4 = PhoneNumberUtils.normalizeNumber(number);
            String r6 = PhoneNumberUtils.toCallerIDMinMatch(r4);
            if (TextUtils.isEmpty(r4) == false) goto L5;
        L43:
            fillBlacklistContact(r3);
            fillContactFromCootek(c);
            return r3;
        L5:
            if (TextUtils.isEmpty(r6) == true) goto L43;
            String r7 = String.valueOf(r4.length());
            String r1 = PhoneNumberUtils.formatNumberToE164(number, SecurityCenterApplication.getApplication().getCurrentCountryIso());
            if (TextUtils.isEmpty(r1) == false) goto L9;
            String[] r2 = {r6, r7, r4, r7};
            String r5 = CALLER_ID_SELECTION_WITHOUT_E164;
        L10:
            ContentResolver r13 = this.mContext.getContentResolver();
            Uri r8 = PHONES_WITH_PRESENCE_URI;
            Cursor r9 = r13.query(r8, CALLER_ID_PROJECTION, r5, r2, null);
            if (r9 != null) goto L45;
            OLog.w(Contact.TAG, "queryContactInfoByNumber returned NULL cursor! contact uri used " + r8);
            return r3;
        L45:
        L40:
            th = move-exception;
            r9.close();
            throw th;
        L15:
            if (r9.moveToFirst() == false) goto L27;
            fillPhoneTypeContact(r3, r9);     // Catch: Throwable -> L40
            if (r9.getCount() > 1) goto L19;
        L36:
            r9.close();
            goto L43
        L19:
            if (Contact.access$1200(c) == null) goto L36;
            if (Contact.access$1200(c).equals(Contact.access$1200(r3)) == true) goto L36;
        L23:
            if (r9.moveToNext() == false) goto L36;
            if (Contact.access$1200(c).equals(r9.getString(3)) == false) goto L23;
            fillPhoneTypeContact(r3, r9);     // Catch: Throwable -> L40
            goto L23
        L27:
            Cursor r10 = this.mContext.getContentResolver().query(Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI, "data"), SELF_PROJECTION, r5, r2, null);     // Catch: Throwable -> L40
            if (r10 != null) goto L46;
            OLog.w(Contact.TAG, "queryContactInfoByNumber from self table returned NULL cursor! contact uri used " + r8);     // Catch: Throwable -> L40
            r9.close();
            return r3;
        L46:
        L37:
            th = move-exception;
            r10.close();     // Catch: Throwable -> L40
            throw th;     // Catch: Throwable -> L40
        L33:
            if (r10.moveToFirst() == false) goto L35;
            fillSelfContact(r3, r10);     // Catch: Throwable -> L37
        L35:
            r10.close();     // Catch: Throwable -> L40
            goto L36
        L9:
            String[] r11 = {r6, r1, r7, r4, r7};
            r5 = CALLER_ID_SELECTION;
            r2 = r11;
            goto L10
        }

        private Contact getContactInfoForSelf() {
            Contact r0 = new Contact(true, null);
            Contact.access$602(r0, 3);
            if (LogTag.DBG == false) goto L5;
            Contact.access$2900("getContactInfoForSelf");
        L5:
            Cursor r1 = this.mContext.getContentResolver().query(Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI, "data"), SELF_PROJECTION, null, null, null);
            if (r1 != null) goto L17;
            OLog.w(Contact.TAG, "getContactInfoForSelf() returned NULL cursor! contact uri used " + ContactsContract.Profile.CONTENT_URI);
            return r0;
        L17:
        L14:
            th = move-exception;
            r1.close();
            throw th;
        L10:
            if (r1.moveToFirst() == false) goto L12;
            fillSelfContact(r0, r1);     // Catch: Throwable -> L14
        L12:
            r1.close();
            return r0;
        }

        private void fillBlacklistContact(final Contact contact) {
            if (contact != null) goto L4;
            return;
        L4:
            if (TextUtils.isEmpty(Contact.access$1700(contact)) == true) goto L20;
            Uri r3 = Uri.withAppendedPath(Uri.parse("content://com.obric.nodisturb.provider/inblacklist"), Contact.access$1700(contact));
            Cursor r8 = this.mContext.getContentResolver().query(r3, new String[]{"bl_note"}, null, null, null);
            if (r8 == null) goto L18;
        L12:
            th = move-exception;
            r8.close();
            throw th;
        L9:
            if (r8.moveToFirst() == false) goto L11;
            Contact.access$1102(contact, true);     // Catch: Throwable -> L12
            Contact.access$1602(contact, r8.getString(0));     // Catch: Throwable -> L12
        L11:
            r8.close();
            return;
        L18:
            return;
        }

        private void fillPhoneTypeContact(final Contact contact, final Cursor cursor) {
            monitor-enter(contact);
            boolean r0 = true;
            Contact.access$602(contact, 1);     // Catch: Throwable -> L18
            Contact.access$702(contact, cursor.getLong(0));     // Catch: Throwable -> L18
            Contact.access$1402(contact, ContactsContract.CommonDataKinds.Phone.getTypeLabel(this.mContext.getResources(), cursor.getInt(2), "").toString());     // Catch: Throwable -> L18
            Contact.access$1202(contact, cursor.getString(3));     // Catch: Throwable -> L18
            Contact.access$802(contact, cursor.getLong(4));     // Catch: Throwable -> L18
            Contact.access$902(contact, getPresenceIconResourceId(cursor.getInt(5)));     // Catch: Throwable -> L18
            Contact.access$1802(contact, cursor.getString(6));     // Catch: Throwable -> L18
            Contact.access$1902(contact, cursor.getString(7));     // Catch: Throwable -> L18
            if (cursor.getInt(8) == 1) goto L8;
            r0 = false;
        L8:
            Contact.access$1002(contact, r0);     // Catch: Throwable -> L18
            monitor-exit(contact);     // Catch: Throwable -> L18
            byte[] r5 = loadAvatarData(contact);
            monitor-enter(contact);
            Contact.access$1502(contact, r5);     // Catch: Throwable -> L15
            monitor-exit(contact);     // Catch: Throwable -> L15
            return;
        L15:
            th = move-exception;
            throw th;
        L18:
            th = move-exception;
            throw th;
        }

        private void fillContactFromCootek(final Contact c) {
            singleThreadExecutor.execute(new AnonymousClass2(this, c));
        }

        private void notifyContactUpdate(Contact c) {
            if (TextUtils.isEmpty(Contact.access$1700(c)) == true) goto L18;
            HashSet r4 = Contact.access$3400();
            monitor-enter(r4);
            HashSet r0 = (HashSet) Contact.access$3400().clone();     // Catch: Throwable -> L15
            monitor-exit(r4);     // Catch: Throwable -> L15
            Iterator r5 = r0.iterator();
        L10:
            if (r5.hasNext() == false) goto L24;
            UpdateListener r1 = (UpdateListener) r5.next();
            if (LogTag.DBG == false) goto L14;
            OLog.d(Contact.TAG, "updating " + r1);
        L14:
            r1.onUpdate(c);
            goto L10
        L24:
            return;
        L15:
            th = move-exception;
            throw th;
        }

        private void fillSelfContact(final Contact contact, final Cursor cursor) {
            monitor-enter(contact);
            Contact.access$1202(contact, cursor.getString(1));     // Catch: Throwable -> L16
            Contact.access$802(contact, cursor.getLong(2));     // Catch: Throwable -> L16
            if (TextUtils.isEmpty(Contact.access$1200(contact)) == false) goto L7;
            Contact.access$1202(contact, this.mContext.getString(R.string.messagelist_sender_self));     // Catch: Throwable -> L16
        L7:
            monitor-exit(contact);     // Catch: Throwable -> L16
            byte[] r2 = loadAvatarData(contact);
            monitor-enter(contact);
            Contact.access$1502(contact, r2);     // Catch: Throwable -> L13
            monitor-exit(contact);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        L16:
            th = move-exception;
            throw th;
        }

        private byte[] loadAvatarData(Contact entry) {
            byte[] r2 = null;
            if (Contact.access$2400(entry) == null) goto L6;
            return null;
        L6:
            if (Contact.access$2600(entry) == false) goto L8;
        L11:
            Uri r8 = ContactsContract.Profile.CONTENT_URI;
        L12:
            InputStream r7 = ContactsContract.Contacts.openContactPhotoInputStream(this.mContext.getContentResolver(), r8, true);
            if (r7 != null) goto L32;
        L23:
            if (r7 != null) goto L30;
        L25:
            return r2;
        L30:
            r7.close();     // Catch: IOException -> L26
            goto L25
        L32:
            int r9 = r7.available();     // Catch: Throwable -> L16 IOException -> L20
            r2 = new byte[r9];     // Catch: Throwable -> L16 IOException -> L20
            Contact.access$2900("readCount=" + r7.read(r2, 0, r9));     // Catch: Throwable -> L16 IOException -> L20
        L20:
            if (r7 == null) goto L25;
        L16:
            th = move-exception;
            if (r7 != null) goto L28;
        L19:
            throw th;
        L28:
            r7.close();     // Catch: IOException -> L27
            goto L19
        L8:
            if (Contact.access$800(entry) == 0) goto L11;
            r8 = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, Contact.access$800(entry));
            goto L12
        }

        private int getPresenceIconResourceId(int presence) {
            if (presence != 0) goto L4;
            return 0;
        L4:
            return ContactsContract.Presence.getPresenceIconResourceId(presence);
        }

        private Contact getContactInfoForEmailAddress(String email) {
            Contact r0 = new Contact(email, null);
            Contact.access$602(r0, 2);
            Contact.access$2302(r0, Uri.fromParts("mailto", email, null));
            Context r3 = this.mContext;
            Cursor r4 = SqliteWrapper.query(r3, r3.getContentResolver(), EMAIL_WITH_PRESENCE_URI, EMAIL_PROJECTION, EMAIL_SELECTION, new String[]{email}, null);
            if (r4 != null) goto L45;
        L40:
            return r0;
        L45:
        L37:
            th = move-exception;
            r4.close();
            throw th;
        L5:
            if (r4.moveToNext() == false) goto L36;
            monitor-enter(r0);     // Catch: Throwable -> L37
            Contact.access$702(r0, r4.getLong(0));     // Catch: Throwable -> L33
            Contact.access$902(r0, getPresenceIconResourceId(r4.getInt(2)));     // Catch: Throwable -> L33
            Contact.access$802(r0, r4.getLong(3));     // Catch: Throwable -> L33
            if (r4.getInt(5) != 1) goto L10;
            boolean r5 = true;
        L11:
            Contact.access$1002(r0, r5);     // Catch: Throwable -> L33
            String r6 = r4.getString(1);     // Catch: Throwable -> L33
            if (TextUtils.isEmpty(r6) == false) goto L15;
            r6 = r4.getString(4);     // Catch: Throwable -> L33
        L20:
            if (TextUtils.isEmpty(r6) == true) goto L22;
            Contact.access$1202(r0, r6);     // Catch: Throwable -> L33
            boolean r7 = true;
        L23:
            monitor-exit(r0);     // Catch: Throwable -> L33
            if (r7 == false) goto L45;
            byte[] r11 = loadAvatarData(r0);     // Catch: Throwable -> L37
            monitor-enter(r0);     // Catch: Throwable -> L37
            Contact.access$1502(r0, r11);     // Catch: Throwable -> L30
            monitor-exit(r0);     // Catch: Throwable -> L30
        L30:
            th = move-exception;
            throw th;     // Catch: Throwable -> L37
        L22:
            r7 = false;
            goto L23
        L15:
            if (TextUtils.equals(r6, email) == false) goto L20;
            String r8 = r4.getString(4);     // Catch: Throwable -> L33
            if (TextUtils.isEmpty(r8) == true) goto L20;
            r6 = r8;
            goto L20
        L10:
            r5 = false;
            goto L11
        L33:
            th = move-exception;
            throw th;     // Catch: Throwable -> L37
        L36:
            r4.close();
            goto L40
        }

        private String key(String phoneNumber, CharBuffer keyBuffer) {
            keyBuffer.clear();
            keyBuffer.mark();
            int r4 = phoneNumber.length();
            int r0 = 0;
        L3:
            r4 = r4 - 1;
            if (r4 < 0) goto L9;
            char r2 = phoneNumber.charAt(r4);
            if (Character.isDigit(r2) == false) goto L3;
            keyBuffer.put(r2);
            r0 = r0 + 1;
            if (r0 != 5) goto L3;
        L9:
            if (r0 <= 0) goto L15;
            if (r0 >= 5) goto L13;
        L11:
            keyBuffer.put('0');
            r0 = r0 + 1;
            if (r0 < 5) goto L11;
        L13:
            keyBuffer.reset();
            return keyBuffer.toString();
        L15:
            keyBuffer.reset();
            return phoneNumber;
        }

        private Contact internalGet(String numberOrEmail, boolean isMe) {
            return internalGet(numberOrEmail, isMe, true);
        }

        private Contact internalGet(String numberOrEmail, boolean isMe, boolean createNew) {
            monitor-enter(this);
            int r0 = 0;
            boolean r1 = true;
            if (isMe == false) goto L48;
        L13:
            boolean r2 = true;
        L14:
            if (r2 == false) goto L16;
            String r3 = numberOrEmail;
        L17:
            ArrayList<Contact> r4 = this.mContactsHash.get(r3);     // Catch: Throwable -> L11
            AnonymousClass1 r5 = null;
            if (createNew == true) goto L22;
            if (r4 != null) goto L22;
            monitor-exit(this);     // Catch: Throwable -> L11
            return null;
        L22:
            if (r4 == null) goto L39;
            int r6 = r4.size();     // Catch: Throwable -> L11
        L24:
            if (r0 >= r6) goto L36;
            Contact r7 = r4.get(r0);     // Catch: Throwable -> L11
            if (r2 == false) goto L32;
            if (numberOrEmail.equals(Contact.access$1700(r7)) == false) goto L35;
            monitor-exit(this);     // Catch: Throwable -> L11
            return r7;
        L35:
            r0 = r0 + 1;     // Catch: Throwable -> L11
            goto L24
        L32:
            if (PhoneNumberUtils.compare(numberOrEmail, Contact.access$1700(r7), true) == false) goto L35;
            monitor-exit(this);     // Catch: Throwable -> L11
            return r7;
        L36:
            if (createNew == true) goto L40;
            monitor-exit(this);     // Catch: Throwable -> L11
            return null;
        L40:
            if (isMe == false) goto L42;
            Contact r9 = new Contact(r1, r5);     // Catch: Throwable -> L11
        L43:
            r4.add(r9);     // Catch: Throwable -> L11
            monitor-exit(this);     // Catch: Throwable -> L11
            return r9;
        L42:
            r9 = new Contact(numberOrEmail, r5);     // Catch: Throwable -> L11
            goto L43
        L39:
            r4 = new ArrayList();     // Catch: Throwable -> L11
            this.mContactsHash.put(r3, r4);     // Catch: Throwable -> L11
            goto L40
        L16:
            r3 = key(numberOrEmail, sStaticKeyBuffer);     // Catch: Throwable -> L11
            goto L17
        L48:
        L11:
            th = move-exception;
            throw th;
        L6:
            if (Telephony.Mms.isEmailAddress(numberOrEmail) == true) goto L13;
            if (MessageUtils.isAlias(numberOrEmail) == true) goto L13;
            r2 = false;
            goto L14
        }

        void invalidate() {
            monitor-enter(this);
            Iterator<ArrayList<Contact>> r0 = this.mContactsHash.values().iterator();     // Catch: Throwable -> L20
        L5:
            if (r0.hasNext() == false) goto L18;
            Iterator<Contact> r1 = r0.next().iterator();     // Catch: Throwable -> L20
        L8:
            if (r1.hasNext() == false) goto L5;
            Contact r2 = r1.next();     // Catch: Throwable -> L20
            monitor-enter(r2);     // Catch: Throwable -> L20
            Contact.access$402(r2, true);     // Catch: Throwable -> L15
            monitor-exit(r2);     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            throw th;     // Catch: Throwable -> L20
        L18:
            monitor-exit(this);     // Catch: Throwable -> L20
            return;
        L20:
            th = move-exception;
            throw th;
        }

        private void removeAll() {
            monitor-enter(this);
            this.mContactsHash.clear();     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        }

        private void remove(Contact contact) {
            monitor-enter(this);
            String r0 = contact.getNumber();     // Catch: Throwable -> L33
            int r1 = 0;
            if (contact.isMe() == false) goto L6;
        L11:
            boolean r7 = true;
        L12:
            if (r7 == false) goto L14;
            String r2 = r0;
        L15:
            ArrayList<Contact> r3 = this.mContactsHash.get(r2);     // Catch: Throwable -> L33
            if (r3 == null) goto L31;
            int r4 = r3.size();     // Catch: Throwable -> L33
        L18:
            if (r1 >= r4) goto L29;
            Contact r5 = r3.get(r1);     // Catch: Throwable -> L33
            if (r7 == false) goto L25;
            if (r0.equals(Contact.access$1700(r5)) == false) goto L27;
            r3.remove(r1);     // Catch: Throwable -> L33
        L27:
            r1 = r1 + 1;     // Catch: Throwable -> L33
            goto L18
        L25:
            if (PhoneNumberUtils.compare(r0, Contact.access$1700(r5)) == false) goto L27;
            r3.remove(r1);     // Catch: Throwable -> L33
        L29:
            if (r3.size() != 0) goto L31;
            this.mContactsHash.remove(r2);     // Catch: Throwable -> L33
        L31:
            monitor-exit(this);     // Catch: Throwable -> L33
            return;
        L14:
            r2 = key(r0, sStaticKeyBuffer);     // Catch: Throwable -> L33
            goto L15
        L6:
            if (Telephony.Mms.isEmailAddress(r0) == true) goto L11;
            if (MessageUtils.isAlias(r0) == true) goto L11;
            r7 = false;
        L33:
            th = move-exception;
            throw th;
        }

        private void updateNumberLogoByXy(final Contact contact) {
            SmsXySdkManager.NumberParserItem r0 = SmsXySdkManager.getInstance().getNumberParserItem(Contact.access$1700(contact));
            if (r0 != null) goto L5;
        L8:
            final StringBuilder r1 = new StringBuilder();
            XySdkCallBackAdapter r2 = new AnonymousClass3(this, r1, contact);
            this.mCootekManager.queryPublicInfoByXySdk(Contact.access$1700(contact), 1, null, r2);
            return;
        L5:
            if (r0.logo == null) goto L8;
            notifyContactUpdateIfNeedlyByLogo(contact, r0.logo);
        }

        private void notifyContactUpdateIfNeedlyByLogo(Contact contact, Bitmap logo) {
            if (logo != null) goto L4;
        L5:
            if (logo == null) goto L7;
            return;
        L7:
            if (Contact.access$2200(contact) == null) goto L11;
        L8:
            Contact.access$2202(contact, logo);
            notifyContactUpdate(contact);
            return;
        L11:
            return;
        L4:
            if (logo.equals(Contact.access$2200(contact)) == false) goto L8;
            goto L5
        }

        private void updateClassify(final Contact contact) {
            QueryCallerIdCallback r0 = new AnonymousClass4(this, contact);
            this.mCootekManager.queryCallerIdDetail(Contact.access$1700(contact), r0);
        }
    }

    public interface UpdateListener {
        void onUpdate(Contact updated);
    }

    private static String emptyIfNull(String s) {
        if (s != null) goto L6;
        return "";
    L6:
        return s;
    }

    public String toString() {
        return "{ contact=redacted }";
    }

    /* synthetic */ Contact(String r1, AnonymousClass1 r2) {
        this(r1);
    }

    /* synthetic */ Contact(boolean r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ boolean access$1000(Contact r0) {
        return r0.mSendToVoicemail;
    }

    static /* synthetic */ boolean access$1002(Contact r0, boolean r1) {
        r0.mSendToVoicemail = r1;
        return r1;
    }

    static /* synthetic */ boolean access$1100(Contact r0) {
        return r0.mInBlacklist;
    }

    static /* synthetic */ boolean access$1102(Contact r0, boolean r1) {
        r0.mInBlacklist = r1;
        return r1;
    }

    static /* synthetic */ String access$1200(Contact r0) {
        return r0.mName;
    }

    static /* synthetic */ String access$1202(Contact r0, String r1) {
        r0.mName = r1;
        return r1;
    }

    static /* synthetic */ String access$1300(String r0) {
        return emptyIfNull(r0);
    }

    static /* synthetic */ String access$1400(Contact r0) {
        return r0.mLabel;
    }

    static /* synthetic */ String access$1402(Contact r0, String r1) {
        r0.mLabel = r1;
        return r1;
    }

    static /* synthetic */ byte[] access$1500(Contact r0) {
        return r0.mAvatarData;
    }

    static /* synthetic */ byte[] access$1502(Contact r0, byte[] r1) {
        r0.mAvatarData = r1;
        return r1;
    }

    static /* synthetic */ String access$1600(Contact r0) {
        return r0.mSpamName;
    }

    static /* synthetic */ String access$1602(Contact r0, String r1) {
        r0.mSpamName = r1;
        return r1;
    }

    static /* synthetic */ String access$1700(Contact r0) {
        return r0.mNumber;
    }

    static /* synthetic */ String access$1702(Contact r0, String r1) {
        r0.mNumber = r1;
        return r1;
    }

    static /* synthetic */ String access$1800(Contact r0) {
        return r0.mPresenceText;
    }

    static /* synthetic */ String access$1802(Contact r0, String r1) {
        r0.mPresenceText = r1;
        return r1;
    }

    static /* synthetic */ String access$1900(Contact r0) {
        return r0.mNumberE164;
    }

    static /* synthetic */ String access$1902(Contact r0, String r1) {
        r0.mNumberE164 = r1;
        return r1;
    }

    static /* synthetic */ String access$2000(Contact r0) {
        return r0.mNotiName;
    }

    static /* synthetic */ String access$2002(Contact r0, String r1) {
        r0.mNotiName = r1;
        return r1;
    }

    static /* synthetic */ String access$2100(Contact r0) {
        return r0.mClassify;
    }

    static /* synthetic */ String access$2102(Contact r0, String r1) {
        r0.mClassify = r1;
        return r1;
    }

    static /* synthetic */ Bitmap access$2200(Contact r0) {
        return r0.mLogo;
    }

    static /* synthetic */ Bitmap access$2202(Contact r0, Bitmap r1) {
        r0.mLogo = r1;
        return r1;
    }

    static /* synthetic */ Uri access$2300(Contact r0) {
        return r0.mPeopleReferenceUri;
    }

    static /* synthetic */ Uri access$2302(Contact r0, Uri r1) {
        r0.mPeopleReferenceUri = r1;
        return r1;
    }

    static /* synthetic */ BitmapDrawable access$2400(Contact r0) {
        return r0.mAvatar;
    }

    static /* synthetic */ BitmapDrawable access$2402(Contact r0, BitmapDrawable r1) {
        r0.mAvatar = r1;
        return r1;
    }

    static /* synthetic */ void access$2500(Contact r0) {
        r0.notSynchronizedUpdateNameAndNumber();
    }

    static /* synthetic */ boolean access$2600(Contact r0) {
        return r0.mIsMe;
    }

    static /* synthetic */ void access$2900(String r0) {
        log(r0);
    }

    static /* synthetic */ boolean access$300(Contact r0) {
        return r0.mQueryPending;
    }

    static /* synthetic */ boolean access$302(Contact r0, boolean r1) {
        r0.mQueryPending = r1;
        return r1;
    }

    static /* synthetic */ HashSet access$3400() {
        return mListeners;
    }

    static /* synthetic */ boolean access$400(Contact r0) {
        return r0.mIsStale;
    }

    static /* synthetic */ boolean access$402(Contact r0, boolean r1) {
        r0.mIsStale = r1;
        return r1;
    }

    static /* synthetic */ int access$600(Contact r0) {
        return r0.mContactMethodType;
    }

    static /* synthetic */ int access$602(Contact r0, int r1) {
        r0.mContactMethodType = r1;
        return r1;
    }

    static /* synthetic */ long access$700(Contact r2) {
        return r2.mContactMethodId;
    }

    static /* synthetic */ long access$702(Contact r0, long r1) {
        r0.mContactMethodId = r1;
        return r1;
    }

    static /* synthetic */ long access$800(Contact r2) {
        return r2.mPersonId;
    }

    static /* synthetic */ long access$802(Contact r0, long r1) {
        r0.mPersonId = r1;
        return r1;
    }

    static /* synthetic */ int access$900(Contact r0) {
        return r0.mPresenceResId;
    }

    static /* synthetic */ int access$902(Contact r0, int r1) {
        r0.mPresenceResId = r1;
        return r1;
    }

    static {
        mListeners = new HashSet();
    }

    private Contact(String number, String name, String label) {
        initWithLabel(number, name, label);
    }

    private Contact(String number, String name) {
        init(number, name);
    }

    private Contact(String number) {
        init(number, "");
    }

    private Contact(boolean isMe) {
        init(SELF_ITEM_KEY, "");
        this.mIsMe = isMe;
    }

    private void init(String number, String name) {
        this.mContactMethodId = -1;
        this.mName = name;
        setNumber(number);
        this.mNumberIsModified = false;
        this.mLabel = "";
        this.mPersonId = 0;
        this.mPresenceResId = 0;
        this.mIsStale = true;
        this.mSendToVoicemail = false;
    }

    private void initWithLabel(String number, String name, String label) {
        this.mContactMethodId = -1;
        this.mName = name;
        setNumber(number);
        this.mNumberIsModified = false;
        this.mLabel = label;
        this.mPersonId = 0;
        this.mPresenceResId = 0;
        this.mIsStale = true;
        this.mSendToVoicemail = false;
    }

    public static void logWithTrace(String tag, String msg, Object... format) {
        Thread r0 = Thread.currentThread();
        StackTraceElement[] r1 = r0.getStackTrace();
        StringBuilder r2 = new StringBuilder("[");
        r2.append(r0.getId());
        r2.append("] ");
        r2.append(String.format(msg, format));
        r2.append(" <- ");
        int r3 = 7;
        if (r1.length > 7) goto L6;
        r3 = r1.length;
    L6:
        int r7 = 3;
    L7:
        if (r7 >= r3) goto L11;
        r2.append(r1[r7].getMethodName());
        r7 = r7 + 1;
        if (r7 == r3) goto L7;
        r2.append(" <- ");
        goto L7
    L11:
        OLog.d(tag, r2.toString());
    }

    public static Contact get(String number, boolean canBlock) {
        return sContactCache.get(number, canBlock);
    }

    public static Contact get(String number, boolean canBlock, boolean forceUpdate) {
        return sContactCache.get(number, canBlock, forceUpdate);
    }

    public static Contact getMe(boolean canBlock) {
        return sContactCache.getMe(canBlock);
    }

    public void removeFromCache() {
        ContactsCache.access$000(sContactCache, this);
    }

    public static void invalidateCache() {
        sContactCache.invalidate();
    }

    public boolean isMe() {
        return this.mIsMe;
    }

    public static String formatNameAndNumber(String name, String number, String numberE164) {
        if (Telephony.Mms.isEmailAddress(number) == true) goto L5;
        String r3 = PhoneNumberUtils.formatNumber(number, numberE164, SecurityCenterApplication.getApplication().getCurrentCountryIso());
    L6:
        String r4 = MessageUtils.formatPhoneNumber(r3);
        if (TextUtils.isEmpty(name) == false) goto L9;
    L12:
        return r4;
    L9:
        if (name.equals(number) == true) goto L12;
        return name + " <" + r4 + ">";
    L5:
        r3 = number;
        goto L6
    }

    private String formatNameAndNumber(String name, String number) {
        if (TextUtils.isEmpty(name) == false) goto L5;
    L8:
        return number;
    L5:
        if (name.equals(number) == true) goto L8;
        return name + " <" + number + ">";
    }

    public synchronized void reload() {
        monitor-enter(this);
        this.mIsStale = true;     // Catch: Throwable -> L7
        sContactCache.get(this.mNumber, false);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized String getNumber() {
        monitor-enter(this);
        String r0 = this.mNumber;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setNumber(String number) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (Telephony.Mms.isEmailAddress(number) == true) goto L6;
        String r0 = PhoneNumberUtils.formatNumber(number, this.mNumberE164, SecurityCenterApplication.getApplication().getCurrentCountryIso());     // Catch: Throwable -> L13
        this.mNumber = r0;     // Catch: Throwable -> L13
        this.mNumber = MessageUtils.formatPhoneNumber(r0);     // Catch: Throwable -> L13
    L8:
        if (this.mNumber != null) goto L10;
        this.mNumber = number;     // Catch: Throwable -> L13
    L10:
        notSynchronizedUpdateNameAndNumber();     // Catch: Throwable -> L13
        this.mNumberIsModified = true;     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L6:
        this.mNumber = number;     // Catch: Throwable -> L13
        goto L8
    }

    public boolean isNumberModified() {
        return this.mNumberIsModified;
    }

    public boolean getSendToVoicemail() {
        return this.mSendToVoicemail;
    }

    public void setIsNumberModified(boolean flag) {
        this.mNumberIsModified = flag;
    }

    public boolean isNameEqualsNumber() {
        if (TextUtils.equals(this.mName, this.mNumber) == false) goto L5;
        return true;
    L5:
        if (PhoneNumberUtils.compare(this.mName, this.mNumber, true) == true) goto L10;
        return false;
    L10:
        return true;
    }

    public synchronized void setInBlacklist(boolean inBlacklist) {
        monitor-enter(this);
        this.mInBlacklist = inBlacklist;     // Catch: Throwable -> L8
        if (inBlacklist == true) goto L6;
        this.mSpamName = null;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isInBlacklist() {
        monitor-enter(this);
        boolean r0 = this.mInBlacklist;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized String getName() {
        monitor-enter(this);
        String r0 = getName(false);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized String getName(boolean isSpam) {
        monitor-enter(this);
        if (isSpam == true) goto L7;
    L24:
        th = move-exception;
        throw th;
    L5:
        if (this.mInBlacklist == true) goto L7;
    L12:
        if (TextUtils.isEmpty(this.mName) == true) goto L14;
        String r1 = this.mName;     // Catch: Throwable -> L24
        monitor-exit(this);
        return r1;
    L14:
        if (TextUtils.isEmpty(this.mNotiName) == true) goto L18;
        String r2 = this.mNotiName;     // Catch: Throwable -> L24
        monitor-exit(this);
        return r2;
    L18:
        String r3 = this.mNumber;     // Catch: Throwable -> L24
        monitor-exit(this);
        return r3;
    L7:
        if (TextUtils.isEmpty(this.mSpamName) == true) goto L12;
        String r4 = this.mSpamName;     // Catch: Throwable -> L24
        monitor-exit(this);
        return r4;
    }

    public synchronized String getNotiName() {
        monitor-enter(this);
        String r0 = this.mNotiName;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setNotiName(String notiName) {
        monitor-enter(this);
        this.mNotiName = notiName;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized String getClassify() {
        monitor-enter(this);
        String r0 = this.mClassify;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized Bitmap getLogo() {
        monitor-enter(this);
        Bitmap r0 = this.mLogo;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized String getNameNotNumber(boolean isSpam) {
        monitor-enter(this);
        if (isSpam == true) goto L7;
    L24:
        th = move-exception;
        throw th;
    L5:
        if (this.mInBlacklist == true) goto L7;
    L12:
        if (TextUtils.isEmpty(this.mName) == true) goto L17;
        String r1 = this.mName;     // Catch: Throwable -> L24
        monitor-exit(this);
        return r1;
    L17:
        if (TextUtils.isEmpty(this.mNotiName) == true) goto L21;
        String r2 = this.mNotiName;     // Catch: Throwable -> L24
        monitor-exit(this);
        return r2;
    L21:
        monitor-exit(this);
        return null;
    L7:
        if (TextUtils.isEmpty(this.mSpamName) == true) goto L12;
        String r3 = this.mSpamName;     // Catch: Throwable -> L24
        monitor-exit(this);
        return r3;
    }

    public synchronized String getNameAndNumber() {
        monitor-enter(this);
        String r0 = this.mNameAndNumber;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private void notSynchronizedUpdateNameAndNumber() {
        this.mNameAndNumber = formatNameAndNumber(this.mName, this.mNumber);
    }

    public synchronized long getRecipientId() {
        monitor-enter(this);
        long r0 = this.mRecipientId;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setRecipientId(long id) {
        monitor-enter(this);
        this.mRecipientId = id;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized String getLabel() {
        monitor-enter(this);
        String r0 = this.mLabel;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized Uri getUri() {
        monitor-enter(this);
        Uri r0 = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, this.mPersonId);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int getPresenceResId() {
        monitor-enter(this);
        int r0 = this.mPresenceResId;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean existsInDatabase() {
        monitor-enter(this);
        if (this.mPersonId <= 0) goto L7;
        boolean r0 = true;
    L8:
        monitor-exit(this);
        return r0;
    L7:
        r0 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public static void addListener(UpdateListener l) {
        HashSet<UpdateListener> r0 = mListeners;
        monitor-enter(r0);
        r0.add(l);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void removeListener(UpdateListener l) {
        HashSet<UpdateListener> r0 = mListeners;
        monitor-enter(r0);
        r0.remove(l);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isEmail() {
        monitor-enter(this);
        boolean r0 = Telephony.Mms.isEmailAddress(this.mNumber);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public String getPresenceText() {
        return this.mPresenceText;
    }

    public int getContactMethodType() {
        return this.mContactMethodType;
    }

    public Uri getPeopleReferenceUri() {
        return this.mPeopleReferenceUri;
    }

    public long getContactMethodId() {
        return this.mContactMethodId;
    }

    public synchronized Uri getPhoneUri() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (existsInDatabase() == false) goto L8;
        Uri r0 = ContentUris.withAppendedId(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, this.mContactMethodId);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r0;
    L8:
        Uri.Builder r1 = new Uri.Builder();     // Catch: Throwable -> L11
        r1.scheme(TEL_SCHEME);     // Catch: Throwable -> L11
        r1.encodedOpaquePart(this.mNumber);     // Catch: Throwable -> L11
        Uri r2 = r1.build();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r2;
    }

    public synchronized Drawable getAvatar(Context context, Drawable defaultValue) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.mAvatar != null) goto L8;
        byte[] r0 = this.mAvatarData;     // Catch: Throwable -> L13
        if (r0 == null) goto L8;
        Bitmap r1 = BitmapFactory.decodeByteArray(r0, 0, r0.length);     // Catch: Throwable -> L13
        this.mAvatar = new BitmapDrawable(context.getResources(), r1);     // Catch: Throwable -> L13
    L8:
        BitmapDrawable r4 = this.mAvatar;     // Catch: Throwable -> L13
        if (r4 == null) goto L11;
        defaultValue = r4;
    L11:
        monitor-exit(this);
        return defaultValue;
    }

    public synchronized byte[] getAvatarData() {
        monitor-enter(this);
        byte[] r0 = this.mAvatarData;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public static void init(final Context context) {
        if (sContactCache != null) goto L5;
        sContactCache = new ContactsCache(context, null);
    L5:
        ContactsCache.access$200(sContactCache);
        SpamRecipientIdCache.init(context);
    }

    public static void dump() {
        sContactCache.dump();
    }

    private static void log(String msg) {
        OLog.d(TAG, msg);
    }
}
