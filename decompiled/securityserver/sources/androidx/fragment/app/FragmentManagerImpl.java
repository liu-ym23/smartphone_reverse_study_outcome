package androidx.fragment.app;

import a.a;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import androidx.core.os.EnvironmentCompat;
import androidx.core.util.DebugUtils;
import androidx.core.util.LogWriter;
import androidx.core.view.OneShotPreDrawListener;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
final class FragmentManagerImpl extends FragmentManager implements LayoutInflater.Factory2 {
    static final int ANIM_DUR = 220;
    public static final int ANIM_STYLE_CLOSE_ENTER = 3;
    public static final int ANIM_STYLE_CLOSE_EXIT = 4;
    public static final int ANIM_STYLE_FADE_ENTER = 5;
    public static final int ANIM_STYLE_FADE_EXIT = 6;
    public static final int ANIM_STYLE_OPEN_ENTER = 1;
    public static final int ANIM_STYLE_OPEN_EXIT = 2;
    static boolean DEBUG = false;
    static final Interpolator DECELERATE_CUBIC = null;
    static final Interpolator DECELERATE_QUINT = null;
    static final String TAG = "FragmentManager";
    static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    static final String TARGET_STATE_TAG = "android:target_state";
    static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
    static final String VIEW_STATE_TAG = "android:view_state";
    final HashMap<String, Fragment> mActive;
    final ArrayList<Fragment> mAdded;
    ArrayList<Integer> mAvailBackStackIndices;
    ArrayList<BackStackRecord> mBackStack;
    ArrayList<FragmentManager.OnBackStackChangedListener> mBackStackChangeListeners;
    ArrayList<BackStackRecord> mBackStackIndices;
    FragmentContainer mContainer;
    ArrayList<Fragment> mCreatedMenus;
    int mCurState;
    boolean mDestroyed;
    Runnable mExecCommit;
    boolean mExecutingActions;
    boolean mHavePendingDeferredStart;
    FragmentHostCallback mHost;
    private final CopyOnWriteArrayList<FragmentLifecycleCallbacksHolder> mLifecycleCallbacks;
    boolean mNeedMenuInvalidate;
    int mNextFragmentIndex;
    private FragmentManagerViewModel mNonConfig;
    private final OnBackPressedCallback mOnBackPressedCallback;
    private OnBackPressedDispatcher mOnBackPressedDispatcher;
    Fragment mParent;
    ArrayList<OpGenerator> mPendingActions;
    ArrayList<StartEnterTransitionListener> mPostponedTransactions;

    @Nullable
    Fragment mPrimaryNav;
    SparseArray<Parcelable> mStateArray;
    Bundle mStateBundle;
    boolean mStateSaved;
    boolean mStopped;
    ArrayList<Fragment> mTmpAddedFragments;
    ArrayList<Boolean> mTmpIsPop;
    ArrayList<BackStackRecord> mTmpRecords;

    public static class AnimationOrAnimator {
        public final Animation animation;
        public final Animator animator;

        public AnimationOrAnimator(Animation r2) {
            this.animation = r2;
            this.animator = null;
            if (r2 == null) goto L6;
            return;
        L6:
            throw new IllegalStateException("Animation cannot be null");
        }

        public AnimationOrAnimator(Animator r2) {
            this.animation = null;
            this.animator = r2;
            if (r2 == null) goto L6;
            return;
        L6:
            throw new IllegalStateException("Animator cannot be null");
        }
    }

    public static class EndViewTransitionAnimation extends AnimationSet implements Runnable {
        private boolean mAnimating;
        private final View mChild;
        private boolean mEnded;
        private final ViewGroup mParent;
        private boolean mTransitionEnded;

        public EndViewTransitionAnimation(@NonNull Animation r2, @NonNull ViewGroup r3, @NonNull View r4) {
            super(false);
            this.mAnimating = true;
            this.mParent = r3;
            this.mChild = r4;
            addAnimation(r2);
            r3.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long r3, Transformation r5) {
            this.mAnimating = true;
            if (this.mEnded == false) goto L7;
            return !this.mTransitionEnded;
        L7:
            if (super.getTransformation(r3, r5) == true) goto L9;
            this.mEnded = true;
            OneShotPreDrawListener.add(this.mParent, this);
        L9:
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mEnded == false) goto L5;
        L7:
            this.mParent.endViewTransition(this.mChild);
            this.mTransitionEnded = true;
            return;
        L5:
            if (this.mAnimating == false) goto L7;
            this.mAnimating = false;
            this.mParent.post(this);
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long r3, Transformation r5, float r6) {
            this.mAnimating = true;
            if (this.mEnded == false) goto L7;
            return !this.mTransitionEnded;
        L7:
            if (super.getTransformation(r3, r5, r6) == true) goto L9;
            this.mEnded = true;
            OneShotPreDrawListener.add(this.mParent, this);
        L9:
            return true;
        }
    }

    public static final class FragmentLifecycleCallbacksHolder {
        final FragmentManager.FragmentLifecycleCallbacks mCallback;
        final boolean mRecursive;

        public FragmentLifecycleCallbacksHolder(FragmentManager.FragmentLifecycleCallbacks r1, boolean r2) {
            this.mCallback = r1;
            this.mRecursive = r2;
        }
    }

    public static class FragmentTag {
        public static final int[] Fragment = null;
        public static final int Fragment_id = 1;
        public static final int Fragment_name = 0;
        public static final int Fragment_tag = 2;

        static {
            Fragment = new int[]{R.attr.name, R.attr.id, R.attr.tag};
        }

        private FragmentTag() {
        }
    }

    public interface OpGenerator {
        boolean generateOps(ArrayList<BackStackRecord> r1, ArrayList<Boolean> r2);
    }

    public class PopBackStackState implements OpGenerator {
        final int mFlags;
        final int mId;
        final String mName;
        final /* synthetic */ FragmentManagerImpl this$0;

        public PopBackStackState(FragmentManagerImpl r1, String r2, int r3, int r4) {
            this.this$0 = r1;
            this.mName = r2;
            this.mId = r3;
            this.mFlags = r4;
        }

        @Override // androidx.fragment.app.FragmentManagerImpl.OpGenerator
        public boolean generateOps(ArrayList<BackStackRecord> r7, ArrayList<Boolean> r8) {
            Fragment r0 = this.this$0.mPrimaryNav;
            if (r0 == null) goto L13;
            if (this.mId >= 0) goto L13;
            if (this.mName != null) goto L13;
            if (r0.getChildFragmentManager().popBackStackImmediate() == false) goto L13;
            return false;
        L13:
            return this.this$0.popBackStackState(r7, r8, this.mName, this.mId, this.mFlags);
        }
    }

    public static class StartEnterTransitionListener implements Fragment.OnStartEnterTransitionListener {
        final boolean mIsBack;
        private int mNumPostponed;
        final BackStackRecord mRecord;

        public StartEnterTransitionListener(BackStackRecord r1, boolean r2) {
            this.mIsBack = r2;
            this.mRecord = r1;
        }

        public void cancelTransaction() {
            BackStackRecord r0 = this.mRecord;
            r0.mManager.completeExecute(r0, this.mIsBack, false, false);
        }

        public void completeTransaction() {
            int r1 = 0;
            if (this.mNumPostponed <= 0) goto L5;
            boolean r0 = true;
        L6:
            FragmentManagerImpl r3 = this.mRecord.mManager;
            int r4 = r3.mAdded.size();
        L7:
            if (r1 >= r4) goto L14;
            Fragment r5 = r3.mAdded.get(r1);
            r5.setOnStartEnterTransitionListener(null);
            if (r0 == false) goto L13;
            if (r5.isPostponed() == false) goto L13;
            r5.startPostponedEnterTransition();
        L13:
            r1 = r1 + 1;
            goto L7
        L14:
            BackStackRecord r2 = this.mRecord;
            r2.mManager.completeExecute(r2, this.mIsBack, !r0, true);
            return;
        L5:
            r0 = false;
            goto L6
        }

        public boolean isReady() {
            if (this.mNumPostponed != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.fragment.app.Fragment.OnStartEnterTransitionListener
        public void onStartEnterTransition() {
            int r0 = this.mNumPostponed - 1;
            this.mNumPostponed = r0;
            if (r0 == 0) goto L5;
            return;
        L5:
            this.mRecord.mManager.scheduleCommit();
        }

        @Override // androidx.fragment.app.Fragment.OnStartEnterTransitionListener
        public void startListening() {
            this.mNumPostponed++;
        }
    }

    static {
        DECELERATE_QUINT = new DecelerateInterpolator(2.5f);
        DECELERATE_CUBIC = new DecelerateInterpolator(1.5f);
    }

    public FragmentManagerImpl() {
        final boolean r0 = false;
        this.mNextFragmentIndex = 0;
        this.mAdded = new ArrayList();
        this.mActive = new HashMap();
        this.mOnBackPressedCallback = new AnonymousClass1(this, r0);
        this.mLifecycleCallbacks = new CopyOnWriteArrayList();
        this.mCurState = 0;
        this.mStateBundle = null;
        this.mStateArray = null;
        this.mExecCommit = new AnonymousClass2(this);
    }

    private void addAddedFragments(ArraySet<Fragment> r11) {
        int r0 = this.mCurState;
        if (r0 >= 1) goto L5;
        return;
    L5:
        int r1 = Math.min(r0, 3);
        int r2 = this.mAdded.size();
        int r8 = 0;
    L6:
        if (r8 >= r2) goto L17;
        Fragment r9 = this.mAdded.get(r8);
        if (r9.mState >= r1) goto L16;
        moveToState(r9, r1, r9.getNextAnim(), r9.getNextTransition(), false);
        if (r9.mView == null) goto L16;
        if (r9.mHidden == true) goto L16;
        if (r9.mIsNewlyAdded == false) goto L16;
        r11.add(r9);
    L16:
        r8 = r8 + 1;
        goto L6
    }

    private void animateRemoveFragment(@NonNull final Fragment r3, @NonNull AnimationOrAnimator r4, int r5) {
        final View r0 = r3.mView;
        final ViewGroup r1 = r3.mContainer;
        r1.startViewTransition(r0);
        r3.setStateAfterAnimating(r5);
        if (r4.animation == null) goto L5;
        EndViewTransitionAnimation r6 = new EndViewTransitionAnimation(r4.animation, r1, r0);
        r3.setAnimatingAway(r3.mView);
        r6.setAnimationListener(new AnonymousClass3(this, r1, r3));
        r3.mView.startAnimation(r6);
        return;
    L5:
        Animator r7 = r4.animator;
        r3.setAnimator(r7);
        r7.addListener(new AnonymousClass4(this, r1, r0, r3));
        r7.setTarget(r3.mView);
        r7.start();
    }

    private void burpActive() {
        this.mActive.values().removeAll(Collections.singleton(null));
    }

    private void checkStateLoss() {
        if (isStateSaved() == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }

    private void cleanupExec() {
        this.mExecutingActions = false;
        this.mTmpIsPop.clear();
        this.mTmpRecords.clear();
    }

    private void dispatchParentPrimaryNavigationFragmentChanged(@Nullable Fragment r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (this.mActive.get(r2.mWho) != r2) goto L8;
        r2.performPrimaryNavigationFragmentChanged();
        return;
    }

    private void dispatchStateChange(int r3) {
        this.mExecutingActions = true;     // Catch: Throwable -> L6
        moveToState(r3, false);     // Catch: Throwable -> L6
        this.mExecutingActions = false;
        execPendingActions();
        return;
    L6:
        th = move-exception;
        this.mExecutingActions = false;
        throw th;
    }

    private void endAnimatingAwayFragments() {
        Iterator<Fragment> r0 = this.mActive.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L16;
        Fragment r3 = r0.next();
        if (r3 == null) goto L4;
        if (r3.getAnimatingAway() != null) goto L9;
        if (r3.getAnimator() == null) goto L4;
        r3.getAnimator().end();
        goto L4
    L9:
        int r4 = r3.getStateAfterAnimating();
        View r1 = r3.getAnimatingAway();
        Animation r2 = r1.getAnimation();
        if (r2 == null) goto L12;
        r2.cancel();
        r1.clearAnimation();
    L12:
        r3.setAnimatingAway(null);
        moveToState(r3, r4, 0, 0, false);
        goto L4
    }

    private void ensureExecReady(boolean r3) {
        if (this.mExecutingActions == true) goto L25;
        if (this.mHost == null) goto L23;
        if (Looper.myLooper() != this.mHost.getHandler().getLooper()) goto L21;
        if (r3 == true) goto L11;
        checkStateLoss();
    L11:
        if (this.mTmpRecords != null) goto L13;
        this.mTmpRecords = new ArrayList();
        this.mTmpIsPop = new ArrayList();
    L13:
        this.mExecutingActions = true;
        executePostponedTransaction(null, null);     // Catch: Throwable -> L17
        this.mExecutingActions = false;
        return;
    L17:
        th = move-exception;
        this.mExecutingActions = false;
        throw th;
    L21:
        throw new IllegalStateException("Must be called from main thread of fragment host");
    L23:
        throw new IllegalStateException("Fragment host has been destroyed");
    L25:
        throw new IllegalStateException("FragmentManager is already executing transactions");
    }

    private static void executeOps(ArrayList<BackStackRecord> r3, ArrayList<Boolean> r4, int r5, int r6) {
    L2:
        if (r5 >= r6) goto L12;
        BackStackRecord r0 = r3.get(r5);
        boolean r2 = true;
        if (r4.get(r5).booleanValue() == false) goto L10;
        r0.bumpBackStackNesting(-1);
        if (r5 == (r6 - 1)) goto L9;
        r2 = false;
    L9:
        r0.executePopOps(r2);
    L11:
        r5 = r5 + 1;
        goto L2
    L10:
        r0.bumpBackStackNesting(1);
        r0.executeOps();
        goto L11
    }

    private void executeOpsTogether(ArrayList<BackStackRecord> r16, ArrayList<Boolean> r17, int r18, int r19) {
        int r9 = r18;
        boolean r11 = r16.get(r9).mReorderingAllowed;
        ArrayList<Fragment> r0 = this.mTmpAddedFragments;
        if (r0 != null) goto L5;
        this.mTmpAddedFragments = new ArrayList();
    L6:
        this.mTmpAddedFragments.addAll(this.mAdded);
        Fragment r1 = getPrimaryNavigationFragment();
        boolean r12 = false;
        int r2 = r9;
    L8:
        if (r2 >= r19) goto L20;
        BackStackRecord r3 = r16.get(r2);
        if (r17.get(r2).booleanValue() == true) goto L12;
        r1 = r3.expandOps(this.mTmpAddedFragments, r1);
    L13:
        if (r12 == false) goto L15;
    L18:
        r12 = true;
    L19:
        r2 = r2 + 1;
        goto L8
    L15:
        if (r3.mAddToBackStack == true) goto L18;
        r12 = false;
        goto L19
    L12:
        r1 = r3.trackAddedFragmentsInPop(this.mTmpAddedFragments, r1);
        goto L13
    L20:
        this.mTmpAddedFragments.clear();
        if (r11 == true) goto L23;
        FragmentTransition.startTransitions(this, r16, r17, r18, r19, false);
    L23:
        executeOps(r16, r17, r18, r19);
        if (r11 == false) goto L26;
        ArraySet<Fragment> r14 = new ArraySet();
        addAddedFragments(r14);
        int r4 = postponePostponableTransactions(r16, r17, r18, r19, r14);
        makeRemovedFragmentsInvisible(r14);
        int r5 = r4;
    L27:
        if (r5 == r9) goto L30;
        if (r11 == false) goto L30;
        FragmentTransition.startTransitions(this, r16, r17, r18, r5, true);
        moveToState(this.mCurState, true);
    L30:
        if (r9 >= r19) goto L37;
        BackStackRecord r6 = r16.get(r9);
        if (r17.get(r9).booleanValue() == false) goto L36;
        int r7 = r6.mIndex;
        if (r7 < 0) goto L36;
        freeBackStackIndex(r7);
        r6.mIndex = -1;
    L36:
        r6.runOnCommitRunnables();
        r9 = r9 + 1;
        goto L30
    L37:
        if (r12 == false) goto L48;
        reportBackStackChanged();
        return;
    L48:
        return;
    L26:
        r5 = r19;
        goto L27
    L5:
        r0.clear();
        goto L6
    }

    private void executePostponedTransaction(ArrayList<BackStackRecord> r8, ArrayList<Boolean> r9) {
        ArrayList<StartEnterTransitionListener> r0 = this.mPostponedTransactions;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L33;
        StartEnterTransitionListener r3 = this.mPostponedTransactions.get(r2);
        if (r8 == null) goto L18;
        if (r3.mIsBack == true) goto L18;
        int r5 = r8.indexOf(r3.mRecord);
        if (r5 == (-1)) goto L18;
        if (r9.get(r5).booleanValue() == false) goto L18;
        this.mPostponedTransactions.remove(r2);
        r2 = r2 - 1;
        r1 = r1 - 1;
        r3.cancelTransaction();
    L32:
        r2 = r2 + 1;
    L18:
        if (r3.isReady() == true) goto L22;
        if (r8 == null) goto L32;
        if (r3.mRecord.interactsWith(r8, 0, r8.size()) == false) goto L32;
    L22:
        this.mPostponedTransactions.remove(r2);
        r2 = r2 - 1;
        r1 = r1 - 1;
        if (r8 != null) goto L25;
    L31:
        r3.completeTransaction();
        goto L32
    L25:
        if (r3.mIsBack == true) goto L31;
        int r6 = r8.indexOf(r3.mRecord);
        if (r6 == (-1)) goto L31;
        if (r9.get(r6).booleanValue() == false) goto L31;
        r3.cancelTransaction();
        goto L32
    L33:
        return;
    L5:
        r1 = r0.size();
        goto L6
    }

    private Fragment findFragmentUnder(Fragment r5) {
        ViewGroup r0 = r5.mContainer;
        View r1 = r5.mView;
        if (r0 == null) goto L14;
        if (r1 == null) goto L14;
        int r6 = this.mAdded.indexOf(r5) - 1;
    L7:
        if (r6 < 0) goto L14;
        Fragment r2 = this.mAdded.get(r6);
        if (r2.mContainer != r0) goto L13;
        if (r2.mView == null) goto L13;
        return r2;
    L13:
        r6 = r6 - 1;
    L14:
        return null;
    }

    private void forcePostponedTransactions() {
        if (this.mPostponedTransactions != null) goto L5;
        return;
    L5:
        if (this.mPostponedTransactions.isEmpty() == true) goto L9;
        this.mPostponedTransactions.remove(0).completeTransaction();
        goto L5
    }

    private boolean generateOpsForPendingActions(ArrayList<BackStackRecord> r5, ArrayList<Boolean> r6) {
        monitor-enter(this);
        ArrayList<OpGenerator> r0 = this.mPendingActions;     // Catch: Throwable -> L11
        int r1 = 0;
        if (r0 != null) goto L6;
    L16:
        monitor-exit(this);     // Catch: Throwable -> L11
        return false;
    L6:
        if (r0.size() == 0) goto L16;
        int r2 = this.mPendingActions.size();     // Catch: Throwable -> L11
        boolean r3 = false;
    L9:
        if (r1 >= r2) goto L13;
        r3 = r3 | this.mPendingActions.get(r1).generateOps(r5, r6);     // Catch: Throwable -> L11
        r1 = r1 + 1;     // Catch: Throwable -> L11
        goto L9
    L13:
        this.mPendingActions.clear();     // Catch: Throwable -> L11
        this.mHost.getHandler().removeCallbacks(this.mExecCommit);     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return r3;
    L11:
        th = move-exception;
        throw th;
    }

    private boolean isMenuAvailable(Fragment r1) {
        if (r1.mHasMenu == false) goto L7;
        if (r1.mMenuVisible == false) goto L7;
    L8:
        return true;
    L7:
        if (r1.mChildFragmentManager.checkForMenus() == true) goto L8;
        return false;
    }

    public static AnimationOrAnimator makeFadeAnimation(float r1, float r2) {
        AlphaAnimation r0 = new AlphaAnimation(r1, r2);
        r0.setInterpolator(DECELERATE_CUBIC);
        r0.setDuration(220);
        return new AnimationOrAnimator(r0);
    }

    public static AnimationOrAnimator makeOpenCloseAnimation(float r11, float r12, float r13, float r14) {
        AnimationSet r0 = new AnimationSet(false);
        ScaleAnimation r1 = new ScaleAnimation(r11, r12, r11, r12, 1, 0.5f, 1, 0.5f);
        r1.setInterpolator(DECELERATE_QUINT);
        r1.setDuration(220);
        r0.addAnimation(r1);
        AlphaAnimation r2 = new AlphaAnimation(r13, r14);
        r2.setInterpolator(DECELERATE_CUBIC);
        r2.setDuration(220);
        r0.addAnimation(r2);
        return new AnimationOrAnimator(r0);
    }

    private void makeRemovedFragmentsInvisible(ArraySet<Fragment> r5) {
        int r4 = r5.size();
        int r0 = 0;
    L3:
        if (r0 >= r4) goto L8;
        Fragment r1 = r5.valueAt(r0);
        if (r1.mAdded == true) goto L7;
        View r2 = r1.requireView();
        r1.mPostponedAlpha = r2.getAlpha();
        r2.setAlpha(0.0f);
    L7:
        r0 = r0 + 1;
        goto L3
    }

    private int postponePostponableTransactions(ArrayList<BackStackRecord> r7, ArrayList<Boolean> r8, int r9, int r10, ArraySet<Fragment> r11) {
        int r0 = r10 - 1;
        int r1 = r10;
    L3:
        if (r0 < r9) goto L20;
        BackStackRecord r2 = r7.get(r0);
        boolean r3 = r8.get(r0).booleanValue();
        if (r2.isPostponed() == false) goto L19;
        if (r2.interactsWith(r7, r0 + 1, r10) == true) goto L19;
        if (this.mPostponedTransactions != null) goto L11;
        this.mPostponedTransactions = new ArrayList();
    L11:
        StartEnterTransitionListener r4 = new StartEnterTransitionListener(r2, r3);
        this.mPostponedTransactions.add(r4);
        r2.setOnStartPostponedListener(r4);
        if (r3 == false) goto L14;
        r2.executeOps();
    L15:
        r1 = r1 - 1;
        if (r0 == r1) goto L18;
        r7.remove(r0);
        r7.add(r1, r2);
    L18:
        addAddedFragments(r11);
        goto L19
    L14:
        r2.executePopOps(false);
    L19:
        r0 = r0 - 1;
        goto L3
    L20:
        return r1;
    }

    private void removeRedundantOperationsAndExecute(ArrayList<BackStackRecord> r5, ArrayList<Boolean> r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.isEmpty() == true) goto L38;
        if (r6 == null) goto L29;
        if (r5.size() != r6.size()) goto L29;
        executePostponedTransaction(r5, r6);
        int r0 = r5.size();
        int r1 = 0;
        int r2 = 0;
    L10:
        if (r1 >= r0) goto L25;
        if (r5.get(r1).mReorderingAllowed == true) goto L24;
        if (r2 == r1) goto L15;
        executeOpsTogether(r5, r6, r2, r1);
    L15:
        r2 = r1 + 1;
        if (r6.get(r1).booleanValue() == false) goto L23;
    L17:
        if (r2 >= r0) goto L23;
        if (r6.get(r2).booleanValue() == false) goto L23;
        if (r5.get(r2).mReorderingAllowed == true) goto L23;
        r2 = r2 + 1;
    L23:
        executeOpsTogether(r5, r6, r1, r2);
        r1 = r2 - 1;
    L24:
        r1 = r1 + 1;
        goto L10
    L25:
        if (r2 == r0) goto L37;
        executeOpsTogether(r5, r6, r2, r0);
        return;
    L37:
        return;
    L29:
        throw new IllegalStateException("Internal error with the back stack records");
    }

    public static int reverseTransit(int r3) {
        if (r3 != 4097) goto L5;
        return 8194;
    L5:
        if (r3 == 4099) goto L10;
        if (r3 == 8194) goto L13;
        return 0;
    L13:
        return FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
    L10:
        return FragmentTransaction.TRANSIT_FRAGMENT_FADE;
    }

    private void throwException(RuntimeException r8) {
        Log.e(TAG, r8.getMessage());
        Log.e(TAG, "Activity state:");
        PrintWriter r2 = new PrintWriter(new LogWriter(TAG));
        FragmentHostCallback r0 = this.mHost;
        if (r0 == null) goto L15;
        r0.onDump("  ", null, r2, new String[0]);     // Catch: Exception -> L6
        throw r8;
    L6:
        e = move-exception;
        Log.e(TAG, "Failed dumping state", e);
        throw r8;
    L15:
        dump("  ", null, r2, new String[0]);     // Catch: Exception -> L10
        throw r8;
    L10:
        e = move-exception;
        Log.e(TAG, "Failed dumping state", e);
        throw r8;
    }

    public static int transitToStyleIndex(int r1, boolean r2) {
        if (r1 != 4097) goto L5;
        if (r2 == false) goto L17;
        return 1;
    L17:
        return 2;
    L5:
        if (r1 != 4099) goto L7;
        if (r2 == false) goto L14;
        return 5;
    L14:
        return 6;
    L7:
        if (r1 == 8194) goto L9;
        return -1;
    L9:
        if (r2 == false) goto L11;
        return 3;
    L11:
        return 4;
    }

    private void updateOnBackPressedCallbackEnabled() {
        ArrayList<OpGenerator> r0 = this.mPendingActions;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        OnBackPressedCallback r2 = this.mOnBackPressedCallback;
        if (getBackStackEntryCount() > 0) goto L11;
    L13:
        r1 = false;
    L14:
        r2.setEnabled(r1);
        return;
    L11:
        if (isPrimaryNavigation(this.mParent) == false) goto L13;
    L5:
        if (r0.isEmpty() == true) goto L8;
        this.mOnBackPressedCallback.setEnabled(true);
    }

    public void addBackStackState(BackStackRecord r2) {
        if (this.mBackStack != null) goto L5;
        this.mBackStack = new ArrayList();
    L5:
        this.mBackStack.add(r2);
    }

    public void addFragment(Fragment r4, boolean r5) {
        if (DEBUG == false) goto L5;
        a.x("add: ", r4, TAG);
    L5:
        makeActive(r4);
        if (r4.mDetached == false) goto L8;
        return;
    L8:
        if (this.mAdded.contains(r4) == true) goto L25;
        ArrayList<Fragment> r0 = this.mAdded;
        monitor-enter(r0);
        this.mAdded.add(r4);     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        r4.mAdded = true;
        r4.mRemoving = false;
        if (r4.mView != null) goto L17;
        r4.mHiddenChanged = false;
    L17:
        if (isMenuAvailable(r4) == false) goto L19;
        this.mNeedMenuInvalidate = true;
    L19:
        if (r5 == false) goto L29;
        moveToState(r4);
        return;
    L29:
        return;
    L21:
        th = move-exception;
        throw th;
    L25:
        throw new IllegalStateException("Fragment already added: " + r4);
    }

    @Override // androidx.fragment.app.FragmentManager
    public void addOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener r2) {
        if (this.mBackStackChangeListeners != null) goto L5;
        this.mBackStackChangeListeners = new ArrayList();
    L5:
        this.mBackStackChangeListeners.add(r2);
    }

    public void addRetainedFragment(@NonNull Fragment r3) {
        if (isStateSaved() == false) goto L9;
        if (DEBUG == false) goto L14;
        Log.v(TAG, "Ignoring addRetainedFragment as the state is already saved");
        return;
    L14:
        return;
    L9:
        if (this.mNonConfig.addRetainedFragment(r3) == true) goto L11;
        return;
    L11:
        if (DEBUG == false) goto L16;
        a.x("Updating retained Fragments: Added ", r3, TAG);
        return;
    }

    public int allocBackStackIndex(BackStackRecord r5) {
        monitor-enter(this);
        ArrayList<Integer> r2 = this.mAvailBackStackIndices;     // Catch: Throwable -> L12
        if (r2 == null) goto L18;
        if (r2.size() <= 0) goto L18;
        ArrayList<Integer> r0 = this.mAvailBackStackIndices;     // Catch: Throwable -> L12
        int r1 = r0.remove(r0.size() - 1).intValue();     // Catch: Throwable -> L12
        if (DEBUG == false) goto L14;
        Log.v(TAG, "Adding back stack index " + r1 + " with " + r5);     // Catch: Throwable -> L12
    L14:
        this.mBackStackIndices.set(r1, r5);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return r1;
    L18:
        if (this.mBackStackIndices != null) goto L20;
        this.mBackStackIndices = new ArrayList();     // Catch: Throwable -> L12
    L20:
        int r3 = this.mBackStackIndices.size();     // Catch: Throwable -> L12
        if (DEBUG == false) goto L23;
        Log.v(TAG, "Setting back stack index " + r3 + " to " + r5);     // Catch: Throwable -> L12
    L23:
        this.mBackStackIndices.add(r5);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return r3;
    L12:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void attachController(@NonNull FragmentHostCallback r3, @NonNull FragmentContainer r4, @Nullable Fragment r5) {
        if (this.mHost != null) goto L21;
        this.mHost = r3;
        this.mContainer = r4;
        this.mParent = r5;
        if (r5 == null) goto L8;
        updateOnBackPressedCallbackEnabled();
    L8:
        if ((r3 instanceof OnBackPressedDispatcherOwner) == false) goto L13;
        OnBackPressedDispatcherOwner r6 = (OnBackPressedDispatcherOwner) r3;
        OnBackPressedDispatcher r0 = r6.getOnBackPressedDispatcher();
        this.mOnBackPressedDispatcher = r0;
        LifecycleOwner r7 = r6;
        if (r5 == null) goto L12;
        r7 = r5;
    L12:
        r0.addCallback(r7, this.mOnBackPressedCallback);
    L13:
        if (r5 == null) goto L16;
        this.mNonConfig = r5.mFragmentManager.getChildNonConfig(r5);
        return;
    L16:
        if ((r3 instanceof ViewModelStoreOwner) == false) goto L18;
        this.mNonConfig = FragmentManagerViewModel.getInstance(((ViewModelStoreOwner) r3).getViewModelStore());
        return;
    L18:
        this.mNonConfig = new FragmentManagerViewModel(false);
        return;
    L21:
        throw new IllegalStateException("Already attached");
    }

    public void attachFragment(Fragment r3) {
        if (DEBUG == false) goto L6;
        a.x("attach: ", r3, TAG);
    L6:
        if (r3.mDetached == false) goto L26;
        r3.mDetached = false;
        if (r3.mAdded == false) goto L10;
        return;
    L10:
        if (this.mAdded.contains(r3) == true) goto L25;
        if (DEBUG == false) goto L14;
        a.x("add from attach: ", r3, TAG);
    L14:
        ArrayList<Fragment> r0 = this.mAdded;
        monitor-enter(r0);
        this.mAdded.add(r3);     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        r3.mAdded = true;
        if (isMenuAvailable(r3) == false) goto L30;
        this.mNeedMenuInvalidate = true;
        return;
    L30:
        return;
    L21:
        th = move-exception;
        throw th;
    L25:
        throw new IllegalStateException("Fragment already added: " + r3);
    }

    @Override // androidx.fragment.app.FragmentManager
    @NonNull
    public FragmentTransaction beginTransaction() {
        return new BackStackRecord(this);
    }

    public boolean checkForMenus() {
        Iterator<Fragment> r0 = this.mActive.values().iterator();
        boolean r2 = false;
    L4:
        if (r0.hasNext() == false) goto L11;
        Fragment r3 = r0.next();
        if (r3 == null) goto L8;
        r2 = isMenuAvailable(r3);
    L8:
        if (r2 == false) goto L4;
        return true;
    L11:
        return false;
    }

    public void completeExecute(BackStackRecord r8, boolean r9, boolean r10, boolean r11) {
        if (r9 == false) goto L4;
        r8.executePopOps(r11);
    L5:
        ArrayList r1 = new ArrayList(1);
        ArrayList r2 = new ArrayList(1);
        r1.add(r8);
        r2.add(Boolean.valueOf(r9));
        if (r10 == false) goto L8;
        FragmentTransition.startTransitions(this, r1, r2, 0, 1, true);
    L8:
        if (r11 == false) goto L10;
        moveToState(this.mCurState, true);
    L10:
        Iterator<Fragment> r7 = this.mActive.values().iterator();
    L12:
        if (r7.hasNext() == false) goto L27;
        Fragment r12 = r7.next();
        if (r12 == null) goto L12;
        if (r12.mView == null) goto L12;
        if (r12.mIsNewlyAdded == false) goto L12;
        if (r8.interactsWith(r12.mContainerId) == false) goto L12;
        float r13 = r12.mPostponedAlpha;
        if (r13 <= 0.0f) goto L24;
        r12.mView.setAlpha(r13);
    L24:
        if (r11 == true) goto L25;
        r12.mPostponedAlpha = -1.0f;
        r12.mIsNewlyAdded = false;
        goto L12
    L25:
        r12.mPostponedAlpha = 0.0f;
        goto L12
    L27:
        return;
    L4:
        r8.executeOps();
        goto L5
    }

    public void completeShowHideFragment(final Fragment r8) {
        if (r8.mView == null) goto L28;
        AnimationOrAnimator r0 = loadAnimation(r8, r8.getNextTransition(), !r8.mHidden, r8.getNextTransitionStyle());
        if (r0 == null) goto L16;
        Animator r3 = r0.animator;
        if (r3 == null) goto L16;
        r3.setTarget(r8.mView);
        if (r8.mHidden == true) goto L11;
        r8.mView.setVisibility(0);
    L15:
        r0.animator.start();
        goto L28
    L11:
        if (r8.isHideReplaced() == false) goto L13;
        r8.setHideReplaced(false);
        goto L15
    L13:
        final ViewGroup r4 = r8.mContainer;
        final View r5 = r8.mView;
        r4.startViewTransition(r5);
        r0.animator.addListener(new AnonymousClass5(this, r4, r5, r8));
    L16:
        if (r0 == null) goto L19;
        r8.mView.startAnimation(r0.animation);
        r0.animation.start();
    L19:
        if (r8.mHidden == true) goto L21;
    L23:
        int r1 = 0;
    L24:
        r8.mView.setVisibility(r1);
        if (r8.isHideReplaced() == false) goto L28;
        r8.setHideReplaced(false);
        goto L28
    L21:
        if (r8.isHideReplaced() == true) goto L23;
        r1 = 8;
    L28:
        if (r8.mAdded == true) goto L30;
    L32:
        r8.mHiddenChanged = false;
        r8.onHiddenChanged(r8.mHidden);
        return;
    L30:
        if (isMenuAvailable(r8) == false) goto L32;
        this.mNeedMenuInvalidate = true;
        goto L32
    }

    public void detachFragment(Fragment r4) {
        if (DEBUG == false) goto L6;
        a.x("detach: ", r4, TAG);
    L6:
        if (r4.mDetached == true) goto L23;
        r4.mDetached = true;
        if (r4.mAdded == true) goto L10;
        return;
    L10:
        if (DEBUG == false) goto L12;
        a.x("remove from detach: ", r4, TAG);
    L12:
        ArrayList<Fragment> r1 = this.mAdded;
        monitor-enter(r1);
        this.mAdded.remove(r4);     // Catch: Throwable -> L20
        monitor-exit(r1);     // Catch: Throwable -> L20
        if (isMenuAvailable(r4) == false) goto L19;
        this.mNeedMenuInvalidate = true;
    L19:
        r4.mAdded = false;
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public void dispatchActivityCreated() {
        this.mStateSaved = false;
        this.mStopped = false;
        dispatchStateChange(2);
    }

    public void dispatchConfigurationChanged(@NonNull Configuration r3) {
        int r0 = 0;
    L4:
        if (r0 >= this.mAdded.size()) goto L9;
        Fragment r1 = this.mAdded.get(r0);
        if (r1 == null) goto L8;
        r1.performConfigurationChanged(r3);
    L8:
        r0 = r0 + 1;
        goto L4
    }

    public boolean dispatchContextItemSelected(@NonNull MenuItem r5) {
        if (this.mCurState >= 1) goto L5;
        return false;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= this.mAdded.size()) goto L14;
        Fragment r3 = this.mAdded.get(r0);
        if (r3 == null) goto L13;
        if (r3.performContextItemSelected(r5) == false) goto L13;
        return true;
    L13:
        r0 = r0 + 1;
        goto L7
    L14:
        return false;
    }

    public void dispatchCreate() {
        this.mStateSaved = false;
        this.mStopped = false;
        dispatchStateChange(1);
    }

    public boolean dispatchCreateOptionsMenu(@NonNull Menu r8, @NonNull MenuInflater r9) {
        int r1 = 0;
        if (this.mCurState >= 1) goto L5;
        return false;
    L5:
        ArrayList<Fragment> r0 = null;
        int r3 = 0;
        boolean r4 = false;
    L7:
        if (r3 >= this.mAdded.size()) goto L17;
        Fragment r5 = this.mAdded.get(r3);
        if (r5 == null) goto L15;
        if (r5.performCreateOptionsMenu(r8, r9) == false) goto L15;
        if (r0 != null) goto L14;
        r0 = new ArrayList();
    L14:
        r0.add(r5);
        r4 = true;
    L15:
        r3 = r3 + 1;
        goto L7
    L17:
        if (this.mCreatedMenus != null) goto L19;
    L26:
        this.mCreatedMenus = r0;
        return r4;
    L19:
        if (r1 >= this.mCreatedMenus.size()) goto L26;
        Fragment r10 = this.mCreatedMenus.get(r1);
        if (r0 != null) goto L23;
    L24:
        r10.onDestroyOptionsMenu();
    L25:
        r1 = r1 + 1;
        goto L19
    L23:
        if (r0.contains(r10) == true) goto L25;
        goto L24
    }

    public void dispatchDestroy() {
        this.mDestroyed = true;
        execPendingActions();
        dispatchStateChange(0);
        this.mHost = null;
        this.mContainer = null;
        this.mParent = null;
        if (this.mOnBackPressedDispatcher == null) goto L6;
        this.mOnBackPressedCallback.remove();
        this.mOnBackPressedDispatcher = null;
        return;
    }

    public void dispatchDestroyView() {
        dispatchStateChange(1);
    }

    public void dispatchLowMemory() {
        int r0 = 0;
    L4:
        if (r0 >= this.mAdded.size()) goto L9;
        Fragment r1 = this.mAdded.get(r0);
        if (r1 == null) goto L8;
        r1.performLowMemory();
    L8:
        r0 = r0 + 1;
        goto L4
    }

    public void dispatchMultiWindowModeChanged(boolean r3) {
        int r0 = this.mAdded.size() - 1;
    L3:
        if (r0 < 0) goto L8;
        Fragment r1 = this.mAdded.get(r0);
        if (r1 == null) goto L7;
        r1.performMultiWindowModeChanged(r3);
    L7:
        r0 = r0 - 1;
        goto L3
    }

    public void dispatchOnFragmentActivityCreated(@NonNull Fragment r4, @Nullable Bundle r5, boolean r6) {
        Fragment r0 = this.mParent;
        if (r0 == null) goto L7;
        FragmentManager r1 = r0.getFragmentManager();
        if ((r1 instanceof FragmentManagerImpl) == false) goto L7;
        ((FragmentManagerImpl) r1).dispatchOnFragmentActivityCreated(r4, r5, true);
    L7:
        Iterator<FragmentLifecycleCallbacksHolder> r2 = this.mLifecycleCallbacks.iterator();
    L9:
        if (r2.hasNext() == false) goto L15;
        FragmentLifecycleCallbacksHolder r3 = r2.next();
        if (r6 == false) goto L14;
        if (r3.mRecursive == false) goto L9;
    L14:
        r3.mCallback.onFragmentActivityCreated(this, r4, r5);
        goto L9
    }

    public void dispatchOnFragmentAttached(@NonNull Fragment r4, @NonNull Context r5, boolean r6) {
        Fragment r0 = this.mParent;
        if (r0 == null) goto L7;
        FragmentManager r1 = r0.getFragmentManager();
        if ((r1 instanceof FragmentManagerImpl) == false) goto L7;
        ((FragmentManagerImpl) r1).dispatchOnFragmentAttached(r4, r5, true);
    L7:
        Iterator<FragmentLifecycleCallbacksHolder> r2 = this.mLifecycleCallbacks.iterator();
    L9:
        if (r2.hasNext() == false) goto L15;
        FragmentLifecycleCallbacksHolder r3 = r2.next();
        if (r6 == false) goto L14;
        if (r3.mRecursive == false) goto L9;
    L14:
        r3.mCallback.onFragmentAttached(this, r4, r5);
        goto L9
    }

    public void dispatchOnFragmentCreated(@NonNull Fragment r4, @Nullable Bundle r5, boolean r6) {
        Fragment r0 = this.mParent;
        if (r0 == null) goto L7;
        FragmentManager r1 = r0.getFragmentManager();
        if ((r1 instanceof FragmentManagerImpl) == false) goto L7;
        ((FragmentManagerImpl) r1).dispatchOnFragmentCreated(r4, r5, true);
    L7:
        Iterator<FragmentLifecycleCallbacksHolder> r2 = this.mLifecycleCallbacks.iterator();
    L9:
        if (r2.hasNext() == false) goto L15;
        FragmentLifecycleCallbacksHolder r3 = r2.next();
        if (r6 == false) goto L14;
        if (r3.mRecursive == false) goto L9;
    L14:
        r3.mCallback.onFragmentCreated(this, r4, r5);
        goto L9
    }

    public void dispatchOnFragmentDestroyed(@NonNull Fragment r4, boolean r5) {
        Fragment r0 = this.mParent;
        if (r0 == null) goto L7;
        FragmentManager r1 = r0.getFragmentManager();
        if ((r1 instanceof FragmentManagerImpl) == false) goto L7;
        ((FragmentManagerImpl) r1).dispatchOnFragmentDestroyed(r4, true);
    L7:
        Iterator<FragmentLifecycleCallbacksHolder> r2 = this.mLifecycleCallbacks.iterator();
    L9:
        if (r2.hasNext() == false) goto L15;
        FragmentLifecycleCallbacksHolder r3 = r2.next();
        if (r5 == false) goto L14;
        if (r3.mRecursive == false) goto L9;
    L14:
        r3.mCallback.onFragmentDestroyed(this, r4);
        goto L9
    }

    public void dispatchOnFragmentDetached(@NonNull Fragment r4, boolean r5) {
        Fragment r0 = this.mParent;
        if (r0 == null) goto L7;
        FragmentManager r1 = r0.getFragmentManager();
        if ((r1 instanceof FragmentManagerImpl) == false) goto L7;
        ((FragmentManagerImpl) r1).dispatchOnFragmentDetached(r4, true);
    L7:
        Iterator<FragmentLifecycleCallbacksHolder> r2 = this.mLifecycleCallbacks.iterator();
    L9:
        if (r2.hasNext() == false) goto L15;
        FragmentLifecycleCallbacksHolder r3 = r2.next();
        if (r5 == false) goto L14;
        if (r3.mRecursive == false) goto L9;
    L14:
        r3.mCallback.onFragmentDetached(this, r4);
        goto L9
    }

    public void dispatchOnFragmentPaused(@NonNull Fragment r4, boolean r5) {
        Fragment r0 = this.mParent;
        if (r0 == null) goto L7;
        FragmentManager r1 = r0.getFragmentManager();
        if ((r1 instanceof FragmentManagerImpl) == false) goto L7;
        ((FragmentManagerImpl) r1).dispatchOnFragmentPaused(r4, true);
    L7:
        Iterator<FragmentLifecycleCallbacksHolder> r2 = this.mLifecycleCallbacks.iterator();
    L9:
        if (r2.hasNext() == false) goto L15;
        FragmentLifecycleCallbacksHolder r3 = r2.next();
        if (r5 == false) goto L14;
        if (r3.mRecursive == false) goto L9;
    L14:
        r3.mCallback.onFragmentPaused(this, r4);
        goto L9
    }

    public void dispatchOnFragmentPreAttached(@NonNull Fragment r4, @NonNull Context r5, boolean r6) {
        Fragment r0 = this.mParent;
        if (r0 == null) goto L7;
        FragmentManager r1 = r0.getFragmentManager();
        if ((r1 instanceof FragmentManagerImpl) == false) goto L7;
        ((FragmentManagerImpl) r1).dispatchOnFragmentPreAttached(r4, r5, true);
    L7:
        Iterator<FragmentLifecycleCallbacksHolder> r2 = this.mLifecycleCallbacks.iterator();
    L9:
        if (r2.hasNext() == false) goto L15;
        FragmentLifecycleCallbacksHolder r3 = r2.next();
        if (r6 == false) goto L14;
        if (r3.mRecursive == false) goto L9;
    L14:
        r3.mCallback.onFragmentPreAttached(this, r4, r5);
        goto L9
    }

    public void dispatchOnFragmentPreCreated(@NonNull Fragment r4, @Nullable Bundle r5, boolean r6) {
        Fragment r0 = this.mParent;
        if (r0 == null) goto L7;
        FragmentManager r1 = r0.getFragmentManager();
        if ((r1 instanceof FragmentManagerImpl) == false) goto L7;
        ((FragmentManagerImpl) r1).dispatchOnFragmentPreCreated(r4, r5, true);
    L7:
        Iterator<FragmentLifecycleCallbacksHolder> r2 = this.mLifecycleCallbacks.iterator();
    L9:
        if (r2.hasNext() == false) goto L15;
        FragmentLifecycleCallbacksHolder r3 = r2.next();
        if (r6 == false) goto L14;
        if (r3.mRecursive == false) goto L9;
    L14:
        r3.mCallback.onFragmentPreCreated(this, r4, r5);
        goto L9
    }

    public void dispatchOnFragmentResumed(@NonNull Fragment r4, boolean r5) {
        Fragment r0 = this.mParent;
        if (r0 == null) goto L7;
        FragmentManager r1 = r0.getFragmentManager();
        if ((r1 instanceof FragmentManagerImpl) == false) goto L7;
        ((FragmentManagerImpl) r1).dispatchOnFragmentResumed(r4, true);
    L7:
        Iterator<FragmentLifecycleCallbacksHolder> r2 = this.mLifecycleCallbacks.iterator();
    L9:
        if (r2.hasNext() == false) goto L15;
        FragmentLifecycleCallbacksHolder r3 = r2.next();
        if (r5 == false) goto L14;
        if (r3.mRecursive == false) goto L9;
    L14:
        r3.mCallback.onFragmentResumed(this, r4);
        goto L9
    }

    public void dispatchOnFragmentSaveInstanceState(@NonNull Fragment r4, @NonNull Bundle r5, boolean r6) {
        Fragment r0 = this.mParent;
        if (r0 == null) goto L7;
        FragmentManager r1 = r0.getFragmentManager();
        if ((r1 instanceof FragmentManagerImpl) == false) goto L7;
        ((FragmentManagerImpl) r1).dispatchOnFragmentSaveInstanceState(r4, r5, true);
    L7:
        Iterator<FragmentLifecycleCallbacksHolder> r2 = this.mLifecycleCallbacks.iterator();
    L9:
        if (r2.hasNext() == false) goto L15;
        FragmentLifecycleCallbacksHolder r3 = r2.next();
        if (r6 == false) goto L14;
        if (r3.mRecursive == false) goto L9;
    L14:
        r3.mCallback.onFragmentSaveInstanceState(this, r4, r5);
        goto L9
    }

    public void dispatchOnFragmentStarted(@NonNull Fragment r4, boolean r5) {
        Fragment r0 = this.mParent;
        if (r0 == null) goto L7;
        FragmentManager r1 = r0.getFragmentManager();
        if ((r1 instanceof FragmentManagerImpl) == false) goto L7;
        ((FragmentManagerImpl) r1).dispatchOnFragmentStarted(r4, true);
    L7:
        Iterator<FragmentLifecycleCallbacksHolder> r2 = this.mLifecycleCallbacks.iterator();
    L9:
        if (r2.hasNext() == false) goto L15;
        FragmentLifecycleCallbacksHolder r3 = r2.next();
        if (r5 == false) goto L14;
        if (r3.mRecursive == false) goto L9;
    L14:
        r3.mCallback.onFragmentStarted(this, r4);
        goto L9
    }

    public void dispatchOnFragmentStopped(@NonNull Fragment r4, boolean r5) {
        Fragment r0 = this.mParent;
        if (r0 == null) goto L7;
        FragmentManager r1 = r0.getFragmentManager();
        if ((r1 instanceof FragmentManagerImpl) == false) goto L7;
        ((FragmentManagerImpl) r1).dispatchOnFragmentStopped(r4, true);
    L7:
        Iterator<FragmentLifecycleCallbacksHolder> r2 = this.mLifecycleCallbacks.iterator();
    L9:
        if (r2.hasNext() == false) goto L15;
        FragmentLifecycleCallbacksHolder r3 = r2.next();
        if (r5 == false) goto L14;
        if (r3.mRecursive == false) goto L9;
    L14:
        r3.mCallback.onFragmentStopped(this, r4);
        goto L9
    }

    public void dispatchOnFragmentViewCreated(@NonNull Fragment r4, @NonNull View r5, @Nullable Bundle r6, boolean r7) {
        Fragment r0 = this.mParent;
        if (r0 == null) goto L7;
        FragmentManager r1 = r0.getFragmentManager();
        if ((r1 instanceof FragmentManagerImpl) == false) goto L7;
        ((FragmentManagerImpl) r1).dispatchOnFragmentViewCreated(r4, r5, r6, true);
    L7:
        Iterator<FragmentLifecycleCallbacksHolder> r2 = this.mLifecycleCallbacks.iterator();
    L9:
        if (r2.hasNext() == false) goto L15;
        FragmentLifecycleCallbacksHolder r3 = r2.next();
        if (r7 == false) goto L14;
        if (r3.mRecursive == false) goto L9;
    L14:
        r3.mCallback.onFragmentViewCreated(this, r4, r5, r6);
        goto L9
    }

    public void dispatchOnFragmentViewDestroyed(@NonNull Fragment r4, boolean r5) {
        Fragment r0 = this.mParent;
        if (r0 == null) goto L7;
        FragmentManager r1 = r0.getFragmentManager();
        if ((r1 instanceof FragmentManagerImpl) == false) goto L7;
        ((FragmentManagerImpl) r1).dispatchOnFragmentViewDestroyed(r4, true);
    L7:
        Iterator<FragmentLifecycleCallbacksHolder> r2 = this.mLifecycleCallbacks.iterator();
    L9:
        if (r2.hasNext() == false) goto L15;
        FragmentLifecycleCallbacksHolder r3 = r2.next();
        if (r5 == false) goto L14;
        if (r3.mRecursive == false) goto L9;
    L14:
        r3.mCallback.onFragmentViewDestroyed(this, r4);
        goto L9
    }

    public boolean dispatchOptionsItemSelected(@NonNull MenuItem r5) {
        if (this.mCurState >= 1) goto L5;
        return false;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= this.mAdded.size()) goto L14;
        Fragment r3 = this.mAdded.get(r0);
        if (r3 == null) goto L13;
        if (r3.performOptionsItemSelected(r5) == false) goto L13;
        return true;
    L13:
        r0 = r0 + 1;
        goto L7
    L14:
        return false;
    }

    public void dispatchOptionsMenuClosed(@NonNull Menu r3) {
        if (this.mCurState >= 1) goto L5;
        return;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= this.mAdded.size()) goto L12;
        Fragment r1 = this.mAdded.get(r0);
        if (r1 == null) goto L11;
        r1.performOptionsMenuClosed(r3);
    L11:
        r0 = r0 + 1;
        goto L7
    }

    public void dispatchPause() {
        dispatchStateChange(3);
    }

    public void dispatchPictureInPictureModeChanged(boolean r3) {
        int r0 = this.mAdded.size() - 1;
    L3:
        if (r0 < 0) goto L8;
        Fragment r1 = this.mAdded.get(r0);
        if (r1 == null) goto L7;
        r1.performPictureInPictureModeChanged(r3);
    L7:
        r0 = r0 - 1;
        goto L3
    }

    public boolean dispatchPrepareOptionsMenu(@NonNull Menu r5) {
        int r1 = 0;
        if (this.mCurState >= 1) goto L5;
        return false;
    L5:
        boolean r0 = false;
    L7:
        if (r1 >= this.mAdded.size()) goto L14;
        Fragment r3 = this.mAdded.get(r1);
        if (r3 == null) goto L13;
        if (r3.performPrepareOptionsMenu(r5) == false) goto L13;
        r0 = true;
    L13:
        r1 = r1 + 1;
        goto L7
    L14:
        return r0;
    }

    public void dispatchPrimaryNavigationFragmentChanged() {
        updateOnBackPressedCallbackEnabled();
        dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
    }

    public void dispatchResume() {
        this.mStateSaved = false;
        this.mStopped = false;
        dispatchStateChange(4);
    }

    public void dispatchStart() {
        this.mStateSaved = false;
        this.mStopped = false;
        dispatchStateChange(3);
    }

    public void dispatchStop() {
        this.mStopped = true;
        dispatchStateChange(2);
    }

    public void doPendingDeferredStart() {
        if (this.mHavePendingDeferredStart == false) goto L6;
        this.mHavePendingDeferredStart = false;
        startPendingDeferredFragments();
        return;
    }

    @Override // androidx.fragment.app.FragmentManager
    public void dump(@NonNull String r5, @Nullable FileDescriptor r6, @NonNull PrintWriter r7, @Nullable String[] r8) {
        String r0 = a.j(r5, "    ");
        if (this.mActive.isEmpty() == true) goto L10;
        r7.print(r5);
        r7.print("Active Fragments in ");
        r7.print(Integer.toHexString(System.identityHashCode(this)));
        r7.println(":");
        Iterator<Fragment> r1 = this.mActive.values().iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        Fragment r2 = r1.next();
        r7.print(r5);
        r7.println(r2);
        if (r2 == null) goto L6;
        r2.dump(r0, r6, r7, r8);
    L10:
        int r9 = this.mAdded.size();
        int r10 = 0;
        if (r9 <= 0) goto L15;
        r7.print(r5);
        r7.println("Added Fragments:");
        int r3 = 0;
    L13:
        if (r3 >= r9) goto L15;
        Fragment r4 = this.mAdded.get(r3);
        r7.print(r5);
        r7.print("  #");
        r7.print(r3);
        r7.print(": ");
        r7.println(r4.toString());
        r3 = r3 + 1;
    L15:
        ArrayList<Fragment> r11 = this.mCreatedMenus;
        if (r11 == null) goto L22;
        int r12 = r11.size();
        if (r12 <= 0) goto L22;
        r7.print(r5);
        r7.println("Fragments Created Menus:");
        int r13 = 0;
    L20:
        if (r13 >= r12) goto L22;
        Fragment r14 = this.mCreatedMenus.get(r13);
        r7.print(r5);
        r7.print("  #");
        r7.print(r13);
        r7.print(": ");
        r7.println(r14.toString());
        r13 = r13 + 1;
    L22:
        ArrayList<BackStackRecord> r15 = this.mBackStack;
        if (r15 == null) goto L29;
        int r16 = r15.size();
        if (r16 <= 0) goto L29;
        r7.print(r5);
        r7.println("Back Stack:");
        int r17 = 0;
    L27:
        if (r17 >= r16) goto L29;
        BackStackRecord r18 = this.mBackStack.get(r17);
        r7.print(r5);
        r7.print("  #");
        r7.print(r17);
        r7.print(": ");
        r7.println(r18.toString());
        r18.dump(r0, r7);
        r17 = r17 + 1;
    L29:
        monitor-enter(this);
        ArrayList<BackStackRecord> r19 = this.mBackStackIndices;     // Catch: Throwable -> L37
        if (r19 == null) goto L39;
        int r20 = r19.size();     // Catch: Throwable -> L37
        if (r20 <= 0) goto L39;
        r7.print(r5);     // Catch: Throwable -> L37
        r7.println("Back Stack Indices:");     // Catch: Throwable -> L37
        int r21 = 0;
    L35:
        if (r21 >= r20) goto L39;
        Object r22 = (BackStackRecord) this.mBackStackIndices.get(r21);     // Catch: Throwable -> L37
        r7.print(r5);     // Catch: Throwable -> L37
        r7.print("  #");     // Catch: Throwable -> L37
        r7.print(r21);     // Catch: Throwable -> L37
        r7.print(": ");     // Catch: Throwable -> L37
        r7.println(r22);     // Catch: Throwable -> L37
        r21 = r21 + 1;     // Catch: Throwable -> L37
    L39:
        ArrayList<Integer> r23 = this.mAvailBackStackIndices;     // Catch: Throwable -> L37
        if (r23 != null) goto L42;
    L44:
        monitor-exit(this);     // Catch: Throwable -> L37
        ArrayList<OpGenerator> r24 = this.mPendingActions;
        if (r24 == null) goto L52;
        int r25 = r24.size();
        if (r25 <= 0) goto L52;
        r7.print(r5);
        r7.println("Pending Actions:");
    L50:
        if (r10 >= r25) goto L52;
        Object r26 = (OpGenerator) this.mPendingActions.get(r10);
        r7.print(r5);
        r7.print("  #");
        r7.print(r10);
        r7.print(": ");
        r7.println(r26);
        r10 = r10 + 1;
    L52:
        r7.print(r5);
        r7.println("FragmentManager misc state:");
        r7.print(r5);
        r7.print("  mHost=");
        r7.println(this.mHost);
        r7.print(r5);
        r7.print("  mContainer=");
        r7.println(this.mContainer);
        if (this.mParent == null) goto L55;
        r7.print(r5);
        r7.print("  mParent=");
        r7.println(this.mParent);
    L55:
        r7.print(r5);
        r7.print("  mCurState=");
        r7.print(this.mCurState);
        r7.print(" mStateSaved=");
        r7.print(this.mStateSaved);
        r7.print(" mStopped=");
        r7.print(this.mStopped);
        r7.print(" mDestroyed=");
        r7.println(this.mDestroyed);
        if (this.mNeedMenuInvalidate == false) goto L73;
        r7.print(r5);
        r7.print("  mNeedMenuInvalidate=");
        r7.println(this.mNeedMenuInvalidate);
        return;
    L73:
        return;
    L42:
        if (r23.size() <= 0) goto L44;
        r7.print(r5);     // Catch: Throwable -> L37
        r7.print("mAvailBackStackIndices: ");     // Catch: Throwable -> L37
        r7.println(Arrays.toString(this.mAvailBackStackIndices.toArray()));     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw th;
    }

    public void enqueueAction(OpGenerator r2, boolean r3) {
        if (r3 == true) goto L4;
        checkStateLoss();
    L4:
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L6:
        if (this.mDestroyed == false) goto L8;
    L18:
        if (r3 == false) goto L22;
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L22:
        throw new IllegalStateException("Activity has been destroyed");     // Catch: Throwable -> L13
    L8:
        if (this.mHost == null) goto L18;
        if (this.mPendingActions != null) goto L15;
        this.mPendingActions = new ArrayList();     // Catch: Throwable -> L13
    L15:
        this.mPendingActions.add(r2);     // Catch: Throwable -> L13
        scheduleCommit();     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
    }

    public void ensureInflatedFragmentView(Fragment r4) {
        if (r4.mFromLayout == true) goto L5;
        return;
    L5:
        if (r4.mPerformedCreateView == true) goto L15;
        r4.performCreateView(r4.performGetLayoutInflater(r4.mSavedFragmentState), null, r4.mSavedFragmentState);
        View r0 = r4.mView;
        if (r0 == null) goto L12;
        r4.mInnerView = r0;
        r0.setSaveFromParentEnabled(false);
        if (r4.mHidden == false) goto L11;
        r4.mView.setVisibility(8);
    L11:
        r4.onViewCreated(r4.mView, r4.mSavedFragmentState);
        dispatchOnFragmentViewCreated(r4, r4.mView, r4.mSavedFragmentState, false);
        return;
    L12:
        r4.mInnerView = null;
        return;
    }

    public boolean execPendingActions() {
        ensureExecReady(true);
        boolean r1 = false;
    L4:
        if (generateOpsForPendingActions(this.mTmpRecords, this.mTmpIsPop) == false) goto L11;
        this.mExecutingActions = true;
        removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);     // Catch: Throwable -> L8
        cleanupExec();
        r1 = true;
    L8:
        th = move-exception;
        cleanupExec();
        throw th;
    L11:
        updateOnBackPressedCallbackEnabled();
        doPendingDeferredStart();
        burpActive();
        return r1;
    }

    public void execSingleAction(OpGenerator r2, boolean r3) {
        if (r3 == true) goto L4;
    L8:
        ensureExecReady(r3);
        if (r2.generateOps(this.mTmpRecords, this.mTmpIsPop) == false) goto L16;
        this.mExecutingActions = true;
        removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);     // Catch: Throwable -> L13
        cleanupExec();
    L13:
        th = move-exception;
        cleanupExec();
        throw th;
    L16:
        updateOnBackPressedCallbackEnabled();
        doPendingDeferredStart();
        burpActive();
        return;
    L4:
        if (this.mHost != null) goto L6;
        return;
    L6:
        if (this.mDestroyed == false) goto L8;
    }

    @Override // androidx.fragment.app.FragmentManager
    public boolean executePendingTransactions() {
        boolean r0 = execPendingActions();
        forcePostponedTransactions();
        return r0;
    }

    @Override // androidx.fragment.app.FragmentManager
    @Nullable
    public Fragment findFragmentById(int r4) {
        int r0 = this.mAdded.size() - 1;
    L3:
        if (r0 < 0) goto L10;
        Fragment r1 = this.mAdded.get(r0);
        if (r1 == null) goto L9;
        if (r1.mFragmentId != r4) goto L9;
        return r1;
    L9:
        r0 = r0 - 1;
        goto L3
    L10:
        Iterator<Fragment> r3 = this.mActive.values().iterator();
    L12:
        if (r3.hasNext() == false) goto L18;
        Fragment r2 = r3.next();
        if (r2 == null) goto L12;
        if (r2.mFragmentId != r4) goto L12;
        return r2;
    L18:
        return null;
    }

    @Override // androidx.fragment.app.FragmentManager
    @Nullable
    public Fragment findFragmentByTag(@Nullable String r4) {
        if (r4 == null) goto L11;
        int r0 = this.mAdded.size() - 1;
    L4:
        if (r0 < 0) goto L11;
        Fragment r1 = this.mAdded.get(r0);
        if (r1 == null) goto L10;
        if (r4.equals(r1.mTag) == false) goto L10;
        return r1;
    L10:
        r0 = r0 - 1;
    L11:
        if (r4 == null) goto L20;
        Iterator<Fragment> r3 = this.mActive.values().iterator();
    L14:
        if (r3.hasNext() == false) goto L32;
        Fragment r2 = r3.next();
        if (r2 == null) goto L14;
        if (r4.equals(r2.mTag) == false) goto L14;
        return r2;
    L32:
        return null;
    L20:
        return null;
    }

    public Fragment findFragmentByWho(@NonNull String r2) {
        Iterator<Fragment> r1 = this.mActive.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        Fragment r0 = r1.next();
        if (r0 == null) goto L4;
        Fragment r3 = r0.findFragmentByWho(r2);
        if (r3 == null) goto L4;
        return r3;
    L10:
        return null;
    }

    public void freeBackStackIndex(int r4) {
        monitor-enter(this);
        this.mBackStackIndices.set(r4, null);     // Catch: Throwable -> L7
        if (this.mAvailBackStackIndices != null) goto L10;
        this.mAvailBackStackIndices = new ArrayList();     // Catch: Throwable -> L7
    L10:
        if (DEBUG == false) goto L12;
        Log.v(TAG, "Freeing back stack index " + r4);     // Catch: Throwable -> L7
    L12:
        this.mAvailBackStackIndices.add(Integer.valueOf(r4));     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public int getActiveFragmentCount() {
        return this.mActive.size();
    }

    @NonNull
    public List<Fragment> getActiveFragments() {
        return new ArrayList(this.mActive.values());
    }

    @Override // androidx.fragment.app.FragmentManager
    public FragmentManager.BackStackEntry getBackStackEntryAt(int r1) {
        return this.mBackStack.get(r1);
    }

    @Override // androidx.fragment.app.FragmentManager
    public int getBackStackEntryCount() {
        ArrayList<BackStackRecord> r0 = this.mBackStack;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    @NonNull
    public FragmentManagerViewModel getChildNonConfig(@NonNull Fragment r1) {
        return this.mNonConfig.getChildNonConfig(r1);
    }

    @Override // androidx.fragment.app.FragmentManager
    @Nullable
    public Fragment getFragment(Bundle r5, String r6) {
        String r7 = r5.getString(r6);
        if (r7 != null) goto L6;
        return null;
    L6:
        Fragment r0 = this.mActive.get(r7);
        if (r0 != null) goto L9;
        throwException(new IllegalStateException("Fragment no longer exists for key " + r6 + ": unique id " + r7));
    L9:
        return r0;
    }

    @Override // androidx.fragment.app.FragmentManager
    @NonNull
    public FragmentFactory getFragmentFactory() {
        if (super.getFragmentFactory() != FragmentManager.DEFAULT_FACTORY) goto L10;
        Fragment r0 = this.mParent;
        if (r0 != null) goto L7;
        setFragmentFactory(new AnonymousClass6(this));
        goto L10
    L7:
        return r0.mFragmentManager.getFragmentFactory();
    L10:
        return super.getFragmentFactory();
    }

    @Override // androidx.fragment.app.FragmentManager
    public List<Fragment> getFragments() {
        if (this.mAdded.isEmpty() == true) goto L5;
        ArrayList<Fragment> r0 = this.mAdded;
        monitor-enter(r0);
        List<Fragment> r1 = (List) this.mAdded.clone();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L11:
        th = move-exception;
        throw th;
    L5:
        return Collections.emptyList();
    }

    public LayoutInflater.Factory2 getLayoutInflaterFactory() {
        return this;
    }

    @Override // androidx.fragment.app.FragmentManager
    @Nullable
    public Fragment getPrimaryNavigationFragment() {
        return this.mPrimaryNav;
    }

    @NonNull
    public ViewModelStore getViewModelStore(@NonNull Fragment r1) {
        return this.mNonConfig.getViewModelStore(r1);
    }

    public void handleOnBackPressed() {
        execPendingActions();
        if (this.mOnBackPressedCallback.isEnabled() == false) goto L5;
        popBackStackImmediate();
        return;
    L5:
        this.mOnBackPressedDispatcher.onBackPressed();
    }

    public void hideFragment(Fragment r2) {
        if (DEBUG == false) goto L6;
        a.x("hide: ", r2, TAG);
    L6:
        if (r2.mHidden == true) goto L9;
        r2.mHidden = true;
        r2.mHiddenChanged = true ^ r2.mHiddenChanged;
        return;
    }

    @Override // androidx.fragment.app.FragmentManager
    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    public boolean isPrimaryNavigation(@Nullable Fragment r4) {
        if (r4 != null) goto L5;
        return true;
    L5:
        FragmentManagerImpl r1 = r4.mFragmentManager;
        if (r4 == r1.getPrimaryNavigationFragment()) goto L8;
    L10:
        return false;
    L8:
        if (isPrimaryNavigation(r1.mParent) == false) goto L10;
        return true;
    }

    public boolean isStateAtLeast(int r1) {
        if (this.mCurState < r1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.fragment.app.FragmentManager
    public boolean isStateSaved() {
        if (this.mStateSaved == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mStopped == true) goto L8;
        return false;
    }

    public AnimationOrAnimator loadAnimation(Fragment r5, int r6, boolean r7, int r8) {
        int r0 = r5.getNextAnim();
        r5.setNextAnim(0);
        ViewGroup r1 = r5.mContainer;
        if (r1 != null) goto L5;
    L7:
        Animation r2 = r5.onCreateAnimation(r6, r7, r0);
        if (r2 != null) goto L10;
        Animator r9 = r5.onCreateAnimator(r6, r7, r0);
        if (r9 != null) goto L14;
        if (r0 == 0) goto L35;
        boolean r10 = "anim".equals(this.mHost.getContext().getResources().getResourceTypeName(r0));
        if (r10 == true) goto L62;
    L60:
        Animator r3 = AnimatorInflater.loadAnimator(this.mHost.getContext(), r0);     // Catch: RuntimeException -> L28
        if (r3 == null) goto L35;
        return new AnimationOrAnimator(r3);
    L28:
        e = move-exception;
        if (r10 == true) goto L34;
        Animation r11 = AnimationUtils.loadAnimation(this.mHost.getContext(), r0);
        if (r11 == null) goto L35;
        return new AnimationOrAnimator(r11);
    L34:
        throw e;
    L62:
        Animation r4 = AnimationUtils.loadAnimation(this.mHost.getContext(), r0);     // Catch: Resources.NotFoundException -> L22 RuntimeException -> L59
        if (r4 == null) goto L35;
        return new AnimationOrAnimator(r4);
    L22:
        e = move-exception;
        throw e;
    L35:
        if (r6 != 0) goto L37;
        return null;
    L37:
        int r12 = transitToStyleIndex(r6, r7);
        if (r12 >= 0) goto L41;
        return null;
    L41:
        switch(r12) {
            case 1: goto L58;
            case 2: goto L56;
            case 3: goto L54;
            case 4: goto L52;
            case 5: goto L50;
            case 6: goto L48;
            default: goto L42;
        };
    L42:
        if (r8 == 0) goto L44;
    L46:
        return null;
    L44:
        if (this.mHost.onHasWindowAnimations() == false) goto L46;
        this.mHost.onGetWindowAnimations();
        goto L46
    L48:
        return makeFadeAnimation(1.0f, 0.0f);
    L50:
        return makeFadeAnimation(0.0f, 1.0f);
    L52:
        return makeOpenCloseAnimation(1.0f, 1.075f, 1.0f, 0.0f);
    L54:
        return makeOpenCloseAnimation(0.975f, 1.0f, 0.0f, 1.0f);
    L56:
        return makeOpenCloseAnimation(1.0f, 0.975f, 1.0f, 0.0f);
    L58:
        return makeOpenCloseAnimation(1.125f, 1.0f, 0.0f, 1.0f);
    L14:
        return new AnimationOrAnimator(r9);
    L10:
        return new AnimationOrAnimator(r2);
    L5:
        if (r1.getLayoutTransition() == null) goto L7;
        return null;
    }

    public void makeActive(Fragment r3) {
        if (this.mActive.get(r3.mWho) == null) goto L5;
        return;
    L5:
        this.mActive.put(r3.mWho, r3);
        if (r3.mRetainInstanceChangedWhileDetached == false) goto L13;
        if (r3.mRetainInstance == false) goto L10;
        addRetainedFragment(r3);
    L11:
        r3.mRetainInstanceChangedWhileDetached = false;
        goto L13
    L10:
        removeRetainedFragment(r3);
    L13:
        if (DEBUG == false) goto L16;
        a.x("Added fragment to active set ", r3, TAG);
        return;
    }

    public void makeInactive(Fragment r6) {
        if (this.mActive.get(r6.mWho) != null) goto L6;
        return;
    L6:
        if (DEBUG == false) goto L8;
        a.x("Removed fragment from active set ", r6, TAG);
    L8:
        Iterator<Fragment> r0 = this.mActive.values().iterator();
    L10:
        if (r0.hasNext() == false) goto L16;
        Fragment r1 = r0.next();
        if (r1 == null) goto L10;
        if (r6.mWho.equals(r1.mTargetWho) == false) goto L10;
        r1.mTarget = r6;
        r1.mTargetWho = null;
        goto L10
    L16:
        this.mActive.put(r6.mWho, null);
        removeRetainedFragment(r6);
        String r2 = r6.mTargetWho;
        if (r2 == null) goto L19;
        r6.mTarget = this.mActive.get(r2);
    L19:
        r6.initState();
    }

    public void moveFragmentToExpectedState(Fragment r11) {
        if (r11 != null) goto L5;
        return;
    L5:
        if (this.mActive.containsKey(r11.mWho) == false) goto L7;
        int r0 = this.mCurState;
        if (r11.mRemoving == false) goto L17;
        if (r11.isInBackStack() == false) goto L16;
        r0 = Math.min(r0, 1);
        goto L17
    L16:
        r0 = Math.min(r0, 0);
    L17:
        moveToState(r11, r0, r11.getNextTransition(), r11.getNextTransitionStyle(), false);
        if (r11.mView == null) goto L38;
        Fragment r1 = findFragmentUnder(r11);
        if (r1 == null) goto L25;
        View r2 = r1.mView;
        ViewGroup r3 = r11.mContainer;
        int r4 = r3.indexOfChild(r2);
        int r5 = r3.indexOfChild(r11.mView);
        if (r5 >= r4) goto L25;
        r3.removeViewAt(r5);
        r3.addView(r11.mView, r4);
    L25:
        if (r11.mIsNewlyAdded == false) goto L38;
        if (r11.mContainer == null) goto L38;
        float r6 = r11.mPostponedAlpha;
        if (r6 <= 0.0f) goto L31;
        r11.mView.setAlpha(r6);
    L31:
        r11.mPostponedAlpha = 0.0f;
        r11.mIsNewlyAdded = false;
        AnimationOrAnimator r7 = loadAnimation(r11, r11.getNextTransition(), true, r11.getNextTransitionStyle());
        if (r7 == null) goto L38;
        Animation r8 = r7.animation;
        if (r8 == null) goto L36;
        r11.mView.startAnimation(r8);
        goto L38
    L36:
        r7.animator.setTarget(r11.mView);
        r7.animator.start();
    L38:
        if (r11.mHiddenChanged == false) goto L42;
        completeShowHideFragment(r11);
        return;
    L42:
        return;
    L7:
        if (DEBUG == false) goto L41;
        Log.v(TAG, "Ignoring moving " + r11 + " to state " + this.mCurState + "since it is not added to " + this);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void moveToState(Fragment r19, int r20, int r21, int r22, boolean r23) {
        int r8 = 1;
        boolean r9 = true;
        boolean r10 = true;
        if (r19.mAdded == true) goto L5;
    L6:
        int r0 = r20;
        if (r0 <= 1) goto L11;
        r0 = 1;
    L11:
        if (r19.mRemoving == false) goto L20;
        int r1 = r19.mState;
        if (r0 <= r1) goto L20;
        if (r1 == 0) goto L16;
    L18:
        r0 = r19.mState;
        goto L20
    L16:
        if (r19.isInBackStack() == false) goto L18;
        r0 = 1;
    L20:
        if (r19.mDeferStart == true) goto L22;
    L25:
        Lifecycle.State r2 = r19.mMaxState;
        if (r2 != Lifecycle.State.CREATED) goto L29;
        int r3 = Math.min(r0, 1);
    L28:
        int r11 = r3;
        int r4 = r19.mState;
        if (r4 <= r11) goto L33;
        if (r4 <= r11) goto L269;
        if (r4 != 1) goto L162;
    L216:
        if (r11 >= 1) goto L269;
        if (this.mDestroyed == false) goto L226;
        if (r19.getAnimatingAway() == null) goto L223;
        View r5 = r19.getAnimatingAway();
        r19.setAnimatingAway(null);
        r5.clearAnimation();
        goto L226
    L223:
        if (r19.getAnimator() == null) goto L226;
        Animator r6 = r19.getAnimator();
        r19.setAnimator(null);
        r6.cancel();
    L226:
        if (r19.getAnimatingAway() == null) goto L228;
    L268:
        r19.setStateAfterAnimating(r11);
    L271:
        if (r19.mState == r8) goto L276;
        Log.w(TAG, "moveToState: Fragment state for " + r19 + " not updated inline; expected state " + r8 + " found " + r19.mState);
        r19.mState = r8;
        return;
    L276:
        return;
    L228:
        if (r19.getAnimator() != null) goto L268;
        if (DEBUG == false) goto L234;
        a.x("movefrom CREATED: ", r19, TAG);
    L234:
        if (r19.mRemoving == true) goto L236;
    L238:
        Object[] r7 = false;
    L239:
        if (r7 == false) goto L241;
    L244:
        FragmentHostCallback r12 = this.mHost;
        if ((r12 instanceof ViewModelStoreOwner) == false) goto L248;
        r10 = this.mNonConfig.isCleared();
    L250:
        if (r7 == true) goto L252;
        if (r10 == true) goto L252;
    L253:
        r19.performDestroy();
        dispatchOnFragmentDestroyed(r19, false);
    L254:
        r19.performDetach();
        dispatchOnFragmentDetached(r19, false);
        if (r23 == true) goto L269;
        if (r7 == false) goto L258;
    L267:
        makeInactive(r19);
        goto L269
    L258:
        if (this.mNonConfig.shouldDestroy(r19) == true) goto L267;
        r19.mHost = null;
        r19.mParentFragment = null;
        r19.mFragmentManager = null;
        String r13 = r19.mTargetWho;
        if (r13 == null) goto L269;
        Fragment r14 = this.mActive.get(r13);
        if (r14 == null) goto L269;
        if (r14.getRetainInstance() == false) goto L269;
        r19.mTarget = r14;
    L252:
        this.mNonConfig.clearNonConfigState(r19);
        goto L253
    L248:
        if ((r12.getContext() instanceof Activity) == false) goto L250;
        r10 = true ^ ((Activity) this.mHost.getContext()).isChangingConfigurations();
        goto L250
    L241:
        if (this.mNonConfig.shouldDestroy(r19) == true) goto L244;
        r19.mState = 0;
        goto L254
    L236:
        if (r19.isInBackStack() == true) goto L238;
        r7 = true;
        goto L239
    L162:
        if (r4 != 2) goto L164;
        int r15 = 2;
    L182:
        if (r11 >= r15) goto L216;
        if (DEBUG == false) goto L187;
        a.x("movefrom ACTIVITY_CREATED: ", r19, TAG);
    L187:
        if (r19.mView != null) goto L189;
    L193:
        r19.performDestroyView();
        dispatchOnFragmentViewDestroyed(r19, false);
        View r16 = r19.mView;
        if (r16 == null) goto L215;
        ViewGroup r17 = r19.mContainer;
        if (r17 == null) goto L215;
        r17.endViewTransition(r16);
        r19.mView.clearAnimation();
        if (r19.getParentFragment() == null) goto L202;
        if (r19.getParentFragment().mRemoving == true) goto L215;
    L202:
        if (this.mCurState > 0) goto L204;
    L210:
        AnimationOrAnimator r18 = null;
    L211:
        r19.mPostponedAlpha = 0.0f;
        if (r18 == null) goto L214;
        animateRemoveFragment(r19, r18, r11);
    L214:
        r19.mContainer.removeView(r19.mView);
        goto L215
    L204:
        if (this.mDestroyed == true) goto L210;
        if (r19.mView.getVisibility() != 0) goto L210;
        if (r19.mPostponedAlpha < 0.0f) goto L210;
        r18 = loadAnimation(r19, r21, false, r22);
    L215:
        r19.mContainer = null;
        r19.mView = null;
        r19.mViewLifecycleOwner = null;
        r19.mViewLifecycleOwnerLiveData.setValue(null);
        r19.mInnerView = null;
        r19.mInLayout = false;
        goto L216
    L189:
        if (this.mHost.onShouldSaveFragmentState(r19) == false) goto L193;
        if (r19.mSavedViewState != null) goto L193;
        saveFragmentViewState(r19);
        goto L193
    L164:
        if (r4 != 3) goto L166;
        int r24 = 3;
    L175:
        if (r11 < r24) goto L177;
    L180:
        r15 = 2;
        goto L182
    L177:
        if (DEBUG == false) goto L179;
        a.x("movefrom STARTED: ", r19, TAG);
    L179:
        r19.performStop();
        dispatchOnFragmentStopped(r19, false);
        goto L180
    L166:
        if (r4 != 4) goto L269;
        if (r11 < 4) goto L170;
    L173:
        r24 = 3;
        goto L175
    L170:
        if (DEBUG == false) goto L172;
        a.x("movefrom RESUMED: ", r19, TAG);
    L172:
        r19.performPause();
        dispatchOnFragmentPaused(r19, false);
    L269:
        r8 = r11;
        goto L271
    L33:
        if (r19.mFromLayout == false) goto L38;
        if (r19.mInLayout == true) goto L38;
        return;
    L38:
        if (r19.getAnimatingAway() == null) goto L40;
    L41:
        r19.setAnimatingAway(null);
        r19.setAnimator(null);
        moveToState(r19, r19.getStateAfterAnimating(), 0, 0, true);
    L42:
        int r25 = r19.mState;
        if (r25 == 0) goto L50;
        if (r25 == 1) goto L105;
        if (r25 == 2) goto L49;
        if (r25 != 3) goto L269;
        int r26 = 3;
    L154:
        if (r11 <= r26) goto L269;
        if (DEBUG == false) goto L158;
        a.x("moveto RESUMED: ", r19, TAG);
    L158:
        r19.performResume();
        dispatchOnFragmentResumed(r19, false);
        r19.mSavedFragmentState = null;
        r19.mSavedViewState = null;
        goto L269
    L49:
        int r27 = 2;
    L148:
        if (r11 > r27) goto L150;
    L153:
        r26 = 3;
        goto L154
    L150:
        if (DEBUG == false) goto L152;
        a.x("moveto STARTED: ", r19, TAG);
    L152:
        r19.performStart();
        dispatchOnFragmentStarted(r19, false);
    L105:
        if (r11 <= 0) goto L107;
        ensureInflatedFragmentView(r19);
    L107:
        if (r11 > 1) goto L109;
    L147:
        r27 = 2;
        goto L148
    L109:
        if (DEBUG == false) goto L112;
        a.x("moveto ACTIVITY_CREATED: ", r19, TAG);
    L112:
        if (r19.mFromLayout == true) goto L143;
        int r28 = r19.mContainerId;
        if (r28 != 0) goto L116;
        ViewGroup r29 = null;
    L127:
        r19.mContainer = r29;
        r19.performCreateView(r19.performGetLayoutInflater(r19.mSavedFragmentState), r29, r19.mSavedFragmentState);
        View r30 = r19.mView;
        if (r30 == null) goto L142;
        r19.mInnerView = r30;
        r30.setSaveFromParentEnabled(false);
        if (r29 == null) goto L133;
        r29.addView(r19.mView);
    L133:
        if (r19.mHidden == false) goto L135;
        r19.mView.setVisibility(8);
    L135:
        r19.onViewCreated(r19.mView, r19.mSavedFragmentState);
        dispatchOnFragmentViewCreated(r19, r19.mView, r19.mSavedFragmentState, false);
        if (r19.mView.getVisibility() == 0) goto L138;
    L140:
        r9 = false;
    L141:
        r19.mIsNewlyAdded = r9;
        goto L143
    L138:
        if (r19.mContainer == null) goto L140;
    L142:
        r19.mInnerView = null;
        goto L143
    L116:
        if (r28 != (-1)) goto L118;
        throwException(new IllegalArgumentException(a.i("Cannot create fragment ", r19, " for a container view with no id")));
    L118:
        r29 = (ViewGroup) this.mContainer.onFindViewById(r19.mContainerId);
        if (r29 != null) goto L127;
        if (r19.mRestored == true) goto L127;
        String r31 = r19.getResources().getResourceName(r19.mContainerId);     // Catch: Resources.NotFoundException -> L124
    L125:
        throwException(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(r19.mContainerId) + " (" + r31 + ") for fragment " + r19));
    L124:
        r31 = EnvironmentCompat.MEDIA_UNKNOWN;
    L143:
        r19.performActivityCreated(r19.mSavedFragmentState);
        dispatchOnFragmentActivityCreated(r19, r19.mSavedFragmentState, false);
        if (r19.mView == null) goto L146;
        r19.restoreViewState(r19.mSavedFragmentState);
    L146:
        r19.mSavedFragmentState = null;
        goto L147
    L50:
        if (r11 <= 0) goto L105;
        if (DEBUG == false) goto L54;
        a.x("moveto CREATED: ", r19, TAG);
    L54:
        Bundle r32 = r19.mSavedFragmentState;
        if (r32 == null) goto L72;
        r32.setClassLoader(this.mHost.getContext().getClassLoader());
        r19.mSavedViewState = r19.mSavedFragmentState.getSparseParcelableArray(VIEW_STATE_TAG);
        Fragment r33 = getFragment(r19.mSavedFragmentState, TARGET_STATE_TAG);
        if (r33 == null) goto L59;
        String r34 = r33.mWho;
    L60:
        r19.mTargetWho = r34;
        if (r34 == null) goto L63;
        r19.mTargetRequestCode = r19.mSavedFragmentState.getInt(TARGET_REQUEST_CODE_STATE_TAG, 0);
    L63:
        Boolean r35 = r19.mSavedUserVisibleHint;
        if (r35 == null) goto L66;
        r19.mUserVisibleHint = r35.booleanValue();
        r19.mSavedUserVisibleHint = null;
    L68:
        if (r19.mUserVisibleHint == true) goto L72;
        r19.mDeferStart = true;
        if (r11 <= 2) goto L72;
        r11 = 2;
        goto L72
    L66:
        r19.mUserVisibleHint = r19.mSavedFragmentState.getBoolean(USER_VISIBLE_HINT_TAG, true);
        goto L68
    L59:
        r34 = null;
    L72:
        FragmentHostCallback r36 = this.mHost;
        r19.mHost = r36;
        Fragment r37 = this.mParent;
        r19.mParentFragment = r37;
        if (r37 == null) goto L75;
        FragmentManagerImpl r38 = r37.mChildFragmentManager;
    L76:
        r19.mFragmentManager = r38;
        Fragment r39 = r19.mTarget;
        String r40 = " declared target fragment ";
        String r41 = "Fragment ";
        if (r39 == null) goto L87;
        Fragment r42 = this.mActive.get(r39.mWho);
        Fragment r43 = r19.mTarget;
        if (r42 != r43) goto L86;
        if (r43.mState >= 1) goto L84;
        moveToState(r43, 1, 0, 0, true);
    L84:
        r19.mTargetWho = r19.mTarget.mWho;
        r19.mTarget = null;
    L88:
        String r44 = r19.mTargetWho;
        if (r44 == null) goto L97;
        Fragment r45 = this.mActive.get(r44);
        if (r45 != null) goto L93;
        StringBuilder r46 = new StringBuilder(r41);
        r46.append(r19);
        r46.append(r40);
        throw new IllegalStateException(a.o(r46, r19.mTargetWho, " that does not belong to this FragmentManager!"));
    L93:
        if (r45.mState >= 1) goto L97;
        moveToState(r45, 1, 0, 0, true);
    L97:
        dispatchOnFragmentPreAttached(r19, this.mHost.getContext(), false);
        r19.performAttach();
        Fragment r47 = r19.mParentFragment;
        if (r47 != null) goto L100;
        this.mHost.onAttachFragment(r19);
    L101:
        dispatchOnFragmentAttached(r19, this.mHost.getContext(), false);
        if (r19.mIsCreated == true) goto L104;
        dispatchOnFragmentPreCreated(r19, r19.mSavedFragmentState, false);
        r19.performCreate(r19.mSavedFragmentState);
        dispatchOnFragmentCreated(r19, r19.mSavedFragmentState, false);
        goto L105
    L104:
        r19.restoreChildFragmentState(r19.mSavedFragmentState);
        r19.mState = 1;
        goto L105
    L100:
        r47.onAttachFragment(r19);
        goto L101
    L86:
        throw new IllegalStateException("Fragment " + r19 + " declared target fragment " + r19.mTarget + " that does not belong to this FragmentManager!");
    L87:
        r41 = "Fragment ";
        r40 = " declared target fragment ";
        goto L88
    L75:
        r38 = r36.mFragmentManager;
        goto L76
    L40:
        if (r19.getAnimator() == null) goto L42;
    L29:
        r3 = Math.min(r0, r2.ordinal());
        goto L28
    L22:
        if (r19.mState >= 3) goto L25;
        if (r0 <= 2) goto L25;
        r0 = 2;
        goto L25
    L5:
        if (r19.mDetached == true) goto L6;
        r0 = r20;
        goto L11
    }

    public void noteStateNotSaved() {
        int r0 = 0;
        this.mStateSaved = false;
        this.mStopped = false;
        int r1 = this.mAdded.size();
    L3:
        if (r0 >= r1) goto L8;
        Fragment r2 = this.mAdded.get(r0);
        if (r2 == null) goto L7;
        r2.noteStateNotSaved();
    L7:
        r0 = r0 + 1;
        goto L3
    }

    @Override // android.view.LayoutInflater.Factory2
    @Nullable
    public View onCreateView(@Nullable View r12, @NonNull String r13, @NonNull Context r14, @NonNull AttributeSet r15) {
        Fragment r3 = null;
        if ("fragment".equals(r13) == true) goto L5;
        return null;
    L5:
        String r2 = r15.getAttributeValue(null, "class");
        TypedArray r4 = r14.obtainStyledAttributes(r15, FragmentTag.Fragment);
        int r6 = 0;
        if (r2 != null) goto L8;
        r2 = r4.getString(0);
    L8:
        String r7 = r2;
        int r9 = r4.getResourceId(1, -1);
        String r10 = r4.getString(2);
        r4.recycle();
        if (r7 != null) goto L11;
    L61:
        return null;
    L11:
        if (FragmentFactory.isFragmentClass(r14.getClassLoader(), r7) == false) goto L61;
        if (r12 == null) goto L15;
        r6 = r12.getId();
    L15:
        if (r6 != (-1)) goto L21;
        if (r9 != (-1)) goto L21;
        if (r10 != null) goto L21;
        throw new IllegalArgumentException(r15.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + r7);
    L21:
        if (r9 == (-1)) goto L23;
        r3 = findFragmentById(r9);
    L23:
        if (r3 != null) goto L26;
        if (r10 == null) goto L26;
        r3 = findFragmentByTag(r10);
    L26:
        if (r3 != null) goto L30;
        if (r6 == (-1)) goto L30;
        r3 = findFragmentById(r6);
    L30:
        if (DEBUG == false) goto L32;
        Log.v(TAG, "onCreateView: id=0x" + Integer.toHexString(r9) + " fname=" + r7 + " existing=" + r3);
    L32:
        if (r3 != null) goto L40;
        r3 = getFragmentFactory().instantiate(r14.getClassLoader(), r7);
        r3.mFromLayout = true;
        if (r9 == 0) goto L36;
        int r5 = r9;
    L37:
        r3.mFragmentId = r5;
        r3.mContainerId = r6;
        r3.mTag = r10;
        r3.mInLayout = true;
        r3.mFragmentManager = this;
        FragmentHostCallback r8 = this.mHost;
        r3.mHost = r8;
        r3.onInflate(r8.getContext(), r15, r3.mSavedFragmentState);
        addFragment(r3, true);
    L38:
        Fragment r11 = r3;
        if (this.mCurState < 1) goto L45;
    L47:
        moveToState(r11);
    L48:
        View r0 = r11.mView;
        if (r0 == null) goto L58;
        if (r9 == 0) goto L53;
        r0.setId(r9);
    L53:
        if (r11.mView.getTag() != null) goto L56;
        r11.mView.setTag(r10);
    L56:
        return r11.mView;
    L58:
        throw new IllegalStateException(a.k("Fragment ", r7, " did not create a view."));
    L45:
        if (r11.mFromLayout == false) goto L47;
        moveToState(r11, 1, 0, 0, false);
        goto L48
    L36:
        r5 = r6;
        goto L37
    L40:
        if (r3.mInLayout == true) goto L60;
        r3.mInLayout = true;
        FragmentHostCallback r16 = this.mHost;
        r3.mHost = r16;
        r3.onInflate(r16.getContext(), r15, r3.mSavedFragmentState);
        goto L38
    L60:
        throw new IllegalArgumentException(r15.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(r9) + ", tag " + r10 + ", or parent id 0x" + Integer.toHexString(r6) + " with another fragment for " + r7);
    }

    public void performPendingDeferredStart(Fragment r8) {
        if (r8.mDeferStart == true) goto L5;
        return;
    L5:
        if (this.mExecutingActions == false) goto L8;
        this.mHavePendingDeferredStart = true;
        return;
    L8:
        r8.mDeferStart = false;
        moveToState(r8, this.mCurState, 0, 0, false);
    }

    @Override // androidx.fragment.app.FragmentManager
    public void popBackStack() {
        enqueueAction(new PopBackStackState(this, null, -1, 0), false);
    }

    @Override // androidx.fragment.app.FragmentManager
    public boolean popBackStackImmediate() {
        checkStateLoss();
        return popBackStackImmediate(null, -1, 0);
    }

    public boolean popBackStackState(ArrayList<BackStackRecord> r6, ArrayList<Boolean> r7, String r8, int r9, int r10) {
        ArrayList<BackStackRecord> r0 = this.mBackStack;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r8 != null) goto L14;
        if (r9 >= 0) goto L14;
        if ((r10 & 1) != 0) goto L14;
        int r11 = r0.size() - 1;
        if (r11 >= 0) goto L13;
        return false;
    L13:
        r6.add(this.mBackStack.remove(r11));
        r7.add(Boolean.TRUE);
    L51:
        return true;
    L14:
        if (r8 != null) goto L18;
        if (r9 >= 0) goto L18;
        int r12 = -1;
    L46:
        if (r12 != (this.mBackStack.size() - 1)) goto L48;
        return false;
    L48:
        int r13 = this.mBackStack.size() - 1;
    L49:
        if (r13 <= r12) goto L51;
        r6.add(this.mBackStack.remove(r13));
        r7.add(Boolean.TRUE);
        r13 = r13 - 1;
    L18:
        int r1 = r0.size() - 1;
    L19:
        if (r1 < 0) goto L30;
        BackStackRecord r3 = this.mBackStack.get(r1);
        if (r8 != null) goto L23;
    L25:
        if (r9 < 0) goto L29;
        if (r9 == r3.mIndex) goto L30;
    L29:
        r1 = r1 - 1;
        goto L19
    L23:
        if (r8.equals(r3.getName()) == false) goto L25;
    L30:
        if (r1 >= 0) goto L33;
        return false;
    L33:
        if ((r10 & 1) == 0) goto L44;
    L34:
        r1 = r1 - 1;
        if (r1 < 0) goto L44;
        BackStackRecord r14 = this.mBackStack.get(r1);
        if (r8 == null) goto L40;
        if (r8.equals(r14.getName()) == true) goto L34;
    L40:
        if (r9 < 0) goto L44;
        if (r9 == r14.mIndex) goto L34;
    L44:
        r12 = r1;
        goto L46
    }

    @Override // androidx.fragment.app.FragmentManager
    public void putFragment(Bundle r4, String r5, Fragment r6) {
        if (r6.mFragmentManager == this) goto L5;
        throwException(new IllegalStateException(a.i("Fragment ", r6, " is not currently in the FragmentManager")));
    L5:
        r4.putString(r5, r6.mWho);
    }

    @Override // androidx.fragment.app.FragmentManager
    public void registerFragmentLifecycleCallbacks(@NonNull FragmentManager.FragmentLifecycleCallbacks r2, boolean r3) {
        this.mLifecycleCallbacks.add(new FragmentLifecycleCallbacksHolder(r2, r3));
    }

    public void removeFragment(Fragment r4) {
        if (DEBUG == false) goto L5;
        Log.v(TAG, "remove: " + r4 + " nesting=" + r4.mBackStackNesting);
    L5:
        boolean r0 = !r4.isInBackStack();
        if (r4.mDetached == false) goto L8;
        if (r0 == true) goto L8;
        return;
    L8:
        ArrayList<Fragment> r1 = this.mAdded;
        monitor-enter(r1);
        this.mAdded.remove(r4);     // Catch: Throwable -> L17
        monitor-exit(r1);     // Catch: Throwable -> L17
        if (isMenuAvailable(r4) == false) goto L15;
        this.mNeedMenuInvalidate = true;
    L15:
        r4.mAdded = false;
        r4.mRemoving = true;
        return;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // androidx.fragment.app.FragmentManager
    public void removeOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener r1) {
        ArrayList<FragmentManager.OnBackStackChangedListener> r0 = this.mBackStackChangeListeners;
        if (r0 == null) goto L6;
        r0.remove(r1);
        return;
    }

    public void removeRetainedFragment(@NonNull Fragment r3) {
        if (isStateSaved() == false) goto L9;
        if (DEBUG == false) goto L14;
        Log.v(TAG, "Ignoring removeRetainedFragment as the state is already saved");
        return;
    L14:
        return;
    L9:
        if (this.mNonConfig.removeRetainedFragment(r3) == true) goto L11;
        return;
    L11:
        if (DEBUG == false) goto L16;
        a.x("Updating retained Fragments: Removed ", r3, TAG);
        return;
    }

    public void reportBackStackChanged() {
        if (this.mBackStackChangeListeners == null) goto L8;
        int r0 = 0;
    L6:
        if (r0 >= this.mBackStackChangeListeners.size()) goto L10;
        this.mBackStackChangeListeners.get(r0).onBackStackChanged();
        r0 = r0 + 1;
        goto L6
    L10:
        return;
    }

    public void restoreAllState(Parcelable r3, FragmentManagerNonConfig r4) {
        if ((this.mHost instanceof ViewModelStoreOwner) == false) goto L5;
        throwException(new IllegalStateException("You must use restoreSaveState when your FragmentHostCallback implements ViewModelStoreOwner"));
    L5:
        this.mNonConfig.restoreFromSnapshot(r4);
        restoreSaveState(r3);
    }

    public void restoreSaveState(Parcelable r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        FragmentManagerState r13 = (FragmentManagerState) r12;
        if (r13.mActive != null) goto L7;
        return;
    L7:
        Iterator<Fragment> r0 = this.mNonConfig.getRetainedFragments().iterator();
    L9:
        if (r0.hasNext() == false) goto L32;
        Fragment r1 = r0.next();
        if (DEBUG == false) goto L13;
        a.x("restoreSaveState: re-attaching retained ", r1, TAG);
    L13:
        Iterator<FragmentState> r5 = r13.mActive.iterator();
    L15:
        if (r5.hasNext() == false) goto L19;
        FragmentState r6 = r5.next();
        if (r6.mWho.equals(r1.mWho) == false) goto L15;
    L20:
        if (r6 == null) goto L22;
        r6.mInstance = r1;
        r1.mSavedViewState = null;
        r1.mBackStackNesting = 0;
        r1.mInLayout = false;
        r1.mAdded = false;
        Fragment r2 = r1.mTarget;
        if (r2 == null) goto L28;
        String r3 = r2.mWho;
    L29:
        r1.mTargetWho = r3;
        r1.mTarget = null;
        Bundle r4 = r6.mSavedFragmentState;
        if (r4 == null) goto L9;
        r4.setClassLoader(this.mHost.getContext().getClassLoader());
        r1.mSavedViewState = r6.mSavedFragmentState.getSparseParcelableArray(VIEW_STATE_TAG);
        r1.mSavedFragmentState = r6.mSavedFragmentState;
        goto L9
    L28:
        r3 = null;
        goto L29
    L22:
        if (DEBUG == false) goto L24;
        Log.v(TAG, "Discarding retained Fragment " + r1 + " that was not found in the set of active Fragments " + r13.mActive);
    L24:
        moveToState(r1, 1, 0, 0, false);
        r1.mRemoving = true;
        moveToState(r1, 0, 0, 0, false);
        goto L9
    L19:
        r6 = null;
        goto L20
    L32:
        this.mActive.clear();
        Iterator<FragmentState> r7 = r13.mActive.iterator();
    L34:
        if (r7.hasNext() == false) goto L41;
        FragmentState r8 = r7.next();
        if (r8 == null) goto L34;
        Fragment r9 = r8.instantiate(this.mHost.getContext().getClassLoader(), getFragmentFactory());
        r9.mFragmentManager = this;
        if (DEBUG == false) goto L40;
        Log.v(TAG, "restoreSaveState: active (" + r9.mWho + "): " + r9);
    L40:
        this.mActive.put(r9.mWho, r9);
        r8.mInstance = null;
        goto L34
    L41:
        this.mAdded.clear();
        ArrayList<String> r10 = r13.mAdded;
        if (r10 == null) goto L65;
        Iterator<String> r11 = r10.iterator();
    L45:
        if (r11.hasNext() == false) goto L65;
        String r14 = r11.next();
        Fragment r15 = this.mActive.get(r14);
        if (r15 != null) goto L49;
        throwException(new IllegalStateException(a.k("No instantiated fragment for (", r14, ")")));
    L49:
        r15.mAdded = true;
        if (DEBUG == false) goto L53;
        Log.v(TAG, "restoreSaveState: added (" + r14 + "): " + r15);
    L53:
        if (this.mAdded.contains(r15) == true) goto L63;
        ArrayList<Fragment> r16 = this.mAdded;
        monitor-enter(r16);
        this.mAdded.add(r15);     // Catch: Throwable -> L59
        monitor-exit(r16);     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        throw th;
    L63:
        throw new IllegalStateException("Already added " + r15);
    L65:
        if (r13.mBackStack == null) goto L76;
        this.mBackStack = new ArrayList(r13.mBackStack.length);
        int r17 = 0;
    L67:
        BackStackState[] r18 = r13.mBackStack;
        if (r17 >= r18.length) goto L77;
        BackStackRecord r19 = r18[r17].instantiate(this);
        if (DEBUG == false) goto L72;
        StringBuilder r20 = a.p(r17, "restoreAllState: back stack #", " (index ");
        r20.append(r19.mIndex);
        r20.append("): ");
        r20.append(r19);
        Log.v(TAG, r20.toString());
        PrintWriter r21 = new PrintWriter(new LogWriter(TAG));
        r19.dump("  ", r21, false);
        r21.close();
    L72:
        this.mBackStack.add(r19);
        int r22 = r19.mIndex;
        if (r22 < 0) goto L75;
        setBackStackIndex(r22, r19);
    L75:
        r17 = r17 + 1;
    L77:
        String r23 = r13.mPrimaryNavActiveWho;
        if (r23 == null) goto L80;
        Fragment r24 = this.mActive.get(r23);
        this.mPrimaryNav = r24;
        dispatchParentPrimaryNavigationFragmentChanged(r24);
    L80:
        this.mNextFragmentIndex = r13.mNextFragmentIndex;
        return;
    L76:
        this.mBackStack = null;
        goto L77
    }

    @Deprecated
    public FragmentManagerNonConfig retainNonConfig() {
        if ((this.mHost instanceof ViewModelStoreOwner) == false) goto L6;
        throwException(new IllegalStateException("You cannot use retainNonConfig when your FragmentHostCallback implements ViewModelStoreOwner."));
    L6:
        return this.mNonConfig.getSnapshot();
    }

    public Parcelable saveAllState() {
        forcePostponedTransactions();
        endAnimatingAwayFragments();
        execPendingActions();
        this.mStateSaved = true;
        BackStackState[] r2 = null;
        if (this.mActive.isEmpty() == false) goto L5;
        return null;
    L5:
        ArrayList<FragmentState> r3 = new ArrayList(this.mActive.size());
        Iterator<Fragment> r1 = this.mActive.values().iterator();
        int r4 = 0;
        boolean r5 = false;
    L7:
        if (r1.hasNext() == false) goto L33;
        Fragment r6 = r1.next();
        if (r6 == null) goto L7;
        if (r6.mFragmentManager == this) goto L13;
        throwException(new IllegalStateException(a.i("Failure saving state: active ", r6, " was removed from the FragmentManager")));
    L13:
        FragmentState r7 = new FragmentState(r6);
        r3.add(r7);
        if (r6.mState > 0) goto L16;
    L28:
        r7.mSavedFragmentState = r6.mSavedFragmentState;
    L30:
        if (DEBUG == false) goto L32;
        Log.v(TAG, "Saved state of " + r6 + ": " + r7.mSavedFragmentState);
    L32:
        r5 = true;
        goto L7
    L16:
        if (r7.mSavedFragmentState != null) goto L28;
        r7.mSavedFragmentState = saveFragmentBasicState(r6);
        String r8 = r6.mTargetWho;
        if (r8 == null) goto L30;
        Fragment r9 = this.mActive.get(r8);
        if (r9 != null) goto L23;
        throwException(new IllegalStateException("Failure saving state: " + r6 + " has target not in fragment manager: " + r6.mTargetWho));
    L23:
        if (r7.mSavedFragmentState != null) goto L25;
        r7.mSavedFragmentState = new Bundle();
    L25:
        putFragment(r7.mSavedFragmentState, TARGET_STATE_TAG, r9);
        int r10 = r6.mTargetRequestCode;
        if (r10 == 0) goto L30;
        r7.mSavedFragmentState.putInt(TARGET_REQUEST_CODE_STATE_TAG, r10);
        goto L30
    L33:
        if (r5 == false) goto L35;
        int r0 = this.mAdded.size();
        if (r0 <= 0) goto L49;
        ArrayList<String> r11 = new ArrayList(r0);
        Iterator<Fragment> r12 = this.mAdded.iterator();
    L42:
        if (r12.hasNext() == false) goto L50;
        Fragment r13 = r12.next();
        r11.add(r13.mWho);
        if (r13.mFragmentManager == this) goto L47;
        throwException(new IllegalStateException(a.i("Failure saving state: active ", r13, " was removed from the FragmentManager")));
    L47:
        if (DEBUG == false) goto L42;
        Log.v(TAG, "saveAllState: adding fragment (" + r13.mWho + "): " + r13);
    L50:
        ArrayList<BackStackRecord> r14 = this.mBackStack;
        if (r14 == null) goto L60;
        int r15 = r14.size();
        if (r15 <= 0) goto L60;
        r2 = new BackStackState[r15];
    L55:
        if (r4 >= r15) goto L60;
        r2[r4] = new BackStackState(this.mBackStack.get(r4));
        if (DEBUG == false) goto L59;
        StringBuilder r16 = a.p(r4, "saveAllState: adding back stack #", ": ");
        r16.append(this.mBackStack.get(r4));
        Log.v(TAG, r16.toString());
    L59:
        r4 = r4 + 1;
    L60:
        FragmentManagerState r17 = new FragmentManagerState();
        r17.mActive = r3;
        r17.mAdded = r11;
        r17.mBackStack = r2;
        Fragment r18 = this.mPrimaryNav;
        if (r18 == null) goto L63;
        r17.mPrimaryNavActiveWho = r18.mWho;
    L63:
        r17.mNextFragmentIndex = this.mNextFragmentIndex;
        return r17;
    L49:
        r11 = null;
        goto L50
    L35:
        if (DEBUG == false) goto L37;
        Log.v(TAG, "saveAllState: no fragments!");
    L37:
        return null;
    }

    public Bundle saveFragmentBasicState(Fragment r3) {
        if (this.mStateBundle != null) goto L5;
        this.mStateBundle = new Bundle();
    L5:
        r3.performSaveInstanceState(this.mStateBundle);
        dispatchOnFragmentSaveInstanceState(r3, this.mStateBundle, false);
        Bundle r1 = null;
        if (this.mStateBundle.isEmpty() == true) goto L9;
        Bundle r0 = this.mStateBundle;
        this.mStateBundle = null;
        r1 = r0;
    L9:
        if (r3.mView == null) goto L12;
        saveFragmentViewState(r3);
    L12:
        if (r3.mSavedViewState == null) goto L17;
        if (r1 != null) goto L15;
        r1 = new Bundle();
    L15:
        r1.putSparseParcelableArray(VIEW_STATE_TAG, r3.mSavedViewState);
    L17:
        if (r3.mUserVisibleHint == true) goto L21;
        if (r1 != null) goto L20;
        r1 = new Bundle();
    L20:
        r1.putBoolean(USER_VISIBLE_HINT_TAG, r3.mUserVisibleHint);
    L21:
        return r1;
    }

    @Override // androidx.fragment.app.FragmentManager
    @Nullable
    public Fragment.SavedState saveFragmentInstanceState(@NonNull Fragment r4) {
        if (r4.mFragmentManager == this) goto L6;
        throwException(new IllegalStateException(a.i("Fragment ", r4, " is not currently in the FragmentManager")));
    L6:
        if (r4.mState <= 0) goto L11;
        Bundle r3 = saveFragmentBasicState(r4);
        if (r3 != null) goto L10;
        return null;
    L10:
        return new Fragment.SavedState(r3);
    L11:
        return null;
    }

    public void saveFragmentViewState(Fragment r3) {
        if (r3.mInnerView != null) goto L5;
        return;
    L5:
        SparseArray<Parcelable> r0 = this.mStateArray;
        if (r0 != null) goto L8;
        this.mStateArray = new SparseArray();
    L9:
        r3.mInnerView.saveHierarchyState(this.mStateArray);
        if (this.mStateArray.size() <= 0) goto L13;
        r3.mSavedViewState = this.mStateArray;
        this.mStateArray = null;
        return;
    L13:
        return;
    L8:
        r0.clear();
        goto L9
    }

    public void scheduleCommit() {
        monitor-enter(this);
        ArrayList<StartEnterTransitionListener> r0 = this.mPostponedTransactions;     // Catch: Throwable -> L8
        boolean r1 = false;
        if (r0 != null) goto L6;
    L10:
        boolean r2 = false;
    L11:
        ArrayList<OpGenerator> r3 = this.mPendingActions;     // Catch: Throwable -> L8
        if (r3 != null) goto L14;
    L16:
        if (r2 == true) goto L18;
        if (r1 == true) goto L18;
    L19:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L18:
        this.mHost.getHandler().removeCallbacks(this.mExecCommit);     // Catch: Throwable -> L8
        this.mHost.getHandler().post(this.mExecCommit);     // Catch: Throwable -> L8
        updateOnBackPressedCallbackEnabled();     // Catch: Throwable -> L8
        goto L19
    L14:
        if (r3.size() != 1) goto L16;
        r1 = true;
        goto L16
    L6:
        if (r0.isEmpty() == true) goto L10;
        r2 = true;
    L8:
        th = move-exception;
        throw th;
    }

    public void setBackStackIndex(int r5, BackStackRecord r6) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mBackStackIndices != null) goto L9;
        this.mBackStackIndices = new ArrayList();     // Catch: Throwable -> L7
    L9:
        int r1 = this.mBackStackIndices.size();     // Catch: Throwable -> L7
        if (r5 < r1) goto L12;
    L15:
        if (r1 >= r5) goto L24;
        this.mBackStackIndices.add(null);     // Catch: Throwable -> L7
        if (this.mAvailBackStackIndices != null) goto L20;
        this.mAvailBackStackIndices = new ArrayList();     // Catch: Throwable -> L7
    L20:
        if (DEBUG == false) goto L22;
        Log.v(TAG, "Adding available back stack index " + r1);     // Catch: Throwable -> L7
    L22:
        this.mAvailBackStackIndices.add(Integer.valueOf(r1));     // Catch: Throwable -> L7
        r1 = r1 + 1;     // Catch: Throwable -> L7
        goto L15
    L24:
        if (DEBUG == false) goto L26;
        Log.v(TAG, "Adding back stack index " + r5 + " with " + r6);     // Catch: Throwable -> L7
    L26:
        this.mBackStackIndices.add(r6);     // Catch: Throwable -> L7
    L27:
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L12:
        if (DEBUG == false) goto L14;
        Log.v(TAG, "Setting back stack index " + r5 + " to " + r6);     // Catch: Throwable -> L7
    L14:
        this.mBackStackIndices.set(r5, r6);     // Catch: Throwable -> L7
        goto L27
    }

    public void setMaxLifecycle(Fragment r3, Lifecycle.State r4) {
        if (this.mActive.get(r3.mWho) != r3) goto L11;
        if (r3.mHost != null) goto L7;
    L8:
        r3.mMaxState = r4;
        return;
    L7:
        if (r3.getFragmentManager() == this) goto L8;
    L11:
        throw new IllegalArgumentException("Fragment " + r3 + " is not an active fragment of FragmentManager " + this);
    }

    public void setPrimaryNavigationFragment(Fragment r4) {
        if (r4 != null) goto L4;
    L12:
        Fragment r0 = this.mPrimaryNav;
        this.mPrimaryNav = r4;
        dispatchParentPrimaryNavigationFragmentChanged(r0);
        dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
        return;
    L4:
        if (this.mActive.get(r4.mWho) != r4) goto L11;
        if (r4.mHost == null) goto L12;
        if (r4.getFragmentManager() == this) goto L12;
    L11:
        throw new IllegalArgumentException("Fragment " + r4 + " is not an active fragment of FragmentManager " + this);
    }

    public void showFragment(Fragment r2) {
        if (DEBUG == false) goto L6;
        a.x("show: ", r2, TAG);
    L6:
        if (r2.mHidden == false) goto L9;
        r2.mHidden = false;
        r2.mHiddenChanged = !r2.mHiddenChanged;
        return;
    }

    public void startPendingDeferredFragments() {
        Iterator<Fragment> r0 = this.mActive.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Fragment r1 = r0.next();
        if (r1 == null) goto L4;
        performPendingDeferredStart(r1);
        goto L4
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(128);
        r0.append("FragmentManager{");
        r0.append(Integer.toHexString(System.identityHashCode(this)));
        r0.append(" in ");
        Fragment r1 = this.mParent;
        if (r1 == null) goto L5;
        DebugUtils.buildShortClassTag(r1, r0);
    L6:
        r0.append("}}");
        return r0.toString();
    L5:
        DebugUtils.buildShortClassTag(this.mHost, r0);
        goto L6
    }

    @Override // androidx.fragment.app.FragmentManager
    public void unregisterFragmentLifecycleCallbacks(@NonNull FragmentManager.FragmentLifecycleCallbacks r5) {
        CopyOnWriteArrayList<FragmentLifecycleCallbacksHolder> r0 = this.mLifecycleCallbacks;
        monitor-enter(r0);
        int r1 = this.mLifecycleCallbacks.size();     // Catch: Throwable -> L9
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L12;
        if (this.mLifecycleCallbacks.get(r2).mCallback == r5) goto L8;
        r2 = r2 + 1;     // Catch: Throwable -> L9
        goto L5
    L8:
        this.mLifecycleCallbacks.remove(r2);     // Catch: Throwable -> L9
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // androidx.fragment.app.FragmentManager
    public void popBackStack(@Nullable String r3, int r4) {
        enqueueAction(new PopBackStackState(this, r3, -1, r4), false);
    }

    @Override // androidx.fragment.app.FragmentManager
    public void popBackStack(int r3, int r4) {
        if (r3 < 0) goto L6;
        enqueueAction(new PopBackStackState(this, null, r3, r4), false);
        return;
    L6:
        throw new IllegalArgumentException(a.e(r3, "Bad id: "));
    }

    @Override // androidx.fragment.app.FragmentManager
    public boolean popBackStackImmediate(@Nullable String r2, int r3) {
        checkStateLoss();
        return popBackStackImmediate(r2, -1, r3);
    }

    @Override // androidx.fragment.app.FragmentManager
    public boolean popBackStackImmediate(int r2, int r3) {
        checkStateLoss();
        execPendingActions();
        if (r2 < 0) goto L7;
        return popBackStackImmediate(null, r2, r3);
    L7:
        throw new IllegalArgumentException(a.e(r2, "Bad id: "));
    }

    private boolean popBackStackImmediate(String r9, int r10, int r11) {
        execPendingActions();
        ensureExecReady(true);
        Fragment r1 = this.mPrimaryNav;
        if (r1 == null) goto L9;
        if (r10 >= 0) goto L9;
        if (r9 != null) goto L9;
        if (r1.getChildFragmentManager().popBackStackImmediate() == false) goto L9;
        return true;
    L9:
        boolean r12 = popBackStackState(this.mTmpRecords, this.mTmpIsPop, r9, r10, r11);
        if (r12 == false) goto L17;
        this.mExecutingActions = true;
        removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);     // Catch: Throwable -> L14
        cleanupExec();
    L14:
        th = move-exception;
        cleanupExec();
        throw th;
    L17:
        updateOnBackPressedCallbackEnabled();
        doPendingDeferredStart();
        burpActive();
        return r12;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String r2, Context r3, AttributeSet r4) {
        return onCreateView(null, r2, r3, r4);
    }

    public void moveToState(Fragment r7) {
        moveToState(r7, this.mCurState, 0, 0, false);
    }

    public void moveToState(int r3, boolean r4) {
        if (this.mHost != null) goto L8;
        if (r3 == 0) goto L8;
        throw new IllegalStateException("No activity");
    L8:
        if (r4 == false) goto L10;
    L12:
        this.mCurState = r3;
        int r5 = this.mAdded.size();
        int r0 = 0;
    L13:
        if (r0 >= r5) goto L15;
        moveFragmentToExpectedState(this.mAdded.get(r0));
        r0 = r0 + 1;
        goto L13
    L15:
        Iterator<Fragment> r6 = this.mActive.values().iterator();
    L17:
        if (r6.hasNext() == false) goto L27;
        Fragment r1 = r6.next();
        if (r1 == null) goto L17;
        if (r1.mRemoving == true) goto L25;
        if (r1.mDetached == false) goto L17;
    L25:
        if (r1.mIsNewlyAdded == true) goto L17;
        moveFragmentToExpectedState(r1);
        goto L17
    L27:
        startPendingDeferredFragments();
        if (this.mNeedMenuInvalidate == false) goto L46;
        FragmentHostCallback r7 = this.mHost;
        if (r7 != null) goto L32;
        return;
    L32:
        if (this.mCurState != 4) goto L48;
        r7.onSupportInvalidateOptionsMenu();
        this.mNeedMenuInvalidate = false;
        return;
    L48:
        return;
    L46:
        return;
    L10:
        if (r3 != this.mCurState) goto L12;
    }
}
