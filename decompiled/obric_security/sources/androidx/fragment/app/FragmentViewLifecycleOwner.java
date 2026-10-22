package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;

/* JADX INFO: loaded from: classes.dex */
class FragmentViewLifecycleOwner implements HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, ViewModelStoreOwner {
    private ViewModelProvider.Factory mDefaultFactory;
    private final Fragment mFragment;
    private LifecycleRegistry mLifecycleRegistry;
    private SavedStateRegistryController mSavedStateRegistryController;
    private final ViewModelStore mViewModelStore;

    FragmentViewLifecycleOwner(Fragment r2, ViewModelStore r3) {
        this.mLifecycleRegistry = null;
        this.mSavedStateRegistryController = null;
        this.mFragment = r2;
        this.mViewModelStore = r3;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        initialize();
        return this.mViewModelStore;
    }

    void initialize() {
        if (this.mLifecycleRegistry != null) goto L6;
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        this.mSavedStateRegistryController = SavedStateRegistryController.create(this);
        return;
    }

    boolean isInitialized() {
        if (this.mLifecycleRegistry == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        initialize();
        return this.mLifecycleRegistry;
    }

    void setCurrentState(Lifecycle.State r1) {
        this.mLifecycleRegistry.setCurrentState(r1);
    }

    void handleLifecycleEvent(Lifecycle.Event r1) {
        this.mLifecycleRegistry.handleLifecycleEvent(r1);
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        ViewModelProvider.Factory r0 = this.mFragment.getDefaultViewModelProviderFactory();
        if (r0.equals(this.mFragment.mDefaultFactory) == true) goto L7;
        this.mDefaultFactory = r0;
        return r0;
    L7:
        if (this.mDefaultFactory != null) goto L18;
        Context r1 = this.mFragment.requireContext().getApplicationContext();
    L10:
        if ((r1 instanceof ContextWrapper) == false) goto L15;
        if ((r1 instanceof Application) == true) goto L13;
        r1 = ((ContextWrapper) r1).getBaseContext();
        goto L10
    L13:
        Application r2 = (Application) r1;
    L16:
        this.mDefaultFactory = new SavedStateViewModelFactory(r2, this, this.mFragment.getArguments());
        goto L18
    L15:
        r2 = null;
    L18:
        return this.mDefaultFactory;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public SavedStateRegistry getSavedStateRegistry() {
        initialize();
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    void performRestore(Bundle r1) {
        this.mSavedStateRegistryController.performRestore(r1);
    }

    void performSave(Bundle r1) {
        this.mSavedStateRegistryController.performSave(r1);
    }
}
