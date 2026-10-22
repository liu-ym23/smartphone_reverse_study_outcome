package com.google.android.material.transition.platform;

import a.a;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class TransitionUtils {
    private static final RectF transformAlphaRectF = null;

    public interface CanvasOperation {
        void run(Canvas r1);
    }

    public interface CornerSizeBinaryOperator {
        @NonNull
        CornerSize apply(@NonNull CornerSize r1, @NonNull CornerSize r2);
    }

    static {
        transformAlphaRectF = new RectF();
    }

    private TransitionUtils() {
    }

    public static float calculateArea(@NonNull RectF r1) {
        float r0 = r1.width();
        return r1.height() * r0;
    }

    public static ShapeAppearanceModel convertToRelativeCornerSizes(ShapeAppearanceModel r1, final RectF r2) {
        return r1.withTransformedCornerSizes(new AnonymousClass1(r2));
    }

    public static Shader createColorShader(@ColorInt int r9) {
        return new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, r9, r9, Shader.TileMode.CLAMP);
    }

    @NonNull
    public static <T> T defaultIfNull(@Nullable T r0, @NonNull T r1) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        return r1;
    }

    public static View findAncestorById(View r2, @IdRes int r3) {
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
        throw new IllegalArgumentException(a.j(r0, " is not a valid ancestor"));
    }

    public static View findDescendantOrAncestorById(View r1, @IdRes int r2) {
        View r0 = r1.findViewById(r2);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return findAncestorById(r1, r2);
    }

    public static RectF getLocationOnScreen(View r4) {
        int[] r0 = new int[2];
        r4.getLocationOnScreen(r0);
        int r1 = r0[0];
        int r2 = r0[1];
        return new RectF(r1, r2, r4.getWidth() + r1, r4.getHeight() + r2);
    }

    public static RectF getRelativeBounds(View r4) {
        return new RectF(r4.getLeft(), r4.getTop(), r4.getRight(), r4.getBottom());
    }

    public static Rect getRelativeBoundsRect(View r4) {
        return new Rect(r4.getLeft(), r4.getTop(), r4.getRight(), r4.getBottom());
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

    public static float lerp(float r0, float r1, @FloatRange(from = 0.0d, to = 1.0d) float r2) {
        return a.a(r1, r0, r2, r0);
    }

    public static void maybeAddTransition(TransitionSet r0, @Nullable Transition r1) {
        if (r1 == null) goto L5;
        r0.addTransition(r1);
        return;
    }

    public static void maybeRemoveTransition(TransitionSet r0, @Nullable Transition r1) {
        if (r1 == null) goto L5;
        r0.removeTransition(r1);
        return;
    }

    private static int saveLayerAlphaCompat(Canvas r1, Rect r2, int r3) {
        RectF r0 = transformAlphaRectF;
        r0.set(r2);
        return r1.saveLayerAlpha(r0, r3);
    }

    public static void transform(Canvas r1, Rect r2, float r3, float r4, float r5, int r6, CanvasOperation r7) {
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

    public static ShapeAppearanceModel transformCornerSizes(ShapeAppearanceModel r2, ShapeAppearanceModel r3, RectF r4, CornerSizeBinaryOperator r5) {
        if (isShapeAppearanceSignificant(r2, r4) == false) goto L5;
        ShapeAppearanceModel r6 = r2;
    L7:
        return r6.toBuilder().setTopLeftCornerSize(r5.apply(r2.getTopLeftCornerSize(), r3.getTopLeftCornerSize())).setTopRightCornerSize(r5.apply(r2.getTopRightCornerSize(), r3.getTopRightCornerSize())).setBottomLeftCornerSize(r5.apply(r2.getBottomLeftCornerSize(), r3.getBottomLeftCornerSize())).setBottomRightCornerSize(r5.apply(r2.getBottomRightCornerSize(), r3.getBottomRightCornerSize())).build();
    L5:
        r6 = r3;
        goto L7
    }

    public static float lerp(float r1, float r2, @FloatRange(from = 0.0d, to = 1.0d) float r3, @FloatRange(from = 0.0d, to = 1.0d) float r4, @FloatRange(from = 0.0d, to = 1.0d) float r5) {
        if (r5 >= r3) goto L6;
        return r1;
    L6:
        if (r5 <= r4) goto L9;
        return r2;
    L9:
        return lerp(r1, r2, (r5 - r3) / (r4 - r3));
    }

    public static int lerp(int r1, int r2, @FloatRange(from = 0.0d, to = 1.0d) float r3, @FloatRange(from = 0.0d, to = 1.0d) float r4, @FloatRange(from = 0.0d, to = 1.0d) float r5) {
        if (r5 >= r3) goto L6;
        return r1;
    L6:
        if (r5 <= r4) goto L9;
        return r2;
    L9:
        return (int) lerp(r1, r2, (r5 - r3) / (r4 - r3));
    }

    public static ShapeAppearanceModel lerp(ShapeAppearanceModel r7, ShapeAppearanceModel r8, final RectF r9, final RectF r10, @FloatRange(from = 0.0d, to = 1.0d) final float r11, @FloatRange(from = 0.0d, to = 1.0d) final float r12, @FloatRange(from = 0.0d, to = 1.0d) final float r13) {
        if (r13 >= r11) goto L6;
        return r7;
    L6:
        if (r13 <= r12) goto L9;
        return r8;
    L9:
        return transformCornerSizes(r7, r8, r9, new AnonymousClass2(r9, r10, r11, r12, r13));
    }
}
