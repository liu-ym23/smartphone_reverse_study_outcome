package androidx.appcompat.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ViewUtils {
    private static final String TAG = "ViewUtils";
    private static Method sComputeFitSystemWindowsMethod;

    static {
        Method r0 = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{Rect.class, Rect.class});     // Catch: NoSuchMethodException -> L7
        sComputeFitSystemWindowsMethod = r0;     // Catch: NoSuchMethodException -> L7
        if (r0.isAccessible() == true) goto L11;
        sComputeFitSystemWindowsMethod.setAccessible(true);     // Catch: NoSuchMethodException -> L7
        return;
    L11:
        return;
    L7:
        Log.d(TAG, "Could not find method computeFitSystemWindows. Oh well.");
    }

    private ViewUtils() {
    }

    public static void computeFitSystemWindows(View r1, Rect r2, Rect r3) {
        Method r0 = sComputeFitSystemWindowsMethod;
        if (r0 == null) goto L11;
        r0.invoke(r1, new Object[]{r2, r3});     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        Log.d(TAG, "Could not invoke computeFitSystemWindows", e);
        return;
    }

    public static boolean isLayoutRtl(View r1) {
        if (ViewCompat.getLayoutDirection(r1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static void makeOptionalFitsSystemWindows(View r5) {
        Method r2 = r5.getClass().getMethod("makeOptionalFitsSystemWindows", null);     // Catch: IllegalAccessException -> L6 InvocationTargetException -> L8 NoSuchMethodException -> L14
        if (r2.isAccessible() == true) goto L10;
        r2.setAccessible(true);     // Catch: IllegalAccessException -> L6 InvocationTargetException -> L8 NoSuchMethodException -> L14
    L10:
        r2.invoke(r5, null);     // Catch: IllegalAccessException -> L6 InvocationTargetException -> L8 NoSuchMethodException -> L14
    L20:
        return;
    L6:
        e = move-exception;
        Log.d(TAG, "Could not invoke makeOptionalFitsSystemWindows", e);
        return;
    L14:
        Log.d(TAG, "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        return;
    L8:
        e = move-exception;
        Log.d(TAG, "Could not invoke makeOptionalFitsSystemWindows", e);
    }
}
