package com.obric.common.oea.foundation.animation.spec.spring;

import com.obric.common.oea.foundation.animation.calculator.SpringSimulation;
import com.obric.common.oea.foundation.animation.spec.AnimationSpec;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: FloatSpringSpec.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0002\u0010\bJ(\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0002J\b\u0010\u001a\u001a\u00020\nH\u0016J \u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J-\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\u001dJ(\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u0015H\u0016J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f¨\u0006%"}, d2 = {"Lcom/obric/common/oea/foundation/animation/spec/spring/FloatSpringSpec;", "Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;", "", "dampingRatio", "stiffness", "delay", "", "visibilityThreshold", "(FFIF)V", "TAG", "", "getDampingRatio", "()F", "getDelay", "()I", "delta", "spring", "Lcom/obric/common/oea/foundation/animation/calculator/SpringSimulation;", "getStiffness", "getVisibilityThreshold", "clampPlayTimeNanos", "", "playTimeNanos", "initialValue", "targetValue", "initialVelocity", "dump", "getDurationNanos", "getValueFromNanos", "(JFFF)Ljava/lang/Float;", "getVelocityFromNanos", "isFinishedFromNanos", "", "durationNanos", "setAccuracy", "", "accuracy", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class FloatSpringSpec implements AnimationSpec<Float> {
    private final String TAG;
    private final float dampingRatio;
    private final int delay;
    private float delta;
    private final SpringSimulation spring;
    private final float stiffness;
    private final float visibilityThreshold;

    public FloatSpringSpec() {
        this(0.0f, 0.0f, 0, 0.0f, 15, null);
    }

    public FloatSpringSpec(float r1, float r2, int r3, float r4) {
        this.dampingRatio = r1;
        this.stiffness = r2;
        this.delay = r3;
        this.visibilityThreshold = r4;
        this.TAG = "FloatSpringSpec";
        SpringSimulation r5 = new SpringSimulation(1.0f);
        r5.setDampingRatio(r1);
        r5.setStiffness(r2);
        Unit r6 = Unit.INSTANCE;
        this.spring = r5;
        this.delta = 1.0f;
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public /* bridge */ /* synthetic */ long getDurationNanos(Float r1, Float r2, float r3) {
        return getDurationNanos(r1.floatValue(), r2.floatValue(), r3);
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public /* bridge */ /* synthetic */ Float getValueFromNanos(long r7, Float r9, Float r10, float r11) {
        return getValueFromNanos(r7, r9.floatValue(), r10.floatValue(), r11);
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public /* bridge */ /* synthetic */ float getVelocityFromNanos(long r7, Float r9, Float r10, float r11) {
        return getVelocityFromNanos(r7, r9.floatValue(), r10.floatValue(), r11);
    }

    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    public final float getStiffness() {
        return this.stiffness;
    }

    public final int getDelay() {
        return this.delay;
    }

    public /* synthetic */ FloatSpringSpec(float r2, float r3, int r4, float r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = 1.0f;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = 1.0f;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = 0;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = 0.01f;
    L14:
        this(r2, r3, r4, r5);
    }

    public final float getVisibilityThreshold() {
        return this.visibilityThreshold;
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public String dump() {
        return "FloatSpringSpec(dampingRatio: " + this.dampingRatio + ", stiffness: " + this.stiffness + ", delay: " + this.delay + ", visibilityThreshold: " + this.visibilityThreshold + ", delta: " + this.delta + ')';
    }

    public final void setAccuracy(float r1) {
        this.delta = r1;
    }

    public Float getValueFromNanos(long r3, float r5, float r6, float r7) {
        long r4 = clampPlayTimeNanos(r3, r5, r6, r7) / 1000000;
        this.spring.setFinalPosition(r6);
        return Float.valueOf(this.spring.updateValues$foundation_standardRelease(r5, r7, r4).getValue());
    }

    public float getVelocityFromNanos(long r3, float r5, float r6, float r7) {
        long r4 = clampPlayTimeNanos(r3, r5, r6, r7) / 1000000;
        this.spring.setFinalPosition(r6);
        return this.spring.updateValues$foundation_standardRelease(r5, r7, r4).getVelocity();
    }

    public long getDurationNanos(float r3, float r4, float r5) {
        float r0 = this.spring.getStiffness();
        float r1 = this.spring.getDampingRatio();
        float r6 = r3 - r4;
        float r7 = this.visibilityThreshold;
        float r8 = r5 / r7;
        return FloatSpringSpecKt.estimateAnimationDurationMillis(r0, r1, r8, r6 / r7, this.delta) * 1000000;
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public boolean isFinishedFromNanos(long r5, long r7) {
        if (r5 < (r7 + (((long) this.delay) * 1000000))) goto L5;
        return true;
    L5:
        return false;
    }

    private final long clampPlayTimeNanos(long r9, float r11, float r12, float r13) {
        long r14 = getDurationNanos(r11, r12, r13);
        long r2 = r9 - (((long) this.delay) * 1000000);
        if (r14 < 0) goto L5;
        long r6 = r14;
    L7:
        return RangesKt.coerceIn(r2, 0, r6);
    L5:
        r6 = 0;
        goto L7
    }
}
