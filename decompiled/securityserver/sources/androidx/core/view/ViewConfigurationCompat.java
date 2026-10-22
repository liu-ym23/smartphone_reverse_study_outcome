package androidx.core.view;

import android.R;
import android.content.Context;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class ViewConfigurationCompat {
    private static final String TAG = "ViewConfigCompat";
    private static Method sGetScaledScrollFactorMethod;

    private ViewConfigurationCompat() {
    }

    private static float getLegacyScrollFactor(ViewConfiguration r3, Context r4) {
        Method r0 = sGetScaledScrollFactorMethod;
        if (r0 != null) goto L15;
    L9:
        TypedValue r5 = new TypedValue();
        if (r4.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, r5, true) == true) goto L12;
        return 0.0f;
    L12:
        return r5.getDimension(r4.getResources().getDisplayMetrics());
    L15:
        return ((Integer) r0.invoke(r3, null)).intValue();
    L8:
        Log.i(TAG, "Could not find method getScaledScrollFactor() on ViewConfiguration");
        goto L9
    }

    public static float getScaledHorizontalScrollFactor(@NonNull ViewConfiguration r0, @NonNull Context r1) {
        return r0.getScaledHorizontalScrollFactor();
    }

    public static int getScaledHoverSlop(ViewConfiguration r0) {
        return r0.getScaledHoverSlop();
    }

    @Deprecated
    public static int getScaledPagingTouchSlop(ViewConfiguration r0) {
        return r0.getScaledPagingTouchSlop();
    }

    public static float getScaledVerticalScrollFactor(@NonNull ViewConfiguration r0, @NonNull Context r1) {
        return r0.getScaledVerticalScrollFactor();
    }

    @Deprecated
    public static boolean hasPermanentMenuKey(ViewConfiguration r0) {
        return r0.hasPermanentMenuKey();
    }

    public static boolean shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration r0, @NonNull Context r1) {
        return r0.shouldShowMenuShortcutsWhenKeyboardPresent();
    }
}
