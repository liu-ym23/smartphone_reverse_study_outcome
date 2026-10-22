package com.bytedance.android.sdk.bdticketguard.o1;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.android.sdk.bdticketguard.o1.c;
import com.bytedance.android.sdk.bdticketguard.s0;
import com.bytedance.android.sdk.bdticketguard.z0;
import kotlin.n0.d.o;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<K extends c, PubInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private K f927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SharedPreferences f928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f930d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f931e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f932f;

    public a(Context r3, String r4) {
        o.g(r3, "context");
        o.g(r4, "keystoreAlias");
        this.f931e = r3;
        this.f932f = r4;
        SharedPreferences r5 = a(r3, "sp_TicketGuardHelper", 0);
        o.b(r5, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        this.f928b = r5;
        String r6 = g() + '_' + r4;
        this.f929c = r6;
        this.f930d = r5.getString(r6, "");
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    private final void p() {
        this.f930d += ",timestamp=" + System.currentTimeMillis();
        this.f928b.edit().putString(this.f929c, this.f930d).apply();
    }

    public abstract boolean b();

    public abstract boolean c();

    public abstract K d(String r1);

    public final Context e() {
        return this.f931e;
    }

    public final String f() {
        return this.f930d;
    }

    protected abstract String g();

    public final K h() {
        return this.f927a;
    }

    public final String i() {
        return this.f932f;
    }

    protected final SharedPreferences j() {
        return this.f928b;
    }

    protected final String k() {
        return l() + "_" + this.f932f;
    }

    public abstract String l();

    protected final String m() {
        return n() + "_" + this.f932f;
    }

    public abstract String n();

    public abstract K o(String r1);

    public final boolean q(String r9) {
        o.g(r9, "scene");
        K r0 = this.f927a;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        monitor-enter(this);
        K r2 = this.f927a;     // Catch: Throwable -> L47
        if (r2 == null) goto L15;
        if (r2.b() != true) goto L15;
        monitor-exit(this);
        return true;
    L15:
        if (this.f927a == null) goto L51;
        boolean r10 = b();     // Catch: Throwable -> L47
        monitor-exit(this);
        return r10;
    L51:
        boolean r3 = c();     // Catch: Throwable -> L43
        boolean r4 = this.f928b.getBoolean("has_gen_key", false);     // Catch: Throwable -> L43
        if (r3 == true) goto L24;
        if (r4 == false) goto L24;
        z0.i();     // Catch: Throwable -> L43
    L24:
        s0.f1065a.e("AbsKeyHelper", "containsAlias: " + r3 + ", spContainsAlias: " + r4);     // Catch: Throwable -> L43
        if (r3 == false) goto L27;
        c r5 = (K) o(r9);
    L28:
        if (r5 == null) goto L34;
        if (r4 == true) goto L32;
        this.f928b.edit().putBoolean("has_gen_key", true).apply();     // Catch: Throwable -> L43
    L32:
        if (r5.a() == false) goto L35;
        p();     // Catch: Throwable -> L43
    L35:
        this.f927a = (K) r5;     // Catch: Throwable -> L43
        if (r5 != null) goto L38;
    L40:
        r1 = false;
    L41:
        monitor-exit(this);     // Catch: Throwable -> L43
        return r1;
    L38:
        if (r5.b() != true) goto L40;
    L34:
        r5 = (K) null;
        goto L35
    L27:
        r5 = d(r9);     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        s0.f1065a.c("AbsKeyHelper", "containsAlias failed", th);     // Catch: Throwable -> L47
        z0.h(r9, th);     // Catch: Throwable -> L47
        return false;
    L47:
        th = move-exception;
        throw th;
    L5:
        if (r0.b() != true) goto L7;
        return true;
    }
}
