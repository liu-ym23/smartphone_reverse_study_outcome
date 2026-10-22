package com.tencent.wcdb.database;

import com.tencent.wcdb.AbstractCursor;
import com.tencent.wcdb.support.Log;

/* JADX INFO: loaded from: classes5.dex */
public class SQLiteDirectCursor extends AbstractCursor {
    public static final SQLiteDatabase.CursorFactory FACTORY = null;
    private static final String TAG = "WCDB.SQLiteDirectCursor";
    private final String[] mColumns;
    private int mCount;
    private boolean mCountFinished;
    private final SQLiteCursorDriver mDriver;
    private final SQLiteDirectQuery mQuery;

    public SQLiteDirectCursor(SQLiteCursorDriver r1, String r2, SQLiteDirectQuery r3) {
        if (r3 == null) goto L7;
        this.mQuery = r3;
        this.mDriver = r1;
        this.mColumns = r3.getColumnNames();
        this.mCount = -1;
        this.mCountFinished = false;
        return;
    L7:
        throw new IllegalArgumentException("query object cannot be null");
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        this.mQuery.close();
        this.mDriver.cursorClosed();
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public void deactivate() {
        super.deactivate();
        this.mDriver.cursorDeactivated();
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public String[] getColumnNames() {
        return this.mColumns;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public String getString(int r1) {
        return this.mQuery.getString(r1);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public byte[] getBlob(int r1) {
        return this.mQuery.getBlob(r1);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public short getShort(int r1) {
        return (short) this.mQuery.getLong(r1);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public int getInt(int r1) {
        return (int) this.mQuery.getLong(r1);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public long getLong(int r1) {
        return this.mQuery.getLong(r1);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public float getFloat(int r1) {
        return (float) this.mQuery.getDouble(r1);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public double getDouble(int r1) {
        return this.mQuery.getDouble(r1);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public int getType(int r1) {
        return this.mQuery.getType(r1);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public boolean isNull(int r1) {
        if (getType(r1) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public boolean moveToPosition(int r6) {
        if (r6 >= 0) goto L7;
        this.mQuery.reset(false);
        this.mPos = -1;
        return false;
    L7:
        if (this.mCountFinished == false) goto L13;
        int r1 = this.mCount;
        if (r6 < r1) goto L13;
        this.mPos = r1;
        return false;
    L13:
        if (r6 >= this.mPos) goto L16;
        Log.w(TAG, "Moving backward on SQLiteDirectCursor is slow. Get rid of backward movement or use other implementations.");
        this.mQuery.reset(false);
        int r2 = this.mQuery.step(r6 + 1) - 1;
    L19:
        if (r2 >= r6) goto L21;
        int r3 = r2 + 1;
        this.mCount = r3;
        this.mCountFinished = true;
        this.mPos = r3;
    L25:
        if (this.mPos < this.mCount) goto L27;
        return false;
    L27:
        return true;
    L21:
        this.mPos = r2;
        if (r2 < this.mCount) goto L25;
        this.mCount = r2 + 1;
        this.mCountFinished = false;
        goto L25
    L16:
        if (r6 != this.mPos) goto L18;
        return true;
    L18:
        r2 = this.mPos + this.mQuery.step(r6 - this.mPos);
        goto L19
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public int getCount() {
        if (this.mCountFinished == true) goto L6;
        Log.w(TAG, "Count query on SQLiteDirectCursor is slow. Iterate through the end to get count or use other implementations.");
        this.mCount = (this.mPos + this.mQuery.step(Integer.MAX_VALUE)) + 1;
        this.mCountFinished = true;
        this.mQuery.reset(false);
        this.mPos = this.mQuery.step(this.mPos + 1) - 1;
    L6:
        return this.mCount;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public boolean requery() {
        if (isClosed() == false) goto L5;
        return false;
    L5:
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L7:
        if (this.mQuery.getDatabase().isOpen() == true) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L18
        return false;
    L10:
        this.mPos = -1;     // Catch: Throwable -> L18
        this.mCountFinished = false;     // Catch: Throwable -> L18
        this.mCount = -1;     // Catch: Throwable -> L18
        this.mDriver.cursorRequeried(this);     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        this.mQuery.reset(false);
        return super.requery();
    L15:
        e = move-exception;
        Log.w(TAG, "requery() failed " + e.getMessage(), new Object[]{e});
        return false;
    }

    static {
        FACTORY = new AnonymousClass1();
    }
}
