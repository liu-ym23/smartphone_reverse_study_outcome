package com.tencent.wcdb.database;

import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;

/* JADX INFO: loaded from: classes5.dex */
public class SQLiteDirectQuery extends SQLiteProgram {
    private static final int[] SQLITE_TYPE_MAPPING = null;
    private static final String TAG = "WCDB.SQLiteDirectQuery";
    private final CancellationSignal mCancellationSignal;

    private static native byte[] nativeGetBlob(long r0, int r2);

    private static native double nativeGetDouble(long r0, int r2);

    private static native long nativeGetLong(long r0, int r2);

    private static native String nativeGetString(long r0, int r2);

    private static native int nativeGetType(long r0, int r2);

    private static native int nativeStep(long r0, int r2);

    public SQLiteDirectQuery(SQLiteDatabase r1, String r2, Object[] r3, CancellationSignal r4) {
        super(r1, r2, r3, r4);
        this.mCancellationSignal = r4;
    }

    public long getLong(int r3) {
        return nativeGetLong(this.mPreparedStatement.getPtr(), r3);
    }

    public double getDouble(int r3) {
        return nativeGetDouble(this.mPreparedStatement.getPtr(), r3);
    }

    public String getString(int r3) {
        return nativeGetString(this.mPreparedStatement.getPtr(), r3);
    }

    public byte[] getBlob(int r3) {
        return nativeGetBlob(this.mPreparedStatement.getPtr(), r3);
    }

    public int getType(int r4) {
        return SQLITE_TYPE_MAPPING[nativeGetType(this.mPreparedStatement.getPtr(), r4)];
    }

    public int step(int r4) {
    L8:
        e = move-exception;
        if ((e instanceof SQLiteException) == false) goto L13;
        Log.e(TAG, "Got exception on stepping: " + e.getMessage() + ", SQL: " + getSql());
        checkCorruption((SQLiteException) e);
    L13:
        if (this.mPreparedStatement == null) goto L15;
        this.mPreparedStatement.detachCancellationSignal(this.mCancellationSignal);
        this.mPreparedStatement.failOperation(e);
    L15:
        releasePreparedStatement();
        throw e;
    L4:
        if (acquirePreparedStatement(false) == false) goto L6;
        this.mPreparedStatement.beginOperation("directQuery", getBindArgs());     // Catch: RuntimeException -> L8
        this.mPreparedStatement.attachCancellationSignal(this.mCancellationSignal);     // Catch: RuntimeException -> L8
    L6:
        return nativeStep(this.mPreparedStatement.getPtr(), r4);
    }

    public synchronized void reset(boolean r3) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mPreparedStatement == null) goto L8;
        this.mPreparedStatement.reset(false);     // Catch: Throwable -> L10
        if (r3 == false) goto L8;
        this.mPreparedStatement.detachCancellationSignal(this.mCancellationSignal);     // Catch: Throwable -> L10
        this.mPreparedStatement.endOperation(null);     // Catch: Throwable -> L10
        releasePreparedStatement();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
    }

    @Override // com.tencent.wcdb.database.SQLiteProgram, com.tencent.wcdb.database.SQLiteClosable
    protected void onAllReferencesReleased() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mPreparedStatement == null) goto L6;
        this.mPreparedStatement.detachCancellationSignal(this.mCancellationSignal);     // Catch: Throwable -> L9
        this.mPreparedStatement.endOperation(null);     // Catch: Throwable -> L9
    L6:
        monitor-exit(this);     // Catch: Throwable -> L9
        super.onAllReferencesReleased();
    }

    static {
        SQLITE_TYPE_MAPPING = new int[]{3, 1, 2, 3, 4, 0};
    }
}
