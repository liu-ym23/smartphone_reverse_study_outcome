package androidx.activity;

import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.core.os.BuildCompat;
import androidx.core.util.Consumer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class OnBackPressedDispatcher {
    private boolean mBackInvokedCallbackRegistered;
    private Consumer<Boolean> mEnabledConsumer;
    private final Runnable mFallbackOnBackPressed;
    private OnBackInvokedDispatcher mInvokedDispatcher;
    private OnBackInvokedCallback mOnBackInvokedCallback;
    final ArrayDeque<OnBackPressedCallback> mOnBackPressedCallbacks;

    static class Api33Impl {
        private Api33Impl() {
        }

        static void registerOnBackInvokedCallback(Object r0, int r1, Object r2) {
            ((OnBackInvokedDispatcher) r0).registerOnBackInvokedCallback(r1, (OnBackInvokedCallback) r2);
        }

        static void unregisterOnBackInvokedCallback(Object r0, Object r1) {
            ((OnBackInvokedDispatcher) r0).unregisterOnBackInvokedCallback((OnBackInvokedCallback) r1);
        }

        static OnBackInvokedCallback createOnBackInvokedCallback(Runnable r1) {
            Objects.requireNonNull(r1);
            return new OnBackPressedDispatcher$Api33Impl$$ExternalSyntheticLambda0(r1);
        }
    }

    private class LifecycleOnBackPressedCancellable implements LifecycleEventObserver, Cancellable {
        private Cancellable mCurrentCancellable;
        private final Lifecycle mLifecycle;
        private final OnBackPressedCallback mOnBackPressedCallback;
        final /* synthetic */ OnBackPressedDispatcher this$0;

        LifecycleOnBackPressedCancellable(OnBackPressedDispatcher r1, Lifecycle r2, OnBackPressedCallback r3) {
            this.this$0 = r1;
            this.mLifecycle = r2;
            this.mOnBackPressedCallback = r3;
            r2.addObserver(this);
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner r1, Lifecycle.Event r2) {
            if (r2 != Lifecycle.Event.ON_START) goto L6;
            this.mCurrentCancellable = this.this$0.addCancellableCallback(this.mOnBackPressedCallback);
            return;
        L6:
            if (r2 != Lifecycle.Event.ON_STOP) goto L11;
            Cancellable r0 = this.mCurrentCancellable;
            if (r0 == null) goto L15;
            r0.cancel();
            return;
        L15:
            return;
        L11:
            if (r2 != Lifecycle.Event.ON_DESTROY) goto L17;
            cancel();
            return;
        }

        @Override // androidx.activity.Cancellable
        public void cancel() {
            this.mLifecycle.removeObserver(this);
            this.mOnBackPressedCallback.removeCancellable(this);
            Cancellable r0 = this.mCurrentCancellable;
            if (r0 == null) goto L6;
            r0.cancel();
            this.mCurrentCancellable = null;
            return;
        }
    }

    private class OnBackPressedCancellable implements Cancellable {
        private final OnBackPressedCallback mOnBackPressedCallback;
        final /* synthetic */ OnBackPressedDispatcher this$0;

        OnBackPressedCancellable(OnBackPressedDispatcher r1, OnBackPressedCallback r2) {
            this.this$0 = r1;
            this.mOnBackPressedCallback = r2;
        }

        @Override // androidx.activity.Cancellable
        public void cancel() {
            this.this$0.mOnBackPressedCallbacks.remove(this.mOnBackPressedCallback);
            this.mOnBackPressedCallback.removeCancellable(this);
            if (BuildCompat.isAtLeastT() == false) goto L6;
            this.mOnBackPressedCallback.setIsEnabledConsumer(null);
            this.this$0.updateBackInvokedCallbackState();
            return;
        }
    }

    public void setOnBackInvokedDispatcher(OnBackInvokedDispatcher r1) {
        this.mInvokedDispatcher = r1;
        updateBackInvokedCallbackState();
    }

    void updateBackInvokedCallbackState() {
        boolean r0 = hasEnabledCallbacks();
        OnBackInvokedDispatcher r1 = this.mInvokedDispatcher;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r0 == true) goto L7;
    L9:
        if (r0 == false) goto L11;
        return;
    L11:
        if (this.mBackInvokedCallbackRegistered == false) goto L17;
        Api33Impl.unregisterOnBackInvokedCallback(r1, this.mOnBackInvokedCallback);
        this.mBackInvokedCallbackRegistered = false;
        return;
    L17:
        return;
    L7:
        if (this.mBackInvokedCallbackRegistered == true) goto L9;
        Api33Impl.registerOnBackInvokedCallback(r1, 0, this.mOnBackInvokedCallback);
        this.mBackInvokedCallbackRegistered = true;
    }

    public OnBackPressedDispatcher() {
        this(null);
    }

    public OnBackPressedDispatcher(Runnable r2) {
        this.mOnBackPressedCallbacks = new ArrayDeque();
        this.mBackInvokedCallbackRegistered = false;
        this.mFallbackOnBackPressed = r2;
        if (BuildCompat.isAtLeastT() == false) goto L6;
        this.mEnabledConsumer = new OnBackPressedDispatcher$$ExternalSyntheticLambda0(this);
        this.mOnBackInvokedCallback = Api33Impl.createOnBackInvokedCallback(new OnBackPressedDispatcher$$ExternalSyntheticLambda1(this));
        return;
    }

    /* JADX INFO: renamed from: lambda$new$0$androidx-activity-OnBackPressedDispatcher, reason: not valid java name */
    /* synthetic */ void m3lambda$new$0$androidxactivityOnBackPressedDispatcher(Boolean r1) {
        if (BuildCompat.isAtLeastT() == false) goto L6;
        updateBackInvokedCallbackState();
        return;
    }

    public void addCallback(OnBackPressedCallback r1) {
        addCancellableCallback(r1);
    }

    Cancellable addCancellableCallback(OnBackPressedCallback r3) {
        this.mOnBackPressedCallbacks.add(r3);
        OnBackPressedCancellable r0 = new OnBackPressedCancellable(this, r3);
        r3.addCancellable(r0);
        if (BuildCompat.isAtLeastT() == false) goto L5;
        updateBackInvokedCallbackState();
        r3.setIsEnabledConsumer(this.mEnabledConsumer);
    L5:
        return r0;
    }

    public void addCallback(LifecycleOwner r3, OnBackPressedCallback r4) {
        Lifecycle r5 = r3.getLifecycle();
        if (r5.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        r4.addCancellable(new LifecycleOnBackPressedCancellable(this, r5, r4));
        if (BuildCompat.isAtLeastT() == false) goto L9;
        updateBackInvokedCallbackState();
        r4.setIsEnabledConsumer(this.mEnabledConsumer);
        return;
    }

    public boolean hasEnabledCallbacks() {
        Iterator<OnBackPressedCallback> r1 = this.mOnBackPressedCallbacks.descendingIterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        if (r1.next().isEnabled() == false) goto L4;
        return true;
    L9:
        return false;
    }

    public void onBackPressed() {
        Iterator<OnBackPressedCallback> r0 = this.mOnBackPressedCallbacks.descendingIterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        OnBackPressedCallback r1 = r0.next();
        if (r1.isEnabled() == false) goto L4;
        r1.handleOnBackPressed();
        return;
    L9:
        Runnable r3 = this.mFallbackOnBackPressed;
        if (r3 == null) goto L16;
        r3.run();
        return;
    }
}
