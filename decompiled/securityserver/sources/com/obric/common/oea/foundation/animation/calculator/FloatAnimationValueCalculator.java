package com.obric.common.oea.foundation.animation.calculator;

import com.obric.common.oea.foundation.animation.spec.AnimationSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FloatAnimationValueCalculator implements AnimationValueCalculator<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FloatAnimationValueCalculator f106a = null;

    static {
        f106a = new FloatAnimationValueCalculator();
    }

    @Override // com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator
    public final Object a(long r7, Object r9, Object r10, float r11, AnimationSpec r12) {
        float r6 = ((Number) r9).floatValue();
        float r13 = ((Number) r10).floatValue();
        Intrinsics.f(r12, "spec");
        return (Float) r12.d(r7, Float.valueOf(r6), Float.valueOf(r13), r11);
    }

    @Override // com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator
    public final float b(long r7, Object r9, Object r10, float r11, AnimationSpec r12) {
        float r6 = ((Number) r9).floatValue();
        float r13 = ((Number) r10).floatValue();
        Intrinsics.f(r12, "spec");
        return r12.a(r7, Float.valueOf(r6), Float.valueOf(r13), r11);
    }

    @Override // com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator
    public final boolean c(long r1, long r3, AnimationSpec r5) {
        Intrinsics.f(r5, "spec");
        return r5.e(r1, r3);
    }
}
