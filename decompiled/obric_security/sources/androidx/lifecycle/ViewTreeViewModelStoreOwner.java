package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.viewmodel.R;

/* JADX INFO: loaded from: classes.dex */
public class ViewTreeViewModelStoreOwner {
    private ViewTreeViewModelStoreOwner() {
    }

    public static void set(View r1, ViewModelStoreOwner r2) {
        r1.setTag(R.id.view_tree_view_model_store_owner, r2);
    }

    public static ViewModelStoreOwner get(View r2) {
        ViewModelStoreOwner r0 = (ViewModelStoreOwner) r2.getTag(R.id.view_tree_view_model_store_owner);
        if (r0 == null) goto L5;
        return r0;
    L5:
        Object r3 = r2.getParent();
    L6:
        if (r0 != null) goto L10;
        if ((r3 instanceof View) == false) goto L10;
        View r4 = (View) r3;
        r0 = (ViewModelStoreOwner) r4.getTag(R.id.view_tree_view_model_store_owner);
        r3 = r4.getParent();
    L10:
        return r0;
    }
}
