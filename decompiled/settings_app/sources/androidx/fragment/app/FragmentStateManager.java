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
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStoreOwner;
import com.android.settings.utils.HanziToPinyin;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class FragmentStateManager {
    static final String ARGUMENTS_KEY = "arguments";
    static final String CHILD_FRAGMENT_MANAGER_KEY = "childFragmentManager";
    static final String FRAGMENT_STATE_KEY = "state";
    static final String REGISTRY_STATE_KEY = "registryState";
    static final String SAVED_INSTANCE_STATE_KEY = "savedInstanceState";
    private static final String TAG = "FragmentManager";
    static final String VIEW_REGISTRY_STATE_KEY = "viewRegistryState";
    static final String VIEW_STATE_KEY = "viewState";
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

    FragmentStateManager(FragmentLifecycleCallbacksDispatcher r2, FragmentStore r3, ClassLoader r4, FragmentFactory r5, Bundle r6) {
        this.mMovingToState = false;
        this.mFragmentManagerState = -1;
        this.mDispatcher = r2;
        this.mFragmentStore = r3;
        Fragment r7 = ((FragmentState) r6.getParcelable("state")).instantiate(r5, r4);
        this.mFragment = r7;
        r7.mSavedFragmentState = r6;
        Bundle r1 = r6.getBundle(ARGUMENTS_KEY);
        if (r1 == null) goto L5;
        r1.setClassLoader(r4);
    L5:
        r7.setArguments(r1);
        if (FragmentManager.isLoggingEnabled(2) == false) goto L9;
        Log.v("FragmentManager", "Instantiated fragment " + r7);
        return;
    }

    FragmentStateManager(FragmentLifecycleCallbacksDispatcher r3, FragmentStore r4, Fragment r5, Bundle r6) {
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
        r5.mSavedFragmentState = r6;
        r5.mArguments = r6.getBundle(ARGUMENTS_KEY);
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
        if (this.mFragment.mContainer == null) goto L34;
        SpecialEffectsController.Operation.LifecycleImpact r2 = SpecialEffectsController.getOrCreateController(this.mFragment.mContainer, this.mFragment.getParentFragmentManager()).getAwaitingCompletionLifecycleImpact(this);
    L36:
        if (r2 != SpecialEffectsController.Operation.LifecycleImpact.ADDING) goto L39;
        r0 = Math.min(r0, 6);
    L48:
        if (this.mFragment.mDeferStart == false) goto L53;
        if (this.mFragment.mState >= 5) goto L53;
        r0 = Math.min(r0, 4);
    L53:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L55;
        Log.v("FragmentManager", "computeExpectedState() of " + r0 + " for " + this.mFragment);
    L55:
        return r0;
    L39:
        if (r2 != SpecialEffectsController.Operation.LifecycleImpact.REMOVING) goto L42;
        r0 = Math.max(r0, 3);
        goto L48
    L42:
        if (this.mFragment.mRemoving == false) goto L48;
        if (this.mFragment.isInBackStack() == false) goto L46;
        r0 = Math.min(r0, 1);
        goto L48
    L46:
        r0 = Math.min(r0, -1);
        goto L48
    L34:
        r2 = null;
        goto L36
    L5:
        return this.mFragment.mState;
    }

    void moveToExpectedState() {
        if (this.mMovingToState == false) goto L98;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L119;
        Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + getFragment());
        return;
    L119:
        return;
    L98:
        this.mMovingToState = true;     // Catch: Throwable -> L95
        boolean r4 = false;
    L10:
        int r5 = computeExpectedState();     // Catch: Throwable -> L95
        if (r5 == this.mFragment.mState) goto L63;
        if (r5 <= this.mFragment.mState) goto L31;
        switch((this.mFragment.mState + 1)) {
            case 0: goto L29;
            case 1: goto L28;
            case 2: goto L27;
            case 3: goto L26;
            case 4: goto L21;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L17;
            default: goto L62;
        };     // Catch: Throwable -> L95
    L17:
        resume();     // Catch: Throwable -> L95
        goto L62
    L18:
        this.mFragment.mState = 6;     // Catch: Throwable -> L95
        goto L62
    L19:
        start();     // Catch: Throwable -> L95
        goto L62
    L26:
        activityCreated();     // Catch: Throwable -> L95
        goto L62
    L27:
        ensureInflatedView();     // Catch: Throwable -> L95
        createView();     // Catch: Throwable -> L95
        goto L62
    L28:
        create();     // Catch: Throwable -> L95
        goto L62
    L29:
        attach();     // Catch: Throwable -> L95
    L62:
        r4 = true;
        goto L10
    L21:
        if (this.mFragment.mView != null) goto L23;
    L25:
        this.mFragment.mState = 4;     // Catch: Throwable -> L95
        goto L62
    L23:
        if (this.mFragment.mContainer == null) goto L25;
        SpecialEffectsController.getOrCreateController(this.mFragment.mContainer, this.mFragment.getParentFragmentManager()).enqueueAdd(SpecialEffectsController.Operation.State.from(this.mFragment.mView.getVisibility()), this);     // Catch: Throwable -> L95
        goto L25
    L31:
        switch((this.mFragment.mState - 1)) {
            case -1: goto L61;
            case 0: goto L56;
            case 1: goto L54;
            case 2: goto L53;
            case 3: goto L37;
            case 4: goto L35;
            case 5: goto L34;
            case 6: goto L33;
            default: goto L62;
        };     // Catch: Throwable -> L95
    L33:
        pause();     // Catch: Throwable -> L95
        goto L62
    L34:
        this.mFragment.mState = 5;     // Catch: Throwable -> L95
        goto L62
    L35:
        stop();     // Catch: Throwable -> L95
        goto L62
    L53:
        this.mFragment.mInLayout = false;     // Catch: Throwable -> L95
        this.mFragment.mState = 2;     // Catch: Throwable -> L95
        goto L62
    L54:
        destroyFragmentView();     // Catch: Throwable -> L95
        this.mFragment.mState = 1;     // Catch: Throwable -> L95
        goto L62
    L61:
        detach();     // Catch: Throwable -> L95
        goto L62
    L37:
        if (FragmentManager.isLoggingEnabled(3) == false) goto L40;
        Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.mFragment);     // Catch: Throwable -> L95
    L40:
        if (this.mFragment.mBeingSaved == false) goto L43;
        this.mFragmentStore.setSavedState(this.mFragment.mWho, saveState());     // Catch: Throwable -> L95
    L48:
        if (this.mFragment.mView != null) goto L50;
    L52:
        this.mFragment.mState = 3;     // Catch: Throwable -> L95
        goto L62
    L50:
        if (this.mFragment.mContainer == null) goto L52;
        SpecialEffectsController.getOrCreateController(this.mFragment.mContainer, this.mFragment.getParentFragmentManager()).enqueueRemove(this);     // Catch: Throwable -> L95
        goto L52
    L43:
        if (this.mFragment.mView == null) goto L48;
        if (this.mFragment.mSavedViewState != null) goto L48;
        saveViewState();     // Catch: Throwable -> L95
        goto L48
    L56:
        if (this.mFragment.mBeingSaved == true) goto L58;
    L60:
        destroy();     // Catch: Throwable -> L95
        goto L62
    L58:
        if (this.mFragmentStore.getSavedState(this.mFragment.mWho) != null) goto L60;
        this.mFragmentStore.setSavedState(this.mFragment.mWho, saveState());     // Catch: Throwable -> L95
        goto L60
    L63:
        if (r4 == true) goto L80;
        if (this.mFragment.mState != (-1)) goto L80;
        if (this.mFragment.mRemoving == false) goto L80;
        if (this.mFragment.isInBackStack() == true) goto L80;
        if (this.mFragment.mBeingSaved == true) goto L80;
        if (FragmentManager.isLoggingEnabled(3) == false) goto L75;
        Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + this.mFragment);     // Catch: Throwable -> L95
    L75:
        this.mFragmentStore.getNonConfig().clearNonConfigState(this.mFragment, true);     // Catch: Throwable -> L95
        this.mFragmentStore.makeInactive(this);     // Catch: Throwable -> L95
        if (FragmentManager.isLoggingEnabled(3) == false) goto L78;
        Log.d("FragmentManager", "initState called for fragment: " + this.mFragment);     // Catch: Throwable -> L95
    L78:
        this.mFragment.initState();     // Catch: Throwable -> L95
    L80:
        if (this.mFragment.mHiddenChanged == true) goto L82;
    L93:
        this.mMovingToState = false;
        return;
    L82:
        if (this.mFragment.mView == null) goto L90;
        if (this.mFragment.mContainer == null) goto L90;
        SpecialEffectsController r1 = SpecialEffectsController.getOrCreateController(this.mFragment.mContainer, this.mFragment.getParentFragmentManager());     // Catch: Throwable -> L95
        if (this.mFragment.mHidden == false) goto L88;
        r1.enqueueHide(this);     // Catch: Throwable -> L95
        goto L90
    L88:
        r1.enqueueShow(this);     // Catch: Throwable -> L95
    L90:
        if (this.mFragment.mFragmentManager == null) goto L92;
        this.mFragment.mFragmentManager.invalidateMenuForFragment(this.mFragment);     // Catch: Throwable -> L95
    L92:
        this.mFragment.mHiddenChanged = false;     // Catch: Throwable -> L95
        Fragment r2 = this.mFragment;     // Catch: Throwable -> L95
        r2.onHiddenChanged(r2.mHidden);     // Catch: Throwable -> L95
        this.mFragment.mChildFragmentManager.dispatchOnHiddenChanged();     // Catch: Throwable -> L95
    L95:
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
        if (FragmentManager.isLoggingEnabled(3) == false) goto L12;
        Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.mFragment);
    L12:
        if (this.mFragment.mSavedFragmentState == null) goto L14;
        Bundle r0 = this.mFragment.mSavedFragmentState.getBundle(SAVED_INSTANCE_STATE_KEY);
    L15:
        Fragment r2 = this.mFragment;
        r2.performCreateView(r2.performGetLayoutInflater(r0), null, r0);
        if (this.mFragment.mView == null) goto L25;
        this.mFragment.mView.setSaveFromParentEnabled(false);
        this.mFragment.mView.setTag(R.id.fragment_container_view_tag, this.mFragment);
        if (this.mFragment.mHidden == false) goto L20;
        this.mFragment.mView.setVisibility(8);
    L20:
        this.mFragment.performViewCreated();
        FragmentLifecycleCallbacksDispatcher r1 = this.mDispatcher;
        Fragment r3 = this.mFragment;
        r1.dispatchOnFragmentViewCreated(r3, r3.mView, r0, false);
        this.mFragment.mState = 2;
        return;
    L25:
        return;
    L14:
        r0 = null;
        goto L15
    }

    void restoreState(ClassLoader r3) {
        if (this.mFragment.mSavedFragmentState != null) goto L5;
        return;
    L5:
        this.mFragment.mSavedFragmentState.setClassLoader(r3);
        if (this.mFragment.mSavedFragmentState.getBundle(SAVED_INSTANCE_STATE_KEY) != null) goto L8;
        this.mFragment.mSavedFragmentState.putBundle(SAVED_INSTANCE_STATE_KEY, new Bundle());
    L8:
        Fragment r4 = this.mFragment;
        r4.mSavedViewState = r4.mSavedFragmentState.getSparseParcelableArray(VIEW_STATE_KEY);
        Fragment r5 = this.mFragment;
        r5.mSavedViewRegistryState = r5.mSavedFragmentState.getBundle(VIEW_REGISTRY_STATE_KEY);
        FragmentState r6 = (FragmentState) this.mFragment.mSavedFragmentState.getParcelable("state");
        if (r6 == null) goto L15;
        Fragment r0 = this.mFragment;
        r0.mTargetWho = r6.mTargetWho;
        Fragment r1 = this.mFragment;
        r1.mTargetRequestCode = r6.mTargetRequestCode;
        if (this.mFragment.mSavedUserVisibleHint == null) goto L13;
        Fragment r7 = this.mFragment;
        r7.mUserVisibleHint = r7.mSavedUserVisibleHint.booleanValue();
        this.mFragment.mSavedUserVisibleHint = null;
        goto L15
    L13:
        Fragment r2 = this.mFragment;
        r2.mUserVisibleHint = r6.mUserVisibleHint;
    L15:
        if (this.mFragment.mUserVisibleHint == true) goto L18;
        this.mFragment.mDeferStart = true;
        return;
    }

    void attach() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d("FragmentManager", "moveto ATTACHED: " + this.mFragment);
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
        if (r4 == null) goto L21;
        r4.moveToExpectedState();
    L21:
        Fragment r2 = this.mFragment;
        r2.mHost = r2.mFragmentManager.getHost();
        Fragment r3 = this.mFragment;
        r3.mParentFragment = r3.mFragmentManager.getParent();
        this.mDispatcher.dispatchOnFragmentPreAttached(this.mFragment, false);
        this.mFragment.performAttach();
        this.mDispatcher.dispatchOnFragmentAttached(this.mFragment, false);
        return;
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
        Log.d("FragmentManager", "moveto CREATED: " + this.mFragment);
    L6:
        if (this.mFragment.mSavedFragmentState == null) goto L8;
        Bundle r0 = this.mFragment.mSavedFragmentState.getBundle(SAVED_INSTANCE_STATE_KEY);
    L10:
        if (this.mFragment.mIsCreated == true) goto L12;
        this.mDispatcher.dispatchOnFragmentPreCreated(this.mFragment, r0, false);
        this.mFragment.performCreate(r0);
        this.mDispatcher.dispatchOnFragmentCreated(this.mFragment, r0, false);
        return;
    L12:
        this.mFragment.mState = 1;
        this.mFragment.restoreChildFragmentState();
        return;
    L8:
        r0 = null;
        goto L10
    }

    void createView() {
        if (this.mFragment.mFromLayout == false) goto L6;
        return;
    L6:
        if (FragmentManager.isLoggingEnabled(3) == false) goto L8;
        Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.mFragment);
    L8:
        ViewGroup r3 = null;
        if (this.mFragment.mSavedFragmentState == null) goto L11;
        Bundle r1 = this.mFragment.mSavedFragmentState.getBundle(SAVED_INSTANCE_STATE_KEY);
    L12:
        LayoutInflater r4 = this.mFragment.performGetLayoutInflater(r1);
        if (this.mFragment.mContainer == null) goto L16;
        r3 = this.mFragment.mContainer;
    L34:
        this.mFragment.mContainer = r3;
        this.mFragment.performCreateView(r4, r3, r1);
        if (this.mFragment.mView != null) goto L37;
    L58:
        this.mFragment.mState = 2;
        return;
    L37:
        if (FragmentManager.isLoggingEnabled(3) == false) goto L39;
        Log.d("FragmentManager", "moveto VIEW_CREATED: " + this.mFragment);
    L39:
        this.mFragment.mView.setSaveFromParentEnabled(false);
        this.mFragment.mView.setTag(R.id.fragment_container_view_tag, this.mFragment);
        if (r3 == null) goto L43;
        addViewToContainer();
    L43:
        if (this.mFragment.mHidden == false) goto L46;
        this.mFragment.mView.setVisibility(8);
    L46:
        if (ViewCompat.isAttachedToWindow(this.mFragment.mView) == false) goto L48;
        ViewCompat.requestApplyInsets(this.mFragment.mView);
    L49:
        this.mFragment.performViewCreated();
        FragmentLifecycleCallbacksDispatcher r0 = this.mDispatcher;
        Fragment r5 = this.mFragment;
        r0.dispatchOnFragmentViewCreated(r5, r5.mView, r1, false);
        int r2 = this.mFragment.mView.getVisibility();
        this.mFragment.setPostOnViewCreatedAlpha(this.mFragment.mView.getAlpha());
        if (this.mFragment.mContainer == null) goto L58;
        if (r2 != 0) goto L58;
        View r6 = this.mFragment.mView.findFocus();
        if (r6 == null) goto L57;
        this.mFragment.setFocusedView(r6);
        if (FragmentManager.isLoggingEnabled(2) == false) goto L57;
        Log.v("FragmentManager", "requestFocus: Saved focused view " + r6 + " for Fragment " + this.mFragment);
    L57:
        this.mFragment.mView.setAlpha(0.0f);
        goto L58
    L48:
        final View r7 = this.mFragment.mView;
        r7.addOnAttachStateChangeListener(new AnonymousClass1(this, r7));
        goto L49
    L16:
        if (this.mFragment.mContainerId == 0) goto L34;
        if (this.mFragment.mContainerId == (-1)) goto L33;
        r3 = (ViewGroup) this.mFragment.mFragmentManager.getContainer().onFindViewById(this.mFragment.mContainerId);
        if (r3 != null) goto L30;
        if (this.mFragment.mRestored == true) goto L34;
        String r8 = this.mFragment.getResources().getResourceName(this.mFragment.mContainerId);     // Catch: Resources.NotFoundException -> L26
    L28:
        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.mFragment.mContainerId) + " (" + r8 + ") for fragment " + this.mFragment);
    L26:
        r8 = EnvironmentCompat.MEDIA_UNKNOWN;
        goto L28
    L30:
        if ((r3 instanceof FragmentContainerView) == true) goto L34;
        FragmentStrictMode.onWrongFragmentContainer(this.mFragment, r3);
        goto L34
    L33:
        throw new IllegalArgumentException("Cannot create fragment " + this.mFragment + " for a container view with no id");
    L11:
        r1 = null;
        goto L12
    }

    void activityCreated() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L6;
        Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.mFragment);
    L6:
        if (this.mFragment.mSavedFragmentState == null) goto L8;
        Bundle r0 = this.mFragment.mSavedFragmentState.getBundle(SAVED_INSTANCE_STATE_KEY);
    L9:
        this.mFragment.performActivityCreated(r0);
        this.mDispatcher.dispatchOnFragmentActivityCreated(this.mFragment, r0, false);
        return;
    L8:
        r0 = null;
        goto L9
    }

    void start() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d("FragmentManager", "moveto STARTED: " + this.mFragment);
    L5:
        this.mFragment.performStart();
        this.mDispatcher.dispatchOnFragmentStarted(this.mFragment, false);
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
        this.mFragmentStore.setSavedState(this.mFragment.mWho, null);
        this.mFragment.mSavedFragmentState = null;
        this.mFragment.mSavedViewState = null;
        this.mFragment.mSavedViewRegistryState = null;
        return;
    L8:
        if (isFragmentViewChild(r0) == false) goto L16;
        boolean r2 = r0.requestFocus();
        if (FragmentManager.isLoggingEnabled(2) == false) goto L16;
        StringBuilder r1 = new StringBuilder("requestFocus: Restoring focused view ").append(r0).append(HanziToPinyin.Token.SEPARATOR);
        if (r2 == false) goto L14;
        String r3 = "succeeded";
    L15:
        Log.v("FragmentManager", r1.append(r3).append(" on Fragment ").append(this.mFragment).append(" resulting in focused view ").append(this.mFragment.mView.findFocus()).toString());
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
        Log.d("FragmentManager", "movefrom RESUMED: " + this.mFragment);
    L5:
        this.mFragment.performPause();
        this.mDispatcher.dispatchOnFragmentPaused(this.mFragment, false);
    }

    void stop() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d("FragmentManager", "movefrom STARTED: " + this.mFragment);
    L5:
        this.mFragment.performStop();
        this.mDispatcher.dispatchOnFragmentStopped(this.mFragment, false);
    }

    Bundle saveState() {
        Bundle r0 = new Bundle();
        if (this.mFragment.mState == (-1)) goto L5;
    L7:
        r0.putParcelable("state", new FragmentState(this.mFragment));
        if (this.mFragment.mState <= (-1)) goto L28;
        Bundle r1 = new Bundle();
        this.mFragment.performSaveInstanceState(r1);
        if (r1.isEmpty() == true) goto L12;
        r0.putBundle(SAVED_INSTANCE_STATE_KEY, r1);
    L12:
        this.mDispatcher.dispatchOnFragmentSaveInstanceState(this.mFragment, r1, false);
        Bundle r2 = new Bundle();
        this.mFragment.mSavedStateRegistryController.performSave(r2);
        if (r2.isEmpty() == true) goto L15;
        r0.putBundle(REGISTRY_STATE_KEY, r2);
    L15:
        Bundle r3 = this.mFragment.mChildFragmentManager.saveAllStateInternal();
        if (r3.isEmpty() == true) goto L19;
        r0.putBundle(CHILD_FRAGMENT_MANAGER_KEY, r3);
    L19:
        if (this.mFragment.mView == null) goto L22;
        saveViewState();
    L22:
        if (this.mFragment.mSavedViewState == null) goto L25;
        r0.putSparseParcelableArray(VIEW_STATE_KEY, this.mFragment.mSavedViewState);
    L25:
        if (this.mFragment.mSavedViewRegistryState == null) goto L28;
        r0.putBundle(VIEW_REGISTRY_STATE_KEY, this.mFragment.mSavedViewRegistryState);
    L28:
        if (this.mFragment.mArguments == null) goto L30;
        r0.putBundle(ARGUMENTS_KEY, this.mFragment.mArguments);
    L30:
        return r0;
    L5:
        if (this.mFragment.mSavedFragmentState == null) goto L7;
        r0.putAll(this.mFragment.mSavedFragmentState);
        goto L7
    }

    Fragment.SavedState saveInstanceState() {
        if (this.mFragment.mState > (-1)) goto L5;
        return null;
    L5:
        return new Fragment.SavedState(saveState());
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

    void destroyFragmentView() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L6;
        Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.mFragment);
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
        Log.d("FragmentManager", "movefrom CREATED: " + this.mFragment);
    L5:
        boolean r1 = true;
        if (this.mFragment.mRemoving == true) goto L8;
    L10:
        boolean r0 = false;
    L12:
        if (r0 == true) goto L14;
    L16:
        if (r0 == false) goto L18;
    L21:
        boolean r4 = true;
    L22:
        if (r4 == false) goto L47;
        FragmentHostCallback<?> r5 = this.mFragment.mHost;
        if ((r5 instanceof ViewModelStoreOwner) == false) goto L27;
        r1 = this.mFragmentStore.getNonConfig().isCleared();
    L29:
        if (r0 == true) goto L31;
    L32:
        if (r1 == false) goto L34;
    L33:
        this.mFragmentStore.getNonConfig().clearNonConfigState(this.mFragment, false);
    L34:
        this.mFragment.performDestroy();
        this.mDispatcher.dispatchOnFragmentDestroyed(this.mFragment, false);
        Iterator<FragmentStateManager> r2 = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
    L36:
        if (r2.hasNext() == false) goto L43;
        FragmentStateManager r3 = r2.next();
        if (r3 == null) goto L36;
        Fragment r6 = r3.getFragment();
        if (this.mFragment.mWho.equals(r6.mTargetWho) == false) goto L36;
        r6.mTarget = this.mFragment;
        r6.mTargetWho = null;
        goto L36
    L43:
        if (this.mFragment.mTargetWho == null) goto L45;
        Fragment r7 = this.mFragment;
        r7.mTarget = this.mFragmentStore.findActiveFragment(r7.mTargetWho);
    L45:
        this.mFragmentStore.makeInactive(this);
        return;
    L31:
        if (this.mFragment.mBeingSaved == false) goto L33;
    L27:
        if ((r5.getContext() instanceof Activity) == false) goto L29;
        r1 = true ^ ((Activity) r5.getContext()).isChangingConfigurations();
        goto L29
    L47:
        if (this.mFragment.mTargetWho == null) goto L53;
        Fragment r8 = this.mFragmentStore.findActiveFragment(this.mFragment.mTargetWho);
        if (r8 == null) goto L53;
        if (r8.mRetainInstance == false) goto L53;
        this.mFragment.mTarget = r8;
    L53:
        this.mFragment.mState = 0;
        return;
    L18:
        if (this.mFragmentStore.getNonConfig().shouldDestroy(this.mFragment) == true) goto L21;
        r4 = false;
        goto L22
    L14:
        if (this.mFragment.mBeingSaved == true) goto L16;
        this.mFragmentStore.setSavedState(this.mFragment.mWho, null);
        goto L16
    L8:
        if (this.mFragment.isInBackStack() == true) goto L10;
        r0 = true;
        goto L12
    }

    void detach() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d("FragmentManager", "movefrom ATTACHED: " + this.mFragment);
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
        Log.d("FragmentManager", "initState called for fragment: " + this.mFragment);
    L16:
        this.mFragment.initState();
        return;
    L8:
        if (this.mFragment.isInBackStack() == true) goto L10;
        r4 = true;
        goto L10
    }

    void addViewToContainer() {
        Fragment r0 = FragmentManager.findViewFragment(this.mFragment.mContainer);
        Fragment r1 = this.mFragment.getParentFragment();
        if (r0 != null) goto L5;
    L7:
        int r2 = this.mFragmentStore.findFragmentIndexInContainer(this.mFragment);
        this.mFragment.mContainer.addView(this.mFragment.mView, r2);
        return;
    L5:
        if (r0.equals(r1) == true) goto L7;
        Fragment r3 = this.mFragment;
        FragmentStrictMode.onWrongNestedHierarchy(r3, r0, r3.mContainerId);
        goto L7
    }
}
