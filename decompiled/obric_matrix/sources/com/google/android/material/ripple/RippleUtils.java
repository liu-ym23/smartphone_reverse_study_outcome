package com.google.android.material.ripple;

import android.R;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.ColorUtils;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class RippleUtils {
    private static final int[] ENABLED_PRESSED_STATE_SET = null;
    private static final int[] FOCUSED_STATE_SET = null;
    private static final int[] HOVERED_FOCUSED_STATE_SET = null;
    private static final int[] HOVERED_STATE_SET = null;

    @VisibleForTesting
    static final String LOG_TAG = null;
    private static final int[] PRESSED_STATE_SET = null;
    private static final int[] SELECTED_FOCUSED_STATE_SET = null;
    private static final int[] SELECTED_HOVERED_FOCUSED_STATE_SET = null;
    private static final int[] SELECTED_HOVERED_STATE_SET = null;
    private static final int[] SELECTED_PRESSED_STATE_SET = null;
    private static final int[] SELECTED_STATE_SET = null;

    @VisibleForTesting
    static final String TRANSPARENT_DEFAULT_COLOR_WARNING = "Use a non-transparent color for the default color as it will be used to finish ripple animations.";
    public static final boolean USE_FRAMEWORK_RIPPLE = false;

    static {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        boolean r0 = true;
    L6:
        USE_FRAMEWORK_RIPPLE = r0;
        PRESSED_STATE_SET = new int[]{R.attr.state_pressed};
        HOVERED_FOCUSED_STATE_SET = new int[]{R.attr.state_hovered, R.attr.state_focused};
        FOCUSED_STATE_SET = new int[]{R.attr.state_focused};
        HOVERED_STATE_SET = new int[]{R.attr.state_hovered};
        SELECTED_PRESSED_STATE_SET = new int[]{R.attr.state_selected, R.attr.state_pressed};
        SELECTED_HOVERED_FOCUSED_STATE_SET = new int[]{R.attr.state_selected, R.attr.state_hovered, R.attr.state_focused};
        SELECTED_FOCUSED_STATE_SET = new int[]{R.attr.state_selected, R.attr.state_focused};
        SELECTED_HOVERED_STATE_SET = new int[]{R.attr.state_selected, R.attr.state_hovered};
        SELECTED_STATE_SET = new int[]{R.attr.state_selected};
        ENABLED_PRESSED_STATE_SET = new int[]{R.attr.state_enabled, R.attr.state_pressed};
        LOG_TAG = RippleUtils.class.getSimpleName();
        return;
    L5:
        r0 = false;
        goto L6
    }

    private RippleUtils() {
    }

    @NonNull
    public static ColorStateList convertToRippleDrawableColor(@Nullable ColorStateList r6) {
        if (USE_FRAMEWORK_RIPPLE == true) goto L5;
        int[] r5 = SELECTED_PRESSED_STATE_SET;
        int[] r7 = SELECTED_HOVERED_FOCUSED_STATE_SET;
        int[] r2 = SELECTED_FOCUSED_STATE_SET;
        int[] r3 = SELECTED_HOVERED_STATE_SET;
        int[] r4 = PRESSED_STATE_SET;
        int[] r8 = HOVERED_FOCUSED_STATE_SET;
        int[] r9 = FOCUSED_STATE_SET;
        int[] r10 = HOVERED_STATE_SET;
        return new ColorStateList(new int[][]{r5, r7, r2, r3, SELECTED_STATE_SET, r4, r8, r9, r10, StateSet.NOTHING}, new int[]{getColorForState(r6, r5), getColorForState(r6, r7), getColorForState(r6, r2), getColorForState(r6, r3), 0, getColorForState(r6, r4), getColorForState(r6, r8), getColorForState(r6, r9), getColorForState(r6, r10), 0});
    L5:
        return new ColorStateList(new int[][]{SELECTED_STATE_SET, StateSet.NOTHING}, new int[]{getColorForState(r6, SELECTED_PRESSED_STATE_SET), getColorForState(r6, PRESSED_STATE_SET)});
    }

    @ColorInt
    @TargetApi(21)
    private static int doubleAlpha(@ColorInt int r2) {
        return ColorUtils.setAlphaComponent(r2, Math.min(Color.alpha(r2) * 2, 255));
    }

    @ColorInt
    private static int getColorForState(@Nullable ColorStateList r1, int[] r2) {
        if (r1 == null) goto L4;
        int r3 = r1.getColorForState(r2, r1.getDefaultColor());
    L6:
        if (USE_FRAMEWORK_RIPPLE == true) goto L8;
        return r3;
    L8:
        return doubleAlpha(r3);
    L4:
        r3 = 0;
        goto L6
    }

    @NonNull
    public static ColorStateList sanitizeRippleDrawableColor(@Nullable ColorStateList r3) {
        if (r3 == null) goto L15;
        int r1 = Build.VERSION.SDK_INT;
        if (r1 >= 22) goto L7;
    L13:
        return r3;
    L7:
        if (r1 > 27) goto L13;
        if (Color.alpha(r3.getDefaultColor()) != 0) goto L13;
        if (Color.alpha(r3.getColorForState(ENABLED_PRESSED_STATE_SET, 0)) == 0) goto L13;
        Log.w(LOG_TAG, TRANSPARENT_DEFAULT_COLOR_WARNING);
        goto L13
    L15:
        return ColorStateList.valueOf(0);
    }

    public static boolean shouldDrawRippleCompat(@NonNull int[] r8) {
        int r0 = r8.length;
        int r2 = 0;
        boolean r3 = false;
        boolean r4 = false;
    L4:
        if (r2 >= r0) goto L18;
        int r6 = r8[r2];
        if (r6 != 16842910) goto L9;
        r3 = true;
    L17:
        r2 = r2 + 1;
        goto L4
    L9:
        if (r6 != 16842908) goto L12;
    L10:
        r4 = true;
        goto L17
    L12:
        if (r6 == 16842919) goto L10;
        if (r6 != 16843623) goto L17;
    L18:
        if (r3 == false) goto L26;
        if (r4 == true) goto L21;
        return false;
    L21:
        return true;
    L26:
        return false;
    }
}
