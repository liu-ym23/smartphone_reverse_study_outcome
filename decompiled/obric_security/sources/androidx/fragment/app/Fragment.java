package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
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
import androidx.arch.core.util.Function;
import androidx.core.app.SharedElementCallback;
import androidx.core.view.LayoutInflaterCompat;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
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
    private boolean mCalled;
    FragmentManager mChildFragmentManager;
    ViewGroup mContainer;
    int mContainerId;
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
    boolean mIsNewlyAdded;
    private Boolean mIsPrimaryNavigationFragment;
    LayoutInflater mLayoutInflater;
    LifecycleRegistry mLifecycleRegistry;
    Lifecycle.State mMaxState;
    boolean mMenuVisible;
    private final AtomicInteger mNextLocalRequestCode;
    private final ArrayList<OnPreAttachedListener> mOnPreAttachedListeners;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    float mPostponedAlpha;
    Runnable mPostponedDurationRunnable;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    SavedStateRegistryController mSavedStateRegistryController;
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
    FragmentViewLifecycleOwner mViewLifecycleOwner;
    MutableLiveData<LifecycleOwner> mViewLifecycleOwnerLiveData;
    String mWho;

    static class AnimationInfo {
        Boolean mAllowEnterTransitionOverlap;
        Boolean mAllowReturnTransitionOverlap;
        View mAnimatingAway;
        Animator mAnimator;
        int mEnterAnim;
        Object mEnterTransition;
        SharedElementCallback mEnterTransitionCallback;
        boolean mEnterTransitionPostponed;
        int mExitAnim;
        Object mExitTransition;
        SharedElementCallback mExitTransitionCallback;
        View mFocusedView;
        boolean mIsHideReplaced;
        boolean mIsPop;
        int mNextTransition;
        int mPopEnterAnim;
        int mPopExitAnim;
        float mPostOnViewCreatedAlpha;
        Object mReenterTransition;
        Object mReturnTransition;
        Object mSharedElementEnterTransition;
        Object mSharedElementReturnTransition;
        ArrayList<String> mSharedElementSourceNames;
        ArrayList<String> mSharedElementTargetNames;
        OnStartEnterTransitionListener mStartEnterTransitionListener;

        AnimationInfo() {
            this.mEnterTransition = null;
            this.mReturnTransition = Fragment.USE_DEFAULT_TRANSITION;
            this.mExitTransition = null;
            this.mReenterTransition = Fragment.USE_DEFAULT_TRANSITION;
            this.mSharedElementEnterTransition = null;
            this.mSharedElementReturnTransition = Fragment.USE_DEFAULT_TRANSITION;
            this.mEnterTransitionCallback = null;
            this.mExitTransitionCallback = null;
            this.mPostOnViewCreatedAlpha = 1.0f;
            this.mFocusedView = null;
        }
    }

    public static class InstantiationException extends RuntimeException {
        public InstantiationException(String r1, Exception r2) {
            super(r1, r2);
        }
    }

    private static abstract class OnPreAttachedListener {
        abstract void onPreAttached();

        private OnPreAttachedListener() {
        }

        /* synthetic */ OnPreAttachedListener(AnonymousClass1 r1) {
            this();
        }
    }

    interface OnStartEnterTransitionListener {
        void onStartEnterTransition();

        void startListening();
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        final Bundle mState;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        SavedState(Bundle r1) {
            this.mState = r1;
        }

        SavedState(Parcel r1, ClassLoader r2) {
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
        public void writeToParcel(Parcel r1, int r2) {
            r1.writeBundle(this.mState);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    @Deprecated
    public void onAttachFragment(Fragment r1) {
    }

    public boolean onContextItemSelected(MenuItem r1) {
        return false;
    }

    public Animation onCreateAnimation(int r1, boolean r2, int r3) {
        return null;
    }

    public Animator onCreateAnimator(int r1, boolean r2, int r3) {
        return null;
    }

    public void onCreateOptionsMenu(Menu r1, MenuInflater r2) {
    }

    public void onDestroyOptionsMenu() {
    }

    public void onHiddenChanged(boolean r1) {
    }

    public void onMultiWindowModeChanged(boolean r1) {
    }

    public boolean onOptionsItemSelected(MenuItem r1) {
        return false;
    }

    public void onOptionsMenuClosed(Menu r1) {
    }

    public void onPictureInPictureModeChanged(boolean r1) {
    }

    public void onPrepareOptionsMenu(Menu r1) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean r1) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int r1, String[] r2, int[] r3) {
    }

    public void onSaveInstanceState(Bundle r1) {
    }

    public void onViewCreated(View r1, Bundle r2) {
    }

    static {
        USE_DEFAULT_TRANSITION = new Object();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public LifecycleOwner getViewLifecycleOwner() {
        FragmentViewLifecycleOwner r1 = this.mViewLifecycleOwner;
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public LiveData<LifecycleOwner> getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        if (this.mFragmentManager == null) goto L11;
        if (getMinimumMaxLifecycleState() == Lifecycle.State.INITIALIZED.ordinal()) goto L9;
        return this.mFragmentManager.getViewModelStore(this);
    L9:
        throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    L11:
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    private int getMinimumMaxLifecycleState() {
        if (this.mMaxState == Lifecycle.State.INITIALIZED) goto L10;
        if (this.mParentFragment == null) goto L10;
        return Math.min(this.mMaxState.ordinal(), this.mParentFragment.getMinimumMaxLifecycleState());
    L10:
        return this.mMaxState.ordinal();
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        if (this.mFragmentManager == null) goto L22;
        if (this.mDefaultFactory != null) goto L20;
        Context r0 = requireContext().getApplicationContext();
    L8:
        if ((r0 instanceof ContextWrapper) == false) goto L13;
        if ((r0 instanceof Application) == true) goto L11;
        r0 = ((ContextWrapper) r0).getBaseContext();
        goto L8
    L11:
        Application r1 = (Application) r0;
    L14:
        if (r1 == null) goto L16;
    L18:
        this.mDefaultFactory = new SavedStateViewModelFactory(r1, this, getArguments());
        goto L20
    L16:
        if (FragmentManager.isLoggingEnabled(3) == false) goto L18;
        Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        goto L18
    L13:
        r1 = null;
    L20:
        return this.mDefaultFactory;
    L22:
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.getSavedStateRegistry();
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
        initLifecycle();
    }

    public Fragment(int r1) {
        this();
        this.mContentLayoutId = r1;
    }

    private void initLifecycle() {
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        this.mSavedStateRegistryController = SavedStateRegistryController.create(this);
        this.mDefaultFactory = null;
    }

    @Deprecated
    public static Fragment instantiate(Context r1, String r2) {
        return instantiate(r1, r2, null);
    }

    @Deprecated
    public static Fragment instantiate(Context r4, String r5, Bundle r6) {
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

    final boolean isInBackStack() {
        if (this.mBackStackNesting <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean equals(Object r1) {
        return super.equals(r1);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(128);
        r0.append(getClass().getSimpleName());
        r0.append("{");
        r0.append(Integer.toHexString(System.identityHashCode(this)));
        r0.append("} (");
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

    public final int getId() {
        return this.mFragmentId;
    }

    public final String getTag() {
        return this.mTag;
    }

    public void setArguments(Bundle r2) {
        if (this.mFragmentManager != null) goto L5;
    L9:
        this.mArguments = r2;
        return;
    L5:
        if (isStateSaved() == false) goto L9;
        throw new IllegalStateException("Fragment already added and state has been saved");
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final Bundle requireArguments() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    public final boolean isStateSaved() {
        FragmentManager r0 = this.mFragmentManager;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isStateSaved();
    }

    public void setInitialSavedState(SavedState r2) {
        if (this.mFragmentManager != null) goto L12;
        if (r2 != null) goto L6;
    L8:
        Bundle r3 = null;
    L9:
        this.mSavedFragmentState = r3;
        return;
    L6:
        if (r2.mState == null) goto L8;
        r3 = r2.mState;
        goto L9
    L12:
        throw new IllegalStateException("Fragment already added");
    }

    @Deprecated
    public void setTargetFragment(Fragment r4, int r5) {
        FragmentManager r0 = this.mFragmentManager;
        if (r4 == null) goto L5;
        FragmentManager r2 = r4.mFragmentManager;
    L6:
        if (r0 == null) goto L12;
        if (r2 == null) goto L12;
        if (r0 == r2) goto L12;
        throw new IllegalArgumentException("Fragment " + r4 + " must share the same FragmentManager to be set as a target fragment");
    L12:
        Fragment r1 = r4;
    L13:
        if (r1 == null) goto L19;
        if (r1.equals(this) == true) goto L18;
        r1 = r1.getTargetFragment();
        goto L13
    L18:
        throw new IllegalArgumentException("Setting " + r4 + " as the target of " + this + " would create a target cycle");
    L19:
        if (r4 != null) goto L22;
        this.mTargetWho = null;
        this.mTarget = null;
    L27:
        this.mTargetRequestCode = r5;
        return;
    L22:
        if (this.mFragmentManager != null) goto L24;
    L26:
        this.mTargetWho = null;
        this.mTarget = r4;
        goto L27
    L24:
        if (r4.mFragmentManager == null) goto L26;
        this.mTargetWho = r4.mWho;
        this.mTarget = null;
        goto L27
    L5:
        r2 = null;
        goto L6
    }

    @Deprecated
    public final Fragment getTargetFragment() {
        Fragment r0 = this.mTarget;
        if (r0 == null) goto L5;
        return r0;
    L5:
        FragmentManager r1 = this.mFragmentManager;
        if (r1 == null) goto L11;
        String r2 = this.mTargetWho;
        if (r2 != null) goto L10;
        return null;
    L10:
        return r1.findActiveFragment(r2);
    L11:
        return null;
    }

    @Deprecated
    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    public Context getContext() {
        FragmentHostCallback<?> r0 = this.mHost;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getContext();
    }

    public final Context requireContext() {
        Context r0 = getContext();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public final FragmentActivity getActivity() {
        FragmentHostCallback<?> r0 = this.mHost;
        if (r0 != null) goto L6;
        return null;
    L6:
        return (FragmentActivity) r0.getActivity();
    }

    public final FragmentActivity requireActivity() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public final Object getHost() {
        FragmentHostCallback<?> r0 = this.mHost;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.onGetHost();
    }

    public final Object requireHost() {
        Object r0 = getHost();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Fragment " + this + " not attached to a host.");
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    public final CharSequence getText(int r1) {
        return getResources().getText(r1);
    }

    public final String getString(int r1) {
        return getResources().getString(r1);
    }

    public final String getString(int r1, Object... r2) {
        return getResources().getString(r1, r2);
    }

    @Deprecated
    public final FragmentManager getFragmentManager() {
        return this.mFragmentManager;
    }

    public final FragmentManager getParentFragmentManager() {
        FragmentManager r0 = this.mFragmentManager;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    @Deprecated
    public final FragmentManager requireFragmentManager() {
        return getParentFragmentManager();
    }

    public final FragmentManager getChildFragmentManager() {
        if (this.mHost == null) goto L7;
        return this.mChildFragmentManager;
    L7:
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

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

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    final boolean isRemovingParent() {
        Fragment r1 = getParentFragment();
        if (r1 != null) goto L5;
    L9:
        return false;
    L5:
        if (r1.isRemoving() == false) goto L7;
    L8:
        return true;
    L7:
        if (r1.isRemovingParent() == false) goto L9;
        goto L8
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isResumed() {
        if (this.mState < 7) goto L5;
        return true;
    L5:
        return false;
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

    public final boolean isHidden() {
        return this.mHidden;
    }

    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

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

    @Deprecated
    public void setRetainInstance(boolean r2) {
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

    @Deprecated
    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

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

    @Deprecated
    public void setUserVisibleHint(boolean r4) {
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

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    @Deprecated
    public LoaderManager getLoaderManager() {
        return LoaderManager.getInstance(this);
    }

    public void startActivity(Intent r2) {
        startActivity(r2, null);
    }

    public void startActivity(Intent r3, Bundle r4) {
        FragmentHostCallback<?> r0 = this.mHost;
        if (r0 == null) goto L7;
        r0.onStartActivityFromFragment(this, r3, -1, r4);
        return;
    L7:
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public void startActivityForResult(Intent r2, int r3) {
        startActivityForResult(r2, r3, null);
    }

    @Deprecated
    public void startActivityForResult(Intent r2, int r3, Bundle r4) {
        if (this.mHost == null) goto L7;
        getParentFragmentManager().launchStartActivityForResult(this, r2, r3, r4);
        return;
    L7:
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender r10, int r11, Intent r12, int r13, int r14, int r15, Bundle r16) throws IntentSender.SendIntentException {
        if (this.mHost == null) goto L11;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L8;
        Log.v("FragmentManager", "Fragment " + this + " received the following in startIntentSenderForResult() requestCode: " + r11 + " IntentSender: " + r10 + " fillInIntent: " + r12 + " options: " + r16);
    L8:
        getParentFragmentManager().launchStartIntentSenderForResult(this, r10, r11, r12, r13, r14, r15, r16);
        return;
    L11:
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public void onActivityResult(int r3, int r4, Intent r5) {
        if (FragmentManager.isLoggingEnabled(2) == false) goto L6;
        Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + r3 + " resultCode: " + r4 + " data: " + r5);
        return;
    }

    @Deprecated
    public final void requestPermissions(String[] r2, int r3) {
        if (this.mHost == null) goto L7;
        getParentFragmentManager().launchRequestPermissions(this, r2, r3);
        return;
    L7:
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public boolean shouldShowRequestPermissionRationale(String r1) {
        FragmentHostCallback<?> r0 = this.mHost;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.onShouldShowRequestPermissionRationale(r1);
    }

    public LayoutInflater onGetLayoutInflater(Bundle r1) {
        return getLayoutInflater(r1);
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater r0 = this.mLayoutInflater;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return performGetLayoutInflater(null);
    }

    LayoutInflater performGetLayoutInflater(Bundle r1) {
        LayoutInflater r2 = onGetLayoutInflater(r1);
        this.mLayoutInflater = r2;
        return r2;
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle r1) {
        FragmentHostCallback<?> r2 = this.mHost;
        if (r2 == null) goto L7;
        LayoutInflater r3 = r2.onGetLayoutInflater();
        LayoutInflaterCompat.setFactory2(r3, this.mChildFragmentManager.getLayoutInflaterFactory());
        return r3;
    L7:
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    public void onInflate(Context r2, AttributeSet r3, Bundle r4) {
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

    @Deprecated
    public void onInflate(Activity r1, AttributeSet r2, Bundle r3) {
        this.mCalled = true;
    }

    public void onAttach(Context r2) {
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

    @Deprecated
    public void onAttach(Activity r1) {
        this.mCalled = true;
    }

    public void onCreate(Bundle r2) {
        this.mCalled = true;
        restoreChildFragmentState(r2);
        if (this.mChildFragmentManager.isStateAtLeast(1) == true) goto L6;
        this.mChildFragmentManager.dispatchCreate();
        return;
    }

    void restoreChildFragmentState(Bundle r2) {
        if (r2 == null) goto L7;
        Parcelable r3 = r2.getParcelable("android:support:fragments");
        if (r3 == null) goto L8;
        this.mChildFragmentManager.restoreSaveState(r3);
        this.mChildFragmentManager.dispatchCreate();
        return;
    L8:
        return;
    }

    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        int r0 = this.mContentLayoutId;
        if (r0 != 0) goto L5;
        return null;
    L5:
        return r1.inflate(r0, r2, false);
    }

    public View getView() {
        return this.mView;
    }

    public final View requireView() {
        View r0 = getView();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    @Deprecated
    public void onActivityCreated(Bundle r1) {
        this.mCalled = true;
    }

    public void onViewStateRestored(Bundle r1) {
        this.mCalled = true;
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onResume() {
        this.mCalled = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r1) {
        this.mCalled = true;
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    void initState() {
        initLifecycle();
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

    public void onDetach() {
        this.mCalled = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu r1, View r2, ContextMenu.ContextMenuInfo r3) {
        requireActivity().onCreateContextMenu(r1, r2, r3);
    }

    public void registerForContextMenu(View r1) {
        r1.setOnCreateContextMenuListener(this);
    }

    public void unregisterForContextMenu(View r1) {
        r1.setOnCreateContextMenuListener(null);
    }

    public void setEnterSharedElementCallback(SharedElementCallback r1) {
        ensureAnimationInfo().mEnterTransitionCallback = r1;
    }

    public void setExitSharedElementCallback(SharedElementCallback r1) {
        ensureAnimationInfo().mExitTransitionCallback = r1;
    }

    public void setEnterTransition(Object r1) {
        ensureAnimationInfo().mEnterTransition = r1;
    }

    public Object getEnterTransition() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mEnterTransition;
    }

    public void setReturnTransition(Object r1) {
        ensureAnimationInfo().mReturnTransition = r1;
    }

    public Object getReturnTransition() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        if (r0.mReturnTransition != USE_DEFAULT_TRANSITION) goto L10;
        return getEnterTransition();
    L10:
        return this.mAnimationInfo.mReturnTransition;
    }

    public void setExitTransition(Object r1) {
        ensureAnimationInfo().mExitTransition = r1;
    }

    public Object getExitTransition() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mExitTransition;
    }

    public void setReenterTransition(Object r1) {
        ensureAnimationInfo().mReenterTransition = r1;
    }

    public Object getReenterTransition() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        if (r0.mReenterTransition != USE_DEFAULT_TRANSITION) goto L10;
        return getExitTransition();
    L10:
        return this.mAnimationInfo.mReenterTransition;
    }

    public void setSharedElementEnterTransition(Object r1) {
        ensureAnimationInfo().mSharedElementEnterTransition = r1;
    }

    public Object getSharedElementEnterTransition() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mSharedElementEnterTransition;
    }

    public void setSharedElementReturnTransition(Object r1) {
        ensureAnimationInfo().mSharedElementReturnTransition = r1;
    }

    public Object getSharedElementReturnTransition() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        if (r0.mSharedElementReturnTransition != USE_DEFAULT_TRANSITION) goto L10;
        return getSharedElementEnterTransition();
    L10:
        return this.mAnimationInfo.mSharedElementReturnTransition;
    }

    public void setAllowEnterTransitionOverlap(boolean r1) {
        AnimationInfo r0 = ensureAnimationInfo();
        r0.mAllowEnterTransitionOverlap = Boolean.valueOf(r1);
    }

    public boolean getAllowEnterTransitionOverlap() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.mAllowEnterTransitionOverlap == null) goto L8;
        return this.mAnimationInfo.mAllowEnterTransitionOverlap.booleanValue();
    }

    public void setAllowReturnTransitionOverlap(boolean r1) {
        AnimationInfo r0 = ensureAnimationInfo();
        r0.mAllowReturnTransitionOverlap = Boolean.valueOf(r1);
    }

    public boolean getAllowReturnTransitionOverlap() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.mAllowReturnTransitionOverlap == null) goto L8;
        return this.mAnimationInfo.mAllowReturnTransitionOverlap.booleanValue();
    }

    public void postponeEnterTransition() {
        ensureAnimationInfo().mEnterTransitionPostponed = true;
    }

    public final void postponeEnterTransition(long r3, TimeUnit r5) {
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
        this.mHost.getHandler().postAtFrontOfQueue(new AnonymousClass2(this));
        return;
    L13:
        callStartTransitionListener(true);
    }

    void callStartTransitionListener(boolean r4) {
        AnimationInfo r0 = this.mAnimationInfo;
        OnStartEnterTransitionListener r1 = null;
        if (r0 == null) goto L6;
        r0.mEnterTransitionPostponed = false;
        OnStartEnterTransitionListener r2 = this.mAnimationInfo.mStartEnterTransitionListener;
        this.mAnimationInfo.mStartEnterTransitionListener = null;
        r1 = r2;
    L6:
        if (r1 == null) goto L9;
        r1.onStartEnterTransition();
        return;
    L9:
        if (FragmentManager.USE_STATE_MANAGER == true) goto L11;
        return;
    L11:
        if (this.mView == null) goto L23;
        ViewGroup r3 = this.mContainer;
        if (r3 == null) goto L24;
        FragmentManager r5 = this.mFragmentManager;
        if (r5 == null) goto L25;
        final SpecialEffectsController r6 = SpecialEffectsController.getOrCreateController(r3, r5);
        r6.markPostponedState();
        if (r4 == false) goto L19;
        this.mHost.getHandler().post(new AnonymousClass3(this, r6));
        return;
    L19:
        r6.executePendingOperations();
        return;
    L25:
        return;
    L24:
        return;
    }

    public void dump(String r3, FileDescriptor r4, PrintWriter r5, String[] r6) {
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
        Fragment r0 = getTargetFragment();
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

    Fragment findFragmentByWho(String r2) {
        if (r2.equals(this.mWho) == false) goto L6;
        return this;
    L6:
        return this.mChildFragmentManager.findFragmentByWho(r2);
    }

    FragmentContainer createFragmentContainer() {
        return new AnonymousClass4(this);
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

    void performCreate(Bundle r4) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.addObserver(new AnonymousClass5(this));
        this.mSavedStateRegistryController.performRestore(r4);
        onCreate(r4);
        this.mIsCreated = true;
        if (this.mCalled == false) goto L7;
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        return;
    L7:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
    }

    void performCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
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

    void performViewCreated() {
        onViewCreated(this.mView, this.mSavedFragmentState);
        this.mChildFragmentManager.dispatchViewCreated();
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

    private void restoreViewState() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L6;
        Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
    L6:
        if (this.mView == null) goto L8;
        restoreViewState(this.mSavedFragmentState);
    L8:
        this.mSavedFragmentState = null;
    }

    void performStart() {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mChildFragmentManager.execPendingActions(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (this.mCalled == false) goto L10;
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
        if (this.mView == null) goto L7;
        this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_START);
    L7:
        this.mChildFragmentManager.dispatchStart();
        return;
    L10:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
    }

    void performResume() {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mChildFragmentManager.execPendingActions(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (this.mCalled == false) goto L10;
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        if (this.mView == null) goto L7;
        this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    L7:
        this.mChildFragmentManager.dispatchResume();
        return;
    L10:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
    }

    void noteStateNotSaved() {
        this.mChildFragmentManager.noteStateNotSaved();
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

    void performMultiWindowModeChanged(boolean r1) {
        onMultiWindowModeChanged(r1);
        this.mChildFragmentManager.dispatchMultiWindowModeChanged(r1);
    }

    void performPictureInPictureModeChanged(boolean r1) {
        onPictureInPictureModeChanged(r1);
        this.mChildFragmentManager.dispatchPictureInPictureModeChanged(r1);
    }

    void performConfigurationChanged(Configuration r1) {
        onConfigurationChanged(r1);
        this.mChildFragmentManager.dispatchConfigurationChanged(r1);
    }

    void performLowMemory() {
        onLowMemory();
        this.mChildFragmentManager.dispatchLowMemory();
    }

    boolean performCreateOptionsMenu(Menu r3, MenuInflater r4) {
        boolean r1 = false;
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (this.mHasMenu == false) goto L10;
        if (this.mMenuVisible == false) goto L10;
        onCreateOptionsMenu(r3, r4);
        r1 = true;
    L10:
        return r1 | this.mChildFragmentManager.dispatchCreateOptionsMenu(r3, r4);
    }

    boolean performPrepareOptionsMenu(Menu r3) {
        boolean r1 = false;
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (this.mHasMenu == false) goto L10;
        if (this.mMenuVisible == false) goto L10;
        onPrepareOptionsMenu(r3);
        r1 = true;
    L10:
        return r1 | this.mChildFragmentManager.dispatchPrepareOptionsMenu(r3);
    }

    boolean performOptionsItemSelected(MenuItem r2) {
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

    boolean performContextItemSelected(MenuItem r2) {
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (onContextItemSelected(r2) == false) goto L9;
        return true;
    L9:
        return this.mChildFragmentManager.dispatchContextItemSelected(r2);
    }

    void performOptionsMenuClosed(Menu r2) {
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

    void performSaveInstanceState(Bundle r2) {
        onSaveInstanceState(r2);
        this.mSavedStateRegistryController.performSave(r2);
        Parcelable r1 = this.mChildFragmentManager.saveAllState();
        if (r1 == null) goto L6;
        r2.putParcelable("android:support:fragments", r1);
        return;
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

    void setOnStartEnterTransitionListener(OnStartEnterTransitionListener r3) {
        ensureAnimationInfo();
        if (r3 != this.mAnimationInfo.mStartEnterTransitionListener) goto L5;
        return;
    L5:
        if (r3 == null) goto L12;
        if (this.mAnimationInfo.mStartEnterTransitionListener == null) goto L12;
        throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
    L12:
        if (this.mAnimationInfo.mEnterTransitionPostponed == false) goto L14;
        this.mAnimationInfo.mStartEnterTransitionListener = r3;
    L14:
        if (r3 == null) goto L17;
        r3.startListening();
        return;
    }

    private AnimationInfo ensureAnimationInfo() {
        if (this.mAnimationInfo != null) goto L6;
        this.mAnimationInfo = new AnimationInfo();
    L6:
        return this.mAnimationInfo;
    }

    void setAnimations(int r2, int r3, int r4, int r5) {
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

    int getEnterAnim() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.mEnterAnim;
    }

    int getExitAnim() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.mExitAnim;
    }

    int getPopEnterAnim() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.mPopEnterAnim;
    }

    int getPopExitAnim() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.mPopExitAnim;
    }

    boolean getPopDirection() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.mIsPop;
    }

    void setPopDirection(boolean r2) {
        if (this.mAnimationInfo != null) goto L5;
        return;
    L5:
        ensureAnimationInfo().mIsPop = r2;
    }

    int getNextTransition() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.mNextTransition;
    }

    void setNextTransition(int r2) {
        if (this.mAnimationInfo != null) goto L6;
        if (r2 != 0) goto L6;
        return;
    L6:
        ensureAnimationInfo();
        this.mAnimationInfo.mNextTransition = r2;
    }

    ArrayList<String> getSharedElementSourceNames() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 == null) goto L10;
        if (r0.mSharedElementSourceNames == null) goto L10;
        return this.mAnimationInfo.mSharedElementSourceNames;
    L10:
        return new ArrayList();
    }

    ArrayList<String> getSharedElementTargetNames() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 == null) goto L10;
        if (r0.mSharedElementTargetNames == null) goto L10;
        return this.mAnimationInfo.mSharedElementTargetNames;
    L10:
        return new ArrayList();
    }

    void setSharedElementNames(ArrayList<String> r2, ArrayList<String> r3) {
        ensureAnimationInfo();
        this.mAnimationInfo.mSharedElementSourceNames = r2;
        this.mAnimationInfo.mSharedElementTargetNames = r3;
    }

    SharedElementCallback getEnterTransitionCallback() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mEnterTransitionCallback;
    }

    SharedElementCallback getExitTransitionCallback() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mExitTransitionCallback;
    }

    View getAnimatingAway() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mAnimatingAway;
    }

    void setAnimatingAway(View r1) {
        ensureAnimationInfo().mAnimatingAway = r1;
    }

    void setAnimator(Animator r1) {
        ensureAnimationInfo().mAnimator = r1;
    }

    Animator getAnimator() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mAnimator;
    }

    void setPostOnViewCreatedAlpha(float r1) {
        ensureAnimationInfo().mPostOnViewCreatedAlpha = r1;
    }

    float getPostOnViewCreatedAlpha() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return 1.0f;
    L7:
        return r0.mPostOnViewCreatedAlpha;
    }

    void setFocusedView(View r1) {
        ensureAnimationInfo().mFocusedView = r1;
    }

    View getFocusedView() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mFocusedView;
    }

    boolean isPostponed() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.mEnterTransitionPostponed;
    }

    boolean isHideReplaced() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.mIsHideReplaced;
    }

    void setHideReplaced(boolean r1) {
        ensureAnimationInfo().mIsHideReplaced = r1;
    }

    @Override // androidx.activity.result.ActivityResultCaller
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> r2, ActivityResultCallback<O> r3) {
        return prepareCallInternal(r2, new AnonymousClass6(this), r3);
    }

    @Override // androidx.activity.result.ActivityResultCaller
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> r2, final ActivityResultRegistry r3, ActivityResultCallback<O> r4) {
        return prepareCallInternal(r2, new AnonymousClass7(this, r3), r4);
    }

    private <I, O> ActivityResultLauncher<I> prepareCallInternal(final ActivityResultContract<I, O> r9, final Function<Void, ActivityResultRegistry> r10, final ActivityResultCallback<O> r11) {
        if (this.mState > 1) goto L7;
        final AtomicReference r0 = new AtomicReference();
        registerOnPreAttachListener(new AnonymousClass8(this, r10, r0, r9, r11));
        return new AnonymousClass9(this, r0, r9);
    L7:
        throw new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
    }

    private void registerOnPreAttachListener(OnPreAttachedListener r2) {
        if (this.mState < 0) goto L5;
        r2.onPreAttached();
        return;
    L5:
        this.mOnPreAttachedListeners.add(r2);
    }

    String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }
}
