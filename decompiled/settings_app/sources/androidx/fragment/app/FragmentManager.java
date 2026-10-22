package androidx.fragment.app;

import android.app.Activity;
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
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuProvider;
import androidx.fragment.R;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import com.GlobalProxyLancet;
import com.android.settings.utils.HanziToPinyin;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import obric.tablet.widget.BytedanceJustifyTextView;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentManager implements FragmentResultOwner {
    private static boolean DEBUG = false;
    private static final String EXTRA_CREATED_FILLIN_INTENT = "androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE";
    private static final String FRAGMENT_KEY_PREFIX = "fragment_";
    private static final String FRAGMENT_MANAGER_STATE_KEY = "state";
    public static final int POP_BACK_STACK_INCLUSIVE = 1;
    private static final String RESULT_KEY_PREFIX = "result_";
    private static final String SAVED_STATE_KEY = "android:support:fragments";
    public static final String TAG = "FragmentManager";
    ArrayList<BackStackRecord> mBackStack;
    private ArrayList<OnBackStackChangedListener> mBackStackChangeListeners;
    private final AtomicInteger mBackStackIndex;
    private final Map<String, BackStackState> mBackStackStates;
    private FragmentContainer mContainer;
    private ArrayList<Fragment> mCreatedMenus;
    int mCurState;
    private SpecialEffectsControllerFactory mDefaultSpecialEffectsControllerFactory;
    private boolean mDestroyed;
    private Runnable mExecCommit;
    private boolean mExecutingActions;
    private FragmentFactory mFragmentFactory;
    private final FragmentStore mFragmentStore;
    private boolean mHavePendingDeferredStart;
    private FragmentHostCallback<?> mHost;
    private FragmentFactory mHostFragmentFactory;
    ArrayDeque<LaunchedFragmentInfo> mLaunchedFragments;
    private final FragmentLayoutInflaterFactory mLayoutInflaterFactory;
    private final FragmentLifecycleCallbacksDispatcher mLifecycleCallbacksDispatcher;
    private final MenuProvider mMenuProvider;
    private boolean mNeedMenuInvalidate;
    private FragmentManagerViewModel mNonConfig;
    private final CopyOnWriteArrayList<FragmentOnAttachListener> mOnAttachListeners;
    private final OnBackPressedCallback mOnBackPressedCallback;
    private OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final Consumer<Configuration> mOnConfigurationChangedListener;
    private final Consumer<MultiWindowModeChangedInfo> mOnMultiWindowModeChangedListener;
    private final Consumer<PictureInPictureModeChangedInfo> mOnPictureInPictureModeChangedListener;
    private final Consumer<Integer> mOnTrimMemoryListener;
    private Fragment mParent;
    private final ArrayList<OpGenerator> mPendingActions;
    Fragment mPrimaryNav;
    private ActivityResultLauncher<String[]> mRequestPermissions;
    private final Map<String, LifecycleAwareResultListener> mResultListeners;
    private final Map<String, Bundle> mResults;
    private SpecialEffectsControllerFactory mSpecialEffectsControllerFactory;
    private ActivityResultLauncher<Intent> mStartActivityForResult;
    private ActivityResultLauncher<IntentSenderRequest> mStartIntentSenderForResult;
    private boolean mStateSaved;
    private boolean mStopped;
    private FragmentStrictMode.Policy mStrictModePolicy;
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

    private class ClearBackStackState implements OpGenerator {
        private final String mName;
        final /* synthetic */ FragmentManager this$0;

        ClearBackStackState(FragmentManager r1, String r2) {
            this.this$0 = r1;
            this.mName = r2;
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public boolean generateOps(ArrayList<BackStackRecord> r2, ArrayList<Boolean> r3) {
            return this.this$0.clearBackStackState(r2, r3, this.mName);
        }
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
            Bundle r1 = GlobalProxyLancet.com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(r5, ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
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
        default void onBackStackChangeCommitted(Fragment r1, boolean r2) {
        }

        default void onBackStackChangeStarted(Fragment r1, boolean r2) {
        }

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

    private class RestoreBackStackState implements OpGenerator {
        private final String mName;
        final /* synthetic */ FragmentManager this$0;

        RestoreBackStackState(FragmentManager r1, String r2) {
            this.this$0 = r1;
            this.mName = r2;
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public boolean generateOps(ArrayList<BackStackRecord> r2, ArrayList<Boolean> r3) {
            return this.this$0.restoreBackStackState(r2, r3, this.mName);
        }
    }

    private class SaveBackStackState implements OpGenerator {
        private final String mName;
        final /* synthetic */ FragmentManager this$0;

        SaveBackStackState(FragmentManager r1, String r2) {
            this.this$0 = r1;
            this.mName = r2;
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public boolean generateOps(ArrayList<BackStackRecord> r2, ArrayList<Boolean> r3) {
            return this.this$0.saveBackStackState(r2, r3, this.mName);
        }
    }

    static {
    }

    static int reverseTransit(int r3) {
        int r1 = 4097;
        if (r3 == 4097) goto L14;
        if (r3 == 8194) goto L17;
        r1 = FragmentTransaction.TRANSIT_FRAGMENT_MATCH_ACTIVITY_CLOSE;
        if (r3 != 8197) goto L8;
        return 4100;
    L8:
        if (r3 == 4099) goto L13;
        if (r3 == 4100) goto L17;
        return 0;
    L13:
        return 4099;
    L17:
        return r1;
    L14:
        return 8194;
    }

    public FragmentManager() {
        this.mPendingActions = new ArrayList();
        this.mFragmentStore = new FragmentStore();
        this.mLayoutInflaterFactory = new FragmentLayoutInflaterFactory(this);
        final boolean r1 = false;
        this.mOnBackPressedCallback = new AnonymousClass1(this, r1);
        this.mBackStackIndex = new AtomicInteger();
        this.mBackStackStates = Collections.synchronizedMap(new HashMap());
        this.mResults = Collections.synchronizedMap(new HashMap());
        this.mResultListeners = Collections.synchronizedMap(new HashMap());
        this.mLifecycleCallbacksDispatcher = new FragmentLifecycleCallbacksDispatcher(this);
        this.mOnAttachListeners = new CopyOnWriteArrayList();
        this.mOnConfigurationChangedListener = new FragmentManager$$ExternalSyntheticLambda0(this);
        this.mOnTrimMemoryListener = new FragmentManager$$ExternalSyntheticLambda1(this);
        this.mOnMultiWindowModeChangedListener = new FragmentManager$$ExternalSyntheticLambda2(this);
        this.mOnPictureInPictureModeChangedListener = new FragmentManager$$ExternalSyntheticLambda3(this);
        this.mMenuProvider = new AnonymousClass2(this);
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

    @Deprecated
    public static void enableDebugLogging(boolean r0) {
        DEBUG = r0;
    }

    public static boolean isLoggingEnabled(int r1) {
        if (DEBUG == false) goto L5;
    L8:
        return true;
    L5:
        if (Log.isLoggable(TAG, r1) == true) goto L8;
        return false;
    }

    /* JADX INFO: renamed from: lambda$new$0$androidx-fragment-app-FragmentManager, reason: not valid java name */
    /* synthetic */ void m53lambda$new$0$androidxfragmentappFragmentManager(Configuration r2) {
        if (isParentAdded() == false) goto L6;
        dispatchConfigurationChanged(r2, false);
        return;
    }

    /* JADX INFO: renamed from: lambda$new$1$androidx-fragment-app-FragmentManager, reason: not valid java name */
    /* synthetic */ void m54lambda$new$1$androidxfragmentappFragmentManager(Integer r2) {
        if (isParentAdded() == true) goto L5;
        return;
    L5:
        if (r2.intValue() != 80) goto L9;
        dispatchLowMemory(false);
        return;
    }

    /* JADX INFO: renamed from: lambda$new$2$androidx-fragment-app-FragmentManager, reason: not valid java name */
    /* synthetic */ void m55lambda$new$2$androidxfragmentappFragmentManager(MultiWindowModeChangedInfo r2) {
        if (isParentAdded() == false) goto L6;
        dispatchMultiWindowModeChanged(r2.isInMultiWindowMode(), false);
        return;
    }

    /* JADX INFO: renamed from: lambda$new$3$androidx-fragment-app-FragmentManager, reason: not valid java name */
    /* synthetic */ void m56lambda$new$3$androidxfragmentappFragmentManager(PictureInPictureModeChangedInfo r2) {
        if (isParentAdded() == false) goto L6;
        dispatchPictureInPictureModeChanged(r2.isInPictureInPictureMode(), false);
        return;
    }

    private void throwException(RuntimeException r8) {
        Log.e(TAG, r8.getMessage());
        Log.e(TAG, "Activity state:");
        PrintWriter r2 = new PrintWriter(new LogWriter(TAG));
        FragmentHostCallback<?> r0 = this.mHost;
        if (r0 == null) goto L15;
        r0.onDump(BytedanceJustifyTextView.TWO_BLANK, null, r2, new String[0]);     // Catch: Exception -> L6
        throw r8;
    L6:
        e = move-exception;
        Log.e(TAG, "Failed dumping state", e);
        throw r8;
    L15:
        dump(BytedanceJustifyTextView.TWO_BLANK, null, r2, new String[0]);     // Catch: Exception -> L10
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

    boolean isParentHidden(Fragment r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return r1.isHidden();
    }

    void handleOnBackPressed() {
        execPendingActions(true);
        if (this.mOnBackPressedCallback.isEnabled() == false) goto L5;
        popBackStackImmediate();
        return;
    L5:
        this.mOnBackPressedDispatcher.onBackPressed();
    }

    public void restoreBackStack(String r2) {
        enqueueAction(new RestoreBackStackState(this, r2), false);
    }

    public void saveBackStack(String r2) {
        enqueueAction(new SaveBackStackState(this, r2), false);
    }

    public void clearBackStack(String r2) {
        enqueueAction(new ClearBackStackState(this, r2), false);
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

    public void popBackStack(int r2, int r3) {
        popBackStack(r2, r3, false);
    }

    void popBackStack(int r3, int r4, boolean r5) {
        if (r3 < 0) goto L6;
        enqueueAction(new PopBackStackState(this, null, r3, r4), r5);
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

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void setFragmentResult(String r3, Bundle r4) {
        LifecycleAwareResultListener r0 = this.mResultListeners.get(r3);
        if (r0 != null) goto L5;
    L7:
        this.mResults.put(r3, r4);
    L9:
        if (isLoggingEnabled(2) == false) goto L12;
        Log.v(TAG, "Setting fragment result with key " + r3 + " and result " + r4);
        return;
    L12:
        return;
    L5:
        if (r0.isAtLeast(Lifecycle.State.STARTED) == false) goto L7;
        r0.onFragmentResult(r3, r4);
        goto L9
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void clearFragmentResult(String r2) {
        this.mResults.remove(r2);
        if (isLoggingEnabled(2) == false) goto L6;
        Log.v(TAG, "Clearing fragment result with key " + r2);
        return;
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void setFragmentResultListener(final String r3, LifecycleOwner r4, final FragmentResultListener r5) {
        final Lifecycle r6 = r4.getLifecycle();
        if (r6.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        LifecycleEventObserver r0 = new AnonymousClass6(this, r3, r5, r6);
        LifecycleAwareResultListener r2 = this.mResultListeners.put(r3, new LifecycleAwareResultListener(r6, r5, r0));
        if (r2 == null) goto L9;
        r2.removeObserver();
    L9:
        if (isLoggingEnabled(2) == false) goto L11;
        Log.v(TAG, "Setting FragmentResultListener with key " + r3 + " lifecycleOwner " + r6 + " and listener " + r5);
    L11:
        r6.addObserver(r0);
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void clearFragmentResultListener(String r2) {
        LifecycleAwareResultListener r1 = this.mResultListeners.remove(r2);
        if (r1 == null) goto L6;
        r1.removeObserver();
    L6:
        if (isLoggingEnabled(2) == false) goto L9;
        Log.v(TAG, "Clearing FragmentResultListener for key " + r2);
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

    static Fragment findViewFragment(View r2) {
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

    private void clearBackStackStateViewModels() {
        FragmentHostCallback<?> r0 = this.mHost;
        if ((r0 instanceof ViewModelStoreOwner) == false) goto L6;
        boolean r1 = this.mFragmentStore.getNonConfig().isCleared();
    L9:
        if (r1 == false) goto L17;
        Iterator<BackStackState> r2 = this.mBackStackStates.values().iterator();
    L12:
        if (r2.hasNext() == false) goto L20;
        Iterator<String> r3 = r2.next().mFragments.iterator();
    L15:
        if (r3.hasNext() == false) goto L12;
        this.mFragmentStore.getNonConfig().clearNonConfigState(r3.next(), false);
        goto L15
    L20:
        return;
    L17:
        return;
    L6:
        if ((r0.getContext() instanceof Activity) == false) goto L8;
        r1 = !((Activity) this.mHost.getContext()).isChangingConfigurations();
        goto L9
    L8:
        r1 = true;
        goto L9
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
        r0.append(VectorFormat.DEFAULT_PREFIX);
        r0.append(Integer.toHexString(System.identityHashCode(this.mParent)));
        r0.append(VectorFormat.DEFAULT_SUFFIX);
    L9:
        r0.append("}}");
        return r0.toString();
    L5:
        FragmentHostCallback<?> r2 = this.mHost;
        if (r2 == null) goto L8;
        r0.append(r2.getClass().getSimpleName());
        r0.append(VectorFormat.DEFAULT_PREFIX);
        r0.append(Integer.toHexString(System.identityHashCode(this.mHost)));
        r0.append(VectorFormat.DEFAULT_SUFFIX);
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
        r3.moveToExpectedState();
    }

    boolean isStateAtLeast(int r1) {
        if (this.mCurState < r1) goto L5;
        return true;
    L5:
        return false;
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

    void moveToState(int r2, boolean r3) {
        if (this.mHost == null) goto L5;
    L9:
        if (r3 == false) goto L11;
    L13:
        this.mCurState = r2;
        this.mFragmentStore.moveToExpectedState();
        startPendingDeferredFragments();
        if (this.mNeedMenuInvalidate == false) goto L21;
        FragmentHostCallback<?> r4 = this.mHost;
        if (r4 != null) goto L18;
        return;
    L18:
        if (this.mCurState != 7) goto L23;
        r4.onSupportInvalidateOptionsMenu();
        this.mNeedMenuInvalidate = false;
        return;
    L23:
        return;
    L21:
        return;
    L11:
        if (r2 != this.mCurState) goto L13;
        return;
    L5:
        if (r2 == (-1)) goto L9;
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
        if (r4.mPreviousWho == null) goto L6;
        FragmentStrictMode.onFragmentReuse(r4, r4.mPreviousWho);
    L6:
        if (isLoggingEnabled(2) == false) goto L8;
        Log.v(TAG, "add: " + r4);
    L8:
        FragmentStateManager r0 = createOrGetFragmentStateManager(r4);
        r4.mFragmentManager = this;
        this.mFragmentStore.makeActive(r0);
        if (r4.mDetached == true) goto L16;
        this.mFragmentStore.addFragment(r4);
        r4.mRemoving = false;
        if (r4.mView != null) goto L14;
        r4.mHiddenChanged = false;
    L14:
        if (isMenuAvailable(r4) == false) goto L16;
        this.mNeedMenuInvalidate = true;
    L16:
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
        boolean r2 = true;
        if (this.mPendingActions.size() == 1) goto L8;
        r2 = false;
    L8:
        if (r2 == false) goto L10;
        this.mHost.getHandler().removeCallbacks(this.mExecCommit);     // Catch: Throwable -> L12
        this.mHost.getHandler().post(this.mExecCommit);     // Catch: Throwable -> L12
        updateOnBackPressedCallbackEnabled();     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    int allocBackStackIndex() {
        return this.mBackStackIndex.getAndIncrement();
    }

    private void ensureExecReady(boolean r3) {
        if (this.mExecutingActions == true) goto L23;
        if (this.mHost != null) goto L13;
        if (this.mDestroyed == false) goto L11;
        throw new IllegalStateException("FragmentManager has been destroyed");
    L11:
        throw new IllegalStateException("FragmentManager has not been attached to a host.");
    L13:
        if (Looper.myLooper() != this.mHost.getHandler().getLooper()) goto L21;
        if (r3 == true) goto L17;
        checkStateLoss();
    L17:
        if (this.mTmpRecords != null) goto L24;
        this.mTmpRecords = new ArrayList();
        this.mTmpIsPop = new ArrayList();
        return;
    L24:
        return;
    L21:
        throw new IllegalStateException("Must be called from main thread of fragment host");
    L23:
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

    private void removeRedundantOperationsAndExecute(ArrayList<BackStackRecord> r5, ArrayList<Boolean> r6) {
        if (r5.isEmpty() == false) goto L6;
        return;
    L6:
        if (r5.size() != r6.size()) goto L27;
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

    private void executeOpsTogether(ArrayList<BackStackRecord> r9, ArrayList<Boolean> r10, int r11, int r12) {
        boolean r0 = r9.get(r11).mReorderingAllowed;
        ArrayList<Fragment> r1 = this.mTmpAddedFragments;
        if (r1 != null) goto L5;
        this.mTmpAddedFragments = new ArrayList();
    L6:
        this.mTmpAddedFragments.addAll(this.mFragmentStore.getFragments());
        Fragment r2 = getPrimaryNavigationFragment();
        int r3 = r11;
        boolean r4 = false;
    L8:
        if (r3 >= r12) goto L20;
        BackStackRecord r6 = r9.get(r3);
        if (r10.get(r3).booleanValue() == true) goto L12;
        r2 = r6.expandOps(this.mTmpAddedFragments, r2);
    L13:
        if (r4 == false) goto L15;
    L18:
        r4 = true;
    L19:
        r3 = r3 + 1;
        goto L8
    L15:
        if (r6.mAddToBackStack == true) goto L18;
        r4 = false;
        goto L19
    L12:
        r2 = r6.trackAddedFragmentsInPop(this.mTmpAddedFragments, r2);
        goto L13
    L20:
        this.mTmpAddedFragments.clear();
        if (r0 == false) goto L23;
    L35:
        executeOps(r9, r10, r11, r12);
        boolean r5 = r10.get(r12 - 1).booleanValue();
        if (r4 == false) goto L59;
        ArrayList<OnBackStackChangedListener> r7 = this.mBackStackChangeListeners;
        if (r7 == null) goto L59;
        if (r7.isEmpty() == true) goto L59;
        LinkedHashSet r8 = new LinkedHashSet();
        Iterator<BackStackRecord> r13 = r9.iterator();
    L43:
        if (r13.hasNext() == false) goto L45;
        r8.addAll(fragmentsFromRecord(r13.next()));
        goto L43
    L45:
        Iterator<OnBackStackChangedListener> r14 = this.mBackStackChangeListeners.iterator();
    L47:
        if (r14.hasNext() == false) goto L52;
        OnBackStackChangedListener r15 = r14.next();
        Iterator r16 = r8.iterator();
    L50:
        if (r16.hasNext() == false) goto L47;
        r15.onBackStackChangeStarted((Fragment) r16.next(), r5);
        goto L50
    L52:
        Iterator<OnBackStackChangedListener> r17 = this.mBackStackChangeListeners.iterator();
    L54:
        if (r17.hasNext() == false) goto L59;
        OnBackStackChangedListener r18 = r17.next();
        Iterator r19 = r8.iterator();
    L57:
        if (r19.hasNext() == false) goto L54;
        r18.onBackStackChangeCommitted((Fragment) r19.next(), r5);
    L59:
        int r20 = r11;
    L60:
        if (r20 >= r12) goto L76;
        BackStackRecord r21 = r9.get(r20);
        if (r5 == false) goto L69;
        int r22 = r21.mOps.size() - 1;
    L64:
        if (r22 < 0) goto L75;
        Fragment r23 = r21.mOps.get(r22).mFragment;
        if (r23 == null) goto L68;
        createOrGetFragmentStateManager(r23).moveToExpectedState();
    L68:
        r22 = r22 - 1;
    L75:
        r20 = r20 + 1;
        goto L60
    L69:
        Iterator<FragmentTransaction.Op> r24 = r21.mOps.iterator();
    L71:
        if (r24.hasNext() == false) goto L75;
        Fragment r25 = r24.next().mFragment;
        if (r25 == null) goto L71;
        createOrGetFragmentStateManager(r25).moveToExpectedState();
        goto L71
    L76:
        moveToState(this.mCurState, true);
        Iterator<SpecialEffectsController> r26 = collectChangedControllers(r9, r11, r12).iterator();
    L78:
        if (r26.hasNext() == false) goto L80;
        SpecialEffectsController r27 = r26.next();
        r27.updateOperationDirection(r5);
        r27.markPostponedState();
        r27.executePendingOperations();
    L80:
        if (r11 >= r12) goto L87;
        BackStackRecord r28 = r9.get(r11);
        if (r10.get(r11).booleanValue() == false) goto L86;
        if (r28.mIndex < 0) goto L86;
        r28.mIndex = -1;
    L86:
        r28.runOnCommitRunnables();
        r11 = r11 + 1;
        goto L80
    L87:
        if (r4 == false) goto L120;
        reportBackStackChanged();
        return;
    L120:
        return;
    L23:
        if (this.mCurState < 1) goto L35;
        int r29 = r11;
    L25:
        if (r29 >= r12) goto L35;
        Iterator<FragmentTransaction.Op> r30 = r9.get(r29).mOps.iterator();
    L28:
        if (r30.hasNext() == false) goto L34;
        Fragment r31 = r30.next().mFragment;
        if (r31 == null) goto L28;
        if (r31.mFragmentManager == null) goto L28;
        this.mFragmentStore.makeActive(createOrGetFragmentStateManager(r31));
        goto L28
    L34:
        r29 = r29 + 1;
        goto L25
    L5:
        r1.clear();
        goto L6
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

    private static void executeOps(ArrayList<BackStackRecord> r2, ArrayList<Boolean> r3, int r4, int r5) {
    L2:
        if (r4 >= r5) goto L8;
        BackStackRecord r0 = r2.get(r4);
        if (r3.get(r4).booleanValue() == false) goto L6;
        r0.bumpBackStackNesting(-1);
        r0.executePopOps();
    L7:
        r4 = r4 + 1;
        goto L2
    L6:
        r0.bumpBackStackNesting(1);
        r0.executeOps();
        goto L7
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

    private void forcePostponedTransactions() {
        Iterator<SpecialEffectsController> r1 = collectAllSpecialEffectsController().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().forcePostponedExecutePendingOperations();
        goto L4
    }

    private void endAnimatingAwayFragments() {
        Iterator<SpecialEffectsController> r1 = collectAllSpecialEffectsController().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().forceCompleteAllOperations();
        goto L4
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
        if (this.mPendingActions.isEmpty() == false) goto L21;
        monitor-exit(r0);     // Catch: Throwable -> L18
        return false;
    L21:
        int r1 = this.mPendingActions.size();     // Catch: Throwable -> L15
        boolean r3 = false;
    L9:
        if (r2 >= r1) goto L12;
        r3 = r3 | this.mPendingActions.get(r2).generateOps(r6, r7);
        r2 = r2 + 1;
        goto L9
    L12:
        this.mPendingActions.clear();     // Catch: Throwable -> L18
        this.mHost.getHandler().removeCallbacks(this.mExecCommit);     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return r3;
    L15:
        th = move-exception;
        this.mPendingActions.clear();     // Catch: Throwable -> L18
        this.mHost.getHandler().removeCallbacks(this.mExecCommit);     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
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

    private Set<Fragment> fragmentsFromRecord(BackStackRecord r4) {
        HashSet r3 = new HashSet();
        int r0 = 0;
    L4:
        if (r0 >= r4.mOps.size()) goto L11;
        Fragment r1 = r4.mOps.get(r0).mFragment;
        if (r1 == null) goto L10;
        if (r4.mAddToBackStack == false) goto L10;
        r3.add(r1);
    L10:
        r0 = r0 + 1;
        goto L4
    L11:
        return r3;
    }

    void addBackStackState(BackStackRecord r2) {
        if (this.mBackStack != null) goto L5;
        this.mBackStack = new ArrayList();
    L5:
        this.mBackStack.add(r2);
    }

    boolean restoreBackStackState(ArrayList<BackStackRecord> r7, ArrayList<Boolean> r8, String r9) {
        BackStackState r10 = this.mBackStackStates.remove(r9);
        if (r10 != null) goto L5;
        return false;
    L5:
        HashMap r1 = new HashMap();
        Iterator<BackStackRecord> r2 = r7.iterator();
    L7:
        if (r2.hasNext() == false) goto L16;
        BackStackRecord r3 = r2.next();
        if (r3.mBeingSaved == false) goto L7;
        Iterator<FragmentTransaction.Op> r4 = r3.mOps.iterator();
    L12:
        if (r4.hasNext() == false) goto L7;
        FragmentTransaction.Op r5 = r4.next();
        if (r5.mFragment == null) goto L12;
        r1.put(r5.mFragment.mWho, r5.mFragment);
        goto L12
    L16:
        Iterator<BackStackRecord> r6 = r10.instantiate(this, r1).iterator();
    L17:
        boolean r11 = false;
    L19:
        if (r6.hasNext() == false) goto L24;
        if (r6.next().generateOps(r7, r8) == true) goto L23;
        if (r11 == false) goto L17;
    L23:
        r11 = true;
        goto L19
    L24:
        return r11;
    }

    boolean saveBackStackState(ArrayList<BackStackRecord> r17, ArrayList<Boolean> r18, String r19) {
        int r2 = findBackStackIndex(r19, -1, true);
        if (r2 >= 0) goto L6;
        return false;
    L6:
        int r4 = r2;
    L8:
        if (r4 >= this.mBackStack.size()) goto L13;
        BackStackRecord r5 = this.mBackStack.get(r4);
        if (r5.mReorderingAllowed == true) goto L12;
        throwException(new IllegalArgumentException("saveBackStack(\"" + r19 + "\") included FragmentTransactions must use setReorderingAllowed(true) to ensure that the back stack can be restored as an atomic operation. Found " + r5 + " that did not use setReorderingAllowed(true)."));
    L12:
        r4 = r4 + 1;
        goto L8
    L13:
        HashSet r6 = new HashSet();
        int r7 = r2;
    L15:
        if (r7 >= this.mBackStack.size()) goto L44;
        BackStackRecord r8 = this.mBackStack.get(r7);
        HashSet r9 = new HashSet();
        HashSet r10 = new HashSet();
        Iterator<FragmentTransaction.Op> r11 = r8.mOps.iterator();
    L18:
        if (r11.hasNext() == false) goto L36;
        FragmentTransaction.Op r12 = r11.next();
        Fragment r13 = r12.mFragment;
        if (r13 == null) goto L18;
        if (r12.mFromExpandedOp == true) goto L25;
    L30:
        r6.add(r13);
        r9.add(r13);
    L32:
        if (r12.mCmd == 1) goto L35;
        if (r12.mCmd != 2) goto L18;
    L35:
        r10.add(r13);
        goto L18
    L25:
        if (r12.mCmd == 1) goto L30;
        if (r12.mCmd == 2) goto L30;
        if (r12.mCmd != 8) goto L32;
    L36:
        r9.removeAll(r10);
        if (r9.isEmpty() == true) goto L43;
        StringBuilder r14 = new StringBuilder("saveBackStack(\"").append(r19).append("\") must be self contained and not reference fragments from non-saved FragmentTransactions. Found reference to fragment");
        if (r9.size() != 1) goto L41;
        String r15 = HanziToPinyin.Token.SEPARATOR + r9.iterator().next();
    L42:
        throwException(new IllegalArgumentException(r14.append(r15).append(" in ").append(r8).append(" that were previously added to the FragmentManager through a separate FragmentTransaction.").toString()));
        goto L43
    L41:
        r15 = "s " + r9;
    L43:
        r7 = r7 + 1;
        goto L15
    L44:
        ArrayDeque r16 = new ArrayDeque(r6);
    L46:
        if (r16.isEmpty() == true) goto L60;
        Fragment r20 = (Fragment) r16.removeFirst();
        if (r20.mRetainInstance == false) goto L54;
        StringBuilder r21 = new StringBuilder("saveBackStack(\"").append(r19).append("\") must not contain retained fragments. Found ");
        if (r6.contains(r20) == false) goto L52;
        String r110 = "direct reference to retained ";
    L53:
        throwException(new IllegalArgumentException(r21.append(r110).append("fragment ").append(r20).toString()));
        goto L54
    L52:
        r110 = "retained child ";
    L54:
        Iterator<Fragment> r22 = r20.mChildFragmentManager.getActiveFragments().iterator();
    L56:
        if (r22.hasNext() == false) goto L46;
        Fragment r23 = r22.next();
        if (r23 == null) goto L56;
        r16.addLast(r23);
        goto L56
    L60:
        ArrayList r24 = new ArrayList();
        Iterator r25 = r6.iterator();
    L62:
        if (r25.hasNext() == false) goto L64;
        r24.add(((Fragment) r25.next()).mWho);
        goto L62
    L64:
        ArrayList r26 = new ArrayList(this.mBackStack.size() - r2);
        int r27 = r2;
    L66:
        if (r27 >= this.mBackStack.size()) goto L68;
        r26.add(null);
        r27 = r27 + 1;
        goto L66
    L68:
        BackStackState r28 = new BackStackState(r24, r26);
        int r29 = this.mBackStack.size() - 1;
    L69:
        if (r29 < r2) goto L71;
        BackStackRecord r30 = this.mBackStack.remove(r29);
        BackStackRecord r31 = new BackStackRecord(r30);
        r31.collapseOps();
        r26.set(r29 - r2, new BackStackRecordState(r31));
        r30.mBeingSaved = true;
        r17.add(r30);
        r18.add(true);
        r29 = r29 - 1;
        goto L69
    L71:
        this.mBackStackStates.put(r19, r28);
        return true;
    }

    boolean clearBackStackState(ArrayList<BackStackRecord> r7, ArrayList<Boolean> r8, String r9) {
        if (restoreBackStackState(r7, r8, r9) == true) goto L7;
        return false;
    L7:
        return popBackStackState(r7, r8, r9, -1, 1);
    }

    boolean popBackStackState(ArrayList<BackStackRecord> r3, ArrayList<Boolean> r4, String r5, int r6, int r7) {
        if ((r7 & 1) == 0) goto L5;
        boolean r8 = true;
    L6:
        int r9 = findBackStackIndex(r5, r6, r8);
        if (r9 >= 0) goto L9;
        return false;
    L9:
        int r10 = this.mBackStack.size() - 1;
    L10:
        if (r10 < r9) goto L12;
        r3.add(this.mBackStack.remove(r10));
        r4.add(true);
        r10 = r10 - 1;
        goto L10
    L12:
        return true;
    L5:
        r8 = false;
        goto L6
    }

    private int findBackStackIndex(String r5, int r6, boolean r7) {
        ArrayList<BackStackRecord> r0 = this.mBackStack;
        if (r0 != null) goto L5;
    L43:
        return -1;
    L5:
        if (r0.isEmpty() == true) goto L43;
        if (r5 != null) goto L14;
        if (r6 >= 0) goto L14;
        if (r7 == false) goto L13;
        return 0;
    L13:
        return this.mBackStack.size() - 1;
    L14:
        int r1 = this.mBackStack.size() - 1;
    L15:
        if (r1 < 0) goto L26;
        BackStackRecord r2 = this.mBackStack.get(r1);
        if (r5 != null) goto L19;
    L21:
        if (r6 < 0) goto L25;
        if (r6 == r2.mIndex) goto L26;
    L25:
        r1 = r1 - 1;
        goto L15
    L19:
        if (r5.equals(r2.getName()) == false) goto L21;
    L26:
        if (r1 >= 0) goto L28;
        return r1;
    L28:
        if (r7 == false) goto L39;
    L29:
        if (r1 <= 0) goto L56;
        BackStackRecord r8 = this.mBackStack.get(r1 - 1);
        if (r5 != null) goto L33;
    L34:
        if (r6 < 0) goto L54;
        if (r6 == r8.mIndex) goto L37;
        return r1;
    L37:
        r1 = r1 - 1;
        goto L29
    L54:
        return r1;
    L33:
        if (r5.equals(r8.getName()) == true) goto L37;
    L56:
        return r1;
    L39:
        if (r1 != (this.mBackStack.size() - 1)) goto L42;
        return -1;
    L42:
        return r1 + 1;
    }

    @Deprecated
    FragmentManagerNonConfig retainNonConfig() {
        if ((this.mHost instanceof ViewModelStoreOwner) == false) goto L6;
        throwException(new IllegalStateException("You cannot use retainNonConfig when your FragmentHostCallback implements ViewModelStoreOwner."));
    L6:
        return this.mNonConfig.getSnapshot();
    }

    Parcelable saveAllState() {
        if ((this.mHost instanceof SavedStateRegistryOwner) == false) goto L5;
        throwException(new IllegalStateException("You cannot use saveAllState when your FragmentHostCallback implements SavedStateRegistryOwner."));
    L5:
        Bundle r2 = saveAllStateInternal();
        if (r2.isEmpty() == false) goto L9;
        return null;
    L9:
        return r2;
    }

    Bundle saveAllStateInternal() {
        Bundle r0 = new Bundle();
        forcePostponedTransactions();
        endAnimatingAwayFragments();
        execPendingActions(true);
        this.mStateSaved = true;
        this.mNonConfig.setIsStateSaved(true);
        ArrayList<String> r1 = this.mFragmentStore.saveActiveFragments();
        HashMap<String, Bundle> r2 = this.mFragmentStore.getAllSavedState();
        if (r2.isEmpty() == true) goto L5;
        ArrayList<String> r3 = this.mFragmentStore.saveAddedFragments();
        ArrayList<BackStackRecord> r6 = this.mBackStack;
        if (r6 == null) goto L17;
        int r7 = r6.size();
        if (r7 <= 0) goto L17;
        BackStackRecordState[] r8 = new BackStackRecordState[r7];
        int r9 = 0;
    L12:
        if (r9 >= r7) goto L18;
        r8[r9] = new BackStackRecordState(this.mBackStack.get(r9));
        if (isLoggingEnabled(2) == false) goto L16;
        Log.v(TAG, "saveAllState: adding back stack #" + r9 + ": " + this.mBackStack.get(r9));
    L16:
        r9 = r9 + 1;
    L18:
        FragmentManagerState r4 = new FragmentManagerState();
        r4.mActive = r1;
        r4.mAdded = r3;
        r4.mBackStack = r8;
        r4.mBackStackIndex = this.mBackStackIndex.get();
        Fragment r5 = this.mPrimaryNav;
        if (r5 == null) goto L21;
        r4.mPrimaryNavActiveWho = r5.mWho;
    L21:
        r4.mBackStackStateKeys.addAll(this.mBackStackStates.keySet());
        r4.mBackStackStates.addAll(this.mBackStackStates.values());
        r4.mLaunchedFragments = new ArrayList(this.mLaunchedFragments);
        r0.putParcelable("state", r4);
        Iterator<String> r10 = this.mResults.keySet().iterator();
    L23:
        if (r10.hasNext() == false) goto L25;
        String r11 = r10.next();
        r0.putBundle(RESULT_KEY_PREFIX + r11, this.mResults.get(r11));
        goto L23
    L25:
        Iterator<String> r12 = r2.keySet().iterator();
    L27:
        if (r12.hasNext() == false) goto L29;
        String r13 = r12.next();
        r0.putBundle(FRAGMENT_KEY_PREFIX + r13, r2.get(r13));
    L29:
        return r0;
    L17:
        r8 = null;
        goto L18
    L5:
        if (isLoggingEnabled(2) == false) goto L29;
        Log.v(TAG, "saveAllState: no fragments!");
        goto L29
    }

    void restoreAllState(Parcelable r3, FragmentManagerNonConfig r4) {
        if ((this.mHost instanceof ViewModelStoreOwner) == false) goto L5;
        throwException(new IllegalStateException("You must use restoreSaveState when your FragmentHostCallback implements ViewModelStoreOwner"));
    L5:
        this.mNonConfig.restoreFromSnapshot(r4);
        restoreSaveStateInternal(r3);
    }

    void restoreSaveState(Parcelable r3) {
        if ((this.mHost instanceof SavedStateRegistryOwner) == false) goto L5;
        throwException(new IllegalStateException("You cannot use restoreSaveState when your FragmentHostCallback implements SavedStateRegistryOwner."));
    L5:
        restoreSaveStateInternal(r3);
    }

    void restoreSaveStateInternal(Parcelable r15) {
        if (r15 != null) goto L4;
        return;
    L4:
        Bundle r16 = (Bundle) r15;
        Iterator<String> r0 = r16.keySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L12;
        String r1 = r0.next();
        if (r1.startsWith(RESULT_KEY_PREFIX) == false) goto L6;
        Bundle r2 = r16.getBundle(r1);
        if (r2 == null) goto L6;
        r2.setClassLoader(this.mHost.getContext().getClassLoader());
        this.mResults.put(r1.substring(7), r2);
        goto L6
    L12:
        HashMap<String, Bundle> r3 = new HashMap();
        Iterator<String> r4 = r16.keySet().iterator();
    L14:
        if (r4.hasNext() == false) goto L20;
        String r5 = r4.next();
        if (r5.startsWith(FRAGMENT_KEY_PREFIX) == false) goto L14;
        Bundle r6 = r16.getBundle(r5);
        if (r6 == null) goto L14;
        r6.setClassLoader(this.mHost.getContext().getClassLoader());
        r3.put(r5.substring(9), r6);
        goto L14
    L20:
        this.mFragmentStore.restoreSaveState(r3);
        FragmentManagerState r17 = (FragmentManagerState) r16.getParcelable("state");
        if (r17 != null) goto L23;
        return;
    L23:
        this.mFragmentStore.resetActiveFragments();
        Iterator<String> r7 = r17.mActive.iterator();
    L25:
        if (r7.hasNext() == false) goto L39;
        Bundle r8 = this.mFragmentStore.setSavedState(r7.next(), null);
        if (r8 == null) goto L25;
        Fragment r9 = this.mNonConfig.findRetainedFragmentByWho(((FragmentState) r8.getParcelable("state")).mWho);
        if (r9 != null) goto L31;
        FragmentStateManager r10 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, this.mHost.getContext().getClassLoader(), getFragmentFactory(), r8);
    L35:
        Fragment r11 = r10.getFragment();
        r11.mSavedFragmentState = r8;
        r11.mFragmentManager = this;
        if (isLoggingEnabled(2) == false) goto L38;
        Log.v(TAG, "restoreSaveState: active (" + r11.mWho + "): " + r11);
    L38:
        r10.restoreState(this.mHost.getContext().getClassLoader());
        this.mFragmentStore.makeActive(r10);
        r10.setFragmentManagerState(this.mCurState);
        goto L25
    L31:
        if (isLoggingEnabled(2) == false) goto L33;
        Log.v(TAG, "restoreSaveState: re-attaching retained " + r9);
    L33:
        r10 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, r9, r8);
        goto L35
    L39:
        Iterator<Fragment> r12 = this.mNonConfig.getRetainedFragments().iterator();
    L41:
        if (r12.hasNext() == false) goto L48;
        Fragment r13 = r12.next();
        if (this.mFragmentStore.containsActiveFragment(r13.mWho) == true) goto L41;
        if (isLoggingEnabled(2) == false) goto L47;
        Log.v(TAG, "Discarding retained Fragment " + r13 + " that was not found in the set of active Fragments " + r17.mActive);
    L47:
        this.mNonConfig.removeRetainedFragment(r13);
        r13.mFragmentManager = this;
        FragmentStateManager r14 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, r13);
        r14.setFragmentManagerState(1);
        r14.moveToExpectedState();
        r13.mRemoving = true;
        r14.moveToExpectedState();
        goto L41
    L48:
        this.mFragmentStore.restoreAddedFragments(r17.mAdded);
        int r18 = 0;
        if (r17.mBackStack == null) goto L57;
        this.mBackStack = new ArrayList(r17.mBackStack.length);
        int r19 = 0;
    L52:
        if (r19 >= r17.mBackStack.length) goto L58;
        BackStackRecord r20 = r17.mBackStack[r19].instantiate(this);
        if (isLoggingEnabled(2) == false) goto L56;
        Log.v(TAG, "restoreAllState: back stack #" + r19 + " (index " + r20.mIndex + "): " + r20);
        PrintWriter r21 = new PrintWriter(new LogWriter(TAG));
        r20.dump(BytedanceJustifyTextView.TWO_BLANK, r21, false);
        r21.close();
    L56:
        this.mBackStack.add(r20);
        r19 = r19 + 1;
    L58:
        this.mBackStackIndex.set(r17.mBackStackIndex);
        if (r17.mPrimaryNavActiveWho == null) goto L61;
        Fragment r22 = findActiveFragment(r17.mPrimaryNavActiveWho);
        this.mPrimaryNav = r22;
        dispatchParentPrimaryNavigationFragmentChanged(r22);
    L61:
        ArrayList<String> r23 = r17.mBackStackStateKeys;
        if (r23 != null) goto L64;
    L66:
        this.mLaunchedFragments = new ArrayDeque(r17.mLaunchedFragments);
        return;
    L64:
        if (r18 >= r23.size()) goto L66;
        this.mBackStackStates.put(r23.get(r18), r17.mBackStackStates.get(r18));
        r18 = r18 + 1;
        goto L64
    L57:
        this.mBackStack = null;
        goto L58
    }

    public FragmentHostCallback<?> getHost() {
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
    void attachController(FragmentHostCallback<?> r4, FragmentContainer r5, final Fragment r6) {
        if (this.mHost != null) goto L56;
        this.mHost = r4;
        this.mContainer = r5;
        this.mParent = r6;
        if (r6 == null) goto L8;
        addFragmentOnAttachListener(new AnonymousClass7(this, r6));
    L11:
        if (this.mParent == null) goto L14;
        updateOnBackPressedCallbackEnabled();
    L14:
        if ((r4 instanceof OnBackPressedDispatcherOwner) == false) goto L19;
        OnBackPressedDispatcherOwner r7 = (OnBackPressedDispatcherOwner) r4;
        OnBackPressedDispatcher r0 = r7.getOnBackPressedDispatcher();
        this.mOnBackPressedDispatcher = r0;
        LifecycleOwner r8 = r7;
        if (r6 == null) goto L18;
        r8 = r6;
    L18:
        r0.addCallback(r8, this.mOnBackPressedCallback);
    L19:
        if (r6 == null) goto L22;
        this.mNonConfig = r6.mFragmentManager.getChildNonConfig(r6);
    L25:
        this.mNonConfig.setIsStateSaved(isStateSaved());
        this.mFragmentStore.setNonConfig(this.mNonConfig);
        Object r9 = this.mHost;
        if ((r9 instanceof SavedStateRegistryOwner) == false) goto L31;
        if (r6 != null) goto L31;
        SavedStateRegistry r10 = ((SavedStateRegistryOwner) r9).getSavedStateRegistry();
        r10.registerSavedStateProvider(SAVED_STATE_KEY, new FragmentManager$$ExternalSyntheticLambda4(this));
        Bundle r11 = r10.consumeRestoredStateForKey(SAVED_STATE_KEY);
        if (r11 == null) goto L31;
        restoreSaveStateInternal(r11);
    L31:
        Object r12 = this.mHost;
        if ((r12 instanceof ActivityResultRegistryOwner) == false) goto L38;
        ActivityResultRegistry r13 = ((ActivityResultRegistryOwner) r12).getActivityResultRegistry();
        if (r6 == null) goto L36;
        String r14 = r6.mWho + ":";
    L37:
        String r15 = "FragmentManager:" + r14;
        this.mStartActivityForResult = r13.register(r15 + "StartActivityForResult", new ActivityResultContracts.StartActivityForResult(), new AnonymousClass8(this));
        this.mStartIntentSenderForResult = r13.register(r15 + "StartIntentSenderForResult", new FragmentIntentSenderContract(), new AnonymousClass9(this));
        this.mRequestPermissions = r13.register(r15 + "RequestPermissions", new ActivityResultContracts.RequestMultiplePermissions(), new AnonymousClass10(this));
        goto L38
    L36:
        r14 = "";
    L38:
        Object r16 = this.mHost;
        if ((r16 instanceof OnConfigurationChangedProvider) == false) goto L41;
        ((OnConfigurationChangedProvider) r16).addOnConfigurationChangedListener(this.mOnConfigurationChangedListener);
    L41:
        Object r17 = this.mHost;
        if ((r17 instanceof OnTrimMemoryProvider) == false) goto L44;
        ((OnTrimMemoryProvider) r17).addOnTrimMemoryListener(this.mOnTrimMemoryListener);
    L44:
        Object r18 = this.mHost;
        if ((r18 instanceof OnMultiWindowModeChangedProvider) == false) goto L47;
        ((OnMultiWindowModeChangedProvider) r18).addOnMultiWindowModeChangedListener(this.mOnMultiWindowModeChangedListener);
    L47:
        Object r19 = this.mHost;
        if ((r19 instanceof OnPictureInPictureModeChangedProvider) == false) goto L50;
        ((OnPictureInPictureModeChangedProvider) r19).addOnPictureInPictureModeChangedListener(this.mOnPictureInPictureModeChangedListener);
    L50:
        Object r20 = this.mHost;
        if ((r20 instanceof MenuHost) == false) goto L57;
        if (r6 != null) goto L58;
        ((MenuHost) r20).addMenuProvider(this.mMenuProvider);
        return;
    L58:
        return;
    L57:
        return;
    L22:
        if ((r4 instanceof ViewModelStoreOwner) == false) goto L24;
        this.mNonConfig = FragmentManagerViewModel.getInstance(((ViewModelStoreOwner) r4).getViewModelStore());
        goto L25
    L24:
        this.mNonConfig = new FragmentManagerViewModel(false);
        goto L25
    L8:
        if ((r4 instanceof FragmentOnAttachListener) == false) goto L11;
        addFragmentOnAttachListener((FragmentOnAttachListener) r4);
        goto L11
    L56:
        throw new IllegalStateException("Already attached");
    }

    /* JADX INFO: renamed from: lambda$attachController$4$androidx-fragment-app-FragmentManager, reason: not valid java name */
    /* synthetic */ Bundle m52lambda$attachController$4$androidxfragmentappFragmentManager() {
        return saveAllStateInternal();
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
        if (this.mStartActivityForResult == null) goto L8;
        LaunchedFragmentInfo r0 = new LaunchedFragmentInfo(r2.mWho, r4);
        this.mLaunchedFragments.addLast(r0);
        if (r5 == null) goto L7;
        r3.putExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, r5);
    L7:
        this.mStartActivityForResult.launch(r3);
        return;
    L8:
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
        clearBackStackStateViewModels();
        dispatchStateChange(-1);
        Object r0 = this.mHost;
        if ((r0 instanceof OnTrimMemoryProvider) == false) goto L5;
        ((OnTrimMemoryProvider) r0).removeOnTrimMemoryListener(this.mOnTrimMemoryListener);
    L5:
        Object r1 = this.mHost;
        if ((r1 instanceof OnConfigurationChangedProvider) == false) goto L8;
        ((OnConfigurationChangedProvider) r1).removeOnConfigurationChangedListener(this.mOnConfigurationChangedListener);
    L8:
        Object r2 = this.mHost;
        if ((r2 instanceof OnMultiWindowModeChangedProvider) == false) goto L11;
        ((OnMultiWindowModeChangedProvider) r2).removeOnMultiWindowModeChangedListener(this.mOnMultiWindowModeChangedListener);
    L11:
        Object r3 = this.mHost;
        if ((r3 instanceof OnPictureInPictureModeChangedProvider) == false) goto L14;
        ((OnPictureInPictureModeChangedProvider) r3).removeOnPictureInPictureModeChangedListener(this.mOnPictureInPictureModeChangedListener);
    L14:
        Object r4 = this.mHost;
        if ((r4 instanceof MenuHost) == true) goto L17;
    L19:
        this.mHost = null;
        this.mContainer = null;
        this.mParent = null;
        if (this.mOnBackPressedDispatcher == null) goto L22;
        this.mOnBackPressedCallback.remove();
        this.mOnBackPressedDispatcher = null;
    L22:
        ActivityResultLauncher<Intent> r5 = this.mStartActivityForResult;
        if (r5 == null) goto L26;
        r5.unregister();
        this.mStartIntentSenderForResult.unregister();
        this.mRequestPermissions.unregister();
        return;
    L26:
        return;
    L17:
        if (this.mParent != null) goto L19;
        ((MenuHost) r4).removeMenuProvider(this.mMenuProvider);
        goto L19
    }

    private void dispatchStateChange(int r4) {
        this.mExecutingActions = true;     // Catch: Throwable -> L10
        this.mFragmentStore.dispatchStateChange(r4);     // Catch: Throwable -> L10
        moveToState(r4, false);     // Catch: Throwable -> L10
        Iterator<SpecialEffectsController> r5 = collectAllSpecialEffectsController().iterator();     // Catch: Throwable -> L10
    L5:
        if (r5.hasNext() == false) goto L8;
        r5.next().forceCompleteAllOperations();     // Catch: Throwable -> L10
        goto L5
    L8:
        this.mExecutingActions = false;
        execPendingActions(true);
        return;
    L10:
        th = move-exception;
        this.mExecutingActions = false;
        throw th;
    }

    void dispatchMultiWindowModeChanged(boolean r3, boolean r4) {
        if (r4 == true) goto L4;
    L6:
        Iterator<Fragment> r2 = this.mFragmentStore.getFragments().iterator();
    L8:
        if (r2.hasNext() == false) goto L14;
        Fragment r0 = r2.next();
        if (r0 == null) goto L8;
        r0.performMultiWindowModeChanged(r3);
        if (r4 == false) goto L8;
        r0.mChildFragmentManager.dispatchMultiWindowModeChanged(r3, true);
        goto L8
    L14:
        return;
    L4:
        if ((this.mHost instanceof OnMultiWindowModeChangedProvider) == false) goto L6;
        throwException(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        goto L6
    }

    void dispatchPictureInPictureModeChanged(boolean r3, boolean r4) {
        if (r4 == true) goto L4;
    L6:
        Iterator<Fragment> r2 = this.mFragmentStore.getFragments().iterator();
    L8:
        if (r2.hasNext() == false) goto L14;
        Fragment r0 = r2.next();
        if (r0 == null) goto L8;
        r0.performPictureInPictureModeChanged(r3);
        if (r4 == false) goto L8;
        r0.mChildFragmentManager.dispatchPictureInPictureModeChanged(r3, true);
        goto L8
    L14:
        return;
    L4:
        if ((this.mHost instanceof OnPictureInPictureModeChangedProvider) == false) goto L6;
        throwException(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        goto L6
    }

    void dispatchConfigurationChanged(Configuration r3, boolean r4) {
        if (r4 == true) goto L4;
    L6:
        Iterator<Fragment> r2 = this.mFragmentStore.getFragments().iterator();
    L8:
        if (r2.hasNext() == false) goto L14;
        Fragment r0 = r2.next();
        if (r0 == null) goto L8;
        r0.performConfigurationChanged(r3);
        if (r4 == false) goto L8;
        r0.mChildFragmentManager.dispatchConfigurationChanged(r3, true);
        goto L8
    L14:
        return;
    L4:
        if ((this.mHost instanceof OnConfigurationChangedProvider) == false) goto L6;
        throwException(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        goto L6
    }

    void dispatchLowMemory(boolean r3) {
        if (r3 == true) goto L4;
    L6:
        Iterator<Fragment> r2 = this.mFragmentStore.getFragments().iterator();
    L8:
        if (r2.hasNext() == false) goto L14;
        Fragment r0 = r2.next();
        if (r0 == null) goto L8;
        r0.performLowMemory();
        if (r3 == false) goto L8;
        r0.mChildFragmentManager.dispatchLowMemory(true);
        goto L8
    L14:
        return;
    L4:
        if ((this.mHost instanceof OnTrimMemoryProvider) == false) goto L6;
        throwException(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        goto L6
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

    void dispatchOnHiddenChanged() {
        Iterator<Fragment> r2 = this.mFragmentStore.getActiveFragments().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Fragment r0 = r2.next();
        if (r0 == null) goto L4;
        r0.onHiddenChanged(r0.isHidden());
        r0.mChildFragmentManager.dispatchOnHiddenChanged();
        goto L4
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

    private boolean isParentAdded() {
        Fragment r0 = this.mParent;
        if (r0 != null) goto L6;
        return true;
    L6:
        if (r0.isAdded() == true) goto L8;
    L10:
        return false;
    L8:
        if (this.mParent.getParentFragmentManager().isParentAdded() == false) goto L10;
        return true;
    }

    LayoutInflater.Factory2 getLayoutInflaterFactory() {
        return this.mLayoutInflaterFactory;
    }

    public FragmentStrictMode.Policy getStrictModePolicy() {
        return this.mStrictModePolicy;
    }

    public void setStrictModePolicy(FragmentStrictMode.Policy r1) {
        this.mStrictModePolicy = r1;
    }
}
