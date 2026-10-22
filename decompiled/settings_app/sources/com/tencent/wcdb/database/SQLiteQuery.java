package com.tencent.wcdb.database;

import com.tencent.wcdb.CursorWindow;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;

/* JADX INFO: loaded from: classes5.dex */
public final class SQLiteQuery extends SQLiteProgram {
    private static final String TAG = "WCDB.SQLiteQuery";
    private final CancellationSignal mCancellationSignal;

    SQLiteQuery(SQLiteDatabase r1, String r2, Object[] r3, CancellationSignal r4) {
        super(r1, r2, r3, r4);
        this.mCancellationSignal = r4;
    }

    int fillWindow(CursorWindow r11, int r12, int r13, boolean r14) {
        acquireReference();
        r11.acquireReference();     // Catch: Throwable -> L15
        int r15 = getSession().executeForCursorWindow(getSql(), getBindArgs(), r11, r12, r13, r14, getConnectionFlags(), this.mCancellationSignal);     // Catch: Throwable -> L8 SQLiteException -> L10
        r11.releaseReference();     // Catch: Throwable -> L15
        releaseReference();
        return r15;
    L8:
        th = move-exception;
        r11.releaseReference();     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L10:
        e = move-exception;
        Log.e(TAG, "exception: " + e.getMessage() + "; query: " + getSql());     // Catch: Throwable -> L8
        checkCorruption(e);     // Catch: Throwable -> L8
        throw e;     // Catch: Throwable -> L8
    L15:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public String toString() {
        return "SQLiteQuery: " + getSql();
    }
}
