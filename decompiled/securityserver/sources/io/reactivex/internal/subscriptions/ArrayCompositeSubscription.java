package io.reactivex.internal.subscriptions;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class ArrayCompositeSubscription extends AtomicReferenceArray<Subscription> implements Disposable {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeSubscription(int r1) {
        super(r1);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        int r0 = 0;
        if (get(0) == SubscriptionHelper.CANCELLED) goto L13;
        int r1 = length();
    L5:
        if (r0 >= r1) goto L19;
        Subscription r2 = get(r0);
        SubscriptionHelper r3 = SubscriptionHelper.CANCELLED;
        if (r2 == r3) goto L12;
        Subscription r4 = getAndSet(r0, r3);
        if (r4 == r3) goto L12;
        if (r4 == null) goto L12;
        r4.cancel();
    L12:
        r0 = r0 + 1;
        goto L5
    L19:
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get(0) != SubscriptionHelper.CANCELLED) goto L6;
        return true;
    L6:
        return false;
    }

    public Subscription replaceResource(int r3, Subscription r4) {
    L2:
        Subscription r0 = get(r3);
        if (r0 == SubscriptionHelper.CANCELLED) goto L4;
        if (compareAndSet(r3, r0, r4) == false) goto L2;
        return r0;
    L4:
        if (r4 == null) goto L14;
        r4.cancel();
        return null;
    L14:
        return null;
    }

    public boolean setResource(int r3, Subscription r4) {
    L2:
        Subscription r0 = get(r3);
        if (r0 == SubscriptionHelper.CANCELLED) goto L4;
        if (compareAndSet(r3, r0, r4) == false) goto L2;
        if (r0 == null) goto L18;
        r0.cancel();
        return true;
    L18:
        return true;
    L4:
        if (r4 == null) goto L17;
        r4.cancel();
        return false;
    L17:
        return false;
    }
}
