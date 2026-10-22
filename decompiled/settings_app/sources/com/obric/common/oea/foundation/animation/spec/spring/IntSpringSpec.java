package com.obric.common.oea.foundation.animation.spec.spring;

import android.graphics.Color;
import com.obric.common.oea.foundation.animation.calculator.SpringSimulation;
import com.obric.common.oea.foundation.animation.spec.AnimationSpec;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: IntSpringSpec.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B7\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ(\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J\b\u0010\u001f\u001a\u00020\fH\u0016J \u0010 \u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0004H\u0016J-\u0010!\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\"J(\u0010#\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0004H\u0016J\u0018\u0010$\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u001aH\u0016J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004R\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000e¨\u0006)"}, d2 = {"Lcom/obric/common/oea/foundation/animation/spec/spring/IntSpringSpec;", "Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;", "", "dampingRatio", "", "stiffness", "delay", "visibilityThreshold", "isColor", "", "(FFIFZ)V", "TAG", "", "getDampingRatio", "()F", "getDelay", "()I", "delta", "()Z", "setColor", "(Z)V", "spring", "Lcom/obric/common/oea/foundation/animation/calculator/SpringSimulation;", "getStiffness", "getVisibilityThreshold", "clampPlayTimeNanos", "", "playTimeNanos", "initialValue", "targetValue", "initialVelocity", "dump", "getDurationNanos", "getValueFromNanos", "(JIIF)Ljava/lang/Integer;", "getVelocityFromNanos", "isFinishedFromNanos", "durationNanos", "setAccuracy", "", "accuracy", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class IntSpringSpec implements AnimationSpec<Integer> {
    private final String TAG;
    private final float dampingRatio;
    private final int delay;
    private float delta;
    private boolean isColor;
    private final SpringSimulation spring;
    private final float stiffness;
    private final float visibilityThreshold;

    public IntSpringSpec() {
        this(0.0f, 0.0f, 0, 0.0f, false, 31, null);
    }

    public IntSpringSpec(float r1, float r2, int r3, float r4, boolean r5) {
        this.dampingRatio = r1;
        this.stiffness = r2;
        this.delay = r3;
        this.visibilityThreshold = r4;
        this.isColor = r5;
        this.TAG = "IntSpringSpec";
        SpringSimulation r6 = new SpringSimulation(1.0f);
        r6.setDampingRatio(r1);
        r6.setStiffness(r2);
        Unit r7 = Unit.INSTANCE;
        this.spring = r6;
        this.delta = 1.0f;
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public /* bridge */ /* synthetic */ long getDurationNanos(Integer r1, Integer r2, float r3) {
        return getDurationNanos(r1.intValue(), r2.intValue(), r3);
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public /* bridge */ /* synthetic */ Integer getValueFromNanos(long r7, Integer r9, Integer r10, float r11) {
        return getValueFromNanos(r7, r9.intValue(), r10.intValue(), r11);
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public /* bridge */ /* synthetic */ float getVelocityFromNanos(long r7, Integer r9, Integer r10, float r11) {
        return getVelocityFromNanos(r7, r9.intValue(), r10.intValue(), r11);
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

    public final float getVisibilityThreshold() {
        return this.visibilityThreshold;
    }

    public /* synthetic */ IntSpringSpec(float r2, float r3, int r4, float r5, boolean r6, int r7, DefaultConstructorMarker r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = 1.0f;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = 1.0f;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = 0;
    L12:
        if ((r7 & 8) == 0) goto L15;
        r5 = 0.01f;
    L15:
        if ((r7 & 16) == 0) goto L17;
        r6 = false;
    L17:
        this(r2, r3, r4, r5, r6);
    }

    public final boolean isColor() {
        return this.isColor;
    }

    public final void setColor(boolean r1) {
        this.isColor = r1;
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public String dump() {
        return "IntSpringSpec(dampingRatio: " + this.dampingRatio + ", stiffness: " + this.stiffness + ", delay: " + this.delay + ", visibilityThreshold: " + this.visibilityThreshold + ", delta: " + this.delta + ')';
    }

    public final void setAccuracy(float r1) {
        this.delta = r1;
    }

    public Integer getValueFromNanos(long r8, int r10, int r11, float r12) {
        long r9 = clampPlayTimeNanos(r8, r10, r11, r12) / 1000000;
        if (this.isColor == false) goto L5;
        int r0 = Color.alpha(r10);
        int r1 = Color.red(r10);
        int r2 = Color.green(r10);
        int r13 = Color.blue(r10);
        int r3 = Color.alpha(r11);
        int r4 = Color.red(r11);
        int r5 = Color.green(r11);
        int r14 = Color.blue(r11);
        this.spring.setFinalPosition(r3);
        int r6 = (int) this.spring.updateValues$foundation_standardRelease(r0, r12, r9).getValue();
        this.spring.setFinalPosition(r4);
        int r7 = (int) this.spring.updateValues$foundation_standardRelease(r1, r12, r9).getValue();
        this.spring.setFinalPosition(r5);
        int r15 = (int) this.spring.updateValues$foundation_standardRelease(r2, r12, r9).getValue();
        this.spring.setFinalPosition(r14);
        int r16 = Color.argb(r6, r7, r15, (int) this.spring.updateValues$foundation_standardRelease(r13, r12, r9).getValue());
    L7:
        return Integer.valueOf(r16);
    L5:
        this.spring.setFinalPosition(r11);
        r16 = (int) this.spring.updateValues$foundation_standardRelease(r10, r12, r9).getValue();
        goto L7
    }

    public float getVelocityFromNanos(long r8, int r10, int r11, float r12) {
        long r9 = clampPlayTimeNanos(r8, r10, r11, r12) / 1000000;
        if (this.isColor == false) goto L6;
        float r0 = Color.alpha(r10);
        float r1 = Color.red(r10);
        float r2 = Color.green(r10);
        float r13 = Color.blue(r10);
        float r3 = Color.alpha(r11);
        float r4 = Color.red(r11);
        float r5 = Color.green(r11);
        float r14 = Color.blue(r11);
        this.spring.setFinalPosition(r3);
        float r6 = this.spring.updateValues$foundation_standardRelease(r0, r12, r9).getVelocity();
        this.spring.setFinalPosition(r4);
        float r7 = this.spring.updateValues$foundation_standardRelease(r1, r12, r9).getVelocity();
        this.spring.setFinalPosition(r5);
        float r15 = this.spring.updateValues$foundation_standardRelease(r2, r12, r9).getVelocity();
        this.spring.setFinalPosition(r14);
        float r16 = this.spring.updateValues$foundation_standardRelease(r13, r12, r9).getVelocity();
        return (float) Math.sqrt((((r6 * r6) + (r7 * r7)) + (r15 * r15)) + (r16 * r16));
    L6:
        this.spring.setFinalPosition(r11);
        return this.spring.updateValues$foundation_standardRelease(r10, r12, r9).getVelocity();
    }

    public long getDurationNanos(int r10, int r11, float r12) {
        float r0 = Color.alpha(r10);
        float r1 = Color.alpha(r11);
        float r2 = Color.red(r10);
        float r3 = Color.red(r11);
        float r4 = Color.green(r10);
        float r5 = Color.green(r11);
        float r13 = Color.blue(r10);
        float r14 = Color.blue(r11);
        float r6 = this.spring.getStiffness();
        float r7 = this.spring.getDampingRatio();
        float r8 = r0 - r1;
        float r9 = this.visibilityThreshold;
        long r15 = FloatSpringSpecKt.estimateAnimationDurationMillis(r6, r7, r12 / r9, r8 / r9, this.delta);
        float r16 = this.spring.getStiffness();
        float r17 = this.spring.getDampingRatio();
        float r18 = r2 - r3;
        float r19 = this.visibilityThreshold;
        long r20 = FloatSpringSpecKt.estimateAnimationDurationMillis(r16, r17, r12 / r19, r18 / r19, this.delta);
        float r21 = this.spring.getStiffness();
        float r22 = this.spring.getDampingRatio();
        float r23 = r4 - r5;
        float r24 = this.visibilityThreshold;
        long r25 = FloatSpringSpecKt.estimateAnimationDurationMillis(r21, r22, r12 / r24, r23 / r24, this.delta);
        float r26 = this.spring.getStiffness();
        float r27 = this.spring.getDampingRatio();
        float r110 = r13 - r14;
        float r111 = this.visibilityThreshold;
        return ComparisonsKt.maxOf(r15, new long[]{r20, r25, FloatSpringSpecKt.estimateAnimationDurationMillis(r26, r27, r12 / r111, r110 / r111, this.delta)}) * 1000000;
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public boolean isFinishedFromNanos(long r5, long r7) {
        if (r5 < (r7 + (((long) this.delay) * 1000000))) goto L5;
        return true;
    L5:
        return false;
    }

    private final long clampPlayTimeNanos(long r9, int r11, int r12, float r13) {
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
