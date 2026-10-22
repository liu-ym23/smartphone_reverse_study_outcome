package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes5.dex */
public final class CompletableCache extends Completable implements CompletableObserver {
    static final InnerCompletableCache[] EMPTY = null;
    static final InnerCompletableCache[] TERMINATED = null;
    Throwable error;
    final AtomicReference<InnerCompletableCache[]> observers;
    final AtomicBoolean once;
    final CompletableSource source;

    final class InnerCompletableCache extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 8943152917179642732L;
        final CompletableObserver downstream;
        final /* synthetic */ CompletableCache this$0;

        InnerCompletableCache(CompletableCache r1, CompletableObserver r2) {
            this.this$0 = r1;
            this.downstream = r2;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (compareAndSet(false, true) == false) goto L6;
            this.this$0.remove(this);
            return;
        }
    }

    @Override // io.reactivex.CompletableObserver
    public void onSubscribe(Disposable r1) {
    }

    static {
        EMPTY = new InnerCompletableCache[0];
        TERMINATED = new InnerCompletableCache[0];
    }

    public CompletableCache(CompletableSource r2) {
        this.source = r2;
        this.observers = new AtomicReference(EMPTY);
        this.once = new AtomicBoolean();
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver r3) {
        InnerCompletableCache r0 = new InnerCompletableCache(this, r3);
        r3.onSubscribe(r0);
        if (add(r0) == true) goto L5;
        Throwable r2 = this.error;
        if (r2 == null) goto L13;
        r3.onError(r2);
        return;
    L13:
        r3.onComplete();
        return;
    L5:
        if (r0.isDisposed() == false) goto L8;
        remove(r0);
    L8:
        if (this.once.compareAndSet(false, true) == false) goto L15;
        this.source.subscribe(this);
        return;
    }

    @Override // io.reactivex.CompletableObserver
    public void onError(Throwable r5) {
        this.error = r5;
        InnerCompletableCache[] r4 = this.observers.getAndSet(TERMINATED);
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        InnerCompletableCache r2 = r4[r1];
        if (r2.get() == true) goto L7;
        r2.downstream.onError(r5);
    L7:
        r1 = r1 + 1;
        goto L3
    }

    @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onComplete() {
        InnerCompletableCache[] r4 = this.observers.getAndSet(TERMINATED);
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        InnerCompletableCache r2 = r4[r1];
        if (r2.get() == true) goto L7;
        r2.downstream.onComplete();
    L7:
        r1 = r1 + 1;
        goto L3
    }

    boolean add(InnerCompletableCache r5) {
    L2:
        InnerCompletableCache[] r0 = this.observers.get();
        if (r0 == TERMINATED) goto L4;
        int r1 = r0.length;
        InnerCompletableCache[] r3 = new InnerCompletableCache[r1 + 1];
        System.arraycopy(r0, 0, r3, 0, r1);
        r3[r1] = r5;
        if (b0$$ExternalSyntheticBackport0.m(this.observers, r0, r3) == false) goto L2;
        return true;
    L4:
        return false;
    }

    void remove(InnerCompletableCache r7) {
    L2:
        InnerCompletableCache[] r0 = this.observers.get();
        int r1 = r0.length;
        if (r1 == 0) goto L4;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L11;
        if (r0[r3] == r7) goto L12;
        r3 = r3 + 1;
    L12:
        if (r3 < 0) goto L13;
        if (r1 != 1) goto L17;
        InnerCompletableCache[] r2 = EMPTY;
    L19:
        if (b0$$ExternalSyntheticBackport0.m(this.observers, r0, r2) == false) goto L2;
        return;
    L17:
        InnerCompletableCache[] r5 = new InnerCompletableCache[r1 - 1];
        System.arraycopy(r0, 0, r5, 0, r3);
        System.arraycopy(r0, r3 + 1, r5, r3, (r1 - r3) - 1);
        r2 = r5;
        goto L19
    L13:
        return;
    L11:
        r3 = -1;
        goto L12
    }
}
