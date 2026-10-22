package androidx.lifecycle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ViewModelStores {
    private ViewModelStores() {
    }

    @Deprecated
    public static ViewModelStore of(FragmentActivity r0) {
        return r0.getViewModelStore();
    }

    @Deprecated
    public static ViewModelStore of(Fragment r0) {
        return r0.getViewModelStore();
    }
}
