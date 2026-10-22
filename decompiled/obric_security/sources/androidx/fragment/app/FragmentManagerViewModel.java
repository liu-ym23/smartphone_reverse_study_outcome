package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class FragmentManagerViewModel extends ViewModel {
    private static final ViewModelProvider.Factory FACTORY = null;
    private static final String TAG = "FragmentManager";
    private final HashMap<String, FragmentManagerViewModel> mChildNonConfigs;
    private boolean mHasBeenCleared;
    private boolean mHasSavedSnapshot;
    private boolean mIsStateSaved;
    private final HashMap<String, Fragment> mRetainedFragments;
    private final boolean mStateAutomaticallySaved;
    private final HashMap<String, ViewModelStore> mViewModelStores;

    static {
        FACTORY = new AnonymousClass1();
    }

    static FragmentManagerViewModel getInstance(ViewModelStore r2) {
        return (FragmentManagerViewModel) new ViewModelProvider(r2, FACTORY).get(FragmentManagerViewModel.class);
    }

    FragmentManagerViewModel(boolean r2) {
        this.mRetainedFragments = new HashMap();
        this.mChildNonConfigs = new HashMap();
        this.mViewModelStores = new HashMap();
        this.mHasBeenCleared = false;
        this.mHasSavedSnapshot = false;
        this.mIsStateSaved = false;
        this.mStateAutomaticallySaved = r2;
    }

    void setIsStateSaved(boolean r1) {
        this.mIsStateSaved = r1;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d(TAG, "onCleared called for " + this);
    L5:
        this.mHasBeenCleared = true;
    }

    boolean isCleared() {
        return this.mHasBeenCleared;
    }

    void addRetainedFragment(Fragment r5) {
        if (this.mIsStateSaved == false) goto L9;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L15;
        Log.v(TAG, "Ignoring addRetainedFragment as the state is already saved");
        return;
    L15:
        return;
    L9:
        if (this.mRetainedFragments.containsKey(r5.mWho) == false) goto L11;
        return;
    L11:
        this.mRetainedFragments.put(r5.mWho, r5);
        if (FragmentManager.isLoggingEnabled(2) == false) goto L16;
        Log.v(TAG, "Updating retained Fragments: Added " + r5);
        return;
    }

    Fragment findRetainedFragmentByWho(String r1) {
        return this.mRetainedFragments.get(r1);
    }

    Collection<Fragment> getRetainedFragments() {
        return new ArrayList(this.mRetainedFragments.values());
    }

    boolean shouldDestroy(Fragment r2) {
        if (this.mRetainedFragments.containsKey(r2.mWho) == true) goto L6;
        return true;
    L6:
        if (this.mStateAutomaticallySaved == false) goto L10;
        return this.mHasBeenCleared;
    L10:
        return !this.mHasSavedSnapshot;
    }

    void removeRetainedFragment(Fragment r4) {
        if (this.mIsStateSaved == false) goto L9;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L17;
        Log.v(TAG, "Ignoring removeRetainedFragment as the state is already saved");
        return;
    L17:
        return;
    L9:
        if (this.mRetainedFragments.remove(r4.mWho) == null) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == true) goto L14;
        return;
    L14:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L19;
        Log.v(TAG, "Updating retained Fragments: Removed " + r4);
        return;
    L19:
        return;
    L11:
        r3 = false;
        goto L12
    }

    FragmentManagerViewModel getChildNonConfig(Fragment r3) {
        FragmentManagerViewModel r0 = this.mChildNonConfigs.get(r3.mWho);
        if (r0 != null) goto L6;
        FragmentManagerViewModel r1 = new FragmentManagerViewModel(this.mStateAutomaticallySaved);
        this.mChildNonConfigs.put(r3.mWho, r1);
        return r1;
    L6:
        return r0;
    }

    ViewModelStore getViewModelStore(Fragment r3) {
        ViewModelStore r0 = this.mViewModelStores.get(r3.mWho);
        if (r0 != null) goto L6;
        ViewModelStore r1 = new ViewModelStore();
        this.mViewModelStores.put(r3.mWho, r1);
        return r1;
    L6:
        return r0;
    }

    void clearNonConfigState(Fragment r3) {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L5;
        Log.d(TAG, "Clearing non-config state for " + r3);
    L5:
        FragmentManagerViewModel r0 = this.mChildNonConfigs.get(r3.mWho);
        if (r0 == null) goto L8;
        r0.onCleared();
        this.mChildNonConfigs.remove(r3.mWho);
    L8:
        ViewModelStore r1 = this.mViewModelStores.get(r3.mWho);
        if (r1 == null) goto L12;
        r1.clear();
        this.mViewModelStores.remove(r3.mWho);
        return;
    }

    @Deprecated
    void restoreFromSnapshot(FragmentManagerNonConfig r5) {
        this.mRetainedFragments.clear();
        this.mChildNonConfigs.clear();
        this.mViewModelStores.clear();
        if (r5 == null) goto L21;
        Collection<Fragment> r0 = r5.getFragments();
        if (r0 == null) goto L12;
        Iterator<Fragment> r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        Fragment r2 = r1.next();
        if (r2 == null) goto L8;
        this.mRetainedFragments.put(r2.mWho, r2);
    L12:
        Map<String, FragmentManagerNonConfig> r3 = r5.getChildNonConfigs();
        if (r3 == null) goto L18;
        Iterator<Map.Entry<String, FragmentManagerNonConfig>> r4 = r3.entrySet().iterator();
    L16:
        if (r4.hasNext() == false) goto L18;
        Map.Entry<String, FragmentManagerNonConfig> r6 = r4.next();
        FragmentManagerViewModel r7 = new FragmentManagerViewModel(this.mStateAutomaticallySaved);
        r7.restoreFromSnapshot(r6.getValue());
        this.mChildNonConfigs.put(r6.getKey(), r7);
    L18:
        Map<String, ViewModelStore> r8 = r5.getViewModelStores();
        if (r8 == null) goto L21;
        this.mViewModelStores.putAll(r8);
    L21:
        this.mHasSavedSnapshot = false;
    }

    @Deprecated
    FragmentManagerNonConfig getSnapshot() {
        if (this.mRetainedFragments.isEmpty() == true) goto L5;
    L9:
        HashMap r0 = new HashMap();
        Iterator<Map.Entry<String, FragmentManagerViewModel>> r2 = this.mChildNonConfigs.entrySet().iterator();
    L11:
        if (r2.hasNext() == false) goto L15;
        Map.Entry<String, FragmentManagerViewModel> r3 = r2.next();
        FragmentManagerNonConfig r4 = r3.getValue().getSnapshot();
        if (r4 == null) goto L11;
        r0.put(r3.getKey(), r4);
        goto L11
    L15:
        this.mHasSavedSnapshot = true;
        if (this.mRetainedFragments.isEmpty() == false) goto L23;
        if (r0.isEmpty() == false) goto L23;
        if (this.mViewModelStores.isEmpty() == false) goto L23;
        return null;
    L23:
        return new FragmentManagerNonConfig(new ArrayList(this.mRetainedFragments.values()), r0, new HashMap(this.mViewModelStores));
    L5:
        if (this.mChildNonConfigs.isEmpty() == false) goto L9;
        if (this.mViewModelStores.isEmpty() == false) goto L9;
        return null;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L19:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L19;
        FragmentManagerViewModel r6 = (FragmentManagerViewModel) r5;
        if (this.mRetainedFragments.equals(r6.mRetainedFragments) == false) goto L18;
        if (this.mChildNonConfigs.equals(r6.mChildNonConfigs) == false) goto L18;
        if (this.mViewModelStores.equals(r6.mViewModelStores) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        return (((this.mRetainedFragments.hashCode() * 31) + this.mChildNonConfigs.hashCode()) * 31) + this.mViewModelStores.hashCode();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("FragmentManagerViewModel{");
        r0.append(Integer.toHexString(System.identityHashCode(this)));
        r0.append("} Fragments (");
        Iterator<Fragment> r1 = this.mRetainedFragments.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        r0.append(r1.next());
        if (r1.hasNext() == false) goto L4;
        r0.append(", ");
        goto L4
    L8:
        r0.append(") Child Non Config (");
        Iterator<String> r2 = this.mChildNonConfigs.keySet().iterator();
    L10:
        if (r2.hasNext() == false) goto L14;
        r0.append(r2.next());
        if (r2.hasNext() == false) goto L10;
        r0.append(", ");
        goto L10
    L14:
        r0.append(") ViewModelStores (");
        Iterator<String> r4 = this.mViewModelStores.keySet().iterator();
    L16:
        if (r4.hasNext() == false) goto L20;
        r0.append(r4.next());
        if (r4.hasNext() == false) goto L16;
        r0.append(", ");
        goto L16
    L20:
        r0.append(')');
        return r0.toString();
    }
}
