package com.tencent.wcdb.database;

import com.tencent.wcdb.support.CancellationSignal;

/* JADX INFO: loaded from: classes5.dex */
public final class SQLiteStatement extends SQLiteProgram {
    SQLiteStatement(SQLiteDatabase r2, String r3, Object[] r4) {
        super(r2, r3, r4, null);
    }

    public void execute() {
        execute(null);
    }

    public void execute(CancellationSignal r5) {
        acquireReference();
        getSession().execute(getSql(), getBindArgs(), getConnectionFlags(), r5);     // Catch: Throwable -> L6 SQLiteException -> L8
        releaseReference();
        return;
    L8:
        e = move-exception;
        checkCorruption(e);     // Catch: Throwable -> L6
        throw e;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public int executeUpdateDelete() {
        return executeUpdateDelete(null);
    }

    public int executeUpdateDelete(CancellationSignal r5) {
        acquireReference();
        int r6 = getSession().executeForChangedRowCount(getSql(), getBindArgs(), getConnectionFlags(), r5);     // Catch: Throwable -> L6 SQLiteDatabaseCorruptException -> L8
        releaseReference();
        return r6;
    L8:
        e = move-exception;
        checkCorruption(e);     // Catch: Throwable -> L6
        throw e;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public long executeInsert() {
        return executeInsert(null);
    }

    public long executeInsert(CancellationSignal r5) {
        acquireReference();
        long r0 = getSession().executeForLastInsertedRowId(getSql(), getBindArgs(), getConnectionFlags(), r5);     // Catch: Throwable -> L6 SQLiteDatabaseCorruptException -> L8
        releaseReference();
        return r0;
    L8:
        e = move-exception;
        checkCorruption(e);     // Catch: Throwable -> L6
        throw e;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public long simpleQueryForLong() {
        return simpleQueryForLong(null);
    }

    public long simpleQueryForLong(CancellationSignal r5) {
        acquireReference();
        long r0 = getSession().executeForLong(getSql(), getBindArgs(), getConnectionFlags(), r5);     // Catch: Throwable -> L6 SQLiteDatabaseCorruptException -> L8
        releaseReference();
        return r0;
    L8:
        e = move-exception;
        checkCorruption(e);     // Catch: Throwable -> L6
        throw e;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public String simpleQueryForString() {
        return simpleQueryForString(null);
    }

    public String simpleQueryForString(CancellationSignal r5) {
        acquireReference();
        String r6 = getSession().executeForString(getSql(), getBindArgs(), getConnectionFlags(), r5);     // Catch: Throwable -> L6 SQLiteDatabaseCorruptException -> L8
        releaseReference();
        return r6;
    L8:
        e = move-exception;
        checkCorruption(e);     // Catch: Throwable -> L6
        throw e;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public String toString() {
        return "SQLiteProgram: " + getSql();
    }
}
