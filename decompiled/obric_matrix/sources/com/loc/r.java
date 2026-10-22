package com.loc;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile q f7687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Properties f7688b;

    static {
        f7688b = f();
    }

    private r() {
    }

    public static q a() {
        if (f7687a != null) goto L28;
        monitor-enter(r.class);
    L24:
        th = move-exception;
        throw th;
    L7:
        if (f7687a == null) goto L31;
    L22:
        monitor-exit(r.class);     // Catch: Throwable -> L24
        goto L28
    L31:
        q r1 = b(Build.MANUFACTURER);     // Catch: Exception -> L20 Throwable -> L24
        if ("".equals(r1.a()) == false) goto L18;
        Iterator r2 = Arrays.asList(new String[]{q.f7600k.a(), q.f7601l.a(), q.m.a(), q.n.a(), q.o.a(), q.p.a(), q.q.a(), q.s.a(), q.t.a(), q.u.a(), q.v.a()}).iterator();     // Catch: Exception -> L20 Throwable -> L24
    L13:
        if (r2.hasNext() == false) goto L17;
        q r3 = b((String) r2.next());     // Catch: Exception -> L20 Throwable -> L24
        if ("".equals(r3.a()) == true) goto L13;
        r1 = r3;
        goto L18
    L17:
        r1 = q.w;     // Catch: Exception -> L20 Throwable -> L24
    L18:
        f7687a = r1;     // Catch: Exception -> L20 Throwable -> L24
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L24
    L28:
        return f7687a;
    }

    private static q b(String r2) {
        if (r2 == null) goto L69;
        if (r2.length() <= 0) goto L69;
        q r0 = q.f7600k;
        if (r2.equals(r0.a()) == true) goto L9;
        q r1 = q.f7601l;
        if (r2.equals(r1.a()) == true) goto L14;
        q r3 = q.m;
        if (r2.equals(r3.a()) == true) goto L19;
        q r4 = q.n;
        if (r2.equals(r4.a()) == true) goto L24;
        q r5 = q.o;
        if (r2.equals(r5.a()) == true) goto L29;
        q r6 = q.p;
        if (r2.equals(r6.a()) == true) goto L34;
        q r7 = q.q;
        if (r2.equals(r7.a()) == true) goto L39;
        q r8 = q.r;
        if (r2.equals(r8.a()) == true) goto L44;
        q r9 = q.s;
        if (r2.equals(r9.a()) == true) goto L49;
        q r10 = q.t;
        if (r2.equals(r10.a()) == true) goto L54;
        q r11 = q.u;
        if (r2.equals(r11.a()) == true) goto L59;
        q r12 = q.v;
        if (r2.equals(r12.a()) == true) goto L64;
    L67:
        return q.w;
    L64:
        if (r(r12) == false) goto L67;
        return r12;
    L59:
        if (q(r11) == false) goto L67;
        return r11;
    L54:
        if (p(r10) == false) goto L67;
        return r10;
    L49:
        if (o(r9) == false) goto L67;
        return r9;
    L44:
        if (n(r8) == false) goto L67;
        return r8;
    L39:
        if (m(r7) == false) goto L67;
        return r7;
    L34:
        if (l(r6) == false) goto L67;
        return r6;
    L29:
        if (k(r5) == false) goto L67;
        return r5;
    L24:
        if (j(r4) == false) goto L67;
        return r4;
    L19:
        if (i(r3) == false) goto L67;
        return r3;
    L14:
        if (g(r1) == false) goto L67;
        return r1;
    L9:
        if (d(r0) == false) goto L67;
        return r0;
    L69:
        return q.w;
    }

    private static void c(q r1, String r2) {
        Matcher r3 = Pattern.compile("([\\d.]+)[^\\d]*").matcher(r2);
        if (r3.find() == true) goto L10;
        return;
    L10:
        String r4 = r3.group(1);     // Catch: Exception -> L7
        r1.c(r4);     // Catch: Exception -> L7
        r1.b(Integer.parseInt(r4.split("\\.")[0]));     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    private static boolean d(q r1) {
        if (TextUtils.isEmpty(e("ro.miui.ui.version.name")) == true) goto L6;
        String r0 = e("ro.build.version.incremental");
        c(r1, r0);
        r1.j(r0);
        return true;
    L6:
        return false;
    }

    private static String e(String r5) {
        String r0 = f7688b.getProperty("[" + r5 + "]", null);
        if (TextUtils.isEmpty(r0) == false) goto L7;
        return h(r5);
    L7:
        return r0.replace("[", "").replace("]", "");
    }

    private static Properties f() {
        Properties r0 = new Properties();
        r0.load(Runtime.getRuntime().exec("getprop").getInputStream());     // Catch: Exception -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    private static boolean g(q r2) {
        String r0 = e("ro.flyme.published");
        String r1 = e("ro.meizu.setupwizard.flyme");
        if (TextUtils.isEmpty(r0) == true) goto L5;
    L9:
        String r3 = e("ro.build.display.id");
        c(r2, r3);
        r2.j(r3);
        return true;
    L5:
        if (TextUtils.isEmpty(r1) == false) goto L9;
        return false;
    }

    private static String h(String r3) {
        BufferedReader r0 = null;
        BufferedReader r1 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(r3))).getInputStream()), 1024);     // Catch: Throwable -> L9 IOException -> L13
        String r4 = r1.readLine();     // Catch: Throwable -> L7 IOException -> L19
        r1.close();     // Catch: Throwable -> L7 IOException -> L19
        r1.close();     // Catch: IOException -> L17
    L6:
        return r4;
    L7:
        th = th;
        r0 = r1;
    L10:
        if (r0 != null) goto L21;
    L12:
        throw th;
    L21:
        r0.close();     // Catch: IOException -> L18
    L14:
        if (r1 != null) goto L25;
    L16:
        return null;
    L25:
        r1.close();     // Catch: IOException -> L20
        goto L16
    L13:
        r1 = null;
    L9:
        th = th;
        goto L10
    }

    private static boolean i(q r2) {
        String r0 = e("ro.build.version.emui");
        if (TextUtils.isEmpty(r0) == true) goto L6;
        c(r2, r0);
        r2.j(r0);
        return true;
    L6:
        return false;
    }

    private static boolean j(q r2) {
        String r0 = e("ro.build.version.opporom");
        if (TextUtils.isEmpty(r0) == true) goto L6;
        c(r2, r0);
        r2.j(r0);
        return true;
    L6:
        return false;
    }

    private static boolean k(q r2) {
        String r0 = e("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(r0) == true) goto L6;
        c(r2, r0);
        r2.j(r0);
        return true;
    L6:
        return false;
    }

    private static boolean l(q r2) {
        String r0 = e("ro.smartisan.version");
        if (TextUtils.isEmpty(r0) == true) goto L6;
        c(r2, r0);
        r2.j(r0);
        return true;
    L6:
        return false;
    }

    private static boolean m(q r2) {
        String r0 = e("ro.build.display.id");
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return false;
    L5:
        if (r0.matches("amigo([\\d.]+)[a-zA-Z]*") == false) goto L10;
        c(r2, r0);
        r2.j(r0);
        return true;
    L10:
        return false;
    }

    private static boolean n(q r2) {
        String r0 = e("ro.letv.release.version");
        if (TextUtils.isEmpty(r0) == true) goto L6;
        c(r2, r0);
        r2.j(r0);
        return true;
    L6:
        return false;
    }

    private static boolean o(q r2) {
        String r0 = e("ro.build.sense.version");
        if (TextUtils.isEmpty(r0) == true) goto L6;
        c(r2, r0);
        r2.j(r0);
        return true;
    L6:
        return false;
    }

    private static boolean p(q r2) {
        String r0 = e("sys.lge.lgmdm_version");
        if (TextUtils.isEmpty(r0) == true) goto L6;
        c(r2, r0);
        r2.j(r0);
        return true;
    L6:
        return false;
    }

    private static boolean q(q r2) {
        if ("android-google".equals(e("ro.com.google.clientidbase")) == false) goto L6;
        String r0 = e("ro.build.version.release");
        r2.b(Build.VERSION.SDK_INT);
        r2.j(r0);
        return true;
    L6:
        return false;
    }

    private static boolean r(q r2) {
        String r0 = e("ro.build.nubia.rom.code");
        if (TextUtils.isEmpty(r0) == true) goto L6;
        c(r2, r0);
        r2.j(r0);
        return true;
    L6:
        return false;
    }
}
