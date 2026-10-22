package com.google.android.material.floatingactionbutton;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ImageMatrixProperty;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.internal.StateListAnimator;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.ripple.RippleDrawableCompat;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
class FloatingActionButtonImpl {
    static final int ANIM_STATE_HIDING = 1;
    static final int ANIM_STATE_NONE = 0;
    static final int ANIM_STATE_SHOWING = 2;
    static final long ELEVATION_ANIM_DELAY = 100;
    static final long ELEVATION_ANIM_DURATION = 100;
    static final TimeInterpolator ELEVATION_ANIM_INTERPOLATOR = null;
    static final int[] EMPTY_STATE_SET = null;
    static final int[] ENABLED_STATE_SET = null;
    static final int[] FOCUSED_ENABLED_STATE_SET = null;
    private static final float HIDE_ICON_SCALE = 0.4f;
    private static final float HIDE_OPACITY = 0.0f;
    private static final float HIDE_SCALE = 0.4f;
    static final int[] HOVERED_ENABLED_STATE_SET = null;
    static final int[] HOVERED_FOCUSED_ENABLED_STATE_SET = null;
    static final int[] PRESSED_ENABLED_STATE_SET = null;
    static final float SHADOW_MULTIPLIER = 1.5f;
    private static final float SHOW_ICON_SCALE = 1.0f;
    private static final float SHOW_OPACITY = 1.0f;
    private static final float SHOW_SCALE = 1.0f;
    private static final float SPEC_HIDE_ICON_SCALE = 0.0f;
    private static final float SPEC_HIDE_SCALE = 0.0f;
    private int animState;

    @Nullable
    BorderDrawable borderDrawable;

    @Nullable
    Drawable contentBackground;

    @Nullable
    private Animator currentAnimator;
    float elevation;
    boolean ensureMinTouchTargetSize;
    private ArrayList<Animator.AnimatorListener> hideListeners;

    @Nullable
    private MotionSpec hideMotionSpec;
    float hoveredFocusedTranslationZ;
    private float imageMatrixScale;
    private int maxImageSize;
    int minTouchTargetSize;

    @Nullable
    private ViewTreeObserver.OnPreDrawListener preDrawListener;
    float pressedTranslationZ;

    @Nullable
    Drawable rippleDrawable;
    private float rotation;
    boolean shadowPaddingEnabled;
    final ShadowViewDelegate shadowViewDelegate;

    @Nullable
    ShapeAppearanceModel shapeAppearance;

    @Nullable
    MaterialShapeDrawable shapeDrawable;
    private ArrayList<Animator.AnimatorListener> showListeners;

    @Nullable
    private MotionSpec showMotionSpec;

    @NonNull
    private final StateListAnimator stateListAnimator;
    private final Matrix tmpMatrix;
    private final Rect tmpRect;
    private final RectF tmpRectF1;
    private final RectF tmpRectF2;
    private ArrayList<InternalTransformationCallback> transformationCallbacks;
    final FloatingActionButton view;

    private class DisabledElevationAnimation extends ShadowAnimatorImpl {
        final /* synthetic */ FloatingActionButtonImpl this$0;

        DisabledElevationAnimation(FloatingActionButtonImpl r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        protected float getTargetShadowSize() {
            return 0.0f;
        }
    }

    private class ElevateToHoveredFocusedTranslationZAnimation extends ShadowAnimatorImpl {
        final /* synthetic */ FloatingActionButtonImpl this$0;

        ElevateToHoveredFocusedTranslationZAnimation(FloatingActionButtonImpl r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        protected float getTargetShadowSize() {
            FloatingActionButtonImpl r1 = this.this$0;
            return r1.elevation + r1.hoveredFocusedTranslationZ;
        }
    }

    private class ElevateToPressedTranslationZAnimation extends ShadowAnimatorImpl {
        final /* synthetic */ FloatingActionButtonImpl this$0;

        ElevateToPressedTranslationZAnimation(FloatingActionButtonImpl r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        protected float getTargetShadowSize() {
            FloatingActionButtonImpl r1 = this.this$0;
            return r1.elevation + r1.pressedTranslationZ;
        }
    }

    interface InternalTransformationCallback {
        void onScaleChanged();

        void onTranslationChanged();
    }

    interface InternalVisibilityChangedListener {
        void onHidden();

        void onShown();
    }

    private class ResetElevationAnimation extends ShadowAnimatorImpl {
        final /* synthetic */ FloatingActionButtonImpl this$0;

        ResetElevationAnimation(FloatingActionButtonImpl r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        protected float getTargetShadowSize() {
            return this.this$0.elevation;
        }
    }

    private abstract class ShadowAnimatorImpl extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        private float shadowSizeEnd;
        private float shadowSizeStart;
        final /* synthetic */ FloatingActionButtonImpl this$0;
        private boolean validValues;

        private ShadowAnimatorImpl(FloatingActionButtonImpl r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ShadowAnimatorImpl(FloatingActionButtonImpl r1, AnonymousClass1 r2) {
            this(r1);
        }

        protected abstract float getTargetShadowSize();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r2) {
            this.this$0.updateShapeElevation((int) this.shadowSizeEnd);
            this.validValues = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator r3) {
            if (this.validValues == true) goto L9;
            MaterialShapeDrawable r0 = this.this$0.shapeDrawable;
            if (r0 != null) goto L7;
            float r1 = 0.0f;
        L8:
            this.shadowSizeStart = r1;
            this.shadowSizeEnd = getTargetShadowSize();
            this.validValues = true;
            goto L9
        L7:
            r1 = r0.getElevation();
        L9:
            FloatingActionButtonImpl r2 = this.this$0;
            float r4 = this.shadowSizeStart;
            r2.updateShapeElevation((int) (r4 + ((this.shadowSizeEnd - r4) * r3.getAnimatedFraction())));
        }
    }

    static {
        ELEVATION_ANIM_INTERPOLATOR = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
        PRESSED_ENABLED_STATE_SET = new int[]{R.attr.state_pressed, R.attr.state_enabled};
        HOVERED_FOCUSED_ENABLED_STATE_SET = new int[]{R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
        FOCUSED_ENABLED_STATE_SET = new int[]{R.attr.state_focused, R.attr.state_enabled};
        HOVERED_ENABLED_STATE_SET = new int[]{R.attr.state_hovered, R.attr.state_enabled};
        ENABLED_STATE_SET = new int[]{R.attr.state_enabled};
        EMPTY_STATE_SET = new int[0];
    }

    FloatingActionButtonImpl(FloatingActionButton r3, ShadowViewDelegate r4) {
        this.shadowPaddingEnabled = true;
        this.imageMatrixScale = 1.0f;
        this.animState = 0;
        this.tmpRect = new Rect();
        this.tmpRectF1 = new RectF();
        this.tmpRectF2 = new RectF();
        this.tmpMatrix = new Matrix();
        this.view = r3;
        this.shadowViewDelegate = r4;
        StateListAnimator r5 = new StateListAnimator();
        this.stateListAnimator = r5;
        r5.addState(PRESSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToPressedTranslationZAnimation(this)));
        r5.addState(HOVERED_FOCUSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation(this)));
        r5.addState(FOCUSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation(this)));
        r5.addState(HOVERED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation(this)));
        r5.addState(ENABLED_STATE_SET, createElevationAnimator(new ResetElevationAnimation(this)));
        r5.addState(EMPTY_STATE_SET, createElevationAnimator(new DisabledElevationAnimation(this)));
        this.rotation = r3.getRotation();
    }

    static /* synthetic */ int access$002(FloatingActionButtonImpl r0, int r1) {
        r0.animState = r1;
        return r1;
    }

    static /* synthetic */ Animator access$102(FloatingActionButtonImpl r0, Animator r1) {
        r0.currentAnimator = r1;
        return r1;
    }

    static /* synthetic */ float access$202(FloatingActionButtonImpl r0, float r1) {
        r0.imageMatrixScale = r1;
        return r1;
    }

    static /* synthetic */ void access$300(FloatingActionButtonImpl r0, float r1, Matrix r2) {
        r0.calculateImageMatrixFromScale(r1, r2);
    }

    private void calculateImageMatrixFromScale(float r6, @NonNull Matrix r7) {
        r7.reset();
        Drawable r0 = this.view.getDrawable();
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.maxImageSize == 0) goto L9;
        RectF r1 = this.tmpRectF1;
        RectF r2 = this.tmpRectF2;
        r1.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        int r3 = this.maxImageSize;
        r2.set(0.0f, 0.0f, r3, r3);
        r7.setRectToRect(r1, r2, Matrix.ScaleToFit.CENTER);
        int r5 = this.maxImageSize;
        r7.postScale(r6, r6, r5 / 2.0f, r5 / 2.0f);
        return;
    }

    @NonNull
    private AnimatorSet createAnimator(@NonNull MotionSpec r7, float r8, float r9, float r10) {
        ArrayList r0 = new ArrayList();
        ObjectAnimator r11 = ObjectAnimator.ofFloat(this.view, View.ALPHA, new float[]{r8});
        r7.getTiming("opacity").apply(r11);
        r0.add(r11);
        ObjectAnimator r12 = ObjectAnimator.ofFloat(this.view, View.SCALE_X, new float[]{r9});
        r7.getTiming("scale").apply(r12);
        workAroundOreoBug(r12);
        r0.add(r12);
        ObjectAnimator r13 = ObjectAnimator.ofFloat(this.view, View.SCALE_Y, new float[]{r9});
        r7.getTiming("scale").apply(r13);
        workAroundOreoBug(r13);
        r0.add(r13);
        calculateImageMatrixFromScale(r10, this.tmpMatrix);
        ObjectAnimator r6 = ObjectAnimator.ofObject(this.view, new ImageMatrixProperty(), new AnonymousClass3(this), new Matrix[]{new Matrix(this.tmpMatrix)});
        r7.getTiming("iconScale").apply(r6);
        r0.add(r6);
        AnimatorSet r14 = new AnimatorSet();
        AnimatorSetCompat.playTogether(r14, r0);
        return r14;
    }

    private AnimatorSet createDefaultAnimator(final float r16, final float r17, final float r18) {
        AnimatorSet r11 = new AnimatorSet();
        ArrayList r12 = new ArrayList();
        ValueAnimator r13 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        final float r2 = this.view.getAlpha();
        final float r4 = this.view.getScaleX();
        final float r6 = this.view.getScaleY();
        final float r7 = this.imageMatrixScale;
        final Matrix r9 = new Matrix(this.tmpMatrix);
        r13.addUpdateListener(new AnonymousClass4(this, r2, r16, r4, r17, r6, r7, r18, r9));
        r12.add(r13);
        AnimatorSetCompat.playTogether(r11, r12);
        r11.setDuration(MotionUtils.resolveThemeDuration(this.view.getContext(), com.google.android.material.R.attr.motionDurationLong1, this.view.getContext().getResources().getInteger(com.google.android.material.R.integer.material_motion_duration_long_1)));
        r11.setInterpolator(MotionUtils.resolveThemeInterpolator(this.view.getContext(), com.google.android.material.R.attr.motionEasingStandard, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return r11;
    }

    @NonNull
    private ValueAnimator createElevationAnimator(@NonNull ShadowAnimatorImpl r3) {
        ValueAnimator r2 = new ValueAnimator();
        r2.setInterpolator(ELEVATION_ANIM_INTERPOLATOR);
        r2.setDuration(100);
        r2.addListener(r3);
        r2.addUpdateListener(r3);
        r2.setFloatValues(new float[]{0.0f, 1.0f});
        return r2;
    }

    @NonNull
    private ViewTreeObserver.OnPreDrawListener getOrCreatePreDrawListener() {
        if (this.preDrawListener != null) goto L6;
        this.preDrawListener = new AnonymousClass6(this);
    L6:
        return this.preDrawListener;
    }

    private boolean shouldAnimateVisibilityChange() {
        if (ViewCompat.isLaidOut(this.view) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.view.isInEditMode() == true) goto L7;
        return true;
    }

    private void workAroundOreoBug(ObjectAnimator r3) {
        if (Build.VERSION.SDK_INT == 26) goto L5;
        return;
    L5:
        r3.setEvaluator(new AnonymousClass5(this));
    }

    public void addOnHideAnimationListener(@NonNull Animator.AnimatorListener r2) {
        if (this.hideListeners != null) goto L5;
        this.hideListeners = new ArrayList();
    L5:
        this.hideListeners.add(r2);
    }

    void addOnShowAnimationListener(@NonNull Animator.AnimatorListener r2) {
        if (this.showListeners != null) goto L5;
        this.showListeners = new ArrayList();
    L5:
        this.showListeners.add(r2);
    }

    void addTransformationCallback(@NonNull InternalTransformationCallback r2) {
        if (this.transformationCallbacks != null) goto L5;
        this.transformationCallbacks = new ArrayList();
    L5:
        this.transformationCallbacks.add(r2);
    }

    MaterialShapeDrawable createShapeDrawable() {
        return new MaterialShapeDrawable((ShapeAppearanceModel) Preconditions.checkNotNull(this.shapeAppearance));
    }

    @Nullable
    final Drawable getContentBackground() {
        return this.contentBackground;
    }

    float getElevation() {
        return this.elevation;
    }

    boolean getEnsureMinTouchTargetSize() {
        return this.ensureMinTouchTargetSize;
    }

    @Nullable
    final MotionSpec getHideMotionSpec() {
        return this.hideMotionSpec;
    }

    float getHoveredFocusedTranslationZ() {
        return this.hoveredFocusedTranslationZ;
    }

    void getPadding(@NonNull Rect r5) {
        if (this.ensureMinTouchTargetSize == false) goto L5;
        int r0 = (this.minTouchTargetSize - this.view.getSizeDimension()) / 2;
    L7:
        if (this.shadowPaddingEnabled == false) goto L9;
        float r1 = getElevation() + this.pressedTranslationZ;
    L10:
        int r4 = Math.max(r0, (int) Math.ceil(r1));
        int r2 = Math.max(r0, (int) Math.ceil(r1 * SHADOW_MULTIPLIER));
        r5.set(r4, r2, r4, r2);
        return;
    L9:
        r1 = 0.0f;
        goto L10
    L5:
        r0 = 0;
        goto L7
    }

    float getPressedTranslationZ() {
        return this.pressedTranslationZ;
    }

    @Nullable
    final ShapeAppearanceModel getShapeAppearance() {
        return this.shapeAppearance;
    }

    @Nullable
    final MotionSpec getShowMotionSpec() {
        return this.showMotionSpec;
    }

    void hide(@Nullable final InternalVisibilityChangedListener r3, final boolean r4) {
        if (isOrWillBeHidden() == false) goto L5;
        return;
    L5:
        Animator r0 = this.currentAnimator;
        if (r0 == null) goto L9;
        r0.cancel();
    L9:
        if (shouldAnimateVisibilityChange() == false) goto L21;
        MotionSpec r1 = this.hideMotionSpec;
        if (r1 == null) goto L13;
        AnimatorSet r2 = createAnimator(r1, 0.0f, 0.0f, 0.0f);
    L14:
        r2.addListener(new AnonymousClass1(this, r4, r3));
        ArrayList<Animator.AnimatorListener> r5 = this.hideListeners;
        if (r5 == null) goto L20;
        Iterator<Animator.AnimatorListener> r6 = r5.iterator();
    L18:
        if (r6.hasNext() == false) goto L20;
        r2.addListener(r6.next());
    L20:
        r2.start();
        return;
    L13:
        r2 = createDefaultAnimator(0.0f, 0.4f, 0.4f);
        goto L14
    L21:
        FloatingActionButton r7 = this.view;
        if (r4 == false) goto L24;
        int r8 = 8;
    L25:
        r7.internalSetVisibility(r8, r4);
        if (r3 == null) goto L31;
        r3.onHidden();
        return;
    L31:
        return;
    L24:
        r8 = 4;
        goto L25
    }

    void initializeBackgroundDrawable(ColorStateList r1, @Nullable PorterDuff.Mode r2, ColorStateList r3, int r4) {
        MaterialShapeDrawable r5 = createShapeDrawable();
        this.shapeDrawable = r5;
        r5.setTintList(r1);
        if (r2 == null) goto L5;
        this.shapeDrawable.setTintMode(r2);
    L5:
        this.shapeDrawable.setShadowColor(-12303292);
        this.shapeDrawable.initializeElevationOverlay(this.view.getContext());
        RippleDrawableCompat r6 = new RippleDrawableCompat(this.shapeDrawable.getShapeAppearanceModel());
        r6.setTintList(RippleUtils.sanitizeRippleDrawableColor(r3));
        this.rippleDrawable = r6;
        this.contentBackground = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.checkNotNull(this.shapeDrawable), r6});
    }

    boolean isOrWillBeHidden() {
        int r0 = this.view.getVisibility();
        int r3 = this.animState;
        if (r0 != 0) goto L8;
        if (r3 == 1) goto L6;
        return false;
    L6:
        return true;
    L8:
        if (r3 != 2) goto L10;
        return false;
    L10:
        return true;
    }

    boolean isOrWillBeShown() {
        int r0 = this.view.getVisibility();
        int r3 = this.animState;
        if (r0 != 0) goto L5;
        if (r3 != 1) goto L10;
        return false;
    L10:
        return true;
    L5:
        if (r3 == 2) goto L7;
        return false;
    L7:
        return true;
    }

    void jumpDrawableToCurrentState() {
        this.stateListAnimator.jumpToCurrentState();
    }

    void onAttachedToWindow() {
        MaterialShapeDrawable r0 = this.shapeDrawable;
        if (r0 == null) goto L6;
        MaterialShapeUtils.setParentAbsoluteElevation(this.view, r0);
    L6:
        if (requirePreDrawListener() == false) goto L9;
        this.view.getViewTreeObserver().addOnPreDrawListener(getOrCreatePreDrawListener());
        return;
    }

    void onCompatShadowChanged() {
    }

    void onDetachedFromWindow() {
        ViewTreeObserver r0 = this.view.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener r1 = this.preDrawListener;
        if (r1 == null) goto L6;
        r0.removeOnPreDrawListener(r1);
        this.preDrawListener = null;
        return;
    }

    void onDrawableStateChanged(int[] r1) {
        this.stateListAnimator.setState(r1);
    }

    void onElevationsChanged(float r1, float r2, float r3) {
        updatePadding();
        updateShapeElevation(r1);
    }

    void onPaddingUpdated(@NonNull Rect r8) {
        Preconditions.checkNotNull(this.contentBackground, "Didn't initialize content background");
        if (shouldAddPadding() == false) goto L5;
        InsetDrawable r0 = new InsetDrawable(this.contentBackground, r8.left, r8.top, r8.right, r8.bottom);
        this.shadowViewDelegate.setBackgroundDrawable(r0);
        return;
    L5:
        this.shadowViewDelegate.setBackgroundDrawable(this.contentBackground);
    }

    void onPreDraw() {
        float r0 = this.view.getRotation();
        if (this.rotation == r0) goto L6;
        this.rotation = r0;
        updateFromViewRotation();
        return;
    }

    void onScaleChanged() {
        ArrayList<InternalTransformationCallback> r1 = this.transformationCallbacks;
        if (r1 == null) goto L8;
        Iterator<InternalTransformationCallback> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        r2.next().onScaleChanged();
        goto L6
    L10:
        return;
    }

    void onTranslationChanged() {
        ArrayList<InternalTransformationCallback> r1 = this.transformationCallbacks;
        if (r1 == null) goto L8;
        Iterator<InternalTransformationCallback> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        r2.next().onTranslationChanged();
        goto L6
    L10:
        return;
    }

    public void removeOnHideAnimationListener(@NonNull Animator.AnimatorListener r1) {
        ArrayList<Animator.AnimatorListener> r0 = this.hideListeners;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.remove(r1);
    }

    void removeOnShowAnimationListener(@NonNull Animator.AnimatorListener r1) {
        ArrayList<Animator.AnimatorListener> r0 = this.showListeners;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.remove(r1);
    }

    void removeTransformationCallback(@NonNull InternalTransformationCallback r1) {
        ArrayList<InternalTransformationCallback> r0 = this.transformationCallbacks;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.remove(r1);
    }

    boolean requirePreDrawListener() {
        return true;
    }

    void setBackgroundTintList(@Nullable ColorStateList r2) {
        MaterialShapeDrawable r0 = this.shapeDrawable;
        if (r0 == null) goto L5;
        r0.setTintList(r2);
    L5:
        BorderDrawable r1 = this.borderDrawable;
        if (r1 == null) goto L9;
        r1.setBorderTint(r2);
        return;
    }

    void setBackgroundTintMode(@Nullable PorterDuff.Mode r1) {
        MaterialShapeDrawable r0 = this.shapeDrawable;
        if (r0 == null) goto L6;
        r0.setTintMode(r1);
        return;
    }

    final void setElevation(float r3) {
        if (this.elevation == r3) goto L6;
        this.elevation = r3;
        onElevationsChanged(r3, this.hoveredFocusedTranslationZ, this.pressedTranslationZ);
        return;
    }

    void setEnsureMinTouchTargetSize(boolean r1) {
        this.ensureMinTouchTargetSize = r1;
    }

    final void setHideMotionSpec(@Nullable MotionSpec r1) {
        this.hideMotionSpec = r1;
    }

    final void setHoveredFocusedTranslationZ(float r3) {
        if (this.hoveredFocusedTranslationZ == r3) goto L6;
        this.hoveredFocusedTranslationZ = r3;
        onElevationsChanged(this.elevation, r3, this.pressedTranslationZ);
        return;
    }

    final void setImageMatrixScale(float r2) {
        this.imageMatrixScale = r2;
        Matrix r0 = this.tmpMatrix;
        calculateImageMatrixFromScale(r2, r0);
        this.view.setImageMatrix(r0);
    }

    final void setMaxImageSize(int r2) {
        if (this.maxImageSize == r2) goto L6;
        this.maxImageSize = r2;
        updateImageMatrixScale();
        return;
    }

    void setMinTouchTargetSize(int r1) {
        this.minTouchTargetSize = r1;
    }

    final void setPressedTranslationZ(float r3) {
        if (this.pressedTranslationZ == r3) goto L6;
        this.pressedTranslationZ = r3;
        onElevationsChanged(this.elevation, this.hoveredFocusedTranslationZ, r3);
        return;
    }

    void setRippleColor(@Nullable ColorStateList r1) {
        Drawable r0 = this.rippleDrawable;
        if (r0 == null) goto L6;
        DrawableCompat.setTintList(r0, RippleUtils.sanitizeRippleDrawableColor(r1));
        return;
    }

    void setShadowPaddingEnabled(boolean r1) {
        this.shadowPaddingEnabled = r1;
        updatePadding();
    }

    final void setShapeAppearance(@NonNull ShapeAppearanceModel r3) {
        this.shapeAppearance = r3;
        MaterialShapeDrawable r0 = this.shapeDrawable;
        if (r0 == null) goto L5;
        r0.setShapeAppearanceModel(r3);
    L5:
        Object r1 = this.rippleDrawable;
        if ((r1 instanceof Shapeable) == false) goto L8;
        ((Shapeable) r1).setShapeAppearanceModel(r3);
    L8:
        BorderDrawable r2 = this.borderDrawable;
        if (r2 == null) goto L12;
        r2.setShapeAppearanceModel(r3);
        return;
    }

    final void setShowMotionSpec(@Nullable MotionSpec r1) {
        this.showMotionSpec = r1;
    }

    boolean shouldAddPadding() {
        return true;
    }

    final boolean shouldExpandBoundsForA11y() {
        if (this.ensureMinTouchTargetSize == true) goto L5;
    L8:
        return true;
    L5:
        if (this.view.getSizeDimension() >= this.minTouchTargetSize) goto L8;
        return false;
    }

    void show(@Nullable final InternalVisibilityChangedListener r7, final boolean r8) {
        if (isOrWillBeShown() == false) goto L5;
        return;
    L5:
        Animator r0 = this.currentAnimator;
        if (r0 == null) goto L9;
        r0.cancel();
    L9:
        if (this.showMotionSpec != null) goto L11;
        boolean r1 = true;
    L13:
        if (shouldAnimateVisibilityChange() == true) goto L15;
        this.view.internalSetVisibility(0, r8);
        this.view.setAlpha(1.0f);
        this.view.setScaleY(1.0f);
        this.view.setScaleX(1.0f);
        setImageMatrixScale(1.0f);
        if (r7 == null) goto L45;
        r7.onShown();
        return;
    L45:
        return;
    L15:
        if (this.view.getVisibility() == 0) goto L28;
        float r2 = 0.0f;
        this.view.setAlpha(0.0f);
        FloatingActionButton r3 = this.view;
        if (r1 == false) goto L19;
        float r5 = 0.4f;
    L20:
        r3.setScaleY(r5);
        FloatingActionButton r4 = this.view;
        if (r1 == false) goto L23;
        float r6 = 0.4f;
    L24:
        r4.setScaleX(r6);
        if (r1 == false) goto L27;
        r2 = 0.4f;
    L27:
        setImageMatrixScale(r2);
        goto L28
    L23:
        r6 = 0.0f;
        goto L24
    L19:
        r5 = 0.0f;
    L28:
        MotionSpec r9 = this.showMotionSpec;
        if (r9 == null) goto L31;
        AnimatorSet r10 = createAnimator(r9, 1.0f, 1.0f, 1.0f);
    L32:
        r10.addListener(new AnonymousClass2(this, r8, r7));
        ArrayList<Animator.AnimatorListener> r11 = this.showListeners;
        if (r11 == null) goto L38;
        Iterator<Animator.AnimatorListener> r12 = r11.iterator();
    L36:
        if (r12.hasNext() == false) goto L38;
        r10.addListener(r12.next());
    L38:
        r10.start();
        return;
    L31:
        r10 = createDefaultAnimator(1.0f, 1.0f, 1.0f);
        goto L32
    L11:
        r1 = false;
        goto L13
    }

    void updateFromViewRotation() {
        if (Build.VERSION.SDK_INT == 19) goto L5;
    L13:
        MaterialShapeDrawable r0 = this.shapeDrawable;
        if (r0 == null) goto L17;
        r0.setShadowCompatRotation((int) this.rotation);
        return;
    L17:
        return;
    L5:
        if ((this.rotation % 90.0f) == 0.0f) goto L10;
        int r2 = 1;
        if (this.view.getLayerType() == 1) goto L13;
        FloatingActionButton r1 = this.view;
    L12:
        r1.setLayerType(r2, null);
        goto L13
    L10:
        if (this.view.getLayerType() == 0) goto L13;
        r1 = this.view;
        r2 = 0;
        goto L12
    }

    final void updateImageMatrixScale() {
        setImageMatrixScale(this.imageMatrixScale);
    }

    final void updatePadding() {
        Rect r0 = this.tmpRect;
        getPadding(r0);
        onPaddingUpdated(r0);
        this.shadowViewDelegate.setShadowPadding(r0.left, r0.top, r0.right, r0.bottom);
    }

    void updateShapeElevation(float r1) {
        MaterialShapeDrawable r0 = this.shapeDrawable;
        if (r0 == null) goto L6;
        r0.setElevation(r1);
        return;
    }
}
