package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class ValueCallbackKeyframeAnimation<K, A> extends BaseKeyframeAnimation<K, A> {
    private final LottieFrameInfo<A> frameInfo;
    private final A valueCallbackValue;

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    float getEndProgress() {
        return 1.0f;
    }

    public ValueCallbackKeyframeAnimation(LottieValueCallback<A> r2) {
        this(r2, null);
    }

    public ValueCallbackKeyframeAnimation(LottieValueCallback<A> r2, A r3) {
        super(Collections.emptyList());
        this.frameInfo = new LottieFrameInfo();
        setValueCallback(r2);
        this.valueCallbackValue = r3;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public void notifyListeners() {
        if (this.valueCallback == null) goto L6;
        super.notifyListeners();
        return;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public A getValue() {
        LottieValueCallback<A> r0 = this.valueCallback;
        A r4 = this.valueCallbackValue;
        return r0.getValueInternal(0.0f, 0.0f, r4, r4, getProgress(), getProgress(), getProgress());
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    A getValue(Keyframe<K> r1, float r2) {
        return getValue();
    }
}
