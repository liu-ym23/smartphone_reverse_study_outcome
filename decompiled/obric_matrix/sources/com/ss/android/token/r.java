package com.ss.android.token;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Collection;
import java.util.Set;
import kotlin.a0;
import kotlin.f0;
import kotlin.n0.d.e0;
import kotlin.n0.d.y;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ kotlin.s0.l[] f12299a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlin.h f12300b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final r f12301c = null;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private volatile String f12302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile Set<String> f12303b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Object f12304c;

        static {
        }

        public a(Context r2) {
            kotlin.n0.d.o.g(r2, "context");
            this.f12303b = s.a();
            this.f12304c = new Object();
            e(r2);
        }

        @Proxy("getSharedPreferences")
        @TargetClass(scope = Scope.SELF, value = "android.content.Context")
        public static SharedPreferences a(Context r0, String r1, int r2) {
            return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
        }

        private final void e(Context r4) {
            SharedPreferences r5 = a(r4, "token_temporary_settings", 0);
            kotlin.v.a r1 = kotlin.v.f21457g;     // Catch: Throwable -> L5
            Object r2 = r5.getString("config_version", null);     // Catch: Throwable -> L5
            kotlin.v.b(r2);     // Catch: Throwable -> L5
        L8:
            if (kotlin.v.f(r2) == false) goto L10;
            r2 = null;
        L10:
            this.f12302a = (String) r2;
            kotlin.v.a r3 = kotlin.v.f21457g;     // Catch: Throwable -> L16
            Set<String> r6 = r5.getStringSet("need_sign_paths", s.a());     // Catch: Throwable -> L16
            if (r6 == null) goto L14;
            Object r7 = kotlin.i0.r.C0(r6);     // Catch: Throwable -> L16
            kotlin.v.b(r7);     // Catch: Throwable -> L16
        L18:
            Set r0 = s.a();
            if (kotlin.v.f(r7) == false) goto L21;
            r7 = r0;
        L21:
            this.f12303b = (Set) r7;
            return;
        L14:
            kotlin.n0.d.o.p();     // Catch: Throwable -> L16
            throw null;
        L16:
            th = move-exception;
            kotlin.v.a r8 = kotlin.v.f21457g;
            r7 = kotlin.w.a(th);
            kotlin.v.b(r7);
        L5:
            th = move-exception;
            kotlin.v.a r9 = kotlin.v.f21457g;
            r2 = kotlin.w.a(th);
            kotlin.v.b(r2);
            goto L8
        }

        public final void b(Collection<String> r3) {
            kotlin.n0.d.o.g(r3, "paths");
            Object r0 = this.f12304c;
            monitor-enter(r0);
            this.f12303b.addAll(r3);     // Catch: Throwable -> L7
            g();     // Catch: Throwable -> L7
            f0 r2 = f0.f18324a;     // Catch: Throwable -> L7
            monitor-exit(r0);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public final String c() {
            return this.f12302a;
        }

        public final Set<String> d() {
            return this.f12303b;
        }

        public final void f(String r4) {
            kotlin.n0.d.o.g(r4, "latestConfigVersion");
            d.b.s.a.a0.a.d("TokenGuardTemporarySettings", "resetAllTemporarySettings, oldVersion: " + this.f12302a + ", newVersion: " + r4);
            Object r0 = this.f12304c;
            monitor-enter(r0);
            this.f12302a = r4;     // Catch: Throwable -> L7
            this.f12303b.clear();     // Catch: Throwable -> L7
            g();     // Catch: Throwable -> L7
            f0 r3 = f0.f18324a;     // Catch: Throwable -> L7
            monitor-exit(r0);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public final void g() {
            Context r0 = r.a(r.f12301c);
            if (r0 != null) goto L12;
            d.b.s.a.a0.a.b("TokenGuardTemporarySettings", "Context is null, unable to save temporary settings");
            return;
        L12:
            SharedPreferences.Editor r1 = a(r0, "token_temporary_settings", 0).edit();     // Catch: Exception -> L9
            r1.putString("config_version", this.f12302a);     // Catch: Exception -> L9
            r1.putStringSet("need_sign_paths", kotlin.i0.r.D0(d()));     // Catch: Exception -> L9
            r1.apply();     // Catch: Exception -> L9
            return;
        L9:
            e = move-exception;
            d.b.s.a.a0.a.c("TokenGuardTemporarySettings", "saveToStorage error", e);
        }
    }

    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.a<a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f12305f = null;

        static {
            f12305f = new b();
        }

        b() {
            super(0);
        }

        public final a a() {
            Context r1 = r.a(r.f12301c);
            if (r1 == null) goto L7;
            return new a(r1);
        L7:
            throw new IllegalStateException("Context is null. Cannot initialize Storage.");
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ a invoke() {
            return a();
        }
    }

    static {
        f12299a = new kotlin.s0.l[]{e0.g(new y(e0.b(r.class), "storage", "getStorage()Lcom/ss/android/token/TokenGuardTemporarySettings$Storage;"))};
        f12301c = new r();
        f12300b = kotlin.i.b(b.f12305f);
    }

    private r() {
    }

    public static final /* synthetic */ Context a(r r0) {
        return r0.d();
    }

    private final boolean c() {
        String r0 = com.bytedance.sdk.account.ticketguard.f.d();
        kotlin.n0.d.o.b(r0, "TokenGuardSettingManager.getConfigVersion()");
        if (e().c() != null) goto L5;
    L9:
        i(r0);
        return true;
    L5:
        if ((!kotlin.n0.d.o.a(r0, e().c())) == true) goto L9;
        return false;
    }

    private final Context d() {
        com.ss.android.d r0 = com.ss.android.i.j.l();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e();
    }

    private final a e() {
        kotlin.h r2 = f12300b;
        kotlin.s0.l r0 = f12299a[0];
        return (a) r2.getValue();
    }

    public final void b(Collection<String> r4) {
        kotlin.n0.d.o.g(r4, "paths");
        if (com.bytedance.sdk.account.ticketguard.f.r() == true) goto L10;
        return;
    L10:
        e().b(r4);     // Catch: IllegalStateException -> L7
        d.b.s.a.a0.a.d("TokenGuardTemporarySettings", "Paths added to temporary settings: " + r4 + ", config_version: " + e().c());     // Catch: IllegalStateException -> L7
        return;
    L7:
        e = move-exception;
        d.b.s.a.a0.a.c("TokenGuardTemporarySettings", "Context is null when adding paths", e);
    }

    public final boolean f(String r6) {
        kotlin.n0.d.o.g(r6, "path");
        if (com.bytedance.sdk.account.ticketguard.f.r() == true) goto L15;
        return false;
    L15:
    L12:
        e = move-exception;
        d.b.s.a.a0.a.c("TokenGuardTemporarySettings", "Context is null", e);
        return false;
    L6:
        if (c() == false) goto L8;
        return false;
    L8:
        boolean r1 = e().d().contains(r6);     // Catch: IllegalStateException -> L12
        if (r1 == false) goto L11;
        d.b.s.a.a0.a.d("TokenGuardTemporarySettings", "path is in temporary settings: " + r6 + ", config_version: " + e().c());     // Catch: IllegalStateException -> L12
    L11:
        return r1;
    }

    public final void g(String r2, String r3, String r4, boolean r5) {
        kotlin.n0.d.o.g(r2, "path");
        kotlin.n0.d.o.g(r3, "remoteError");
        kotlin.n0.d.o.g(r4, "logId");
        o.C("token_guard_update_fallback_config", s.b(new kotlin.u[]{a0.a("path", r2), a0.a("remote_error", r3), a0.a("logid", r4), a0.a("has_consumer_content", Integer.valueOf(r5 ? 1 : 0)), a0.a("token_config_version", com.bytedance.sdk.account.ticketguard.f.d())}));
    }

    public final void h(String r2, String r3, String r4, boolean r5) {
        kotlin.n0.d.o.g(r2, "path");
        kotlin.n0.d.o.g(r3, "remoteError");
        kotlin.n0.d.o.g(r4, "logId");
        o.C("token_guard_use_fallback_config_fail", s.b(new kotlin.u[]{a0.a("path", r2), a0.a("remote_error", r3), a0.a("logid", r4), a0.a("has_consumer_content", Integer.valueOf(r5 ? 1 : 0)), a0.a("token_config_version", com.bytedance.sdk.account.ticketguard.f.d())}));
    }

    public final void i(String r2) {
        kotlin.n0.d.o.g(r2, "latestConfigVersion");
        e().f(r2);
    }
}
