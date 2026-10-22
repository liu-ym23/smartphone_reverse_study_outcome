package com.bytedance.monitor.collector;

import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Printer;
import com.bytedance.common.utility.Logger;
import com.ttnet.org.chromium.base.TimeUtils;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f5167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Printer f5168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static com.bytedance.apm.r.j f5169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final CopyOnWriteArrayList<com.bytedance.monitor.collector.a> f5170d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static com.bytedance.monitor.collector.a f5171e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static com.bytedance.monitor.collector.a f5172f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile c f5173g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile boolean f5174h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static long f5175i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static int f5176j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static boolean f5177k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static boolean f5178l;
    private static Printer m;

    static class a implements Printer {
        a() {
        }

        @Override // android.util.Printer
        public void println(String r4) {
            if (TextUtils.isEmpty(r4) == false) goto L5;
            return;
        L5:
            boolean r3 = false;
            if (r4.charAt(0) != '>') goto L13;
            if (o.f5223b == false) goto L10;
            com.bytedance.apm.r.k.e(r4);
            return;
        L10:
            r3 = true;
        L11:
            h.d(r3, r4, null);
            return;
        L13:
            if (r4.charAt(0) == '<') goto L15;
            return;
        L15:
            if (o.f5223b == false) goto L11;
            com.bytedance.apm.r.k.f(r4, null);
        }
    }

    static class b implements com.bytedance.apm.r.j {
        b() {
        }

        @Override // com.bytedance.apm.r.j
        public void a(String r2) {
            h.d(true, r2, null);
        }

        @Override // com.bytedance.apm.r.j
        public void b(String r1, Message r2) {
            h.d(false, r1, r2);
        }
    }

    public interface c {
        void a(long r1);
    }

    static {
        f5170d = new CopyOnWriteArrayList();
        f5174h = false;
        f5175i = 0;
        f5176j = 0;
    }

    public static void a() {
        if (f5167a == false) goto L24;
        if (f5177k == true) goto L24;
        if (f5172f != null) goto L24;
        if (com.bytedance.apm.d0.c.e("block_monitor") == false) goto L12;
        return;
    L12:
        if (Build.VERSION.SDK_INT < 24) goto L30;
        b();
        if (j() == true) goto L17;
        com.bytedance.common.utility.f.g(f5168b);
    L21:
        f5177k = true;
        return;
    L17:
        if (com.bytedance.apm.d.C() == false) goto L19;
        Logger.i("LooperMonitor", "enable Looper Observer monitor.");
    L19:
        com.bytedance.apm.r.k.i(f5169c);
        goto L21
    L30:
        return;
    L24:
        if (f5177k == true) goto L26;
        return;
    L26:
        if (f5178l == true) goto L32;
        b();
        return;
    }

    public static void b() {
        if (f5167a == true) goto L5;
        return;
    L5:
        if (f5178l == false) goto L7;
        return;
    L7:
        if (o.f5224c == true) goto L10;
        return;
    L10:
        if (j() == false) goto L18;
        List<com.bytedance.apm.r.j> r0 = com.bytedance.apm.r.k.c();
        if (r0 == null) goto L29;
        if (r0.size() != 1) goto L29;
        if (r0.get(0) != f5169c) goto L29;
        com.bytedance.apm.r.k.j();
    L27:
        f5178l = true;
    L29:
        if (com.bytedance.apm.d.C() == false) goto L34;
        Logger.i("LooperMonitor", "enable Looper Observer block.");
        return;
    L34:
        return;
    L18:
        List<Printer> r1 = com.bytedance.common.utility.f.e();
        if (r1 == null) goto L29;
        if (r1.size() != 1) goto L29;
        if (r1.get(0) != f5168b) goto L29;
        Printer r2 = f();
        m = r2;
        if (r2 == null) goto L29;
        Looper.getMainLooper().setMessageLogging(null);
        goto L27
    }

    public static void c() {
        if (f5167a == true) goto L5;
        return;
    L5:
        if (f5177k == false) goto L8;
        return;
    L8:
        if (com.bytedance.apm.r.m.e.A().E() == true) goto L10;
        return;
    L10:
        int r0 = com.bytedance.apm.r.m.e.A().B();
        if (f5170d.isEmpty() == false) goto L18;
        if (r0 == 0) goto L14;
        return;
    L14:
        if (f5172f != null) goto L20;
        a();
        return;
    L20:
        return;
    }

    public static void d(boolean r9, String r10, Message r11) {
        long r1 = System.nanoTime();
        com.bytedance.monitor.collector.a.f5105b = r1 / TimeUtils.NANOSECONDS_PER_MILLISECOND;
        com.bytedance.monitor.collector.a.f5106c = SystemClock.currentThreadTimeMillis();
        if (r9 == false) goto L9;
        com.bytedance.monitor.collector.a r3 = f5172f;
        if (r3 == null) goto L9;
        if (r3.d() == false) goto L9;
        f5172f.c(r10);
    L9:
        if (r9 == false) goto L57;
        com.bytedance.monitor.collector.a r4 = f5171e;
        if (r4 == null) goto L57;
        if (r4.d() == false) goto L57;
        f5171e.c(r10);
    L57:
        CopyOnWriteArrayList<com.bytedance.monitor.collector.a> r5 = f5170d;     // Catch: Exception -> L56
        int r6 = 0;
    L17:
        if (r6 >= r5.size()) goto L35;
        com.bytedance.monitor.collector.a r7 = r5.get(r6);     // Catch: Exception -> L56
        if (r7 != null) goto L22;
    L30:
        if (r9 == true) goto L34;
        if (r7.f5107a == false) goto L34;
        r7.b("", null);     // Catch: Exception -> L56
    L34:
        r6 = r6 + 1;
        goto L17
    L22:
        if (r7.d() == false) goto L30;
        if (r9 == false) goto L28;
        if (r7.f5107a == true) goto L34;
        r7.c(r10);     // Catch: Exception -> L56
        goto L34
    L28:
        if (r7.f5107a == false) goto L34;
        r7.b(r10, r11);     // Catch: Exception -> L56
    L35:
        if (r9 == true) goto L41;
        com.bytedance.monitor.collector.a r12 = f5171e;
        if (r12 == null) goto L41;
        if (r12.d() == false) goto L41;
        f5171e.b("", null);
    L41:
        if (r9 == true) goto L48;
        com.bytedance.monitor.collector.a r13 = f5172f;
        if (r13 == null) goto L48;
        if (r13.d() == false) goto L48;
        f5172f.b("", null);
    L48:
        if (f5174h == false) goto L67;
        f5175i += System.nanoTime() - r1;
        int r14 = f5176j;
        f5176j = r14 + 1;
        if (r14 >= 1000) goto L52;
        return;
    L52:
        if (f5173g == null) goto L54;
        f5173g.a(f5175i);
    L54:
        f5176j = 0;
        f5175i = 0;
        f5174h = false;
        return;
    }

    public static void e(boolean r0) {
        f5174h = r0;
    }

    private static Printer f() {
        Field r0 = Class.forName("android.os.Looper").getDeclaredField("mLogging");     // Catch: Exception -> L4
        r0.setAccessible(true);     // Catch: Exception -> L4
        return (Printer) r0.get(Looper.getMainLooper());
    L4:
        return null;
    }

    public static int g() {
        return f5170d.size();
    }

    public static void h() {
        if (o.f5222a == false) goto L6;
        return;
    L6:
        if (f5167a == false) goto L8;
        return;
    L8:
        f5167a = true;
        f5168b = new a();
        f5169c = new b();
        if (o.f5223b == true) goto L11;
    L19:
        i();
        return;
    L11:
        if (com.bytedance.apm.r.k.d(f5168b) == false) goto L19;
        if (com.bytedance.apm.d.C() == false) goto L16;
        Logger.i("LooperMonitor", "enable Looper Observer monitor.");
    L16:
        if (com.bytedance.apm.r.k.f1840b == false) goto L18;
        i();
    L18:
        com.bytedance.apm.r.k.a(f5169c);
    }

    public static void i() {
        com.bytedance.common.utility.f.f();
        com.bytedance.common.utility.f.c(f5168b);
    }

    private static boolean j() {
        if (o.f5223b == true) goto L5;
    L9:
        return false;
    L5:
        if (com.bytedance.apm.r.k.d(f5168b) == false) goto L9;
        if (com.bytedance.apm.r.k.f1840b == true) goto L9;
        return true;
    }

    public static void k(com.bytedance.monitor.collector.a r2) {
        CopyOnWriteArrayList<com.bytedance.monitor.collector.a> r0 = f5170d;
        monitor-enter(r0);
        if (r2 != null) goto L15;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        if (r0.contains(r2) == true) goto L10;
        r0.add(r2);     // Catch: Throwable -> L12
        if (com.bytedance.apm.r.m.e.A().E() == false) goto L10;
        n();     // Catch: Throwable -> L12
        goto L10
    }

    public static void l(com.bytedance.monitor.collector.a r0) {
        f5171e = r0;
    }

    public static void m(c r0) {
        f5173g = r0;
    }

    public static void n() {
        if (f5167a == true) goto L5;
        return;
    L5:
        if (f5177k == false) goto L17;
        o(false);
        if (j() == true) goto L10;
        i();
    L14:
        f5177k = false;
        return;
    L10:
        if (com.bytedance.apm.d.C() == false) goto L12;
        Logger.i("LooperMonitor", "enable Looper Observer monitor.");
    L12:
        com.bytedance.apm.r.k.a(f5169c);
        goto L14
    }

    public static void o(boolean r1) {
        if (f5167a == true) goto L5;
        return;
    L5:
        if (f5178l == true) goto L7;
        return;
    L7:
        if (o.f5224c == true) goto L10;
        return;
    L10:
        if (j() == false) goto L14;
        if (r1 == false) goto L14;
        return;
    L14:
        if (j() == false) goto L17;
        com.bytedance.apm.r.k.b();
    L20:
        if (com.bytedance.apm.d.C() == false) goto L22;
        Logger.i("LooperMonitor", "enable Looper Observer unblock.");
    L22:
        f5178l = false;
        return;
    L17:
        if (m == null) goto L20;
        Looper.getMainLooper().setMessageLogging(m);
        goto L20
    }

    public static void p(com.bytedance.monitor.collector.a r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        CopyOnWriteArrayList<com.bytedance.monitor.collector.a> r0 = f5170d;
        monitor-enter(r0);
        r0.remove(r1);     // Catch: Throwable -> L17
        if (com.bytedance.apm.r.m.e.A().E() == true) goto L9;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L9:
        if (r0.isEmpty() == false) goto L15;
        if (com.bytedance.apm.r.m.e.A().B() != 0) goto L15;
        if (f5172f != null) goto L15;
        a();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }
}
