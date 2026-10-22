package androidx.transition;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ViewUtilsApi23 extends ViewUtilsApi22 {
    private static boolean sTryHiddenSetTransitionVisibility = true;

    static {
    }

    ViewUtilsApi23() {
    }

    @Override // androidx.transition.ViewUtilsBase
    public void setTransitionVisibility(View r1, int r2) {
        if (sTryHiddenSetTransitionVisibility == false) goto L10;
        r1.setTransitionVisibility(r2);     // Catch: NoSuchMethodError -> L6
        return;
    L6:
        sTryHiddenSetTransitionVisibility = false;
        return;
    }
}
