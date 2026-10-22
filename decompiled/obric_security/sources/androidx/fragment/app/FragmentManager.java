package androidx.fragment.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.collection.ArraySet;
import androidx.core.os.CancellationSignal;
import androidx.fragment.R;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentManager implements FragmentResultOwner {
    private static boolean DEBUG = false;
    private static final String EXTRA_CREATED_FILLIN_INTENT = "androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE";
    public static final int POP_BACK_STACK_INCLUSIVE = 1;
    static final String TAG = "FragmentManager";
    static boolean USE_STATE_MANAGER = true;
    ArrayList<BackStackRecord> mBackStack;
    private ArrayList<OnBackStackChangedListener> mBackStackChangeListeners;
    private final AtomicInteger mBackStackIndex;
    private FragmentContainer mContainer;
    private ArrayList<Fragment> mCreatedMenus;
    int mCurState;
    private SpecialEffectsControllerFactory mDefaultSpecialEffectsControllerFactory;
    private boolean mDestroyed;
    private Runnable mExecCommit;
    private boolean mExecutingActions;
    private Map<Fragment, HashSet<CancellationSignal>> mExitAnimationCancellationSignals;
    private FragmentFactory mFragmentFactory;
    private final FragmentStore mFragmentStore;
    private final FragmentTransition.Callback mFragmentTransitionCallback;
    private boolean mHavePendingDeferredStart;
    private FragmentHostCallback<?> mHost;
    private FragmentFactory mHostFragmentFactory;
    ArrayDeque<LaunchedFragmentInfo> mLaunchedFragments;
    private final FragmentLayoutInflaterFactory mLayoutInflaterFactory;
    private final FragmentLifecycleCallbacksDispatcher mLifecycleCallbacksDispatcher;
    private boolean mNeedMenuInvalidate;
    private FragmentManagerViewModel mNonConfig;
    private final CopyOnWriteArrayList<FragmentOnAttachListener> mOnAttachListeners;
    private final OnBackPressedCallback mOnBackPressedCallback;
    private OnBackPressedDispatcher mOnBackPressedDispatcher;
    private Fragment mParent;
    private final ArrayList<OpGenerator> mPendingActions;
    private ArrayList<StartEnterTransitionListener> mPostponedTransactions;
    Fragment mPrimaryNav;
    private ActivityResultLauncher<String[]> mRequestPermissions;
    private final Map<String, LifecycleAwareResultListener> mResultListeners;
    private final Map<String, Bundle> mResults;
    private SpecialEffectsControllerFactory mSpecialEffectsControllerFactory;
    private ActivityResultLauncher<Intent> mStartActivityForResult;
    private ActivityResultLauncher<IntentSenderRequest> mStartIntentSenderForResult;
    private boolean mStateSaved;
    private boolean mStopped;
    private ArrayList<Fragment> mTmpAddedFragments;
    private ArrayList<Boolean> mTmpIsPop;
    private ArrayList<BackStackRecord> mTmpRecords;

    public interface BackStackEntry {
        @Deprecated
        CharSequence getBreadCrumbShortTitle();

        @Deprecated
        int getBreadCrumbShortTitleRes();

        @Deprecated
        CharSequence getBreadCrumbTitle();

        @Deprecated
        int getBreadCrumbTitleRes();

        int getId();

        String getName();
    }

    static class FragmentIntentSenderContract extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
        FragmentIntentSenderContract() {
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r1, IntentSenderRequest r2) {
            return createIntent2(r1, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResult parseResult(int r1, Intent r2) {
            return parseResult(r1, r2);
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r3, IntentSenderRequest r4) {
            Intent r2 = new Intent(ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST);
            Intent r5 = r4.getFillInIntent();
            if (r5 == null) goto L9;
            Bundle r1 = r5.getBundleExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
            if (r1 == null) goto L9;
            r2.putExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, r1);
            r5.removeExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
            if (r5.getBooleanExtra(FragmentManager.EXTRA_CREATED_FILLIN_INTENT, false) == false) goto L9;
            r4 = new IntentSenderRequest.Builder(r4.getIntentSender()).setFillInIntent(null).setFlags(r4.getFlagsValues(), r4.getFlagsMask()).build();
        L9:
            r2.putExtra(ActivityResultContracts.StartIntentSenderForResult.EXTRA_INTENT_SENDER_REQUEST, r4);
            if (FragmentManager.isLoggingEnabled(2) == false) goto L12;
            Log.v(FragmentManager.TAG, "CreateIntent created the following intent: " + r2);
        L12:
            return r2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public ActivityResult parseResult(int r1, Intent r2) {
            return new ActivityResult(r1, r2);
        }
    }

    public static abstract class FragmentLifecycleCallbacks {
        @Deprecated
        public void onFragmentActivityCreated(FragmentManager r1, Fragment r2, Bundle r3) {
        }

        public void onFragmentAttached(FragmentManager r1, Fragment r2, Context r3) {
        }

        public void onFragmentCreated(FragmentManager r1, Fragment r2, Bundle r3) {
        }

        public void onFragmentDestroyed(FragmentManager r1, Fragment r2) {
        }

        public void onFragmentDetached(FragmentManager r1, Fragment r2) {
        }

        public void onFragmentPaused(FragmentManager r1, Fragment r2) {
        }

        public void onFragmentPreAttached(FragmentManager r1, Fragment r2, Context r3) {
        }

        public void onFragmentPreCreated(FragmentManager r1, Fragment r2, Bundle r3) {
        }

        public void onFragmentResumed(FragmentManager r1, Fragment r2) {
        }

        public void onFragmentSaveInstanceState(FragmentManager r1, Fragment r2, Bundle r3) {
        }

        public void onFragmentStarted(FragmentManager r1, Fragment r2) {
        }

        public void onFragmentStopped(FragmentManager r1, Fragment r2) {
        }

        public void onFragmentViewCreated(FragmentManager r1, Fragment r2, View r3, Bundle r4) {
        }

        public void onFragmentViewDestroyed(FragmentManager r1, Fragment r2) {
        }

        public FragmentLifecycleCallbacks() {
        }
    }

    static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = null;
        int mRequestCode;
        String mWho;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        LaunchedFragmentInfo(String r1, int r2) {
            this.mWho = r1;
            this.mRequestCode = r2;
        }

        LaunchedFragmentInfo(Parcel r2) {
            this.mWho = r2.readString();
            this.mRequestCode = r2.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            r1.writeString(this.mWho);
            r1.writeInt(this.mRequestCode);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    private static class LifecycleAwareResultListener implements FragmentResultListener {
        private final Lifecycle mLifecycle;
        private final FragmentResultListener mListener;
        private final LifecycleEventObserver mObserver;

        LifecycleAwareResultListener(Lifecycle r1, FragmentResultListener r2, LifecycleEventObserver r3) {
            this.mLifecycle = r1;
            this.mListener = r2;
            this.mObserver = r3;
        }

        public boolean isAtLeast(Lifecycle.State r1) {
            return this.mLifecycle.getCurrentState().isAtLeast(r1);
        }

        @Override // androidx.fragment.app.FragmentResultListener
        public void onFragmentResult(String r1, Bundle r2) {
            this.mListener.onFragmentResult(r1, r2);
        }

        public void removeObserver() {
            this.mLifecycle.removeObserver(this.mObserver);
        }
    }

    public interface OnBackStackChangedListener {
        void onBackStackChanged();
    }

    interface OpGenerator {
        boolean generateOps(ArrayList<BackStackRecord> r1, ArrayList<Boolean> r2);
    }

    private class PopBackStackState implements OpGenerator {
        final int mFlags;
        final int mId;
        final String mName;
        final /* synthetic */ FragmentManager this$0;

        PopBackStackState(FragmentManager r1, String r2, int r3, int r4) {
            this.this$0 = r1;
            this.mName = r2;
            this.mId = r3;
            this.mFlags = r4;
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public boolean generateOps(ArrayList<BackStackRecord> r7, ArrayList<Boolean> r8) {
            if (this.this$0.mPrimaryNav == null) goto L13;
            if (this.mId >= 0) goto L13;
            if (this.mName != null) goto L13;
            if (this.this$0.mPrimaryNav.getChildFragmentManager().popBackStackImmediate() == false) goto L13;
            return false;
        L13:
            return this.this$0.popBackStackState(r7, r8, this.mName, this.mId, this.mFlags);
        }
    }

    static class StartEnterTransitionListener implements Fragment.OnStartEnterTransitionListener {
        final boolean mIsBack;
        private int mNumPostponed;
        final BackStackRecord mRecord;

        StartEnterTransitionListener(BackStackRecord r1, boolean r2) {
            this.mIsBack = r2;
            this.mRecord = r1;
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

        public boolean isReady() {
            if (this.mNumPostponed != 0) goto L5;
            return true;
        L5:
            return false;
        }

        void completeTransaction() {
            if (this.mNumPostponed <= 0) goto L5;
            boolean r0 = true;
        L6:
            Iterator<Fragment> r2 = this.mRecord.mManager.getFragments().iterator();
        L8:
            if (r2.hasNext() == false) goto L14;
            Fragment r3 = r2.next();
            r3.setOnStartEnterTransitionListener(null);
            if (r0 == false) goto L8;
            if (r3.isPostponed() == false) goto L8;
            r3.startPostponedEnterTransition();
            goto L8
        L14:
            this.mRecord.mManager.completeExecute(this.mRecord, this.mIsBack, !r0, true);
            return;
        L5:
            r0 = false;
            goto L6
        }

        void cancelTransaction() {
            this.mRecord.mManager.completeExecute(this.mRecord, this.mIsBack, false, false);
        }
    }

    static {
    }

    static int reverseTransit(int r3) {
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

    public FragmentManager() {
        this.mPendingActions = new ArrayList();
        this.mFragmentStore = new FragmentStore();
        this.mLayoutInflaterFactory = new FragmentLayoutInflaterFactory(this);
        final boolean r1 = false;
        this.mOnBackPressedCallback = new AnonymousClass1(this, r1);
        this.mBackStackIndex = new AtomicInteger();
        this.mResults = Collections.synchronizedMap(new HashMap());
        this.mResultListeners = Collections.synchronizedMap(new HashMap());
        this.mExitAnimationCancellationSignals = Collections.synchronizedMap(new HashMap());
        this.mFragmentTransitionCallback = new AnonymousClass2(this);
        this.mLifecycleCallbacksDispatcher = new FragmentLifecycleCallbacksDispatcher(this);
        this.mOnAttachListeners = new CopyOnWriteArrayList();
        this.mCurState = -1;
        this.mFragmentFactory = null;
        this.mHostFragmentFactory = new AnonymousClass3(this);
        this.mSpecialEffectsControllerFactory = null;
        this.mDefaultSpecialEffectsControllerFactory = new AnonymousClass4(this);
        this.mLaunchedFragments = new ArrayDeque();
        this.mExecCommit = new AnonymousClass5(this);
    }

    static /* synthetic */ Map access$000(FragmentManager r0) {
        return r0.mResults;
    }

    static /* synthetic */ Map access$100(FragmentManager r0) {
        return r0.mResultListeners;
    }

    static /* synthetic */ FragmentStore access$200(FragmentManager r0) {
        return r0.mFragmentStore;
    }

    public static void enableNewStateManager(boolean r0) {
        USE_STATE_MANAGER = r0;
    }

    @Deprecated
    public static void enableDebugLogging(boolean r0) {
        DEBUG = r0;
    }

    static boolean isLoggingEnabled(int r1) {
        if (DEBUG == false) goto L5;
    L8:
        return true;
    L5:
        if (Log.isLoggable(TAG, r1) == true) goto L8;
        return false;
    }

    private void throwException(RuntimeException r8) {
        Log.e(TAG, r8.getMessage());
        Log.e(TAG, "Activity state:");
        PrintWriter r2 = new PrintWriter(new LogWriter(TAG));
        FragmentHostCallback<?> r0 = this.mHost;
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

    @Deprecated
    public FragmentTransaction openTransaction() {
        return beginTransaction();
    }

    public FragmentTransaction beginTransaction() {
        return new BackStackRecord(this);
    }

    public boolean executePendingTransactions() {
        boolean r0 = execPendingActions(true);
        forcePostponedTransactions();
        return r0;
    }

    private void updateOnBackPressedCallbackEnabled() {
        ArrayList<OpGenerator> r0 = this.mPendingActions;
        monitor-enter(r0);
        boolean r2 = true;
        if (this.mPendingActions.isEmpty() == true) goto L9;
        this.mOnBackPressedCallback.setEnabled(true);     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L18
        OnBackPressedCallback r1 = this.mOnBackPressedCallback;
        if (getBackStackEntryCount() > 0) goto L13;
    L15:
        r2 = false;
    L16:
        r1.setEnabled(r2);
        return;
    L13:
        if (isPrimaryNavigation(this.mParent) == false) goto L15;
    L18:
        th = move-exception;
        throw th;
    }

    boolean isPrimaryNavigation(Fragment r4) {
        if (r4 != null) goto L5;
        return true;
    L5:
        FragmentManager r1 = r4.mFragmentManager;
        if (r4.equals(r1.getPrimaryNavigationFragment()) == true) goto L8;
    L10:
        return false;
    L8:
        if (isPrimaryNavigation(r1.mParent) == false) goto L10;
        return true;
    }

    boolean isParentMenuVisible(Fragment r1) {
        if (r1 != null) goto L6;
        return true;
    L6:
        return r1.isMenuVisible();
    }

    void handleOnBackPressed() {
        execPendingActions(true);
        if (this.mOnBackPressedCallback.isEnabled() == false) goto L5;
        popBackStackImmediate();
        return;
    L5:
        this.mOnBackPressedDispatcher.onBackPressed();
    }

    public void popBackStack() {
        enqueueAction(new PopBackStackState(this, null, -1, 0), false);
    }

    public boolean popBackStackImmediate() {
        return popBackStackImmediate(null, -1, 0);
    }

    public void popBackStack(String r3, int r4) {
        enqueueAction(new PopBackStackState(this, r3, -1, r4), false);
    }

    public boolean popBackStackImmediate(String r2, int r3) {
        return popBackStackImmediate(r2, -1, r3);
    }

    public void popBackStack(int r3, int r4) {
        if (r3 < 0) goto L6;
        enqueueAction(new PopBackStackState(this, null, r3, r4), false);
        return;
    L6:
        throw new IllegalArgumentException("Bad id: " + r3);
    }

    public boolean popBackStackImmediate(int r2, int r3) {
        if (r2 < 0) goto L6;
        return popBackStackImmediate(null, r2, r3);
    L6:
        throw new IllegalArgumentException("Bad id: " + r2);
    }

    private boolean popBackStackImmediate(String r9, int r10, int r11) {
        execPendingActions(false);
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
        this.mFragmentStore.burpActive();
        return r12;
    }

    public int getBackStackEntryCount() {
        ArrayList<BackStackRecord> r0 = this.mBackStack;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public BackStackEntry getBackStackEntryAt(int r1) {
        return this.mBackStack.get(r1);
    }

    public void addOnBackStackChangedListener(OnBackStackChangedListener r2) {
        if (this.mBackStackChangeListeners != null) goto L5;
        this.mBackStackChangeListeners = new ArrayList();
    L5:
        this.mBackStackChangeListeners.add(r2);
    }

    public void removeOnBackStackChangedListener(OnBackStackChangedListener r1) {
        ArrayList<OnBackStackChangedListener> r0 = this.mBackStackChangeListeners;
        if (r0 == null) goto L6;
        r0.remove(r1);
        return;
    }

    void addCancellationSignal(Fragment r3, CancellationSignal r4) {
        if (this.mExitAnimationCancellationSignals.get(r3) != null) goto L5;
        this.mExitAnimationCancellationSignals.put(r3, new HashSet());
    L5:
        this.mExitAnimationCancellationSignals.get(r3).add(r4);
    }

    void removeCancellationSignal(Fragment r2, CancellationSignal r3) {
        HashSet<CancellationSignal> r0 = this.mExitAnimationCancellationSignals.get(r2);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.remove(r3) == true) goto L7;
        return;
    L7:
        if (r0.isEmpty() == false) goto L14;
        this.mExitAnimationCancellationSignals.remove(r2);
        if (r2.mState >= 5) goto L15;
        destroyFragmentView(r2);
        moveToState(r2);
        return;
    L15:
        return;
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void setFragmentResult(String r3, Bundle r4) {
        LifecycleAwareResultListener r0 = this.mResultListeners.get(r3);
        if (r0 != null) goto L5;
    L7:
        this.mResults.put(r3, r4);
        return;
    L5:
        if (r0.isAtLeast(Lifecycle.State.STARTED) == false) goto L7;
        r0.onFragmentResult(r3, r4);
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void clearFragmentResult(String r1) {
        this.mResults.remove(r1);
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void setFragmentResultListener(final String r3, LifecycleOwner r4, final FragmentResultListener r5) {
        final Lifecycle r6 = r4.getLifecycle();
        if (r6.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        LifecycleEventObserver r0 = new AnonymousClass6(this, r3, r5, r6);
        r6.addObserver(r0);
        LifecycleAwareResultListener r2 = this.mResultListeners.put(r3, new LifecycleAwareResultListener(r6, r5, r0));
        if (r2 == null) goto L9;
        r2.removeObserver();
        return;
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void clearFragmentResultListener(String r1) {
        LifecycleAwareResultListener r0 = this.mResultListeners.remove(r1);
        if (r0 == null) goto L6;
        r0.removeObserver();
        return;
    }

    public void putFragment(Bundle r4, String r5, Fragment r6) {
        if (r6.mFragmentManager == this) goto L5;
        throwException(new IllegalStateException("Fragment " + r6 + " is not currently in the FragmentManager"));
    L5:
        r4.putString(r5, r6.mWho);
    }

    public Fragment getFragment(Bundle r5, String r6) {
        String r7 = r5.getString(r6);
        if (r7 != null) goto L6;
        return null;
    L6:
        Fragment r0 = findActiveFragment(r7);
        if (r0 != null) goto L9;
        throwException(new IllegalStateException("Fragment no longer exists for key " + r6 + ": unique id " + r7));
    L9:
        return r0;
    }

    public static <F extends Fragment> F findFragment(View r3) {
        F r0 = (F) findViewFragment(r3);
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("View " + r3 + " does not have a Fragment set");
    }

    private static Fragment findViewFragment(View r2) {
    L3:
        if (r2 == null) goto L11;
        Fragment r1 = getViewFragment(r2);
        if (r1 != null) goto L6;
        Object r3 = r2.getParent();
        if ((r3 instanceof View) == true) goto L9;
        r2 = null;
        goto L3
    L9:
        r2 = (View) r3;
        goto L3
    L6:
        return r1;
    L11:
        return null;
    }

    static Fragment getViewFragment(View r1) {
        Object r2 = r1.getTag(R.id.fragment_container_view_tag);
        if ((r2 instanceof Fragment) == true) goto L5;
        return null;
    L5:
        return (Fragment) r2;
    }

    void onContainerAvailable(FragmentContainerView r5) {
        Iterator<FragmentStateManager> r4 = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
    L4:
        if (r4.hasNext() == false) goto L12;
        FragmentStateManager r0 = r4.next();
        Fragment r1 = r0.getFragment();
        if (r1.mContainerId != r5.getId()) goto L4;
        if (r1.mView == null) goto L4;
        if (r1.mView.getParent() != null) goto L4;
        r1.mContainer = r5;
        r0.addViewToContainer();
        goto L4
    }

    static FragmentManager findFragmentManager(View r4) {
        Fragment r0 = findViewFragment(r4);
        if (r0 != null) goto L5;
        Context r1 = r4.getContext();
    L11:
        if ((r1 instanceof ContextWrapper) == false) goto L16;
        if ((r1 instanceof FragmentActivity) == true) goto L14;
        r1 = ((ContextWrapper) r1).getBaseContext();
        goto L11
    L14:
        FragmentActivity r2 = (FragmentActivity) r1;
    L17:
        if (r2 == null) goto L21;
        return r2.getSupportFragmentManager();
    L21:
        throw new IllegalStateException("View " + r4 + " is not within a subclass of FragmentActivity.");
    L16:
        r2 = null;
        goto L17
    L5:
        if (r0.isAdded() == false) goto L8;
        return r0.getChildFragmentManager();
    L8:
        throw new IllegalStateException("The Fragment " + r0 + " that owns View " + r4 + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
    }

    public List<Fragment> getFragments() {
        return this.mFragmentStore.getFragments();
    }

    ViewModelStore getViewModelStore(Fragment r1) {
        return this.mNonConfig.getViewModelStore(r1);
    }

    private FragmentManagerViewModel getChildNonConfig(Fragment r1) {
        return this.mNonConfig.getChildNonConfig(r1);
    }

    void addRetainedFragment(Fragment r1) {
        this.mNonConfig.addRetainedFragment(r1);
    }

    void removeRetainedFragment(Fragment r1) {
        this.mNonConfig.removeRetainedFragment(r1);
    }

    List<Fragment> getActiveFragments() {
        return this.mFragmentStore.getActiveFragments();
    }

    int getActiveFragmentCount() {
        return this.mFragmentStore.getActiveFragmentCount();
    }

    public Fragment.SavedState saveFragmentInstanceState(Fragment r5) {
        FragmentStateManager r0 = this.mFragmentStore.getFragmentStateManager(r5.mWho);
        if (r0 != null) goto L5;
    L6:
        throwException(new IllegalStateException("Fragment " + r5 + " is not currently in the FragmentManager"));
    L8:
        return r0.saveInstanceState();
    L5:
        if (r0.getFragment().equals(r5) == true) goto L8;
        goto L6
    }

    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(128);
        r0.append("FragmentManager{");
        r0.append(Integer.toHexString(System.identityHashCode(this)));
        r0.append(" in ");
        Fragment r1 = this.mParent;
        if (r1 == null) goto L5;
        r0.append(r1.getClass().getSimpleName());
        r0.append("{");
        r0.append(Integer.toHexString(System.identityHashCode(this.mParent)));
        r0.append("}");
    L9:
        r0.append("}}");
        return r0.toString();
    L5:
        FragmentHostCallback<?> r2 = this.mHost;
        if (r2 == null) goto L8;
        r0.append(r2.getClass().getSimpleName());
        r0.append("{");
        r0.append(Integer.toHexString(System.identityHashCode(this.mHost)));
        r0.append("}");
        goto L9
    L8:
        r0.append("null");
        goto L9
    }

    public void dump(String r5, FileDescriptor r6, PrintWriter r7, String[] r8) {
        String r0 = r5 + "    ";
        this.mFragmentStore.dump(r5, r6, r7, r8);
        ArrayList<Fragment> r9 = this.mCreatedMenus;
        int r10 = 0;
        if (r9 == null) goto L9;
        int r11 = r9.size();
        if (r11 <= 0) goto L9;
        r7.print(r5);
        r7.println("Fragments Created Menus:");
        int r1 = 0;
    L7:
        if (r1 >= r11) goto L9;
        Fragment r2 = this.mCreatedMenus.get(r1);
        r7.print(r5);
        r7.print("  #");
        r7.print(r1);
        r7.print(": ");
        r7.println(r2.toString());
        r1 = r1 + 1;
    L9:
        ArrayList<BackStackRecord> r12 = this.mBackStack;
        if (r12 == null) goto L16;
        int r13 = r12.size();
        if (r13 <= 0) goto L16;
        r7.print(r5);
        r7.println("Back Stack:");
        int r3 = 0;
    L14:
        if (r3 >= r13) goto L16;
        BackStackRecord r4 = this.mBackStack.get(r3);
        r7.print(r5);
        r7.print("  #");
        r7.print(r3);
        r7.print(": ");
        r7.println(r4.toString());
        r4.dump(r0, r7);
        r3 = r3 + 1;
    L16:
        r7.print(r5);
        r7.println("Back Stack Index: " + this.mBackStackIndex.get());
        ArrayList<OpGenerator> r14 = this.mPendingActions;
        monitor-enter(r14);
        int r15 = this.mPendingActions.size();     // Catch: Throwable -> L31
        if (r15 <= 0) goto L23;
        r7.print(r5);     // Catch: Throwable -> L31
        r7.println("Pending Actions:");     // Catch: Throwable -> L31
    L21:
        if (r10 >= r15) goto L23;
        OpGenerator r16 = this.mPendingActions.get(r10);     // Catch: Throwable -> L31
        r7.print(r5);     // Catch: Throwable -> L31
        r7.print("  #");     // Catch: Throwable -> L31
        r7.print(r10);     // Catch: Throwable -> L31
        r7.print(": ");     // Catch: Throwable -> L31
        r7.println(r16);     // Catch: Throwable -> L31
        r10 = r10 + 1;     // Catch: Throwable -> L31
    L23:
        monitor-exit(r14);     // Catch: Throwable -> L31
        r7.print(r5);
        r7.println("FragmentManager misc state:");
        r7.print(r5);
        r7.print("  mHost=");
        r7.println(this.mHost);
        r7.print(r5);
        r7.print("  mContainer=");
        r7.println(this.mContainer);
        if (this.mParent == null) goto L27;
        r7.print(r5);
        r7.print("  mParent=");
        r7.println(this.mParent);
    L27:
        r7.print(r5);
        r7.print("  mCurState=");
        r7.print(this.mCurState);
        r7.print(" mStateSaved=");
        r7.print(this.mStateSaved);
        r7.print(" mStopped=");
        r7.print(this.mStopped);
        r7.print(" mDestroyed=");
        r7.println(this.mDestroyed);
        if (this.mNeedMenuInvalidate == false) goto L39;
        r7.print(r5);
        r7.print("  mNeedMenuInvalidate=");
        r7.println(this.mNeedMenuInvalidate);
        return;
    L39:
        return;
    L31:
        th = move-exception;
        throw th;
    }

    void performPendingDeferredStart(FragmentStateManager r3) {
        Fragment r0 = r3.getFragment();
        if (r0.mDeferStart == true) goto L5;
        return;
    L5:
        if (this.mExecutingActions == false) goto L8;
        this.mHavePendingDeferredStart = true;
        return;
    L8:
        r0.mDeferStart = false;
        if (USE_STATE_MANAGER == false) goto L11;
        r3.moveToExpectedState();
        return;
    L11:
        moveToState(r0);
    }

    boolean isStateAtLeast(int r1) {
        if (this.mCurState < r1) goto L5;
        return true;
    L5:
        return false;
    }

    void moveToState(Fragment r11, int r12) {
        FragmentStateManager r0 = this.mFragmentStore.getFragmentStateManager(r11.mWho);
        int r1 = 1;
        if (r0 != null) goto L6;
        r0 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, r11);
        r0.setFragmentManagerState(1);
    L6:
        if (r11.mFromLayout == true) goto L8;
    L12:
        int r13 = Math.min(r12, r0.computeExpectedState());
        if (r11.mState > r13) goto L42;
        if (r11.mState < r13) goto L17;
    L19:
        int r10 = r11.mState;
        if (r10 == (-1)) goto L27;
        if (r10 == 0) goto L29;
        if (r10 == 1) goto L31;
        if (r10 == 2) goto L35;
        if (r10 == 4) goto L37;
        if (r10 != 5) goto L106;
    L39:
        if (r13 <= 5) goto L106;
        r0.resume();
    L106:
        if (r11.mState != r13) goto L108;
        return;
    L108:
        if (isLoggingEnabled(3) == false) goto L110;
        Log.d(TAG, "moveToState: Fragment state for " + r11 + " not updated inline; expected state " + r13 + " found " + r11.mState);
    L110:
        r11.mState = r13;
        return;
    L37:
        if (r13 <= 4) goto L39;
        r0.start();
    L35:
        if (r13 <= 2) goto L37;
        r0.activityCreated();
    L31:
        if (r13 <= (-1)) goto L33;
        r0.ensureInflatedView();
    L33:
        if (r13 <= 1) goto L35;
        r0.createView();
    L29:
        if (r13 <= 0) goto L31;
        r0.create();
        goto L31
    L27:
        if (r13 <= (-1)) goto L29;
        r0.attach();
        goto L29
    L17:
        if (this.mExitAnimationCancellationSignals.isEmpty() == true) goto L19;
        cancelExitAnimation(r11);
        goto L19
    L42:
        if (r11.mState <= r13) goto L106;
        int r2 = r11.mState;
        if (r2 == 0) goto L101;
        if (r2 == 1) goto L96;
        if (r2 == 2) goto L67;
        if (r2 == 4) goto L56;
        if (r2 != 5) goto L50;
    L54:
        if (r13 >= 5) goto L56;
        r0.stop();
        goto L56
    L50:
        if (r2 != 7) goto L106;
        if (r13 >= 7) goto L54;
        r0.pause();
    L56:
        if (r13 >= 4) goto L67;
        if (isLoggingEnabled(3) == false) goto L61;
        Log.d(TAG, "movefrom ACTIVITY_CREATED: " + r11);
    L61:
        if (r11.mView == null) goto L67;
        if (this.mHost.onShouldSaveFragmentState(r11) == false) goto L67;
        if (r11.mSavedViewState != null) goto L67;
        r0.saveViewState();
    L67:
        if (r13 >= 2) goto L96;
        if (r11.mView == null) goto L94;
        if (r11.mContainer == null) goto L94;
        r11.mContainer.endViewTransition(r11.mView);
        r11.mView.clearAnimation();
        if (r11.isRemovingParent() == true) goto L94;
        if (this.mCurState > (-1)) goto L77;
    L83:
        FragmentAnim.AnimationOrAnimator r3 = null;
    L84:
        r11.mPostponedAlpha = 0.0f;
        ViewGroup r6 = r11.mContainer;
        View r7 = r11.mView;
        if (r3 == null) goto L87;
        FragmentAnim.animateRemoveFragment(r11, r3, this.mFragmentTransitionCallback);
    L87:
        r6.removeView(r7);
        if (isLoggingEnabled(2) == false) goto L91;
        Log.v(TAG, "Removing view " + r7 + " for fragment " + r11 + " from container " + r6);
    L91:
        if (r6 == r11.mContainer) goto L94;
        return;
    L77:
        if (this.mDestroyed == true) goto L83;
        if (r11.mView.getVisibility() != 0) goto L83;
        if (r11.mPostponedAlpha < 0.0f) goto L83;
        r3 = FragmentAnim.loadAnimation(this.mHost.getContext(), r11, false, r11.getPopDirection());
    L94:
        if (this.mExitAnimationCancellationSignals.get(r11) != null) goto L96;
        r0.destroyFragmentView();
    L96:
        if (r13 >= 1) goto L101;
        if (this.mExitAnimationCancellationSignals.get(r11) != null) goto L102;
        r0.destroy();
    L102:
        if (r1 >= 0) goto L104;
        r0.detach();
    L104:
        r13 = r1;
    L101:
        r1 = r13;
        goto L102
    L8:
        if (r11.mInLayout == false) goto L12;
        if (r11.mState != 2) goto L12;
        r12 = Math.max(r12, 2);
        goto L12
    }

    private void cancelExitAnimation(Fragment r4) {
        HashSet<CancellationSignal> r0 = this.mExitAnimationCancellationSignals.get(r4);
        if (r0 == null) goto L11;
        Iterator<CancellationSignal> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        r1.next().cancel();
        goto L6
    L8:
        r0.clear();
        destroyFragmentView(r4);
        this.mExitAnimationCancellationSignals.remove(r4);
        return;
    }

    void setExitAnimationOrder(Fragment r1, boolean r2) {
        ViewGroup r0 = getFragmentContainer(r1);
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0 instanceof FragmentContainerView) == false) goto L9;
        ((FragmentContainerView) r0).setDrawDisappearingViewsLast(!r2);
        return;
    }

    private void destroyFragmentView(Fragment r3) {
        r3.performDestroyView();
        this.mLifecycleCallbacksDispatcher.dispatchOnFragmentViewDestroyed(r3, false);
        r3.mContainer = null;
        r3.mView = null;
        r3.mViewLifecycleOwner = null;
        r3.mViewLifecycleOwnerLiveData.setValue(null);
        r3.mInLayout = false;
    }

    void moveToState(Fragment r2) {
        moveToState(r2, this.mCurState);
    }

    private void completeShowHideFragment(final Fragment r7) {
        if (r7.mView == null) goto L27;
        FragmentAnim.AnimationOrAnimator r0 = FragmentAnim.loadAnimation(this.mHost.getContext(), r7, !r7.mHidden, r7.getPopDirection());
        if (r0 != null) goto L7;
    L16:
        if (r0 == null) goto L19;
        r7.mView.startAnimation(r0.animation);
        r0.animation.start();
    L19:
        if (r7.mHidden == true) goto L21;
    L23:
        int r1 = 0;
    L24:
        r7.mView.setVisibility(r1);
        if (r7.isHideReplaced() == false) goto L27;
        r7.setHideReplaced(false);
        goto L27
    L21:
        if (r7.isHideReplaced() == true) goto L23;
        r1 = 8;
        goto L24
    L7:
        if (r0.animator == null) goto L16;
        r0.animator.setTarget(r7.mView);
        if (r7.mHidden == true) goto L11;
        r7.mView.setVisibility(0);
    L15:
        r0.animator.start();
        goto L27
    L11:
        if (r7.isHideReplaced() == false) goto L13;
        r7.setHideReplaced(false);
        goto L15
    L13:
        final ViewGroup r2 = r7.mContainer;
        final View r3 = r7.mView;
        r2.startViewTransition(r3);
        r0.animator.addListener(new AnonymousClass7(this, r2, r3, r7));
    L27:
        invalidateMenuForFragment(r7);
        r7.mHiddenChanged = false;
        r7.onHiddenChanged(r7.mHidden);
    }

    void moveFragmentToExpectedState(Fragment r4) {
        if (this.mFragmentStore.containsActiveFragment(r4.mWho) == false) goto L5;
        moveToState(r4);
        if (r4.mView == null) goto L24;
        if (r4.mIsNewlyAdded == false) goto L24;
        if (r4.mContainer == null) goto L24;
        if (r4.mPostponedAlpha <= 0.0f) goto L17;
        r4.mView.setAlpha(r4.mPostponedAlpha);
    L17:
        r4.mPostponedAlpha = 0.0f;
        r4.mIsNewlyAdded = false;
        FragmentAnim.AnimationOrAnimator r0 = FragmentAnim.loadAnimation(this.mHost.getContext(), r4, true, r4.getPopDirection());
        if (r0 == null) goto L24;
        if (r0.animation == null) goto L22;
        r4.mView.startAnimation(r0.animation);
        goto L24
    L22:
        r0.animator.setTarget(r4.mView);
        r0.animator.start();
    L24:
        if (r4.mHiddenChanged == false) goto L28;
        completeShowHideFragment(r4);
        return;
    L28:
        return;
    L5:
        if (isLoggingEnabled(3) == false) goto L27;
        Log.d(TAG, "Ignoring moving " + r4 + " to state " + this.mCurState + "since it is not added to " + this);
        return;
    }

    void moveToState(int r4, boolean r5) {
        if (this.mHost == null) goto L5;
    L9:
        if (r5 == false) goto L11;
    L13:
        this.mCurState = r4;
        if (USE_STATE_MANAGER == false) goto L16;
        this.mFragmentStore.moveToExpectedState();
    L34:
        startPendingDeferredFragments();
        if (this.mNeedMenuInvalidate == false) goto L48;
        FragmentHostCallback<?> r6 = this.mHost;
        if (r6 != null) goto L39;
        return;
    L39:
        if (this.mCurState != 7) goto L50;
        r6.onSupportInvalidateOptionsMenu();
        this.mNeedMenuInvalidate = false;
        return;
    L50:
        return;
    L48:
        return;
    L16:
        Iterator<Fragment> r7 = this.mFragmentStore.getFragments().iterator();
    L18:
        if (r7.hasNext() == false) goto L20;
        moveFragmentToExpectedState(r7.next());
        goto L18
    L20:
        Iterator<FragmentStateManager> r8 = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
    L22:
        if (r8.hasNext() == false) goto L34;
        FragmentStateManager r0 = r8.next();
        Fragment r1 = r0.getFragment();
        if (r1.mIsNewlyAdded == true) goto L27;
        moveFragmentToExpectedState(r1);
    L27:
        if (r1.mRemoving == true) goto L29;
    L31:
        boolean r2 = false;
    L32:
        if (r2 == false) goto L22;
        this.mFragmentStore.makeInactive(r0);
        goto L22
    L29:
        if (r1.isInBackStack() == true) goto L31;
        r2 = true;
        goto L32
    L11:
        if (r4 != this.mCurState) goto L13;
        return;
    L5:
        if (r4 == (-1)) goto L9;
        throw new IllegalStateException("No activity");
    }

    private void startPendingDeferredFragments() {
        Iterator<FragmentStateManager> r0 = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        performPendingDeferredStart(r0.next());
        goto L4
    }

    FragmentStateManager createOrGetFragmentStateManager(Fragment r4) {
        FragmentStateManager r0 = this.mFragmentStore.getFragmentStateManager(r4.mWho);
        if (r0 == null) goto L5;
        return r0;
    L5:
        FragmentStateManager r1 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, r4);
        r1.restoreState(this.mHost.getContext().getClassLoader());
        r1.setFragmentManagerState(this.mCurState);
        return r1;
    }

    FragmentStateManager addFragment(Fragment r4) {
        if (isLoggingEnabled(2) == false) goto L5;
        Log.v(TAG, "add: " + r4);
    L5:
        FragmentStateManager r0 = createOrGetFragmentStateManager(r4);
        r4.mFragmentManager = this;
        this.mFragmentStore.makeActive(r0);
        if (r4.mDetached == true) goto L13;
        this.mFragmentStore.addFragment(r4);
        r4.mRemoving = false;
        if (r4.mView != null) goto L11;
        r4.mHiddenChanged = false;
    L11:
        if (isMenuAvailable(r4) == false) goto L13;
        this.mNeedMenuInvalidate = true;
    L13:
        return r0;
    }

    void removeFragment(Fragment r4) {
        if (isLoggingEnabled(2) == false) goto L5;
        Log.v(TAG, "remove: " + r4 + " nesting=" + r4.mBackStackNesting);
    L5:
        boolean r0 = !r4.isInBackStack();
        if (r4.mDetached == false) goto L8;
        if (r0 == true) goto L8;
        return;
    L8:
        this.mFragmentStore.removeFragment(r4);
        if (isMenuAvailable(r4) == false) goto L11;
        this.mNeedMenuInvalidate = true;
    L11:
        r4.mRemoving = true;
        setVisibleRemovingFragment(r4);
    }

    void hideFragment(Fragment r3) {
        if (isLoggingEnabled(2) == false) goto L6;
        Log.v(TAG, "hide: " + r3);
    L6:
        if (r3.mHidden == true) goto L9;
        r3.mHidden = true;
        r3.mHiddenChanged = true ^ r3.mHiddenChanged;
        setVisibleRemovingFragment(r3);
        return;
    }

    void showFragment(Fragment r2) {
        if (isLoggingEnabled(2) == false) goto L6;
        Log.v(TAG, "show: " + r2);
    L6:
        if (r2.mHidden == false) goto L9;
        r2.mHidden = false;
        r2.mHiddenChanged = !r2.mHiddenChanged;
        return;
    }

    void detachFragment(Fragment r5) {
        if (isLoggingEnabled(2) == false) goto L6;
        Log.v(TAG, "detach: " + r5);
    L6:
        if (r5.mDetached == true) goto L17;
        r5.mDetached = true;
        if (r5.mAdded == true) goto L10;
        return;
    L10:
        if (isLoggingEnabled(2) == false) goto L12;
        Log.v(TAG, "remove from detach: " + r5);
    L12:
        this.mFragmentStore.removeFragment(r5);
        if (isMenuAvailable(r5) == false) goto L15;
        this.mNeedMenuInvalidate = true;
    L15:
        setVisibleRemovingFragment(r5);
        return;
    }

    void attachFragment(Fragment r5) {
        if (isLoggingEnabled(2) == false) goto L6;
        Log.v(TAG, "attach: " + r5);
    L6:
        if (r5.mDetached == false) goto L16;
        r5.mDetached = false;
        if (r5.mAdded == true) goto L17;
        this.mFragmentStore.addFragment(r5);
        if (isLoggingEnabled(2) == false) goto L13;
        Log.v(TAG, "add from attach: " + r5);
    L13:
        if (isMenuAvailable(r5) == false) goto L18;
        this.mNeedMenuInvalidate = true;
        return;
    L18:
        return;
    L17:
        return;
    }

    public Fragment findFragmentById(int r1) {
        return this.mFragmentStore.findFragmentById(r1);
    }

    public Fragment findFragmentByTag(String r1) {
        return this.mFragmentStore.findFragmentByTag(r1);
    }

    Fragment findFragmentByWho(String r1) {
        return this.mFragmentStore.findFragmentByWho(r1);
    }

    Fragment findActiveFragment(String r1) {
        return this.mFragmentStore.findActiveFragment(r1);
    }

    private void checkStateLoss() {
        if (isStateSaved() == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }

    public boolean isStateSaved() {
        if (this.mStateSaved == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mStopped == true) goto L8;
        return false;
    }

    void enqueueAction(OpGenerator r3, boolean r4) {
        if (r4 == false) goto L4;
    L12:
        ArrayList<OpGenerator> r0 = this.mPendingActions;
        monitor-enter(r0);
    L24:
        th = move-exception;
        throw th;
    L15:
        if (this.mHost != null) goto L21;
        if (r4 == false) goto L20;
        monitor-exit(r0);     // Catch: Throwable -> L24
        return;
    L20:
        throw new IllegalStateException("Activity has been destroyed");     // Catch: Throwable -> L24
    L21:
        this.mPendingActions.add(r3);     // Catch: Throwable -> L24
        scheduleCommit();     // Catch: Throwable -> L24
        monitor-exit(r0);     // Catch: Throwable -> L24
        return;
    L4:
        if (this.mHost == null) goto L6;
        checkStateLoss();
        goto L12
    L6:
        if (this.mDestroyed == false) goto L10;
        throw new IllegalStateException("FragmentManager has been destroyed");
    L10:
        throw new IllegalStateException("FragmentManager has not been attached to a host.");
    }

    void scheduleCommit() {
        ArrayList<OpGenerator> r0 = this.mPendingActions;
        monitor-enter(r0);
        ArrayList<StartEnterTransitionListener> r1 = this.mPostponedTransactions;     // Catch: Throwable -> L18
        boolean r2 = false;
        if (r1 != null) goto L7;
    L9:
        boolean r3 = false;
    L11:
        if (this.mPendingActions.size() != 1) goto L13;
        r2 = true;
    L13:
        if (r3 == true) goto L15;
        if (r2 == true) goto L15;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L15:
        this.mHost.getHandler().removeCallbacks(this.mExecCommit);     // Catch: Throwable -> L18
        this.mHost.getHandler().post(this.mExecCommit);     // Catch: Throwable -> L18
        updateOnBackPressedCallbackEnabled();     // Catch: Throwable -> L18
        goto L16
    L7:
        if (r1.isEmpty() == true) goto L9;
        r3 = true;
    L18:
        th = move-exception;
        throw th;
    }

    int allocBackStackIndex() {
        return this.mBackStackIndex.getAndIncrement();
    }

    private void ensureExecReady(boolean r3) {
        if (this.mExecutingActions == true) goto L29;
        if (this.mHost != null) goto L13;
        if (this.mDestroyed == false) goto L11;
        throw new IllegalStateException("FragmentManager has been destroyed");
    L11:
        throw new IllegalStateException("FragmentManager has not been attached to a host.");
    L13:
        if (Looper.myLooper() != this.mHost.getHandler().getLooper()) goto L27;
        if (r3 == true) goto L17;
        checkStateLoss();
    L17:
        if (this.mTmpRecords != null) goto L19;
        this.mTmpRecords = new ArrayList();
        this.mTmpIsPop = new ArrayList();
    L19:
        this.mExecutingActions = true;
        executePostponedTransaction(null, null);     // Catch: Throwable -> L23
        this.mExecutingActions = false;
        return;
    L23:
        th = move-exception;
        this.mExecutingActions = false;
        throw th;
    L27:
        throw new IllegalStateException("Must be called from main thread of fragment host");
    L29:
        throw new IllegalStateException("FragmentManager is already executing transactions");
    }

    void execSingleAction(OpGenerator r2, boolean r3) {
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
        this.mFragmentStore.burpActive();
        return;
    L4:
        if (this.mHost != null) goto L6;
        return;
    L6:
        if (this.mDestroyed == false) goto L8;
    }

    private void cleanupExec() {
        this.mExecutingActions = false;
        this.mTmpIsPop.clear();
        this.mTmpRecords.clear();
    }

    boolean execPendingActions(boolean r3) {
        ensureExecReady(r3);
        boolean r4 = false;
    L4:
        if (generateOpsForPendingActions(this.mTmpRecords, this.mTmpIsPop) == false) goto L11;
        r4 = true;
        this.mExecutingActions = true;
        removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);     // Catch: Throwable -> L8
        cleanupExec();
    L8:
        th = move-exception;
        cleanupExec();
        throw th;
    L11:
        updateOnBackPressedCallbackEnabled();
        doPendingDeferredStart();
        this.mFragmentStore.burpActive();
        return r4;
    }

    private void executePostponedTransaction(ArrayList<BackStackRecord> r8, ArrayList<Boolean> r9) {
        ArrayList<StartEnterTransitionListener> r0 = this.mPostponedTransactions;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L35;
        StartEnterTransitionListener r3 = this.mPostponedTransactions.get(r2);
        if (r8 == null) goto L19;
        if (r3.mIsBack == true) goto L19;
        int r5 = r8.indexOf(r3.mRecord);
        if (r5 == (-1)) goto L19;
        if (r9 == null) goto L19;
        if (r9.get(r5).booleanValue() == false) goto L19;
        this.mPostponedTransactions.remove(r2);
        r2 = r2 - 1;
        r1 = r1 - 1;
        r3.cancelTransaction();
    L34:
        r2 = r2 + 1;
    L19:
        if (r3.isReady() == true) goto L23;
        if (r8 == null) goto L34;
        if (r3.mRecord.interactsWith(r8, 0, r8.size()) == false) goto L34;
    L23:
        this.mPostponedTransactions.remove(r2);
        r2 = r2 - 1;
        r1 = r1 - 1;
        if (r8 != null) goto L26;
    L33:
        r3.completeTransaction();
        goto L34
    L26:
        if (r3.mIsBack == true) goto L33;
        int r6 = r8.indexOf(r3.mRecord);
        if (r6 == (-1)) goto L33;
        if (r9 == null) goto L33;
        if (r9.get(r6).booleanValue() == false) goto L33;
        r3.cancelTransaction();
        goto L34
    L35:
        return;
    L5:
        r1 = r0.size();
        goto L6
    }

    private void removeRedundantOperationsAndExecute(ArrayList<BackStackRecord> r5, ArrayList<Boolean> r6) {
        if (r5.isEmpty() == false) goto L6;
        return;
    L6:
        if (r5.size() != r6.size()) goto L27;
        executePostponedTransaction(r5, r6);
        int r0 = r5.size();
        int r1 = 0;
        int r2 = 0;
    L8:
        if (r1 >= r0) goto L23;
        if (r5.get(r1).mReorderingAllowed == true) goto L22;
        if (r2 == r1) goto L13;
        executeOpsTogether(r5, r6, r2, r1);
    L13:
        r2 = r1 + 1;
        if (r6.get(r1).booleanValue() == false) goto L21;
    L15:
        if (r2 >= r0) goto L21;
        if (r6.get(r2).booleanValue() == false) goto L21;
        if (r5.get(r2).mReorderingAllowed == true) goto L21;
        r2 = r2 + 1;
    L21:
        executeOpsTogether(r5, r6, r1, r2);
        r1 = r2 - 1;
    L22:
        r1 = r1 + 1;
        goto L8
    L23:
        if (r2 == r0) goto L34;
        executeOpsTogether(r5, r6, r2, r0);
        return;
    L34:
        return;
    L27:
        throw new IllegalStateException("Internal error with the back stack records");
    }

    /* JADX WARN: Failed to calculate best type for var: r17v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r17v0 'this'  ??, new type: androidx.fragment.app.FragmentManager
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r8v10 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r8v10 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r8v10 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r8v10 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r8v11 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r8v11 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r8v12 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r8v12 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r8v13 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r8v13 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to set immutable type for var: r17v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r17v0 'this'  ??, new type: androidx.fragment.app.FragmentManager
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$0(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r8v10 ??, new type: int
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    private void executeOpsTogether(java.util.ArrayList<androidx.fragment.app.BackStackRecord> r18, java.util.ArrayList<java.lang.Boolean> r19, int r20, int r21) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00de: INVOKE (r8v10 ?? I:int) = (r8v9 java.util.ArrayList<androidx.fragment.app.FragmentTransaction$Op>) VIRTUAL call: java.util.ArrayList.size():int A[DECLARE_VAR, MD:():int (c)] in method: androidx.fragment.app.FragmentManager.executeOpsTogether(java.util.ArrayList<androidx.fragment.app.BackStackRecord>, java.util.ArrayList<java.lang.Boolean>, int, int):void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.executeOpsTogether(java.util.ArrayList, java.util.ArrayList, int, int):void");
    }

    private Set<SpecialEffectsController> collectChangedControllers(ArrayList<BackStackRecord> r4, int r5, int r6) {
        HashSet r0 = new HashSet();
    L3:
        if (r5 >= r6) goto L13;
        Iterator<FragmentTransaction.Op> r1 = r4.get(r5).mOps.iterator();
    L6:
        if (r1.hasNext() == false) goto L12;
        Fragment r2 = r1.next().mFragment;
        if (r2 == null) goto L6;
        ViewGroup r3 = r2.mContainer;
        if (r3 == null) goto L6;
        r0.add(SpecialEffectsController.getOrCreateController(r3, this));
        goto L6
    L12:
        r5 = r5 + 1;
        goto L3
    L13:
        return r0;
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

    private int postponePostponableTransactions(ArrayList<BackStackRecord> r8, ArrayList<Boolean> r9, int r10, int r11, ArraySet<Fragment> r12) {
        int r0 = r11 - 1;
        int r1 = r11;
    L3:
        if (r0 < r10) goto L23;
        BackStackRecord r2 = r8.get(r0);
        boolean r3 = r9.get(r0).booleanValue();
        if (r2.isPostponed() == true) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == false) goto L22;
        if (this.mPostponedTransactions != null) goto L14;
        this.mPostponedTransactions = new ArrayList();
    L14:
        StartEnterTransitionListener r5 = new StartEnterTransitionListener(r2, r3);
        this.mPostponedTransactions.add(r5);
        r2.setOnStartPostponedListener(r5);
        if (r3 == false) goto L17;
        r2.executeOps();
    L18:
        r1 = r1 - 1;
        if (r0 == r1) goto L21;
        r8.remove(r0);
        r8.add(r1, r2);
    L21:
        addAddedFragments(r12);
        goto L22
    L17:
        r2.executePopOps(false);
    L22:
        r0 = r0 - 1;
        goto L3
    L7:
        if (r2.interactsWith(r8, r0 + 1, r11) == true) goto L9;
        r4 = true;
        goto L10
    L23:
        return r1;
    }

    void completeExecute(BackStackRecord r10, boolean r11, boolean r12, boolean r13) {
        if (r11 == false) goto L4;
        r10.executePopOps(r13);
    L5:
        ArrayList r2 = new ArrayList(1);
        ArrayList r3 = new ArrayList(1);
        r2.add(r10);
        r3.add(Boolean.valueOf(r11));
        if (r12 == true) goto L8;
    L10:
        if (r13 == false) goto L12;
        moveToState(this.mCurState, true);
    L12:
        Iterator<Fragment> r9 = this.mFragmentStore.getActiveFragments().iterator();
    L14:
        if (r9.hasNext() == false) goto L29;
        Fragment r14 = r9.next();
        if (r14 == null) goto L14;
        if (r14.mView == null) goto L14;
        if (r14.mIsNewlyAdded == false) goto L14;
        if (r10.interactsWith(r14.mContainerId) == false) goto L14;
        if (r14.mPostponedAlpha <= 0.0f) goto L26;
        r14.mView.setAlpha(r14.mPostponedAlpha);
    L26:
        if (r13 == true) goto L27;
        r14.mPostponedAlpha = -1.0f;
        r14.mIsNewlyAdded = false;
        goto L14
    L27:
        r14.mPostponedAlpha = 0.0f;
        goto L14
    L29:
        return;
    L8:
        if (this.mCurState < 1) goto L10;
        FragmentTransition.startTransitions(this.mHost.getContext(), this.mContainer, r2, r3, 0, 1, true, this.mFragmentTransitionCallback);
        goto L10
    L4:
        r10.executeOps();
        goto L5
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

    private void setVisibleRemovingFragment(Fragment r3) {
        ViewGroup r2 = getFragmentContainer(r3);
        if (r2 != null) goto L5;
        return;
    L5:
        if ((((r3.getEnterAnim() + r3.getExitAnim()) + r3.getPopEnterAnim()) + r3.getPopExitAnim()) > 0) goto L7;
        return;
    L7:
        if (r2.getTag(R.id.visible_removing_fragment_view_tag) != null) goto L9;
        r2.setTag(R.id.visible_removing_fragment_view_tag, r3);
    L9:
        ((Fragment) r2.getTag(R.id.visible_removing_fragment_view_tag)).setPopDirection(r3.getPopDirection());
    }

    private ViewGroup getFragmentContainer(Fragment r3) {
        if (r3.mContainer == null) goto L7;
        return r3.mContainer;
    L7:
        if (r3.mContainerId > 0) goto L10;
        return null;
    L10:
        if (this.mContainer.onHasView() == false) goto L15;
        View r2 = this.mContainer.onFindViewById(r3.mContainerId);
        if ((r2 instanceof ViewGroup) == false) goto L15;
        return (ViewGroup) r2;
    L15:
        return null;
    }

    private void addAddedFragments(ArraySet<Fragment> r5) {
        int r0 = this.mCurState;
        if (r0 >= 1) goto L5;
        return;
    L5:
        int r1 = Math.min(r0, 5);
        Iterator<Fragment> r2 = this.mFragmentStore.getFragments().iterator();
    L7:
        if (r2.hasNext() == false) goto L17;
        Fragment r3 = r2.next();
        if (r3.mState >= r1) goto L7;
        moveToState(r3, r1);
        if (r3.mView == null) goto L7;
        if (r3.mHidden == true) goto L7;
        if (r3.mIsNewlyAdded == false) goto L7;
        r5.add(r3);
        goto L7
    }

    private void forcePostponedTransactions() {
        if (USE_STATE_MANAGER == false) goto L9;
        Iterator<SpecialEffectsController> r2 = collectAllSpecialEffectsController().iterator();
    L6:
        if (r2.hasNext() == false) goto L16;
        r2.next().forcePostponedExecutePendingOperations();
        goto L6
    L16:
        return;
    L9:
        if (this.mPostponedTransactions != null) goto L11;
        return;
    L11:
        if (this.mPostponedTransactions.isEmpty() == true) goto L17;
        this.mPostponedTransactions.remove(0).completeTransaction();
        goto L11
    }

    private void endAnimatingAwayFragments() {
        if (USE_STATE_MANAGER == false) goto L9;
        Iterator<SpecialEffectsController> r2 = collectAllSpecialEffectsController().iterator();
    L6:
        if (r2.hasNext() == false) goto L17;
        r2.next().forceCompleteAllOperations();
        goto L6
    L17:
        return;
    L9:
        if (this.mExitAnimationCancellationSignals.isEmpty() == true) goto L14;
        Iterator<Fragment> r0 = this.mExitAnimationCancellationSignals.keySet().iterator();
    L12:
        if (r0.hasNext() == false) goto L18;
        Fragment r1 = r0.next();
        cancelExitAnimation(r1);
        moveToState(r1);
        goto L12
    L18:
        return;
    }

    private Set<SpecialEffectsController> collectAllSpecialEffectsController() {
        HashSet r0 = new HashSet();
        Iterator<FragmentStateManager> r1 = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        ViewGroup r2 = r1.next().getFragment().mContainer;
        if (r2 == null) goto L4;
        r0.add(SpecialEffectsController.getOrCreateController(r2, getSpecialEffectsControllerFactory()));
        goto L4
    L8:
        return r0;
    }

    private boolean generateOpsForPendingActions(ArrayList<BackStackRecord> r6, ArrayList<Boolean> r7) {
        ArrayList<OpGenerator> r0 = this.mPendingActions;
        monitor-enter(r0);
        int r2 = 0;
        if (this.mPendingActions.isEmpty() == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return false;
    L8:
        int r1 = this.mPendingActions.size();     // Catch: Throwable -> L14
        boolean r3 = false;
    L9:
        if (r2 >= r1) goto L11;
        r3 = r3 | this.mPendingActions.get(r2).generateOps(r6, r7);     // Catch: Throwable -> L14
        r2 = r2 + 1;     // Catch: Throwable -> L14
        goto L9
    L11:
        this.mPendingActions.clear();     // Catch: Throwable -> L14
        this.mHost.getHandler().removeCallbacks(this.mExecCommit);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r3;
    L14:
        th = move-exception;
        throw th;
    }

    private void doPendingDeferredStart() {
        if (this.mHavePendingDeferredStart == false) goto L6;
        this.mHavePendingDeferredStart = false;
        startPendingDeferredFragments();
        return;
    }

    private void reportBackStackChanged() {
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

    void addBackStackState(BackStackRecord r2) {
        if (this.mBackStack != null) goto L5;
        this.mBackStack = new ArrayList();
    L5:
        this.mBackStack.add(r2);
    }

    boolean popBackStackState(ArrayList<BackStackRecord> r6, ArrayList<Boolean> r7, String r8, int r9, int r10) {
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
        r7.add(true);
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
        r7.add(true);
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

    @Deprecated
    FragmentManagerNonConfig retainNonConfig() {
        if ((this.mHost instanceof ViewModelStoreOwner) == false) goto L6;
        throwException(new IllegalStateException("You cannot use retainNonConfig when your FragmentHostCallback implements ViewModelStoreOwner."));
    L6:
        return this.mNonConfig.getSnapshot();
    }

    Parcelable saveAllState() {
        forcePostponedTransactions();
        endAnimatingAwayFragments();
        execPendingActions(true);
        this.mStateSaved = true;
        this.mNonConfig.setIsStateSaved(true);
        ArrayList<FragmentState> r0 = this.mFragmentStore.saveActiveFragments();
        BackStackState[] r4 = null;
        if (r0.isEmpty() == true) goto L5;
        ArrayList<String> r1 = this.mFragmentStore.saveAddedFragments();
        ArrayList<BackStackRecord> r5 = this.mBackStack;
        if (r5 == null) goto L18;
        int r6 = r5.size();
        if (r6 <= 0) goto L18;
        r4 = new BackStackState[r6];
        int r7 = 0;
    L13:
        if (r7 >= r6) goto L18;
        r4[r7] = new BackStackState(this.mBackStack.get(r7));
        if (isLoggingEnabled(2) == false) goto L17;
        Log.v(TAG, "saveAllState: adding back stack #" + r7 + ": " + this.mBackStack.get(r7));
    L17:
        r7 = r7 + 1;
    L18:
        FragmentManagerState r2 = new FragmentManagerState();
        r2.mActive = r0;
        r2.mAdded = r1;
        r2.mBackStack = r4;
        r2.mBackStackIndex = this.mBackStackIndex.get();
        Fragment r3 = this.mPrimaryNav;
        if (r3 == null) goto L21;
        r2.mPrimaryNavActiveWho = r3.mWho;
    L21:
        r2.mResultKeys.addAll(this.mResults.keySet());
        r2.mResults.addAll(this.mResults.values());
        r2.mLaunchedFragments = new ArrayList(this.mLaunchedFragments);
        return r2;
    L5:
        if (isLoggingEnabled(2) == false) goto L7;
        Log.v(TAG, "saveAllState: no fragments!");
    L7:
        return null;
    }

    void restoreAllState(Parcelable r3, FragmentManagerNonConfig r4) {
        if ((this.mHost instanceof ViewModelStoreOwner) == false) goto L5;
        throwException(new IllegalStateException("You must use restoreSaveState when your FragmentHostCallback implements ViewModelStoreOwner"));
    L5:
        this.mNonConfig.restoreFromSnapshot(r4);
        restoreSaveState(r3);
    }

    void restoreSaveState(Parcelable r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        FragmentManagerState r13 = (FragmentManagerState) r12;
        if (r13.mActive != null) goto L7;
        return;
    L7:
        this.mFragmentStore.resetActiveFragments();
        Iterator<FragmentState> r0 = r13.mActive.iterator();
    L9:
        if (r0.hasNext() == false) goto L23;
        FragmentState r10 = r0.next();
        if (r10 == null) goto L9;
        Fragment r1 = this.mNonConfig.findRetainedFragmentByWho(r10.mWho);
        if (r1 != null) goto L15;
        FragmentStateManager r5 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, this.mHost.getContext().getClassLoader(), getFragmentFactory(), r10);
    L19:
        Fragment r2 = r5.getFragment();
        r2.mFragmentManager = this;
        if (isLoggingEnabled(2) == false) goto L22;
        Log.v(TAG, "restoreSaveState: active (" + r2.mWho + "): " + r2);
    L22:
        r5.restoreState(this.mHost.getContext().getClassLoader());
        this.mFragmentStore.makeActive(r5);
        r5.setFragmentManagerState(this.mCurState);
        goto L9
    L15:
        if (isLoggingEnabled(2) == false) goto L17;
        Log.v(TAG, "restoreSaveState: re-attaching retained " + r1);
    L17:
        r5 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, r1, r10);
        goto L19
    L23:
        Iterator<Fragment> r3 = this.mNonConfig.getRetainedFragments().iterator();
    L25:
        if (r3.hasNext() == false) goto L32;
        Fragment r4 = r3.next();
        if (this.mFragmentStore.containsActiveFragment(r4.mWho) == true) goto L25;
        if (isLoggingEnabled(2) == false) goto L31;
        Log.v(TAG, "Discarding retained Fragment " + r4 + " that was not found in the set of active Fragments " + r13.mActive);
    L31:
        this.mNonConfig.removeRetainedFragment(r4);
        r4.mFragmentManager = this;
        FragmentStateManager r6 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, r4);
        r6.setFragmentManagerState(1);
        r6.moveToExpectedState();
        r4.mRemoving = true;
        r6.moveToExpectedState();
        goto L25
    L32:
        this.mFragmentStore.restoreAddedFragments(r13.mAdded);
        int r7 = 0;
        if (r13.mBackStack == null) goto L41;
        this.mBackStack = new ArrayList(r13.mBackStack.length);
        int r8 = 0;
    L36:
        if (r8 >= r13.mBackStack.length) goto L42;
        BackStackRecord r9 = r13.mBackStack[r8].instantiate(this);
        if (isLoggingEnabled(2) == false) goto L40;
        Log.v(TAG, "restoreAllState: back stack #" + r8 + " (index " + r9.mIndex + "): " + r9);
        PrintWriter r11 = new PrintWriter(new LogWriter(TAG));
        r9.dump("  ", r11, false);
        r11.close();
    L40:
        this.mBackStack.add(r9);
        r8 = r8 + 1;
    L42:
        this.mBackStackIndex.set(r13.mBackStackIndex);
        if (r13.mPrimaryNavActiveWho == null) goto L45;
        Fragment r14 = findActiveFragment(r13.mPrimaryNavActiveWho);
        this.mPrimaryNav = r14;
        dispatchParentPrimaryNavigationFragmentChanged(r14);
    L45:
        ArrayList<String> r15 = r13.mResultKeys;
        if (r15 != null) goto L48;
    L50:
        this.mLaunchedFragments = new ArrayDeque(r13.mLaunchedFragments);
        return;
    L48:
        if (r7 >= r15.size()) goto L50;
        Bundle r16 = r13.mResults.get(r7);
        r16.setClassLoader(this.mHost.getContext().getClassLoader());
        this.mResults.put(r15.get(r7), r16);
        r7 = r7 + 1;
        goto L48
    L41:
        this.mBackStack = null;
        goto L42
    }

    FragmentHostCallback<?> getHost() {
        return this.mHost;
    }

    Fragment getParent() {
        return this.mParent;
    }

    FragmentContainer getContainer() {
        return this.mContainer;
    }

    FragmentStore getFragmentStore() {
        return this.mFragmentStore;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void attachController(FragmentHostCallback<?> r3, FragmentContainer r4, final Fragment r5) {
        if (this.mHost != null) goto L34;
        this.mHost = r3;
        this.mContainer = r4;
        this.mParent = r5;
        if (r5 == null) goto L8;
        addFragmentOnAttachListener(new AnonymousClass8(this, r5));
    L11:
        if (this.mParent == null) goto L14;
        updateOnBackPressedCallbackEnabled();
    L14:
        if ((r3 instanceof OnBackPressedDispatcherOwner) == false) goto L19;
        OnBackPressedDispatcherOwner r6 = (OnBackPressedDispatcherOwner) r3;
        OnBackPressedDispatcher r0 = r6.getOnBackPressedDispatcher();
        this.mOnBackPressedDispatcher = r0;
        LifecycleOwner r7 = r6;
        if (r5 == null) goto L18;
        r7 = r5;
    L18:
        r0.addCallback(r7, this.mOnBackPressedCallback);
    L19:
        if (r5 == null) goto L22;
        this.mNonConfig = r5.mFragmentManager.getChildNonConfig(r5);
    L25:
        this.mNonConfig.setIsStateSaved(isStateSaved());
        this.mFragmentStore.setNonConfig(this.mNonConfig);
        Object r8 = this.mHost;
        if ((r8 instanceof ActivityResultRegistryOwner) == false) goto L35;
        ActivityResultRegistry r9 = ((ActivityResultRegistryOwner) r8).getActivityResultRegistry();
        if (r5 == null) goto L30;
        String r10 = r5.mWho + ":";
    L31:
        String r11 = "FragmentManager:" + r10;
        this.mStartActivityForResult = r9.register(r11 + "StartActivityForResult", new ActivityResultContracts.StartActivityForResult(), new AnonymousClass9(this));
        this.mStartIntentSenderForResult = r9.register(r11 + "StartIntentSenderForResult", new FragmentIntentSenderContract(), new AnonymousClass10(this));
        this.mRequestPermissions = r9.register(r11 + "RequestPermissions", new ActivityResultContracts.RequestMultiplePermissions(), new AnonymousClass11(this));
        return;
    L30:
        r10 = "";
        goto L31
    L35:
        return;
    L22:
        if ((r3 instanceof ViewModelStoreOwner) == false) goto L24;
        this.mNonConfig = FragmentManagerViewModel.getInstance(((ViewModelStoreOwner) r3).getViewModelStore());
        goto L25
    L24:
        this.mNonConfig = new FragmentManagerViewModel(false);
        goto L25
    L8:
        if ((r3 instanceof FragmentOnAttachListener) == false) goto L11;
        addFragmentOnAttachListener((FragmentOnAttachListener) r3);
        goto L11
    L34:
        throw new IllegalStateException("Already attached");
    }

    void noteStateNotSaved() {
        if (this.mHost != null) goto L5;
        return;
    L5:
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        Iterator<Fragment> r2 = this.mFragmentStore.getFragments().iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        Fragment r0 = r2.next();
        if (r0 == null) goto L7;
        r0.noteStateNotSaved();
        goto L7
    }

    void launchStartActivityForResult(Fragment r2, Intent r3, int r4, Bundle r5) {
        if (this.mStartActivityForResult == null) goto L9;
        LaunchedFragmentInfo r0 = new LaunchedFragmentInfo(r2.mWho, r4);
        this.mLaunchedFragments.addLast(r0);
        if (r3 == null) goto L8;
        if (r5 == null) goto L8;
        r3.putExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, r5);
    L8:
        this.mStartActivityForResult.launch(r3);
        return;
    L9:
        this.mHost.onStartActivityFromFragment(r2, r3, r4, r5);
    }

    void launchStartIntentSenderForResult(Fragment r11, IntentSender r12, int r13, Intent r14, int r15, int r16, int r17, Bundle r18) throws IntentSender.SendIntentException {
        if (this.mStartIntentSenderForResult != null) goto L5;
        this.mHost.onStartIntentSenderFromFragment(r11, r12, r13, r14, r15, r16, r17, r18);
        return;
    L5:
        if (r18 == null) goto L13;
        if (r14 != null) goto L8;
        Intent r4 = new Intent();
        r4.putExtra(EXTRA_CREATED_FILLIN_INTENT, true);
    L10:
        if (isLoggingEnabled(2) == false) goto L12;
        Log.v(TAG, "ActivityOptions " + r18 + " were added to fillInIntent " + r4 + " for fragment " + r11);
    L12:
        r4.putExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, r18);
    L14:
        IntentSenderRequest r5 = new IntentSenderRequest.Builder(r12).setFillInIntent(r4).setFlags(r16, r15).build();
        this.mLaunchedFragments.addLast(new LaunchedFragmentInfo(r11.mWho, r13));
        if (isLoggingEnabled(2) == false) goto L17;
        Log.v(TAG, "Fragment " + r11 + "is launching an IntentSender for result ");
    L17:
        this.mStartIntentSenderForResult.launch(r5);
        return;
    L8:
        r4 = r14;
        goto L10
    L13:
        r4 = r14;
        goto L14
    }

    void launchRequestPermissions(Fragment r2, String[] r3, int r4) {
        if (this.mRequestPermissions == null) goto L5;
        LaunchedFragmentInfo r0 = new LaunchedFragmentInfo(r2.mWho, r4);
        this.mLaunchedFragments.addLast(r0);
        this.mRequestPermissions.launch(r3);
        return;
    L5:
        this.mHost.onRequestPermissionsFromFragment(r2, r3, r4);
    }

    void dispatchAttach() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        dispatchStateChange(0);
    }

    void dispatchCreate() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        dispatchStateChange(1);
    }

    void dispatchViewCreated() {
        dispatchStateChange(2);
    }

    void dispatchActivityCreated() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        dispatchStateChange(4);
    }

    void dispatchStart() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        dispatchStateChange(5);
    }

    void dispatchResume() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        dispatchStateChange(7);
    }

    void dispatchPause() {
        dispatchStateChange(5);
    }

    void dispatchStop() {
        this.mStopped = true;
        this.mNonConfig.setIsStateSaved(true);
        dispatchStateChange(4);
    }

    void dispatchDestroyView() {
        dispatchStateChange(1);
    }

    void dispatchDestroy() {
        this.mDestroyed = true;
        execPendingActions(true);
        endAnimatingAwayFragments();
        dispatchStateChange(-1);
        this.mHost = null;
        this.mContainer = null;
        this.mParent = null;
        if (this.mOnBackPressedDispatcher == null) goto L5;
        this.mOnBackPressedCallback.remove();
        this.mOnBackPressedDispatcher = null;
    L5:
        ActivityResultLauncher<Intent> r0 = this.mStartActivityForResult;
        if (r0 == null) goto L9;
        r0.unregister();
        this.mStartIntentSenderForResult.unregister();
        this.mRequestPermissions.unregister();
        return;
    }

    private void dispatchStateChange(int r4) {
        this.mExecutingActions = true;     // Catch: Throwable -> L12
        this.mFragmentStore.dispatchStateChange(r4);     // Catch: Throwable -> L12
        moveToState(r4, false);     // Catch: Throwable -> L12
        if (USE_STATE_MANAGER == false) goto L10;
        Iterator<SpecialEffectsController> r5 = collectAllSpecialEffectsController().iterator();     // Catch: Throwable -> L12
    L7:
        if (r5.hasNext() == false) goto L10;
        r5.next().forceCompleteAllOperations();     // Catch: Throwable -> L12
    L10:
        this.mExecutingActions = false;
        execPendingActions(true);
        return;
    L12:
        th = move-exception;
        this.mExecutingActions = false;
        throw th;
    }

    void dispatchMultiWindowModeChanged(boolean r2) {
        Iterator<Fragment> r1 = this.mFragmentStore.getFragments().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Fragment r0 = r1.next();
        if (r0 == null) goto L4;
        r0.performMultiWindowModeChanged(r2);
        goto L4
    }

    void dispatchPictureInPictureModeChanged(boolean r2) {
        Iterator<Fragment> r1 = this.mFragmentStore.getFragments().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Fragment r0 = r1.next();
        if (r0 == null) goto L4;
        r0.performPictureInPictureModeChanged(r2);
        goto L4
    }

    void dispatchConfigurationChanged(Configuration r2) {
        Iterator<Fragment> r1 = this.mFragmentStore.getFragments().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Fragment r0 = r1.next();
        if (r0 == null) goto L4;
        r0.performConfigurationChanged(r2);
        goto L4
    }

    void dispatchLowMemory() {
        Iterator<Fragment> r1 = this.mFragmentStore.getFragments().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Fragment r0 = r1.next();
        if (r0 == null) goto L4;
        r0.performLowMemory();
        goto L4
    }

    boolean dispatchCreateOptionsMenu(Menu r8, MenuInflater r9) {
        int r1 = 0;
        if (this.mCurState >= 1) goto L5;
        return false;
    L5:
        Iterator<Fragment> r0 = this.mFragmentStore.getFragments().iterator();
        ArrayList<Fragment> r3 = null;
        boolean r4 = false;
    L7:
        if (r0.hasNext() == false) goto L18;
        Fragment r5 = r0.next();
        if (r5 == null) goto L7;
        if (isParentMenuVisible(r5) == false) goto L7;
        if (r5.performCreateOptionsMenu(r8, r9) == false) goto L7;
        if (r3 != null) goto L16;
        r3 = new ArrayList();
    L16:
        r3.add(r5);
        r4 = true;
        goto L7
    L18:
        if (this.mCreatedMenus != null) goto L20;
    L27:
        this.mCreatedMenus = r3;
        return r4;
    L20:
        if (r1 >= this.mCreatedMenus.size()) goto L27;
        Fragment r10 = this.mCreatedMenus.get(r1);
        if (r3 != null) goto L24;
    L25:
        r10.onDestroyOptionsMenu();
    L26:
        r1 = r1 + 1;
        goto L20
    L24:
        if (r3.contains(r10) == true) goto L26;
        goto L25
    }

    boolean dispatchPrepareOptionsMenu(Menu r6) {
        boolean r1 = false;
        if (this.mCurState >= 1) goto L5;
        return false;
    L5:
        Iterator<Fragment> r0 = this.mFragmentStore.getFragments().iterator();
    L7:
        if (r0.hasNext() == false) goto L15;
        Fragment r3 = r0.next();
        if (r3 == null) goto L7;
        if (isParentMenuVisible(r3) == false) goto L7;
        if (r3.performPrepareOptionsMenu(r6) == false) goto L7;
        r1 = true;
        goto L7
    L15:
        return r1;
    }

    boolean dispatchOptionsItemSelected(MenuItem r4) {
        if (this.mCurState >= 1) goto L5;
        return false;
    L5:
        Iterator<Fragment> r3 = this.mFragmentStore.getFragments().iterator();
    L7:
        if (r3.hasNext() == false) goto L13;
        Fragment r0 = r3.next();
        if (r0 == null) goto L7;
        if (r0.performOptionsItemSelected(r4) == false) goto L7;
        return true;
    L13:
        return false;
    }

    boolean dispatchContextItemSelected(MenuItem r4) {
        if (this.mCurState >= 1) goto L5;
        return false;
    L5:
        Iterator<Fragment> r3 = this.mFragmentStore.getFragments().iterator();
    L7:
        if (r3.hasNext() == false) goto L13;
        Fragment r0 = r3.next();
        if (r0 == null) goto L7;
        if (r0.performContextItemSelected(r4) == false) goto L7;
        return true;
    L13:
        return false;
    }

    void dispatchOptionsMenuClosed(Menu r3) {
        if (this.mCurState >= 1) goto L5;
        return;
    L5:
        Iterator<Fragment> r2 = this.mFragmentStore.getFragments().iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        Fragment r0 = r2.next();
        if (r0 == null) goto L7;
        r0.performOptionsMenuClosed(r3);
        goto L7
    }

    void setPrimaryNavigationFragment(Fragment r4) {
        if (r4 != null) goto L4;
    L12:
        Fragment r0 = this.mPrimaryNav;
        this.mPrimaryNav = r4;
        dispatchParentPrimaryNavigationFragmentChanged(r0);
        dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
        return;
    L4:
        if (r4.equals(findActiveFragment(r4.mWho)) == false) goto L11;
        if (r4.mHost == null) goto L12;
        if (r4.mFragmentManager == this) goto L12;
    L11:
        throw new IllegalArgumentException("Fragment " + r4 + " is not an active fragment of FragmentManager " + this);
    }

    private void dispatchParentPrimaryNavigationFragmentChanged(Fragment r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.equals(findActiveFragment(r2.mWho)) == false) goto L8;
        r2.performPrimaryNavigationFragmentChanged();
        return;
    }

    void dispatchPrimaryNavigationFragmentChanged() {
        updateOnBackPressedCallbackEnabled();
        dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
    }

    public Fragment getPrimaryNavigationFragment() {
        return this.mPrimaryNav;
    }

    void setMaxLifecycle(Fragment r3, Lifecycle.State r4) {
        if (r3.equals(findActiveFragment(r3.mWho)) == false) goto L11;
        if (r3.mHost != null) goto L7;
    L8:
        r3.mMaxState = r4;
        return;
    L7:
        if (r3.mFragmentManager == this) goto L8;
    L11:
        throw new IllegalArgumentException("Fragment " + r3 + " is not an active fragment of FragmentManager " + this);
    }

    public void setFragmentFactory(FragmentFactory r1) {
        this.mFragmentFactory = r1;
    }

    public FragmentFactory getFragmentFactory() {
        FragmentFactory r0 = this.mFragmentFactory;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Fragment r1 = this.mParent;
        if (r1 == null) goto L10;
        return r1.mFragmentManager.getFragmentFactory();
    L10:
        return this.mHostFragmentFactory;
    }

    void setSpecialEffectsControllerFactory(SpecialEffectsControllerFactory r1) {
        this.mSpecialEffectsControllerFactory = r1;
    }

    SpecialEffectsControllerFactory getSpecialEffectsControllerFactory() {
        SpecialEffectsControllerFactory r0 = this.mSpecialEffectsControllerFactory;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Fragment r1 = this.mParent;
        if (r1 == null) goto L10;
        return r1.mFragmentManager.getSpecialEffectsControllerFactory();
    L10:
        return this.mDefaultSpecialEffectsControllerFactory;
    }

    FragmentLifecycleCallbacksDispatcher getLifecycleCallbacksDispatcher() {
        return this.mLifecycleCallbacksDispatcher;
    }

    public void registerFragmentLifecycleCallbacks(FragmentLifecycleCallbacks r1, boolean r2) {
        this.mLifecycleCallbacksDispatcher.registerFragmentLifecycleCallbacks(r1, r2);
    }

    public void unregisterFragmentLifecycleCallbacks(FragmentLifecycleCallbacks r1) {
        this.mLifecycleCallbacksDispatcher.unregisterFragmentLifecycleCallbacks(r1);
    }

    public void addFragmentOnAttachListener(FragmentOnAttachListener r1) {
        this.mOnAttachListeners.add(r1);
    }

    void dispatchOnAttachFragment(Fragment r3) {
        Iterator<FragmentOnAttachListener> r0 = this.mOnAttachListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onAttachFragment(this, r3);
        goto L4
    }

    public void removeFragmentOnAttachListener(FragmentOnAttachListener r1) {
        this.mOnAttachListeners.remove(r1);
    }

    boolean checkForMenus() {
        Iterator<Fragment> r0 = this.mFragmentStore.getActiveFragments().iterator();
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

    private boolean isMenuAvailable(Fragment r1) {
        if (r1.mHasMenu == false) goto L7;
        if (r1.mMenuVisible == false) goto L7;
    L8:
        return true;
    L7:
        if (r1.mChildFragmentManager.checkForMenus() == true) goto L8;
        return false;
    }

    void invalidateMenuForFragment(Fragment r2) {
        if (r2.mAdded == true) goto L5;
        return;
    L5:
        if (isMenuAvailable(r2) == false) goto L9;
        this.mNeedMenuInvalidate = true;
        return;
    }

    LayoutInflater.Factory2 getLayoutInflaterFactory() {
        return this.mLayoutInflaterFactory;
    }
}
