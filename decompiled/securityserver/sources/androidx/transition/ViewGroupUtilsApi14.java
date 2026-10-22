package androidx.transition;

import android.animation.LayoutTransition;
import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class ViewGroupUtilsApi14 {
    private static final int LAYOUT_TRANSITION_CHANGING = 4;
    private static final String TAG = "ViewGroupUtilsApi14";
    private static Method sCancelMethod;
    private static boolean sCancelMethodFetched;
    private static LayoutTransition sEmptyLayoutTransition;
    private static Field sLayoutSuppressedField;
    private static boolean sLayoutSuppressedFieldFetched;

    private ViewGroupUtilsApi14() {
    }

    private static void cancelLayoutTransition(LayoutTransition r6) {
        if (sCancelMethodFetched == false) goto L16;
    L9:
        Method r0 = sCancelMethod;
        if (r0 == null) goto L20;
        r0.invoke(r6, null);     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L14
    L22:
        return;
    L14:
        Log.i(TAG, "Failed to access cancel method by reflection");
        return;
    L13:
        Log.i(TAG, "Failed to invoke cancel method by reflection");
        return;
    L20:
        return;
    L16:
        Method r4 = LayoutTransition.class.getDeclaredMethod("cancel", null);     // Catch: NoSuchMethodException -> L7
        sCancelMethod = r4;     // Catch: NoSuchMethodException -> L7
        r4.setAccessible(true);     // Catch: NoSuchMethodException -> L7
    L8:
        sCancelMethodFetched = true;
    L7:
        Log.i(TAG, "Failed to access cancel method by reflection");
        goto L8
    }

    public static void suppressLayout(@NonNull ViewGroup r5, boolean r6) {
        boolean r2 = false;
        if (sEmptyLayoutTransition != null) goto L5;
        LayoutTransition r0 = new AnonymousClass1();
        sEmptyLayoutTransition = r0;
        r0.setAnimator(2, null);
        sEmptyLayoutTransition.setAnimator(0, null);
        sEmptyLayoutTransition.setAnimator(1, null);
        sEmptyLayoutTransition.setAnimator(3, null);
        sEmptyLayoutTransition.setAnimator(4, null);
    L5:
        if (r6 == false) goto L15;
        LayoutTransition r7 = r5.getLayoutTransition();
        if (r7 != null) goto L9;
    L14:
        r5.setLayoutTransition(sEmptyLayoutTransition);
        return;
    L9:
        if (r7.isRunning() == false) goto L12;
        cancelLayoutTransition(r7);
    L12:
        if (r7 == sEmptyLayoutTransition) goto L14;
        r5.setTag(R.id.transition_layout_save, r7);
        goto L14
    L15:
        r5.setLayoutTransition(null);
        if (sLayoutSuppressedFieldFetched == false) goto L39;
    L21:
        Field r8 = sLayoutSuppressedField;
        if (r8 != null) goto L41;
    L30:
        if (r2 == false) goto L32;
        r5.requestLayout();
    L32:
        LayoutTransition r9 = (LayoutTransition) r5.getTag(R.id.transition_layout_save);
        if (r9 == null) goto L44;
        r5.setTag(R.id.transition_layout_save, null);
        r5.setLayoutTransition(r9);
        return;
    L44:
        return;
    L41:
        boolean r10 = r8.getBoolean(r5);     // Catch: IllegalAccessException -> L36
        if (r10 == true) goto L37;
    L28:
        r2 = r10;
        goto L30
    L37:
        sLayoutSuppressedField.setBoolean(r5, false);     // Catch: IllegalAccessException -> L27
    L27:
        r2 = r10;
    L29:
        Log.i(TAG, "Failed to get mLayoutSuppressed field by reflection");
        goto L30
    L39:
        Field r11 = ViewGroup.class.getDeclaredField("mLayoutSuppressed");     // Catch: NoSuchFieldException -> L19
        sLayoutSuppressedField = r11;     // Catch: NoSuchFieldException -> L19
        r11.setAccessible(true);     // Catch: NoSuchFieldException -> L19
    L20:
        sLayoutSuppressedFieldFetched = true;
    L19:
        Log.i(TAG, "Failed to access mLayoutSuppressed field by reflection");
        goto L20
    }
}
