package androidx.lifecycle;

import androidx.savedstate.SavedStateRegistry;

/* JADX INFO: loaded from: classes.dex */
final class SavedStateHandleController implements LifecycleEventObserver {
    private final SavedStateHandle mHandle;
    private boolean mIsAttached;
    private final String mKey;

    SavedStateHandleController(String r2, SavedStateHandle r3) {
        this.mIsAttached = false;
        this.mKey = r2;
        this.mHandle = r3;
    }

    boolean isAttached() {
        return this.mIsAttached;
    }

    void attachToLifecycle(SavedStateRegistry r2, Lifecycle r3) {
        if (this.mIsAttached == true) goto L7;
        this.mIsAttached = true;
        r3.addObserver(this);
        r2.registerSavedStateProvider(this.mKey, this.mHandle.savedStateProvider());
        return;
    L7:
        throw new IllegalStateException("Already attached to lifecycleOwner");
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
        if (r3 != Lifecycle.Event.ON_DESTROY) goto L6;
        this.mIsAttached = false;
        r2.getLifecycle().removeObserver(this);
        return;
    }

    SavedStateHandle getHandle() {
        return this.mHandle;
    }
}
