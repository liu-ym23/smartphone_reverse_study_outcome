package com.ttnet.org.chromium.base.supplier;

import com.ttnet.org.chromium.base.Callback;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public class OneShotCallback<E> {
    private final Callback<E> mCallback;
    private final Callback<E> mCallbackWrapper;
    private final WeakReference<ObservableSupplier<E>> mWeakSupplier;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.supplier.OneShotCallback$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class CallbackWrapper implements Callback<E> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final /* synthetic */ OneShotCallback this$0;

        static {
        }

        private CallbackWrapper(OneShotCallback r1) {
            this.this$0 = r1;
        }

        /* synthetic */ CallbackWrapper(OneShotCallback r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.ttnet.org.chromium.base.Callback
        public void onResult(E r2) {
            OneShotCallback.access$100(this.this$0).onResult(r2);
            ((ObservableSupplier) OneShotCallback.access$200(this.this$0).get()).removeObserver(OneShotCallback.access$300(this.this$0));
        }
    }

    static /* synthetic */ Callback access$100(OneShotCallback r0) {
        return r0.mCallback;
    }

    static /* synthetic */ WeakReference access$200(OneShotCallback r0) {
        return r0.mWeakSupplier;
    }

    static /* synthetic */ Callback access$300(OneShotCallback r0) {
        return r0.mCallbackWrapper;
    }

    public OneShotCallback(ObservableSupplier<E> r3, Callback<E> r4) {
        CallbackWrapper r0 = new CallbackWrapper(this, null);
        this.mCallbackWrapper = r0;
        this.mWeakSupplier = new WeakReference(r3);
        this.mCallback = r4;
        r3.addObserver(r0);
    }
}
