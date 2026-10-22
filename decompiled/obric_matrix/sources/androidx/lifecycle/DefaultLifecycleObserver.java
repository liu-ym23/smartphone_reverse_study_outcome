package androidx.lifecycle;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface DefaultLifecycleObserver extends FullLifecycleObserver {
    @Override // androidx.lifecycle.FullLifecycleObserver
    default void onCreate(@NonNull LifecycleOwner r1) {
    }

    @Override // androidx.lifecycle.FullLifecycleObserver
    default void onDestroy(@NonNull LifecycleOwner r1) {
    }

    @Override // androidx.lifecycle.FullLifecycleObserver
    default void onPause(@NonNull LifecycleOwner r1) {
    }

    @Override // androidx.lifecycle.FullLifecycleObserver
    default void onResume(@NonNull LifecycleOwner r1) {
    }

    @Override // androidx.lifecycle.FullLifecycleObserver
    default void onStart(@NonNull LifecycleOwner r1) {
    }

    @Override // androidx.lifecycle.FullLifecycleObserver
    default void onStop(@NonNull LifecycleOwner r1) {
    }
}
