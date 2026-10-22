package com.google.android.material.transition;

import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.transition.ArcMotion;
import androidx.transition.PathMotion;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public final class MaterialContainerTransform extends Transition {
    private static final ProgressThresholdsGroup DEFAULT_ENTER_THRESHOLDS = null;
    private static final ProgressThresholdsGroup DEFAULT_ENTER_THRESHOLDS_ARC = null;
    private static final ProgressThresholdsGroup DEFAULT_RETURN_THRESHOLDS = null;
    private static final ProgressThresholdsGroup DEFAULT_RETURN_THRESHOLDS_ARC = null;
    private static final float ELEVATION_NOT_SET = -1.0f;
    public static final int FADE_MODE_CROSS = 2;
    public static final int FADE_MODE_IN = 0;
    public static final int FADE_MODE_OUT = 1;
    public static final int FADE_MODE_THROUGH = 3;
    public static final int FIT_MODE_AUTO = 0;
    public static final int FIT_MODE_HEIGHT = 2;
    public static final int FIT_MODE_WIDTH = 1;
    private static final String PROP_BOUNDS = "materialContainerTransition:bounds";
    private static final String PROP_SHAPE_APPEARANCE = "materialContainerTransition:shapeAppearance";
    private static final String TAG = null;
    public static final int TRANSITION_DIRECTION_AUTO = 0;
    public static final int TRANSITION_DIRECTION_ENTER = 1;
    public static final int TRANSITION_DIRECTION_RETURN = 2;
    private static final String[] TRANSITION_PROPS = null;
    private boolean appliedThemeValues;

    @ColorInt
    private int containerColor;
    private boolean drawDebugEnabled;

    @IdRes
    private int drawingViewId;
    private boolean elevationShadowEnabled;

    @ColorInt
    private int endContainerColor;
    private float endElevation;

    @Nullable
    private ShapeAppearanceModel endShapeAppearanceModel;

    @Nullable
    private View endView;

    @IdRes
    private int endViewId;
    private int fadeMode;

    @Nullable
    private ProgressThresholds fadeProgressThresholds;
    private int fitMode;
    private boolean holdAtEndEnabled;
    private boolean pathMotionCustom;

    @Nullable
    private ProgressThresholds scaleMaskProgressThresholds;

    @Nullable
    private ProgressThresholds scaleProgressThresholds;

    @ColorInt
    private int scrimColor;

    @Nullable
    private ProgressThresholds shapeMaskProgressThresholds;

    @ColorInt
    private int startContainerColor;
    private float startElevation;

    @Nullable
    private ShapeAppearanceModel startShapeAppearanceModel;

    @Nullable
    private View startView;

    @IdRes
    private int startViewId;
    private int transitionDirection;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface FadeMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface FitMode {
    }

    public static class ProgressThresholds {

        @FloatRange(from = 0.0d, to = 1.0d)
        private final float end;

        @FloatRange(from = 0.0d, to = 1.0d)
        private final float start;

        public ProgressThresholds(@FloatRange(from = 0.0d, to = 1.0d) float r1, @FloatRange(from = 0.0d, to = 1.0d) float r2) {
            this.start = r1;
            this.end = r2;
        }

        static /* synthetic */ float access$1000(ProgressThresholds r0) {
            return r0.start;
        }

        static /* synthetic */ float access$1100(ProgressThresholds r0) {
            return r0.end;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float getEnd() {
            return this.end;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float getStart() {
            return this.start;
        }
    }

    private static class ProgressThresholdsGroup {

        @NonNull
        private final ProgressThresholds fade;

        @NonNull
        private final ProgressThresholds scale;

        @NonNull
        private final ProgressThresholds scaleMask;

        @NonNull
        private final ProgressThresholds shapeMask;

        private ProgressThresholdsGroup(@NonNull ProgressThresholds r1, @NonNull ProgressThresholds r2, @NonNull ProgressThresholds r3, @NonNull ProgressThresholds r4) {
            this.fade = r1;
            this.scale = r2;
            this.scaleMask = r3;
            this.shapeMask = r4;
        }

        /* synthetic */ ProgressThresholdsGroup(ProgressThresholds r1, ProgressThresholds r2, ProgressThresholds r3, ProgressThresholds r4, AnonymousClass1 r5) {
            this(r1, r2, r3, r4);
        }

        static /* synthetic */ ProgressThresholds access$400(ProgressThresholdsGroup r0) {
            return r0.fade;
        }

        static /* synthetic */ ProgressThresholds access$500(ProgressThresholdsGroup r0) {
            return r0.scale;
        }

        static /* synthetic */ ProgressThresholds access$600(ProgressThresholdsGroup r0) {
            return r0.scaleMask;
        }

        static /* synthetic */ ProgressThresholds access$700(ProgressThresholdsGroup r0) {
            return r0.shapeMask;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TransitionDirection {
    }

    private static final class TransitionDrawable extends Drawable {
        private static final int COMPAT_SHADOW_COLOR = -7829368;
        private static final int SHADOW_COLOR = 754974720;
        private static final float SHADOW_DX_MULTIPLIER_ADJUSTMENT = 0.3f;
        private static final float SHADOW_DY_MULTIPLIER_ADJUSTMENT = 1.5f;
        private final MaterialShapeDrawable compatShadowDrawable;
        private final Paint containerPaint;
        private float currentElevation;
        private float currentElevationDy;
        private final RectF currentEndBounds;
        private final RectF currentEndBoundsMasked;
        private RectF currentMaskBounds;
        private final RectF currentStartBounds;
        private final RectF currentStartBoundsMasked;
        private final Paint debugPaint;
        private final Path debugPath;
        private final float displayHeight;
        private final float displayWidth;
        private final boolean drawDebugEnabled;
        private final boolean elevationShadowEnabled;
        private final RectF endBounds;
        private final Paint endContainerPaint;
        private final float endElevation;
        private final ShapeAppearanceModel endShapeAppearanceModel;
        private final View endView;
        private final boolean entering;
        private final FadeModeEvaluator fadeModeEvaluator;
        private FadeModeResult fadeModeResult;
        private final FitModeEvaluator fitModeEvaluator;
        private FitModeResult fitModeResult;
        private final MaskEvaluator maskEvaluator;
        private final float motionPathLength;
        private final PathMeasure motionPathMeasure;
        private final float[] motionPathPosition;
        private float progress;
        private final ProgressThresholdsGroup progressThresholds;
        private final Paint scrimPaint;
        private final Paint shadowPaint;
        private final RectF startBounds;
        private final Paint startContainerPaint;
        private final float startElevation;
        private final ShapeAppearanceModel startShapeAppearanceModel;
        private final View startView;

        private TransitionDrawable(PathMotion r14, View r15, RectF r16, ShapeAppearanceModel r17, float r18, View r19, RectF r20, ShapeAppearanceModel r21, float r22, @ColorInt int r23, @ColorInt int r24, @ColorInt int r25, int r26, boolean r27, boolean r28, FadeModeEvaluator r29, FitModeEvaluator r30, ProgressThresholdsGroup r31, boolean r32) {
            Paint r2 = new Paint();
            this.containerPaint = r2;
            Paint r3 = new Paint();
            this.startContainerPaint = r3;
            Paint r4 = new Paint();
            this.endContainerPaint = r4;
            this.shadowPaint = new Paint();
            Paint r5 = new Paint();
            this.scrimPaint = r5;
            this.maskEvaluator = new MaskEvaluator();
            this.motionPathPosition = new float[]{r16.centerX(), r16.top};
            MaterialShapeDrawable r8 = new MaterialShapeDrawable();
            this.compatShadowDrawable = r8;
            Paint r9 = new Paint();
            this.debugPaint = r9;
            this.debugPath = new Path();
            this.startView = r15;
            this.startBounds = r16;
            this.startShapeAppearanceModel = r17;
            this.startElevation = r18;
            this.endView = r19;
            this.endBounds = r20;
            this.endShapeAppearanceModel = r21;
            this.endElevation = r22;
            this.entering = r27;
            this.elevationShadowEnabled = r28;
            this.fadeModeEvaluator = r29;
            this.fitModeEvaluator = r30;
            this.progressThresholds = r31;
            this.drawDebugEnabled = r32;
            WindowManager r10 = (WindowManager) r15.getContext().getSystemService("window");
            DisplayMetrics r12 = new DisplayMetrics();
            r10.getDefaultDisplay().getMetrics(r12);
            this.displayWidth = r12.widthPixels;
            this.displayHeight = r12.heightPixels;
            r2.setColor(r23);
            r3.setColor(r24);
            r4.setColor(r25);
            r8.setFillColor(ColorStateList.valueOf(0));
            r8.setShadowCompatibilityMode(2);
            r8.setShadowBitmapDrawingEnable(false);
            r8.setShadowColor(COMPAT_SHADOW_COLOR);
            RectF r6 = new RectF(r16);
            this.currentStartBounds = r6;
            this.currentStartBoundsMasked = new RectF(r6);
            RectF r7 = new RectF(r6);
            this.currentEndBounds = r7;
            this.currentEndBoundsMasked = new RectF(r7);
            PointF r11 = getMotionPathPoint(r16);
            PointF r13 = getMotionPathPoint(r20);
            PathMeasure r33 = new PathMeasure(r14.getPath(r11.x, r11.y, r13.x, r13.y), false);
            this.motionPathMeasure = r33;
            this.motionPathLength = r33.getLength();
            r5.setStyle(Paint.Style.FILL);
            r5.setShader(TransitionUtils.createColorShader(r26));
            r9.setStyle(Paint.Style.STROKE);
            r9.setStrokeWidth(10.0f);
            updateProgress(0.0f);
        }

        /* synthetic */ TransitionDrawable(PathMotion r1, View r2, RectF r3, ShapeAppearanceModel r4, float r5, View r6, RectF r7, ShapeAppearanceModel r8, float r9, int r10, int r11, int r12, int r13, boolean r14, boolean r15, FadeModeEvaluator r16, FitModeEvaluator r17, ProgressThresholdsGroup r18, boolean r19, AnonymousClass1 r20) {
            this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
        }

        static /* synthetic */ void access$200(TransitionDrawable r0, float r1) {
            r0.setProgress(r1);
        }

        static /* synthetic */ View access$800(TransitionDrawable r0) {
            return r0.startView;
        }

        static /* synthetic */ View access$900(TransitionDrawable r0) {
            return r0.endView;
        }

        private static float calculateElevationDxMultiplier(RectF r1, float r2) {
            return ((r1.centerX() / (r2 / 2.0f)) - 1.0f) * SHADOW_DX_MULTIPLIER_ADJUSTMENT;
        }

        private static float calculateElevationDyMultiplier(RectF r0, float r1) {
            return (r0.centerY() / r1) * SHADOW_DY_MULTIPLIER_ADJUSTMENT;
        }

        private void drawDebugCumulativePath(Canvas r3, RectF r4, Path r5, @ColorInt int r6) {
            PointF r7 = getMotionPathPoint(r4);
            if (this.progress != 0.0f) goto L5;
            r5.reset();
            r5.moveTo(r7.x, r7.y);
            return;
        L5:
            r5.lineTo(r7.x, r7.y);
            this.debugPaint.setColor(r6);
            r3.drawPath(r5, this.debugPaint);
        }

        private void drawDebugRect(Canvas r2, RectF r3, @ColorInt int r4) {
            this.debugPaint.setColor(r4);
            r2.drawRect(r3, this.debugPaint);
        }

        private void drawElevationShadow(Canvas r3) {
            r3.save();
            r3.clipPath(this.maskEvaluator.getPath(), Region.Op.DIFFERENCE);
            if (Build.VERSION.SDK_INT <= 28) goto L5;
            drawElevationShadowWithPaintShadowLayer(r3);
        L6:
            r3.restore();
            return;
        L5:
            drawElevationShadowWithMaterialShapeDrawable(r3);
            goto L6
        }

        private void drawElevationShadowWithMaterialShapeDrawable(Canvas r6) {
            MaterialShapeDrawable r0 = this.compatShadowDrawable;
            RectF r1 = this.currentMaskBounds;
            r0.setBounds((int) r1.left, (int) r1.top, (int) r1.right, (int) r1.bottom);
            this.compatShadowDrawable.setElevation(this.currentElevation);
            this.compatShadowDrawable.setShadowVerticalOffset((int) this.currentElevationDy);
            this.compatShadowDrawable.setShapeAppearanceModel(this.maskEvaluator.getCurrentShapeAppearanceModel());
            this.compatShadowDrawable.draw(r6);
        }

        private void drawElevationShadowWithPaintShadowLayer(Canvas r3) {
            ShapeAppearanceModel r0 = this.maskEvaluator.getCurrentShapeAppearanceModel();
            if (r0.isRoundRect(this.currentMaskBounds) == false) goto L5;
            float r1 = r0.getTopLeftCornerSize().getCornerSize(this.currentMaskBounds);
            r3.drawRoundRect(this.currentMaskBounds, r1, r1, this.shadowPaint);
            return;
        L5:
            r3.drawPath(this.maskEvaluator.getPath(), this.shadowPaint);
        }

        private void drawEndView(Canvas r9) {
            maybeDrawContainerColor(r9, this.endContainerPaint);
            Rect r2 = getBounds();
            RectF r0 = this.currentEndBounds;
            TransitionUtils.transform(r9, r2, r0.left, r0.top, this.fitModeResult.endScale, this.fadeModeResult.endAlpha, new AnonymousClass2(this));
        }

        private void drawStartView(Canvas r9) {
            maybeDrawContainerColor(r9, this.startContainerPaint);
            Rect r2 = getBounds();
            RectF r0 = this.currentStartBounds;
            TransitionUtils.transform(r9, r2, r0.left, r0.top, this.fitModeResult.startScale, this.fadeModeResult.startAlpha, new AnonymousClass1(this));
        }

        private static PointF getMotionPathPoint(RectF r2) {
            return new PointF(r2.centerX(), r2.top);
        }

        private void maybeDrawContainerColor(Canvas r2, Paint r3) {
            if (r3.getColor() != 0) goto L5;
            return;
        L5:
            if (r3.getAlpha() <= 0) goto L9;
            r2.drawRect(getBounds(), r3);
            return;
        }

        private void setProgress(float r2) {
            if (this.progress == r2) goto L6;
            updateProgress(r2);
            return;
        }

        private void updateProgress(float r13) {
            this.progress = r13;
            Paint r0 = this.scrimPaint;
            if (this.entering == false) goto L5;
            float r1 = TransitionUtils.lerp(0.0f, 255.0f, r13);
        L6:
            r0.setAlpha((int) r1);
            this.motionPathMeasure.getPosTan(this.motionPathLength * r13, this.motionPathPosition, null);
            float[] r2 = this.motionPathPosition;
            float r3 = r2[0];
            float r5 = r2[1];
            if (r13 <= 1.0f) goto L9;
        L12:
            if (r13 <= 1.0f) goto L14;
            float r6 = 0.99f;
            float r7 = (r13 - 1.0f) / 0.00999999f;
        L15:
            this.motionPathMeasure.getPosTan(this.motionPathLength * r6, r2, null);
            float[] r4 = this.motionPathPosition;
            r3 = r3 + ((r3 - r4[0]) * r7);
            r5 = r5 + ((r5 - r4[1]) * r7);
        L11:
            float r10 = r3;
            float r11 = r5;
            FitModeResult r8 = this.fitModeEvaluator.evaluate(r13, ((Float) Preconditions.checkNotNull(Float.valueOf(ProgressThresholds.access$1000(ProgressThresholdsGroup.access$500(this.progressThresholds))))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(ProgressThresholds.access$1100(ProgressThresholdsGroup.access$500(this.progressThresholds))))).floatValue(), this.startBounds.width(), this.startBounds.height(), this.endBounds.width(), this.endBounds.height());
            this.fitModeResult = r8;
            RectF r9 = this.currentStartBounds;
            float r12 = r8.currentStartWidth;
            r9.set(r10 - (r12 / 2.0f), r11, (r12 / 2.0f) + r10, r8.currentStartHeight + r11);
            RectF r14 = this.currentEndBounds;
            FitModeResult r15 = this.fitModeResult;
            float r16 = r15.currentEndWidth;
            r14.set(r10 - (r16 / 2.0f), r11, r10 + (r16 / 2.0f), r15.currentEndHeight + r11);
            this.currentStartBoundsMasked.set(this.currentStartBounds);
            this.currentEndBoundsMasked.set(this.currentEndBounds);
            float r17 = ((Float) Preconditions.checkNotNull(Float.valueOf(ProgressThresholds.access$1000(ProgressThresholdsGroup.access$600(this.progressThresholds))))).floatValue();
            float r18 = ((Float) Preconditions.checkNotNull(Float.valueOf(ProgressThresholds.access$1100(ProgressThresholdsGroup.access$600(this.progressThresholds))))).floatValue();
            boolean r19 = this.fitModeEvaluator.shouldMaskStartBounds(this.fitModeResult);
            if (r19 == false) goto L19;
            RectF r20 = this.currentStartBoundsMasked;
        L20:
            float r21 = TransitionUtils.lerp(0.0f, 1.0f, r17, r18, r13);
            if (r19 == true) goto L24;
            r21 = 1.0f - r21;
        L24:
            this.fitModeEvaluator.applyMask(r20, r21, this.fitModeResult);
            this.currentMaskBounds = new RectF(Math.min(this.currentStartBoundsMasked.left, this.currentEndBoundsMasked.left), Math.min(this.currentStartBoundsMasked.top, this.currentEndBoundsMasked.top), Math.max(this.currentStartBoundsMasked.right, this.currentEndBoundsMasked.right), Math.max(this.currentStartBoundsMasked.bottom, this.currentEndBoundsMasked.bottom));
            this.maskEvaluator.evaluate(r13, this.startShapeAppearanceModel, this.endShapeAppearanceModel, this.currentStartBounds, this.currentStartBoundsMasked, this.currentEndBoundsMasked, ProgressThresholdsGroup.access$700(this.progressThresholds));
            this.currentElevation = TransitionUtils.lerp(this.startElevation, this.endElevation, r13);
            float r22 = calculateElevationDxMultiplier(this.currentMaskBounds, this.displayWidth);
            float r23 = calculateElevationDyMultiplier(this.currentMaskBounds, this.displayHeight);
            float r24 = this.currentElevation;
            float r25 = (int) (r23 * r24);
            this.currentElevationDy = r25;
            this.shadowPaint.setShadowLayer(r24, (int) (r22 * r24), r25, SHADOW_COLOR);
            this.fadeModeResult = this.fadeModeEvaluator.evaluate(r13, ((Float) Preconditions.checkNotNull(Float.valueOf(ProgressThresholds.access$1000(ProgressThresholdsGroup.access$400(this.progressThresholds))))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(ProgressThresholds.access$1100(ProgressThresholdsGroup.access$400(this.progressThresholds))))).floatValue(), 0.35f);
            if (this.startContainerPaint.getColor() == 0) goto L28;
            this.startContainerPaint.setAlpha(this.fadeModeResult.startAlpha);
        L28:
            if (this.endContainerPaint.getColor() == 0) goto L30;
            this.endContainerPaint.setAlpha(this.fadeModeResult.endAlpha);
        L30:
            invalidateSelf();
            return;
        L19:
            r20 = this.currentEndBoundsMasked;
            goto L20
        L14:
            r6 = 0.01f;
            r7 = (r13 / 0.01f) * MaterialContainerTransform.ELEVATION_NOT_SET;
            goto L15
        L9:
            if (r13 >= 0.0f) goto L11;
        L5:
            r1 = TransitionUtils.lerp(255.0f, 0.0f, r13);
            goto L6
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas r4) {
            if (this.scrimPaint.getAlpha() <= 0) goto L6;
            r4.drawRect(getBounds(), this.scrimPaint);
        L6:
            if (this.drawDebugEnabled == false) goto L8;
            int r0 = r4.save();
        L10:
            if (this.elevationShadowEnabled == true) goto L12;
        L14:
            this.maskEvaluator.clip(r4);
            maybeDrawContainerColor(r4, this.containerPaint);
            if (this.fadeModeResult.endOnTop == false) goto L17;
            drawStartView(r4);
            drawEndView(r4);
        L19:
            if (this.drawDebugEnabled == false) goto L22;
            r4.restoreToCount(r0);
            drawDebugCumulativePath(r4, this.currentStartBounds, this.debugPath, -65281);
            drawDebugRect(r4, this.currentStartBoundsMasked, InputDeviceCompat.SOURCE_ANY);
            drawDebugRect(r4, this.currentStartBounds, -16711936);
            drawDebugRect(r4, this.currentEndBoundsMasked, -16711681);
            drawDebugRect(r4, this.currentEndBounds, -16776961);
            return;
        L22:
            return;
        L17:
            drawEndView(r4);
            drawStartView(r4);
            goto L19
        L12:
            if (this.currentElevation <= 0.0f) goto L14;
            drawElevationShadow(r4);
            goto L14
        L8:
            r0 = -1;
            goto L10
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int r1) {
            throw new UnsupportedOperationException("Setting alpha on is not supported");
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@Nullable ColorFilter r1) {
            throw new UnsupportedOperationException("Setting a color filter is not supported");
        }
    }

    static {
        TAG = MaterialContainerTransform.class.getSimpleName();
        TRANSITION_PROPS = new String[]{PROP_BOUNDS, PROP_SHAPE_APPEARANCE};
        DEFAULT_ENTER_THRESHOLDS = new ProgressThresholdsGroup(new ProgressThresholds(0.0f, 0.25f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.75f), null);
        AnonymousClass1 r14 = null;
        DEFAULT_RETURN_THRESHOLDS = new ProgressThresholdsGroup(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.3f, 0.9f), r14);
        DEFAULT_ENTER_THRESHOLDS_ARC = new ProgressThresholdsGroup(new ProgressThresholds(0.1f, 0.4f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 0.9f), null);
        DEFAULT_RETURN_THRESHOLDS_ARC = new ProgressThresholdsGroup(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.2f, 0.9f), r14);
    }

    public MaterialContainerTransform() {
        boolean r0 = false;
        this.drawDebugEnabled = false;
        this.holdAtEndEnabled = false;
        this.pathMotionCustom = false;
        this.appliedThemeValues = false;
        this.drawingViewId = R.id.content;
        this.startViewId = -1;
        this.endViewId = -1;
        this.containerColor = 0;
        this.startContainerColor = 0;
        this.endContainerColor = 0;
        this.scrimColor = 1375731712;
        this.transitionDirection = 0;
        this.fadeMode = 0;
        this.fitMode = 0;
        if (Build.VERSION.SDK_INT < 28) goto L5;
        r0 = true;
    L5:
        this.elevationShadowEnabled = r0;
        this.startElevation = ELEVATION_NOT_SET;
        this.endElevation = ELEVATION_NOT_SET;
    }

    public MaterialContainerTransform(@NonNull Context r5, boolean r6) {
        boolean r0 = false;
        this.drawDebugEnabled = false;
        this.holdAtEndEnabled = false;
        this.pathMotionCustom = false;
        this.appliedThemeValues = false;
        this.drawingViewId = R.id.content;
        this.startViewId = -1;
        this.endViewId = -1;
        this.containerColor = 0;
        this.startContainerColor = 0;
        this.endContainerColor = 0;
        this.scrimColor = 1375731712;
        this.transitionDirection = 0;
        this.fadeMode = 0;
        this.fitMode = 0;
        if (Build.VERSION.SDK_INT < 28) goto L5;
        r0 = true;
    L5:
        this.elevationShadowEnabled = r0;
        this.startElevation = ELEVATION_NOT_SET;
        this.endElevation = ELEVATION_NOT_SET;
        maybeApplyThemeValues(r5, r6);
        this.appliedThemeValues = true;
    }

    static /* synthetic */ boolean access$300(MaterialContainerTransform r0) {
        return r0.holdAtEndEnabled;
    }

    private ProgressThresholdsGroup buildThresholdsGroup(boolean r3) {
        PathMotion r0 = getPathMotion();
        if ((r0 instanceof ArcMotion) == false) goto L5;
    L10:
        ProgressThresholdsGroup r1 = DEFAULT_ENTER_THRESHOLDS_ARC;
        ProgressThresholdsGroup r2 = DEFAULT_RETURN_THRESHOLDS_ARC;
    L9:
        return getThresholdsOrDefault(r3, r1, r2);
    L5:
        if ((r0 instanceof MaterialArcMotion) == true) goto L10;
        r1 = DEFAULT_ENTER_THRESHOLDS;
        r2 = DEFAULT_RETURN_THRESHOLDS;
        goto L9
    }

    private static RectF calculateDrawableBounds(View r0, @Nullable View r1, float r2, float r3) {
        if (r1 == null) goto L6;
        RectF r4 = TransitionUtils.getLocationOnScreen(r1);
        r4.offset(r2, r3);
        return r4;
    L6:
        return new RectF(0.0f, 0.0f, r0.getWidth(), r0.getHeight());
    }

    private static ShapeAppearanceModel captureShapeAppearance(@NonNull View r0, @NonNull RectF r1, @Nullable ShapeAppearanceModel r2) {
        return TransitionUtils.convertToRelativeCornerSizes(getShapeAppearance(r0, r2), r1);
    }

    private static void captureValues(@NonNull TransitionValues r2, @Nullable View r3, @IdRes int r4, @Nullable ShapeAppearanceModel r5) {
        if (r4 == (-1)) goto L6;
        r3 = TransitionUtils.findDescendantOrAncestorById(r2.view, r4);
    L5:
        r2.view = r3;
    L11:
        View r6 = r2.view;
        if (ViewCompat.isLaidOut(r6) == true) goto L18;
        if (r6.getWidth() != 0) goto L18;
        if (r6.getHeight() != 0) goto L18;
        return;
    L18:
        if (r6.getParent() != null) goto L20;
        RectF r7 = TransitionUtils.getRelativeBounds(r6);
    L21:
        r2.values.put(PROP_BOUNDS, r7);
        r2.values.put(PROP_SHAPE_APPEARANCE, captureShapeAppearance(r6, r7, r5));
        return;
    L20:
        r7 = TransitionUtils.getLocationOnScreen(r6);
        goto L21
    L6:
        if (r3 != null) goto L5;
        View r8 = r2.view;
        int r9 = com.google.android.material.R.id.mtrl_motion_snapshot_view;
        if ((r8.getTag(r9) instanceof View) == false) goto L11;
        r3 = (View) r2.view.getTag(r9);
        r2.view.setTag(r9, null);
        goto L5
    }

    private static float getElevationOrDefault(float r1, View r2) {
        if (r1 == ELEVATION_NOT_SET) goto L6;
        return r1;
    L6:
        return ViewCompat.getElevation(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static ShapeAppearanceModel getShapeAppearance(@NonNull View r2, @Nullable ShapeAppearanceModel r3) {
        if (r3 == null) goto L4;
        return r3;
    L4:
        int r4 = com.google.android.material.R.id.mtrl_motion_snapshot_view;
        if ((r2.getTag(r4) instanceof ShapeAppearanceModel) == true) goto L7;
        Context r5 = r2.getContext();
        int r0 = getTransitionShapeAppearanceResId(r5);
        if (r0 == (-1)) goto L13;
        return ShapeAppearanceModel.builder(r5, r0, 0).build();
    L13:
        if ((r2 instanceof Shapeable) == false) goto L17;
        return ((Shapeable) r2).getShapeAppearanceModel();
    L17:
        return ShapeAppearanceModel.builder().build();
    L7:
        return (ShapeAppearanceModel) r2.getTag(r4);
    }

    private ProgressThresholdsGroup getThresholdsOrDefault(boolean r7, ProgressThresholdsGroup r8, ProgressThresholdsGroup r9) {
        if (r7 == true) goto L6;
        r8 = r9;
    L6:
        return new ProgressThresholdsGroup((ProgressThresholds) TransitionUtils.defaultIfNull(this.fadeProgressThresholds, ProgressThresholdsGroup.access$400(r8)), (ProgressThresholds) TransitionUtils.defaultIfNull(this.scaleProgressThresholds, ProgressThresholdsGroup.access$500(r8)), (ProgressThresholds) TransitionUtils.defaultIfNull(this.scaleMaskProgressThresholds, ProgressThresholdsGroup.access$600(r8)), (ProgressThresholds) TransitionUtils.defaultIfNull(this.shapeMaskProgressThresholds, ProgressThresholdsGroup.access$700(r8)), null);
    }

    @StyleRes
    private static int getTransitionShapeAppearanceResId(Context r3) {
        TypedArray r4 = r3.obtainStyledAttributes(new int[]{com.google.android.material.R.attr.transitionShapeAppearance});
        int r0 = r4.getResourceId(0, -1);
        r4.recycle();
        return r0;
    }

    private boolean isEntering(@NonNull RectF r4, @NonNull RectF r5) {
        int r0 = this.transitionDirection;
        if (r0 == 0) goto L12;
        if (r0 != 1) goto L6;
        return true;
    L6:
        if (r0 != 2) goto L9;
        return false;
    L9:
        throw new IllegalArgumentException("Invalid transition direction: " + this.transitionDirection);
    L12:
        if (TransitionUtils.calculateArea(r5) > TransitionUtils.calculateArea(r4)) goto L14;
        return false;
    L14:
        return true;
    }

    private void maybeApplyThemeValues(Context r3, boolean r4) {
        TransitionUtils.maybeApplyThemeInterpolator(this, r3, com.google.android.material.R.attr.motionEasingStandard, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        if (r4 == false) goto L5;
        int r5 = com.google.android.material.R.attr.motionDurationLong1;
    L6:
        TransitionUtils.maybeApplyThemeDuration(this, r3, r5);
        if (this.pathMotionCustom == true) goto L10;
        TransitionUtils.maybeApplyThemePath(this, r3, com.google.android.material.R.attr.motionPath);
        return;
    L10:
        return;
    L5:
        r5 = com.google.android.material.R.attr.motionDurationMedium2;
        goto L6
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues r3) {
        captureValues(r3, this.endView, this.endViewId, this.endShapeAppearanceModel);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues r3) {
        captureValues(r3, this.startView, this.startViewId, this.startShapeAppearanceModel);
    }

    @Override // androidx.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup r30, @Nullable TransitionValues r31, @Nullable TransitionValues r32) {
        if (r31 == null) goto L31;
        if (r32 == null) goto L31;
        RectF r10 = (RectF) r31.values.get(PROP_BOUNDS);
        ShapeAppearanceModel r11 = (ShapeAppearanceModel) r31.values.get(PROP_SHAPE_APPEARANCE);
        if (r10 == null) goto L30;
        if (r11 == null) goto L30;
        RectF r14 = (RectF) r32.values.get(PROP_BOUNDS);
        ShapeAppearanceModel r15 = (ShapeAppearanceModel) r32.values.get(PROP_SHAPE_APPEARANCE);
        if (r14 == null) goto L27;
        if (r15 == null) goto L27;
        final View r4 = r31.view;
        final View r5 = r32.view;
        if (r5.getParent() == null) goto L17;
        View r0 = r5;
    L19:
        if (this.drawingViewId != r0.getId()) goto L21;
        final View r2 = (View) r0.getParent();
        View r1 = r0;
    L22:
        RectF r3 = TransitionUtils.getLocationOnScreen(r2);
        float r7 = -r3.left;
        float r6 = -r3.top;
        RectF r8 = calculateDrawableBounds(r2, r1, r7, r6);
        r10.offset(r7, r6);
        r14.offset(r7, r6);
        boolean r9 = isEntering(r10, r14);
        if (this.appliedThemeValues == true) goto L25;
        maybeApplyThemeValues(r0.getContext(), r9);
    L25:
        final TransitionDrawable r12 = new TransitionDrawable(getPathMotion(), r4, r10, r11, getElevationOrDefault(this.startElevation, r4), r5, r14, r15, getElevationOrDefault(this.endElevation, r5), this.containerColor, this.startContainerColor, this.endContainerColor, this.scrimColor, r9, this.elevationShadowEnabled, FadeModeEvaluators.get(this.fadeMode, r9), FitModeEvaluators.get(this.fitMode, r9, r10, r14), buildThresholdsGroup(r9), this.drawDebugEnabled, null);
        r12.setBounds(Math.round(r8.left), Math.round(r8.top), Math.round(r8.right), Math.round(r8.bottom));
        ValueAnimator r13 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r13.addUpdateListener(new AnonymousClass1(this, r12));
        addListener(new AnonymousClass2(this, r2, r12, r4, r5));
        return r13;
    L21:
        r2 = TransitionUtils.findAncestorById(r0, this.drawingViewId);
        r1 = null;
        goto L22
    L17:
        r0 = r4;
    L27:
        String r16 = TAG;
        String r17 = "Skipping due to null end bounds. Ensure end view is laid out and measured.";
    L28:
        Log.w(r16, r17);
        return null;
    L30:
        r16 = TAG;
        r17 = "Skipping due to null start bounds. Ensure start view is laid out and measured.";
    L31:
        return null;
    }

    @ColorInt
    public int getContainerColor() {
        return this.containerColor;
    }

    @IdRes
    public int getDrawingViewId() {
        return this.drawingViewId;
    }

    @ColorInt
    public int getEndContainerColor() {
        return this.endContainerColor;
    }

    public float getEndElevation() {
        return this.endElevation;
    }

    @Nullable
    public ShapeAppearanceModel getEndShapeAppearanceModel() {
        return this.endShapeAppearanceModel;
    }

    @Nullable
    public View getEndView() {
        return this.endView;
    }

    @IdRes
    public int getEndViewId() {
        return this.endViewId;
    }

    public int getFadeMode() {
        return this.fadeMode;
    }

    @Nullable
    public ProgressThresholds getFadeProgressThresholds() {
        return this.fadeProgressThresholds;
    }

    public int getFitMode() {
        return this.fitMode;
    }

    @Nullable
    public ProgressThresholds getScaleMaskProgressThresholds() {
        return this.scaleMaskProgressThresholds;
    }

    @Nullable
    public ProgressThresholds getScaleProgressThresholds() {
        return this.scaleProgressThresholds;
    }

    @ColorInt
    public int getScrimColor() {
        return this.scrimColor;
    }

    @Nullable
    public ProgressThresholds getShapeMaskProgressThresholds() {
        return this.shapeMaskProgressThresholds;
    }

    @ColorInt
    public int getStartContainerColor() {
        return this.startContainerColor;
    }

    public float getStartElevation() {
        return this.startElevation;
    }

    @Nullable
    public ShapeAppearanceModel getStartShapeAppearanceModel() {
        return this.startShapeAppearanceModel;
    }

    @Nullable
    public View getStartView() {
        return this.startView;
    }

    @IdRes
    public int getStartViewId() {
        return this.startViewId;
    }

    public int getTransitionDirection() {
        return this.transitionDirection;
    }

    @Override // androidx.transition.Transition
    @Nullable
    public String[] getTransitionProperties() {
        return TRANSITION_PROPS;
    }

    public boolean isDrawDebugEnabled() {
        return this.drawDebugEnabled;
    }

    public boolean isElevationShadowEnabled() {
        return this.elevationShadowEnabled;
    }

    public boolean isHoldAtEndEnabled() {
        return this.holdAtEndEnabled;
    }

    public void setAllContainerColors(@ColorInt int r1) {
        this.containerColor = r1;
        this.startContainerColor = r1;
        this.endContainerColor = r1;
    }

    public void setContainerColor(@ColorInt int r1) {
        this.containerColor = r1;
    }

    public void setDrawDebugEnabled(boolean r1) {
        this.drawDebugEnabled = r1;
    }

    public void setDrawingViewId(@IdRes int r1) {
        this.drawingViewId = r1;
    }

    public void setElevationShadowEnabled(boolean r1) {
        this.elevationShadowEnabled = r1;
    }

    public void setEndContainerColor(@ColorInt int r1) {
        this.endContainerColor = r1;
    }

    public void setEndElevation(float r1) {
        this.endElevation = r1;
    }

    public void setEndShapeAppearanceModel(@Nullable ShapeAppearanceModel r1) {
        this.endShapeAppearanceModel = r1;
    }

    public void setEndView(@Nullable View r1) {
        this.endView = r1;
    }

    public void setEndViewId(@IdRes int r1) {
        this.endViewId = r1;
    }

    public void setFadeMode(int r1) {
        this.fadeMode = r1;
    }

    public void setFadeProgressThresholds(@Nullable ProgressThresholds r1) {
        this.fadeProgressThresholds = r1;
    }

    public void setFitMode(int r1) {
        this.fitMode = r1;
    }

    public void setHoldAtEndEnabled(boolean r1) {
        this.holdAtEndEnabled = r1;
    }

    @Override // androidx.transition.Transition
    public void setPathMotion(@Nullable PathMotion r1) {
        super.setPathMotion(r1);
        this.pathMotionCustom = true;
    }

    public void setScaleMaskProgressThresholds(@Nullable ProgressThresholds r1) {
        this.scaleMaskProgressThresholds = r1;
    }

    public void setScaleProgressThresholds(@Nullable ProgressThresholds r1) {
        this.scaleProgressThresholds = r1;
    }

    public void setScrimColor(@ColorInt int r1) {
        this.scrimColor = r1;
    }

    public void setShapeMaskProgressThresholds(@Nullable ProgressThresholds r1) {
        this.shapeMaskProgressThresholds = r1;
    }

    public void setStartContainerColor(@ColorInt int r1) {
        this.startContainerColor = r1;
    }

    public void setStartElevation(float r1) {
        this.startElevation = r1;
    }

    public void setStartShapeAppearanceModel(@Nullable ShapeAppearanceModel r1) {
        this.startShapeAppearanceModel = r1;
    }

    public void setStartView(@Nullable View r1) {
        this.startView = r1;
    }

    public void setStartViewId(@IdRes int r1) {
        this.startViewId = r1;
    }

    public void setTransitionDirection(int r1) {
        this.transitionDirection = r1;
    }
}
