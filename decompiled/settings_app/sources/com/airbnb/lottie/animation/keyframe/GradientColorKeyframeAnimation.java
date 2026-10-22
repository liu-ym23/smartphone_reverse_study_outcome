package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GradientColorKeyframeAnimation extends KeyframeAnimation<GradientColor> {
    private final GradientColor gradientColor;

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* bridge */ /* synthetic */ Object getValue(Keyframe r1, float r2) {
        return getValue(r1, r2);
    }

    public GradientColorKeyframeAnimation(List<Keyframe<GradientColor>> r3) {
        super(r3);
        int r0 = 0;
        GradientColor r4 = r3.get(0).startValue;
        if (r4 == null) goto L6;
        r0 = r4.getSize();
    L6:
        this.gradientColor = new GradientColor(new float[r0], new int[r0]);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    GradientColor getValue(Keyframe<GradientColor> r3, float r4) {
        this.gradientColor.lerp(r3.startValue, r3.endValue, r4);
        return this.gradientColor;
    }
}
