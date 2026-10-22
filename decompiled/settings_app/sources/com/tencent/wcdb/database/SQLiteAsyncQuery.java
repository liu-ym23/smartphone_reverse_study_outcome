package com.tencent.wcdb.database;

import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;

/* JADX INFO: loaded from: classes5.dex */
public class SQLiteAsyncQuery extends SQLiteProgram {
    private static final String TAG = "WCDB.SQLiteAsyncQuery";
    private final int mResultColumns;

    private static native int nativeCount(long r0);

    private static native int nativeFillRows(long r0, long r2, int r4, int r5);

    public SQLiteAsyncQuery(SQLiteDatabase r1, String r2, Object[] r3, CancellationSignal r4) {
        super(r1, r2, r3, r4);
        this.mResultColumns = getColumnNames().length;
    }

    void acquire() {
        if (this.mPreparedStatement != null) goto L6;
        acquirePreparedStatement(true);
        this.mPreparedStatement.bindArguments(getBindArgs());
        return;
    }

    void release() {
        releasePreparedStatement();
    }

    int fillRows(ChunkedCursorWindow r8, int r9, int r10) {
        acquire();
        int r0 = r8.getNumColumns();
        int r1 = this.mResultColumns;
        if (r0 == r1) goto L10;
        r8.setNumColumns(r1);
    L10:
        return nativeFillRows(this.mPreparedStatement.getPtr(), r8.mWindowPtr, r9, r10);
    L7:
        e = move-exception;
        Log.e(TAG, "Got exception on fillRows: " + e.getMessage() + ", SQL: " + getSql());
        checkCorruption(e);
        throw e;
    }

    int getCount() {
        acquire();
        return nativeCount(this.mPreparedStatement.getPtr());
    L5:
        e = move-exception;
        Log.e(TAG, "Got exception on getCount: " + e.getMessage() + ", SQL: " + getSql());
        checkCorruption(e);
        throw e;
    }

    void reset() {
        if (this.mPreparedStatement == null) goto L6;
        this.mPreparedStatement.reset(false);
        return;
    }
}
