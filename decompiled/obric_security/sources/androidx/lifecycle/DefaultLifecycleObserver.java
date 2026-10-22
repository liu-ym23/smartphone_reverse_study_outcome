package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
public interface DefaultLifecycleObserver extends FullLifecycleObserver {
    @Override // androidx.lifecycle.FullLifecycleObserver
    default void onCreate(LifecycleOwner r1) {
    }

    @Override // androidx.lifecycle.FullLifecycleObserver
    default void onDestroy(LifecycleOwner r1) {
    }

    @Override // androidx.lifecycle.FullLifecycleObserver
    default void onPause(LifecycleOwner r1) {
    }

    @Override // androidx.lifecycle.FullLifecycleObserver
    default void onResume(LifecycleOwner r1) {
    }

    @Override // androidx.lifecycle.FullLifecycleObserver
    default void onStart(LifecycleOwner r1) {
    }

    @Override // androidx.lifecycle.FullLifecycleObserver
    default void onStop(LifecycleOwner r1) {
    }
}
