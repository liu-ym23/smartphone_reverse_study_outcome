package androidx.fragment.app;

import a.a;
import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
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
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.core.app.SharedElementCallback;
import androidx.core.util.DebugUtils;
import androidx.core.view.LayoutInflaterCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, LifecycleOwner, ViewModelStoreOwner, SavedStateRegistryOwner {
    static final int ACTIVITY_CREATED = 2;
    static final int CREATED = 1;
    static final int INITIALIZING = 0;
    static final int RESUMED = 4;
    static final int STARTED = 3;
    static final Object USE_DEFAULT_TRANSITION = null;
    boolean mAdded;
    AnimationInfo mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    private boolean mCalled;

    @NonNull
    FragmentManagerImpl mChildFragmentManager;
    ViewGroup mContainer;
    int mContainerId;

    @LayoutRes
    private int mContentLayoutId;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    FragmentManagerImpl mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    FragmentHostCallback mHost;
    boolean mInLayout;
    View mInnerView;
    boolean mIsCreated;
    boolean mIsNewlyAdded;
    private Boolean mIsPrimaryNavigationFragment;
    LayoutInflater mLayoutInflater;
    LifecycleRegistry mLifecycleRegistry;
    Lifecycle.State mMaxState;
    boolean mMenuVisible;
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

    @Nullable
    Boolean mSavedUserVisibleHint;
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

    public static class AnimationInfo {
        Boolean mAllowEnterTransitionOverlap;
        Boolean mAllowReturnTransitionOverlap;
        View mAnimatingAway;
        Animator mAnimator;
        Object mEnterTransition;
        SharedElementCallback mEnterTransitionCallback;
        boolean mEnterTransitionPostponed;
        Object mExitTransition;
        SharedElementCallback mExitTransitionCallback;
        boolean mIsHideReplaced;
        int mNextAnim;
        int mNextTransition;
        int mNextTransitionStyle;
        Object mReenterTransition;
        Object mReturnTransition;
        Object mSharedElementEnterTransition;
        Object mSharedElementReturnTransition;
        OnStartEnterTransitionListener mStartEnterTransitionListener;
        int mStateAfterAnimating;

        public AnimationInfo() {
            this.mEnterTransition = null;
            Object r1 = Fragment.USE_DEFAULT_TRANSITION;
            this.mReturnTransition = r1;
            this.mExitTransition = null;
            this.mReenterTransition = r1;
            this.mSharedElementEnterTransition = null;
            this.mSharedElementReturnTransition = r1;
            this.mEnterTransitionCallback = null;
            this.mExitTransitionCallback = null;
        }
    }

    public static class InstantiationException extends RuntimeException {
        public InstantiationException(@NonNull String r1, @Nullable Exception r2) {
            super(r1, r2);
        }
    }

    public interface OnStartEnterTransitionListener {
        void onStartEnterTransition();

        void startListening();
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {

        @NonNull
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        final Bundle mState;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Bundle r1) {
            this.mState = r1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r1, int r2) {
            r1.writeBundle(this.mState);
        }

        public SavedState(@NonNull Parcel r1, @Nullable ClassLoader r2) {
            Bundle r3 = r1.readBundle();
            this.mState = r3;
            if (r2 == null) goto L7;
            if (r3 == null) goto L8;
            r3.setClassLoader(r2);
            return;
        L8:
            return;
        }
    }

    static {
        USE_DEFAULT_TRANSITION = new Object();
    }

    public Fragment() {
        this.mState = 0;
        this.mWho = UUID.randomUUID().toString();
        this.mTargetWho = null;
        this.mIsPrimaryNavigationFragment = null;
        this.mChildFragmentManager = new FragmentManagerImpl();
        this.mMenuVisible = true;
        this.mUserVisibleHint = true;
        this.mPostponedDurationRunnable = new AnonymousClass1(this);
        this.mMaxState = Lifecycle.State.RESUMED;
        this.mViewLifecycleOwnerLiveData = new MutableLiveData();
        initLifecycle();
    }

    private AnimationInfo ensureAnimationInfo() {
        if (this.mAnimationInfo != null) goto L6;
        this.mAnimationInfo = new AnimationInfo();
    L6:
        return this.mAnimationInfo;
    }

    private void initLifecycle() {
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        this.mSavedStateRegistryController = SavedStateRegistryController.create(this);
        this.mLifecycleRegistry.addObserver(new AnonymousClass2(this));
    }

    @NonNull
    @Deprecated
    public static Fragment instantiate(@NonNull Context r1, @NonNull String r2) {
        return instantiate(r1, r2, null);
    }

    public void callStartTransitionListener() {
        AnimationInfo r2 = this.mAnimationInfo;
        OnStartEnterTransitionListener r0 = null;
        if (r2 == null) goto L6;
        r2.mEnterTransitionPostponed = false;
        OnStartEnterTransitionListener r1 = r2.mStartEnterTransitionListener;
        r2.mStartEnterTransitionListener = null;
        r0 = r1;
    L6:
        if (r0 == null) goto L9;
        r0.onStartEnterTransition();
        return;
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
        if (this.mSavedViewState == null) goto L20;
        r5.print(r3);
        r5.print("mSavedViewState=");
        r5.println(this.mSavedViewState);
    L20:
        Fragment r0 = getTargetFragment();
        if (r0 == null) goto L24;
        r5.print(r3);
        r5.print("mTarget=");
        r5.print(r0);
        r5.print(" mTargetRequestCode=");
        r5.println(this.mTargetRequestCode);
    L24:
        if (getNextAnim() == 0) goto L27;
        r5.print(r3);
        r5.print("mNextAnim=");
        r5.println(getNextAnim());
    L27:
        if (this.mContainer == null) goto L30;
        r5.print(r3);
        r5.print("mContainer=");
        r5.println(this.mContainer);
    L30:
        if (this.mView == null) goto L33;
        r5.print(r3);
        r5.print("mView=");
        r5.println(this.mView);
    L33:
        if (this.mInnerView == null) goto L36;
        r5.print(r3);
        r5.print("mInnerView=");
        r5.println(this.mView);
    L36:
        if (getAnimatingAway() == null) goto L39;
        r5.print(r3);
        r5.print("mAnimatingAway=");
        r5.println(getAnimatingAway());
        r5.print(r3);
        r5.print("mStateAfterAnimating=");
        r5.println(getStateAfterAnimating());
    L39:
        if (getContext() == null) goto L41;
        LoaderManager.getInstance(this).dump(r3, r4, r5, r6);
    L41:
        r5.print(r3);
        r5.println("Child " + this.mChildFragmentManager + ":");
        this.mChildFragmentManager.dump(a.j(r3, "  "), r4, r5, r6);
    }

    public final boolean equals(@Nullable Object r1) {
        return super.equals(r1);
    }

    @Nullable
    public Fragment findFragmentByWho(@NonNull String r2) {
        if (r2.equals(this.mWho) == false) goto L6;
        return this;
    L6:
        return this.mChildFragmentManager.findFragmentByWho(r2);
    }

    @Nullable
    public final FragmentActivity getActivity() {
        FragmentHostCallback r0 = this.mHost;
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

    public View getAnimatingAway() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mAnimatingAway;
    }

    public Animator getAnimator() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mAnimator;
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
        throw new IllegalStateException(a.i("Fragment ", this, " has not been attached yet."));
    }

    @Nullable
    public Context getContext() {
        FragmentHostCallback r0 = this.mHost;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getContext();
    }

    @Nullable
    public Object getEnterTransition() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mEnterTransition;
    }

    public SharedElementCallback getEnterTransitionCallback() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mEnterTransitionCallback;
    }

    @Nullable
    public Object getExitTransition() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mExitTransition;
    }

    public SharedElementCallback getExitTransitionCallback() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mExitTransitionCallback;
    }

    @Nullable
    public final FragmentManager getFragmentManager() {
        return this.mFragmentManager;
    }

    @Nullable
    public final Object getHost() {
        FragmentHostCallback r0 = this.mHost;
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

    public int getNextAnim() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.mNextAnim;
    }

    public int getNextTransition() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.mNextTransition;
    }

    public int getNextTransitionStyle() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.mNextTransitionStyle;
    }

    @Nullable
    public final Fragment getParentFragment() {
        return this.mParentFragment;
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

    public final boolean getRetainInstance() {
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

    public int getStateAfterAnimating() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.mStateAfterAnimating;
    }

    @NonNull
    public final String getString(@StringRes int r1) {
        return getResources().getString(r1);
    }

    @Nullable
    public final String getTag() {
        return this.mTag;
    }

    @Nullable
    public final Fragment getTargetFragment() {
        Fragment r0 = this.mTarget;
        if (r0 == null) goto L5;
        return r0;
    L5:
        FragmentManagerImpl r1 = this.mFragmentManager;
        if (r1 == null) goto L11;
        String r2 = this.mTargetWho;
        if (r2 != null) goto L10;
        return null;
    L10:
        return r1.mActive.get(r2);
    L11:
        return null;
    }

    public final int getTargetRequestCode() {
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
        FragmentManagerImpl r0 = this.mFragmentManager;
        if (r0 == null) goto L7;
        return r0.getViewModelStore(this);
    L7:
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void initState() {
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
        return this.mHidden;
    }

    public boolean isHideReplaced() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.mIsHideReplaced;
    }

    public final boolean isInBackStack() {
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
        return this.mMenuVisible;
    }

    public boolean isPostponed() {
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
        if (this.mState < 4) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isStateSaved() {
        FragmentManagerImpl r0 = this.mFragmentManager;
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

    public void noteStateNotSaved() {
        this.mChildFragmentManager.noteStateNotSaved();
    }

    @CallSuper
    public void onActivityCreated(@Nullable Bundle r1) {
        this.mCalled = true;
    }

    public void onActivityResult(int r1, int r2, @Nullable Intent r3) {
    }

    @CallSuper
    public void onAttach(@NonNull Context r2) {
        this.mCalled = true;
        FragmentHostCallback r3 = this.mHost;
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

    public void onAttachFragment(@NonNull Fragment r1) {
    }

    @Override // android.content.ComponentCallbacks
    @CallSuper
    public void onConfigurationChanged(@NonNull Configuration r1) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(@NonNull MenuItem r1) {
        return false;
    }

    @CallSuper
    public void onCreate(@Nullable Bundle r2) {
        this.mCalled = true;
        restoreChildFragmentState(r2);
        if (this.mChildFragmentManager.isStateAtLeast(1) == true) goto L6;
        this.mChildFragmentManager.dispatchCreate();
        return;
    }

    @Nullable
    public Animation onCreateAnimation(int r1, boolean r2, int r3) {
        return null;
    }

    @Nullable
    public Animator onCreateAnimator(int r1, boolean r2, int r3) {
        return null;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(@NonNull ContextMenu r1, @NonNull View r2, @Nullable ContextMenu.ContextMenuInfo r3) {
        requireActivity().onCreateContextMenu(r1, r2, r3);
    }

    public void onCreateOptionsMenu(@NonNull Menu r1, @NonNull MenuInflater r2) {
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater r1, @Nullable ViewGroup r2, @Nullable Bundle r3) {
        int r0 = this.mContentLayoutId;
        if (r0 != 0) goto L5;
        return null;
    L5:
        return r1.inflate(r0, r2, false);
    }

    @CallSuper
    public void onDestroy() {
        this.mCalled = true;
    }

    public void onDestroyOptionsMenu() {
    }

    @CallSuper
    public void onDestroyView() {
        this.mCalled = true;
    }

    @CallSuper
    public void onDetach() {
        this.mCalled = true;
    }

    @NonNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle r1) {
        return getLayoutInflater(r1);
    }

    public void onHiddenChanged(boolean r1) {
    }

    @CallSuper
    public void onInflate(@NonNull Context r2, @NonNull AttributeSet r3, @Nullable Bundle r4) {
        this.mCalled = true;
        FragmentHostCallback r5 = this.mHost;
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
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean r1) {
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem r1) {
        return false;
    }

    public void onOptionsMenuClosed(@NonNull Menu r1) {
    }

    @CallSuper
    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean r1) {
    }

    public void onPrepareOptionsMenu(@NonNull Menu r1) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean r1) {
    }

    public void onRequestPermissionsResult(int r1, @NonNull String[] r2, @NonNull int[] r3) {
    }

    @CallSuper
    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(@NonNull Bundle r1) {
    }

    @CallSuper
    public void onStart() {
        this.mCalled = true;
    }

    @CallSuper
    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(@NonNull View r1, @Nullable Bundle r2) {
    }

    @CallSuper
    public void onViewStateRestored(@Nullable Bundle r1) {
        this.mCalled = true;
    }

    public void performActivityCreated(Bundle r3) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mState = 2;
        this.mCalled = false;
        onActivityCreated(r3);
        if (this.mCalled == false) goto L7;
        this.mChildFragmentManager.dispatchActivityCreated();
        return;
    L7:
        throw new SuperNotCalledException(a.i("Fragment ", this, " did not call through to super.onActivityCreated()"));
    }

    public void performAttach() {
        this.mChildFragmentManager.attachController(this.mHost, new AnonymousClass4(this), this);
        this.mCalled = false;
        onAttach(this.mHost.getContext());
        if (this.mCalled == false) goto L6;
        return;
    L6:
        throw new SuperNotCalledException(a.i("Fragment ", this, " did not call through to super.onAttach()"));
    }

    public void performConfigurationChanged(@NonNull Configuration r1) {
        onConfigurationChanged(r1);
        this.mChildFragmentManager.dispatchConfigurationChanged(r1);
    }

    public boolean performContextItemSelected(@NonNull MenuItem r3) {
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (onContextItemSelected(r3) == false) goto L8;
        return true;
    L8:
        if (this.mChildFragmentManager.dispatchContextItemSelected(r3) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public void performCreate(Bundle r3) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mState = 1;
        this.mCalled = false;
        this.mSavedStateRegistryController.performRestore(r3);
        onCreate(r3);
        this.mIsCreated = true;
        if (this.mCalled == false) goto L7;
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        return;
    L7:
        throw new SuperNotCalledException(a.i("Fragment ", this, " did not call through to super.onCreate()"));
    }

    public boolean performCreateOptionsMenu(@NonNull Menu r3, @NonNull MenuInflater r4) {
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

    public void performCreateView(@NonNull LayoutInflater r2, @Nullable ViewGroup r3, @Nullable Bundle r4) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new FragmentViewLifecycleOwner();
        View r5 = onCreateView(r2, r3, r4);
        this.mView = r5;
        if (r5 == null) goto L6;
        this.mViewLifecycleOwner.initialize();
        this.mViewLifecycleOwnerLiveData.setValue(this.mViewLifecycleOwner);
        return;
    L6:
        if (this.mViewLifecycleOwner.isInitialized() == true) goto L10;
        this.mViewLifecycleOwner = null;
        return;
    L10:
        throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
    }

    public void performDestroy() {
        this.mChildFragmentManager.dispatchDestroy();
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (this.mCalled == false) goto L6;
        return;
    L6:
        throw new SuperNotCalledException(a.i("Fragment ", this, " did not call through to super.onDestroy()"));
    }

    public void performDestroyView() {
        this.mChildFragmentManager.dispatchDestroyView();
        if (this.mView == null) goto L5;
        this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    L5:
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (this.mCalled == false) goto L10;
        LoaderManager.getInstance(this).markForRedelivery();
        this.mPerformedCreateView = false;
        return;
    L10:
        throw new SuperNotCalledException(a.i("Fragment ", this, " did not call through to super.onDestroyView()"));
    }

    public void performDetach() {
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
        throw new SuperNotCalledException(a.i("Fragment ", this, " did not call through to super.onDetach()"));
    }

    @NonNull
    public LayoutInflater performGetLayoutInflater(@Nullable Bundle r1) {
        LayoutInflater r2 = onGetLayoutInflater(r1);
        this.mLayoutInflater = r2;
        return r2;
    }

    public void performLowMemory() {
        onLowMemory();
        this.mChildFragmentManager.dispatchLowMemory();
    }

    public void performMultiWindowModeChanged(boolean r1) {
        onMultiWindowModeChanged(r1);
        this.mChildFragmentManager.dispatchMultiWindowModeChanged(r1);
    }

    public boolean performOptionsItemSelected(@NonNull MenuItem r3) {
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (this.mHasMenu == false) goto L12;
        if (this.mMenuVisible == false) goto L12;
        if (onOptionsItemSelected(r3) == false) goto L12;
        return true;
    L12:
        if (this.mChildFragmentManager.dispatchOptionsItemSelected(r3) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public void performOptionsMenuClosed(@NonNull Menu r2) {
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

    public void performPause() {
        this.mChildFragmentManager.dispatchPause();
        if (this.mView == null) goto L5;
        this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    L5:
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        this.mState = 3;
        this.mCalled = false;
        onPause();
        if (this.mCalled == false) goto L9;
        return;
    L9:
        throw new SuperNotCalledException(a.i("Fragment ", this, " did not call through to super.onPause()"));
    }

    public void performPictureInPictureModeChanged(boolean r1) {
        onPictureInPictureModeChanged(r1);
        this.mChildFragmentManager.dispatchPictureInPictureModeChanged(r1);
    }

    public boolean performPrepareOptionsMenu(@NonNull Menu r3) {
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

    public void performPrimaryNavigationFragmentChanged() {
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

    public void performResume() {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mChildFragmentManager.execPendingActions();
        this.mState = 4;
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
        this.mChildFragmentManager.execPendingActions();
        return;
    L10:
        throw new SuperNotCalledException(a.i("Fragment ", this, " did not call through to super.onResume()"));
    }

    public void performSaveInstanceState(Bundle r2) {
        onSaveInstanceState(r2);
        this.mSavedStateRegistryController.performSave(r2);
        Parcelable r1 = this.mChildFragmentManager.saveAllState();
        if (r1 == null) goto L6;
        r2.putParcelable("android:support:fragments", r1);
        return;
    }

    public void performStart() {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mChildFragmentManager.execPendingActions();
        this.mState = 3;
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
        throw new SuperNotCalledException(a.i("Fragment ", this, " did not call through to super.onStart()"));
    }

    public void performStop() {
        this.mChildFragmentManager.dispatchStop();
        if (this.mView == null) goto L5;
        this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    L5:
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        this.mState = 2;
        this.mCalled = false;
        onStop();
        if (this.mCalled == false) goto L9;
        return;
    L9:
        throw new SuperNotCalledException(a.i("Fragment ", this, " did not call through to super.onStop()"));
    }

    public void postponeEnterTransition() {
        ensureAnimationInfo().mEnterTransitionPostponed = true;
    }

    public void registerForContextMenu(@NonNull View r1) {
        r1.setOnCreateContextMenuListener(this);
    }

    public final void requestPermissions(@NonNull String[] r2, int r3) {
        FragmentHostCallback r0 = this.mHost;
        if (r0 == null) goto L7;
        r0.onRequestPermissionsFromFragment(this, r2, r3);
        return;
    L7:
        throw new IllegalStateException(a.i("Fragment ", this, " not attached to Activity"));
    }

    @NonNull
    public final FragmentActivity requireActivity() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException(a.i("Fragment ", this, " not attached to an activity."));
    }

    @NonNull
    public final Bundle requireArguments() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException(a.i("Fragment ", this, " does not have any arguments."));
    }

    @NonNull
    public final Context requireContext() {
        Context r0 = getContext();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException(a.i("Fragment ", this, " not attached to a context."));
    }

    @NonNull
    public final FragmentManager requireFragmentManager() {
        FragmentManager r0 = getFragmentManager();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException(a.i("Fragment ", this, " not associated with a fragment manager."));
    }

    @NonNull
    public final Object requireHost() {
        Object r0 = getHost();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException(a.i("Fragment ", this, " not attached to a host."));
    }

    @NonNull
    public final Fragment requireParentFragment() {
        Fragment r0 = getParentFragment();
        if (r0 == null) goto L5;
        return r0;
    L5:
        if (getContext() != null) goto L9;
        throw new IllegalStateException(a.i("Fragment ", this, " is not attached to any Fragment or host"));
    L9:
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    @NonNull
    public final View requireView() {
        View r0 = getView();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException(a.i("Fragment ", this, " did not return a View from onCreateView() or this was called before onCreateView()."));
    }

    public void restoreChildFragmentState(@Nullable Bundle r2) {
        if (r2 == null) goto L7;
        Parcelable r3 = r2.getParcelable("android:support:fragments");
        if (r3 == null) goto L8;
        this.mChildFragmentManager.restoreSaveState(r3);
        this.mChildFragmentManager.dispatchCreate();
        return;
    L8:
        return;
    }

    public final void restoreViewState(Bundle r3) {
        SparseArray<Parcelable> r0 = this.mSavedViewState;
        if (r0 == null) goto L5;
        this.mInnerView.restoreHierarchyState(r0);
        this.mSavedViewState = null;
    L5:
        this.mCalled = false;
        onViewStateRestored(r3);
        if (this.mCalled == false) goto L12;
        if (this.mView == null) goto L13;
        this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        return;
    L13:
        return;
    L12:
        throw new SuperNotCalledException(a.i("Fragment ", this, " did not call through to super.onViewStateRestored()"));
    }

    public void setAllowEnterTransitionOverlap(boolean r1) {
        AnimationInfo r0 = ensureAnimationInfo();
        r0.mAllowEnterTransitionOverlap = Boolean.valueOf(r1);
    }

    public void setAllowReturnTransitionOverlap(boolean r1) {
        AnimationInfo r0 = ensureAnimationInfo();
        r0.mAllowReturnTransitionOverlap = Boolean.valueOf(r1);
    }

    public void setAnimatingAway(View r1) {
        ensureAnimationInfo().mAnimatingAway = r1;
    }

    public void setAnimator(Animator r1) {
        ensureAnimationInfo().mAnimator = r1;
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

    public void setHideReplaced(boolean r1) {
        ensureAnimationInfo().mIsHideReplaced = r1;
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

    public void setNextAnim(int r2) {
        if (this.mAnimationInfo != null) goto L6;
        if (r2 != 0) goto L6;
        return;
    L6:
        ensureAnimationInfo().mNextAnim = r2;
    }

    public void setNextTransition(int r2, int r3) {
        if (this.mAnimationInfo != null) goto L7;
        if (r2 != 0) goto L7;
        if (r3 != 0) goto L7;
        return;
    L7:
        ensureAnimationInfo();
        AnimationInfo r1 = this.mAnimationInfo;
        r1.mNextTransition = r2;
        r1.mNextTransitionStyle = r3;
    }

    public void setOnStartEnterTransitionListener(OnStartEnterTransitionListener r3) {
        ensureAnimationInfo();
        AnimationInfo r0 = this.mAnimationInfo;
        OnStartEnterTransitionListener r1 = r0.mStartEnterTransitionListener;
        if (r3 != r1) goto L5;
        return;
    L5:
        if (r3 == null) goto L11;
        if (r1 == null) goto L11;
        throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
    L11:
        if (r0.mEnterTransitionPostponed == false) goto L13;
        r0.mStartEnterTransitionListener = r3;
    L13:
        if (r3 == null) goto L16;
        r3.startListening();
        return;
    }

    public void setReenterTransition(@Nullable Object r1) {
        ensureAnimationInfo().mReenterTransition = r1;
    }

    public void setRetainInstance(boolean r2) {
        this.mRetainInstance = r2;
        FragmentManagerImpl r0 = this.mFragmentManager;
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

    public void setSharedElementReturnTransition(@Nullable Object r1) {
        ensureAnimationInfo().mSharedElementReturnTransition = r1;
    }

    public void setStateAfterAnimating(int r1) {
        ensureAnimationInfo().mStateAfterAnimating = r1;
    }

    public void setTargetFragment(@Nullable Fragment r4, int r5) {
        FragmentManager r0 = getFragmentManager();
        if (r4 == null) goto L5;
        FragmentManager r2 = r4.getFragmentManager();
    L6:
        if (r0 == null) goto L12;
        if (r2 == null) goto L12;
        if (r0 == r2) goto L12;
        throw new IllegalArgumentException(a.i("Fragment ", r4, " must share the same FragmentManager to be set as a target fragment"));
    L12:
        Fragment r1 = r4;
    L13:
        if (r1 == null) goto L18;
        if (r1 == this) goto L17;
        r1 = r1.getTargetFragment();
        goto L13
    L17:
        throw new IllegalArgumentException("Setting " + r4 + " as the target of " + this + " would create a target cycle");
    L18:
        if (r4 != null) goto L21;
        this.mTargetWho = null;
        this.mTarget = null;
    L26:
        this.mTargetRequestCode = r5;
        return;
    L21:
        if (this.mFragmentManager != null) goto L23;
    L25:
        this.mTargetWho = null;
        this.mTarget = r4;
        goto L26
    L23:
        if (r4.mFragmentManager == null) goto L25;
        this.mTargetWho = r4.mWho;
        this.mTarget = null;
        goto L26
    L5:
        r2 = null;
        goto L6
    }

    @Deprecated
    public void setUserVisibleHint(boolean r3) {
        if (this.mUserVisibleHint == true) goto L14;
        if (r3 == false) goto L14;
        if (this.mState >= 3) goto L14;
        if (this.mFragmentManager == null) goto L14;
        if (isAdded() == false) goto L14;
        if (this.mIsCreated == false) goto L14;
        this.mFragmentManager.performPendingDeferredStart(this);
    L14:
        this.mUserVisibleHint = r3;
        if (this.mState >= 3) goto L18;
        if (r3 == true) goto L18;
        boolean r0 = true;
    L19:
        this.mDeferStart = r0;
        if (this.mSavedFragmentState == null) goto L23;
        this.mSavedUserVisibleHint = Boolean.valueOf(r3);
        return;
    L23:
        return;
    L18:
        r0 = false;
        goto L19
    }

    public boolean shouldShowRequestPermissionRationale(@NonNull String r1) {
        FragmentHostCallback r0 = this.mHost;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.onShouldShowRequestPermissionRationale(r1);
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent r2) {
        startActivity(r2, null);
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent r2, int r3) {
        startActivityForResult(r2, r3, null);
    }

    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender r10, int r11, @Nullable Intent r12, int r13, int r14, int r15, @Nullable Bundle r16) {
        FragmentHostCallback r0 = this.mHost;
        if (r0 == null) goto L7;
        r0.onStartIntentSenderFromFragment(this, r10, r11, r12, r13, r14, r15, r16);
        return;
    L7:
        throw new IllegalStateException(a.i("Fragment ", this, " not attached to Activity"));
    }

    public void startPostponedEnterTransition() {
        FragmentManagerImpl r0 = this.mFragmentManager;
        if (r0 != null) goto L5;
    L11:
        ensureAnimationInfo().mEnterTransitionPostponed = false;
        return;
    L5:
        if (r0.mHost == null) goto L11;
        if (Looper.myLooper() == this.mFragmentManager.mHost.getHandler().getLooper()) goto L10;
        this.mFragmentManager.mHost.getHandler().postAtFrontOfQueue(new AnonymousClass3(this));
        return;
    L10:
        callStartTransitionListener();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(128);
        DebugUtils.buildShortClassTag(this, r0);
        r0.append(" (");
        r0.append(this.mWho);
        r0.append(")");
        if (this.mFragmentId == 0) goto L6;
        r0.append(" id=0x");
        r0.append(Integer.toHexString(this.mFragmentId));
    L6:
        if (this.mTag == null) goto L8;
        r0.append(" ");
        r0.append(this.mTag);
    L8:
        r0.append('}');
        return r0.toString();
    }

    public void unregisterForContextMenu(@NonNull View r1) {
        r1.setOnCreateContextMenuListener(null);
    }

    @NonNull
    @Deprecated
    public static Fragment instantiate(@NonNull Context r3, @NonNull String r4, @Nullable Bundle r5) {
        Fragment r6 = FragmentFactory.loadFragmentClass(r3.getClassLoader(), r4).getConstructor(null).newInstance(null);     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L9 IllegalAccessException -> L11 java.lang.InstantiationException -> L13
        if (r5 == null) goto L15;
        r5.setClassLoader(r6.getClass().getClassLoader());     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L9 IllegalAccessException -> L11 java.lang.InstantiationException -> L13
        r6.setArguments(r5);     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L9 IllegalAccessException -> L11 java.lang.InstantiationException -> L13
    L15:
        return r6;
    L11:
        e = move-exception;
        throw new InstantiationException(a.k("Unable to instantiate fragment ", r4, ": make sure class name exists, is public, and has an empty constructor that is public"), e);
    L13:
        e = move-exception;
        throw new InstantiationException(a.k("Unable to instantiate fragment ", r4, ": make sure class name exists, is public, and has an empty constructor that is public"), e);
    L9:
        e = move-exception;
        throw new InstantiationException(a.k("Unable to instantiate fragment ", r4, ": could not find Fragment constructor"), e);
    L7:
        e = move-exception;
        throw new InstantiationException(a.k("Unable to instantiate fragment ", r4, ": calling Fragment constructor caused an exception"), e);
    }

    @NonNull
    public final String getString(@StringRes int r1, @Nullable Object... r2) {
        return getResources().getString(r1, r2);
    }

    public final void postponeEnterTransition(long r3, @NonNull TimeUnit r5) {
        ensureAnimationInfo().mEnterTransitionPostponed = true;
        FragmentManagerImpl r0 = this.mFragmentManager;
        if (r0 == null) goto L5;
        Handler r1 = r0.mHost.getHandler();
    L6:
        r1.removeCallbacks(this.mPostponedDurationRunnable);
        r1.postDelayed(this.mPostponedDurationRunnable, r5.toMillis(r3));
        return;
    L5:
        r1 = new Handler(Looper.getMainLooper());
        goto L6
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent r3, @Nullable Bundle r4) {
        FragmentHostCallback r0 = this.mHost;
        if (r0 == null) goto L7;
        r0.onStartActivityFromFragment(this, r3, -1, r4);
        return;
    L7:
        throw new IllegalStateException(a.i("Fragment ", this, " not attached to Activity"));
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent r2, int r3, @Nullable Bundle r4) {
        FragmentHostCallback r0 = this.mHost;
        if (r0 == null) goto L7;
        r0.onStartActivityFromFragment(this, r2, r3, r4);
        return;
    L7:
        throw new IllegalStateException(a.i("Fragment ", this, " not attached to Activity"));
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public LayoutInflater getLayoutInflater(@Nullable Bundle r1) {
        FragmentHostCallback r2 = this.mHost;
        if (r2 == null) goto L7;
        LayoutInflater r3 = r2.onGetLayoutInflater();
        LayoutInflaterCompat.setFactory2(r3, this.mChildFragmentManager.getLayoutInflaterFactory());
        return r3;
    L7:
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @CallSuper
    @Deprecated
    public void onAttach(@NonNull Activity r1) {
        this.mCalled = true;
    }

    @CallSuper
    @Deprecated
    public void onInflate(@NonNull Activity r1, @NonNull AttributeSet r2, @Nullable Bundle r3) {
        this.mCalled = true;
    }

    @ContentView
    public Fragment(@LayoutRes int r1) {
        this();
        this.mContentLayoutId = r1;
    }
}
