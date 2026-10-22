package androidx.fragment.app;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelStore;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class FragmentManagerNonConfig {

    @Nullable
    private final Map<String, FragmentManagerNonConfig> mChildNonConfigs;

    @Nullable
    private final Collection<Fragment> mFragments;

    @Nullable
    private final Map<String, ViewModelStore> mViewModelStores;

    FragmentManagerNonConfig(@Nullable Collection<Fragment> r1, @Nullable Map<String, FragmentManagerNonConfig> r2, @Nullable Map<String, ViewModelStore> r3) {
        this.mFragments = r1;
        this.mChildNonConfigs = r2;
        this.mViewModelStores = r3;
    }

    @Nullable
    Map<String, FragmentManagerNonConfig> getChildNonConfigs() {
        return this.mChildNonConfigs;
    }

    @Nullable
    Collection<Fragment> getFragments() {
        return this.mFragments;
    }

    @Nullable
    Map<String, ViewModelStore> getViewModelStores() {
        return this.mViewModelStores;
    }

    boolean isRetaining(Fragment r1) {
        Collection<Fragment> r0 = this.mFragments;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.contains(r1);
    }
}
