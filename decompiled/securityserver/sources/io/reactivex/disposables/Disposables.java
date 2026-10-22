package io.reactivex.disposables;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Future;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class Disposables {
    private Disposables() {
        throw new IllegalStateException("No instances!");
    }

    @NonNull
    public static Disposable disposed() {
        return EmptyDisposable.INSTANCE;
    }

    @NonNull
    public static Disposable empty() {
        return fromRunnable(Functions.EMPTY_RUNNABLE);
    }

    @NonNull
    public static Disposable fromAction(@NonNull Action r1) {
        ObjectHelper.requireNonNull(r1, "run is null");
        return new ActionDisposable(r1);
    }

    @NonNull
    public static Disposable fromFuture(@NonNull Future<?> r1) {
        ObjectHelper.requireNonNull(r1, "future is null");
        return fromFuture(r1, true);
    }

    @NonNull
    public static Disposable fromRunnable(@NonNull Runnable r1) {
        ObjectHelper.requireNonNull(r1, "run is null");
        return new RunnableDisposable(r1);
    }

    @NonNull
    public static Disposable fromSubscription(@NonNull Subscription r1) {
        ObjectHelper.requireNonNull(r1, "subscription is null");
        return new SubscriptionDisposable(r1);
    }

    @NonNull
    public static Disposable fromFuture(@NonNull Future<?> r1, boolean r2) {
        ObjectHelper.requireNonNull(r1, "future is null");
        return new FutureDisposable(r1, r2);
    }
}
