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
import androidx.core.os.EnvironmentCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.R;
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

    FragmentStateManager(FragmentLifecycleCallbacksDispatcher r2, FragmentStore r3, Fragment r4) {
        this.mMovingToState = false;
        this.mFragmentManagerState = -1;
        this.mDispatcher = r2;
        this.mFragmentStore = r3;
        this.mFragment = r4;
    }

    FragmentStateManager(FragmentLifecycleCallbacksDispatcher r2, FragmentStore r3, ClassLoader r4, FragmentFactory r5, FragmentState r6) {
        this.mMovingToState = false;
        this.mFragmentManagerState = -1;
        this.mDispatcher = r2;
        this.mFragmentStore = r3;
        Fragment r7 = r5.instantiate(r4, r6.mClassName);
        this.mFragment = r7;
        if (r6.mArguments == null) goto L5;
        r6.mArguments.setClassLoader(r4);
    L5:
        r7.setArguments(r6.mArguments);
        r7.mWho = r6.mWho;
        r7.mFromLayout = r6.mFromLayout;
        r7.mRestored = true;
        r7.mFragmentId = r6.mFragmentId;
        r7.mContainerId = r6.mContainerId;
        r7.mTag = r6.mTag;
        r7.mRetainInstance = r6.mRetainInstance;
        r7.mRemoving = r6.mRemoving;
        r7.mDetached = r6.mDetached;
        r7.mHidden = r6.mHidden;
        r7.mMaxState = Lifecycle.State.values()[r6.mMaxLifecycleState];
        if (r6.mSavedFragmentState == null) goto L8;
        r7.mSavedFragmentState = r6.mSavedFragmentState;
    L10:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L13;
        Log.v(TAG, "Instantiated fragment " + r7);
        return;
    L13:
        return;
    L8:
        r7.mSavedFragmentState = new Bundle();
        goto L10
    }

    FragmentStateManager(FragmentLifecycleCallbacksDispatcher r3, FragmentStore r4, Fragment r5, FragmentState r6) {
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
        if (r5.mTarget == null) goto L5;
        String r7 = r5.mTarget.mWho;
    L6:
        r5.mTargetWho = r7;
        r5.mTarget = null;
        if (r6.mSavedFragmentState == null) goto L9;
        r5.mSavedFragmentState = r6.mSavedFragmentState;
        return;
    L9:
        r5.mSavedFragmentState = new Bundle();
        return;
    L5:
        r7 = null;
        goto L6
    }

    Fragment getFragment() {
        return this.mFragment;
    }

    void setFragmentManagerState(int r1) {
        this.mFragmentManagerState = r1;
    }

    int computeExpectedState() {
        if (this.mFragment.mFragmentManager == null) goto L5;
        int r0 = this.mFragmentManagerState;
        int r1 = AnonymousClass2.$SwitchMap$androidx$lifecycle$Lifecycle$State[this.mFragment.mMaxState.ordinal()];
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L13;
        if (r1 == 4) goto L12;
        r0 = Math.min(r0, -1);
        goto L16
    L12:
        r0 = Math.min(r0, 0);
        goto L16
    L13:
        r0 = Math.min(r0, 1);
        goto L16
    L14:
        r0 = Math.min(r0, 5);
    L16:
        if (this.mFragment.mFromLayout == false) goto L29;
        if (this.mFragment.mInLayout == false) goto L25;
        r0 = Math.max(this.mFragmentManagerState, 2);
        if (this.mFragment.mView == null) goto L29;
        if (this.mFragment.mView.getParent() != null) goto L29;
        r0 = Math.min(r0, 2);
        goto L29
    L25:
        if (this.mFragmentManagerState >= 4) goto L27;
        r0 = Math.min(r0, this.mFragment.mState);
        goto L29
    L27:
        r0 = Math.min(r0, 1);
    L29:
        if (this.mFragment.mAdded == true) goto L32;
        r0 = Math.min(r0, 1);
    L32:
        if (FragmentManager.USE_STATE_MANAGER == true) goto L34;
    L36:
        SpecialEffectsController.Operation.LifecycleImpact r2 = null;
    L38:
        if (r2 != SpecialEffectsController.Operation.LifecycleImpact.ADDING) goto L41;
        r0 = Math.min(r0, 6);
    L50:
        if (this.mFragment.mDeferStart == false) goto L55;
        if (this.mFragment.mState >= 5) goto L55;
        r0 = Math.min(r0, 4);
    L55:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L57;
        Log.v(TAG, "computeExpectedState() of " + r0 + " for " + this.mFragment);
    L57:
        return r0;
    L41:
        if (r2 != SpecialEffectsController.Operation.LifecycleImpact.REMOVING) goto L44;
        r0 = Math.max(r0, 3);
        goto L50
    L44:
        if (this.mFragment.mRemoving == false) goto L50;
        if (this.mFragment.isInBackStack() == false) goto L48;
        r0 = Math.min(r0, 1);
        goto L50
    L48:
        r0 = Math.min(r0, -1);
        goto L50
    L34:
        if (this.mFragment.mContainer == null) goto L36;
        r2 = SpecialEffectsController.getOrCreateController(this.mFragment.mContainer, this.mFragment.getParentFragmentManager()).getAwaitingCompletionLifecycleImpact(this);
        goto L38
    L5:
        return this.mFragment.mState;
    }

    void moveToExpectedState() {
        if (this.mMovingToState == false) goto L75;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L117;
        Log.v(TAG, "Ignoring re-entrant call to moveToExpectedState() for " + getFragment());
        return;
    L117:
        return;
    L75:
        this.mMovingToState = true;     // Catch: Throwable -> L72
    L10:
        int r4 = computeExpectedState();     // Catch: Throwable -> L72
        if (r4 == this.mFragment.mState) goto L55;
        if (r4 > this.mFragment.mState) goto L15;
        switch((this.mFragment.mState - 1)) {
            case -1: goto L53;
            case 0: goto L52;
            case 1: goto L51;
            case 2: goto L50;
            case 3: goto L37;
            case 4: goto L35;
            case 5: goto L34;
            case 6: goto L33;
            default: goto L10;
        };     // Catch: Throwable -> L72
    L33:
        pause();     // Catch: Throwable -> L72
        goto L10
    L34:
        this.mFragment.mState = 5;     // Catch: Throwable -> L72
        goto L10
    L35:
        stop();     // Catch: Throwable -> L72
        goto L10
    L37:
        if (FragmentManager.isLoggingEnabled(3) == false) goto L40;
        Log.d(TAG, "movefrom ACTIVITY_CREATED: " + this.mFragment);     // Catch: Throwable -> L72
    L40:
        if (this.mFragment.mView == null) goto L45;
        if (this.mFragment.mSavedViewState != null) goto L45;
        saveViewState();     // Catch: Throwable -> L72
    L45:
        if (this.mFragment.mView != null) goto L47;
    L49:
        this.mFragment.mState = 3;     // Catch: Throwable -> L72
        goto L10
    L47:
        if (this.mFragment.mContainer == null) goto L49;
        SpecialEffectsController.getOrCreateController(this.mFragment.mContainer, this.mFragment.getParentFragmentManager()).enqueueRemove(this);     // Catch: Throwable -> L72
        goto L49
    L50:
        this.mFragment.mInLayout = false;     // Catch: Throwable -> L72
        this.mFragment.mState = 2;     // Catch: Throwable -> L72
        goto L10
    L51:
        destroyFragmentView();     // Catch: Throwable -> L72
        this.mFragment.mState = 1;     // Catch: Throwable -> L72
        goto L10
    L52:
        destroy();     // Catch: Throwable -> L72
        goto L10
    L53:
        detach();     // Catch: Throwable -> L72
        goto L10
    L15:
        switch((this.mFragment.mState + 1)) {
            case 0: goto L29;
            case 1: goto L28;
            case 2: goto L27;
            case 3: goto L26;
            case 4: goto L21;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L17;
            default: goto L10;
        };     // Catch: Throwable -> L72
    L17:
        resume();     // Catch: Throwable -> L72
        goto L10
    L18:
        this.mFragment.mState = 6;     // Catch: Throwable -> L72
        goto L10
    L19:
        start();     // Catch: Throwable -> L72
        goto L10
    L21:
        if (this.mFragment.mView != null) goto L23;
    L25:
        this.mFragment.mState = 4;     // Catch: Throwable -> L72
        goto L10
    L23:
        if (this.mFragment.mContainer == null) goto L25;
        SpecialEffectsController.getOrCreateController(this.mFragment.mContainer, this.mFragment.getParentFragmentManager()).enqueueAdd(SpecialEffectsController.Operation.State.from(this.mFragment.mView.getVisibility()), this);     // Catch: Throwable -> L72
        goto L25
    L26:
        activityCreated();     // Catch: Throwable -> L72
        goto L10
    L27:
        ensureInflatedView();     // Catch: Throwable -> L72
        createView();     // Catch: Throwable -> L72
        goto L10
    L28:
        create();     // Catch: Throwable -> L72
        goto L10
    L29:
        attach();     // Catch: Throwable -> L72
        goto L10
    L55:
        if (FragmentManager.USE_STATE_MANAGER == true) goto L57;
    L70:
        this.mMovingToState = false;
        return;
    L57:
        if (this.mFragment.mHiddenChanged == false) goto L70;
        if (this.mFragment.mView == null) goto L67;
        if (this.mFragment.mContainer == null) goto L67;
        SpecialEffectsController r1 = SpecialEffectsController.getOrCreateController(this.mFragment.mContainer, this.mFragment.getParentFragmentManager());     // Catch: Throwable -> L72
        if (this.mFragment.mHidden == false) goto L65;
        r1.enqueueHide(this);     // Catch: Throwable -> L72
        goto L67
    L65:
        r1.enqueueShow(this);     // Catch: Throwable -> L72
    L67:
        if (this.mFragment.mFragmentManager == null) goto L69;
        this.mFragment.mFragmentManager.invalidateMenuForFragment(this.mFragment);     // Catch: Throwable -> L72
    L69:
        this.mFragment.mHiddenChanged = false;     // Catch: Throwable -> L72
        Fragment r2 = this.mFragment;     // Catch: Throwable -> L72
        r2.onHiddenChanged(r2.mHidden);     // Catch: Throwable -> L72
    L72:
        th = move-exception;
        this.mMovingToState = false;
        throw th;
    }

    void ensureInflatedView() {
        if (this.mFragment.mFromLayout == true) goto L5;
        return;
    L5:
        if (this.mFragment.mInLayout == true) goto L7;
        return;
    L7:
        if (this.mFragment.mPerformedCreateView == false) goto L9;
        return;
    L9:
        if (FragmentManager.isLoggingEnabled(3) == false) goto L11;
        Log.d(TAG, "moveto CREATE_VIEW: " + this.mFragment);
    L11:
        Fragment r0 = this.mFragment;
        r0.performCreateView(r0.performGetLayoutInflater(r0.mSavedFragmentState), null, this.mFragment.mSavedFragmentState);
        if (this.mFragment.mView == null) goto L21;
        this.mFragment.mView.setSaveFromParentEnabled(false);
        this.mFragment.mView.setTag(R.id.fragment_container_view_tag, this.mFragment);
        if (this.mFragment.mHidden == false) goto L16;
        this.mFragment.mView.setVisibility(8);
    L16:
        this.mFragment.performViewCreated();
        FragmentLifecycleCallbacksDispatcher r1 = this.mDispatcher;
        Fragment r2 = this.mFragment;
        r1.dispatchOnFragmentViewCreated(r2, r2.mView, this.mFragment.mSavedFragmentState, false);
        this.mFragment.mState = 2;
        return;
    }

    void restoreState(ClassLoader r4) {
        if (this.mFragment.mSavedFragmentState != null) goto L5;
        return;
    L5:
        this.mFragment.mSavedFragmentState.setClassLoader(r4);
        Fragment r5 = this.mFragment;
        r5.mSavedViewState = r5.mSavedFragmentState.getSparseParcelableArray(VIEW_STATE_TAG);
        Fragment r6 = this.mFragment;
        r6.mSavedViewRegistryState = r6.mSavedFragmentState.getBundle(VIEW_REGISTRY_STATE_TAG);
        Fragment r7 = this.mFragment;
        r7.mTargetWho = r7.mSavedFragmentState.getString(TARGET_STATE_TAG);
        if (this.mFragment.mTargetWho == null) goto L9;
        Fragment r8 = this.mFragment;
        r8.mTargetRequestCode = r8.mSavedFragmentState.getInt(TARGET_REQUEST_CODE_STATE_TAG, 0);
    L9:
        if (this.mFragment.mSavedUserVisibleHint == null) goto L11;
        Fragment r9 = this.mFragment;
        r9.mUserVisibleHint = r9.mSavedUserVisibleHint.booleanValue();
        this.mFragment.mSavedUserVisibleHint = null;
    L13:
        if (this.mFragment.mUserVisibleHint == true) goto L16;
        this.mFragment.mDeferStart = true;
        return;
    L16:
        return;
    L11:
        Fragment r10 = this.mFragment;
        r10.mUserVisibleHint = r10.mSavedFragmentState.getBoolean(USER_VISIBLE_HINT_TAG, true);
        goto L13
    }

    void attach() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d(TAG, "moveto ATTACHED: " + this.mFragment);
    L5:
        FragmentStateManager r4 = null;
        if (this.mFragment.mTarget == null) goto L13;
        FragmentStateManager r0 = this.mFragmentStore.getFragmentStateManager(this.mFragment.mTarget.mWho);
        if (r0 == null) goto L11;
        Fragment r1 = this.mFragment;
        r1.mTargetWho = r1.mTarget.mWho;
        this.mFragment.mTarget = null;
        r4 = r0;
    L19:
        if (r4 != null) goto L21;
    L25:
        Fragment r2 = this.mFragment;
        r2.mHost = r2.mFragmentManager.getHost();
        Fragment r3 = this.mFragment;
        r3.mParentFragment = r3.mFragmentManager.getParent();
        this.mDispatcher.dispatchOnFragmentPreAttached(this.mFragment, false);
        this.mFragment.performAttach();
        this.mDispatcher.dispatchOnFragmentAttached(this.mFragment, false);
        return;
    L21:
        if (FragmentManager.USE_STATE_MANAGER == false) goto L23;
    L24:
        r4.moveToExpectedState();
        goto L25
    L23:
        if (r4.getFragment().mState >= 1) goto L25;
    L11:
        throw new IllegalStateException("Fragment " + this.mFragment + " declared target fragment " + this.mFragment.mTarget + " that does not belong to this FragmentManager!");
    L13:
        if (this.mFragment.mTargetWho == null) goto L19;
        r4 = this.mFragmentStore.getFragmentStateManager(this.mFragment.mTargetWho);
        if (r4 != null) goto L19;
        throw new IllegalStateException("Fragment " + this.mFragment + " declared target fragment " + this.mFragment.mTargetWho + " that does not belong to this FragmentManager!");
    }

    void create() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L6;
        Log.d(TAG, "moveto CREATED: " + this.mFragment);
    L6:
        if (this.mFragment.mIsCreated == true) goto L8;
        FragmentLifecycleCallbacksDispatcher r0 = this.mDispatcher;
        Fragment r1 = this.mFragment;
        r0.dispatchOnFragmentPreCreated(r1, r1.mSavedFragmentState, false);
        Fragment r2 = this.mFragment;
        r2.performCreate(r2.mSavedFragmentState);
        FragmentLifecycleCallbacksDispatcher r3 = this.mDispatcher;
        Fragment r4 = this.mFragment;
        r3.dispatchOnFragmentCreated(r4, r4.mSavedFragmentState, false);
        return;
    L8:
        Fragment r5 = this.mFragment;
        r5.restoreChildFragmentState(r5.mSavedFragmentState);
        this.mFragment.mState = 1;
    }

    void createView() {
        if (this.mFragment.mFromLayout == false) goto L6;
        return;
    L6:
        if (FragmentManager.isLoggingEnabled(3) == false) goto L8;
        Log.d(TAG, "moveto CREATE_VIEW: " + this.mFragment);
    L8:
        Fragment r0 = this.mFragment;
        LayoutInflater r1 = r0.performGetLayoutInflater(r0.mSavedFragmentState);
        if (this.mFragment.mContainer == null) goto L12;
        ViewGroup r2 = this.mFragment.mContainer;
    L28:
        this.mFragment.mContainer = r2;
        Fragment r3 = this.mFragment;
        r3.performCreateView(r1, r2, r3.mSavedFragmentState);
        if (this.mFragment.mView == null) goto L57;
        boolean r4 = false;
        this.mFragment.mView.setSaveFromParentEnabled(false);
        this.mFragment.mView.setTag(R.id.fragment_container_view_tag, this.mFragment);
        if (r2 == null) goto L34;
        addViewToContainer();
    L34:
        if (this.mFragment.mHidden == false) goto L37;
        this.mFragment.mView.setVisibility(8);
    L37:
        if (ViewCompat.isAttachedToWindow(this.mFragment.mView) == false) goto L39;
        ViewCompat.requestApplyInsets(this.mFragment.mView);
    L40:
        this.mFragment.performViewCreated();
        FragmentLifecycleCallbacksDispatcher r5 = this.mDispatcher;
        Fragment r6 = this.mFragment;
        r5.dispatchOnFragmentViewCreated(r6, r6.mView, this.mFragment.mSavedFragmentState, false);
        int r7 = this.mFragment.mView.getVisibility();
        float r8 = this.mFragment.mView.getAlpha();
        if (FragmentManager.USE_STATE_MANAGER == false) goto L51;
        this.mFragment.setPostOnViewCreatedAlpha(r8);
        if (this.mFragment.mContainer == null) goto L57;
        if (r7 != 0) goto L57;
        View r9 = this.mFragment.mView.findFocus();
        if (r9 == null) goto L50;
        this.mFragment.setFocusedView(r9);
        if (FragmentManager.isLoggingEnabled(2) == false) goto L50;
        Log.v(TAG, "requestFocus: Saved focused view " + r9 + " for Fragment " + this.mFragment);
    L50:
        this.mFragment.mView.setAlpha(0.0f);
        goto L57
    L51:
        Fragment r10 = this.mFragment;
        if (r7 == 0) goto L54;
    L56:
        r10.mIsNewlyAdded = r4;
        goto L57
    L54:
        if (r10.mContainer == null) goto L56;
        r4 = true;
        goto L56
    L39:
        final View r11 = this.mFragment.mView;
        r11.addOnAttachStateChangeListener(new AnonymousClass1(this, r11));
    L57:
        this.mFragment.mState = 2;
        return;
    L12:
        if (this.mFragment.mContainerId != 0) goto L14;
        r2 = null;
        goto L28
    L14:
        if (this.mFragment.mContainerId == (-1)) goto L26;
        r2 = (ViewGroup) this.mFragment.mFragmentManager.getContainer().onFindViewById(this.mFragment.mContainerId);
        if (r2 != null) goto L28;
        if (this.mFragment.mRestored == true) goto L28;
        String r12 = this.mFragment.getResources().getResourceName(this.mFragment.mContainerId);     // Catch: Resources.NotFoundException -> L22
    L24:
        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.mFragment.mContainerId) + " (" + r12 + ") for fragment " + this.mFragment);
    L22:
        r12 = EnvironmentCompat.MEDIA_UNKNOWN;
        goto L24
    L26:
        throw new IllegalArgumentException("Cannot create fragment " + this.mFragment + " for a container view with no id");
    }

    void activityCreated() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d(TAG, "moveto ACTIVITY_CREATED: " + this.mFragment);
    L5:
        Fragment r0 = this.mFragment;
        r0.performActivityCreated(r0.mSavedFragmentState);
        FragmentLifecycleCallbacksDispatcher r1 = this.mDispatcher;
        Fragment r3 = this.mFragment;
        r1.dispatchOnFragmentActivityCreated(r3, r3.mSavedFragmentState, false);
    }

    void start() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d(TAG, "moveto STARTED: " + this.mFragment);
    L5:
        this.mFragment.performStart();
        this.mDispatcher.dispatchOnFragmentStarted(this.mFragment, false);
    }

    void resume() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d(TAG, "moveto RESUMED: " + this.mFragment);
    L5:
        View r0 = this.mFragment.getFocusedView();
        if (r0 != null) goto L8;
    L16:
        this.mFragment.setFocusedView(null);
        this.mFragment.performResume();
        this.mDispatcher.dispatchOnFragmentResumed(this.mFragment, false);
        this.mFragment.mSavedFragmentState = null;
        this.mFragment.mSavedViewState = null;
        this.mFragment.mSavedViewRegistryState = null;
        return;
    L8:
        if (isFragmentViewChild(r0) == false) goto L16;
        boolean r2 = r0.requestFocus();
        if (FragmentManager.isLoggingEnabled(2) == false) goto L16;
        StringBuilder r1 = new StringBuilder("requestFocus: Restoring focused view ").append(r0).append(" ");
        if (r2 == false) goto L14;
        String r3 = "succeeded";
    L15:
        Log.v(TAG, r1.append(r3).append(" on Fragment ").append(this.mFragment).append(" resulting in focused view ").append(this.mFragment.mView.findFocus()).toString());
        goto L16
    L14:
        r3 = "failed";
        goto L15
    }

    private boolean isFragmentViewChild(View r3) {
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

    void pause() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d(TAG, "movefrom RESUMED: " + this.mFragment);
    L5:
        this.mFragment.performPause();
        this.mDispatcher.dispatchOnFragmentPaused(this.mFragment, false);
    }

    void stop() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d(TAG, "movefrom STARTED: " + this.mFragment);
    L5:
        this.mFragment.performStop();
        this.mDispatcher.dispatchOnFragmentStopped(this.mFragment, false);
    }

    FragmentState saveState() {
        FragmentState r0 = new FragmentState(this.mFragment);
        if (this.mFragment.mState > (-1)) goto L5;
    L14:
        r0.mSavedFragmentState = this.mFragment.mSavedFragmentState;
    L15:
        return r0;
    L5:
        if (r0.mSavedFragmentState != null) goto L14;
        r0.mSavedFragmentState = saveBasicState();
        if (this.mFragment.mTargetWho == null) goto L15;
        if (r0.mSavedFragmentState != null) goto L11;
        r0.mSavedFragmentState = new Bundle();
    L11:
        r0.mSavedFragmentState.putString(TARGET_STATE_TAG, this.mFragment.mTargetWho);
        if (this.mFragment.mTargetRequestCode == 0) goto L15;
        r0.mSavedFragmentState.putInt(TARGET_REQUEST_CODE_STATE_TAG, this.mFragment.mTargetRequestCode);
        goto L15
    }

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

    void saveViewState() {
        if (this.mFragment.mView != null) goto L5;
        return;
    L5:
        SparseArray<Parcelable> r0 = new SparseArray();
        this.mFragment.mView.saveHierarchyState(r0);
        if (r0.size() <= 0) goto L8;
        this.mFragment.mSavedViewState = r0;
    L8:
        Bundle r1 = new Bundle();
        this.mFragment.mViewLifecycleOwner.performSave(r1);
        if (r1.isEmpty() == true) goto L12;
        this.mFragment.mSavedViewRegistryState = r1;
        return;
    }

    void destroyFragmentView() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L6;
        Log.d(TAG, "movefrom CREATE_VIEW: " + this.mFragment);
    L6:
        if (this.mFragment.mContainer != null) goto L8;
    L10:
        this.mFragment.performDestroyView();
        this.mDispatcher.dispatchOnFragmentViewDestroyed(this.mFragment, false);
        this.mFragment.mContainer = null;
        this.mFragment.mView = null;
        this.mFragment.mViewLifecycleOwner = null;
        this.mFragment.mViewLifecycleOwnerLiveData.setValue(null);
        this.mFragment.mInLayout = false;
        return;
    L8:
        if (this.mFragment.mView == null) goto L10;
        this.mFragment.mContainer.removeView(this.mFragment.mView);
        goto L10
    }

    void destroy() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d(TAG, "movefrom CREATED: " + this.mFragment);
    L5:
        boolean r1 = true;
        if (this.mFragment.mRemoving == true) goto L8;
    L10:
        boolean r0 = false;
    L11:
        if (r0 == false) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == false) goto L40;
        FragmentHostCallback<?> r4 = this.mFragment.mHost;
        if ((r4 instanceof ViewModelStoreOwner) == false) goto L22;
        r1 = this.mFragmentStore.getNonConfig().isCleared();
    L24:
        if (r0 == true) goto L26;
        if (r1 == true) goto L26;
    L27:
        this.mFragment.performDestroy();
        this.mDispatcher.dispatchOnFragmentDestroyed(this.mFragment, false);
        Iterator<FragmentStateManager> r2 = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
    L29:
        if (r2.hasNext() == false) goto L36;
        FragmentStateManager r5 = r2.next();
        if (r5 == null) goto L29;
        Fragment r6 = r5.getFragment();
        if (this.mFragment.mWho.equals(r6.mTargetWho) == false) goto L29;
        r6.mTarget = this.mFragment;
        r6.mTargetWho = null;
        goto L29
    L36:
        if (this.mFragment.mTargetWho == null) goto L38;
        Fragment r7 = this.mFragment;
        r7.mTarget = this.mFragmentStore.findActiveFragment(r7.mTargetWho);
    L38:
        this.mFragmentStore.makeInactive(this);
        return;
    L26:
        this.mFragmentStore.getNonConfig().clearNonConfigState(this.mFragment);
        goto L27
    L22:
        if ((r4.getContext() instanceof Activity) == false) goto L24;
        r1 = true ^ ((Activity) r4.getContext()).isChangingConfigurations();
        goto L24
    L40:
        if (this.mFragment.mTargetWho == null) goto L46;
        Fragment r8 = this.mFragmentStore.findActiveFragment(this.mFragment.mTargetWho);
        if (r8 == null) goto L46;
        if (r8.mRetainInstance == false) goto L46;
        this.mFragment.mTarget = r8;
    L46:
        this.mFragment.mState = 0;
        return;
    L13:
        if (this.mFragmentStore.getNonConfig().shouldDestroy(this.mFragment) == true) goto L16;
        r3 = false;
        goto L17
    L8:
        if (this.mFragment.isInBackStack() == true) goto L10;
        r0 = true;
        goto L11
    }

    void detach() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d(TAG, "movefrom ATTACHED: " + this.mFragment);
    L5:
        this.mFragment.performDetach();
        boolean r4 = false;
        this.mDispatcher.dispatchOnFragmentDetached(this.mFragment, false);
        this.mFragment.mState = -1;
        this.mFragment.mHost = null;
        this.mFragment.mParentFragment = null;
        this.mFragment.mFragmentManager = null;
        if (this.mFragment.mRemoving == true) goto L8;
    L10:
        if (r4 == true) goto L14;
        if (this.mFragmentStore.getNonConfig().shouldDestroy(this.mFragment) == true) goto L14;
        return;
    L14:
        if (FragmentManager.isLoggingEnabled(3) == false) goto L16;
        Log.d(TAG, "initState called for fragment: " + this.mFragment);
    L16:
        this.mFragment.initState();
        return;
    L8:
        if (this.mFragment.isInBackStack() == true) goto L10;
        r4 = true;
        goto L10
    }

    void addViewToContainer() {
        int r0 = this.mFragmentStore.findFragmentIndexInContainer(this.mFragment);
        this.mFragment.mContainer.addView(this.mFragment.mView, r0);
    }
}
