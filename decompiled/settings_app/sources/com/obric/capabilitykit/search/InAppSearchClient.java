package com.obric.capabilitykit.search;

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
import com.obric.capabilitykit.entity.search.EntityChangeMonitorRequest;
import com.obric.capabilitykit.entity.search.EntityChangeResult;
import com.obric.capabilitykit.entity.search.IEntityChangeCallback;
import com.obric.capabilitykit.entity.search.IInAppSearchCallback;
import com.obric.capabilitykit.entity.search.IInAppSearchService;
import com.obric.capabilitykit.entity.search.InAppSearchRequest;
import com.obric.capabilitykit.entity.search.InAppSearchResult;
import com.obric.capabilitykit.entity.search.InAppSearchResultWithoutEntity;
import com.obric.capabilitykit.logger.Logger;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import cz.msebera.android.httpclient.message.TokenParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\n\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0010H\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004J\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\bH\u0002J\u0006\u0010\u001e\u001a\u00020\u001aJ\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040 2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0004J\u0016\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u001e\u0010'\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010(\u001a\u00020)2\u0006\u0010%\u001a\u00020*J\u0006\u0010+\u001a\u00020\u001aJ\u0006\u0010,\u001a\u00020\u001aJ\b\u0010-\u001a\u00020\u001aH\u0002J\u0006\u0010.\u001a\u00020\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/obric/capabilitykit/search/InAppSearchClient;", "", "()V", "ACTION_SEARCH_SERVICE", "", "TAG", "businessMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", WsConstants.KEY_CONNECTION, "com/obric/capabilitykit/search/InAppSearchClient$connection$1", "Lcom/obric/capabilitykit/search/InAppSearchClient$connection$1;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "isBound", "", "mainHandler", "Landroid/os/Handler;", "pendingOperations", "Ljava/util/Queue;", "Lkotlin/Function0;", "service", "Lcom/obric/capabilitykit/entity/search/IInAppSearchService;", "bindService", BDSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "", "businessName", "isCancelled", "timestamp", "prepareSearch", "queryServicePackagesByAction", "", "action", "registerEntityObserver", "entityChangeMonitorRequest", "Lcom/obric/capabilitykit/entity/search/EntityChangeMonitorRequest;", "callback", "Lcom/obric/capabilitykit/search/IAppEntityChangeCallback;", "startAppSearch", Ext.KEY_REQUEST, "Lcom/obric/capabilitykit/entity/search/InAppSearchRequest;", "Lcom/obric/capabilitykit/search/IAppSearchCallback;", "stop", "stopSearch", "unbindService", "unregisterEntityObserver", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InAppSearchClient {
    private static final String ACTION_SEARCH_SERVICE = "com.obric.memorydata.action.SEARCH_SERVICE";
    public static final InAppSearchClient INSTANCE = null;
    private static final String TAG = "InAppSearchClient";
    private static final ConcurrentHashMap<String, Long> businessMap = null;
    private static final a connection = null;
    private static final Context context = null;
    private static boolean isBound;
    private static final Handler mainHandler = null;
    private static final Queue<Function0<Object>> pendingOperations = null;
    private static IInAppSearchService service;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/obric/capabilitykit/search/InAppSearchClient$connection$1", "Landroid/content/ServiceConnection;", "onServiceConnected", "", "name", "Landroid/content/ComponentName;", "binder", "Landroid/os/IBinder;", "onServiceDisconnected", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r2, IBinder r3) {
            InAppSearchClient r1 = InAppSearchClient.INSTANCE;
            InAppSearchClient.access$setService$p(IInAppSearchService.Stub.asInterface(r3));
            Logger.INSTANCE.d(InAppSearchClient.TAG, "onServiceConnected " + r2);
            InAppSearchClient.access$setBound$p(true);
        L4:
            if ((!InAppSearchClient.access$getPendingOperations$p().isEmpty()) == false) goto L8;
            Function0 r4 = (Function0) InAppSearchClient.access$getPendingOperations$p().poll();
            if (r4 == null) goto L4;
            r4.invoke();
            goto L4
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r3) {
            Logger.INSTANCE.d(InAppSearchClient.TAG, "onServiceDisconnected " + r3);
            InAppSearchClient r2 = InAppSearchClient.INSTANCE;
            InAppSearchClient.access$setService$p(null);
            InAppSearchClient.access$setBound$p(false);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Lkotlin/Unit;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<Unit> {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
            super(0);
        }

        public final Unit a() {
            IInAppSearchService r3 = InAppSearchClient.access$getService$p();     // Catch: Throwable -> L7
            if (r3 == null) goto L6;
            r3.prepareSearch();     // Catch: Throwable -> L7
            return Unit.INSTANCE;
        L6:
            return null;
        L7:
            th = move-exception;
            th.printStackTrace();
            Logger.INSTANCE.e(InAppSearchClient.TAG, "exception " + th.getMessage());
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function0<Object> {
        public final /* synthetic */ IAppEntityChangeCallback a;
        public final /* synthetic */ EntityChangeMonitorRequest b;

        @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/obric/capabilitykit/search/InAppSearchClient$registerEntityObserver$operation$1$1", "Lcom/obric/capabilitykit/entity/search/IEntityChangeCallback$Stub;", "onChange", "", "result", "Lcom/obric/capabilitykit/entity/search/EntityChangeResult;", "onError", AccountConst.KEY_ERROR_CODE, "", AccountConst.KEY_ERROR_MSG, "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a extends IEntityChangeCallback.Stub {
            public final /* synthetic */ IAppEntityChangeCallback a;

            public static /* synthetic */ void $r8$lambda$MBBpeLO7AFlkGu6ujqV986rfyb4(IAppEntityChangeCallback r0, EntityChangeResult r1) {
                a(r0, r1);
            }

            public static /* synthetic */ void $r8$lambda$geX8TvJO2QDvzLJPLNBPvr2dfUE(IAppEntityChangeCallback r0, int r1, String r2) {
                a(r0, r1, r2);
            }

            public a(IAppEntityChangeCallback r1) {
                this.a = r1;
            }

            private static final void a(IAppEntityChangeCallback r1, int r2, String r3) {
                Intrinsics.checkNotNullParameter(r1, "$callback");
                Intrinsics.checkNotNullParameter(r3, "$errorMsg");
                r1.onError(r2, r3);
            }

            private static final void a(IAppEntityChangeCallback r1, EntityChangeResult r2) {
                Intrinsics.checkNotNullParameter(r1, "$callback");
                Intrinsics.checkNotNullParameter(r2, "$result");
                r1.onChange(r2);
            }

            @Override // com.obric.capabilitykit.entity.search.IEntityChangeCallback
            public void onChange(final EntityChangeResult r3) {
                Intrinsics.checkNotNullParameter(r3, "result");
                Handler r0 = InAppSearchClient.access$getMainHandler$p();
                final IAppEntityChangeCallback r2 = this.a;
                r0.post(new InAppSearchClient$c$a$$ExternalSyntheticLambda0(r2, r3));
            }

            @Override // com.obric.capabilitykit.entity.search.IEntityChangeCallback
            public void onError(final int r4, final String r5) {
                Intrinsics.checkNotNullParameter(r5, AccountConst.KEY_ERROR_MSG);
                Logger.INSTANCE.w(InAppSearchClient.TAG, "onError: " + r4 + TokenParser.SP + r5);
                Handler r0 = InAppSearchClient.access$getMainHandler$p();
                final IAppEntityChangeCallback r3 = this.a;
                r0.post(new InAppSearchClient$c$a$$ExternalSyntheticLambda1(r3, r4, r5));
            }
        }

        /* JADX INFO: renamed from: $r8$lambda$oGDEIdie0g-vMy3k6uqLBju-nCM, reason: not valid java name */
        public static /* synthetic */ void m999$r8$lambda$oGDEIdie0gvMy3k6uqLBjunCM(IAppEntityChangeCallback r0, Throwable r1) {
            a(r0, r1);
        }

        public c(IAppEntityChangeCallback r1, EntityChangeMonitorRequest r2) {
            this.a = r1;
            this.b = r2;
            super(0);
        }

        private static final void a(IAppEntityChangeCallback r1, Throwable r2) {
            Intrinsics.checkNotNullParameter(r1, "$callback");
            Intrinsics.checkNotNullParameter(r2, "$e");
            String r3 = r2.getMessage();
            if (r3 != null) goto L5;
            r3 = "";
        L5:
            r1.onError(1, r3);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MemoryServiceChecker r1 = MemoryServiceChecker.INSTANCE;     // Catch: Throwable -> L15
            Context r2 = InAppSearchClient.access$getContext$p();     // Catch: Throwable -> L15
            Intrinsics.checkNotNullExpressionValue(r2, "context");     // Catch: Throwable -> L15
            if (r1.checkSearchServiceAvailable(r2) == MemoryServiceStatus.AVAILABLE) goto L7;
            Logger.INSTANCE.w(InAppSearchClient.TAG, "Memory search service is not available, skip registerEntityObserver");     // Catch: Throwable -> L15
            this.a.onError(6, "Memory search service is disabled");     // Catch: Throwable -> L15
        L12:
            return Unit.INSTANCE;
        L7:
            if (InAppSearchClient.access$getService$p() != null) goto L9;
            this.a.onError(2, "service not ready");     // Catch: Throwable -> L15
            goto L12
        L9:
            IInAppSearchService r3 = InAppSearchClient.access$getService$p();     // Catch: Throwable -> L15
            if (r3 == null) goto L14;
            r3.registerEntityObserver(this.b, new a(this.a));     // Catch: Throwable -> L15
            goto L12
        L14:
            return null;
        L15:
            th = move-exception;
            th.printStackTrace();
            Logger.INSTANCE.e(InAppSearchClient.TAG, "exception " + th.getMessage());
            Handler r0 = InAppSearchClient.access$getMainHandler$p();
            final IAppEntityChangeCallback r5 = this.a;
            return Boolean.valueOf(r0.post(new InAppSearchClient$c$$ExternalSyntheticLambda0(r5, th)));
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function0<Object> {
        public final /* synthetic */ IAppSearchCallback a;
        public final /* synthetic */ String b;
        public final /* synthetic */ InAppSearchRequest c;

        @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"com/obric/capabilitykit/search/InAppSearchClient$startAppSearch$operation$1$1", "Lcom/obric/capabilitykit/entity/search/IInAppSearchCallback$Stub;", "onCompleted", "", "onError", AccountConst.KEY_ERROR_CODE, "", AccountConst.KEY_ERROR_MSG, "", "onSearchResult", "result", "Lcom/obric/capabilitykit/entity/search/InAppSearchResult;", "onSearchResultWithoutEntity", "Lcom/obric/capabilitykit/entity/search/InAppSearchResultWithoutEntity;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a extends IInAppSearchCallback.Stub {
            public final /* synthetic */ String a;
            public final /* synthetic */ long b;
            public final /* synthetic */ IAppSearchCallback c;

            public static /* synthetic */ void $r8$lambda$M7YiRtclisfG5SQX_uad561zL88(String r0, long r1, IAppSearchCallback r3, int r4, String r5) {
                a(r0, r1, r3, r4, r5);
            }

            /* JADX INFO: renamed from: $r8$lambda$MMtM6GzrBtGSw9wXZeHLcJP-s6U, reason: not valid java name */
            public static /* synthetic */ void m1000$r8$lambda$MMtM6GzrBtGSw9wXZeHLcJPs6U(String r0, long r1, IAppSearchCallback r3) {
                a(r0, r1, r3);
            }

            public static /* synthetic */ void $r8$lambda$ZWtYUYYv5POfkGzZOdIwIKcCsO8(String r0, long r1, IAppSearchCallback r3, InAppSearchResultWithoutEntity r4) {
                a(r0, r1, r3, r4);
            }

            /* JADX INFO: renamed from: $r8$lambda$kIR1dlnQntc1kjTKjeCj3-P-MJs, reason: not valid java name */
            public static /* synthetic */ void m1001$r8$lambda$kIR1dlnQntc1kjTKjeCj3PMJs(String r0, long r1, IAppSearchCallback r3, InAppSearchResult r4) {
                a(r0, r1, r3, r4);
            }

            public a(String r1, long r2, IAppSearchCallback r4) {
                this.a = r1;
                this.b = r2;
                this.c = r4;
            }

            private static final void a(String r1, long r2, IAppSearchCallback r4) {
                Intrinsics.checkNotNullParameter(r1, "$businessName");
                Intrinsics.checkNotNullParameter(r4, "$callback");
                if (InAppSearchClient.access$isCancelled(InAppSearchClient.INSTANCE, r1, r2) == true) goto L6;
                r4.onCompleted();
                InAppSearchClient.access$getBusinessMap$p().remove(r1);
                return;
            }

            private static final void a(String r1, long r2, IAppSearchCallback r4, int r5, String r6) {
                Intrinsics.checkNotNullParameter(r1, "$businessName");
                Intrinsics.checkNotNullParameter(r4, "$callback");
                Intrinsics.checkNotNullParameter(r6, "$errorMsg");
                if (InAppSearchClient.access$isCancelled(InAppSearchClient.INSTANCE, r1, r2) == true) goto L6;
                r4.onError(r5, r6);
                InAppSearchClient.access$getBusinessMap$p().remove(r1);
                return;
            }

            private static final void a(String r1, long r2, IAppSearchCallback r4, InAppSearchResult r5) {
                Intrinsics.checkNotNullParameter(r1, "$businessName");
                Intrinsics.checkNotNullParameter(r4, "$callback");
                Intrinsics.checkNotNullParameter(r5, "$result");
                if (InAppSearchClient.access$isCancelled(InAppSearchClient.INSTANCE, r1, r2) == true) goto L6;
                r4.onSearchResult(r5);
                return;
            }

            private static final void a(String r1, long r2, IAppSearchCallback r4, InAppSearchResultWithoutEntity r5) {
                Intrinsics.checkNotNullParameter(r1, "$businessName");
                Intrinsics.checkNotNullParameter(r4, "$callback");
                Intrinsics.checkNotNullParameter(r5, "$result");
                if (InAppSearchClient.access$isCancelled(InAppSearchClient.INSTANCE, r1, r2) == true) goto L6;
                r4.onSearchResultWithoutEntity(r5);
                return;
            }

            @Override // com.obric.capabilitykit.entity.search.IInAppSearchCallback
            public void onCompleted() {
                Logger.INSTANCE.d(InAppSearchClient.TAG, "onCompleted");
                Handler r0 = InAppSearchClient.access$getMainHandler$p();
                final String r1 = this.a;
                final long r2 = this.b;
                final IAppSearchCallback r5 = this.c;
                r0.post(new InAppSearchClient$d$a$$ExternalSyntheticLambda3(r1, r2, r5));
            }

            @Override // com.obric.capabilitykit.entity.search.IInAppSearchCallback
            public void onError(final int r9, final String r10) {
                Intrinsics.checkNotNullParameter(r10, AccountConst.KEY_ERROR_MSG);
                Logger.INSTANCE.w(InAppSearchClient.TAG, "onError: " + r9 + TokenParser.SP + r10);
                Handler r0 = InAppSearchClient.access$getMainHandler$p();
                final String r2 = this.a;
                final long r3 = this.b;
                final IAppSearchCallback r5 = this.c;
                r0.post(new InAppSearchClient$d$a$$ExternalSyntheticLambda2(r2, r3, r5, r9, r10));
            }

            @Override // com.obric.capabilitykit.entity.search.IInAppSearchCallback
            public void onSearchResult(final InAppSearchResult r8) {
                Intrinsics.checkNotNullParameter(r8, "result");
                Logger.INSTANCE.d(InAppSearchClient.TAG, "onSearchResult: " + r8);
                Handler r0 = InAppSearchClient.access$getMainHandler$p();
                final String r2 = this.a;
                final long r3 = this.b;
                final IAppSearchCallback r5 = this.c;
                r0.post(new InAppSearchClient$d$a$$ExternalSyntheticLambda0(r2, r3, r5, r8));
            }

            @Override // com.obric.capabilitykit.entity.search.IInAppSearchCallback
            public void onSearchResultWithoutEntity(final InAppSearchResultWithoutEntity r8) {
                Intrinsics.checkNotNullParameter(r8, "result");
                Logger.INSTANCE.d(InAppSearchClient.TAG, "onSearchResultWithoutEntity");
                Handler r0 = InAppSearchClient.access$getMainHandler$p();
                final String r2 = this.a;
                final long r3 = this.b;
                final IAppSearchCallback r5 = this.c;
                r0.post(new InAppSearchClient$d$a$$ExternalSyntheticLambda1(r2, r3, r5, r8));
            }
        }

        public static /* synthetic */ void $r8$lambda$uYcuRoSw_QM7xokr3pEPv6pJAgo(IAppSearchCallback r0, Throwable r1) {
            a(r0, r1);
        }

        public d(IAppSearchCallback r1, String r2, InAppSearchRequest r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            super(0);
        }

        private static final void a(IAppSearchCallback r1, Throwable r2) {
            Intrinsics.checkNotNullParameter(r1, "$callback");
            Intrinsics.checkNotNullParameter(r2, "$e");
            String r3 = r2.getMessage();
            if (r3 != null) goto L5;
            r3 = "";
        L5:
            r1.onError(1, r3);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
        L11:
            th = move-exception;
            th.printStackTrace();
            Logger.INSTANCE.e(InAppSearchClient.TAG, "exception " + th.getMessage());
            Handler r1 = InAppSearchClient.access$getMainHandler$p();
            final IAppSearchCallback r8 = this.a;
            return Boolean.valueOf(r1.post(new InAppSearchClient$d$$ExternalSyntheticLambda0(r8, th)));
        L3:
            if (InAppSearchClient.access$getService$p() != null) goto L5;
            this.a.onError(2, "service not ready");     // Catch: Throwable -> L11
        L8:
            return Unit.INSTANCE;
        L5:
            long r0 = System.currentTimeMillis();     // Catch: Throwable -> L11
            InAppSearchClient.access$getBusinessMap$p().put(this.b, Long.valueOf(r0));     // Catch: Throwable -> L11
            IInAppSearchService r2 = InAppSearchClient.access$getService$p();     // Catch: Throwable -> L11
            if (r2 == null) goto L10;
            r2.startAppSearch(this.b, this.c, new a(this.b, r0, this.a));     // Catch: Throwable -> L11
            goto L8
        L10:
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Lkotlin/Unit;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e extends Lambda implements Function0<Unit> {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
            super(0);
        }

        public final Unit a() {
            IInAppSearchService r0 = InAppSearchClient.access$getService$p();     // Catch: RemoteException -> L7
            if (r0 == null) goto L6;
            r0.unregisterEntityObserver();     // Catch: RemoteException -> L7
            return Unit.INSTANCE;
        L6:
            return null;
        L7:
            e = move-exception;
            e.printStackTrace();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            return a();
        }
    }

    static {
        INSTANCE = new InAppSearchClient();
        context = AppHost.Companion.getApplication().getApplicationContext();
        mainHandler = new Handler(Looper.getMainLooper());
        pendingOperations = new LinkedList();
        businessMap = new ConcurrentHashMap();
        connection = new a();
    }

    private InAppSearchClient() {
    }

    public static final /* synthetic */ ConcurrentHashMap access$getBusinessMap$p() {
        return businessMap;
    }

    public static final /* synthetic */ Context access$getContext$p() {
        return context;
    }

    public static final /* synthetic */ Handler access$getMainHandler$p() {
        return mainHandler;
    }

    public static final /* synthetic */ Queue access$getPendingOperations$p() {
        return pendingOperations;
    }

    public static final /* synthetic */ IInAppSearchService access$getService$p() {
        return service;
    }

    public static final /* synthetic */ boolean access$isCancelled(InAppSearchClient r0, String r1, long r2) {
        return r0.isCancelled(r1, r2);
    }

    public static final /* synthetic */ void access$setBound$p(boolean r0) {
        isBound = r0;
    }

    public static final /* synthetic */ void access$setService$p(IInAppSearchService r0) {
        service = r0;
    }

    private final boolean bindService() {
        Logger r0 = Logger.INSTANCE;
        r0.d(TAG, "start bindService");
        Context r1 = context;
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        List<String> r6 = queryServicePackagesByAction(r1, "com.obric.memorydata.action.SEARCH_SERVICE");
        if (r6.size() != 1) goto L12;
        Intent r4 = new Intent("com.obric.memorydata.action.SEARCH_SERVICE");
        r4.setPackage((String) CollectionsKt.first(r6));
        boolean r7 = r1.bindService(r4, connection, 1);
        if (r7 == true) goto L11;
        StringBuilder r2 = new StringBuilder("not found service ");
        ComponentName r3 = r4.getComponent();
        if (r3 == null) goto L9;
        String r5 = r3.getShortClassName();
    L10:
        r0.w(TAG, r2.append(r5).toString());
        goto L11
    L9:
        r5 = null;
    L11:
        return r7;
    L12:
        r0.w(TAG, "not found service com.obric.memorydata.action.SEARCH_SERVICE, result = " + r6);
        return false;
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
        if (r2.checkSearchServiceAvailable(r0) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Memory search service is not available, skip cancel");
        return;
    L6:
        businessMap.remove(r3);
        if (isBound == false) goto L17;
        IInAppSearchService r4 = service;     // Catch: RemoteException -> L12
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

    public final void prepareSearch() {
        MemoryServiceChecker r0 = MemoryServiceChecker.INSTANCE;
        Context r1 = context;
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        if (r0.checkSearchServiceAvailable(r1) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Memory search service is not available, skip prepareSearch");
        return;
    L6:
        b r2 = b.a;
        if (isBound == false) goto L9;
        r2.invoke();
        return;
    L9:
        pendingOperations.add(r2);
        bindService();
    }

    public final List<String> queryServicePackagesByAction(Context r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "action");
        Intent r0 = new Intent(r2);
        List<ResolveInfo> r3 = r1.getPackageManager().queryIntentServices(r0, 131072);
        Intrinsics.checkNotNullExpressionValue(r3, "pm.queryIntentServices(i…PackageManager.MATCH_ALL)");
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L12;
        ServiceInfo r6 = ((ResolveInfo) r5.next()).serviceInfo;
        if (r6 == null) goto L8;
        String r7 = r6.packageName;
    L9:
        if (r7 == null) goto L4;
        r4.add(r7);
        goto L4
    L8:
        r7 = null;
        goto L9
    L12:
        return CollectionsKt.distinct(r4);
    }

    public final void registerEntityObserver(EntityChangeMonitorRequest r2, IAppEntityChangeCallback r3) {
        Intrinsics.checkNotNullParameter(r2, "entityChangeMonitorRequest");
        Intrinsics.checkNotNullParameter(r3, "callback");
        c r0 = new c(r3, r2);
        if (isBound == false) goto L5;
        r0.invoke();
        return;
    L5:
        pendingOperations.add(r0);
        bindService();
    }

    public final void startAppSearch(String r4, InAppSearchRequest r5, IAppSearchCallback r6) {
        Intrinsics.checkNotNullParameter(r4, "businessName");
        Intrinsics.checkNotNullParameter(r5, Ext.KEY_REQUEST);
        Intrinsics.checkNotNullParameter(r6, "callback");
        MemoryServiceChecker r0 = MemoryServiceChecker.INSTANCE;
        Context r1 = context;
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        if (r0.checkSearchServiceAvailable(r1) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Memory search service is not available, skip startAppSearch");
        r6.onError(6, "Memory search service is disabled");
        return;
    L6:
        d r2 = new d(r6, r4, r5);
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
        if (r0.checkSearchServiceAvailable(r1) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Memory search service is not available, skip stop");
        return;
    L6:
        businessMap.clear();
        unbindService();
    }

    public final void stopSearch() {
        MemoryServiceChecker r2 = MemoryServiceChecker.INSTANCE;
        Context r0 = context;
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        if (r2.checkSearchServiceAvailable(r0) == MemoryServiceStatus.AVAILABLE) goto L7;
        Logger.INSTANCE.w(TAG, "Memory search service is not available, skip stopSearch");
        return;
    L7:
        if (isBound == false) goto L17;
        IInAppSearchService r3 = service;     // Catch: RemoteException -> L12
        if (r3 == null) goto L18;
        r3.stopSearch();     // Catch: RemoteException -> L12
        return;
    L18:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public final void unregisterEntityObserver() {
        MemoryServiceChecker r0 = MemoryServiceChecker.INSTANCE;
        Context r1 = context;
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        if (r0.checkSearchServiceAvailable(r1) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Memory search service is not available, skip unregisterEntityObserver");
        return;
    L6:
        e r2 = e.a;
        if (isBound == false) goto L9;
        r2.invoke();
        return;
    L9:
        pendingOperations.add(r2);
        bindService();
    }
}
