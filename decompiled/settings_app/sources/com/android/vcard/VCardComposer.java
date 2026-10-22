package com.android.vcard;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Entity;
import android.content.EntityIterator;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import com.android.settings.applications.PreferredSettingsUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class VCardComposer {
    private static final boolean DEBUG = false;
    public static final String FAILURE_REASON_FAILED_TO_GET_DATABASE_INFO = "Failed to get database information";
    public static final String FAILURE_REASON_NOT_INITIALIZED = "The vCard composer object is not correctly initialized";
    public static final String FAILURE_REASON_NO_ENTRY = "There's no exportable in the database";
    public static final String FAILURE_REASON_UNSUPPORTED_URI = "The Uri vCard composer received is not supported by the composer.";
    private static final String LOG_TAG = "VCardComposer";
    public static final String NO_ERROR = "No error";
    private static final String SHIFT_JIS = "SHIFT_JIS";
    private static final String UTF_8 = "UTF-8";
    private static final String[] sContactsProjection = null;
    private static final Map<Integer, String> sImMap = null;
    private final String mCharset;
    private final ContentResolver mContentResolver;
    private Uri mContentUriForRawContactsEntity;
    private Cursor mCursor;
    private boolean mCursorSuppliedFromOutside;
    private Entity mEntity;
    private EntityIterator mEntityIterator;
    private String mErrorReason;
    private boolean mFirstVCardEmittedInDoCoMoCase;
    private int mIdColumn;
    private boolean mInitDone;
    private final boolean mIsDoCoMo;
    private VCardPhoneNumberTranslationCallback mPhoneTranslationCallback;
    private RawContactEntitlesInfoCallback mRawContactEntitlesInfoCallback;
    private boolean mTerminateCalled;
    private final int mVCardType;

    public static class RawContactEntitlesInfo {
        public final long contactId;
        public final Uri rawContactEntitlesUri;

        public RawContactEntitlesInfo(Uri r1, long r2) {
            this.rawContactEntitlesUri = r1;
            this.contactId = r2;
        }
    }

    public interface RawContactEntitlesInfoCallback {
        RawContactEntitlesInfo getRawContactEntitlesInfo(long r1);
    }

    static {
        HashMap r0 = new HashMap();
        sImMap = r0;
        r0.put(0, VCardConstants.PROPERTY_X_AIM);
        r0.put(1, VCardConstants.PROPERTY_X_MSN);
        r0.put(2, VCardConstants.PROPERTY_X_YAHOO);
        r0.put(6, VCardConstants.PROPERTY_X_ICQ);
        r0.put(7, VCardConstants.PROPERTY_X_JABBER);
        r0.put(3, VCardConstants.PROPERTY_X_SKYPE_USERNAME);
        sContactsProjection = new String[]{"_id"};
    }

    public VCardComposer(Context r4) {
        this(r4, VCardConfig.VCARD_TYPE_DEFAULT, null, true);
    }

    public VCardComposer(Context r3, int r4) {
        this(r3, r4, null, true);
    }

    public VCardComposer(Context r2, int r3, String r4) {
        this(r2, r3, r4, true);
    }

    public VCardComposer(Context r2, int r3, boolean r4) {
        this(r2, r3, null, r4);
    }

    public VCardComposer(Context r7, int r8, String r9, boolean r10) {
        this(r7, r7.getContentResolver(), r8, r9, r10);
    }

    public VCardComposer(Context r2, ContentResolver r3, int r4, String r5, boolean r6) {
        this.mErrorReason = NO_ERROR;
        boolean r7 = true;
        this.mTerminateCalled = true;
        this.mVCardType = r4;
        this.mContentResolver = r3;
        boolean r8 = VCardConfig.isDoCoMo(r4);
        this.mIsDoCoMo = r8;
        if (TextUtils.isEmpty(r5) == false) goto L6;
        r5 = "UTF-8";
    L6:
        if (VCardConfig.isVersion30(r4) == true) goto L8;
    L11:
        if (r8 == true) goto L19;
        if (r7 == true) goto L19;
        if (TextUtils.isEmpty(r5) == false) goto L17;
        this.mCharset = "UTF-8";
    L25:
        Log.d(LOG_TAG, "Use the charset \"" + this.mCharset + "\"");
        return;
    L17:
        this.mCharset = r5;
    L19:
        if (SHIFT_JIS.equalsIgnoreCase(r5) == false) goto L22;
        this.mCharset = r5;
        goto L25
    L22:
        if (TextUtils.isEmpty(r5) == false) goto L24;
        this.mCharset = SHIFT_JIS;
        goto L25
    L24:
        this.mCharset = r5;
        goto L25
    L8:
        if ("UTF-8".equalsIgnoreCase(r5) == false) goto L11;
        r7 = false;
        goto L11
    }

    public boolean init() {
        return init(null, null);
    }

    @Deprecated
    public boolean initWithRawContactsEntityUri(Uri r8) {
        return init(ContactsContract.Contacts.CONTENT_URI, sContactsProjection, null, null, null, r8);
    }

    public boolean init(String r8, String[] r9) {
        return init(ContactsContract.Contacts.CONTENT_URI, sContactsProjection, r8, r9, null, null);
    }

    public boolean init(Uri r8, String r9, String[] r10, String r11) {
        return init(r8, sContactsProjection, r9, r10, r11, null);
    }

    public boolean init(Uri r8, String r9, String[] r10, String r11, Uri r12) {
        return init(r8, sContactsProjection, r9, r10, r11, r12);
    }

    public boolean init(Uri r3, String[] r4, String r5, String[] r6, String r7, Uri r8) {
        if ("com.android.contacts".equals(r3.getAuthority()) == true) goto L7;
        this.mErrorReason = FAILURE_REASON_UNSUPPORTED_URI;
        return false;
    L7:
        if (initInterFirstPart(r8) == true) goto L10;
        return false;
    L10:
        if (initInterCursorCreationPart(r3, r4, r5, r6, r7) == true) goto L13;
        return false;
    L13:
        if (initInterMainPart() == true) goto L15;
        return false;
    L15:
        initEntityIterator();
        return initInterLastPart();
    }

    public boolean init(Cursor r2) {
        return initWithCallback(r2, null);
    }

    public boolean initWithCallback(Cursor r3, RawContactEntitlesInfoCallback r4) {
        if (initInterFirstPart(null) == true) goto L5;
        return false;
    L5:
        this.mCursorSuppliedFromOutside = true;
        this.mCursor = r3;
        this.mRawContactEntitlesInfoCallback = r4;
        if (initInterMainPart() == true) goto L9;
        return false;
    L9:
        return initInterLastPart();
    }

    private boolean initInterFirstPart(Uri r1) {
        if (r1 != null) goto L5;
        r1 = ContactsContract.RawContactsEntity.CONTENT_URI;
    L5:
        this.mContentUriForRawContactsEntity = r1;
        if (this.mInitDone == false) goto L9;
        Log.e(LOG_TAG, "init() is already called");
        return false;
    L9:
        return true;
    }

    private boolean initInterCursorCreationPart(Uri r8, String[] r9, String r10, String[] r11, String r12) {
        this.mCursorSuppliedFromOutside = false;
        Cursor r13 = this.mContentResolver.query(r8, r9, r10, r11, r12);
        this.mCursor = r13;
        if (r13 != null) goto L6;
        Log.e(LOG_TAG, String.format("Cursor became null unexpectedly", new Object[0]));
        this.mErrorReason = FAILURE_REASON_FAILED_TO_GET_DATABASE_INFO;
        return false;
    L6:
        return true;
    }

    private boolean initInterMainPart() {
        if (this.mCursor.getCount() != 0) goto L5;
    L14:
        closeCursorIfAppropriate();
        return false;
    L5:
        if (this.mCursor.moveToFirst() == false) goto L14;
        int r0 = this.mCursor.getColumnIndex("contact_id");
        this.mIdColumn = r0;
        if (r0 >= 0) goto L11;
        this.mIdColumn = this.mCursor.getColumnIndex("_id");
    L11:
        if (this.mIdColumn < 0) goto L16;
        return true;
    L16:
        return false;
    }

    private void initEntityIterator() {
        StringBuilder r0 = new StringBuilder("contact_id IN (");
    L3:
        r0.append(this.mCursor.getString(this.mIdColumn));
        if (this.mCursor.isLast() == true) goto L7;
        r0.append(",");
    L7:
        if (this.mCursor.moveToNext() == true) goto L3;
        r0.append(")");
        this.mEntityIterator = ContactsContract.RawContacts.newEntityIterator(this.mContentResolver.query(this.mContentUriForRawContactsEntity, null, r0.toString(), null, "contact_id"));
        this.mCursor.moveToFirst();
    }

    private boolean initInterLastPart() {
        this.mInitDone = true;
        this.mTerminateCalled = false;
        return true;
    }

    public String createOneEntry() {
        return createOneEntry(null);
    }

    public String createOneEntry(Method r3) {
        if (this.mIsDoCoMo == false) goto L8;
        if (this.mFirstVCardEmittedInDoCoMoCase == true) goto L8;
        this.mFirstVCardEmittedInDoCoMoCase = true;
    L8:
        if (this.mEntityIterator == null) goto L12;
        if (r3 != null) goto L12;
        String r4 = createOneEntryInternalByIterator();
    L14:
        if (this.mCursor.moveToNext() == true) goto L16;
        Log.e(LOG_TAG, "Cursor#moveToNext() returned false");
    L16:
        return r4;
    L12:
        r4 = createOneEntryInternal(this.mCursor.getLong(this.mIdColumn), r3);
        goto L14
    }

    private String createOneEntryInternalByIterator() {
        if (this.mEntityIterator.hasNext() == false) goto L5;
    L8:
        HashMap r0 = new HashMap();
        Entity r2 = this.mEntity;
        if (r2 == null) goto L20;
        int r3 = r2.getEntityValues().getAsInteger("contact_id").intValue();
        Iterator<Entity.NamedContentValues> r6 = this.mEntity.getSubValues().iterator();
    L12:
        if (r6.hasNext() == false) goto L19;
        ContentValues r7 = r6.next().values;
        String r8 = r7.getAsString(PreferredSettingsUtils.INTENT_EXTRA_MIMETYPE);
        if (r8 == null) goto L12;
        List<ContentValues> r9 = r0.get(r8);
        if (r9 != null) goto L18;
        r9 = new ArrayList();
        r0.put(r8, r9);
    L18:
        r9.add(r7);
        goto L12
    L19:
        this.mEntity = null;
    L22:
        if (this.mEntityIterator.hasNext() == false) goto L39;
        Entity r1 = (Entity) this.mEntityIterator.next();
        int r10 = r1.getEntityValues().getAsInteger("contact_id").intValue();
        if (r3 == (-1)) goto L28;
        if (r10 == r3) goto L28;
        this.mEntity = r1;
    L28:
        Iterator<Entity.NamedContentValues> r4 = r1.getSubValues().iterator();
    L30:
        if (r4.hasNext() == false) goto L37;
        ContentValues r5 = r4.next().values;
        String r11 = r5.getAsString(PreferredSettingsUtils.INTENT_EXTRA_MIMETYPE);
        if (r11 == null) goto L30;
        List<ContentValues> r12 = r0.get(r11);
        if (r12 != null) goto L36;
        r12 = new ArrayList();
        r0.put(r11, r12);
    L36:
        r12.add(r5);
        goto L30
    L37:
        r3 = r10;
    L39:
        return buildVCard(r0);
    L20:
        r3 = -1;
        goto L22
    L5:
        if (this.mEntity != null) goto L8;
        Log.e(LOG_TAG, "EntityIterator#hasNext() returned false");
        return null;
    }

    private String createOneEntryInternal(long r13, Method r15) {
        HashMap r3 = new HashMap();
        EntityIterator r4 = null;
        Uri r5 = this.mContentUriForRawContactsEntity;     // Catch: Throwable -> L48
        RawContactEntitlesInfoCallback r6 = this.mRawContactEntitlesInfoCallback;     // Catch: Throwable -> L48
        if (r6 == null) goto L6;
        RawContactEntitlesInfo r14 = r6.getRawContactEntitlesInfo(r13);     // Catch: Throwable -> L48
        r5 = r14.rawContactEntitlesUri;     // Catch: Throwable -> L48
        r13 = r14.contactId;     // Catch: Throwable -> L48
    L6:
        Uri r7 = r5;
        String[] r9 = {String.valueOf(r13)};     // Catch: Throwable -> L48
        if (r15 != null) goto L53;
        r4 = ContactsContract.RawContacts.newEntityIterator(this.mContentResolver.query(r7, null, "contact_id=?", r9, null));     // Catch: Throwable -> L48
    L21:
        if (r4 != null) goto L27;
        Log.e(LOG_TAG, "EntityIterator is null");     // Catch: Throwable -> L48
        if (r4 == null) goto L25;
        r4.close();
    L25:
        return "";
    L27:
        if (r4.hasNext() == true) goto L33;
        Log.w(LOG_TAG, "Data does not exist. contactId: " + r13);     // Catch: Throwable -> L48
        if (r4 == null) goto L31;
        r4.close();
    L31:
        return "";
    L33:
        if (r4.hasNext() == false) goto L44;
        Iterator<Entity.NamedContentValues> r16 = ((Entity) r4.next()).getSubValues().iterator();     // Catch: Throwable -> L48
    L36:
        if (r16.hasNext() == false) goto L33;
        ContentValues r17 = r16.next().values;     // Catch: Throwable -> L48
        String r18 = r17.getAsString(PreferredSettingsUtils.INTENT_EXTRA_MIMETYPE);     // Catch: Throwable -> L48
        if (r18 == null) goto L36;
        List<ContentValues> r0 = r3.get(r18);     // Catch: Throwable -> L48
        if (r0 != null) goto L42;
        r0 = new ArrayList();     // Catch: Throwable -> L48
        r3.put(r18, r0);     // Catch: Throwable -> L48
    L42:
        r0.add(r17);     // Catch: Throwable -> L48
        goto L36
    L44:
        if (r4 == null) goto L47;
        r4.close();
    L47:
        return buildVCard(r3);
    L53:
        r4 = (EntityIterator) r15.invoke(null, new Object[]{this.mContentResolver, r7, "contact_id=?", r9, null});     // Catch: InvocationTargetException -> L12 IllegalAccessException -> L15 IllegalArgumentException -> L17 Throwable -> L48
        goto L21
    L15:
        e = move-exception;
        Log.e(LOG_TAG, "IllegalAccessException has been thrown: " + e.getMessage());     // Catch: Throwable -> L48
    L12:
        e = move-exception;
        Log.e(LOG_TAG, "InvocationTargetException has been thrown: ", e);     // Catch: Throwable -> L48
        throw new RuntimeException("InvocationTargetException has been thrown");     // Catch: Throwable -> L48
    L17:
        e = move-exception;
        Log.e(LOG_TAG, "IllegalArgumentException has been thrown: " + e.getMessage());     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        if (0 == 0) goto L51;
        r4.close();
    L51:
        throw th;
    }

    public void setPhoneNumberTranslationCallback(VCardPhoneNumberTranslationCallback r1) {
        this.mPhoneTranslationCallback = r1;
    }

    public String buildVCard(Map<String, List<ContentValues>> r5) {
        if (r5 != null) goto L5;
        Log.e(LOG_TAG, "The given map is null. Ignore and return empty String");
        return "";
    L5:
        VCardBuilder r0 = new VCardBuilder(this.mVCardType, this.mCharset);
        r0.appendNameProperties(r5.get("vnd.android.cursor.item/name")).appendNickNames(r5.get("vnd.android.cursor.item/nickname")).appendPhones(r5.get("vnd.android.cursor.item/phone_v2"), this.mPhoneTranslationCallback).appendEmails(r5.get("vnd.android.cursor.item/email_v2")).appendPostals(r5.get("vnd.android.cursor.item/postal-address_v2")).appendOrganizations(r5.get("vnd.android.cursor.item/organization")).appendWebsites(r5.get("vnd.android.cursor.item/website"));
        if ((this.mVCardType & 8388608) != 0) goto L8;
        r0.appendPhotos(r5.get("vnd.android.cursor.item/photo"));
    L8:
        r0.appendNotes(r5.get("vnd.android.cursor.item/note")).appendEvents(r5.get("vnd.android.cursor.item/contact_event")).appendIms(r5.get("vnd.android.cursor.item/im")).appendSipAddresses(r5.get("vnd.android.cursor.item/sip_address")).appendRelation(r5.get("vnd.android.cursor.item/relation"));
        return r0.toString();
    }

    public void terminate() {
        closeCursorIfAppropriate();
        this.mTerminateCalled = true;
    }

    private void closeCursorIfAppropriate() {
        if (this.mCursorSuppliedFromOutside == true) goto L11;
        Cursor r0 = this.mCursor;
        if (r0 == null) goto L11;
        r0.close();     // Catch: SQLiteException -> L8
    L10:
        this.mCursor = null;
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "SQLiteException on Cursor#close(): " + e.getMessage());
    L11:
        EntityIterator r1 = this.mEntityIterator;
        if (r1 == null) goto L23;
        r1.close();     // Catch: SQLiteException -> L15
    L17:
        this.mEntityIterator = null;
        return;
    L15:
        e = move-exception;
        Log.e(LOG_TAG, "SQLiteException on EntityIterator#close(): " + e.getMessage());
        goto L17
    }

    protected void finalize() throws Throwable {
    L7:
        th = move-exception;
        super.finalize();
        throw th;
    L3:
        if (this.mTerminateCalled == true) goto L5;
        Log.e(LOG_TAG, "finalized() is called before terminate() being called");     // Catch: Throwable -> L7
    L5:
        super.finalize();
    }

    public int getCount() {
        Cursor r1 = this.mCursor;
        if (r1 != null) goto L7;
        Log.w(LOG_TAG, "This object is not ready yet.");
        return 0;
    L7:
        return r1.getCount();
    }

    public boolean isAfterLast() {
        Cursor r0 = this.mCursor;
        if (r0 != null) goto L6;
        Log.w(LOG_TAG, "This object is not ready yet.");
        return false;
    L6:
        EntityIterator r2 = this.mEntityIterator;
        if (r2 == null) goto L17;
        if (r2.hasNext() == true) goto L13;
        if (this.mEntity != null) goto L13;
    L14:
        return true;
    L13:
        if (this.mCursor.isAfterLast() == true) goto L14;
        return false;
    L17:
        return r0.isAfterLast();
    }

    public String getErrorReason() {
        return this.mErrorReason;
    }
}
