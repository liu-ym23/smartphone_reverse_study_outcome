package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedApi"})
public final class SavedStateRegistry {
    private static final String SAVED_COMPONENTS_KEY = "androidx.lifecycle.BundlableSavedStateRegistry.key";
    boolean mAllowingSavingState;
    private SafeIterableMap<String, SavedStateProvider> mComponents;
    private Recreator.SavedStateProvider mRecreatorProvider;
    private boolean mRestored;

    @Nullable
    private Bundle mRestoredState;

    public interface AutoRecreated {
        void onRecreated(@NonNull SavedStateRegistryOwner r1);
    }

    public interface SavedStateProvider {
        @NonNull
        Bundle saveState();
    }

    public SavedStateRegistry() {
        this.mComponents = new SafeIterableMap();
        this.mAllowingSavingState = true;
    }

    @Nullable
    @MainThread
    public Bundle consumeRestoredStateForKey(@NonNull String r4) {
        if (this.mRestored == false) goto L12;
        Bundle r0 = this.mRestoredState;
        if (r0 == null) goto L10;
        Bundle r1 = r0.getBundle(r4);
        this.mRestoredState.remove(r4);
        if (this.mRestoredState.isEmpty() == false) goto L9;
        this.mRestoredState = null;
    L9:
        return r1;
    L10:
        return null;
    L12:
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    @MainThread
    public boolean isRestored() {
        return this.mRestored;
    }

    @MainThread
    public void performRestore(@NonNull Lifecycle r2, @Nullable Bundle r3) {
        if (this.mRestored == true) goto L9;
        if (r3 == null) goto L6;
        this.mRestoredState = r3.getBundle(SAVED_COMPONENTS_KEY);
    L6:
        r2.addObserver(new AnonymousClass1(this));
        this.mRestored = true;
        return;
    L9:
        throw new IllegalStateException("SavedStateRegistry was already restored.");
    }

    @MainThread
    public void performSave(@NonNull Bundle r4) {
        Bundle r0 = new Bundle();
        Bundle r1 = this.mRestoredState;
        if (r1 == null) goto L5;
        r0.putAll(r1);
    L5:
        SafeIterableMap<String, SavedStateProvider>.IteratorWithAdditions r3 = this.mComponents.iteratorWithAdditions();
    L7:
        if (r3.hasNext() == false) goto L9;
        Map.Entry r2 = r3.next();
        r0.putBundle((String) r2.getKey(), ((SavedStateProvider) r2.getValue()).saveState());
        goto L7
    L9:
        r4.putBundle(SAVED_COMPONENTS_KEY, r0);
    }

    @MainThread
    public void registerSavedStateProvider(@NonNull String r1, @NonNull SavedStateProvider r2) {
        if (this.mComponents.putIfAbsent(r1, r2) != null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
    }

    @MainThread
    public void runOnNextRecreation(@NonNull Class<? extends AutoRecreated> r4) {
        if (this.mAllowingSavingState == false) goto L15;
        if (this.mRecreatorProvider != null) goto L16;
        this.mRecreatorProvider = new Recreator.SavedStateProvider(this);
    L16:
        r4.getDeclaredConstructor(null);     // Catch: NoSuchMethodException -> L11
        this.mRecreatorProvider.add(r4.getName());
        return;
    L11:
        e = move-exception;
        throw new IllegalArgumentException("Class" + r4.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
    L15:
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }

    @MainThread
    public void unregisterSavedStateProvider(@NonNull String r1) {
        this.mComponents.remove(r1);
    }
}
