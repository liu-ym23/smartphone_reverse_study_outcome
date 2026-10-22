package tmsdkobf;

import android.content.Context;
import android.os.Debug;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import tmsdk.common.creator.BaseManagerC;

/* JADX INFO: loaded from: classes5.dex */
public class o2 extends BaseManagerC implements n2.a {
    private static ArrayList q;
    private static long r;
    private static long s;
    private static e7 t;
    private ArrayList b;
    private final ReentrantReadWriteLock c;
    private final ReentrantReadWriteLock d;
    protected PriorityBlockingQueue e;
    protected LinkedList f;
    protected ArrayList g;
    protected HashMap h;
    private int i;
    protected n2 j;
    private boolean k;
    private HandlerThread l;
    private e m;
    private Object n;
    private volatile boolean o;
    private h5 p;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f381a;
        final /* synthetic */ o2 b;

        a(o2 r1, d r2) {
            this.b = r1;
            this.f381a = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            r8.c("ThreadPool", "add cost before: mThreadPoolExecutor.getCorePoolSize()" + this.b.j.getCorePoolSize());
            if (this.b.j.getCorePoolSize() >= 16) goto L5;
            this.b.j.execute(this.f381a);
            n2 r0 = this.b.j;
            r0.setCorePoolSize(r0.getCorePoolSize() + 1);
            n2 r1 = this.b.j;
            r1.setMaximumPoolSize(r1.getCorePoolSize() + 1);
        L6:
            q8.c("ThreadPool", "add cost after: mThreadPoolExecutor.getCorePoolSize()" + this.b.j.getCorePoolSize());
            Iterator r2 = this.b.h().iterator();
        L8:
            if (r2.hasNext() == false) goto L10;
            ((e7) r2.next()).a(this.f381a.a(), this.b.j.getActiveCount());
            goto L8
        L10:
            return;
        L5:
            d r3 = this.f381a;
            d.m2412$$Nest$fgeta(r3).d = 5;
            this.b.j.execute(r3);
            goto L6
        }
    }

    class b implements e7 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ o2 f382a;

        b(o2 r1) {
            this.f382a = r1;
        }

        @Override // tmsdkobf.e7
        public void a(g7 r2) {
            Iterator r1 = o2.m2409$$Nest$sfgetq().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            ((e7) r1.next()).a(r2);
            goto L4
        }

        @Override // tmsdkobf.e7
        public void b(g7 r2) {
            Iterator r1 = o2.m2409$$Nest$sfgetq().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            ((e7) r1.next()).b(r2);
            goto L4
        }

        @Override // tmsdkobf.e7
        public void a(g7 r2, int r3) {
            Iterator r1 = o2.m2409$$Nest$sfgetq().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            ((e7) r1.next()).a(r2, r3);
            goto L4
        }
    }

    class c implements e7 {
        c() {
        }

        @Override // tmsdkobf.e7
        public void a(g7 r2) {
            Iterator r1 = o2.m2409$$Nest$sfgetq().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            ((e7) r1.next()).a(r2);
            goto L4
        }

        @Override // tmsdkobf.e7
        public void b(g7 r2) {
            Iterator r1 = o2.m2409$$Nest$sfgetq().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            ((e7) r1.next()).b(r2);
            goto L4
        }

        @Override // tmsdkobf.e7
        public void a(g7 r2, int r3) {
            Iterator r1 = o2.m2409$$Nest$sfgetq().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            ((e7) r1.next()).a(r2, r3);
            goto L4
        }
    }

    class d implements Runnable, Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private g7 f383a;
        final /* synthetic */ o2 b;

        /* JADX INFO: renamed from: -$$Nest$fgeta, reason: not valid java name */
        static /* bridge */ /* synthetic */ g7 m2412$$Nest$fgeta(d r0) {
            return r0.f383a;
        }

        public d(o2 r1, int r2, Runnable r3, String r4, long r5, boolean r7, Object r8) {
            this.b = r1;
            this.f383a = new g7();
            if (r4 != null) goto L5;
        L6:
            r4 = r3.getClass().getName();
        L7:
            g7 r0 = this.f383a;
            r0.f214a = 1;
            r0.d = r2;
            r0.c = r4;
            r0.b = r5;
            r0.i = r3;
            r0.h = r7;
            r0.j = r8;
            r0.e = System.currentTimeMillis();
            return;
        L5:
            if (r4.length() != 0) goto L7;
            goto L6
        }

        public int a(d r5) {
            int r0 = (int) (Math.abs(System.currentTimeMillis() - this.f383a.e) / 200);
            int r4 = this.f383a.d;
            if (r0 <= 0) goto L6;
            r4 = r4 + r0;
        L6:
            return r5.f383a.d - r4;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r1) {
            return a((d) r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            g7 r2 = this.f383a;     // Catch: Throwable -> L8
            if (r2 == null) goto L13;
            Runnable r3 = r2.i;     // Catch: Throwable -> L8
            if (r3 == null) goto L14;
            r3.run();     // Catch: Throwable -> L8
            return;
        L14:
            return;
        L13:
            return;
        L8:
            th = move-exception;
            r8.a("ThreadPool", "run (Throwable)", th);
        }

        public g7 a() {
            return this.f383a;
        }
    }

    class e extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ o2 f384a;

        public e(o2 r1, Looper r2) {
            this.f384a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r9) {
            int r10 = r9.what;
            if (r10 != 1) goto L16;
            removeMessages(r10);
            if (o2.m2408$$Nest$mi(this.f384a) == false) goto L13;
            r8.c("ThreadPool", "thread pool is pause");
            long r2 = System.currentTimeMillis();
            if (o2.m2410$$Nest$sfgetr() > 0) goto L10;
        L12:
            sendEmptyMessageDelayed(1, 1000);
            return;
        L10:
            if (Math.abs(o2.m2411$$Nest$sfgets() - r2) <= o2.m2410$$Nest$sfgetr()) goto L12;
            r8.c("ThreadPool", "thread pool is auto wakeup");
            this.f384a.wakeupThreadPool();
            goto L12
        L13:
            o2.m2407$$Nest$mc(this.f384a);
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$mc, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2407$$Nest$mc(o2 r0) {
        r0.c();
    }

    /* JADX INFO: renamed from: -$$Nest$mi, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2408$$Nest$mi(o2 r0) {
        return r0.i();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetq, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m2409$$Nest$sfgetq() {
        return q;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetr, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m2410$$Nest$sfgetr() {
        return r;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgets, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m2411$$Nest$sfgets() {
        return s;
    }

    static {
        q = new ArrayList();
        r = 0;
        s = 0;
        t = new c();
    }

    public o2() {
        this.b = new ArrayList();
        this.c = new ReentrantReadWriteLock();
        this.d = new ReentrantReadWriteLock();
        this.e = new PriorityBlockingQueue(5);
        this.f = new LinkedList();
        this.g = new ArrayList();
        this.h = new HashMap();
        this.j = null;
        this.k = false;
        this.n = new Object();
        this.o = false;
    }

    private void d() {
        int r0 = this.j.getCorePoolSize();
        int r1 = this.i;
        if (r0 >= r1) goto L6;
        this.j.setCorePoolSize(r1);
        this.j.setMaximumPoolSize(this.i);
        return;
    }

    public static e7 e() {
        return t;
    }

    private int f() {
        return g() * 2;
    }

    private int g() {
        int r1 = (Runtime.getRuntime().availableProcessors() * 4) + 2;
        if (r1 > 16) goto L5;
        return r1;
    L5:
        return 16;
    }

    private boolean i() {
        return this.o;
    }

    public void a(Runnable r13, String r14, long r15, boolean r17, Object r18) {
        Object r10 = this.n;
        monitor-enter(r10);
        StringBuilder r1 = new StringBuilder("add costtime task: ").append(r13.getClass().getName()).append(", name: ").append(r14).append(", ident: ").append(r15).append(", isWeak: ").append(r17).append(", owner: ");     // Catch: Throwable -> L11
        if (r18 == null) goto L7;
        String r3 = r18.getClass().getName();     // Catch: Throwable -> L11
    L8:
        r8.c("ThreadPool", r1.append(r3).toString());     // Catch: Throwable -> L11
        d r11 = new d(this, Integer.MAX_VALUE, r13, r14, r15, r17, r18);     // Catch: Throwable -> L11
        this.g.add(r11);     // Catch: Throwable -> L11
        this.m.post(new a(this, r11));     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L7:
        r3 = null;
    L11:
        th = move-exception;
        throw th;
    }

    public void addThreadPoolInfoObserver(e7 r2) {
        Object r1 = this.n;
        monitor-enter(r1);
        q.add(r2);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addThreadPoolStatusObserver(f7 r2) {
        Object r0 = this.n;
        monitor-enter(r0);
        this.b.add(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void b(Runnable r9, String r10, long r11, boolean r13, Object r14) {
        a(5, r9, r10, r11, r13, r14);
    }

    public void c(Runnable r14, String r15, long r16, boolean r18, Object r19) {
        Object r11 = this.n;
        monitor-enter(r11);
        d r12 = new d(this, Integer.MAX_VALUE, r14, r15, r16, r18, r19);     // Catch: Throwable -> L16
        this.g.add(r12);     // Catch: Throwable -> L16
        this.j.execute(r12);     // Catch: Throwable -> L16
        int r1 = this.j.getActiveCount();     // Catch: Throwable -> L16
        int r2 = this.i;     // Catch: Throwable -> L16
        if (r1 >= r2) goto L7;
    L9:
        d();     // Catch: Throwable -> L16
    L10:
        Iterator r3 = q.iterator();     // Catch: Throwable -> L16
    L12:
        if (r3.hasNext() == false) goto L14;
        ((e7) r3.next()).a(r12.a(), this.j.getActiveCount());     // Catch: Throwable -> L16
        goto L12
    L14:
        monitor-exit(r11);     // Catch: Throwable -> L16
        return;
    L7:
        if (r2 >= f()) goto L9;
        int r4 = this.i + 1;     // Catch: Throwable -> L16
        this.i = r4;     // Catch: Throwable -> L16
        this.j.setCorePoolSize(r4);     // Catch: Throwable -> L16
        this.j.setMaximumPoolSize(this.i);     // Catch: Throwable -> L16
        r8.c("ThreadPool", "expand urgent core pool size: " + this.i);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public boolean containsTask(Runnable r3) {
        Object r0 = this.n;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (isTaskRunning(r3) == false) goto L7;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return true;
    L7:
        if (isTaskAwaiting(r3) == true) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return false;
    }

    public boolean containsTaskOfCaller(long r6) {
        Object r0 = this.n;
        monitor-enter(r0);
        Iterator r1 = this.h.keySet().iterator();     // Catch: Throwable -> L27
        if (r1 != null) goto L7;
    L14:
        Iterator r5 = this.g.iterator();     // Catch: Throwable -> L27
        if (r5 != null) goto L17;
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L27
        return false;
    L17:
        if (r5.hasNext() == false) goto L24;
        d r2 = (d) r5.next();     // Catch: Throwable -> L27
        if (r2.a() == null) goto L17;
        if (r6 != r2.a().b) goto L17;
        monitor-exit(r0);     // Catch: Throwable -> L27
        return true;
    L7:
        if (r1.hasNext() == false) goto L14;
        d r3 = (d) r1.next();     // Catch: Throwable -> L27
        if (r3.a() == null) goto L7;
        if (r6 != r3.a().b) goto L7;
        monitor-exit(r0);     // Catch: Throwable -> L27
        return true;
    L27:
        th = move-exception;
        throw th;
    }

    public List getRunningTasks() {
        Object r0 = this.n;
        monitor-enter(r0);
        Iterator r3 = this.h.keySet().iterator();     // Catch: Throwable -> L10
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L10
    L6:
        if (r3.hasNext() == false) goto L8;
        r1.add(((d) r3.next()).a());     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L10:
        th = move-exception;
        throw th;
    }

    public Thread getRunningThread(Runnable r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        Object r1 = this.n;
        monitor-enter(r1);
        Iterator r2 = this.h.keySet().iterator();     // Catch: Throwable -> L25
        if (r2 != null) goto L10;
    L23:
        monitor-exit(r1);     // Catch: Throwable -> L25
        return null;
    L10:
        if (r2.hasNext() == false) goto L18;
        d r3 = (d) r2.next();     // Catch: Throwable -> L25
        if (r3 == null) goto L10;
        if (r3.a() == null) goto L10;
        if (r6.equals(r3.a().i) == false) goto L10;
    L19:
        if (r3 == null) goto L23;
        Thread r5 = (Thread) this.h.get(r3);     // Catch: Throwable -> L25
        monitor-exit(r1);     // Catch: Throwable -> L25
        return r5;
    L18:
        r3 = null;
    L25:
        th = move-exception;
        throw th;
    }

    @Override // tmsdkobf.b0
    public int getSingletonType() {
        return 1;
    }

    public ArrayList h() {
        Object r2 = this.n;
        monitor-enter(r2);
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L7
        r0.addAll(q);     // Catch: Throwable -> L7
        monitor-exit(r2);     // Catch: Throwable -> L7
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public void interruptTask(Runnable r3) {
        Object r0 = this.n;
        monitor-enter(r0);
        Thread r1 = getRunningThread(r3);     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        r1.interrupt();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L7:
        removeTask(r3);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public boolean isTaskAwaiting(Runnable r4) {
        Object r0 = this.n;
        monitor-enter(r0);
        Iterator r3 = this.g.iterator();     // Catch: Throwable -> L23
        if (r3 != null) goto L7;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L23
        return false;
    L7:
        if (r3.hasNext() == false) goto L15;
        d r1 = (d) r3.next();     // Catch: Throwable -> L23
        if (r1 == null) goto L7;
        if (r1.a() == null) goto L7;
        if (r4.equals(r1.a().i) == false) goto L7;
    L16:
        if (r1 == null) goto L20;
        monitor-exit(r0);     // Catch: Throwable -> L23
        return true;
    L15:
        r1 = null;
    L23:
        th = move-exception;
        throw th;
    }

    public boolean isTaskRunning(Runnable r1) {
        if (getRunningThread(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isThreadPoolBusy() {
        Object r0 = this.n;
        monitor-enter(r0);
        Iterator r1 = this.h.keySet().iterator();     // Catch: Throwable -> L29
        if (r1 != null) goto L7;
    L15:
        Iterator r6 = this.g.iterator();     // Catch: Throwable -> L29
        if (r6 != null) goto L18;
    L26:
        monitor-exit(r0);     // Catch: Throwable -> L29
        return false;
    L18:
        if (r6.hasNext() == false) goto L26;
        d r2 = (d) r6.next();     // Catch: Throwable -> L29
        if (r2 == null) goto L18;
        if (r2.a().h == true) goto L18;
        r8.c("ThreadPool", "Busy - waiting task: " + r2.a().b + " | " + r2.a().c);     // Catch: Throwable -> L29
        monitor-exit(r0);     // Catch: Throwable -> L29
        return true;
    L7:
        if (r1.hasNext() == false) goto L15;
        d r3 = (d) r1.next();     // Catch: Throwable -> L29
        if (r3 == null) goto L7;
        if (r3.a().h == true) goto L7;
        r8.c("ThreadPool", "Busy - running task: " + r3.a().b + " | " + r3.a().c);     // Catch: Throwable -> L29
        monitor-exit(r0);     // Catch: Throwable -> L29
        return true;
    L29:
        th = move-exception;
        throw th;
    }

    public HandlerThread newFreeHandlerThread(String r1, int r2, long r3) {
        return f5.a(r1, r2, r3);
    }

    public Thread newFreeThread(Runnable r1, String r2, long r3) {
        b();
        return this.p.a(r1, r2, r3);
    }

    @Override // tmsdkobf.b0
    public void onCreate(Context r9) {
        this.i = g();
        n2 r10 = new n2(0, this.i + 2, 3, TimeUnit.SECONDS, this.e, new ThreadPoolExecutor.CallerRunsPolicy());
        this.j = r10;
        r10.a(this);
        HandlerThread r11 = new HandlerThread("TMS_THREAD_POOL_HANDLER");
        this.l = r11;
        r11.start();
        this.m = new e(this, this.l.getLooper());
    }

    public void pauseThreadPool(long r4) {
        Object r0 = this.n;
        monitor-enter(r0);
        this.o = true;     // Catch: Throwable -> L8
        s = System.currentTimeMillis();     // Catch: Throwable -> L8
        r = r4;     // Catch: Throwable -> L8
        r8.c("ThreadPool", "pause thread pool");     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean removeTask(Runnable r6) {
        if (r6 != null) goto L5;
        return false;
    L5:
        Object r1 = this.n;
        monitor-enter(r1);
        Iterator r2 = this.g.iterator();     // Catch: Throwable -> L26
        if (r2 != null) goto L10;
    L24:
        monitor-exit(r1);     // Catch: Throwable -> L26
        return false;
    L10:
        if (r2.hasNext() == false) goto L18;
        d r3 = (d) r2.next();     // Catch: Throwable -> L26
        if (r3 == null) goto L10;
        if (r3.a() == null) goto L10;
        if (r6.equals(r3.a().i) == false) goto L10;
        r2.remove();     // Catch: Throwable -> L26
    L19:
        if (r3 == null) goto L24;
        this.j.remove(r3);     // Catch: Throwable -> L26
        monitor-exit(r1);     // Catch: Throwable -> L26
        return true;
    L18:
        r3 = null;
    L26:
        th = move-exception;
        throw th;
    }

    public void removeThreadPoolInfoListener(e7 r2) {
        Object r1 = this.n;
        monitor-enter(r1);
        q.remove(r2);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeThreadPoolStatusObserver(f7 r2) {
        Object r0 = this.n;
        monitor-enter(r0);
        this.b.remove(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void shutdown() {
        n2 r0 = this.j;
        if (r0 == null) goto L6;
        r0.shutdown();
        return;
    }

    public void wakeupThreadPool() {
        Object r0 = this.n;
        monitor-enter(r0);
        this.o = false;     // Catch: Throwable -> L8
        s = 0;     // Catch: Throwable -> L8
        r = 0;     // Catch: Throwable -> L8
        r8.c("ThreadPool", "wake up threa pool");     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void b() {
        if (this.p != null) goto L6;
        h5 r0 = new h5();
        this.p = r0;
        r0.a(new b(this));
        return;
    }

    private void c() {
        Object r0 = this.n;     // Catch: Throwable -> L22
        monitor-enter(r0);     // Catch: Throwable -> L22
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L5:
        if (this.f.isEmpty() == true) goto L15;
        Iterator r1 = this.f.iterator();     // Catch: Throwable -> L19
        if (r1 == null) goto L15;
        if (r1.hasNext() == false) goto L15;
        d r2 = (d) r1.next();     // Catch: Throwable -> L19
        r1.remove();     // Catch: Throwable -> L19
        d();     // Catch: Throwable -> L19
        this.j.execute(r2);     // Catch: Throwable -> L19
        Iterator r3 = q.iterator();     // Catch: Throwable -> L19
    L12:
        if (r3.hasNext() == false) goto L15;
        ((e7) r3.next()).a(r2.a(), this.j.getActiveCount());     // Catch: Throwable -> L19
    L15:
        if (this.f.isEmpty() == true) goto L17;
        this.m.sendEmptyMessage(1);     // Catch: Throwable -> L19
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L19
    L30:
        return;
    L22:
        th = move-exception;
        r8.a("ThreadPool", "executeTask (Throwable)", th);
    }

    public void a(int r13, Runnable r14, String r15, long r16, boolean r18, Object r19) {
        Object r10 = this.n;
        monitor-enter(r10);
        d r11 = new d(this, r13, r14, r15, r16, r18, r19);     // Catch: Throwable -> L7
        this.f.add(r11);     // Catch: Throwable -> L7
        this.g.add(r11);     // Catch: Throwable -> L7
        this.m.sendEmptyMessage(1);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // tmsdkobf.n2.a
    public void a(Runnable r5, Throwable r6) {
        Object r7 = this.n;
        monitor-enter(r7);
        d r8 = (d) r5;     // Catch: Throwable -> L29
        Iterator r0 = this.h.keySet().iterator();     // Catch: Throwable -> L29
        if (r0 != null) goto L7;
    L16:
        int r9 = this.j.getActiveCount();     // Catch: Throwable -> L29
        int r1 = this.j.getQueue().size();     // Catch: Throwable -> L29
        int r2 = this.j.getCorePoolSize();     // Catch: Throwable -> L29
        if (r9 != 1) goto L27;
        if (r1 != 0) goto L27;
        if (r2 <= 0) goto L22;
        this.i = g();     // Catch: Throwable -> L29
        this.j.setCorePoolSize(0);     // Catch: Throwable -> L29
        this.j.setMaximumPoolSize(this.i + 2);     // Catch: Throwable -> L29
        r8.c("ThreadPool", "shrink core pool size: " + this.j.getCorePoolSize());     // Catch: Throwable -> L29
    L22:
        Iterator r3 = this.b.iterator();     // Catch: Throwable -> L29
        if (r3.hasNext() == true) goto L25;
        this.k = false;     // Catch: Throwable -> L29
        goto L27
    L25:
        ua.a(r3.next());     // Catch: Throwable -> L29
        throw null;     // Catch: Throwable -> L29
    L27:
        monitor-exit(r7);     // Catch: Throwable -> L29
        return;
    L7:
        if (r0.hasNext() == false) goto L16;
        d r4 = (d) r0.next();     // Catch: Throwable -> L29
        if (r4 == null) goto L7;
        if (r4.equals(r8) == false) goto L7;
        r0.remove();     // Catch: Throwable -> L29
        r8.a().f = System.currentTimeMillis() - r8.a().f;     // Catch: Throwable -> L29
        r8.a().g = Debug.threadCpuTimeNanos() - r8.a().g;     // Catch: Throwable -> L29
        Iterator r10 = q.iterator();     // Catch: Throwable -> L29
    L14:
        if (r10.hasNext() == false) goto L16;
        ((e7) r10.next()).a(r8.a());     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    }

    @Override // tmsdkobf.n2.a
    public void a(Thread r7, Runnable r8) {
        Object r0 = this.n;
        monitor-enter(r0);
        Iterator r1 = this.g.iterator();     // Catch: Throwable -> L33
        if (r1 == null) goto L31;
        d r9 = (d) r8;     // Catch: Throwable -> L33
        int r2 = r9.a().d;     // Catch: Throwable -> L33
        if (r2 >= 1) goto L10;
        r2 = 1;
    L12:
        r7.setPriority(r2);     // Catch: Throwable -> L33
    L14:
        if (r1.hasNext() == false) goto L31;
        d r3 = (d) r1.next();     // Catch: Throwable -> L33
        if (r3 == null) goto L14;
        if (r3.equals(r9) == false) goto L14;
        r1.remove();     // Catch: Throwable -> L33
        if (this.k == true) goto L26;
        Iterator r4 = this.b.iterator();     // Catch: Throwable -> L33
        if (r4.hasNext() == false) goto L26;
        ua.a(r4.next());     // Catch: Throwable -> L33
        throw null;     // Catch: Throwable -> L33
    L26:
        Iterator r5 = q.iterator();     // Catch: Throwable -> L33
    L28:
        if (r5.hasNext() == false) goto L30;
        ((e7) r5.next()).b(r9.a());     // Catch: Throwable -> L33
        goto L28
    L30:
        r9.a().f = System.currentTimeMillis();     // Catch: Throwable -> L33
        r9.a().g = Debug.threadCpuTimeNanos();     // Catch: Throwable -> L33
        this.h.put(r9, r7);     // Catch: Throwable -> L33
        r7.setName(r9.a().c);     // Catch: Throwable -> L33
        this.k = true;     // Catch: Throwable -> L33
        goto L31
    L10:
        if (r2 <= 10) goto L12;
        r2 = 10;
    L31:
        monitor-exit(r0);     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        throw th;
    }

    public void a(Object r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        Object r0 = this.n;
        monitor-enter(r0);
        Iterator r3 = this.g.iterator();     // Catch: Throwable -> L18
    L8:
        if (r3.hasNext() == false) goto L16;
        d r1 = (d) r3.next();     // Catch: Throwable -> L18
        if (r1 == null) goto L8;
        if (r1.a().h == false) goto L8;
        if (r4.equals(r1.a().j) == false) goto L8;
        r3.remove();     // Catch: Throwable -> L18
        goto L8
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }
}
