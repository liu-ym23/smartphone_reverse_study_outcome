package com.tencent.wcdb.database;

import android.os.SystemClock;
import android.util.Printer;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;
import com.tencent.wcdb.support.OperationCanceledException;
import com.tencent.wcdb.support.PrefixPrinter;
import java.io.Closeable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;
import obric.tablet.widget.BytedanceJustifyTextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class SQLiteConnectionPool implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CONNECTION_FLAG_INTERACTIVE = 4;
    public static final int CONNECTION_FLAG_PRIMARY_CONNECTION_AFFINITY = 2;
    public static final int CONNECTION_FLAG_READ_ONLY = 1;
    private static final long CONNECTION_POOL_BUSY_MILLIS = 3000;
    private static final int OPEN_FLAG_REOPEN_MASK = 268435473;
    private static final String TAG = "WCDB.SQLiteConnectionPool";
    private final WeakHashMap<SQLiteConnection, AcquiredConnectionStatus> mAcquiredConnections;
    private final ArrayList<SQLiteConnection> mAvailableNonPrimaryConnections;
    private SQLiteConnection mAvailablePrimaryConnection;
    private volatile SQLiteChangeListener mChangeListener;
    private volatile SQLiteCheckpointListener mCheckpointListener;
    private SQLiteCipherSpec mCipher;
    private final SQLiteDatabaseConfiguration mConfiguration;
    private final AtomicBoolean mConnectionLeaked;
    private ConnectionWaiter mConnectionWaiterPool;
    private ConnectionWaiter mConnectionWaiterQueue;
    private final WeakReference<SQLiteDatabase> mDB;
    private boolean mIsOpen;
    private final Object mLock;
    private int mMaxConnectionPoolSize;
    private int mNextConnectionId;
    private byte[] mPassword;
    private volatile SQLiteTrace mTraceCallback;

    static final enum AcquiredConnectionStatus extends Enum<AcquiredConnectionStatus> {
        private static final /* synthetic */ AcquiredConnectionStatus[] $VALUES = null;
        public static final AcquiredConnectionStatus DISCARD = null;
        public static final AcquiredConnectionStatus NORMAL = null;
        public static final AcquiredConnectionStatus RECONFIGURE = null;

        private AcquiredConnectionStatus(String r1, int r2) {
            super(r1, r2);
        }

        public static AcquiredConnectionStatus valueOf(String r1) {
            return (AcquiredConnectionStatus) Enum.valueOf(AcquiredConnectionStatus.class, r1);
        }

        public static AcquiredConnectionStatus[] values() {
            return (AcquiredConnectionStatus[]) $VALUES.clone();
        }

        static {
            AcquiredConnectionStatus r0 = new AcquiredConnectionStatus("NORMAL", 0);
            NORMAL = r0;
            AcquiredConnectionStatus r1 = new AcquiredConnectionStatus("RECONFIGURE", 1);
            RECONFIGURE = r1;
            AcquiredConnectionStatus r3 = new AcquiredConnectionStatus("DISCARD", 2);
            DISCARD = r3;
            $VALUES = new AcquiredConnectionStatus[]{r0, r1, r3};
        }
    }

    private static class ConnectionPoolBusyInfo {
        int activeConnections;
        ArrayList<String> activeOperationDescriptions;
        ArrayList<SQLiteTrace.TraceInfo<String>> activeSql;
        ArrayList<SQLiteTrace.TraceInfo<StackTraceElement[]>> activeTransactions;
        int availableConnections;
        int idleConnections;
        String label;

        private ConnectionPoolBusyInfo() {
            this.activeOperationDescriptions = new ArrayList();
            this.activeSql = new ArrayList();
            this.activeTransactions = new ArrayList();
        }

        /* synthetic */ ConnectionPoolBusyInfo(AnonymousClass1 r1) {
            this();
        }
    }

    private static final class ConnectionWaiter {
        public SQLiteConnection mAssignedConnection;
        public int mConnectionFlags;
        public RuntimeException mException;
        public ConnectionWaiter mNext;
        public int mNonce;
        public int mPriority;
        public String mSql;
        public long mStartTime;
        public Thread mThread;
        public boolean mWantPrimaryConnection;

        private ConnectionWaiter() {
        }

        /* synthetic */ ConnectionWaiter(AnonymousClass1 r1) {
            this();
        }
    }

    static {
    }

    private static int getPriority(int r0) {
        if ((r0 & 4) == 0) goto L5;
        return 1;
    L5:
        return 0;
    }

    static /* synthetic */ Object access$000(SQLiteConnectionPool r0) {
        return r0.mLock;
    }

    static /* synthetic */ void access$100(SQLiteConnectionPool r0, ConnectionWaiter r1) {
        r0.cancelConnectionWaiterLocked(r1);
    }

    private SQLiteConnectionPool(SQLiteDatabase r2, SQLiteDatabaseConfiguration r3, int r4) {
        this.mLock = new Object();
        this.mConnectionLeaked = new AtomicBoolean();
        this.mAvailableNonPrimaryConnections = new ArrayList();
        this.mAcquiredConnections = new WeakHashMap();
        this.mDB = new WeakReference(r2);
        this.mConfiguration = new SQLiteDatabaseConfiguration(r3);
        setMaxConnectionPoolSizeLocked(r4);
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

    public static SQLiteConnectionPool open(SQLiteDatabase r1, SQLiteDatabaseConfiguration r2, byte[] r3, SQLiteCipherSpec r4) {
        return open(r1, r2, r3, r4, 1);
    }

    public static SQLiteConnectionPool open(SQLiteDatabase r1, SQLiteDatabaseConfiguration r2, byte[] r3, SQLiteCipherSpec r4, int r5) {
        if (r2 == null) goto L10;
        SQLiteConnectionPool r0 = new SQLiteConnectionPool(r1, r2, r5);
        r0.mPassword = r3;
        if (r4 != null) goto L6;
        SQLiteCipherSpec r6 = null;
    L7:
        r0.mCipher = r6;
        r0.open();
        return r0;
    L6:
        r6 = new SQLiteCipherSpec(r4);
        goto L7
    L10:
        throw new IllegalArgumentException("configuration must not be null.");
    }

    private void open() {
        this.mAvailablePrimaryConnection = openConnectionLocked(this.mConfiguration, true);
        this.mIsOpen = true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        dispose(false);
    }

    private void dispose(boolean r5) {
        if (r5 == true) goto L15;
        Object r6 = this.mLock;
        monitor-enter(r6);
        throwIfClosedLocked();     // Catch: Throwable -> L12
        this.mIsOpen = false;     // Catch: Throwable -> L12
        closeAvailableConnectionsAndLogExceptionsLocked();     // Catch: Throwable -> L12
        int r1 = this.mAcquiredConnections.size();     // Catch: Throwable -> L12
        if (r1 == 0) goto L9;
        Log.i(TAG, "The connection pool for " + this.mConfiguration.label + " has been closed but there are still " + r1 + " connections in use.  They will be closed as they are released back to the pool.");     // Catch: Throwable -> L12
    L9:
        wakeConnectionWaitersLocked();     // Catch: Throwable -> L12
        monitor-exit(r6);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void reconfigure(SQLiteDatabaseConfiguration r7) {
        if (r7 == null) goto L43;
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfClosedLocked();     // Catch: Throwable -> L39
        if (((r7.openFlags ^ this.mConfiguration.openFlags) & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) == 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L16;
        if (this.mAcquiredConnections.isEmpty() == false) goto L14;
        closeAvailableNonPrimaryConnectionsAndLogExceptionsLocked();     // Catch: Throwable -> L39
        goto L16
    L14:
        throw new IllegalStateException("Write Ahead Logging (WAL) mode cannot be enabled or disabled while there are transactions in progress.  Finish all transactions and release all active database connections first.");     // Catch: Throwable -> L39
    L16:
        if (r7.foreignKeyConstraintsEnabled == this.mConfiguration.foreignKeyConstraintsEnabled) goto L18;
        boolean r4 = true;
    L19:
        if (r4 == false) goto L26;
        if (this.mAcquiredConnections.isEmpty() == true) goto L26;
        throw new IllegalStateException("Foreign Key Constraints cannot be enabled or disabled while there are transactions in progress.  Finish all transactions and release all active database connections first.");     // Catch: Throwable -> L39
    L26:
        if (((this.mConfiguration.openFlags ^ r7.openFlags) & OPEN_FLAG_REOPEN_MASK) == 0) goto L28;
    L33:
        if (r1 == false) goto L35;
        closeAvailableConnectionsAndLogExceptionsLocked();     // Catch: Throwable -> L39
    L35:
        SQLiteConnection r2 = openConnectionLocked(r7, true);     // Catch: Throwable -> L39
        closeAvailableConnectionsAndLogExceptionsLocked();     // Catch: Throwable -> L39
        discardAcquiredConnectionsLocked();     // Catch: Throwable -> L39
        this.mAvailablePrimaryConnection = r2;     // Catch: Throwable -> L39
        this.mConfiguration.updateParametersFrom(r7);     // Catch: Throwable -> L39
        setMaxConnectionPoolSizeLocked(0);     // Catch: Throwable -> L39
    L36:
        wakeConnectionWaitersLocked();     // Catch: Throwable -> L39
        monitor-exit(r0);     // Catch: Throwable -> L39
        return;
    L28:
        if (DatabaseUtils.objectEquals(this.mConfiguration.vfsName, r7.vfsName) == false) goto L33;
        if (r7.extensions.containsAll(this.mConfiguration.extensions) == false) goto L33;
        this.mConfiguration.updateParametersFrom(r7);     // Catch: Throwable -> L39
        setMaxConnectionPoolSizeLocked(0);     // Catch: Throwable -> L39
        closeExcessConnectionsAndLogExceptionsLocked();     // Catch: Throwable -> L39
        reconfigureAllConnectionsLocked();     // Catch: Throwable -> L39
        goto L36
    L18:
        r4 = false;
        goto L19
    L8:
        r1 = false;
    L39:
        th = move-exception;
        throw th;
    L43:
        throw new IllegalArgumentException("configuration must not be null.");
    }

    public SQLiteConnection acquireConnection(String r9, int r10, CancellationSignal r11) {
        long r0 = SystemClock.uptimeMillis();
        SQLiteConnection r12 = waitForConnection(r9, r10, r11);
        SQLiteTrace r2 = this.mTraceCallback;
        if (r2 == null) goto L11;
        long r5 = SystemClock.uptimeMillis() - r0;
        SQLiteDatabase r3 = this.mDB.get();
        if (r3 == null) goto L11;
        if ((r10 & 2) == 0) goto L9;
        boolean r8 = true;
    L10:
        r2.onConnectionObtained(r3, r9, r5, r8);
        goto L11
    L9:
        r8 = false;
    L11:
        return r12;
    }

    public void releaseConnection(SQLiteConnection r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        AcquiredConnectionStatus r1 = this.mAcquiredConnections.remove(r5);     // Catch: Throwable -> L26
        if (r1 == null) goto L25;
        if (this.mIsOpen == true) goto L10;
        closeConnectionAndLogExceptionsLocked(r5);     // Catch: Throwable -> L26
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L26
        return;
    L10:
        if (r5.isPrimaryConnection() == false) goto L16;
        if (recycleConnectionLocked(r5, r1) == false) goto L14;
        this.mAvailablePrimaryConnection = r5;     // Catch: Throwable -> L26
    L14:
        wakeConnectionWaitersLocked();     // Catch: Throwable -> L26
        goto L22
    L16:
        if (this.mAvailableNonPrimaryConnections.size() < (this.mMaxConnectionPoolSize - 1)) goto L19;
        closeConnectionAndLogExceptionsLocked(r5);     // Catch: Throwable -> L26
        goto L22
    L19:
        if (recycleConnectionLocked(r5, r1) == false) goto L21;
        this.mAvailableNonPrimaryConnections.add(r5);     // Catch: Throwable -> L26
    L21:
        wakeConnectionWaitersLocked();     // Catch: Throwable -> L26
        goto L22
    L25:
        throw new IllegalStateException("Cannot perform this operation because the specified connection was not acquired from this pool or has already been released.");     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    private boolean recycleConnectionLocked(SQLiteConnection r5, AcquiredConnectionStatus r6) {
        if (r6 != AcquiredConnectionStatus.RECONFIGURE) goto L9;
        r5.reconfigure(this.mConfiguration);     // Catch: RuntimeException -> L6
    L6:
        e = move-exception;
        Log.e(TAG, "Failed to reconfigure released connection, closing it: " + r5, new Object[]{e});
        r6 = AcquiredConnectionStatus.DISCARD;
    L9:
        if (r6 != AcquiredConnectionStatus.DISCARD) goto L12;
        closeConnectionAndLogExceptionsLocked(r5);
        return false;
    L12:
        return true;
    }

    public boolean shouldYieldConnection(SQLiteConnection r3, int r4) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mAcquiredConnections.containsKey(r3) == false) goto L15;
        if (this.mIsOpen == true) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L16
        return false;
    L11:
        boolean r2 = isSessionBlockingImportantConnectionWaitersLocked(r3.isPrimaryConnection(), r4);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return r2;
    L15:
        throw new IllegalStateException("Cannot perform this operation because the specified connection was not acquired from this pool or has already been released.");     // Catch: Throwable -> L16
    }

    public void collectDbStats(ArrayList<SQLiteDebug.DbStats> r4) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        SQLiteConnection r1 = this.mAvailablePrimaryConnection;     // Catch: Throwable -> L17
        if (r1 == null) goto L7;
        r1.collectDbStats(r4);     // Catch: Throwable -> L17
    L7:
        Iterator<SQLiteConnection> r2 = this.mAvailableNonPrimaryConnections.iterator();     // Catch: Throwable -> L17
    L9:
        if (r2.hasNext() == false) goto L11;
        r2.next().collectDbStats(r4);     // Catch: Throwable -> L17
        goto L9
    L11:
        Iterator<SQLiteConnection> r3 = this.mAcquiredConnections.keySet().iterator();     // Catch: Throwable -> L17
    L13:
        if (r3.hasNext() == false) goto L15;
        r3.next().collectDbStatsUnsafe(r4);     // Catch: Throwable -> L17
        goto L13
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    private SQLiteConnection openConnectionLocked(SQLiteDatabaseConfiguration r7, boolean r8) {
        int r2 = this.mNextConnectionId;
        this.mNextConnectionId = r2 + 1;
        return SQLiteConnection.open(this, r7, r2, r8, this.mPassword, this.mCipher);
    }

    void onConnectionLeaked() {
        Log.w(TAG, "A SQLiteConnection object for database '" + this.mConfiguration.label + "' was leaked!  Please fix your application to end transactions in progress properly and to close the database when it is no longer needed.");
        this.mConnectionLeaked.set(true);
    }

    private void closeAvailableConnectionsAndLogExceptionsLocked() {
        closeAvailableNonPrimaryConnectionsAndLogExceptionsLocked();
        SQLiteConnection r0 = this.mAvailablePrimaryConnection;
        if (r0 == null) goto L6;
        closeConnectionAndLogExceptionsLocked(r0);
        this.mAvailablePrimaryConnection = null;
        return;
    }

    private void closeAvailableNonPrimaryConnectionsAndLogExceptionsLocked() {
        int r0 = this.mAvailableNonPrimaryConnections.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        closeConnectionAndLogExceptionsLocked(this.mAvailableNonPrimaryConnections.get(r1));
        r1 = r1 + 1;
        goto L3
    L5:
        this.mAvailableNonPrimaryConnections.clear();
    }

    private void closeExcessConnectionsAndLogExceptionsLocked() {
        int r0 = this.mAvailableNonPrimaryConnections.size();
    L3:
        int r1 = r0 - 1;
        if (r0 <= (this.mMaxConnectionPoolSize - 1)) goto L6;
        closeConnectionAndLogExceptionsLocked(this.mAvailableNonPrimaryConnections.remove(r1));
        r0 = r1;
        goto L3
    }

    private void closeConnectionAndLogExceptionsLocked(SQLiteConnection r3) {
        r3.close();     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "Failed to close connection, its fate is now in the hands of the merciful GC: " + r3 + e.getMessage());
    }

    private void discardAcquiredConnectionsLocked() {
        markAcquiredConnectionsLocked(AcquiredConnectionStatus.DISCARD);
    }

    private void reconfigureAllConnectionsLocked() {
        SQLiteConnection r0 = this.mAvailablePrimaryConnection;
        if (r0 != null) goto L20;
    L8:
        int r1 = this.mAvailableNonPrimaryConnections.size();
        int r4 = 0;
    L9:
        if (r4 >= r1) goto L16;
        SQLiteConnection r5 = this.mAvailableNonPrimaryConnections.get(r4);
        r5.reconfigure(this.mConfiguration);     // Catch: RuntimeException -> L13
    L15:
        r4 = r4 + 1;
    L13:
        e = move-exception;
        Log.e(TAG, "Failed to reconfigure available non-primary connection, closing it: " + r5, new Object[]{e});
        closeConnectionAndLogExceptionsLocked(r5);
        this.mAvailableNonPrimaryConnections.remove(r4);
        r1 = r1 - 1;
        r4 = r4 - 1;
        goto L15
    L16:
        markAcquiredConnectionsLocked(AcquiredConnectionStatus.RECONFIGURE);
        return;
    L20:
        r0.reconfigure(this.mConfiguration);     // Catch: RuntimeException -> L6
    L6:
        e = move-exception;
        Log.e(TAG, "Failed to reconfigure available primary connection, closing it: " + this.mAvailablePrimaryConnection, new Object[]{e});
        closeConnectionAndLogExceptionsLocked(this.mAvailablePrimaryConnection);
        this.mAvailablePrimaryConnection = null;
        goto L8
    }

    private void markAcquiredConnectionsLocked(AcquiredConnectionStatus r6) {
        if (this.mAcquiredConnections.isEmpty() == true) goto L15;
        ArrayList r0 = new ArrayList(this.mAcquiredConnections.size());
        Iterator<Map.Entry<SQLiteConnection, AcquiredConnectionStatus>> r1 = this.mAcquiredConnections.entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L12;
        Map.Entry<SQLiteConnection, AcquiredConnectionStatus> r2 = r1.next();
        AcquiredConnectionStatus r3 = r2.getValue();
        if (r6 == r3) goto L6;
        if (r3 == AcquiredConnectionStatus.DISCARD) goto L6;
        r0.add(r2.getKey());
        goto L6
    L12:
        int r4 = r0.size();
        int r5 = 0;
    L13:
        if (r5 >= r4) goto L24;
        this.mAcquiredConnections.put((SQLiteConnection) r0.get(r5), r6);
        r5 = r5 + 1;
        goto L13
    L24:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v6, types: [long] */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11, types: [com.tencent.wcdb.support.CancellationSignal$OnCancelListener] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.tencent.wcdb.support.CancellationSignal$OnCancelListener] */
    /* JADX WARN: Type inference failed for: r2v8, types: [long] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r30v0, types: [com.tencent.wcdb.support.CancellationSignal] */
    private SQLiteConnection waitForConnection(String r28, int r29, CancellationSignal r30) {
        if ((r29 & 2) == 0) goto L5;
        boolean r21 = true;
    L6:
        Object r13 = this.mLock;
        monitor-enter(r13);
        throwIfClosedLocked();     // Catch: Throwable -> L88
        if (r30 == 0) goto L11;
        r30.throwIfCanceled();     // Catch: Throwable -> L88
    L11:
        ConnectionPoolBusyInfo r15 = null;
        if (r21 == true) goto L14;
        SQLiteConnection r1 = tryAcquireNonPrimaryConnectionLocked(r28, r29);     // Catch: Throwable -> L88
    L15:
        if (r1 != null) goto L17;
        r1 = tryAcquirePrimaryConnectionLocked(r29);     // Catch: Throwable -> L88
    L17:
        if (r1 == null) goto L20;
        monitor-exit(r13);     // Catch: Throwable -> L88
        return r1;
    L20:
        int r14 = getPriority(r29);     // Catch: Throwable -> L88
        final ConnectionWaiter r2 = obtainConnectionWaiterLocked(Thread.currentThread(), SystemClock.uptimeMillis(), r14, r21, r28, r29);     // Catch: Throwable -> L88
        ConnectionWaiter r3 = this.mConnectionWaiterQueue;     // Catch: Throwable -> L88
        ConnectionWaiter r4 = null;
    L21:
        if (r3 == null) goto L26;
        if (r14 > r3.mPriority) goto L24;
        r4 = r3;
        r3 = r3.mNext;     // Catch: Throwable -> L88
        goto L21
    L24:
        r2.mNext = r3;     // Catch: Throwable -> L88
    L26:
        if (r4 == null) goto L28;
        r4.mNext = r2;     // Catch: Throwable -> L88
    L29:
        final int r5 = r2.mNonce;     // Catch: Throwable -> L88
        monitor-exit(r13);     // Catch: Throwable -> L88
        if (r30 == 0) goto L101;
        r30.setOnCancelListener(new AnonymousClass1(this, r2, r5));
    L101:
        long r6 = 3000;
        ?? r7 = r2.mStartTime + 3000;     // Catch: Throwable -> L83
    L35:
        if (this.mConnectionLeaked.compareAndSet(true, false) == false) goto L44;
        Object r8 = this.mLock;     // Catch: Throwable -> L83
        monitor-enter(r8);     // Catch: Throwable -> L83
        wakeConnectionWaitersLocked();     // Catch: Throwable -> L41
        monitor-exit(r8);     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        throw th;     // Catch: Throwable -> L83
    L44:
        LockSupport.parkNanos(r6 * 1000000);     // Catch: Throwable -> L83
        Thread.interrupted();     // Catch: Throwable -> L83
        Object r9 = this.mLock;     // Catch: Throwable -> L83
        monitor-enter(r9);     // Catch: Throwable -> L83
        throwIfClosedLocked();     // Catch: Throwable -> L75
        SQLiteConnection r10 = r2.mAssignedConnection;     // Catch: Throwable -> L75
        RuntimeException r11 = r2.mException;     // Catch: Throwable -> L75
        if (r10 != null) goto L67;
        if (r11 != null) goto L67;
        long r12 = SystemClock.uptimeMillis();     // Catch: Throwable -> L75
        if (r12 >= r7) goto L53;
        ?? r22 = r7;
        long r24 = r12 - r7;     // Catch: Throwable -> L75
        ConnectionPoolBusyInfo r16 = r15;
    L54:
        monitor-exit(r9);     // Catch: Throwable -> L75
        if (r16 == null) goto L65;
        long r17 = r12 - r2.mStartTime;     // Catch: Throwable -> L83
        logConnectionPoolBusy(r16, r17, r29);     // Catch: Throwable -> L83
        SQLiteDatabase r18 = this.mDB.get();     // Catch: Throwable -> L83
        SQLiteTrace r19 = this.mTraceCallback;     // Catch: Throwable -> L83
        if (r18 == null) goto L65;
        if (r19 == null) goto L65;
        ConnectionPoolBusyInfo r20 = r15;
        r19.onConnectionPoolBusy(r18, r28, r17, r21, r16.activeSql, r16.activeTransactions);     // Catch: Throwable -> L63
    L66:
        r15 = r20;
        r7 = r22;
        r6 = r24;
    L63:
        th = th;
        r7 = r20;
    L85:
        if (r30 == 0) goto L87;
        r30.setOnCancelListener(r7);
    L87:
        throw th;
    L65:
        r20 = r15;
        goto L66
    L53:
        r16 = gatherConnectionPoolBusyInfoLocked();     // Catch: Throwable -> L75
        r24 = 3000;
        r22 = r12 + 3000;     // Catch: Throwable -> L75
    L67:
        ?? r23 = r15;
        recycleConnectionWaiterLocked(r2);     // Catch: Throwable -> L81
        if (r10 == null) goto L74;
        monitor-exit(r9);     // Catch: Throwable -> L81
        if (r30 == 0) goto L73;
        r30.setOnCancelListener(r23);
    L73:
        return r10;
    L74:
        throw r11;     // Catch: Throwable -> L81
    L75:
        th = th;
        r7 = r15;
    L77:
        monitor-exit(r9);     // Catch: Throwable -> L81
        throw th;     // Catch: Throwable -> L79
    L79:
        th = th;
    L81:
        th = th;
    L83:
        th = th;
        r7 = r15;
        goto L85
    L28:
        this.mConnectionWaiterQueue = r2;     // Catch: Throwable -> L88
        goto L29
    L14:
        r1 = null;
    L88:
        th = move-exception;
        throw th;
    L5:
        r21 = false;
        goto L6
    }

    private void cancelConnectionWaiterLocked(ConnectionWaiter r4) {
        if (r4.mAssignedConnection == null) goto L5;
        return;
    L5:
        if (r4.mException != null) goto L17;
        ConnectionWaiter r0 = this.mConnectionWaiterQueue;
        ConnectionWaiter r1 = null;
    L8:
        if (r0 == r4) goto L10;
        r1 = r0;
        r0 = r0.mNext;
        goto L8
    L10:
        if (r1 == null) goto L12;
        r1.mNext = r4.mNext;
    L13:
        r4.mException = new OperationCanceledException();
        LockSupport.unpark(r4.mThread);
        wakeConnectionWaitersLocked();
        return;
    L12:
        this.mConnectionWaiterQueue = r4.mNext;
        goto L13
    }

    private void logConnectionPoolBusy(ConnectionPoolBusyInfo r4, long r5, int r7) {
        StringBuilder r3 = new StringBuilder();
        if (r5 == 0) goto L5;
        Thread r0 = Thread.currentThread();
        r3.append("The connection pool for database '").append(r4.label);
        r3.append("' has been unable to grant a connection to thread ");
        r3.append(r0.getId()).append(" (").append(r0.getName()).append(") with flags 0x");
        r3.append(Integer.toHexString(r7));
        r3.append(" for ").append(r5 * 0.001f).append(" seconds.\n");
    L5:
        r3.append("Connections: ").append(r4.activeConnections).append(" active, ");
        r3.append(r4.idleConnections).append(" idle, ");
        r3.append(r4.availableConnections).append(" available.\n");
        if (r4.activeOperationDescriptions.isEmpty() == true) goto L11;
        r3.append("\nRequests in progress:\n");
        Iterator<String> r6 = r4.activeOperationDescriptions.iterator();
    L9:
        if (r6.hasNext() == false) goto L11;
        r3.append(BytedanceJustifyTextView.TWO_BLANK).append(r6.next()).append("\n");
    L11:
        Log.w(TAG, r3.toString());
    }

    private ConnectionPoolBusyInfo gatherConnectionPoolBusyInfoLocked() {
        ConnectionPoolBusyInfo r0 = new ConnectionPoolBusyInfo(null);
        r0.activeConnections = 0;
        r0.idleConnections = 0;
        if (this.mAcquiredConnections.isEmpty() == true) goto L17;
        Iterator<SQLiteConnection> r1 = this.mAcquiredConnections.keySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L17;
        SQLiteConnection r2 = r1.next();
        SQLiteTrace.TraceInfo<StackTraceElement[]> r3 = r2.tracePersistAcquisitionUnsafe();
        if (r3 == null) goto L10;
        r0.activeTransactions.add(r3);
    L10:
        SQLiteTrace.TraceInfo<String> r4 = r2.traceCurrentOperationUnsafe();
        if (r4 != null) goto L12;
        r0.idleConnections++;
        goto L6
    L12:
        r0.activeSql.add(r4);
        String r5 = r2.describeCurrentOperationUnsafe();
        if (r5 == null) goto L15;
        r0.activeOperationDescriptions.add(r5);
    L15:
        r0.activeConnections++;
    L17:
        r0.availableConnections = this.mAvailableNonPrimaryConnections.size();
        if (this.mAvailablePrimaryConnection == null) goto L20;
        r0.availableConnections++;
    L20:
        return r0;
    }

    private void wakeConnectionWaitersLocked() {
        ConnectionWaiter r0 = this.mConnectionWaiterQueue;
        ConnectionWaiter r4 = null;
        boolean r3 = false;
        boolean r5 = false;
    L3:
        if (r0 == null) goto L36;
        boolean r7 = true;
        if (this.mIsOpen == true) goto L37;
    L28:
        ConnectionWaiter r6 = r0.mNext;
        if (r7 == false) goto L34;
        if (r4 == null) goto L32;
        r4.mNext = r6;
    L33:
        r0.mNext = null;
        LockSupport.unpark(r0.mThread);
    L35:
        r0 = r6;
        goto L3
    L32:
        this.mConnectionWaiterQueue = r6;
        goto L33
    L34:
        r4 = r0;
        goto L35
    L37:
        if (r0.mWantPrimaryConnection == true) goto L13;
        if (r3 == true) goto L13;
        SQLiteConnection r8 = tryAcquireNonPrimaryConnectionLocked(r0.mSql, r0.mConnectionFlags);     // Catch: RuntimeException -> L26
        if (r8 != null) goto L14;
        r3 = true;
    L14:
        if (r8 != null) goto L19;
        if (r5 == true) goto L19;
        r8 = tryAcquirePrimaryConnectionLocked(r0.mConnectionFlags);     // Catch: RuntimeException -> L26
        if (r8 != null) goto L19;
        r5 = true;
    L19:
        if (r8 == null) goto L22;
        r0.mAssignedConnection = r8;     // Catch: RuntimeException -> L26
        goto L28
    L22:
        if (r3 == false) goto L25;
        if (r5 == false) goto L25;
        return;
    L25:
        r7 = false;
    L13:
        r8 = null;
    L26:
        e = move-exception;
        r0.mException = e;
        goto L28
    }

    private SQLiteConnection tryAcquirePrimaryConnectionLocked(int r4) {
        SQLiteConnection r0 = this.mAvailablePrimaryConnection;
        if (r0 == null) goto L6;
        this.mAvailablePrimaryConnection = null;
        finishAcquireConnectionLocked(r0, r4);
        return r0;
    L6:
        Iterator<SQLiteConnection> r1 = this.mAcquiredConnections.keySet().iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        if (r1.next().isPrimaryConnection() == false) goto L8;
        return null;
    L12:
        SQLiteConnection r2 = openConnectionLocked(this.mConfiguration, true);
        finishAcquireConnectionLocked(r2, r4);
        return r2;
    }

    private SQLiteConnection tryAcquireNonPrimaryConnectionLocked(String r7, int r8) {
        int r0 = this.mAvailableNonPrimaryConnections.size();
        if (r0 <= 1) goto L12;
        if (r7 == null) goto L12;
        int r3 = 0;
    L6:
        if (r3 >= r0) goto L12;
        SQLiteConnection r4 = this.mAvailableNonPrimaryConnections.get(r3);
        if (r4.isPreparedStatementInCache(r7) == true) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        this.mAvailableNonPrimaryConnections.remove(r3);
        finishAcquireConnectionLocked(r4, r8);
        return r4;
    L12:
        if (r0 <= 0) goto L15;
        SQLiteConnection r9 = this.mAvailableNonPrimaryConnections.remove(r0 - 1);
        finishAcquireConnectionLocked(r9, r8);
        return r9;
    L15:
        int r10 = this.mAcquiredConnections.size();
        if (this.mAvailablePrimaryConnection == null) goto L19;
        r10 = r10 + 1;
    L19:
        if (r10 < this.mMaxConnectionPoolSize) goto L22;
        return null;
    L22:
        SQLiteConnection r11 = openConnectionLocked(this.mConfiguration, false);
        finishAcquireConnectionLocked(r11, r8);
        return r11;
    }

    private void finishAcquireConnectionLocked(SQLiteConnection r4, int r5) {
        if ((r5 & 1) == 0) goto L5;
        boolean r0 = true;
    L11:
        r4.setOnlyAllowReadOnlyOperations(r0);     // Catch: RuntimeException -> L8
        this.mAcquiredConnections.put(r4, AcquiredConnectionStatus.NORMAL);     // Catch: RuntimeException -> L8
        return;
    L8:
        e = move-exception;
        Log.e(TAG, "Failed to prepare acquired connection for session, closing it: " + r4 + ", connectionFlags=" + r5);
        closeConnectionAndLogExceptionsLocked(r4);
        throw e;
    L5:
        r0 = false;
        goto L11
    }

    private boolean isSessionBlockingImportantConnectionWaitersLocked(boolean r2, int r3) {
        ConnectionWaiter r1 = this.mConnectionWaiterQueue;
        if (r1 == null) goto L17;
        int r4 = getPriority(r3);
    L6:
        if (r4 > r1.mPriority) goto L25;
        if (r2 == true) goto L15;
        if (r1.mWantPrimaryConnection == false) goto L24;
        r1 = r1.mNext;
        if (r1 != null) goto L6;
        return false;
    L24:
        return true;
    L15:
        return true;
    L25:
        return false;
    L17:
        return false;
    }

    private void setMaxConnectionPoolSizeLocked(int r3) {
        if (r3 <= 0) goto L5;
    L8:
        this.mMaxConnectionPoolSize = r3;
        Log.i(TAG, "Max connection pool size is %d.", new Object[]{Integer.valueOf(r3)});
        return;
    L5:
        if ((this.mConfiguration.openFlags & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) == 0) goto L7;
        r3 = 4;
        goto L8
    L7:
        r3 = 1;
        goto L8
    }

    private void throwIfClosedLocked() {
        if (this.mIsOpen == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Cannot perform this operation because the connection pool has been closed.");
    }

    private ConnectionWaiter obtainConnectionWaiterLocked(Thread r4, long r5, int r7, boolean r8, String r9, int r10) {
        ConnectionWaiter r0 = this.mConnectionWaiterPool;
        AnonymousClass1 r1 = null;
        if (r0 == null) goto L5;
        this.mConnectionWaiterPool = r0.mNext;
        r0.mNext = null;
    L6:
        r0.mThread = r4;
        r0.mStartTime = r5;
        r0.mPriority = r7;
        r0.mWantPrimaryConnection = r8;
        r0.mSql = r9;
        r0.mConnectionFlags = r10;
        return r0;
    L5:
        r0 = new ConnectionWaiter(r1);
        goto L6
    }

    private void recycleConnectionWaiterLocked(ConnectionWaiter r2) {
        r2.mNext = this.mConnectionWaiterPool;
        r2.mThread = null;
        r2.mSql = null;
        r2.mAssignedConnection = null;
        r2.mException = null;
        r2.mNonce++;
        this.mConnectionWaiterPool = r2;
    }

    SQLiteChangeListener getChangeListener() {
        return this.mChangeListener;
    }

    void setChangeListener(SQLiteChangeListener r4, boolean r5) {
        if (r4 == null) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L8;
        r5 = false;
    L8:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L11:
        if (this.mConfiguration.updateNotificationEnabled == r1) goto L13;
    L14:
        this.mConfiguration.updateNotificationEnabled = r1;     // Catch: Throwable -> L18
        this.mConfiguration.updateNotificationRowID = r5;     // Catch: Throwable -> L18
        closeExcessConnectionsAndLogExceptionsLocked();     // Catch: Throwable -> L18
        reconfigureAllConnectionsLocked();     // Catch: Throwable -> L18
    L15:
        this.mChangeListener = r4;     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L13:
        if (this.mConfiguration.updateNotificationRowID == r5) goto L15;
    L5:
        r1 = false;
        goto L6
    }

    void notifyChanges(String r9, String r10, long[] r11, long[] r12, long[] r13) {
        SQLiteDatabase r2 = this.mDB.get();
        SQLiteChangeListener r1 = this.mChangeListener;
        if (r1 == null) goto L8;
        if (r2 == null) goto L9;
        r1.onChange(r2, r9, r10, r11, r12, r13);
        return;
    L9:
        return;
    }

    SQLiteTrace getTraceCallback() {
        return this.mTraceCallback;
    }

    void setTraceCallback(SQLiteTrace r1) {
        this.mTraceCallback = r1;
    }

    void traceExecute(String r8, int r9, long r10) {
        SQLiteDatabase r2 = this.mDB.get();
        SQLiteTrace r1 = this.mTraceCallback;
        if (r1 == null) goto L8;
        if (r2 == null) goto L9;
        r1.onSQLExecuted(r2, r8, r9, r10);
        return;
    L9:
        return;
    }

    SQLiteCheckpointListener getCheckpointListener() {
        return this.mCheckpointListener;
    }

    void setCheckpointListener(SQLiteCheckpointListener r3) {
        SQLiteDatabase r0 = this.mDB.get();
        if (this.mCheckpointListener == null) goto L5;
        this.mCheckpointListener.onDetach(r0);
    L5:
        this.mCheckpointListener = r3;
        if (this.mCheckpointListener == null) goto L9;
        this.mCheckpointListener.onAttach(r0);
        return;
    }

    void notifyCheckpoint(String r2, int r3) {
        SQLiteDatabase r0 = this.mDB.get();
        SQLiteCheckpointListener r1 = this.mCheckpointListener;
        if (r1 == null) goto L8;
        if (r0 == null) goto L9;
        r1.onWALCommit(r0, r2, r3);
        return;
    L9:
        return;
    }

    void dump(Printer r8, boolean r9) {
        Printer r3 = PrefixPrinter.create(r8, "    ");
        Object r4 = this.mLock;
        monitor-enter(r4);
        r8.println("Connection pool for " + this.mConfiguration.path + ":");     // Catch: Throwable -> L29
        r8.println("  Open: " + this.mIsOpen);     // Catch: Throwable -> L29
        r8.println("  Max connections: " + this.mMaxConnectionPoolSize);     // Catch: Throwable -> L29
        r8.println("  Available primary connection:");     // Catch: Throwable -> L29
        SQLiteConnection r0 = this.mAvailablePrimaryConnection;     // Catch: Throwable -> L29
        if (r0 == null) goto L7;
        r0.dump(r3, r9);     // Catch: Throwable -> L29
    L8:
        r8.println("  Available non-primary connections:");     // Catch: Throwable -> L29
        int r1 = 0;
        if (this.mAvailableNonPrimaryConnections.isEmpty() == true) goto L13;
        int r2 = this.mAvailableNonPrimaryConnections.size();     // Catch: Throwable -> L29
        int r5 = 0;
    L11:
        if (r5 >= r2) goto L14;
        this.mAvailableNonPrimaryConnections.get(r5).dump(r3, r9);     // Catch: Throwable -> L29
        r5 = r5 + 1;     // Catch: Throwable -> L29
    L14:
        r8.println("  Acquired connections:");     // Catch: Throwable -> L29
        if (this.mAcquiredConnections.isEmpty() == true) goto L20;
        Iterator<Map.Entry<SQLiteConnection, AcquiredConnectionStatus>> r6 = this.mAcquiredConnections.entrySet().iterator();     // Catch: Throwable -> L29
    L18:
        if (r6.hasNext() == false) goto L21;
        Map.Entry<SQLiteConnection, AcquiredConnectionStatus> r7 = r6.next();     // Catch: Throwable -> L29
        r7.getKey().dump(r3, r9);     // Catch: Throwable -> L29
        r3.println("  Status: " + r7.getValue());     // Catch: Throwable -> L29
    L21:
        r8.println("  Connection waiters:");     // Catch: Throwable -> L29
        if (this.mConnectionWaiterQueue == null) goto L26;
        long r10 = SystemClock.uptimeMillis();     // Catch: Throwable -> L29
        ConnectionWaiter r11 = this.mConnectionWaiterQueue;     // Catch: Throwable -> L29
    L24:
        if (r11 == null) goto L27;
        r3.println(r1 + ": waited for " + (r10 - r11.mStartTime) + " ms - thread=" + r11.mThread + ", priority=" + r11.mPriority + ", sql='" + r11.mSql + "'");     // Catch: Throwable -> L29
        r11 = r11.mNext;     // Catch: Throwable -> L29
        r1 = r1 + 1;     // Catch: Throwable -> L29
    L27:
        monitor-exit(r4);     // Catch: Throwable -> L29
        return;
    L26:
        r3.println("<none>");     // Catch: Throwable -> L29
        goto L27
    L20:
        r3.println("<none>");     // Catch: Throwable -> L29
        goto L21
    L13:
        r3.println("<none>");     // Catch: Throwable -> L29
        goto L14
    L7:
        r3.println("<none>");     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    }

    JSONObject dumpJSON(boolean r9) throws JSONException {
        Object r0 = this.mLock;
        monitor-enter(r0);
        JSONArray r1 = new JSONArray();     // Catch: Throwable -> L17
        JSONArray r2 = new JSONArray();     // Catch: Throwable -> L17
        JSONArray r3 = new JSONArray();     // Catch: Throwable -> L17
        JSONObject r4 = new JSONObject().put("path", this.mConfiguration.path).put("open", this.mIsOpen).put("maxConn", this.mMaxConnectionPoolSize);     // Catch: Throwable -> L17
        SQLiteConnection r6 = this.mAvailablePrimaryConnection;     // Catch: Throwable -> L17
        JSONObject r5 = r4.put("availablePrimary", null).put("availableNonPrimary", r1).put("acquired", r2).put("waiters", r3);     // Catch: Throwable -> L17
        Iterator<SQLiteConnection> r7 = this.mAvailableNonPrimaryConnections.iterator();     // Catch: Throwable -> L17
    L6:
        if (r7.hasNext() == false) goto L8;
        r1.put(r7.next().dumpJSON(r9));     // Catch: Throwable -> L17
        goto L6
    L8:
        Iterator<Map.Entry<SQLiteConnection, AcquiredConnectionStatus>> r8 = this.mAcquiredConnections.entrySet().iterator();     // Catch: Throwable -> L17
    L10:
        if (r8.hasNext() == false) goto L12;
        Map.Entry<SQLiteConnection, AcquiredConnectionStatus> r10 = r8.next();     // Catch: Throwable -> L17
        r2.put(r10.getKey().dumpJSON(r9).put("status", r10.getValue().toString()));     // Catch: Throwable -> L17
        goto L10
    L12:
        ConnectionWaiter r11 = this.mConnectionWaiterQueue;     // Catch: Throwable -> L17
    L13:
        if (r11 == null) goto L15;
        long r12 = SystemClock.uptimeMillis();     // Catch: Throwable -> L17
        r3.put(new JSONObject().put("duration", r12 - r11.mStartTime).put("thread", r11.mThread.toString()).put("priority", r11.mPriority).put("sql", r11.mSql));     // Catch: Throwable -> L17
        r11 = r11.mNext;     // Catch: Throwable -> L17
        goto L13
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return r5;
    L17:
        th = move-exception;
        throw th;
    }

    public String toString() {
        return "SQLiteConnectionPool: " + this.mConfiguration.path;
    }
}
