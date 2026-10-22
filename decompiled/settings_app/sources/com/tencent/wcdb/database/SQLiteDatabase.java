package com.tencent.wcdb.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Printer;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.DatabaseErrorHandler;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.DefaultDatabaseErrorHandler;
import com.tencent.wcdb.SQLException;
import com.tencent.wcdb.extension.SQLiteExtension;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class SQLiteDatabase extends SQLiteClosable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CONFLICT_ABORT = 2;
    public static final int CONFLICT_FAIL = 3;
    public static final int CONFLICT_IGNORE = 4;
    public static final int CONFLICT_NONE = 0;
    public static final int CONFLICT_REPLACE = 5;
    public static final int CONFLICT_ROLLBACK = 1;
    private static final String[] CONFLICT_VALUES = null;
    public static final int CREATE_IF_NECESSARY = 268435456;
    public static final int ENABLE_IO_TRACE = 256;
    public static final int ENABLE_WRITE_AHEAD_LOGGING = 536870912;
    public static final int MAX_SQL_CACHE_SIZE = 100;
    public static final int NO_LOCALIZED_COLLATORS = 16;
    public static final int OPEN_READONLY = 1;
    public static final int OPEN_READWRITE = 0;
    private static final int OPEN_READ_MASK = 1;
    public static final int SQLITE_MAX_LIKE_PATTERN_LENGTH = 50000;
    public static final int SYNCHRONOUS_EXTRA = 3;
    public static final int SYNCHRONOUS_FULL = 2;
    public static final int SYNCHRONOUS_NORMAL = 1;
    public static final int SYNCHRONOUS_OFF = 0;
    private static final String TAG = "WCDB.SQLiteDatabase";
    private static final WeakHashMap<SQLiteDatabase, Object> sActiveDatabases = null;
    private final SQLiteDatabaseConfiguration mConfigurationLocked;
    private SQLiteConnectionPool mConnectionPoolLocked;
    private final CursorFactory mCursorFactory;
    private final DatabaseErrorHandler mErrorHandler;
    private boolean mHasAttachedDbsLocked;
    private final Object mLock;
    private final ThreadLocal<SQLiteSession> mThreadSession;

    public interface CursorFactory {
        Cursor newCursor(SQLiteDatabase r1, SQLiteCursorDriver r2, String r3, SQLiteProgram r4);

        SQLiteProgram newQuery(SQLiteDatabase r1, String r2, Object[] r3, CancellationSignal r4);
    }

    public interface CustomFunction {
        void callback(String[] r1);
    }

    @Deprecated
    public boolean isDbLockedByOtherThreads() {
        return false;
    }

    @Deprecated
    public void markTableSyncable(String r1, String r2) {
    }

    @Deprecated
    public void markTableSyncable(String r1, String r2, String r3) {
    }

    @Deprecated
    public void setLockingEnabled(boolean r1) {
    }

    static {
        SQLiteGlobal.loadLib();
        sActiveDatabases = new WeakHashMap();
        CONFLICT_VALUES = new String[]{"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    }

    private SQLiteDatabase(String r2, int r3, CursorFactory r4, DatabaseErrorHandler r5) {
        this.mThreadSession = new AnonymousClass1(this);
        this.mLock = new Object();
        this.mCursorFactory = r4;
        if (r5 != null) goto L6;
        r5 = new DefaultDatabaseErrorHandler(true);
    L6:
        this.mErrorHandler = r5;
        this.mConfigurationLocked = new SQLiteDatabaseConfiguration(r2, r3);
    }

    protected void finalize() throws Throwable {
        dispose(true);     // Catch: Throwable -> L6
        super.finalize();
        return;
    L6:
        th = move-exception;
        super.finalize();
        throw th;
    }

    @Override // com.tencent.wcdb.database.SQLiteClosable
    protected void onAllReferencesReleased() {
        dispose(false);
    }

    private void dispose(boolean r4) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        SQLiteConnectionPool r1 = this.mConnectionPoolLocked;     // Catch: Throwable -> L17
        this.mConnectionPoolLocked = null;     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        if (r4 == true) goto L16;
        WeakHashMap<SQLiteDatabase, Object> r5 = sActiveDatabases;
        monitor-enter(r5);
        r5.remove(this);     // Catch: Throwable -> L13
        monitor-exit(r5);     // Catch: Throwable -> L13
        if (r1 == null) goto L24;
        r1.close();
        return;
    L24:
        return;
    L13:
        th = move-exception;
        throw th;
    L16:
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public static int releaseMemory() {
        return SQLiteGlobal.releaseMemory();
    }

    String getLabel() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String r1 = this.mConfigurationLocked.label;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void onCorruption() {
        this.mErrorHandler.onCorruption(this);
    }

    SQLiteSession getThreadSession() {
        return this.mThreadSession.get();
    }

    SQLiteSession createSession() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfNotOpenLocked();     // Catch: Throwable -> L8
        SQLiteConnectionPool r1 = this.mConnectionPoolLocked;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return new SQLiteSession(r1);
    L8:
        th = move-exception;
        throw th;
    }

    int getThreadDefaultConnectionFlags(boolean r1) {
        if (r1 == false) goto L4;
        int r0 = 1;
    L6:
        if (isMainThread() == true) goto L8;
        return r0;
    L8:
        return r0 | 4;
    L4:
        r0 = 2;
        goto L6
    }

    private static boolean isMainThread() {
        Looper r0 = Looper.myLooper();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0 != Looper.getMainLooper()) goto L7;
        return true;
    }

    public void beginTransaction() {
        beginTransaction(null, true);
    }

    public void beginTransactionNonExclusive() {
        beginTransaction(null, false);
    }

    public void beginTransactionWithListener(SQLiteTransactionListener r2) {
        beginTransaction(r2, true);
    }

    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener r2) {
        beginTransaction(r2, false);
    }

    private void beginTransaction(SQLiteTransactionListener r4, boolean r5) {
        acquireReference();
        SQLiteSession r0 = getThreadSession();     // Catch: Throwable -> L10
        if (r5 == false) goto L6;
        int r6 = 2;
    L7:
        r0.beginTransaction(r6, r4, getThreadDefaultConnectionFlags(false), null);     // Catch: Throwable -> L10
        releaseReference();
        return;
    L6:
        r6 = 1;
    L10:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public void endTransaction() {
        acquireReference();
        getThreadSession().endTransaction(null);     // Catch: Throwable -> L6
        releaseReference();
        return;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public void setTransactionSuccessful() {
        acquireReference();
        getThreadSession().setTransactionSuccessful();     // Catch: Throwable -> L6
        releaseReference();
        return;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public boolean inTransaction() {
        acquireReference();
        boolean r0 = getThreadSession().hasTransaction();     // Catch: Throwable -> L6
        releaseReference();
        return r0;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public boolean isDbLockedByCurrentThread() {
        acquireReference();
        boolean r0 = getThreadSession().hasConnection();     // Catch: Throwable -> L6
        releaseReference();
        return r0;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Deprecated
    public boolean yieldIfContended() {
        return yieldIfContendedHelper(false, -1);
    }

    public boolean yieldIfContendedSafely() {
        return yieldIfContendedHelper(true, -1);
    }

    public boolean yieldIfContendedSafely(long r2) {
        return yieldIfContendedHelper(true, r2);
    }

    private boolean yieldIfContendedHelper(boolean r3, long r4) {
        acquireReference();
        boolean r5 = getThreadSession().yieldTransaction(r4, r3, null);     // Catch: Throwable -> L6
        releaseReference();
        return r5;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Deprecated
    public Map<String, String> getSyncedTables() {
        return new HashMap(0);
    }

    public static SQLiteDatabase openDatabase(String r1, CursorFactory r2, int r3) {
        return openDatabase(r1, r2, r3, null);
    }

    public static SQLiteDatabase openDatabase(String r1, byte[] r2, SQLiteCipherSpec r3, CursorFactory r4, int r5, DatabaseErrorHandler r6, int r7) {
        SQLiteDatabase r0 = new SQLiteDatabase(r1, r5, r4, r6);
        r0.open(r2, r3, r7);
        return r0;
    }

    public static SQLiteDatabase openDatabase(String r7, byte[] r8, SQLiteCipherSpec r9, CursorFactory r10, int r11, DatabaseErrorHandler r12) {
        return openDatabase(r7, r8, r9, r10, r11, r12, 0);
    }

    public static SQLiteDatabase openDatabase(String r7, CursorFactory r8, int r9, DatabaseErrorHandler r10) {
        return openDatabase(r7, null, null, r8, r9, r10, 0);
    }

    public static SQLiteDatabase openDatabase(String r7, CursorFactory r8, int r9, DatabaseErrorHandler r10, int r11) {
        return openDatabase(r7, null, null, r8, r9, r10, r11);
    }

    public static SQLiteDatabase openOrCreateDatabase(File r0, CursorFactory r1) {
        return openOrCreateDatabase(r0.getPath(), r1);
    }

    public static SQLiteDatabase openOrCreateDatabase(File r6, byte[] r7, SQLiteCipherSpec r8, CursorFactory r9, DatabaseErrorHandler r10) {
        return openOrCreateDatabase(r6.getPath(), r7, r8, r9, r10, 0);
    }

    public static SQLiteDatabase openOrCreateDatabase(File r6, byte[] r7, SQLiteCipherSpec r8, CursorFactory r9, DatabaseErrorHandler r10, int r11) {
        return openOrCreateDatabase(r6.getPath(), r7, r8, r9, r10, r11);
    }

    public static SQLiteDatabase openOrCreateDatabase(File r6, byte[] r7, CursorFactory r8, DatabaseErrorHandler r9) {
        return openOrCreateDatabase(r6.getPath(), r7, null, r8, r9, 0);
    }

    public static SQLiteDatabase openOrCreateDatabase(File r6, byte[] r7, CursorFactory r8, DatabaseErrorHandler r9, int r10) {
        return openOrCreateDatabase(r6.getPath(), r7, null, r8, r9, r10);
    }

    public static SQLiteDatabase openOrCreateDatabase(String r7, CursorFactory r8, int r9) {
        return openDatabase(r7, null, null, r8, 268435456, null, r9);
    }

    public static SQLiteDatabase openOrCreateDatabaseInWalMode(String r7, CursorFactory r8) {
        return openDatabase(r7, null, null, r8, 805306368, null, 0);
    }

    public static SQLiteDatabase openOrCreateDatabaseInWalMode(String r7, CursorFactory r8, int r9) {
        return openDatabase(r7, null, null, r8, 805306368, null, r9);
    }

    public static SQLiteDatabase openOrCreateDatabase(String r7, CursorFactory r8) {
        return openDatabase(r7, null, null, r8, 268435456, null, 0);
    }

    public static SQLiteDatabase openOrCreateDatabase(String r7, CursorFactory r8, boolean r9) {
        if (r9 == false) goto L4;
        int r10 = 805306368;
    L6:
        return openDatabase(r7, null, null, r8, r10, null, 0);
    L4:
        r10 = 268435456;
        goto L6
    }

    public static SQLiteDatabase openOrCreateDatabase(String r7, byte[] r8, SQLiteCipherSpec r9, CursorFactory r10, DatabaseErrorHandler r11, int r12) {
        return openDatabase(r7, r8, r9, r10, 268435456, r11, r12);
    }

    public static SQLiteDatabase openOrCreateDatabaseInWalMode(String r7, byte[] r8, SQLiteCipherSpec r9, CursorFactory r10, DatabaseErrorHandler r11, int r12) {
        return openDatabase(r7, r8, r9, r10, 805306368, r11, r12);
    }

    public static SQLiteDatabase openOrCreateDatabaseInWalMode(String r7, byte[] r8, SQLiteCipherSpec r9, CursorFactory r10) {
        return openDatabase(r7, r8, r9, r10, 805306368, null, 0);
    }

    public static SQLiteDatabase openOrCreateMemoryDatabaseInWalMode(CursorFactory r7) {
        return openDatabase(SQLiteDatabaseConfiguration.MEMORY_DB_PATH, null, null, r7, 805306368, null, 0);
    }

    public static SQLiteDatabase openOrCreateDatabase(String r6, byte[] r7, CursorFactory r8, DatabaseErrorHandler r9, int r10) {
        return openOrCreateDatabase(r6, r7, null, r8, r9, r10);
    }

    public static SQLiteDatabase openOrCreateDatabase(String r6, byte[] r7, CursorFactory r8, DatabaseErrorHandler r9) {
        return openOrCreateDatabase(r6, r7, null, r8, r9, 0);
    }

    public static SQLiteDatabase openOrCreateDatabase(String r1, CursorFactory r2, DatabaseErrorHandler r3) {
        return openDatabase(r1, r2, 268435456, r3);
    }

    public static boolean deleteDatabase(File r4) {
        if (r4 == null) goto L12;
        boolean r0 = ((r4.delete() | new File(r4.getPath() + "-journal").delete()) | new File(r4.getPath() + "-shm").delete()) | new File(r4.getPath() + "-wal").delete();
        File r1 = r4.getParentFile();
        if (r1 == null) goto L10;
        final String r5 = r4.getName() + "-mj";
        File[] r6 = r1.listFiles(new AnonymousClass2(r5));
        if (r6 == null) goto L10;
        int r2 = r6.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L10;
        r0 = r0 | r6[r3].delete();
        r3 = r3 + 1;
    L10:
        return r0;
    L12:
        throw new IllegalArgumentException("file must not be null");
    }

    public void reopenReadWrite() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfNotOpenLocked();     // Catch: Throwable -> L15
        if (isReadOnlyLocked() == true) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L8:
        int r1 = this.mConfigurationLocked.openFlags;     // Catch: Throwable -> L15
        SQLiteDatabaseConfiguration r2 = this.mConfigurationLocked;     // Catch: Throwable -> L15
        r2.openFlags = (r2.openFlags & (-2)) | 0;     // Catch: Throwable -> L15
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);     // Catch: RuntimeException -> L12 Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L12:
        e = move-exception;
        this.mConfigurationLocked.openFlags = r1;     // Catch: Throwable -> L15
        throw e;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    private void open(byte[] r2, SQLiteCipherSpec r3, int r4) {
        openInner(r2, r3, r4);     // Catch: SQLiteException -> L4 SQLiteDatabaseCorruptException -> L6
    L10:
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "Failed to open database '" + getLabel() + "'.", new Object[]{e});
        close();
        throw e;
    L6:
        onCorruption();     // Catch: SQLiteException -> L4
        openInner(r2, r3, r4);     // Catch: SQLiteException -> L4
        goto L10
    }

    private void openInner(byte[] r3, SQLiteCipherSpec r4, int r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mConnectionPoolLocked = SQLiteConnectionPool.open(this, this.mConfigurationLocked, r3, r4, r5);     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        WeakHashMap<SQLiteDatabase, Object> r6 = sActiveDatabases;
        monitor-enter(r6);
        r6.put(this, null);     // Catch: Throwable -> L12
        monitor-exit(r6);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L17:
        th = move-exception;
        throw th;
    }

    public static SQLiteDatabase create(CursorFactory r2) {
        return openDatabase(SQLiteDatabaseConfiguration.MEMORY_DB_PATH, r2, 268435456);
    }

    public void addExtension(SQLiteExtension r4) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfNotOpenLocked();     // Catch: Throwable -> L13
        if (this.mConfigurationLocked.extensions.add(r4) == true) goto L16;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L16:
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);     // Catch: RuntimeException -> L8 Throwable -> L13
    L8:
        e = move-exception;
        this.mConfigurationLocked.extensions.remove(r4);     // Catch: Throwable -> L13
        throw e;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public int getVersion() {
        return Long.valueOf(DatabaseUtils.longForQuery(this, "PRAGMA user_version;", null)).intValue();
    }

    public void setVersion(int r3) {
        execSQL("PRAGMA user_version = " + r3);
    }

    public long getMaximumSize() {
        return DatabaseUtils.longForQuery(this, "PRAGMA max_page_count;", null) * getPageSize();
    }

    public long setMaximumSize(long r7) {
        long r0 = getPageSize();
        long r2 = r7 / r0;
        if ((r7 % r0) == 0) goto L6;
        r2 = r2 + 1;
    L6:
        return DatabaseUtils.longForQuery(this, "PRAGMA max_page_count = " + r2, null) * r0;
    }

    public long getPageSize() {
        return DatabaseUtils.longForQuery(this, "PRAGMA page_size;", null);
    }

    public void setPageSize(long r3) {
        execSQL("PRAGMA page_size = " + r3);
    }

    public static String findEditTable(String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L16;
        int r0 = r3.indexOf(32);
        int r1 = r3.indexOf(44);
        if (r0 <= 0) goto L10;
        if (r0 < r1) goto L9;
        if (r1 >= 0) goto L10;
    L9:
        return r3.substring(0, r0);
    L10:
        if (r1 <= 0) goto L17;
        if (r1 < r0) goto L14;
        if (r0 < 0) goto L14;
        return r3;
    L14:
        return r3.substring(0, r1);
    L17:
        return r3;
    L16:
        throw new IllegalStateException("Invalid tables");
    }

    public SQLiteStatement compileStatement(String r3) throws SQLException {
        acquireReference();
        SQLiteStatement r0 = new SQLiteStatement(this, r3, null);     // Catch: Throwable -> L6
        releaseReference();
        return r0;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public Cursor query(boolean r13, String r14, String[] r15, String r16, Object[] r17, String r18, String r19, String r20, String r21) {
        return queryWithFactory(null, r13, r14, r15, r16, r17, r18, r19, r20, r21, null);
    }

    public Cursor query(boolean r13, String r14, String[] r15, String r16, Object[] r17, String r18, String r19, String r20, String r21, CancellationSignal r22) {
        return queryWithFactory(null, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public Cursor queryWithFactory(CursorFactory r13, boolean r14, String r15, String[] r16, String r17, Object[] r18, String r19, String r20, String r21, String r22) {
        return queryWithFactory(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, null);
    }

    public Cursor queryWithFactory(CursorFactory r10, boolean r11, String r12, String[] r13, String r14, Object[] r15, String r16, String r17, String r18, String r19, CancellationSignal r20) {
        acquireReference();
        Cursor r0 = rawQueryWithFactory(r10, SQLiteQueryBuilder.buildQueryString(r11, r12, r13, r14, r16, r17, r18, r19), r15, findEditTable(r12), r20);     // Catch: Throwable -> L6
        releaseReference();
        return r0;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public Cursor query(String r11, String[] r12, String r13, Object[] r14, String r15, String r16, String r17) {
        return query(false, r11, r12, r13, r14, r15, r16, r17, null);
    }

    public Cursor query(String r11, String[] r12, String r13, Object[] r14, String r15, String r16, String r17, String r18) {
        return query(false, r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public Cursor rawQuery(String r7, Object[] r8) {
        return rawQueryWithFactory(null, r7, r8, null, null);
    }

    public Cursor rawQuery(String r7, Object[] r8, CancellationSignal r9) {
        return rawQueryWithFactory(null, r7, r8, null, r9);
    }

    public Cursor rawQueryWithFactory(CursorFactory r7, String r8, Object[] r9, String r10) {
        return rawQueryWithFactory(r7, r8, r9, r10, null);
    }

    public Cursor rawQueryWithFactory(CursorFactory r2, String r3, Object[] r4, String r5, CancellationSignal r6) {
        acquireReference();
        SQLiteDirectCursorDriver r0 = new SQLiteDirectCursorDriver(this, r3, r5, r6);     // Catch: Throwable -> L10
        if (r2 != null) goto L7;
        r2 = this.mCursorFactory;     // Catch: Throwable -> L10
    L7:
        Cursor r7 = r0.query(r2, r4);     // Catch: Throwable -> L10
        releaseReference();
        return r7;
    L10:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public long insert(String r2, String r3, ContentValues r4) {
        return insertWithOnConflict(r2, r3, r4, 0);
    L8:
        e = move-exception;
        throw e;
    L5:
        e = move-exception;
        Log.e(TAG, "Error inserting %s: %s", new Object[]{r4, e});
        return -1;
    }

    public long insertOrThrow(String r2, String r3, ContentValues r4) throws SQLException {
        return insertWithOnConflict(r2, r3, r4, 0);
    }

    public long replace(String r2, String r3, ContentValues r4) {
        return insertWithOnConflict(r2, r3, r4, 5);
    L8:
        e = move-exception;
        throw e;
    L5:
        e = move-exception;
        Log.e(TAG, "Error inserting " + r4, new Object[]{e});
        return -1;
    }

    public long replaceOrThrow(String r2, String r3, ContentValues r4) throws SQLException {
        return insertWithOnConflict(r2, r3, r4, 5);
    }

    private Set<String> keySet(ContentValues r1) {
        return r1.keySet();
    }

    public long insertWithOnConflict(String r7, String r8, ContentValues r9, int r10) {
        acquireReference();
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L34
        r0.append("INSERT");     // Catch: Throwable -> L34
        r0.append(CONFLICT_VALUES[r10]);     // Catch: Throwable -> L34
        r0.append(" INTO ");     // Catch: Throwable -> L34
        r0.append(r7);     // Catch: Throwable -> L34
        r0.append('(');     // Catch: Throwable -> L34
        int r11 = 0;
        if (r9 != null) goto L6;
    L8:
        int r12 = 0;
    L10:
        if (r12 <= 0) goto L25;
        Object[] r13 = new Object[r12];     // Catch: Throwable -> L34
        Iterator<String> r2 = keySet(r9).iterator();     // Catch: Throwable -> L34
        int r3 = 0;
    L13:
        if (r2.hasNext() == false) goto L19;
        String r4 = r2.next();     // Catch: Throwable -> L34
        if (r3 <= 0) goto L17;
        String r5 = ",";
    L18:
        r0.append(r5);     // Catch: Throwable -> L34
        r0.append(r4);     // Catch: Throwable -> L34
        r13[r3] = r9.get(r4);     // Catch: Throwable -> L34
        r3 = r3 + 1;     // Catch: Throwable -> L34
        goto L13
    L17:
        r5 = "";
        goto L18
    L19:
        r0.append(')');     // Catch: Throwable -> L34
        r0.append(" VALUES (");     // Catch: Throwable -> L34
    L20:
        if (r11 >= r12) goto L26;
        if (r11 <= 0) goto L23;
        String r14 = ",?";
    L24:
        r0.append(r14);     // Catch: Throwable -> L34
        r11 = r11 + 1;     // Catch: Throwable -> L34
        goto L20
    L23:
        r14 = "?";
    L26:
        r0.append(')');     // Catch: Throwable -> L34
        SQLiteStatement r15 = new SQLiteStatement(this, r0.toString(), r13);     // Catch: Throwable -> L34
        long r16 = r15.executeInsert();     // Catch: Throwable -> L31
        r15.close();     // Catch: Throwable -> L34
        releaseReference();
        return r16;
    L31:
        th = move-exception;
        r15.close();     // Catch: Throwable -> L34
        throw th;     // Catch: Throwable -> L34
    L25:
        r0.append(r8 + ") VALUES (NULL");     // Catch: Throwable -> L34
        r13 = null;
        goto L26
    L6:
        if (r9.size() <= 0) goto L8;
        r12 = r9.size();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public int delete(String r5, String r6, String[] r7) {
        acquireReference();
        StringBuilder r8 = new StringBuilder("DELETE FROM ").append(r5);     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r6) == true) goto L6;
        String r9 = " WHERE " + r6;     // Catch: Throwable -> L15
    L7:
        SQLiteStatement r2 = new SQLiteStatement(this, r8.append(r9).toString(), r7);     // Catch: Throwable -> L15
        int r10 = r2.executeUpdateDelete();     // Catch: Throwable -> L12
        r2.close();     // Catch: Throwable -> L15
        releaseReference();
        return r10;
    L12:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L6:
        r9 = "";
    L15:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public int update(String r7, ContentValues r8, String r9, String[] r10) {
        return updateWithOnConflict(r7, r8, r9, r10, 0);
    }

    public int updateWithOnConflict(String r7, ContentValues r8, String r9, String[] r10, int r11) {
        if (r8 == null) goto L37;
        if (r8.size() == 0) goto L37;
        acquireReference();
        StringBuilder r0 = new StringBuilder(120);     // Catch: Throwable -> L33
        r0.append("UPDATE ");     // Catch: Throwable -> L33
        r0.append(CONFLICT_VALUES[r11]);     // Catch: Throwable -> L33
        r0.append(r7);     // Catch: Throwable -> L33
        r0.append(" SET ");     // Catch: Throwable -> L33
        int r12 = r8.size();     // Catch: Throwable -> L33
        if (r10 != null) goto L9;
        int r13 = r12;
    L10:
        Object[] r1 = new Object[r13];     // Catch: Throwable -> L33
        Iterator<String> r2 = keySet(r8).iterator();     // Catch: Throwable -> L33
        int r3 = 0;
    L12:
        if (r2.hasNext() == false) goto L18;
        String r4 = r2.next();     // Catch: Throwable -> L33
        if (r3 <= 0) goto L16;
        String r5 = ",";
    L17:
        r0.append(r5);     // Catch: Throwable -> L33
        r0.append(r4);     // Catch: Throwable -> L33
        r1[r3] = r8.get(r4);     // Catch: Throwable -> L33
        r0.append("=?");     // Catch: Throwable -> L33
        r3 = r3 + 1;     // Catch: Throwable -> L33
        goto L12
    L16:
        r5 = "";
        goto L17
    L18:
        if (r10 == null) goto L23;
        int r14 = r12;
    L20:
        if (r14 >= r13) goto L23;
        r1[r14] = r10[r14 - r12];     // Catch: Throwable -> L33
        r14 = r14 + 1;     // Catch: Throwable -> L33
    L23:
        if (TextUtils.isEmpty(r9) == true) goto L25;
        r0.append(" WHERE ");     // Catch: Throwable -> L33
        r0.append(r9);     // Catch: Throwable -> L33
    L25:
        SQLiteStatement r15 = new SQLiteStatement(this, r0.toString(), r1);     // Catch: Throwable -> L33
        int r16 = r15.executeUpdateDelete();     // Catch: Throwable -> L30
        r15.close();     // Catch: Throwable -> L33
        releaseReference();
        return r16;
    L30:
        th = move-exception;
        r15.close();     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L33
    L9:
        r13 = r10.length + r12;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        releaseReference();
        throw th;
    L37:
        throw new IllegalArgumentException("Empty values");
    }

    public void execSQL(String r2) throws SQLException {
        executeSql(r2, null, null);
    }

    public void execSQL(String r2, Object[] r3) throws SQLException {
        executeSql(r2, r3, null);
    }

    public void execSQL(String r1, Object[] r2, CancellationSignal r3) {
        executeSql(r1, r2, r3);
    }

    private int executeSql(String r3, Object[] r4, CancellationSignal r5) throws SQLException {
        acquireReference();
    L26:
        th = move-exception;
        releaseReference();
        throw th;
    L4:
        if (DatabaseUtils.getSqlStatementType(r3) != 3) goto L18;
        Object r0 = this.mLock;     // Catch: Throwable -> L26
        monitor-enter(r0);     // Catch: Throwable -> L26
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L8:
        if (this.mHasAttachedDbsLocked == true) goto L10;
        boolean r1 = true;
        this.mHasAttachedDbsLocked = true;     // Catch: Throwable -> L15
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L15
        if (r1 == false) goto L18;
        disableWriteAheadLogging();     // Catch: Throwable -> L26
        goto L18
    L10:
        r1 = false;
    L18:
        SQLiteStatement r2 = new SQLiteStatement(this, r3, r4);     // Catch: Throwable -> L26
        int r6 = r2.executeUpdateDelete(r5);     // Catch: Throwable -> L23
        r2.close();     // Catch: Throwable -> L26
        releaseReference();
        return r6;
    L23:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    }

    public Pair<Integer, Integer> walCheckpoint(String r2, boolean r3) {
        acquireReference();
        if (r3 == false) goto L5;
        int r4 = 2;
    L12:
        Pair<Integer, Integer> r5 = getThreadSession().walCheckpoint(r2, r4);     // Catch: Throwable -> L9
        releaseReference();
        return r5;
    L9:
        th = move-exception;
        releaseReference();
        throw th;
    L5:
        r4 = 0;
        goto L12
    }

    public boolean isReadOnly() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = isReadOnlyLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean isReadOnlyLocked() {
        if ((this.mConfigurationLocked.openFlags & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isInMemoryDatabase() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mConfigurationLocked.isInMemoryDb();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isOpen() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mConnectionPoolLocked == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public boolean needUpgrade(int r1) {
        if (r1 <= getVersion()) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getPath() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String r1 = this.mConfigurationLocked.path;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void setLocale(Locale r4) {
        if (r4 == null) goto L16;
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfNotOpenLocked();     // Catch: Throwable -> L12
        Locale r1 = this.mConfigurationLocked.locale;     // Catch: Throwable -> L12
        this.mConfigurationLocked.locale = r4;     // Catch: Throwable -> L12
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);     // Catch: RuntimeException -> L9 Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L9:
        e = move-exception;
        this.mConfigurationLocked.locale = r1;     // Catch: Throwable -> L12
        throw e;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new IllegalArgumentException("locale must not be null.");
    }

    public void setMaxSqlCacheSize(int r4) {
        if (r4 > 100) goto L18;
        if (r4 < 0) goto L18;
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfNotOpenLocked();     // Catch: Throwable -> L14
        int r1 = this.mConfigurationLocked.maxSqlCacheSize;     // Catch: Throwable -> L14
        this.mConfigurationLocked.maxSqlCacheSize = r4;     // Catch: Throwable -> L14
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);     // Catch: RuntimeException -> L11 Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L11:
        e = move-exception;
        this.mConfigurationLocked.maxSqlCacheSize = r1;     // Catch: Throwable -> L14
        throw e;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    L18:
        throw new IllegalStateException("expected value between 0 and 100");
    }

    public void setForeignKeyConstraintsEnabled(boolean r4) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfNotOpenLocked();     // Catch: Throwable -> L19
        if (this.mConfigurationLocked.foreignKeyConstraintsEnabled != r4) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L8:
        this.mConfigurationLocked.foreignKeyConstraintsEnabled = r4;     // Catch: Throwable -> L19
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);     // Catch: RuntimeException -> L12 Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L12:
        e = move-exception;
        SQLiteDatabaseConfiguration r3 = this.mConfigurationLocked;     // Catch: Throwable -> L19
        if (r4 == true) goto L16;
        boolean r5 = true;
    L17:
        r3.foreignKeyConstraintsEnabled = r5;     // Catch: Throwable -> L19
        throw e;     // Catch: Throwable -> L19
    L16:
        r5 = false;
    L19:
        th = move-exception;
        throw th;
    }

    public SQLiteCheckpointListener getCheckpointCallback() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfNotOpenLocked();     // Catch: Throwable -> L12
        if (this.mConfigurationLocked.customWALHookEnabled == true) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return null;
    L9:
        SQLiteCheckpointListener r2 = this.mConnectionPoolLocked.getCheckpointListener();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L12:
        th = move-exception;
        throw th;
    }

    public void setCheckpointCallback(SQLiteCheckpointListener r7) {
        boolean r0 = true;
        if (r7 == null) goto L5;
        boolean r2 = true;
    L6:
        Object r3 = this.mLock;
        monitor-enter(r3);
        throwIfNotOpenLocked();     // Catch: Throwable -> L23
        if (this.mConfigurationLocked.customWALHookEnabled == r2) goto L20;
        this.mConfigurationLocked.customWALHookEnabled = r2;     // Catch: Throwable -> L23
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);     // Catch: RuntimeException -> L13 Throwable -> L23
    L13:
        e = move-exception;
        SQLiteDatabaseConfiguration r6 = this.mConfigurationLocked;     // Catch: Throwable -> L23
        if (r2 == false) goto L18;
        r0 = false;
    L18:
        r6.customWALHookEnabled = r0;     // Catch: Throwable -> L23
        throw e;     // Catch: Throwable -> L23
    L20:
        this.mConnectionPoolLocked.setCheckpointListener(r7);     // Catch: Throwable -> L23
        monitor-exit(r3);     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        throw th;
    L5:
        r2 = false;
        goto L6
    }

    public boolean getAsyncCheckpointEnabled() {
        SQLiteCheckpointListener r0 = getCheckpointCallback();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if ((r0 instanceof SQLiteAsyncCheckpointer) == false) goto L7;
        return true;
    }

    public void setAsyncCheckpointEnabled(boolean r1) {
        if (r1 == false) goto L4;
        SQLiteAsyncCheckpointer r2 = new SQLiteAsyncCheckpointer();
    L5:
        setCheckpointCallback(r2);
        return;
    L4:
        r2 = null;
        goto L5
    }

    public boolean enableWriteAheadLogging() {
        Object r1 = this.mLock;
        monitor-enter(r1);
        throwIfNotOpenLocked();     // Catch: Throwable -> L29
        if ((this.mConfigurationLocked.openFlags & ENABLE_WRITE_AHEAD_LOGGING) == 0) goto L9;
        monitor-exit(r1);     // Catch: Throwable -> L29
        return true;
    L9:
        if (isReadOnlyLocked() == false) goto L13;
        monitor-exit(r1);     // Catch: Throwable -> L29
        return false;
    L13:
        if (this.mConfigurationLocked.isInMemoryDb() == false) goto L18;
        Log.i(TAG, "can't enable WAL for memory databases.");     // Catch: Throwable -> L29
        monitor-exit(r1);     // Catch: Throwable -> L29
        return false;
    L18:
        if (this.mHasAttachedDbsLocked == false) goto L22;
        Log.i(TAG, "this database: " + this.mConfigurationLocked.label + " has attached databases. can't  enable WAL.");     // Catch: Throwable -> L29
        monitor-exit(r1);     // Catch: Throwable -> L29
        return false;
    L22:
        this.mConfigurationLocked.openFlags |= ENABLE_WRITE_AHEAD_LOGGING;     // Catch: Throwable -> L29
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);     // Catch: RuntimeException -> L26 Throwable -> L29
        monitor-exit(r1);     // Catch: Throwable -> L29
        return true;
    L26:
        e = move-exception;
        this.mConfigurationLocked.openFlags &= -536870913;     // Catch: Throwable -> L29
        throw e;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    }

    public void disableWriteAheadLogging() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfNotOpenLocked();     // Catch: Throwable -> L15
        if ((this.mConfigurationLocked.openFlags & ENABLE_WRITE_AHEAD_LOGGING) != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L8:
        this.mConfigurationLocked.openFlags &= -536870913;     // Catch: Throwable -> L15
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);     // Catch: RuntimeException -> L12 Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L12:
        e = move-exception;
        SQLiteDatabaseConfiguration r5 = this.mConfigurationLocked;     // Catch: Throwable -> L15
        r5.openFlags = 536870912 | r5.openFlags;     // Catch: Throwable -> L15
        throw e;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public boolean isWriteAheadLoggingEnabled() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfNotOpenLocked();     // Catch: Throwable -> L10
        if ((this.mConfigurationLocked.openFlags & ENABLE_WRITE_AHEAD_LOGGING) == 0) goto L7;
        boolean r2 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public int getSynchronousMode() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfNotOpenLocked();     // Catch: Throwable -> L7
        int r1 = this.mConfigurationLocked.synchronousMode;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void setSynchronousMode(int r4) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfNotOpenLocked();     // Catch: Throwable -> L14
        int r1 = this.mConfigurationLocked.synchronousMode;     // Catch: Throwable -> L14
        if (r1 == r4) goto L12;
        this.mConfigurationLocked.synchronousMode = r4;     // Catch: Throwable -> L14
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);     // Catch: RuntimeException -> L9 Throwable -> L14
    L9:
        e = move-exception;
        this.mConfigurationLocked.synchronousMode = r1;     // Catch: Throwable -> L14
        throw e;     // Catch: Throwable -> L14
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public SQLiteChangeListener getChangeListener() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfNotOpenLocked();     // Catch: Throwable -> L7
        SQLiteChangeListener r1 = this.mConnectionPoolLocked.getChangeListener();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void setChangeListener(SQLiteChangeListener r2, boolean r3) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfNotOpenLocked();     // Catch: Throwable -> L7
        this.mConnectionPoolLocked.setChangeListener(r2, r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public SQLiteTrace getTraceCallback() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfNotOpenLocked();     // Catch: Throwable -> L7
        SQLiteTrace r1 = this.mConnectionPoolLocked.getTraceCallback();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void setTraceCallback(SQLiteTrace r2) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfNotOpenLocked();     // Catch: Throwable -> L7
        this.mConnectionPoolLocked.setTraceCallback(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static ArrayList<SQLiteDebug.DbStats> getDbStats() {
        ArrayList<SQLiteDebug.DbStats> r0 = new ArrayList();
        Iterator<SQLiteDatabase> r1 = getActiveDatabases().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().collectDbStats(r0);
        goto L4
    L6:
        return r0;
    }

    private void collectDbStats(ArrayList<SQLiteDebug.DbStats> r2) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        SQLiteConnectionPool r1 = this.mConnectionPoolLocked;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.collectDbStats(r2);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private static ArrayList<SQLiteDatabase> getActiveDatabases() {
        ArrayList<SQLiteDatabase> r0 = new ArrayList();
        WeakHashMap<SQLiteDatabase, Object> r1 = sActiveDatabases;
        monitor-enter(r1);
        r0.addAll(r1.keySet());     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public static void dumpAll(Printer r2, boolean r3) {
        Iterator<SQLiteDatabase> r0 = getActiveDatabases().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().dump(r2, r3);
        goto L4
    }

    public static JSONArray dumpAllJSON(boolean r3) throws JSONException {
        JSONArray r0 = new JSONArray();
        Iterator<SQLiteDatabase> r1 = getActiveDatabases().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.put(r1.next().dumpJSON(r3));
        goto L4
    L6:
        return r0;
    }

    public void dump(Printer r2, boolean r3) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        SQLiteConnectionPool r1 = this.mConnectionPoolLocked;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.dump(r2, r3);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public JSONObject dumpJSON(boolean r2) throws JSONException {
        Object r0 = this.mLock;
        monitor-enter(r0);
        SQLiteConnectionPool r1 = this.mConnectionPoolLocked;     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        JSONObject r3 = r1.dumpJSON(r2);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r3;
    L9:
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r4;
    L12:
        th = move-exception;
        throw th;
    }

    public List<Pair<String, String>> getAttachedDbs() {
        ArrayList r0 = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
        Cursor r3 = null;
        if (this.mConnectionPoolLocked != null) goto L9;
        monitor-exit(r1);     // Catch: Throwable -> L31
        return null;
    L9:
        if (this.mHasAttachedDbsLocked == true) goto L13;
        r0.add(new Pair("main", this.mConfigurationLocked.path));     // Catch: Throwable -> L31
        monitor-exit(r1);     // Catch: Throwable -> L31
        return r0;
    L13:
        acquireReference();     // Catch: Throwable -> L31
        monitor-exit(r1);     // Catch: Throwable -> L31
        r3 = rawQuery("pragma database_list;", null);     // Catch: Throwable -> L24
    L17:
        if (r3.moveToNext() == false) goto L20;
        r0.add(new Pair(r3.getString(1), r3.getString(2)));     // Catch: Throwable -> L24
    L20:
        if (r3 == null) goto L22;
        r3.close();     // Catch: Throwable -> L28
    L22:
        releaseReference();
        return r0;
    L24:
        th = move-exception;
        if (r3 == null) goto L27;
        r3.close();     // Catch: Throwable -> L28
    L27:
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        releaseReference();
        throw th;
    L31:
        th = move-exception;
        throw th;
    }

    public boolean isDatabaseIntegrityOk() {
        acquireReference();
        List<Pair<String, String>> r1 = getAttachedDbs();     // Catch: Throwable -> L8 SQLiteException -> L10
        if (r1 == null) goto L7;
    L11:
        int r2 = 0;
    L13:
        if (r2 >= r1.size()) goto L30;
        Pair<String, String> r3 = r1.get(r2);     // Catch: Throwable -> L8
        SQLiteStatement r4 = null;
        r4 = compileStatement("PRAGMA " + ((String) r3.first) + ".integrity_check(1);");     // Catch: Throwable -> L26
        String r5 = r4.simpleQueryForString();     // Catch: Throwable -> L26
        if (DatabaseUtils.objectEquals(r5, "ok") == false) goto L18;
        if (r4 == null) goto L25;
        r4.close();     // Catch: Throwable -> L8
    L25:
        r2 = r2 + 1;     // Catch: Throwable -> L8
        goto L13
    L18:
        Log.e(TAG, "PRAGMA integrity_check on " + ((String) r3.second) + " returned: " + r5);     // Catch: Throwable -> L26
        if (r4 == null) goto L21;
        r4.close();     // Catch: Throwable -> L8
    L21:
        releaseReference();
        return false;
    L26:
        th = move-exception;
        if (r4 == null) goto L29;
        r4.close();     // Catch: Throwable -> L8
    L29:
        throw th;     // Catch: Throwable -> L8
    L30:
        releaseReference();
        return true;
    L7:
        throw new IllegalStateException("databaselist for: " + getPath() + " couldn't be retrieved. probably because the database is closed");     // Catch: Throwable -> L8 SQLiteException -> L10
    L10:
        r1 = new ArrayList();     // Catch: Throwable -> L8
        r1.add(new Pair("main", getPath()));     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public long acquireNativeConnectionHandle(String r1, boolean r2, boolean r3) {
        if (r1 != null) goto L4;
        r1 = "unnamedNative";
    L4:
        if (r2 == false) goto L6;
        int r4 = 1;
    L7:
        if (r3 == false) goto L9;
        r4 = r4 | 4;
    L9:
        long r0 = getThreadSession().acquireConnectionForNativeHandle(r4).getNativeHandle(r1);
        if (r0 == 0) goto L13;
        return r0;
    L13:
        throw new IllegalStateException("SQLiteConnection native handle not initialized.");
    L6:
        r4 = 2;
        goto L7
    }

    public void releaseNativeConnection(long r1, Exception r3) {
        getThreadSession().releaseConnectionForNativeHandle(r3);
    }

    public String toString() {
        return "SQLiteDatabase: " + getPath();
    }

    private void throwIfNotOpenLocked() {
        if (this.mConnectionPoolLocked == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("The database '" + this.mConfigurationLocked.label + "' is not open.");
    }
}
