package io.reactivex.internal.subscriptions;

import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes5.dex */
public final enum SubscriptionHelper extends Enum<SubscriptionHelper> implements Subscription {
    private static final /* synthetic */ SubscriptionHelper[] $VALUES = null;
    public static final SubscriptionHelper CANCELLED = null;

    @Override // org.reactivestreams.Subscription
    public void cancel() {
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r1) {
    }

    private SubscriptionHelper(String r1, int r2) {
        super(r1, r2);
    }

    public static SubscriptionHelper valueOf(String r1) {
        return (SubscriptionHelper) Enum.valueOf(SubscriptionHelper.class, r1);
    }

    public static SubscriptionHelper[] values() {
        return (SubscriptionHelper[]) $VALUES.clone();
    }

    static {
        SubscriptionHelper r0 = new SubscriptionHelper("CANCELLED", 0);
        CANCELLED = r0;
        $VALUES = new SubscriptionHelper[]{r0};
    }

    public static boolean validate(Subscription r1, Subscription r2) {
        if (r2 != null) goto L6;
        RxJavaPlugins.onError(new NullPointerException("next is null"));
        return false;
    L6:
        if (r1 == null) goto L9;
        r2.cancel();
        reportSubscriptionSet();
        return false;
    L9:
        return true;
    }

    public static void reportSubscriptionSet() {
        RxJavaPlugins.onError(new ProtocolViolationException("Subscription already set!"));
    }

    public static boolean validate(long r3) {
        if (r3 > 0) goto L6;
        RxJavaPlugins.onError(new IllegalArgumentException("n > 0 required but it was " + r3));
        return false;
    L6:
        return true;
    }

    public static void reportMoreProduced(long r3) {
        RxJavaPlugins.onError(new ProtocolViolationException("More produced than requested: " + r3));
    }

    public static boolean set(AtomicReference<Subscription> r2, Subscription r3) {
    L2:
        Subscription r0 = r2.get();
        if (r0 == CANCELLED) goto L4;
        if (b0$$ExternalSyntheticBackport0.m(r2, r0, r3) == false) goto L2;
        if (r0 == null) goto L18;
        r0.cancel();
        return true;
    L18:
        return true;
    L4:
        if (r3 == null) goto L17;
        r3.cancel();
        return false;
    L17:
        return false;
    }

    public static boolean setOnce(AtomicReference<Subscription> r1, Subscription r2) {
        ObjectHelper.requireNonNull(r2, "s is null");
        if (b0$$ExternalSyntheticBackport0.m(r1, null, r2) == true) goto L9;
        r2.cancel();
        if (r1.get() == CANCELLED) goto L11;
        reportSubscriptionSet();
        return false;
    L11:
        return false;
    L9:
        return true;
    }

    public static boolean replace(AtomicReference<Subscription> r2, Subscription r3) {
    L2:
        Subscription r0 = r2.get();
        if (r0 == CANCELLED) goto L4;
        if (b0$$ExternalSyntheticBackport0.m(r2, r0, r3) == false) goto L2;
        return true;
    L4:
        if (r3 == null) goto L15;
        r3.cancel();
        return false;
    L15:
        return false;
    }

    public static boolean cancel(AtomicReference<Subscription> r2) {
        Subscription r0 = r2.get();
        SubscriptionHelper r1 = CANCELLED;
        if (r0 == r1) goto L10;
        Subscription r3 = r2.getAndSet(r1);
        if (r3 == r1) goto L13;
        if (r3 == null) goto L12;
        r3.cancel();
        return true;
    L12:
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public static boolean deferredSetOnce(AtomicReference<Subscription> r2, AtomicLong r3, Subscription r4) {
        if (setOnce(r2, r4) == false) goto L9;
        long r5 = r3.getAndSet(0);
        if (r5 == 0) goto L11;
        r4.request(r5);
        return true;
    L11:
        return true;
    L9:
        return false;
    }

    public static void deferredRequest(AtomicReference<Subscription> r2, AtomicLong r3, long r4) {
        Subscription r0 = r2.get();
        if (r0 == null) goto L6;
        r0.request(r4);
        return;
    L6:
        if (validate(r4) == false) goto L14;
        BackpressureHelper.add(r3, r4);
        Subscription r5 = r2.get();
        if (r5 == null) goto L15;
        long r1 = r3.getAndSet(0);
        if (r1 == 0) goto L16;
        r5.request(r1);
        return;
    L16:
        return;
    L15:
        return;
    }

    public static boolean setOnce(AtomicReference<Subscription> r0, Subscription r1, long r2) {
        if (setOnce(r0, r1) == false) goto L6;
        r1.request(r2);
        return true;
    L6:
        return false;
    }
}
