package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
class ViewUtilsApi23 extends ViewUtilsApi22 {
    private static boolean sTryHiddenSetTransitionVisibility = true;

    public ViewUtilsApi23() {
    }

    @Override // androidx.transition.ViewUtilsBase
    @SuppressLint({"NewApi"})
    public void setTransitionVisibility(@NonNull View r1, int r2) {
        if (sTryHiddenSetTransitionVisibility == false) goto L10;
        r1.setTransitionVisibility(r2);     // Catch: NoSuchMethodError -> L6
        return;
    L6:
        sTryHiddenSetTransitionVisibility = false;
        return;
    }
}
