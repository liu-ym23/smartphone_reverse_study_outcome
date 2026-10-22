package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.ObservableQueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;

/* JADX INFO: loaded from: classes2.dex */
public abstract class QueueDrainObserver<T, U, V> extends QueueDrainSubscriberPad2 implements Observer<T>, ObservableQueueDrain<U, V> {
    protected volatile boolean cancelled;
    protected volatile boolean done;
    protected final Observer<? super V> downstream;
    protected Throwable error;
    protected final SimplePlainQueue<U> queue;

    public QueueDrainObserver(Observer<? super V> r1, SimplePlainQueue<U> r2) {
        this.downstream = r1;
        this.queue = r2;
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public void accept(Observer<? super V> r1, U r2) {
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final boolean cancelled() {
        return this.cancelled;
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final boolean done() {
        return this.done;
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final boolean enter() {
        if (this.wip.getAndIncrement() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final Throwable error() {
        return this.error;
    }

    public final boolean fastEnter() {
        if (this.wip.get() == 0) goto L5;
        return false;
    L5:
        if (this.wip.compareAndSet(0, 1) == true) goto L7;
        return false;
    L7:
        return true;
    }

    public final void fastPathEmit(U r6, boolean r7, Disposable r8) {
        Observer<? super V> r0 = this.downstream;
        SimplePlainQueue<U> r1 = this.queue;
        if (this.wip.get() == 0) goto L5;
    L9:
        r1.offer(r6);
        if (enter() == true) goto L12;
        return;
    L12:
        QueueDrainHelper.drainLoop(r1, r0, r7, r8, this);
        return;
    L5:
        if (this.wip.compareAndSet(0, 1) == false) goto L9;
        accept(r0, r6);
        if (leave(-1) != 0) goto L12;
    }

    public final void fastPathOrderedEmit(U r6, boolean r7, Disposable r8) {
        Observer<? super V> r0 = this.downstream;
        SimplePlainQueue<U> r1 = this.queue;
        if (this.wip.get() == 0) goto L5;
    L12:
        r1.offer(r6);
        if (enter() == true) goto L15;
        return;
    L15:
        QueueDrainHelper.drainLoop(r1, r0, r7, r8, this);
        return;
    L5:
        if (this.wip.compareAndSet(0, 1) == false) goto L12;
        if (r1.isEmpty() == false) goto L11;
        accept(r0, r6);
        if (leave(-1) != 0) goto L15;
        return;
    L11:
        r1.offer(r6);
        goto L15
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final int leave(int r1) {
        return this.wip.addAndGet(r1);
    }
}
