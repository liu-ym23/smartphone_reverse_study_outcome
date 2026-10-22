package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class SplitDimensionPathKeyframeAnimation extends BaseKeyframeAnimation<PointF, PointF> {
    private final PointF point;
    private final BaseKeyframeAnimation<Float, Float> xAnimation;
    private final BaseKeyframeAnimation<Float, Float> yAnimation;

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public /* bridge */ /* synthetic */ PointF getValue() {
        return getValue();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* bridge */ /* synthetic */ PointF getValue(Keyframe<PointF> r1, float r2) {
        return getValue(r1, r2);
    }

    public SplitDimensionPathKeyframeAnimation(BaseKeyframeAnimation<Float, Float> r2, BaseKeyframeAnimation<Float, Float> r3) {
        super(Collections.emptyList());
        this.point = new PointF();
        this.xAnimation = r2;
        this.yAnimation = r3;
        setProgress(getProgress());
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public void setProgress(float r3) {
        this.xAnimation.setProgress(r3);
        this.yAnimation.setProgress(r3);
        this.point.set(this.xAnimation.getValue().floatValue(), this.yAnimation.getValue().floatValue());
        int r4 = 0;
    L4:
        if (r4 >= this.listeners.size()) goto L6;
        this.listeners.get(r4).onValueChanged();
        r4 = r4 + 1;
        goto L4
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public PointF getValue() {
        return getValue(null, 0.0f);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    PointF getValue(Keyframe<PointF> r1, float r2) {
        return this.point;
    }
}
