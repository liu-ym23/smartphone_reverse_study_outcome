package com.google.android.material.ripple;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.StateSet;
import androidx.core.graphics.ColorUtils;

/* JADX INFO: loaded from: classes3.dex */
public class RippleUtils {
    private static final int[] ENABLED_PRESSED_STATE_SET = null;
    private static final int[] FOCUSED_STATE_SET = null;
    private static final int[] HOVERED_FOCUSED_STATE_SET = null;
    private static final int[] HOVERED_STATE_SET = null;
    static final String LOG_TAG = null;
    private static final int[] PRESSED_STATE_SET = null;
    private static final int[] SELECTED_FOCUSED_STATE_SET = null;
    private static final int[] SELECTED_HOVERED_FOCUSED_STATE_SET = null;
    private static final int[] SELECTED_HOVERED_STATE_SET = null;
    private static final int[] SELECTED_PRESSED_STATE_SET = null;
    private static final int[] SELECTED_STATE_SET = null;
    static final String TRANSPARENT_DEFAULT_COLOR_WARNING = "Use a non-transparent color for the default color as it will be used to finish ripple animations.";
    public static final boolean USE_FRAMEWORK_RIPPLE = false;

    static {
        USE_FRAMEWORK_RIPPLE = true;
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
        LOG_TAG = "RippleUtils";
    }

    private RippleUtils() {
    }

    public static ColorStateList convertToRippleDrawableColor(ColorStateList r6) {
        if (USE_FRAMEWORK_RIPPLE == true) goto L5;
        int[] r5 = SELECTED_PRESSED_STATE_SET;
        int[] r7 = SELECTED_HOVERED_FOCUSED_STATE_SET;
        int[] r2 = SELECTED_FOCUSED_STATE_SET;
        int[] r1 = SELECTED_HOVERED_STATE_SET;
        int[] r3 = PRESSED_STATE_SET;
        int[] r4 = HOVERED_FOCUSED_STATE_SET;
        int[] r8 = FOCUSED_STATE_SET;
        int[] r9 = HOVERED_STATE_SET;
        return new ColorStateList(new int[][]{r5, r7, r2, r1, SELECTED_STATE_SET, r3, r4, r8, r9, StateSet.NOTHING}, new int[]{getColorForState(r6, r5), getColorForState(r6, r7), getColorForState(r6, r2), getColorForState(r6, r1), 0, getColorForState(r6, r3), getColorForState(r6, r4), getColorForState(r6, r8), getColorForState(r6, r9), 0});
    L5:
        return new ColorStateList(new int[][]{SELECTED_STATE_SET, StateSet.NOTHING}, new int[]{getColorForState(r6, SELECTED_PRESSED_STATE_SET), getColorForState(r6, PRESSED_STATE_SET)});
    }

    public static ColorStateList sanitizeRippleDrawableColor(ColorStateList r0) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        return ColorStateList.valueOf(0);
    }

    public static boolean shouldDrawRippleCompat(int[] r8) {
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

    private static int getColorForState(ColorStateList r1, int[] r2) {
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

    private static int doubleAlpha(int r2) {
        return ColorUtils.setAlphaComponent(r2, Math.min(Color.alpha(r2) * 2, 255));
    }
}
