package com.google.android.material.motion;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.TypedValue;
import androidx.core.graphics.PathParser;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.google.android.material.resources.MaterialAttributes;

/* JADX INFO: loaded from: classes3.dex */
public class MotionUtils {
    private static final String EASING_TYPE_CUBIC_BEZIER = "cubic-bezier";
    private static final String EASING_TYPE_FORMAT_END = ")";
    private static final String EASING_TYPE_FORMAT_START = "(";
    private static final String EASING_TYPE_PATH = "path";

    private MotionUtils() {
    }

    public static int resolveThemeDuration(Context r0, int r1, int r2) {
        return MaterialAttributes.resolveInteger(r0, r1, r2);
    }

    public static TimeInterpolator resolveThemeInterpolator(Context r2, int r3, TimeInterpolator r4) {
        TypedValue r0 = new TypedValue();
        if (r2.getTheme().resolveAttribute(r3, r0, true) == true) goto L5;
        return r4;
    L5:
        if (r0.type != 3) goto L21;
        String r5 = String.valueOf(r0.string);
        if (isEasingType(r5, EASING_TYPE_CUBIC_BEZIER) == false) goto L15;
        String[] r6 = getEasingContent(r5, EASING_TYPE_CUBIC_BEZIER).split(",");
        if (r6.length != 4) goto L13;
        return PathInterpolatorCompat.create(getControlPoint(r6, 0), getControlPoint(r6, 1), getControlPoint(r6, 2), getControlPoint(r6, 3));
    L13:
        throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + r6.length);
    L15:
        if (isEasingType(r5, "path") == false) goto L19;
        return PathInterpolatorCompat.create(PathParser.createPathFromPathData(getEasingContent(r5, "path")));
    L19:
        throw new IllegalArgumentException("Invalid motion easing type: " + r5);
    L21:
        throw new IllegalArgumentException("Motion easing theme attribute must be a string");
    }

    private static boolean isEasingType(String r1, String r2) {
        if (r1.startsWith(r2 + EASING_TYPE_FORMAT_START) == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.endsWith(EASING_TYPE_FORMAT_END) == false) goto L7;
        return true;
    }

    private static String getEasingContent(String r1, String r2) {
        return r1.substring(r2.length() + 1, r1.length() - 1);
    }

    private static float getControlPoint(String[] r2, int r3) {
        float r4 = Float.parseFloat(r2[r3]);
        if (r4 < 0.0f) goto L8;
        if (r4 > 1.0f) goto L8;
        return r4;
    L8:
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + r4);
    }
}
