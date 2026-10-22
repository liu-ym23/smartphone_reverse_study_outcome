package androidx.activity;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayDeque;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    @Nullable
    private final Runnable mFallbackOnBackPressed;
    final ArrayDeque<OnBackPressedCallback> mOnBackPressedCallbacks;

    public class LifecycleOnBackPressedCancellable implements LifecycleEventObserver, Cancellable {

        @Nullable
        private Cancellable mCurrentCancellable;
        private final Lifecycle mLifecycle;
        private final OnBackPressedCallback mOnBackPressedCallback;
        final /* synthetic */ OnBackPressedDispatcher this$0;

        public LifecycleOnBackPressedCancellable(@NonNull OnBackPressedDispatcher r1, @NonNull Lifecycle r2, OnBackPressedCallback r3) {
            this.this$0 = r1;
            this.mLifecycle = r2;
            this.mOnBackPressedCallback = r3;
            r2.addObserver(this);
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

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@NonNull LifecycleOwner r1, @NonNull Lifecycle.Event r2) {
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
    }

    public class OnBackPressedCancellable implements Cancellable {
        private final OnBackPressedCallback mOnBackPressedCallback;
        final /* synthetic */ OnBackPressedDispatcher this$0;

        public OnBackPressedCancellable(OnBackPressedDispatcher r1, OnBackPressedCallback r2) {
            this.this$0 = r1;
            this.mOnBackPressedCallback = r2;
        }

        @Override // androidx.activity.Cancellable
        public void cancel() {
            this.this$0.mOnBackPressedCallbacks.remove(this.mOnBackPressedCallback);
            this.mOnBackPressedCallback.removeCancellable(this);
        }
    }

    public OnBackPressedDispatcher() {
        this(null);
    }

    @MainThread
    public void addCallback(@NonNull OnBackPressedCallback r1) {
        addCancellableCallback(r1);
    }

    @NonNull
    @MainThread
    public Cancellable addCancellableCallback(@NonNull OnBackPressedCallback r2) {
        this.mOnBackPressedCallbacks.add(r2);
        OnBackPressedCancellable r0 = new OnBackPressedCancellable(this, r2);
        r2.addCancellable(r0);
        return r0;
    }

    @MainThread
    public boolean hasEnabledCallbacks() {
        Iterator<OnBackPressedCallback> r1 = this.mOnBackPressedCallbacks.descendingIterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        if (r1.next().isEnabled() == false) goto L4;
        return true;
    L9:
        return false;
    }

    @MainThread
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

    public OnBackPressedDispatcher(@Nullable Runnable r2) {
        this.mOnBackPressedCallbacks = new ArrayDeque();
        this.mFallbackOnBackPressed = r2;
    }

    @MainThread
    public void addCallback(@NonNull LifecycleOwner r3, @NonNull OnBackPressedCallback r4) {
        Lifecycle r5 = r3.getLifecycle();
        if (r5.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        r4.addCancellable(new LifecycleOnBackPressedCancellable(this, r5, r4));
    }
}
