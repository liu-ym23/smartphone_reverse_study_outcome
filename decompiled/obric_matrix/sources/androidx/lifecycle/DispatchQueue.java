package androidx.lifecycle;

import android.annotation.SuppressLint;
import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import h.a.b1;
import h.a.i2;
import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.k0.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u0004H\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0007J\b\u0010\u0010\u001a\u00020\fH\u0007J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\tH\u0003J\b\u0010\u0012\u001a\u00020\fH\u0007J\b\u0010\u0013\u001a\u00020\fH\u0007J\b\u0010\u0014\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/lifecycle/DispatchQueue;", "", "()V", "finished", "", "isDraining", "paused", "queue", "Ljava/util/Queue;", "Ljava/lang/Runnable;", "canRun", "dispatchAndEnqueue", "", "context", "Lkotlin/coroutines/CoroutineContext;", "runnable", "drainQueue", "enqueue", "finish", "pause", "resume", "lifecycle-runtime-ktx_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DispatchQueue {
    private boolean finished;
    private boolean isDraining;
    private boolean paused;
    private final Queue<Runnable> queue;

    public DispatchQueue() {
        this.paused = true;
        this.queue = new ArrayDeque();
    }

    public static /* synthetic */ void a(DispatchQueue r0, Runnable r1) {
        m20dispatchAndEnqueue$lambda2$lambda1(r0, r1);
    }

    /* JADX INFO: renamed from: dispatchAndEnqueue$lambda-2$lambda-1, reason: not valid java name */
    private static final void m20dispatchAndEnqueue$lambda2$lambda1(DispatchQueue r1, Runnable r2) {
        o.f(r1, "this$0");
        o.f(r2, "$runnable");
        r1.enqueue(r2);
    }

    @MainThread
    private final void enqueue(Runnable r2) {
        if (this.queue.offer(r2) == false) goto L7;
        drainQueue();
        return;
    L7:
        throw new IllegalStateException("cannot enqueue any more runnables".toString());
    }

    @MainThread
    public final boolean canRun() {
        if (this.finished == false) goto L5;
    L8:
        return true;
    L5:
        if (this.paused == false) goto L8;
        return false;
    }

    @AnyThread
    @SuppressLint({"WrongThread"})
    public final void dispatchAndEnqueue(g r3, final Runnable r4) {
        o.f(r3, "context");
        o.f(r4, "runnable");
        i2 r0 = b1.c().h0();
        if (r0.isDispatchNeeded(r3) == false) goto L5;
    L8:
        r0.dispatch(r3, new a(this, r4));
        return;
    L5:
        if (canRun() == true) goto L8;
        enqueue(r4);
    }

    @MainThread
    public final void drainQueue() {
        if (this.isDraining == false) goto L21;
        return;
    L21:
        this.isDraining = true;     // Catch: Throwable -> L18
    L8:
        if ((!this.queue.isEmpty()) == false) goto L16;
        if (canRun() == false) goto L16;
        Runnable r2 = this.queue.poll();     // Catch: Throwable -> L18
        if (r2 == null) goto L8;
        r2.run();     // Catch: Throwable -> L18
    L16:
        this.isDraining = false;
        return;
    L18:
        th = move-exception;
        this.isDraining = false;
        throw th;
    }

    @MainThread
    public final void finish() {
        this.finished = true;
        drainQueue();
    }

    @MainThread
    public final void pause() {
        this.paused = true;
    }

    @MainThread
    public final void resume() {
        if (this.paused == true) goto L6;
        return;
    L6:
        if ((!this.finished) == false) goto L10;
        this.paused = false;
        drainQueue();
        return;
    L10:
        throw new IllegalStateException("Cannot resume a finished dispatcher".toString());
    }
}
