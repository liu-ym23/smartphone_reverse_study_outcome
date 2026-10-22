package androidx.transition;

import android.annotation.SuppressLint;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class ViewGroupUtils {
    private static Method sGetChildDrawingOrderMethod = null;
    private static boolean sGetChildDrawingOrderMethodFetched = false;
    private static boolean sTryHiddenSuppressLayout = true;

    private ViewGroupUtils() {
    }

    public static int getChildDrawingOrder(@NonNull ViewGroup r0, int r1) {
        return r0.getChildDrawingOrder(r1);
    }

    public static ViewGroupOverlayImpl getOverlay(@NonNull ViewGroup r1) {
        return new ViewGroupOverlayApi18(r1);
    }

    @RequiresApi(18)
    @SuppressLint({"NewApi"})
    private static void hiddenSuppressLayout(@NonNull ViewGroup r1, boolean r2) {
        if (sTryHiddenSuppressLayout == false) goto L10;
        r1.suppressLayout(r2);     // Catch: NoSuchMethodError -> L6
        return;
    L6:
        sTryHiddenSuppressLayout = false;
        return;
    }

    public static void suppressLayout(@NonNull ViewGroup r0, boolean r1) {
        r0.suppressLayout(r1);
    }
}
