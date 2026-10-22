package com.tencent.wcdb.database;

import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.support.CancellationSignal;

/* JADX INFO: loaded from: classes5.dex */
public final class SQLiteDirectCursorDriver implements SQLiteCursorDriver {
    private static SQLiteDatabase.CursorFactory DEFAULT_FACTORY;
    private final CancellationSignal mCancellationSignal;
    private final SQLiteDatabase mDatabase;
    private final String mEditTable;
    private SQLiteProgram mQuery;
    private final String mSql;

    @Override // com.tencent.wcdb.database.SQLiteCursorDriver
    public void cursorClosed() {
    }

    @Override // com.tencent.wcdb.database.SQLiteCursorDriver
    public void cursorDeactivated() {
    }

    @Override // com.tencent.wcdb.database.SQLiteCursorDriver
    public void cursorRequeried(Cursor r1) {
    }

    static {
        DEFAULT_FACTORY = SQLiteCursor.FACTORY;
    }

    public SQLiteDirectCursorDriver(SQLiteDatabase r1, String r2, String r3, CancellationSignal r4) {
        this.mDatabase = r1;
        this.mEditTable = r3;
        this.mSql = r2;
        this.mCancellationSignal = r4;
    }

    @Override // com.tencent.wcdb.database.SQLiteCursorDriver
    public Cursor query(SQLiteDatabase.CursorFactory r5, Object[] r6) {
        if (r5 != null) goto L4;
        r5 = DEFAULT_FACTORY;
    L4:
        SQLiteProgram r0 = null;
        r0 = r5.newQuery(this.mDatabase, this.mSql, r6, this.mCancellationSignal);     // Catch: RuntimeException -> L8
        Cursor r7 = r5.newCursor(this.mDatabase, this, this.mEditTable, r0);     // Catch: RuntimeException -> L8
        this.mQuery = r0;
        return r7;
    L8:
        e = move-exception;
        if (r0 == null) goto L11;
        r0.close();
    L11:
        throw e;
    }

    @Override // com.tencent.wcdb.database.SQLiteCursorDriver
    public void setBindArguments(String[] r1) {
        this.mQuery.bindAllArgsAsStrings(r1);
    }

    public String toString() {
        return "SQLiteDirectCursorDriver: " + this.mSql;
    }
}
