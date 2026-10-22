package com.tencent.wcdb.database;

import android.database.sqlite.SQLiteTransactionListener;
import android.util.Pair;
import com.tencent.wcdb.CursorWindow;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.support.CancellationSignal;

/* JADX INFO: loaded from: classes5.dex */
public final class SQLiteSession {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int TRANSACTION_MODE_DEFERRED = 0;
    public static final int TRANSACTION_MODE_EXCLUSIVE = 2;
    public static final int TRANSACTION_MODE_IMMEDIATE = 1;
    private SQLiteConnection mConnection;
    private int mConnectionFlags;
    private final SQLiteConnectionPool mConnectionPool;
    private int mConnectionUseCount;
    private Transaction mTransactionPool;
    private Transaction mTransactionStack;

    /* JADX INFO: renamed from: com.tencent.wcdb.database.SQLiteSession$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class Transaction {
        public boolean mChildFailed;
        public SQLiteTransactionListener mListener;
        public boolean mMarkedSuccessful;
        public int mMode;
        public Transaction mParent;

        private Transaction() {
        }

        /* synthetic */ Transaction(AnonymousClass1 r1) {
            this();
        }
    }

    static {
    }

    public SQLiteSession(SQLiteConnectionPool r1) {
        if (r1 == null) goto L7;
        this.mConnectionPool = r1;
        return;
    L7:
        throw new IllegalArgumentException("connectionPool must not be null");
    }

    public boolean hasTransaction() {
        if (this.mTransactionStack == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasNestedTransaction() {
        Transaction r0 = this.mTransactionStack;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.mParent == null) goto L7;
        return true;
    }

    public boolean hasConnection() {
        if (this.mConnection == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void beginTransaction(int r1, SQLiteTransactionListener r2, int r3, CancellationSignal r4) {
        throwIfTransactionMarkedSuccessful();
        beginTransactionUnchecked(r1, r2, r3, r4);
    }

    private void beginTransactionUnchecked(int r4, SQLiteTransactionListener r5, int r6, CancellationSignal r7) {
        if (r7 == null) goto L5;
        r7.throwIfCanceled();
    L5:
        if (this.mTransactionStack != null) goto L32;
        acquireConnection(null, r6, true, r7);
    L32:
    L27:
        th = move-exception;
        if (this.mTransactionStack != null) goto L31;
        releaseConnection();
    L31:
        throw th;
    L8:
        if (this.mTransactionStack != null) goto L15;
        if (r4 != 1) goto L11;
        this.mConnection.execute("BEGIN IMMEDIATE;", null, r7);     // Catch: Throwable -> L27
        goto L15
    L11:
        if (r4 == 2) goto L13;
        this.mConnection.execute("BEGIN;", null, r7);     // Catch: Throwable -> L27
        goto L15
    L13:
        this.mConnection.execute("BEGIN EXCLUSIVE;", null, r7);     // Catch: Throwable -> L27
    L15:
        if (r5 != null) goto L33;
    L23:
        Transaction r8 = obtainTransaction(r4, r5);     // Catch: Throwable -> L27
        r8.mParent = this.mTransactionStack;     // Catch: Throwable -> L27
        this.mTransactionStack = r8;     // Catch: Throwable -> L27
        if (r8 != null) goto L35;
        releaseConnection();
        return;
    L35:
        return;
    L33:
        r5.onBegin();     // Catch: RuntimeException -> L18 Throwable -> L27
    L18:
        e = move-exception;
        if (this.mTransactionStack != null) goto L22;
        this.mConnection.execute("ROLLBACK;", null, r7);     // Catch: Throwable -> L27
    L22:
        throw e;     // Catch: Throwable -> L27
    }

    public void setTransactionSuccessful() {
        throwIfNoTransaction();
        throwIfTransactionMarkedSuccessful();
        this.mTransactionStack.mMarkedSuccessful = true;
    }

    public void endTransaction(CancellationSignal r2) {
        throwIfNoTransaction();
        endTransactionUnchecked(r2, false);
    }

    private void endTransactionUnchecked(CancellationSignal r6, boolean r7) {
        if (r6 == null) goto L4;
        r6.throwIfCanceled();
    L4:
        Transaction r0 = this.mTransactionStack;
        boolean r3 = false;
        if (r0.mMarkedSuccessful == true) goto L8;
        if (r7 == true) goto L8;
    L10:
        boolean r8 = false;
    L11:
        SQLiteTransactionListener r1 = r0.mListener;
        if (r1 != null) goto L37;
    L19:
        r3 = r8;
        e = null;
    L20:
        this.mTransactionStack = r0.mParent;
        recycleTransaction(r0);
        Transaction r2 = this.mTransactionStack;
        if (r2 == null) goto L34;
        if (r3 == true) goto L28;
        r2.mChildFailed = true;
    L28:
        if (e != null) goto L30;
        return;
    L30:
        throw e;
    L34:
        if (r3 == false) goto L26;
        this.mConnection.execute("COMMIT;", null, r6);     // Catch: Throwable -> L31
    L27:
        releaseConnection();
        goto L28
    L26:
        this.mConnection.execute("ROLLBACK;", null, r6);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        releaseConnection();
        throw th;
    L37:
        if (r8 == false) goto L15;
        r1.onCommit();     // Catch: RuntimeException -> L17
    L36:
        goto L19
    L15:
        r1.onRollback();     // Catch: RuntimeException -> L17
    L17:
        e = e;
    L8:
        if (r0.mChildFailed == true) goto L10;
        r8 = true;
        goto L11
    }

    public boolean yieldTransaction(long r2, boolean r4, CancellationSignal r5) {
        if (r4 == false) goto L5;
        throwIfNoTransaction();
        throwIfTransactionMarkedSuccessful();
        throwIfNestedTransaction();
    L13:
        if (this.mTransactionStack.mChildFailed == false) goto L16;
        return false;
    L16:
        return yieldTransactionUnchecked(r2, r5);
    L5:
        Transaction r6 = this.mTransactionStack;
        if (r6 != null) goto L8;
    L17:
        return false;
    L8:
        if (r6.mMarkedSuccessful == true) goto L17;
        if (this.mTransactionStack.mParent == null) goto L13;
        goto L17
    }

    private boolean yieldTransactionUnchecked(long r7, CancellationSignal r9) {
        if (r9 == null) goto L5;
        r9.throwIfCanceled();
    L5:
        if (this.mConnectionPool.shouldYieldConnection(this.mConnection, this.mConnectionFlags) == true) goto L8;
        return false;
    L8:
        int r0 = this.mTransactionStack.mMode;
        SQLiteTransactionListener r1 = this.mTransactionStack.mListener;
        int r2 = this.mConnectionFlags;
        endTransactionUnchecked(r9, true);
        if (r7 > 0) goto L14;
    L11:
        beginTransactionUnchecked(r0, r1, r2, r9);
        return true;
    L14:
        Thread.sleep(r7);     // Catch: InterruptedException -> L13
        goto L11
    }

    public void prepare(String r2, int r3, CancellationSignal r4, SQLiteStatementInfo r5) {
        if (r2 == null) goto L13;
        if (r4 == null) goto L5;
        r4.throwIfCanceled();
    L5:
        acquireConnection(r2, r3, false, r4);
        this.mConnection.prepare(r2, r5);     // Catch: Throwable -> L9
        releaseConnection();
        return;
    L9:
        th = move-exception;
        releaseConnection();
        throw th;
    L13:
        throw new IllegalArgumentException("sql must not be null.");
    }

    public void execute(String r2, Object[] r3, int r4, CancellationSignal r5) {
        if (r2 == null) goto L14;
        if (executeSpecial(r2, r3, r4, r5) == false) goto L6;
        return;
    L6:
        acquireConnection(r2, r4, false, r5);
        this.mConnection.execute(r2, r3, r5);     // Catch: Throwable -> L10
        releaseConnection();
        return;
    L10:
        th = move-exception;
        releaseConnection();
        throw th;
    L14:
        throw new IllegalArgumentException("sql must not be null.");
    }

    public long executeForLong(String r2, Object[] r3, int r4, CancellationSignal r5) {
        if (r2 == null) goto L15;
        if (executeSpecial(r2, r3, r4, r5) == false) goto L7;
        return 0;
    L7:
        acquireConnection(r2, r4, false, r5);
        long r6 = this.mConnection.executeForLong(r2, r3, r5);     // Catch: Throwable -> L11
        releaseConnection();
        return r6;
    L11:
        th = move-exception;
        releaseConnection();
        throw th;
    L15:
        throw new IllegalArgumentException("sql must not be null.");
    }

    public String executeForString(String r2, Object[] r3, int r4, CancellationSignal r5) {
        if (r2 == null) goto L15;
        if (executeSpecial(r2, r3, r4, r5) == false) goto L7;
        return null;
    L7:
        acquireConnection(r2, r4, false, r5);
        String r6 = this.mConnection.executeForString(r2, r3, r5);     // Catch: Throwable -> L11
        releaseConnection();
        return r6;
    L11:
        th = move-exception;
        releaseConnection();
        throw th;
    L15:
        throw new IllegalArgumentException("sql must not be null.");
    }

    public int executeForChangedRowCount(String r3, Object[] r4, int r5, CancellationSignal r6) {
        if (r3 == null) goto L14;
        if (executeSpecial(r3, r4, r5, r6) == false) goto L6;
        return 0;
    L6:
        acquireConnection(r3, r5, false, r6);
        int r7 = this.mConnection.executeForChangedRowCount(r3, r4, r6);     // Catch: Throwable -> L10
        releaseConnection();
        return r7;
    L10:
        th = move-exception;
        releaseConnection();
        throw th;
    L14:
        throw new IllegalArgumentException("sql must not be null.");
    }

    public long executeForLastInsertedRowId(String r2, Object[] r3, int r4, CancellationSignal r5) {
        if (r2 == null) goto L15;
        if (executeSpecial(r2, r3, r4, r5) == false) goto L7;
        return 0;
    L7:
        acquireConnection(r2, r4, false, r5);
        long r6 = this.mConnection.executeForLastInsertedRowId(r2, r3, r5);     // Catch: Throwable -> L11
        releaseConnection();
        return r6;
    L11:
        th = move-exception;
        releaseConnection();
        throw th;
    L15:
        throw new IllegalArgumentException("sql must not be null.");
    }

    public int executeForCursorWindow(String r11, Object[] r12, CursorWindow r13, int r14, int r15, boolean r16, int r17, CancellationSignal r18) {
        if (r11 == null) goto L19;
        if (r13 == null) goto L17;
        if (executeSpecial(r11, r12, r17, r18) == false) goto L9;
        r13.clear();
        return 0;
    L9:
        acquireConnection(r11, r17, false, r18);
        int r0 = this.mConnection.executeForCursorWindow(r11, r12, r13, r14, r15, r16, r18);     // Catch: Throwable -> L13
        releaseConnection();
        return r0;
    L13:
        th = move-exception;
        releaseConnection();
        throw th;
    L17:
        throw new IllegalArgumentException("window must not be null.");
    L19:
        throw new IllegalArgumentException("sql must not be null.");
    }

    public Pair<Integer, Integer> walCheckpoint(String r3, int r4) {
        acquireConnection(null, r4, false, null);
        Pair<Integer, Integer> r5 = this.mConnection.walCheckpoint(r3);     // Catch: Throwable -> L6
        releaseConnection();
        return r5;
    L6:
        th = move-exception;
        releaseConnection();
        throw th;
    }

    private boolean executeSpecial(String r2, Object[] r3, int r4, CancellationSignal r5) {
        if (r5 == null) goto L4;
        r5.throwIfCanceled();
    L4:
        int r6 = DatabaseUtils.getSqlStatementType(r2);
        if (r6 != 4) goto L7;
        beginTransaction(2, null, r4, r5);
        return true;
    L7:
        if (r6 != 5) goto L9;
        setTransactionSuccessful();
        endTransaction(r5);
        return true;
    L9:
        if (r6 == 6) goto L12;
        return false;
    L12:
        endTransaction(r5);
        return true;
    }

    private void acquireConnection(String r3, int r4, boolean r5, CancellationSignal r6) {
        if (this.mConnection != null) goto L5;
        SQLiteConnection r7 = this.mConnectionPool.acquireConnection(r3, r4, r6);
        this.mConnection = r7;
        this.mConnectionFlags = r4;
        r7.setAcquisitionState(true, r5);
    L5:
        this.mConnectionUseCount++;
    }

    private void releaseConnection() {
        int r0 = this.mConnectionUseCount - 1;
        this.mConnectionUseCount = r0;
        if (r0 == 0) goto L11;
        return;
    L11:
        this.mConnection.setAcquisitionState(false, false);     // Catch: Throwable -> L7
        this.mConnectionPool.releaseConnection(this.mConnection);     // Catch: Throwable -> L7
        this.mConnection = null;
        return;
    L7:
        th = move-exception;
        this.mConnection = null;
        throw th;
    }

    SQLiteConnection acquireConnectionForNativeHandle(int r3) {
        acquireConnection(null, r3, true, null);
        return this.mConnection;
    }

    void releaseConnectionForNativeHandle(Exception r2) {
        SQLiteConnection r0 = this.mConnection;
        if (r0 == null) goto L5;
        r0.endNativeHandle(r2);
    L5:
        releaseConnection();
    }

    SQLiteConnection.PreparedStatement acquirePreparedStatement(String r2, int r3, boolean r4) {
        acquireConnection(r2, r3, r4, null);
        return this.mConnection.acquirePreparedStatement(r2);
    }

    void releasePreparedStatement(SQLiteConnection.PreparedStatement r2) {
        SQLiteConnection r0 = this.mConnection;
        if (r0 == null) goto L6;
        r0.releasePreparedStatement(r2);
        releaseConnection();
        return;
    }

    private void throwIfNoTransaction() {
        if (this.mTransactionStack == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("Cannot perform this operation because there is no current transaction.");
    }

    private void throwIfTransactionMarkedSuccessful() {
        Transaction r1 = this.mTransactionStack;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.mMarkedSuccessful == true) goto L8;
        return;
    L8:
        throw new IllegalStateException("Cannot perform this operation because the transaction has already been marked successful.  The only thing you can do now is call endTransaction().");
    }

    private void throwIfNestedTransaction() {
        if (hasNestedTransaction() == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("Cannot perform this operation because a nested transaction is in progress.");
    }

    private Transaction obtainTransaction(int r4, SQLiteTransactionListener r5) {
        Transaction r0 = this.mTransactionPool;
        AnonymousClass1 r1 = null;
        if (r0 == null) goto L5;
        this.mTransactionPool = r0.mParent;
        r0.mParent = null;
        r0.mMarkedSuccessful = false;
        r0.mChildFailed = false;
    L6:
        r0.mMode = r4;
        r0.mListener = r5;
        return r0;
    L5:
        r0 = new Transaction(r1);
        goto L6
    }

    private void recycleTransaction(Transaction r2) {
        r2.mParent = this.mTransactionPool;
        r2.mListener = null;
        this.mTransactionPool = r2;
    }
}
