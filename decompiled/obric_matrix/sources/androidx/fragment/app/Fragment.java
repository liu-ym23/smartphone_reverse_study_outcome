package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.AnimRes;
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.UiThread;
import androidx.arch.core.util.Function;
import androidx.core.app.SharedElementCallback;
import androidx.core.view.LayoutInflaterCompat;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, ActivityResultCaller {
    static final int ACTIVITY_CREATED = 4;
    static final int ATTACHED = 0;
    static final int AWAITING_ENTER_EFFECTS = 6;
    static final int AWAITING_EXIT_EFFECTS = 3;
    static final int CREATED = 1;
    static final int INITIALIZING = -1;
    static final int RESUMED = 7;
    static final int STARTED = 5;
    static final Object USE_DEFAULT_TRANSITION = null;
    static final int VIEW_CREATED = 2;
    boolean mAdded;
    AnimationInfo mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    boolean mBeingSaved;
    private boolean mCalled;

    @NonNull
    FragmentManager mChildFragmentManager;
    ViewGroup mContainer;
    int mContainerId;

    @LayoutRes
    private int mContentLayoutId;
    ViewModelProvider.Factory mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    FragmentManager mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    FragmentHostCallback<?> mHost;
    boolean mInLayout;
    boolean mIsCreated;
    private Boolean mIsPrimaryNavigationFragment;
    LayoutInflater mLayoutInflater;
    LifecycleRegistry mLifecycleRegistry;
    Lifecycle.State mMaxState;
    boolean mMenuVisible;
    private final AtomicInteger mNextLocalRequestCode;
    private final ArrayList<OnPreAttachedListener> mOnPreAttachedListeners;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    Runnable mPostponedDurationRunnable;

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String mPreviousWho;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    private final OnPreAttachedListener mSavedStateAttachListener;
    SavedStateRegistryController mSavedStateRegistryController;

    @Nullable
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray<Parcelable> mSavedViewState;
    int mState;
    String mTag;
    Fragment mTarget;
    int mTargetRequestCode;
    String mTargetWho;
    boolean mUserVisibleHint;
    View mView;

    @Nullable
    FragmentViewLifecycleOwner mViewLifecycleOwner;
    MutableLiveData<LifecycleOwner> mViewLifecycleOwnerLiveData;

    @NonNull
    String mWho;

    static class AnimationInfo {
        Boolean mAllowEnterTransitionOverlap;
        Boolean mAllowReturnTransitionOverlap;
        View mAnimatingAway;

        @AnimRes
        int mEnterAnim;
        Object mEnterTransition;
        SharedElementCallback mEnterTransitionCallback;
        boolean mEnterTransitionPostponed;

        @AnimRes
        int mExitAnim;
        Object mExitTransition;
        SharedElementCallback mExitTransitionCallback;
        View mFocusedView;
        boolean mIsPop;
        int mNextTransition;

        @AnimRes
        int mPopEnterAnim;

        @AnimRes
        int mPopExitAnim;
        float mPostOnViewCreatedAlpha;
        Object mReenterTransition;
        Object mReturnTransition;
        Object mSharedElementEnterTransition;
        Object mSharedElementReturnTransition;
        ArrayList<String> mSharedElementSourceNames;
        ArrayList<String> mSharedElementTargetNames;

        AnimationInfo() {
            this.mEnterTransition = null;
            Object r1 = Fragment.USE_DEFAULT_TRANSITION;
            this.mReturnTransition = r1;
            this.mExitTransition = null;
            this.mReenterTransition = r1;
            this.mSharedElementEnterTransition = null;
            this.mSharedElementReturnTransition = r1;
            this.mEnterTransitionCallback = null;
            this.mExitTransitionCallback = null;
            this.mPostOnViewCreatedAlpha = 1.0f;
            this.mFocusedView = null;
        }
    }

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        static void cancelPendingInputEvents(@NonNull View r0) {
            r0.cancelPendingInputEvents();
        }
    }

    public static class InstantiationException extends RuntimeException {
        public InstantiationException(@NonNull String r1, @Nullable Exception r2) {
            super(r1, r2);
        }
    }

    private static abstract class OnPreAttachedListener {
        private OnPreAttachedListener() {
        }

        /* synthetic */ OnPreAttachedListener(AnonymousClass1 r1) {
            this();
        }

        abstract void onPreAttached();
    }

    @SuppressLint({"BanParcelableUsage, ParcelClassLoader"})
    public static class SavedState implements Parcelable {

        @NonNull
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        final Bundle mState;

        static {
            CREATOR = new AnonymousClass1();
        }

        SavedState(Bundle r1) {
            this.mState = r1;
        }

        SavedState(@NonNull Parcel r1, @Nullable ClassLoader r2) {
            Bundle r3 = r1.readBundle();
            this.mState = r3;
            if (r2 == null) goto L7;
            if (r3 == null) goto L8;
            r3.setClassLoader(r2);
            return;
        L8:
            return;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r1, int r2) {
            r1.writeBundle(this.mState);
        }
    }

    static {
        USE_DEFAULT_TRANSITION = new Object();
    }

    public Fragment() {
        this.mState = -1;
        this.mWho = UUID.randomUUID().toString();
        this.mTargetWho = null;
        this.mIsPrimaryNavigationFragment = null;
        this.mChildFragmentManager = new FragmentManagerImpl();
        this.mMenuVisible = true;
        this.mUserVisibleHint = true;
        this.mPostponedDurationRunnable = new AnonymousClass1(this);
        this.mMaxState = Lifecycle.State.RESUMED;
        this.mViewLifecycleOwnerLiveData = new MutableLiveData();
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mOnPreAttachedListeners = new ArrayList();
        this.mSavedStateAttachListener = new AnonymousClass2(this);
        initLifecycle();
    }

    @ContentView
    public Fragment(@LayoutRes int r1) {
        this();
        this.mContentLayoutId = r1;
    }

    private AnimationInfo ensureAnimationInfo() {
        if (this.mAnimationInfo != null) goto L6;
        this.mAnimationInfo = new AnimationInfo();
    L6:
        return this.mAnimationInfo;
    }

    private int getMinimumMaxLifecycleState() {
        Lifecycle.State r0 = this.mMaxState;
        if (r0 == Lifecycle.State.INITIALIZED) goto L10;
        if (this.mParentFragment == null) goto L10;
        return Math.min(r0.ordinal(), this.mParentFragment.getMinimumMaxLifecycleState());
    L10:
        return r0.ordinal();
    }

    @Nullable
    private Fragment getTargetFragment(boolean r1) {
        if (r1 == false) goto L4;
        FragmentStrictMode.onGetTargetFragmentUsage(this);
    L4:
        Fragment r2 = this.mTarget;
        if (r2 == null) goto L7;
        return r2;
    L7:
        FragmentManager r3 = this.mFragmentManager;
        if (r3 == null) goto L13;
        String r0 = this.mTargetWho;
        if (r0 != null) goto L12;
        return null;
    L12:
        return r3.findActiveFragment(r0);
    L13:
        return null;
    }

    private void initLifecycle() {
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        this.mSavedStateRegistryController = SavedStateRegistryController.create(this);
        this.mDefaultFactory = null;
        if (this.mOnPreAttachedListeners.contains(this.mSavedStateAttachListener) == true) goto L6;
        registerOnPreAttachListener(this.mSavedStateAttachListener);
        return;
    }

    @NonNull
    @Deprecated
    public static Fragment instantiate(@NonNull Context r1, @NonNull String r2) {
        return instantiate(r1, r2, null);
    }

    @NonNull
    @Deprecated
    public static Fragment instantiate(@NonNull Context r4, @NonNull String r5, @Nullable Bundle r6) {
        Fragment r7 = FragmentFactory.loadFragmentClass(r4.getClassLoader(), r5).getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L10 IllegalAccessException -> L13 java.lang.InstantiationException -> L16
        if (r6 == null) goto L6;
        r6.setClassLoader(r7.getClass().getClassLoader());     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L10 IllegalAccessException -> L13 java.lang.InstantiationException -> L16
        r7.setArguments(r6);     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L10 IllegalAccessException -> L13 java.lang.InstantiationException -> L16
    L6:
        return r7;
    L13:
        e = move-exception;
        throw new InstantiationException("Unable to instantiate fragment " + r5 + ": make sure class name exists, is public, and has an empty constructor that is public", e);
    L16:
        e = move-exception;
        throw new InstantiationException("Unable to instantiate fragment " + r5 + ": make sure class name exists, is public, and has an empty constructor that is public", e);
    L10:
        e = move-exception;
        throw new InstantiationException("Unable to instantiate fragment " + r5 + ": could not find Fragment constructor", e);
    L7:
        e = move-exception;
        throw new InstantiationException("Unable to instantiate fragment " + r5 + ": calling Fragment constructor caused an exception", e);
    }

    @NonNull
    private <I, O> ActivityResultLauncher<I> prepareCallInternal(@NonNull final ActivityResultContract<I, O> r9, @NonNull final Function<Void, ActivityResultRegistry> r10, @NonNull final ActivityResultCallback<O> r11) {
        if (this.mState > 1) goto L7;
        final AtomicReference r0 = new AtomicReference();
        registerOnPreAttachListener(new AnonymousClass9(this, r10, r0, r9, r11));
        return new AnonymousClass10(this, r0, r9);
    L7:
        throw new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
    }

    private void registerOnPreAttachListener(@NonNull OnPreAttachedListener r2) {
        if (this.mState < 0) goto L5;
        r2.onPreAttached();
        return;
    L5:
        this.mOnPreAttachedListeners.add(r2);
    }

    private void restoreViewState() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L6;
        Log.d(FragmentManager.TAG, "moveto RESTORE_VIEW_STATE: " + this);
    L6:
        if (this.mView == null) goto L8;
        restoreViewState(this.mSavedFragmentState);
    L8:
        this.mSavedFragmentState = null;
    }

    void callStartTransitionListener(boolean r3) {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 == null) goto L6;
        r0.mEnterTransitionPostponed = false;
    L6:
        if (this.mView == null) goto L16;
        ViewGroup r1 = this.mContainer;
        if (r1 == null) goto L17;
        FragmentManager r2 = this.mFragmentManager;
        if (r2 == null) goto L18;
        final SpecialEffectsController r4 = SpecialEffectsController.getOrCreateController(r1, r2);
        r4.markPostponedState();
        if (r3 == false) goto L14;
        this.mHost.getHandler().post(new AnonymousClass4(this, r4));
        return;
    L14:
        r4.executePendingOperations();
        return;
    L18:
        return;
    L17:
        return;
    }

    @NonNull
    FragmentContainer createFragmentContainer() {
        return new AnonymousClass5(this);
    }

    public void dump(@NonNull String r3, @Nullable FileDescriptor r4, @NonNull PrintWriter r5, @Nullable String[] r6) {
        r5.print(r3);
        r5.print("mFragmentId=#");
        r5.print(Integer.toHexString(this.mFragmentId));
        r5.print(" mContainerId=#");
        r5.print(Integer.toHexString(this.mContainerId));
        r5.print(" mTag=");
        r5.println(this.mTag);
        r5.print(r3);
        r5.print("mState=");
        r5.print(this.mState);
        r5.print(" mWho=");
        r5.print(this.mWho);
        r5.print(" mBackStackNesting=");
        r5.println(this.mBackStackNesting);
        r5.print(r3);
        r5.print("mAdded=");
        r5.print(this.mAdded);
        r5.print(" mRemoving=");
        r5.print(this.mRemoving);
        r5.print(" mFromLayout=");
        r5.print(this.mFromLayout);
        r5.print(" mInLayout=");
        r5.println(this.mInLayout);
        r5.print(r3);
        r5.print("mHidden=");
        r5.print(this.mHidden);
        r5.print(" mDetached=");
        r5.print(this.mDetached);
        r5.print(" mMenuVisible=");
        r5.print(this.mMenuVisible);
        r5.print(" mHasMenu=");
        r5.println(this.mHasMenu);
        r5.print(r3);
        r5.print("mRetainInstance=");
        r5.print(this.mRetainInstance);
        r5.print(" mUserVisibleHint=");
        r5.println(this.mUserVisibleHint);
        if (this.mFragmentManager == null) goto L6;
        r5.print(r3);
        r5.print("mFragmentManager=");
        r5.println(this.mFragmentManager);
    L6:
        if (this.mHost == null) goto L9;
        r5.print(r3);
        r5.print("mHost=");
        r5.println(this.mHost);
    L9:
        if (this.mParentFragment == null) goto L12;
        r5.print(r3);
        r5.print("mParentFragment=");
        r5.println(this.mParentFragment);
    L12:
        if (this.mArguments == null) goto L15;
        r5.print(r3);
        r5.print("mArguments=");
        r5.println(this.mArguments);
    L15:
        if (this.mSavedFragmentState == null) goto L18;
        r5.print(r3);
        r5.print("mSavedFragmentState=");
        r5.println(this.mSavedFragmentState);
    L18:
        if (this.mSavedViewState == null) goto L21;
        r5.print(r3);
        r5.print("mSavedViewState=");
        r5.println(this.mSavedViewState);
    L21:
        if (this.mSavedViewRegistryState == null) goto L23;
        r5.print(r3);
        r5.print("mSavedViewRegistryState=");
        r5.println(this.mSavedViewRegistryState);
    L23:
        Fragment r0 = getTargetFragment(false);
        if (r0 == null) goto L26;
        r5.print(r3);
        r5.print("mTarget=");
        r5.print(r0);
        r5.print(" mTargetRequestCode=");
        r5.println(this.mTargetRequestCode);
    L26:
        r5.print(r3);
        r5.print("mPopDirection=");
        r5.println(getPopDirection());
        if (getEnterAnim() == 0) goto L30;
        r5.print(r3);
        r5.print("getEnterAnim=");
        r5.println(getEnterAnim());
    L30:
        if (getExitAnim() == 0) goto L33;
        r5.print(r3);
        r5.print("getExitAnim=");
        r5.println(getExitAnim());
    L33:
        if (getPopEnterAnim() == 0) goto L36;
        r5.print(r3);
        r5.print("getPopEnterAnim=");
        r5.println(getPopEnterAnim());
    L36:
        if (getPopExitAnim() == 0) goto L39;
        r5.print(r3);
        r5.print("getPopExitAnim=");
        r5.println(getPopExitAnim());
    L39:
        if (this.mContainer == null) goto L42;
        r5.print(r3);
        r5.print("mContainer=");
        r5.println(this.mContainer);
    L42:
        if (this.mView == null) goto L45;
        r5.print(r3);
        r5.print("mView=");
        r5.println(this.mView);
    L45:
        if (getAnimatingAway() == null) goto L48;
        r5.print(r3);
        r5.print("mAnimatingAway=");
        r5.println(getAnimatingAway());
    L48:
        if (getContext() == null) goto L50;
        LoaderManager.getInstance(this).dump(r3, r4, r5, r6);
    L50:
        r5.print(r3);
        r5.println("Child " + this.mChildFragmentManager + ":");
        this.mChildFragmentManager.dump(r3 + "  ", r4, r5, r6);
    }

    public final boolean equals(@Nullable Object r1) {
        return super.equals(r1);
    }

    @Nullable
    Fragment findFragmentByWho(@NonNull String r2) {
        if (r2.equals(this.mWho) == false) goto L6;
        return this;
    L6:
        return this.mChildFragmentManager.findFragmentByWho(r2);
    }

    @NonNull
    String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    @Nullable
    public final FragmentActivity getActivity() {
        FragmentHostCallback<?> r0 = this.mHost;
        if (r0 != null) goto L6;
        return null;
    L6:
        return (FragmentActivity) r0.getActivity();
    }

    public boolean getAllowEnterTransitionOverlap() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 == null) goto L8;
        Boolean r1 = r0.mAllowEnterTransitionOverlap;
        if (r1 == null) goto L8;
        return r1.booleanValue();
    L8:
        return true;
    }

    public boolean getAllowReturnTransitionOverlap() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 == null) goto L8;
        Boolean r1 = r0.mAllowReturnTransitionOverlap;
        if (r1 == null) goto L8;
        return r1.booleanValue();
    L8:
        return true;
    }

    View getAnimatingAway() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mAnimatingAway;
    }

    @Nullable
    public final Bundle getArguments() {
        return this.mArguments;
    }

    @NonNull
    public final FragmentManager getChildFragmentManager() {
        if (this.mHost == null) goto L7;
        return this.mChildFragmentManager;
    L7:
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    @Nullable
    public Context getContext() {
        FragmentHostCallback<?> r0 = this.mHost;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getContext();
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    @NonNull
    @CallSuper
    public CreationExtras getDefaultViewModelCreationExtras() {
        Context r0 = requireContext().getApplicationContext();
    L4:
        if ((r0 instanceof ContextWrapper) == false) goto L9;
        if ((r0 instanceof Application) == true) goto L7;
        r0 = ((ContextWrapper) r0).getBaseContext();
        goto L4
    L7:
        Application r1 = (Application) r0;
    L10:
        if (r1 == null) goto L12;
    L14:
        MutableCreationExtras r2 = new MutableCreationExtras();
        if (r1 == null) goto L17;
        r2.set(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY, r1);
    L17:
        r2.set(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        r2.set(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, this);
        if (getArguments() == null) goto L20;
        r2.set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, getArguments());
    L20:
        return r2;
    L12:
        if (FragmentManager.isLoggingEnabled(3) == false) goto L14;
        Log.d(FragmentManager.TAG, "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        goto L14
    L9:
        r1 = null;
        goto L10
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    @NonNull
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        if (this.mFragmentManager == null) goto L21;
        if (this.mDefaultFactory != null) goto L19;
        Application r0 = null;
        Context r1 = requireContext().getApplicationContext();
    L8:
        if ((r1 instanceof ContextWrapper) == false) goto L13;
        if ((r1 instanceof Application) == true) goto L11;
        r1 = ((ContextWrapper) r1).getBaseContext();
        goto L8
    L11:
        r0 = (Application) r1;
    L13:
        if (r0 == null) goto L15;
    L17:
        this.mDefaultFactory = new SavedStateViewModelFactory(r0, this, getArguments());
        goto L19
    L15:
        if (FragmentManager.isLoggingEnabled(3) == false) goto L17;
        Log.d(FragmentManager.TAG, "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will need CreationExtras to use AndroidViewModel with the default ViewModelProvider.Factory");
    L19:
        return this.mDefaultFactory;
    L21:
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    @AnimRes
    int getEnterAnim() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.mEnterAnim;
    }

    @Nullable
    public Object getEnterTransition() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mEnterTransition;
    }

    SharedElementCallback getEnterTransitionCallback() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mEnterTransitionCallback;
    }

    @AnimRes
    int getExitAnim() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.mExitAnim;
    }

    @Nullable
    public Object getExitTransition() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mExitTransition;
    }

    SharedElementCallback getExitTransitionCallback() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mExitTransitionCallback;
    }

    View getFocusedView() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mFocusedView;
    }

    @Nullable
    @Deprecated
    public final FragmentManager getFragmentManager() {
        return this.mFragmentManager;
    }

    @Nullable
    public final Object getHost() {
        FragmentHostCallback<?> r0 = this.mHost;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.onGetHost();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    @NonNull
    public final LayoutInflater getLayoutInflater() {
        LayoutInflater r0 = this.mLayoutInflater;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return performGetLayoutInflater(null);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public LayoutInflater getLayoutInflater(@Nullable Bundle r1) {
        FragmentHostCallback<?> r2 = this.mHost;
        if (r2 == null) goto L7;
        LayoutInflater r3 = r2.onGetLayoutInflater();
        LayoutInflaterCompat.setFactory2(r3, this.mChildFragmentManager.getLayoutInflaterFactory());
        return r3;
    L7:
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @NonNull
    @Deprecated
    public LoaderManager getLoaderManager() {
        return LoaderManager.getInstance(this);
    }

    int getNextTransition() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.mNextTransition;
    }

    @Nullable
    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    @NonNull
    public final FragmentManager getParentFragmentManager() {
        FragmentManager r0 = this.mFragmentManager;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    boolean getPopDirection() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.mIsPop;
    }

    @AnimRes
    int getPopEnterAnim() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.mPopEnterAnim;
    }

    @AnimRes
    int getPopExitAnim() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.mPopExitAnim;
    }

    float getPostOnViewCreatedAlpha() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return 1.0f;
    L7:
        return r0.mPostOnViewCreatedAlpha;
    }

    @Nullable
    public Object getReenterTransition() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L6;
        return null;
    L6:
        Object r1 = r0.mReenterTransition;
        if (r1 == USE_DEFAULT_TRANSITION) goto L9;
        return r1;
    L9:
        return getExitTransition();
    }

    @NonNull
    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        FragmentStrictMode.onGetRetainInstanceUsage(this);
        return this.mRetainInstance;
    }

    @Nullable
    public Object getReturnTransition() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L6;
        return null;
    L6:
        Object r1 = r0.mReturnTransition;
        if (r1 == USE_DEFAULT_TRANSITION) goto L9;
        return r1;
    L9:
        return getEnterTransition();
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    @NonNull
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    @Nullable
    public Object getSharedElementEnterTransition() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mSharedElementEnterTransition;
    }

    @Nullable
    public Object getSharedElementReturnTransition() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L6;
        return null;
    L6:
        Object r1 = r0.mSharedElementReturnTransition;
        if (r1 == USE_DEFAULT_TRANSITION) goto L9;
        return r1;
    L9:
        return getSharedElementEnterTransition();
    }

    @NonNull
    ArrayList<String> getSharedElementSourceNames() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 == null) goto L9;
        ArrayList<String> r1 = r0.mSharedElementSourceNames;
        if (r1 == null) goto L9;
        return r1;
    L9:
        return new ArrayList();
    }

    @NonNull
    ArrayList<String> getSharedElementTargetNames() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 == null) goto L9;
        ArrayList<String> r1 = r0.mSharedElementTargetNames;
        if (r1 == null) goto L9;
        return r1;
    L9:
        return new ArrayList();
    }

    @NonNull
    public final String getString(@StringRes int r1) {
        return getResources().getString(r1);
    }

    @NonNull
    public final String getString(@StringRes int r1, @Nullable Object... r2) {
        return getResources().getString(r1, r2);
    }

    @Nullable
    public final String getTag() {
        return this.mTag;
    }

    @Nullable
    @Deprecated
    public final Fragment getTargetFragment() {
        return getTargetFragment(true);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        FragmentStrictMode.onGetTargetFragmentRequestCodeUsage(this);
        return this.mTargetRequestCode;
    }

    @NonNull
    public final CharSequence getText(@StringRes int r1) {
        return getResources().getText(r1);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    @Nullable
    public View getView() {
        return this.mView;
    }

    @NonNull
    @MainThread
    public LifecycleOwner getViewLifecycleOwner() {
        FragmentViewLifecycleOwner r1 = this.mViewLifecycleOwner;
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    @NonNull
    public LiveData<LifecycleOwner> getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NonNull
    public ViewModelStore getViewModelStore() {
        if (this.mFragmentManager == null) goto L11;
        if (getMinimumMaxLifecycleState() == Lifecycle.State.INITIALIZED.ordinal()) goto L9;
        return this.mFragmentManager.getViewModelStore(this);
    L9:
        throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    L11:
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    @SuppressLint({"KotlinPropertyAccess"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    void initState() {
        initLifecycle();
        this.mPreviousWho = this.mWho;
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new FragmentManagerImpl();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        if (this.mHost != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mAdded == false) goto L7;
        return true;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        if (this.mHidden == true) goto L10;
        FragmentManager r0 = this.mFragmentManager;
        if (r0 != null) goto L7;
    L9:
        return false;
    L7:
        if (r0.isParentHidden(this.mParentFragment) == false) goto L9;
    L10:
        return true;
    }

    final boolean isInBackStack() {
        if (this.mBackStackNesting <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final boolean isMenuVisible() {
        if (this.mMenuVisible == false) goto L9;
        FragmentManager r0 = this.mFragmentManager;
        if (r0 != null) goto L7;
    L8:
        return true;
    L7:
        if (r0.isParentMenuVisible(this.mParentFragment) == true) goto L8;
    L9:
        return false;
    }

    boolean isPostponed() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.mEnterTransitionPostponed;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isResumed() {
        if (this.mState < 7) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isStateSaved() {
        FragmentManager r0 = this.mFragmentManager;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isStateSaved();
    }

    public final boolean isVisible() {
        if (isAdded() == true) goto L5;
    L13:
        return false;
    L5:
        if (isHidden() == true) goto L13;
        View r0 = this.mView;
        if (r0 == null) goto L13;
        if (r0.getWindowToken() == null) goto L13;
        if (this.mView.getVisibility() != 0) goto L13;
        return true;
    }

    void noteStateNotSaved() {
        this.mChildFragmentManager.noteStateNotSaved();
    }

    @CallSuper
    @MainThread
    @Deprecated
    public void onActivityCreated(@Nullable Bundle r1) {
        this.mCalled = true;
    }

    @Deprecated
    public void onActivityResult(int r3, int r4, @Nullable Intent r5) {
        if (FragmentManager.isLoggingEnabled(2) == false) goto L6;
        Log.v(FragmentManager.TAG, "Fragment " + this + " received the following in onActivityResult(): requestCode: " + r3 + " resultCode: " + r4 + " data: " + r5);
        return;
    }

    @CallSuper
    @MainThread
    @Deprecated
    public void onAttach(@NonNull Activity r1) {
        this.mCalled = true;
    }

    @CallSuper
    @MainThread
    public void onAttach(@NonNull Context r2) {
        this.mCalled = true;
        FragmentHostCallback<?> r3 = this.mHost;
        if (r3 != null) goto L5;
        Activity r4 = null;
    L6:
        if (r4 == null) goto L9;
        this.mCalled = false;
        onAttach(r4);
        return;
    L9:
        return;
    L5:
        r4 = r3.getActivity();
        goto L6
    }

    @MainThread
    @Deprecated
    public void onAttachFragment(@NonNull Fragment r1) {
    }

    @Override // android.content.ComponentCallbacks
    @CallSuper
    public void onConfigurationChanged(@NonNull Configuration r1) {
        this.mCalled = true;
    }

    @MainThread
    public boolean onContextItemSelected(@NonNull MenuItem r1) {
        return false;
    }

    @CallSuper
    @MainThread
    public void onCreate(@Nullable Bundle r2) {
        this.mCalled = true;
        restoreChildFragmentState(r2);
        if (this.mChildFragmentManager.isStateAtLeast(1) == true) goto L6;
        this.mChildFragmentManager.dispatchCreate();
        return;
    }

    @Nullable
    @MainThread
    public Animation onCreateAnimation(int r1, boolean r2, int r3) {
        return null;
    }

    @Nullable
    @MainThread
    public Animator onCreateAnimator(int r1, boolean r2, int r3) {
        return null;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    @MainThread
    public void onCreateContextMenu(@NonNull ContextMenu r1, @NonNull View r2, @Nullable ContextMenu.ContextMenuInfo r3) {
        requireActivity().onCreateContextMenu(r1, r2, r3);
    }

    @MainThread
    @Deprecated
    public void onCreateOptionsMenu(@NonNull Menu r1, @NonNull MenuInflater r2) {
    }

    @Nullable
    @MainThread
    public View onCreateView(@NonNull LayoutInflater r1, @Nullable ViewGroup r2, @Nullable Bundle r3) {
        int r0 = this.mContentLayoutId;
        if (r0 != 0) goto L5;
        return null;
    L5:
        return r1.inflate(r0, r2, false);
    }

    @CallSuper
    @MainThread
    public void onDestroy() {
        this.mCalled = true;
    }

    @MainThread
    @Deprecated
    public void onDestroyOptionsMenu() {
    }

    @CallSuper
    @MainThread
    public void onDestroyView() {
        this.mCalled = true;
    }

    @CallSuper
    @MainThread
    public void onDetach() {
        this.mCalled = true;
    }

    @NonNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle r1) {
        return getLayoutInflater(r1);
    }

    @MainThread
    public void onHiddenChanged(boolean r1) {
    }

    @CallSuper
    @UiThread
    @Deprecated
    public void onInflate(@NonNull Activity r1, @NonNull AttributeSet r2, @Nullable Bundle r3) {
        this.mCalled = true;
    }

    @CallSuper
    @UiThread
    public void onInflate(@NonNull Context r2, @NonNull AttributeSet r3, @Nullable Bundle r4) {
        this.mCalled = true;
        FragmentHostCallback<?> r5 = this.mHost;
        if (r5 != null) goto L5;
        Activity r6 = null;
    L6:
        if (r6 == null) goto L9;
        this.mCalled = false;
        onInflate(r6, r3, r4);
        return;
    L9:
        return;
    L5:
        r6 = r5.getActivity();
        goto L6
    }

    @Override // android.content.ComponentCallbacks
    @CallSuper
    @MainThread
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean r1) {
    }

    @MainThread
    @Deprecated
    public boolean onOptionsItemSelected(@NonNull MenuItem r1) {
        return false;
    }

    @MainThread
    @Deprecated
    public void onOptionsMenuClosed(@NonNull Menu r1) {
    }

    @CallSuper
    @MainThread
    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean r1) {
    }

    @MainThread
    @Deprecated
    public void onPrepareOptionsMenu(@NonNull Menu r1) {
    }

    @MainThread
    public void onPrimaryNavigationFragmentChanged(boolean r1) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int r1, @NonNull String[] r2, @NonNull int[] r3) {
    }

    @CallSuper
    @MainThread
    public void onResume() {
        this.mCalled = true;
    }

    @MainThread
    public void onSaveInstanceState(@NonNull Bundle r1) {
    }

    @CallSuper
    @MainThread
    public void onStart() {
        this.mCalled = true;
    }

    @CallSuper
    @MainThread
    public void onStop() {
        this.mCalled = true;
    }

    @MainThread
    public void onViewCreated(@NonNull View r1, @Nullable Bundle r2) {
    }

    @CallSuper
    @MainThread
    public void onViewStateRestored(@Nullable Bundle r1) {
        this.mCalled = true;
    }

    void performActivityCreated(Bundle r3) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(r3);
        if (this.mCalled == false) goto L7;
        restoreViewState();
        this.mChildFragmentManager.dispatchActivityCreated();
        return;
    L7:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    void performAttach() {
        Iterator<OnPreAttachedListener> r0 = this.mOnPreAttachedListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onPreAttached();
        goto L4
    L6:
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.attachController(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach(this.mHost.getContext());
        if (this.mCalled == false) goto L11;
        this.mFragmentManager.dispatchOnAttachFragment(this);
        this.mChildFragmentManager.dispatchAttach();
        return;
    L11:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onAttach()");
    }

    void performConfigurationChanged(@NonNull Configuration r1) {
        onConfigurationChanged(r1);
    }

    boolean performContextItemSelected(@NonNull MenuItem r2) {
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (onContextItemSelected(r2) == false) goto L9;
        return true;
    L9:
        return this.mChildFragmentManager.dispatchContextItemSelected(r2);
    }

    void performCreate(Bundle r4) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mState = 1;
        this.mCalled = false;
        if (Build.VERSION.SDK_INT < 19) goto L5;
        this.mLifecycleRegistry.addObserver(new AnonymousClass6(this));
    L5:
        this.mSavedStateRegistryController.performRestore(r4);
        onCreate(r4);
        this.mIsCreated = true;
        if (this.mCalled == false) goto L10;
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        return;
    L10:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
    }

    boolean performCreateOptionsMenu(@NonNull Menu r3, @NonNull MenuInflater r4) {
        boolean r1 = false;
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (this.mHasMenu == false) goto L10;
        if (this.mMenuVisible == false) goto L10;
        r1 = true;
        onCreateOptionsMenu(r3, r4);
    L10:
        return r1 | this.mChildFragmentManager.dispatchCreateOptionsMenu(r3, r4);
    }

    void performCreateView(@NonNull LayoutInflater r3, @Nullable ViewGroup r4, @Nullable Bundle r5) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new FragmentViewLifecycleOwner(this, getViewModelStore());
        View r6 = onCreateView(r3, r4, r5);
        this.mView = r6;
        if (r6 == null) goto L6;
        this.mViewLifecycleOwner.initialize();
        ViewTreeLifecycleOwner.set(this.mView, this.mViewLifecycleOwner);
        ViewTreeViewModelStoreOwner.set(this.mView, this.mViewLifecycleOwner);
        ViewTreeSavedStateRegistryOwner.set(this.mView, this.mViewLifecycleOwner);
        this.mViewLifecycleOwnerLiveData.setValue(this.mViewLifecycleOwner);
        return;
    L6:
        if (this.mViewLifecycleOwner.isInitialized() == true) goto L10;
        this.mViewLifecycleOwner = null;
        return;
    L10:
        throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
    }

    void performDestroy() {
        this.mChildFragmentManager.dispatchDestroy();
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (this.mCalled == false) goto L6;
        return;
    L6:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
    }

    void performDestroyView() {
        this.mChildFragmentManager.dispatchDestroyView();
        if (this.mView != null) goto L5;
    L7:
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (this.mCalled == false) goto L12;
        LoaderManager.getInstance(this).markForRedelivery();
        this.mPerformedCreateView = false;
        return;
    L12:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
    L5:
        if (this.mViewLifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED) == false) goto L7;
        this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        goto L7
    }

    void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (this.mCalled == false) goto L9;
        if (this.mChildFragmentManager.isDestroyed() == true) goto L10;
        this.mChildFragmentManager.dispatchDestroy();
        this.mChildFragmentManager = new FragmentManagerImpl();
        return;
    L10:
        return;
    L9:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDetach()");
    }

    @NonNull
    LayoutInflater performGetLayoutInflater(@Nullable Bundle r1) {
        LayoutInflater r2 = onGetLayoutInflater(r1);
        this.mLayoutInflater = r2;
        return r2;
    }

    void performLowMemory() {
        onLowMemory();
    }

    void performMultiWindowModeChanged(boolean r1) {
        onMultiWindowModeChanged(r1);
    }

    boolean performOptionsItemSelected(@NonNull MenuItem r2) {
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (this.mHasMenu == false) goto L13;
        if (this.mMenuVisible == false) goto L13;
        if (onOptionsItemSelected(r2) == false) goto L13;
        return true;
    L13:
        return this.mChildFragmentManager.dispatchOptionsItemSelected(r2);
    }

    void performOptionsMenuClosed(@NonNull Menu r2) {
        if (this.mHidden == false) goto L5;
        return;
    L5:
        if (this.mHasMenu == true) goto L7;
    L9:
        this.mChildFragmentManager.dispatchOptionsMenuClosed(r2);
        return;
    L7:
        if (this.mMenuVisible == false) goto L9;
        onOptionsMenuClosed(r2);
        goto L9
    }

    void performPause() {
        this.mChildFragmentManager.dispatchPause();
        if (this.mView == null) goto L5;
        this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    L5:
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (this.mCalled == false) goto L9;
        return;
    L9:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
    }

    void performPictureInPictureModeChanged(boolean r1) {
        onPictureInPictureModeChanged(r1);
    }

    boolean performPrepareOptionsMenu(@NonNull Menu r3) {
        boolean r1 = false;
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (this.mHasMenu == false) goto L10;
        if (this.mMenuVisible == false) goto L10;
        r1 = true;
        onPrepareOptionsMenu(r3);
    L10:
        return r1 | this.mChildFragmentManager.dispatchPrepareOptionsMenu(r3);
    }

    void performPrimaryNavigationFragmentChanged() {
        boolean r0 = this.mFragmentManager.isPrimaryNavigation(this);
        Boolean r1 = this.mIsPrimaryNavigationFragment;
        if (r1 != null) goto L5;
    L6:
        this.mIsPrimaryNavigationFragment = Boolean.valueOf(r0);
        onPrimaryNavigationFragmentChanged(r0);
        this.mChildFragmentManager.dispatchPrimaryNavigationFragmentChanged();
        return;
    L5:
        if (r1.booleanValue() != r0) goto L6;
    }

    void performResume() {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mChildFragmentManager.execPendingActions(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (this.mCalled == false) goto L10;
        LifecycleRegistry r0 = this.mLifecycleRegistry;
        Lifecycle.Event r1 = Lifecycle.Event.ON_RESUME;
        r0.handleLifecycleEvent(r1);
        if (this.mView == null) goto L7;
        this.mViewLifecycleOwner.handleLifecycleEvent(r1);
    L7:
        this.mChildFragmentManager.dispatchResume();
        return;
    L10:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
    }

    void performSaveInstanceState(Bundle r2) {
        onSaveInstanceState(r2);
        this.mSavedStateRegistryController.performSave(r2);
        Bundle r1 = this.mChildFragmentManager.saveAllStateInternal();
        if (r1 == null) goto L6;
        r2.putParcelable("android:support:fragments", r1);
        return;
    }

    void performStart() {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mChildFragmentManager.execPendingActions(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (this.mCalled == false) goto L10;
        LifecycleRegistry r0 = this.mLifecycleRegistry;
        Lifecycle.Event r1 = Lifecycle.Event.ON_START;
        r0.handleLifecycleEvent(r1);
        if (this.mView == null) goto L7;
        this.mViewLifecycleOwner.handleLifecycleEvent(r1);
    L7:
        this.mChildFragmentManager.dispatchStart();
        return;
    L10:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
    }

    void performStop() {
        this.mChildFragmentManager.dispatchStop();
        if (this.mView == null) goto L5;
        this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    L5:
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        onStop();
        if (this.mCalled == false) goto L9;
        return;
    L9:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
    }

    void performViewCreated() {
        onViewCreated(this.mView, this.mSavedFragmentState);
        this.mChildFragmentManager.dispatchViewCreated();
    }

    public void postponeEnterTransition() {
        ensureAnimationInfo().mEnterTransitionPostponed = true;
    }

    public final void postponeEnterTransition(long r3, @NonNull TimeUnit r5) {
        ensureAnimationInfo().mEnterTransitionPostponed = true;
        FragmentManager r0 = this.mFragmentManager;
        if (r0 == null) goto L5;
        Handler r1 = r0.getHost().getHandler();
    L6:
        r1.removeCallbacks(this.mPostponedDurationRunnable);
        r1.postDelayed(this.mPostponedDurationRunnable, r5.toMillis(r3));
        return;
    L5:
        r1 = new Handler(Looper.getMainLooper());
        goto L6
    }

    @Override // androidx.activity.result.ActivityResultCaller
    @NonNull
    @MainThread
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(@NonNull ActivityResultContract<I, O> r2, @NonNull ActivityResultCallback<O> r3) {
        return prepareCallInternal(r2, new AnonymousClass7(this), r3);
    }

    @Override // androidx.activity.result.ActivityResultCaller
    @NonNull
    @MainThread
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(@NonNull ActivityResultContract<I, O> r2, @NonNull final ActivityResultRegistry r3, @NonNull ActivityResultCallback<O> r4) {
        return prepareCallInternal(r2, new AnonymousClass8(this, r3), r4);
    }

    public void registerForContextMenu(@NonNull View r1) {
        r1.setOnCreateContextMenuListener(this);
    }

    @Deprecated
    public final void requestPermissions(@NonNull String[] r2, int r3) {
        if (this.mHost == null) goto L7;
        getParentFragmentManager().launchRequestPermissions(this, r2, r3);
        return;
    L7:
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @NonNull
    public final FragmentActivity requireActivity() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    @NonNull
    public final Bundle requireArguments() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    @NonNull
    public final Context requireContext() {
        Context r0 = getContext();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    @NonNull
    @Deprecated
    public final FragmentManager requireFragmentManager() {
        return getParentFragmentManager();
    }

    @NonNull
    public final Object requireHost() {
        Object r0 = getHost();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Fragment " + this + " not attached to a host.");
    }

    @NonNull
    public final Fragment requireParentFragment() {
        Fragment r0 = getParentFragment();
        if (r0 == null) goto L5;
        return r0;
    L5:
        if (getContext() != null) goto L9;
        throw new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
    L9:
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    @NonNull
    public final View requireView() {
        View r0 = getView();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    void restoreChildFragmentState(@Nullable Bundle r2) {
        if (r2 == null) goto L7;
        Parcelable r3 = r2.getParcelable("android:support:fragments");
        if (r3 == null) goto L8;
        this.mChildFragmentManager.restoreSaveStateInternal(r3);
        this.mChildFragmentManager.dispatchCreate();
        return;
    L8:
        return;
    }

    final void restoreViewState(Bundle r4) {
        SparseArray<Parcelable> r0 = this.mSavedViewState;
        if (r0 == null) goto L6;
        this.mView.restoreHierarchyState(r0);
        this.mSavedViewState = null;
    L6:
        if (this.mView == null) goto L8;
        this.mViewLifecycleOwner.performRestore(this.mSavedViewRegistryState);
        this.mSavedViewRegistryState = null;
    L8:
        this.mCalled = false;
        onViewStateRestored(r4);
        if (this.mCalled == false) goto L15;
        if (this.mView == null) goto L16;
        this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        return;
    L16:
        return;
    L15:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
    }

    public void setAllowEnterTransitionOverlap(boolean r1) {
        AnimationInfo r0 = ensureAnimationInfo();
        r0.mAllowEnterTransitionOverlap = Boolean.valueOf(r1);
    }

    public void setAllowReturnTransitionOverlap(boolean r1) {
        AnimationInfo r0 = ensureAnimationInfo();
        r0.mAllowReturnTransitionOverlap = Boolean.valueOf(r1);
    }

    void setAnimations(@AnimRes int r2, @AnimRes int r3, @AnimRes int r4, @AnimRes int r5) {
        if (this.mAnimationInfo != null) goto L9;
        if (r2 != 0) goto L9;
        if (r3 != 0) goto L9;
        if (r4 != 0) goto L9;
        if (r5 != 0) goto L9;
        return;
    L9:
        ensureAnimationInfo().mEnterAnim = r2;
        ensureAnimationInfo().mExitAnim = r3;
        ensureAnimationInfo().mPopEnterAnim = r4;
        ensureAnimationInfo().mPopExitAnim = r5;
    }

    public void setArguments(@Nullable Bundle r2) {
        if (this.mFragmentManager != null) goto L5;
    L9:
        this.mArguments = r2;
        return;
    L5:
        if (isStateSaved() == false) goto L9;
        throw new IllegalStateException("Fragment already added and state has been saved");
    }

    public void setEnterSharedElementCallback(@Nullable SharedElementCallback r1) {
        ensureAnimationInfo().mEnterTransitionCallback = r1;
    }

    public void setEnterTransition(@Nullable Object r1) {
        ensureAnimationInfo().mEnterTransition = r1;
    }

    public void setExitSharedElementCallback(@Nullable SharedElementCallback r1) {
        ensureAnimationInfo().mExitTransitionCallback = r1;
    }

    public void setExitTransition(@Nullable Object r1) {
        ensureAnimationInfo().mExitTransition = r1;
    }

    void setFocusedView(View r1) {
        ensureAnimationInfo().mFocusedView = r1;
    }

    @Deprecated
    public void setHasOptionsMenu(boolean r2) {
        if (this.mHasMenu == r2) goto L10;
        this.mHasMenu = r2;
        if (isAdded() == true) goto L7;
        return;
    L7:
        if (isHidden() == true) goto L12;
        this.mHost.onSupportInvalidateOptionsMenu();
        return;
    L12:
        return;
    }

    public void setInitialSavedState(@Nullable SavedState r2) {
        if (this.mFragmentManager != null) goto L12;
        if (r2 == null) goto L8;
        Bundle r3 = r2.mState;
        if (r3 == null) goto L8;
    L9:
        this.mSavedFragmentState = r3;
        return;
    L8:
        r3 = null;
        goto L9
    L12:
        throw new IllegalStateException("Fragment already added");
    }

    public void setMenuVisibility(boolean r2) {
        if (this.mMenuVisible == r2) goto L12;
        this.mMenuVisible = r2;
        if (this.mHasMenu == true) goto L7;
        return;
    L7:
        if (isAdded() == true) goto L9;
        return;
    L9:
        if (isHidden() == true) goto L15;
        this.mHost.onSupportInvalidateOptionsMenu();
        return;
    L15:
        return;
    }

    void setNextTransition(int r2) {
        if (this.mAnimationInfo != null) goto L6;
        if (r2 != 0) goto L6;
        return;
    L6:
        ensureAnimationInfo();
        this.mAnimationInfo.mNextTransition = r2;
    }

    void setPopDirection(boolean r2) {
        if (this.mAnimationInfo != null) goto L5;
        return;
    L5:
        ensureAnimationInfo().mIsPop = r2;
    }

    void setPostOnViewCreatedAlpha(float r1) {
        ensureAnimationInfo().mPostOnViewCreatedAlpha = r1;
    }

    public void setReenterTransition(@Nullable Object r1) {
        ensureAnimationInfo().mReenterTransition = r1;
    }

    @Deprecated
    public void setRetainInstance(boolean r2) {
        FragmentStrictMode.onSetRetainInstanceUsage(this);
        this.mRetainInstance = r2;
        FragmentManager r0 = this.mFragmentManager;
        if (r0 == null) goto L7;
        if (r2 == false) goto L6;
        r0.addRetainedFragment(this);
        return;
    L6:
        r0.removeRetainedFragment(this);
        return;
    L7:
        this.mRetainInstanceChangedWhileDetached = true;
    }

    public void setReturnTransition(@Nullable Object r1) {
        ensureAnimationInfo().mReturnTransition = r1;
    }

    public void setSharedElementEnterTransition(@Nullable Object r1) {
        ensureAnimationInfo().mSharedElementEnterTransition = r1;
    }

    void setSharedElementNames(@Nullable ArrayList<String> r1, @Nullable ArrayList<String> r2) {
        ensureAnimationInfo();
        AnimationInfo r0 = this.mAnimationInfo;
        r0.mSharedElementSourceNames = r1;
        r0.mSharedElementTargetNames = r2;
    }

    public void setSharedElementReturnTransition(@Nullable Object r1) {
        ensureAnimationInfo().mSharedElementReturnTransition = r1;
    }

    @Deprecated
    public void setTargetFragment(@Nullable Fragment r4, int r5) {
        if (r4 == null) goto L4;
        FragmentStrictMode.onSetTargetFragmentUsage(this, r4, r5);
    L4:
        FragmentManager r0 = this.mFragmentManager;
        if (r4 == null) goto L7;
        FragmentManager r2 = r4.mFragmentManager;
    L8:
        if (r0 == null) goto L14;
        if (r2 == null) goto L14;
        if (r0 == r2) goto L14;
        throw new IllegalArgumentException("Fragment " + r4 + " must share the same FragmentManager to be set as a target fragment");
    L14:
        Fragment r1 = r4;
    L15:
        if (r1 == null) goto L21;
        if (r1.equals(this) == true) goto L20;
        r1 = r1.getTargetFragment(false);
        goto L15
    L20:
        throw new IllegalArgumentException("Setting " + r4 + " as the target of " + this + " would create a target cycle");
    L21:
        if (r4 != null) goto L25;
        this.mTargetWho = null;
    L23:
        this.mTarget = null;
    L30:
        this.mTargetRequestCode = r5;
        return;
    L25:
        if (this.mFragmentManager != null) goto L27;
    L29:
        this.mTargetWho = null;
        this.mTarget = r4;
        goto L30
    L27:
        if (r4.mFragmentManager == null) goto L29;
        this.mTargetWho = r4.mWho;
        goto L23
    L7:
        r2 = null;
        goto L8
    }

    @Deprecated
    public void setUserVisibleHint(boolean r4) {
        FragmentStrictMode.onSetUserVisibleHint(this, r4);
        if (this.mUserVisibleHint == true) goto L14;
        if (r4 == false) goto L14;
        if (this.mState >= 5) goto L14;
        if (this.mFragmentManager == null) goto L14;
        if (isAdded() == false) goto L14;
        if (this.mIsCreated == false) goto L14;
        FragmentManager r0 = this.mFragmentManager;
        r0.performPendingDeferredStart(r0.createOrGetFragmentStateManager(this));
    L14:
        this.mUserVisibleHint = r4;
        if (this.mState >= 5) goto L18;
        if (r4 == true) goto L18;
        boolean r1 = true;
    L19:
        this.mDeferStart = r1;
        if (this.mSavedFragmentState == null) goto L23;
        this.mSavedUserVisibleHint = Boolean.valueOf(r4);
        return;
    L23:
        return;
    L18:
        r1 = false;
        goto L19
    }

    public boolean shouldShowRequestPermissionRationale(@NonNull String r1) {
        FragmentHostCallback<?> r0 = this.mHost;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.onShouldShowRequestPermissionRationale(r1);
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent r2) {
        startActivity(r2, null);
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent r3, @Nullable Bundle r4) {
        FragmentHostCallback<?> r0 = this.mHost;
        if (r0 == null) goto L7;
        r0.onStartActivityFromFragment(this, r3, -1, r4);
        return;
    L7:
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent r2, int r3) {
        startActivityForResult(r2, r3, null);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent r2, int r3, @Nullable Bundle r4) {
        if (this.mHost == null) goto L7;
        getParentFragmentManager().launchStartActivityForResult(this, r2, r3, r4);
        return;
    L7:
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender r10, int r11, @Nullable Intent r12, int r13, int r14, int r15, @Nullable Bundle r16) {
        if (this.mHost == null) goto L11;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L8;
        Log.v(FragmentManager.TAG, "Fragment " + this + " received the following in startIntentSenderForResult() requestCode: " + r11 + " IntentSender: " + r10 + " fillInIntent: " + r12 + " options: " + r16);
    L8:
        getParentFragmentManager().launchStartIntentSenderForResult(this, r10, r11, r12, r13, r14, r15, r16);
        return;
    L11:
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo != null) goto L5;
        return;
    L5:
        if (ensureAnimationInfo().mEnterTransitionPostponed == true) goto L8;
        return;
    L8:
        if (this.mHost != null) goto L11;
        ensureAnimationInfo().mEnterTransitionPostponed = false;
        return;
    L11:
        if (Looper.myLooper() == this.mHost.getHandler().getLooper()) goto L13;
        this.mHost.getHandler().postAtFrontOfQueue(new AnonymousClass3(this));
        return;
    L13:
        callStartTransitionListener(true);
    }

    @NonNull
    public String toString() {
        StringBuilder r0 = new StringBuilder(128);
        r0.append(getClass().getSimpleName());
        r0.append("{");
        r0.append(Integer.toHexString(System.identityHashCode(this)));
        r0.append("}");
        r0.append(" (");
        r0.append(this.mWho);
        if (this.mFragmentId == 0) goto L6;
        r0.append(" id=0x");
        r0.append(Integer.toHexString(this.mFragmentId));
    L6:
        if (this.mTag == null) goto L8;
        r0.append(" tag=");
        r0.append(this.mTag);
    L8:
        r0.append(")");
        return r0.toString();
    }

    public void unregisterForContextMenu(@NonNull View r1) {
        r1.setOnCreateContextMenuListener(null);
    }
}
