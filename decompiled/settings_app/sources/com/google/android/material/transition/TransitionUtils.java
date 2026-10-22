package com.google.android.material.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.TypedValue;
import android.view.View;
import androidx.core.graphics.PathParser;
import androidx.transition.PathMotion;
import androidx.transition.PatternPathMotion;
import androidx.transition.Transition;
import androidx.transition.TransitionSet;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;

/* JADX INFO: loaded from: classes3.dex */
class TransitionUtils {
    static final int NO_ATTR_RES_ID = 0;
    static final int NO_DURATION = -1;
    private static final int PATH_TYPE_ARC = 1;
    private static final int PATH_TYPE_LINEAR = 0;
    private static final RectF transformAlphaRectF = null;

    interface CanvasOperation {
        void run(Canvas r1);
    }

    interface CornerSizeBinaryOperator {
        CornerSize apply(CornerSize r1, CornerSize r2);
    }

    static <T> T defaultIfNull(T r0, T r1) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        return r1;
    }

    static float lerp(float r0, float r1, float r2) {
        return r0 + (r2 * (r1 - r0));
    }

    private TransitionUtils() {
    }

    static boolean maybeApplyThemeInterpolator(Transition r1, Context r2, int r3, TimeInterpolator r4) {
        if (r3 != 0) goto L4;
        return false;
    L4:
        if (r1.getInterpolator() != null) goto L9;
        r1.setInterpolator(MotionUtils.resolveThemeInterpolator(r2, r3, r4));
        return true;
    L9:
        return false;
    }

    static boolean maybeApplyThemeDuration(Transition r4, Context r5, int r6) {
        if (r6 != 0) goto L4;
        return false;
    L4:
        if (r4.getDuration() != (-1)) goto L11;
        int r7 = MotionUtils.resolveThemeDuration(r5, r6, -1);
        if (r7 == (-1)) goto L12;
        r4.setDuration(r7);
        return true;
    L12:
        return false;
    L11:
        return false;
    }

    static boolean maybeApplyThemePath(Transition r0, Context r1, int r2) {
        if (r2 == 0) goto L7;
        PathMotion r3 = resolveThemePath(r1, r2);
        if (r3 == null) goto L9;
        r0.setPathMotion(r3);
        return true;
    L9:
        return false;
    L7:
        return false;
    }

    static PathMotion resolveThemePath(Context r3, int r4) {
        TypedValue r0 = new TypedValue();
        if (r3.getTheme().resolveAttribute(r4, r0, true) == true) goto L5;
        return null;
    L5:
        if (r0.type != 16) goto L15;
        int r5 = r0.data;
        if (r5 != 0) goto L9;
        return null;
    L9:
        if (r5 != 1) goto L13;
        return new MaterialArcMotion();
    L13:
        throw new IllegalArgumentException("Invalid motion path type: " + r5);
    L15:
        if (r0.type != 3) goto L19;
        return new PatternPathMotion(PathParser.createPathFromPathData(String.valueOf(r0.string)));
    L19:
        throw new IllegalArgumentException("Motion path theme attribute must either be an enum value or path data string");
    }

    static ShapeAppearanceModel convertToRelativeCornerSizes(ShapeAppearanceModel r1, final RectF r2) {
        return r1.withTransformedCornerSizes(new AnonymousClass1(r2));
    }

    static ShapeAppearanceModel transformCornerSizes(ShapeAppearanceModel r2, ShapeAppearanceModel r3, RectF r4, CornerSizeBinaryOperator r5) {
        if (isShapeAppearanceSignificant(r2, r4) == false) goto L5;
        ShapeAppearanceModel r6 = r2;
    L7:
        return r6.toBuilder().setTopLeftCornerSize(r5.apply(r2.getTopLeftCornerSize(), r3.getTopLeftCornerSize())).setTopRightCornerSize(r5.apply(r2.getTopRightCornerSize(), r3.getTopRightCornerSize())).setBottomLeftCornerSize(r5.apply(r2.getBottomLeftCornerSize(), r3.getBottomLeftCornerSize())).setBottomRightCornerSize(r5.apply(r2.getBottomRightCornerSize(), r3.getBottomRightCornerSize())).build();
    L5:
        r6 = r3;
        goto L7
    }

    private static boolean isShapeAppearanceSignificant(ShapeAppearanceModel r2, RectF r3) {
        if (r2.getTopLeftCornerSize().getCornerSize(r3) == 0.0f) goto L5;
    L12:
        return true;
    L5:
        if (r2.getTopRightCornerSize().getCornerSize(r3) != 0.0f) goto L12;
        if (r2.getBottomRightCornerSize().getCornerSize(r3) != 0.0f) goto L12;
        if (r2.getBottomLeftCornerSize().getCornerSize(r3) != 0.0f) goto L12;
        return false;
    }

    static float lerp(float r6, float r7, float r8, float r9, float r10) {
        return lerp(r6, r7, r8, r9, r10, false);
    }

    static float lerp(float r0, float r1, float r2, float r3, float r4, boolean r5) {
        if (r5 == false) goto L10;
        if (r4 < 0.0f) goto L8;
        if (r4 <= 1.0f) goto L10;
    L8:
        return lerp(r0, r1, r4);
    L10:
        if (r4 >= r2) goto L13;
        return r0;
    L13:
        if (r4 <= r3) goto L16;
        return r1;
    L16:
        return lerp(r0, r1, (r4 - r2) / (r3 - r2));
    }

    static int lerp(int r1, int r2, float r3, float r4, float r5) {
        if (r5 >= r3) goto L6;
        return r1;
    L6:
        if (r5 <= r4) goto L9;
        return r2;
    L9:
        return (int) lerp(r1, r2, (r5 - r3) / (r4 - r3));
    }

    static ShapeAppearanceModel lerp(ShapeAppearanceModel r7, ShapeAppearanceModel r8, final RectF r9, final RectF r10, final float r11, final float r12, final float r13) {
        if (r13 >= r11) goto L6;
        return r7;
    L6:
        if (r13 <= r12) goto L9;
        return r8;
    L9:
        return transformCornerSizes(r7, r8, r9, new AnonymousClass2(r9, r10, r11, r12, r13));
    }

    static Shader createColorShader(int r9) {
        return new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, r9, r9, Shader.TileMode.CLAMP);
    }

    static View findDescendantOrAncestorById(View r1, int r2) {
        View r0 = r1.findViewById(r2);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return findAncestorById(r1, r2);
    }

    static View findAncestorById(View r2, int r3) {
        String r0 = r2.getResources().getResourceName(r3);
    L3:
        if (r2 == null) goto L11;
        if (r2.getId() == r3) goto L6;
        Object r4 = r2.getParent();
        if ((r4 instanceof View) == false) goto L11;
        r2 = (View) r4;
        goto L3
    L6:
        return r2;
    L11:
        throw new IllegalArgumentException(r0 + " is not a valid ancestor");
    }

    static RectF getRelativeBounds(View r4) {
        return new RectF(r4.getLeft(), r4.getTop(), r4.getRight(), r4.getBottom());
    }

    static Rect getRelativeBoundsRect(View r4) {
        return new Rect(r4.getLeft(), r4.getTop(), r4.getRight(), r4.getBottom());
    }

    static RectF getLocationOnScreen(View r4) {
        int[] r0 = new int[2];
        r4.getLocationOnScreen(r0);
        int r1 = r0[0];
        int r2 = r0[1];
        return new RectF(r1, r2, r4.getWidth() + r1, r4.getHeight() + r2);
    }

    static float calculateArea(RectF r1) {
        return r1.width() * r1.height();
    }

    static {
        transformAlphaRectF = new RectF();
    }

    private static int saveLayerAlphaCompat(Canvas r1, Rect r2, int r3) {
        RectF r0 = transformAlphaRectF;
        r0.set(r2);
        return r1.saveLayerAlpha(r0, r3);
    }

    static void transform(Canvas r1, Rect r2, float r3, float r4, float r5, int r6, CanvasOperation r7) {
        if (r6 > 0) goto L4;
        return;
    L4:
        int r0 = r1.save();
        r1.translate(r3, r4);
        r1.scale(r5, r5);
        if (r6 >= 255) goto L7;
        saveLayerAlphaCompat(r1, r2, r6);
    L7:
        r7.run(r1);
        r1.restoreToCount(r0);
    }

    static void maybeAddTransition(TransitionSet r0, Transition r1) {
        if (r1 == null) goto L5;
        r0.addTransition(r1);
        return;
    }

    static void maybeRemoveTransition(TransitionSet r0, Transition r1) {
        if (r1 == null) goto L5;
        r0.removeTransition(r1);
        return;
    }
}
