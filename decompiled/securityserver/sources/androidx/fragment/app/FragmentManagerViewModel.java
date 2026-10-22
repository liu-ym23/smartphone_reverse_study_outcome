package androidx.fragment.app;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class FragmentManagerViewModel extends ViewModel {
    private static final ViewModelProvider.Factory FACTORY = null;
    private final HashMap<String, FragmentManagerViewModel> mChildNonConfigs;
    private boolean mHasBeenCleared;
    private boolean mHasSavedSnapshot;
    private final HashSet<Fragment> mRetainedFragments;
    private final boolean mStateAutomaticallySaved;
    private final HashMap<String, ViewModelStore> mViewModelStores;

    static {
        FACTORY = new AnonymousClass1();
    }

    public FragmentManagerViewModel(boolean r2) {
        this.mRetainedFragments = new HashSet();
        this.mChildNonConfigs = new HashMap();
        this.mViewModelStores = new HashMap();
        this.mHasBeenCleared = false;
        this.mHasSavedSnapshot = false;
        this.mStateAutomaticallySaved = r2;
    }

    @NonNull
    public static FragmentManagerViewModel getInstance(ViewModelStore r2) {
        return (FragmentManagerViewModel) new ViewModelProvider(r2, FACTORY).get(FragmentManagerViewModel.class);
    }

    public boolean addRetainedFragment(@NonNull Fragment r1) {
        return this.mRetainedFragments.add(r1);
    }

    public void clearNonConfigState(@NonNull Fragment r3) {
        if (FragmentManagerImpl.DEBUG == false) goto L5;
        Log.d("FragmentManager", "Clearing non-config state for " + r3);
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

    @NonNull
    public FragmentManagerViewModel getChildNonConfig(@NonNull Fragment r3) {
        FragmentManagerViewModel r0 = this.mChildNonConfigs.get(r3.mWho);
        if (r0 != null) goto L6;
        FragmentManagerViewModel r1 = new FragmentManagerViewModel(this.mStateAutomaticallySaved);
        this.mChildNonConfigs.put(r3.mWho, r1);
        return r1;
    L6:
        return r0;
    }

    @NonNull
    public Collection<Fragment> getRetainedFragments() {
        return this.mRetainedFragments;
    }

    @Nullable
    @Deprecated
    public FragmentManagerNonConfig getSnapshot() {
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
        return new FragmentManagerNonConfig(new ArrayList(this.mRetainedFragments), r0, new HashMap(this.mViewModelStores));
    L5:
        if (this.mChildNonConfigs.isEmpty() == false) goto L9;
        if (this.mViewModelStores.isEmpty() == false) goto L9;
        return null;
    }

    @NonNull
    public ViewModelStore getViewModelStore(@NonNull Fragment r3) {
        ViewModelStore r0 = this.mViewModelStores.get(r3.mWho);
        if (r0 != null) goto L6;
        ViewModelStore r1 = new ViewModelStore();
        this.mViewModelStores.put(r3.mWho, r1);
        return r1;
    L6:
        return r0;
    }

    public int hashCode() {
        int r0 = this.mRetainedFragments.hashCode() * 31;
        int r1 = (this.mChildNonConfigs.hashCode() + r0) * 31;
        return this.mViewModelStores.hashCode() + r1;
    }

    public boolean isCleared() {
        return this.mHasBeenCleared;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        if (FragmentManagerImpl.DEBUG == false) goto L5;
        Log.d("FragmentManager", "onCleared called for " + this);
    L5:
        this.mHasBeenCleared = true;
    }

    public boolean removeRetainedFragment(@NonNull Fragment r1) {
        return this.mRetainedFragments.remove(r1);
    }

    @Deprecated
    public void restoreFromSnapshot(@Nullable FragmentManagerNonConfig r5) {
        this.mRetainedFragments.clear();
        this.mChildNonConfigs.clear();
        this.mViewModelStores.clear();
        if (r5 == null) goto L16;
        Collection<Fragment> r0 = r5.getFragments();
        if (r0 == null) goto L7;
        this.mRetainedFragments.addAll(r0);
    L7:
        Map<String, FragmentManagerNonConfig> r1 = r5.getChildNonConfigs();
        if (r1 == null) goto L13;
        Iterator<Map.Entry<String, FragmentManagerNonConfig>> r2 = r1.entrySet().iterator();
    L11:
        if (r2.hasNext() == false) goto L13;
        Map.Entry<String, FragmentManagerNonConfig> r3 = r2.next();
        FragmentManagerViewModel r4 = new FragmentManagerViewModel(this.mStateAutomaticallySaved);
        r4.restoreFromSnapshot(r3.getValue());
        this.mChildNonConfigs.put(r3.getKey(), r4);
    L13:
        Map<String, ViewModelStore> r6 = r5.getViewModelStores();
        if (r6 == null) goto L16;
        this.mViewModelStores.putAll(r6);
    L16:
        this.mHasSavedSnapshot = false;
    }

    public boolean shouldDestroy(@NonNull Fragment r2) {
        if (this.mRetainedFragments.contains(r2) == true) goto L6;
        return true;
    L6:
        if (this.mStateAutomaticallySaved == false) goto L10;
        return this.mHasBeenCleared;
    L10:
        return !this.mHasSavedSnapshot;
    }

    @NonNull
    public String toString() {
        StringBuilder r0 = new StringBuilder("FragmentManagerViewModel{");
        r0.append(Integer.toHexString(System.identityHashCode(this)));
        r0.append("} Fragments (");
        Iterator<Fragment> r1 = this.mRetainedFragments.iterator();
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
