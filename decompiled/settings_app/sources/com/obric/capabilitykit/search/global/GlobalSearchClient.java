package com.obric.capabilitykit.search.global;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.security.bytedance.guard.BDSecurityGuardStub;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.entity.memory.MemoryServiceChecker;
import com.obric.capabilitykit.entity.memory.MemoryServiceStatus;
import com.obric.capabilitykit.entity.search.global.GlobalSearchRequest;
import com.obric.capabilitykit.entity.search.global.GlobalSearchResult;
import com.obric.capabilitykit.entity.search.global.IGlobalSearchService;
import com.obric.capabilitykit.logger.Logger;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import cz.msebera.android.httpclient.message.TokenParser;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0002J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0006J\u0018\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\tH\u0002J\u001e\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020\u001bJ\b\u0010%\u001a\u00020\u001bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/capabilitykit/search/global/GlobalSearchClient;", "", "()V", "NONE_ERROR_ENTITY_TYPE", "", "TAG", "", "businessMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", WsConstants.KEY_CONNECTION, "com/obric/capabilitykit/search/global/GlobalSearchClient$connection$1", "Lcom/obric/capabilitykit/search/global/GlobalSearchClient$connection$1;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "isBound", "", "mainHandler", "Landroid/os/Handler;", "pendingOperations", "Ljava/util/Queue;", "Lkotlin/Function0;", "service", "Lcom/obric/capabilitykit/entity/search/global/IGlobalSearchService;", "bindService", BDSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "", "businessName", "isCancelled", "timestamp", "startGlobalSearch", Ext.KEY_REQUEST, "Lcom/obric/capabilitykit/entity/search/global/GlobalSearchRequest;", "callback", "Lcom/obric/capabilitykit/search/global/IGlobalSearchCallback;", "stop", "unbindService", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GlobalSearchClient {
    public static final GlobalSearchClient INSTANCE = null;
    public static final int NONE_ERROR_ENTITY_TYPE = -1;
    private static final String TAG = "GlobalSearchClient";
    private static final ConcurrentHashMap<String, Long> businessMap = null;
    private static final a connection = null;
    private static final Context context = null;
    private static boolean isBound;
    private static final Handler mainHandler = null;
    private static final Queue<Function0<Object>> pendingOperations = null;
    private static IGlobalSearchService service;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/obric/capabilitykit/search/global/GlobalSearchClient$connection$1", "Landroid/content/ServiceConnection;", "onServiceConnected", "", "name", "Landroid/content/ComponentName;", "binder", "Landroid/os/IBinder;", "onServiceDisconnected", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r2, IBinder r3) {
            GlobalSearchClient r1 = GlobalSearchClient.INSTANCE;
            GlobalSearchClient.access$setService$p(IGlobalSearchService.Stub.asInterface(r3));
            Logger.INSTANCE.d(GlobalSearchClient.TAG, "onServiceConnected " + r2);
            GlobalSearchClient.access$setBound$p(true);
        L4:
            if ((!GlobalSearchClient.access$getPendingOperations$p().isEmpty()) == false) goto L8;
            Function0 r4 = (Function0) GlobalSearchClient.access$getPendingOperations$p().poll();
            if (r4 == null) goto L4;
            r4.invoke();
            goto L4
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r3) {
            Logger.INSTANCE.d(GlobalSearchClient.TAG, "onServiceDisconnected " + r3);
            GlobalSearchClient r2 = GlobalSearchClient.INSTANCE;
            GlobalSearchClient.access$setService$p(null);
            GlobalSearchClient.access$setBound$p(false);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<Object> {
        public final /* synthetic */ IGlobalSearchCallback a;
        public final /* synthetic */ String b;
        public final /* synthetic */ GlobalSearchRequest c;

        @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"com/obric/capabilitykit/search/global/GlobalSearchClient$startGlobalSearch$operation$1$1", "Lcom/obric/capabilitykit/entity/search/global/IGlobalSearchCallback$Stub;", "onAllCompleted", "", "onCompleted", "entityType", "", "onError", AccountConst.KEY_ERROR_CODE, AccountConst.KEY_ERROR_MSG, "", "onSearchResult", "result", "Lcom/obric/capabilitykit/entity/search/global/GlobalSearchResult;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a extends com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback.Stub {
            public final /* synthetic */ String a;
            public final /* synthetic */ long b;
            public final /* synthetic */ IGlobalSearchCallback c;

            /* JADX INFO: renamed from: $r8$lambda$-854c9zS8KC34Ppoz9ldVs9kRYc, reason: not valid java name */
            public static /* synthetic */ void m1003$r8$lambda$854c9zS8KC34Ppoz9ldVs9kRYc(String r0, long r1, IGlobalSearchCallback r3) {
                a(r0, r1, r3);
            }

            /* JADX INFO: renamed from: $r8$lambda$5E8VhNMmoWxBB-8MitBgOadozG4, reason: not valid java name */
            public static /* synthetic */ void m1004$r8$lambda$5E8VhNMmoWxBB8MitBgOadozG4(String r0, long r1, IGlobalSearchCallback r3, int r4) {
                a(r0, r1, r3, r4);
            }

            public static /* synthetic */ void $r8$lambda$qK42MxT_Ij_sOuhvobgChalC40g(String r0, long r1, IGlobalSearchCallback r3, int r4, String r5) {
                a(r0, r1, r3, r4, r5);
            }

            /* JADX INFO: renamed from: $r8$lambda$r8WYu-23Ups3PQTqvFwx_0CJVx4, reason: not valid java name */
            public static /* synthetic */ void m1005$r8$lambda$r8WYu23Ups3PQTqvFwx_0CJVx4(String r0, long r1, IGlobalSearchCallback r3, GlobalSearchResult r4) {
                a(r0, r1, r3, r4);
            }

            public a(String r1, long r2, IGlobalSearchCallback r4) {
                this.a = r1;
                this.b = r2;
                this.c = r4;
            }

            private static final void a(String r1, long r2, IGlobalSearchCallback r4) {
                Intrinsics.checkNotNullParameter(r1, "$businessName");
                Intrinsics.checkNotNullParameter(r4, "$callback");
                if (GlobalSearchClient.access$isCancelled(GlobalSearchClient.INSTANCE, r1, r2) == true) goto L6;
                r4.onAllCompleted();
                GlobalSearchClient.access$getBusinessMap$p().remove(r1);
                return;
            }

            private static final void a(String r1, long r2, IGlobalSearchCallback r4, int r5) {
                Intrinsics.checkNotNullParameter(r1, "$businessName");
                Intrinsics.checkNotNullParameter(r4, "$callback");
                if (GlobalSearchClient.access$isCancelled(GlobalSearchClient.INSTANCE, r1, r2) == true) goto L6;
                r4.onCompleted(r5);
                return;
            }

            private static final void a(String r1, long r2, IGlobalSearchCallback r4, int r5, String r6) {
                Intrinsics.checkNotNullParameter(r1, "$businessName");
                Intrinsics.checkNotNullParameter(r4, "$callback");
                Intrinsics.checkNotNullParameter(r6, "$errorMsg");
                if (GlobalSearchClient.access$isCancelled(GlobalSearchClient.INSTANCE, r1, r2) == true) goto L6;
                r4.onError(r5, -1, r6);
                GlobalSearchClient.access$getBusinessMap$p().remove(r1);
                return;
            }

            private static final void a(String r1, long r2, IGlobalSearchCallback r4, GlobalSearchResult r5) {
                Intrinsics.checkNotNullParameter(r1, "$businessName");
                Intrinsics.checkNotNullParameter(r4, "$callback");
                Intrinsics.checkNotNullParameter(r5, "$result");
                if (GlobalSearchClient.access$isCancelled(GlobalSearchClient.INSTANCE, r1, r2) == true) goto L6;
                r4.onSearchResult(r5);
                return;
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
            public void onAllCompleted() {
                Logger.INSTANCE.d(GlobalSearchClient.TAG, "onAllCompleted");
                Handler r0 = GlobalSearchClient.access$getMainHandler$p();
                final String r1 = this.a;
                final long r2 = this.b;
                final IGlobalSearchCallback r5 = this.c;
                r0.post(new GlobalSearchClient$b$a$$ExternalSyntheticLambda0(r1, r2, r5));
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
            public void onCompleted(final int r8) {
                Logger.INSTANCE.d(GlobalSearchClient.TAG, "onCompleted " + r8);
                Handler r0 = GlobalSearchClient.access$getMainHandler$p();
                final String r2 = this.a;
                final long r3 = this.b;
                final IGlobalSearchCallback r5 = this.c;
                r0.post(new GlobalSearchClient$b$a$$ExternalSyntheticLambda3(r2, r3, r5, r8));
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
            public void onError(final int r8, int r9, final String r10) {
                Intrinsics.checkNotNullParameter(r10, AccountConst.KEY_ERROR_MSG);
                Logger.INSTANCE.w(GlobalSearchClient.TAG, "onError: " + r8 + TokenParser.SP + r10);
                Handler r11 = GlobalSearchClient.access$getMainHandler$p();
                final String r1 = this.a;
                final long r2 = this.b;
                final IGlobalSearchCallback r4 = this.c;
                r11.post(new GlobalSearchClient$b$a$$ExternalSyntheticLambda1(r1, r2, r4, r8, r10));
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
            public void onSearchResult(final GlobalSearchResult r8) {
                Intrinsics.checkNotNullParameter(r8, "result");
                Logger.INSTANCE.d(GlobalSearchClient.TAG, "onSearchResult: " + r8);
                Handler r0 = GlobalSearchClient.access$getMainHandler$p();
                final String r2 = this.a;
                final long r3 = this.b;
                final IGlobalSearchCallback r5 = this.c;
                r0.post(new GlobalSearchClient$b$a$$ExternalSyntheticLambda2(r2, r3, r5, r8));
            }
        }

        /* JADX INFO: renamed from: $r8$lambda$iqeFuGxDJkRxGq-kKhciR7U1NQ0, reason: not valid java name */
        public static /* synthetic */ void m1002$r8$lambda$iqeFuGxDJkRxGqkKhciR7U1NQ0(IGlobalSearchCallback r0, Throwable r1) {
            a(r0, r1);
        }

        public b(IGlobalSearchCallback r1, String r2, GlobalSearchRequest r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            super(0);
        }

        private static final void a(IGlobalSearchCallback r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r2, "$callback");
            Intrinsics.checkNotNullParameter(r3, "$e");
            String r4 = r3.getMessage();
            if (r4 != null) goto L5;
            r4 = "";
        L5:
            r2.onError(1, -1, r4);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
        L11:
            th = move-exception;
            th.printStackTrace();
            Logger.INSTANCE.e(GlobalSearchClient.TAG, "exception " + th.getMessage());
            Handler r1 = GlobalSearchClient.access$getMainHandler$p();
            final IGlobalSearchCallback r8 = this.a;
            return Boolean.valueOf(r1.post(new GlobalSearchClient$b$$ExternalSyntheticLambda0(r8, th)));
        L3:
            if (GlobalSearchClient.access$getService$p() != null) goto L5;
            this.a.onError(2, -1, "service not ready");     // Catch: Throwable -> L11
        L8:
            return Unit.INSTANCE;
        L5:
            long r0 = System.currentTimeMillis();     // Catch: Throwable -> L11
            GlobalSearchClient.access$getBusinessMap$p().put(this.b, Long.valueOf(r0));     // Catch: Throwable -> L11
            IGlobalSearchService r2 = GlobalSearchClient.access$getService$p();     // Catch: Throwable -> L11
            if (r2 == null) goto L10;
            r2.startGlobalSearch(this.b, this.c, new a(this.b, r0, this.a));     // Catch: Throwable -> L11
            goto L8
        L10:
            return null;
        }
    }

    static {
        INSTANCE = new GlobalSearchClient();
        context = AppHost.Companion.getApplication().getApplicationContext();
        mainHandler = new Handler(Looper.getMainLooper());
        pendingOperations = new LinkedList();
        businessMap = new ConcurrentHashMap();
        connection = new a();
    }

    private GlobalSearchClient() {
    }

    public static final /* synthetic */ ConcurrentHashMap access$getBusinessMap$p() {
        return businessMap;
    }

    public static final /* synthetic */ Handler access$getMainHandler$p() {
        return mainHandler;
    }

    public static final /* synthetic */ Queue access$getPendingOperations$p() {
        return pendingOperations;
    }

    public static final /* synthetic */ IGlobalSearchService access$getService$p() {
        return service;
    }

    public static final /* synthetic */ boolean access$isCancelled(GlobalSearchClient r0, String r1, long r2) {
        return r0.isCancelled(r1, r2);
    }

    public static final /* synthetic */ void access$setBound$p(boolean r0) {
        isBound = r0;
    }

    public static final /* synthetic */ void access$setService$p(IGlobalSearchService r0) {
        service = r0;
    }

    private final boolean bindService() {
        Logger.INSTANCE.d(TAG, "start bindService");
        Intent r7 = new Intent(MemoryServiceChecker.ACTION_GLOBAL_SEARCH_SERVICE);
        List<ResolveInfo> r0 = context.getPackageManager().queryIntentServices(r7, 0);
        Intrinsics.checkNotNullExpressionValue(r0, "context.packageManager.q…IntentServices(intent, 0)");
        Iterator<T> r1 = r0.iterator();
    L3:
        String r5 = null;
        if (r1.hasNext() == false) goto L11;
        Object r3 = r1.next();
        if (((ResolveInfo) r3).serviceInfo == null) goto L8;
        boolean r6 = true;
    L9:
        if (r6 == false) goto L3;
    L12:
        ResolveInfo r4 = (ResolveInfo) r3;
        if (r4 == null) goto L15;
        ServiceInfo r2 = r4.serviceInfo;
    L16:
        if (r2 != null) goto L19;
        Logger.INSTANCE.e(TAG, "No service found for action: " + r7.getAction());
        return false;
    L19:
        r7.setPackage(r2.packageName);
        boolean r8 = context.bindService(r7, connection, 1);
        if (r8 == true) goto L25;
        Logger r9 = Logger.INSTANCE;
        StringBuilder r10 = new StringBuilder("not found service ");
        ComponentName r11 = r7.getComponent();
        if (r11 == null) goto L24;
        r5 = r11.getShortClassName();
    L24:
        r9.w(TAG, r10.append(r5).toString());
    L25:
        return r8;
    L15:
        r2 = null;
        goto L16
    L8:
        r6 = false;
        goto L9
    L11:
        r3 = null;
        goto L12
    }

    private final boolean isCancelled(String r1, long r2) {
        Long r0 = businessMap.get(r1);
        if (r0 != null) goto L6;
    L7:
        Logger.INSTANCE.d(TAG, "ignore expired search");
        return true;
    L6:
        if (r0.longValue() != r2) goto L7;
        return false;
    }

    private final void unbindService() {
        if (isBound == false) goto L6;
        context.unbindService(connection);
        isBound = false;
        return;
    }

    public final void cancel(String r3) {
        Intrinsics.checkNotNullParameter(r3, "businessName");
        MemoryServiceChecker r2 = MemoryServiceChecker.INSTANCE;
        Context r0 = context;
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        if (r2.checkGlobalSearchServiceAvailable(r0) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Global search service is not available, skip cancel");
        return;
    L6:
        businessMap.remove(r3);
        if (isBound == false) goto L17;
        IGlobalSearchService r4 = service;     // Catch: RemoteException -> L12
        if (r4 == null) goto L18;
        r4.cancel(r3);     // Catch: RemoteException -> L12
        return;
    L18:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public final void startGlobalSearch(String r4, GlobalSearchRequest r5, IGlobalSearchCallback r6) {
        Intrinsics.checkNotNullParameter(r4, "businessName");
        Intrinsics.checkNotNullParameter(r5, Ext.KEY_REQUEST);
        Intrinsics.checkNotNullParameter(r6, "callback");
        MemoryServiceChecker r0 = MemoryServiceChecker.INSTANCE;
        Context r1 = context;
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        if (r0.checkGlobalSearchServiceAvailable(r1) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Global search service is not available, skip startGlobalSearch");
        r6.onError(6, -1, "Global search service is not available");
        return;
    L6:
        b r2 = new b(r6, r4, r5);
        if (isBound == false) goto L9;
        r2.invoke();
        return;
    L9:
        pendingOperations.add(r2);
        bindService();
    }

    public final void stop() {
        MemoryServiceChecker r0 = MemoryServiceChecker.INSTANCE;
        Context r1 = context;
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        if (r0.checkGlobalSearchServiceAvailable(r1) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Global search service is not available, skip stop");
        return;
    L6:
        businessMap.clear();
        unbindService();
    }
}
