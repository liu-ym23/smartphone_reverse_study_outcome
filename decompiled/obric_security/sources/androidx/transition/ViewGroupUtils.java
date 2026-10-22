package androidx.transition;

import android.view.ViewGroup;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class ViewGroupUtils {
    private static Method sGetChildDrawingOrderMethod = null;
    private static boolean sGetChildDrawingOrderMethodFetched = false;
    private static boolean sTryHiddenSuppressLayout = true;

    static {
    }

    static ViewGroupOverlayImpl getOverlay(ViewGroup r1) {
        return new ViewGroupOverlayApi18(r1);
    }

    static void suppressLayout(ViewGroup r0, boolean r1) {
        r0.suppressLayout(r1);
    }

    private static void hiddenSuppressLayout(ViewGroup r1, boolean r2) {
        if (sTryHiddenSuppressLayout == false) goto L10;
        r1.suppressLayout(r2);     // Catch: NoSuchMethodError -> L6
        return;
    L6:
        sTryHiddenSuppressLayout = false;
        return;
    }

    static int getChildDrawingOrder(ViewGroup r0, int r1) {
        return r0.getChildDrawingOrder(r1);
    }

    private ViewGroupUtils() {
    }
}
