package androidx.savedstate;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes.dex */
public final class SavedStateRegistryController {
    private final SavedStateRegistryOwner mOwner;
    private final SavedStateRegistry mRegistry;

    private SavedStateRegistryController(SavedStateRegistryOwner r1) {
        this.mOwner = r1;
        this.mRegistry = new SavedStateRegistry();
    }

    @NonNull
    public static SavedStateRegistryController create(@NonNull SavedStateRegistryOwner r1) {
        return new SavedStateRegistryController(r1);
    }

    @NonNull
    public SavedStateRegistry getSavedStateRegistry() {
        return this.mRegistry;
    }

    @MainThread
    public void performRestore(@Nullable Bundle r4) {
        Lifecycle r0 = this.mOwner.getLifecycle();
        if (r0.getCurrentState() != Lifecycle.State.INITIALIZED) goto L7;
        r0.addObserver(new Recreator(this.mOwner));
        this.mRegistry.performRestore(r0, r4);
        return;
    L7:
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
    }

    @MainThread
    public void performSave(@NonNull Bundle r1) {
        this.mRegistry.performSave(r1);
    }
}
