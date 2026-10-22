package com.obric.matrix.q.h;

import h.a.b1;
import h.a.m0;
import h.a.q1;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.p;
import kotlin.n0.d.o;
import kotlin.w;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\rR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/matrix/base/system/BaseInstalledPkgMgr;", "", "()V", "installedThirdXrPkgMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/matrix/base/system/ThirdXrPkgInfo;", "init", "", "onInstallApp", "packageName", "onInstallApp$internal_cnRelease", "onUninstallApp", "onUninstallApp$internal_cnRelease", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f9869a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, l> f9870b = null;

    @kotlin.k0.j.a.f(c = "com.obric.matrix.base.system.BaseInstalledPkgMgr$onInstallApp$1", f = "BaseInstalledPkgMgr.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends kotlin.k0.j.a.l implements p<m0, kotlin.k0.d<? super f0>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f9871f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f9872g;

        a(String r1, kotlin.k0.d<? super a> r2) {
            this.f9872g = r1;
            super(2, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final kotlin.k0.d<f0> create(Object r1, kotlin.k0.d<?> r2) {
            return new a(this.f9872g, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(m0 r1, kotlin.k0.d<? super f0> r2) {
            return ((a) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(m0 r1, kotlin.k0.d<? super f0> r2) {
            return invoke2(r1, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r9) {
            kotlin.k0.i.b.c();
            if (this.f9871f != 0) goto L12;
            w.b(r9);
            String r3 = this.f9872g;     // Catch: Exception -> L7
            com.obric.matrix.r.e.b r1 = com.obric.matrix.r.e.b.f9938a;     // Catch: Exception -> L7
            String r4 = String.valueOf(r1.b(com.bytedance.mpaas.app.a.f5245g, r3));     // Catch: Exception -> L7
            String r5 = com.obric.matrix.r.e.k.e(com.bytedance.mpaas.app.a.f5245g, this.f9872g);     // Catch: Exception -> L7
            o.e(r5, "getSignPublicKeySHA256(L…Application, packageName)");     // Catch: Exception -> L7
            l r10 = new l(r3, r4, r5, r1.c(this.f9872g), r1.a(this.f9872g));     // Catch: Exception -> L7
            String r8 = this.f9872g;     // Catch: Exception -> L7
            com.obric.matrix.r.c.c.b("BaseInstalledPkgMgr", "onInstallApp() with ThirdXrPkgInfo = " + r10);     // Catch: Exception -> L7
            b.a().put(r8, r10);     // Catch: Exception -> L7
        L10:
            return f0.f18324a;
        L7:
            e = move-exception;
            com.obric.matrix.r.c.c.g("BaseInstalledPkgMgr", "onInstallApp Exception", e);
            goto L10
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.matrix.q.h.b$b, reason: collision with other inner class name */
    @kotlin.k0.j.a.f(c = "com.obric.matrix.base.system.BaseInstalledPkgMgr$onUninstallApp$1", f = "BaseInstalledPkgMgr.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class C0280b extends kotlin.k0.j.a.l implements p<m0, kotlin.k0.d<? super f0>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f9873f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f9874g;

        C0280b(String r1, kotlin.k0.d<? super C0280b> r2) {
            this.f9874g = r1;
            super(2, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final kotlin.k0.d<f0> create(Object r1, kotlin.k0.d<?> r2) {
            return new C0280b(this.f9874g, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(m0 r1, kotlin.k0.d<? super f0> r2) {
            return ((C0280b) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(m0 r1, kotlin.k0.d<? super f0> r2) {
            return invoke2(r1, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r2) {
            kotlin.k0.i.b.c();
            if (this.f9873f != 0) goto L7;
            w.b(r2);
            b.a().remove(this.f9874g);
            return f0.f18324a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f9869a = new b();
        f9870b = new ConcurrentHashMap();
    }

    private b() {
    }

    public static final /* synthetic */ ConcurrentHashMap a() {
        return f9870b;
    }

    public final void b() {
        h.f9880a.a("BaseInstalledPkgMgr", new c());
    }

    public final void c(String r7) {
        o.f(r7, "packageName");
        com.obric.matrix.r.c.c.b("BaseInstalledPkgMgr", "onInstallApp() called with: packageName = " + r7);
        if (r7.length() != 0) goto L5;
        boolean r6 = true;
    L6:
        if (r6 == false) goto L8;
        return;
    L8:
        h.a.h.b(q1.f17560f, b1.b(), null, new a(r7, null), 2, null);
        return;
    L5:
        r6 = false;
        goto L6
    }

    public final void d(String r7) {
        o.f(r7, "packageName");
        com.obric.matrix.r.c.c.b("BaseInstalledPkgMgr", "onUninstallApp() called with: packageName = " + r7);
        if (r7.length() != 0) goto L5;
        boolean r6 = true;
    L6:
        if (r6 == false) goto L8;
        return;
    L8:
        h.a.h.b(q1.f17560f, b1.b(), null, new C0280b(r7, null), 2, null);
        return;
    L5:
        r6 = false;
        goto L6
    }
}
