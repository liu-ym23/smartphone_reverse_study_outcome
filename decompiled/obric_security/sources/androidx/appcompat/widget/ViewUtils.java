package androidx.appcompat.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class ViewUtils {
    static final boolean SDK_LEVEL_SUPPORTS_AUTOSIZE = false;
    private static final String TAG = "ViewUtils";
    private static Method sComputeFitSystemWindowsMethod;

    static {
        SDK_LEVEL_SUPPORTS_AUTOSIZE = true;
        Method r1 = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{Rect.class, Rect.class});     // Catch: NoSuchMethodException -> L7
        sComputeFitSystemWindowsMethod = r1;     // Catch: NoSuchMethodException -> L7
        if (r1.isAccessible() == true) goto L11;
        sComputeFitSystemWindowsMethod.setAccessible(true);     // Catch: NoSuchMethodException -> L7
        return;
    L11:
        return;
    L7:
        Log.d(TAG, "Could not find method computeFitSystemWindows. Oh well.");
    }

    private ViewUtils() {
    }

    public static boolean isLayoutRtl(View r1) {
        if (ViewCompat.getLayoutDirection(r1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static void computeFitSystemWindows(View r3, Rect r4, Rect r5) {
        Method r0 = sComputeFitSystemWindowsMethod;
        if (r0 != null) goto L10;
        return;
    L10:
        r0.invoke(r3, new Object[]{r4, r5});     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        Log.d(TAG, "Could not invoke computeFitSystemWindows", e);
    }

    public static void makeOptionalFitsSystemWindows(View r6) {
        Method r2 = r6.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);     // Catch: IllegalAccessException -> L8 InvocationTargetException -> L10 NoSuchMethodException -> L12
        if (r2.isAccessible() == true) goto L6;
        r2.setAccessible(true);     // Catch: IllegalAccessException -> L8 InvocationTargetException -> L10 NoSuchMethodException -> L12
    L6:
        r2.invoke(r6, new Object[0]);     // Catch: IllegalAccessException -> L8 InvocationTargetException -> L10 NoSuchMethodException -> L12
    L18:
        return;
    L8:
        e = move-exception;
        Log.d(TAG, "Could not invoke makeOptionalFitsSystemWindows", e);
        return;
    L12:
        Log.d(TAG, "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        return;
    L10:
        e = move-exception;
        Log.d(TAG, "Could not invoke makeOptionalFitsSystemWindows", e);
    }
}
