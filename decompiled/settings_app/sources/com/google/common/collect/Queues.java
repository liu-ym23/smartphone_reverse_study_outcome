package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.time.Duration;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Queues {
    private Queues() {
    }

    public static <E> ArrayBlockingQueue<E> newArrayBlockingQueue(int r1) {
        return new ArrayBlockingQueue(r1);
    }

    public static <E> ArrayDeque<E> newArrayDeque() {
        return new ArrayDeque();
    }

    public static <E> ArrayDeque<E> newArrayDeque(Iterable<? extends E> r1) {
        if ((r1 instanceof Collection) == true) goto L5;
        ArrayDeque<E> r0 = new ArrayDeque();
        Iterables.addAll(r0, r1);
        return r0;
    L5:
        return new ArrayDeque((Collection) r1);
    }

    public static <E> ConcurrentLinkedQueue<E> newConcurrentLinkedQueue() {
        return new ConcurrentLinkedQueue();
    }

    public static <E> ConcurrentLinkedQueue<E> newConcurrentLinkedQueue(Iterable<? extends E> r1) {
        if ((r1 instanceof Collection) == true) goto L5;
        ConcurrentLinkedQueue<E> r0 = new ConcurrentLinkedQueue();
        Iterables.addAll(r0, r1);
        return r0;
    L5:
        return new ConcurrentLinkedQueue((Collection) r1);
    }

    public static <E> LinkedBlockingDeque<E> newLinkedBlockingDeque() {
        return new LinkedBlockingDeque();
    }

    public static <E> LinkedBlockingDeque<E> newLinkedBlockingDeque(int r1) {
        return new LinkedBlockingDeque(r1);
    }

    public static <E> LinkedBlockingDeque<E> newLinkedBlockingDeque(Iterable<? extends E> r1) {
        if ((r1 instanceof Collection) == true) goto L5;
        LinkedBlockingDeque<E> r0 = new LinkedBlockingDeque();
        Iterables.addAll(r0, r1);
        return r0;
    L5:
        return new LinkedBlockingDeque((Collection) r1);
    }

    public static <E> LinkedBlockingQueue<E> newLinkedBlockingQueue() {
        return new LinkedBlockingQueue();
    }

    public static <E> LinkedBlockingQueue<E> newLinkedBlockingQueue(int r1) {
        return new LinkedBlockingQueue(r1);
    }

    public static <E> LinkedBlockingQueue<E> newLinkedBlockingQueue(Iterable<? extends E> r1) {
        if ((r1 instanceof Collection) == true) goto L5;
        LinkedBlockingQueue<E> r0 = new LinkedBlockingQueue();
        Iterables.addAll(r0, r1);
        return r0;
    L5:
        return new LinkedBlockingQueue((Collection) r1);
    }

    public static <E extends Comparable> PriorityBlockingQueue<E> newPriorityBlockingQueue() {
        return new PriorityBlockingQueue();
    }

    public static <E extends Comparable> PriorityBlockingQueue<E> newPriorityBlockingQueue(Iterable<? extends E> r1) {
        if ((r1 instanceof Collection) == true) goto L5;
        PriorityBlockingQueue<E> r0 = new PriorityBlockingQueue();
        Iterables.addAll(r0, r1);
        return r0;
    L5:
        return new PriorityBlockingQueue((Collection) r1);
    }

    public static <E extends Comparable> PriorityQueue<E> newPriorityQueue() {
        return new PriorityQueue();
    }

    public static <E extends Comparable> PriorityQueue<E> newPriorityQueue(Iterable<? extends E> r1) {
        if ((r1 instanceof Collection) == true) goto L5;
        PriorityQueue<E> r0 = new PriorityQueue();
        Iterables.addAll(r0, r1);
        return r0;
    L5:
        return new PriorityQueue((Collection) r1);
    }

    public static <E> SynchronousQueue<E> newSynchronousQueue() {
        return new SynchronousQueue();
    }

    public static <E> int drain(BlockingQueue<E> r6, Collection<? super E> r7, int r8, Duration r9) throws InterruptedException {
        return drain(r6, r7, r8, r9.toNanos(), TimeUnit.NANOSECONDS);
    }

    public static <E> int drain(BlockingQueue<E> r3, Collection<? super E> r4, int r5, long r6, TimeUnit r8) throws InterruptedException {
        Preconditions.checkNotNull(r4);
        long r0 = System.nanoTime() + r8.toNanos(r6);
        int r7 = 0;
    L3:
        if (r7 >= r5) goto L10;
        r7 = r7 + r3.drainTo(r4, r5 - r7);
        if (r7 >= r5) goto L3;
        E r9 = r3.poll(r0 - System.nanoTime(), TimeUnit.NANOSECONDS);
        if (r9 == null) goto L10;
        r4.add(r9);
        r7 = r7 + 1;
    L10:
        return r7;
    }

    public static <E> int drainUninterruptibly(BlockingQueue<E> r6, Collection<? super E> r7, int r8, Duration r9) {
        return drainUninterruptibly(r6, r7, r8, r9.toNanos(), TimeUnit.NANOSECONDS);
    }

    public static <E> int drainUninterruptibly(BlockingQueue<E> r4, Collection<? super E> r5, int r6, long r7, TimeUnit r9) {
        Preconditions.checkNotNull(r5);
        long r0 = System.nanoTime() + r9.toNanos(r7);
        int r8 = 0;
        boolean r10 = false;
    L3:
        if (r8 >= r6) goto L18;
    L14:
        th = move-exception;
        if (r10 == false) goto L17;
        Thread.currentThread().interrupt();
    L17:
        throw th;
    L6:
        r8 = r8 + r4.drainTo(r5, r6 - r8);
        if (r8 >= r6) goto L3;
    L23:
        E r11 = r4.poll(r0 - System.nanoTime(), TimeUnit.NANOSECONDS);     // Catch: InterruptedException -> L13 Throwable -> L14
        if (r11 == null) goto L18;
        r5.add(r11);     // Catch: Throwable -> L14
        r8 = r8 + 1;
    L13:
        r10 = true;
    L18:
        if (r10 == false) goto L20;
        Thread.currentThread().interrupt();
    L20:
        return r8;
    }

    public static <E> Queue<E> synchronizedQueue(Queue<E> r1) {
        return Synchronized.queue(r1, null);
    }

    public static <E> Deque<E> synchronizedDeque(Deque<E> r1) {
        return Synchronized.deque(r1, null);
    }
}
