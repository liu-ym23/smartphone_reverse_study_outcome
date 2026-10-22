package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.animation.ChildrenAlphaProperty;
import com.google.android.material.animation.DrawableAlphaProperty;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.animation.Positioning;
import com.google.android.material.circularreveal.CircularRevealCompat;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.math.MathUtils;
import com.ss.android.common.ApiConstants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    private float dependencyOriginalTranslationX;
    private float dependencyOriginalTranslationY;
    private final int[] tmpArray;
    private final Rect tmpRect;
    private final RectF tmpRectF1;
    private final RectF tmpRectF2;

    public static class FabTransformationSpec {
        public Positioning positioning;

        @Nullable
        public MotionSpec timings;

        public FabTransformationSpec() {
        }
    }

    public FabTransformationBehavior() {
        this.tmpRect = new Rect();
        this.tmpRectF1 = new RectF();
        this.tmpRectF2 = new RectF();
        this.tmpArray = new int[2];
    }

    @Nullable
    private ViewGroup calculateChildContentContainer(@NonNull View r2) {
        View r0 = r2.findViewById(R.id.mtrl_child_content_container);
        if (r0 == null) goto L7;
        return toViewGroupOrNull(r0);
    L7:
        if ((r2 instanceof TransformationChildLayout) == true) goto L14;
        if ((r2 instanceof TransformationChildCard) == true) goto L14;
        return toViewGroupOrNull(r2);
    L14:
        return toViewGroupOrNull(((ViewGroup) r2).getChildAt(0));
    }

    private void calculateChildVisibleBoundsAtEndOfExpansion(@NonNull View r1, @NonNull FabTransformationSpec r2, @NonNull MotionTiming r3, @NonNull MotionTiming r4, float r5, float r6, float r7, float r8, @NonNull RectF r9) {
        float r10 = calculateValueOfAnimationAtEndOfExpansion(r2, r3, r5, r7);
        float r11 = calculateValueOfAnimationAtEndOfExpansion(r2, r4, r6, r8);
        Rect r12 = this.tmpRect;
        r1.getWindowVisibleDisplayFrame(r12);
        RectF r13 = this.tmpRectF1;
        r13.set(r12);
        RectF r14 = this.tmpRectF2;
        calculateWindowBounds(r1, r14);
        r14.offset(r10, r11);
        r14.intersect(r13);
        r9.set(r14);
    }

    private void calculateDependencyWindowBounds(@NonNull View r1, @NonNull RectF r2) {
        calculateWindowBounds(r1, r2);
        r2.offset(this.dependencyOriginalTranslationX, this.dependencyOriginalTranslationY);
    }

    @NonNull
    private Pair<MotionTiming, MotionTiming> calculateMotionTiming(float r1, float r2, boolean r3, @NonNull FabTransformationSpec r4) {
        if (r1 != 0.0f) goto L5;
    L14:
        MotionTiming r0 = r4.timings.getTiming("translationXLinear");
        MotionTiming r5 = r4.timings.getTiming("translationYLinear");
    L16:
        return new Pair(r0, r5);
    L5:
        if (r2 == 0.0f) goto L14;
        if (r3 == true) goto L9;
    L10:
        if (r3 == true) goto L13;
        if (r2 <= 0.0f) goto L13;
    L12:
        r0 = r4.timings.getTiming("translationXCurveUpwards");
        r5 = r4.timings.getTiming("translationYCurveUpwards");
    L13:
        r0 = r4.timings.getTiming("translationXCurveDownwards");
        r5 = r4.timings.getTiming("translationYCurveDownwards");
        goto L16
    L9:
        if (r2 < 0.0f) goto L12;
        goto L10
    }

    private float calculateRevealCenterX(@NonNull View r3, @NonNull View r4, @NonNull Positioning r5) {
        RectF r0 = this.tmpRectF1;
        RectF r1 = this.tmpRectF2;
        calculateDependencyWindowBounds(r3, r0);
        calculateWindowBounds(r4, r1);
        r1.offset(-calculateTranslationX(r3, r4, r5), 0.0f);
        return r0.centerX() - r1.left;
    }

    private float calculateRevealCenterY(@NonNull View r3, @NonNull View r4, @NonNull Positioning r5) {
        RectF r0 = this.tmpRectF1;
        RectF r1 = this.tmpRectF2;
        calculateDependencyWindowBounds(r3, r0);
        calculateWindowBounds(r4, r1);
        r1.offset(0.0f, -calculateTranslationY(r3, r4, r5));
        return r0.centerY() - r1.top;
    }

    private float calculateTranslationX(@NonNull View r3, @NonNull View r4, @NonNull Positioning r5) {
        RectF r0 = this.tmpRectF1;
        RectF r1 = this.tmpRectF2;
        calculateDependencyWindowBounds(r3, r0);
        calculateWindowBounds(r4, r1);
        int r2 = r5.gravity & 7;
        if (r2 != 1) goto L5;
        float r6 = r1.centerX();
        float r7 = r0.centerX();
    L10:
        float r8 = r6 - r7;
    L14:
        return r8 + r5.xAdjustment;
    L5:
        if (r2 != 3) goto L7;
        r6 = r1.left;
        r7 = r0.left;
        goto L10
    L7:
        if (r2 == 5) goto L9;
        r8 = 0.0f;
        goto L14
    L9:
        r6 = r1.right;
        r7 = r0.right;
        goto L10
    }

    private float calculateTranslationY(@NonNull View r3, @NonNull View r4, @NonNull Positioning r5) {
        RectF r0 = this.tmpRectF1;
        RectF r1 = this.tmpRectF2;
        calculateDependencyWindowBounds(r3, r0);
        calculateWindowBounds(r4, r1);
        int r2 = r5.gravity & ApiConstants.OP_ERROR_UGC_POST_TOO_FAST;
        if (r2 != 16) goto L5;
        float r6 = r1.centerY();
        float r7 = r0.centerY();
    L10:
        float r8 = r6 - r7;
    L14:
        return r8 + r5.yAdjustment;
    L5:
        if (r2 != 48) goto L7;
        r6 = r1.top;
        r7 = r0.top;
        goto L10
    L7:
        if (r2 == 80) goto L9;
        r8 = 0.0f;
        goto L14
    L9:
        r6 = r1.bottom;
        r7 = r0.bottom;
        goto L10
    }

    private float calculateValueOfAnimationAtEndOfExpansion(@NonNull FabTransformationSpec r7, @NonNull MotionTiming r8, float r9, float r10) {
        long r0 = r8.getDelay();
        long r2 = r8.getDuration();
        MotionTiming r6 = r7.timings.getTiming("expansion");
        return AnimationUtils.lerp(r9, r10, r8.getInterpolator().getInterpolation((((r6.getDuration() + r6.getDelay()) + 17) - r0) / r2));
    }

    private void calculateWindowBounds(@NonNull View r4, RectF r5) {
        r5.set(0.0f, 0.0f, r4.getWidth(), r4.getHeight());
        int[] r3 = this.tmpArray;
        r4.getLocationInWindow(r3);
        r5.offsetTo(r3[0], r3[1]);
        r5.offset((int) (-r4.getTranslationX()), (int) (-r4.getTranslationY()));
    }

    private void createChildrenFadeAnimation(View r2, View r3, boolean r4, boolean r5, @NonNull FabTransformationSpec r6, @NonNull List<Animator> r7, List<Animator.AnimatorListener> r8) {
        if ((r3 instanceof ViewGroup) == true) goto L6;
        return;
    L6:
        if ((r3 instanceof CircularRevealWidget) == true) goto L8;
    L10:
        ViewGroup r1 = calculateChildContentContainer(r3);
        if (r1 != null) goto L14;
        return;
    L14:
        if (r4 == false) goto L18;
        if (r5 == true) goto L17;
        ChildrenAlphaProperty.CHILDREN_ALPHA.set(r1, Float.valueOf(0.0f));
    L17:
        ObjectAnimator r9 = ObjectAnimator.ofFloat(r1, ChildrenAlphaProperty.CHILDREN_ALPHA, new float[]{1.0f});
    L19:
        r6.timings.getTiming("contentFade").apply(r9);
        r7.add(r9);
        return;
    L18:
        r9 = ObjectAnimator.ofFloat(r1, ChildrenAlphaProperty.CHILDREN_ALPHA, new float[]{0.0f});
        goto L19
    L8:
        if (CircularRevealHelper.STRATEGY != 0) goto L10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void createColorAnimation(@NonNull View r1, View r2, boolean r3, boolean r4, @NonNull FabTransformationSpec r5, @NonNull List<Animator> r6, List<Animator.AnimatorListener> r7) {
        if ((r2 instanceof CircularRevealWidget) == true) goto L5;
        return;
    L5:
        CircularRevealWidget r8 = (CircularRevealWidget) r2;
        int r0 = getBackgroundTint(r1);
        int r9 = 16777215 & r0;
        if (r3 == false) goto L10;
        if (r4 == true) goto L9;
        r8.setCircularRevealScrimColor(r0);
    L9:
        ObjectAnimator r10 = ObjectAnimator.ofInt(r8, CircularRevealWidget.CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, new int[]{r9});
    L11:
        r10.setEvaluator(ArgbEvaluatorCompat.getInstance());
        r5.timings.getTiming(TypedValues.Custom.S_COLOR).apply(r10);
        r6.add(r10);
        return;
    L10:
        r10 = ObjectAnimator.ofInt(r8, CircularRevealWidget.CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, new int[]{r0});
        goto L11
    }

    private void createDependencyTranslationAnimation(@NonNull View r7, @NonNull View r8, boolean r9, @NonNull FabTransformationSpec r10, @NonNull List<Animator> r11) {
        float r2 = calculateTranslationX(r7, r8, r10.positioning);
        float r12 = calculateTranslationY(r7, r8, r10.positioning);
        Pair<MotionTiming, MotionTiming> r13 = calculateMotionTiming(r2, r12, r9, r10);
        MotionTiming r3 = (MotionTiming) r13.first;
        MotionTiming r14 = (MotionTiming) r13.second;
        Property r4 = View.TRANSLATION_X;
        if (r9 == true) goto L6;
        r2 = this.dependencyOriginalTranslationX;
    L6:
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r7, r4, new float[]{r2});
        Property r6 = View.TRANSLATION_Y;
        if (r9 == true) goto L10;
        r12 = this.dependencyOriginalTranslationY;
    L10:
        ObjectAnimator r15 = ObjectAnimator.ofFloat(r7, r6, new float[]{r12});
        r3.apply(r5);
        r14.apply(r15);
        r11.add(r5);
        r11.add(r15);
    }

    @TargetApi(21)
    private void createElevationAnimation(View r2, @NonNull View r3, boolean r4, boolean r5, @NonNull FabTransformationSpec r6, @NonNull List<Animator> r7, List<Animator.AnimatorListener> r8) {
        float r0 = ViewCompat.getElevation(r3) - ViewCompat.getElevation(r2);
        if (r4 == false) goto L7;
        if (r5 == true) goto L6;
        r3.setTranslationZ(-r0);
    L6:
        ObjectAnimator r1 = ObjectAnimator.ofFloat(r3, View.TRANSLATION_Z, new float[]{0.0f});
    L8:
        r6.timings.getTiming("elevation").apply(r1);
        r7.add(r1);
        return;
    L7:
        r1 = ObjectAnimator.ofFloat(r3, View.TRANSLATION_Z, new float[]{-r0});
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void createExpansionAnimation(@NonNull View r18, View r19, boolean r20, boolean r21, @NonNull FabTransformationSpec r22, float r23, float r24, @NonNull List<Animator> r25, @NonNull List<Animator.AnimatorListener> r26) {
        if ((r19 instanceof CircularRevealWidget) == true) goto L5;
        return;
    L5:
        final CircularRevealWidget r12 = (CircularRevealWidget) r19;
        float r1 = calculateRevealCenterX(r18, r19, r22.positioning);
        float r11 = calculateRevealCenterY(r18, r19, r22.positioning);
        ((FloatingActionButton) r18).getContentRect(this.tmpRect);
        float r13 = this.tmpRect.width() / 2.0f;
        MotionTiming r14 = r22.timings.getTiming("expansion");
        if (r20 == false) goto L12;
        if (r21 == true) goto L9;
        r12.setRevealInfo(new CircularRevealWidget.RevealInfo(r1, r11, r13));
    L9:
        if (r21 == false) goto L11;
        r13 = r12.getRevealInfo().radius;
    L11:
        Animator r10 = CircularRevealCompat.createCircularReveal(r12, r1, r11, MathUtils.distanceToFurthestCorner(r1, r11, 0.0f, 0.0f, r23, r24));
        r10.addListener(new AnonymousClass4(this, r12));
        createPreFillRadialExpansion(r19, r14.getDelay(), (int) r1, (int) r11, r13, r25);
    L13:
        r14.apply(r10);
        r25.add(r10);
        r26.add(CircularRevealCompat.createCircularRevealListener(r12));
        return;
    L12:
        float r6 = r12.getRevealInfo().radius;
        Animator r15 = CircularRevealCompat.createCircularReveal(r12, r1, r11, r13);
        int r7 = (int) r1;
        int r16 = (int) r11;
        createPreFillRadialExpansion(r19, r14.getDelay(), r7, r16, r6, r25);
        createPostFillRadialExpansion(r19, r14.getDelay(), r14.getDuration(), r22.timings.getTotalDuration(), r7, r16, r13, r25);
        r10 = r15;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void createIconFadeAnimation(View r3, final View r4, boolean r5, boolean r6, @NonNull FabTransformationSpec r7, @NonNull List<Animator> r8, @NonNull List<Animator.AnimatorListener> r9) {
        if ((r4 instanceof CircularRevealWidget) == true) goto L5;
        return;
    L5:
        if ((r3 instanceof ImageView) == false) goto L19;
        final CircularRevealWidget r0 = (CircularRevealWidget) r4;
        final Drawable r10 = ((ImageView) r3).getDrawable();
        if (r10 != null) goto L10;
        return;
    L10:
        r10.mutate();
        if (r5 == false) goto L15;
        if (r6 == true) goto L14;
        r10.setAlpha(255);
    L14:
        ObjectAnimator r11 = ObjectAnimator.ofInt(r10, DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, new int[]{0});
    L16:
        r11.addUpdateListener(new AnonymousClass2(this, r4));
        r7.timings.getTiming("iconFade").apply(r11);
        r8.add(r11);
        r9.add(new AnonymousClass3(this, r0, r10));
        return;
    L15:
        r11 = ObjectAnimator.ofInt(r10, DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, new int[]{255});
        goto L16
    }

    private void createPostFillRadialExpansion(View r1, long r2, long r4, long r6, int r8, int r9, float r10, @NonNull List<Animator> r11) {
        long r3 = r2 + r4;
        if (r3 >= r6) goto L6;
        Animator r0 = ViewAnimationUtils.createCircularReveal(r1, r8, r9, r10, r10);
        r0.setStartDelay(r3);
        r0.setDuration(r6 - r3);
        r11.add(r0);
        return;
    }

    private void createPreFillRadialExpansion(View r3, long r4, int r6, int r7, float r8, @NonNull List<Animator> r9) {
        if (r4 <= 0) goto L6;
        Animator r2 = ViewAnimationUtils.createCircularReveal(r3, r6, r7, r8, r8);
        r2.setStartDelay(0);
        r2.setDuration(r4);
        r9.add(r2);
        return;
    }

    private void createTranslationAnimation(@NonNull View r16, @NonNull View r17, boolean r18, boolean r19, @NonNull FabTransformationSpec r20, @NonNull List<Animator> r21, List<Animator.AnimatorListener> r22, @NonNull RectF r23) {
        float r7 = calculateTranslationX(r16, r17, r20.positioning);
        float r1 = calculateTranslationY(r16, r17, r20.positioning);
        Pair<MotionTiming, MotionTiming> r8 = calculateMotionTiming(r7, r1, r18, r20);
        MotionTiming r11 = (MotionTiming) r8.first;
        MotionTiming r12 = (MotionTiming) r8.second;
        if (r18 == false) goto L7;
        if (r19 == true) goto L6;
        r17.setTranslationX(-r7);
        r17.setTranslationY(-r1);
    L6:
        ObjectAnimator r13 = ObjectAnimator.ofFloat(r17, View.TRANSLATION_X, new float[]{0.0f});
        ObjectAnimator r14 = ObjectAnimator.ofFloat(r17, View.TRANSLATION_Y, new float[]{0.0f});
        calculateChildVisibleBoundsAtEndOfExpansion(r17, r20, r11, r12, -r7, -r1, 0.0f, 0.0f, r23);
    L8:
        r11.apply(r13);
        r12.apply(r14);
        r21.add(r13);
        r21.add(r14);
        return;
    L7:
        r13 = ObjectAnimator.ofFloat(r17, View.TRANSLATION_X, new float[]{-r7});
        r14 = ObjectAnimator.ofFloat(r17, View.TRANSLATION_Y, new float[]{-r1});
        goto L8
    }

    private int getBackgroundTint(@NonNull View r2) {
        ColorStateList r1 = ViewCompat.getBackgroundTintList(r2);
        if (r1 != null) goto L5;
        return 0;
    L5:
        return r1.getColorForState(r2.getDrawableState(), r1.getDefaultColor());
    }

    @Nullable
    private ViewGroup toViewGroupOrNull(View r1) {
        if ((r1 instanceof ViewGroup) == true) goto L5;
        return null;
    L5:
        return (ViewGroup) r1;
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean layoutDependsOn(@NonNull CoordinatorLayout r1, @NonNull View r2, @NonNull View r3) {
        if (r2.getVisibility() == 8) goto L13;
        if ((r3 instanceof FloatingActionButton) == false) goto L14;
        int r0 = ((FloatingActionButton) r3).getExpandedComponentIdHint();
        if (r0 != 0) goto L9;
    L10:
        return true;
    L9:
        if (r0 == r2.getId()) goto L10;
        return false;
    L14:
        return false;
    L13:
        throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams r1) {
        if (r1.dodgeInsetEdges != 0) goto L6;
        r1.dodgeInsetEdges = 80;
        return;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    @NonNull
    public AnimatorSet onCreateExpandedStateChangeAnimation(@NonNull final View r16, @NonNull final View r17, final boolean r18, boolean r19) {
        FabTransformationSpec r12 = onCreateMotionSpec(r17.getContext(), r18);
        if (r18 == false) goto L5;
        this.dependencyOriginalTranslationX = r16.getTranslationX();
        this.dependencyOriginalTranslationY = r16.getTranslationY();
    L5:
        List<Animator> r13 = new ArrayList();
        ArrayList r14 = new ArrayList();
        createElevationAnimation(r16, r17, r18, r19, r12, r13, r14);
        RectF r9 = this.tmpRectF1;
        createTranslationAnimation(r16, r17, r18, r19, r12, r13, r14, r9);
        float r8 = r9.width();
        float r10 = r9.height();
        createDependencyTranslationAnimation(r16, r17, r18, r12, r13);
        createIconFadeAnimation(r16, r17, r18, r19, r12, r13, r14);
        createExpansionAnimation(r16, r17, r18, r19, r12, r8, r10, r13, r14);
        createColorAnimation(r16, r17, r18, r19, r12, r13, r14);
        createChildrenFadeAnimation(r16, r17, r18, r19, r12, r13, r14);
        AnimatorSet r0 = new AnimatorSet();
        AnimatorSetCompat.playTogether(r0, r13);
        r0.addListener(new AnonymousClass1(this, r18, r17, r16));
        int r1 = r14.size();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        r0.addListener((Animator.AnimatorListener) r14.get(r2));
        r2 = r2 + 1;
        goto L6
    L8:
        return r0;
    }

    public abstract FabTransformationSpec onCreateMotionSpec(Context r1, boolean r2);

    public FabTransformationBehavior(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.tmpRect = new Rect();
        this.tmpRectF1 = new RectF();
        this.tmpRectF2 = new RectF();
        this.tmpArray = new int[2];
    }
}
