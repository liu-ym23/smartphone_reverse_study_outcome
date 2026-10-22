package androidx.core.view;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class ViewConfigurationCompat {
    private static final String TAG = "ViewConfigCompat";
    private static Method sGetScaledScrollFactorMethod;

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static float getScaledHorizontalScrollFactor(ViewConfiguration r0) {
            return r0.getScaledHorizontalScrollFactor();
        }

        @DoNotInline
        static float getScaledVerticalScrollFactor(ViewConfiguration r0) {
            return r0.getScaledVerticalScrollFactor();
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static int getScaledHoverSlop(ViewConfiguration r0) {
            return r0.getScaledHoverSlop();
        }

        @DoNotInline
        static boolean shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration r0) {
            return r0.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
    }

    static {
        if (Build.VERSION.SDK_INT != 25) goto L10;
        sGetScaledScrollFactorMethod = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);     // Catch: Exception -> L6
        return;
    L6:
        Log.i(TAG, "Could not find method getScaledScrollFactor() on ViewConfiguration");
        return;
    }

    private ViewConfigurationCompat() {
    }

    private static float getLegacyScrollFactor(ViewConfiguration r3, Context r4) {
        if (Build.VERSION.SDK_INT < 25) goto L11;
        Method r0 = sGetScaledScrollFactorMethod;
        if (r0 == null) goto L11;
        return ((Integer) r0.invoke(r3, new Object[0])).intValue();
    L10:
        Log.i(TAG, "Could not find method getScaledScrollFactor() on ViewConfiguration");
    L11:
        TypedValue r5 = new TypedValue();
        if (r4.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, r5, true) == true) goto L14;
        return 0.0f;
    L14:
        return r5.getDimension(r4.getResources().getDisplayMetrics());
    }

    public static float getScaledHorizontalScrollFactor(@NonNull ViewConfiguration r2, @NonNull Context r3) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.getScaledHorizontalScrollFactor(r2);
    L7:
        return getLegacyScrollFactor(r2, r3);
    }

    public static int getScaledHoverSlop(@NonNull ViewConfiguration r2) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return Api28Impl.getScaledHoverSlop(r2);
    L7:
        return r2.getScaledTouchSlop() / 2;
    }

    @Deprecated
    public static int getScaledPagingTouchSlop(ViewConfiguration r0) {
        return r0.getScaledPagingTouchSlop();
    }

    public static float getScaledVerticalScrollFactor(@NonNull ViewConfiguration r2, @NonNull Context r3) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.getScaledVerticalScrollFactor(r2);
    L7:
        return getLegacyScrollFactor(r2, r3);
    }

    @Deprecated
    public static boolean hasPermanentMenuKey(ViewConfiguration r0) {
        return r0.hasPermanentMenuKey();
    }

    public static boolean shouldShowMenuShortcutsWhenKeyboardPresent(@NonNull ViewConfiguration r2, @NonNull Context r3) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        Resources r4 = r3.getResources();
        int r5 = r4.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
        if (r5 != 0) goto L9;
    L11:
        return false;
    L9:
        if (r4.getBoolean(r5) == false) goto L11;
        return true;
    L5:
        return Api28Impl.shouldShowMenuShortcutsWhenKeyboardPresent(r2);
    }
}
