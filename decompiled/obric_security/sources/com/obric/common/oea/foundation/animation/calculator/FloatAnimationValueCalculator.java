package com.obric.common.oea.foundation.animation.calculator;

import com.obric.common.oea.foundation.animation.spec.AnimationSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FloatAnimationValueCalculator.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J;\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0016¢\u0006\u0002\u0010\fJ6\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0016J&\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/common/oea/foundation/animation/calculator/FloatAnimationValueCalculator;", "Lcom/obric/common/oea/foundation/animation/calculator/AnimationValueCalculator;", "", "()V", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "spec", "Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;", "(JFFFLcom/obric/common/oea/foundation/animation/spec/AnimationSpec;)Ljava/lang/Float;", "getVelocityFromNanos", "isFinishedFromNanos", "", "durationNanos", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class FloatAnimationValueCalculator implements AnimationValueCalculator<Float> {
    public static final FloatAnimationValueCalculator INSTANCE = null;

    static {
        INSTANCE = new FloatAnimationValueCalculator();
    }

    private FloatAnimationValueCalculator() {
    }

    @Override // com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator
    public /* bridge */ /* synthetic */ Float getValueFromNanos(long r8, Float r10, Float r11, float r12, AnimationSpec<Float> r13) {
        return getValueFromNanos(r8, r10.floatValue(), r11.floatValue(), r12, r13);
    }

    @Override // com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator
    public /* bridge */ /* synthetic */ float getVelocityFromNanos(long r8, Float r10, Float r11, float r12, AnimationSpec<Float> r13) {
        return getVelocityFromNanos(r8, r10.floatValue(), r11.floatValue(), r12, r13);
    }

    public Float getValueFromNanos(long r7, float r9, float r10, float r11, AnimationSpec<Float> r12) {
        Intrinsics.checkNotNullParameter(r12, "spec");
        return r12.getValueFromNanos(r7, Float.valueOf(r9), Float.valueOf(r10), r11);
    }

    public float getVelocityFromNanos(long r7, float r9, float r10, float r11, AnimationSpec<Float> r12) {
        Intrinsics.checkNotNullParameter(r12, "spec");
        return r12.getVelocityFromNanos(r7, Float.valueOf(r9), Float.valueOf(r10), r11);
    }

    @Override // com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator
    public boolean isFinishedFromNanos(long r1, long r3, AnimationSpec<Float> r5) {
        Intrinsics.checkNotNullParameter(r5, "spec");
        return r5.isFinishedFromNanos(r1, r3);
    }
}
