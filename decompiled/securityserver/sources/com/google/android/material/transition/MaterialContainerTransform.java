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
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
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

/* JADX INFO: loaded from: classes.dex */
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
    private static final String TAG = "MaterialContainerTransform";
    public static final int TRANSITION_DIRECTION_AUTO = 0;
    public static final int TRANSITION_DIRECTION_ENTER = 1;
    public static final int TRANSITION_DIRECTION_RETURN = 2;
    private static final String[] TRANSITION_PROPS = null;

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

        public static /* synthetic */ float access$1000(ProgressThresholds r0) {
            return r0.start;
        }

        public static /* synthetic */ float access$1100(ProgressThresholds r0) {
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

    public static class ProgressThresholdsGroup {

        @NonNull
        private final ProgressThresholds fade;

        @NonNull
        private final ProgressThresholds scale;

        @NonNull
        private final ProgressThresholds scaleMask;

        @NonNull
        private final ProgressThresholds shapeMask;

        public /* synthetic */ ProgressThresholdsGroup(ProgressThresholds r1, ProgressThresholds r2, ProgressThresholds r3, ProgressThresholds r4, AnonymousClass1 r5) {
            this(r1, r2, r3, r4);
        }

        public static /* synthetic */ ProgressThresholds access$400(ProgressThresholdsGroup r0) {
            return r0.fade;
        }

        public static /* synthetic */ ProgressThresholds access$500(ProgressThresholdsGroup r0) {
            return r0.scale;
        }

        public static /* synthetic */ ProgressThresholds access$600(ProgressThresholdsGroup r0) {
            return r0.scaleMask;
        }

        public static /* synthetic */ ProgressThresholds access$700(ProgressThresholdsGroup r0) {
            return r0.shapeMask;
        }

        private ProgressThresholdsGroup(@NonNull ProgressThresholds r1, @NonNull ProgressThresholds r2, @NonNull ProgressThresholds r3, @NonNull ProgressThresholds r4) {
            this.fade = r1;
            this.scale = r2;
            this.scaleMask = r3;
            this.shapeMask = r4;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TransitionDirection {
    }

    public static final class TransitionDrawable extends Drawable {
        private static final int COMPAT_SHADOW_COLOR = -7829368;
        private static final float COMPAT_SHADOW_OFFSET_MULTIPLIER = 0.75f;
        private static final int SHADOW_COLOR = 754974720;
        private final MaterialShapeDrawable compatShadowDrawable;
        private final Paint containerPaint;
        private float currentElevation;
        private final RectF currentEndBounds;
        private final RectF currentEndBoundsMasked;
        private RectF currentMaskBounds;
        private final RectF currentStartBounds;
        private final RectF currentStartBoundsMasked;
        private final Paint debugPaint;
        private final Path debugPath;
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

        public /* synthetic */ TransitionDrawable(PathMotion r1, View r2, RectF r3, ShapeAppearanceModel r4, float r5, View r6, RectF r7, ShapeAppearanceModel r8, float r9, int r10, int r11, int r12, int r13, boolean r14, boolean r15, FadeModeEvaluator r16, FitModeEvaluator r17, ProgressThresholdsGroup r18, boolean r19, AnonymousClass1 r20) {
            this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
        }

        public static /* synthetic */ void access$200(TransitionDrawable r0, float r1) {
            r0.setProgress(r1);
        }

        public static /* synthetic */ View access$800(TransitionDrawable r0) {
            return r0.startView;
        }

        public static /* synthetic */ View access$900(TransitionDrawable r0) {
            return r0.endView;
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
            drawElevationShadowWithPaintShadowLayer(r3);
            r3.restore();
        }

        private void drawElevationShadowWithMaterialShapeDrawable(Canvas r6) {
            MaterialShapeDrawable r0 = this.compatShadowDrawable;
            RectF r1 = this.currentMaskBounds;
            r0.setBounds((int) r1.left, (int) r1.top, (int) r1.right, (int) r1.bottom);
            this.compatShadowDrawable.setElevation(this.currentElevation);
            this.compatShadowDrawable.setShadowVerticalOffset((int) (this.currentElevation * COMPAT_SHADOW_OFFSET_MULTIPLIER));
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

        private void updateProgress(float r14) {
            this.progress = r14;
            Paint r0 = this.scrimPaint;
            if (this.entering == false) goto L5;
            float r1 = TransitionUtils.lerp(0.0f, 255.0f, r14);
        L6:
            r0.setAlpha((int) r1);
            float r2 = TransitionUtils.lerp(this.startElevation, this.endElevation, r14);
            this.currentElevation = r2;
            this.shadowPaint.setShadowLayer(r2, 0.0f, r2, SHADOW_COLOR);
            this.motionPathMeasure.getPosTan(this.motionPathLength * r14, this.motionPathPosition, null);
            float[] r3 = this.motionPathPosition;
            float r4 = r3[0];
            float r5 = r3[1];
            float r6 = ((Float) Preconditions.checkNotNull(Float.valueOf(ProgressThresholds.access$1000(ProgressThresholdsGroup.access$500(this.progressThresholds))))).floatValue();
            float r7 = ((Float) Preconditions.checkNotNull(Float.valueOf(ProgressThresholds.access$1100(ProgressThresholdsGroup.access$500(this.progressThresholds))))).floatValue();
            FitModeResult r8 = this.fitModeEvaluator.evaluate(r14, r6, r7, this.startBounds.width(), this.startBounds.height(), this.endBounds.width(), this.endBounds.height());
            this.fitModeResult = r8;
            RectF r9 = this.currentStartBounds;
            float r10 = r8.currentStartWidth;
            r9.set(r4 - (r10 / 2.0f), r5, (r10 / 2.0f) + r4, r8.currentStartHeight + r5);
            RectF r11 = this.currentEndBounds;
            FitModeResult r12 = this.fitModeResult;
            float r13 = r12.currentEndWidth;
            r11.set(r4 - (r13 / 2.0f), r5, (r13 / 2.0f) + r4, r12.currentEndHeight + r5);
            this.currentStartBoundsMasked.set(this.currentStartBounds);
            this.currentEndBoundsMasked.set(this.currentEndBounds);
            float r15 = ((Float) Preconditions.checkNotNull(Float.valueOf(ProgressThresholds.access$1000(ProgressThresholdsGroup.access$600(this.progressThresholds))))).floatValue();
            float r16 = ((Float) Preconditions.checkNotNull(Float.valueOf(ProgressThresholds.access$1100(ProgressThresholdsGroup.access$600(this.progressThresholds))))).floatValue();
            boolean r17 = this.fitModeEvaluator.shouldMaskStartBounds(this.fitModeResult);
            if (r17 == false) goto L9;
            RectF r18 = this.currentStartBoundsMasked;
        L10:
            float r19 = TransitionUtils.lerp(0.0f, 1.0f, r15, r16, r14);
            if (r17 == true) goto L14;
            r19 = 1.0f - r19;
        L14:
            this.fitModeEvaluator.applyMask(r18, r19, this.fitModeResult);
            this.currentMaskBounds = new RectF(Math.min(this.currentStartBoundsMasked.left, this.currentEndBoundsMasked.left), Math.min(this.currentStartBoundsMasked.top, this.currentEndBoundsMasked.top), Math.max(this.currentStartBoundsMasked.right, this.currentEndBoundsMasked.right), Math.max(this.currentStartBoundsMasked.bottom, this.currentEndBoundsMasked.bottom));
            this.maskEvaluator.evaluate(r14, this.startShapeAppearanceModel, this.endShapeAppearanceModel, this.currentStartBounds, this.currentStartBoundsMasked, this.currentEndBoundsMasked, ProgressThresholdsGroup.access$700(this.progressThresholds));
            float r20 = ((Float) Preconditions.checkNotNull(Float.valueOf(ProgressThresholds.access$1000(ProgressThresholdsGroup.access$400(this.progressThresholds))))).floatValue();
            float r21 = ((Float) Preconditions.checkNotNull(Float.valueOf(ProgressThresholds.access$1100(ProgressThresholdsGroup.access$400(this.progressThresholds))))).floatValue();
            this.fadeModeResult = this.fadeModeEvaluator.evaluate(r14, r20, r21);
            if (this.startContainerPaint.getColor() == 0) goto L18;
            this.startContainerPaint.setAlpha(this.fadeModeResult.startAlpha);
        L18:
            if (this.endContainerPaint.getColor() == 0) goto L20;
            this.endContainerPaint.setAlpha(this.fadeModeResult.endAlpha);
        L20:
            invalidateSelf();
            return;
        L9:
            r18 = this.currentEndBoundsMasked;
            goto L10
        L5:
            r1 = TransitionUtils.lerp(255.0f, 0.0f, r14);
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

        private TransitionDrawable(PathMotion r13, View r14, RectF r15, ShapeAppearanceModel r16, float r17, View r18, RectF r19, ShapeAppearanceModel r20, float r21, @ColorInt int r22, @ColorInt int r23, @ColorInt int r24, int r25, boolean r26, boolean r27, FadeModeEvaluator r28, FitModeEvaluator r29, ProgressThresholdsGroup r30, boolean r31) {
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
            this.motionPathPosition = new float[]{r15.centerX(), r15.top};
            MaterialShapeDrawable r8 = new MaterialShapeDrawable();
            this.compatShadowDrawable = r8;
            Paint r9 = new Paint();
            this.debugPaint = r9;
            this.debugPath = new Path();
            this.startView = r14;
            this.startBounds = r15;
            this.startShapeAppearanceModel = r16;
            this.startElevation = r17;
            this.endView = r18;
            this.endBounds = r19;
            this.endShapeAppearanceModel = r20;
            this.endElevation = r21;
            this.entering = r26;
            this.elevationShadowEnabled = r27;
            this.fadeModeEvaluator = r28;
            this.fitModeEvaluator = r29;
            this.progressThresholds = r30;
            this.drawDebugEnabled = r31;
            r2.setColor(r22);
            r3.setColor(r23);
            r4.setColor(r24);
            r8.setFillColor(ColorStateList.valueOf(0));
            r8.setShadowCompatibilityMode(2);
            r8.setShadowBitmapDrawingEnable(false);
            r8.setShadowColor(COMPAT_SHADOW_COLOR);
            RectF r6 = new RectF(r15);
            this.currentStartBounds = r6;
            this.currentStartBoundsMasked = new RectF(r6);
            RectF r7 = new RectF(r6);
            this.currentEndBounds = r7;
            this.currentEndBoundsMasked = new RectF(r7);
            PointF r10 = getMotionPathPoint(r15);
            PointF r11 = getMotionPathPoint(r19);
            PathMeasure r12 = new PathMeasure(r13.getPath(r10.x, r10.y, r11.x, r11.y), false);
            this.motionPathMeasure = r12;
            this.motionPathLength = r12.getLength();
            r5.setStyle(Paint.Style.FILL);
            r5.setShader(TransitionUtils.createColorShader(r25));
            r9.setStyle(Paint.Style.STROKE);
            r9.setStrokeWidth(10.0f);
            updateProgress(0.0f);
        }
    }

    static {
        TRANSITION_PROPS = new String[]{PROP_BOUNDS, PROP_SHAPE_APPEARANCE};
        DEFAULT_ENTER_THRESHOLDS = new ProgressThresholdsGroup(new ProgressThresholds(0.0f, 0.25f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.75f), null);
        AnonymousClass1 r14 = null;
        DEFAULT_RETURN_THRESHOLDS = new ProgressThresholdsGroup(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.3f, 0.9f), r14);
        DEFAULT_ENTER_THRESHOLDS_ARC = new ProgressThresholdsGroup(new ProgressThresholds(0.1f, 0.4f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 0.9f), null);
        DEFAULT_RETURN_THRESHOLDS_ARC = new ProgressThresholdsGroup(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.2f, 0.9f), r14);
    }

    public MaterialContainerTransform() {
        this.drawDebugEnabled = false;
        this.holdAtEndEnabled = false;
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
        this.elevationShadowEnabled = true;
        this.startElevation = ELEVATION_NOT_SET;
        this.endElevation = ELEVATION_NOT_SET;
        setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    }

    public static /* synthetic */ boolean access$300(MaterialContainerTransform r0) {
        return r0.holdAtEndEnabled;
    }

    private ProgressThresholdsGroup buildThresholdsGroup(boolean r3) {
        PathMotion r0 = getPathMotion();
        if ((r0 instanceof ArcMotion) == true) goto L10;
        if ((r0 instanceof MaterialArcMotion) == true) goto L10;
        return getThresholdsOrDefault(r3, DEFAULT_ENTER_THRESHOLDS, DEFAULT_RETURN_THRESHOLDS);
    L10:
        return getThresholdsOrDefault(r3, DEFAULT_ENTER_THRESHOLDS_ARC, DEFAULT_RETURN_THRESHOLDS_ARC);
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
        if (r4 == (-1)) goto L5;
        r2.view = TransitionUtils.findDescendantOrAncestorById(r2.view, r4);
    L10:
        View r6 = r2.view;
        if (ViewCompat.isLaidOut(r6) == true) goto L17;
        if (r6.getWidth() != 0) goto L17;
        if (r6.getHeight() != 0) goto L17;
        return;
    L17:
        if (r6.getParent() != null) goto L19;
        RectF r7 = TransitionUtils.getRelativeBounds(r6);
    L20:
        r2.values.put(PROP_BOUNDS, r7);
        r2.values.put(PROP_SHAPE_APPEARANCE, captureShapeAppearance(r6, r7, r5));
        return;
    L19:
        r7 = TransitionUtils.getLocationOnScreen(r6);
        goto L20
    L5:
        if (r3 == null) goto L8;
        r2.view = r3;
        goto L10
    L8:
        if ((r2.view.getTag(com.google.android.material.R.id.mtrl_motion_snapshot_view) instanceof View) == false) goto L10;
        View r8 = (View) r2.view.getTag(com.google.android.material.R.id.mtrl_motion_snapshot_view);
        r2.view.setTag(com.google.android.material.R.id.mtrl_motion_snapshot_view, null);
        r2.view = r8;
        goto L10
    }

    private static float getElevationOrDefault(float r1, View r2) {
        if (r1 == ELEVATION_NOT_SET) goto L6;
        return r1;
    L6:
        return ViewCompat.getElevation(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static ShapeAppearanceModel getShapeAppearance(@NonNull View r2, @Nullable ShapeAppearanceModel r3) {
        if (r3 == null) goto L5;
        return r3;
    L5:
        if ((r2.getTag(com.google.android.material.R.id.mtrl_motion_snapshot_view) instanceof ShapeAppearanceModel) == true) goto L7;
        Context r4 = r2.getContext();
        int r0 = getTransitionShapeAppearanceResId(r4);
        if (r0 == (-1)) goto L13;
        return ShapeAppearanceModel.builder(r4, r0, 0).build();
    L13:
        if ((r2 instanceof Shapeable) == false) goto L17;
        return ((Shapeable) r2).getShapeAppearanceModel();
    L17:
        return ShapeAppearanceModel.builder().build();
    L7:
        return (ShapeAppearanceModel) r2.getTag(com.google.android.material.R.id.mtrl_motion_snapshot_view);
    }

    private ProgressThresholdsGroup getThresholdsOrDefault(boolean r7, ProgressThresholdsGroup r8, ProgressThresholdsGroup r9) {
        if (r7 == true) goto L6;
        r8 = r9;
    L6:
        return new ProgressThresholdsGroup((ProgressThresholds) TransitionUtils.defaultIfNull(this.fadeProgressThresholds, ProgressThresholdsGroup.access$400(r8)), (ProgressThresholds) TransitionUtils.defaultIfNull(this.scaleProgressThresholds, ProgressThresholdsGroup.access$500(r8)), (ProgressThresholds) TransitionUtils.defaultIfNull(this.scaleMaskProgressThresholds, ProgressThresholdsGroup.access$600(r8)), (ProgressThresholds) TransitionUtils.defaultIfNull(this.shapeMaskProgressThresholds, ProgressThresholdsGroup.access$700(r8)), null);
    }

    @StyleRes
    private static int getTransitionShapeAppearanceResId(Context r2) {
        TypedArray r3 = r2.obtainStyledAttributes(new int[]{com.google.android.material.R.attr.transitionShapeAppearance});
        int r0 = r3.getResourceId(0, -1);
        r3.recycle();
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
        if (r31 == null) goto L27;
        if (r32 == null) goto L27;
        RectF r10 = (RectF) r31.values.get(PROP_BOUNDS);
        ShapeAppearanceModel r11 = (ShapeAppearanceModel) r31.values.get(PROP_SHAPE_APPEARANCE);
        if (r10 == null) goto L26;
        if (r11 == null) goto L26;
        RectF r14 = (RectF) r32.values.get(PROP_BOUNDS);
        ShapeAppearanceModel r15 = (ShapeAppearanceModel) r32.values.get(PROP_SHAPE_APPEARANCE);
        if (r14 == null) goto L24;
        if (r15 == null) goto L24;
        final View r4 = r31.view;
        final View r5 = r32.view;
        if (r5.getParent() == null) goto L17;
        View r0 = r5;
    L19:
        if (this.drawingViewId != r0.getId()) goto L21;
        final View r2 = (View) r0.getParent();
    L22:
        RectF r1 = TransitionUtils.getLocationOnScreen(r2);
        float r3 = -r1.left;
        float r6 = -r1.top;
        RectF r7 = calculateDrawableBounds(r2, r0, r3, r6);
        r10.offset(r3, r6);
        r14.offset(r3, r6);
        boolean r8 = isEntering(r10, r14);
        final TransitionDrawable r9 = new TransitionDrawable(getPathMotion(), r4, r10, r11, getElevationOrDefault(this.startElevation, r4), r5, r14, r15, getElevationOrDefault(this.endElevation, r5), this.containerColor, this.startContainerColor, this.endContainerColor, this.scrimColor, r8, this.elevationShadowEnabled, FadeModeEvaluators.get(this.fadeMode, r8), FitModeEvaluators.get(this.fitMode, r8, r10, r14), buildThresholdsGroup(r8), this.drawDebugEnabled, null);
        r9.setBounds(Math.round(r7.left), Math.round(r7.top), Math.round(r7.right), Math.round(r7.bottom));
        ValueAnimator r12 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r12.addUpdateListener(new AnonymousClass1(this, r9));
        addListener(new AnonymousClass2(this, r2, r9, r4, r5));
        return r12;
    L21:
        r2 = TransitionUtils.findAncestorById(r0, this.drawingViewId);
        r0 = null;
        goto L22
    L17:
        r0 = r4;
    L24:
        Log.w(TAG, "Skipping due to null end bounds. Ensure end view is laid out and measured.");
        return null;
    L26:
        Log.w(TAG, "Skipping due to null start bounds. Ensure start view is laid out and measured.");
    L27:
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
