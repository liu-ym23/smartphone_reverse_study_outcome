package com.airbnb.lottie.value;

import com.airbnb.lottie.utils.MiscUtils;

/* JADX INFO: loaded from: classes.dex */
public class LottieRelativeIntegerValueCallback extends LottieValueCallback<Integer> {
    @Override // com.airbnb.lottie.value.LottieValueCallback
    public /* bridge */ /* synthetic */ Integer getValue(LottieFrameInfo<Integer> r1) {
        return getValue(r1);
    }

    public LottieRelativeIntegerValueCallback() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.value.LottieValueCallback
    public Integer getValue(LottieFrameInfo<Integer> r4) {
        return Integer.valueOf(MiscUtils.lerp(r4.getStartValue().intValue(), r4.getEndValue().intValue(), r4.getInterpolatedKeyframeProgress()) + getOffset(r4).intValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Integer getOffset(LottieFrameInfo<Integer> r1) {
        if (this.value == 0) goto L7;
        return (Integer) this.value;
    L7:
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }
}
