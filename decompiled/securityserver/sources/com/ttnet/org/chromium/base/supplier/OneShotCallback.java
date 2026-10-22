package com.ttnet.org.chromium.base.supplier;

import androidx.annotation.NonNull;
import com.ttnet.org.chromium.base.Callback;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class OneShotCallback<E> {
    private final Callback<E> mCallback;
    private final Callback<E> mCallbackWrapper;
    private final WeakReference<ObservableSupplier<E>> mWeakSupplier;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.supplier.OneShotCallback$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class CallbackWrapper implements Callback<E> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final /* synthetic */ OneShotCallback this$0;

        private CallbackWrapper(OneShotCallback r1) {
            this.this$0 = r1;
        }

        @Override // com.ttnet.org.chromium.base.Callback
        public void onResult(E r2) {
            OneShotCallback.access$100(this.this$0).onResult(r2);
            ((ObservableSupplier) OneShotCallback.access$200(this.this$0).get()).removeObserver(OneShotCallback.access$300(this.this$0));
        }

        public /* synthetic */ CallbackWrapper(OneShotCallback r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    public OneShotCallback(@NonNull ObservableSupplier<E> r3, @NonNull Callback<E> r4) {
        CallbackWrapper r0 = new CallbackWrapper(this, null);
        this.mCallbackWrapper = r0;
        this.mWeakSupplier = new WeakReference(r3);
        this.mCallback = r4;
        r3.addObserver(r0);
    }

    public static /* synthetic */ Callback access$100(OneShotCallback r0) {
        return r0.mCallback;
    }

    public static /* synthetic */ WeakReference access$200(OneShotCallback r0) {
        return r0.mWeakSupplier;
    }

    public static /* synthetic */ Callback access$300(OneShotCallback r0) {
        return r0.mCallbackWrapper;
    }
}
