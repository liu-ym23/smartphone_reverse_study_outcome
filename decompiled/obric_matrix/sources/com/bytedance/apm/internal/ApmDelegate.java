package com.bytedance.apm.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.bytedance.apm.agent.tracing.AutoPageTraceHelper;
import com.bytedance.apm.config.SlardarConfigManagerImpl;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.doctor.DoctorManager;
import com.bytedance.apm.impl.ApmAgentServiceImpl;
import com.bytedance.apm.impl.LaunchTraceImpl;
import com.bytedance.apm.util.u;
import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.services.apm.api.IApmAgent;
import com.bytedance.services.apm.api.IEncrypt;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.ILaunchTrace;
import com.bytedance.services.apm.api.IWidget;
import com.bytedance.services.apm.api.IZstdCompress;
import com.bytedance.services.apm.api.IZstdDict;
import com.bytedance.services.apm.api.WidgetParams;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ApmDelegate implements IConfigListener {
    private static long r;
    private static boolean s;
    private static boolean t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.apm.config.b f1608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.apm.g0.a f1609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bytedance.apm.g0.e f1610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.bytedance.apm.config.c f1611d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bytedance.apm.w.b f1612e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private IEncrypt f1613f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private SlardarConfigManagerImpl f1614g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f1615h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile boolean f1616i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile boolean f1617j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f1618k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Set<IWidget> f1619l;
    boolean m;
    private boolean n;
    private List<String> o;
    private List<String> p;
    private List<String> q;

    class a implements Runnable {
        a(ApmDelegate r1) {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.monitor.collector.h.h();
        }
    }

    class b implements com.bytedance.news.common.service.manager.a<IApmAgent> {
        b(ApmDelegate r1) {
        }

        public IApmAgent a() {
            return new ApmAgentServiceImpl();
        }

        @Override // com.bytedance.news.common.service.manager.a
        public /* bridge */ /* synthetic */ IApmAgent create() {
            return a();
        }
    }

    class c implements com.bytedance.news.common.service.manager.a<ILaunchTrace> {
        c(ApmDelegate r1) {
        }

        public ILaunchTrace a() {
            return new LaunchTraceImpl();
        }

        @Override // com.bytedance.news.common.service.manager.a
        public /* bridge */ /* synthetic */ ILaunchTrace create() {
            return a();
        }
    }

    class d implements com.bytedance.news.common.service.manager.a<IZstdCompress> {
        d(ApmDelegate r1) {
        }

        public IZstdCompress a() {
            return new com.bytedance.apm.l();
        }

        @Override // com.bytedance.news.common.service.manager.a
        public /* bridge */ /* synthetic */ IZstdCompress create() {
            return a();
        }
    }

    class e implements com.bytedance.news.common.service.manager.a<IZstdDict> {
        e(ApmDelegate r1) {
        }

        public IZstdDict a() {
            return (IZstdDict) d.b.b.n.c.a(IZstdDict.class);
        }

        @Override // com.bytedance.news.common.service.manager.a
        public /* bridge */ /* synthetic */ IZstdDict create() {
            return a();
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f1620f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f1621g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f1622h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f1623i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ com.bytedance.apm.p.e f1624j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ com.bytedance.apm.p.d f1625k;

        f(ApmDelegate r1, String r2, long r3, long r5, String r7, com.bytedance.apm.p.e r8, com.bytedance.apm.p.d r9) {
            this.f1620f = r2;
            this.f1621g = r3;
            this.f1622h = r5;
            this.f1623i = r7;
            this.f1624j = r8;
            this.f1625k = r9;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.apm.p.a.f(this.f1620f, this.f1621g, this.f1622h, this.f1623i, this.f1624j, this.f1625k);
        }
    }

    class g implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.bytedance.apm.config.b f1626f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Context f1627g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Runnable f1628h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ ApmDelegate f1629i;

        g(ApmDelegate r1, com.bytedance.apm.config.b r2, Context r3, Runnable r4) {
            this.f1629i = r1;
            this.f1626f = r2;
            this.f1627g = r3;
            this.f1628h = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            ApmDelegate.a(this.f1629i).registerConfigListener(ApmDelegate.k());
            com.bytedance.apm.g0.c.f(this.f1626f.l());
            com.bytedance.apm.g0.c.g(this.f1626f.k());
            com.bytedance.apm.internal.a.e(this.f1627g);
            com.bytedance.apm.e r0 = com.bytedance.apm.d.x();
            if (r0 == null) goto L6;
            r0.b();
        L6:
            if (ApmDelegate.b(this.f1629i) == false) goto L20;
            com.bytedance.apm.r.m.e.A().T();
            com.bytedance.monitor.collector.j.a r1 = new com.bytedance.monitor.collector.j.a();
            r1.g(com.bytedance.apm.internal.a.b());
            if (com.bytedance.apm.internal.a.b() != 0) goto L10;
        L12:
            boolean r2 = false;
        L13:
            r1.i(r2);
            if (this.f1626f.r() == true) goto L16;
        L18:
            boolean r3 = false;
        L19:
            r1.j(r3);
            r1.m(com.bytedance.apm.internal.a.d(64));
            r1.k(false);
            r1.l(!ApmDelegate.c(this.f1629i).u());
            r1.n(com.bytedance.apm.internal.a.c());
            com.bytedance.monitor.collector.k.n().s(com.bytedance.apm.d.h(), r1.h());
            com.bytedance.monitor.collector.k.n().z();
            com.bytedance.monitor.collector.k.n().x(ApmDelegate.c(this.f1629i).s());
        L21:
            com.bytedance.apm.r.g.a().d();
            Runnable r4 = this.f1628h;
            if (r4 == null) goto L25;
            r4.run();
        L25:
            if (com.bytedance.apm.d.C() == false) goto L32;
            DoctorManager r5 = DoctorManager.getInstance();
            if (ApmDelegate.b(this.f1629i) == false) goto L29;
            String r6 = "APM_INIT_ASYNC";
        L30:
            r5.b(r6, "done");
            return;
        L29:
            r6 = "APM_INIT_ASYNC_OTHER_PROCESS";
            goto L30
        L32:
            return;
        L16:
            if (com.bytedance.apm.internal.a.d(2) == false) goto L18;
            r3 = true;
            goto L19
        L10:
            if (com.bytedance.apm.internal.a.d(2) == false) goto L12;
            r2 = true;
            goto L13
        L20:
            com.bytedance.monitor.collector.k.u(com.bytedance.apm.d.h());
            goto L21
        }
    }

    class h implements Runnable {
        h(ApmDelegate r1) {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.monitor.collector.k.n().C();
        }
    }

    class i implements Runnable {
        i(ApmDelegate r1) {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.monitor.collector.k.n().z();
        }
    }

    static class j implements DoctorManager.ApmListener {
        j() {
        }

        private void a(String r10, String r11, boolean r12) {
            int r9 = (4000 - r10.length()) - 5;
            if (r11.length() > r9) goto L9;
            String[] r13 = new String[2];
            if (r12 == false) goto L7;
            r13[0] = r10;
            r13[1] = " " + r11;
            com.bytedance.apm.x.e.c("APM-Doctor-Log", r13);
            return;
        L7:
            r13[0] = r10;
            r13[1] = " " + r11;
            com.bytedance.apm.x.e.d("APM-Doctor-Log", r13);
            return;
        L9:
            int r0 = 0;
        L11:
            if (r0 >= r11.length()) goto L21;
            int r6 = r0 + r9;
            if (r6 >= r11.length()) goto L15;
            String r1 = r11.substring(r0, r6);
        L16:
            String[] r7 = new String[2];
            if (r12 == false) goto L19;
            r7[0] = r10;
            r7[1] = " " + r1;
            com.bytedance.apm.x.e.c("APM-Doctor-Log", r7);
        L20:
            r0 = r6;
            goto L11
        L19:
            r7[0] = r10;
            r7[1] = " " + r1;
            com.bytedance.apm.x.e.d("APM-Doctor-Log", r7);
            goto L20
        L15:
            r1 = r11.substring(r0);
            goto L16
        }

        @Override // com.bytedance.apm.doctor.DoctorManager.ApmListener
        public void onDataEvent(int r5, String r6, JSONObject r7) {
            if (TextUtils.equals(r6, "DATA_CACHE") == false) goto L5;
            return;
        L5:
            if (TextUtils.equals(r6, "DATA_SEND_END") == false) goto L7;
            return;
        L7:
            if (TextUtils.equals(r6, "DATA_SEND_RESPONSE") == false) goto L10;
            return;
        L10:
            if (TextUtils.equals(r6, "DATA_RECEIVE") == true) goto L12;
        L14:
            a("onDataEvent[" + r5 + "] " + r6 + " [service:" + r7.optString("service") + "|logType:" + r7.optString("log_type") + "] = ", r7.toString(), r6.contains("ERROR"));
            return;
        L12:
            if (r7.optJSONObject("DATA_DOCTOR").optBoolean("DATA_SAMPLE") == true) goto L14;
            r6 = "DATA_NOT_SAMPLED";
            goto L14
        }

        @Override // com.bytedance.apm.doctor.DoctorManager.ApmListener
        public void onEvent(String r3, String r4) {
            a("onEvent key=" + r3, r4, false);
        }
    }

    class k implements d.b.o.b.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bytedance.apm.r.m.b f1630a;

        k(ApmDelegate r1, com.bytedance.apm.r.m.b r2) {
            this.f1630a = r2;
        }

        @Override // d.b.o.b.b
        public void a(long r1, boolean r3) {
            this.f1630a.k(r1, r3);
        }
    }

    class l implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ApmDelegate f1631f;

        l(ApmDelegate r1) {
            this.f1631f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            ApmDelegate.d(this.f1631f);
        }
    }

    class m implements com.bytedance.apm.k.b {
        m(ApmDelegate r1) {
        }

        @Override // com.bytedance.apm.k.b
        public void a(Throwable r2, String r3) {
            EnsureManager.reportLogEException(5, r2, r3, false);
        }

        @Override // com.bytedance.apm.k.b
        public void ensureNotReachHere(String r1) {
            EnsureManager.ensureNotReachHere(r1);
        }

        @Override // com.bytedance.apm.k.b
        public void ensureNotReachHere(Throwable r1, String r2) {
            EnsureManager.ensureNotReachHere(r1, r2);
        }
    }

    class n implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ApmDelegate f1632f;

        class a implements com.bytedance.apm.core.d {
            a(n r1) {
            }

            @Override // com.bytedance.apm.core.d
            public Map<String, String> a() {
                return com.bytedance.apm.d.y();
            }
        }

        n(ApmDelegate r1) {
            this.f1632f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            ApmDelegate.a(this.f1632f).initParams(ApmDelegate.e(this.f1632f).A(), new a(this), ApmDelegate.e(this.f1632f).t());
            if (ApmDelegate.e(this.f1632f).B() == true) goto L5;
        L7:
            ApmDelegate.a(this.f1632f).fetchConfig();
            return;
        L5:
            if (com.bytedance.apm.d.G() == false) goto L7;
            ApmDelegate.a(this.f1632f).forceUpdateFromRemote(null, null);
        }
    }

    private static class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final ApmDelegate f1633a = null;

        static {
            f1633a = new ApmDelegate(null);
        }

        static /* synthetic */ ApmDelegate a() {
            return f1633a;
        }
    }

    private ApmDelegate() {
        this.m = false;
        this.n = true;
    }

    /* synthetic */ ApmDelegate(g r1) {
        this();
    }

    private void D() {
        com.bytedance.apm.internal.b.a();
        com.bytedance.apm.d.h0(System.currentTimeMillis());
        com.bytedance.apm.d.e0(this.f1611d.s());
        d.b.b.l.a.f(this.f1611d.o());
        h();
        com.bytedance.apm.d0.c.g(new com.bytedance.apm.c0.a());
        com.bytedance.apm.k.e().f(new m(this));
        com.bytedance.apm.d.R(this.f1611d.m());
        com.bytedance.apm.d.Q(this.f1611d.i());
        com.bytedance.apm.d.S(this.f1611d.n());
        com.bytedance.apm.d.f0(this.f1611d.t());
        com.bytedance.apm.d.K(this.f1611d.b());
        this.f1613f = this.f1611d.j();
        this.f1619l = this.f1611d.x();
        t();
        com.bytedance.apm.z.a.b().a(this.f1611d.c());
        com.bytedance.apm.t.c.a.p().j();
        com.bytedance.apm.t.c.d.t().j();
        com.bytedance.apm.t.c.d.t().I(this.f1611d.q());
        com.bytedance.apm.p.a.e(com.bytedance.apm.d.h(), this.f1608a.c());
        r();
        long r0 = this.f1611d.h();
        n r2 = new n(this);
        if (r0 > 0) goto L5;
        com.bytedance.apm.f0.b.f().i(r2);
    L7:
        if (com.bytedance.apm.d.C() == false) goto L10;
        com.bytedance.apm.x.a.d("apm_debug", "delayRequestSeconds:" + r0);
    L10:
        if (this.f1618k == false) goto L12;
        g();
    L12:
        p(com.bytedance.apm.d.h());
        WidgetParams r1 = new WidgetParams();
        r1.setReportDomain(this.f1611d.g());
        v(r1);
        C();
        com.bytedance.apm.f0.b.f().h(this.f1611d.l());
        u(this.f1611d);
        com.bytedance.apm.w.b r3 = this.f1611d.d();
        this.f1612e = r3;
        if (r3 == null) goto L15;
        r3.a();
    L15:
        com.bytedance.apm.agent.tracing.a.j();
        com.bytedance.news.common.service.manager.d.d(IHttpService.class, new AnonymousClass7(this));
        if (com.bytedance.apm.d.C() == false) goto L23;
        DoctorManager r4 = DoctorManager.getInstance();
        if (this.f1618k == false) goto L20;
        String r5 = "APM_START";
    L21:
        r4.b(r5, this.f1611d.toString());
        goto L23
    L20:
        r5 = "APM_START_OTHER_PROCESS";
    L23:
        if (com.bytedance.apm.x.a.c() == null) goto L26;
        com.bytedance.apm.x.a.c().b("apm_debug", "APM_START");
        return;
    L26:
        return;
    L5:
        com.bytedance.apm.f0.b.f().k(r2, 1000 * r0);
        goto L7
    }

    private void E() {
        long r0 = System.nanoTime();     // Catch: Throwable -> L6
        d.b.b.i.c.a.E(this.f1611d.r());     // Catch: Throwable -> L6
        D();     // Catch: Throwable -> L6
        if (this.f1618k == false) goto L20;
        com.bytedance.apm.d.g0(System.nanoTime() - r0);     // Catch: Throwable -> L6
        z();     // Catch: Throwable -> L6
        return;
    L20:
        return;
    L6:
        th = move-exception;
        if (com.bytedance.apm.d.C() == false) goto L11;
        th.printStackTrace();
        DoctorManager.getInstance().b("APM_START_ERROR", u.a(th));
    L11:
        if (com.bytedance.apm.x.a.c() == null) goto L18;
        com.bytedance.apm.x.a.c().b("apm_debug", "APM_START_ERROR:" + u.a(th));
    L18:
        com.bytedance.apm.f0.b.f().o();     // Catch: Throwable -> L15
        return;
    }

    static /* synthetic */ SlardarConfigManagerImpl a(ApmDelegate r0) {
        return r0.f1614g;
    }

    static /* synthetic */ boolean b(ApmDelegate r0) {
        return r0.f1618k;
    }

    static /* synthetic */ com.bytedance.apm.config.b c(ApmDelegate r0) {
        return r0.f1608a;
    }

    static /* synthetic */ void d(ApmDelegate r0) {
        r0.E();
    }

    static /* synthetic */ com.bytedance.apm.config.c e(ApmDelegate r0) {
        return r0.f1611d;
    }

    @WorkerThread
    private void g() {
        String r2 = com.bytedance.apm.internal.b.a().d("update_version_code");
        String r1 = com.bytedance.apm.d.l().optString("update_version_code");
        if (TextUtils.equals(r2, r1) == true) goto L5;
        com.bytedance.apm.d.d0(1);
        com.bytedance.apm.internal.b.a().g("update_version_code", r1);
        return;
    L5:
        com.bytedance.apm.d.d0(2);
    }

    private void h() {
        if (com.bytedance.apm.util.i.b(this.f1611d.t()) == false) goto L8;
        if (com.bytedance.apm.util.i.b(this.o) == true) goto L8;
        this.f1611d.J(this.o);
    L8:
        if (com.bytedance.apm.util.i.b(this.f1611d.g()) == false) goto L13;
        if (com.bytedance.apm.util.i.b(this.p) == true) goto L13;
        this.f1611d.H(this.p);
    L13:
        if (com.bytedance.apm.util.i.b(this.f1611d.k()) == true) goto L15;
        return;
    L15:
        if (com.bytedance.apm.util.i.b(this.q) == true) goto L19;
        this.f1611d.I(this.q);
        return;
    }

    private void initEvilMethodTraceInject() {
    }

    private static void initTraceEvilMethod() {
        d.b.o.b.a.m(r);
        d.b.o.b.a.n(s);
        d.b.o.b.a.m = true;
        com.bytedance.apm.r.m.e.A().C();
        com.bytedance.apm.r.m.f.E().K();
        new d.b.o.b.a(t).p();
        com.bytedance.monitor.collector.k.n().y(true);
    }

    public static ApmDelegate k() {
        return o.a();
    }

    private void p(Context r2) {
        Set<IWidget> r1 = this.f1619l;
        if (r1 != null) goto L5;
        return;
    L5:
        Iterator<IWidget> r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        r3.next().init(r2);     // Catch: Throwable -> L12
        goto L7
    }

    private void q() {
        if (this.m == false) goto L5;
        return;
    L5:
        this.m = true;
        com.bytedance.apm.f0.a.a().post(new a(this));
        com.bytedance.apm.r.b r0 = new com.bytedance.apm.r.b();
        r0.k(this.f1611d.f());
        r0.n(this.f1611d.G());
        r0.l(this.f1611d.C());
        r0.j(this.f1611d.e());
        r0.i();
        if (ActivityLifeObserver.getInstance().isForeground() == false) goto L8;
        r0.o();
    L8:
        r0.m(this.f1608a.v());
    }

    private static void r() {
        String r0 = d.b.g.a.a();     // Catch: Throwable -> L6
        if (TextUtils.isEmpty(r0) == true) goto L11;
        com.bytedance.apm.d.l().put("bytrace_id", r0);     // Catch: Throwable -> L6
        com.bytedance.apm.d.l().put("pid", String.valueOf(Process.myPid()));     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    private void s(Application r1) {
    }

    private void t() {
        d.b.b.k.b.h().j();
        if (this.f1618k == false) goto L5;
        com.bytedance.apm.a0.f r0 = new com.bytedance.apm.a0.f();
        r0.Q(this.f1611d.u());
        r0.d();
    L5:
        com.bytedance.apm.a0.k.g.r(this.f1611d.w());
        d.b.b.g.a.d().f(this.f1611d.u());
        d.b.b.k.b.h().l(this.f1611d.p());
        if (this.f1611d.F() == true) goto L8;
        return;
    L8:
        if (this.f1611d.z() == true) goto L12;
        q();
        return;
    }

    private void u(@NonNull com.bytedance.apm.config.c r7) {
        List<String> r6 = r7.g();
        if (com.bytedance.apm.util.i.b(r6) == true) goto L15;
        int r0 = 0;
        String r1 = new URL(r6.get(0)).getHost();     // Catch: MalformedURLException -> L19
        com.bytedance.apm.b0.a.b(r1);     // Catch: MalformedURLException -> L19
        com.bytedance.apm.b0.a.a(r1);     // Catch: MalformedURLException -> L19
        com.bytedance.apm.p.g.a.a(r1);     // Catch: MalformedURLException -> L19
    L6:
        ArrayList r2 = new ArrayList(2);
        int r3 = r6.size();
    L7:
        if (r0 >= r3) goto L14;
        String r4 = new URL(r6.get(r0)).getHost();     // Catch: Exception -> L20
        if (TextUtils.isEmpty(r4) == true) goto L13;
        if (r4.indexOf(46) <= 0) goto L13;
        r2.add("https://" + r4 + "/monitor/collect/batch/");     // Catch: Exception -> L20
    L13:
        r0 = r0 + 1;
        goto L7
    L14:
        d.b.b.e.a.k.c.e().q(r2);
    L15:
        d.b.b.e.a.k.c.e().r(com.bytedance.apm.s.a.f1954c);
        d.b.b.e.a.k.c.e().p(com.bytedance.apm.s.a.f1955d);
        d.b.b.e.a.k.c.e().p(r7.k());
        List<String> r8 = r7.v();
        if (com.bytedance.apm.util.i.b(r8) == true) goto L29;
        d.b.b.e.a.k.c.e().r(r8);
        return;
    }

    private static void x() {
        if (com.bytedance.apm.d.C() == true) goto L5;
        return;
    L5:
        DoctorManager.getInstance().registerApmListener(new j());
    }

    private void y() {
        SlardarConfigManagerImpl r0 = new SlardarConfigManagerImpl();
        this.f1614g = r0;
        r0.registerConfigListener(this);
        com.bytedance.news.common.service.manager.d.d(IConfigManager.class, this.f1614g);
        com.bytedance.news.common.service.manager.d.c(IApmAgent.class, new b(this));
        com.bytedance.news.common.service.manager.d.c(ILaunchTrace.class, new c(this));
        com.bytedance.news.common.service.manager.d.c(IZstdCompress.class, new d(this));
        com.bytedance.news.common.service.manager.d.c(IZstdDict.class, new e(this));
    }

    @WorkerThread
    private void z() {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L4
        r0.put("init", com.bytedance.apm.d.n());     // Catch: JSONException -> L4
        r0.put("init_finish", com.bytedance.apm.d.o());     // Catch: JSONException -> L4
        r0.put("init_step2", com.bytedance.apm.d.p());     // Catch: JSONException -> L4
        r0.put("init_step3", com.bytedance.apm.d.q());     // Catch: JSONException -> L4
        r0.put("init_step4", com.bytedance.apm.d.r());     // Catch: JSONException -> L4
        r0.put("init_step5", com.bytedance.apm.d.s());     // Catch: JSONException -> L4
        r0.put("start", com.bytedance.apm.d.z());     // Catch: JSONException -> L4
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L4
        r1.put("is_main_process", this.f1618k);     // Catch: JSONException -> L4
        com.bytedance.apm.c.l("apm_cost", r1, r0, null);     // Catch: JSONException -> L4
        return;
    }

    public void A() {
        com.bytedance.apm.f0.b.f().n();
        com.bytedance.apm.f0.b.f().i(new i(this));
    }

    public void B(@NonNull com.bytedance.apm.config.c r4) {
        if (com.bytedance.apm.x.a.c() == null) goto L6;
        com.bytedance.apm.x.a.c().b("apm_debug", "start");     // Catch: Exception -> L17
    L6:
        if (this.f1616i == false) goto L16;
        if (r4 == null) goto L14;
        if (this.f1617j == false) goto L11;
        return;
    L11:
        com.bytedance.apm.f0.b.f().n();
        this.f1617j = true;
        this.f1611d = r4;
        com.bytedance.apm.f0.b.f().i(new l(this));
        return;
    L14:
        throw new IllegalArgumentException("startConfig must not be allowed");
    L16:
        throw new IllegalArgumentException("You must call Apm.getInstance().init() on Application.onCreate from version 5.x.x, pls call init() before start().");
    }

    public void C() {
        Set<IWidget> r1 = this.f1619l;
        if (r1 != null) goto L5;
        return;
    L5:
        Iterator<IWidget> r2 = r1.iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        r2.next().start();     // Catch: Throwable -> L12
        goto L7
    }

    public void f(String r13, long r14, long r16, String r18, com.bytedance.apm.p.e r19, com.bytedance.apm.p.d r20) {
        if (this.n == false) goto L5;
        com.bytedance.apm.f0.b.f().p(new f(this, r13, r14, r16, r18, r19, r20));
        return;
    L5:
        if (r20 == null) goto L9;
        r20.a(false, com.bytedance.apm.p.b.a(false, 9, null, null));
        return;
    }

    public com.bytedance.apm.config.b i() {
        com.bytedance.apm.config.b r0 = this.f1608a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return com.bytedance.apm.config.b.a().E();
    }

    public IEncrypt j() {
        return this.f1613f;
    }

    public boolean l(String r2) {
        if (this.f1615h == false) goto L9;
        SlardarConfigManagerImpl r1 = this.f1614g;
        if (r1 != null) goto L8;
        return false;
    L8:
        return r1.getLogTypeSwitch(r2);
    L9:
        return false;
    }

    public boolean m(String r2) {
        if (this.f1615h == false) goto L9;
        SlardarConfigManagerImpl r1 = this.f1614g;
        if (r1 != null) goto L8;
        return false;
    L8:
        return r1.getMetricTypeSwitch(r2);
    L9:
        return false;
    }

    public boolean n(String r2) {
        if (this.f1615h == false) goto L9;
        SlardarConfigManagerImpl r1 = this.f1614g;
        if (r1 != null) goto L8;
        return false;
    L8:
        return r1.getServiceSwitch(r2);
    L9:
        return false;
    }

    public void o(@NonNull Context r8, @NonNull com.bytedance.apm.config.b r9) {
        if (this.f1616i == true) goto L40;
        long r0 = System.nanoTime();
        this.f1616i = true;
        com.bytedance.apm.d.A();
        com.bytedance.apm.d.Z(System.currentTimeMillis());
        com.bytedance.apm.d.a0(System.currentTimeMillis() - SystemClock.uptimeMillis());
        this.f1608a = r9;
        com.bytedance.apm.util.l.d(r9.f());
        com.bytedance.apm.g0.a r3 = this.f1609b;
        if (r3 == null) goto L7;
        this.f1608a.B(r3);
    L7:
        com.bytedance.apm.g0.e r4 = this.f1610c;
        if (r4 != null) goto L38;
        com.bytedance.apm.t.a.n(r9.d());
        com.bytedance.apm.t.a.o(r9.y());
        d.b.b.d.a.o(r9.y());
        Application r5 = com.bytedance.apm.util.a.a(r8);
        com.bytedance.apm.d.M(r5);
        ActivityLifeObserver.init(r5);
        com.bytedance.apm.d.U(System.nanoTime() - r0);
        y();
        x();
        com.bytedance.apm.d.V(System.nanoTime() - r0);
        com.bytedance.apm.e r6 = com.bytedance.apm.d.x();
        if (r6 == null) goto L12;
        r6.a();
    L12:
        com.bytedance.apm.d.N(r9.j());
        this.f1618k = com.bytedance.apm.d.G();
        Runnable r7 = d.b.b.a.b(r8);
        com.bytedance.apm.d.W(System.nanoTime() - r0);
        com.bytedance.apm.f0.b.f().i(new g(this, r9, r8, r7));
        com.bytedance.apm.d.X(System.nanoTime() - r0);
        if (this.f1618k == false) goto L28;
        com.bytedance.apm.a0.i.a.a(r5, this.f1608a.b());
        if (r9.A() == false) goto L17;
        new com.bytedance.apm.g0.d().k(r9.i(), true);
    L17:
        AutoPageTraceHelper.d(r9.i());
        com.bytedance.apm.agent.tracing.a.k(r9.h());
        s(r5);
        t = r9.x();
        r = r9.e();
        s = r9.z();
        com.bytedance.apm.r.m.b.m(r9.n());
        boolean r10 = r9.w();
        boolean r11 = r9.q();
        com.bytedance.apm.r.m.e.A().C();
        com.bytedance.apm.r.m.e.A().Q(r9.o());
        com.bytedance.apm.r.m.e.A().O(r9.s());
        com.bytedance.apm.r.m.e.A().P(r9.u());
        com.bytedance.monitor.collector.o.f5224c = this.f1608a.t();
        if (r10 == false) goto L26;
        if (r11 == true) goto L26;
        com.bytedance.apm.r.m.b r12 = new com.bytedance.apm.r.m.b();
        com.bytedance.apm.g0.h.c.c(r12);
        d.b.o.b.a.l(new k(this, r12));
        if (Build.VERSION.SDK_INT >= 24) goto L23;
    L24:
        com.bytedance.apm.r.m.e.A().u(r12);
    L25:
        com.bytedance.apm.r.m.e.A().R(r12);
        goto L26
    L23:
        if (this.f1608a.u() == true) goto L25;
    L26:
        initEvilMethodTraceInject();
        com.bytedance.apm.v.g.b.a();
        com.bytedance.apm.v.a.b().f(r9.g());
        com.bytedance.apm.d.T(System.nanoTime() - r0);
        com.bytedance.apm.d.P(r9.p());
        com.bytedance.apm.d.j0(r9.C());
    L28:
        if (com.bytedance.apm.d.C() == false) goto L35;
        DoctorManager r13 = DoctorManager.getInstance();
        if (this.f1618k == false) goto L32;
        String r14 = "APM_INIT";
    L33:
        r13.b(r14, r9.toString());
        goto L35
    L32:
        r14 = "APM_INIT_OTHER_PROCESS";
    L35:
        if (com.bytedance.apm.x.a.c() == null) goto L37;
        com.bytedance.apm.x.a.c().b("apm_debug", "apm_init");
    L37:
        com.bytedance.apm.d.c0(true);
        com.bytedance.apm.d.Y(System.nanoTime() - r0);
        return;
    L38:
        r4.a();
        throw null;
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onReady() {
        boolean r0 = true;
        this.f1615h = true;
        com.bytedance.apm.w.b r1 = this.f1612e;
        if (r1 == null) goto L5;
        r1.onReady();
    L5:
        JSONObject r2 = this.f1614g.getConfig();
        if (this.f1618k == false) goto L14;
        new com.bytedance.apm.a0.h().d();
        if (com.bytedance.apm.util.h.e(r2, "performance_modules", "traffic", "enable_collect") != 1) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L14;
        com.bytedance.apm.a0.k.g.p().d();
        goto L14
    L10:
        r3 = false;
    L14:
        if (this.f1611d.E() == false) goto L40;
        if (com.bytedance.apm.util.h.e(r2, "performance_modules", "battery", "enable_upload") != 1) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == false) goto L21;
        com.bytedance.apm.q.e.b();
    L21:
        if (r5 == false) goto L23;
    L24:
        com.bytedance.apm.q.e.a(this.f1611d.y());
    L26:
        if (com.bytedance.apm.util.h.e(r2, "performance_modules", "battery", "power_monitor_enable") != 1) goto L28;
        boolean r6 = true;
    L29:
        if (r6 == false) goto L32;
        com.bytedance.apm.q.e.d();
    L32:
        if (com.bytedance.apm.util.h.e(r2, "performance_modules", "battery", "temperature_enable_upload") == 1) goto L35;
        r0 = false;
    L35:
        if (r0 == false) goto L37;
    L38:
        com.bytedance.apm.q.e.c(this.f1611d.D());
        goto L40
    L37:
        if (this.f1611d.D() == false) goto L40;
    L28:
        r6 = false;
        goto L29
    L23:
        if (this.f1611d.y() == false) goto L26;
    L18:
        r5 = false;
    L40:
        if (this.f1611d.z() == true) goto L42;
        return;
    L42:
        if (com.bytedance.apm.a0.c.a().d("block_monitor") == false) goto L46;
        q();
        return;
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onRefresh(JSONObject r2, boolean r3) {
        JSONObject r4 = r2.optJSONObject("general");
        if (r4 == null) goto L5;
        this.n = r4.optBoolean("enable_active_upload_alog", true);
        return;
    L5:
        this.n = true;
    }

    public void v(WidgetParams r2) {
        Set<IWidget> r1 = this.f1619l;
        if (r1 != null) goto L5;
        return;
    L5:
        Iterator<IWidget> r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        r3.next().notifyParams(r2);     // Catch: Throwable -> L12
        goto L7
    }

    public void w() {
        com.bytedance.apm.f0.b.f().i(new h(this));
        com.bytedance.apm.f0.b.f().o();
    }
}
