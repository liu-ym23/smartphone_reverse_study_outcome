package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class FragmentStore {
    private static final String TAG = "FragmentManager";
    private final HashMap<String, FragmentStateManager> mActive;
    private final ArrayList<Fragment> mAdded;
    private FragmentManagerViewModel mNonConfig;
    private final HashMap<String, FragmentState> mSavedState;

    FragmentStore() {
        this.mAdded = new ArrayList();
        this.mActive = new HashMap();
        this.mSavedState = new HashMap();
    }

    void addFragment(@NonNull Fragment r3) {
        if (this.mAdded.contains(r3) == true) goto L14;
        ArrayList<Fragment> r0 = this.mAdded;
        monitor-enter(r0);
        this.mAdded.add(r3);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        r3.mAdded = true;
        return;
    L10:
        th = move-exception;
        throw th;
    L14:
        throw new IllegalStateException("Fragment already added: " + r3);
    }

    void burpActive() {
        this.mActive.values().removeAll(Collections.singleton(null));
    }

    boolean containsActiveFragment(@NonNull String r1) {
        if (this.mActive.get(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    void dispatchStateChange(int r2) {
        Iterator<FragmentStateManager> r1 = this.mActive.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        FragmentStateManager r0 = r1.next();
        if (r0 == null) goto L4;
        r0.setFragmentManagerState(r2);
        goto L4
    }

    void dump(@NonNull String r4, @Nullable FileDescriptor r5, @NonNull PrintWriter r6, @Nullable String[] r7) {
        String r0 = r4 + "    ";
        if (this.mActive.isEmpty() == true) goto L11;
        r6.print(r4);
        r6.println("Active Fragments:");
        Iterator<FragmentStateManager> r1 = this.mActive.values().iterator();
    L6:
        if (r1.hasNext() == false) goto L11;
        FragmentStateManager r2 = r1.next();
        r6.print(r4);
        if (r2 != null) goto L9;
        r6.println("null");
        goto L6
    L9:
        Fragment r3 = r2.getFragment();
        r6.println(r3);
        r3.dump(r0, r5, r6, r7);
    L11:
        int r8 = this.mAdded.size();
        if (r8 <= 0) goto L16;
        r6.print(r4);
        r6.println("Added Fragments:");
        int r9 = 0;
    L14:
        if (r9 >= r8) goto L24;
        Fragment r10 = this.mAdded.get(r9);
        r6.print(r4);
        r6.print("  #");
        r6.print(r9);
        r6.print(": ");
        r6.println(r10.toString());
        r9 = r9 + 1;
        goto L14
    L24:
        return;
    }

    @Nullable
    Fragment findActiveFragment(@NonNull String r1) {
        FragmentStateManager r0 = this.mActive.get(r1);
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getFragment();
    }

    @Nullable
    Fragment findFragmentById(@IdRes int r4) {
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
        Iterator<FragmentStateManager> r3 = this.mActive.values().iterator();
    L12:
        if (r3.hasNext() == false) goto L18;
        FragmentStateManager r2 = r3.next();
        if (r2 == null) goto L12;
        Fragment r5 = r2.getFragment();
        if (r5.mFragmentId != r4) goto L12;
        return r5;
    L18:
        return null;
    }

    @Nullable
    Fragment findFragmentByTag(@Nullable String r4) {
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
        Iterator<FragmentStateManager> r3 = this.mActive.values().iterator();
    L14:
        if (r3.hasNext() == false) goto L32;
        FragmentStateManager r2 = r3.next();
        if (r2 == null) goto L14;
        Fragment r5 = r2.getFragment();
        if (r4.equals(r5.mTag) == false) goto L14;
        return r5;
    L32:
        return null;
    L20:
        return null;
    }

    @Nullable
    Fragment findFragmentByWho(@NonNull String r2) {
        Iterator<FragmentStateManager> r1 = this.mActive.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        FragmentStateManager r0 = r1.next();
        if (r0 == null) goto L4;
        Fragment r3 = r0.getFragment().findFragmentByWho(r2);
        if (r3 == null) goto L4;
        return r3;
    L10:
        return null;
    }

    int findFragmentIndexInContainer(@NonNull Fragment r6) {
        ViewGroup r0 = r6.mContainer;
        if (r0 != null) goto L5;
        return -1;
    L5:
        int r7 = this.mAdded.indexOf(r6);
        int r2 = r7 - 1;
    L6:
        if (r2 < 0) goto L14;
        Fragment r3 = this.mAdded.get(r2);
        if (r3.mContainer != r0) goto L13;
        View r4 = r3.mView;
        if (r4 == null) goto L13;
        return r0.indexOfChild(r4) + 1;
    L13:
        r2 = r2 - 1;
    L14:
        r7 = r7 + 1;
        if (r7 >= this.mAdded.size()) goto L23;
        Fragment r5 = this.mAdded.get(r7);
        if (r5.mContainer != r0) goto L14;
        View r8 = r5.mView;
        if (r8 == null) goto L14;
        return r0.indexOfChild(r8);
    L23:
        return -1;
    }

    int getActiveFragmentCount() {
        return this.mActive.size();
    }

    @NonNull
    List<FragmentStateManager> getActiveFragmentStateManagers() {
        ArrayList r0 = new ArrayList();
        Iterator<FragmentStateManager> r2 = this.mActive.values().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        FragmentStateManager r1 = r2.next();
        if (r1 == null) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }

    @NonNull
    List<Fragment> getActiveFragments() {
        ArrayList r0 = new ArrayList();
        Iterator<FragmentStateManager> r2 = this.mActive.values().iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        FragmentStateManager r1 = r2.next();
        if (r1 == null) goto L8;
        Fragment r3 = r1.getFragment();
    L9:
        r0.add(r3);
        goto L4
    L8:
        r3 = null;
        goto L9
    L10:
        return r0;
    }

    @NonNull
    ArrayList<FragmentState> getAllSavedState() {
        return new ArrayList(this.mSavedState.values());
    }

    @Nullable
    FragmentStateManager getFragmentStateManager(@NonNull String r1) {
        return this.mActive.get(r1);
    }

    @NonNull
    List<Fragment> getFragments() {
        if (this.mAdded.isEmpty() == true) goto L5;
        ArrayList<Fragment> r0 = this.mAdded;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(this.mAdded);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L11:
        th = move-exception;
        throw th;
    L5:
        return Collections.emptyList();
    }

    FragmentManagerViewModel getNonConfig() {
        return this.mNonConfig;
    }

    @Nullable
    FragmentState getSavedState(@NonNull String r1) {
        return this.mSavedState.get(r1);
    }

    void makeActive(@NonNull FragmentStateManager r4) {
        Fragment r0 = r4.getFragment();
        if (containsActiveFragment(r0.mWho) == false) goto L5;
        return;
    L5:
        this.mActive.put(r0.mWho, r4);
        if (r0.mRetainInstanceChangedWhileDetached == false) goto L13;
        boolean r5 = r0.mRetainInstance;
        FragmentManagerViewModel r3 = this.mNonConfig;
        if (r5 == false) goto L10;
        r3.addRetainedFragment(r0);
    L11:
        r0.mRetainInstanceChangedWhileDetached = false;
        goto L13
    L10:
        r3.removeRetainedFragment(r0);
    L13:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L16;
        Log.v("FragmentManager", "Added fragment to active set " + r0);
        return;
    }

    void makeInactive(@NonNull FragmentStateManager r3) {
        Fragment r4 = r3.getFragment();
        if (r4.mRetainInstance == false) goto L6;
        this.mNonConfig.removeRetainedFragment(r4);
    L6:
        if (this.mActive.put(r4.mWho, null) != null) goto L9;
        return;
    L9:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L12;
        Log.v("FragmentManager", "Removed fragment from active set " + r4);
        return;
    }

    void moveToExpectedState() {
        Iterator<Fragment> r0 = this.mAdded.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Fragment r1 = r0.next();
        FragmentStateManager r2 = this.mActive.get(r1.mWho);
        if (r2 == null) goto L4;
        r2.moveToExpectedState();
        goto L4
    L8:
        Iterator<FragmentStateManager> r3 = this.mActive.values().iterator();
    L10:
        if (r3.hasNext() == false) goto L26;
        FragmentStateManager r4 = r3.next();
        if (r4 == null) goto L10;
        r4.moveToExpectedState();
        Fragment r5 = r4.getFragment();
        if (r5.mRemoving == true) goto L16;
    L18:
        boolean r6 = false;
    L19:
        if (r6 == false) goto L10;
        if (r5.mBeingSaved == true) goto L23;
    L25:
        makeInactive(r4);
        goto L10
    L23:
        if (this.mSavedState.containsKey(r5.mWho) == true) goto L25;
        r4.saveState();
        goto L25
    L16:
        if (r5.isInBackStack() == true) goto L18;
        r6 = true;
        goto L19
    }

    void removeFragment(@NonNull Fragment r2) {
        ArrayList<Fragment> r0 = this.mAdded;
        monitor-enter(r0);
        this.mAdded.remove(r2);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        r2.mAdded = false;
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void resetActiveFragments() {
        this.mActive.clear();
    }

    void restoreAddedFragments(@Nullable List<String> r5) {
        this.mAdded.clear();
        if (r5 == null) goto L15;
        Iterator<String> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L20;
        String r0 = r6.next();
        Fragment r1 = findActiveFragment(r0);
        if (r1 == null) goto L14;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L12;
        Log.v("FragmentManager", "restoreSaveState: added (" + r0 + "): " + r1);
    L12:
        addFragment(r1);
        goto L6
    L14:
        throw new IllegalStateException("No instantiated fragment for (" + r0 + ")");
    L20:
        return;
    }

    void restoreSaveState(@NonNull ArrayList<FragmentState> r4) {
        this.mSavedState.clear();
        Iterator<FragmentState> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        FragmentState r0 = r5.next();
        this.mSavedState.put(r0.mWho, r0);
        goto L4
    }

    @NonNull
    ArrayList<String> saveActiveFragments() {
        ArrayList<String> r0 = new ArrayList(this.mActive.size());
        Iterator<FragmentStateManager> r4 = this.mActive.values().iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        FragmentStateManager r1 = r4.next();
        if (r1 == null) goto L4;
        Fragment r2 = r1.getFragment();
        r1.saveState();
        r0.add(r2.mWho);
        if (FragmentManager.isLoggingEnabled(2) == false) goto L4;
        Log.v("FragmentManager", "Saved state of " + r2 + ": " + r2.mSavedFragmentState);
        goto L4
    L10:
        return r0;
    }

    @Nullable
    ArrayList<String> saveAddedFragments() {
        ArrayList<Fragment> r0 = this.mAdded;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.mAdded.isEmpty() == true) goto L7;
        ArrayList<String> r1 = new ArrayList(this.mAdded.size());     // Catch: Throwable -> L17
        Iterator<Fragment> r6 = this.mAdded.iterator();     // Catch: Throwable -> L17
    L11:
        if (r6.hasNext() == false) goto L15;
        Fragment r2 = r6.next();     // Catch: Throwable -> L17
        r1.add(r2.mWho);     // Catch: Throwable -> L17
        if (FragmentManager.isLoggingEnabled(2) == false) goto L11;
        Log.v("FragmentManager", "saveAllState: adding fragment (" + r2.mWho + "): " + r2);     // Catch: Throwable -> L17
        goto L11
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return r1;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return null;
    }

    void setNonConfig(@NonNull FragmentManagerViewModel r1) {
        this.mNonConfig = r1;
    }

    @Nullable
    FragmentState setSavedState(@NonNull String r1, @Nullable FragmentState r2) {
        HashMap<String, FragmentState> r0 = this.mSavedState;
        if (r2 == null) goto L7;
        FragmentState r3 = r0.put(r1, r2);
    L6:
        return r3;
    L7:
        r3 = r0.remove(r1);
        goto L6
    }
}
