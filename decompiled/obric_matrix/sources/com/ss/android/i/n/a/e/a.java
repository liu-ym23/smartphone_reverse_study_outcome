package com.ss.android.i.n.a.e;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.f0;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f11930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0308a f11931d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f11933b;

    /* JADX INFO: renamed from: com.ss.android.i.n.a.e.a$a, reason: collision with other inner class name */
    public static final class C0308a {
        private C0308a() {
        }

        public /* synthetic */ C0308a(g r1) {
            this();
        }

        public final a a(Context r3) {
            o.g(r3, "context");
            if (a.b() == null) goto L5;
        L15:
            a r2 = a.b();
            if (r2 == null) goto L18;
            return r2;
        L18:
            o.p();
            throw null;
        L5:
            monitor-enter(a.class);
        L12:
            th = move-exception;
            throw th;
        L7:
            if (a.b() != null) goto L9;
            Context r4 = r3.getApplicationContext();     // Catch: Throwable -> L12
            o.b(r4, "context.applicationContext");     // Catch: Throwable -> L12
            a.c(new a(r4));     // Catch: Throwable -> L12
        L9:
            f0 r5 = f0.f18324a;     // Catch: Throwable -> L12
            monitor-exit(a.class);
            goto L15
        }
    }

    static {
        f11931d = new C0308a(null);
    }

    public a(Context r2) {
        o.g(r2, "context");
        this.f11933b = r2;
        this.f11932a = "account_sec_share_data";
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    public static final /* synthetic */ a b() {
        return f11930c;
    }

    public static final /* synthetic */ void c(a r0) {
        f11930c = r0;
    }

    public final String d(String r2) {
        o.g(r2, "key");
        return e().getString(r2, "");
    }

    public final SharedPreferences e() {
        SharedPreferences r2 = a(this.f11933b, this.f11932a, 0);
        o.b(r2, "context.getSharedPrefere…me, Context.MODE_PRIVATE)");
        return r2;
    }

    public final SharedPreferences.Editor f() {
        SharedPreferences.Editor r2 = a(this.f11933b, this.f11932a, 0).edit();
        o.b(r2, "context.getSharedPrefere…text.MODE_PRIVATE).edit()");
        return r2;
    }

    public final void g(String r2, String r3) {
        o.g(r2, "key");
        o.g(r3, "value");
        f().putString(r2, r3).apply();
    }
}
