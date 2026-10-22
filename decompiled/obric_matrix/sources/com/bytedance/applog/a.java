package com.bytedance.applog;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.applog.util.n;
import com.bytedance.applog.util.p;
import com.bytedance.bdinstall.d0;
import com.bytedance.bdinstall.h0;
import com.bytedance.bdinstall.m0;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile com.bytedance.applog.q.b f2198a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile com.bytedance.applog.q.c f2199b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f2200c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f2201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile com.bytedance.applog.collector.a f2202e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static g f2203f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Application f2204g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static com.bytedance.applog.o.e f2205h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile com.bytedance.applog.p.a f2206i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final com.bytedance.applog.n.c f2207j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile d f2208k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile boolean f2209l;
    private static volatile IBDAccountCallback m;
    private static volatile boolean n;
    private static volatile boolean o;
    private static volatile boolean p;
    private static volatile boolean q;
    private static volatile boolean r;
    private static volatile Integer s;
    private static volatile i t;
    private static volatile boolean u;

    static {
        f2207j = new com.bytedance.applog.n.a();
        f2209l = false;
        n = false;
        o = true;
        p = false;
        q = false;
        r = false;
        u = false;
    }

    private a() {
        n.i(null);
    }

    public static boolean A() {
        return o;
    }

    public static boolean B() {
        return r;
    }

    public static boolean C() {
        return q;
    }

    public static boolean D() {
        return n;
    }

    public static void E(@NonNull String r4, @Nullable Bundle r5) {
        com.bytedance.applog.o.b.d(com.bytedance.applog.r.b.a.f2332h, com.bytedance.applog.r.b.d.f2346g);
        JSONObject r0 = null;
        if (r5 != null) goto L21;
    L17:
        G(r4, r0);
        return;
    L21:
    L15:
        th = th;
    L16:
        com.bytedance.applog.o.b.d(com.bytedance.applog.r.b.a.f2332h, com.bytedance.applog.r.b.d.f2347h);
        n.i(th);
        goto L17
    L5:
        if (r5.isEmpty() == true) goto L17;
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L15
        Iterator<String> r2 = r5.keySet().iterator();     // Catch: Throwable -> L13
    L9:
        if (r2.hasNext() == false) goto L12;
        String r3 = r2.next();     // Catch: Throwable -> L13
        r1.put(r3, r5.get(r3));     // Catch: Throwable -> L13
        goto L9
    L12:
        r0 = r1;
    L13:
        th = th;
        r0 = r1;
        goto L16
    }

    public static void F(@NonNull String r2, @Nullable JSONObject r3) {
        com.bytedance.applog.o.b.d(com.bytedance.applog.r.b.a.f2332h, com.bytedance.applog.r.b.d.f2346g);
        G(r2, r3);
    }

    private static void G(@NonNull String r3, @Nullable JSONObject r4) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        com.bytedance.applog.o.b.d(com.bytedance.applog.r.b.a.f2332h, com.bytedance.applog.r.b.d.f2347h);
        n.c("event name is empty", null);
        return;
    L6:
        com.bytedance.applog.o.e.F(new com.bytedance.applog.w.e(r3, false, K(r3, null, r4)));
    }

    public static void H(e r1) {
        com.bytedance.applog.util.a.g().h(r1);
    }

    public static void I(@NonNull i r0) {
        t = r0;
    }

    public static void J(boolean r0, String r1) {
    }

    private static String K(String r4, String r5, JSONObject r6) {
        JSONObject r7 = p.d(r6);
        if (r7 == null) goto L30;
        l r1 = s();
        if (r1 != null) goto L7;
    L9:
        boolean r2 = false;
    L32:
    L35:
        return r7.toString();
    L18:
        e = e;
        String r3 = "event toString OOM tag: ";
        if (r2 == true) goto L24;
        StringBuilder r8 = new StringBuilder();
    L22:
        r8.append(r3);
        r8.append(r4);
        r8.append(", label: ");
        r8.append(r5);
        n.c(r8.toString(), e);
        goto L30
    L24:
        throw new RuntimeException("event toString OOM tag: " + r4 + ", label: " + r5, e);
    L12:
        e = e;
        r3 = "event toString stack overflow tag: ";
        if (r2 == true) goto L17;
        r8 = new StringBuilder();
        goto L22
    L17:
        throw new RuntimeException("event toString stack overflow tag: " + r4 + ", label: " + r5, e);
    L25:
        return r7.toString();
    L27:
        th = move-exception;
        throw new RuntimeException("event params exception tag: " + r4 + ", label: " + r5, th);
    L7:
        if ("local_test".equalsIgnoreCase(r1.i()) == false) goto L9;
        r2 = true;
    L30:
        return null;
    }

    public static void a(e r1) {
        com.bytedance.applog.util.a.g().f(r1);
    }

    public static String b(Context r1, String r2, boolean r3, m0 r4) {
        return c(r1, new StringBuilder(r2), r3, r4);
    }

    public static String c(Context r0, StringBuilder r1, boolean r2, m0 r3) {
        return com.bytedance.bdinstall.i.d(r0, r1, r2, r3);
    }

    public static void d() {
        com.bytedance.applog.o.e r0 = f2205h;
        if (r0 == null) goto L6;
        r0.E(null, true);
        return;
    }

    public static String e() {
        long r0 = com.bytedance.applog.o.h.n;
        IBDAccountCallback r2 = i();
        if (r2 == null) goto L6;
        r0 = ((Long) r2.getOdinUserInfo().second).longValue();
    L6:
        return f(String.valueOf(r0));
    }

    public static String f(String r1) {
        d r0 = f2208k;
        if (r0 == null) goto L7;
        return r0.a(r1);
    L7:
        if (f2199b != null) goto L9;
        return null;
    L9:
        return f2199b.b();
    }

    public static boolean g() {
        return p;
    }

    public static String h() {
        if (f2198a != null) goto L5;
        return "";
    L5:
        return f2198a.h();
    }

    public static IBDAccountCallback i() {
        return m;
    }

    public static Context j() {
        return f2204g;
    }

    public static String k() {
        return f2207j.getDid();
    }

    public static Integer l() {
        return s;
    }

    public static boolean m() {
        return f2209l;
    }

    public static boolean n() {
        return f2200c;
    }

    public static com.bytedance.applog.p.a o() {
        return f2206i;
    }

    @Nullable
    public static JSONObject p() {
        if (f2199b != null) goto L7;
        n.i(new RuntimeException("init come first"));
        return null;
    L7:
        return f2199b.d();
    }

    public static g q() {
        return f2203f;
    }

    public static String r() {
        h0 r0 = f2207j.a();
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0.d();
    }

    public static l s() {
        if (f2198a != null) goto L7;
        return null;
    L7:
        return f2198a.t();
    }

    public static i t() {
        return t;
    }

    public static d0 u() {
        return f2198a.t().r();
    }

    public static String v() {
        h0 r0 = f2207j.a();
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0.f();
    }

    public static String w() {
        if (f2199b != null) goto L5;
        return "";
    L5:
        return f2199b.h();
    }

    public static void x(@NonNull Context r8, @NonNull l r9) {
        monitor-enter(a.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (f2204g != null) goto L10;
        n.g(r8, r9.p());     // Catch: Throwable -> L12
        n.e("Inited Begin");     // Catch: Throwable -> L12
        Application r1 = (Application) r8.getApplicationContext();     // Catch: Throwable -> L12
        f2204g = r1;     // Catch: Throwable -> L12
        f2198a = new com.bytedance.applog.q.b(r1, r9);     // Catch: Throwable -> L12
        y(r8);     // Catch: Throwable -> L12
        com.bytedance.applog.q.b r2 = f2198a;     // Catch: Throwable -> L12
        com.bytedance.applog.n.c r6 = f2207j;     // Catch: Throwable -> L12
        f2199b = new com.bytedance.applog.q.c(r2, r6);     // Catch: Throwable -> L12
        f2205h = new com.bytedance.applog.o.e(f2204g, f2198a, f2199b, r6, r9.h());     // Catch: Throwable -> L12
        f2202e = new com.bytedance.applog.collector.a(r9.s());     // Catch: Throwable -> L12
        if (r9.N() == false) goto L9;
        f2204g.registerActivityLifecycleCallbacks(f2202e);     // Catch: Throwable -> L12
    L9:
        f2201d = 1;     // Catch: Throwable -> L12
        r9.a();     // Catch: Throwable -> L12
        n.e("Inited End");     // Catch: Throwable -> L12
    L10:
        monitor-exit(a.class);     // Catch: Throwable -> L12
    }

    private static void y(Context r2) {
        if (t() == null) goto L5;
        return;
    L5:
        if (p.i("com.bytedance.applog.compress.CompressManager") == false) goto L9;
        I(new com.bytedance.applog.util.d(r2, f2198a));
        return;
    }

    public static boolean z() {
        return u;
    }
}
