package com.obric.oui.animation.style;

import android.animation.ValueAnimator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class CommonStyleKt$windowBottomHide$2 implements ValueAnimator.AnimatorUpdateListener {
    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r1) {
        Intrinsics.f(r1, "animation");
        CommonStyleKt.a(r1.getAnimatedFraction());
    }
}
