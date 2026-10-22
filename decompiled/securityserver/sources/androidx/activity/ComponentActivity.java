package androidx.activity;

import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;

/* JADX INFO: loaded from: classes.dex */
public class ComponentActivity extends androidx.core.app.ComponentActivity implements LifecycleOwner, ViewModelStoreOwner, SavedStateRegistryOwner, OnBackPressedDispatcherOwner {

    @LayoutRes
    private int mContentLayoutId;
    private final LifecycleRegistry mLifecycleRegistry;
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final SavedStateRegistryController mSavedStateRegistryController;
    private ViewModelStore mViewModelStore;

    public static final class NonConfigurationInstances {
        Object custom;
        ViewModelStore viewModelStore;

        public NonConfigurationInstances() {
        }
    }

    public ComponentActivity() {
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        this.mSavedStateRegistryController = SavedStateRegistryController.create(this);
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new AnonymousClass1(this));
        if (getLifecycle() == null) goto L7;
        getLifecycle().addObserver(new AnonymousClass2(this));
        getLifecycle().addObserver(new AnonymousClass3(this));
        return;
    L7:
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    public static /* synthetic */ void access$001(ComponentActivity r0) {
        super.onBackPressed();
    }

    @Nullable
    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        NonConfigurationInstances r0 = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.custom;
    }

    @Override // androidx.core.app.ComponentActivity, androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.activity.OnBackPressedDispatcherOwner
    @NonNull
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    @NonNull
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NonNull
    public ViewModelStore getViewModelStore() {
        if (getApplication() == null) goto L15;
        if (this.mViewModelStore != null) goto L13;
        NonConfigurationInstances r0 = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (r0 == null) goto L10;
        this.mViewModelStore = r0.viewModelStore;
    L10:
        if (this.mViewModelStore != null) goto L13;
        this.mViewModelStore = new ViewModelStore();
    L13:
        return this.mViewModelStore;
    L15:
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    @Override // android.app.Activity
    @MainThread
    public void onBackPressed() {
        this.mOnBackPressedDispatcher.onBackPressed();
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle r2) {
        super.onCreate(r2);
        this.mSavedStateRegistryController.performRestore(r2);
        ReportFragment.injectIfNeededIn(this);
        int r3 = this.mContentLayoutId;
        if (r3 == 0) goto L6;
        setContentView(r3);
        return;
    }

    @Nullable
    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    @Nullable
    public final Object onRetainNonConfigurationInstance() {
        Object r0 = onRetainCustomNonConfigurationInstance();
        ViewModelStore r1 = this.mViewModelStore;
        if (r1 != null) goto L7;
        NonConfigurationInstances r2 = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (r2 == null) goto L7;
        r1 = r2.viewModelStore;
    L7:
        if (r1 != null) goto L11;
        if (r0 != null) goto L11;
        return null;
    L11:
        NonConfigurationInstances r3 = new NonConfigurationInstances();
        r3.custom = r0;
        r3.viewModelStore = r1;
        return r3;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    @CallSuper
    public void onSaveInstanceState(@NonNull Bundle r3) {
        Lifecycle r0 = getLifecycle();
        if ((r0 instanceof LifecycleRegistry) == false) goto L5;
        ((LifecycleRegistry) r0).setCurrentState(Lifecycle.State.CREATED);
    L5:
        super.onSaveInstanceState(r3);
        this.mSavedStateRegistryController.performSave(r3);
    }

    @ContentView
    public ComponentActivity(@LayoutRes int r1) {
        this();
        this.mContentLayoutId = r1;
    }
}
