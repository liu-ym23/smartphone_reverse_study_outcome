package io.reactivex.internal.observers;

import io.reactivex.internal.fuseable.QueueDisposable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BasicQueueDisposable<T> implements QueueDisposable<T> {
    public BasicQueueDisposable() {
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(T r1) {
        throw new UnsupportedOperationException("Should not be called");
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(T r1, T r2) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
