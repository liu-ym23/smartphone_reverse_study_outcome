package androidx.lifecycle;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
class ReflectiveGenericLifecycleObserver implements LifecycleEventObserver {
    private final ClassesInfoCache.CallbackInfo mInfo;
    private final Object mWrapped;

    ReflectiveGenericLifecycleObserver(Object r2) {
        this.mWrapped = r2;
        this.mInfo = ClassesInfoCache.sInstance.getInfo(r2.getClass());
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner r2, @NonNull Lifecycle.Event r3) {
        this.mInfo.invokeCallbacks(r2, r3, this.mWrapped);
    }
}
