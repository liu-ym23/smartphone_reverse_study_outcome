package com.tencent.wcdb.database;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import java.util.HashSet;

/* JADX INFO: loaded from: classes5.dex */
public class SQLiteAsyncCheckpointer implements SQLiteCheckpointListener, Handler.Callback {
    private static final int DEFAULT_BLOCKING_THRESHOLD = 300;
    private static final int DEFAULT_THRESHOLD = 100;
    private static HandlerThread gDefaultThread;
    private static final Object gDefaultThreadLock = null;
    private static int gDefaultThreadRefCount;
    private int mBlockingThreshold;
    private Handler mHandler;
    private int mLastSyncMode;
    private Looper mLooper;
    private final HashSet<Pair<SQLiteDatabase, String>> mPendingCheckpoints;
    private int mThreshold;
    private boolean mUseDefaultLooper;

    protected void onCheckpointResult(SQLiteDatabase r1, int r2, int r3, long r4) {
    }

    public SQLiteAsyncCheckpointer() {
        this(null, 100, 300);
    }

    public SQLiteAsyncCheckpointer(Looper r3) {
        this(r3, 100, 300);
    }

    public SQLiteAsyncCheckpointer(Looper r1, int r2, int r3) {
        this.mLooper = r1;
        this.mThreshold = r2;
        this.mBlockingThreshold = r3;
        this.mPendingCheckpoints = new HashSet();
    }

    @Override // com.tencent.wcdb.database.SQLiteCheckpointListener
    public void onAttach(SQLiteDatabase r4) {
        if (this.mLooper != null) goto L5;
        this.mLooper = acquireDefaultLooper();
        this.mUseDefaultLooper = true;
    L5:
        this.mHandler = new Handler(this.mLooper, this);
        this.mLastSyncMode = r4.getSynchronousMode();
        r4.setSynchronousMode(1);
    }

    @Override // com.tencent.wcdb.database.SQLiteCheckpointListener
    public void onWALCommit(SQLiteDatabase r4, String r5, int r6) {
        if (r6 >= this.mThreshold) goto L6;
        return;
    L6:
        if (r6 < this.mBlockingThreshold) goto L8;
        int r7 = 1;
    L9:
        Pair<SQLiteDatabase, String> r0 = new Pair(r4, r5);
        HashSet<Pair<SQLiteDatabase, String>> r8 = this.mPendingCheckpoints;
        monitor-enter(r8);
        boolean r2 = this.mPendingCheckpoints.add(r0);     // Catch: Throwable -> L17
        monitor-exit(r8);     // Catch: Throwable -> L17
        if (r2 == true) goto L15;
        return;
    L15:
        r4.acquireReference();
        this.mHandler.sendMessage(this.mHandler.obtainMessage(0, r7, 0, r0));
        return;
    L17:
        th = move-exception;
        throw th;
    L8:
        r7 = 0;
        goto L9
    }

    @Override // com.tencent.wcdb.database.SQLiteCheckpointListener
    public void onDetach(SQLiteDatabase r2) {
        r2.setSynchronousMode(this.mLastSyncMode);
        this.mHandler = null;
        if (this.mUseDefaultLooper == false) goto L6;
        this.mLooper = null;
        releaseDefaultLooper();
        this.mUseDefaultLooper = false;
        return;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r10) {
        Pair r0 = (Pair) r10.obj;
        SQLiteDatabase r1 = (SQLiteDatabase) r0.first;
        String r2 = (String) r0.second;
        if (r10.arg1 == 0) goto L5;
        boolean r11 = true;
    L22:
        long r3 = SystemClock.uptimeMillis();     // Catch: Throwable -> L18
        Pair<Integer, Integer> r12 = r1.walCheckpoint(r2, r11);     // Catch: Throwable -> L18
        onCheckpointResult(r1, ((Integer) r12.first).intValue(), ((Integer) r12.second).intValue(), SystemClock.uptimeMillis() - r3);     // Catch: Throwable -> L18
        r1.releaseReference();
        HashSet<Pair<SQLiteDatabase, String>> r13 = this.mPendingCheckpoints;
        monitor-enter(r13);
    L15:
        th = move-exception;
        throw th;
    L10:
        if (this.mPendingCheckpoints.remove(r0) == false) goto L14;
        monitor-exit(r13);     // Catch: Throwable -> L15
        return true;
    L14:
        throw new AssertionError("mPendingCheckpoints.remove(p)");     // Catch: Throwable -> L15
    L18:
        th = move-exception;
        r1.releaseReference();
        throw th;
    L5:
        r11 = false;
        goto L22
    }

    private static Looper acquireDefaultLooper() {
        Object r0 = gDefaultThreadLock;
        monitor-enter(r0);
        int r1 = gDefaultThreadRefCount;     // Catch: Throwable -> L14
        gDefaultThreadRefCount = r1 + 1;     // Catch: Throwable -> L14
        if (r1 == 0) goto L7;
    L11:
        Looper r2 = gDefaultThread.getLooper();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r2;
    L7:
        if (gDefaultThread != null) goto L10;
        HandlerThread r3 = new HandlerThread("WCDB.AsyncCheckpointer", 4);     // Catch: Throwable -> L14
        gDefaultThread = r3;     // Catch: Throwable -> L14
        r3.start();     // Catch: Throwable -> L14
        goto L11
    L10:
        throw new AssertionError("gDefaultThread == null");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    private static void releaseDefaultLooper() {
        Object r0 = gDefaultThreadLock;
        monitor-enter(r0);
        int r1 = gDefaultThreadRefCount - 1;     // Catch: Throwable -> L12
        gDefaultThreadRefCount = r1;     // Catch: Throwable -> L12
        if (r1 > 0) goto L10;
        if (r1 < 0) goto L9;
        gDefaultThread.quit();     // Catch: Throwable -> L12
        gDefaultThread = null;     // Catch: Throwable -> L12
        goto L10
    L9:
        throw new AssertionError("gDefaultThreadRefCount == 0");     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    static {
        gDefaultThreadLock = new Object();
    }
}
