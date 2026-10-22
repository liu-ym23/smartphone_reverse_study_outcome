package io.reactivex.disposables;

import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Future;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class Disposables {
    private Disposables() {
        throw new IllegalStateException("No instances!");
    }

    public static Disposable fromRunnable(Runnable r1) {
        ObjectHelper.requireNonNull(r1, "run is null");
        return new RunnableDisposable(r1);
    }

    public static Disposable fromAction(Action r1) {
        ObjectHelper.requireNonNull(r1, "run is null");
        return new ActionDisposable(r1);
    }

    public static Disposable fromFuture(Future<?> r1) {
        ObjectHelper.requireNonNull(r1, "future is null");
        return fromFuture(r1, true);
    }

    public static Disposable fromFuture(Future<?> r1, boolean r2) {
        ObjectHelper.requireNonNull(r1, "future is null");
        return new FutureDisposable(r1, r2);
    }

    public static Disposable fromSubscription(Subscription r1) {
        ObjectHelper.requireNonNull(r1, "subscription is null");
        return new SubscriptionDisposable(r1);
    }

    public static Disposable empty() {
        return fromRunnable(Functions.EMPTY_RUNNABLE);
    }

    public static Disposable disposed() {
        return EmptyDisposable.INSTANCE;
    }
}
