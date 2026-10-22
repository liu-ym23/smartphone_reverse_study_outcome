package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SparseArrayCompat;
import androidx.core.app.ActivityCompat;
import androidx.core.app.SharedElementCallback;
import androidx.core.internal.view.SupportMenu;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class FragmentActivity extends ComponentActivity implements ActivityCompat.OnRequestPermissionsResultCallback, ActivityCompat.RequestPermissionsRequestCodeValidator {
    static final String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
    static final String FRAGMENTS_TAG = "android:support:fragments";
    static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 65534;
    static final String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
    static final String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
    private static final String TAG = "FragmentActivity";
    boolean mCreated;
    final LifecycleRegistry mFragmentLifecycleRegistry;
    final FragmentController mFragments;
    int mNextCandidateRequestIndex;
    SparseArrayCompat<String> mPendingFragmentActivityResults;
    boolean mRequestedPermissionsFromFragment;
    boolean mResumed;
    boolean mStartedActivityFromFragment;
    boolean mStartedIntentSenderFromFragment;
    boolean mStopped;

    public class HostCallbacks extends FragmentHostCallback<FragmentActivity> implements ViewModelStoreOwner, OnBackPressedDispatcherOwner {
        final /* synthetic */ FragmentActivity this$0;

        public HostCallbacks(FragmentActivity r1) {
            this.this$0 = r1;
            super(r1);
        }

        @Override // androidx.lifecycle.LifecycleOwner
        @NonNull
        public Lifecycle getLifecycle() {
            return this.this$0.mFragmentLifecycleRegistry;
        }

        @Override // androidx.activity.OnBackPressedDispatcherOwner
        @NonNull
        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return this.this$0.getOnBackPressedDispatcher();
        }

        @Override // androidx.lifecycle.ViewModelStoreOwner
        @NonNull
        public ViewModelStore getViewModelStore() {
            return this.this$0.getViewModelStore();
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public void onAttachFragment(@NonNull Fragment r1) {
            this.this$0.onAttachFragment(r1);
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public void onDump(@NonNull String r1, @Nullable FileDescriptor r2, @NonNull PrintWriter r3, @Nullable String[] r4) {
            this.this$0.dump(r1, r2, r3, r4);
        }

        @Override // androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer
        @Nullable
        public View onFindViewById(int r1) {
            return this.this$0.findViewById(r1);
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public /* bridge */ /* synthetic */ FragmentActivity onGetHost() {
            return onGetHost();
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        @NonNull
        public LayoutInflater onGetLayoutInflater() {
            return this.this$0.getLayoutInflater().cloneInContext(this.this$0);
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public int onGetWindowAnimations() {
            Window r0 = this.this$0.getWindow();
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.getAttributes().windowAnimations;
        }

        @Override // androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer
        public boolean onHasView() {
            Window r0 = this.this$0.getWindow();
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.peekDecorView() == null) goto L7;
            return true;
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public boolean onHasWindowAnimations() {
            if (this.this$0.getWindow() == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public void onRequestPermissionsFromFragment(@NonNull Fragment r1, @NonNull String[] r2, int r3) {
            this.this$0.requestPermissionsFromFragment(r1, r2, r3);
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public boolean onShouldSaveFragmentState(@NonNull Fragment r1) {
            return !this.this$0.isFinishing();
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public boolean onShouldShowRequestPermissionRationale(@NonNull String r1) {
            return ActivityCompat.shouldShowRequestPermissionRationale(this.this$0, r1);
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public void onStartActivityFromFragment(@NonNull Fragment r1, Intent r2, int r3) {
            this.this$0.startActivityFromFragment(r1, r2, r3);
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public void onStartIntentSenderFromFragment(@NonNull Fragment r10, IntentSender r11, int r12, @Nullable Intent r13, int r14, int r15, int r16, Bundle r17) {
            this.this$0.startIntentSenderFromFragment(r10, r11, r12, r13, r14, r15, r16, r17);
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public void onSupportInvalidateOptionsMenu() {
            this.this$0.supportInvalidateOptionsMenu();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.fragment.app.FragmentHostCallback
        public FragmentActivity onGetHost() {
            return this.this$0;
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public void onStartActivityFromFragment(@NonNull Fragment r1, Intent r2, int r3, @Nullable Bundle r4) {
            this.this$0.startActivityFromFragment(r1, r2, r3, r4);
        }
    }

    public FragmentActivity() {
        this.mFragments = FragmentController.createController(new HostCallbacks(this));
        this.mFragmentLifecycleRegistry = new LifecycleRegistry(this);
        this.mStopped = true;
    }

    private int allocateRequestIndex(@NonNull Fragment r4) {
        if (this.mPendingFragmentActivityResults.size() >= MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS) goto L10;
    L5:
        if (this.mPendingFragmentActivityResults.indexOfKey(this.mNextCandidateRequestIndex) < 0) goto L7;
        this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
        goto L5
    L7:
        int r0 = this.mNextCandidateRequestIndex;
        this.mPendingFragmentActivityResults.put(r0, r4.mWho);
        this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
        return r0;
    L10:
        throw new IllegalStateException("Too many pending Fragment activity results.");
    }

    public static void checkForValidRequestCode(int r1) {
        if ((r1 & SupportMenu.CATEGORY_MASK) != 0) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }

    private void markFragmentsCreated() {
    L3:
        if (markState(getSupportFragmentManager(), Lifecycle.State.CREATED) == true) goto L3;
    }

    private static boolean markState(FragmentManager r4, Lifecycle.State r5) {
        Iterator<Fragment> r6 = r4.getFragments().iterator();
        boolean r0 = false;
    L4:
        if (r6.hasNext() == false) goto L14;
        Fragment r1 = r6.next();
        if (r1 == null) goto L4;
        if (r1.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L12;
        r1.mLifecycleRegistry.setCurrentState(r5);
        r0 = true;
    L12:
        if (r1.getHost() == null) goto L4;
        r0 = r0 | markState(r1.getChildFragmentManager(), r5);
        goto L4
    L14:
        return r0;
    }

    @Nullable
    public final View dispatchFragmentsOnCreateView(@Nullable View r1, @NonNull String r2, @NonNull Context r3, @NonNull AttributeSet r4) {
        return this.mFragments.onCreateView(r1, r2, r3, r4);
    }

    @Override // android.app.Activity
    public void dump(@NonNull String r3, @Nullable FileDescriptor r4, @NonNull PrintWriter r5, @Nullable String[] r6) {
        super.dump(r3, r4, r5, r6);
        r5.print(r3);
        r5.print("Local FragmentActivity ");
        r5.print(Integer.toHexString(System.identityHashCode(this)));
        r5.println(" State:");
        String r0 = r3 + "  ";
        r5.print(r0);
        r5.print("mCreated=");
        r5.print(this.mCreated);
        r5.print(" mResumed=");
        r5.print(this.mResumed);
        r5.print(" mStopped=");
        r5.print(this.mStopped);
        if (getApplication() == null) goto L5;
        LoaderManager.getInstance(this).dump(r0, r4, r5, r6);
    L5:
        this.mFragments.getSupportFragmentManager().dump(r3, r4, r5, r6);
    }

    @NonNull
    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.getSupportFragmentManager();
    }

    @NonNull
    @Deprecated
    public LoaderManager getSupportLoaderManager() {
        return LoaderManager.getInstance(this);
    }

    @Override // android.app.Activity
    @CallSuper
    public void onActivityResult(int r4, int r5, @Nullable Intent r6) {
        this.mFragments.noteStateNotSaved();
        int r0 = r4 >> 16;
        if (r0 == 0) goto L13;
        int r1 = r0 - 1;
        String r2 = this.mPendingFragmentActivityResults.get(r1);
        this.mPendingFragmentActivityResults.remove(r1);
        if (r2 != null) goto L8;
        Log.w(TAG, "Activity result delivered for unknown Fragment.");
        return;
    L8:
        Fragment r3 = this.mFragments.findFragmentByWho(r2);
        if (r3 != null) goto L11;
        Log.w(TAG, "Activity result no fragment exists for who: ".concat(r2));
        return;
    L11:
        r3.onActivityResult(r4 & 65535, r5, r6);
        return;
    L13:
        ActivityCompat.PermissionCompatDelegate r7 = ActivityCompat.getPermissionCompatDelegate();
        if (r7 != null) goto L16;
    L18:
        super.onActivityResult(r4, r5, r6);
        return;
    L16:
        if (r7.onActivityResult(this, r4, r5, r6) == false) goto L18;
    }

    public void onAttachFragment(@NonNull Fragment r1) {
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration r2) {
        super.onConfigurationChanged(r2);
        this.mFragments.noteStateNotSaved();
        this.mFragments.dispatchConfigurationChanged(r2);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle r8) {
        this.mFragments.attachHost(null);
        if (r8 == null) goto L18;
        this.mFragments.restoreSaveState(r8.getParcelable(FRAGMENTS_TAG));
        if (r8.containsKey(NEXT_CANDIDATE_REQUEST_INDEX_TAG) == false) goto L18;
        this.mNextCandidateRequestIndex = r8.getInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG);
        int[] r1 = r8.getIntArray(ALLOCATED_REQUEST_INDICIES_TAG);
        String[] r2 = r8.getStringArray(REQUEST_FRAGMENT_WHO_TAG);
        if (r1 == null) goto L16;
        if (r2 == null) goto L16;
        if (r1.length != r2.length) goto L16;
        this.mPendingFragmentActivityResults = new SparseArrayCompat(r1.length);
        int r3 = 0;
    L14:
        if (r3 >= r1.length) goto L18;
        this.mPendingFragmentActivityResults.put(r1[r3], r2[r3]);
        r3 = r3 + 1;
    L16:
        Log.w(TAG, "Invalid requestCode mapping in savedInstanceState.");
    L18:
        if (this.mPendingFragmentActivityResults != null) goto L20;
        this.mPendingFragmentActivityResults = new SparseArrayCompat();
        this.mNextCandidateRequestIndex = 0;
    L20:
        super.onCreate(r8);
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        this.mFragments.dispatchCreate();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int r2, @NonNull Menu r3) {
        if (r2 != 0) goto L6;
        boolean r4 = super.onCreatePanelMenu(r2, r3);
        return this.mFragments.dispatchCreateOptionsMenu(r3, getMenuInflater()) | r4;
    L6:
        return super.onCreatePanelMenu(r2, r3);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    @Nullable
    public View onCreateView(@Nullable View r2, @NonNull String r3, @NonNull Context r4, @NonNull AttributeSet r5) {
        View r0 = dispatchFragmentsOnCreateView(r2, r3, r4, r5);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return super.onCreateView(r2, r3, r4, r5);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.dispatchDestroy();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.dispatchLowMemory();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int r2, @NonNull MenuItem r3) {
        if (super.onMenuItemSelected(r2, r3) == false) goto L6;
        return true;
    L6:
        if (r2 == 0) goto L14;
        if (r2 == 6) goto L12;
        return false;
    L12:
        return this.mFragments.dispatchContextItemSelected(r3);
    L14:
        return this.mFragments.dispatchOptionsItemSelected(r3);
    }

    @Override // android.app.Activity
    @CallSuper
    public void onMultiWindowModeChanged(boolean r1) {
        this.mFragments.dispatchMultiWindowModeChanged(r1);
    }

    @Override // android.app.Activity
    @CallSuper
    public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent r1) {
        super.onNewIntent(r1);
        this.mFragments.noteStateNotSaved();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int r2, @NonNull Menu r3) {
        if (r2 != 0) goto L5;
        this.mFragments.dispatchOptionsMenuClosed(r3);
    L5:
        super.onPanelClosed(r2, r3);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.dispatchPause();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Activity
    @CallSuper
    public void onPictureInPictureModeChanged(boolean r1) {
        this.mFragments.dispatchPictureInPictureModeChanged(r1);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public boolean onPrepareOptionsPanel(@Nullable View r2, @NonNull Menu r3) {
        return super.onPreparePanel(0, r2, r3);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int r1, @Nullable View r2, @NonNull Menu r3) {
        if (r1 != 0) goto L6;
        boolean r4 = onPrepareOptionsPanel(r2, r3);
        return this.mFragments.dispatchPrepareOptionsMenu(r3) | r4;
    L6:
        return super.onPreparePanel(r1, r2, r3);
    }

    @Override // android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int r5, @NonNull String[] r6, @NonNull int[] r7) {
        this.mFragments.noteStateNotSaved();
        int r0 = (r5 >> 16) & 65535;
        if (r0 == 0) goto L13;
        int r1 = r0 - 1;
        String r2 = this.mPendingFragmentActivityResults.get(r1);
        this.mPendingFragmentActivityResults.remove(r1);
        if (r2 != null) goto L8;
        Log.w(TAG, "Activity result delivered for unknown Fragment.");
        return;
    L8:
        Fragment r4 = this.mFragments.findFragmentByWho(r2);
        if (r4 != null) goto L11;
        Log.w(TAG, "Activity result no fragment exists for who: ".concat(r2));
        return;
    L11:
        r4.onRequestPermissionsResult(r5 & 65535, r6, r7);
        return;
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.mResumed = true;
        this.mFragments.noteStateNotSaved();
        this.mFragments.execPendingActions();
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        this.mFragments.dispatchResume();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle r5) {
        super.onSaveInstanceState(r5);
        markFragmentsCreated();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        Parcelable r0 = this.mFragments.saveAllState();
        if (r0 == null) goto L6;
        r5.putParcelable(FRAGMENTS_TAG, r0);
    L6:
        if (this.mPendingFragmentActivityResults.size() <= 0) goto L14;
        r5.putInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG, this.mNextCandidateRequestIndex);
        int[] r1 = new int[this.mPendingFragmentActivityResults.size()];
        String[] r2 = new String[this.mPendingFragmentActivityResults.size()];
        int r3 = 0;
    L9:
        if (r3 >= this.mPendingFragmentActivityResults.size()) goto L11;
        r1[r3] = this.mPendingFragmentActivityResults.keyAt(r3);
        r2[r3] = this.mPendingFragmentActivityResults.valueAt(r3);
        r3 = r3 + 1;
        goto L9
    L11:
        r5.putIntArray(ALLOCATED_REQUEST_INDICIES_TAG, r1);
        r5.putStringArray(REQUEST_FRAGMENT_WHO_TAG, r2);
        return;
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.mStopped = false;
        if (this.mCreated == true) goto L5;
        this.mCreated = true;
        this.mFragments.dispatchActivityCreated();
    L5:
        this.mFragments.noteStateNotSaved();
        this.mFragments.execPendingActions();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
        this.mFragments.dispatchStart();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.noteStateNotSaved();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.dispatchStop();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    public void requestPermissionsFromFragment(@NonNull Fragment r3, @NonNull String[] r4, int r5) {
        if (r5 != (-1)) goto L6;
        ActivityCompat.requestPermissions(this, r4, r5);
        return;
    L6:
        checkForValidRequestCode(r5);
        this.mRequestedPermissionsFromFragment = true;     // Catch: Throwable -> L10
        ActivityCompat.requestPermissions(this, r4, ((allocateRequestIndex(r3) + 1) << 16) + (r5 & 65535));     // Catch: Throwable -> L10
        this.mRequestedPermissionsFromFragment = false;
        return;
    L10:
        th = move-exception;
        this.mRequestedPermissionsFromFragment = false;
        throw th;
    }

    public void setEnterSharedElementCallback(@Nullable SharedElementCallback r1) {
        ActivityCompat.setEnterSharedElementCallback(this, r1);
    }

    public void setExitSharedElementCallback(@Nullable SharedElementCallback r1) {
        ActivityCompat.setExitSharedElementCallback(this, r1);
    }

    @Override // android.app.Activity
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent r2, int r3) {
        if (this.mStartedActivityFromFragment == false) goto L5;
    L7:
        super.startActivityForResult(r2, r3);
        return;
    L5:
        if (r3 == (-1)) goto L7;
        checkForValidRequestCode(r3);
        goto L7
    }

    public void startActivityFromFragment(@NonNull Fragment r2, @SuppressLint({"UnknownNullness"}) Intent r3, int r4) {
        startActivityFromFragment(r2, r3, r4, null);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender r2, int r3, @Nullable Intent r4, int r5, int r6, int r7) {
        if (this.mStartedIntentSenderFromFragment == false) goto L5;
    L7:
        super.startIntentSenderForResult(r2, r3, r4, r5, r6, r7);
        return;
    L5:
        if (r3 == (-1)) goto L7;
        checkForValidRequestCode(r3);
        goto L7
    }

    public void startIntentSenderFromFragment(@NonNull Fragment r12, @SuppressLint({"UnknownNullness"}) IntentSender r13, int r14, @Nullable Intent r15, int r16, int r17, int r18, @Nullable Bundle r19) {
        this.mStartedIntentSenderFromFragment = true;
        if (r14 == (-1)) goto L5;
        checkForValidRequestCode(r14);     // Catch: Throwable -> L8
        ActivityCompat.startIntentSenderForResult(this, r13, ((allocateRequestIndex(r12) + 1) << 16) + (r14 & 65535), r15, r16, r17, r18, r19);     // Catch: Throwable -> L8
        this.mStartedIntentSenderFromFragment = false;
        return;
    L5:
        ActivityCompat.startIntentSenderForResult(this, r13, r14, r15, r16, r17, r18, r19);     // Catch: Throwable -> L8
        this.mStartedIntentSenderFromFragment = false;
        return;
    L8:
        th = move-exception;
        this.mStartedIntentSenderFromFragment = false;
        throw th;
    }

    public void supportFinishAfterTransition() {
        ActivityCompat.finishAfterTransition(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        ActivityCompat.postponeEnterTransition(this);
    }

    public void supportStartPostponedEnterTransition() {
        ActivityCompat.startPostponedEnterTransition(this);
    }

    @Override // androidx.core.app.ActivityCompat.RequestPermissionsRequestCodeValidator
    public final void validateRequestPermissionsRequestCode(int r1) {
        if (this.mRequestedPermissionsFromFragment == false) goto L5;
        return;
    L5:
        if (r1 == (-1)) goto L9;
        checkForValidRequestCode(r1);
        return;
    }

    public void startActivityFromFragment(@NonNull Fragment r4, @SuppressLint({"UnknownNullness"}) Intent r5, int r6, @Nullable Bundle r7) {
        this.mStartedActivityFromFragment = true;
        if (r6 != (-1)) goto L9;
        ActivityCompat.startActivityForResult(this, r5, -1, r7);     // Catch: Throwable -> L7
        this.mStartedActivityFromFragment = false;
        return;
    L9:
        checkForValidRequestCode(r6);     // Catch: Throwable -> L7
        ActivityCompat.startActivityForResult(this, r5, ((allocateRequestIndex(r4) + 1) << 16) + (r6 & 65535), r7);     // Catch: Throwable -> L7
        this.mStartedActivityFromFragment = false;
        return;
    L7:
        th = move-exception;
        this.mStartedActivityFromFragment = false;
        throw th;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    @Nullable
    public View onCreateView(@NonNull String r2, @NonNull Context r3, @NonNull AttributeSet r4) {
        View r0 = dispatchFragmentsOnCreateView(null, r2, r3, r4);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return super.onCreateView(r2, r3, r4);
    }

    @Override // android.app.Activity
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent r2, int r3, @Nullable Bundle r4) {
        if (this.mStartedActivityFromFragment == false) goto L5;
    L7:
        super.startActivityForResult(r2, r3, r4);
        return;
    L5:
        if (r3 == (-1)) goto L7;
        checkForValidRequestCode(r3);
        goto L7
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender r2, int r3, @Nullable Intent r4, int r5, int r6, int r7, @Nullable Bundle r8) {
        if (this.mStartedIntentSenderFromFragment == false) goto L5;
    L7:
        super.startIntentSenderForResult(r2, r3, r4, r5, r6, r7, r8);
        return;
    L5:
        if (r3 == (-1)) goto L7;
        checkForValidRequestCode(r3);
        goto L7
    }

    @ContentView
    public FragmentActivity(@LayoutRes int r1) {
        super(r1);
        this.mFragments = FragmentController.createController(new HostCallbacks(this));
        this.mFragmentLifecycleRegistry = new LifecycleRegistry(this);
        this.mStopped = true;
    }
}
