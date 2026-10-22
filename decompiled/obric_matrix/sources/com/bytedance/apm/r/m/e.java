package com.bytedance.apm.r.m;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.Choreographer;
import android.view.FrameMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.monitor.collector.k;
import com.bytedance.services.apm.api.EnsureManager;
import com.ttnet.org.chromium.base.TimeUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class e implements com.bytedance.apm.core.c {
    private static final e w = null;
    private static boolean x;
    private static com.bytedance.apm.r.a y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f1890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.apm.r.m.d f1891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long[] f1892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<com.bytedance.apm.r.a> f1893d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f1894e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1895f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f1896g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1897h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Object f1898i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Object[] f1899j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long[] f1900k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Method f1901l;
    private Choreographer m;
    private boolean n;
    final com.bytedance.apm.f0.d o;
    Runnable p;
    final com.bytedance.apm.f0.e q;
    private HashMap<String, Window.OnFrameMetricsAvailableListener> r;
    private long s;
    private boolean t;
    private boolean u;
    public boolean v;

    class a extends com.bytedance.monitor.collector.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f1902d;

        a(e r1) {
            this.f1902d = r1;
        }

        @Override // com.bytedance.monitor.collector.a
        public void b(String r1, Message r2) {
            super.b(r1, r2);
            e.i(this.f1902d);
        }

        @Override // com.bytedance.monitor.collector.a
        public void c(String r1) {
            super.c(r1);
            e.b(this.f1902d, r1);
        }

        @Override // com.bytedance.monitor.collector.a
        public boolean d() {
            return e.a(this.f1902d);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f1903f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f1904g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ e f1905h;

        b(e r1, long r2, long r4) {
            this.f1905h = r1;
            this.f1903f = r2;
            this.f1904g = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator r0 = e.j(this.f1905h).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((com.bytedance.apm.r.a) r0.next()).e(ActivityLifeObserver.getInstance().getTopActivityClassName(), this.f1903f, this.f1904g);
            goto L4
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f1906f;

        class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ c f1907f;

            a(c r1) {
                this.f1907f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f1907f.f1906f.z();     // Catch: Throwable -> L4
                return;
            }
        }

        c(e r1) {
            this.f1906f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            e r3 = this.f1906f;     // Catch: Exception -> L31
            r3.p = new a(this);     // Catch: Exception -> L31
            e.l(r3, e.n(r3, e.m(r3), "mLock"));     // Catch: Exception -> L31
            if (e.k(this.f1906f) != null) goto L6;
            e r4 = this.f1906f;     // Catch: Exception -> L31
            e.l(r4, e.o(r4, e.m(r4), "mLock"));     // Catch: Exception -> L31
        L6:
            e r2 = this.f1906f;     // Catch: Exception -> L31
            e.q(r2, (Object[]) e.n(r2, e.m(r2), "mCallbackQueues"));     // Catch: Exception -> L31
            if (e.p(this.f1906f) != null) goto L9;
            e r5 = this.f1906f;     // Catch: Exception -> L31
            e.q(r5, (Object[]) e.o(r5, e.m(r5), "mCallbackQueues"));     // Catch: Exception -> L31
        L9:
            int r1 = Build.VERSION.SDK_INT;     // Catch: Exception -> L31
            if (r1 != 28) goto L13;
            e r6 = this.f1906f;     // Catch: Exception -> L31
            e.s(r6, (long[]) e.o(r6, e.o(r6, e.m(r6), "mFrameInfo"), "mFrameInfo"));     // Catch: Exception -> L31
        L18:
            if (e.r(this.f1906f) != null) goto L22;
            if (r1 <= 22) goto L22;
            EnsureManager.ensureNotReachHere("FrameInfoIsNull");     // Catch: Exception -> L31
        L22:
            if (e.k(this.f1906f) != null) goto L25;
            EnsureManager.ensureNotReachHere("CallbackQueueLockIsNull");     // Catch: Exception -> L31
        L25:
            if (e.p(this.f1906f) != null) goto L27;
            EnsureManager.ensureNotReachHere("callbackQueuesIsNull");     // Catch: Exception -> L31
        L27:
            e r7 = this.f1906f;     // Catch: Exception -> L31
            e.c(r7, e.d(r7, e.p(r7)[0], "addCallbackLocked", new Class[]{Long.TYPE, Object.class, Object.class}));     // Catch: Exception -> L31
            if (r1 < 16) goto L36;
            e r8 = this.f1906f;     // Catch: Exception -> L31
            e.e(r8, r8.p);     // Catch: Exception -> L31
            return;
        L36:
            return;
        L13:
            if (r1 <= 28) goto L15;
            e r9 = this.f1906f;     // Catch: Exception -> L31
            e.s(r9, (long[]) e.o(r9, e.o(r9, e.m(r9), "mFrameInfo"), "frameInfo"));     // Catch: Exception -> L31
            goto L18
        L15:
            if (r1 <= 22) goto L18;
            e r10 = this.f1906f;     // Catch: Exception -> L31
            e.s(r10, (long[]) e.n(r10, e.n(r10, e.m(r10), "mFrameInfo"), "mFrameInfo"));     // Catch: Exception -> L31
        L31:
            e = move-exception;
            EnsureManager.ensureNotReachHere(e, "MainThreadMonitor_fullFps");
        }
    }

    class d extends h {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ e f1908g;

        d(e r1, Window.Callback r2) {
            this.f1908g = r1;
            super(r2);
        }

        @Override // android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent r4) {
            if (e.f(this.f1908g) == true) goto L6;
            this.f1908g.f1891b.a(r4.getEventTime());
        L6:
            return this.f1951f.dispatchKeyEvent(r4);
        }

        @Override // android.view.Window.Callback
        public boolean dispatchTouchEvent(MotionEvent r4) {
            if (e.f(this.f1908g) == true) goto L6;
            this.f1908g.f1891b.a(r4.getEventTime());
        L6:
            return this.f1951f.dispatchTouchEvent(r4);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.apm.r.m.e$e, reason: collision with other inner class name */
    class WindowOnFrameMetricsAvailableListenerC0060e implements Window.OnFrameMetricsAvailableListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f1909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f1910b;

        /* JADX INFO: renamed from: com.bytedance.apm.r.m.e$e$a */
        class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ long f1911f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ long f1912g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f1913h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ WindowOnFrameMetricsAvailableListenerC0060e f1914i;

            a(WindowOnFrameMetricsAvailableListenerC0060e r1, long r2, long r4, int r6) {
                this.f1914i = r1;
                this.f1911f = r2;
                this.f1912g = r4;
                this.f1913h = r6;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f1911f == 0) goto L5;
                return;
            L5:
                if (e.h() != null) goto L7;
            L9:
                Iterator r0 = e.j(this.f1914i.f1910b).iterator();
            L11:
                if (r0.hasNext() == false) goto L16;
                ((com.bytedance.apm.r.a) r0.next()).g(this.f1914i.f1909a, this.f1912g, this.f1913h);
                goto L11
            L16:
                return;
            L7:
                if (this.f1914i.f1910b.v == false) goto L9;
                e.h().g(this.f1914i.f1909a, this.f1912g, this.f1913h);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.apm.r.m.e$e$b */
        class b implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ FrameMetrics f1915f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ int f1916g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ WindowOnFrameMetricsAvailableListenerC0060e f1917h;

            b(WindowOnFrameMetricsAvailableListenerC0060e r1, FrameMetrics r2, int r3) {
                this.f1917h = r1;
                this.f1915f = r2;
                this.f1916g = r3;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f1915f.getMetric(9) == 0) goto L5;
                return;
            L5:
                if (e.h() != null) goto L7;
            L9:
                Iterator r0 = e.j(this.f1917h.f1910b).iterator();
            L11:
                if (r0.hasNext() == false) goto L16;
                ((com.bytedance.apm.r.a) r0.next()).h(this.f1917h.f1909a, this.f1915f, this.f1916g);
                goto L11
            L16:
                return;
            L7:
                if (this.f1917h.f1910b.v == false) goto L9;
                e.h().h(this.f1917h.f1909a, this.f1915f, this.f1916g);
            }
        }

        WindowOnFrameMetricsAvailableListenerC0060e(e r1, String r2) {
            this.f1910b = r1;
            this.f1909a = r2;
        }

        @Override // android.view.Window.OnFrameMetricsAvailableListener
        public void onFrameMetricsAvailable(Window r12, FrameMetrics r13, int r14) {
            if (e.g(this.f1910b) == false) goto L5;
            long r8 = (((((r13.getMetric(0) + r13.getMetric(1)) + r13.getMetric(2)) + r13.getMetric(3)) + r13.getMetric(4)) + r13.getMetric(5)) / TimeUtils.NANOSECONDS_PER_MILLISECOND;
            long r6 = r13.getMetric(9);
            this.f1910b.o.b(new a(this, r6, r8, r14));
            return;
        L5:
            FrameMetrics r15 = new FrameMetrics(r13);
            this.f1910b.o.b(new b(this, r15, r14));
        }
    }

    class f implements Window.OnFrameMetricsAvailableListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f1918a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f1919b;

        class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ long f1920f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ long f1921g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f1922h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ f f1923i;

            a(f r1, long r2, long r4, int r6) {
                this.f1923i = r1;
                this.f1920f = r2;
                this.f1921g = r4;
                this.f1922h = r6;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f1920f == 0) goto L5;
                return;
            L5:
                if (e.h() != null) goto L7;
            L9:
                Iterator r0 = e.j(this.f1923i.f1919b).iterator();
            L11:
                if (r0.hasNext() == false) goto L16;
                ((com.bytedance.apm.r.a) r0.next()).g(this.f1923i.f1918a, this.f1921g, this.f1922h);
                goto L11
            L16:
                return;
            L7:
                if (this.f1923i.f1919b.v == false) goto L9;
                e.h().g(this.f1923i.f1918a, this.f1921g, this.f1922h);
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ FrameMetrics f1924f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ int f1925g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ f f1926h;

            b(f r1, FrameMetrics r2, int r3) {
                this.f1926h = r1;
                this.f1924f = r2;
                this.f1925g = r3;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f1924f.getMetric(9) == 0) goto L5;
                return;
            L5:
                if (e.h() != null) goto L7;
            L9:
                Iterator r0 = e.j(this.f1926h.f1919b).iterator();
            L11:
                if (r0.hasNext() == false) goto L16;
                ((com.bytedance.apm.r.a) r0.next()).h(this.f1926h.f1918a, this.f1924f, this.f1925g);
                goto L11
            L16:
                return;
            L7:
                if (this.f1926h.f1919b.v == false) goto L9;
                e.h().h(this.f1926h.f1918a, this.f1924f, this.f1925g);
            }
        }

        f(e r1, String r2) {
            this.f1919b = r1;
            this.f1918a = r2;
        }

        @Override // android.view.Window.OnFrameMetricsAvailableListener
        public void onFrameMetricsAvailable(Window r12, FrameMetrics r13, int r14) {
            if (e.g(this.f1919b) == false) goto L5;
            long r8 = (((((r13.getMetric(0) + r13.getMetric(1)) + r13.getMetric(2)) + r13.getMetric(3)) + r13.getMetric(4)) + r13.getMetric(5)) / TimeUtils.NANOSECONDS_PER_MILLISECOND;
            long r6 = r13.getMetric(9);
            this.f1919b.o.b(new a(this, r6, r8, r14));
            return;
        L5:
            FrameMetrics r15 = new FrameMetrics(r13);
            this.f1919b.o.b(new b(this, r15, r14));
        }
    }

    static {
        w = new e();
    }

    private e() {
        this.f1891b = new com.bytedance.apm.r.m.d();
        this.f1892c = new long[4];
        this.f1893d = new CopyOnWriteArrayList();
        this.f1894e = false;
        this.f1895f = false;
        this.f1896g = false;
        this.f1897h = false;
        this.n = false;
        this.o = new com.bytedance.apm.f0.d("looper_monitor");
        this.q = new com.bytedance.apm.f0.e("looper_monitor");
        this.r = new HashMap();
        this.s = -1;
    }

    public static e A() {
        return w;
    }

    private boolean F() {
        if (this.f1895f == true) goto L5;
    L7:
        return false;
    L5:
        if (Build.VERSION.SDK_INT >= 24) goto L7;
        return true;
    }

    private Method I(Object r1, String r2, Class<?>... r3) {
        Method r0 = r1.getClass().getDeclaredMethod(r2, r3);     // Catch: Exception -> L4
        r0.setAccessible(true);     // Catch: Exception -> L4
        return r0;
    L4:
        return null;
    }

    public static Method J(Class r7, String r8, Class<?>... r9) {
        Method r10 = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r7, new Object[]{r8, r9});     // Catch: Exception -> L4
        r10.setAccessible(true);     // Catch: Exception -> L4
        return r10;
    L4:
        return null;
    }

    private <T> T K(Object r6, String r7) {
        Field r5 = (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(r6.getClass(), new Object[]{r7});     // Catch: Exception -> L4
        r5.setAccessible(true);     // Catch: Exception -> L4
        return (T) r5.get(r6);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private <T> T L(Object r1, String r2) {
        Field r0 = r1.getClass().getDeclaredField(r2);     // Catch: Exception -> L4
        r0.setAccessible(true);     // Catch: Exception -> L4
        return (T) r0.get(r1);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    static /* synthetic */ boolean a(e r0) {
        return r0.f1890a;
    }

    static /* synthetic */ void b(e r0, String r1) {
        r0.v(r1);
    }

    static /* synthetic */ Method c(e r0, Method r1) {
        r0.f1901l = r1;
        return r1;
    }

    static /* synthetic */ Method d(e r0, Object r1, String r2, Class[] r3) {
        return r0.I(r1, r2, r3);
    }

    static /* synthetic */ void e(e r0, Runnable r1) {
        r0.t(r1);
    }

    static /* synthetic */ boolean f(e r0) {
        return r0.f1897h;
    }

    static /* synthetic */ boolean g(e r0) {
        return r0.u;
    }

    static /* synthetic */ com.bytedance.apm.r.a h() {
        return y;
    }

    static /* synthetic */ void i(e r0) {
        r0.w();
    }

    static /* synthetic */ List j(e r0) {
        return r0.f1893d;
    }

    static /* synthetic */ Object k(e r0) {
        return r0.f1898i;
    }

    static /* synthetic */ Object l(e r0, Object r1) {
        r0.f1898i = r1;
        return r1;
    }

    static /* synthetic */ Choreographer m(e r0) {
        return r0.m;
    }

    static /* synthetic */ Object n(e r0, Object r1, String r2) {
        return r0.L(r1, r2);
    }

    static /* synthetic */ Object o(e r0, Object r1, String r2) {
        return r0.K(r1, r2);
    }

    static /* synthetic */ Object[] p(e r0) {
        return r0.f1899j;
    }

    static /* synthetic */ Object[] q(e r0, Object[] r1) {
        r0.f1899j = r1;
        return r1;
    }

    static /* synthetic */ long[] r(e r0) {
        return r0.f1900k;
    }

    static /* synthetic */ long[] s(e r0, long[] r1) {
        r0.f1900k = r1;
        return r1;
    }

    private synchronized void t(Runnable r8) {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        if (this.f1890a == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.n == false) goto L31;
        monitor-exit(this);
        return;
    L31:
        Object r0 = this.f1898i;     // Catch: Exception -> L26 Throwable -> L23
        monitor-enter(r0);     // Catch: Exception -> L26 Throwable -> L23
        Method r1 = this.f1901l;     // Catch: Throwable -> L18
        if (r1 == null) goto L16;
        r1.invoke(this.f1899j[0], new Object[]{-1L, r8, null});     // Catch: Throwable -> L18
        this.n = true;     // Catch: Throwable -> L18
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;     // Catch: Exception -> L26 Throwable -> L23
    L21:
        monitor-exit(this);
    }

    private void v(String r6) {
        this.f1897h = true;
        long[] r0 = this.f1892c;
        int r3 = 0;
        r0[0] = com.bytedance.monitor.collector.a.f5105b;
        r0[2] = com.bytedance.monitor.collector.a.f5106c;
        List<com.bytedance.apm.r.a> r5 = this.f1893d;
        int r1 = r5.size();
    L3:
        if (r3 >= r1) goto L8;
        com.bytedance.apm.r.a r2 = r5.get(r3);
        if (r2.f() == true) goto L7;
        r2.c(r6);
    L7:
        r3 = r3 + 1;
        goto L3
    }

    private void w() {
        boolean r14 = this.f1896g;
        if (F() == true) goto L5;
    L15:
        long[] r0 = this.f1892c;
        r0[1] = com.bytedance.monitor.collector.a.f5105b;
        r0[3] = com.bytedance.monitor.collector.a.f5106c;
        List<com.bytedance.apm.r.a> r1 = this.f1893d;
        int r2 = r1.size();
        int r5 = 0;
    L16:
        if (r5 >= r2) goto L22;
        com.bytedance.apm.r.a r7 = r1.get(r5);
        if (r7.f() == false) goto L20;
        long[] r8 = this.f1892c;
        boolean r19 = r14;
        r7.d(r8[0], r8[2], r8[1], r8[3], r19);
    L21:
        r5 = r5 + 1;
        r14 = r19;
        goto L16
    L20:
        r19 = r14;
        goto L21
    L22:
        this.f1891b.c();
        this.f1897h = false;
        return;
    L5:
        if (this.f1896g == false) goto L15;
        y();
        long r4 = com.bytedance.monitor.collector.a.f5105b;
        long r3 = this.s;
        if (this.f1900k == null) goto L13;
        if (k.n().m() == null) goto L11;
        k.n().m().a(this.f1900k);
    L11:
        com.bytedance.apm.r.m.c.c().b(this.f1900k, r4);
    L13:
        if (Build.VERSION.SDK_INT >= 24) goto L15;
        this.o.b(new b(this, r3, r4));
        goto L15
    }

    private void x() {
        this.f1896g = true;
    }

    private void y() {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        t(this.p);
    L5:
        this.f1896g = false;
    }

    public int B() {
        int r0 = this.f1893d.size();
        boolean r1 = com.bytedance.apm.d0.c.e("block_monitor");
        if (D() == false) goto L7;
        if (r1 == false) goto L6;
        return r0;
    L6:
        return r0 - 1;
    L7:
        return r0;
    }

    @TargetApi(16)
    public void C() {
        if (this.t == false) goto L6;
        return;
    L6:
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) goto L10;
        ActivityLifeObserver.getInstance().register(this);
        com.bytedance.monitor.collector.h.h();
        com.bytedance.monitor.collector.h.l(new a(this));
        this.t = true;
        return;
    L10:
        throw new AssertionError("must be init in main thread!");
    }

    public boolean D() {
        return x;
    }

    public boolean E() {
        return this.v;
    }

    public synchronized void G() {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        if (com.bytedance.apm.d.H() == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.t == false) goto L20;
        if (this.f1890a == true) goto L13;
        this.f1890a = true;     // Catch: Throwable -> L21
    L13:
        if (F() == true) goto L15;
    L17:
        monitor-exit(this);
        return;
    L15:
        if (Build.VERSION.SDK_INT < 16) goto L17;
        t(this.p);     // Catch: Throwable -> L21
        goto L17
    L20:
        throw new RuntimeException("never init!");     // Catch: Throwable -> L21
    }

    public synchronized void H() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (com.bytedance.apm.d.G() == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.t == false) goto L15;
        if (this.f1890a == false) goto L12;
        this.f1890a = false;     // Catch: Throwable -> L16
    L12:
        monitor-exit(this);
        return;
    L15:
        throw new RuntimeException("MainThreadMonitor is never init!");     // Catch: Throwable -> L16
    }

    public void M(com.bytedance.apm.r.a r2) {
        this.f1893d.remove(r2);
        if (this.v == false) goto L10;
        if (B() == 0) goto L7;
        return;
    L7:
        if (com.bytedance.monitor.collector.h.g() != 0) goto L14;
        com.bytedance.monitor.collector.h.a();
        return;
    L14:
        return;
    L10:
        if (this.f1893d.isEmpty() == false) goto L16;
        H();
        return;
    }

    public void N() {
        x = true;
    }

    public void O(boolean r1) {
        this.u = r1;
    }

    public void P(boolean r1) {
        this.v = r1;
    }

    public void Q(boolean r1) {
        this.f1894e = r1;
    }

    public void R(com.bytedance.apm.r.a r1) {
        y = r1;
    }

    public void S(boolean r1) {
        this.f1895f = r1;
    }

    public void T() {
        this.o.c();
        this.q.k();
    }

    @Override // com.bytedance.apm.core.c
    public void onActivityCreated(Activity r4, Bundle r5) {
        Window r6 = r4.getWindow();     // Catch: Exception -> L14
        int r0 = Build.VERSION.SDK_INT;     // Catch: Exception -> L14
        if (r0 < 23) goto L5;
        r6.setCallback(new d(this, r6.getCallback()));     // Catch: Exception -> L14
    L5:
        String r1 = r4.getClass().getName();     // Catch: Exception -> L14
        String r7 = r4.toString();     // Catch: Exception -> L14
        com.bytedance.monitor.collector.h.c();     // Catch: Exception -> L14
        if (this.f1894e == false) goto L9;
        return;
    L9:
        if (r0 >= 24) goto L11;
        return;
    L11:
        if (this.q.e() == false) goto L18;
        WindowOnFrameMetricsAvailableListenerC0060e r2 = new WindowOnFrameMetricsAvailableListenerC0060e(this, r1);     // Catch: Exception -> L14
        this.r.put(r7, r2);     // Catch: Exception -> L14
        r6.addOnFrameMetricsAvailableListener(r2, this.q.f1526d);     // Catch: Exception -> L14
        return;
    L18:
        return;
    }

    @Override // com.bytedance.apm.core.c
    public void onActivityDestroyed(Activity r3) {
        if (Build.VERSION.SDK_INT < 24) goto L11;
        Window.OnFrameMetricsAvailableListener r2 = this.r.remove(r3.toString());     // Catch: Exception -> L8
        if (r2 == null) goto L12;
        r3.getWindow().removeOnFrameMetricsAvailableListener(r2);     // Catch: Exception -> L8
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.apm.core.c
    public void onActivityResumed(Activity r4) {
        if (this.f1894e == true) goto L17;
        return;
    L17:
        if (Build.VERSION.SDK_INT < 24) goto L19;
        Window r0 = r4.getWindow();     // Catch: Exception -> L16
        String r1 = r4.getClass().getName();     // Catch: Exception -> L16
        String r5 = r4.toString();     // Catch: Exception -> L16
        HashMap<String, Window.OnFrameMetricsAvailableListener> r2 = this.r;     // Catch: Exception -> L16
        if (r2 == null) goto L13;
        if (r2.containsKey(r5) == false) goto L13;
        return;
    L13:
        if (this.q.e() == false) goto L20;
        f r3 = new f(this, r1);     // Catch: Exception -> L16
        this.r.put(r5, r3);     // Catch: Exception -> L16
        r0.addOnFrameMetricsAvailableListener(r3, this.q.f1526d);     // Catch: Exception -> L16
        return;
    L20:
        return;
    L19:
        return;
    }

    @Override // com.bytedance.apm.core.c
    public void onBackground(Activity r1) {
    }

    @Override // com.bytedance.apm.core.c
    public void onFront(Activity r2) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return;
    L5:
        if (this.m == null) goto L8;
        return;
    L8:
        if (F() == false) goto L16;
        this.m = Choreographer.getInstance();     // Catch: Exception -> L12
    L10:
        com.bytedance.apm.f0.b.f().i(new c(this));
        return;
    }

    public void u(com.bytedance.apm.r.a r2) {
        if (this.f1890a == true) goto L6;
        G();
    L6:
        if (this.f1893d.contains(r2) == true) goto L11;
        this.f1893d.add(r2);
        if (this.v == false) goto L12;
        com.bytedance.monitor.collector.h.n();
        return;
    L12:
        return;
    }

    public void z() {
        int r1 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L17
        if (r1 <= 22) goto L13;
        long[] r2 = this.f1900k;     // Catch: Throwable -> L17
        if (r2 != null) goto L10;
        long r3 = com.bytedance.monitor.collector.a.f5105b;     // Catch: Throwable -> L17
    L8:
        this.s = r3;     // Catch: Throwable -> L17
        x();     // Catch: Throwable -> L17
        this.n = false;
        return;
    L10:
        if (r1 < 31) goto L12;
        r3 = r2[2] / TimeUtils.NANOSECONDS_PER_MILLISECOND;     // Catch: Throwable -> L17
        goto L8
    L12:
        r3 = r2[1] / TimeUtils.NANOSECONDS_PER_MILLISECOND;     // Catch: Throwable -> L17
        goto L8
    L13:
        r3 = com.bytedance.monitor.collector.a.f5105b;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        this.n = false;
        throw th;
    }
}
