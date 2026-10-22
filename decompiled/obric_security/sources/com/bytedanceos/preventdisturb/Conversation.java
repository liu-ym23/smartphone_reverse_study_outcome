package com.bytedanceos.preventdisturb;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.room.FtsOptions;
import bytedanceos.util.LogTag;
import com.bytedanceos.utils.Constants;
import com.obric.olog.OLog;
import com.obric.security.R;
import com.obric.securitycenter.nodisturb.ProviderConstants;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class Conversation {
    public static final String[] ALL_SPAM_THREADS_PROJECTION = null;
    public static final int DATE = 1;
    private static final boolean DEBUG = false;
    public static final String DEFAULT_SORT_ORDER = " weight DESC, date_by_user DESC, date DESC";
    private static final boolean DELETEDEBUG = false;
    public static final int ERROR = 7;
    public static final int HAS_ATTACHMENT = 8;
    public static final int ID = 0;
    public static final int MESSAGE_COUNT = 2;
    public static final int READ = 6;
    public static final int RECIPIENT_IDS = 3;
    private static final String[] SEEN_PROJECTION = null;
    public static final int SNIPPET = 4;
    public static final int SNIPPET_CS = 5;
    private static final String TAG = "Mms/conv";
    public static final int TD_SMS_COUNT = 9;
    public static final String TD_SMS_COUNT_COLUMN = "td_sms_count";
    public static final String[] UNREAD_PROJECTION = null;
    private static final String UNREAD_SELECTION = "(read=0 OR seen=0)";
    public static final Uri sAllSpamThreadsUri = null;
    private static boolean sDeletingThreads;
    private static Object sDeletingThreadsLock;
    private static boolean sLoadingThreads;
    private static ContentValues sReadContentValues;
    private Contact mContact;
    private final Context mContext;
    private long mDate;
    private long mDateByUser;
    private boolean mFavorite;
    private String mForwardRecipientNumber;
    private boolean mHasAttachment;
    private boolean mHasError;
    private boolean mHasMmsForward;
    private boolean mHasUnreadMessages;
    private boolean mIsSpamCon;
    private boolean mMarkAsReadBlocked;
    private boolean mMarkAsReadWaiting;
    private int mMessageCount;
    private String mRecipientIds;
    public long mSendTimeForDelay;
    private String mSnippet;
    private long mThreadId;
    private boolean mUnreadByUser;

    private static class Cache {
        private static volatile Cache sInstance;
        private final HashSet<Conversation> mCache;

        static {
            sInstance = new Cache();
        }

        private Cache() {
            this.mCache = new HashSet(10);
        }

        static Conversation get(long threadId, boolean isSpam) {
            Cache r0 = sInstance;
            monitor-enter(r0);
            Iterator<Conversation> r1 = sInstance.mCache.iterator();     // Catch: Throwable -> L16
        L6:
            if (r1.hasNext() == false) goto L13;
            Conversation r2 = r1.next();     // Catch: Throwable -> L16
            if (r2.getThreadId() != threadId) goto L6;
            if (r2.isSpamCon() != isSpam) goto L6;
            monitor-exit(r0);     // Catch: Throwable -> L16
            return r2;
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L16
            return null;
        L16:
            th = move-exception;
            throw th;
        }

        static void put(Conversation c) {
            Cache r1 = sInstance;
            monitor-enter(r1);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (sInstance.mCache.contains(c) == true) goto L10;
            sInstance.mCache.add(c);     // Catch: Throwable -> L11
            monitor-exit(r1);     // Catch: Throwable -> L11
            return;
        L10:
            throw new IllegalStateException("cache already contains " + c + " threadId: " + Conversation.access$200(c));     // Catch: Throwable -> L11
        }

        static boolean replace(Conversation c) {
            Cache r0 = sInstance;
            monitor-enter(r0);
        L13:
            th = move-exception;
            throw th;
        L5:
            if (sInstance.mCache.contains(c) == true) goto L9;
            monitor-exit(r0);     // Catch: Throwable -> L13
            return false;
        L9:
            sInstance.mCache.remove(c);     // Catch: Throwable -> L13
            sInstance.mCache.add(c);     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            return true;
        }

        static void remove(long threadId, boolean isSpamConv) {
            Cache r0 = sInstance;
            monitor-enter(r0);
            Iterator<Conversation> r1 = sInstance.mCache.iterator();     // Catch: Throwable -> L16
        L6:
            if (r1.hasNext() == false) goto L14;
            Conversation r2 = r1.next();     // Catch: Throwable -> L16
            if (r2.getThreadId() != threadId) goto L6;
            if (r2.isSpamCon() != isSpamConv) goto L6;
            sInstance.mCache.remove(r2);     // Catch: Throwable -> L16
            monitor-exit(r0);     // Catch: Throwable -> L16
            return;
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L16
            return;
        L16:
            th = move-exception;
            throw th;
        }

        static void dumpCache() {
            Cache r0 = sInstance;
            monitor-enter(r0);
            OLog.d(Conversation.TAG, "Conversation dumpCache: ");     // Catch: Throwable -> L10
            Iterator<Conversation> r1 = sInstance.mCache.iterator();     // Catch: Throwable -> L10
        L6:
            if (r1.hasNext() == false) goto L8;
            Conversation r2 = r1.next();     // Catch: Throwable -> L10
            OLog.d(Conversation.TAG, "   conv: " + r2.toString() + " hash: " + r2.hashCode());     // Catch: Throwable -> L10
            goto L6
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        static void keepOnly(Set<Long> convKeys) {
            Cache r0 = sInstance;
            monitor-enter(r0);
            Iterator<Conversation> r1 = sInstance.mCache.iterator();     // Catch: Throwable -> L16
        L6:
            if (r1.hasNext() == false) goto L14;
            Conversation r2 = r1.next();     // Catch: Throwable -> L16
            long r3 = r2.getThreadId();     // Catch: Throwable -> L16
            if (r2.isSpamCon() == false) goto L10;
            int r4 = -1;
        L12:
            if (convKeys.contains(Long.valueOf(r3 * ((long) r4))) == true) goto L6;
            r1.remove();     // Catch: Throwable -> L16
            goto L6
        L10:
            r4 = 1;
            goto L12
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L16
            return;
        L16:
            th = move-exception;
            throw th;
        }
    }

    public static class ConversationQueryHandler extends AsyncQueryHandler {
        private int mDeleteToken;

        public ConversationQueryHandler(ContentResolver cr) {
            super(cr);
        }

        public void setDeleteToken(int token) {
            this.mDeleteToken = token;
        }

        @Override // android.content.AsyncQueryHandler
        protected void onDeleteComplete(int token, Object cookie, int result) {
            if (token != this.mDeleteToken) goto L13;
            Object r0 = Conversation.access$000();
            monitor-enter(r0);
            Conversation.access$102(false);     // Catch: Throwable -> L10
            Conversation.access$000().notifyAll();     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    static /* synthetic */ Object access$000() {
        return sDeletingThreadsLock;
    }

    static /* synthetic */ boolean access$102(boolean r0) {
        sDeletingThreads = r0;
        return r0;
    }

    static /* synthetic */ long access$200(Conversation r2) {
        return r2.mThreadId;
    }

    static {
        sAllSpamThreadsUri = Uri.parse("content://bytedance_spam/conversations").buildUpon().appendQueryParameter(FtsOptions.TOKENIZER_SIMPLE, Constants.IS_SET).build();
        ALL_SPAM_THREADS_PROJECTION = new String[]{"_id", ProviderConstants.Sms.DATE, "message_count", "recipient_ids", "snippet", "snippet_cs", ProviderConstants.Sms.READ, "error", "has_attachment"};
        UNREAD_PROJECTION = new String[]{"_id", ProviderConstants.Sms.READ};
        SEEN_PROJECTION = new String[]{ProviderConstants.Sms.SEEN};
        sDeletingThreadsLock = new Object();
    }

    private Conversation(Context context) {
        this.mHasMmsForward = false;
        this.mContext = context.getApplicationContext();
        this.mThreadId = 0;
        this.mIsSpamCon = false;
    }

    private Conversation(Context context, long threadId, boolean allowQuery, boolean isSpam) {
        this.mHasMmsForward = false;
        this.mContext = context.getApplicationContext();
        this.mIsSpamCon = isSpam;
        if (loadFromThreadId(threadId, allowQuery, isSpam) == true) goto L6;
        this.mThreadId = 0;
        return;
    }

    private Conversation(Context context, Cursor cursor, boolean allowQuery, boolean isSpam) {
        this.mHasMmsForward = false;
        this.mContext = context.getApplicationContext();
        this.mIsSpamCon = isSpam;
        fillFromCursor(context, this, cursor, allowQuery, isSpam);
    }

    public static Conversation createNew(Context context) {
        return new Conversation(context);
    }

    public static Conversation get(Context context, long threadId, boolean allowQuery) {
        return get(context, threadId, allowQuery, false);
    }

    public static Conversation get(Context context, long threadId, boolean allowQuery, boolean isSpam) {
        Conversation r0 = Cache.get(threadId, isSpam);
        if (r0 == null) goto L5;
        return r0;
    L5:
        Conversation r1 = new Conversation(context, threadId, allowQuery, isSpam);
        Cache.put(r1);     // Catch: IllegalStateException -> L8
    L7:
        return r1;
    }

    public static Conversation get(Context context, Uri uri, boolean allowQuery, boolean isSpam) {
        if (uri != null) goto L6;
        return createNew(context);
    L6:
        if (uri.getPathSegments().size() < 2) goto L11;
        return get(context, Long.parseLong(uri.getPathSegments().get(1)), allowQuery, isSpam);
    L9:
        OLog.d(TAG, "Invalid URI: " + uri);
    L11:
        return createNew(context);
    }

    public static Conversation from(Context context, Cursor cursor, boolean isSpam) {
        long r1 = cursor.getLong(0);
        if (r1 <= 0) goto L8;
        Conversation r2 = Cache.get(r1, isSpam);
        if (r2 == null) goto L8;
        fillFromCursor(context, r2, cursor, false, isSpam);
        return r2;
    L8:
        Conversation r3 = new Conversation(context, cursor, false, isSpam);
        Cache.put(r3);     // Catch: IllegalStateException -> L11
    L14:
        return r3;
    L11:
        OLog.d(TAG, "Tried to add duplicate Conversation to Cache (from cursor): " + r3);
        if (Cache.replace(r3) == true) goto L14;
        OLog.d(TAG, "Converations.from cache.replace failed on " + r3);
        goto L14
    }

    public synchronized long getThreadId() {
        monitor-enter(this);
        long r0 = this.mThreadId;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized Contact getContact() {
        monitor-enter(this);
        Contact r0 = this.mContact;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int getMessageCount() {
        monitor-enter(this);
        int r0 = this.mMessageCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized String getSnippet() {
        monitor-enter(this);
        String r0 = this.mSnippet;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private void setHasUnreadMessages(boolean flag) {
        monitor-enter(this);
        this.mHasUnreadMessages = flag;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean hasError() {
        monitor-enter(this);
        boolean r0 = this.mHasError;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized long getDate() {
        monitor-enter(this);
        long r0 = this.mDate;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public static void startQuery(AsyncQueryHandler handler, int token, String selection, boolean isSpam) {
        handler.cancelOperation(token);
        Uri r3 = sAllSpamThreadsUri;
        String[] r4 = ALL_SPAM_THREADS_PROJECTION;
        LogTag.d(TAG, "conversation startQuery");
        handler.startQuery(token, null, r3, r4, selection, null, "date DESC");
    }

    public static void startDeleteOneSpamThread(ConversationQueryHandler handler, int token, Long threadId) {
        Object r1 = sDeletingThreadsLock;
        monitor-enter(r1);
        sDeletingThreads = true;     // Catch: Throwable -> L11
        if (LogTag.VERBOSE == false) goto L8;
        OLog.v(TAG, "delete spam threadId: " + threadId);     // Catch: Throwable -> L11
    L8:
        Uri r7 = ContentUris.withAppendedId(Uri.parse("content://bytedance_spam/conversations"), threadId.longValue());     // Catch: Throwable -> L11
        handler.setDeleteToken(token);     // Catch: Throwable -> L11
        handler.startDelete(token, threadId, r7, null, null);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static void startDeleteAllSpam(ConversationQueryHandler handler, int token) {
        Object r0 = sDeletingThreadsLock;
        monitor-enter(r0);
        sDeletingThreads = true;     // Catch: Throwable -> L8
        handler.setDeleteToken(token);     // Catch: Throwable -> L8
        handler.startDelete(token, null, Uri.parse("content://bytedance_spam/conversations"), null, null);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static void fillFromCursor(Context context, Conversation conv, Cursor c, boolean allowQuery, boolean isSpam) {
        monitor-enter(conv);
        boolean r0 = false;
        conv.mThreadId = c.getLong(0);     // Catch: Throwable -> L28
        conv.mDate = c.getLong(1);     // Catch: Throwable -> L28
        conv.mMessageCount = c.getInt(2);     // Catch: Throwable -> L28
        String r2 = MessageUtils.cleanseMmsSubject(context, MessageUtils.extractEncStrFromCursor(c, 4, 5));     // Catch: Throwable -> L28
        if (TextUtils.isEmpty(r2) == false) goto L7;
        r2 = context.getString(R.string.no_subject_view);     // Catch: Throwable -> L28
    L7:
        conv.mSnippet = r2;     // Catch: Throwable -> L28
        if (c.getInt(6) != 0) goto L10;
        boolean r4 = true;
    L11:
        conv.setHasUnreadMessages(r4);     // Catch: Throwable -> L28
        if (c.getInt(7) == 0) goto L14;
        boolean r5 = true;
    L15:
        conv.mHasError = r5;     // Catch: Throwable -> L28
        if (c.getInt(8) == 0) goto L18;
        r0 = true;
    L18:
        conv.mHasAttachment = r0;     // Catch: Throwable -> L28
        conv.mIsSpamCon = isSpam;     // Catch: Throwable -> L28
        conv.mRecipientIds = c.getString(3);     // Catch: Throwable -> L28
        monitor-exit(conv);     // Catch: Throwable -> L28
        String r6 = c.getString(3);
        OLog.d(TAG, "recipientIds " + r6);
        Contact r7 = getContact(r6, allowQuery);
        monitor-enter(conv);
        conv.mContact = r7;     // Catch: Throwable -> L25
        monitor-exit(conv);     // Catch: Throwable -> L25
        return;
    L25:
        th = move-exception;
        throw th;
    L14:
        r5 = false;
        goto L15
    L10:
        r4 = false;
    L28:
        th = move-exception;
        throw th;
    }

    private static Contact getContact(String spaceSepIds, boolean canBlock) {
        Iterator<SpamRecipientIdCache.Entry> r2 = SpamRecipientIdCache.getAddresses(spaceSepIds).iterator();
    L4:
        if (r2.hasNext() == false) goto L13;
        SpamRecipientIdCache.Entry r0 = r2.next();
        if (r0 == null) goto L4;
        if (TextUtils.isEmpty(r0.number) == true) goto L4;
        Contact r3 = Contact.get(r0.number, canBlock);
        String r4 = SpamRecipientIdCache.getNotiName(r0.id);
        if (TextUtils.isEmpty(r4) == true) goto L12;
        r3.setNotiName(r4);
    L12:
        return r3;
    L13:
        return null;
    }

    public static void init(final Context context, final boolean isSpam) {
        Thread r3 = new Thread(new AnonymousClass1(), "Conversation.init_isSpam_" + isSpam);
        r3.setPriority(1);
        r3.start();
    }

    private boolean loadFromThreadId(long threadId, boolean allowQuery, boolean isSpam) {
        Cursor r2 = this.mContext.getContentResolver().query(sAllSpamThreadsUri, ALL_SPAM_THREADS_PROJECTION, "_id=" + Long.toString(threadId), null, null);
        if (r2 != null) goto L19;
        return false;
    L19:
    L16:
        th = move-exception;
        r2.close();
        throw th;
    L7:
        if (r2.moveToFirst() == false) goto L13;
        fillFromCursor(this.mContext, this, r2, allowQuery, isSpam);     // Catch: Throwable -> L16
        if (threadId == this.mThreadId) goto L11;
        LogTag.d(TAG, "loadFromThreadId: fillFromCursor returned differnt thread_id! threadId=" + threadId + ", mThreadId=" + this.mThreadId);     // Catch: Throwable -> L16
    L11:
        r2.close();
        return true;
    L13:
        LogTag.d(TAG, "loadFromThreadId: Can't find thread ID " + threadId);     // Catch: Throwable -> L16
        r2.close();
        return false;
    }

    public static void clearDeleteCache(final Collection<Long> threadIds, final boolean isSpam) {
        if (threadIds != null) goto L4;
        return;
    L4:
        if (threadIds.size() <= 0) goto L8;
        new Thread(new AnonymousClass2(threadIds, isSpam), "Conversation.clearDeleteCache").start();
        return;
    }

    public boolean isSpamCon() {
        return this.mIsSpamCon;
    }

    public boolean getHasMmsForward() {
        return this.mHasMmsForward;
    }

    public void setHasMmsForward(boolean value) {
        this.mHasMmsForward = value;
    }

    public String getForwardRecipientNumber() {
        return this.mForwardRecipientNumber;
    }

    public void setForwardRecipientNumber(String forwardRecipientNumber) {
        this.mForwardRecipientNumber = forwardRecipientNumber;
    }

    public synchronized String getRecipientIds() {
        monitor-enter(this);
        String r0 = this.mRecipientIds;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isUnread() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.mHasUnreadMessages == true) goto L9;
        if (this.mUnreadByUser == true) goto L9;
        boolean r0 = false;
    L10:
        monitor-exit(this);
        return r0;
    L9:
        r0 = true;
        goto L10
    }

    public synchronized boolean isUnreadByUser() {
        monitor-enter(this);
        boolean r0 = this.mUnreadByUser;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized void setUnreadByUser(boolean unread) {
        monitor-enter(this);
        this.mUnreadByUser = unread;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isFavorite() {
        monitor-enter(this);
        boolean r0 = this.mFavorite;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }
}
