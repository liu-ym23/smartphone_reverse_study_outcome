package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class QueueDrainHelper {
    static final long COMPLETED_MASK = Long.MIN_VALUE;
    static final long REQUESTED_MASK = Long.MAX_VALUE;

    private QueueDrainHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> boolean checkTerminated(boolean r2, boolean r3, Subscriber<?> r4, boolean r5, SimpleQueue<?> r6, QueueDrain<T, U> r7) {
        if (r7.cancelled() == false) goto L6;
        r6.clear();
        return true;
    L6:
        if (r2 == false) goto L21;
        if (r5 == false) goto L14;
        if (r3 == false) goto L23;
        Throwable r8 = r7.error();
        if (r8 == null) goto L12;
        r4.onError(r8);
    L13:
        return true;
    L12:
        r4.onComplete();
        goto L13
    L23:
        return false;
    L14:
        Throwable r9 = r7.error();
        if (r9 == null) goto L18;
        r6.clear();
        r4.onError(r9);
        return true;
    L18:
        if (r3 == false) goto L24;
        r4.onComplete();
        return true;
    L24:
        return false;
    L21:
        return false;
    }

    public static <T> SimpleQueue<T> createQueue(int r1) {
        if (r1 >= 0) goto L6;
        return new SpscLinkedArrayQueue(-r1);
    L6:
        return new SpscArrayQueue(r1);
    }

    public static <T, U> void drainLoop(SimplePlainQueue<T> r11, Observer<? super U> r12, boolean r13, Disposable r14, ObservableQueueDrain<T, U> r15) {
        int r1 = 1;
    L4:
        if (checkTerminated(r15.done(), r11.isEmpty(), r12, r13, r11, r14, r15) == true) goto L5;
    L6:
        boolean r3 = r15.done();
        T r2 = r11.poll();
        if (r2 != null) goto L9;
        boolean r10 = true;
    L11:
        if (checkTerminated(r3, r10, r12, r13, r11, r14, r15) == true) goto L12;
        if (r10 == true) goto L14;
        r15.accept(r12, r2);
        goto L6
    L14:
        r1 = r15.leave(-r1);
        if (r1 != 0) goto L4;
        return;
    L12:
        return;
    L9:
        r10 = false;
        goto L11
    }

    public static <T, U> void drainMaxLoop(SimplePlainQueue<T> r10, Subscriber<? super U> r11, boolean r12, Disposable r13, QueueDrain<T, U> r14) {
        int r1 = 1;
    L3:
        boolean r2 = r14.done();
        T r8 = r10.poll();
        if (r8 != null) goto L6;
        boolean r9 = true;
    L8:
        if (checkTerminated(r2, r9, r11, r12, r10, r14) == true) goto L9;
        if (r9 == true) goto L13;
        long r3 = r14.requested();
        if (r3 == 0) goto L23;
        if (r14.accept(r11, r8) == false) goto L3;
        if (r3 == REQUESTED_MASK) goto L3;
        r14.produced(1);
        goto L3
    L23:
        r10.clear();
        if (r13 == null) goto L26;
        r13.dispose();
    L26:
        r11.onError(new MissingBackpressureException("Could not emit value due to lack of requests."));
        return;
    L13:
        r1 = r14.leave(-r1);
        if (r1 != 0) goto L3;
        return;
    L9:
        if (r13 == null) goto L40;
        r13.dispose();
        return;
    L40:
        return;
    L6:
        r9 = false;
        goto L8
    }

    public static boolean isCancelled(BooleanSupplier r0) {
        return r0.getAsBoolean();
    L4:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        return true;
    }

    public static <T> void postComplete(Subscriber<? super T> r14, Queue<T> r15, AtomicLong r16, BooleanSupplier r17) {
        if (r15.isEmpty() == false) goto L7;
        r14.onComplete();
        return;
    L7:
        if (postCompleteDrain(r16.get(), r14, r15, r16, r17) == false) goto L9;
        return;
    L9:
        long r0 = r16.get();
        if ((r0 & COMPLETED_MASK) != 0) goto L11;
        long r8 = r0 | COMPLETED_MASK;
        if (r16.compareAndSet(r0, r8) == false) goto L9;
        if (r0 == 0) goto L21;
        postCompleteDrain(r8, r14, r15, r16, r17);
        return;
    L21:
        return;
    }

    public static <T> boolean postCompleteDrain(long r8, Subscriber<? super T> r10, Queue<T> r11, AtomicLong r12, BooleanSupplier r13) {
        long r2 = r8 & COMPLETED_MASK;
    L4:
        if (r2 != r8) goto L6;
        if (isCancelled(r13) == true) goto L15;
        if (r11.isEmpty() == true) goto L18;
        r8 = r12.get();
        if (r8 != r2) goto L4;
        long r3 = r12.addAndGet(-(r2 & REQUESTED_MASK));
        if ((REQUESTED_MASK & r3) == 0) goto L24;
        r8 = r3;
        r2 = r3 & COMPLETED_MASK;
        goto L4
    L24:
        return false;
    L18:
        r10.onComplete();
        return true;
    L15:
        return true;
    L6:
        if (isCancelled(r13) == true) goto L7;
        T r4 = r11.poll();
        if (r4 == null) goto L10;
        r10.onNext(r4);
        r2 = r2 + 1;
        goto L4
    L10:
        r10.onComplete();
        return true;
    L7:
        return true;
    }

    public static <T> boolean postCompleteRequest(long r14, Subscriber<? super T> r16, Queue<T> r17, AtomicLong r18, BooleanSupplier r19) {
    L3:
        long r2 = r18.get();
        long r4 = REQUESTED_MASK & r2;
        long r8 = r2 & COMPLETED_MASK;
        if (r18.compareAndSet(r2, BackpressureHelper.addCap(r4, r14) | r8) == false) goto L3;
        if (r2 != COMPLETED_MASK) goto L9;
        postCompleteDrain(r14 | COMPLETED_MASK, r16, r17, r18, r19);
        return true;
    L9:
        return false;
    }

    public static void request(Subscription r2, int r3) {
        if (r3 >= 0) goto L4;
        long r0 = REQUESTED_MASK;
    L5:
        r2.request(r0);
        return;
    L4:
        r0 = r3;
        goto L5
    }

    public static <T, U> boolean checkTerminated(boolean r2, boolean r3, Observer<?> r4, boolean r5, SimpleQueue<?> r6, Disposable r7, ObservableQueueDrain<T, U> r8) {
        if (r8.cancelled() == false) goto L6;
        r6.clear();
        r7.dispose();
        return true;
    L6:
        if (r2 == false) goto L28;
        if (r5 == false) goto L16;
        if (r3 == false) goto L30;
        if (r7 == null) goto L11;
        r7.dispose();
    L11:
        Throwable r9 = r8.error();
        if (r9 == null) goto L14;
        r4.onError(r9);
    L15:
        return true;
    L14:
        r4.onComplete();
        goto L15
    L30:
        return false;
    L16:
        Throwable r10 = r8.error();
        if (r10 == null) goto L23;
        r6.clear();
        if (r7 == null) goto L21;
        r7.dispose();
    L21:
        r4.onError(r10);
        return true;
    L23:
        if (r3 == false) goto L31;
        if (r7 == null) goto L26;
        r7.dispose();
    L26:
        r4.onComplete();
        return true;
    L31:
        return false;
    L28:
        return false;
    }
}
