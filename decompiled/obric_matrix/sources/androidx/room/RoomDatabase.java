package androidx.room;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.room.migration.Migration;
import androidx.room.util.SneakyThrow;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes.dex */
public abstract class RoomDatabase {
    private static final String DB_IMPL_SUFFIX = "_Impl";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    private boolean mAllowMainThreadQueries;
    private final Map<String, Object> mBackingFieldMap;

    @Nullable
    @Deprecated
    protected List<Callback> mCallbacks;
    private final ReentrantReadWriteLock mCloseLock;

    @Deprecated
    protected volatile SupportSQLiteDatabase mDatabase;
    private final InvalidationTracker mInvalidationTracker;
    private SupportSQLiteOpenHelper mOpenHelper;
    private Executor mQueryExecutor;
    private final ThreadLocal<Integer> mSuspendingTransactionId;
    private Executor mTransactionExecutor;
    boolean mWriteAheadLoggingEnabled;

    public static class Builder<T extends RoomDatabase> {
        private boolean mAllowDestructiveMigrationOnDowngrade;
        private boolean mAllowMainThreadQueries;
        private ArrayList<Callback> mCallbacks;
        private final Context mContext;
        private String mCopyFromAssetPath;
        private File mCopyFromFile;
        private final Class<T> mDatabaseClass;
        private SupportSQLiteOpenHelper.Factory mFactory;
        private JournalMode mJournalMode;
        private final MigrationContainer mMigrationContainer;
        private Set<Integer> mMigrationStartAndEndVersions;
        private Set<Integer> mMigrationsNotRequiredFrom;
        private boolean mMultiInstanceInvalidation;
        private final String mName;
        private Executor mQueryExecutor;
        private boolean mRequireMigration;
        private Executor mTransactionExecutor;

        Builder(@NonNull Context r1, @NonNull Class<T> r2, @Nullable String r3) {
            this.mContext = r1;
            this.mDatabaseClass = r2;
            this.mName = r3;
            this.mJournalMode = JournalMode.AUTOMATIC;
            this.mRequireMigration = true;
            this.mMigrationContainer = new MigrationContainer();
        }

        @NonNull
        public Builder<T> addCallback(@NonNull Callback r2) {
            if (this.mCallbacks != null) goto L5;
            this.mCallbacks = new ArrayList();
        L5:
            this.mCallbacks.add(r2);
            return this;
        }

        @NonNull
        public Builder<T> addMigrations(@NonNull Migration... r6) {
            if (this.mMigrationStartAndEndVersions != null) goto L5;
            this.mMigrationStartAndEndVersions = new HashSet();
        L5:
            int r0 = r6.length;
            int r1 = 0;
        L6:
            if (r1 >= r0) goto L8;
            Migration r2 = r6[r1];
            this.mMigrationStartAndEndVersions.add(Integer.valueOf(r2.startVersion));
            this.mMigrationStartAndEndVersions.add(Integer.valueOf(r2.endVersion));
            r1 = r1 + 1;
            goto L6
        L8:
            this.mMigrationContainer.addMigrations(r6);
            return this;
        }

        @NonNull
        public Builder<T> allowMainThreadQueries() {
            this.mAllowMainThreadQueries = true;
            return this;
        }

        @NonNull
        @SuppressLint({"RestrictedApi"})
        public T build() {
            if (this.mContext == null) goto L55;
            if (this.mDatabaseClass == null) goto L53;
            Executor r1 = this.mQueryExecutor;
            if (r1 == null) goto L9;
        L12:
            if (r1 != null) goto L14;
        L16:
            if (r1 != null) goto L20;
            Executor r2 = this.mTransactionExecutor;
            if (r2 == null) goto L20;
        L11:
            this.mQueryExecutor = r2;
        L20:
            Set<Integer> r3 = this.mMigrationStartAndEndVersions;
            if (r3 == null) goto L33;
            if (this.mMigrationsNotRequiredFrom == null) goto L33;
            Iterator<Integer> r4 = r3.iterator();
        L26:
            if (r4.hasNext() == false) goto L33;
            Integer r5 = r4.next();
            if (this.mMigrationsNotRequiredFrom.contains(r5) == false) goto L26;
            throw new IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + r5);
        L33:
            if (this.mFactory != null) goto L35;
            this.mFactory = new FrameworkSQLiteOpenHelperFactory();
        L35:
            String r6 = this.mCopyFromAssetPath;
            if (r6 != null) goto L40;
            if (this.mCopyFromFile != null) goto L40;
        L48:
            Context r7 = this.mContext;
            DatabaseConfiguration r8 = new DatabaseConfiguration(r7, this.mName, this.mFactory, this.mMigrationContainer, this.mCallbacks, this.mAllowMainThreadQueries, this.mJournalMode.resolve(r7), this.mQueryExecutor, this.mTransactionExecutor, this.mMultiInstanceInvalidation, this.mRequireMigration, this.mAllowDestructiveMigrationOnDowngrade, this.mMigrationsNotRequiredFrom, this.mCopyFromAssetPath, this.mCopyFromFile);
            T r0 = (T) Room.getGeneratedImplementation(this.mDatabaseClass, RoomDatabase.DB_IMPL_SUFFIX);
            r0.init(r8);
            return r0;
        L40:
            if (this.mName == null) goto L51;
            if (r6 != null) goto L43;
        L47:
            this.mFactory = new SQLiteCopyOpenHelperFactory(r6, this.mCopyFromFile, this.mFactory);
            goto L48
        L43:
            if (this.mCopyFromFile == null) goto L47;
            throw new IllegalArgumentException("Both createFromAsset() and createFromFile() was called on this Builder but the database can only be created using one of the two configurations.");
        L51:
            throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
        L14:
            if (this.mTransactionExecutor != null) goto L16;
            this.mTransactionExecutor = r1;
            goto L20
        L9:
            if (this.mTransactionExecutor != null) goto L12;
            r2 = ArchTaskExecutor.getIOThreadExecutor();
            this.mTransactionExecutor = r2;
            goto L11
        L53:
            throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
        L55:
            throw new IllegalArgumentException("Cannot provide null context for the database.");
        }

        @NonNull
        public Builder<T> createFromAsset(@NonNull String r1) {
            this.mCopyFromAssetPath = r1;
            return this;
        }

        @NonNull
        public Builder<T> createFromFile(@NonNull File r1) {
            this.mCopyFromFile = r1;
            return this;
        }

        @NonNull
        public Builder<T> enableMultiInstanceInvalidation() {
            if (this.mName == null) goto L5;
            boolean r0 = true;
        L6:
            this.mMultiInstanceInvalidation = r0;
            return this;
        L5:
            r0 = false;
            goto L6
        }

        @NonNull
        public Builder<T> fallbackToDestructiveMigration() {
            this.mRequireMigration = false;
            this.mAllowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        @NonNull
        public Builder<T> fallbackToDestructiveMigrationFrom(int... r5) {
            if (this.mMigrationsNotRequiredFrom != null) goto L5;
            this.mMigrationsNotRequiredFrom = new HashSet(r5.length);
        L5:
            int r0 = r5.length;
            int r1 = 0;
        L6:
            if (r1 >= r0) goto L8;
            int r2 = r5[r1];
            this.mMigrationsNotRequiredFrom.add(Integer.valueOf(r2));
            r1 = r1 + 1;
            goto L6
        L8:
            return this;
        }

        @NonNull
        public Builder<T> fallbackToDestructiveMigrationOnDowngrade() {
            this.mRequireMigration = true;
            this.mAllowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        @NonNull
        public Builder<T> openHelperFactory(@Nullable SupportSQLiteOpenHelper.Factory r1) {
            this.mFactory = r1;
            return this;
        }

        @NonNull
        public Builder<T> setJournalMode(@NonNull JournalMode r1) {
            this.mJournalMode = r1;
            return this;
        }

        @NonNull
        public Builder<T> setQueryExecutor(@NonNull Executor r1) {
            this.mQueryExecutor = r1;
            return this;
        }

        @NonNull
        public Builder<T> setTransactionExecutor(@NonNull Executor r1) {
            this.mTransactionExecutor = r1;
            return this;
        }
    }

    public static abstract class Callback {
        public Callback() {
        }

        public void onCreate(@NonNull SupportSQLiteDatabase r1) {
        }

        public void onDestructiveMigration(@NonNull SupportSQLiteDatabase r1) {
        }

        public void onOpen(@NonNull SupportSQLiteDatabase r1) {
        }
    }

    public static final enum JournalMode extends Enum<JournalMode> {
        private static final /* synthetic */ JournalMode[] $VALUES = null;
        public static final JournalMode AUTOMATIC = null;
        public static final JournalMode TRUNCATE = null;

        @RequiresApi(16)
        public static final JournalMode WRITE_AHEAD_LOGGING = null;

        static {
            JournalMode r0 = new JournalMode("AUTOMATIC", 0);
            AUTOMATIC = r0;
            JournalMode r1 = new JournalMode("TRUNCATE", 1);
            TRUNCATE = r1;
            JournalMode r3 = new JournalMode("WRITE_AHEAD_LOGGING", 2);
            WRITE_AHEAD_LOGGING = r3;
            $VALUES = new JournalMode[]{r0, r1, r3};
        }

        private JournalMode(String r1, int r2) {
            super(r1, r2);
        }

        private static boolean isLowRamDevice(@NonNull ActivityManager r2) {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return false;
        L5:
            return r2.isLowRamDevice();
        }

        public static JournalMode valueOf(String r1) {
            return (JournalMode) Enum.valueOf(JournalMode.class, r1);
        }

        public static JournalMode[] values() {
            return (JournalMode[]) $VALUES.clone();
        }

        @SuppressLint({"NewApi"})
        JournalMode resolve(Context r2) {
            if (this == AUTOMATIC) goto L6;
            return this;
        L6:
            if (Build.VERSION.SDK_INT < 16) goto L14;
            ActivityManager r1 = (ActivityManager) r2.getSystemService("activity");
            if (r1 == null) goto L14;
            if (isLowRamDevice(r1) == true) goto L14;
            return WRITE_AHEAD_LOGGING;
        L14:
            return TRUNCATE;
        }
    }

    public static class MigrationContainer {
        private HashMap<Integer, TreeMap<Integer, Migration>> mMigrations;

        public MigrationContainer() {
            this.mMigrations = new HashMap();
        }

        private void addMigration(Migration r5) {
            int r0 = r5.startVersion;
            int r1 = r5.endVersion;
            TreeMap<Integer, Migration> r2 = this.mMigrations.get(Integer.valueOf(r0));
            if (r2 != null) goto L5;
            r2 = new TreeMap();
            this.mMigrations.put(Integer.valueOf(r0), r2);
        L5:
            Migration r4 = r2.get(Integer.valueOf(r1));
            if (r4 == null) goto L8;
            Log.w("ROOM", "Overriding migration " + r4 + " with " + r5);
        L8:
            r2.put(Integer.valueOf(r1), r5);
        }

        private List<Migration> findUpMigrationPath(List<Migration> r7, boolean r8, int r9, int r10) {
        L2:
            if (r8 == false) goto L5;
            if (r9 >= r10) goto L28;
        L6:
            TreeMap<Integer, Migration> r0 = this.mMigrations.get(Integer.valueOf(r9));
            if (r0 == null) goto L8;
            if (r8 == false) goto L11;
            Set<Integer> r2 = r0.descendingKeySet();
        L12:
            Iterator<Integer> r3 = r2.iterator();
        L13:
            boolean r4 = true;
            boolean r5 = false;
            if (r3.hasNext() == false) goto L25;
            int r6 = r3.next().intValue();
            if (r8 == false) goto L20;
            if (r6 > r10) goto L23;
            if (r6 <= r9) goto L23;
        L19:
            r5 = true;
        L23:
            if (r5 == false) goto L13;
            r7.add(r0.get(Integer.valueOf(r6)));
            r9 = r6;
        L26:
            if (r4 == true) goto L2;
            return null;
        L20:
            if (r6 < r10) goto L23;
            if (r6 >= r9) goto L23;
        L25:
            r4 = false;
            goto L26
        L11:
            r2 = r0.keySet();
            goto L12
        L8:
            return null;
        L28:
            return r7;
        L5:
            if (r9 <= r10) goto L28;
            goto L6
        }

        public void addMigrations(@NonNull Migration... r4) {
            int r0 = r4.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            addMigration(r4[r1]);
            r1 = r1 + 1;
            goto L3
        }

        @Nullable
        public List<Migration> findMigrationPath(int r3, int r4) {
            if (r3 == r4) goto L4;
            if (r4 <= r3) goto L7;
            boolean r0 = true;
        L9:
            return findUpMigrationPath(new ArrayList(), r0, r3, r4);
        L7:
            r0 = false;
            goto L9
        L4:
            return Collections.emptyList();
        }
    }

    public RoomDatabase() {
        this.mCloseLock = new ReentrantReadWriteLock();
        this.mSuspendingTransactionId = new ThreadLocal();
        this.mBackingFieldMap = new ConcurrentHashMap();
        this.mInvalidationTracker = createInvalidationTracker();
    }

    private static boolean isMainThread() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void assertNotMainThread() {
        if (this.mAllowMainThreadQueries == false) goto L6;
        return;
    L6:
        if (isMainThread() == true) goto L9;
        return;
    L9:
        throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void assertNotSuspendingTransaction() {
        if (inTransaction() == false) goto L5;
        return;
    L5:
        if (this.mSuspendingTransactionId.get() != null) goto L8;
        return;
    L8:
        throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
    }

    @Deprecated
    public void beginTransaction() {
        assertNotMainThread();
        SupportSQLiteDatabase r0 = this.mOpenHelper.getWritableDatabase();
        this.mInvalidationTracker.syncTriggers(r0);
        r0.beginTransaction();
    }

    @WorkerThread
    public abstract void clearAllTables();

    public void close() {
        if (isOpen() == false) goto L10;
        ReentrantReadWriteLock.WriteLock r0 = this.mCloseLock.writeLock();
        r0.lock();     // Catch: Throwable -> L7
        this.mInvalidationTracker.stopMultiInstanceInvalidation();     // Catch: Throwable -> L7
        this.mOpenHelper.close();     // Catch: Throwable -> L7
        r0.unlock();
        return;
    L7:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public SupportSQLiteStatement compileStatement(@NonNull String r1) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return this.mOpenHelper.getWritableDatabase().compileStatement(r1);
    }

    @NonNull
    protected abstract InvalidationTracker createInvalidationTracker();

    @NonNull
    protected abstract SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r1);

    @Deprecated
    public void endTransaction() {
        this.mOpenHelper.getWritableDatabase().endTransaction();
        if (inTransaction() == true) goto L6;
        this.mInvalidationTracker.refreshVersionsAsync();
        return;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    Map<String, Object> getBackingFieldMap() {
        return this.mBackingFieldMap;
    }

    Lock getCloseLock() {
        return this.mCloseLock.readLock();
    }

    @NonNull
    public InvalidationTracker getInvalidationTracker() {
        return this.mInvalidationTracker;
    }

    @NonNull
    public SupportSQLiteOpenHelper getOpenHelper() {
        return this.mOpenHelper;
    }

    @NonNull
    public Executor getQueryExecutor() {
        return this.mQueryExecutor;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    ThreadLocal<Integer> getSuspendingTransactionId() {
        return this.mSuspendingTransactionId;
    }

    @NonNull
    public Executor getTransactionExecutor() {
        return this.mTransactionExecutor;
    }

    public boolean inTransaction() {
        return this.mOpenHelper.getWritableDatabase().inTransaction();
    }

    @CallSuper
    public void init(@NonNull DatabaseConfiguration r4) {
        SupportSQLiteOpenHelper r0 = createOpenHelper(r4);
        this.mOpenHelper = r0;
        if ((r0 instanceof SQLiteCopyOpenHelper) == false) goto L5;
        ((SQLiteCopyOpenHelper) r0).setDatabaseConfiguration(r4);
    L5:
        boolean r2 = false;
        if (Build.VERSION.SDK_INT >= 16) goto L8;
    L11:
        this.mCallbacks = r4.callbacks;
        this.mQueryExecutor = r4.queryExecutor;
        this.mTransactionExecutor = new TransactionExecutor(r4.transactionExecutor);
        this.mAllowMainThreadQueries = r4.allowMainThreadQueries;
        this.mWriteAheadLoggingEnabled = r2;
        if (r4.multiInstanceInvalidation == false) goto L15;
        this.mInvalidationTracker.startMultiInstanceInvalidation(r4.context, r4.name);
        return;
    L15:
        return;
    L8:
        if (r4.journalMode != JournalMode.WRITE_AHEAD_LOGGING) goto L10;
        r2 = true;
    L10:
        this.mOpenHelper.setWriteAheadLoggingEnabled(r2);
        goto L11
    }

    protected void internalInitInvalidationTracker(@NonNull SupportSQLiteDatabase r1) {
        this.mInvalidationTracker.internalInit(r1);
    }

    public boolean isOpen() {
        SupportSQLiteDatabase r0 = this.mDatabase;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isOpen() == false) goto L7;
        return true;
    }

    @NonNull
    public Cursor query(@NonNull SupportSQLiteQuery r2) {
        return query(r2, null);
    }

    @NonNull
    public Cursor query(@NonNull SupportSQLiteQuery r3, @Nullable CancellationSignal r4) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        if (r4 == null) goto L9;
        if (Build.VERSION.SDK_INT < 16) goto L9;
        return this.mOpenHelper.getWritableDatabase().query(r3, r4);
    L9:
        return this.mOpenHelper.getWritableDatabase().query(r3);
    }

    @NonNull
    public Cursor query(@NonNull String r2, @Nullable Object[] r3) {
        return this.mOpenHelper.getWritableDatabase().query(new SimpleSQLiteQuery(r2, r3));
    }

    public <V> V runInTransaction(@NonNull Callable<V> r1) {
        beginTransaction();
        V r2 = r1.call();     // Catch: Throwable -> L6 Exception -> L8 RuntimeException -> L12
        setTransactionSuccessful();     // Catch: Throwable -> L6 Exception -> L8 RuntimeException -> L12
        endTransaction();
        return r2;
    L6:
        th = move-exception;
        endTransaction();
        throw th;
    L12:
        e = move-exception;
        throw e;     // Catch: Throwable -> L6
    L8:
        e = move-exception;
        SneakyThrow.reThrow(e);     // Catch: Throwable -> L6
        endTransaction();
        return null;
    }

    public void runInTransaction(@NonNull Runnable r1) {
        beginTransaction();
        r1.run();     // Catch: Throwable -> L6
        setTransactionSuccessful();     // Catch: Throwable -> L6
        endTransaction();
        return;
    L6:
        th = move-exception;
        endTransaction();
        throw th;
    }

    @Deprecated
    public void setTransactionSuccessful() {
        this.mOpenHelper.getWritableDatabase().setTransactionSuccessful();
    }
}
