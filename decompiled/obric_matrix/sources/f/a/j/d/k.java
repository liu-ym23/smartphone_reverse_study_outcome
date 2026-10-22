package f.a.j.d;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends f.a.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final k f17143a = null;

    static final class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Runnable f17144f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final c f17145g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final long f17146h;

        a(Runnable r1, c r2, long r3) {
            this.f17144f = r1;
            this.f17145g = r2;
            this.f17146h = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f17145g.f17154i == true) goto L18;
            long r0 = this.f17145g.a(TimeUnit.MILLISECONDS);
            long r2 = this.f17146h;
            if (r2 <= r0) goto L13;
            Thread.sleep(r2 - r0);     // Catch: InterruptedException -> L9
        L9:
            e = move-exception;
            Thread.currentThread().interrupt();
            f.a.k.a.m(e);
            return;
        L13:
            if (this.f17145g.f17154i == true) goto L19;
            this.f17144f.run();
            return;
        L19:
            return;
        }
    }

    static final class b implements Comparable<b> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final Runnable f17147f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final long f17148g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final int f17149h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile boolean f17150i;

        b(Runnable r1, Long r2, int r3) {
            this.f17147f = r1;
            this.f17148g = r2.longValue();
            this.f17149h = r3;
        }

        public int a(b r5) {
            int r0 = f.a.j.b.b.b(this.f17148g, r5.f17148g);
            if (r0 == 0) goto L5;
            return r0;
        L5:
            return f.a.j.b.b.a(this.f17149h, r5.f17149h);
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(b r1) {
            return a(r1);
        }
    }

    static final class c extends f.a.f.b implements f.a.g.b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final PriorityBlockingQueue<b> f17151f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final AtomicInteger f17152g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final AtomicInteger f17153h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile boolean f17154i;

        final class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final b f17155f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ c f17156g;

            a(c r1, b r2) {
                this.f17156g = r1;
                this.f17155f = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f17155f.f17150i = true;
                this.f17156g.f17151f.remove(this.f17155f);
            }
        }

        c() {
            this.f17151f = new PriorityBlockingQueue();
            this.f17152g = new AtomicInteger();
            this.f17153h = new AtomicInteger();
        }

        @Override // f.a.f.b
        public f.a.g.b b(Runnable r3, long r4, TimeUnit r6) {
            long r0 = a(TimeUnit.MILLISECONDS) + r6.toMillis(r4);
            return c(new a(r3, this, r0), r0);
        }

        f.a.g.b c(Runnable r2, long r3) {
            if (this.f17154i == true) goto L5;
            b r0 = new b(r2, Long.valueOf(r3), this.f17153h.incrementAndGet());
            this.f17151f.add(r0);
            if (this.f17152g.getAndIncrement() != 0) goto L23;
            int r4 = 1;
        L10:
            if (this.f17154i == true) goto L11;
            b r5 = this.f17151f.poll();
            if (r5 == null) goto L15;
            if (r5.f17150i == true) goto L10;
            r5.f17147f.run();
            goto L10
        L15:
            r4 = this.f17152g.addAndGet(-r4);
            if (r4 != 0) goto L10;
            return f.a.j.a.d.f17053f;
        L11:
            this.f17151f.clear();
            return f.a.j.a.d.f17053f;
        L23:
            return f.a.g.c.b(new a(this, r0));
        L5:
            return f.a.j.a.d.f17053f;
        }

        @Override // f.a.g.b
        public void dispose() {
            this.f17154i = true;
        }
    }

    static {
        f17143a = new k();
    }

    k() {
    }

    public static k d() {
        return f17143a;
    }

    @Override // f.a.f
    public f.a.f.b a() {
        return new c();
    }

    @Override // f.a.f
    public f.a.g.b b(Runnable r1) {
        f.a.k.a.n(r1).run();
        return f.a.j.a.d.f17053f;
    }

    @Override // f.a.f
    public f.a.g.b c(Runnable r1, long r2, TimeUnit r4) {
        r4.sleep(r2);     // Catch: InterruptedException -> L4
        f.a.k.a.n(r1).run();     // Catch: InterruptedException -> L4
    L7:
        return f.a.j.a.d.f17053f;
    L4:
        e = move-exception;
        Thread.currentThread().interrupt();
        f.a.k.a.m(e);
        goto L7
    }
}
