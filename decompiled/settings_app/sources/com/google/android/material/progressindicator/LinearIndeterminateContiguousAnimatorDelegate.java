package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.color.MaterialColors;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
final class LinearIndeterminateContiguousAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {
    private static final Property<LinearIndeterminateContiguousAnimatorDelegate, Float> ANIMATION_FRACTION = null;
    private static final int DURATION_PER_CYCLE_IN_MS = 333;
    private static final int TOTAL_DURATION_IN_MS = 667;
    private float animationFraction;
    private ObjectAnimator animator;
    private final BaseProgressIndicatorSpec baseSpec;
    private boolean dirtyColors;
    private FastOutSlowInInterpolator interpolator;
    private int newIndicatorColorIndex;

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void registerAnimatorsCompleteCallback(Animatable2Compat.AnimationCallback r1) {
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void requestCancelAnimatorAfterCurrentCycle() {
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void unregisterAnimatorsCompleteCallback() {
    }

    static /* synthetic */ int access$000(LinearIndeterminateContiguousAnimatorDelegate r0) {
        return r0.newIndicatorColorIndex;
    }

    static /* synthetic */ int access$002(LinearIndeterminateContiguousAnimatorDelegate r0, int r1) {
        r0.newIndicatorColorIndex = r1;
        return r1;
    }

    static /* synthetic */ BaseProgressIndicatorSpec access$100(LinearIndeterminateContiguousAnimatorDelegate r0) {
        return r0.baseSpec;
    }

    static /* synthetic */ boolean access$202(LinearIndeterminateContiguousAnimatorDelegate r0, boolean r1) {
        r0.dirtyColors = r1;
        return r1;
    }

    static /* synthetic */ float access$300(LinearIndeterminateContiguousAnimatorDelegate r0) {
        return r0.getAnimationFraction();
    }

    public LinearIndeterminateContiguousAnimatorDelegate(LinearProgressIndicatorSpec r2) {
        super(3);
        this.newIndicatorColorIndex = 1;
        this.baseSpec = r2;
        this.interpolator = new FastOutSlowInInterpolator();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void startAnimator() {
        maybeInitializeAnimators();
        resetPropertiesForNewStart();
        this.animator.start();
    }

    private void maybeInitializeAnimators() {
        if (this.animator != null) goto L6;
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this, ANIMATION_FRACTION, new float[]{0.0f, 1.0f});
        this.animator = r0;
        r0.setDuration(333);
        this.animator.setInterpolator(null);
        this.animator.setRepeatCount(-1);
        this.animator.addListener(new AnonymousClass1(this));
        return;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void cancelAnimatorImmediately() {
        ObjectAnimator r0 = this.animator;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void invalidateSpecValues() {
        resetPropertiesForNewStart();
    }

    private void updateSegmentPositions(int r5) {
        this.segmentPositions[0] = 0.0f;
        float r6 = getFractionInRange(r5, 0, TOTAL_DURATION_IN_MS);
        float[] r0 = this.segmentPositions;
        float[] r1 = this.segmentPositions;
        float r2 = this.interpolator.getInterpolation(r6);
        r1[2] = r2;
        r0[1] = r2;
        float[] r3 = this.segmentPositions;
        float[] r4 = this.segmentPositions;
        FastOutSlowInInterpolator r7 = this.interpolator;
        float r8 = r7.getInterpolation(r6 + 0.49925038f);
        r4[4] = r8;
        r3[3] = r8;
        this.segmentPositions[5] = 1.0f;
    }

    private void maybeUpdateSegmentColors() {
        if (this.dirtyColors == true) goto L5;
        return;
    L5:
        if (this.segmentPositions[3] >= 1.0f) goto L9;
        this.segmentColors[2] = this.segmentColors[1];
        this.segmentColors[1] = this.segmentColors[0];
        this.segmentColors[0] = MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[this.newIndicatorColorIndex], this.drawable.getAlpha());
        this.dirtyColors = false;
        return;
    }

    void resetPropertiesForNewStart() {
        this.dirtyColors = true;
        this.newIndicatorColorIndex = 1;
        Arrays.fill(this.segmentColors, MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[0], this.drawable.getAlpha()));
    }

    private float getAnimationFraction() {
        return this.animationFraction;
    }

    void setAnimationFraction(float r2) {
        this.animationFraction = r2;
        updateSegmentPositions((int) (r2 * 333.0f));
        maybeUpdateSegmentColors();
        this.drawable.invalidateSelf();
    }

    static {
        final Class<Float> r1 = Float.class;
        final String r2 = "animationFraction";
        ANIMATION_FRACTION = new AnonymousClass2(r1, r2);
    }
}
