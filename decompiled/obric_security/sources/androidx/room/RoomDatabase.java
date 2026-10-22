package androidx.room;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.matrix.platform.sdk.ones.safecushion.SafeCushionConstant;
import com.obric.securitycenter.nodisturb.ProviderConstants;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RoomDatabase.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000 n2\u00020\u0001:\u0007lmnopqrB\u0005¢\u0006\u0002\u0010\u0002J\b\u00108\u001a\u000209H\u0017J\b\u0010:\u001a\u000209H\u0017J\b\u0010;\u001a\u000209H\u0017J\b\u0010<\u001a\u000209H'J\b\u0010=\u001a\u000209H\u0016J\u0010\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0010H\u0016J\b\u0010A\u001a\u00020\u0018H$J\u0010\u0010B\u001a\u00020\u00132\u0006\u0010C\u001a\u00020DH$J\b\u0010E\u001a\u000209H\u0017J*\u0010F\u001a\b\u0012\u0004\u0012\u00020G0!2\u001a\u0010\u0007\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\n0HH\u0017J\r\u0010I\u001a\u00020JH\u0000¢\u0006\u0002\bKJ\u0016\u0010L\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t0MH\u0017J\"\u0010N\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0!0HH\u0015J#\u0010O\u001a\u0004\u0018\u0001HP\"\u0004\b\u0000\u0010P2\f\u0010Q\u001a\b\u0012\u0004\u0012\u0002HP0\tH\u0016¢\u0006\u0002\u0010RJ\b\u0010S\u001a\u00020\u0004H\u0016J\u0010\u0010T\u001a\u0002092\u0006\u0010U\u001a\u00020DH\u0017J\b\u0010V\u001a\u000209H\u0002J\b\u0010W\u001a\u000209H\u0002J\u0010\u0010X\u001a\u0002092\u0006\u0010Y\u001a\u00020%H\u0014J\u001c\u0010Z\u001a\u00020[2\u0006\u0010Z\u001a\u00020\\2\n\b\u0002\u0010]\u001a\u0004\u0018\u00010^H\u0017J)\u0010Z\u001a\u00020[2\u0006\u0010Z\u001a\u00020\u00102\u0012\u0010_\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010`H\u0016¢\u0006\u0002\u0010aJ\u0010\u0010b\u001a\u0002092\u0006\u0010c\u001a\u00020dH\u0016J!\u0010b\u001a\u0002He\"\u0004\b\u0000\u0010e2\f\u0010c\u001a\b\u0012\u0004\u0012\u0002He0fH\u0016¢\u0006\u0002\u0010gJ\b\u0010h\u001a\u000209H\u0017J+\u0010i\u001a\u0004\u0018\u0001HP\"\u0004\b\u0000\u0010P2\f\u0010j\u001a\b\u0012\u0004\u0012\u0002HP0\t2\u0006\u0010'\u001a\u00020\u0013H\u0002¢\u0006\u0002\u0010kR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\u0007\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\n0\b8\u0004@\u0004X\u0085\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001f\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\b8G¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u00048VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0002\u001a\u0004\b\u001e\u0010\u001dR \u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!8\u0004@\u0004X\u0085\u000e¢\u0006\b\n\u0000\u0012\u0004\b#\u0010\u0002R\u001a\u0010$\u001a\u0004\u0018\u00010%8\u0004@\u0004X\u0085\u000e¢\u0006\b\n\u0000\u0012\u0004\b&\u0010\u0002R\u0014\u0010'\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010/\u001a\b\u0012\u0004\u0012\u000201008G¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0014\u00104\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u0010,R\u001e\u00106\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006s"}, d2 = {"Landroidx/room/RoomDatabase;", "", "()V", "allowMainThreadQueries", "", "autoCloser", "Landroidx/room/AutoCloser;", "autoMigrationSpecs", "", "Ljava/lang/Class;", "Landroidx/room/migration/AutoMigrationSpec;", "getAutoMigrationSpecs", "()Ljava/util/Map;", "setAutoMigrationSpecs", "(Ljava/util/Map;)V", "backingFieldMap", "", "getBackingFieldMap", "internalOpenHelper", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "internalQueryExecutor", "Ljava/util/concurrent/Executor;", "internalTransactionExecutor", "invalidationTracker", "Landroidx/room/InvalidationTracker;", "getInvalidationTracker", "()Landroidx/room/InvalidationTracker;", "isMainThread", "isMainThread$room_runtime_release", "()Z", "isOpen", "isOpen$annotations", "mCallbacks", "", "Landroidx/room/RoomDatabase$Callback;", "getMCallbacks$annotations", "mDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getMDatabase$annotations", "openHelper", "getOpenHelper", "()Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "queryExecutor", "getQueryExecutor", "()Ljava/util/concurrent/Executor;", "readWriteLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "suspendingTransactionId", "Ljava/lang/ThreadLocal;", "", "getSuspendingTransactionId", "()Ljava/lang/ThreadLocal;", "transactionExecutor", "getTransactionExecutor", "typeConverters", "writeAheadLoggingEnabled", "assertNotMainThread", "", "assertNotSuspendingTransaction", "beginTransaction", "clearAllTables", "close", "compileStatement", "Landroidx/sqlite/db/SupportSQLiteStatement;", "sql", "createInvalidationTracker", "createOpenHelper", "config", "Landroidx/room/DatabaseConfiguration;", "endTransaction", "getAutoMigrations", "Landroidx/room/migration/Migration;", "", "getCloseLock", "Ljava/util/concurrent/locks/Lock;", "getCloseLock$room_runtime_release", "getRequiredAutoMigrationSpecs", "", "getRequiredTypeConverters", "getTypeConverter", ExifInterface.GPS_DIRECTION_TRUE, "klass", "(Ljava/lang/Class;)Ljava/lang/Object;", "inTransaction", "init", "configuration", "internalBeginTransaction", "internalEndTransaction", "internalInitInvalidationTracker", CloudControlInf.DB, "query", "Landroid/database/Cursor;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "signal", "Landroid/os/CancellationSignal;", "args", "", "(Ljava/lang/String;[Ljava/lang/Object;)Landroid/database/Cursor;", "runInTransaction", ProviderConstants.Sms.BODY, "Ljava/lang/Runnable;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Ljava/util/concurrent/Callable;", "(Ljava/util/concurrent/Callable;)Ljava/lang/Object;", "setTransactionSuccessful", "unwrapOpenHelper", "clazz", "(Ljava/lang/Class;Landroidx/sqlite/db/SupportSQLiteOpenHelper;)Ljava/lang/Object;", "Builder", "Callback", "Companion", "JournalMode", "MigrationContainer", "PrepackagedDatabaseCallback", "QueryCallback", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class RoomDatabase {
    public static final Companion Companion = null;
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    private boolean allowMainThreadQueries;
    private AutoCloser autoCloser;
    private Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs;
    private final Map<String, Object> backingFieldMap;
    private SupportSQLiteOpenHelper internalOpenHelper;
    private Executor internalQueryExecutor;
    private Executor internalTransactionExecutor;
    private final InvalidationTracker invalidationTracker;
    protected List<? extends Callback> mCallbacks;
    protected volatile SupportSQLiteDatabase mDatabase;
    private final ReentrantReadWriteLock readWriteLock;
    private final ThreadLocal<Integer> suspendingTransactionId;
    private final Map<Class<?>, Object> typeConverters;
    private boolean writeAheadLoggingEnabled;

    /* JADX INFO: compiled from: RoomDatabase.kt */
    @Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0015\n\u0002\b\u000b\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B'\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0016\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00104\u001a\u00020\u0014H\u0016J\u0016\u00105\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00106\u001a\u00020\u0016H\u0016J'\u00107\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u00108\u001a\n\u0012\u0006\b\u0001\u0012\u00020:09\"\u00020:H\u0016¢\u0006\u0002\u0010;J\u0016\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010=\u001a\u00020\u0003H\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\r\u0010>\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010?J\u0016\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010A\u001a\u00020\tH\u0016J\u001e\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010A\u001a\u00020\t2\u0006\u00106\u001a\u00020*H\u0017J\u0016\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010C\u001a\u00020\u0019H\u0016J\u001e\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010C\u001a\u00020\u00192\u0006\u00106\u001a\u00020*H\u0017J\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0017J$\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u00106\u001a\u00020*H\u0017J\u000e\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\u000e\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\u0010I\u001a\u00020J\"\u00020%H\u0016J\u000e\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\u0018\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J \u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0001\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0017J\u0016\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0016\u0010O\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010P\u001a\u00020(H\u0017J\u001e\u0010Q\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010R\u001a\u00020.H\u0016J\u0016\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010R\u001a\u00020.H\u0016J\u0016\u0010T\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010R\u001a\u00020.H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Landroidx/room/RoomDatabase$Builder;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/room/RoomDatabase;", "", "context", "Landroid/content/Context;", "klass", "Ljava/lang/Class;", "name", "", "(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;)V", "allowDestructiveMigrationOnDowngrade", "", "allowMainThreadQueries", "autoCloseTimeUnit", "Ljava/util/concurrent/TimeUnit;", "autoCloseTimeout", "", "autoMigrationSpecs", "", "Landroidx/room/migration/AutoMigrationSpec;", "callbacks", "Landroidx/room/RoomDatabase$Callback;", "copyFromAssetPath", "copyFromFile", "Ljava/io/File;", "copyFromInputStream", "Ljava/util/concurrent/Callable;", "Ljava/io/InputStream;", "factory", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;", "journalMode", "Landroidx/room/RoomDatabase$JournalMode;", "migrationContainer", "Landroidx/room/RoomDatabase$MigrationContainer;", "migrationStartAndEndVersions", "", "", "migrationsNotRequiredFrom", "multiInstanceInvalidationIntent", "Landroid/content/Intent;", "prepackagedDatabaseCallback", "Landroidx/room/RoomDatabase$PrepackagedDatabaseCallback;", "queryCallback", "Landroidx/room/RoomDatabase$QueryCallback;", "queryCallbackExecutor", "Ljava/util/concurrent/Executor;", "queryExecutor", "requireMigration", "transactionExecutor", "typeConverters", "addAutoMigrationSpec", "autoMigrationSpec", "addCallback", "callback", "addMigrations", "migrations", "", "Landroidx/room/migration/Migration;", "([Landroidx/room/migration/Migration;)Landroidx/room/RoomDatabase$Builder;", "addTypeConverter", "typeConverter", "build", "()Landroidx/room/RoomDatabase;", "createFromAsset", "databaseFilePath", "createFromFile", "databaseFile", "createFromInputStream", "inputStreamCallable", "enableMultiInstanceInvalidation", "fallbackToDestructiveMigration", "fallbackToDestructiveMigrationFrom", "startVersions", "", "fallbackToDestructiveMigrationOnDowngrade", "openHelperFactory", "setAutoCloseTimeout", "setJournalMode", "setMultiInstanceInvalidationServiceIntent", "invalidationServiceIntent", "setQueryCallback", "executor", "setQueryExecutor", "setTransactionExecutor", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class Builder<T extends RoomDatabase> {
        private boolean allowDestructiveMigrationOnDowngrade;
        private boolean allowMainThreadQueries;
        private TimeUnit autoCloseTimeUnit;
        private long autoCloseTimeout;
        private List<AutoMigrationSpec> autoMigrationSpecs;
        private final List<Callback> callbacks;
        private final Context context;
        private String copyFromAssetPath;
        private File copyFromFile;
        private Callable<InputStream> copyFromInputStream;
        private SupportSQLiteOpenHelper.Factory factory;
        private JournalMode journalMode;
        private final Class<T> klass;
        private final MigrationContainer migrationContainer;
        private Set<Integer> migrationStartAndEndVersions;
        private Set<Integer> migrationsNotRequiredFrom;
        private Intent multiInstanceInvalidationIntent;
        private final String name;
        private PrepackagedDatabaseCallback prepackagedDatabaseCallback;
        private QueryCallback queryCallback;
        private Executor queryCallbackExecutor;
        private Executor queryExecutor;
        private boolean requireMigration;
        private Executor transactionExecutor;
        private final List<Object> typeConverters;

        public Builder(Context r2, Class<T> r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "klass");
            this.context = r2;
            this.klass = r3;
            this.name = r4;
            this.callbacks = new ArrayList();
            this.typeConverters = new ArrayList();
            this.autoMigrationSpecs = new ArrayList();
            this.journalMode = JournalMode.AUTOMATIC;
            this.requireMigration = true;
            this.autoCloseTimeout = -1;
            this.migrationContainer = new MigrationContainer();
            this.migrationsNotRequiredFrom = new LinkedHashSet();
        }

        public Builder<T> createFromAsset(String r2) {
            Intrinsics.checkNotNullParameter(r2, "databaseFilePath");
            this.copyFromAssetPath = r2;
            return this;
        }

        public Builder<T> createFromAsset(String r2, PrepackagedDatabaseCallback r3) {
            Intrinsics.checkNotNullParameter(r2, "databaseFilePath");
            Intrinsics.checkNotNullParameter(r3, "callback");
            this.prepackagedDatabaseCallback = r3;
            this.copyFromAssetPath = r2;
            return this;
        }

        public Builder<T> createFromFile(File r2) {
            Intrinsics.checkNotNullParameter(r2, "databaseFile");
            this.copyFromFile = r2;
            return this;
        }

        public Builder<T> createFromFile(File r2, PrepackagedDatabaseCallback r3) {
            Intrinsics.checkNotNullParameter(r2, "databaseFile");
            Intrinsics.checkNotNullParameter(r3, "callback");
            this.prepackagedDatabaseCallback = r3;
            this.copyFromFile = r2;
            return this;
        }

        public Builder<T> createFromInputStream(Callable<InputStream> r2) {
            Intrinsics.checkNotNullParameter(r2, "inputStreamCallable");
            this.copyFromInputStream = r2;
            return this;
        }

        public Builder<T> createFromInputStream(Callable<InputStream> r2, PrepackagedDatabaseCallback r3) {
            Intrinsics.checkNotNullParameter(r2, "inputStreamCallable");
            Intrinsics.checkNotNullParameter(r3, "callback");
            this.prepackagedDatabaseCallback = r3;
            this.copyFromInputStream = r2;
            return this;
        }

        public Builder<T> openHelperFactory(SupportSQLiteOpenHelper.Factory r2) {
            this.factory = r2;
            return this;
        }

        public Builder<T> addMigrations(Migration... r6) {
            Intrinsics.checkNotNullParameter(r6, "migrations");
            if (this.migrationStartAndEndVersions != null) goto L5;
            this.migrationStartAndEndVersions = new HashSet();
        L5:
            int r0 = r6.length;
            int r1 = 0;
        L6:
            if (r1 >= r0) goto L8;
            Migration r2 = r6[r1];
            Set<Integer> r3 = this.migrationStartAndEndVersions;
            Intrinsics.checkNotNull(r3);
            r3.add(Integer.valueOf(r2.startVersion));
            Set<Integer> r4 = this.migrationStartAndEndVersions;
            Intrinsics.checkNotNull(r4);
            r4.add(Integer.valueOf(r2.endVersion));
            r1 = r1 + 1;
            goto L6
        L8:
            this.migrationContainer.addMigrations((Migration[]) Arrays.copyOf(r6, r6.length));
            return this;
        }

        public Builder<T> addAutoMigrationSpec(AutoMigrationSpec r2) {
            Intrinsics.checkNotNullParameter(r2, "autoMigrationSpec");
            this.autoMigrationSpecs.add(r2);
            return this;
        }

        public Builder<T> allowMainThreadQueries() {
            this.allowMainThreadQueries = true;
            return this;
        }

        public Builder<T> setJournalMode(JournalMode r2) {
            Intrinsics.checkNotNullParameter(r2, "journalMode");
            this.journalMode = r2;
            return this;
        }

        public Builder<T> setQueryExecutor(Executor r2) {
            Intrinsics.checkNotNullParameter(r2, "executor");
            this.queryExecutor = r2;
            return this;
        }

        public Builder<T> setTransactionExecutor(Executor r2) {
            Intrinsics.checkNotNullParameter(r2, "executor");
            this.transactionExecutor = r2;
            return this;
        }

        public Builder<T> enableMultiInstanceInvalidation() {
            if (this.name == null) goto L5;
            Intent r0 = new Intent(this.context, MultiInstanceInvalidationService.class);
        L6:
            this.multiInstanceInvalidationIntent = r0;
            return this;
        L5:
            r0 = null;
            Intent r1 = (Intent) null;
            goto L6
        }

        @ExperimentalRoomApi
        public Builder<T> setMultiInstanceInvalidationServiceIntent(Intent r2) {
            Intrinsics.checkNotNullParameter(r2, "invalidationServiceIntent");
            if (this.name != null) goto L6;
            r2 = null;
        L6:
            this.multiInstanceInvalidationIntent = r2;
            return this;
        }

        public Builder<T> fallbackToDestructiveMigration() {
            this.requireMigration = false;
            this.allowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        public Builder<T> fallbackToDestructiveMigrationOnDowngrade() {
            this.requireMigration = true;
            this.allowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        public Builder<T> fallbackToDestructiveMigrationFrom(int... r5) {
            Intrinsics.checkNotNullParameter(r5, "startVersions");
            int r0 = r5.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            int r2 = r5[r1];
            this.migrationsNotRequiredFrom.add(Integer.valueOf(r2));
            r1 = r1 + 1;
            goto L3
        L5:
            return this;
        }

        public Builder<T> addCallback(Callback r2) {
            Intrinsics.checkNotNullParameter(r2, "callback");
            this.callbacks.add(r2);
            return this;
        }

        public Builder<T> setQueryCallback(QueryCallback r2, Executor r3) {
            Intrinsics.checkNotNullParameter(r2, "queryCallback");
            Intrinsics.checkNotNullParameter(r3, "executor");
            this.queryCallback = r2;
            this.queryCallbackExecutor = r3;
            return this;
        }

        public Builder<T> addTypeConverter(Object r2) {
            Intrinsics.checkNotNullParameter(r2, "typeConverter");
            this.typeConverters.add(r2);
            return this;
        }

        @ExperimentalRoomApi
        public Builder<T> setAutoCloseTimeout(long r3, TimeUnit r5) {
            Intrinsics.checkNotNullParameter(r5, "autoCloseTimeUnit");
            if (r3 < 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L10;
            this.autoCloseTimeout = r3;
            this.autoCloseTimeUnit = r5;
            return this;
        L10:
            throw new IllegalArgumentException("autoCloseTimeout must be >= 0".toString());
        L5:
            r0 = false;
            goto L6
        }

        public T build() {
            Executor r1 = this.queryExecutor;
            if (r1 == null) goto L5;
        L7:
            if (r1 != null) goto L9;
        L11:
            if (r1 != null) goto L13;
            this.queryExecutor = this.transactionExecutor;
        L13:
            Set<Integer> r2 = this.migrationStartAndEndVersions;
            boolean r3 = true;
            if (r2 == null) goto L23;
            Intrinsics.checkNotNull(r2);
            Iterator<Integer> r4 = r2.iterator();
        L17:
            if (r4.hasNext() == false) goto L23;
            int r5 = r4.next().intValue();
            if ((!this.migrationsNotRequiredFrom.contains(Integer.valueOf(r5))) == true) goto L17;
            throw new IllegalArgumentException(("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + r5).toString());
        L23:
            SQLiteCopyOpenHelperFactory r6 = this.factory;
            if (r6 != null) goto L27;
            r6 = new FrameworkSQLiteOpenHelperFactory();
        L27:
            if (r6 != null) goto L29;
            r6 = null;
        L74:
            if (r6 == null) goto L97;
            if (this.queryCallback == null) goto L86;
            Executor r7 = this.queryCallbackExecutor;
            if (r7 == null) goto L85;
            QueryCallback r8 = this.queryCallback;
            if (r8 == null) goto L83;
            r6 = new QueryInterceptorOpenHelperFactory(r6, r7, r8);
            goto L86
        L83:
            throw new IllegalArgumentException("Required value was null.".toString());
        L85:
            throw new IllegalArgumentException("Required value was null.".toString());
        L86:
            SupportSQLiteOpenHelper.Factory r9 = r6;
            Context r10 = this.context;
            String r11 = this.name;
            MigrationContainer r12 = this.migrationContainer;
            List<Callback> r13 = this.callbacks;
            boolean r14 = this.allowMainThreadQueries;
            JournalMode r15 = this.journalMode.resolve$room_runtime_release(r10);
            Executor r16 = this.queryExecutor;
            if (r16 == null) goto L95;
            Executor r17 = this.transactionExecutor;
            if (r17 == null) goto L93;
            DatabaseConfiguration r18 = new DatabaseConfiguration(r10, r11, r9, r12, r13, r14, r15, r16, r17, this.multiInstanceInvalidationIntent, this.requireMigration, this.allowDestructiveMigrationOnDowngrade, this.migrationsNotRequiredFrom, this.copyFromAssetPath, this.copyFromFile, this.copyFromInputStream, this.prepackagedDatabaseCallback, this.typeConverters, this.autoMigrationSpecs);
            T r0 = (T) Room.getGeneratedImplementation(this.klass, "_Impl");
            r0.init(r18);
            return r0;
        L93:
            throw new IllegalArgumentException("Required value was null.".toString());
        L95:
            throw new IllegalArgumentException("Required value was null.".toString());
        L97:
            throw new IllegalArgumentException("Required value was null.".toString());
        L29:
            if (this.autoCloseTimeout > 0) goto L31;
        L43:
            String r19 = this.copyFromAssetPath;
            if (r19 != null) goto L50;
            if (this.copyFromFile != null) goto L50;
            if (this.copyFromInputStream == null) goto L74;
        L50:
            if (this.name == null) goto L72;
            if (r19 != null) goto L54;
            int r20 = 0;
        L56:
            if (this.copyFromFile != null) goto L58;
            int r21 = 0;
        L60:
            if (this.copyFromInputStream != null) goto L62;
            int r22 = 0;
        L64:
            if (((r20 + r21) + r22) == 1) goto L67;
            r3 = false;
        L67:
            if (r3 == false) goto L70;
            r6 = new SQLiteCopyOpenHelperFactory(this.copyFromAssetPath, this.copyFromFile, this.copyFromInputStream, r6);
            goto L74
        L70:
            throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.".toString());
        L62:
            r22 = 1;
            goto L64
        L58:
            r21 = 1;
            goto L60
        L54:
            r20 = 1;
            goto L56
        L72:
            throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.".toString());
        L31:
            if (this.name == null) goto L42;
            long r23 = this.autoCloseTimeout;
            TimeUnit r24 = this.autoCloseTimeUnit;
            if (r24 == null) goto L40;
            Executor r25 = this.queryExecutor;
            if (r25 == null) goto L38;
            r6 = new AutoClosingRoomOpenHelperFactory(r6, new AutoCloser(r23, r24, r25));
            goto L43
        L38:
            throw new IllegalArgumentException("Required value was null.".toString());
        L40:
            throw new IllegalArgumentException("Required value was null.".toString());
        L42:
            throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.".toString());
        L9:
            if (this.transactionExecutor != null) goto L11;
            this.transactionExecutor = r1;
            goto L13
        L5:
            if (this.transactionExecutor != null) goto L7;
            Executor r26 = ArchTaskExecutor.getIOThreadExecutor();
            this.transactionExecutor = r26;
            this.queryExecutor = r26;
            goto L13
        }
    }

    /* JADX INFO: compiled from: RoomDatabase.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"Landroidx/room/RoomDatabase$Callback;", "", "()V", "onCreate", "", CloudControlInf.DB, "Landroidx/sqlite/db/SupportSQLiteDatabase;", "onDestructiveMigration", "onOpen", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class Callback {
        public void onCreate(SupportSQLiteDatabase r1) {
            Intrinsics.checkNotNullParameter(r1, CloudControlInf.DB);
        }

        public void onDestructiveMigration(SupportSQLiteDatabase r1) {
            Intrinsics.checkNotNullParameter(r1, CloudControlInf.DB);
        }

        public void onOpen(SupportSQLiteDatabase r1) {
            Intrinsics.checkNotNullParameter(r1, CloudControlInf.DB);
        }

        public Callback() {
        }
    }

    /* JADX INFO: compiled from: RoomDatabase.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/room/RoomDatabase$Companion;", "", "()V", "MAX_BIND_PARAMETER_CNT", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: RoomDatabase.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Landroidx/room/RoomDatabase$JournalMode;", "", "(Ljava/lang/String;I)V", "isLowRamDevice", "", "activityManager", "Landroid/app/ActivityManager;", "resolve", "context", "Landroid/content/Context;", "resolve$room_runtime_release", "AUTOMATIC", "TRUNCATE", "WRITE_AHEAD_LOGGING", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum JournalMode extends Enum<JournalMode> {
        private static final /* synthetic */ JournalMode[] $VALUES = null;
        public static final JournalMode AUTOMATIC = null;
        public static final JournalMode TRUNCATE = null;
        public static final JournalMode WRITE_AHEAD_LOGGING = null;

        private static final /* synthetic */ JournalMode[] $values() {
            return new JournalMode[]{AUTOMATIC, TRUNCATE, WRITE_AHEAD_LOGGING};
        }

        public static JournalMode valueOf(String r1) {
            return (JournalMode) Enum.valueOf(JournalMode.class, r1);
        }

        public static JournalMode[] values() {
            return (JournalMode[]) $VALUES.clone();
        }

        private JournalMode(String r1, int r2) {
            super(r1, r2);
        }

        static {
            AUTOMATIC = new JournalMode("AUTOMATIC", 0);
            TRUNCATE = new JournalMode("TRUNCATE", 1);
            WRITE_AHEAD_LOGGING = new JournalMode("WRITE_AHEAD_LOGGING", 2);
            $VALUES = $values();
        }

        public final JournalMode resolve$room_runtime_release(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            if (this == AUTOMATIC) goto L5;
            return this;
        L5:
            Object r3 = r2.getSystemService("activity");
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.ActivityManager");
            if (isLowRamDevice((ActivityManager) r3) == true) goto L10;
            return WRITE_AHEAD_LOGGING;
        L10:
            return TRUNCATE;
        }

        private final boolean isLowRamDevice(ActivityManager r1) {
            return SupportSQLiteCompat.Api19Impl.isLowRamDevice(r1);
        }
    }

    /* JADX INFO: compiled from: RoomDatabase.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0002J!\u0010\u000b\u001a\u00020\t2\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\f\"\u00020\u0007H\u0016¢\u0006\u0002\u0010\rJ\u0016\u0010\u000b\u001a\u00020\t2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005J \u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J6\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00182\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J \u0010\u001a\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u001b0\u001bH\u0016R&\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/room/RoomDatabase$MigrationContainer;", "", "()V", "migrations", "", "", "Ljava/util/TreeMap;", "Landroidx/room/migration/Migration;", "addMigration", "", "migration", "addMigrations", "", "([Landroidx/room/migration/Migration;)V", "", "contains", "", "startVersion", "endVersion", "findMigrationPath", "start", TraceStatsConsts.STATS_KEY_END, "findUpMigrationPath", "result", "", SafeCushionConstant.UPGRADE_MODE, "getMigrations", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class MigrationContainer {
        private final Map<Integer, TreeMap<Integer, Migration>> migrations;

        public MigrationContainer() {
            this.migrations = new LinkedHashMap();
        }

        public void addMigrations(List<? extends Migration> r2) {
            Intrinsics.checkNotNullParameter(r2, "migrations");
            Iterator<T> r3 = r2.iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            addMigration((Migration) r3.next());
            goto L4
        }

        private final void addMigration(Migration r5) {
            int r0 = r5.startVersion;
            int r1 = r5.endVersion;
            Map<Integer, TreeMap<Integer, Migration>> r4 = this.migrations;
            Integer r2 = Integer.valueOf(r0);
            TreeMap<Integer, Migration> r3 = r4.get(r2);
            if (r3 != null) goto L5;
            r3 = new TreeMap();
            r4.put(r2, r3);
        L5:
            TreeMap<Integer, Migration> r6 = r3;
            TreeMap<Integer, Migration> r7 = r6;
            if (r7.containsKey(Integer.valueOf(r1)) == false) goto L8;
            Log.w(Room.LOG_TAG, "Overriding migration " + r6.get(Integer.valueOf(r1)) + " with " + r5);
        L8:
            r7.put(Integer.valueOf(r1), r5);
        }

        public Map<Integer, Map<Integer, Migration>> getMigrations() {
            return this.migrations;
        }

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
            return CollectionsKt.emptyList();
        }

        private final List<Migration> findUpMigrationPath(List<Migration> r9, boolean r10, int r11, int r12) {
        L2:
            boolean r0 = true;
            if (r10 == false) goto L6;
            if (r11 < r12) goto L7;
        L8:
            boolean r2 = false;
        L9:
            if (r2 == false) goto L35;
            TreeMap<Integer, Migration> r3 = this.migrations.get(Integer.valueOf(r11));
            if (r3 == null) goto L12;
            if (r10 == false) goto L15;
            NavigableSet<Integer> r4 = r3.descendingKeySet();
        L16:
            Iterator<Integer> r5 = r4.iterator();
        L18:
            if (r5.hasNext() == false) goto L32;
            Integer r6 = r5.next();
            if (r10 == false) goto L25;
            int r7 = r11 + 1;
            Intrinsics.checkNotNullExpressionValue(r6, "targetVersion");
            int r8 = r6.intValue();
            if (r7 > r8) goto L29;
            if (r8 > r12) goto L29;
        L28:
            boolean r13 = true;
        L30:
            if (r13 == false) goto L18;
            Migration r14 = r3.get(r6);
            Intrinsics.checkNotNull(r14);
            r9.add(r14);
            r11 = r6.intValue();
        L33:
            if (r0 == true) goto L2;
            return null;
        L29:
            r13 = false;
            goto L30
        L25:
            Intrinsics.checkNotNullExpressionValue(r6, "targetVersion");
            int r15 = r6.intValue();
            if (r12 > r15) goto L29;
            if (r15 >= r11) goto L29;
        L32:
            r0 = false;
            goto L33
        L15:
            r4 = r3.keySet();
            goto L16
        L12:
            return null;
        L35:
            return r9;
        L7:
            r2 = true;
            goto L9
        L6:
            if (r11 <= r12) goto L8;
            goto L7
        }

        public final boolean contains(int r2, int r3) {
            Map<Integer, Map<Integer, Migration>> r1 = getMigrations();
            if (r1.containsKey(Integer.valueOf(r2)) == false) goto L9;
            Map<Integer, Migration> r4 = r1.get(Integer.valueOf(r2));
            if (r4 != null) goto L8;
            r4 = MapsKt.emptyMap();
        L8:
            return r4.containsKey(Integer.valueOf(r3));
        L9:
            return false;
        }

        public void addMigrations(Migration... r4) {
            Intrinsics.checkNotNullParameter(r4, "migrations");
            int r0 = r4.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            addMigration(r4[r1]);
            r1 = r1 + 1;
            goto L3
        }
    }

    /* JADX INFO: compiled from: RoomDatabase.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Landroidx/room/RoomDatabase$PrepackagedDatabaseCallback;", "", "()V", "onOpenPrepackagedDatabase", "", CloudControlInf.DB, "Landroidx/sqlite/db/SupportSQLiteDatabase;", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class PrepackagedDatabaseCallback {
        public void onOpenPrepackagedDatabase(SupportSQLiteDatabase r1) {
            Intrinsics.checkNotNullParameter(r1, CloudControlInf.DB);
        }

        public PrepackagedDatabaseCallback() {
        }
    }

    /* JADX INFO: compiled from: RoomDatabase.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/room/RoomDatabase$QueryCallback;", "", "onQuery", "", "sqlQuery", "", "bindArgs", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface QueryCallback {
        void onQuery(String r1, List<? extends Object> r2);
    }

    static {
        Companion = new Companion(null);
    }

    @Deprecated(message = "Will be hidden in a future release.")
    protected static /* synthetic */ void getMCallbacks$annotations() {
    }

    @Deprecated(message = "Will be hidden in the next release.")
    protected static /* synthetic */ void getMDatabase$annotations() {
    }

    public static /* synthetic */ void isOpen$annotations() {
    }

    public abstract void clearAllTables();

    protected abstract InvalidationTracker createInvalidationTracker();

    protected abstract SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r1);

    public final Cursor query(SupportSQLiteQuery r3) {
        Intrinsics.checkNotNullParameter(r3, "query");
        return query$default(this, r3, null, 2, null);
    }

    public RoomDatabase() {
        this.invalidationTracker = createInvalidationTracker();
        this.autoMigrationSpecs = new LinkedHashMap();
        this.readWriteLock = new ReentrantReadWriteLock();
        this.suspendingTransactionId = new ThreadLocal();
        Map<String, Object> r0 = Collections.synchronizedMap(new LinkedHashMap());
        Intrinsics.checkNotNullExpressionValue(r0, "synchronizedMap(mutableMapOf())");
        this.backingFieldMap = r0;
        this.typeConverters = new LinkedHashMap();
    }

    public static final /* synthetic */ void access$internalBeginTransaction(RoomDatabase r0) {
        r0.internalBeginTransaction();
    }

    public static final /* synthetic */ void access$internalEndTransaction(RoomDatabase r0) {
        r0.internalEndTransaction();
    }

    public Executor getQueryExecutor() {
        Executor r0 = this.internalQueryExecutor;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("internalQueryExecutor");
        return null;
    L6:
        return r0;
    }

    public Executor getTransactionExecutor() {
        Executor r0 = this.internalTransactionExecutor;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("internalTransactionExecutor");
        return null;
    L6:
        return r0;
    }

    public SupportSQLiteOpenHelper getOpenHelper() {
        SupportSQLiteOpenHelper r0 = this.internalOpenHelper;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("internalOpenHelper");
        return null;
    L6:
        return r0;
    }

    public InvalidationTracker getInvalidationTracker() {
        return this.invalidationTracker;
    }

    protected final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> getAutoMigrationSpecs() {
        return this.autoMigrationSpecs;
    }

    protected final void setAutoMigrationSpecs(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.autoMigrationSpecs = r2;
    }

    public final Lock getCloseLock$room_runtime_release() {
        ReentrantReadWriteLock.ReadLock r1 = this.readWriteLock.readLock();
        Intrinsics.checkNotNullExpressionValue(r1, "readWriteLock.readLock()");
        return r1;
    }

    public final ThreadLocal<Integer> getSuspendingTransactionId() {
        return this.suspendingTransactionId;
    }

    public final Map<String, Object> getBackingFieldMap() {
        return this.backingFieldMap;
    }

    public <T> T getTypeConverter(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "klass");
        return (T) this.typeConverters.get(r2);
    }

    public void init(DatabaseConfiguration r12) {
        Intrinsics.checkNotNullParameter(r12, "configuration");
        this.internalOpenHelper = createOpenHelper(r12);
        Set<Class<? extends AutoMigrationSpec>> r0 = getRequiredAutoMigrationSpecs();
        BitSet r1 = new BitSet();
        Iterator<Class<? extends AutoMigrationSpec>> r2 = r0.iterator();
    L3:
        boolean r3 = true;
        int r5 = -1;
        if (r2.hasNext() == false) goto L20;
        Class<? extends AutoMigrationSpec> r4 = r2.next();
        int r6 = r12.autoMigrationSpecs.size() - 1;
        if (r6 < 0) goto L13;
    L7:
        int r7 = r6 - 1;
        if (r4.isAssignableFrom(r12.autoMigrationSpecs.get(r6).getClass()) == true) goto L9;
        if (r7 < 0) goto L13;
        r6 = r7;
        goto L7
    L9:
        r1.set(r6);
        r5 = r6;
    L13:
        if (r5 >= 0) goto L16;
        r3 = false;
    L16:
        if (r3 == false) goto L19;
        this.autoMigrationSpecs.put(r4, r12.autoMigrationSpecs.get(r5));
        goto L3
    L19:
        throw new IllegalArgumentException(("A required auto migration spec (" + r4.getCanonicalName() + ") is missing in the database configuration.").toString());
    L20:
        int r8 = r12.autoMigrationSpecs.size() - 1;
        if (r8 < 0) goto L29;
    L22:
        int r9 = r8 - 1;
        if (r1.get(r8) == false) goto L28;
        if (r9 < 0) goto L29;
        r8 = r9;
        goto L22
    L28:
        throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.".toString());
    L29:
        Iterator<Migration> r10 = getAutoMigrations(this.autoMigrationSpecs).iterator();
    L31:
        if (r10.hasNext() == false) goto L35;
        Migration r11 = r10.next();
        if (r12.migrationContainer.contains(r11.startVersion, r11.endVersion) == true) goto L31;
        r12.migrationContainer.addMigrations(new Migration[]{r11});
        goto L31
    L35:
        SQLiteCopyOpenHelper r13 = (SQLiteCopyOpenHelper) unwrapOpenHelper(SQLiteCopyOpenHelper.class, getOpenHelper());
        if (r13 == null) goto L38;
        r13.setDatabaseConfiguration(r12);
    L38:
        AutoClosingRoomOpenHelper r14 = (AutoClosingRoomOpenHelper) unwrapOpenHelper(AutoClosingRoomOpenHelper.class, getOpenHelper());
        if (r14 == null) goto L42;
        this.autoCloser = r14.autoCloser;
        getInvalidationTracker().setAutoCloser$room_runtime_release(r14.autoCloser);
    L42:
        if (r12.journalMode != JournalMode.WRITE_AHEAD_LOGGING) goto L44;
        boolean r15 = true;
    L45:
        getOpenHelper().setWriteAheadLoggingEnabled(r15);
        this.mCallbacks = r12.callbacks;
        this.internalQueryExecutor = r12.queryExecutor;
        this.internalTransactionExecutor = new TransactionExecutor(r12.transactionExecutor);
        this.allowMainThreadQueries = r12.allowMainThreadQueries;
        this.writeAheadLoggingEnabled = r15;
        if (r12.multiInstanceInvalidationServiceIntent != null) goto L48;
    L52:
        Map<Class<?>, List<Class<?>>> r16 = getRequiredTypeConverters();
        BitSet r17 = new BitSet();
        Iterator<Map.Entry<Class<?>, List<Class<?>>>> r18 = r16.entrySet().iterator();
    L54:
        if (r18.hasNext() == false) goto L74;
        Map.Entry<Class<?>, List<Class<?>>> r19 = r18.next();
        Class<?> r20 = r19.getKey();
        Iterator<Class<?>> r21 = r19.getValue().iterator();
    L57:
        if (r21.hasNext() == false) goto L54;
        Class<?> r22 = r21.next();
        int r23 = r12.typeConverters.size() - 1;
        if (r23 < 0) goto L66;
    L60:
        int r24 = r23 - 1;
        if (r22.isAssignableFrom(r12.typeConverters.get(r23).getClass()) == true) goto L62;
        if (r24 < 0) goto L66;
        r23 = r24;
        goto L60
    L62:
        r17.set(r23);
    L67:
        if (r23 < 0) goto L69;
        boolean r25 = true;
    L70:
        if (r25 == false) goto L73;
        this.typeConverters.put(r22, r12.typeConverters.get(r23));
        goto L57
    L73:
        throw new IllegalArgumentException(("A required type converter (" + r22 + ") for " + r20.getCanonicalName() + " is missing in the database configuration.").toString());
    L69:
        r25 = false;
    L66:
        r23 = -1;
        goto L67
    L74:
        int r110 = r12.typeConverters.size() - 1;
        if (r110 < 0) goto L83;
    L76:
        int r26 = r110 - 1;
        if (r17.get(r110) == false) goto L82;
        if (r26 < 0) goto L102;
        r110 = r26;
        goto L76
    L102:
        return;
    L82:
        throw new IllegalArgumentException("Unexpected type converter " + r12.typeConverters.get(r110) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
    L83:
        return;
    L48:
        if (r12.name == null) goto L51;
        getInvalidationTracker().startMultiInstanceInvalidation$room_runtime_release(r12.context, r12.name, r12.multiInstanceInvalidationServiceIntent);
        goto L52
    L51:
        throw new IllegalArgumentException("Required value was null.".toString());
    L44:
        r15 = false;
        goto L45
    }

    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> r1) {
        Intrinsics.checkNotNullParameter(r1, "autoMigrationSpecs");
        return CollectionsKt.emptyList();
    }

    private final <T> T unwrapOpenHelper(Class<T> r2, SupportSQLiteOpenHelper r3) {
        if (r2.isInstance(r3) == false) goto L7;
        return (T) r3;
    L7:
        if ((r3 instanceof DelegatingOpenHelper) == true) goto L11;
        return null;
    L11:
        return (T) unwrapOpenHelper(r2, ((DelegatingOpenHelper) r3).getDelegate());
    }

    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        return MapsKt.emptyMap();
    }

    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return SetsKt.emptySet();
    }

    public boolean isOpen() {
        AutoCloser r0 = this.autoCloser;
        if (r0 == null) goto L6;
        boolean r1 = r0.isActive();
    L5:
        Boolean r2 = Boolean.valueOf(r1);
    L11:
        return Intrinsics.areEqual(r2, true);
    L6:
        SupportSQLiteDatabase r3 = this.mDatabase;
        if (r3 == null) goto L9;
        r1 = r3.isOpen();
        goto L5
    L9:
        r2 = null;
        goto L11
    }

    public void close() {
        if (isOpen() == false) goto L10;
        ReentrantReadWriteLock.WriteLock r0 = this.readWriteLock.writeLock();
        Intrinsics.checkNotNullExpressionValue(r0, "readWriteLock.writeLock()");
        ReentrantReadWriteLock.WriteLock r1 = r0;
        r1.lock();
        getInvalidationTracker().stopMultiInstanceInvalidation$room_runtime_release();     // Catch: Throwable -> L7
        getOpenHelper().close();     // Catch: Throwable -> L7
        r1.unlock();
        return;
    L7:
        th = move-exception;
        r1.unlock();
        throw th;
    }

    public final boolean isMainThread$room_runtime_release() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }

    public void assertNotMainThread() {
        if (this.allowMainThreadQueries == false) goto L6;
        return;
    L6:
        if ((!isMainThread$room_runtime_release()) == false) goto L9;
        return;
    L9:
        throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.".toString());
    }

    public void assertNotSuspendingTransaction() {
        if (inTransaction() == false) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return;
    L12:
        throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.".toString());
    L5:
        if (this.suspendingTransactionId.get() == null) goto L8;
        r1 = false;
        goto L9
    }

    public Cursor query(String r2, Object[] r3) {
        Intrinsics.checkNotNullParameter(r2, "query");
        return getOpenHelper().getWritableDatabase().query(new SimpleSQLiteQuery(r2, r3));
    }

    public static /* synthetic */ Cursor query$default(RoomDatabase r0, SupportSQLiteQuery r1, CancellationSignal r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L7;
        r2 = null;
    L7:
        return r0.query(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: query");
    }

    public Cursor query(SupportSQLiteQuery r2, CancellationSignal r3) {
        Intrinsics.checkNotNullParameter(r2, "query");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        if (r3 == null) goto L6;
        return getOpenHelper().getWritableDatabase().query(r2, r3);
    L6:
        return getOpenHelper().getWritableDatabase().query(r2);
    }

    public SupportSQLiteStatement compileStatement(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sql");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return getOpenHelper().getWritableDatabase().compileStatement(r2);
    }

    @Deprecated(message = "beginTransaction() is deprecated", replaceWith = @ReplaceWith(expression = "runInTransaction(Runnable)", imports = {}))
    public void beginTransaction() {
        assertNotMainThread();
        AutoCloser r0 = this.autoCloser;
        if (r0 != null) goto L5;
        internalBeginTransaction();
        return;
    L5:
        r0.executeRefCountingFunction(new AnonymousClass1(this));
    }

    private final void internalBeginTransaction() {
        assertNotMainThread();
        SupportSQLiteDatabase r0 = getOpenHelper().getWritableDatabase();
        getInvalidationTracker().syncTriggers$room_runtime_release(r0);
        if (r0.isWriteAheadLoggingEnabled() == false) goto L5;
        r0.beginTransactionNonExclusive();
        return;
    L5:
        r0.beginTransaction();
    }

    @Deprecated(message = "endTransaction() is deprecated", replaceWith = @ReplaceWith(expression = "runInTransaction(Runnable)", imports = {}))
    public void endTransaction() {
        AutoCloser r0 = this.autoCloser;
        if (r0 != null) goto L5;
        internalEndTransaction();
        return;
    L5:
        r0.executeRefCountingFunction(new C01271(this));
    }

    private final void internalEndTransaction() {
        getOpenHelper().getWritableDatabase().endTransaction();
        if (inTransaction() == true) goto L6;
        getInvalidationTracker().refreshVersionsAsync();
        return;
    }

    @Deprecated(message = "setTransactionSuccessful() is deprecated", replaceWith = @ReplaceWith(expression = "runInTransaction(Runnable)", imports = {}))
    public void setTransactionSuccessful() {
        getOpenHelper().getWritableDatabase().setTransactionSuccessful();
    }

    public void runInTransaction(Runnable r2) {
        Intrinsics.checkNotNullParameter(r2, ProviderConstants.Sms.BODY);
        beginTransaction();
        r2.run();     // Catch: Throwable -> L6
        setTransactionSuccessful();     // Catch: Throwable -> L6
        endTransaction();
        return;
    L6:
        th = move-exception;
        endTransaction();
        throw th;
    }

    public <V> V runInTransaction(Callable<V> r2) {
        Intrinsics.checkNotNullParameter(r2, ProviderConstants.Sms.BODY);
        beginTransaction();
        V r3 = r2.call();     // Catch: Throwable -> L6
        setTransactionSuccessful();     // Catch: Throwable -> L6
        endTransaction();
        return r3;
    L6:
        th = move-exception;
        endTransaction();
        throw th;
    }

    protected void internalInitInvalidationTracker(SupportSQLiteDatabase r2) {
        Intrinsics.checkNotNullParameter(r2, CloudControlInf.DB);
        getInvalidationTracker().internalInit$room_runtime_release(r2);
    }

    public boolean inTransaction() {
        return getOpenHelper().getWritableDatabase().inTransaction();
    }
}
