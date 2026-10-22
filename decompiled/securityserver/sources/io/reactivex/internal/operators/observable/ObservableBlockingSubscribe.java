package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BlockingObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.BlockingIgnoringReceiver;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableBlockingSubscribe {
    private ObservableBlockingSubscribe() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> void subscribe(ObservableSource<? extends T> r3, Observer<? super T> r4) {
        LinkedBlockingQueue r0 = new LinkedBlockingQueue();
        BlockingObserver r1 = new BlockingObserver(r0);
        r4.onSubscribe(r1);
        r3.subscribe(r1);
    L4:
        if (r1.isDisposed() == true) goto L28;
        Object r5 = r0.poll();
        if (r5 != null) goto L14;
        r5 = r0.take();     // Catch: InterruptedException -> L10
    L10:
        e = move-exception;
        r1.dispose();
        r4.onError(e);
        return;
    L14:
        if (r1.isDisposed() == true) goto L29;
        if (r5 == BlockingObserver.TERMINATED) goto L19;
        if (NotificationLite.acceptFull(r5, r4) == false) goto L4;
        return;
    L19:
        return;
    L29:
        return;
    }

    public static <T> void subscribe(ObservableSource<? extends T> r4) {
        BlockingIgnoringReceiver r0 = new BlockingIgnoringReceiver();
        LambdaObserver r1 = new LambdaObserver(Functions.emptyConsumer(), r0, r0, Functions.emptyConsumer());
        r4.subscribe(r1);
        BlockingHelper.awaitForComplete(r0, r1);
        Throwable r5 = r0.error;
        if (r5 != null) goto L6;
        return;
    L6:
        throw ExceptionHelper.wrapOrThrow(r5);
    }

    public static <T> void subscribe(ObservableSource<? extends T> r2, Consumer<? super T> r3, Consumer<? super Throwable> r4, Action r5) {
        ObjectHelper.requireNonNull(r3, "onNext is null");
        ObjectHelper.requireNonNull(r4, "onError is null");
        ObjectHelper.requireNonNull(r5, "onComplete is null");
        subscribe(r2, new LambdaObserver(r3, r4, r5, Functions.emptyConsumer()));
    }
}
