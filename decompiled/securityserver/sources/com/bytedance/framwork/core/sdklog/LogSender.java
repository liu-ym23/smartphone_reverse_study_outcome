package com.bytedance.framwork.core.sdklog;

import android.content.Context;
import android.database.sqlite.SQLiteFullException;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
final class LogSender extends Thread {
    private static final long CLEAN_LOG_INTERVAL = 600000;
    private static final long DEFAULT_SCAN_LOG_INTERVAL = 120000;
    static final String KEY_MAGIC_TAG = "magic_tag";
    static final String KEY_MESSAGE = "message";
    static final String MAGIC_TAG = "log_queue";
    private static final long MAX_EXPIRE_TIME = 864000000;
    static final String STATUS_OK = "success";
    private static final String TAG = "LogSender";
    private int mChannelPosition;
    private final Context mContext;
    private final LogQueueManager mDbHelper;
    private long mLastCleanTime;
    private final Object mLock;
    private LogQueue mLogQueue;
    private long mMinLog;
    private final LinkedList<LogItem> mPendingQueue;
    private long mScanLogInterval;
    private final AtomicBoolean mStopFlag;

    public LogSender(Context r3, LogQueue r4, LinkedList<LogItem> r5, AtomicBoolean r6) {
        super(TAG);
        this.mLock = new Object();
        this.mMinLog = -1;
        this.mLastCleanTime = 0;
        this.mScanLogInterval = 120000;
        this.mLogQueue = r4;
        this.mContext = r3;
        this.mPendingQueue = r5;
        this.mStopFlag = r6;
        this.mDbHelper = LogQueueManager.getInstance(r3);
    }

    private void cleanLog() {
        if (isStop() == false) goto L5;
        return;
    L5:
        Map<String, LogHandler> r0 = this.mLogQueue.getAllLogHandler();
        if (r0 != null) goto L8;
    L22:
        this.mDbHelper.cleanExpireLog(null, -1, MAX_EXPIRE_TIME);
        return;
    L8:
        if (r0.isEmpty() == true) goto L22;
        Iterator<String> r1 = r0.keySet().iterator();
    L11:
        if (r1.hasNext() == false) goto L22;
        String r2 = r1.next();
        if (isStop() == true) goto L22;
        LogHandler r3 = r0.get(r2);
        if (r3 == null) goto L11;
        LogHandler.IConfig r4 = r3.getConfig();
        if (r4 == null) goto L11;
        this.mDbHelper.cleanExpireLog(r2, r4.getMaxRetryCount(), r4.getLogExpireTime());
        goto L11
    }

    private boolean isStop() {
        return this.mStopFlag.get();
    }

    private boolean processPendingQueue() {
        if (isStop() == false) goto L5;
        return false;
    L5:
        LinkedList<LogItem> r0 = this.mPendingQueue;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L8:
        if (isStop() == false) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return false;
    L14:
        if (this.mPendingQueue.isEmpty() == true) goto L16;
        LogItem r1 = this.mPendingQueue.poll();     // Catch: Throwable -> L11
    L17:
        boolean r2 = !this.mPendingQueue.isEmpty();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        if (r1 != null) goto L29;
    L25:
        return r2;
    L29:
    L24:
        this.mDbHelper.recreateTableQueue();
        goto L25
    L21:
        if (this.mDbHelper.insertLog(r1.type, r1.value) < Long.MAX_VALUE) goto L25;
        this.mDbHelper.recreateTableQueue();     // Catch: SQLiteFullException -> L24
        goto L25
    L16:
        r1 = null;
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARN: Type inference failed for: r22v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r26v0, types: [com.bytedance.framwork.core.sdklog.LogSender] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.framwork.core.sdklog.LogQueueManager] */
    /* JADX WARN: Type inference failed for: r3v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [com.bytedance.framwork.core.sdklog.LogHandler] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private boolean scanAndSendLog() {
        boolean r2 = false;
        if (isStop() == false) goto L6;
        return false;
    L6:
        if (this.mMinLog >= 0) goto L11;
        if ((System.currentTimeMillis() - this.mLastCleanTime) <= 600000) goto L11;
        this.mMinLog = 0;
        cleanLog();
        this.mLastCleanTime = System.currentTimeMillis();
    L11:
        if (LogLib.isNetworkAvailable(this.mContext) == true) goto L14;
        this.mScanLogInterval = 120000;
        return false;
    L14:
        LogItem r7 = this.mDbHelper.getLog(this.mMinLog);
        LogHandler.IConfig r0 = null;
        if (r7 == null) goto L17;
        long r8 = this.mMinLog;
        long r10 = r7.id;
        if (r8 >= r10) goto L30;
        this.mMinLog = r10;
    L31:
        byte[] r9 = r7.value;
        if (r9 != null) goto L34;
    L89:
        ?? r11 = 0;
        ?? r3 = 0;
        r2 = true;
    L91:
        if (isStop() == false) goto L93;
        return true;
    L93:
        if (r2 == false) goto L96;
        this.mDbHelper.onLogSent(r7.id, true, 0, 0);
    L103:
        return true;
    L96:
        if (this.mDbHelper.onLogSent(r7.id, r3, r0.getLogExpireTime(), r0.getMaxRetryCount()) == false) goto L101;
        long r4 = r0.getRetryInterval() * ((long) (r7.retryCount + 1));
        if (r4 <= 0) goto L100;
        this.mScanLogInterval = r4;
    L100:
        this.mScanLogInterval = Math.min(120000, this.mScanLogInterval);
    L102:
        r11.onLogSent(r7.value, r3);
        goto L103
    L101:
        this.mScanLogInterval = 120000;
        goto L102
    L34:
        if (r9.length <= 0) goto L89;
        LogHandler r12 = this.mLogQueue.getLogHandler(r7.type);
        if (r12 != null) goto L39;
        return true;
    L39:
        LogHandler.IConfig r13 = r12.getConfig();
        LogHandler.IResponseConfig r1 = r12.getResponseConfig();
        long r14 = System.currentTimeMillis();
        long r15 = r13.getRetryInterval();
        if (r1 == null) goto L52;
        if (r1.getRemoveSwitch() == false) goto L45;
        ?? r5 = 1;
    L44:
        r0 = r13;
        r3 = r5;
        r11 = r12;
        goto L91
    L45:
        long r16 = r1.getStopInterval();
        if (r16 > 0) goto L48;
    L50:
        r12.setLastStopTime(System.currentTimeMillis());
        goto L52
    L48:
        if ((r14 - r12.getLastStopTime()) >= r16) goto L50;
        return true;
    L52:
        if (r15 <= 0) goto L58;
        int r6 = r7.retryCount;
        if (r6 <= 0) goto L58;
        if ((r14 - r7.retryTime) >= (r15 * ((long) r6))) goto L58;
        return true;
    L58:
        ?? r17 = r12.getLastSuccessChannel();
        List<String> r18 = r13.getChannels();
        if (r18 != null) goto L107;
        return true;
    L107:
        String r19 = r13.getRedirectUrl();     // Catch: Throwable -> L64
        if (TextUtils.isEmpty(r19) == true) goto L105;
        ?? r20 = sendLog(r12, r19, r7.value);     // Catch: Throwable -> L64
    L87:
        r5 = r20;
        goto L44
    L105:
        if (TextUtils.isEmpty(r17) == true) goto L76;
        r17 = sendLog(r12, r17, r7.value);     // Catch: Throwable -> L64
        if (r17 != 0) goto L74;
        r12.setLastSuccessChannel("");     // Catch: Throwable -> L72
        r17 = r17;
    L104:
    L74:
        r20 = r17;
        goto L87
    L76:
        if (r1.getMoreChannelSwitch() == false) goto L78;
        this.mChannelPosition++;     // Catch: Throwable -> L64
    L78:
        int r21 = r18.size();     // Catch: Throwable -> L64
        int r22 = this.mChannelPosition;     // Catch: Throwable -> L64
        if (r21 <= r22) goto L82;
        if (r22 < 0) goto L82;
        String r23 = r18.get(r22);     // Catch: Throwable -> L64
    L83:
        r17 = sendLog(r12, r23, r7.value);     // Catch: Throwable -> L64
        if (r17 == 0) goto L74;
        r12.setLastSuccessChannel(r23);     // Catch: Throwable -> L72
        r17 = r17;
    L82:
        this.mChannelPosition = 0;     // Catch: Throwable -> L64
        r23 = r18.get(0);     // Catch: Throwable -> L64
    L72:
        th = th;
    L88:
        LogQueue.log(TAG, "send log exception: " + th);
        r5 = r17;
    L64:
        th = th;
        r17 = 0;
        goto L88
    L30:
        this.mMinLog = r8 + 1;
        goto L31
    L17:
        if (this.mMinLog != 0) goto L23;
        if (this.mDbHelper.getEventCount(null) != 0) goto L23;
        this.mScanLogInterval = 0;
        return false;
    L23:
        if (this.mMinLog != (-1)) goto L25;
        this.mScanLogInterval = 120000;
    L25:
        this.mMinLog = -1;
        return false;
    }

    private boolean sendLog(LogHandler r1, String r2, byte[] r3) {
        if (r3 != null) goto L4;
        return false;
    L4:
        if (r3.length <= 0) goto L13;
        if (r1 != null) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return false;
    L10:
        return r1.send(r2, r3);
    L13:
        return false;
    }

    public void awaken() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mLock.notify();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void quit() {
        awaken();
        this.mDbHelper.closeDatabase();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        LogQueue.log(TAG, "LogSender start");
    L4:
        if (isStop() == true) goto L31;
        boolean r0 = processPendingQueue();
        if (isStop() == true) goto L31;
        if (scanAndSendLog() == true) goto L13;
        if (r0 == true) goto L13;
        boolean r1 = false;
    L15:
        if (isStop() == true) goto L31;
        if (r1 == true) goto L4;
        Object r2 = this.mLock;
        monitor-enter(r2);
        long r3 = this.mScanLogInterval;     // Catch: Throwable -> L24 InterruptedException -> L33
        if (r3 != 0) goto L26;
        this.mLock.wait();     // Catch: Throwable -> L24 InterruptedException -> L33
        goto L27
    L26:
        this.mLock.wait(r3);     // Catch: Throwable -> L24 InterruptedException -> L33
        goto L27
    L24:
        th = move-exception;
        throw th;
    L27:
        monitor-exit(r2);     // Catch: Throwable -> L24
    L13:
        r1 = true;
    L31:
        LogQueue.log(TAG, "LogSender quit");
    }
}
