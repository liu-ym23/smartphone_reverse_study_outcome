package androidx.core.widget;

import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class PopupWindowCompat {
    private static final String TAG = "PopupWindowCompatApi21";
    private static Method sGetWindowLayoutTypeMethod;
    private static boolean sGetWindowLayoutTypeMethodAttempted;
    private static Field sOverlapAnchorField;
    private static boolean sOverlapAnchorFieldAttempted;
    private static Method sSetWindowLayoutTypeMethod;
    private static boolean sSetWindowLayoutTypeMethodAttempted;

    private PopupWindowCompat() {
    }

    public static boolean getOverlapAnchor(@NonNull PopupWindow r0) {
        return r0.getOverlapAnchor();
    }

    public static int getWindowLayoutType(@NonNull PopupWindow r0) {
        return r0.getWindowLayoutType();
    }

    public static void setOverlapAnchor(@NonNull PopupWindow r0, boolean r1) {
        r0.setOverlapAnchor(r1);
    }

    public static void setWindowLayoutType(@NonNull PopupWindow r0, int r1) {
        r0.setWindowLayoutType(r1);
    }

    public static void showAsDropDown(@NonNull PopupWindow r0, @NonNull View r1, int r2, int r3, int r4) {
        r0.showAsDropDown(r1, r2, r3, r4);
    }
}
