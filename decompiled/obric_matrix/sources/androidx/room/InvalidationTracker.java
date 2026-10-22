package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.LiveData;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
public class InvalidationTracker {
    private static final String CREATE_TRACKING_TABLE_SQL = "CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)";
    private static final String INVALIDATED_COLUMN_NAME = "invalidated";

    @VisibleForTesting
    static final String RESET_UPDATED_TABLES_SQL = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ";

    @VisibleForTesting
    static final String SELECT_UPDATED_TABLES_SQL = "SELECT * FROM room_table_modification_log WHERE invalidated = 1;";
    private static final String TABLE_ID_COLUMN_NAME = "table_id";
    private static final String[] TRIGGERS = null;
    private static final String UPDATE_TABLE_NAME = "room_table_modification_log";
    volatile SupportSQLiteStatement mCleanupStatement;
    final RoomDatabase mDatabase;
    private volatile boolean mInitialized;
    private final InvalidationLiveDataContainer mInvalidationLiveDataContainer;
    private MultiInstanceInvalidationClient mMultiInstanceInvalidationClient;
    private ObservedTableTracker mObservedTableTracker;

    @SuppressLint({"RestrictedApi"})
    @VisibleForTesting
    final SafeIterableMap<Observer, ObserverWrapper> mObserverMap;
    AtomicBoolean mPendingRefresh;

    @VisibleForTesting
    Runnable mRefreshRunnable;

    @NonNull
    final HashMap<String, Integer> mTableIdLookup;
    final String[] mTableNames;

    @NonNull
    private Map<String, Set<String>> mViewTables;

    static class ObservedTableTracker {
        static final int ADD = 1;
        static final int NO_OP = 0;
        static final int REMOVE = 2;
        boolean mNeedsSync;
        boolean mPendingSync;
        final long[] mTableObservers;
        final int[] mTriggerStateChanges;
        final boolean[] mTriggerStates;

        ObservedTableTracker(int r3) {
            long[] r0 = new long[r3];
            this.mTableObservers = r0;
            boolean[] r1 = new boolean[r3];
            this.mTriggerStates = r1;
            this.mTriggerStateChanges = new int[r3];
            Arrays.fill(r0, 0);
            Arrays.fill(r1, false);
        }

        @Nullable
        int[] getTablesToSync() {
            monitor-enter(this);
        L30:
            th = move-exception;
            throw th;
        L4:
            if (this.mNeedsSync == false) goto L28;
            if (this.mPendingSync == true) goto L28;
            int r0 = this.mTableObservers.length;     // Catch: Throwable -> L30
            int r2 = 0;
        L9:
            int r3 = 1;
            if (r2 >= r0) goto L24;
            if (this.mTableObservers[r2] <= 0) goto L14;
            boolean r4 = true;
        L15:
            boolean[] r5 = this.mTriggerStates;     // Catch: Throwable -> L30
            if (r4 == r5[r2]) goto L22;
            int[] r6 = this.mTriggerStateChanges;     // Catch: Throwable -> L30
            if (r4 == true) goto L21;
            r3 = 2;
        L21:
            r6[r2] = r3;     // Catch: Throwable -> L30
        L23:
            r5[r2] = r4;     // Catch: Throwable -> L30
            r2 = r2 + 1;     // Catch: Throwable -> L30
            goto L9
        L22:
            this.mTriggerStateChanges[r2] = 0;     // Catch: Throwable -> L30
            goto L23
        L14:
            r4 = false;
            goto L15
        L24:
            this.mPendingSync = true;     // Catch: Throwable -> L30
            this.mNeedsSync = false;     // Catch: Throwable -> L30
            int[] r1 = this.mTriggerStateChanges;     // Catch: Throwable -> L30
            monitor-exit(this);     // Catch: Throwable -> L30
            return r1;
        L28:
            monitor-exit(this);     // Catch: Throwable -> L30
            return null;
        }

        boolean onAdded(int... r10) {
            monitor-enter(this);
            int r0 = r10.length;     // Catch: Throwable -> L11
            int r1 = 0;
            boolean r2 = false;
        L4:
            if (r1 >= r0) goto L9;
            int r3 = r10[r1];     // Catch: Throwable -> L11
            long[] r4 = this.mTableObservers;     // Catch: Throwable -> L11
            long r5 = r4[r3];     // Catch: Throwable -> L11
            r4[r3] = 1 + r5;     // Catch: Throwable -> L11
            if (r5 != 0) goto L8;
            this.mNeedsSync = true;     // Catch: Throwable -> L11
            r2 = true;
        L8:
            r1 = r1 + 1;     // Catch: Throwable -> L11
            goto L4
        L9:
            monitor-exit(this);     // Catch: Throwable -> L11
            return r2;
        L11:
            th = move-exception;
            throw th;
        }

        boolean onRemoved(int... r12) {
            monitor-enter(this);
            int r0 = r12.length;     // Catch: Throwable -> L11
            int r1 = 0;
            boolean r2 = false;
        L4:
            if (r1 >= r0) goto L9;
            int r3 = r12[r1];     // Catch: Throwable -> L11
            long[] r4 = this.mTableObservers;     // Catch: Throwable -> L11
            long r5 = r4[r3];     // Catch: Throwable -> L11
            r4[r3] = r5 - 1;     // Catch: Throwable -> L11
            if (r5 != 1) goto L8;
            this.mNeedsSync = true;     // Catch: Throwable -> L11
            r2 = true;
        L8:
            r1 = r1 + 1;     // Catch: Throwable -> L11
            goto L4
        L9:
            monitor-exit(this);     // Catch: Throwable -> L11
            return r2;
        L11:
            th = move-exception;
            throw th;
        }

        void onSyncCompleted() {
            monitor-enter(this);
            this.mPendingSync = false;     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static abstract class Observer {
        final String[] mTables;

        protected Observer(@NonNull String r2, String... r3) {
            String[] r0 = (String[]) Arrays.copyOf(r3, r3.length + 1);
            this.mTables = r0;
            r0[r3.length] = r2;
        }

        public Observer(@NonNull String[] r2) {
            this.mTables = (String[]) Arrays.copyOf(r2, r2.length);
        }

        boolean isRemote() {
            return false;
        }

        public abstract void onInvalidated(@NonNull Set<String> r1);
    }

    static class ObserverWrapper {
        final Observer mObserver;
        private final Set<String> mSingleTableSet;
        final int[] mTableIds;
        private final String[] mTableNames;

        ObserverWrapper(Observer r1, int[] r2, String[] r3) {
            this.mObserver = r1;
            this.mTableIds = r2;
            this.mTableNames = r3;
            if (r2.length != 1) goto L5;
            HashSet r4 = new HashSet();
            r4.add(r3[0]);
            Set<String> r5 = Collections.unmodifiableSet(r4);
        L6:
            this.mSingleTableSet = r5;
            return;
        L5:
            r5 = null;
            goto L6
        }

        void notifyByTableInvalidStatus(Set<Integer> r5) {
            int r0 = this.mTableIds.length;
            Set<String> r1 = null;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L13;
            if (r5.contains(Integer.valueOf(this.mTableIds[r2])) == false) goto L12;
            if (r0 != 1) goto L9;
            r1 = this.mSingleTableSet;
            goto L12
        L9:
            if (r1 != null) goto L11;
            r1 = new HashSet(r0);
        L11:
            r1.add(this.mTableNames[r2]);
        L12:
            r2 = r2 + 1;
            goto L3
        L13:
            if (r1 == null) goto L20;
            this.mObserver.onInvalidated(r1);
            return;
        }

        void notifyByTableNames(String[] r12) {
            Set<String> r3 = null;
            if (this.mTableNames.length != 1) goto L10;
            int r0 = r12.length;
            int r2 = 0;
        L5:
            if (r2 >= r0) goto L22;
            if (r12[r2].equalsIgnoreCase(this.mTableNames[0]) == true) goto L8;
            r2 = r2 + 1;
            goto L5
        L8:
            r3 = this.mSingleTableSet;
        L22:
            if (r3 == null) goto L31;
            this.mObserver.onInvalidated(r3);
            return;
        L31:
            return;
        L10:
            HashSet r1 = new HashSet();
            int r4 = r12.length;
            int r5 = 0;
        L11:
            if (r5 >= r4) goto L20;
            String r6 = r12[r5];
            String[] r7 = this.mTableNames;
            int r8 = r7.length;
            int r9 = 0;
        L13:
            if (r9 >= r8) goto L18;
            String r10 = r7[r9];
            if (r10.equalsIgnoreCase(r6) == true) goto L16;
            r9 = r9 + 1;
            goto L13
        L16:
            r1.add(r10);
        L18:
            r5 = r5 + 1;
            goto L11
        L20:
            if (r1.size() <= 0) goto L22;
            r3 = r1;
            goto L22
        }
    }

    static class WeakObserver extends Observer {
        final WeakReference<Observer> mDelegateRef;
        final InvalidationTracker mTracker;

        WeakObserver(InvalidationTracker r2, Observer r3) {
            super(r3.mTables);
            this.mTracker = r2;
            this.mDelegateRef = new WeakReference(r3);
        }

        @Override // androidx.room.InvalidationTracker.Observer
        public void onInvalidated(@NonNull Set<String> r2) {
            Observer r0 = this.mDelegateRef.get();
            if (r0 != null) goto L5;
            this.mTracker.removeObserver(this);
            return;
        L5:
            r0.onInvalidated(r2);
        }
    }

    static {
        TRIGGERS = new String[]{"UPDATE", "DELETE", "INSERT"};
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(RoomDatabase r5, Map<String, String> r6, Map<String, Set<String>> r7, String... r8) {
        int r1 = 0;
        this.mPendingRefresh = new AtomicBoolean(false);
        this.mInitialized = false;
        this.mObserverMap = new SafeIterableMap();
        this.mRefreshRunnable = new AnonymousClass1(this);
        this.mDatabase = r5;
        this.mObservedTableTracker = new ObservedTableTracker(r8.length);
        this.mTableIdLookup = new HashMap();
        this.mViewTables = r7;
        this.mInvalidationLiveDataContainer = new InvalidationLiveDataContainer(r5);
        int r9 = r8.length;
        this.mTableNames = new String[r9];
    L3:
        if (r1 >= r9) goto L9;
        String r10 = r8[r1];
        Locale r0 = Locale.US;
        String r11 = r10.toLowerCase(r0);
        this.mTableIdLookup.put(r11, Integer.valueOf(r1));
        String r2 = r6.get(r8[r1]);
        if (r2 == null) goto L7;
        this.mTableNames[r1] = r2.toLowerCase(r0);
    L8:
        r1 = r1 + 1;
        goto L3
    L7:
        this.mTableNames[r1] = r11;
        goto L8
    L9:
        Iterator<Map.Entry<String, String>> r12 = r6.entrySet().iterator();
    L11:
        if (r12.hasNext() == false) goto L15;
        Map.Entry<String, String> r13 = r12.next();
        String r14 = r13.getValue();
        Locale r15 = Locale.US;
        String r16 = r14.toLowerCase(r15);
        if (this.mTableIdLookup.containsKey(r16) == false) goto L11;
        String r17 = r13.getKey().toLowerCase(r15);
        HashMap<String, Integer> r18 = this.mTableIdLookup;
        r18.put(r17, r18.get(r16));
        goto L11
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(RoomDatabase r3, String... r4) {
        this(r3, new HashMap(), Collections.emptyMap(), r4);
    }

    private static void appendTriggerName(StringBuilder r2, String r3, String r4) {
        r2.append("`");
        r2.append("room_table_modification_trigger_");
        r2.append(r3);
        r2.append("_");
        r2.append(r4);
        r2.append("`");
    }

    private String[] resolveViews(String[] r7) {
        HashSet r0 = new HashSet();
        int r1 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        String r3 = r7[r2];
        String r4 = r3.toLowerCase(Locale.US);
        if (this.mViewTables.containsKey(r4) == false) goto L7;
        r0.addAll(this.mViewTables.get(r4));
    L8:
        r2 = r2 + 1;
        goto L3
    L7:
        r0.add(r3);
        goto L8
    L10:
        return (String[]) r0.toArray(new String[r0.size()]);
    }

    private void startTrackingTable(SupportSQLiteDatabase r8, int r9) {
        r8.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + r9 + ", 0)");
        String r7 = this.mTableNames[r9];
        StringBuilder r0 = new StringBuilder();
        String[] r1 = TRIGGERS;
        int r2 = r1.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        String r5 = r1[r4];
        r0.setLength(0);
        r0.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
        appendTriggerName(r0, r7, r5);
        r0.append(" AFTER ");
        r0.append(r5);
        r0.append(" ON `");
        r0.append(r7);
        r0.append("` BEGIN UPDATE ");
        r0.append(UPDATE_TABLE_NAME);
        r0.append(" SET ");
        r0.append(INVALIDATED_COLUMN_NAME);
        r0.append(" = 1");
        r0.append(" WHERE ");
        r0.append(TABLE_ID_COLUMN_NAME);
        r0.append(" = ");
        r0.append(r9);
        r0.append(" AND ");
        r0.append(INVALIDATED_COLUMN_NAME);
        r0.append(" = 0");
        r0.append("; END");
        r8.execSQL(r0.toString());
        r4 = r4 + 1;
        goto L3
    }

    private void stopTrackingTable(SupportSQLiteDatabase r7, int r8) {
        String r6 = this.mTableNames[r8];
        StringBuilder r9 = new StringBuilder();
        String[] r0 = TRIGGERS;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        String r4 = r0[r3];
        r9.setLength(0);
        r9.append("DROP TRIGGER IF EXISTS ");
        appendTriggerName(r9, r6, r4);
        r7.execSQL(r9.toString());
        r3 = r3 + 1;
        goto L3
    }

    private String[] validateAndResolveTableNames(String[] r6) {
        String[] r7 = resolveViews(r6);
        int r0 = r7.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        String r2 = r7[r1];
        if (this.mTableIdLookup.containsKey(r2.toLowerCase(Locale.US)) == false) goto L8;
        r1 = r1 + 1;
        goto L3
    L8:
        throw new IllegalArgumentException("There is no table with name " + r2);
    L9:
        return r7;
    }

    @SuppressLint({"RestrictedApi"})
    @WorkerThread
    public void addObserver(@NonNull Observer r8) {
        String[] r0 = resolveViews(r8.mTables);
        int[] r1 = new int[r0.length];
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L9;
        Integer r4 = this.mTableIdLookup.get(r0[r3].toLowerCase(Locale.US));
        if (r4 == null) goto L8;
        r1[r3] = r4.intValue();
        r3 = r3 + 1;
        goto L3
    L8:
        throw new IllegalArgumentException("There is no table with name " + r0[r3]);
    L9:
        ObserverWrapper r5 = new ObserverWrapper(r8, r1, r0);
        SafeIterableMap<Observer, ObserverWrapper> r6 = this.mObserverMap;
        monitor-enter(r6);
        ObserverWrapper r9 = this.mObserverMap.putIfAbsent(r8, r5);     // Catch: Throwable -> L18
        monitor-exit(r6);     // Catch: Throwable -> L18
        if (r9 == null) goto L15;
        return;
    L15:
        if (this.mObservedTableTracker.onAdded(r1) == false) goto L26;
        syncTriggers();
        return;
    L26:
        return;
    L18:
        th = move-exception;
        throw th;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addWeakObserver(Observer r2) {
        addObserver(new WeakObserver(this, r2));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public <T> LiveData<T> createLiveData(String[] r2, Callable<T> r3) {
        return createLiveData(r2, false, r3);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public <T> LiveData<T> createLiveData(String[] r2, boolean r3, Callable<T> r4) {
        return this.mInvalidationLiveDataContainer.create(validateAndResolveTableNames(r2), r3, r4);
    }

    boolean ensureInitialization() {
        if (this.mDatabase.isOpen() == true) goto L6;
        return false;
    L6:
        if (this.mInitialized == true) goto L9;
        this.mDatabase.getOpenHelper().getWritableDatabase();
    L9:
        if (this.mInitialized == true) goto L12;
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    L12:
        return true;
    }

    void internalInit(SupportSQLiteDatabase r2) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mInitialized == false) goto L8;
        Log.e("ROOM", "Invalidation tracker is initialized twice :/.");     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L8:
        r2.execSQL("PRAGMA temp_store = MEMORY;");     // Catch: Throwable -> L11
        r2.execSQL("PRAGMA recursive_triggers='ON';");     // Catch: Throwable -> L11
        r2.execSQL(CREATE_TRACKING_TABLE_SQL);     // Catch: Throwable -> L11
        syncTriggers(r2);     // Catch: Throwable -> L11
        this.mCleanupStatement = r2.compileStatement(RESET_UPDATED_TABLES_SQL);     // Catch: Throwable -> L11
        this.mInitialized = true;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting(otherwise = 3)
    public void notifyObserversByTableNames(String... r4) {
        SafeIterableMap<Observer, ObserverWrapper> r0 = this.mObserverMap;
        monitor-enter(r0);
        Iterator<Map.Entry<Observer, ObserverWrapper>> r3 = this.mObserverMap.iterator();     // Catch: Throwable -> L12
    L6:
        if (r3.hasNext() == false) goto L10;
        Map.Entry<Observer, ObserverWrapper> r1 = r3.next();     // Catch: Throwable -> L12
        if (r1.getKey().isRemote() == true) goto L6;
        r1.getValue().notifyByTableNames(r4);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void refreshVersionsAsync() {
        if (this.mPendingRefresh.compareAndSet(false, true) == false) goto L6;
        this.mDatabase.getQueryExecutor().execute(this.mRefreshRunnable);
        return;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @WorkerThread
    public void refreshVersionsSync() {
        syncTriggers();
        this.mRefreshRunnable.run();
    }

    @SuppressLint({"RestrictedApi"})
    @WorkerThread
    public void removeObserver(@NonNull Observer r3) {
        SafeIterableMap<Observer, ObserverWrapper> r0 = this.mObserverMap;
        monitor-enter(r0);
        ObserverWrapper r4 = this.mObserverMap.remove(r3);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        if (r4 != null) goto L8;
        return;
    L8:
        if (this.mObservedTableTracker.onRemoved(r4.mTableIds) == false) goto L17;
        syncTriggers();
        return;
    L17:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    void startMultiInstanceInvalidation(Context r3, String r4) {
        this.mMultiInstanceInvalidationClient = new MultiInstanceInvalidationClient(r3, r4, this, this.mDatabase.getQueryExecutor());
    }

    void stopMultiInstanceInvalidation() {
        MultiInstanceInvalidationClient r0 = this.mMultiInstanceInvalidationClient;
        if (r0 == null) goto L6;
        r0.stop();
        this.mMultiInstanceInvalidationClient = null;
        return;
    }

    void syncTriggers() {
        if (this.mDatabase.isOpen() == true) goto L5;
        return;
    L5:
        syncTriggers(this.mDatabase.getOpenHelper().getWritableDatabase());
    }

    void syncTriggers(SupportSQLiteDatabase r7) {
        if (r7.inTransaction() == false) goto L38;
        return;
    L38:
        Lock r0 = this.mDatabase.getCloseLock();     // Catch: Throwable -> L31
        r0.lock();     // Catch: Throwable -> L31
        int[] r1 = this.mObservedTableTracker.getTablesToSync();     // Catch: Throwable -> L28
        if (r1 == null) goto L8;
        int r2 = r1.length;     // Catch: Throwable -> L28
        r7.beginTransaction();     // Catch: Throwable -> L28
        int r3 = 0;
    L12:
        if (r3 >= r2) goto L21;
        int r4 = r1[r3];     // Catch: Throwable -> L25
        if (r4 != 1) goto L16;
        startTrackingTable(r7, r3);     // Catch: Throwable -> L25
    L20:
        r3 = r3 + 1;     // Catch: Throwable -> L25
        goto L12
    L16:
        if (r4 != 2) goto L20;
        stopTrackingTable(r7, r3);     // Catch: Throwable -> L25
        goto L20
    L25:
        th = move-exception;
        r7.endTransaction();     // Catch: Throwable -> L28
        throw th;     // Catch: Throwable -> L28
    L21:
        r7.setTransactionSuccessful();     // Catch: Throwable -> L25
        r7.endTransaction();     // Catch: Throwable -> L28
        this.mObservedTableTracker.onSyncCompleted();     // Catch: Throwable -> L28
        r0.unlock();     // Catch: Throwable -> L31 Throwable -> L31
        goto L38
    L8:
        r0.unlock();     // Catch: Throwable -> L31 Throwable -> L31
        return;
    L28:
        th = move-exception;
        r0.unlock();     // Catch: Throwable -> L31 Throwable -> L31
        throw th;     // Catch: Throwable -> L31 Throwable -> L31
    L31:
        e = move-exception;
        Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
    }
}
