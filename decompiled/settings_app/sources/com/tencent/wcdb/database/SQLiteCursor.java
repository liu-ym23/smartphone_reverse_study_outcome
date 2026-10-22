package com.tencent.wcdb.database;

import com.tencent.wcdb.AbstractWindowedCursor;
import com.tencent.wcdb.CursorWindow;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.support.Log;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class SQLiteCursor extends AbstractWindowedCursor {
    public static final SQLiteDatabase.CursorFactory FACTORY = null;
    static final int NO_COUNT = -1;
    static final String TAG = "WCDB.SQLiteCursor";
    private Map<String, Integer> mColumnNameMap;
    private final String[] mColumns;
    private int mCount;
    private int mCursorWindowCapacity;
    private final SQLiteCursorDriver mDriver;
    private final SQLiteQuery mQuery;

    @Deprecated
    public SQLiteCursor(SQLiteDatabase r1, SQLiteCursorDriver r2, String r3, SQLiteQuery r4) {
        this(r2, r3, r4);
    }

    public SQLiteCursor(SQLiteCursorDriver r1, String r2, SQLiteQuery r3) {
        this.mCount = -1;
        if (r3 == null) goto L7;
        this.mDriver = r1;
        this.mColumnNameMap = null;
        this.mQuery = r3;
        String[] r4 = r3.getColumnNames();
        this.mColumns = r4;
        this.mRowIdColumnIndex = DatabaseUtils.findRowIdColumnIndex(r4);
        return;
    L7:
        throw new IllegalArgumentException("query object cannot be null");
    }

    public SQLiteDatabase getDatabase() {
        return this.mQuery.getDatabase();
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.CrossProcessCursor
    public boolean onMove(int r2, int r3) {
        if (this.mWindow != null) goto L5;
    L8:
        fillWindow(r3);
        int r4 = this.mWindow.getStartPosition() + this.mWindow.getNumRows();
        if (r3 < r4) goto L14;
        this.mCount = r4;
        return true;
    L14:
        return true;
    L5:
        if (r3 < this.mWindow.getStartPosition()) goto L8;
        if (r3 >= (this.mWindow.getStartPosition() + this.mWindow.getNumRows())) goto L8;
        return true;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public boolean moveToPosition(int r3) {
        if (super.moveToPosition(r3) == true) goto L5;
        return false;
    L5:
        int r0 = getCount();
        if (r3 < r0) goto L9;
        this.mPos = r0;
        return false;
    L9:
        return true;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public int getCount() {
        if (this.mCount != (-1)) goto L6;
        fillWindow(0);
    L6:
        return this.mCount;
    }

    private void fillWindow(int r5) {
        clearOrCreateWindow(getDatabase().getPath());
    L8:
        e = move-exception;
        closeWindow();
        throw e;
    L4:
        if (this.mCount != (-1)) goto L6;
        int r0 = DatabaseUtils.cursorPickFillWindowStartPosition(r5, 0);     // Catch: RuntimeException -> L8
        this.mCount = this.mQuery.fillWindow(this.mWindow, r0, r5, true);     // Catch: RuntimeException -> L8
        this.mCursorWindowCapacity = this.mWindow.getNumRows();     // Catch: RuntimeException -> L8
        return;
    L6:
        int r1 = DatabaseUtils.cursorPickFillWindowStartPosition(r5, this.mCursorWindowCapacity);     // Catch: RuntimeException -> L8
        this.mQuery.fillWindow(this.mWindow, r1, r5, false);     // Catch: RuntimeException -> L8
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public int getColumnIndex(String r8) {
        if (this.mColumnNameMap != null) goto L8;
        String[] r0 = this.mColumns;
        int r2 = r0.length;
        HashMap r3 = new HashMap(r2, 1.0f);
        int r4 = 0;
    L5:
        if (r4 >= r2) goto L7;
        r3.put(r0[r4], Integer.valueOf(r4));
        r4 = r4 + 1;
        goto L5
    L7:
        this.mColumnNameMap = r3;
    L8:
        int r1 = r8.lastIndexOf(46);
        if (r1 == (-1)) goto L11;
        Log.e(TAG, "requesting column name with table name -- " + r8, new Object[]{new Exception()});
        r8 = r8.substring(r1 + 1);
    L11:
        Integer r7 = this.mColumnNameMap.get(r8);
        if (r7 != null) goto L14;
        return -1;
    L14:
        return r7.intValue();
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public String[] getColumnNames() {
        return this.mColumns;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public void deactivate() {
        super.deactivate();
        this.mDriver.cursorDeactivated();
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        monitor-enter(this);
        this.mQuery.close();     // Catch: Throwable -> L7
        this.mDriver.cursorClosed();     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public boolean requery() {
        if (isClosed() == false) goto L5;
        return false;
    L5:
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (this.mQuery.getDatabase().isOpen() == true) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L20
        return false;
    L11:
        if (this.mWindow == null) goto L13;
        this.mWindow.clear();     // Catch: Throwable -> L20
    L13:
        this.mPos = -1;     // Catch: Throwable -> L20
        this.mCount = -1;     // Catch: Throwable -> L20
        this.mDriver.cursorRequeried(this);     // Catch: Throwable -> L20
        monitor-exit(this);     // Catch: Throwable -> L20
        return super.requery();
    L17:
        e = move-exception;
        Log.w(TAG, "requery() failed " + e.getMessage(), new Object[]{e});
        return false;
    }

    @Override // com.tencent.wcdb.AbstractWindowedCursor
    public void setWindow(CursorWindow r1) {
        super.setWindow(r1);
        this.mCount = -1;
    }

    public void setSelectionArguments(String[] r1) {
        this.mDriver.setBindArguments(r1);
    }

    @Override // com.tencent.wcdb.AbstractCursor
    protected void finalize() {
    L7:
        th = move-exception;
        super.finalize();
        throw th;
    L3:
        if (this.mWindow == null) goto L5;
        close();     // Catch: Throwable -> L7
    L5:
        super.finalize();
    }

    static {
        FACTORY = new AnonymousClass1();
    }
}
