package com.google.common.collect;

import java.util.Collection;
import java.util.Queue;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingQueue<E> extends ForwardingCollection<E> implements Queue<E> {
    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected abstract Queue<E> delegate();

    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    protected ForwardingQueue() {
    }

    public boolean offer(@ParametricNullness E r1) {
        return delegate().offer(r1);
    }

    @Override // java.util.Queue
    @CheckForNull
    public E poll() {
        return delegate().poll();
    }

    @Override // java.util.Queue
    @ParametricNullness
    public E remove() {
        return delegate().remove();
    }

    @Override // java.util.Queue
    @CheckForNull
    public E peek() {
        return delegate().peek();
    }

    @Override // java.util.Queue
    @ParametricNullness
    public E element() {
        return delegate().element();
    }

    protected boolean standardOffer(@ParametricNullness E r1) {
        return add(r1);
    L4:
        return false;
    }

    @CheckForNull
    protected E standardPeek() {
        return element();
    L4:
        return null;
    }

    @CheckForNull
    protected E standardPoll() {
        return remove();
    L4:
        return null;
    }
}
