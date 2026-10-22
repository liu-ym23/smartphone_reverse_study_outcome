package f.a.j.d;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends f.a.f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final f f17100c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final f f17101d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f17102e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final TimeUnit f17103f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final C0454c f17104g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final a f17105h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ThreadFactory f17106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference<a> f17107b;

    static final class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final long f17108f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final ConcurrentLinkedQueue<C0454c> f17109g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final f.a.g.a f17110h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final ScheduledExecutorService f17111i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final Future<?> f17112j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final ThreadFactory f17113k;

        a(long r8, TimeUnit r10, ThreadFactory r11) {
            if (r10 == null) goto L5;
            long r9 = r10.toNanos(r8);
        L6:
            long r4 = r9;
            this.f17108f = r4;
            this.f17109g = new ConcurrentLinkedQueue();
            this.f17110h = new f.a.g.a();
            this.f17113k = r11;
            ScheduledExecutorService r12 = null;
            if (r10 == null) goto L9;
            r12 = Executors.newScheduledThreadPool(1, c.f17101d);
            ScheduledFuture<?> r13 = r12.scheduleWithFixedDelay(this, r4, r4, TimeUnit.NANOSECONDS);
        L10:
            this.f17111i = r12;
            this.f17112j = r13;
            return;
        L9:
            r13 = null;
            goto L10
        L5:
            r9 = 0;
            goto L6
        }

        void b() {
            if (this.f17109g.isEmpty() == true) goto L12;
            long r0 = d();
            Iterator<C0454c> r2 = this.f17109g.iterator();
        L6:
            if (r2.hasNext() == false) goto L19;
            C0454c r3 = r2.next();
            if (r3.f() > r0) goto L20;
            if (this.f17109g.remove(r3) == false) goto L6;
            this.f17110h.a(r3);
            goto L6
        L20:
            return;
        L19:
            return;
        }

        C0454c c() {
            if (this.f17110h.e() == false) goto L7;
            return c.f17104g;
        L7:
            if (this.f17109g.isEmpty() == true) goto L11;
            C0454c r0 = this.f17109g.poll();
            if (r0 == null) goto L7;
            return r0;
        L11:
            C0454c r1 = new C0454c(this.f17113k);
            this.f17110h.b(r1);
            return r1;
        }

        long d() {
            return System.nanoTime();
        }

        void e(C0454c r5) {
            r5.g(d() + this.f17108f);
            this.f17109g.offer(r5);
        }

        void f() {
            this.f17110h.dispose();
            Future<?> r0 = this.f17112j;
            if (r0 == null) goto L5;
            r0.cancel(true);
        L5:
            ScheduledExecutorService r2 = this.f17111i;
            if (r2 == null) goto L9;
            r2.shutdownNow();
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            b();
        }
    }

    static final class b extends f.a.f.b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final f.a.g.a f17114f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final a f17115g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final C0454c f17116h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final AtomicBoolean f17117i;

        b(a r2) {
            this.f17117i = new AtomicBoolean();
            this.f17115g = r2;
            this.f17114f = new f.a.g.a();
            this.f17116h = r2.c();
        }

        @Override // f.a.f.b
        public f.a.g.b b(Runnable r7, long r8, TimeUnit r10) {
            if (this.f17114f.e() == false) goto L7;
            return f.a.j.a.d.f17053f;
        L7:
            return this.f17116h.c(r7, r8, r10, this.f17114f);
        }

        @Override // f.a.g.b
        public void dispose() {
            if (this.f17117i.compareAndSet(false, true) == false) goto L6;
            this.f17114f.dispose();
            this.f17115g.e(this.f17116h);
            return;
        }
    }

    /* JADX INFO: renamed from: f.a.j.d.c$c, reason: collision with other inner class name */
    static final class C0454c extends e {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f17118h;

        C0454c(ThreadFactory r3) {
            super(r3);
            this.f17118h = 0;
        }

        public long f() {
            return this.f17118h;
        }

        public void g(long r1) {
            this.f17118h = r1;
        }
    }

    static {
        f17103f = TimeUnit.SECONDS;
        f17102e = Long.getLong("rx2.io-keep-alive-time", 60).longValue();
        C0454c r0 = new C0454c(new f("RxCachedThreadSchedulerShutdown"));
        f17104g = r0;
        r0.dispose();
        int r1 = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        f r2 = new f("RxCachedThreadScheduler", r1);
        f17100c = r2;
        f17101d = new f("RxCachedWorkerPoolEvictor", r1);
        a r3 = new a(0, null, r2);
        f17105h = r3;
        r3.f();
    }

    public c() {
        this(f17100c);
    }

    public c(ThreadFactory r2) {
        this.f17106a = r2;
        this.f17107b = new AtomicReference(f17105h);
        d();
    }

    @Override // f.a.f
    public f.a.f.b a() {
        return new b(this.f17107b.get());
    }

    public void d() {
        a r0 = new a(f17102e, f17103f, this.f17106a);
        if (this.f17107b.compareAndSet(f17105h, r0) == true) goto L6;
        r0.f();
        return;
    }
}
