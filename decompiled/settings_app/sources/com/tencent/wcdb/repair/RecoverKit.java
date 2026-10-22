package com.tencent.wcdb.repair;

import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.support.CancellationSignal;

/* JADX INFO: loaded from: classes5.dex */
public class RecoverKit implements CancellationSignal.OnCancelListener {
    public static final int RESULT_CANCELED = 1;
    public static final int RESULT_FAILED = -1;
    public static final int RESULT_OK = 0;
    static final String TAG = "WCDB.DBBackup";
    private SQLiteDatabase mDB;
    private int mFailedCount;
    private String mLastError;
    private long mNativePtr;
    private int mSuccessCount;

    private static native void nativeCancel(long r0);

    private static native int nativeFailureCount(long r0);

    private static native void nativeFinish(long r0);

    private static native long nativeInit(String r0, byte[] r1);

    private static native String nativeLastError(long r0);

    private static native int nativeRun(long r0, long r2, boolean r4);

    private static native int nativeSuccessCount(long r0);

    public RecoverKit(SQLiteDatabase r3, String r4, byte[] r5) throws SQLiteException {
        this.mDB = r3;
        this.mLastError = null;
        long r6 = nativeInit(r4, r5);
        this.mNativePtr = r6;
        if (r6 == 0) goto L6;
        return;
    L6:
        throw new SQLiteException("Failed initialize recover context.");
    }

    public int run(boolean r7) {
        if (this.mNativePtr == 0) goto L7;
        long r0 = this.mDB.acquireNativeConnectionHandle("recover", false, false);
        int r8 = nativeRun(this.mNativePtr, r0, r7);
        this.mDB.releaseNativeConnection(r0, null);
        this.mSuccessCount = nativeSuccessCount(this.mNativePtr);
        this.mFailedCount = nativeFailureCount(this.mNativePtr);
        this.mLastError = nativeLastError(this.mNativePtr);
        nativeFinish(this.mNativePtr);
        this.mNativePtr = 0;
        return r8;
    L7:
        throw new IllegalStateException("RecoverKit not initialized.");
    }

    public int run(boolean r2, CancellationSignal r3) {
        if (r3.isCanceled() == false) goto L6;
        return 1;
    L6:
        r3.setOnCancelListener(this);
        int r1 = run(r2);
        r3.setOnCancelListener(null);
        return r1;
    }

    public int successCount() {
        return this.mSuccessCount;
    }

    public int failureCount() {
        return this.mFailedCount;
    }

    @Override // com.tencent.wcdb.support.CancellationSignal.OnCancelListener
    public void onCancel() {
        long r0 = this.mNativePtr;
        if (r0 == 0) goto L6;
        nativeCancel(r0);
        return;
    }

    public String lastError() {
        return this.mLastError;
    }

    public void release() {
        long r0 = this.mNativePtr;
        if (r0 == 0) goto L6;
        nativeFinish(r0);
        this.mNativePtr = 0;
        return;
    }

    protected void finalize() throws Throwable {
        release();
        super.finalize();
    }
}
