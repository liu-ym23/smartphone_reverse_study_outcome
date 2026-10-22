package com.loc;

import android.content.Context;
import android.os.Build;
import com.bytedance.bdlocation.client.LocationInfoConst;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static WeakReference<v0> f7920a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f7921b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static WeakReference<o1> f7922c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static WeakReference<o1> f7923d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String[] f7924e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f7925f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f7926g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int f7927h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static t5 f7928i;

    final class a extends s1 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Context f7929g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f7930h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ o1 f7931i;

        a(Context r1, String r2, o1 r3) {
            this.f7929g = r1;
            this.f7930h = r2;
            this.f7931i = r3;
        }

        @Override // com.loc.s1
        public final void b() {
            monitor-enter(w.class);     // Catch: Throwable -> L13
            v0 r1 = b1.a(w.c());     // Catch: Throwable -> L10
            b1.e(this.f7929g, r1, this.f7930h, 1000, 4096000, LocationInfoConst.ALLOW_USE_LOCATION);     // Catch: Throwable -> L10
            r1.f7885f = this.f7931i;     // Catch: Throwable -> L10
            if (r1.f7886g != null) goto L7;
            Context r4 = this.f7929g;     // Catch: Throwable -> L10
            r1.f7886g = new f1(new e1(r4, new j1(), new g0(new i0(new j0())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", new Object[]{i5.j(r4), l5.P(), l5.Z(this.f7929g), i5.g(this.f7929g), Build.MODEL, i5.e(this.f7929g), i5.h(this.f7929g), Build.VERSION.RELEASE}));     // Catch: Throwable -> L10
        L7:
            r1.f7887h = 3600000;     // Catch: Throwable -> L10
            w0.a(r1);     // Catch: Throwable -> L10
            monitor-exit(w.class);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            v.m(th, "lg", "pul");
        }
    }

    static {
        f7924e = new String[10];
    }

    public w() {
    }

    private static t5 a(String r4) {
        List r0 = t.c();
        if (r0 != null) goto L6;
        r0 = new ArrayList();
    L6:
        if (r4 != null) goto L8;
    L32:
        return null;
    L8:
        if ("".equals(r4) == true) goto L32;
        Iterator r1 = r0.iterator();
    L12:
        if (r1.hasNext() == false) goto L17;
        t5 r2 = (t5) r1.next();
        if (t.g(r2.i(), r4) == false) goto L12;
        return r2;
    L17:
        if (r4.contains("com.amap.api.col") == false) goto L23;
        return u5.a();
    L20:
        e = move-exception;
        e.printStackTrace();
    L23:
        if (r4.contains("com.amap.co") == false) goto L25;
    L33:
        t5 r5 = u5.p();     // Catch: h5 -> L30
        r5.c(true);     // Catch: h5 -> L30
        return r5;
    L30:
        e = move-exception;
        e.printStackTrace();
        goto L32
    L25:
        if (r4.contains("com.amap.opensdk.co") == true) goto L33;
        if (r4.contains("com.amap.location") == false) goto L32;
        goto L32
    }

    private static String b(List<t5> r11) {
        File r3 = new File("/data/anr/traces.txt");     // Catch: Throwable -> L54 FileNotFoundException -> L77
        if (r3.exists() == true) goto L6;
        return null;
    L6:
        FileInputStream r4 = new FileInputStream(r3);     // Catch: Throwable -> L54 FileNotFoundException -> L77
    L115:
        int r5 = r4.available();     // Catch: Throwable -> L51 FileNotFoundException -> L53
        if (r5 <= 1024000) goto L10;
        r4.skip(r5 - 1024000);     // Catch: Throwable -> L51 FileNotFoundException -> L53
    L10:
        m0 r6 = new m0(r4, l0.u);     // Catch: Throwable -> L51 FileNotFoundException -> L53
        boolean r7 = false;
    L113:
        String r8 = r6.a().trim();     // Catch: Throwable -> L43 EOFException -> L93 FileNotFoundException -> L94
        if (r8.contains("pid") == false) goto L19;
    L15:
        if (r8.startsWith("\"main\"") == true) goto L17;
        r8 = r6.a();     // Catch: Throwable -> L43 EOFException -> L93 FileNotFoundException -> L94
        goto L15
    L17:
        r7 = true;
    L19:
        if (r8.equals("") == false) goto L22;
        if (r7 == true) goto L97;
    L22:
        if (r7 == false) goto L113;
        if (f7925f <= 9) goto L26;
        f7925f = 0;     // Catch: Throwable -> L28
    L26:
        String[] r9 = f7924e;     // Catch: Throwable -> L28
        int r10 = f7925f;     // Catch: Throwable -> L28
        r9[r10] = r8;     // Catch: Throwable -> L28
        f7925f = r10 + 1;     // Catch: Throwable -> L28
    L30:
        int r12 = f7927h;     // Catch: Throwable -> L43 EOFException -> L93 FileNotFoundException -> L94
        if (r12 == 5) goto L97;
        if (f7926g == false) goto L35;
        f7927h = r12 + 1;     // Catch: Throwable -> L43 EOFException -> L93 FileNotFoundException -> L94
        goto L113
    L35:
        Iterator<t5> r13 = r11.iterator();     // Catch: Throwable -> L43 EOFException -> L93 FileNotFoundException -> L94
    L37:
        if (r13.hasNext() == false) goto L113;
        t5 r14 = r13.next();     // Catch: Throwable -> L43 EOFException -> L93 FileNotFoundException -> L94
        boolean r15 = t.i(r14.i(), r8);     // Catch: Throwable -> L43 EOFException -> L93 FileNotFoundException -> L94
        f7926g = r15;     // Catch: Throwable -> L43 EOFException -> L93 FileNotFoundException -> L94
        if (r15 == false) goto L37;
        f7928i = r14;     // Catch: Throwable -> L43 EOFException -> L93 FileNotFoundException -> L94
    L28:
        th = move-exception;
        v.m(th, "alg", "aDa");     // Catch: Throwable -> L43 EOFException -> L93 FileNotFoundException -> L94
        goto L30
    L43:
        th = th;
    L101:
        v.m(th, "alg", "getA");     // Catch: Throwable -> L65
        if (r6 != null) goto L95;
    L62:
        if (r4 == null) goto L89;
        r4.close();     // Catch: Throwable -> L86
    L107:
    L89:
        if (f7926g == true) goto L91;
        return null;
    L91:
        return j();
    L95:
        r6.close();     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        v.m(th, "alg", "getA");
    L65:
        th = move-exception;
        if (r6 != null) goto L105;
    L71:
        if (r4 == null) goto L128;
        r4.close();     // Catch: Throwable -> L74
        throw th;
    L74:
        th = move-exception;
        v.m(th, "alg", "getA");
        throw th;
    L128:
        throw th;
    L105:
        r6.close();     // Catch: Throwable -> L69
    L69:
        th = move-exception;
        v.m(th, "alg", "getA");
    L97:
        r6.close();     // Catch: Throwable -> L47
    L49:
        r4.close();     // Catch: Throwable -> L86
    L47:
        th = move-exception;
        v.m(th, "alg", "getA");
    L78:
        if (r6 != null) goto L99;
    L83:
        if (r4 == null) goto L89;
        r4.close();     // Catch: Throwable -> L86
        goto L107
    L99:
        r6.close();     // Catch: Throwable -> L81
    L81:
        th = move-exception;
        v.m(th, "alg", "getA");
        goto L83
    L53:
        r6 = null;
    L51:
        th = th;
        r6 = null;
    L86:
        th = move-exception;
        v.m(th, "alg", "getA");
    L77:
        r6 = null;
        r4 = null;
    L54:
        th = th;
        r6 = null;
        r4 = null;
        goto L101
    }

    static /* synthetic */ WeakReference c() {
        return f7920a;
    }

    static void d(Context r4) {
        List<t5> r0 = t.c();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() == 0) goto L19;
        String r1 = b(r0);
        if (r1 != null) goto L10;
        return;
    L10:
        if ("".equals(r1) == true) goto L18;
        t5 r2 = f7928i;
        if (r2 == null) goto L20;
        f(r4, r2, 2, "ANR", r1);
        return;
    L20:
        return;
    L18:
        return;
    }

    private static void e(Context r2, o1 r3, String r4) {
        r1.f().d(new a(r2, r4, r3));
    }

    private static void f(Context r6, t5 r7, int r8, String r9, String r10) {
        String r0 = b1.b();
        String r11 = b1.c(r6, r7);
        i5.a(r6);
        String r12 = b1.d(r11, r0, r8, r9, r10);
        if (r12 != null) goto L5;
        return;
    L5:
        if ("".equals(r12) == true) goto L26;
        String r13 = p5.d(r10);
        if (r8 != 1) goto L12;
        String r14 = t.f7781b;
    L10:
        String r2 = r14;
        v0 r15 = b1.a(f7920a);
        b1.e(r6, r15, r2, 1000, 4096000, LocationInfoConst.ALLOW_USE_LOCATION);
        if (r15.f7884e != null) goto L22;
        r15.f7884e = new f0(new g0(new i0(new j0())));
    L22:
        w0.c(r13, u5.o(r12.replaceAll("\n", "<br/>")), r15);     // Catch: Throwable -> L21
        return;
    L27:
        return;
    L12:
        if (r8 != 2) goto L14;
        r14 = t.f7783d;
        goto L10
    L14:
        if (r8 != 0) goto L25;
        r14 = t.f7782c;
        goto L10
    L25:
        return;
    }

    public static void g(Context r4, Throwable r5, int r6, String r7, String r8) {
        String r0 = u5.e(r5);
        t5 r1 = a(r0);
        if (i(r1) == true) goto L5;
        return;
    L5:
        String r2 = r0.replaceAll("\n", "<br/>");
        String r9 = r5.toString();
        if (r9 != null) goto L8;
        return;
    L8:
        if ("".equals(r9) == true) goto L18;
        StringBuilder r3 = new StringBuilder();
        if (r7 == null) goto L13;
        r3.append("class:");
        r3.append(r7);
    L13:
        if (r8 == null) goto L15;
        r3.append(" method:");
        r3.append(r8);
        r3.append("$<br/>");
    L15:
        r3.append(r2);
        f(r4, r1, r6, r9, r3.toString());
        return;
    }

    static void h(t5 r1, Context r2, String r3, String r4) {
        if (i(r1) == true) goto L5;
        return;
    L5:
        if (r3 != null) goto L7;
        return;
    L7:
        if ("".equals(r3) == true) goto L12;
        f(r2, r1, 1, r3, r4);
        return;
    }

    private static boolean i(t5 r0) {
        if (r0 != null) goto L4;
        return false;
    L4:
        if (r0.h() == false) goto L9;
        return true;
    L9:
        return false;
    }

    private static String j() {
        StringBuilder r0 = new StringBuilder();
        int r1 = f7925f;     // Catch: Throwable -> L14
    L5:
        if (r1 >= 10) goto L9;
        if (r1 > 9) goto L9;
        r0.append(f7924e[r1]);     // Catch: Throwable -> L14
        r1 = r1 + 1;     // Catch: Throwable -> L14
    L9:
        int r2 = 0;
    L10:
        if (r2 >= f7925f) goto L17;
        r0.append(f7924e[r2]);     // Catch: Throwable -> L14
        r2 = r2 + 1;
    L17:
        return r0.toString();
    L14:
        th = move-exception;
        v.m(th, "alg", "gLI");
        goto L17
    }

    static void k(Context r2) {
        m1 r0 = new m1(f7921b);
        f7921b = false;
        e(r2, r0, t.f7782c);
    }

    static void l(Context r5) {
        WeakReference<o1> r0 = f7922c;
        if (r0 != null) goto L5;
    L6:
        f7922c = new WeakReference(new n1(r5, 3600000, "hKey", new p1(r5)));
    L7:
        e(r5, f7922c.get(), t.f7783d);
        return;
    L5:
        if (r0.get() != null) goto L7;
        goto L6
    }

    static void m(Context r5) {
        WeakReference<o1> r0 = f7923d;
        if (r0 != null) goto L5;
    L6:
        f7923d = new WeakReference(new n1(r5, 3600000, "gKey", new p1(r5)));
    L7:
        e(r5, f7923d.get(), t.f7781b);
        return;
    L5:
        if (r0.get() != null) goto L7;
        goto L6
    }
}
