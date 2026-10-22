package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ViewUtilsApi21 extends ViewUtilsApi19 {
    private static boolean sTryHiddenSetAnimationMatrix = true;
    private static boolean sTryHiddenTransformMatrixToGlobal = true;
    private static boolean sTryHiddenTransformMatrixToLocal = true;

    static {
    }

    ViewUtilsApi21() {
    }

    @Override // androidx.transition.ViewUtilsBase
    public void transformMatrixToGlobal(View r1, Matrix r2) {
        if (sTryHiddenTransformMatrixToGlobal == false) goto L10;
        r1.transformMatrixToGlobal(r2);     // Catch: NoSuchMethodError -> L6
        return;
    L6:
        sTryHiddenTransformMatrixToGlobal = false;
        return;
    }

    @Override // androidx.transition.ViewUtilsBase
    public void transformMatrixToLocal(View r1, Matrix r2) {
        if (sTryHiddenTransformMatrixToLocal == false) goto L10;
        r1.transformMatrixToLocal(r2);     // Catch: NoSuchMethodError -> L6
        return;
    L6:
        sTryHiddenTransformMatrixToLocal = false;
        return;
    }

    @Override // androidx.transition.ViewUtilsBase
    public void setAnimationMatrix(View r1, Matrix r2) {
        if (sTryHiddenSetAnimationMatrix == false) goto L10;
        r1.setAnimationMatrix(r2);     // Catch: NoSuchMethodError -> L6
        return;
    L6:
        sTryHiddenSetAnimationMatrix = false;
        return;
    }
}
