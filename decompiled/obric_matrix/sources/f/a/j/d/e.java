package f.a.j.d;

import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class e extends f.a.f.b implements f.a.g.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ScheduledExecutorService f17121f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    volatile boolean f17122g;

    public e(ThreadFactory r1) {
        this.f17121f = i.a(r1);
    }

    @Override // f.a.f.b
    public f.a.g.b b(Runnable r7, long r8, TimeUnit r10) {
        if (this.f17122g == false) goto L7;
        return f.a.j.a.d.f17053f;
    L7:
        return c(r7, r8, r10, null);
    }

    public h c(Runnable r4, long r5, TimeUnit r7, f.a.j.a.b r8) {
        h r0 = new h(f.a.k.a.n(r4), r8);
        if (r8 == null) goto L18;
        if (r8.b(r0) == true) goto L18;
        return r0;
    L18:
        if (r5 > 0) goto L10;
        Future<?> r3 = this.f17121f.submit(r0);     // Catch: RejectedExecutionException -> L13
    L11:
        r0.a(r3);     // Catch: RejectedExecutionException -> L13
    L17:
        return r0;
    L10:
        r3 = this.f17121f.schedule(r0, r5, r7);     // Catch: RejectedExecutionException -> L13
    L13:
        e = move-exception;
        if (r8 == null) goto L16;
        r8.a(r0);
    L16:
        f.a.k.a.m(e);
        goto L17
    }

    public f.a.g.b d(Runnable r4, long r5, TimeUnit r7) {
        g r0 = new g(f.a.k.a.n(r4));
        if (r5 > 0) goto L5;
        Future<?> r3 = this.f17121f.submit(r0);     // Catch: RejectedExecutionException -> L8
    L6:
        r0.a(r3);     // Catch: RejectedExecutionException -> L8
        return r0;
    L5:
        r3 = this.f17121f.schedule(r0, r5, r7);     // Catch: RejectedExecutionException -> L8
    L8:
        e = move-exception;
        f.a.k.a.m(e);
        return f.a.j.a.d.f17053f;
    }

    @Override // f.a.g.b
    public void dispose() {
        if (this.f17122g == true) goto L6;
        this.f17122g = true;
        this.f17121f.shutdownNow();
        return;
    }

    public void e() {
        if (this.f17122g == true) goto L6;
        this.f17122g = true;
        this.f17121f.shutdown();
        return;
    }
}
