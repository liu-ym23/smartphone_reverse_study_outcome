package com.obric.common.oea.foundation.animation.spec.tween;

import android.graphics.Color;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.obric.common.oea.foundation.animation.spec.AnimationSpec;
import com.obric.common.oea.foundation.animation.token.CubicBezierEasing;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.common.oea.foundation.animation.token.TokenKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: IntTweenSpec.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J-\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001bH\u0016¢\u0006\u0002\u0010\u001dJ(\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0013H\u0016J \u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u001bH\u0002R\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006%"}, d2 = {"Lcom/obric/common/oea/foundation/animation/spec/tween/IntTweenSpec;", "Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;", "", "durationMillis", "delay", "easing", "Lcom/obric/common/oea/foundation/animation/token/Token$Easing;", "isColor", "", "(IILcom/obric/common/oea/foundation/animation/token/Token$Easing;Z)V", "getDelay", "()I", "getDurationMillis", "getEasing", "()Lcom/obric/common/oea/foundation/animation/token/Token$Easing;", "()Z", "setColor", "(Z)V", "clampPlayTimeNanos", "", "playTimeNanos", "dump", "", "getDurationNanos", "initialValue", "targetValue", "initialVelocity", "", "getValueFromNanos", "(JIIF)Ljava/lang/Integer;", "getVelocityFromNanos", "isFinishedFromNanos", "durationNanos", "lerp", "start", TraceStatsConsts.STATS_KEY_END, "fraction", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class IntTweenSpec implements AnimationSpec<Integer> {
    private final int delay;
    private final int durationMillis;
    private final Token.Easing easing;
    private boolean isColor;

    private final float lerp(float r1, float r2, float r3) {
        return r1 + ((r2 - r1) * r3);
    }

    public IntTweenSpec(int r2, int r3, Token.Easing r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "easing");
        this.durationMillis = r2;
        this.delay = r3;
        this.easing = r4;
        this.isColor = r5;
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

    public final int getDurationMillis() {
        return this.durationMillis;
    }

    public final int getDelay() {
        return this.delay;
    }

    public /* synthetic */ IntTweenSpec(int r2, int r3, Token.Easing r4, boolean r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = Token.Easing.OUI_ANIMATION_EASING_STANDARD;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = false;
    L11:
        this(r2, r3, r4, r5);
    }

    public final Token.Easing getEasing() {
        return this.easing;
    }

    public final boolean isColor() {
        return this.isColor;
    }

    public final void setColor(boolean r1) {
        this.isColor = r1;
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public String dump() {
        return "IntTweenSpec(durationMillis: " + this.durationMillis + ", delay: " + this.delay + ", easing: " + this.easing + ", isColor: " + this.isColor + ')';
    }

    public Integer getValueFromNanos(long r6, int r8, int r9, float r10) {
        long r7 = clampPlayTimeNanos(r6);
        int r11 = this.durationMillis;
        float r0 = 1.0f;
        if (r11 != 0) goto L5;
        float r12 = 1.0f;
    L7:
        if (this.easing != Token.Easing.OUI_ANIMATION_EASING_LINEAR) goto L9;
        float r13 = TokenKt.toLinearEasing(this.easing).transform(r12);
    L18:
        if (this.isColor == false) goto L20;
        float r14 = Color.alpha(r8);
        float r15 = Color.red(r8);
        float r1 = Color.green(r8);
        float r16 = Color.blue(r8);
        int r5 = Color.argb((int) lerp(r14, Color.alpha(r9), r13), (int) lerp(r15, Color.red(r9), r13), (int) lerp(r1, Color.green(r9), r13), (int) lerp(r16, Color.blue(r9), r13));
    L22:
        return Integer.valueOf(r5);
    L20:
        r5 = (int) lerp(r8, r9, r13);
        goto L22
    L9:
        CubicBezierEasing r17 = TokenKt.toCubicBezierEasing(this.easing);
        if (r12 >= 0.0f) goto L13;
        r12 = 0.0f;
    L13:
        if (r12 > 1.0f) goto L16;
        r0 = r12;
    L16:
        r13 = r17.transform(r0);
        goto L18
    L5:
        r12 = r7 / (((long) r11) * 1000000);
        goto L7
    }

    public float getVelocityFromNanos(long r10, int r12, int r13, float r14) {
        long r1 = clampPlayTimeNanos(r10);
        if (r1 >= 0) goto L6;
        return 0.0f;
    L6:
        if (r1 != 0) goto L8;
        return r14;
    L8:
        int r11 = getValueFromNanos(r1 - 1000000, r12, r13, r14).intValue();
        int r15 = getValueFromNanos(r1, r12, r13, r14).intValue();
        if (this.isColor == false) goto L12;
        float r9 = Color.alpha(r11);
        float r16 = Color.red(r11);
        float r17 = Color.green(r11);
        float r18 = Color.blue(r11);
        float r0 = Color.alpha(r15);
        float r2 = Color.red(r15);
        float r3 = (r0 - r9) * 1000.0f;
        float r4 = (r2 - r16) * 1000.0f;
        float r5 = (Color.green(r15) - r17) * 1000.0f;
        float r19 = (Color.blue(r15) - r18) * 1000.0f;
        return (float) Math.sqrt((((r3 * r3) + (r4 * r4)) + (r5 * r5)) + (r19 * r19));
    L12:
        return (r15 - r11) * 1000.0f;
    }

    private final long clampPlayTimeNanos(long r11) {
        return RangesKt.coerceIn(r11 - (((long) this.delay) * 1000000), 0, ((long) this.durationMillis) * 1000000);
    }

    public long getDurationNanos(int r1, int r2, float r3) {
        return ((long) this.durationMillis) * 1000000;
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public boolean isFinishedFromNanos(long r5, long r7) {
        if (r5 < (r7 + (((long) this.delay) * 1000000))) goto L5;
        return true;
    L5:
        return false;
    }
}
