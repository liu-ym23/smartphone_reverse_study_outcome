package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.color.MaterialColors;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
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

    static {
        final Class<Float> r1 = Float.class;
        final String r2 = "animationFraction";
        ANIMATION_FRACTION = new AnonymousClass2(r1, r2);
    }

    public LinearIndeterminateContiguousAnimatorDelegate(@NonNull LinearProgressIndicatorSpec r2) {
        super(3);
        this.newIndicatorColorIndex = 1;
        this.baseSpec = r2;
        this.interpolator = new FastOutSlowInInterpolator();
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

    private float getAnimationFraction() {
        return this.animationFraction;
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

    private void maybeUpdateSegmentColors() {
        if (this.dirtyColors == true) goto L5;
        return;
    L5:
        if (this.segmentPositions[3] >= 1.0f) goto L9;
        int[] r0 = this.segmentColors;
        r0[2] = r0[1];
        r0[1] = r0[0];
        r0[0] = MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[this.newIndicatorColorIndex], this.drawable.getAlpha());
        this.dirtyColors = false;
        return;
    }

    private void updateSegmentPositions(int r4) {
        this.segmentPositions[0] = 0.0f;
        float r5 = getFractionInRange(r4, 0, TOTAL_DURATION_IN_MS);
        float[] r0 = this.segmentPositions;
        float r1 = this.interpolator.getInterpolation(r5);
        r0[2] = r1;
        r0[1] = r1;
        float[] r2 = this.segmentPositions;
        FastOutSlowInInterpolator r3 = this.interpolator;
        float r6 = r3.getInterpolation(r5 + 0.49925038f);
        r2[4] = r6;
        r2[3] = r6;
        this.segmentPositions[5] = 1.0f;
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

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void registerAnimatorsCompleteCallback(@Nullable Animatable2Compat.AnimationCallback r1) {
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void requestCancelAnimatorAfterCurrentCycle() {
    }

    @VisibleForTesting
    void resetPropertiesForNewStart() {
        this.dirtyColors = true;
        this.newIndicatorColorIndex = 1;
        Arrays.fill(this.segmentColors, MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[0], this.drawable.getAlpha()));
    }

    @VisibleForTesting
    void setAnimationFraction(float r2) {
        this.animationFraction = r2;
        updateSegmentPositions((int) (r2 * 333.0f));
        maybeUpdateSegmentColors();
        this.drawable.invalidateSelf();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void startAnimator() {
        maybeInitializeAnimators();
        resetPropertiesForNewStart();
        this.animator.start();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void unregisterAnimatorsCompleteCallback() {
    }
}
