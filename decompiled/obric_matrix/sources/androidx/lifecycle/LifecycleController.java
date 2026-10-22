package androidx.lifecycle;

import androidx.annotation.MainThread;
import h.a.x1;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0007J\u0011\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0082\bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/lifecycle/LifecycleController;", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "minState", "Landroidx/lifecycle/Lifecycle$State;", "dispatchQueue", "Landroidx/lifecycle/DispatchQueue;", "parentJob", "Lkotlinx/coroutines/Job;", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Landroidx/lifecycle/DispatchQueue;Lkotlinx/coroutines/Job;)V", "observer", "Landroidx/lifecycle/LifecycleEventObserver;", "finish", "", "handleDestroy", "lifecycle-runtime-ktx_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@MainThread
public final class LifecycleController {
    private final DispatchQueue dispatchQueue;
    private final Lifecycle lifecycle;
    private final Lifecycle.State minState;
    private final LifecycleEventObserver observer;

    public LifecycleController(Lifecycle r2, Lifecycle.State r3, DispatchQueue r4, final x1 r5) {
        o.f(r2, "lifecycle");
        o.f(r3, "minState");
        o.f(r4, "dispatchQueue");
        o.f(r5, "parentJob");
        this.lifecycle = r2;
        this.minState = r3;
        this.dispatchQueue = r4;
        LifecycleEventObserver r6 = new b(this, r5);
        this.observer = r6;
        if (r2.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        x1.a.a(r5, null, 1, null);
        finish();
        return;
    L5:
        r2.addObserver(r6);
    }

    public static /* synthetic */ void a(LifecycleController r0, x1 r1, LifecycleOwner r2, Lifecycle.Event r3) {
        m21observer$lambda0(r0, r1, r2, r3);
    }

    private final void handleDestroy(x1 r3) {
        x1.a.a(r3, null, 1, null);
        finish();
    }

    /* JADX INFO: renamed from: observer$lambda-0, reason: not valid java name */
    private static final void m21observer$lambda0(LifecycleController r1, x1 r2, LifecycleOwner r3, Lifecycle.Event r4) {
        o.f(r1, "this$0");
        o.f(r2, "$parentJob");
        o.f(r3, "source");
        o.f(r4, "<anonymous parameter 1>");
        if (r3.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        x1.a.a(r2, null, 1, null);
        r1.finish();
        return;
    L5:
        int r5 = r3.getLifecycle().getCurrentState().compareTo(r1.minState);
        DispatchQueue r6 = r1.dispatchQueue;
        if (r5 >= 0) goto L8;
        r6.pause();
        return;
    L8:
        r6.resume();
    }

    @MainThread
    public final void finish() {
        this.lifecycle.removeObserver(this.observer);
        this.dispatchQueue.finish();
    }
}
