package com.tencent.wcdb.repair;

import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.support.CancellationSignal;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class BackupKit implements CancellationSignal.OnCancelListener {
    public static final int FLAG_FIX_CORRUPTION = 4;
    public static final int FLAG_INCREMENTAL = 16;
    public static final int FLAG_NO_CIPHER = 1;
    public static final int FLAG_NO_COMPRESS = 2;
    public static final int FLAG_NO_CREATE_TABLE = 8;
    public static final int RESULT_CANCELED = 1;
    public static final int RESULT_FAILED = -1;
    public static final int RESULT_OK = 0;
    static final String TAG = "WCDB.DBBackup";
    private SQLiteDatabase mDB;
    private String mLastError;
    private long mNativePtr;
    private int mStatementCount;
    private String[] mTableDesc;

    private static native void nativeCancel(long r0);

    private static native void nativeFinish(long r0);

    private static native long nativeInit(String r0, byte[] r1, int r2);

    private static native String nativeLastError(long r0);

    private static native int nativeRun(long r0, long r2, String[] r4);

    private static native int nativeStatementCount(long r0);

    public BackupKit(SQLiteDatabase r1, String r2, byte[] r3, int r4, String[] r5) throws SQLiteException {
        this.mDB = r1;
        String[] r6 = null;
        this.mLastError = null;
        if (r5 == null) goto L5;
        r6 = (String[]) Arrays.copyOf(r5, r5.length);
    L5:
        this.mTableDesc = r6;
        if (r2 == null) goto L13;
        long r7 = nativeInit(r2, r3, r4);
        this.mNativePtr = r7;
        if (r7 == 0) goto L11;
        return;
    L11:
        throw new SQLiteException("Failed initialize backup context.");
    L13:
        throw new IllegalArgumentException();
    }

    public int run() {
        if (this.mNativePtr == 0) goto L7;
        long r0 = this.mDB.acquireNativeConnectionHandle("backup", false, false);
        int r4 = nativeRun(this.mNativePtr, r0, this.mTableDesc);
        this.mDB.releaseNativeConnection(r0, null);
        this.mStatementCount = nativeStatementCount(this.mNativePtr);
        this.mLastError = nativeLastError(this.mNativePtr);
        nativeFinish(this.mNativePtr);
        this.mNativePtr = 0;
        return r4;
    L7:
        throw new IllegalStateException("BackupKit not initialized.");
    }

    public int run(CancellationSignal r2) {
        if (r2.isCanceled() == false) goto L6;
        return 1;
    L6:
        r2.setOnCancelListener(this);
        int r1 = run();
        r2.setOnCancelListener(null);
        return r1;
    }

    public int statementCount() {
        return this.mStatementCount;
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
