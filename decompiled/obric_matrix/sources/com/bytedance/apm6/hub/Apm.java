package com.bytedance.apm6.hub;

import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.services.apm.api.IActivityLifeManager;
import com.bytedance.services.apm.api.IEncrypt;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.IMonitorLogManager;
import com.bytedance.services.apm.api.IZstdCompress;
import com.bytedance.services.apm.api.IZstdDict;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Apm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f2142a = false;

    static class a implements d.b.b.n.a<d.b.b.n.h.b> {
        a() {
        }

        public d.b.b.n.h.b a() {
            return d.b.b.m.a.c.a();
        }

        @Override // d.b.b.n.a
        public /* bridge */ /* synthetic */ d.b.b.n.h.b create() {
            return a();
        }
    }

    static class b implements d.b.b.n.a<IZstdCompress> {
        b() {
        }

        public IZstdCompress a() {
            return new com.bytedance.apm.l();
        }

        @Override // d.b.b.n.a
        public /* bridge */ /* synthetic */ IZstdCompress create() {
            return a();
        }
    }

    static class c implements d.b.b.n.a<IZstdDict> {
        c() {
        }

        public IZstdDict a() {
            return new com.bytedance.apm.m();
        }

        @Override // d.b.b.n.a
        public /* bridge */ /* synthetic */ IZstdDict create() {
            return a();
        }
    }

    static class d implements d.b.b.n.a<d.b.b.k.f.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bytedance.apm6.hub.a f2143a;

        d(com.bytedance.apm6.hub.a r1) {
            this.f2143a = r1;
        }

        public d.b.b.k.f.b a() {
            return this.f2143a.q();
        }

        @Override // d.b.b.n.a
        public /* bridge */ /* synthetic */ d.b.b.k.f.b create() {
            return a();
        }
    }

    static class e implements d.b.b.n.a<d.b.b.j.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bytedance.apm6.hub.a f2144a;

        e(com.bytedance.apm6.hub.a r1) {
            this.f2144a = r1;
        }

        public d.b.b.j.c a() {
            return this.f2144a.o();
        }

        @Override // d.b.b.n.a
        public /* bridge */ /* synthetic */ d.b.b.j.c create() {
            return a();
        }
    }

    static class f implements d.b.b.n.a<d.b.b.k.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bytedance.apm6.hub.a f2145a;

        f(com.bytedance.apm6.hub.a r1) {
            this.f2145a = r1;
        }

        public d.b.b.k.a a() {
            return this.f2145a.p();
        }

        @Override // d.b.b.n.a
        public /* bridge */ /* synthetic */ d.b.b.k.a create() {
            return a();
        }
    }

    static class g implements d.b.b.n.a<d.b.b.n.d.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bytedance.apm6.hub.a f2146a;

        g(com.bytedance.apm6.hub.a r1) {
            this.f2146a = r1;
        }

        public d.b.b.n.d.a a() {
            return this.f2146a.j();
        }

        @Override // d.b.b.n.a
        public /* bridge */ /* synthetic */ d.b.b.n.d.a create() {
            return a();
        }
    }

    static class h implements d.b.b.n.a<d.b.b.g.d.b> {
        h() {
        }

        public d.b.b.g.d.b a() {
            return new com.bytedance.apm6.hub.b.c();
        }

        @Override // d.b.b.n.a
        public /* bridge */ /* synthetic */ d.b.b.g.d.b create() {
            return a();
        }
    }

    static class i implements d.b.b.n.a<d.b.b.n.h.a> {
        i() {
        }

        public d.b.b.n.h.a a() {
            return d.b.b.f.f.a.c();
        }

        @Override // d.b.b.n.a
        public /* bridge */ /* synthetic */ d.b.b.n.h.a create() {
            return a();
        }
    }

    static class j implements d.b.b.n.a<d.b.b.e.a.g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bytedance.apm6.hub.a f2147a;

        j(com.bytedance.apm6.hub.a r1) {
            this.f2147a = r1;
        }

        public d.b.b.e.a.g a() {
            return this.f2147a.s();
        }

        @Override // d.b.b.n.a
        public /* bridge */ /* synthetic */ d.b.b.e.a.g create() {
            return a();
        }
    }

    static class k implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.bytedance.apm6.hub.a f2148f;

        k(com.bytedance.apm6.hub.a r1) {
            this.f2148f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            Apm.a(this.f2148f);
        }
    }

    static class l implements d.b.b.n.a<d.b.b.h.c.b> {
        l() {
        }

        public d.b.b.h.c.b a() {
            return new com.bytedance.apm6.hub.b.d();
        }

        @Override // d.b.b.n.a
        public /* bridge */ /* synthetic */ d.b.b.h.c.b create() {
            return a();
        }
    }

    static class m implements com.bytedance.news.common.service.manager.a<IActivityLifeManager> {
        m() {
        }

        public IActivityLifeManager a() {
            return ActivityLifeObserver.getInstance();
        }

        @Override // com.bytedance.news.common.service.manager.a
        public /* bridge */ /* synthetic */ IActivityLifeManager create() {
            return a();
        }
    }

    static class n extends d.b.b.o.o.a {
        n(long r1) {
            super(r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.b.l.a.e(d.b.b.e.a.e.d());
            d.b.b.k.b.h().i();
            d.b.b.j.a.b().c();
            if (d.b.b.i.c.a.A() == false) goto L5;
            d.b.b.g.a.d().e();
        L5:
            d.b.b.f.c.b.e().f();
            com.bytedance.apm.h.a().b();
            if (d.b.b.i.c.a.A() == false) goto L9;
            com.bytedance.apm.v.d.h();
            com.bytedance.apm.d.L(com.bytedance.apm.g0.c.e());
        L9:
            if (d.b.b.i.c.a.A() == false) goto L12;
            d.b.b.h.a.i().j();
            return;
        }
    }

    static class o implements d.b.b.e.a.l.b {
        o() {
        }

        @Override // d.b.b.e.a.l.b
        public void a(List<d.b.b.e.a.l.a> r6) {
            if (d.b.b.o.f.b(r6) == false) goto L5;
            return;
        L5:
            JSONObject r5 = new JSONObject();
            JSONObject r0 = new JSONObject();
            Iterator<d.b.b.e.a.l.a> r7 = r6.iterator();
        L7:
            if (r7.hasNext() == false) goto L13;
            d.b.b.e.a.l.a r1 = r7.next();
            r0.put("before_size_" + r1.c(), r1.b());     // Catch: Exception -> L15
            r0.put("after_size_" + r1.c(), r1.a());     // Catch: Exception -> L15
            r5.put("strategy", r1.c());     // Catch: Exception -> L15
            if (r1.d() == false) goto L7;
            r5.put("reach_top_today", r1.d());     // Catch: Exception -> L15
            goto L7
        L13:
            d.b.b.d.a.h("apm_db_size", r5, r0, null);
        }
    }

    static class p implements d.b.b.n.a<IHttpService> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bytedance.apm6.hub.a f2149a;

        p(com.bytedance.apm6.hub.a r1) {
            this.f2149a = r1;
        }

        public IHttpService a() {
            return this.f2149a.n();
        }

        @Override // d.b.b.n.a
        public /* bridge */ /* synthetic */ IHttpService create() {
            return a();
        }
    }

    static class q implements d.b.b.n.a<d.b.b.e.a.h.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bytedance.apm6.hub.a f2150a;

        q(com.bytedance.apm6.hub.a r1) {
            this.f2150a = r1;
        }

        public d.b.b.e.a.h.b a() {
            return this.f2150a.r();
        }

        @Override // d.b.b.n.a
        public /* bridge */ /* synthetic */ d.b.b.e.a.h.b create() {
            return a();
        }
    }

    static class r implements d.b.b.n.a<d.b.b.d.b.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bytedance.apm6.hub.a f2151a;

        r(com.bytedance.apm6.hub.a r1) {
            this.f2151a = r1;
        }

        public d.b.b.d.b.b a() {
            return this.f2151a.h();
        }

        @Override // d.b.b.n.a
        public /* bridge */ /* synthetic */ d.b.b.d.b.b create() {
            return a();
        }
    }

    static class s implements d.b.b.n.a<d.b.b.f.d.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bytedance.apm6.hub.a f2152a;

        s(com.bytedance.apm6.hub.a r1) {
            this.f2152a = r1;
        }

        public d.b.b.f.d.b a() {
            return this.f2152a.i();
        }

        @Override // d.b.b.n.a
        public /* bridge */ /* synthetic */ d.b.b.f.d.b create() {
            return a();
        }
    }

    static class t implements d.b.b.n.a<com.bytedance.apm.config.f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bytedance.apm6.hub.a f2153a;

        t(com.bytedance.apm6.hub.a r1) {
            this.f2153a = r1;
        }

        public com.bytedance.apm.config.f a() {
            return this.f2153a.m();
        }

        @Override // d.b.b.n.a
        public /* bridge */ /* synthetic */ com.bytedance.apm.config.f create() {
            return a();
        }
    }

    static class u implements d.b.b.n.a<d.b.b.n.g.a> {
        u() {
        }

        public d.b.b.n.g.a a() {
            return new d.b.b.i.a();
        }

        @Override // d.b.b.n.a
        public /* bridge */ /* synthetic */ d.b.b.n.g.a create() {
            return a();
        }
    }

    static class v implements d.b.b.n.a<IEncrypt> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bytedance.apm6.hub.a f2154a;

        v(com.bytedance.apm6.hub.a r1) {
            this.f2154a = r1;
        }

        public IEncrypt a() {
            return this.f2154a.l();
        }

        @Override // d.b.b.n.a
        public /* bridge */ /* synthetic */ IEncrypt create() {
            return a();
        }
    }

    static class w implements d.b.b.n.a<d.b.b.n.e.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bytedance.apm6.hub.a f2155a;

        w(com.bytedance.apm6.hub.a r1) {
            this.f2155a = r1;
        }

        public d.b.b.n.e.a a() {
            return this.f2155a.k();
        }

        @Override // d.b.b.n.a
        public /* bridge */ /* synthetic */ d.b.b.n.e.a create() {
            return a();
        }
    }

    static {
    }

    static /* synthetic */ void a(com.bytedance.apm6.hub.a r0) {
        e(r0);
    }

    private static void b() {
        d.b.b.e.a.l.c.g().i(new o());
    }

    public static synchronized Runnable c(com.bytedance.apm6.hub.a r2) {
        monitor-enter(Apm.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f2142a == false) goto L10;
        monitor-exit(Apm.class);
        return null;
    L10:
        f2142a = true;     // Catch: Throwable -> L13
        d(r2);     // Catch: Throwable -> L13
        k r1 = new k(r2);     // Catch: Throwable -> L13
        monitor-exit(Apm.class);
        return r1;
    }

    private static void d(com.bytedance.apm6.hub.a r2) {
        d.b.b.i.c.a.B(r2);
        d.b.b.i.c.a.F(System.currentTimeMillis());
        d.b.b.i.c.a.D(System.currentTimeMillis());
        if (d.b.b.o.a.c() == false) goto L5;
        d.b.b.o.m.b.a("APM-Hub", "APM init start in process " + r2.f());
    L5:
        d.b.b.o.m.b.e(new d.b.b.i.d.c());
        d.b.b.n.c.d(d.b.b.n.g.a.class, new d.b.b.i.a());
    }

    private static void e(com.bytedance.apm6.hub.a r4) {
        d.b.b.n.c.c(IHttpService.class, new p(r4));
        d.b.b.n.c.c(d.b.b.e.a.h.b.class, new q(r4));
        d.b.b.n.c.c(d.b.b.d.b.b.class, new r(r4));
        d.b.b.n.c.c(d.b.b.f.d.b.class, new s(r4));
        d.b.b.n.c.c(com.bytedance.apm.config.f.class, new t(r4));
        d.b.b.n.c.c(d.b.b.n.g.a.class, new u());
        d.b.b.n.c.c(IEncrypt.class, new v(r4));
        d.b.b.n.c.c(d.b.b.n.e.a.class, new w(r4));
        d.b.b.n.c.c(d.b.b.n.h.b.class, new a());
        d.b.b.n.c.c(IZstdCompress.class, new b());
        d.b.b.n.c.c(IZstdDict.class, new c());
        new d.b.b.i.a();
        d.b.b.n.c.c(d.b.b.k.f.b.class, new d(r4));
        d.b.b.n.c.c(d.b.b.j.c.class, new e(r4));
        d.b.b.n.c.c(d.b.b.k.a.class, new f(r4));
        d.b.b.n.c.c(d.b.b.n.d.a.class, new g(r4));
        d.b.b.n.c.c(d.b.b.g.d.b.class, new h());
        d.b.b.n.c.c(d.b.b.n.h.a.class, new i());
        d.b.b.n.c.c(d.b.b.e.a.g.class, new j(r4));
        d.b.b.n.c.c(d.b.b.h.c.b.class, new l());
        com.bytedance.news.common.service.manager.d.c(IActivityLifeManager.class, new m());
        com.bytedance.news.common.service.manager.d.c(IMonitorLogManager.class, new AnonymousClass22());
        com.bytedance.apm6.hub.b.i.a.g().h();
        d.b.b.o.o.b.a(d.b.b.o.o.c.f13067g).c(new n(r4.t()));
        b();
    }
}
