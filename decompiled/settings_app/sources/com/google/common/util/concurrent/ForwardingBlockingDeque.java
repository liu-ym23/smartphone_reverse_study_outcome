package com.google.common.util.concurrent;

import com.google.common.collect.ForwardingDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingBlockingDeque<E> extends ForwardingDeque<E> implements BlockingDeque<E> {
    @Override // com.google.common.collect.ForwardingDeque, com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected abstract BlockingDeque<E> delegate();

    @Override // com.google.common.collect.ForwardingDeque, com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingDeque, com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingDeque, com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Deque delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingDeque, com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Queue delegate() {
        return delegate();
    }

    protected ForwardingBlockingDeque() {
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return delegate().remainingCapacity();
    }

    @Override // java.util.concurrent.BlockingDeque
    public void putFirst(E r1) throws InterruptedException {
        delegate().putFirst(r1);
    }

    @Override // java.util.concurrent.BlockingDeque
    public void putLast(E r1) throws InterruptedException {
        delegate().putLast(r1);
    }

    @Override // java.util.concurrent.BlockingDeque
    public boolean offerFirst(E r1, long r2, TimeUnit r4) throws InterruptedException {
        return delegate().offerFirst(r1, r2, r4);
    }

    @Override // java.util.concurrent.BlockingDeque
    public boolean offerLast(E r1, long r2, TimeUnit r4) throws InterruptedException {
        return delegate().offerLast(r1, r2, r4);
    }

    @Override // java.util.concurrent.BlockingDeque
    public E takeFirst() throws InterruptedException {
        return delegate().takeFirst();
    }

    @Override // java.util.concurrent.BlockingDeque
    public E takeLast() throws InterruptedException {
        return delegate().takeLast();
    }

    @Override // java.util.concurrent.BlockingDeque
    @CheckForNull
    public E pollFirst(long r1, TimeUnit r3) throws InterruptedException {
        return delegate().pollFirst(r1, r3);
    }

    @Override // java.util.concurrent.BlockingDeque
    @CheckForNull
    public E pollLast(long r1, TimeUnit r3) throws InterruptedException {
        return delegate().pollLast(r1, r3);
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public void put(E r1) throws InterruptedException {
        delegate().put(r1);
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public boolean offer(E r1, long r2, TimeUnit r4) throws InterruptedException {
        return delegate().offer(r1, r2, r4);
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        return delegate().take();
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    @CheckForNull
    public E poll(long r1, TimeUnit r3) throws InterruptedException {
        return delegate().poll(r1, r3);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> r1) {
        return delegate().drainTo(r1);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> r1, int r2) {
        return delegate().drainTo(r1, r2);
    }
}
