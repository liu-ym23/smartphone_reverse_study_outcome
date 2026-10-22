package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(19)
class ViewUtilsApi19 extends ViewUtilsBase {
    private static boolean sTryHiddenTransitionAlpha = true;

    static {
    }

    ViewUtilsApi19() {
    }

    @Override // androidx.transition.ViewUtilsBase
    public void clearNonTransitionAlpha(@NonNull View r1) {
    }

    @Override // androidx.transition.ViewUtilsBase
    @SuppressLint({"NewApi"})
    public float getTransitionAlpha(@NonNull View r1) {
        if (sTryHiddenTransitionAlpha == false) goto L8;
        return r1.getTransitionAlpha();
    L6:
        sTryHiddenTransitionAlpha = false;
    L8:
        return r1.getAlpha();
    }

    @Override // androidx.transition.ViewUtilsBase
    public void saveNonTransitionAlpha(@NonNull View r1) {
    }

    @Override // androidx.transition.ViewUtilsBase
    @SuppressLint({"NewApi"})
    public void setTransitionAlpha(@NonNull View r1, float r2) {
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
}
