package com.tencent.wcdb.database;

import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.support.CancellationSignal;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SQLiteProgram extends SQLiteClosable {
    private static final String[] EMPTY_STRING_ARRAY = null;
    private static final String TAG = "WCDB.SQLiteProgram";
    private final Object[] mBindArgs;
    private SQLiteSession mBoundSession;
    private final String[] mColumnNames;
    private final SQLiteDatabase mDatabase;
    private final int mNumParameters;
    protected SQLiteConnection.PreparedStatement mPreparedStatement;
    private final boolean mReadOnly;
    private final String mSql;

    @Deprecated
    public final int getUniqueId() {
        return -1;
    }

    static {
        EMPTY_STRING_ARRAY = new String[0];
    }

    protected SQLiteProgram(SQLiteDatabase r7, String r8, Object[] r9, CancellationSignal r10) {
        this.mDatabase = r7;
        String r11 = r8.trim();
        this.mSql = r11;
        int r0 = DatabaseUtils.getSqlStatementType(r11);
        if (r0 != 4) goto L5;
    L19:
        this.mReadOnly = false;
        this.mColumnNames = EMPTY_STRING_ARRAY;
        this.mNumParameters = 0;
    L20:
        if (r9 != null) goto L22;
    L26:
        int r12 = this.mNumParameters;
        if (r12 == 0) goto L31;
        Object[] r13 = new Object[r12];
        this.mBindArgs = r13;
        if (r9 == null) goto L32;
        System.arraycopy(r9, 0, r13, 0, r9.length);
    L32:
        this.mPreparedStatement = null;
        this.mBoundSession = null;
        return;
    L31:
        this.mBindArgs = null;
        goto L32
    L22:
        if (r9.length <= this.mNumParameters) goto L26;
        throw new IllegalArgumentException("Too many bind arguments.  " + r9.length + " arguments were provided but the statement needs " + this.mNumParameters + " arguments.");
    L5:
        if (r0 == 5) goto L19;
        if (r0 == 6) goto L19;
        boolean r1 = true;
        if (r0 != 1) goto L11;
        boolean r3 = true;
    L12:
        SQLiteStatementInfo r4 = new SQLiteStatementInfo();
        r7.getThreadSession().prepare(r11, r7.getThreadDefaultConnectionFlags(r3), r10, r4);
        if (r0 != 8) goto L15;
    L17:
        r1 = false;
    L18:
        this.mReadOnly = r1;
        this.mColumnNames = r4.columnNames;
        this.mNumParameters = r4.numParameters;
        goto L20
    L15:
        if (r4.readOnly == false) goto L17;
    L11:
        r3 = false;
        goto L12
    }

    public final SQLiteDatabase getDatabase() {
        return this.mDatabase;
    }

    protected final String getSql() {
        return this.mSql;
    }

    protected final Object[] getBindArgs() {
        return this.mBindArgs;
    }

    public final String[] getColumnNames() {
        return this.mColumnNames;
    }

    protected final SQLiteSession getSession() {
        return this.mDatabase.getThreadSession();
    }

    protected final int getConnectionFlags() {
        return this.mDatabase.getThreadDefaultConnectionFlags(this.mReadOnly);
    }

    protected final void checkCorruption(SQLiteException r3) {
        boolean r1 = true;
        if ((r3 instanceof SQLiteDatabaseCorruptException) == false) goto L6;
    L11:
        if (r1 == false) goto L14;
        SQLiteDebug.collectLastIOTraceStats(this.mDatabase);
        this.mDatabase.onCorruption();
        return;
    L14:
        return;
    L6:
        if ((r3 instanceof SQLiteFullException) == true) goto L8;
    L10:
        r1 = false;
        goto L11
    L8:
        if (this.mReadOnly == false) goto L10;
        goto L10
    }

    public void bindNull(int r2) {
        bind(r2, null);
    }

    public void bindLong(int r1, long r2) {
        bind(r1, Long.valueOf(r2));
    }

    public void bindDouble(int r1, double r2) {
        bind(r1, Double.valueOf(r2));
    }

    public void bindString(int r2, String r3) {
        if (r3 == null) goto L6;
        bind(r2, r3);
        return;
    L6:
        throw new IllegalArgumentException("the bind value at index " + r2 + " is null");
    }

    public void bindBlob(int r2, byte[] r3) {
        if (r3 == null) goto L6;
        bind(r2, r3);
        return;
    L6:
        throw new IllegalArgumentException("the bind value at index " + r2 + " is null");
    }

    public void clearBindings() {
        Object[] r1 = this.mBindArgs;
        if (r1 == null) goto L6;
        Arrays.fill(r1, null);
        return;
    }

    public void bindAllArgsAsStrings(String[] r3) {
        if (r3 == null) goto L6;
        int r0 = r3.length;
    L4:
        if (r0 == 0) goto L8;
        bindString(r0, r3[r0 - 1]);
        r0 = r0 - 1;
        goto L4
    L8:
        return;
    }

    public void bindAllArgs(Object[] r3) {
        int r0 = r3.length;
    L3:
        if (r0 == 0) goto L5;
        bind(r0, r3[r0 - 1]);
        r0 = r0 - 1;
        goto L3
    }

    @Override // com.tencent.wcdb.database.SQLiteClosable
    protected void onAllReferencesReleased() {
        releasePreparedStatement();
        clearBindings();
    }

    private void bind(int r3, Object r4) {
        if (r3 < 1) goto L9;
        if (r3 > this.mNumParameters) goto L9;
        this.mBindArgs[r3 - 1] = r4;
        return;
    L9:
        throw new IllegalArgumentException("Cannot bind argument at index " + r3 + " because the index is out of range.  The statement has " + this.mNumParameters + " parameters.");
    }

    protected synchronized boolean acquirePreparedStatement(boolean r5) {
        monitor-enter(this);
        SQLiteSession r0 = this.mDatabase.getThreadSession();     // Catch: Throwable -> L15
        SQLiteSession r1 = this.mBoundSession;     // Catch: Throwable -> L15
        if (r0 != r1) goto L8;
        monitor-exit(this);
        return false;
    L8:
        if (r1 != null) goto L14;
        SQLiteConnection.PreparedStatement r6 = r0.acquirePreparedStatement(this.mSql, this.mDatabase.getThreadDefaultConnectionFlags(this.mReadOnly), r5);     // Catch: Throwable -> L15
        this.mPreparedStatement = r6;     // Catch: Throwable -> L15
        r6.bindArguments(this.mBindArgs);     // Catch: Throwable -> L15
        this.mBoundSession = r0;     // Catch: Throwable -> L15
        monitor-exit(this);
        return true;
    L14:
        throw new IllegalStateException("SQLiteProgram has bound to another thread.");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    protected synchronized void releasePreparedStatement() {
        monitor-enter(this);
        SQLiteSession r0 = this.mBoundSession;     // Catch: Throwable -> L21
        if (r0 == null) goto L6;
    L9:
        if (r0 == null) goto L20;
        if (this.mPreparedStatement == null) goto L20;
        if (r0 != this.mDatabase.getThreadSession()) goto L18;
        this.mBoundSession.releasePreparedStatement(this.mPreparedStatement);     // Catch: Throwable -> L21
        this.mPreparedStatement = null;     // Catch: Throwable -> L21
        this.mBoundSession = null;     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L18:
        throw new IllegalStateException("SQLiteProgram has bound to another thread.");     // Catch: Throwable -> L21
    L20:
        throw new IllegalStateException("Internal state error.");     // Catch: Throwable -> L21
    L6:
        if (this.mPreparedStatement != null) goto L9;
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        throw th;
    }

    protected void finalize() throws Throwable {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.mBoundSession != null) goto L11;
        if (this.mPreparedStatement != null) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L12
        super.finalize();
        return;
    L11:
        throw new SQLiteMisuseException("Acquired prepared statement is not released.");     // Catch: Throwable -> L12
    }
}
