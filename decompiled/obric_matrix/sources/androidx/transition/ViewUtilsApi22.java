package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(22)
class ViewUtilsApi22 extends ViewUtilsApi21 {
    private static boolean sTryHiddenSetLeftTopRightBottom = true;

    static {
    }

    ViewUtilsApi22() {
    }

    @Override // androidx.transition.ViewUtilsBase
    @SuppressLint({"NewApi"})
    public void setLeftTopRightBottom(@NonNull View r1, int r2, int r3, int r4, int r5) {
        if (sTryHiddenSetLeftTopRightBottom == false) goto L10;
        r1.setLeftTopRightBottom(r2, r3, r4, r5);     // Catch: NoSuchMethodError -> L6
        return;
    L6:
        sTryHiddenSetLeftTopRightBottom = false;
        return;
    }
}
