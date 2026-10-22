package androidx.lifecycle;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
class SingleGeneratedAdapterObserver implements LifecycleEventObserver {
    private final GeneratedAdapter mGeneratedAdapter;

    SingleGeneratedAdapterObserver(GeneratedAdapter r1) {
        this.mGeneratedAdapter = r1;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner r4, @NonNull Lifecycle.Event r5) {
        this.mGeneratedAdapter.callMethods(r4, r5, false, null);
        this.mGeneratedAdapter.callMethods(r4, r5, true, null);
    }
}
