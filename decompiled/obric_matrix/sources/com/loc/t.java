package com.loc;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.RejectedExecutionException;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7780a = "/a/";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final String f7781b = "b";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final String f7782c = "c";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final String f7783d = "d";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f7784e = "e";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f7785f = "f";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f7786g = "k";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static long f7787h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Vector<t5> f7788i;

    final class a extends s1 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Context f7789g;

        a(Context r1) {
            this.f7789g = r1;
        }

        @Override // com.loc.s1
        public final void b() {
            w.k(this.f7789g);     // Catch: Throwable -> L4 RejectedExecutionException -> L7
            w.m(this.f7789g);     // Catch: Throwable -> L4 RejectedExecutionException -> L7
            w.l(this.f7789g);     // Catch: Throwable -> L4 RejectedExecutionException -> L7
            a1.b(this.f7789g);     // Catch: Throwable -> L4 RejectedExecutionException -> L7
            y0.c(this.f7789g);     // Catch: Throwable -> L4 RejectedExecutionException -> L7
            return;
        L4:
            th = move-exception;
            v.m(th, "Lg", "proL");
            return;
        }
    }

    static {
        f7788i = new Vector();
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    public static String b(Context r2, String r3) {
        return a(r2, "AMSKLG_CFG", 0).getString(r3, "");
    }

    static List<t5> c() {
        Looper r0 = Looper.getMainLooper();     // Catch: Throwable -> L10
        monitor-enter(r0);     // Catch: Throwable -> L10
        Vector<t5> r1 = f7788i;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();
        return f7788i;
    }

    public static void d(Context r4) {
    L7:
        th = move-exception;
        v.m(th, "Lg", "proL");
        return;
    L3:
        if ((System.currentTimeMillis() - f7787h) >= 60000) goto L5;
        return;
    L5:
        f7787h = System.currentTimeMillis();     // Catch: Throwable -> L7
        r1.f().d(new a(r4));     // Catch: Throwable -> L7
    }

    @TargetApi(9)
    public static void e(Context r2, String r3, String r4) {
        SharedPreferences.Editor r5 = a(r2, "AMSKLG_CFG", 0).edit();
        r5.putString(r3, r4);
        r5.apply();
    }

    public static void f(t5 r2) {
        Looper r0 = Looper.getMainLooper();     // Catch: Throwable -> L17
        monitor-enter(r0);     // Catch: Throwable -> L17
        if (r2 != null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L8:
        if (f7788i.contains(r2) == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L11:
        f7788i.add(r2);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    }

    static boolean g(String[] r6, String r7) {
        if (r6 == null) goto L28;
        if (r7 == null) goto L28;
        String[] r8 = r7.split("\n");     // Catch: Throwable -> L26
        int r1 = r8.length;     // Catch: Throwable -> L26
        int r2 = 0;
    L7:
        boolean r3 = true;
        if (r2 >= r1) goto L20;
        String r4 = r8[r2].trim();     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r4) == false) goto L12;
    L16:
        r3 = false;
    L17:
        if (r3 == true) goto L18;
        r2 = r2 + 1;     // Catch: Throwable -> L26
        goto L7
    L18:
        return false;
    L12:
        if (r4.startsWith("at ") == false) goto L16;
        if (r4.contains("uncaughtException") == false) goto L16;
    L20:
        int r5 = r8.length;     // Catch: Throwable -> L26
        int r9 = 0;
    L21:
        if (r9 >= r5) goto L28;
        if (i(r6, r8[r9].trim()) == true) goto L24;
        r9 = r9 + 1;
        goto L21
    L24:
        return true;
    L26:
        th = move-exception;
        th.printStackTrace();
    L28:
        return false;
    }

    public static void h(Context r2, String r3) {
        SharedPreferences.Editor r4 = a(r2, "AMSKLG_CFG", 0).edit();
        r4.remove(r3);
        r4.apply();
    }

    static boolean i(String[] r5, String r6) {
        if (r5 == null) goto L21;
        if (r6 == null) goto L21;
        int r1 = r5.length;     // Catch: Throwable -> L19
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L21;
        String r3 = r5[r2];     // Catch: Throwable -> L19
        r6 = r6.trim();     // Catch: Throwable -> L19
        if (r6.startsWith("at ") == false) goto L18;
        if (r6.contains(r3 + ".") == false) goto L18;
        if (r6.endsWith(")") == false) goto L18;
        if (r6.contains("uncaughtException") == true) goto L18;
        return true;
    L18:
        r2 = r2 + 1;
    L19:
        th = move-exception;
        th.printStackTrace();
    L21:
        return false;
    }

    public static String j(Context r1, String r2) {
        return r1.getFilesDir().getAbsolutePath() + f7780a + r2;
    }
}
