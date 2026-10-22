package com.google.android.material.floatingactionbutton;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ImageMatrixProperty;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.internal.StateListAnimator;
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
    private static final float HIDE_ICON_SCALE = 0.0f;
    private static final float HIDE_OPACITY = 0.0f;
    private static final float HIDE_SCALE = 0.0f;
    static final int[] HOVERED_ENABLED_STATE_SET = null;
    static final int[] HOVERED_FOCUSED_ENABLED_STATE_SET = null;
    static final int[] PRESSED_ENABLED_STATE_SET = null;
    static final float SHADOW_MULTIPLIER = 1.5f;
    private static final float SHOW_ICON_SCALE = 1.0f;
    private static final float SHOW_OPACITY = 1.0f;
    private static final float SHOW_SCALE = 1.0f;
    private int animState;
    BorderDrawable borderDrawable;
    Drawable contentBackground;
    private Animator currentAnimator;
    private MotionSpec defaultHideMotionSpec;
    private MotionSpec defaultShowMotionSpec;
    float elevation;
    boolean ensureMinTouchTargetSize;
    private ArrayList<Animator.AnimatorListener> hideListeners;
    private MotionSpec hideMotionSpec;
    float hoveredFocusedTranslationZ;
    private float imageMatrixScale;
    private int maxImageSize;
    int minTouchTargetSize;
    private ViewTreeObserver.OnPreDrawListener preDrawListener;
    float pressedTranslationZ;
    Drawable rippleDrawable;
    private float rotation;
    boolean shadowPaddingEnabled;
    final ShadowViewDelegate shadowViewDelegate;
    ShapeAppearanceModel shapeAppearance;
    MaterialShapeDrawable shapeDrawable;
    private ArrayList<Animator.AnimatorListener> showListeners;
    private MotionSpec showMotionSpec;
    private final StateListAnimator stateListAnimator;
    private final Matrix tmpMatrix;
    private final Rect tmpRect;
    private final RectF tmpRectF1;
    private final RectF tmpRectF2;
    private ArrayList<InternalTransformationCallback> transformationCallbacks;
    final FloatingActionButton view;

    /* JADX INFO: renamed from: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$4, reason: invalid class name */
    class AnonymousClass4 implements TypeEvaluator<Float> {
        FloatEvaluator floatEvaluator;
        final /* synthetic */ FloatingActionButtonImpl this$0;

        AnonymousClass4(FloatingActionButtonImpl r1) {
            this.this$0 = r1;
            this.floatEvaluator = new FloatEvaluator();
        }

        @Override // android.animation.TypeEvaluator
        public /* bridge */ /* synthetic */ Float evaluate(float r1, Float r2, Float r3) {
            return evaluate2(r1, r2, r3);
        }

        /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
        public Float evaluate2(float r1, Float r2, Float r3) {
            float r0 = this.floatEvaluator.evaluate(r1, r2, r3).floatValue();
            if (r0 >= 0.1f) goto L6;
            r0 = 0.0f;
        L6:
            return Float.valueOf(r0);
        }
    }

    private class DisabledElevationAnimation extends ShadowAnimatorImpl {
        final /* synthetic */ FloatingActionButtonImpl this$0;

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        protected float getTargetShadowSize() {
            return 0.0f;
        }

        DisabledElevationAnimation(FloatingActionButtonImpl r2) {
            this.this$0 = r2;
            super(r2, null);
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
            return this.this$0.elevation + this.this$0.hoveredFocusedTranslationZ;
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
            return this.this$0.elevation + this.this$0.pressedTranslationZ;
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

        protected abstract float getTargetShadowSize();

        private ShadowAnimatorImpl(FloatingActionButtonImpl r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ShadowAnimatorImpl(FloatingActionButtonImpl r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator r3) {
            if (this.validValues == false) goto L5;
        L9:
            FloatingActionButtonImpl r0 = this.this$0;
            float r1 = this.shadowSizeStart;
            r0.updateShapeElevation((int) (r1 + ((this.shadowSizeEnd - r1) * r3.getAnimatedFraction())));
            return;
        L5:
            if (this.this$0.shapeDrawable != null) goto L7;
            float r2 = 0.0f;
        L8:
            this.shadowSizeStart = r2;
            this.shadowSizeEnd = getTargetShadowSize();
            this.validValues = true;
            goto L9
        L7:
            r2 = this.this$0.shapeDrawable.getElevation();
            goto L8
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r2) {
            this.this$0.updateShapeElevation((int) this.shadowSizeEnd);
            this.validValues = false;
        }
    }

    private void workAroundOreoBug(ObjectAnimator r1) {
    }

    void onCompatShadowChanged() {
    }

    boolean requirePreDrawListener() {
        return true;
    }

    boolean shouldAddPadding() {
        return true;
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

    void initializeBackgroundDrawable(ColorStateList r1, PorterDuff.Mode r2, ColorStateList r3, int r4) {
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

    void setBackgroundTintList(ColorStateList r2) {
        MaterialShapeDrawable r0 = this.shapeDrawable;
        if (r0 == null) goto L5;
        r0.setTintList(r2);
    L5:
        BorderDrawable r1 = this.borderDrawable;
        if (r1 == null) goto L9;
        r1.setBorderTint(r2);
        return;
    }

    void setBackgroundTintMode(PorterDuff.Mode r1) {
        MaterialShapeDrawable r0 = this.shapeDrawable;
        if (r0 == null) goto L6;
        r0.setTintMode(r1);
        return;
    }

    void setMinTouchTargetSize(int r1) {
        this.minTouchTargetSize = r1;
    }

    void setRippleColor(ColorStateList r1) {
        Drawable r0 = this.rippleDrawable;
        if (r0 == null) goto L6;
        DrawableCompat.setTintList(r0, RippleUtils.sanitizeRippleDrawableColor(r1));
        return;
    }

    final void setElevation(float r3) {
        if (this.elevation == r3) goto L6;
        this.elevation = r3;
        onElevationsChanged(r3, this.hoveredFocusedTranslationZ, this.pressedTranslationZ);
        return;
    }

    float getElevation() {
        return this.elevation;
    }

    float getHoveredFocusedTranslationZ() {
        return this.hoveredFocusedTranslationZ;
    }

    float getPressedTranslationZ() {
        return this.pressedTranslationZ;
    }

    final void setHoveredFocusedTranslationZ(float r3) {
        if (this.hoveredFocusedTranslationZ == r3) goto L6;
        this.hoveredFocusedTranslationZ = r3;
        onElevationsChanged(this.elevation, r3, this.pressedTranslationZ);
        return;
    }

    final void setPressedTranslationZ(float r3) {
        if (this.pressedTranslationZ == r3) goto L6;
        this.pressedTranslationZ = r3;
        onElevationsChanged(this.elevation, this.hoveredFocusedTranslationZ, r3);
        return;
    }

    final void setMaxImageSize(int r2) {
        if (this.maxImageSize == r2) goto L6;
        this.maxImageSize = r2;
        updateImageMatrixScale();
        return;
    }

    final void updateImageMatrixScale() {
        setImageMatrixScale(this.imageMatrixScale);
    }

    final void setImageMatrixScale(float r2) {
        this.imageMatrixScale = r2;
        Matrix r0 = this.tmpMatrix;
        calculateImageMatrixFromScale(r2, r0);
        this.view.setImageMatrix(r0);
    }

    private void calculateImageMatrixFromScale(float r6, Matrix r7) {
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

    final void setShapeAppearance(ShapeAppearanceModel r3) {
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

    final ShapeAppearanceModel getShapeAppearance() {
        return this.shapeAppearance;
    }

    final MotionSpec getShowMotionSpec() {
        return this.showMotionSpec;
    }

    final void setShowMotionSpec(MotionSpec r1) {
        this.showMotionSpec = r1;
    }

    final MotionSpec getHideMotionSpec() {
        return this.hideMotionSpec;
    }

    final void setHideMotionSpec(MotionSpec r1) {
        this.hideMotionSpec = r1;
    }

    final boolean shouldExpandBoundsForA11y() {
        if (this.ensureMinTouchTargetSize == true) goto L5;
    L8:
        return true;
    L5:
        if (this.view.getSizeDimension() >= this.minTouchTargetSize) goto L8;
        return false;
    }

    boolean getEnsureMinTouchTargetSize() {
        return this.ensureMinTouchTargetSize;
    }

    void setEnsureMinTouchTargetSize(boolean r1) {
        this.ensureMinTouchTargetSize = r1;
    }

    void setShadowPaddingEnabled(boolean r1) {
        this.shadowPaddingEnabled = r1;
        updatePadding();
    }

    void onElevationsChanged(float r1, float r2, float r3) {
        updatePadding();
        updateShapeElevation(r1);
    }

    void updateShapeElevation(float r1) {
        MaterialShapeDrawable r0 = this.shapeDrawable;
        if (r0 == null) goto L6;
        r0.setElevation(r1);
        return;
    }

    void onDrawableStateChanged(int[] r1) {
        this.stateListAnimator.setState(r1);
    }

    void jumpDrawableToCurrentState() {
        this.stateListAnimator.jumpToCurrentState();
    }

    void addOnShowAnimationListener(Animator.AnimatorListener r2) {
        if (this.showListeners != null) goto L5;
        this.showListeners = new ArrayList();
    L5:
        this.showListeners.add(r2);
    }

    void removeOnShowAnimationListener(Animator.AnimatorListener r1) {
        ArrayList<Animator.AnimatorListener> r0 = this.showListeners;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.remove(r1);
    }

    public void addOnHideAnimationListener(Animator.AnimatorListener r2) {
        if (this.hideListeners != null) goto L5;
        this.hideListeners = new ArrayList();
    L5:
        this.hideListeners.add(r2);
    }

    public void removeOnHideAnimationListener(Animator.AnimatorListener r1) {
        ArrayList<Animator.AnimatorListener> r0 = this.hideListeners;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.remove(r1);
    }

    void hide(final InternalVisibilityChangedListener r3, final boolean r4) {
        if (isOrWillBeHidden() == false) goto L5;
        return;
    L5:
        Animator r0 = this.currentAnimator;
        if (r0 == null) goto L9;
        r0.cancel();
    L9:
        if (shouldAnimateVisibilityChange() == false) goto L21;
        MotionSpec r1 = this.hideMotionSpec;
        if (r1 != null) goto L14;
        r1 = getDefaultHideMotionSpec();
    L14:
        AnimatorSet r2 = createAnimator(r1, 0.0f, 0.0f, 0.0f);
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

    void show(final InternalVisibilityChangedListener r4, final boolean r5) {
        if (isOrWillBeShown() == false) goto L5;
        return;
    L5:
        Animator r0 = this.currentAnimator;
        if (r0 == null) goto L9;
        r0.cancel();
    L9:
        if (shouldAnimateVisibilityChange() == true) goto L11;
        this.view.internalSetVisibility(0, r5);
        this.view.setAlpha(1.0f);
        this.view.setScaleY(1.0f);
        this.view.setScaleX(1.0f);
        setImageMatrixScale(1.0f);
        if (r4 == null) goto L30;
        r4.onShown();
        return;
    L30:
        return;
    L11:
        if (this.view.getVisibility() == 0) goto L13;
        this.view.setAlpha(0.0f);
        this.view.setScaleY(0.0f);
        this.view.setScaleX(0.0f);
        setImageMatrixScale(0.0f);
    L13:
        MotionSpec r1 = this.showMotionSpec;
        if (r1 != null) goto L17;
        r1 = getDefaultShowMotionSpec();
    L17:
        AnimatorSet r2 = createAnimator(r1, 1.0f, 1.0f, 1.0f);
        r2.addListener(new AnonymousClass2(this, r5, r4));
        ArrayList<Animator.AnimatorListener> r3 = this.showListeners;
        if (r3 == null) goto L23;
        Iterator<Animator.AnimatorListener> r6 = r3.iterator();
    L21:
        if (r6.hasNext() == false) goto L23;
        r2.addListener(r6.next());
    L23:
        r2.start();
    }

    private MotionSpec getDefaultShowMotionSpec() {
        if (this.defaultShowMotionSpec != null) goto L6;
        this.defaultShowMotionSpec = MotionSpec.createFromResource(this.view.getContext(), com.google.android.material.R.animator.design_fab_show_motion_spec);
    L6:
        return (MotionSpec) Preconditions.checkNotNull(this.defaultShowMotionSpec);
    }

    private MotionSpec getDefaultHideMotionSpec() {
        if (this.defaultHideMotionSpec != null) goto L6;
        this.defaultHideMotionSpec = MotionSpec.createFromResource(this.view.getContext(), com.google.android.material.R.animator.design_fab_hide_motion_spec);
    L6:
        return (MotionSpec) Preconditions.checkNotNull(this.defaultHideMotionSpec);
    }

    private AnimatorSet createAnimator(MotionSpec r7, float r8, float r9, float r10) {
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

    void addTransformationCallback(InternalTransformationCallback r2) {
        if (this.transformationCallbacks != null) goto L5;
        this.transformationCallbacks = new ArrayList();
    L5:
        this.transformationCallbacks.add(r2);
    }

    void removeTransformationCallback(InternalTransformationCallback r1) {
        ArrayList<InternalTransformationCallback> r0 = this.transformationCallbacks;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.remove(r1);
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

    final Drawable getContentBackground() {
        return this.contentBackground;
    }

    final void updatePadding() {
        Rect r0 = this.tmpRect;
        getPadding(r0);
        onPaddingUpdated(r0);
        this.shadowViewDelegate.setShadowPadding(r0.left, r0.top, r0.right, r0.bottom);
    }

    void getPadding(Rect r5) {
        if (this.ensureMinTouchTargetSize == false) goto L5;
        int r0 = (this.minTouchTargetSize - this.view.getSizeDimension()) / 2;
    L7:
        if (this.shadowPaddingEnabled == false) goto L9;
        float r1 = getElevation() + this.pressedTranslationZ;
    L10:
        int r4 = Math.max(r0, (int) Math.ceil(r1));
        int r2 = Math.max(r0, (int) Math.ceil(r1 * 1.5f));
        r5.set(r4, r2, r4, r2);
        return;
    L9:
        r1 = 0.0f;
        goto L10
    L5:
        r0 = 0;
        goto L7
    }

    void onPaddingUpdated(Rect r8) {
        Preconditions.checkNotNull(this.contentBackground, "Didn't initialize content background");
        if (shouldAddPadding() == false) goto L5;
        InsetDrawable r0 = new InsetDrawable(this.contentBackground, r8.left, r8.top, r8.right, r8.bottom);
        this.shadowViewDelegate.setBackgroundDrawable(r0);
        return;
    L5:
        this.shadowViewDelegate.setBackgroundDrawable(this.contentBackground);
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

    void onDetachedFromWindow() {
        ViewTreeObserver r0 = this.view.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener r1 = this.preDrawListener;
        if (r1 == null) goto L6;
        r0.removeOnPreDrawListener(r1);
        this.preDrawListener = null;
        return;
    }

    void onPreDraw() {
        float r0 = this.view.getRotation();
        if (this.rotation == r0) goto L6;
        this.rotation = r0;
        updateFromViewRotation();
        return;
    }

    private ViewTreeObserver.OnPreDrawListener getOrCreatePreDrawListener() {
        if (this.preDrawListener != null) goto L6;
        this.preDrawListener = new AnonymousClass5(this);
    L6:
        return this.preDrawListener;
    }

    MaterialShapeDrawable createShapeDrawable() {
        return new MaterialShapeDrawable((ShapeAppearanceModel) Preconditions.checkNotNull(this.shapeAppearance));
    }

    boolean isOrWillBeShown() {
        if (this.view.getVisibility() == 0) goto L9;
        if (this.animState == 2) goto L7;
        return false;
    L7:
        return true;
    L9:
        if (this.animState != 1) goto L11;
        return false;
    L11:
        return true;
    }

    boolean isOrWillBeHidden() {
        if (this.view.getVisibility() != 0) goto L9;
        if (this.animState == 1) goto L7;
        return false;
    L7:
        return true;
    L9:
        if (this.animState != 2) goto L11;
        return false;
    L11:
        return true;
    }

    private ValueAnimator createElevationAnimator(ShadowAnimatorImpl r3) {
        ValueAnimator r2 = new ValueAnimator();
        r2.setInterpolator(ELEVATION_ANIM_INTERPOLATOR);
        r2.setDuration(100);
        r2.addListener(r3);
        r2.addUpdateListener(r3);
        r2.setFloatValues(new float[]{0.0f, 1.0f});
        return r2;
    }

    private boolean shouldAnimateVisibilityChange() {
        if (ViewCompat.isLaidOut(this.view) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.view.isInEditMode() == true) goto L7;
        return true;
    }

    void updateFromViewRotation() {
        MaterialShapeDrawable r0 = this.shapeDrawable;
        if (r0 == null) goto L6;
        r0.setShadowCompatRotation((int) this.rotation);
        return;
    }
}
