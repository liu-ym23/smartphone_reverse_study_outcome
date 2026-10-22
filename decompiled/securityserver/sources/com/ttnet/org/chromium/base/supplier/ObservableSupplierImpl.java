package com.ttnet.org.chromium.base.supplier;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.bytedance.securityserver.c;
import com.ttnet.org.chromium.base.Callback;
import com.ttnet.org.chromium.base.ObserverList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class ObservableSupplierImpl<E> implements ObservableSupplier<E> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static boolean sIgnoreThreadChecksForTesting;
    private final Handler mHandler;
    private E mObject;
    private final ObserverList<Callback<E>> mObservers;
    private final Thread mThread;

    public ObservableSupplierImpl() {
        this.mThread = Thread.currentThread();
        this.mHandler = new Handler();
        this.mObservers = new ObserverList();
    }

    public static /* synthetic */ void a(ObservableSupplierImpl r0, Object r1, Callback r2) {
        r0.lambda$addObserver$0(r1, r2);
    }

    private void checkThread() {
    }

    private /* synthetic */ void lambda$addObserver$0(Object r2, Callback r3) {
        if (this.mObject == r2) goto L5;
        return;
    L5:
        if (this.mObservers.hasObserver(r3) == false) goto L10;
        r3.onResult(this.mObject);
        return;
    }

    public static void setIgnoreThreadChecksForTesting(boolean r0) {
        sIgnoreThreadChecksForTesting = r0;
    }

    @Override // com.ttnet.org.chromium.base.supplier.ObservableSupplier
    public E addObserver(Callback<E> r5) {
        checkThread();
        this.mObservers.addObserver(r5);
        E r0 = this.mObject;
        if (r0 == null) goto L6;
        this.mHandler.post(new c(this, r0, r5, 1));
    L6:
        return this.mObject;
    }

    @Override // com.ttnet.org.chromium.base.supplier.Supplier
    @Nullable
    public E get() {
        checkThread();
        return this.mObject;
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
}
