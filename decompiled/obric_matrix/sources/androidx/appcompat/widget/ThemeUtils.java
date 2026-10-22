package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ThemeUtils {
    static final int[] ACTIVATED_STATE_SET = null;
    static final int[] CHECKED_STATE_SET = null;
    static final int[] DISABLED_STATE_SET = null;
    static final int[] EMPTY_STATE_SET = null;
    static final int[] FOCUSED_STATE_SET = null;
    static final int[] NOT_PRESSED_OR_FOCUSED_STATE_SET = null;
    static final int[] PRESSED_STATE_SET = null;
    static final int[] SELECTED_STATE_SET = null;
    private static final String TAG = "ThemeUtils";
    private static final int[] TEMP_ARRAY = null;
    private static final ThreadLocal<TypedValue> TL_TYPED_VALUE = null;

    static {
        TL_TYPED_VALUE = new ThreadLocal();
        DISABLED_STATE_SET = new int[]{-16842910};
        FOCUSED_STATE_SET = new int[]{R.attr.state_focused};
        ACTIVATED_STATE_SET = new int[]{R.attr.state_activated};
        PRESSED_STATE_SET = new int[]{R.attr.state_pressed};
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        SELECTED_STATE_SET = new int[]{R.attr.state_selected};
        NOT_PRESSED_OR_FOCUSED_STATE_SET = new int[]{-16842919, -16842908};
        EMPTY_STATE_SET = new int[0];
        TEMP_ARRAY = new int[1];
    }

    private ThemeUtils() {
    }

    public static void checkAppCompatTheme(@NonNull View r3, @NonNull Context r4) {
        TypedArray r5 = r4.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
    L8:
        th = move-exception;
        r5.recycle();
        throw th;
    L4:
        if (r5.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowActionBar) == true) goto L6;
        Log.e(TAG, "View " + r3.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");     // Catch: Throwable -> L8
    L6:
        r5.recycle();
    }

    @NonNull
    public static ColorStateList createDisabledStateList(int r4, int r5) {
        return new ColorStateList(new int[][]{DISABLED_STATE_SET, EMPTY_STATE_SET}, new int[]{r5, r4});
    }

    public static int getDisabledThemeAttrColor(@NonNull Context r4, int r5) {
        ColorStateList r0 = getThemeAttrColorStateList(r4, r5);
        if (r0 != null) goto L5;
    L8:
        TypedValue r1 = getTypedValue();
        r4.getTheme().resolveAttribute(R.attr.disabledAlpha, r1, true);
        return getThemeAttrColor(r4, r5, r1.getFloat());
    L5:
        if (r0.isStateful() == false) goto L8;
        return r0.getColorForState(DISABLED_STATE_SET, r0.getDefaultColor());
    }

    public static int getThemeAttrColor(@NonNull Context r2, int r3) {
        int[] r0 = TEMP_ARRAY;
        r0[0] = r3;
        TintTypedArray r4 = TintTypedArray.obtainStyledAttributes(r2, null, r0);
        int r5 = r4.getColor(0, 0);     // Catch: Throwable -> L6
        r4.recycle();
        return r5;
    L6:
        th = move-exception;
        r4.recycle();
        throw th;
    }

    static int getThemeAttrColor(@NonNull Context r0, int r1, float r2) {
        int r3 = getThemeAttrColor(r0, r1);
        return ColorUtils.setAlphaComponent(r3, Math.round(Color.alpha(r3) * r2));
    }

    @Nullable
    public static ColorStateList getThemeAttrColorStateList(@NonNull Context r2, int r3) {
        int[] r0 = TEMP_ARRAY;
        r0[0] = r3;
        TintTypedArray r4 = TintTypedArray.obtainStyledAttributes(r2, null, r0);
        ColorStateList r5 = r4.getColorStateList(0);     // Catch: Throwable -> L6
        r4.recycle();
        return r5;
    L6:
        th = move-exception;
        r4.recycle();
        throw th;
    }

    private static TypedValue getTypedValue() {
        ThreadLocal<TypedValue> r0 = TL_TYPED_VALUE;
        TypedValue r1 = r0.get();
        if (r1 != null) goto L6;
        TypedValue r2 = new TypedValue();
        r0.set(r2);
        return r2;
    L6:
        return r1;
    }
}
