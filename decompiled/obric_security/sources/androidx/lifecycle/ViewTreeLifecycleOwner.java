package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.runtime.R;

/* JADX INFO: loaded from: classes.dex */
public class ViewTreeLifecycleOwner {
    private ViewTreeLifecycleOwner() {
    }

    public static void set(View r1, LifecycleOwner r2) {
        r1.setTag(R.id.view_tree_lifecycle_owner, r2);
    }

    public static LifecycleOwner get(View r2) {
        LifecycleOwner r0 = (LifecycleOwner) r2.getTag(R.id.view_tree_lifecycle_owner);
        if (r0 == null) goto L5;
        return r0;
    L5:
        Object r3 = r2.getParent();
    L6:
        if (r0 != null) goto L10;
        if ((r3 instanceof View) == false) goto L10;
        View r4 = (View) r3;
        r0 = (LifecycleOwner) r4.getTag(R.id.view_tree_lifecycle_owner);
        r3 = r4.getParent();
    L10:
        return r0;
    }
}
