package com.ttnet.org.chromium.base.supplier;

import android.os.Handler;
import com.ttnet.org.chromium.base.Callback;
import com.ttnet.org.chromium.base.ObserverList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class ObservableSupplierImpl<E> implements ObservableSupplier<E> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static boolean sIgnoreThreadChecksForTesting;
    private final Handler mHandler;
    private E mObject;
    private final ObserverList<Callback<E>> mObservers;
    private final Thread mThread;

    static {
    }

    private void checkThread() {
    }

    public ObservableSupplierImpl() {
        this.mThread = Thread.currentThread();
        this.mHandler = new Handler();
        this.mObservers = new ObserverList();
    }

    @Override // com.ttnet.org.chromium.base.supplier.ObservableSupplier
    public E addObserver(final Callback<E> r4) {
        checkThread();
        this.mObservers.addObserver(r4);
        final E r0 = this.mObject;
        if (r0 == null) goto L6;
        this.mHandler.post(new ObservableSupplierImpl$$ExternalSyntheticLambda0(this, r0, r4));
    L6:
        return this.mObject;
    }

    /* JADX INFO: renamed from: lambda$addObserver$0$com-ttnet-org-chromium-base-supplier-ObservableSupplierImpl, reason: not valid java name */
    /* synthetic */ void m764xbb3c5488(Object r2, Callback r3) {
        if (this.mObject == r2) goto L5;
        return;
    L5:
        if (this.mObservers.hasObserver(r3) == false) goto L10;
        r3.onResult(this.mObject);
        return;
    }

    @Override // com.ttnet.org.chromium.base.supplier.ObservableSupplier
    public void removeObserver(Callback<E> r1) {
        checkThread();
        this.mObservers.removeObserver(r1);
    }

    public void set(E r3) {
        checkThread();
        if (r3 != this.mObject) goto L5;
        return;
    L5:
        this.mObject = r3;
        Iterator<Callback<E>> r4 = this.mObservers.iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        r4.next().onResult(this.mObject);
        goto L7
    }

    @Override // com.ttnet.org.chromium.base.supplier.Supplier
    public E get() {
        checkThread();
        return this.mObject;
    }

    public static void setIgnoreThreadChecksForTesting(boolean r0) {
        sIgnoreThreadChecksForTesting = r0;
    }
}
