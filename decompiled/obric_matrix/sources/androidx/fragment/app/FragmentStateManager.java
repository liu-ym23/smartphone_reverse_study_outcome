package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.os.EnvironmentCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.R;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStoreOwner;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class FragmentStateManager {
    private static final String TAG = "FragmentManager";
    private static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    private static final String TARGET_STATE_TAG = "android:target_state";
    private static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
    private static final String VIEW_REGISTRY_STATE_TAG = "android:view_registry_state";
    private static final String VIEW_STATE_TAG = "android:view_state";
    private final FragmentLifecycleCallbacksDispatcher mDispatcher;

    @NonNull
    private final Fragment mFragment;
    private int mFragmentManagerState;
    private final FragmentStore mFragmentStore;
    private boolean mMovingToState;

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentStateManager$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$State = null;

        static {
            int[] r0 = new int[Lifecycle.State.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$State = r0;
            r0[Lifecycle.State.RESUMED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.STARTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.CREATED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.INITIALIZED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher r2, @NonNull FragmentStore r3, @NonNull Fragment r4) {
        this.mMovingToState = false;
        this.mFragmentManagerState = -1;
        this.mDispatcher = r2;
        this.mFragmentStore = r3;
        this.mFragment = r4;
    }

    FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher r3, @NonNull FragmentStore r4, @NonNull Fragment r5, @NonNull FragmentState r6) {
        this.mMovingToState = false;
        this.mFragmentManagerState = -1;
        this.mDispatcher = r3;
        this.mFragmentStore = r4;
        this.mFragment = r5;
        r5.mSavedViewState = null;
        r5.mSavedViewRegistryState = null;
        r5.mBackStackNesting = 0;
        r5.mInLayout = false;
        r5.mAdded = false;
        Fragment r7 = r5.mTarget;
        if (r7 == null) goto L5;
        String r8 = r7.mWho;
    L6:
        r5.mTargetWho = r8;
        r5.mTarget = null;
        Bundle r2 = r6.mSavedFragmentState;
        if (r2 != null) goto L10;
        r2 = new Bundle();
    L10:
        r5.mSavedFragmentState = r2;
        return;
    L5:
        r8 = null;
        goto L6
    }

    FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher r2, @NonNull FragmentStore r3, @NonNull ClassLoader r4, @NonNull FragmentFactory r5, @NonNull FragmentState r6) {
        this.mMovingToState = false;
        this.mFragmentManagerState = -1;
        this.mDispatcher = r2;
        this.mFragmentStore = r3;
        Fragment r7 = r6.instantiate(r5, r4);
        this.mFragment = r7;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L6;
        Log.v("FragmentManager", "Instantiated fragment " + r7);
        return;
    }

    private boolean isFragmentViewChild(@NonNull View r3) {
        if (r3 != this.mFragment.mView) goto L5;
        return true;
    L5:
        ViewParent r4 = r3.getParent();
    L6:
        if (r4 == null) goto L11;
        if (r4 == this.mFragment.mView) goto L9;
        r4 = r4.getParent();
        goto L6
    L9:
        return true;
    L11:
        return false;
    }

    private Bundle saveBasicState() {
        Bundle r0 = new Bundle();
        this.mFragment.performSaveInstanceState(r0);
        this.mDispatcher.dispatchOnFragmentSaveInstanceState(this.mFragment, r0, false);
        if (r0.isEmpty() == false) goto L6;
        r0 = null;
    L6:
        if (this.mFragment.mView == null) goto L9;
        saveViewState();
    L9:
        if (this.mFragment.mSavedViewState == null) goto L14;
        if (r0 != null) goto L12;
        r0 = new Bundle();
    L12:
        r0.putSparseParcelableArray(VIEW_STATE_TAG, this.mFragment.mSavedViewState);
    L14:
        if (this.mFragment.mSavedViewRegistryState == null) goto L19;
        if (r0 != null) goto L17;
        r0 = new Bundle();
    L17:
        r0.putBundle(VIEW_REGISTRY_STATE_TAG, this.mFragment.mSavedViewRegistryState);
    L19:
        if (this.mFragment.mUserVisibleHint == true) goto L23;
        if (r0 != null) goto L22;
        r0 = new Bundle();
    L22:
        r0.putBoolean(USER_VISIBLE_HINT_TAG, this.mFragment.mUserVisibleHint);
    L23:
        return r0;
    }

    void activityCreated() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.mFragment);
    L5:
        Fragment r0 = this.mFragment;
        r0.performActivityCreated(r0.mSavedFragmentState);
        FragmentLifecycleCallbacksDispatcher r1 = this.mDispatcher;
        Fragment r3 = this.mFragment;
        r1.dispatchOnFragmentActivityCreated(r3, r3.mSavedFragmentState, false);
    }

    void addViewToContainer() {
        int r0 = this.mFragmentStore.findFragmentIndexInContainer(this.mFragment);
        Fragment r2 = this.mFragment;
        r2.mContainer.addView(r2.mView, r0);
    }

    void attach() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d("FragmentManager", "moveto ATTACHED: " + this.mFragment);
    L5:
        Fragment r0 = this.mFragment;
        Fragment r1 = r0.mTarget;
        FragmentStateManager r5 = null;
        if (r1 == null) goto L12;
        FragmentStateManager r2 = this.mFragmentStore.getFragmentStateManager(r1.mWho);
        if (r2 == null) goto L11;
        Fragment r3 = this.mFragment;
        r3.mTargetWho = r3.mTarget.mWho;
        r3.mTarget = null;
        r5 = r2;
    L19:
        if (r5 == null) goto L21;
        r5.moveToExpectedState();
    L21:
        Fragment r4 = this.mFragment;
        r4.mHost = r4.mFragmentManager.getHost();
        Fragment r6 = this.mFragment;
        r6.mParentFragment = r6.mFragmentManager.getParent();
        this.mDispatcher.dispatchOnFragmentPreAttached(this.mFragment, false);
        this.mFragment.performAttach();
        this.mDispatcher.dispatchOnFragmentAttached(this.mFragment, false);
        return;
    L11:
        throw new IllegalStateException("Fragment " + this.mFragment + " declared target fragment " + this.mFragment.mTarget + " that does not belong to this FragmentManager!");
    L12:
        String r7 = r0.mTargetWho;
        if (r7 == null) goto L19;
        r5 = this.mFragmentStore.getFragmentStateManager(r7);
        if (r5 != null) goto L19;
        throw new IllegalStateException("Fragment " + this.mFragment + " declared target fragment " + this.mFragment.mTargetWho + " that does not belong to this FragmentManager!");
    }

    int computeExpectedState() {
        Fragment r0 = this.mFragment;
        if (r0.mFragmentManager == null) goto L5;
        int r1 = this.mFragmentManagerState;
        int r2 = AnonymousClass2.$SwitchMap$androidx$lifecycle$Lifecycle$State[r0.mMaxState.ordinal()];
        if (r2 == 1) goto L15;
        if (r2 == 2) goto L14;
        if (r2 == 3) goto L13;
        if (r2 == 4) goto L12;
        r1 = Math.min(r1, -1);
        goto L15
    L12:
        r1 = Math.min(r1, 0);
        goto L15
    L13:
        r1 = Math.min(r1, 1);
        goto L15
    L14:
        r1 = Math.min(r1, 5);
    L15:
        Fragment r3 = this.mFragment;
        if (r3.mFromLayout == false) goto L29;
        if (r3.mInLayout == false) goto L25;
        r1 = Math.max(this.mFragmentManagerState, 2);
        View r4 = this.mFragment.mView;
        if (r4 == null) goto L29;
        if (r4.getParent() != null) goto L29;
        r1 = Math.min(r1, 2);
        goto L29
    L25:
        if (this.mFragmentManagerState >= 4) goto L27;
        r1 = Math.min(r1, r3.mState);
        goto L29
    L27:
        r1 = Math.min(r1, 1);
    L29:
        if (this.mFragment.mAdded == true) goto L31;
        r1 = Math.min(r1, 1);
    L31:
        SpecialEffectsController.Operation.LifecycleImpact r5 = null;
        Fragment r8 = this.mFragment;
        ViewGroup r9 = r8.mContainer;
        if (r9 == null) goto L35;
        r5 = SpecialEffectsController.getOrCreateController(r9, r8.getParentFragmentManager()).getAwaitingCompletionLifecycleImpact(this);
    L35:
        if (r5 != SpecialEffectsController.Operation.LifecycleImpact.ADDING) goto L38;
        r1 = Math.min(r1, 6);
    L46:
        Fragment r6 = this.mFragment;
        if (r6.mDeferStart == false) goto L52;
        if (r6.mState >= 5) goto L52;
        r1 = Math.min(r1, 4);
    L52:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L54;
        Log.v("FragmentManager", "computeExpectedState() of " + r1 + " for " + this.mFragment);
    L54:
        return r1;
    L38:
        if (r5 != SpecialEffectsController.Operation.LifecycleImpact.REMOVING) goto L40;
        r1 = Math.max(r1, 3);
        goto L46
    L40:
        Fragment r7 = this.mFragment;
        if (r7.mRemoving == false) goto L46;
        if (r7.isInBackStack() == false) goto L45;
        r1 = Math.min(r1, 1);
        goto L46
    L45:
        r1 = Math.min(r1, -1);
        goto L46
    L5:
        return r0.mState;
    }

    void create() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d("FragmentManager", "moveto CREATED: " + this.mFragment);
    L5:
        Fragment r0 = this.mFragment;
        if (r0.mIsCreated == true) goto L8;
        this.mDispatcher.dispatchOnFragmentPreCreated(r0, r0.mSavedFragmentState, false);
        Fragment r1 = this.mFragment;
        r1.performCreate(r1.mSavedFragmentState);
        FragmentLifecycleCallbacksDispatcher r2 = this.mDispatcher;
        Fragment r4 = this.mFragment;
        r2.dispatchOnFragmentCreated(r4, r4.mSavedFragmentState, false);
        return;
    L8:
        r0.restoreChildFragmentState(r0.mSavedFragmentState);
        this.mFragment.mState = 1;
    }

    void createView() {
        if (this.mFragment.mFromLayout == false) goto L6;
        return;
    L6:
        if (FragmentManager.isLoggingEnabled(3) == false) goto L8;
        Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.mFragment);
    L8:
        Fragment r0 = this.mFragment;
        LayoutInflater r1 = r0.performGetLayoutInflater(r0.mSavedFragmentState);
        ViewGroup r2 = null;
        Fragment r3 = this.mFragment;
        ViewGroup r4 = r3.mContainer;
        if (r4 == null) goto L11;
        r2 = r4;
    L30:
        Fragment r5 = this.mFragment;
        r5.mContainer = r2;
        r5.performCreateView(r1, r2, r5.mSavedFragmentState);
        View r6 = this.mFragment.mView;
        if (r6 == null) goto L51;
        r6.setSaveFromParentEnabled(false);
        Fragment r7 = this.mFragment;
        r7.mView.setTag(R.id.fragment_container_view_tag, r7);
        if (r2 == null) goto L35;
        addViewToContainer();
    L35:
        Fragment r8 = this.mFragment;
        if (r8.mHidden == false) goto L39;
        r8.mView.setVisibility(8);
    L39:
        if (ViewCompat.isAttachedToWindow(this.mFragment.mView) == false) goto L41;
        ViewCompat.requestApplyInsets(this.mFragment.mView);
    L42:
        this.mFragment.performViewCreated();
        FragmentLifecycleCallbacksDispatcher r9 = this.mDispatcher;
        Fragment r10 = this.mFragment;
        r9.dispatchOnFragmentViewCreated(r10, r10.mView, r10.mSavedFragmentState, false);
        int r11 = this.mFragment.mView.getVisibility();
        this.mFragment.setPostOnViewCreatedAlpha(this.mFragment.mView.getAlpha());
        Fragment r12 = this.mFragment;
        if (r12.mContainer == null) goto L51;
        if (r11 != 0) goto L51;
        View r13 = r12.mView.findFocus();
        if (r13 == null) goto L50;
        this.mFragment.setFocusedView(r13);
        if (FragmentManager.isLoggingEnabled(2) == false) goto L50;
        Log.v("FragmentManager", "requestFocus: Saved focused view " + r13 + " for Fragment " + this.mFragment);
    L50:
        this.mFragment.mView.setAlpha(0.0f);
        goto L51
    L41:
        final View r14 = this.mFragment.mView;
        r14.addOnAttachStateChangeListener(new AnonymousClass1(this, r14));
    L51:
        this.mFragment.mState = 2;
        return;
    L11:
        int r15 = r3.mContainerId;
        if (r15 == 0) goto L30;
        if (r15 == (-1)) goto L29;
        r2 = (ViewGroup) r3.mFragmentManager.getContainer().onFindViewById(this.mFragment.mContainerId);
        if (r2 != null) goto L26;
        Fragment r16 = this.mFragment;
        if (r16.mRestored == true) goto L30;
        String r17 = r16.getResources().getResourceName(this.mFragment.mContainerId);     // Catch: Resources.NotFoundException -> L22
    L24:
        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.mFragment.mContainerId) + " (" + r17 + ") for fragment " + this.mFragment);
    L22:
        r17 = EnvironmentCompat.MEDIA_UNKNOWN;
        goto L24
    L26:
        if ((r2 instanceof FragmentContainerView) == true) goto L30;
        FragmentStrictMode.onWrongFragmentContainer(this.mFragment, r2);
        goto L30
    L29:
        throw new IllegalArgumentException("Cannot create fragment " + this.mFragment + " for a container view with no id");
    }

    void destroy() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d("FragmentManager", "movefrom CREATED: " + this.mFragment);
    L5:
        Fragment r0 = this.mFragment;
        boolean r2 = true;
        if (r0.mRemoving == true) goto L8;
    L10:
        boolean r1 = false;
    L12:
        if (r1 == false) goto L16;
        Fragment r4 = this.mFragment;
        if (r4.mBeingSaved == true) goto L16;
        this.mFragmentStore.setSavedState(r4.mWho, null);
    L16:
        if (r1 == false) goto L18;
    L21:
        boolean r5 = true;
    L22:
        if (r5 == false) goto L46;
        FragmentHostCallback<?> r6 = this.mFragment.mHost;
        if ((r6 instanceof ViewModelStoreOwner) == false) goto L27;
        r2 = this.mFragmentStore.getNonConfig().isCleared();
    L29:
        if (r1 == true) goto L31;
    L32:
        if (r2 == false) goto L34;
    L33:
        this.mFragmentStore.getNonConfig().clearNonConfigState(this.mFragment);
    L34:
        this.mFragment.performDestroy();
        this.mDispatcher.dispatchOnFragmentDestroyed(this.mFragment, false);
        Iterator<FragmentStateManager> r3 = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
    L36:
        if (r3.hasNext() == false) goto L42;
        FragmentStateManager r7 = r3.next();
        if (r7 == null) goto L36;
        Fragment r8 = r7.getFragment();
        if (this.mFragment.mWho.equals(r8.mTargetWho) == false) goto L36;
        r8.mTarget = this.mFragment;
        r8.mTargetWho = null;
        goto L36
    L42:
        Fragment r9 = this.mFragment;
        String r10 = r9.mTargetWho;
        if (r10 == null) goto L45;
        r9.mTarget = this.mFragmentStore.findActiveFragment(r10);
    L45:
        this.mFragmentStore.makeInactive(this);
        return;
    L31:
        if (this.mFragment.mBeingSaved == false) goto L33;
    L27:
        if ((r6.getContext() instanceof Activity) == false) goto L29;
        r2 = true ^ ((Activity) r6.getContext()).isChangingConfigurations();
        goto L29
    L46:
        String r11 = this.mFragment.mTargetWho;
        if (r11 == null) goto L53;
        Fragment r12 = this.mFragmentStore.findActiveFragment(r11);
        if (r12 == null) goto L53;
        if (r12.mRetainInstance == false) goto L53;
        this.mFragment.mTarget = r12;
    L53:
        this.mFragment.mState = 0;
        return;
    L18:
        if (this.mFragmentStore.getNonConfig().shouldDestroy(this.mFragment) == true) goto L21;
        r5 = false;
        goto L22
    L8:
        if (r0.isInBackStack() == true) goto L10;
        r1 = true;
        goto L12
    }

    void destroyFragmentView() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.mFragment);
    L5:
        Fragment r0 = this.mFragment;
        ViewGroup r1 = r0.mContainer;
        if (r1 == null) goto L10;
        View r2 = r0.mView;
        if (r2 == null) goto L10;
        r1.removeView(r2);
    L10:
        this.mFragment.performDestroyView();
        this.mDispatcher.dispatchOnFragmentViewDestroyed(this.mFragment, false);
        Fragment r3 = this.mFragment;
        r3.mContainer = null;
        r3.mView = null;
        r3.mViewLifecycleOwner = null;
        r3.mViewLifecycleOwnerLiveData.setValue(null);
        this.mFragment.mInLayout = false;
    }

    void detach() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d("FragmentManager", "movefrom ATTACHED: " + this.mFragment);
    L5:
        this.mFragment.performDetach();
        boolean r4 = false;
        this.mDispatcher.dispatchOnFragmentDetached(this.mFragment, false);
        Fragment r1 = this.mFragment;
        r1.mState = -1;
        r1.mHost = null;
        r1.mParentFragment = null;
        r1.mFragmentManager = null;
        if (r1.mRemoving == true) goto L8;
    L10:
        if (r4 == true) goto L14;
        if (this.mFragmentStore.getNonConfig().shouldDestroy(this.mFragment) == true) goto L14;
        return;
    L14:
        if (FragmentManager.isLoggingEnabled(3) == false) goto L16;
        Log.d("FragmentManager", "initState called for fragment: " + this.mFragment);
    L16:
        this.mFragment.initState();
        return;
    L8:
        if (r1.isInBackStack() == true) goto L10;
        r4 = true;
        goto L10
    }

    void ensureInflatedView() {
        Fragment r0 = this.mFragment;
        if (r0.mFromLayout == true) goto L5;
        return;
    L5:
        if (r0.mInLayout == true) goto L7;
        return;
    L7:
        if (r0.mPerformedCreateView == false) goto L9;
        return;
    L9:
        if (FragmentManager.isLoggingEnabled(3) == false) goto L11;
        Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.mFragment);
    L11:
        Fragment r1 = this.mFragment;
        r1.performCreateView(r1.performGetLayoutInflater(r1.mSavedFragmentState), null, this.mFragment.mSavedFragmentState);
        View r2 = this.mFragment.mView;
        if (r2 == null) goto L21;
        r2.setSaveFromParentEnabled(false);
        Fragment r3 = this.mFragment;
        r3.mView.setTag(R.id.fragment_container_view_tag, r3);
        Fragment r4 = this.mFragment;
        if (r4.mHidden == false) goto L16;
        r4.mView.setVisibility(8);
    L16:
        this.mFragment.performViewCreated();
        FragmentLifecycleCallbacksDispatcher r5 = this.mDispatcher;
        Fragment r6 = this.mFragment;
        r5.dispatchOnFragmentViewCreated(r6, r6.mView, r6.mSavedFragmentState, false);
        this.mFragment.mState = 2;
        return;
    }

    @NonNull
    Fragment getFragment() {
        return this.mFragment;
    }

    void moveToExpectedState() {
        if (this.mMovingToState == false) goto L97;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L118;
        Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + getFragment());
        return;
    L118:
        return;
    L97:
        this.mMovingToState = true;     // Catch: Throwable -> L94
        boolean r4 = false;
    L10:
        int r5 = computeExpectedState();     // Catch: Throwable -> L94
        Fragment r6 = this.mFragment;     // Catch: Throwable -> L94
        int r7 = r6.mState;     // Catch: Throwable -> L94
        if (r5 == r7) goto L62;
        if (r5 <= r7) goto L30;
        switch((r7 + 1)) {
            case 0: goto L28;
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L20;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            default: goto L61;
        };     // Catch: Throwable -> L94
    L16:
        resume();     // Catch: Throwable -> L94
        goto L61
    L17:
        r6.mState = 6;     // Catch: Throwable -> L94
        goto L61
    L18:
        start();     // Catch: Throwable -> L94
        goto L61
    L25:
        activityCreated();     // Catch: Throwable -> L94
        goto L61
    L26:
        ensureInflatedView();     // Catch: Throwable -> L94
        createView();     // Catch: Throwable -> L94
        goto L61
    L27:
        create();     // Catch: Throwable -> L94
        goto L61
    L28:
        attach();     // Catch: Throwable -> L94
    L61:
        r4 = true;
        goto L10
    L20:
        if (r6.mView == null) goto L24;
        ViewGroup r8 = r6.mContainer;     // Catch: Throwable -> L94
        if (r8 == null) goto L24;
        SpecialEffectsController.getOrCreateController(r8, r6.getParentFragmentManager()).enqueueAdd(SpecialEffectsController.Operation.State.from(this.mFragment.mView.getVisibility()), this);     // Catch: Throwable -> L94
    L24:
        this.mFragment.mState = 4;     // Catch: Throwable -> L94
        goto L61
    L30:
        switch((r7 - 1)) {
            case -1: goto L60;
            case 0: goto L55;
            case 1: goto L53;
            case 2: goto L52;
            case 3: goto L36;
            case 4: goto L34;
            case 5: goto L33;
            case 6: goto L32;
            default: goto L61;
        };     // Catch: Throwable -> L94
    L32:
        pause();     // Catch: Throwable -> L94
        goto L61
    L33:
        r6.mState = 5;     // Catch: Throwable -> L94
        goto L61
    L34:
        stop();     // Catch: Throwable -> L94
        goto L61
    L52:
        r6.mInLayout = false;     // Catch: Throwable -> L94
        r6.mState = 2;     // Catch: Throwable -> L94
        goto L61
    L53:
        destroyFragmentView();     // Catch: Throwable -> L94
        this.mFragment.mState = 1;     // Catch: Throwable -> L94
        goto L61
    L60:
        detach();     // Catch: Throwable -> L94
        goto L61
    L36:
        if (FragmentManager.isLoggingEnabled(3) == false) goto L38;
        Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.mFragment);     // Catch: Throwable -> L94
    L38:
        Fragment r9 = this.mFragment;     // Catch: Throwable -> L94
        if (r9.mBeingSaved == false) goto L42;
        saveState();     // Catch: Throwable -> L94
    L46:
        Fragment r10 = this.mFragment;     // Catch: Throwable -> L94
        if (r10.mView == null) goto L51;
        ViewGroup r11 = r10.mContainer;     // Catch: Throwable -> L94
        if (r11 == null) goto L51;
        SpecialEffectsController.getOrCreateController(r11, r10.getParentFragmentManager()).enqueueRemove(this);     // Catch: Throwable -> L94
    L51:
        this.mFragment.mState = 3;     // Catch: Throwable -> L94
        goto L61
    L42:
        if (r9.mView == null) goto L46;
        if (r9.mSavedViewState != null) goto L46;
        saveViewState();     // Catch: Throwable -> L94
        goto L46
    L55:
        if (r6.mBeingSaved == true) goto L57;
    L59:
        destroy();     // Catch: Throwable -> L94
        goto L61
    L57:
        if (this.mFragmentStore.getSavedState(r6.mWho) != null) goto L59;
        saveState();     // Catch: Throwable -> L94
        goto L59
    L62:
        if (r4 == false) goto L64;
    L78:
        Fragment r1 = this.mFragment;     // Catch: Throwable -> L94
        if (r1.mHiddenChanged == true) goto L81;
    L92:
        this.mMovingToState = false;
        return;
    L81:
        if (r1.mView == null) goto L88;
        ViewGroup r2 = r1.mContainer;     // Catch: Throwable -> L94
        if (r2 == null) goto L88;
        SpecialEffectsController r3 = SpecialEffectsController.getOrCreateController(r2, r1.getParentFragmentManager());     // Catch: Throwable -> L94
        if (this.mFragment.mHidden == false) goto L87;
        r3.enqueueHide(this);     // Catch: Throwable -> L94
        goto L88
    L87:
        r3.enqueueShow(this);     // Catch: Throwable -> L94
    L88:
        Fragment r12 = this.mFragment;     // Catch: Throwable -> L94
        FragmentManager r13 = r12.mFragmentManager;     // Catch: Throwable -> L94
        if (r13 == null) goto L91;
        r13.invalidateMenuForFragment(r12);     // Catch: Throwable -> L94
    L91:
        Fragment r14 = this.mFragment;     // Catch: Throwable -> L94
        r14.mHiddenChanged = false;     // Catch: Throwable -> L94
        r14.onHiddenChanged(r14.mHidden);     // Catch: Throwable -> L94
        this.mFragment.mChildFragmentManager.dispatchOnHiddenChanged();     // Catch: Throwable -> L94
        goto L92
    L64:
        if (r7 != (-1)) goto L78;
        if (r6.mRemoving == false) goto L78;
        if (r6.isInBackStack() == true) goto L78;
        if (this.mFragment.mBeingSaved == true) goto L78;
        if (FragmentManager.isLoggingEnabled(3) == false) goto L74;
        Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + this.mFragment);     // Catch: Throwable -> L94
    L74:
        this.mFragmentStore.getNonConfig().clearNonConfigState(this.mFragment);     // Catch: Throwable -> L94
        this.mFragmentStore.makeInactive(this);     // Catch: Throwable -> L94
        if (FragmentManager.isLoggingEnabled(3) == false) goto L77;
        Log.d("FragmentManager", "initState called for fragment: " + this.mFragment);     // Catch: Throwable -> L94
    L77:
        this.mFragment.initState();     // Catch: Throwable -> L94
    L94:
        th = move-exception;
        this.mMovingToState = false;
        throw th;
    }

    void pause() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d("FragmentManager", "movefrom RESUMED: " + this.mFragment);
    L5:
        this.mFragment.performPause();
        this.mDispatcher.dispatchOnFragmentPaused(this.mFragment, false);
    }

    void restoreState(@NonNull ClassLoader r4) {
        Bundle r0 = this.mFragment.mSavedFragmentState;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setClassLoader(r4);
        Fragment r5 = this.mFragment;
        r5.mSavedViewState = r5.mSavedFragmentState.getSparseParcelableArray(VIEW_STATE_TAG);
        Fragment r6 = this.mFragment;
        r6.mSavedViewRegistryState = r6.mSavedFragmentState.getBundle(VIEW_REGISTRY_STATE_TAG);
        Fragment r7 = this.mFragment;
        r7.mTargetWho = r7.mSavedFragmentState.getString(TARGET_STATE_TAG);
        Fragment r8 = this.mFragment;
        if (r8.mTargetWho == null) goto L8;
        r8.mTargetRequestCode = r8.mSavedFragmentState.getInt(TARGET_REQUEST_CODE_STATE_TAG, 0);
    L8:
        Fragment r9 = this.mFragment;
        Boolean r1 = r9.mSavedUserVisibleHint;
        if (r1 == null) goto L11;
        r9.mUserVisibleHint = r1.booleanValue();
        this.mFragment.mSavedUserVisibleHint = null;
    L12:
        Fragment r3 = this.mFragment;
        if (r3.mUserVisibleHint == true) goto L16;
        r3.mDeferStart = true;
        return;
    L16:
        return;
    L11:
        r9.mUserVisibleHint = r9.mSavedFragmentState.getBoolean(USER_VISIBLE_HINT_TAG, true);
        goto L12
    }

    void resume() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d("FragmentManager", "moveto RESUMED: " + this.mFragment);
    L5:
        View r0 = this.mFragment.getFocusedView();
        if (r0 != null) goto L8;
    L16:
        this.mFragment.setFocusedView(null);
        this.mFragment.performResume();
        this.mDispatcher.dispatchOnFragmentResumed(this.mFragment, false);
        Fragment r5 = this.mFragment;
        r5.mSavedFragmentState = null;
        r5.mSavedViewState = null;
        r5.mSavedViewRegistryState = null;
        return;
    L8:
        if (isFragmentViewChild(r0) == false) goto L16;
        boolean r2 = r0.requestFocus();
        if (FragmentManager.isLoggingEnabled(2) == false) goto L16;
        StringBuilder r3 = new StringBuilder();
        r3.append("requestFocus: Restoring focused view ");
        r3.append(r0);
        r3.append(" ");
        if (r2 == false) goto L14;
        String r1 = "succeeded";
    L15:
        r3.append(r1);
        r3.append(" on Fragment ");
        r3.append(this.mFragment);
        r3.append(" resulting in focused view ");
        r3.append(this.mFragment.mView.findFocus());
        Log.v("FragmentManager", r3.toString());
        goto L16
    L14:
        r1 = "failed";
        goto L15
    }

    @Nullable
    Fragment.SavedState saveInstanceState() {
        if (this.mFragment.mState <= (-1)) goto L8;
        Bundle r3 = saveBasicState();
        if (r3 != null) goto L7;
        return null;
    L7:
        return new Fragment.SavedState(r3);
    L8:
        return null;
    }

    void saveState() {
        FragmentState r0 = new FragmentState(this.mFragment);
        Fragment r1 = this.mFragment;
        if (r1.mState > (-1)) goto L5;
    L13:
        r0.mSavedFragmentState = r1.mSavedFragmentState;
    L14:
        this.mFragmentStore.setSavedState(this.mFragment.mWho, r0);
        return;
    L5:
        if (r0.mSavedFragmentState != null) goto L13;
        Bundle r2 = saveBasicState();
        r0.mSavedFragmentState = r2;
        if (this.mFragment.mTargetWho == null) goto L14;
        if (r2 != null) goto L10;
        r0.mSavedFragmentState = new Bundle();
    L10:
        r0.mSavedFragmentState.putString(TARGET_STATE_TAG, this.mFragment.mTargetWho);
        int r3 = this.mFragment.mTargetRequestCode;
        if (r3 == 0) goto L14;
        r0.mSavedFragmentState.putInt(TARGET_REQUEST_CODE_STATE_TAG, r3);
        goto L14
    }

    void saveViewState() {
        if (this.mFragment.mView != null) goto L6;
        return;
    L6:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L8;
        Log.v("FragmentManager", "Saving view state for fragment " + this.mFragment + " with view " + this.mFragment.mView);
    L8:
        SparseArray<Parcelable> r0 = new SparseArray();
        this.mFragment.mView.saveHierarchyState(r0);
        if (r0.size() <= 0) goto L11;
        this.mFragment.mSavedViewState = r0;
    L11:
        Bundle r1 = new Bundle();
        this.mFragment.mViewLifecycleOwner.performSave(r1);
        if (r1.isEmpty() == true) goto L15;
        this.mFragment.mSavedViewRegistryState = r1;
        return;
    }

    void setFragmentManagerState(int r1) {
        this.mFragmentManagerState = r1;
    }

    void start() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d("FragmentManager", "moveto STARTED: " + this.mFragment);
    L5:
        this.mFragment.performStart();
        this.mDispatcher.dispatchOnFragmentStarted(this.mFragment, false);
    }

    void stop() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d("FragmentManager", "movefrom STARTED: " + this.mFragment);
    L5:
        this.mFragment.performStop();
        this.mDispatcher.dispatchOnFragmentStopped(this.mFragment, false);
    }
}
