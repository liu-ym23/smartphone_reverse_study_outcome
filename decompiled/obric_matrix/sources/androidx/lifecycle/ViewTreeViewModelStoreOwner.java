package androidx.lifecycle;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.viewmodel.R;

/* JADX INFO: loaded from: classes.dex */
public class ViewTreeViewModelStoreOwner {
    private ViewTreeViewModelStoreOwner() {
    }

    @Nullable
    public static ViewModelStoreOwner get(@NonNull View r2) {
        ViewModelStoreOwner r0 = (ViewModelStoreOwner) r2.getTag(R.id.view_tree_view_model_store_owner);
        if (r0 == null) goto L5;
        return r0;
    L5:
        Object r3 = r2.getParent();
        if (r0 != null) goto L10;
        if ((r3 instanceof View) == false) goto L10;
        r2 = (View) r3;
        r0 = (ViewModelStoreOwner) r2.getTag(R.id.view_tree_view_model_store_owner);
    L10:
        return r0;
    }

    public static void set(@NonNull View r1, @Nullable ViewModelStoreOwner r2) {
        r1.setTag(R.id.view_tree_view_model_store_owner, r2);
    }
}
