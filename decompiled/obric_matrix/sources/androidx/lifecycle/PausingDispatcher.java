package androidx.lifecycle;

import h.a.b1;
import h.a.g0;
import kotlin.Metadata;
import kotlin.k0.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\nj\u0002`\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u0010\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/lifecycle/PausingDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "dispatchQueue", "Landroidx/lifecycle/DispatchQueue;", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "isDispatchNeeded", "", "lifecycle-runtime-ktx_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PausingDispatcher extends g0 {
    public final DispatchQueue dispatchQueue;

    public PausingDispatcher() {
        this.dispatchQueue = new DispatchQueue();
    }

    @Override // h.a.g0
    public void dispatch(g r2, Runnable r3) {
        o.f(r2, "context");
        o.f(r3, "block");
        this.dispatchQueue.dispatchAndEnqueue(r2, r3);
    }

    @Override // h.a.g0
    public boolean isDispatchNeeded(g r2) {
        o.f(r2, "context");
        if (b1.c().h0().isDispatchNeeded(r2) == false) goto L6;
        return true;
    L6:
        return !this.dispatchQueue.canRun();
    }
}
