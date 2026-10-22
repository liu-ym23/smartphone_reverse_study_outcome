package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;

/* JADX INFO: loaded from: classes.dex */
class FragmentViewLifecycleOwner implements HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, ViewModelStoreOwner {
    private ViewModelProvider.Factory mDefaultFactory;
    private final Fragment mFragment;
    private LifecycleRegistry mLifecycleRegistry;
    private final Runnable mRestoreViewSavedStateRunnable;
    private SavedStateRegistryController mSavedStateRegistryController;
    private final ViewModelStore mViewModelStore;

    FragmentViewLifecycleOwner(Fragment r2, ViewModelStore r3, Runnable r4) {
        this.mLifecycleRegistry = null;
        this.mSavedStateRegistryController = null;
        this.mFragment = r2;
        this.mViewModelStore = r3;
        this.mRestoreViewSavedStateRunnable = r4;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        initialize();
        return this.mViewModelStore;
    }

    void initialize() {
        if (this.mLifecycleRegistry != null) goto L6;
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        SavedStateRegistryController r0 = SavedStateRegistryController.create(this);
        this.mSavedStateRegistryController = r0;
        r0.performAttach();
        this.mRestoreViewSavedStateRunnable.run();
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
        Fragment r3 = this.mFragment;
        this.mDefaultFactory = new SavedStateViewModelFactory(r2, r3, r3.getArguments());
        goto L18
    L15:
        r2 = null;
    L18:
        return this.mDefaultFactory;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        Context r0 = this.mFragment.requireContext().getApplicationContext();
    L4:
        if ((r0 instanceof ContextWrapper) == false) goto L9;
        if ((r0 instanceof Application) == true) goto L7;
        r0 = ((ContextWrapper) r0).getBaseContext();
        goto L4
    L7:
        Application r1 = (Application) r0;
    L10:
        MutableCreationExtras r2 = new MutableCreationExtras();
        if (r1 == null) goto L13;
        r2.set(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY, r1);
    L13:
        r2.set(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, this.mFragment);
        r2.set(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, this);
        if (this.mFragment.getArguments() == null) goto L16;
        r2.set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, this.mFragment.getArguments());
    L16:
        return r2;
    L9:
        r1 = null;
        goto L10
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
