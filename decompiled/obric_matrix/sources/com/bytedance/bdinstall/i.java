package com.bytedance.bdinstall;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import androidx.annotation.AnyThread;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile g f2789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile com.bytedance.bdinstall.y0.c f2790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile com.bytedance.bdinstall.y0.a f2791c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final com.bytedance.bdinstall.d1.n<com.bytedance.bdinstall.b1.b> f2792d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SuppressLint({"CI_StaticFieldLeak", "StaticFieldLeak"})
    private static volatile i0 f2793e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final com.bytedance.bdinstall.d1.n<h0> f2794f = null;

    class a extends com.bytedance.bdinstall.d1.n<com.bytedance.bdinstall.b1.b> {
        a() {
        }

        @Override // com.bytedance.bdinstall.d1.n
        protected /* bridge */ /* synthetic */ com.bytedance.bdinstall.b1.b a(Object[] r1) {
            return c(r1);
        }

        protected com.bytedance.bdinstall.b1.b c(Object... r2) {
            if (v0.j((Context) r2[0]) == false) goto L7;
            j0 r0 = new j0();
            r0.d((Application) v0.e((Context) r2[0]));
            return r0;
        L7:
            return new p0();
        }
    }

    class b extends com.bytedance.bdinstall.d1.n<h0> {
        b() {
        }

        @Override // com.bytedance.bdinstall.d1.n
        protected /* bridge */ /* synthetic */ h0 a(Object[] r1) {
            return c(r1);
        }

        protected h0 c(Object... r2) {
            return new o0((Context) r2[0]).c();
        }
    }

    static {
        f2791c = new com.bytedance.bdinstall.y0.a.C0082a();
        new l0();
        f2792d = new a();
        f2793e = null;
        f2794f = new b();
    }

    private static h0 A(g r3) {
        if (r3 == null) goto L5;
        Context r4 = r3.getContext();
    L6:
        if (r4 != null) goto L8;
        r4 = BDInstallProvider.b();
    L8:
        if (r4 != null) goto L11;
        return null;
    L11:
        return f2794f.b(new Object[]{r4});
    L5:
        r4 = null;
        goto L6
    }

    @AnyThread
    public static void a(boolean r1, u r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        com.bytedance.bdinstall.x0.b.c(r1, new com.bytedance.bdinstall.x0.d(r2));
    }

    @AnyThread
    public static void b(boolean r1, b0 r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        com.bytedance.bdinstall.x0.b.c(r1, new com.bytedance.bdinstall.x0.e(r2));
    }

    public static String c(Context r0, StringBuilder r1, String r2, boolean r3, m0 r4) {
        return f.b(r0, r1, r2, r3, r4);
    }

    public static String d(Context r1, StringBuilder r2, boolean r3, m0 r4) {
        return f.b(r1, r2, null, r3, r4);
    }

    public static void e(x r1) {
        com.bytedance.bdinstall.d1.b.d().c(r1);
    }

    public static void f(r r0) {
    }

    public static com.bytedance.bdinstall.y0.a g() {
        return f2791c;
    }

    public static g h() {
        return f2789a;
    }

    public static r i() {
        if (f2793e != null) goto L5;
        return null;
    L5:
        if (f2793e.t() != null) goto L8;
        return null;
    L8:
        return f2792d.b(new Object[]{f2793e.t()}).c();
    }

    public static boolean j(JSONObject r4) {
        return f2792d.b(new Object[]{f2793e.t()}).g(r4);
    L5:
        return false;
    }

    @Nullable
    public static String k() {
        if (f2793e != null) goto L5;
    L9:
        q.c("BDInstall#getDid error, not init yet!");
        h0 r0 = A(h());
        if (r0 != null) goto L13;
        return null;
    L13:
        return r0.c();
    L5:
        if (f2793e.t() == null) goto L9;
        return f2792d.b(new Object[]{f2793e.t()}).getDid();
    }

    @Nullable
    public static h0 l() {
        if (f2793e != null) goto L5;
    L9:
        q.c("BDInstall#getInstallInfo error, not init yet!");
        return A(h());
    L5:
        if (f2793e.t() == null) goto L9;
        return f2792d.b(new Object[]{f2793e.t()}).a();
    }

    static i0 m() {
        return f2793e;
    }

    public static com.bytedance.bdinstall.y0.c n() {
        return f2790b;
    }

    public static void o(i0 r4, r r5) {
        f2793e = r4;
        com.bytedance.bdinstall.y0.c r0 = r4.A();
        if (r0 == null) goto L6;
        f2790b = r0;
    L6:
        if (r4.i() == null) goto L8;
        f2791c = r4.i();
    L8:
        f0 r1 = r4.E();
        if (r1 == null) goto L11;
        t0.d(r1);
    L11:
        f2792d.b(new Object[]{r4.t()}).h(r4, r5);
    }

    public static void p(Context r1, Map<String, String> r2, boolean r3, m0 r4) {
        f.c(r1, r3, null, r2, r4);
    }

    static void q(Application r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        f2792d.b(new Object[]{r3}).d(r3);
    }

    @AnyThread
    public static void r(b0 r0) {
        com.bytedance.bdinstall.x0.b.d(r0);
    }

    public static void s(Context r7, r r8, long r9, n0 r11) {
        f2792d.b(new Object[]{r7}).f(r7, r8, r9, r11);
    }

    public static void t(Context r0, r r1, long r2, n0 r4) {
    }

    public static void u(g r0) {
        f2789a = r0;
    }

    public static void v(a0 r0) {
        f.d(r0);
    }

    public static void w(s r0) {
        t.h(r0);
    }

    public static void x(c0 r0) {
        q.f(r0);
    }

    public static void y(Context r4, String r5) {
        HashMap r0 = new HashMap();
        r0.put("user_unique_id", r5);
        f2792d.b(new Object[]{r4}).e(r4, r0, true, true);
    }

    public static void z() {
        f2792d.b(new Object[]{f2793e.t()}).start();
        com.bytedance.bdinstall.a1.b.l(f2793e.t()).q();
    }
}
