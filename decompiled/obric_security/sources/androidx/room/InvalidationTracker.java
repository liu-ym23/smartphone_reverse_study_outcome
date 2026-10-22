package androidx.room;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: InvalidationTracker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u0000 f2\u00020\u0001:\u0005fghijB#\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006¢\u0006\u0002\u0010\u0007BV\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\t\u0012\u001d\u0010\n\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\b\f0\t\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006¢\u0006\u0002\u0010\rJ\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\"H\u0017J\u0010\u0010;\u001a\u0002092\u0006\u0010:\u001a\u00020\"H\u0017J7\u0010<\u001a\b\u0012\u0004\u0012\u0002H>0=\"\u0004\b\u0000\u0010>2\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00052\f\u0010?\u001a\b\u0012\u0004\u0012\u0002H>0@H\u0017¢\u0006\u0002\u0010AJ?\u0010<\u001a\b\u0012\u0004\u0012\u0002H>0=\"\u0004\b\u0000\u0010>2\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00052\u0006\u0010B\u001a\u00020\u00192\f\u0010?\u001a\b\u0012\u0004\u0012\u0002H>0@H\u0017¢\u0006\u0002\u0010CJ\r\u0010D\u001a\u00020\u0019H\u0000¢\u0006\u0002\bEJ\u0015\u0010F\u001a\u0002092\u0006\u0010\u0002\u001a\u00020GH\u0000¢\u0006\u0002\bHJ!\u0010I\u001a\u0002092\u0012\u0010J\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H\u0007¢\u0006\u0002\u0010KJ\r\u0010L\u001a\u000209H\u0000¢\u0006\u0002\bMJ\b\u0010N\u001a\u000209H\u0016J\b\u0010O\u001a\u000209H\u0017J\u0010\u0010P\u001a\u0002092\u0006\u0010:\u001a\u00020\"H\u0017J%\u0010Q\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00052\u000e\u0010R\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0002\u0010SJ\u0015\u0010T\u001a\u0002092\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\bUJ%\u0010V\u001a\u0002092\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020[H\u0000¢\u0006\u0002\b\\J\u0018\u0010]\u001a\u0002092\u0006\u0010^\u001a\u00020G2\u0006\u0010_\u001a\u000200H\u0002J\r\u0010`\u001a\u000209H\u0000¢\u0006\u0002\baJ\u0018\u0010b\u001a\u0002092\u0006\u0010^\u001a\u00020G2\u0006\u0010_\u001a\u000200H\u0002J\r\u0010c\u001a\u000209H\u0000¢\u0006\u0002\bdJ\u0015\u0010c\u001a\u0002092\u0006\u0010\u0002\u001a\u00020GH\u0000¢\u0006\u0002\bdJ%\u0010e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0002\u0010SR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!8\u0000X\u0081\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020'8GX\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020+8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b,\u0010-R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002000\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u001e\u00103\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\n\n\u0002\u00106\u001a\u0004\b4\u00105R\u000e\u00107\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010\n\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\b\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006k"}, d2 = {"Landroidx/room/InvalidationTracker;", "", "database", "Landroidx/room/RoomDatabase;", "tableNames", "", "", "(Landroidx/room/RoomDatabase;[Ljava/lang/String;)V", "shadowTablesMap", "", "viewTables", "", "Lkotlin/jvm/JvmSuppressWildcards;", "(Landroidx/room/RoomDatabase;Ljava/util/Map;Ljava/util/Map;[Ljava/lang/String;)V", "autoCloser", "Landroidx/room/AutoCloser;", "cleanupStatement", "Landroidx/sqlite/db/SupportSQLiteStatement;", "getCleanupStatement$room_runtime_release", "()Landroidx/sqlite/db/SupportSQLiteStatement;", "setCleanupStatement$room_runtime_release", "(Landroidx/sqlite/db/SupportSQLiteStatement;)V", "getDatabase$room_runtime_release", "()Landroidx/room/RoomDatabase;", "initialized", "", "invalidationLiveDataContainer", "Landroidx/room/InvalidationLiveDataContainer;", "multiInstanceInvalidationClient", "Landroidx/room/MultiInstanceInvalidationClient;", "observedTableTracker", "Landroidx/room/InvalidationTracker$ObservedTableTracker;", "observerMap", "Landroidx/arch/core/internal/SafeIterableMap;", "Landroidx/room/InvalidationTracker$Observer;", "Landroidx/room/InvalidationTracker$ObserverWrapper;", "getObserverMap$room_runtime_release", "()Landroidx/arch/core/internal/SafeIterableMap;", "pendingRefresh", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getPendingRefresh", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "refreshRunnable", "Ljava/lang/Runnable;", "getRefreshRunnable$annotations", "()V", "syncTriggersLock", "tableIdLookup", "", "getTableIdLookup$room_runtime_release", "()Ljava/util/Map;", "tablesNames", "getTablesNames$room_runtime_release", "()[Ljava/lang/String;", "[Ljava/lang/String;", "trackerLock", "addObserver", "", "observer", "addWeakObserver", "createLiveData", "Landroidx/lifecycle/LiveData;", ExifInterface.GPS_DIRECTION_TRUE, "computeFunction", "Ljava/util/concurrent/Callable;", "([Ljava/lang/String;Ljava/util/concurrent/Callable;)Landroidx/lifecycle/LiveData;", "inTransaction", "([Ljava/lang/String;ZLjava/util/concurrent/Callable;)Landroidx/lifecycle/LiveData;", "ensureInitialization", "ensureInitialization$room_runtime_release", "internalInit", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "internalInit$room_runtime_release", "notifyObserversByTableNames", "tables", "([Ljava/lang/String;)V", "onAutoCloseCallback", "onAutoCloseCallback$room_runtime_release", "refreshVersionsAsync", "refreshVersionsSync", "removeObserver", "resolveViews", "names", "([Ljava/lang/String;)[Ljava/lang/String;", "setAutoCloser", "setAutoCloser$room_runtime_release", "startMultiInstanceInvalidation", "context", "Landroid/content/Context;", "name", "serviceIntent", "Landroid/content/Intent;", "startMultiInstanceInvalidation$room_runtime_release", "startTrackingTable", CloudControlInf.DB, "tableId", "stopMultiInstanceInvalidation", "stopMultiInstanceInvalidation$room_runtime_release", "stopTrackingTable", "syncTriggers", "syncTriggers$room_runtime_release", "validateAndResolveTableNames", "Companion", "ObservedTableTracker", "Observer", "ObserverWrapper", "WeakObserver", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class InvalidationTracker {
    private static final String CREATE_TRACKING_TABLE_SQL = "CREATE TEMP TABLE room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)";
    public static final Companion Companion = null;
    private static final String INVALIDATED_COLUMN_NAME = "invalidated";
    public static final String RESET_UPDATED_TABLES_SQL = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1";
    public static final String SELECT_UPDATED_TABLES_SQL = "SELECT * FROM room_table_modification_log WHERE invalidated = 1;";
    private static final String TABLE_ID_COLUMN_NAME = "table_id";
    private static final String[] TRIGGERS = null;
    private static final String UPDATE_TABLE_NAME = "room_table_modification_log";
    private AutoCloser autoCloser;
    private volatile SupportSQLiteStatement cleanupStatement;
    private final RoomDatabase database;
    private volatile boolean initialized;
    private final InvalidationLiveDataContainer invalidationLiveDataContainer;
    private MultiInstanceInvalidationClient multiInstanceInvalidationClient;
    private final ObservedTableTracker observedTableTracker;
    private final SafeIterableMap<Observer, ObserverWrapper> observerMap;
    private final AtomicBoolean pendingRefresh;
    public final Runnable refreshRunnable;
    private final Map<String, String> shadowTablesMap;
    private final Object syncTriggersLock;
    private final Map<String, Integer> tableIdLookup;
    private final String[] tablesNames;
    private final Object trackerLock;
    private final Map<String, Set<String>> viewTables;

    /* JADX INFO: compiled from: InvalidationTracker.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0013J\u001d\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u0016\u0010\b\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0002R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/room/InvalidationTracker$Companion;", "", "()V", "CREATE_TRACKING_TABLE_SQL", "", "INVALIDATED_COLUMN_NAME", "RESET_UPDATED_TABLES_SQL", "getRESET_UPDATED_TABLES_SQL$room_runtime_release$annotations", "SELECT_UPDATED_TABLES_SQL", "getSELECT_UPDATED_TABLES_SQL$room_runtime_release$annotations", "TABLE_ID_COLUMN_NAME", "TRIGGERS", "", "[Ljava/lang/String;", "UPDATE_TABLE_NAME", "beginTransactionInternal", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "beginTransactionInternal$room_runtime_release", "getTriggerName", "tableName", "triggerType", "getTriggerName$room_runtime_release", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ void getRESET_UPDATED_TABLES_SQL$room_runtime_release$annotations() {
        }

        public static /* synthetic */ void getSELECT_UPDATED_TABLES_SQL$room_runtime_release$annotations() {
        }

        private Companion() {
        }

        public final String getTriggerName$room_runtime_release(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "tableName");
            Intrinsics.checkNotNullParameter(r3, "triggerType");
            return "`room_table_modification_trigger_" + r2 + '_' + r3 + '`';
        }

        public final void beginTransactionInternal$room_runtime_release(SupportSQLiteDatabase r1) {
            Intrinsics.checkNotNullParameter(r1, "database");
            if (r1.isWriteAheadLoggingEnabled() == false) goto L5;
            r1.beginTransactionNonExclusive();
            return;
        L5:
            r1.beginTransaction();
        }
    }

    /* JADX INFO: compiled from: InvalidationTracker.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0018\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0007J\u0012\u0010\u0014\u001a\u00020\u00062\n\u0010\u0015\u001a\u00020\u0010\"\u00020\u0003J\u0012\u0010\u0016\u001a\u00020\u00062\n\u0010\u0015\u001a\u00020\u0010\"\u00020\u0003J\u0006\u0010\u0017\u001a\u00020\u0018R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/room/InvalidationTracker$ObservedTableTracker;", "", "tableCount", "", "(I)V", "needsSync", "", "getNeedsSync", "()Z", "setNeedsSync", "(Z)V", "tableObservers", "", "getTableObservers", "()[J", "triggerStateChanges", "", "triggerStates", "", "getTablesToSync", "onAdded", "tableIds", "onRemoved", "resetTriggerState", "", "Companion", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ObservedTableTracker {
        public static final int ADD = 1;
        public static final Companion Companion = null;
        public static final int NO_OP = 0;
        public static final int REMOVE = 2;
        private boolean needsSync;
        private final long[] tableObservers;
        private final int[] triggerStateChanges;
        private final boolean[] triggerStates;

        /* JADX INFO: compiled from: InvalidationTracker.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/room/InvalidationTracker$ObservedTableTracker$Companion;", "", "()V", "ADD", "", "NO_OP", "REMOVE", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            private Companion() {
            }
        }

        static {
            Companion = new Companion(null);
        }

        public ObservedTableTracker(int r2) {
            this.tableObservers = new long[r2];
            this.triggerStates = new boolean[r2];
            this.triggerStateChanges = new int[r2];
        }

        public final long[] getTableObservers() {
            return this.tableObservers;
        }

        public final boolean getNeedsSync() {
            return this.needsSync;
        }

        public final void setNeedsSync(boolean r1) {
            this.needsSync = r1;
        }

        public final boolean onAdded(int... r10) {
            Intrinsics.checkNotNullParameter(r10, "tableIds");
            monitor-enter(this);
            int r0 = r10.length;     // Catch: Throwable -> L13
            int r1 = 0;
            boolean r2 = false;
        L5:
            if (r1 >= r0) goto L10;
            int r3 = r10[r1];     // Catch: Throwable -> L13
            long[] r4 = this.tableObservers;     // Catch: Throwable -> L13
            long r5 = r4[r3];     // Catch: Throwable -> L13
            r4[r3] = 1 + r5;     // Catch: Throwable -> L13
            if (r5 != 0) goto L9;
            r2 = true;
            this.needsSync = true;     // Catch: Throwable -> L13
        L9:
            r1 = r1 + 1;     // Catch: Throwable -> L13
            goto L5
        L10:
            Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L13
            monitor-exit(this);
            return r2;
        L13:
            th = move-exception;
            throw th;
        }

        public final boolean onRemoved(int... r12) {
            Intrinsics.checkNotNullParameter(r12, "tableIds");
            monitor-enter(this);
            int r0 = r12.length;     // Catch: Throwable -> L13
            int r1 = 0;
            boolean r2 = false;
        L5:
            if (r1 >= r0) goto L10;
            int r3 = r12[r1];     // Catch: Throwable -> L13
            long[] r4 = this.tableObservers;     // Catch: Throwable -> L13
            long r5 = r4[r3];     // Catch: Throwable -> L13
            r4[r3] = r5 - 1;     // Catch: Throwable -> L13
            if (r5 != 1) goto L9;
            r2 = true;
            this.needsSync = true;     // Catch: Throwable -> L13
        L9:
            r1 = r1 + 1;     // Catch: Throwable -> L13
            goto L5
        L10:
            Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L13
            monitor-exit(this);
            return r2;
        L13:
            th = move-exception;
            throw th;
        }

        public final void resetTriggerState() {
            monitor-enter(this);
            Arrays.fill(this.triggerStates, false);     // Catch: Throwable -> L6
            this.needsSync = true;     // Catch: Throwable -> L6
            Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public final int[] getTablesToSync() {
            monitor-enter(this);
        L26:
            th = move-exception;
            throw th;
        L4:
            if (this.needsSync == true) goto L8;
            monitor-exit(this);
            return null;
        L8:
            long[] r0 = this.tableObservers;     // Catch: Throwable -> L26
            int r1 = r0.length;     // Catch: Throwable -> L26
            int r3 = 0;
            int r4 = 0;
        L9:
            if (r3 >= r1) goto L23;
            int r7 = r4 + 1;     // Catch: Throwable -> L26
            int r6 = 1;
            if (r0[r3] <= 0) goto L13;
            boolean r5 = true;
        L14:
            boolean[] r8 = this.triggerStates;     // Catch: Throwable -> L26
            if (r5 == r8[r4]) goto L21;
            int[] r9 = this.triggerStateChanges;     // Catch: Throwable -> L26
            if (r5 == true) goto L20;
            r6 = 2;
        L20:
            r9[r4] = r6;     // Catch: Throwable -> L26
        L22:
            r8[r4] = r5;     // Catch: Throwable -> L26
            r3 = r3 + 1;     // Catch: Throwable -> L26
            r4 = r7;
            goto L9
        L21:
            this.triggerStateChanges[r4] = 0;     // Catch: Throwable -> L26
            goto L22
        L13:
            r5 = false;
            goto L14
        L23:
            this.needsSync = false;     // Catch: Throwable -> L26
            int[] r2 = (int[]) this.triggerStateChanges.clone();     // Catch: Throwable -> L26
            monitor-exit(this);
            return r2;
        }
    }

    /* JADX INFO: compiled from: InvalidationTracker.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0010\"\n\u0000\b&\u0018\u00002\u00020\u0001B#\b\u0014\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0005\"\u00020\u0003¢\u0006\u0002\u0010\u0006B\u0015\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\bJ\u0016\u0010\u0010\u001a\u00020\u00112\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012H&R\u0014\u0010\t\u001a\u00020\n8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Landroidx/room/InvalidationTracker$Observer;", "", "firstTable", "", "rest", "", "(Ljava/lang/String;[Ljava/lang/String;)V", "tables", "([Ljava/lang/String;)V", "isRemote", "", "isRemote$room_runtime_release", "()Z", "getTables$room_runtime_release", "()[Ljava/lang/String;", "[Ljava/lang/String;", "onInvalidated", "", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class Observer {
        private final String[] tables;

        public boolean isRemote$room_runtime_release() {
            return false;
        }

        public abstract void onInvalidated(Set<String> r1);

        public Observer(String[] r2) {
            Intrinsics.checkNotNullParameter(r2, "tables");
            this.tables = r2;
        }

        public final String[] getTables$room_runtime_release() {
            return this.tables;
        }

        protected Observer(String r3, String... r4) {
            Intrinsics.checkNotNullParameter(r3, "firstTable");
            Intrinsics.checkNotNullParameter(r4, "rest");
            List r0 = CollectionsKt.createListBuilder();
            CollectionsKt.addAll(r0, r4);
            r0.add(r3);
            Object[] r5 = CollectionsKt.build(r0).toArray(new String[0]);
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            this((String[]) r5);
        }
    }

    /* JADX INFO: compiled from: InvalidationTracker.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u001d\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\rH\u0000¢\u0006\u0002\b\u0015J\u001f\u0010\u0016\u001a\u00020\u00122\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H\u0000¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u001a"}, d2 = {"Landroidx/room/InvalidationTracker$ObserverWrapper;", "", "observer", "Landroidx/room/InvalidationTracker$Observer;", "tableIds", "", "tableNames", "", "", "(Landroidx/room/InvalidationTracker$Observer;[I[Ljava/lang/String;)V", "getObserver$room_runtime_release", "()Landroidx/room/InvalidationTracker$Observer;", "singleTableSet", "", "getTableIds$room_runtime_release", "()[I", "[Ljava/lang/String;", "notifyByTableInvalidStatus", "", "invalidatedTablesIds", "", "notifyByTableInvalidStatus$room_runtime_release", "notifyByTableNames", "tables", "notifyByTableNames$room_runtime_release", "([Ljava/lang/String;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ObserverWrapper {
        private final Observer observer;
        private final Set<String> singleTableSet;
        private final int[] tableIds;
        private final String[] tableNames;

        public ObserverWrapper(Observer r3, int[] r4, String[] r5) {
            Intrinsics.checkNotNullParameter(r3, "observer");
            Intrinsics.checkNotNullParameter(r4, "tableIds");
            Intrinsics.checkNotNullParameter(r5, "tableNames");
            this.observer = r3;
            this.tableIds = r4;
            this.tableNames = r5;
            boolean r0 = true;
            if (r5.length != 0) goto L5;
            boolean r6 = true;
        L7:
            if ((!r6) == false) goto L9;
            Set<String> r7 = SetsKt.setOf(r5[0]);
        L10:
            this.singleTableSet = r7;
            if (r4.length == r5.length) goto L14;
            r0 = false;
        L14:
            if (r0 == false) goto L17;
            return;
        L17:
            throw new IllegalStateException("Check failed.".toString());
        L9:
            r7 = SetsKt.emptySet();
            goto L10
        L5:
            r6 = false;
            goto L7
        }

        public final Observer getObserver$room_runtime_release() {
            return this.observer;
        }

        public final int[] getTableIds$room_runtime_release() {
            return this.tableIds;
        }

        public final void notifyByTableInvalidStatus$room_runtime_release(Set<Integer> r9) {
            Intrinsics.checkNotNullParameter(r9, "invalidatedTablesIds");
            int[] r0 = this.tableIds;
            int r1 = r0.length;
            if (r1 == 0) goto L17;
            int r3 = 0;
            if (r1 == 1) goto L14;
            Set r2 = SetsKt.createSetBuilder();
            int[] r4 = this.tableIds;
            int r5 = r4.length;
            int r6 = 0;
        L7:
            if (r3 >= r5) goto L12;
            int r7 = r6 + 1;
            if (r9.contains(Integer.valueOf(r4[r3])) == false) goto L11;
            r2.add(this.tableNames[r6]);
        L11:
            r3 = r3 + 1;
            r6 = r7;
            goto L7
        L12:
            Set<String> r10 = SetsKt.build(r2);
        L19:
            if ((!r10.isEmpty()) == false) goto L25;
            this.observer.onInvalidated(r10);
            return;
        L25:
            return;
        L14:
            if (r9.contains(Integer.valueOf(r0[0])) == false) goto L16;
            r10 = this.singleTableSet;
            goto L19
        L16:
            r10 = SetsKt.emptySet();
            goto L19
        L17:
            r10 = SetsKt.emptySet();
            goto L19
        }

        public final void notifyByTableNames$room_runtime_release(String[] r12) {
            Intrinsics.checkNotNullParameter(r12, "tables");
            int r0 = this.tableNames.length;
            if (r0 == 0) goto L25;
            boolean r2 = false;
            if (r0 == 1) goto L16;
            Set r1 = SetsKt.createSetBuilder();
            int r3 = r12.length;
            int r4 = 0;
        L7:
            if (r4 >= r3) goto L15;
            String r5 = r12[r4];
            String[] r6 = this.tableNames;
            int r7 = r6.length;
            int r8 = 0;
        L9:
            if (r8 >= r7) goto L14;
            String r9 = r6[r8];
            if (StringsKt.equals(r9, r5, true) == false) goto L13;
            r1.add(r9);
        L13:
            r8 = r8 + 1;
            goto L9
        L14:
            r4 = r4 + 1;
            goto L7
        L15:
            Set<String> r13 = SetsKt.build(r1);
        L27:
            if ((!r13.isEmpty()) == false) goto L36;
            this.observer.onInvalidated(r13);
            return;
        L36:
            return;
        L16:
            int r10 = r12.length;
            int r11 = 0;
        L17:
            if (r11 >= r10) goto L22;
            if (StringsKt.equals(r12[r11], this.tableNames[0], true) == true) goto L20;
            r11 = r11 + 1;
            goto L17
        L20:
            r2 = true;
        L22:
            if (r2 == false) goto L24;
            r13 = this.singleTableSet;
            goto L27
        L24:
            r13 = SetsKt.emptySet();
            goto L27
        L25:
            r13 = SetsKt.emptySet();
            goto L27
        }
    }

    /* JADX INFO: compiled from: InvalidationTracker.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Landroidx/room/InvalidationTracker$WeakObserver;", "Landroidx/room/InvalidationTracker$Observer;", "tracker", "Landroidx/room/InvalidationTracker;", "delegate", "(Landroidx/room/InvalidationTracker;Landroidx/room/InvalidationTracker$Observer;)V", "delegateRef", "Ljava/lang/ref/WeakReference;", "getDelegateRef", "()Ljava/lang/ref/WeakReference;", "getTracker", "()Landroidx/room/InvalidationTracker;", "onInvalidated", "", "tables", "", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class WeakObserver extends Observer {
        private final WeakReference<Observer> delegateRef;
        private final InvalidationTracker tracker;

        public final InvalidationTracker getTracker() {
            return this.tracker;
        }

        public WeakObserver(InvalidationTracker r2, Observer r3) {
            Intrinsics.checkNotNullParameter(r2, "tracker");
            Intrinsics.checkNotNullParameter(r3, "delegate");
            super(r3.getTables$room_runtime_release());
            this.tracker = r2;
            this.delegateRef = new WeakReference(r3);
        }

        public final WeakReference<Observer> getDelegateRef() {
            return this.delegateRef;
        }

        @Override // androidx.room.InvalidationTracker.Observer
        public void onInvalidated(Set<String> r2) {
            Intrinsics.checkNotNullParameter(r2, "tables");
            Observer r0 = this.delegateRef.get();
            if (r0 != null) goto L5;
            this.tracker.removeObserver(this);
            return;
        L5:
            r0.onInvalidated(r2);
        }
    }

    public static /* synthetic */ void getRefreshRunnable$annotations() {
    }

    public InvalidationTracker(RoomDatabase r6, Map<String, String> r7, Map<String, Set<String>> r8, String... r9) {
        Intrinsics.checkNotNullParameter(r6, "database");
        Intrinsics.checkNotNullParameter(r7, "shadowTablesMap");
        Intrinsics.checkNotNullParameter(r8, "viewTables");
        Intrinsics.checkNotNullParameter(r9, "tableNames");
        this.database = r6;
        this.shadowTablesMap = r7;
        this.viewTables = r8;
        int r10 = 0;
        this.pendingRefresh = new AtomicBoolean(false);
        this.observedTableTracker = new ObservedTableTracker(r9.length);
        this.invalidationLiveDataContainer = new InvalidationLiveDataContainer(r6);
        this.observerMap = new SafeIterableMap();
        this.syncTriggersLock = new Object();
        this.trackerLock = new Object();
        this.tableIdLookup = new LinkedHashMap();
        int r11 = r9.length;
        String[] r12 = new String[r11];
    L4:
        if (r10 >= r11) goto L13;
        String r2 = r9[r10];
        Locale r3 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(r3, "US");
        String r4 = r2.toLowerCase(r3);
        Intrinsics.checkNotNullExpressionValue(r4, "this as java.lang.String).toLowerCase(locale)");
        Integer r5 = Integer.valueOf(r10);
        this.tableIdLookup.put(r4, r5);
        String r13 = this.shadowTablesMap.get(r9[r10]);
        if (r13 == null) goto L8;
        Locale r14 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(r14, "US");
        String r1 = r13.toLowerCase(r14);
        Intrinsics.checkNotNullExpressionValue(r1, "this as java.lang.String).toLowerCase(locale)");
    L9:
        if (r1 == null) goto L12;
        r4 = r1;
    L12:
        r12[r10] = r4;
        r10 = r10 + 1;
        goto L4
    L8:
        r1 = null;
        goto L9
    L13:
        this.tablesNames = r12;
        Iterator<Map.Entry<String, String>> r15 = this.shadowTablesMap.entrySet().iterator();
    L15:
        if (r15.hasNext() == false) goto L19;
        Map.Entry<String, String> r16 = r15.next();
        String r17 = r16.getValue();
        Locale r18 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(r18, "US");
        String r19 = r17.toLowerCase(r18);
        Intrinsics.checkNotNullExpressionValue(r19, "this as java.lang.String).toLowerCase(locale)");
        if (this.tableIdLookup.containsKey(r19) == false) goto L15;
        String r20 = r16.getKey();
        Locale r21 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(r21, "US");
        String r22 = r20.toLowerCase(r21);
        Intrinsics.checkNotNullExpressionValue(r22, "this as java.lang.String).toLowerCase(locale)");
        Map<String, Integer> r23 = this.tableIdLookup;
        r23.put(r22, (Integer) MapsKt.getValue(r23, r19));
        goto L15
    L19:
        this.refreshRunnable = new InvalidationTracker$refreshRunnable$1(this);
    }

    public static final /* synthetic */ AutoCloser access$getAutoCloser$p(InvalidationTracker r0) {
        return r0.autoCloser;
    }

    public final RoomDatabase getDatabase$room_runtime_release() {
        return this.database;
    }

    public final Map<String, Integer> getTableIdLookup$room_runtime_release() {
        return this.tableIdLookup;
    }

    public final String[] getTablesNames$room_runtime_release() {
        return this.tablesNames;
    }

    public final AtomicBoolean getPendingRefresh() {
        return this.pendingRefresh;
    }

    public final SupportSQLiteStatement getCleanupStatement$room_runtime_release() {
        return this.cleanupStatement;
    }

    public final void setCleanupStatement$room_runtime_release(SupportSQLiteStatement r1) {
        this.cleanupStatement = r1;
    }

    public final SafeIterableMap<Observer, ObserverWrapper> getObserverMap$room_runtime_release() {
        return this.observerMap;
    }

    public InvalidationTracker(RoomDatabase r4, String... r5) {
        Intrinsics.checkNotNullParameter(r4, "database");
        Intrinsics.checkNotNullParameter(r5, "tableNames");
        this(r4, MapsKt.emptyMap(), MapsKt.emptyMap(), (String[]) Arrays.copyOf(r5, r5.length));
    }

    public final void setAutoCloser$room_runtime_release(AutoCloser r2) {
        Intrinsics.checkNotNullParameter(r2, "autoCloser");
        this.autoCloser = r2;
        r2.setAutoCloseCallback(new InvalidationTracker$$ExternalSyntheticLambda0(this));
    }

    public final void internalInit$room_runtime_release(SupportSQLiteDatabase r3) {
        Intrinsics.checkNotNullParameter(r3, "database");
        Object r0 = this.trackerLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.initialized == false) goto L9;
        Log.e(Room.LOG_TAG, "Invalidation tracker is initialized twice :/.");     // Catch: Throwable -> L12
        monitor-exit(r0);
        return;
    L9:
        r3.execSQL("PRAGMA temp_store = MEMORY;");     // Catch: Throwable -> L12
        r3.execSQL("PRAGMA recursive_triggers='ON';");     // Catch: Throwable -> L12
        r3.execSQL(CREATE_TRACKING_TABLE_SQL);     // Catch: Throwable -> L12
        syncTriggers$room_runtime_release(r3);     // Catch: Throwable -> L12
        this.cleanupStatement = r3.compileStatement(RESET_UPDATED_TABLES_SQL);     // Catch: Throwable -> L12
        this.initialized = true;     // Catch: Throwable -> L12
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r0);
    }

    public final void onAutoCloseCallback$room_runtime_release() {
        Object r0 = this.trackerLock;
        monitor-enter(r0);
        this.initialized = false;     // Catch: Throwable -> L8
        this.observedTableTracker.resetTriggerState();     // Catch: Throwable -> L8
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r0);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void startMultiInstanceInvalidation$room_runtime_release(Context r8, String r9, Intent r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "name");
        Intrinsics.checkNotNullParameter(r10, "serviceIntent");
        this.multiInstanceInvalidationClient = new MultiInstanceInvalidationClient(r8, r9, r10, this, this.database.getQueryExecutor());
    }

    public final void stopMultiInstanceInvalidation$room_runtime_release() {
        MultiInstanceInvalidationClient r0 = this.multiInstanceInvalidationClient;
        if (r0 == null) goto L5;
        r0.stop();
    L5:
        this.multiInstanceInvalidationClient = null;
    }

    private final void stopTrackingTable(SupportSQLiteDatabase r6, int r7) {
        String r5 = this.tablesNames[r7];
        String[] r8 = TRIGGERS;
        int r0 = r8.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        String r2 = "DROP TRIGGER IF EXISTS " + Companion.getTriggerName$room_runtime_release(r5, r8[r1]);
        Intrinsics.checkNotNullExpressionValue(r2, "StringBuilder().apply(builderAction).toString()");
        r6.execSQL(r2);
        r1 = r1 + 1;
        goto L3
    }

    private final void startTrackingTable(SupportSQLiteDatabase r7, int r8) {
        r7.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + r8 + ", 0)");
        String r6 = this.tablesNames[r8];
        String[] r0 = TRIGGERS;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        String r3 = r0[r2];
        String r4 = "CREATE TEMP TRIGGER IF NOT EXISTS " + Companion.getTriggerName$room_runtime_release(r6, r3) + " AFTER " + r3 + " ON `" + r6 + "` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = " + r8 + " AND invalidated = 0; END";
        Intrinsics.checkNotNullExpressionValue(r4, "StringBuilder().apply(builderAction).toString()");
        r7.execSQL(r4);
        r2 = r2 + 1;
        goto L3
    }

    public void addObserver(Observer r9) {
        Intrinsics.checkNotNullParameter(r9, "observer");
        String[] r0 = resolveViews(r9.getTables$room_runtime_release());
        ArrayList r1 = new ArrayList(r0.length);
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L9;
        String r4 = r0[r3];
        Map<String, Integer> r5 = this.tableIdLookup;
        Locale r6 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(r6, "US");
        String r7 = r4.toLowerCase(r6);
        Intrinsics.checkNotNullExpressionValue(r7, "this as java.lang.String).toLowerCase(locale)");
        Integer r8 = r5.get(r7);
        if (r8 == null) goto L8;
        r1.add(Integer.valueOf(r8.intValue()));
        r3 = r3 + 1;
        goto L3
    L8:
        throw new IllegalArgumentException("There is no table with name " + r4);
    L9:
        int[] r10 = CollectionsKt.toIntArray(r1);
        ObserverWrapper r11 = new ObserverWrapper(r9, r10, r0);
        SafeIterableMap<Observer, ObserverWrapper> r12 = this.observerMap;
        monitor-enter(r12);
        ObserverWrapper r13 = this.observerMap.putIfAbsent(r9, r11);     // Catch: Throwable -> L18
        monitor-exit(r12);
        if (r13 == null) goto L15;
        return;
    L15:
        if (this.observedTableTracker.onAdded(Arrays.copyOf(r10, r10.length)) == false) goto L26;
        syncTriggers$room_runtime_release();
        return;
    L26:
        return;
    L18:
        th = move-exception;
        throw th;
    }

    private final String[] validateAndResolveTableNames(String[] r7) {
        String[] r8 = resolveViews(r7);
        int r0 = r8.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        String r2 = r8[r1];
        Map<String, Integer> r3 = this.tableIdLookup;
        Locale r4 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(r4, "US");
        String r5 = r2.toLowerCase(r4);
        Intrinsics.checkNotNullExpressionValue(r5, "this as java.lang.String).toLowerCase(locale)");
        if (r3.containsKey(r5) == false) goto L8;
        r1 = r1 + 1;
        goto L3
    L8:
        throw new IllegalArgumentException(("There is no table with name " + r2).toString());
    L9:
        return r8;
    }

    private final String[] resolveViews(String[] r10) {
        Set r0 = SetsKt.createSetBuilder();
        int r1 = r10.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        String r4 = r10[r3];
        Map<String, Set<String>> r5 = this.viewTables;
        Locale r6 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(r6, "US");
        String r7 = r4.toLowerCase(r6);
        Intrinsics.checkNotNullExpressionValue(r7, "this as java.lang.String).toLowerCase(locale)");
        if (r5.containsKey(r7) == false) goto L7;
        Map<String, Set<String>> r8 = this.viewTables;
        Locale r9 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(r9, "US");
        String r11 = r4.toLowerCase(r9);
        Intrinsics.checkNotNullExpressionValue(r11, "this as java.lang.String).toLowerCase(locale)");
        Set<String> r12 = r8.get(r11);
        Intrinsics.checkNotNull(r12);
        r0.addAll(r12);
    L8:
        r3 = r3 + 1;
        goto L3
    L7:
        r0.add(r4);
        goto L8
    L9:
        Object[] r13 = SetsKt.build(r0).toArray(new String[0]);
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) r13;
    }

    public void addWeakObserver(Observer r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        addObserver(new WeakObserver(this, r2));
    }

    public void removeObserver(Observer r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        SafeIterableMap<Observer, ObserverWrapper> r0 = this.observerMap;
        monitor-enter(r0);
        ObserverWrapper r4 = this.observerMap.remove(r3);     // Catch: Throwable -> L11
        monitor-exit(r0);
        if (r4 == null) goto L16;
        ObservedTableTracker r1 = this.observedTableTracker;
        int[] r5 = r4.getTableIds$room_runtime_release();
        if (r1.onRemoved(Arrays.copyOf(r5, r5.length)) == false) goto L17;
        syncTriggers$room_runtime_release();
        return;
    L17:
        return;
    L16:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final boolean ensureInitialization$room_runtime_release() {
        if (this.database.isOpen() == true) goto L6;
        return false;
    L6:
        if (this.initialized == true) goto L9;
        this.database.getOpenHelper().getWritableDatabase();
    L9:
        if (this.initialized == true) goto L12;
        Log.e(Room.LOG_TAG, "database is not initialized even though it is open");
        return false;
    L12:
        return true;
    }

    public void refreshVersionsAsync() {
        if (this.pendingRefresh.compareAndSet(false, true) == false) goto L9;
        AutoCloser r0 = this.autoCloser;
        if (r0 == null) goto L7;
        r0.incrementCountAndEnsureDbIsOpen();
    L7:
        this.database.getQueryExecutor().execute(this.refreshRunnable);
        return;
    }

    public void refreshVersionsSync() {
        AutoCloser r0 = this.autoCloser;
        if (r0 == null) goto L5;
        r0.incrementCountAndEnsureDbIsOpen();
    L5:
        syncTriggers$room_runtime_release();
        this.refreshRunnable.run();
    }

    public final void notifyObserversByTableNames(String... r4) {
        Intrinsics.checkNotNullParameter(r4, "tables");
        SafeIterableMap<Observer, ObserverWrapper> r0 = this.observerMap;
        monitor-enter(r0);
        Iterator<Map.Entry<K, V>> r3 = this.observerMap.iterator();     // Catch: Throwable -> L13
    L6:
        if (r3.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) r3.next();     // Catch: Throwable -> L13
        Intrinsics.checkNotNullExpressionValue(r1, "(observer, wrapper)");     // Catch: Throwable -> L13
        Observer r2 = (Observer) r1.getKey();     // Catch: Throwable -> L13
        ObserverWrapper r5 = (ObserverWrapper) r1.getValue();     // Catch: Throwable -> L13
        if (r2.isRemote$room_runtime_release() == true) goto L6;
        r5.notifyByTableNames$room_runtime_release(r4);     // Catch: Throwable -> L13
        goto L6
    L10:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r0);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void syncTriggers$room_runtime_release(SupportSQLiteDatabase r10) {
        Intrinsics.checkNotNullParameter(r10, "database");
        if (r10.inTransaction() == false) goto L47;
        return;
    L47:
        Lock r0 = this.database.getCloseLock$room_runtime_release();     // Catch: SQLiteException -> L38 IllegalStateException -> L40
        r0.lock();     // Catch: SQLiteException -> L38 IllegalStateException -> L40
        Object r1 = this.syncTriggersLock;     // Catch: Throwable -> L35
        monitor-enter(r1);     // Catch: Throwable -> L35
        int[] r2 = this.observedTableTracker.getTablesToSync();     // Catch: Throwable -> L32
        if (r2 != null) goto L13;
        monitor-exit(r1);     // Catch: Throwable -> L35
        r0.unlock();     // Catch: SQLiteException -> L38 IllegalStateException -> L40
        return;
    L13:
        Companion.beginTransactionInternal$room_runtime_release(r10);     // Catch: Throwable -> L32
        int r3 = r2.length;     // Catch: Throwable -> L29
        int r4 = 0;
        int r5 = 0;
    L15:
        if (r4 >= r3) goto L24;
        int r6 = r2[r4];     // Catch: Throwable -> L29
        int r7 = r5 + 1;     // Catch: Throwable -> L29
        if (r6 != 1) goto L19;
        startTrackingTable(r10, r5);     // Catch: Throwable -> L29
    L23:
        r4 = r4 + 1;     // Catch: Throwable -> L29
        r5 = r7;
        goto L15
    L19:
        if (r6 != 2) goto L23;
        stopTrackingTable(r10, r5);     // Catch: Throwable -> L29
        goto L23
    L24:
        r10.setTransactionSuccessful();     // Catch: Throwable -> L29
        r10.endTransaction();     // Catch: Throwable -> L32
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L32
        monitor-exit(r1);     // Catch: Throwable -> L35
        r0.unlock();     // Catch: SQLiteException -> L38 IllegalStateException -> L40
        return;
    L29:
        th = move-exception;
        r10.endTransaction();     // Catch: Throwable -> L32
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        r0.unlock();     // Catch: SQLiteException -> L38 IllegalStateException -> L40
        throw th;     // Catch: SQLiteException -> L38 IllegalStateException -> L40
    L38:
        e = move-exception;
        Log.e(Room.LOG_TAG, "Cannot run invalidation tracker. Is the db closed?", e);
        return;
    L40:
        e = move-exception;
        Log.e(Room.LOG_TAG, "Cannot run invalidation tracker. Is the db closed?", e);
    }

    public final void syncTriggers$room_runtime_release() {
        if (this.database.isOpen() == true) goto L5;
        return;
    L5:
        syncTriggers$room_runtime_release(this.database.getOpenHelper().getWritableDatabase());
    }

    @Deprecated(message = "Use [createLiveData(String[], boolean, Callable)]")
    public <T> LiveData<T> createLiveData(String[] r2, Callable<T> r3) {
        Intrinsics.checkNotNullParameter(r2, "tableNames");
        Intrinsics.checkNotNullParameter(r3, "computeFunction");
        return createLiveData(r2, false, r3);
    }

    public <T> LiveData<T> createLiveData(String[] r2, boolean r3, Callable<T> r4) {
        Intrinsics.checkNotNullParameter(r2, "tableNames");
        Intrinsics.checkNotNullParameter(r4, "computeFunction");
        return this.invalidationLiveDataContainer.create(validateAndResolveTableNames(r2), r3, r4);
    }

    static {
        Companion = new Companion(null);
        TRIGGERS = new String[]{"UPDATE", HttpMethodContrants.DELETE, "INSERT"};
    }
}
