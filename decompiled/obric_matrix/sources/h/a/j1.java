package h.a;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\bH\u0004R\u0012\u0010\u0003\u001a\u00020\u0004X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/EventLoop;", "()V", "thread", "Ljava/lang/Thread;", "getThread", "()Ljava/lang/Thread;", "reschedule", "", "now", "", "delayedTask", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "unpark", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class j1 extends h1 {
    public j1() {
    }

    protected abstract Thread t0();

    protected void u0(long r1, i1.c r3) {
        s0.f17564k.F0(r1, r3);
    }

    protected final void v0() {
        Thread r1 = t0();
        if (Thread.currentThread() == r1) goto L11;
        b r0 = c.a();
        if (r0 != null) goto L7;
        kotlin.f0 r2 = null;
    L8:
        if (r2 != null) goto L12;
        LockSupport.unpark(r1);
        return;
    L12:
        return;
    L7:
        r0.f(r1);
        r2 = kotlin.f0.f18324a;
        goto L8
    }
}
