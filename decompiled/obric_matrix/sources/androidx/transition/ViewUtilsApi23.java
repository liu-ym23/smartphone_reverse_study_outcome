package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
class ViewUtilsApi23 extends ViewUtilsApi22 {
    private static boolean sTryHiddenSetTransitionVisibility = true;

    static {
    }

    ViewUtilsApi23() {
    }

    @Override // androidx.transition.ViewUtilsBase
    @SuppressLint({"NewApi"})
    public void setTransitionVisibility(@NonNull View r3, int r4) {
        if (Build.VERSION.SDK_INT != 28) goto L6;
        super.setTransitionVisibility(r3, r4);
        return;
    L6:
        if (sTryHiddenSetTransitionVisibility == false) goto L14;
        r3.setTransitionVisibility(r4);     // Catch: NoSuchMethodError -> L9
        return;
    L9:
        sTryHiddenSetTransitionVisibility = false;
        return;
    }
}
