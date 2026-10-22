package com.tencent.wcdb.database;

import android.content.Context;
import com.tencent.wcdb.DatabaseErrorHandler;
import com.tencent.wcdb.support.Log;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SQLiteOpenHelper {
    private static final boolean DEBUG_STRICT_READONLY = false;
    private static final String TAG = "WCDB.SQLiteOpenHelper";
    private SQLiteCipherSpec mCipher;
    private final Context mContext;
    private SQLiteDatabase mDatabase;
    private boolean mEnableWriteAheadLogging;
    private final DatabaseErrorHandler mErrorHandler;
    private final SQLiteDatabase.CursorFactory mFactory;
    private boolean mForcedSingleConnection;
    private boolean mIsInitializing;
    private int mMode;
    private final String mName;
    private boolean mNeedMode;
    private final int mNewVersion;
    private byte[] mPassword;

    public void onConfigure(SQLiteDatabase r1) {
    }

    public abstract void onCreate(SQLiteDatabase r1);

    public void onOpen(SQLiteDatabase r1) {
    }

    public abstract void onUpgrade(SQLiteDatabase r1, int r2, int r3);

    static {
        SQLiteGlobal.loadLib();
    }

    public SQLiteOpenHelper(Context r7, String r8, SQLiteDatabase.CursorFactory r9, int r10) {
        this(r7, r8, r9, r10, null);
    }

    public SQLiteOpenHelper(Context r2, String r3, byte[] r4, SQLiteCipherSpec r5, SQLiteDatabase.CursorFactory r6, int r7, DatabaseErrorHandler r8) {
        if (r7 < 1) goto L11;
        this.mContext = r2;
        this.mName = r3;
        this.mFactory = r6;
        this.mNewVersion = r7;
        this.mErrorHandler = r8;
        this.mPassword = r4;
        if (r5 != null) goto L7;
        SQLiteCipherSpec r9 = null;
    L8:
        this.mCipher = r9;
        this.mNeedMode = false;
        return;
    L7:
        r9 = new SQLiteCipherSpec(r5);
        goto L8
    L11:
        throw new IllegalArgumentException("Version must be >= 1, was " + r7);
    }

    public SQLiteOpenHelper(Context r9, String r10, byte[] r11, SQLiteDatabase.CursorFactory r12, int r13, DatabaseErrorHandler r14) {
        this(r9, r10, r11, null, r12, r13, r14);
    }

    public SQLiteOpenHelper(Context r9, String r10, SQLiteDatabase.CursorFactory r11, int r12, DatabaseErrorHandler r13) {
        this(r9, r10, null, null, r11, r12, r13);
    }

    public String getDatabaseName() {
        return this.mName;
    }

    public void setWriteAheadLoggingEnabled(boolean r2) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.mEnableWriteAheadLogging == r2) goto L15;
        SQLiteDatabase r0 = this.mDatabase;     // Catch: Throwable -> L17
        if (r0 != null) goto L8;
    L14:
        this.mEnableWriteAheadLogging = r2;     // Catch: Throwable -> L17
        goto L15
    L8:
        if (r0.isOpen() == false) goto L14;
        if (this.mDatabase.isReadOnly() == true) goto L14;
        if (r2 == false) goto L13;
        this.mDatabase.enableWriteAheadLogging();     // Catch: Throwable -> L17
        goto L14
    L13:
        this.mDatabase.disableWriteAheadLogging();     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);     // Catch: Throwable -> L17
    }

    public void setForcedSingleConnection(boolean r1) {
        monitor-enter(this);
        this.mForcedSingleConnection = r1;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public SQLiteDatabase getWritableDatabase() {
        monitor-enter(this);
        SQLiteDatabase r0 = getDatabaseLocked(true);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public SQLiteDatabase getReadableDatabase() {
        monitor-enter(this);
        SQLiteDatabase r0 = getDatabaseLocked(false);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    private SQLiteDatabase getDatabaseLocked(boolean r14) {
        SQLiteDatabase r1 = this.mDatabase;
        if (r1 == null) goto L13;
        if (r1.isOpen() == true) goto L7;
        this.mDatabase = null;
        goto L13
    L7:
        if (r14 == false) goto L11;
        if (this.mDatabase.isReadOnly() == true) goto L13;
    L11:
        return this.mDatabase;
    L13:
        if (this.mIsInitializing == true) goto L51;
        SQLiteDatabase r2 = this.mDatabase;
        this.mIsInitializing = true;     // Catch: Throwable -> L43
        if (r2 == null) goto L21;
        if (r14 == true) goto L19;
    L35:
        SQLiteDatabase r15 = getDatabaseLockedLast(r2);     // Catch: Throwable -> L43
        this.mIsInitializing = false;
        if (r2 != null) goto L39;
    L41:
        return r15;
    L39:
        if (r2 == this.mDatabase) goto L41;
        r2.close();
        goto L41
    L19:
        if (r2.isReadOnly() == false) goto L35;
        r2.reopenReadWrite();     // Catch: Throwable -> L43
        goto L35
    L21:
        String r6 = this.mName;     // Catch: Throwable -> L43
        if (r6 != null) goto L25;
        SQLiteDatabase r16 = SQLiteDatabase.create(null);     // Catch: Throwable -> L43
    L24:
        r2 = r16;
        goto L35
    L25:
        boolean r12 = this.mForcedSingleConnection;     // Catch: Throwable -> L43
        this.mNeedMode = true;     // Catch: SQLiteException -> L32 Throwable -> L43
        if (this.mEnableWriteAheadLogging == false) goto L29;
        int r9 = 8;
    L30:
        this.mMode = r9;     // Catch: SQLiteException -> L32 Throwable -> L43
        r16 = com.tencent.wcdb.support.Context.openOrCreateDatabase(this.mContext, r6, this.mPassword, this.mCipher, r9, this.mFactory, this.mErrorHandler, r12 ? 1 : 0);     // Catch: SQLiteException -> L32 Throwable -> L43
    L29:
        r9 = 0;
    L32:
        e = move-exception;
        if (r14 == true) goto L42;
        Log.e(TAG, "Couldn't open " + this.mName + " for writing (will try read-only):", new Object[]{e});     // Catch: Throwable -> L43
        r16 = SQLiteDatabase.openDatabase(this.mContext.getDatabasePath(this.mName).getPath(), this.mPassword, this.mCipher, this.mFactory, 1, this.mErrorHandler);     // Catch: Throwable -> L43
        goto L24
    L42:
        throw e;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        this.mIsInitializing = false;
        if (r2 != null) goto L47;
    L49:
        throw th;
    L47:
        if (r2 == this.mDatabase) goto L49;
        r2.close();
        goto L49
    L51:
        throw new IllegalStateException("getDatabase called recursively");
    }

    private SQLiteDatabase getDatabaseLockedLast(SQLiteDatabase r4) {
        onConfigure(r4);
        int r0 = r4.getVersion();
        if (r0 != this.mNewVersion) goto L5;
    L20:
        onOpen(r4);
        if (r4.isReadOnly() == false) goto L23;
        Log.w(TAG, "Opened " + this.mName + " in read-only mode");
    L23:
        this.mDatabase = r4;
        return r4;
    L5:
        if (r4.isReadOnly() == true) goto L19;
        r4.beginTransaction();
        if (r0 != 0) goto L9;
        onCreate(r4);     // Catch: Throwable -> L15
    L13:
        r4.setVersion(this.mNewVersion);     // Catch: Throwable -> L15
        r4.setTransactionSuccessful();     // Catch: Throwable -> L15
        r4.endTransaction();
        goto L20
    L9:
        int r1 = this.mNewVersion;     // Catch: Throwable -> L15
        if (r0 <= r1) goto L12;
        onDowngrade(r4, r0, r1);     // Catch: Throwable -> L15
        goto L13
    L12:
        onUpgrade(r4, r0, r1);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r4.endTransaction();
        throw th;
    L19:
        throw new SQLiteException("Can't upgrade read-only database from version " + r4.getVersion() + " to " + this.mNewVersion + ": " + this.mName);
    }

    public synchronized void close() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsInitializing == true) goto L13;
        SQLiteDatabase r0 = this.mDatabase;     // Catch: Throwable -> L14
        if (r0 != null) goto L8;
    L10:
        monitor-exit(this);
        return;
    L8:
        if (r0.isOpen() == false) goto L10;
        this.mDatabase.close();     // Catch: Throwable -> L14
        this.mDatabase = null;     // Catch: Throwable -> L14
        goto L10
    L13:
        throw new IllegalStateException("Closed during initialization");     // Catch: Throwable -> L14
    }

    public void onDowngrade(SQLiteDatabase r2, int r3, int r4) {
        throw new SQLiteException("Can't downgrade database from version " + r3 + " to " + r4);
    }
}
