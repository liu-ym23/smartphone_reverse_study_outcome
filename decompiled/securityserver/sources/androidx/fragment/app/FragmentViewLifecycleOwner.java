package androidx.fragment.app;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

/* JADX INFO: loaded from: classes.dex */
class FragmentViewLifecycleOwner implements LifecycleOwner {
    private LifecycleRegistry mLifecycleRegistry;

    public FragmentViewLifecycleOwner() {
        this.mLifecycleRegistry = null;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        initialize();
        return this.mLifecycleRegistry;
    }

    public void handleLifecycleEvent(@NonNull Lifecycle.Event r1) {
        this.mLifecycleRegistry.handleLifecycleEvent(r1);
    }

    public void initialize() {
        if (this.mLifecycleRegistry != null) goto L6;
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        return;
    }

    public boolean isInitialized() {
        if (this.mLifecycleRegistry == null) goto L5;
        return true;
    L5:
        return false;
    }
}
