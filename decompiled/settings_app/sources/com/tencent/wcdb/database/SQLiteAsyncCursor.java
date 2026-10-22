package com.tencent.wcdb.database;

import com.tencent.wcdb.AbstractCursor;
import com.tencent.wcdb.CursorIndexOutOfBoundsException;
import com.tencent.wcdb.StaleDataException;

/* JADX INFO: loaded from: classes5.dex */
public class SQLiteAsyncCursor extends AbstractCursor {
    public static final SQLiteDatabase.CursorFactory FACTORY = null;
    private static final int MAX_KEEP_CHUNKS = 32;
    private static final int MAX_PREFETCH = 256;
    private static final int MIN_FETCH_ROWS = 32;
    private static final String TAG = "WCDB.SQLiteAsyncCursor";
    private final String[] mColumns;
    private volatile int mCount;
    private long mCurrentRow;
    private final SQLiteCursorDriver mDriver;
    private final SQLiteAsyncQuery mQuery;
    private QueryThread mQueryThread;
    private final Object mWaitLock;
    private ChunkedCursorWindow mWindow;

    private class QueryThread extends Thread {
        private int mFetchPos;
        private int mMinPos;
        private volatile int mRequestPos;
        final /* synthetic */ SQLiteAsyncCursor this$0;

        QueryThread(SQLiteAsyncCursor r1) {
            this.this$0 = r1;
            super("SQLiteAsyncCursor.QueryThread");
            this.mRequestPos = 0;
            this.mMinPos = 0;
            this.mFetchPos = 0;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int r0 = SQLiteAsyncCursor.access$000(this.this$0).getCount();     // Catch: Throwable -> L45 InterruptedException -> L50
            Object r1 = SQLiteAsyncCursor.access$100(this.this$0);     // Catch: Throwable -> L45 InterruptedException -> L50
            monitor-enter(r1);     // Catch: Throwable -> L45 InterruptedException -> L50
            SQLiteAsyncCursor.access$202(this.this$0, r0);     // Catch: Throwable -> L42
            SQLiteAsyncCursor.access$100(this.this$0).notifyAll();     // Catch: Throwable -> L42
            monitor-exit(r1);     // Catch: Throwable -> L42
        L7:
            if (interrupted() == true) goto L48;
            monitor-enter(this);     // Catch: Throwable -> L45 InterruptedException -> L50
        L53:
            if ((this.mRequestPos + 256) > this.mFetchPos) goto L14;
            if (this.mRequestPos < this.mMinPos) goto L14;
            wait();     // Catch: Throwable -> L39
        L14:
            int r2 = this.mRequestPos;     // Catch: Throwable -> L39
            int r3 = r2 + 256;     // Catch: Throwable -> L39
            monitor-exit(this);     // Catch: Throwable -> L39
            if (r2 >= this.mMinPos) goto L20;
            SQLiteAsyncCursor.access$000(this.this$0).reset();     // Catch: Throwable -> L45 InterruptedException -> L50
            this.mFetchPos = 0;     // Catch: Throwable -> L45 InterruptedException -> L50
            SQLiteAsyncCursor.access$300(this.this$0).clear();     // Catch: Throwable -> L45 InterruptedException -> L50
            this.mMinPos = 0;     // Catch: Throwable -> L45 InterruptedException -> L50
        L20:
            if (this.mFetchPos >= r3) goto L7;
            if (SQLiteAsyncCursor.access$300(this.this$0).getNumChunks() <= 32) goto L26;
            long r4 = SQLiteAsyncCursor.access$300(this.this$0).removeChunk(this.mMinPos);     // Catch: Throwable -> L45 InterruptedException -> L50
            if (r4 == (-1)) goto L26;
            this.mMinPos = (int) r4;     // Catch: Throwable -> L45 InterruptedException -> L50
        L26:
            Object r5 = SQLiteAsyncCursor.access$100(this.this$0);     // Catch: Throwable -> L45 InterruptedException -> L50
            monitor-enter(r5);     // Catch: Throwable -> L45 InterruptedException -> L50
            int r6 = SQLiteAsyncCursor.access$000(this.this$0).fillRows(SQLiteAsyncCursor.access$300(this.this$0), this.mFetchPos, 32);     // Catch: Throwable -> L36
            int r7 = this.mFetchPos;     // Catch: Throwable -> L36
            if (r7 <= r2) goto L31;
        L33:
            monitor-exit(r5);     // Catch: Throwable -> L36
            this.mFetchPos += r6;     // Catch: Throwable -> L45 InterruptedException -> L50
            goto L7
        L31:
            if ((r7 + r6) <= r2) goto L33;
            SQLiteAsyncCursor.access$100(this.this$0).notifyAll();     // Catch: Throwable -> L36
        L36:
            th = move-exception;
            throw th;     // Catch: Throwable -> L45 InterruptedException -> L50
        L39:
            th = move-exception;
            throw th;     // Catch: Throwable -> L45 InterruptedException -> L50
        L42:
            th = move-exception;
            throw th;     // Catch: Throwable -> L45 InterruptedException -> L50
        L45:
            th = move-exception;
            SQLiteAsyncCursor.access$000(this.this$0).release();
            throw th;
        L48:
            SQLiteAsyncCursor.access$000(this.this$0).release();
        }

        void requestPos(int r1) {
            monitor-enter(this);
            this.mRequestPos = r1;     // Catch: Throwable -> L6
            notifyAll();     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        }

        void quit() {
            interrupt();
        }
    }

    static /* synthetic */ SQLiteAsyncQuery access$000(SQLiteAsyncCursor r0) {
        return r0.mQuery;
    }

    static /* synthetic */ Object access$100(SQLiteAsyncCursor r0) {
        return r0.mWaitLock;
    }

    static /* synthetic */ int access$202(SQLiteAsyncCursor r0, int r1) {
        r0.mCount = r1;
        return r1;
    }

    static /* synthetic */ ChunkedCursorWindow access$300(SQLiteAsyncCursor r0) {
        return r0.mWindow;
    }

    public SQLiteAsyncCursor(SQLiteCursorDriver r1, String r2, SQLiteAsyncQuery r3) {
        if (r3 == null) goto L7;
        this.mQuery = r3;
        this.mDriver = r1;
        this.mColumns = r3.getColumnNames();
        this.mCount = -1;
        this.mWaitLock = new Object();
        this.mWindow = new ChunkedCursorWindow(16777216);
        QueryThread r4 = new QueryThread(this);
        this.mQueryThread = r4;
        r4.start();
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

    @Override // com.tencent.wcdb.AbstractCursor
    protected void onDeactivateOrClose() {
        long r0 = this.mCurrentRow;
        if (r0 == 0) goto L5;
        this.mWindow.endRowUnsafe(r0);
        this.mCurrentRow = 0;
    L5:
        QueryThread r1 = this.mQueryThread;
        if (r1 == null) goto L10;
        r1.quit();
        this.mQueryThread.join();     // Catch: InterruptedException -> L15
    L9:
        this.mQueryThread = null;
    L10:
        ChunkedCursorWindow r2 = this.mWindow;
        if (r2 == null) goto L13;
        r2.close();
        this.mWindow = null;
    L13:
        this.mCount = -1;
        this.mPos = -1;
        super.onDeactivateOrClose();
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public String[] getColumnNames() {
        return this.mColumns;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public int getCount() {
        if (this.mCount < 0) goto L7;
        return this.mCount;
    L7:
        if (this.mWindow != null) goto L23;
        return -1;
    L23:
        Object r0 = this.mWaitLock;     // Catch: InterruptedException -> L22
        monitor-enter(r0);     // Catch: InterruptedException -> L22
    L24:
    L17:
        th = move-exception;
        throw th;     // Catch: InterruptedException -> L22
    L13:
        if (this.mCount >= 0) goto L15;
        this.mWaitLock.wait();     // Catch: Throwable -> L17
        goto L24
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L17
    L21:
        return this.mCount;
    }

    private boolean isValidPosition(int r1) {
        if (r1 >= 0) goto L4;
    L6:
        return false;
    L4:
        if (r1 >= getCount()) goto L6;
        return true;
    }

    private long waitForRow(int r7) {
        Object r2 = this.mWaitLock;     // Catch: InterruptedException -> L17
        monitor-enter(r2);     // Catch: InterruptedException -> L17
    L18:
        long r3 = this.mWindow.getRowUnsafe(r7);     // Catch: Throwable -> L14
        if (r3 != 0) goto L12;
        if (isValidPosition(r7) == false) goto L11;
        this.mWaitLock.wait();     // Catch: Throwable -> L14
        goto L18
    L11:
        throw new CursorIndexOutOfBoundsException(this.mPos, this.mCount);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r2);     // Catch: Throwable -> L14
        return r3;
    L14:
        th = move-exception;
        throw th;     // Catch: InterruptedException -> L17
    L17:
        return 0;
    }

    private boolean requestRow() {
        if (this.mWindow != null) goto L6;
        return false;
    L6:
        if (isValidPosition(this.mPos) == true) goto L8;
        return false;
    L8:
        this.mQueryThread.requestPos(this.mPos);
        long r2 = this.mWindow.getRowUnsafe(this.mPos);
        this.mCurrentRow = r2;
        if (r2 != 0) goto L12;
        this.mCurrentRow = waitForRow(this.mPos);
    L12:
        if (this.mCurrentRow == 0) goto L15;
        return true;
    L15:
        return false;
    }

    private void checkValidRow() {
        if (this.mCurrentRow == 0) goto L6;
        return;
    L6:
        if (isValidPosition(this.mPos) == true) goto L10;
        throw new CursorIndexOutOfBoundsException(this.mPos, this.mCount);
    L10:
        throw new StaleDataException("Cannot get valid Row object");
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public boolean moveToPosition(int r4) {
        if (r4 >= (-1)) goto L6;
        r4 = -1;
    L6:
        if (r4 == this.mPos) goto L8;
        this.mWindow.endRowUnsafe(this.mCurrentRow);
        this.mCurrentRow = 0;
    L8:
        int r0 = getCount();
        if (r4 < r0) goto L12;
        this.mPos = r0;
        return false;
    L12:
        this.mPos = r4;
        if (r4 >= 0) goto L15;
        return false;
    L15:
        if (requestRow() == false) goto L19;
        return true;
    L19:
        return false;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public int getType(int r4) {
        checkValidRow();
        return this.mWindow.getTypeUnsafe(this.mCurrentRow, r4);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public byte[] getBlob(int r4) {
        checkValidRow();
        return this.mWindow.getBlobUnsafe(this.mCurrentRow, r4);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public String getString(int r4) {
        checkValidRow();
        return this.mWindow.getStringUnsafe(this.mCurrentRow, r4);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public short getShort(int r1) {
        return (short) getLong(r1);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public int getInt(int r1) {
        return (int) getLong(r1);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public long getLong(int r4) {
        checkValidRow();
        return this.mWindow.getLongUnsafe(this.mCurrentRow, r4);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public float getFloat(int r1) {
        return (float) getDouble(r1);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public double getDouble(int r4) {
        checkValidRow();
        return this.mWindow.getDoubleUnsafe(this.mCurrentRow, r4);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public boolean isNull(int r1) {
        if (getType(r1) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    static {
        FACTORY = new AnonymousClass1();
    }
}
