package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractSavedStateViewModelFactory extends ViewModelProvider.OnRequeryFactory implements ViewModelProvider.Factory {
    static final String TAG_SAVED_STATE_HANDLE_CONTROLLER = "androidx.lifecycle.savedstate.vm.tag";
    private Bundle mDefaultArgs;
    private Lifecycle mLifecycle;
    private SavedStateRegistry mSavedStateRegistry;

    public AbstractSavedStateViewModelFactory() {
    }

    @SuppressLint({"LambdaLast"})
    public AbstractSavedStateViewModelFactory(@NonNull SavedStateRegistryOwner r2, @Nullable Bundle r3) {
        this.mSavedStateRegistry = r2.getSavedStateRegistry();
        this.mLifecycle = r2.getLifecycle();
        this.mDefaultArgs = r3;
    }

    @NonNull
    private <T extends ViewModel> T create(@NonNull String r4, @NonNull Class<T> r5) {
        SavedStateHandleController r0 = LegacySavedStateHandleController.create(this.mSavedStateRegistry, this.mLifecycle, r4, this.mDefaultArgs);
        T r3 = (T) create(r4, r5, r0.getHandle());
        r3.setTagIfAbsent(TAG_SAVED_STATE_HANDLE_CONTROLLER, r0);
        return r3;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    @NonNull
    public final <T extends ViewModel> T create(@NonNull Class<T> r3) {
        String r0 = r3.getCanonicalName();
        if (r0 == null) goto L11;
        if (this.mLifecycle == null) goto L9;
        return (T) create(r0, r3);
    L9:
        throw new UnsupportedOperationException("AbstractSavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
    L11:
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    @NonNull
    public final <T extends ViewModel> T create(@NonNull Class<T> r3, @NonNull CreationExtras r4) {
        String r0 = (String) r4.get(ViewModelProvider.NewInstanceFactory.VIEW_MODEL_KEY);
        if (r0 == null) goto L11;
        if (this.mSavedStateRegistry == null) goto L9;
        return (T) create(r0, r3);
    L9:
        return (T) create(r0, r3, SavedStateHandleSupport.createSavedStateHandle(r4));
    L11:
        throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
    }

    @NonNull
    protected abstract <T extends ViewModel> T create(@NonNull String r1, @NonNull Class<T> r2, @NonNull SavedStateHandle r3);

    @Override // androidx.lifecycle.ViewModelProvider.OnRequeryFactory
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onRequery(@NonNull ViewModel r2) {
        SavedStateRegistry r0 = this.mSavedStateRegistry;
        if (r0 == null) goto L6;
        LegacySavedStateHandleController.attachHandleIfNeeded(r2, r0, this.mLifecycle);
        return;
    }
}
