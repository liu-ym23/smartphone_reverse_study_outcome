package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.contextaware.ContextAware;
import androidx.activity.contextaware.ContextAwareHelper;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.DoNotInline;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnNewIntentProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.content.ContextCompat;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.os.BuildCompat;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import androidx.tracing.Trace;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class ComponentActivity extends androidx.core.app.ComponentActivity implements ContextAware, LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, OnBackPressedDispatcherOwner, ActivityResultRegistryOwner, ActivityResultCaller, OnConfigurationChangedProvider, OnTrimMemoryProvider, OnNewIntentProvider, OnMultiWindowModeChangedProvider, OnPictureInPictureModeChangedProvider, MenuHost {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final ActivityResultRegistry mActivityResultRegistry;

    @LayoutRes
    private int mContentLayoutId;
    final ContextAwareHelper mContextAwareHelper;
    private ViewModelProvider.Factory mDefaultFactory;
    private boolean mDispatchingOnMultiWindowModeChanged;
    private boolean mDispatchingOnPictureInPictureModeChanged;
    private final LifecycleRegistry mLifecycleRegistry;
    private final MenuHostHelper mMenuHostHelper;
    private final AtomicInteger mNextLocalRequestCode;
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<Consumer<Configuration>> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<Consumer<MultiWindowModeChangedInfo>> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<Consumer<Intent>> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<Consumer<PictureInPictureModeChangedInfo>> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<Consumer<Integer>> mOnTrimMemoryListeners;
    final SavedStateRegistryController mSavedStateRegistryController;
    private ViewModelStore mViewModelStore;

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        static void cancelPendingInputEvents(View r0) {
            r0.cancelPendingInputEvents();
        }
    }

    @RequiresApi(33)
    static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        static OnBackInvokedDispatcher getOnBackInvokedDispatcher(Activity r0) {
            return r0.getOnBackInvokedDispatcher();
        }
    }

    static final class NonConfigurationInstances {
        Object custom;
        ViewModelStore viewModelStore;

        NonConfigurationInstances() {
        }
    }

    public ComponentActivity() {
        this.mContextAwareHelper = new ContextAwareHelper();
        this.mMenuHostHelper = new MenuHostHelper(new b(this));
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        SavedStateRegistryController r0 = SavedStateRegistryController.create(this);
        this.mSavedStateRegistryController = r0;
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new AnonymousClass1(this));
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new AnonymousClass2(this);
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList();
        this.mDispatchingOnMultiWindowModeChanged = false;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        if (getLifecycle() == null) goto L15;
        int r1 = Build.VERSION.SDK_INT;
        if (r1 < 19) goto L7;
        getLifecycle().addObserver(new AnonymousClass3(this));
    L7:
        getLifecycle().addObserver(new AnonymousClass4(this));
        getLifecycle().addObserver(new AnonymousClass5(this));
        r0.performAttach();
        SavedStateHandleSupport.enableSavedStateHandles(this);
        if (19 <= r1) goto L10;
    L12:
        getSavedStateRegistry().registerSavedStateProvider(ACTIVITY_RESULT_TAG, new e(this));
        addOnContextAvailableListener(new d(this));
        return;
    L10:
        if (r1 > 23) goto L12;
        getLifecycle().addObserver(new ImmLeaksCleaner(this));
        goto L12
    L15:
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    @ContentView
    public ComponentActivity(@LayoutRes int r1) {
        this();
        this.mContentLayoutId = r1;
    }

    static /* synthetic */ void access$001(ComponentActivity r0) {
        super.onBackPressed();
    }

    private /* synthetic */ Bundle i() {
        Bundle r0 = new Bundle();
        this.mActivityResultRegistry.onSaveInstanceState(r0);
        return r0;
    }

    private void initViewTreeOwners() {
        ViewTreeLifecycleOwner.set(getWindow().getDecorView(), this);
        ViewTreeViewModelStoreOwner.set(getWindow().getDecorView(), this);
        ViewTreeSavedStateRegistryOwner.set(getWindow().getDecorView(), this);
        ViewTreeOnBackPressedDispatcherOwner.set(getWindow().getDecorView(), this);
    }

    private /* synthetic */ void k(Context r2) {
        Bundle r3 = getSavedStateRegistry().consumeRestoredStateForKey(ACTIVITY_RESULT_TAG);
        if (r3 == null) goto L6;
        this.mActivityResultRegistry.onRestoreInstanceState(r3);
        return;
    }

    @Override // android.app.Activity
    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View r1, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams r2) {
        initViewTreeOwners();
        super.addContentView(r1, r2);
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(@NonNull MenuProvider r1) {
        this.mMenuHostHelper.addMenuProvider(r1);
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(@NonNull MenuProvider r1, @NonNull LifecycleOwner r2) {
        this.mMenuHostHelper.addMenuProvider(r1, r2);
    }

    @Override // androidx.core.view.MenuHost
    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(@NonNull MenuProvider r1, @NonNull LifecycleOwner r2, @NonNull Lifecycle.State r3) {
        this.mMenuHostHelper.addMenuProvider(r1, r2, r3);
    }

    @Override // androidx.core.content.OnConfigurationChangedProvider
    public final void addOnConfigurationChangedListener(@NonNull Consumer<Configuration> r1) {
        this.mOnConfigurationChangedListeners.add(r1);
    }

    @Override // androidx.activity.contextaware.ContextAware
    public final void addOnContextAvailableListener(@NonNull OnContextAvailableListener r1) {
        this.mContextAwareHelper.addOnContextAvailableListener(r1);
    }

    @Override // androidx.core.app.OnMultiWindowModeChangedProvider
    public final void addOnMultiWindowModeChangedListener(@NonNull Consumer<MultiWindowModeChangedInfo> r1) {
        this.mOnMultiWindowModeChangedListeners.add(r1);
    }

    @Override // androidx.core.app.OnNewIntentProvider
    public final void addOnNewIntentListener(@NonNull Consumer<Intent> r1) {
        this.mOnNewIntentListeners.add(r1);
    }

    @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
    public final void addOnPictureInPictureModeChangedListener(@NonNull Consumer<PictureInPictureModeChangedInfo> r1) {
        this.mOnPictureInPictureModeChangedListeners.add(r1);
    }

    @Override // androidx.core.content.OnTrimMemoryProvider
    public final void addOnTrimMemoryListener(@NonNull Consumer<Integer> r1) {
        this.mOnTrimMemoryListeners.add(r1);
    }

    void ensureViewModelStore() {
        if (this.mViewModelStore != null) goto L11;
        NonConfigurationInstances r0 = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (r0 == null) goto L8;
        this.mViewModelStore = r0.viewModelStore;
    L8:
        if (this.mViewModelStore != null) goto L12;
        this.mViewModelStore = new ViewModelStore();
        return;
    L12:
        return;
    }

    @Override // androidx.activity.result.ActivityResultRegistryOwner
    @NonNull
    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    @NonNull
    @CallSuper
    public CreationExtras getDefaultViewModelCreationExtras() {
        MutableCreationExtras r0 = new MutableCreationExtras();
        if (getApplication() == null) goto L5;
        r0.set(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY, getApplication());
    L5:
        r0.set(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        r0.set(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, this);
        if (getIntent() != null) goto L8;
    L10:
        return r0;
    L8:
        if (getIntent().getExtras() == null) goto L10;
        r0.set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, getIntent().getExtras());
        goto L10
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    @NonNull
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory != null) goto L10;
        Application r1 = getApplication();
        if (getIntent() == null) goto L7;
        Bundle r2 = getIntent().getExtras();
    L8:
        this.mDefaultFactory = new SavedStateViewModelFactory(r1, this, r2);
        goto L10
    L7:
        r2 = null;
    L10:
        return this.mDefaultFactory;
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
        if (getApplication() == null) goto L7;
        ensureViewModelStore();
        return this.mViewModelStore;
    L7:
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    @Override // androidx.core.view.MenuHost
    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    public /* synthetic */ Bundle j() {
        return i();
    }

    public /* synthetic */ void l(Context r1) {
        k(r1);
    }

    @Override // android.app.Activity
    @CallSuper
    @Deprecated
    protected void onActivityResult(int r2, int r3, @Nullable Intent r4) {
        if (this.mActivityResultRegistry.dispatchResult(r2, r3, r4) == true) goto L6;
        super.onActivityResult(r2, r3, r4);
        return;
    }

    @Override // android.app.Activity
    @MainThread
    public void onBackPressed() {
        this.mOnBackPressedDispatcher.onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    @CallSuper
    public void onConfigurationChanged(@NonNull Configuration r2) {
        super.onConfigurationChanged(r2);
        Iterator<Consumer<Configuration>> r1 = this.mOnConfigurationChangedListeners.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().accept(r2);
        goto L4
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    protected void onCreate(@Nullable Bundle r2) {
        this.mSavedStateRegistryController.performRestore(r2);
        this.mContextAwareHelper.dispatchOnContextAvailable(this);
        super.onCreate(r2);
        ReportFragment.injectIfNeededIn(this);
        if (BuildCompat.isAtLeastT() == false) goto L5;
        this.mOnBackPressedDispatcher.setOnBackInvokedDispatcher(Api33Impl.getOnBackInvokedDispatcher(this));
    L5:
        int r3 = this.mContentLayoutId;
        if (r3 == 0) goto L9;
        setContentView(r3);
        return;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int r1, @NonNull Menu r2) {
        if (r1 != 0) goto L6;
        super.onCreatePanelMenu(r1, r2);
        this.mMenuHostHelper.onCreateMenu(r2, getMenuInflater());
        return true;
    L6:
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int r2, @NonNull MenuItem r3) {
        if (super.onMenuItemSelected(r2, r3) == false) goto L6;
        return true;
    L6:
        if (r2 == 0) goto L8;
        return false;
    L8:
        return this.mMenuHostHelper.onMenuItemSelected(r3);
    }

    @Override // android.app.Activity
    @CallSuper
    public void onMultiWindowModeChanged(boolean r3) {
        if (this.mDispatchingOnMultiWindowModeChanged == false) goto L5;
        return;
    L5:
        Iterator<Consumer<MultiWindowModeChangedInfo>> r2 = this.mOnMultiWindowModeChangedListeners.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        r2.next().accept(new MultiWindowModeChangedInfo(r3));
        goto L7
    }

    @Override // android.app.Activity
    @RequiresApi(api = 26)
    @CallSuper
    public void onMultiWindowModeChanged(boolean r3, @NonNull Configuration r4) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        super.onMultiWindowModeChanged(r3, r4);     // Catch: Throwable -> L9
        this.mDispatchingOnMultiWindowModeChanged = false;
        Iterator<Consumer<MultiWindowModeChangedInfo>> r2 = this.mOnMultiWindowModeChangedListeners.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r2.next().accept(new MultiWindowModeChangedInfo(r3, r4));
        goto L6
    L8:
        return;
    L9:
        th = move-exception;
        this.mDispatchingOnMultiWindowModeChanged = false;
        throw th;
    }

    @Override // android.app.Activity
    @CallSuper
    protected void onNewIntent(@SuppressLint({"UnknownNullness", "MissingNullability"}) Intent r2) {
        super.onNewIntent(r2);
        Iterator<Consumer<Intent>> r1 = this.mOnNewIntentListeners.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().accept(r2);
        goto L4
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int r2, @NonNull Menu r3) {
        this.mMenuHostHelper.onMenuClosed(r3);
        super.onPanelClosed(r2, r3);
    }

    @Override // android.app.Activity
    @CallSuper
    public void onPictureInPictureModeChanged(boolean r3) {
        if (this.mDispatchingOnPictureInPictureModeChanged == false) goto L5;
        return;
    L5:
        Iterator<Consumer<PictureInPictureModeChangedInfo>> r2 = this.mOnPictureInPictureModeChangedListeners.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        r2.next().accept(new PictureInPictureModeChangedInfo(r3));
        goto L7
    }

    @Override // android.app.Activity
    @RequiresApi(api = 26)
    @CallSuper
    public void onPictureInPictureModeChanged(boolean r3, @NonNull Configuration r4) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        super.onPictureInPictureModeChanged(r3, r4);     // Catch: Throwable -> L9
        this.mDispatchingOnPictureInPictureModeChanged = false;
        Iterator<Consumer<PictureInPictureModeChangedInfo>> r2 = this.mOnPictureInPictureModeChangedListeners.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r2.next().accept(new PictureInPictureModeChangedInfo(r3, r4));
        goto L6
    L8:
        return;
    L9:
        th = move-exception;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        throw th;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int r1, @Nullable View r2, @NonNull Menu r3) {
        if (r1 != 0) goto L6;
        super.onPreparePanel(r1, r2, r3);
        this.mMenuHostHelper.onPrepareMenu(r3);
        return true;
    L6:
        return true;
    }

    @Override // android.app.Activity
    @CallSuper
    @Deprecated
    public void onRequestPermissionsResult(int r4, @NonNull String[] r5, @NonNull int[] r6) {
        if (this.mActivityResultRegistry.dispatchResult(r4, -1, new Intent().putExtra(ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSIONS, r5).putExtra(ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSION_GRANT_RESULTS, r6)) == false) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L9;
        super.onRequestPermissionsResult(r4, r5, r6);
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
    protected void onSaveInstanceState(@NonNull Bundle r3) {
        Lifecycle r0 = getLifecycle();
        if ((r0 instanceof LifecycleRegistry) == false) goto L5;
        ((LifecycleRegistry) r0).setCurrentState(Lifecycle.State.CREATED);
    L5:
        super.onSaveInstanceState(r3);
        this.mSavedStateRegistryController.performSave(r3);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    @CallSuper
    public void onTrimMemory(int r3) {
        super.onTrimMemory(r3);
        Iterator<Consumer<Integer>> r2 = this.mOnTrimMemoryListeners.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r2.next().accept(Integer.valueOf(r3));
        goto L4
    }

    @Override // androidx.activity.contextaware.ContextAware
    @Nullable
    public Context peekAvailableContext() {
        return this.mContextAwareHelper.peekAvailableContext();
    }

    @Override // androidx.activity.result.ActivityResultCaller
    @NonNull
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(@NonNull ActivityResultContract<I, O> r2, @NonNull ActivityResultCallback<O> r3) {
        return registerForActivityResult(r2, this.mActivityResultRegistry, r3);
    }

    @Override // androidx.activity.result.ActivityResultCaller
    @NonNull
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(@NonNull ActivityResultContract<I, O> r3, @NonNull ActivityResultRegistry r4, @NonNull ActivityResultCallback<O> r5) {
        return r4.register("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, r3, r5);
    }

    @Override // androidx.core.view.MenuHost
    public void removeMenuProvider(@NonNull MenuProvider r1) {
        this.mMenuHostHelper.removeMenuProvider(r1);
    }

    @Override // androidx.core.content.OnConfigurationChangedProvider
    public final void removeOnConfigurationChangedListener(@NonNull Consumer<Configuration> r1) {
        this.mOnConfigurationChangedListeners.remove(r1);
    }

    @Override // androidx.activity.contextaware.ContextAware
    public final void removeOnContextAvailableListener(@NonNull OnContextAvailableListener r1) {
        this.mContextAwareHelper.removeOnContextAvailableListener(r1);
    }

    @Override // androidx.core.app.OnMultiWindowModeChangedProvider
    public final void removeOnMultiWindowModeChangedListener(@NonNull Consumer<MultiWindowModeChangedInfo> r1) {
        this.mOnMultiWindowModeChangedListeners.remove(r1);
    }

    @Override // androidx.core.app.OnNewIntentProvider
    public final void removeOnNewIntentListener(@NonNull Consumer<Intent> r1) {
        this.mOnNewIntentListeners.remove(r1);
    }

    @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
    public final void removeOnPictureInPictureModeChangedListener(@NonNull Consumer<PictureInPictureModeChangedInfo> r1) {
        this.mOnPictureInPictureModeChangedListeners.remove(r1);
    }

    @Override // androidx.core.content.OnTrimMemoryProvider
    public final void removeOnTrimMemoryListener(@NonNull Consumer<Integer> r1) {
        this.mOnTrimMemoryListeners.remove(r1);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
    L14:
        th = move-exception;
        Trace.endSection();
        throw th;
    L3:
        if (Trace.isEnabled() == false) goto L5;
        Trace.beginSection("reportFullyDrawn() for ComponentActivity");     // Catch: Throwable -> L14
    L5:
        int r0 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L14
        if (r0 <= 19) goto L8;
    L7:
        super.reportFullyDrawn();     // Catch: Throwable -> L14
    L12:
        Trace.endSection();
        return;
    L8:
        if (r0 != 19) goto L12;
        if (ContextCompat.checkSelfPermission(this, "android.permission.UPDATE_DEVICE_STATS") != 0) goto L12;
        goto L12
    }

    @Override // android.app.Activity
    public void setContentView(@LayoutRes int r1) {
        initViewTreeOwners();
        super.setContentView(r1);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View r1) {
        initViewTreeOwners();
        super.setContentView(r1);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View r1, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams r2) {
        initViewTreeOwners();
        super.setContentView(r1, r2);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@NonNull Intent r1, int r2) {
        super.startActivityForResult(r1, r2);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@NonNull Intent r1, int r2, @Nullable Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@NonNull IntentSender r1, int r2, @Nullable Intent r3, int r4, int r5, int r6) {
        super.startIntentSenderForResult(r1, r2, r3, r4, r5, r6);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@NonNull IntentSender r1, int r2, @Nullable Intent r3, int r4, int r5, int r6, @Nullable Bundle r7) {
        super.startIntentSenderForResult(r1, r2, r3, r4, r5, r6, r7);
    }
}
