package com.obric.oui.drawble;

import android.animation.ValueAnimator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class RotatingDrawable$start$$inlined$apply$lambda$1 implements ValueAnimator.AnimatorUpdateListener {
    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r1) {
        Intrinsics.f(r1, "it");
        Object r0 = r1.getAnimatedValue();
        if (r0 == null) goto L7;
        ((Integer) r0).intValue();
        throw null;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
