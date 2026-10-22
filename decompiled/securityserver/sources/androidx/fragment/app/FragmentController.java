package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Preconditions;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FragmentController {
    private final FragmentHostCallback<?> mHost;

    private FragmentController(FragmentHostCallback<?> r1) {
        this.mHost = r1;
    }

    @NonNull
    public static FragmentController createController(@NonNull FragmentHostCallback<?> r2) {
        return new FragmentController((FragmentHostCallback) Preconditions.checkNotNull(r2, "callbacks == null"));
    }

    public void attachHost(@Nullable Fragment r2) {
        FragmentHostCallback<?> r1 = this.mHost;
        r1.mFragmentManager.attachController(r1, r1, r2);
    }

    public void dispatchActivityCreated() {
        this.mHost.mFragmentManager.dispatchActivityCreated();
    }

    public void dispatchConfigurationChanged(@NonNull Configuration r1) {
        this.mHost.mFragmentManager.dispatchConfigurationChanged(r1);
    }

    public boolean dispatchContextItemSelected(@NonNull MenuItem r1) {
        return this.mHost.mFragmentManager.dispatchContextItemSelected(r1);
    }

    public void dispatchCreate() {
        this.mHost.mFragmentManager.dispatchCreate();
    }

    public boolean dispatchCreateOptionsMenu(@NonNull Menu r1, @NonNull MenuInflater r2) {
        return this.mHost.mFragmentManager.dispatchCreateOptionsMenu(r1, r2);
    }

    public void dispatchDestroy() {
        this.mHost.mFragmentManager.dispatchDestroy();
    }

    public void dispatchDestroyView() {
        this.mHost.mFragmentManager.dispatchDestroyView();
    }

    public void dispatchLowMemory() {
        this.mHost.mFragmentManager.dispatchLowMemory();
    }

    public void dispatchMultiWindowModeChanged(boolean r1) {
        this.mHost.mFragmentManager.dispatchMultiWindowModeChanged(r1);
    }

    public boolean dispatchOptionsItemSelected(@NonNull MenuItem r1) {
        return this.mHost.mFragmentManager.dispatchOptionsItemSelected(r1);
    }

    public void dispatchOptionsMenuClosed(@NonNull Menu r1) {
        this.mHost.mFragmentManager.dispatchOptionsMenuClosed(r1);
    }

    public void dispatchPause() {
        this.mHost.mFragmentManager.dispatchPause();
    }

    public void dispatchPictureInPictureModeChanged(boolean r1) {
        this.mHost.mFragmentManager.dispatchPictureInPictureModeChanged(r1);
    }

    public boolean dispatchPrepareOptionsMenu(@NonNull Menu r1) {
        return this.mHost.mFragmentManager.dispatchPrepareOptionsMenu(r1);
    }

    @Deprecated
    public void dispatchReallyStop() {
    }

    public void dispatchResume() {
        this.mHost.mFragmentManager.dispatchResume();
    }

    public void dispatchStart() {
        this.mHost.mFragmentManager.dispatchStart();
    }

    public void dispatchStop() {
        this.mHost.mFragmentManager.dispatchStop();
    }

    @Deprecated
    public void doLoaderDestroy() {
    }

    @Deprecated
    public void doLoaderRetain() {
    }

    @Deprecated
    public void doLoaderStart() {
    }

    @Deprecated
    public void doLoaderStop(boolean r1) {
    }

    @Deprecated
    public void dumpLoaders(@NonNull String r1, @Nullable FileDescriptor r2, @NonNull PrintWriter r3, @Nullable String[] r4) {
    }

    public boolean execPendingActions() {
        return this.mHost.mFragmentManager.execPendingActions();
    }

    @Nullable
    public Fragment findFragmentByWho(@NonNull String r1) {
        return this.mHost.mFragmentManager.findFragmentByWho(r1);
    }

    @NonNull
    public List<Fragment> getActiveFragments(@SuppressLint({"UnknownNullness"}) List<Fragment> r1) {
        return this.mHost.mFragmentManager.getActiveFragments();
    }

    public int getActiveFragmentsCount() {
        return this.mHost.mFragmentManager.getActiveFragmentCount();
    }

    @NonNull
    public FragmentManager getSupportFragmentManager() {
        return this.mHost.mFragmentManager;
    }

    @SuppressLint({"UnknownNullness"})
    @Deprecated
    public LoaderManager getSupportLoaderManager() {
        throw new UnsupportedOperationException("Loaders are managed separately from FragmentController, use LoaderManager.getInstance() to obtain a LoaderManager.");
    }

    public void noteStateNotSaved() {
        this.mHost.mFragmentManager.noteStateNotSaved();
    }

    @Nullable
    public View onCreateView(@Nullable View r1, @NonNull String r2, @NonNull Context r3, @NonNull AttributeSet r4) {
        return this.mHost.mFragmentManager.onCreateView(r1, r2, r3, r4);
    }

    @Deprecated
    public void reportLoaderStart() {
    }

    @Deprecated
    public void restoreAllState(@Nullable Parcelable r3, @Nullable List<Fragment> r4) {
        this.mHost.mFragmentManager.restoreAllState(r3, new FragmentManagerNonConfig(r4, null, null));
    }

    @Deprecated
    public void restoreLoaderNonConfig(@SuppressLint({"UnknownNullness"}) SimpleArrayMap<String, LoaderManager> r1) {
    }

    public void restoreSaveState(@Nullable Parcelable r2) {
        FragmentHostCallback<?> r1 = this.mHost;
        if ((r1 instanceof ViewModelStoreOwner) == false) goto L7;
        r1.mFragmentManager.restoreSaveState(r2);
        return;
    L7:
        throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
    }

    @Nullable
    @Deprecated
    public SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig() {
        return null;
    }

    @Nullable
    @Deprecated
    public FragmentManagerNonConfig retainNestedNonConfig() {
        return this.mHost.mFragmentManager.retainNonConfig();
    }

    @Nullable
    @Deprecated
    public List<Fragment> retainNonConfig() {
        FragmentManagerNonConfig r1 = this.mHost.mFragmentManager.retainNonConfig();
        if (r1 != null) goto L5;
    L7:
        return null;
    L5:
        if (r1.getFragments() == null) goto L7;
        return new ArrayList(r1.getFragments());
    }

    @Nullable
    public Parcelable saveAllState() {
        return this.mHost.mFragmentManager.saveAllState();
    }

    @Deprecated
    public void restoreAllState(@Nullable Parcelable r1, @Nullable FragmentManagerNonConfig r2) {
        this.mHost.mFragmentManager.restoreAllState(r1, r2);
    }
}
