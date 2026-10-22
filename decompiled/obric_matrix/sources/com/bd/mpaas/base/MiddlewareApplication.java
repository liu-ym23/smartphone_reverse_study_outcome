package com.bd.mpaas.base;

import android.app.Application;
import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.keva.KevaBuilder;
import com.bytedance.os.oms.OmsLogger;
import com.obric.matrix.account_api.e;
import com.obric.matrix.atomic_capability_api.IAtomicCapabilityService;
import com.obric.matrix.base.settings.MatrixSettingsManager;
import com.obric.matrix.common_api.IMetaSec;
import com.obric.matrix.dataanalysis.h;
import com.obric.matrix.location_api.ILocationService;
import com.obric.matrix.osettings_api.IOSettings;
import com.obric.matrix.push_api.IPush;
import com.obric.matrix.q.h.i;
import com.obric.matrix.q.h.j;
import com.obric.matrix.ws_api.IWs;
import h.a.b1;
import h.a.m0;
import h.a.n0;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.k0.j.a.f;
import kotlin.k0.j.a.l;
import kotlin.n0.c.p;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.u0.k;
import kotlin.w;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\u0006\u0010\t\u001a\u00020\u0006J\b\u0010\n\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\bH\u0002J\b\u0010\u0019\u001a\u00020\u0006H\u0002J\b\u0010\u001a\u001a\u00020\u0006H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\bH\u0002J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\bH\u0002J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bd/mpaas/base/MiddlewareApplication;", "Lcom/bytedance/mpaas/app/LaunchApplication;", "()V", LocationMonitorConst.TAG, "", "attachBaseContext", "", "base", "Landroid/content/Context;", "boeSettingsInit", "dumpAppInfo", "formatOmsLogTag", "getApplicationContext", "getWrapContext", "initALog", "context", "initAccount", "initAtomicCapabilities", "initLocation", "initMetaSec", "initOSettings", "initOmsLogger", "initPush", "initSettings", "wrapContext", "initUnlockedWhenStart", "initWs", "isFeedbackerProcess", "", "isRestartProcess", "onCreate", "setLogLevel", "Companion", "app_matrix_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MiddlewareApplication extends com.bytedance.mpaas.app.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f539l = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f540k;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bd/mpaas/base/MiddlewareApplication$Companion;", "", "()V", "OMS_LOG_TAG_PREFIX", "", "originApp", "Landroid/app/Application;", "getOriginApplication", "app_matrix_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g r1) {
            this();
        }
    }

    @f(c = "com.bd.mpaas.base.MiddlewareApplication$initALog$1", f = "MiddlewareApplication.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b extends l implements p<m0, kotlin.k0.d<? super f0>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f541f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ MiddlewareApplication f542g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Context f543h;

        b(MiddlewareApplication r1, Context r2, kotlin.k0.d<? super b> r3) {
            this.f542g = r1;
            this.f543h = r2;
            super(2, r3);
        }

        @Override // kotlin.k0.j.a.a
        public final kotlin.k0.d<f0> create(Object r2, kotlin.k0.d<?> r3) {
            return new b(this.f542g, this.f543h, r3);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(m0 r1, kotlin.k0.d<? super f0> r2) {
            return ((b) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(m0 r1, kotlin.k0.d<? super f0> r2) {
            return invoke2(r1, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r7) {
            kotlin.k0.i.b.c();
            if (this.f541f != 0) goto L11;
            w.b(r7);
            com.obric.matrix.r.e.f r8 = com.obric.matrix.r.e.f.f9940a;
            String r9 = MiddlewareApplication.f(this.f542g);
            Context r6 = this.f543h;
            com.obric.matrix.r.c.c.b(r9, "initALog >>>");
            long r1 = System.currentTimeMillis();
            com.obric.matrix.r.c.a r3 = com.obric.matrix.r.c.a.f9914a;
            if (r6.isDeviceProtectedStorage() == true) goto L8;
            r6 = r6.createDeviceProtectedStorageContext();
        L8:
            o.e(r6, "if (context.isDeviceProt…ProtectedStorageContext()");
            r3.c(r6, false);
            f0 r10 = f0.f18324a;
            com.obric.matrix.r.c.c.b(r9, "initALog <<< cost: " + (System.currentTimeMillis() - r1) + " ms");
            return r10;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/bd/mpaas/base/MiddlewareApplication$initSettings$1", "Lcom/obric/matrix/dataanalysis/DeviceIdManager$DeviceIdListener;", "onDeviceIdReady", "", "deviceId", "", "onInstallIdReady", "installId", "app_matrix_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c implements h.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f544a;

        c(Context r1) {
            this.f544a = r1;
        }

        @Override // com.obric.matrix.dataanalysis.h.b
        public void a(String r1) {
            o.f(r1, "installId");
        }

        @Override // com.obric.matrix.dataanalysis.h.b
        public void b(String r2) {
            o.f(r2, "deviceId");
            MatrixSettingsManager.f8847a.e(this.f544a);
        }
    }

    static {
        f539l = new a(null);
    }

    public MiddlewareApplication() {
        this.f540k = "MiddlewareApplication";
    }

    public static /* synthetic */ void A(MiddlewareApplication r0, int r1, String r2, String r3, Throwable r4) {
        s(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void B(MiddlewareApplication r0, Throwable r1) {
        C(r0, r1);
    }

    private static final void C(MiddlewareApplication r2, Throwable r3) {
        o.f(r2, "this$0");
        com.obric.matrix.r.c.c.b(r2.f540k, "Rxjava error " + Log.getStackTraceString(r3));
    }

    private final void D() {
        d.b.m.d.a.f(2);
        Logger.setLogLevel(5);
        com.ttnet.org.chromium.base.Logger.setLogLevel(5);
    }

    @Proxy("getApplicationContext")
    @TargetClass(scope = Scope.ALL, value = "android.content.Context")
    public static Context d(com.bytedance.mpaas.app.a r2) {
        e(r2);     // Catch: Exception -> L4
        return r2;
    L4:
        e = move-exception;
        com.obric.matrix.r.c.c.g("hookGetApplicationContext", "getApplicationContext error", e);
        return com.bytedance.mpaas.app.a.a();
    }

    static /* synthetic */ Context e(com.bytedance.mpaas.app.a r0) {
        super.getApplicationContext();
        return r0;
    }

    public static final /* synthetic */ String f(MiddlewareApplication r0) {
        return r0.f540k;
    }

    private static final void h(MiddlewareApplication r3) {
        o.f(r3, "this$0");
    L9:
        e = move-exception;
        com.obric.matrix.r.c.c.f(r3.f540k, Log.getStackTraceString(e));
        return;
    L5:
        if (com.obric.matrix.base.env.d.f8838a.e() == false) goto L7;
        Settings.Global.putInt(r3.getContentResolver(), "matrix_env_status_is_boe", 1);     // Catch: Exception -> L9
    L12:
        return;
    L7:
        Settings.Global.putInt(r3.getContentResolver(), "matrix_env_status_is_boe", 0);     // Catch: Exception -> L9
        goto L12
    }

    private final void i() {
        com.obric.matrix.r.c.c.j(this.f540k, "APP_BUILD_NO: 20260921-23:54:06|f68053159|zhouzhiqiang.nicole_bugfix: versionCode 2.5.0_f68053159_'2026-09-21_23:29', APP_BUILD_TYPE: release, APP_VERSION_CODE: 600808520, APP_VERSION_NAME: 6.8.8, APP_FLAVOR: cn");
    }

    private final String j(String r4) {
        if (r4 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        r4 = "OmsLogger";
    L12:
        if (k.A(r4, "Oms_", false, 2, null) == false) goto L15;
        return r4;
    L15:
        return "Oms_" + r4;
    L5:
        if (k.q(r4) == true) goto L8;
        r0 = false;
        goto L9
    }

    private final Context k() {
        return com.obric.matrix.r.b.g(this);
    }

    private final void l(Context r7) {
        h.a.h.b(n0.b(), b1.b(), null, new b(this, r7, null), 2, null);
    }

    private final void m() {
        com.obric.matrix.r.e.f r0 = com.obric.matrix.r.e.f.f9940a;
        String r1 = this.f540k;
        com.obric.matrix.r.c.c.b(r1, "initAccount >>>");
        long r3 = System.currentTimeMillis();
        com.obric.matrix.r.b r2 = com.obric.matrix.r.b.f9910a;
        if (r2.d() == false) goto L5;
    L7:
        e.f8822a.e(this);
        com.obric.matrix.account.o.a.f8592a.a();     // Catch: Exception -> L10
    L12:
        f0 r6 = f0.f18324a;
        com.obric.matrix.r.c.c.b(r1, "initAccount <<< cost: " + (System.currentTimeMillis() - r3) + " ms");
        return;
    L10:
        e = move-exception;
        com.obric.matrix.r.c.c.g(f(this), "init account failed", e);
        goto L12
    L5:
        if (r2.f() == true) goto L7;
        goto L7
    }

    private final void n() {
        com.obric.matrix.r.e.f r0 = com.obric.matrix.r.e.f.f9940a;
        String r1 = this.f540k;
        com.obric.matrix.r.c.c.b(r1, "initAtomicCapabilities >>>");
        long r3 = System.currentTimeMillis();
        IAtomicCapabilityService r2 = (IAtomicCapabilityService) com.bytedance.news.common.service.manager.d.a(IAtomicCapabilityService.class);     // Catch: Exception -> L5
        Application r5 = com.bytedance.mpaas.app.a.f5245g;     // Catch: Exception -> L5
        o.e(r5, "sApplication");     // Catch: Exception -> L5
        r2.init(r5);     // Catch: Exception -> L5
    L7:
        f0 r7 = f0.f18324a;
        com.obric.matrix.r.c.c.b(r1, "initAtomicCapabilities <<< cost: " + (System.currentTimeMillis() - r3) + " ms");
        return;
    L5:
        e = move-exception;
        com.obric.matrix.r.c.c.g(f(this), "init atomic capability failed", e);
        goto L7
    }

    private final void o() {
        com.obric.matrix.r.e.f r0 = com.obric.matrix.r.e.f.f9940a;
        String r1 = this.f540k;
        com.obric.matrix.r.c.c.b(r1, "initLocation >>>");
        long r3 = System.currentTimeMillis();
        ILocationService r2 = (ILocationService) com.bytedance.news.common.service.manager.d.a(ILocationService.class);     // Catch: Exception -> L5
        Application r5 = com.bytedance.mpaas.app.a.f5245g;     // Catch: Exception -> L5
        o.e(r5, "sApplication");     // Catch: Exception -> L5
        r2.init(r5);     // Catch: Exception -> L5
    L7:
        f0 r7 = f0.f18324a;
        com.obric.matrix.r.c.c.b(r1, "initLocation <<< cost: " + (System.currentTimeMillis() - r3) + " ms");
        return;
    L5:
        e = move-exception;
        com.obric.matrix.r.c.c.g(f(this), "init location failed", e);
        goto L7
    }

    private final void p(Context r1) {
        ((IMetaSec) com.bytedance.news.common.service.manager.d.a(IMetaSec.class)).init(r1);
    }

    private final void q() {
        com.obric.matrix.r.e.f r0 = com.obric.matrix.r.e.f.f9940a;
        String r1 = this.f540k;
        com.obric.matrix.r.c.c.b(r1, "initOSettings >>>");
        long r3 = System.currentTimeMillis();
        IOSettings r2 = (IOSettings) com.bytedance.news.common.service.manager.d.a(IOSettings.class);     // Catch: Exception -> L5
        Application r5 = com.bytedance.mpaas.app.a.f5245g;     // Catch: Exception -> L5
        o.e(r5, "sApplication");     // Catch: Exception -> L5
        r2.init(r5);     // Catch: Exception -> L5
    L7:
        f0 r7 = f0.f18324a;
        com.obric.matrix.r.c.c.b(r1, "initOSettings <<< cost: " + (System.currentTimeMillis() - r3) + " ms");
        return;
    L5:
        e = move-exception;
        com.obric.matrix.r.c.c.g(f(this), "init osettings failed", e);
        goto L7
    }

    private final void r() {
        OmsLogger.setLoggerDelegate(new com.bd.mpaas.base.b(this));
    }

    private static final void s(MiddlewareApplication r1, int r2, String r3, String r4, Throwable r5) {
        o.f(r1, "this$0");
        String r6 = r1.j(r3);
        switch(r2) {
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            case 7: goto L5;
            default: goto L7;
        };
    L5:
        com.obric.matrix.r.c.c.g(r6, r4, r5);
        return;
    L6:
        com.obric.matrix.r.c.c.t(r6, r4, r5);
        return;
    L7:
        com.obric.matrix.r.c.c.k(r6, r4, r5);
        return;
    L8:
        com.obric.matrix.r.c.c.c(r6, r4, r5);
        return;
    L9:
        com.obric.matrix.r.c.c.r(r6, r4, r5);
    }

    private final void t() {
        com.obric.matrix.r.e.f r1 = com.obric.matrix.r.e.f.f9940a;
        String r2 = this.f540k;
        com.obric.matrix.r.c.c.b(r2, "initPush >>>");
        long r4 = System.currentTimeMillis();
        IPush r3 = (IPush) com.bytedance.news.common.service.manager.d.a(IPush.class);     // Catch: Exception -> L5
        Application r6 = com.bytedance.mpaas.app.a.f5245g;     // Catch: Exception -> L5
        o.e(r6, "sApplication");     // Catch: Exception -> L5
        r3.init(r6);     // Catch: Exception -> L5
        com.obric.matrix.opush_api.IPush r5 = (com.obric.matrix.opush_api.IPush) com.bytedance.news.common.service.manager.d.a(com.obric.matrix.opush_api.IPush.class);     // Catch: Exception -> L5
        Application r7 = com.bytedance.mpaas.app.a.f5245g;     // Catch: Exception -> L5
        o.e(r7, "sApplication");     // Catch: Exception -> L5
        r5.init(r7);     // Catch: Exception -> L5
    L7:
        f0 r8 = f0.f18324a;
        com.obric.matrix.r.c.c.b(r2, "initPush <<< cost: " + (System.currentTimeMillis() - r4) + " ms");
        return;
    L5:
        e = move-exception;
        com.obric.matrix.r.c.c.g(f(this), "init push failed", e);
        goto L7
    }

    private final void u(Context r2) {
        h.f9059i.a().l(new c(r2));
    }

    private final void v() {
        ((IPush) com.bytedance.news.common.service.manager.d.a(IPush.class)).initLockedWhenStart();
    }

    private final void w() {
        com.obric.matrix.r.e.f r0 = com.obric.matrix.r.e.f.f9940a;
        String r1 = this.f540k;
        com.obric.matrix.r.c.c.b(r1, "initWs >>>");
        long r3 = System.currentTimeMillis();
        IWs r2 = (IWs) com.bytedance.news.common.service.manager.d.a(IWs.class);     // Catch: Exception -> L5
        Application r5 = com.bytedance.mpaas.app.a.f5245g;     // Catch: Exception -> L5
        o.e(r5, "sApplication");     // Catch: Exception -> L5
        r2.init(r5);     // Catch: Exception -> L5
    L7:
        f0 r7 = f0.f18324a;
        com.obric.matrix.r.c.c.b(r1, "initWs <<< cost: " + (System.currentTimeMillis() - r3) + " ms");
        return;
    L5:
        e = move-exception;
        com.obric.matrix.r.c.c.g(f(this), "init ws failed", e);
        goto L7
    }

    private final boolean x(Context r4) {
        String r3 = com.ss.android.k.c.c.a(r4);
        if (r3 != null) goto L5;
        return false;
    L5:
        if (k.n(r3, ":feedbacker", false, 2, null) == false) goto L9;
        return true;
    L9:
        return false;
    }

    private final boolean y(Context r4) {
        String r3 = com.ss.android.k.c.c.a(r4);
        if (r3 != null) goto L5;
        return false;
    L5:
        if (k.n(r3, ":matrix2", false, 2, null) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static /* synthetic */ void z(MiddlewareApplication r0) {
        h(r0);
    }

    @Override // com.bytedance.mpaas.app.a, android.content.ContextWrapper
    protected void attachBaseContext(Context r3) {
        d r0 = d.f548a;
        r0.b();
        com.obric.matrix.r.b r1 = com.obric.matrix.r.b.f9910a;
        r1.e(this);
        if (r1.f() == false) goto L7;
        if (r3 == null) goto L6;
        r3 = r3.createDeviceProtectedStorageContext();
        goto L7
    L6:
        r3 = null;
    L7:
        super.attachBaseContext(r3);
        KevaBuilder.getInstance().setContext(this);
        v();
        l(this);
        r();
        h.f9059i.b(this);
        r0.a();
    }

    public final void g() {
        com.bytedance.common.utility.m.c.c(new com.bd.mpaas.base.a(this));
    }

    @Override // com.bytedance.mpaas.app.a, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        Context r1 = d(this);
        o.e(r1, "super.getApplicationContext()");
        return com.obric.matrix.r.b.g(r1);
    }

    @Override // com.bytedance.mpaas.app.a, android.app.Application
    public void onCreate() {
        Context r0 = k();
        if (y(r0) == false) goto L5;
        return;
    L5:
        com.obric.matrix.r.c.c.j(this.f540k, "onCreate >>>");
        d r1 = d.f548a;
        r1.d();
        super.onCreate();
        r1.e();
        i();
        if (x(r0) == false) goto L8;
        return;
    L8:
        D();
        if (f.a.k.a.j() == true) goto L11;
        f.a.k.a.p(new com.bd.mpaas.base.c(this));
    L11:
        i.f9882a.b(r0);
        com.obric.matrix.q.h.k.o(r0);
        com.obric.matrix.p.a r2 = com.obric.matrix.p.a.f9466a;
        Context r3 = createDeviceProtectedStorageContext();
        o.e(r3, "createDeviceProtectedStorageContext()");
        r2.f(r3);
        q();
        w();
        t();
        o();
        u(r0);
        g();
        com.obric.matrix.q.h.b.f9869a.b();
        j.f9884a.b();
        com.obric.matrix.r.d.a.g().i(r0);
        m();
        n();
        r1.c();
        com.obric.matrix.badge.a.f8833a.a(r0);
        p(r0);
        com.obric.matrix.r.c.c.j(this.f540k, "onCreate <<<");
    }
}
