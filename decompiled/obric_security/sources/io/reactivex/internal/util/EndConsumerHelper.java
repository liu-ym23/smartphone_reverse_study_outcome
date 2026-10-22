package io.reactivex.internal.util;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes5.dex */
public final class EndConsumerHelper {
    private EndConsumerHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static boolean validate(Disposable r1, Disposable r2, Class<?> r3) {
        ObjectHelper.requireNonNull(r2, "next is null");
        if (r1 == null) goto L9;
        r2.dispose();
        if (r1 == DisposableHelper.DISPOSED) goto L11;
        reportDoubleSubscription(r3);
        return false;
    L11:
        return false;
    L9:
        return true;
    }

    public static boolean setOnce(AtomicReference<Disposable> r1, Disposable r2, Class<?> r3) {
        ObjectHelper.requireNonNull(r2, "next is null");
        if (b0$$ExternalSyntheticBackport0.m(r1, null, r2) == true) goto L9;
        r2.dispose();
        if (r1.get() == DisposableHelper.DISPOSED) goto L11;
        reportDoubleSubscription(r3);
        return false;
    L11:
        return false;
    L9:
        return true;
    }

    public static boolean validate(Subscription r1, Subscription r2, Class<?> r3) {
        ObjectHelper.requireNonNull(r2, "next is null");
        if (r1 == null) goto L9;
        r2.cancel();
        if (r1 == SubscriptionHelper.CANCELLED) goto L11;
        reportDoubleSubscription(r3);
        return false;
    L11:
        return false;
    L9:
        return true;
    }

    public static boolean setOnce(AtomicReference<Subscription> r1, Subscription r2, Class<?> r3) {
        ObjectHelper.requireNonNull(r2, "next is null");
        if (b0$$ExternalSyntheticBackport0.m(r1, null, r2) == true) goto L9;
        r2.cancel();
        if (r1.get() == SubscriptionHelper.CANCELLED) goto L11;
        reportDoubleSubscription(r3);
        return false;
    L11:
        return false;
    L9:
        return true;
    }

    public static String composeMessage(String r2) {
        return "It is not allowed to subscribe with a(n) " + r2 + " multiple times. Please create a fresh instance of " + r2 + " and subscribe that to the target source instead.";
    }

    public static void reportDoubleSubscription(Class<?> r1) {
        RxJavaPlugins.onError(new ProtocolViolationException(composeMessage(r1.getName())));
    }
}
