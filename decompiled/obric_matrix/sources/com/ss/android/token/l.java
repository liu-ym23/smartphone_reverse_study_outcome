package com.ss.android.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<String> f12242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f12243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f12244d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f12245e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f12246f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Context f12247g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f12248h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a f12249i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private g f12250j;

    public interface a {
        boolean a(String r1);
    }

    public l() {
        CopyOnWriteArraySet r0 = new CopyOnWriteArraySet();
        this.f12242b = r0;
        this.f12244d = new Object();
        this.f12246f = false;
        this.f12248h = 600000;
        String r1 = "https://" + com.ss.android.i.j.k().c();
        this.f12241a = r1;
        String r3 = w.f(r1);
        if (r3 == null) goto L6;
        r0.add(r3);
        return;
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    private SharedPreferences k() {
        if (this.f12247g != null) goto L5;
        this.f12247g = com.ss.android.i.j.j();
    L5:
        Context r2 = this.f12247g;
        if (r2 != null) goto L8;
        return null;
    L8:
        return a(r2, "com_ss_android_token_sp_host", 0);
    }

    private SharedPreferences l() {
        if (this.f12247g != null) goto L5;
        this.f12247g = com.ss.android.i.j.j();
    L5:
        Context r2 = this.f12247g;
        if (r2 != null) goto L8;
        return null;
    L8:
        return a(r2, "ss_app_config", 0);
    }

    private void q() {
        SharedPreferences r0 = k();
        if (r0 != null) goto L5;
        return;
    L5:
        if (p() == false) goto L9;
        r0.edit().putStringSet("share_cookie_host_list", this.f12242b).apply();
        return;
    }

    public void b() {
        SharedPreferences r0 = k();
        if (r0 == null) goto L8;
        Set<String> r1 = r0.getStringSet("share_cookie_host_list", null);
        if (r1 == null) goto L9;
        this.f12242b.addAll(r1);
        return;
    L9:
        return;
    }

    public void c() {
        SharedPreferences r0 = l();
        if (r0 == null) goto L25;
        String r1 = r0.getString("share_cookie_host_list", "");
        HashSet r2 = new HashSet();
        if (TextUtils.isEmpty(r1) == true) goto L20;
        String[] r3 = r1.split(",");
        if (r3.length <= 0) goto L20;
        int r4 = r3.length;
        int r5 = 0;
    L9:
        if (r5 >= r4) goto L20;
        String r6 = r3[r5];
        if (TextUtils.isEmpty(r6) == true) goto L19;
        if (r6.length() > 1) goto L16;
    L18:
        r2.add(r6);
        goto L19
    L16:
        if (r6.startsWith(".") == false) goto L18;
        r6 = r6.substring(1);
    L19:
        r5 = r5 + 1;
    L20:
        this.f12242b.addAll(r2);
        return;
    }

    public l d(Collection<String> r1) {
        f(r1);
        return this;
    }

    public void e() {
        b();
        c();
        q();
    }

    protected void f(Collection<String> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.size() <= 0) goto L18;
        this.f12246f = true;
        this.f12242b.addAll(r2);
        Object r3 = this.f12244d;
        monitor-enter(r3);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.f12243c == false) goto L10;
        q();     // Catch: Throwable -> L12
    L10:
        monitor-exit(r3);     // Catch: Throwable -> L12
        return;
    }

    public String g() {
        return this.f12241a;
    }

    protected a h() {
        return this.f12249i;
    }

    public Set<String> i() {
        if (this.f12243c == true) goto L16;
        Object r0 = this.f12244d;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.f12243c == true) goto L9;
        e();     // Catch: Throwable -> L12
    L9:
        this.f12243c = true;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
    L16:
        return this.f12242b;
    }

    protected g j() {
        return this.f12250j;
    }

    public String m() {
        return this.f12245e;
    }

    protected long n() {
        return this.f12248h;
    }

    public boolean o() {
        return this.f12246f;
    }

    public boolean p() {
        this.f12242b.remove(null);
        return !this.f12242b.isEmpty();
    }

    public l r(boolean r1) {
        return this;
    }

    public l s(long r1) {
        this.f12248h = r1;
        return this;
    }
}
