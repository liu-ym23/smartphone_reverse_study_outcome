package d.g.a.a;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.lego.init.IdleTaskConfig;
import com.obric.android.alog.Alog;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f16654a = 3;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static d.g.a.a.b f16655b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f16656c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile Set<String> f16657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile d.g.a.a.c f16658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile List<d.g.a.a.d> f16659f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static ScheduledExecutorService f16660g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Alog f16661h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static ExecutorService f16662i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static HandlerThread f16663j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Handler f16664k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static boolean f16665l;
    private static Object m;
    private static final ThreadLocal<Long> n = null;

    /* JADX INFO: renamed from: d.g.a.a.a$a, reason: collision with other inner class name */
    class RunnableC0438a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f16666f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d.g.a.a.i.b.a f16667g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Throwable f16668h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f16669i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ Object f16670j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ String f16671k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ long f16672l;
        final /* synthetic */ long m;

        RunnableC0438a(int r1, d.g.a.a.i.b.a r2, Throwable r3, String r4, Object r5, String r6, long r7, long r9) {
            this.f16666f = r1;
            this.f16667g = r2;
            this.f16668h = r3;
            this.f16669i = r4;
            this.f16670j = r5;
            this.f16671k = r6;
            this.f16672l = r7;
            this.m = r9;
        }

        @Override // java.lang.Runnable
        public void run() {
            int r1 = a.e(this.f16666f);
            d.g.a.a.i.b.a r0 = this.f16667g;
            if (r0 == null) goto L5;
            d.g.a.a.i.b.a r2 = d.g.a.a.i.b.a.f16729k;
            if (r0 != r2) goto L15;
        L14:
            d.g.a.a.i.b.c(r2, this.f16669i);
        L33:
            com.obric.android.alog.c.g(r1, this.f16671k, this.f16669i, this.f16672l, this.m);
            return;
        L15:
            r2 = d.g.a.a.i.b.a.f16725g;
            if (r0 == r2) goto L14;
            d.g.a.a.i.b.a r3 = d.g.a.a.i.b.a.f16726h;
            if (r0 != r3) goto L21;
            d.g.a.a.i.b.b(r3, (Bundle) this.f16670j);
            goto L33
        L21:
            d.g.a.a.i.b.a r4 = d.g.a.a.i.b.a.f16727i;
            if (r0 != r4) goto L24;
            d.g.a.a.i.b.a(r4, (Intent) this.f16670j);
            goto L33
        L24:
            d.g.a.a.i.b.a r5 = d.g.a.a.i.b.a.f16728j;
            if (r0 != r5) goto L27;
            d.g.a.a.i.b.e(r5, (Throwable) this.f16670j);
            goto L33
        L27:
            d.g.a.a.i.b.a r6 = d.g.a.a.i.b.a.m;
            if (r0 != r6) goto L30;
            d.g.a.a.i.b.d(r6, (Thread) this.f16670j);
            goto L33
        L30:
            d.g.a.a.i.b.a r7 = d.g.a.a.i.b.a.f16730l;
            if (r0 != r7) goto L33;
            d.g.a.a.i.b.f(r7, (StackTraceElement[]) this.f16670j);
            goto L33
        L5:
            if (this.f16668h == null) goto L33;
            if (this.f16669i != null) goto L10;
            String r8 = "";
        L11:
            String r9 = r8 + d.g.a.a.i.d.a(this.f16668h);
            goto L33
        L10:
            r8 = this.f16669i + "\n";
            goto L11
        }
    }

    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f16673a = null;

        static {
            int[] r0 = new int[d.g.a.a.i.b.a.values().length];
            f16673a = r0;
            r0[d.g.a.a.i.b.a.f16724f.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            f16673a[d.g.a.a.i.b.a.n.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            f16673a[d.g.a.a.i.b.a.f16729k.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            f16673a[d.g.a.a.i.b.a.f16725g.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            f16673a[d.g.a.a.i.b.a.f16726h.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            f16673a[d.g.a.a.i.b.a.f16727i.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            f16673a[d.g.a.a.i.b.a.f16728j.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            f16673a[d.g.a.a.i.b.a.m.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            f16673a[d.g.a.a.i.b.a.f16730l.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    class c extends ThreadLocal<Long> {
        c() {
        }

        protected Long a() {
            return Long.valueOf(Process.myTid());
        }

        @Override // java.lang.ThreadLocal
        protected /* bridge */ /* synthetic */ Long initialValue() {
            return a();
        }
    }

    class d implements ThreadFactory {
        d() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r1) {
            Thread r0 = new Thread(r1);
            r0.setName("Alog_newthreadpoolimpl");
            return r0;
        }
    }

    class e extends Handler {
        e(Looper r1) {
            super(r1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r2) {
            int r1 = r2.what;
            if (r1 != 1) goto L5;
            Object r3 = r2.obj;
            if (r3 != null) goto L11;
            return;
        L11:
            if ((r3 instanceof k) == false) goto L16;
            a.a((k) r3);
            return;
        L16:
            return;
        L5:
            if (r1 != 2) goto L17;
            com.obric.android.alog.c.a();
            return;
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Queue f16674f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f16675g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f16676h;

        f(Queue r1, String r2, String r3) {
            this.f16674f = r1;
            this.f16675g = r2;
            this.f16676h = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Queue r0 = this.f16674f;
            if (r0 == null) goto L5;
            a.b(r0);
            a.c().a();
        L5:
            Iterator<d.g.a.a.d> r1 = a.j().iterator();
        L7:
            if (r1.hasNext() == false) goto L16;
            d.g.a.a.d r2 = r1.next();
            if (r2 == null) goto L7;
            r2.a(com.obric.android.alog.c.b());
            goto L7
        L16:
            Thread.sleep(IdleTaskConfig.IDLE_START_TIME_OUT);     // Catch: Exception -> L15
        L13:
            a.d(this.f16675g, this.f16676h);
        }
    }

    class g extends TimerTask {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f16677f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f16678g;

        g(String r1, String r2) {
            this.f16677f = r1;
            this.f16678g = r2;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            a.d(this.f16677f, this.f16678g);
        }
    }

    class h implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f16679f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f16680g;

        h(String r1, String r2) {
            this.f16679f = r1;
            this.f16680g = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.d(this.f16679f, this.f16680g);
        }
    }

    class i implements FilenameFilter {
        i() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File r1, String r2) {
            return r2.startsWith(".logCache_");
        }
    }

    class j implements FilenameFilter {
        j() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File r1, String r2) {
            if (r2.endsWith(".hoting") == false) goto L6;
            return true;
        L6:
            if (r2.endsWith(".hot") == true) goto L8;
            return false;
        L8:
            if (r2.endsWith(".alog.hot") == true) goto L12;
            return true;
        L12:
            return false;
        }
    }

    private static class k {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final Object f16681j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static k f16682k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static int f16683l;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f16684a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f16685b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f16686c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Throwable f16687d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public d.g.a.a.i.b.a f16688e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Object f16689f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f16690g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f16691h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public k f16692i;

        static {
            f16681j = new Object();
        }

        private k() {
            this.f16688e = null;
        }

        public static k a() {
            Object r0 = f16681j;
            monitor-enter(r0);
            k r1 = f16682k;     // Catch: Throwable -> L12
            if (r1 == null) goto L9;
            f16682k = r1.f16692i;     // Catch: Throwable -> L12
            r1.f16692i = null;     // Catch: Throwable -> L12
            f16683l--;     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return new k();
        L12:
            th = move-exception;
            throw th;
        }

        public void b() {
            this.f16685b = null;
            this.f16686c = null;
            this.f16687d = null;
            this.f16688e = null;
            this.f16689f = null;
            this.f16690g = -1;
            this.f16691h = 0;
            this.f16692i = null;
            Object r0 = f16681j;
            monitor-enter(r0);
            int r1 = f16683l;     // Catch: Throwable -> L9
            if (r1 >= 50) goto L7;
            this.f16692i = f16682k;     // Catch: Throwable -> L9
            f16682k = this;     // Catch: Throwable -> L9
            f16683l = r1 + 1;     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    static {
        f16659f = new ArrayList();
        f16660g = null;
        f16661h = null;
        new ArrayList();
        f16662i = null;
        f16665l = false;
        m = new Object();
        n = new c();
    }

    public a() {
    }

    static /* synthetic */ void a(k r0) {
        l(r0);
    }

    static /* synthetic */ void b(Queue r0) {
        v(r0);
    }

    static /* synthetic */ d.g.a.a.c c() {
        return f16658e;
    }

    static /* synthetic */ void d(String r0, String r1) {
        u(r0, r1);
    }

    static /* synthetic */ int e(int r0) {
        return p(r0);
    }

    public static void f(int r1) {
        f16654a = r1;
        com.obric.android.alog.c.i(p(r1));
        Alog r0 = f16661h;
        if (r0 == null) goto L6;
        r0.p(p(r1));
        return;
    }

    public static boolean g(int r2, String r3) {
        if (r2 >= f16654a) goto L5;
        return false;
    L5:
        Set<String> r4 = f16657d;
        if (r4 != null) goto L8;
        return true;
    L8:
        if (TextUtils.isEmpty(r3) == false) goto L10;
        return true;
    L10:
        if (r4.contains(r3) == false) goto L15;
        return false;
    L15:
        return true;
    }

    public static void h(String r3, String r4) {
        if (g(3, r3) == false) goto L37;
        d.g.a.a.b r1 = f16655b;
        if (r1 != null) goto L7;
    L12:
        d.g.a.a.b r2 = f16655b;
        if (r2 != null) goto L15;
    L20:
        boolean r5 = d.g.a.a.g.c();
        if (r5 == true) goto L23;
    L26:
        if (r5 == true) goto L28;
    L31:
        Alog r0 = f16661h;
        if (r0 == null) goto L35;
        if (r5 == false) goto L35;
        r0.j(r3, r4);
        return;
    L35:
        com.obric.android.alog.c.c(r3, r4);
        return;
    L28:
        if (f16664k == null) goto L31;
        q(3, r3, r4);
        return;
    L23:
        if (f16662i == null) goto L26;
        s(3, r3, r4);
        return;
    L15:
        if (r2.b() == false) goto L20;
        if (f16664k == null) goto L20;
        q(3, r3, r4);
        return;
    L7:
        if (r1.b() == false) goto L12;
        if (f16662i == null) goto L12;
        s(3, r3, r4);
        return;
    }

    public static void i(String r3, String r4) {
        if (g(6, r3) == false) goto L37;
        d.g.a.a.b r1 = f16655b;
        if (r1 != null) goto L7;
    L12:
        d.g.a.a.b r2 = f16655b;
        if (r2 != null) goto L15;
    L20:
        boolean r5 = d.g.a.a.g.c();
        if (r5 == true) goto L23;
    L26:
        if (r5 == true) goto L28;
    L31:
        Alog r0 = f16661h;
        if (r0 == null) goto L35;
        if (r5 == false) goto L35;
        r0.k(r3, r4);
        return;
    L35:
        com.obric.android.alog.c.d(r3, r4);
        return;
    L28:
        if (f16664k == null) goto L31;
        q(6, r3, r4);
        return;
    L23:
        if (f16662i == null) goto L26;
        s(6, r3, r4);
        return;
    L15:
        if (r2.b() == false) goto L20;
        if (f16664k == null) goto L20;
        q(6, r3, r4);
        return;
    L7:
        if (r1.b() == false) goto L12;
        if (f16662i == null) goto L12;
        s(6, r3, r4);
        return;
    }

    public static List<d.g.a.a.d> j() {
        return f16659f;
    }

    private static long k() {
        return n.get().longValue();
    }

    private static void l(k r8) {
        int r1 = p(r8.f16684a);
        d.g.a.a.i.b.a r0 = r8.f16688e;
        String r2 = "";
        if (r0 == null) goto L5;
        d.g.a.a.i.b.a r3 = d.g.a.a.i.b.a.f16729k;
        if (r0 != r3) goto L16;
    L14:
        String r4 = d.g.a.a.i.b.c(r3, r8.f16686c);
    L15:
        String r5 = r4;
    L35:
        com.obric.android.alog.c.g(r1, r8.f16685b, r5, r8.f16690g, r8.f16691h);
        r8.b();
        return;
    L16:
        r3 = d.g.a.a.i.b.a.f16725g;
        if (r0 == r3) goto L14;
        d.g.a.a.i.b.a r6 = d.g.a.a.i.b.a.f16726h;
        if (r0 != r6) goto L22;
        r4 = d.g.a.a.i.b.b(r6, (Bundle) r8.f16689f);
        goto L15
    L22:
        d.g.a.a.i.b.a r7 = d.g.a.a.i.b.a.f16727i;
        if (r0 != r7) goto L25;
        r4 = d.g.a.a.i.b.a(r7, (Intent) r8.f16689f);
        goto L15
    L25:
        d.g.a.a.i.b.a r9 = d.g.a.a.i.b.a.f16728j;
        if (r0 != r9) goto L28;
        r4 = d.g.a.a.i.b.e(r9, (Throwable) r8.f16689f);
        goto L15
    L28:
        d.g.a.a.i.b.a r10 = d.g.a.a.i.b.a.m;
        if (r0 != r10) goto L31;
        r4 = d.g.a.a.i.b.d(r10, (Thread) r8.f16689f);
        goto L15
    L31:
        d.g.a.a.i.b.a r11 = d.g.a.a.i.b.a.f16730l;
        if (r0 != r11) goto L34;
        r4 = d.g.a.a.i.b.f(r11, (StackTraceElement[]) r8.f16689f);
        goto L15
    L34:
        r5 = "";
        goto L35
    L5:
        if (r8.f16687d != null) goto L8;
        r4 = r8.f16686c;
        goto L15
    L8:
        if (r8.f16686c == null) goto L11;
        r2 = r8.f16686c + "\n";
    L11:
        r4 = r2 + d.g.a.a.i.d.a(r8.f16687d);
        goto L15
    }

    private static void m(d.g.a.a.f r2) {
        switch(b.f16673a[r2.f16720d.ordinal()]) {
            case 1: goto L15;
            case 2: goto L12;
            case 3: goto L10;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L4;
        };
    L4:
        String r0 = "";
    L16:
        r2.f16719c = r0;
        return;
    L5:
        r0 = d.g.a.a.i.b.f(r2.f16720d, (StackTraceElement[]) r2.f16721e);
        goto L16
    L6:
        r0 = d.g.a.a.i.b.d(r2.f16720d, (Thread) r2.f16721e);
        goto L16
    L7:
        r0 = d.g.a.a.i.b.e(r2.f16720d, (Throwable) r2.f16721e);
        goto L16
    L8:
        r0 = d.g.a.a.i.b.a(r2.f16720d, (Intent) r2.f16721e);
        goto L16
    L9:
        r0 = d.g.a.a.i.b.b(r2.f16720d, (Bundle) r2.f16721e);
        goto L16
    L10:
        r0 = d.g.a.a.i.b.c(r2.f16720d, (String) r2.f16721e);
        goto L16
    L15:
        r0 = (String) r2.f16721e;
        goto L16
    L12:
        if (r2.f16722f != null) goto L14;
        r0 = d.g.a.a.i.d.a((Throwable) r2.f16721e);
        goto L16
    L14:
        r0 = r2.f16722f + d.g.a.a.i.d.a((Throwable) r2.f16721e);
        goto L16
    }

    public static void n(String r3, String r4) {
        if (g(4, r3) == false) goto L37;
        d.g.a.a.b r1 = f16655b;
        if (r1 != null) goto L7;
    L12:
        d.g.a.a.b r2 = f16655b;
        if (r2 != null) goto L15;
    L20:
        boolean r5 = d.g.a.a.g.c();
        if (r5 == true) goto L23;
    L26:
        if (r5 == true) goto L28;
    L31:
        Alog r0 = f16661h;
        if (r0 == null) goto L35;
        if (r5 == false) goto L35;
        r0.n(r3, r4);
        return;
    L35:
        com.obric.android.alog.c.e(r3, r4);
        return;
    L28:
        if (f16664k == null) goto L31;
        q(4, r3, r4);
        return;
    L23:
        if (f16662i == null) goto L26;
        s(4, r3, r4);
        return;
    L15:
        if (r2.b() == false) goto L20;
        if (f16664k == null) goto L20;
        q(4, r3, r4);
        return;
    L7:
        if (r1.b() == false) goto L12;
        if (f16662i == null) goto L12;
        s(4, r3, r4);
        return;
    }

    public static boolean o(d.g.a.a.b r13) {
        boolean r0 = false;
        if (r13 != null) goto L5;
        return false;
    L5:
        f16655b = r13;
        Alog.o(new d.g.a.a.e());     // Catch: Throwable -> L94
        Object r1 = m;
        monitor-enter(r1);
    L91:
        th = move-exception;
        throw th;
    L10:
        if (f16665l == false) goto L13;
        monitor-exit(r1);     // Catch: Throwable -> L91
        return false;
    L13:
        f16665l = true;     // Catch: Throwable -> L91
        monitor-exit(r1);     // Catch: Throwable -> L91
        f16654a = r13.f();
        boolean r2 = d.g.a.a.g.b(r13.e());
        boolean r3 = r13.q();
        if (r3 == false) goto L18;
    L21:
        boolean r4 = false;
    L22:
        boolean r5 = r13.a();
        boolean r6 = r13.p();
        if (r2 == true) goto L25;
        r13.C((int) (r13.i() * r13.l()));
    L25:
        Alog.b r7 = new Alog.b(r13.e());
        r7.g("default");
        r7.h(p(r13.f()));
        r7.q(f16656c);
        r7.i(r13.g());
        r7.k(r13.j());
        int r8 = r13.i();
        if (r4 == false) goto L28;
        r8 = (r8 / 3) * 2;
    L28:
        r7.l(r8);
        r7.j(r13.h());
        r7.c(r13.c());
        if (r2 == false) goto L31;
        int r9 = r13.d() * 1024;
    L32:
        r7.d(r9);
        if (r2 == false) goto L35;
        int r10 = (r13.d() * 3) * 1024;
    L36:
        r7.e(r10);
        Alog.d r11 = Alog.d.f8065h;
        r7.m(r11);
        Alog.g r12 = Alog.g.f8078g;
        r7.r(r12);
        Alog.e r14 = Alog.e.f8069h;
        r7.n(r14);
        if (r13.m() == false) goto L39;
        Alog.c r15 = Alog.c.f8061i;
    L40:
        r7.f(r15);
        if (r13.n() == false) goto L43;
        Alog.f r16 = Alog.f.f8073h;
    L44:
        r7.p(r16);
        if (r13.n() == false) goto L47;
        Alog.a r17 = Alog.a.f8043h;
    L48:
        r7.b(r17);
        r7.o(r13.k());
        com.obric.android.alog.c.h(r7.a());
        if (r3 == false) goto L55;
        if (r5 == true) goto L52;
        if (r2 == false) goto L55;
    L52:
        if (r6 == false) goto L54;
        f16662i = Executors.newSingleThreadExecutor(new d());
        goto L55
    L54:
        HandlerThread r18 = new HandlerThread("Alog_main_delegate");
        f16663j = r18;
        r18.start();
        f16664k = new e(f16663j.getLooper());
    L55:
        if (r4 == false) goto L69;
        Alog.b r19 = new Alog.b(r13.e());
        r19.g("main");
        r19.h(p(r13.f()));
        r19.q(f16656c);
        r19.i(r13.g());
        r19.k(r13.j() / 2);
        r19.l(r13.i() / 3);
        r19.j(r13.h());
        r19.c(r13.c());
        r19.d(32768);
        r19.e(98304);
        r19.m(r11);
        r19.r(r12);
        r19.n(r14);
        if (r13.m() == false) goto L59;
        Alog.c r20 = Alog.c.f8061i;
    L60:
        r19.f(r20);
        if (r13.n() == false) goto L63;
        Alog.f r21 = Alog.f.f8073h;
    L64:
        r19.p(r21);
        if (r13.n() == false) goto L67;
        Alog.a r22 = Alog.a.f8043h;
    L68:
        r19.b(r22);
        r19.o(r13.k());
        f16661h = r19.a();
        goto L69
    L67:
        r22 = Alog.a.f8042g;
        goto L68
    L63:
        r21 = Alog.f.f8072g;
        goto L64
    L59:
        r20 = Alog.c.f8059g;
    L69:
        String r23 = r13.c();
        String r110 = r13.g();
        Queue<d.g.a.a.f> r24 = null;
        if (f16658e == null) goto L77;
        Queue<d.g.a.a.f> r25 = f16658e.b();
        if (r25 != null) goto L74;
    L76:
        r24 = r25;
        goto L77
    L74:
        if (r25.size() != 0) goto L76;
    L77:
        if (r24 == null) goto L79;
    L80:
        f r26 = new f(r24, r23, r110);
        ScheduledExecutorService r27 = f16660g;
        if (r27 != null) goto L83;
        new Thread(r26, "_ALOG_OPT_").start();
    L84:
        r0 = true;
    L85:
        if (r0 == true) goto L90;
        ScheduledExecutorService r28 = f16660g;
        if (r28 != null) goto L89;
        new Timer("_ALOG_OPT_").schedule(new g(r23, r110), IdleTaskConfig.IDLE_START_TIME_OUT);
        goto L90
    L89:
        r28.schedule(new h(r23, r110), 15, TimeUnit.SECONDS);
    L90:
        return true;
    L83:
        r27.execute(r26);
        goto L84
    L79:
        if (j().size() <= 0) goto L85;
    L47:
        r17 = Alog.a.f8042g;
        goto L48
    L43:
        r16 = Alog.f.f8072g;
        goto L44
    L39:
        r15 = Alog.c.f8059g;
        goto L40
    L35:
        r10 = 65536;
        goto L36
    L31:
        r9 = 32768;
        goto L32
    L18:
        if (r13.o() == false) goto L21;
        if (r2 == false) goto L21;
        r4 = true;
    L94:
        return false;
    }

    private static int p(int r0) {
        return r0 - 2;
    }

    private static void q(int r6, String r7, String r8) {
        r(r6, r7, r8, null, null, null);
    }

    private static void r(int r1, String r2, String r3, Throwable r4, d.g.a.a.i.b.a r5, Object r6) {
        k r0 = k.a();
        r0.f16684a = r1;
        r0.f16685b = r2;
        r0.f16686c = r3;
        r0.f16687d = r4;
        r0.f16688e = r5;
        r0.f16689f = r6;
        r0.f16690g = k();
        r0.f16691h = System.currentTimeMillis();
        Message r7 = Message.obtain();
        r7.what = 1;
        r7.obj = r0;
        f16664k.sendMessage(r7);
    }

    private static void s(int r6, String r7, String r8) {
        t(r6, r7, r8, null, null, null);
    }

    private static void t(int r13, String r14, String r15, Throwable r16, d.g.a.a.i.b.a r17, Object r18) {
        long r7 = k();
        long r9 = System.currentTimeMillis();
        f16662i.execute(new RunnableC0438a(r13, r17, r16, r15, r18, r14, r7, r9));
    }

    private static void u(String r4, String r5) {
        File r0 = new File(r4);
        int r1 = 0;
        if (r0.exists() == false) goto L9;
        File[] r6 = r0.listFiles(new i());
        if (r6 == null) goto L9;
        int r2 = r6.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L9;
        r6[r3].delete();
        r3 = r3 + 1;
    L9:
        File r7 = new File(r5);
        if (r7.exists() == false) goto L16;
        File[] r8 = r7.listFiles(new j());
        if (r8 == null) goto L19;
        int r9 = r8.length;
    L14:
        if (r1 >= r9) goto L20;
        r8[r1].delete();
        r1 = r1 + 1;
        goto L14
    L20:
        return;
    L19:
        return;
    }

    private static void v(Queue<d.g.a.a.f> r3) {
        Iterator<d.g.a.a.f> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        d.g.a.a.f r0 = r4.next();
        if (g(r0.f16717a, r0.f16718b) == false) goto L4;
        m(r0);
        com.obric.android.alog.c.f(p(r0.f16717a), r0.f16718b, r0.f16719c);
        goto L4
    }
}
