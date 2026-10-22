package androidx.transition;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ViewUtilsApi19 extends ViewUtilsBase {
    private static boolean sTryHiddenTransitionAlpha = true;

    static {
    }

    @Override // androidx.transition.ViewUtilsBase
    public void clearNonTransitionAlpha(View r1) {
    }

    @Override // androidx.transition.ViewUtilsBase
    public void saveNonTransitionAlpha(View r1) {
    }

    ViewUtilsApi19() {
    }

    @Override // androidx.transition.ViewUtilsBase
    public void setTransitionAlpha(View r1, float r2) {
        if (sTryHiddenTransitionAlpha == true) goto L9;
    L7:
        r1.setAlpha(r2);
        return;
    L9:
        r1.setTransitionAlpha(r2);     // Catch: NoSuchMethodError -> L6
        return;
    L6:
        sTryHiddenTransitionAlpha = false;
        goto L7
    }

    @Override // androidx.transition.ViewUtilsBase
    public float getTransitionAlpha(View r1) {
        if (sTryHiddenTransitionAlpha == false) goto L8;
        return r1.getTransitionAlpha();
    L6:
        sTryHiddenTransitionAlpha = false;
    L8:
        return r1.getAlpha();
    }
}
