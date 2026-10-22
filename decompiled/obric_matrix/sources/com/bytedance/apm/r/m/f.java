package com.bytedance.apm.r.m;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.lego.init.IdleTaskConfig;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static f f1927a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile int f1928b = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f1929c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f1930d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long[] f1931e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f1932f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f1933g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile long f1934h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile long f1935i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Thread f1936j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile Runnable f1937k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static HandlerThread f1938l;
    private static Handler m;
    private static Object n;
    private static boolean o;
    private static Runnable p;
    private static com.bytedance.monitor.collector.a q;
    private static Runnable r;
    private static C0061f s;
    private static C0061f t;

    static class a extends com.bytedance.monitor.collector.a {
        a() {
        }

        @Override // com.bytedance.monitor.collector.a
        public void b(String r1, Message r2) {
            super.b(r1, r2);
            f.l();
        }

        @Override // com.bytedance.monitor.collector.a
        public void c(String r1) {
            super.c(r1);
            f.k();
        }

        @Override // com.bytedance.monitor.collector.a
        public boolean d() {
            if (f.a() == null) goto L6;
            f.a().run();
            f.b(null);
        L6:
            if (f.c() >= 1) goto L10;
            return false;
        L10:
            return true;
        }
    }

    static class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
        L16:
        L15:
            return;
        L3:
            if (f.m() == true) goto L7;
            if (f.c() <= (-1)) goto L7;
            f.o(f.p() - f.q());     // Catch: InterruptedException -> L15
            f.o(f.n() & 8796093022207L);     // Catch: InterruptedException -> L15
            SystemClock.sleep(5);     // Catch: InterruptedException -> L15
        L7:
            Object r4 = f.r();     // Catch: InterruptedException -> L15
            monitor-enter(r4);     // Catch: InterruptedException -> L15
            f.r().wait();     // Catch: Throwable -> L12
            monitor-exit(r4);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;     // Catch: InterruptedException -> L15
        }
    }

    static class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.s();
        }
    }

    static class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.d().removeCallbacksAndMessages(null);
            com.bytedance.monitor.collector.h.p(f.f());
            f.g().quit();
            f.h(null);
        }
    }

    static class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r3 = f.i();
            monitor-enter(r3);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (f.c() != Integer.MAX_VALUE) goto L7;
        L8:
            f.e(-2);     // Catch: Throwable -> L11
            f.j(true);     // Catch: Throwable -> L11
        L9:
            monitor-exit(r3);     // Catch: Throwable -> L11
            return;
        L7:
            if (f.c() != 1) goto L9;
            goto L8
        }
    }

    /* JADX INFO: renamed from: com.bytedance.apm.r.m.f$f, reason: collision with other inner class name */
    public static final class C0061f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1939a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1940b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private C0061f f1941c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private C0061f f1942d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f1943e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f1944f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f1945g;

        public C0061f(int r2) {
            this.f1943e = true;
            this.f1939a = r2;
        }

        static /* synthetic */ C0061f a(C0061f r0) {
            return r0.f1942d;
        }

        static /* synthetic */ C0061f b(C0061f r0, C0061f r1) {
            r0.f1942d = r1;
            return r1;
        }

        static /* synthetic */ C0061f c(C0061f r0) {
            return r0.f1941c;
        }

        static /* synthetic */ C0061f d(C0061f r0, C0061f r1) {
            r0.f1941c = r1;
            return r1;
        }

        static /* synthetic */ long e(C0061f r2) {
            return r2.f1945g;
        }

        static /* synthetic */ long f(C0061f r0, long r1) {
            r0.f1945g = r1;
            return r1;
        }

        public String toString() {
            return "index:" + this.f1939a + ",\tisValid:" + this.f1943e + " source:" + this.f1944f;
        }
    }

    static {
        f1927a = new f();
        Object r0 = new Object();
        f1930d = r0;
        f1934h = B();
        f1935i = f1934h;
        f1936j = Looper.getMainLooper().getThread();
        f1937k = null;
        f1938l = F();
        m = new Handler(f1938l.getLooper());
        n = new Object();
        o = false;
        p = null;
        q = new a();
        r = new b();
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        f1928b = -4;
        f1929c = true;
    L17:
        m.postDelayed(new c(), IdleTaskConfig.IDLE_START_TIME_OUT);
        return;
    L5:
        f1931e = new long[600000];
        if (f1928b != Integer.MAX_VALUE) goto L16;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (f1928b != Integer.MAX_VALUE) goto L11;
        M();     // Catch: Throwable -> L13
        f1928b = 1;     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
    L16:
        G(1048574, 0);
        I("EvilMethodTracer#message_0", com.bytedance.monitor.collector.a.f5105b);
        goto L17
    }

    public f() {
    }

    private static long B() {
        return SystemClock.uptimeMillis();
    }

    public static long C() {
        return f1935i;
    }

    public static f E() {
        return f1927a;
    }

    private static HandlerThread F() {
        HandlerThread r0 = new HandlerThread("trace_time_update_thread");
        r0.start();
        return r0;
    }

    public static void G(int r3, long r4) {
        if (f1929c == false) goto L6;
        return;
    L6:
        if (r3 < 1048575) goto L9;
        return;
    L9:
        if (Thread.currentThread() == f1936j) goto L11;
        return;
    L11:
        if (f1933g == false) goto L13;
        return;
    L13:
        f1933g = true;
        if (r4 == 0) goto L16;
        f1934h = r4 - f1935i;
        f1934h &= 8796093022207L;
    L16:
        long r5 = ((((long) r3) << 43) | Long.MIN_VALUE) | f1934h;
        long[] r6 = f1931e;
        int r1 = f1932f;
        r6[r1] = r5;
        int r2 = r1 + 1;
        f1932f = r2;
        if (r2 != 600000) goto L19;
        f1932f = 0;
    L19:
        f1933g = false;
        C0061f r7 = t;
        if (r7 != null) goto L23;
        return;
    L23:
        if (r7.f1939a != f1932f) goto L30;
        C0061f r8 = C0061f.a(r7);
        t = r8;
        if (r8 == null) goto L27;
        C0061f.d(r8, null);
        return;
    L27:
        s = null;
        return;
    }

    public static C0061f I(String r4, long r5) {
        if (s != null) goto L9;
        C0061f r0 = new C0061f(f1932f);
        s = r0;
        if (r5 > 0) goto L7;
        r5 = SystemClock.uptimeMillis();
    L7:
        C0061f.f(r0, r5);
        C0061f r6 = s;
        r6.f1944f = r4;
        t = r6;
        return r6;
    L9:
        C0061f r1 = new C0061f(f1932f);
        if (r5 > 0) goto L12;
        r5 = SystemClock.uptimeMillis();
    L12:
        C0061f.f(r1, r5);
        r1.f1944f = r4;
        C0061f.d(r1, s);
        C0061f r7 = s;
        r7.f1940b = r1.f1939a - 1;
        C0061f.b(r7, r1);
        s = r1;
        return r1;
    }

    public static void J(int r4, long r5) {
        if (f1929c == false) goto L6;
        return;
    L6:
        if (r4 < 1048575) goto L9;
        return;
    L9:
        if (Thread.currentThread() == f1936j) goto L11;
        return;
    L11:
        if (r5 == 0) goto L13;
        f1934h = r5 - f1935i;
        f1934h &= 8796093022207L;
    L13:
        long r6 = ((((long) r4) << 43) | 0) | f1934h;
        long[] r7 = f1931e;
        int r0 = f1932f;
        r7[r0] = r6;
        int r1 = r0 + 1;
        f1932f = r1;
        if (r1 != 600000) goto L16;
        f1932f = 0;
    L16:
        C0061f r8 = t;
        if (r8 != null) goto L19;
        return;
    L19:
        if (r8.f1939a != f1932f) goto L27;
        C0061f r9 = C0061f.a(r8);
        t = r9;
        if (r9 == null) goto L23;
        C0061f.d(r9, null);
        return;
    L23:
        s = null;
        return;
    }

    private static void M() {
        f1934h = B() - f1935i;
        m.removeCallbacksAndMessages(null);
        m.postDelayed(r, 5);
        Handler r0 = m;
        e r1 = new e();
        p = r1;
        r0.postDelayed(r1, IdleTaskConfig.IDLE_START_TIME_OUT);
        com.bytedance.monitor.collector.h.k(q);
    }

    private static void N() {
        Object r0 = f1930d;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f1928b != Integer.MAX_VALUE) goto L7;
    L8:
        f1928b = -3;     // Catch: Throwable -> L11
        f1929c = true;     // Catch: Throwable -> L11
        f1937k = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        if (f1928b != (-4)) goto L9;
        goto L8
    }

    static /* synthetic */ Runnable a() {
        return f1937k;
    }

    static /* synthetic */ Runnable b(Runnable r0) {
        f1937k = r0;
        return r0;
    }

    static /* synthetic */ int c() {
        return f1928b;
    }

    static /* synthetic */ Handler d() {
        return m;
    }

    static /* synthetic */ int e(int r0) {
        f1928b = r0;
        return r0;
    }

    static /* synthetic */ com.bytedance.monitor.collector.a f() {
        return q;
    }

    static /* synthetic */ HandlerThread g() {
        return f1938l;
    }

    static /* synthetic */ long[] h(long[] r0) {
        f1931e = r0;
        return r0;
    }

    static /* synthetic */ Object i() {
        return f1930d;
    }

    static /* synthetic */ boolean j(boolean r0) {
        f1929c = r0;
        return r0;
    }

    static /* synthetic */ void k() {
        y();
    }

    static /* synthetic */ void l() {
        z();
    }

    static /* synthetic */ boolean m() {
        return o;
    }

    static /* synthetic */ long n() {
        return f1934h;
    }

    static /* synthetic */ long o(long r0) {
        f1934h = r0;
        return r0;
    }

    static /* synthetic */ long p() {
        return B();
    }

    static /* synthetic */ long q() {
        return f1935i;
    }

    static /* synthetic */ Object r() {
        return n;
    }

    static /* synthetic */ void s() {
        N();
    }

    private long[] v(long r5, long r7) {
        C0061f r0 = s;
        if (r0 == null) goto L19;
        C0061f r1 = t;
        if (r1 == null) goto L28;
    L7:
        if (r0 == r1) goto L14;
        if (C0061f.e(C0061f.c(r0)) > r7) goto L10;
        if (C0061f.e(C0061f.a(r1)) >= r5) goto L14;
        r1 = C0061f.a(r1);
        goto L7
    L10:
        r0 = C0061f.c(r0);
    L14:
        int r6 = r0.f1940b;
        if (r6 != 0) goto L18;
        r6 = f1932f - 1;
    L18:
        return u(r1.f1939a, r6);
    L28:
        return null;
    L19:
        return null;
    }

    private static void y() {
        f1934h = com.bytedance.monitor.collector.a.f5105b - f1935i;
        o = false;
        Object r0 = n;
        monitor-enter(r0);
        n.notify();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void z() {
        o = true;
    }

    public String A(long[] r2, long r3) {
        if (r2 != null) goto L5;
        return "";
    L5:
        LinkedList r1 = new LinkedList();
        d.b.o.a.a.j(r2, r1, true, r3);
        d.b.o.a.a.l(r1, 1);
        StringBuilder r4 = new StringBuilder();
        d.b.o.a.a.g(r1, r4);
        return r4.toString();
    }

    public String D(long r3, long r5) {
        long r0 = SystemClock.uptimeMillis();
        return A(v(r3, r5), r0);
    }

    public boolean H() {
        if (f1928b < 2) goto L5;
        return true;
    L5:
        return false;
    }

    public void K() {
        Object r3 = f1930d;
        monitor-enter(r3);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (f1928b < 2) goto L7;
    L13:
        monitor-exit(r3);     // Catch: Throwable -> L15
        return;
    L7:
        if (f1928b < (-2)) goto L13;
        m.removeCallbacks(p);     // Catch: Throwable -> L15
        if (f1931e == null) goto L12;
        f1928b = 2;     // Catch: Throwable -> L15
        f1929c = false;     // Catch: Throwable -> L15
        goto L13
    L12:
        throw new RuntimeException("MethodCollector sBuffer == null");     // Catch: Throwable -> L15
    }

    public void L() {
        Object r2 = f1930d;
        monitor-enter(r2);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f1928b != 2) goto L7;
        f1928b = -1;     // Catch: Throwable -> L9
        f1929c = true;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r2);     // Catch: Throwable -> L9
    }

    public long[] t() {
        C0061f r1 = s;     // Catch: Throwable -> L15
        if (r1 == null) goto L14;
        C0061f r2 = t;     // Catch: Throwable -> L15
        if (r2 == null) goto L14;
        if (r1 == r2) goto L14;
        int r3 = r1.f1940b;     // Catch: Throwable -> L15
        if (r3 != 0) goto L12;
        r3 = f1932f - 1;     // Catch: Throwable -> L15
    L12:
        return u(r2.f1939a, r3);
    L14:
        return null;
    }

    public long[] u(int r4, int r5) {
        long[] r0 = new long[0];
        int r6 = Math.max(0, r4);
        int r7 = Math.max(0, r5);
        if (r7 <= r6) goto L5;
        int r8 = (r7 - r6) + 1;
        long[] r1 = new long[r8];
        System.arraycopy(f1931e, r6, r1, 0, r8);
        return r1;
    L5:
        if (r7 >= r6) goto L9;
        int r9 = r7 + 1;
        long[] r2 = f1931e;
        long[] r3 = new long[(r2.length - r6) + r9];
        System.arraycopy(r2, r6, r3, 0, r2.length - r6);
        long[] r10 = f1931e;
        System.arraycopy(r10, 0, r3, r10.length - r6, r9);
        return r3;
    L9:
        return r0;
    }

    public long[] w(C0061f r3) {
        return x(r3, new C0061f(f1932f - 1));
    }

    public long[] x(C0061f r3, C0061f r4) {
        if (f1928b != (-3)) goto L6;
        return null;
    L6:
        long[] r0 = new long[0];
        if (r3.f1943e == false) goto L13;
        if (r4.f1943e == false) goto L13;
        return u(r3.f1939a - 1, r4.f1939a);
    L13:
        return r0;
    }
}
