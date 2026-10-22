package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.BlockingSubscriber;
import io.reactivex.internal.subscribers.BoundedSubscriber;
import io.reactivex.internal.subscribers.LambdaSubscriber;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.BlockingIgnoringReceiver;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.LinkedBlockingQueue;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableBlockingSubscribe {
    private FlowableBlockingSubscribe() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> void subscribe(Publisher<? extends T> r3, Subscriber<? super T> r4) {
        LinkedBlockingQueue r0 = new LinkedBlockingQueue();
        BlockingSubscriber r1 = new BlockingSubscriber(r0);
        r3.subscribe(r1);
    L23:
        if (r1.isCancelled() == true) goto L31;
        Object r5 = r0.poll();     // Catch: InterruptedException -> L20
        if (r5 != null) goto L13;
        if (r1.isCancelled() == true) goto L32;
        BlockingHelper.verifyNonBlocking();     // Catch: InterruptedException -> L20
        r5 = r0.take();     // Catch: InterruptedException -> L20
        goto L13
    L32:
        return;
    L13:
        if (r1.isCancelled() == true) goto L33;
        if (r5 == BlockingSubscriber.TERMINATED) goto L34;
        if (NotificationLite.acceptFull(r5, r4) == false) goto L23;
        return;
    L34:
        return;
    L33:
        return;
    L31:
        return;
    L20:
        e = move-exception;
        r1.cancel();
        r4.onError(e);
    }

    public static <T> void subscribe(Publisher<? extends T> r4) {
        BlockingIgnoringReceiver r0 = new BlockingIgnoringReceiver();
        LambdaSubscriber r1 = new LambdaSubscriber(Functions.emptyConsumer(), r0, r0, Functions.REQUEST_MAX);
        r4.subscribe(r1);
        BlockingHelper.awaitForComplete(r0, r1);
        Throwable r5 = r0.error;
        if (r5 != null) goto L6;
        return;
    L6:
        throw ExceptionHelper.wrapOrThrow(r5);
    }

    public static <T> void subscribe(Publisher<? extends T> r2, Consumer<? super T> r3, Consumer<? super Throwable> r4, Action r5) {
        ObjectHelper.requireNonNull(r3, "onNext is null");
        ObjectHelper.requireNonNull(r4, "onError is null");
        ObjectHelper.requireNonNull(r5, "onComplete is null");
        subscribe(r2, new LambdaSubscriber(r3, r4, r5, Functions.REQUEST_MAX));
    }

    public static <T> void subscribe(Publisher<? extends T> r7, Consumer<? super T> r8, Consumer<? super Throwable> r9, Action r10, int r11) {
        ObjectHelper.requireNonNull(r8, "onNext is null");
        ObjectHelper.requireNonNull(r9, "onError is null");
        ObjectHelper.requireNonNull(r10, "onComplete is null");
        ObjectHelper.verifyPositive(r11, "number > 0 required");
        subscribe(r7, new BoundedSubscriber(r8, r9, r10, Functions.boundedConsumer(r11), r11));
    }
}
