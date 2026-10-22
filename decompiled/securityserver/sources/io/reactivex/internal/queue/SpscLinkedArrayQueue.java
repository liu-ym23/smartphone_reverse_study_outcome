package io.reactivex.internal.queue;

import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.Pow2;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes2.dex */
public final class SpscLinkedArrayQueue<T> implements SimplePlainQueue<T> {
    private static final Object HAS_NEXT = null;
    static final int MAX_LOOK_AHEAD_STEP = 0;
    AtomicReferenceArray<Object> consumerBuffer;
    final AtomicLong consumerIndex;
    final int consumerMask;
    AtomicReferenceArray<Object> producerBuffer;
    final AtomicLong producerIndex;
    long producerLookAhead;
    int producerLookAheadStep;
    final int producerMask;

    static {
        MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
        HAS_NEXT = new Object();
    }

    public SpscLinkedArrayQueue(int r4) {
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        int r5 = Pow2.roundToPowerOfTwo(Math.max(8, r4));
        int r0 = r5 - 1;
        AtomicReferenceArray<Object> r1 = new AtomicReferenceArray(r5 + 1);
        this.producerBuffer = r1;
        this.producerMask = r0;
        adjustLookAheadStep(r5);
        this.consumerBuffer = r1;
        this.consumerMask = r0;
        this.producerLookAhead = r5 - 2;
        soProducerIndex(0);
    }

    private void adjustLookAheadStep(int r2) {
        this.producerLookAheadStep = Math.min(r2 / 4, MAX_LOOK_AHEAD_STEP);
    }

    private static int calcDirectOffset(int r0) {
        return r0;
    }

    private static int calcWrappedOffset(long r0, int r2) {
        return calcDirectOffset(((int) r0) & r2);
    }

    private long lpConsumerIndex() {
        return this.consumerIndex.get();
    }

    private long lpProducerIndex() {
        return this.producerIndex.get();
    }

    private long lvConsumerIndex() {
        return this.consumerIndex.get();
    }

    private static <E> Object lvElement(AtomicReferenceArray<Object> r0, int r1) {
        return r0.get(r1);
    }

    private AtomicReferenceArray<Object> lvNextBufferAndUnlink(AtomicReferenceArray<Object> r2, int r3) {
        int r1 = calcDirectOffset(r3);
        AtomicReferenceArray<Object> r4 = (AtomicReferenceArray) lvElement(r2, r1);
        soElement(r2, r1, null);
        return r4;
    }

    private long lvProducerIndex() {
        return this.producerIndex.get();
    }

    private T newBufferPeek(AtomicReferenceArray<Object> r1, long r2, int r4) {
        this.consumerBuffer = r1;
        return (T) lvElement(r1, calcWrappedOffset(r2, r4));
    }

    private T newBufferPoll(AtomicReferenceArray<Object> r4, long r5, int r7) {
        this.consumerBuffer = r4;
        int r8 = calcWrappedOffset(r5, r7);
        T r0 = (T) lvElement(r4, r8);
        if (r0 == null) goto L5;
        soElement(r4, r8, null);
        soConsumerIndex(r5 + 1);
    L5:
        return r0;
    }

    private void resize(AtomicReferenceArray<Object> r5, long r6, int r8, T r9, long r10) {
        AtomicReferenceArray<Object> r1 = new AtomicReferenceArray(r5.length());
        this.producerBuffer = r1;
        this.producerLookAhead = (r10 + r6) - 1;
        soElement(r1, r8, r9);
        soNext(r5, r1);
        soElement(r5, r8, HAS_NEXT);
        soProducerIndex(r6 + 1);
    }

    private void soConsumerIndex(long r1) {
        this.consumerIndex.lazySet(r1);
    }

    private static void soElement(AtomicReferenceArray<Object> r0, int r1, Object r2) {
        r0.lazySet(r1, r2);
    }

    private void soNext(AtomicReferenceArray<Object> r1, AtomicReferenceArray<Object> r2) {
        soElement(r1, calcDirectOffset(r1.length() - 1), r2);
    }

    private void soProducerIndex(long r1) {
        this.producerIndex.lazySet(r1);
    }

    private boolean writeToQueue(AtomicReferenceArray<Object> r1, T r2, long r3, int r5) {
        soElement(r1, r5, r2);
        soProducerIndex(r3 + 1);
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
    L3:
        if (poll() != null) goto L3;
        if (isEmpty() == false) goto L3;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        if (lvProducerIndex() != lvConsumerIndex()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T r11) {
        if (r11 == null) goto L18;
        AtomicReferenceArray<Object> r1 = this.producerBuffer;
        long r3 = lpProducerIndex();
        int r0 = this.producerMask;
        int r5 = calcWrappedOffset(r3, r0);
        if (r3 < this.producerLookAhead) goto L6;
        long r6 = ((long) this.producerLookAheadStep) + r3;
        if (lvElement(r1, calcWrappedOffset(r6, r0)) != null) goto L12;
        this.producerLookAhead = r6 - 1;
        return writeToQueue(r1, r11, r3, r5);
    L12:
        if (lvElement(r1, calcWrappedOffset(1 + r3, r0)) == null) goto L14;
        resize(r1, r3, r5, r11, r0);
        return true;
    L14:
        return writeToQueue(r1, r11, r3, r5);
    L6:
        return writeToQueue(r1, r11, r3, r5);
    L18:
        throw new NullPointerException("Null is not a valid element");
    }

    public T peek() {
        AtomicReferenceArray<Object> r0 = this.consumerBuffer;
        long r1 = lpConsumerIndex();
        int r3 = this.consumerMask;
        T r4 = (T) lvElement(r0, calcWrappedOffset(r1, r3));
        if (r4 == HAS_NEXT) goto L5;
        return r4;
    L5:
        return newBufferPeek(lvNextBufferAndUnlink(r0, r3 + 1), r1, r3);
    }

    @Override // io.reactivex.internal.fuseable.SimplePlainQueue, io.reactivex.internal.fuseable.SimpleQueue
    @Nullable
    public T poll() {
        AtomicReferenceArray<Object> r0 = this.consumerBuffer;
        long r1 = lpConsumerIndex();
        int r3 = this.consumerMask;
        int r4 = calcWrappedOffset(r1, r3);
        T r5 = (T) lvElement(r0, r4);
        if (r5 != HAS_NEXT) goto L5;
        boolean r6 = true;
    L7:
        if (r5 == null) goto L11;
        if (r6 == true) goto L11;
        soElement(r0, r4, null);
        soConsumerIndex(r1 + 1);
        return r5;
    L11:
        if (r6 == true) goto L13;
        return null;
    L13:
        return newBufferPoll(lvNextBufferAndUnlink(r0, r3 + 1), r1, r3);
    L5:
        r6 = false;
        goto L7
    }

    public int size() {
        long r0 = lvConsumerIndex();
    L3:
        long r2 = lvProducerIndex();
        long r4 = lvConsumerIndex();
        if (r0 == r4) goto L6;
        r0 = r4;
        goto L3
    L6:
        return (int) (r2 - r4);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T r9, T r10) {
        AtomicReferenceArray<Object> r0 = this.producerBuffer;
        long r1 = lvProducerIndex();
        int r3 = this.producerMask;
        long r4 = 2 + r1;
        if (lvElement(r0, calcWrappedOffset(r4, r3)) != null) goto L5;
        int r2 = calcWrappedOffset(r1, r3);
        soElement(r0, r2 + 1, r10);
        soElement(r0, r2, r9);
        soProducerIndex(r4);
        return true;
    L5:
        AtomicReferenceArray<Object> r7 = new AtomicReferenceArray(r0.length());
        this.producerBuffer = r7;
        int r5 = calcWrappedOffset(r1, r3);
        soElement(r7, r5 + 1, r10);
        soElement(r7, r5, r9);
        soNext(r0, r7);
        soElement(r0, r5, HAS_NEXT);
        soProducerIndex(r4);
        return true;
    }
}
