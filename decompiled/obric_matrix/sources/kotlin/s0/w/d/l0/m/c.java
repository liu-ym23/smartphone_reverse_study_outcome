package kotlin.s0.w.d.l0.m;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.f0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Runnable f20907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.n0.c.l<InterruptedException, f0> f20908d;

    public c(Runnable r2, kotlin.n0.c.l<? super InterruptedException, f0> r3) {
        o.f(r2, "checkCancelled");
        o.f(r3, "interruptedExceptionHandler");
        this(new ReentrantLock(), r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Lock r2, Runnable r3, kotlin.n0.c.l<? super InterruptedException, f0> r4) {
        o.f(r2, "lock");
        o.f(r3, "checkCancelled");
        o.f(r4, "interruptedExceptionHandler");
        super(r2);
        this.f20907c = r3;
        this.f20908d = r4;
    }

    @Override // kotlin.s0.w.d.l0.m.d, kotlin.s0.w.d.l0.m.k
    public void b() {
    L9:
    L6:
        e = move-exception;
        this.f20908d.invoke(e);
        return;
    L3:
        if (c().tryLock(50, TimeUnit.MILLISECONDS) == true) goto L13;
        this.f20907c.run();     // Catch: InterruptedException -> L6
        goto L9
    }
}
