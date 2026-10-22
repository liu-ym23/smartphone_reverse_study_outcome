package f.a.j.d;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends f.a.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final f f17137b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final ScheduledExecutorService f17138c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final AtomicReference<ScheduledExecutorService> f17139a;

    static final class a extends f.a.f.b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final ScheduledExecutorService f17140f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final f.a.g.a f17141g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile boolean f17142h;

        a(ScheduledExecutorService r1) {
            this.f17140f = r1;
            this.f17141g = new f.a.g.a();
        }

        @Override // f.a.f.b
        public f.a.g.b b(Runnable r4, long r5, TimeUnit r7) {
            if (this.f17142h == true) goto L5;
            h r0 = new h(f.a.k.a.n(r4), this.f17141g);
            this.f17141g.b(r0);
            if (r5 > 0) goto L9;
            Future<?> r6 = this.f17140f.submit(r0);     // Catch: RejectedExecutionException -> L12
        L10:
            r0.a(r6);     // Catch: RejectedExecutionException -> L12
            return r0;
        L9:
            r6 = this.f17140f.schedule(r0, r5, r7);     // Catch: RejectedExecutionException -> L12
        L12:
            e = move-exception;
            dispose();
            f.a.k.a.m(e);
            return f.a.j.a.d.f17053f;
        L5:
            return f.a.j.a.d.f17053f;
        }

        @Override // f.a.g.b
        public void dispose() {
            if (this.f17142h == true) goto L6;
            this.f17142h = true;
            this.f17141g.dispose();
            return;
        }
    }

    static {
        ScheduledExecutorService r0 = Executors.newScheduledThreadPool(0);
        f17138c = r0;
        r0.shutdown();
        f17137b = new f("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public j() {
        this(f17137b);
    }

    public j(ThreadFactory r2) {
        AtomicReference<ScheduledExecutorService> r0 = new AtomicReference();
        this.f17139a = r0;
        r0.lazySet(d(r2));
    }

    static ScheduledExecutorService d(ThreadFactory r0) {
        return i.a(r0);
    }

    @Override // f.a.f
    public f.a.f.b a() {
        return new a(this.f17139a.get());
    }

    @Override // f.a.f
    public f.a.g.b c(Runnable r4, long r5, TimeUnit r7) {
        g r0 = new g(f.a.k.a.n(r4));
        if (r5 > 0) goto L5;
        Future<?> r3 = this.f17139a.get().submit(r0);     // Catch: RejectedExecutionException -> L8
    L6:
        r0.a(r3);     // Catch: RejectedExecutionException -> L8
        return r0;
    L5:
        r3 = this.f17139a.get().schedule(r0, r5, r7);     // Catch: RejectedExecutionException -> L8
    L8:
        e = move-exception;
        f.a.k.a.m(e);
        return f.a.j.a.d.f17053f;
    }
}
