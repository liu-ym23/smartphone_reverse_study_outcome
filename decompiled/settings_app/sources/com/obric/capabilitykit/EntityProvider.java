package com.obric.capabilitykit;

import android.app.assist.AssistContent;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.UserManager;
import com.GlobalProxyLancet;
import com.android.settingslib.SliceBroadcastRelay;
import com.google.gson.JsonSyntaxException;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.UtilsKt;
import com.obric.capabilitykit.entity.EntityContextHolder;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.EntityInitParam;
import com.obric.capabilitykit.entity.IndexProgress;
import com.obric.capabilitykit.entity.ResultCallback;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityClassData;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.entity.memory.MemoryServiceChecker;
import com.obric.capabilitykit.entity.memory.MemoryServiceStatus;
import com.obric.capabilitykit.entity.utils.IndexResult;
import com.obric.capabilitykit.logger.Logger;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import com.obric.capabilitykit.sync.EntitySyncUtil;
import com.obric.capabilitykit.version.EntityUpdateVersionParams;
import com.obric.capabilitykit.version.EntityVersionData;
import com.obric.capabilitykit.version.PersonalContextData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000·\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004*\u00010\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010C\u001a\u00020D2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00040F2\u0006\u0010G\u001a\u00020\u0006H\u0007J(\u0010H\u001a\u00020D2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020J0F2\u0010\b\u0002\u0010K\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010LH\u0007J-\u0010M\u001a\u00020D2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020J0F2\u0010\b\u0002\u0010K\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010LH\u0001¢\u0006\u0002\bNJ\b\u0010O\u001a\u00020DH\u0002J\u0018\u0010P\u001a\u00020D2\u0006\u0010G\u001a\u00020\u00062\u0006\u0010Q\u001a\u00020\u0006H\u0002J\u0018\u0010R\u001a\u00020D2\u0006\u0010S\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u0006H\u0007J\u0006\u0010T\u001a\u00020DJ,\u0010U\u001a\u00020D2\u0006\u0010V\u001a\u00020W2\u001a\u0010I\u001a\u0016\u0012\u0004\u0012\u00020J\u0018\u00010Xj\n\u0012\u0004\u0012\u00020J\u0018\u0001`YH\u0007J\u001c\u0010Z\u001a\b\u0012\u0004\u0012\u00020J0F2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020J0FH\u0002J\u001e\u0010[\u001a\u00020D2\u0006\u0010G\u001a\u00020\u00062\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\\0LH\u0007J\u0012\u0010]\u001a\u0004\u0018\u00010\\2\u0006\u0010G\u001a\u00020\u0006H\u0003J \u0010^\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010F2\u0006\u0010_\u001a\u00020\u00042\u0006\u0010`\u001a\u00020\u0004H\u0007J\"\u0010a\u001a\u00020D2\u0006\u0010b\u001a\u00020J2\u0010\b\u0002\u0010K\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010LH\u0007J\u0015\u0010c\u001a\u00020D2\u0006\u0010d\u001a\u00020eH\u0000¢\u0006\u0002\bfJ\u001e\u0010g\u001a\u00020D2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00040F2\u0006\u0010G\u001a\u00020\u0006H\u0002J(\u0010h\u001a\u00020i2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020J0F2\u0010\b\u0002\u0010K\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010LH\u0002J0\u0010j\u001a\u0004\u0018\u00010k2\u0006\u0010l\u001a\u00020\t2\u0006\u0010m\u001a\u00020\u00042\b\u0010n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010o\u001a\u0004\u0018\u00010kH\u0002J\b\u0010p\u001a\u00020:H\u0002J\u0010\u0010q\u001a\u00020:2\u0006\u0010G\u001a\u00020\u0006H\u0007J\b\u0010r\u001a\u00020:H\u0002J\u000f\u0010s\u001a\u0004\u0018\u00010kH\u0000¢\u0006\u0002\btJ\u0017\u0010u\u001a\u00020:2\b\u0010v\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0002\bwJ\r\u0010x\u001a\u00020DH\u0000¢\u0006\u0002\byJ\"\u0010z\u001a\u00020D2\b\u0010{\u001a\u0004\u0018\u00010k2\u0006\u0010G\u001a\u00020\u00062\u0006\u0010|\u001a\u00020}H\u0002J\u0014\u0010~\u001a\u00020D2\f\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020\u00060FJ\u001a\u0010\u0080\u0001\u001a\u00020D2\u0006\u0010G\u001a\u00020\u00062\u0007\u0010\u0081\u0001\u001a\u00020\u000eH\u0002J\u0019\u0010\u0082\u0001\u001a\u00020D2\u000e\u0010\u0083\u0001\u001a\t\u0012\u0005\u0012\u00030\u0084\u00010FH\u0002J \u0010\u0082\u0001\u001a\u00020D2\r\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020J0F2\u0006\u0010|\u001a\u00020}H\u0002J'\u0010\u0082\u0001\u001a\u00020D2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00040F2\u0006\u0010G\u001a\u00020\u00062\u0006\u0010|\u001a\u00020}H\u0002J\u0010\u0010\u0086\u0001\u001a\u00020D2\u0007\u0010\u0087\u0001\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010)\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b+\u0010,R\u0012\u0010/\u001a\u0002008\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u00101R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010;\u001a\u00020:2\u0006\u00109\u001a\u00020:@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u001e\u0010=\u001a\u00020>8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006\u0088\u0001"}, d2 = {"Lcom/obric/capabilitykit/EntityProvider;", "", "()V", "ENTITY_FIRST_FLAG", "", "ENTITY_LIST_CHUNK_SIZE", "", "ENTITY_REPO", "ENTITY_URI", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "getENTITY_URI$capabilitykit_release", "()Landroid/net/Uri;", "INIT_TASK_DELAY_TIME", "", "INSERT_ENTITY_RETRY_TIMES", "KEY_APP_ENTITY_COUNT", "KEY_ENTITY_IDS", "KEY_ENTITY_LIST", "KEY_ENTITY_TYPE", "KEY_ERROR_CODE", "KEY_ERROR_MSG", "KEY_INDEX_PROGRESS", "KEY_IS_DONATE_ALLOWED", "KEY_MAX_LAST_MODIFIED_TIME", "KEY_ON_SCREEN_ENTITIES", "KEY_PKG_NAME", "KEY_PRODUCT_NAME", "KEY_SUCCESS_IDS", "MAX_TRANSACTION_SIZE_BYTES", "METHOD_CHECK_SYNCED_DATA", "METHOD_DATA_CLEAN", "METHOD_DELETE", "METHOD_FETCH_SYNC_INFO", "METHOD_GET_ENTITY_INDEX_PROGRESS", "METHOD_GET_ON_SCREEN_ENTITIES", "METHOD_INDEX", "METHOD_IS_DONATE_ALLOWED_BY_LOCAL_SWITCH", "METHOD_QUERY_PERSONAL_CONTEXT_DATA", "METHOD_SYNC_DELETE", "TAG", "dbHelper", "Lcom/obric/capabilitykit/entity/EntityDBHelper;", "getDbHelper", "()Lcom/obric/capabilitykit/entity/EntityDBHelper;", "dbHelper$delegate", "Lkotlin/Lazy;", "deviceUnlockedReceiver", "com/obric/capabilitykit/EntityProvider$deviceUnlockedReceiver$1", "Lcom/obric/capabilitykit/EntityProvider$deviceUnlockedReceiver$1;", "entitySupplier", "Lcom/obric/capabilitykit/EntitySupplier;", "entitySyncDataSupplier", "Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "featureRunProcessName", "initialCountDownLatch", "Ljava/util/concurrent/CountDownLatch;", "<set-?>", "", "isInitialized", "()Z", "sContext", "Landroid/content/Context;", "getSContext", "()Landroid/content/Context;", "setSContext", "(Landroid/content/Context;)V", "bulkDelete", "", "entityIds", "", "entityType", "bulkIndex", "entities", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "callback", "Lcom/obric/capabilitykit/entity/ResultCallback;", "bulkIndexInner", "bulkIndexInner$capabilitykit_release", "checkIfFirstRunOrDataClean", "checkSyncedData", "entityCount", EntityProvider.METHOD_DELETE, "entityId", "deleteAllEntityData", "donateOnScreenData", "outContent", "Landroid/app/assist/AssistContent;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "filterLastUniqueEntities", "getIndexProgress", "Lcom/obric/capabilitykit/entity/IndexProgress;", "getIndexProgressInternal", "getOnScreenData", "productName", "pkgName", EntityProvider.METHOD_INDEX, "entity", "init", "entityInitParam", "Lcom/obric/capabilitykit/entity/EntityInitParam;", "init$capabilitykit_release", "innerBulkDelete", "innerBulkIndex", "Lcom/obric/capabilitykit/entity/utils/IndexResult;", "innerCall", "Landroid/os/Bundle;", SliceBroadcastRelay.EXTRA_URI, "method", "arg", "extra", "isCredentialProtectionLocked", "isDonateAllowed", "isNotInFeatureProcess", "queryPersonalContextData", "queryPersonalContextData$capabilitykit_release", "reDonateCheck", "paramString", "reDonateCheck$capabilitykit_release", "reindexEntityData", "reindexEntityData$capabilitykit_release", "removeProcessedEntityFromDB", "result", "action", "Lcom/obric/capabilitykit/entity/ActionType;", "syncData", "indexedEntityTypes", "syncDelete", "lastModifiedTime", "tryInsertBulkEntityHistory", "entityDaoList", "Lcom/obric/capabilitykit/entity/EntityHistoryDao;", "entityList", "waitEntityProviderInit", "timeOutMs", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityProvider {
    private static final String ENTITY_FIRST_FLAG = "first_run_flag";
    private static final int ENTITY_LIST_CHUNK_SIZE = 100;
    private static final String ENTITY_REPO = "entity_repo";
    private static final Uri ENTITY_URI = null;
    private static final long INIT_TASK_DELAY_TIME = 10000;
    private static final int INSERT_ENTITY_RETRY_TIMES = 3;
    public static final EntityProvider INSTANCE = null;
    private static final String KEY_APP_ENTITY_COUNT = "app_entity_count";
    public static final String KEY_ENTITY_IDS = "entity_ids";
    public static final String KEY_ENTITY_LIST = "entity_list";
    public static final String KEY_ENTITY_TYPE = "entity_type";
    private static final String KEY_ERROR_CODE = "error_code";
    private static final String KEY_ERROR_MSG = "error_msg";
    private static final String KEY_INDEX_PROGRESS = "index_progress";
    private static final String KEY_IS_DONATE_ALLOWED = "is_donate_allowed";
    private static final String KEY_MAX_LAST_MODIFIED_TIME = "max_last_modified_time";
    private static final String KEY_ON_SCREEN_ENTITIES = "on_screen_entities";
    private static final String KEY_PKG_NAME = "pkg_name";
    private static final String KEY_PRODUCT_NAME = "product_name";
    public static final String KEY_SUCCESS_IDS = "success_ids";
    private static final int MAX_TRANSACTION_SIZE_BYTES = 921600;
    private static final String METHOD_CHECK_SYNCED_DATA = "check_synced_data";
    private static final String METHOD_DATA_CLEAN = "data_clean";
    private static final String METHOD_DELETE = "delete";
    private static final String METHOD_FETCH_SYNC_INFO = "fetch_sync_info";
    private static final String METHOD_GET_ENTITY_INDEX_PROGRESS = "get_entity_index_progress";
    private static final String METHOD_GET_ON_SCREEN_ENTITIES = "get_on_screen_entities";
    private static final String METHOD_INDEX = "index";
    private static final String METHOD_IS_DONATE_ALLOWED_BY_LOCAL_SWITCH = "is_donate_allowed_by_local_switch";
    private static final String METHOD_QUERY_PERSONAL_CONTEXT_DATA = "query_personal_context_data";
    private static final String METHOD_SYNC_DELETE = "sync_delete";
    public static final String TAG = "EntityProvider";
    private static final Lazy dbHelper$delegate = null;
    private static final EntityProvider$deviceUnlockedReceiver$1 deviceUnlockedReceiver = null;
    private static EntitySupplier entitySupplier;
    private static EntitySyncDataSupplier entitySyncDataSupplier;
    private static String featureRunProcessName;
    private static CountDownLatch initialCountDownLatch;
    private static volatile boolean isInitialized;
    public static Context sContext;

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/EntityDBHelper;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<n> {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
            super(0);
        }

        public final n a() {
            return n.b.a(EntityProvider.INSTANCE.getSContext());
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ n invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.EntityProvider$getIndexProgress$1$1", f = "EntityProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ IndexProgress b;
        public final /* synthetic */ ResultCallback<IndexProgress> c;

        public b(IndexProgress r1, ResultCallback<IndexProgress> r2, Continuation<? super b> r3) {
            this.b = r1;
            this.c = r2;
            super(2, r3);
        }

        public final Object a(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((b) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new b(this.b, this.c, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return a(r1, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) goto L11;
            ResultKt.throwOnFailure(r7);
            IndexProgress r8 = this.b;
            if (r8 != null) goto L7;
            ResultCallback.DefaultImpls.onResult$default(this.c, 501, "failed to get index progress", null, 4, null);
        L9:
            return Unit.INSTANCE;
        L7:
            this.c.onResult(0, "ok", r8);
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", SliceBroadcastRelay.EXTRA_URI, "Landroid/net/Uri;", "method", "", "bundle", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function3<Uri, String, Bundle, Bundle> {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
            super(3);
        }

        public final Bundle a(Uri r2, String r3, Bundle r4) {
            Intrinsics.checkNotNullParameter(r2, SliceBroadcastRelay.EXTRA_URI);
            Intrinsics.checkNotNullParameter(r3, "method");
            return EntityProvider.access$innerCall(EntityProvider.INSTANCE, r2, r3, null, r4);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Bundle invoke(Uri r1, String r2, Bundle r3) {
            return a(r1, r2, r3);
        }
    }

    public static /* synthetic */ void $r8$lambda$0gEkflmmtMQVc4aEqJTdnK6iocw(CountDownLatch r0) {
        reindexEntityData$lambda$46(r0);
    }

    public static /* synthetic */ void $r8$lambda$4AUgb0tkcFBQKStRwy42delvFyY(List r0, int r1) {
        bulkDelete$lambda$13(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$5aWKPLWbpr55mHGi-TNrKG5VKU8, reason: not valid java name */
    public static /* synthetic */ void m995$r8$lambda$5aWKPLWbpr55mHGiTNrKG5VKU8(List r0, ResultCallback r1) {
        bulkIndexInner$lambda$11(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$Klpw_v5lEuQnt4qTvCh7Pi09iLk(CountDownLatch r0, Set r1) {
        reDonateCheck$lambda$43(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$ON_Y7y15sQgPYis4fNo8tgLRYDQ(int r0, ResultCallback r1) {
        getIndexProgress$lambda$3(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$SZE9qeHVqf5IC9Ci3l9PvPocZeA() {
        init$lambda$1();
    }

    /* JADX INFO: renamed from: $r8$lambda$YbvwXbnICymSj-BILZZXl8hCYs4, reason: not valid java name */
    public static /* synthetic */ void m996$r8$lambda$YbvwXbnICymSjBILZZXl8hCYs4(List r0, CountDownLatch r1) {
        syncData$lambda$44(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$uVTrYcK3JmfBA-hw5Ch7ECsssdQ, reason: not valid java name */
    public static /* synthetic */ void m997$r8$lambda$uVTrYcK3JmfBAhw5Ch7ECsssdQ() {
        deleteAllEntityData$lambda$14();
    }

    static {
        INSTANCE = new EntityProvider();
        ENTITY_URI = Uri.parse("content://com.obric.memorydata.personalcontext.EntityProvider");
        dbHelper$delegate = LazyKt.lazy(a.a);
        initialCountDownLatch = new CountDownLatch(1);
        deviceUnlockedReceiver = new EntityProvider$deviceUnlockedReceiver$1();
    }

    private EntityProvider() {
    }

    public static final /* synthetic */ void access$checkIfFirstRunOrDataClean(EntityProvider r0) {
        r0.checkIfFirstRunOrDataClean();
    }

    public static final /* synthetic */ Bundle access$innerCall(EntityProvider r0, Uri r1, String r2, String r3, Bundle r4) {
        return r0.innerCall(r1, r2, r3, r4);
    }

    private static final void bulkDelete$lambda$13(List r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "$entityIds");
        Iterator r0 = r3.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String r1 = (String) r0.next();
        INSTANCE.getDbHelper().a(r1, r4);
        goto L4
    L6:
        EntityProvider r2 = INSTANCE;
        r2.tryInsertBulkEntityHistory(r3, r4, m.d);
        r2.innerBulkDelete(r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void bulkIndex$default(EntityProvider r0, List r1, ResultCallback r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.bulkIndex(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void bulkIndexInner$capabilitykit_release$default(EntityProvider r0, List r1, ResultCallback r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.bulkIndexInner$capabilitykit_release(r1, r2);
    }

    private static final void bulkIndexInner$lambda$11(List r13, ResultCallback r14) {
        Intrinsics.checkNotNullParameter(r13, "$entities");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r15 = r13.iterator();
    L4:
        if (r15.hasNext() == false) goto L9;
        Object r1 = r15.next();
        Integer r2 = Integer.valueOf(((AppEntity) r1).getType());
        Object r3 = r0.get(r2);
        if (r3 != null) goto L8;
        r3 = new ArrayList();
        r0.put(r2, r3);
    L8:
        ((List) r3).add(r1);
        goto L4
    L9:
        LinkedHashMap r16 = new LinkedHashMap();
        Iterator r4 = r0.entrySet().iterator();
    L11:
        if (r4.hasNext() == false) goto L20;
        Map.Entry r5 = (Map.Entry) r4.next();
        List<AppEntity> r6 = INSTANCE.filterLastUniqueEntities((List) r5.getValue());
        Iterator<T> r7 = r6.iterator();
    L14:
        if (r7.hasNext() == false) goto L16;
        AppEntity r8 = (AppEntity) r7.next();
        INSTANCE.getDbHelper().a(r8.getId(), r8.getType());
        goto L14
    L16:
        EntityProvider r9 = INSTANCE;
        r9.tryInsertBulkEntityHistory(r6, m.c);
        IndexResult r10 = r9.innerBulkIndex(r6, r14);
        if (r10.getCode() == 0) goto L11;
        r16.put(r5.getKey(), r10);
        goto L11
    L20:
        if ((!r16.isEmpty()) == false) goto L43;
        Logger.INSTANCE.w(TAG, "bulkIndexInner failed, failedMessageMap: " + r16);
        Collection r11 = r16.values();
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r17 = r11.iterator();
    L23:
        if (r17.hasNext() == false) goto L25;
        r12.add(Integer.valueOf(((IndexResult) r17.next()).getCode()));
        goto L23
    L25:
        Set r18 = CollectionsKt.toSet(r12);
        if (r18.size() != r16.size()) goto L28;
        boolean r19 = true;
    L30:
        if (r18.size() != 1) goto L34;
        IndexResult r110 = (IndexResult) CollectionsKt.first(r16.values());
        if (r14 == null) goto L57;
        ResultCallback.DefaultImpls.onResult$default(r14, r110.getCode(), r110.getMessage(), null, 4, null);
        return;
    L57:
        return;
    L34:
        if (r19 == false) goto L36;
        String r20 = "all ";
    L37:
        String r21 = r20.concat(" entity type index failed:");
        Iterator r111 = r16.entrySet().iterator();
        String r22 = r21;
    L39:
        if (r111.hasNext() == false) goto L41;
        Map.Entry r23 = (Map.Entry) r111.next();
        r22 = r22 + "\n entity type " + ((Number) r23.getKey()).intValue() + " reason: " + ((IndexResult) r23.getValue()).getMessage();
        goto L39
    L41:
        if (r14 == null) goto L59;
        ResultCallback.DefaultImpls.onResult$default(r14, 304, r22, null, 4, null);
        return;
    L59:
        return;
    L36:
        r20 = "some ";
        goto L37
    L28:
        r19 = false;
        goto L30
    L43:
        if (r14 == null) goto L61;
        ResultCallback.DefaultImpls.onResult$default(r14, 0, "success", null, 4, null);
        return;
    }

    private final void checkIfFirstRunOrDataClean() {
        z.a.a();
        SharedPreferences r0 = getSContext().getSharedPreferences(ENTITY_REPO, 0);
        if ((!r0.getBoolean(ENTITY_FIRST_FLAG, false)) == false) goto L8;
        SharedPreferences.Editor r1 = r0.edit();
        r1.putBoolean(ENTITY_FIRST_FLAG, true);
        r1.apply();
        if (Intrinsics.areEqual("com.android.gallery3d", getSContext().getPackageName()) == true) goto L7;
        Logger.INSTANCE.i(TAG, "app's data may cleared, need to clean relative entity data.");
        Uri r4 = ENTITY_URI;
        Intrinsics.checkNotNullExpressionValue(r4, "ENTITY_URI");
        innerCall$default(this, r4, METHOD_DATA_CLEAN, null, null, 8, null);
    L7:
        EntitySupplier r2 = entitySupplier;
        Intrinsics.checkNotNull(r2);
        bulkIndex$default(this, r2.provideAllEntities(), null, 2, null);
        return;
    L8:
        p.a.b();
    }

    private final void checkSyncedData(int r3, int r4) {
        Bundle r0 = new Bundle();
        r0.putInt(KEY_ENTITY_TYPE, r3);
        r0.putInt(KEY_APP_ENTITY_COUNT, r4);
        Uri r5 = ENTITY_URI;
        Intrinsics.checkNotNullExpressionValue(r5, "ENTITY_URI");
        innerCall(r5, METHOD_CHECK_SYNCED_DATA, null, r0);
    }

    private static final void deleteAllEntityData$lambda$14() {
        EntityProvider r0 = INSTANCE;
        Uri r1 = ENTITY_URI;
        Intrinsics.checkNotNullExpressionValue(r1, "ENTITY_URI");
        innerCall$default(r0, r1, METHOD_DATA_CLEAN, null, null, 8, null);
    }

    private final List<AppEntity> filterLastUniqueEntities(List<? extends AppEntity> r4) {
        LinkedHashSet r3 = new LinkedHashSet();
        ArrayList r0 = new ArrayList();
        Iterator r5 = CollectionsKt.asReversed(r4).iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        AppEntity r1 = (AppEntity) r5.next();
        if (r3.contains(r1.getId()) == true) goto L4;
        r0.add(r1);
        r3.add(r1.getId());
        goto L4
    L9:
        return CollectionsKt.asReversedMutable(r0);
    }

    private final n getDbHelper() {
        return (n) dbHelper$delegate.getValue();
    }

    private static final void getIndexProgress$lambda$3(int r7, ResultCallback r8) {
        Intrinsics.checkNotNullParameter(r8, "$callback");
        IndexProgress r9 = INSTANCE.getIndexProgressInternal(r7);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new b(r9, r8, null), 3, null);
    }

    private final IndexProgress getIndexProgressInternal(int r4) {
        Bundle r0 = new Bundle();
        r0.putInt(KEY_ENTITY_TYPE, r4);
        Uri r5 = ENTITY_URI;
        Intrinsics.checkNotNullExpressionValue(r5, "ENTITY_URI");
        Object r2 = null;
        Bundle r3 = innerCall(r5, METHOD_GET_ENTITY_INDEX_PROGRESS, null, r0);
        if (r3 == null) goto L14;
        String r6 = r3.getString(KEY_INDEX_PROGRESS);
        if (r6 != null) goto L7;
    L10:
        boolean r7 = true;
    L11:
        if (r7 == true) goto L14;
        r2 = UtilsKt.getGson().fromJson(r6, IndexProgress.class);
        goto L14
    L7:
        if (r6.length() == 0) goto L10;
        r7 = false;
    L14:
        return (IndexProgress) r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void index$default(EntityProvider r0, AppEntity r1, ResultCallback r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.index(r1, r2);
    }

    private static final void init$lambda$1() {
        INSTANCE.checkIfFirstRunOrDataClean();
    }

    private final void innerBulkDelete(List<String> r7, int r8) {
        if (isCredentialProtectionLocked() == false) goto L6;
        Logger.INSTANCE.w(TAG, "device is locked, delete entity will retry when user unlocked device");
        return;
    L6:
        Iterator r6 = CollectionsKt.chunked(r7, 100).iterator();
    L8:
        if (r6.hasNext() == false) goto L14;
        List r1 = (List) r6.next();
        Logger.INSTANCE.i(TAG, "innerBulkDelete ids: " + q.b(r7));
        Bundle r2 = new Bundle();
        Object[] r3 = r1.toArray(new String[0]);
        if (r3 == null) goto L13;
        r2.putStringArray(KEY_ENTITY_IDS, (String[]) r3);
        r2.putInt(KEY_ENTITY_TYPE, r8);
        EntityProvider r4 = INSTANCE;
        Uri r5 = ENTITY_URI;
        Intrinsics.checkNotNullExpressionValue(r5, "ENTITY_URI");
        r4.removeProcessedEntityFromDB(r4.innerCall(r5, METHOD_DELETE, null, r2), r8, m.d);
        goto L8
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    private final IndexResult innerBulkIndex(List<? extends AppEntity> r14, ResultCallback<Unit> r15) {
        if (isCredentialProtectionLocked() == true) goto L5;
        PersonalContextData r13 = z.a.a();
        Parcel r0 = null;
        Integer r1 = null;
        if (r13 == null) goto L9;
        Set<Integer> r16 = r13.getSupportEntityTypes();
    L11:
        if (r16 != null) goto L14;
        Logger.INSTANCE.w(TAG, "innerBulkIndex get PersonalContextData failed");
        IndexTaskManager.INSTANCE.scheduleRestoreHistoryProcessTask();
        return new IndexResult(303, "donate failed temporarily, personal context will retry internally");
    L14:
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r14.iterator();
    L16:
        if (r4.hasNext() == false) goto L22;
        AppEntity r5 = (AppEntity) r4.next();
        if (r16.contains(Integer.valueOf(r5.getType())) == true) goto L19;
        r2.add(r5);
        goto L16
    L19:
        r3.add(r5);
        goto L16
    L22:
        if ((!r2.isEmpty()) == false) goto L28;
        Logger.INSTANCE.i(TAG, "innerBulkIndex, unsupported ids: " + q.b(q.a(r2)));
        Iterator r17 = r2.iterator();
    L25:
        if (r17.hasNext() == false) goto L28;
        AppEntity r6 = (AppEntity) r17.next();
        INSTANCE.getDbHelper().a(r6.getId(), r6.getType(), m.c.b());
    L28:
        if (r3.isEmpty() == false) goto L34;
        Logger r18 = Logger.INSTANCE;
        StringBuilder r19 = new StringBuilder("innerBulkIndex, no supporting entity type ");
        AppEntity r110 = (AppEntity) CollectionsKt.firstOrNull(r14);
        if (r110 == null) goto L32;
        r1 = Integer.valueOf(r110.getType());
    L32:
        r18.w(TAG, r19.append(r1).toString());
        return new IndexResult(302, "unsupported entity type");
    L34:
        ArrayList r111 = new ArrayList();
        if (r3.size() >= 3) goto L41;
        Iterator r112 = r3.iterator();
    L38:
        if (r112.hasNext() == false) goto L40;
        ((AppEntity) r112.next()).countHashCode();
        goto L38
    L40:
        r111.add(r3);
    L76:
        Iterator r113 = r111.iterator();
    L78:
        if (r113.hasNext() == false) goto L101;
        List r114 = (List) r113.next();
        Logger r7 = Logger.INSTANCE;
        r7.i(TAG, "innerBulkIndex ids: " + q.b(q.a(r114)));
        Bundle r8 = new Bundle();
        r8.putParcelableArrayList(KEY_ENTITY_LIST, new ArrayList(r114));
        EntityProvider r9 = INSTANCE;
        Uri r10 = ENTITY_URI;
        Intrinsics.checkNotNullExpressionValue(r10, "ENTITY_URI");
        Bundle r11 = r9.innerCall(r10, METHOD_INDEX, null, r8);
        String r12 = "internal error";
        if (r11 == null) goto L81;
        int r20 = r11.getInt("error_code");
        String r21 = r11.getString(KEY_ERROR_MSG);
        if (r21 == null) goto L89;
        r12 = r21;
    L89:
        Intrinsics.checkNotNullExpressionValue(r12, "this.getString(KEY_ERROR_MSG)?: \"internal error\"");
        if (r20 != 0) goto L92;
        r9.removeProcessedEntityFromDB(r11, ((AppEntity) r114.get(0)).getType(), m.c);
        goto L78
    L92:
        r7.w(TAG, "innerBulkIndex failed, errorCode: " + r20 + ", errorMsg: " + r12);
        if (r20 != 111) goto L99;
        Iterator r115 = r114.iterator();
    L96:
        if (r115.hasNext() == false) goto L99;
        AppEntity r116 = (AppEntity) r115.next();
        INSTANCE.getDbHelper().a(r116.getId(), r116.getType());
    L99:
        return new IndexResult(r20, r12);
    L81:
        if (r15 == null) goto L84;
        ResultCallback.DefaultImpls.onResult$default(r15, 501, "internal error", null, 4, null);
    L84:
        return new IndexResult(501, "internal error");
    L101:
        return new IndexResult(0, "success");
    L41:
        ArrayList r117 = new ArrayList();
        Iterator r22 = r3.iterator();
        int r23 = 0;
    L43:
        if (r22.hasNext() == false) goto L74;
        AppEntity r24 = (AppEntity) r22.next();
        r24.countHashCode();
        Parcel r25 = Parcel.obtain();     // Catch: Throwable -> L52 Exception -> L54
        r25.writeParcelable(r24, 0);     // Catch: Throwable -> L48 Exception -> L50
        int r26 = r25.dataSize();     // Catch: Throwable -> L48 Exception -> L50
        r25.recycle();
    L63:
        if ((!r117.isEmpty()) == false) goto L69;
        if ((r23 + r26) <= MAX_TRANSACTION_SIZE_BYTES) goto L67;
    L68:
        r111.add(r117);
        r117 = new ArrayList();
        r23 = 0;
        goto L69
    L67:
        if (r117.size() >= 100) goto L68;
    L69:
        r117.add(r24);
        r23 = r23 + r26;
        goto L43
    L50:
        e = e;
    L58:
        Logger.INSTANCE.e(TAG, "calculate parcel size error", e);     // Catch: Throwable -> L48
        if (r25 == null) goto L61;
        r25.recycle();
    L61:
        r26 = 1024;
    L48:
        th = th;
        r0 = r25;
    L70:
        if (r0 == null) goto L72;
        r0.recycle();
    L72:
        throw th;
    L54:
        e = e;
        r25 = null;
    L52:
        th = th;
        goto L70
    L74:
        if ((!r117.isEmpty()) == false) goto L76;
        r111.add(r117);
        goto L76
    L9:
        r16 = null;
        goto L11
    L5:
        return new IndexResult(305, "device is locked, donate will try when user unlocked device");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IndexResult innerBulkIndex$default(EntityProvider r0, List r1, ResultCallback r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.innerBulkIndex(r1, r2);
    }

    private final Bundle innerCall(Uri r6, String r7, String r8, Bundle r9) {
    L9:
        e = move-exception;
        Logger.INSTANCE.e(TAG, ExceptionsKt.stackTraceToString(e));
        return null;
    L4:
        if (MemoryServiceChecker.INSTANCE.checkEntityProviderAvailable(getSContext()) == MemoryServiceStatus.AVAILABLE) goto L8;
        Logger.INSTANCE.w(TAG, "EntityProvider is not available, skip call " + r7);     // Catch: Exception -> L9
        return null;
    L8:
        return getSContext().getContentResolver().call(r6, r7, r8, r9);
    }

    public static /* synthetic */ Bundle innerCall$default(EntityProvider r0, Uri r1, String r2, String r3, Bundle r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = new Bundle();
    L6:
        return r0.innerCall(r1, r2, r3, r4);
    }

    private final boolean isCredentialProtectionLocked() {
        return !((UserManager) getSContext().getSystemService(UserManager.class)).isUserUnlocked();
    }

    private final boolean isNotInFeatureProcess() {
        if (isInitialized == true) goto L5;
        return true;
    L5:
        String r0 = featureRunProcessName;
        if (r0 == null) goto L9;
        return true ^ Intrinsics.areEqual(h.a.a(INSTANCE.getSContext()), r0);
    L9:
        if (h.a.b(getSContext()) == false) goto L14;
        return false;
    L14:
        return true;
    }

    private static final void reDonateCheck$lambda$43(CountDownLatch r6, Set r7) {
        Intrinsics.checkNotNullParameter(r6, "$finishDonateCountDownLatch");
        Intrinsics.checkNotNullParameter(r7, "$needDonateVersions");
        EntitySupplier r0 = entitySupplier;
        if (r0 == null) goto L5;
        List<AppEntity> r1 = r0.provideAllEntities();
    L6:
        if (r1 != null) goto L9;
        r6.countDown();
        return;
    L9:
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator<T> r3 = r1.iterator();
    L11:
        if (r3.hasNext() == false) goto L16;
        Object r4 = r3.next();
        Integer r5 = Integer.valueOf(((AppEntity) r4).getType());
        Object r8 = r2.get(r5);
        if (r8 != null) goto L15;
        r8 = new ArrayList();
        r2.put(r5, r8);
    L15:
        ((List) r8).add(r4);
        goto L11
    L16:
        Iterator r9 = r2.entrySet().iterator();
    L18:
        if (r9.hasNext() == false) goto L22;
        Map.Entry r10 = (Map.Entry) r9.next();
        if (r7.contains(r10.getKey()) == false) goto L18;
        Logger.INSTANCE.i(TAG, "reDonateCheck, reDonate type: " + ((Number) r10.getKey()).intValue());
        bulkIndexInner$capabilitykit_release$default(INSTANCE, (List) r10.getValue(), null, 2, null);
        goto L18
    L22:
        r6.countDown();
        return;
    L5:
        r1 = null;
        goto L6
    }

    private static final void reindexEntityData$lambda$46(CountDownLatch r4) {
        Intrinsics.checkNotNullParameter(r4, "$finishDonateCountDownLatch");
        EntitySupplier r0 = entitySupplier;     // Catch: Throwable -> L7 Exception -> L9
        if (r0 == null) goto L6;
        bulkIndex$default(INSTANCE, r0.provideAllEntities(), null, 2, null);     // Catch: Throwable -> L7 Exception -> L9
    L6:
        r4.countDown();
        return;
    L9:
        e = move-exception;
        Logger.INSTANCE.e(TAG, "reindexEntityDataInner error", e);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        r4.countDown();
        throw th;
    }

    private final void removeProcessedEntityFromDB(Bundle r3, int r4, m r5) {
        if (r3 == null) goto L9;
        ArrayList<String> r2 = r3.getStringArrayList(KEY_SUCCESS_IDS);
        if (r2 == null) goto L9;
        Logger.INSTANCE.i(TAG, "callback successIds: " + q.b(r2) + " entityType: " + r4 + " type: " + r5.b());
        Iterator<T> r6 = r2.iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        String r7 = (String) r6.next();
        n r0 = INSTANCE.getDbHelper();
        Intrinsics.checkNotNullExpressionValue(r7, "id");
        r0.a(r7, r4, r5.b());
        p.a.a(r7, r4, r5.b());
    L9:
        IndexTaskManager.INSTANCE.scheduleRestoreHistoryProcessTask();
    }

    private static final void syncData$lambda$44(List r7, CountDownLatch r8) {
        Intrinsics.checkNotNullParameter(r7, "$indexedEntityTypes");
        Intrinsics.checkNotNullParameter(r8, "$finishSyncDataCountDownLatch");
        EntitySyncUtil.INSTANCE.syncData(entitySyncDataSupplier, entitySupplier, r7, null, c.a);
        r8.countDown();
    }

    private final void syncDelete(int r4, long r5) {
        Logger.INSTANCE.d(TAG, "to delete entities which lastModifiedTime > " + r5 + " for type " + r4);
        Bundle r0 = new Bundle();
        r0.putInt(KEY_ENTITY_TYPE, r4);
        r0.putLong(KEY_MAX_LAST_MODIFIED_TIME, r5);
        Uri r6 = ENTITY_URI;
        Intrinsics.checkNotNullExpressionValue(r6, "ENTITY_URI");
        innerCall(r6, METHOD_SYNC_DELETE, null, r0);
    }

    private final void tryInsertBulkEntityHistory(List<o> r5) {
        ArrayList r4 = new ArrayList();
        ArrayList r0 = new ArrayList();
        r0.addAll(r5);
        int r1 = 0;
    L4:
        if (r1 >= 3) goto L13;
        Pair<Boolean, List<o>> r2 = INSTANCE.getDbHelper().b(r0);
        r4.addAll(r2.getSecond());
        Iterator<T> r3 = r2.getSecond().iterator();
    L7:
        if (r3.hasNext() == false) goto L10;
        r0.remove((o) r3.next());
        goto L7
    L10:
        if (r4.size() == r5.size()) goto L11;
        r1 = r1 + 1;
        goto L4
    L11:
        return;
    }

    private final void tryInsertBulkEntityHistory(List<String> r12, int r13, m r14) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r15 = r12.iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        r0.add(new o(0, (String) r15.next(), "", r13, r14, 1, null));
        goto L4
    L6:
        tryInsertBulkEntityHistory(r0);
    }

    private final void tryInsertBulkEntityHistory(List<? extends AppEntity> r13, m r14) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r15 = r13.iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        AppEntity r1 = (AppEntity) r15.next();
        r0.add(new o(0, r1.getId(), EntityExtKt.toJsonKeepTimeStamp(r1), r1.getType(), r14, 1, null));
        goto L4
    L6:
        tryInsertBulkEntityHistory(r0);
    }

    public final void bulkDelete(final List<String> r3, final int r4) {
        Intrinsics.checkNotNullParameter(r3, "entityIds");
        if (MemoryServiceChecker.INSTANCE.checkEntityProviderAvailable(getSContext()) == MemoryServiceStatus.AVAILABLE) goto L7;
        Logger.INSTANCE.w(TAG, "EntityProvider is not available, skip delete");
        return;
    L7:
        if (r3.isEmpty() == false) goto L9;
        return;
    L9:
        IndexTaskManager.INSTANCE.runTask("bulkDelete(size:" + r3.size() + ')', new EntityProvider$$ExternalSyntheticLambda2(r3, r4));
    }

    public final void bulkIndex(List<? extends AppEntity> r8, ResultCallback<Unit> r9) {
        Intrinsics.checkNotNullParameter(r8, "entities");
        if (r8.isEmpty() == false) goto L7;
        if (r9 == null) goto L9;
        ResultCallback.DefaultImpls.onResult$default(r9, 301, "entity list is empty", null, 4, null);
        return;
    L9:
        return;
    L7:
        bulkIndexInner$capabilitykit_release(r8, r9);
    }

    public final void bulkIndexInner$capabilitykit_release(final List<? extends AppEntity> r9, final ResultCallback<Unit> r10) {
        Intrinsics.checkNotNullParameter(r9, "entities");
        if (MemoryServiceChecker.INSTANCE.checkEntityProviderAvailable(getSContext()) == MemoryServiceStatus.AVAILABLE) goto L8;
        if (r10 == null) goto L14;
        ResultCallback.DefaultImpls.onResult$default(r10, 306, "EntityProvider is disabled", null, 4, null);
        return;
    L14:
        return;
    L8:
        if (isCredentialProtectionLocked() == false) goto L12;
        if (r10 == null) goto L15;
        ResultCallback.DefaultImpls.onResult$default(r10, 305, "device is locked, retry donate when user unlocked device", null, 4, null);
        return;
    L15:
        return;
    L12:
        IndexTaskManager.INSTANCE.runTask("bulkIndexInner(size:" + r9.size() + ')', new EntityProvider$$ExternalSyntheticLambda1(r9, r10));
    }

    public final void delete(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "entityId");
        bulkDelete(CollectionsKt.listOf(r2), r3);
    }

    public final void deleteAllEntityData() {
        if (MemoryServiceChecker.INSTANCE.checkEntityProviderAvailable(getSContext()) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "EntityProvider is not available, skip deleteAllEntityData");
        return;
    L6:
        IndexTaskManager.INSTANCE.runTask("deleteAllEntityData", new EntityProvider$$ExternalSyntheticLambda6());
    }

    public final void donateOnScreenData(AssistContent r8, ArrayList<AppEntity> r9) {
        Intrinsics.checkNotNullParameter(r8, "outContent");
        if (MemoryServiceChecker.INSTANCE.checkEntityProviderAvailable(getSContext()) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "EntityProvider is not available, skip donateOnScreenData");
        return;
    L6:
        Logger r7 = Logger.INSTANCE;
        StringBuilder r0 = new StringBuilder("donateOnScreenData entity list: ");
        if (r9 == null) goto L12;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r3 = r9.iterator();
    L10:
        if (r3.hasNext() == false) goto L13;
        AppEntity r4 = (AppEntity) r3.next();
        r2.add(r4.getId() + " - " + r4.getType());
    L13:
        r7.d(TAG, r0.append(r2).toString());
        if (r9 != null) goto L16;
        return;
    L16:
        r8.getExtras().putParcelableArrayList("entities", r9);
        return;
    L12:
        r2 = null;
        goto L13
    }

    public final Uri getENTITY_URI$capabilitykit_release() {
        return ENTITY_URI;
    }

    public final void getIndexProgress(final int r8, final ResultCallback<IndexProgress> r9) {
        Intrinsics.checkNotNullParameter(r9, "callback");
        if (MemoryServiceChecker.INSTANCE.checkEntityProviderAvailable(getSContext()) == MemoryServiceStatus.AVAILABLE) goto L6;
        ResultCallback.DefaultImpls.onResult$default(r9, 306, "Memory service is not available", null, 4, null);
        return;
    L6:
        IndexTaskManager.INSTANCE.runTask("getIndexProgress", new EntityProvider$$ExternalSyntheticLambda7(r8, r9));
    }

    public final List<AppEntity> getOnScreenData(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "productName");
        Intrinsics.checkNotNullParameter(r4, "pkgName");
        Bundle r0 = new Bundle();
        r0.putString("product_name", r3);
        r0.putString("pkg_name", r4);
        Uri r5 = ENTITY_URI;
        Intrinsics.checkNotNullExpressionValue(r5, "ENTITY_URI");
        Bundle r2 = innerCall(r5, METHOD_GET_ON_SCREEN_ENTITIES, null, r0);
        if (r2 == null) goto L6;
        r2.setClassLoader(AppEntity.class.getClassLoader());
        return r2.getParcelableArrayList(KEY_ON_SCREEN_ENTITIES);
    L6:
        return null;
    }

    public final Context getSContext() {
        Context r0 = sContext;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("sContext");
        return null;
    }

    public final void index(AppEntity r2, ResultCallback<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        bulkIndex(CollectionsKt.listOf(r2), r3);
    }

    public final synchronized void init$capabilitykit_release(EntityInitParam r7) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r7, "entityInitParam");     // Catch: Throwable -> L42
        if (isInitialized == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        Context r1 = AppHost.Companion.getApplication().getApplicationContext();     // Catch: Throwable -> L42
        Intrinsics.checkNotNullExpressionValue(r1, "AppHost.application.applicationContext");     // Catch: Throwable -> L42
        setSContext(r1);     // Catch: Throwable -> L42
        String r2 = r7.getRunProcessName();     // Catch: Throwable -> L42
        boolean r3 = false;
        if (r2 != null) goto L11;
        r2 = null;
    L14:
        featureRunProcessName = r2;     // Catch: Throwable -> L42
        if (r2 != null) goto L17;
    L22:
        if (r3 == false) goto L24;
        featureRunProcessName = null;     // Catch: Throwable -> L42
    L24:
        entitySupplier = r7.getSupplier();     // Catch: Throwable -> L42
        entitySyncDataSupplier = r7.getEntitySyncDataSupplier();     // Catch: Throwable -> L42
        EntityContextHolder.INSTANCE.init(getSContext());     // Catch: Throwable -> L42
        isInitialized = true;     // Catch: Throwable -> L42
        initialCountDownLatch.countDown();     // Catch: Throwable -> L42
        if (isNotInFeatureProcess() == false) goto L33;
        Logger r8 = Logger.INSTANCE;     // Catch: Throwable -> L42
        StringBuilder r4 = new StringBuilder("initTask, featureProcess: ");     // Catch: Throwable -> L42
        String r0 = featureRunProcessName;     // Catch: Throwable -> L42
        if (r0 != null) goto L29;
        r0 = "MainProcess";
    L29:
        r8.w(TAG, r4.append(r0).append(", currentProcess: ").append(h.a.a(getSContext())).toString());     // Catch: Throwable -> L42
        monitor-exit(this);
        return;
    L33:
        if (entitySupplier != null) goto L37;
        monitor-exit(this);
        return;
    L37:
        if (isCredentialProtectionLocked() == false) goto L39;
        Logger.INSTANCE.d(TAG, "device locked, wait user unlock");     // Catch: Throwable -> L42
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(getSContext(), deviceUnlockedReceiver, new IntentFilter("android.intent.action.USER_UNLOCKED"));     // Catch: Throwable -> L42
    L40:
        monitor-exit(this);
        return;
    L39:
        IndexTaskManager.INSTANCE.postTaskDelay(INIT_TASK_DELAY_TIME, "checkIfFirstRunOrDataClean", new EntityProvider$$ExternalSyntheticLambda5());     // Catch: Throwable -> L42
        goto L40
    L17:
        if (r2.length() != 0) goto L19;
        boolean r5 = true;
    L20:
        if (r5 != true) goto L22;
        r3 = true;
        goto L22
    L19:
        r5 = false;
        goto L20
    L11:
        if (StringsKt.startsWith$default(r2, ":", false, 2, null) == false) goto L14;
        r2 = INSTANCE.getSContext().getPackageName() + r2;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        throw th;
    }

    public final boolean isDonateAllowed(int r5) {
        Bundle r0 = new Bundle();
        r0.putInt(KEY_ENTITY_TYPE, r5);
        Uri r1 = ENTITY_URI;
        Intrinsics.checkNotNullExpressionValue(r1, "ENTITY_URI");
        Boolean r3 = null;
        Bundle r4 = innerCall(r1, METHOD_IS_DONATE_ALLOWED_BY_LOCAL_SWITCH, null, r0);
        if (r4 == null) goto L5;
        r4.setClassLoader(AppEntity.class.getClassLoader());
    L7:
        if (r4 == null) goto L9;
        r3 = Boolean.valueOf(r4.getBoolean(KEY_IS_DONATE_ALLOWED, false));
    L9:
        Logger.INSTANCE.i(TAG, "isDonateAllowed:type=" + r5 + ",value=" + r3);
        if (r3 != null) goto L12;
        return false;
    L12:
        return r3.booleanValue();
    L5:
        r4 = null;
        goto L7
    }

    public final boolean isInitialized() {
        return isInitialized;
    }

    public final Bundle queryPersonalContextData$capabilitykit_release() {
        Uri r1 = ENTITY_URI;
        Intrinsics.checkNotNullExpressionValue(r1, "ENTITY_URI");
        return innerCall$default(this, r1, METHOD_QUERY_PERSONAL_CONTEXT_DATA, null, null, 8, null);
    }

    public final boolean reDonateCheck$capabilitykit_release(String r9) {
        if (MemoryServiceChecker.INSTANCE.checkEntityProviderAvailable(getSContext()) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.i(TAG, "EntityProvider is not available, skip reDonateCheck");
        return false;
    L6:
        if (r9 != null) goto L29;
        return false;
    L29:
        EntityUpdateVersionParams r8 = (EntityUpdateVersionParams) UtilsKt.getGson().fromJson(r9, EntityUpdateVersionParams.class);     // Catch: JsonSyntaxException -> L26
        final LinkedHashSet r10 = new LinkedHashSet();
        Iterator<Map.Entry<Integer, EntityVersionData>> r11 = r8.getOldEntityVersions().entrySet().iterator();
    L11:
        if (r11.hasNext() == false) goto L21;
        Map.Entry<Integer, EntityVersionData> r0 = r11.next();
        EntityVersionData r1 = r0.getValue();
        EntityClassData<? extends AppEntity> r4 = EntityType.INSTANCE.getClassMap().get(r0.getKey());
        if (r4 == null) goto L15;
        int r5 = r4.getVersion();
    L16:
        EntityVersionData r3 = new EntityVersionData(r5, AppEntity.CREATOR.getVersion());
        Logger.INSTANCE.i(TAG, "reDonateCheck, type: " + r0.getKey().intValue() + " sdkVersion: " + r3 + " personalContextVersion: " + r1);
        if (r3.getSelfVersion() == (-1)) goto L11;
        if (r3.compareTo2(r1) <= 0) goto L11;
        r10.add(r0.getKey());
        goto L11
    L15:
        r5 = -1;
        goto L16
    L21:
        Logger r12 = Logger.INSTANCE;
        r12.i(TAG, "reDonateCheck, needDonateVersions" + r10);
        if (r10.isEmpty() == false) goto L24;
        return true;
    L24:
        final CountDownLatch r2 = new CountDownLatch(1);
        IndexTaskManager.INSTANCE.runTask("reDonateTask", new EntityProvider$$ExternalSyntheticLambda3(r2, r10));
        r2.await();
        r12.i(TAG, "reDonateCheck, reDonate finish");
        return true;
    L26:
        e = move-exception;
        Logger.INSTANCE.e(TAG, "reDonateCheck parse json error, jsonString: " + r9, e);
        return false;
    }

    public final void reindexEntityData$capabilitykit_release() {
        if (MemoryServiceChecker.INSTANCE.checkEntityProviderAvailable(getSContext()) == MemoryServiceStatus.AVAILABLE) goto L13;
        Logger.INSTANCE.i(TAG, "EntityProvider is not available, skip reindexEntityData");
        return;
    L13:
        final CountDownLatch r4 = new CountDownLatch(1);     // Catch: Exception -> L10
        IndexTaskManager r0 = IndexTaskManager.INSTANCE;     // Catch: Exception -> L10
        r0.runTask("reindexEntityData", new EntityProvider$$ExternalSyntheticLambda0(r4));     // Catch: Exception -> L10
        r4.await();     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        Logger.INSTANCE.e(TAG, "reindexEntityData error", e);
    }

    public final void setSContext(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        sContext = r1;
    }

    public final void syncData(final List<Integer> r4) {
        Intrinsics.checkNotNullParameter(r4, "indexedEntityTypes");
        if (MemoryServiceChecker.INSTANCE.checkEntityProviderAvailable(getSContext()) == MemoryServiceStatus.AVAILABLE) goto L7;
        Logger.INSTANCE.w(TAG, "EntityProvider is not available, skip syncData");
        return;
    L7:
        if (isCredentialProtectionLocked() == false) goto L10;
        Logger.INSTANCE.w(TAG, "syncData, credentialProtectionLocked");
        return;
    L10:
        final CountDownLatch r3 = new CountDownLatch(1);
        IndexTaskManager.INSTANCE.runTask("syncData", new EntityProvider$$ExternalSyntheticLambda4(r4, r3));
        r3.await();
    }

    public final void waitEntityProviderInit(long r2) {
        initialCountDownLatch.await(r2, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Logger.INSTANCE.e(TAG, "waitEntityProviderInit throwable", th);
    }
}
