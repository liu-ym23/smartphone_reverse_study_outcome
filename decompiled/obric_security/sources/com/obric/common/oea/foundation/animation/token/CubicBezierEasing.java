package com.obric.common.oea.foundation.animation.token;

import com.obric.common.oea.foundation.animation.util.FloatFloatPair;
import com.obric.oui.calendar.format.DayFormatter;
import kotlin.Metadata;

/* JADX INFO: compiled from: OEasing.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/common/oea/foundation/animation/token/CubicBezierEasing;", "Lcom/obric/common/oea/foundation/animation/token/Easing;", "a", "", "b", "c", DayFormatter.DEFAULT_FORMAT, "(FFFF)V", "max", "min", "equals", "", "other", "", "hashCode", "", "throwNoSolution", "", "fraction", "toString", "", "transform", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class CubicBezierEasing implements Easing {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f12a;
    private final float b;
    private final float c;
    private final float d;
    private final float max;
    private final float min;

    public CubicBezierEasing(float r7, float r8, float r9, float r10) {
        this.f12a = r7;
        this.b = r8;
        this.c = r9;
        this.d = r10;
        FloatFloatPair r11 = OEasingKt.computeCubicVerticalBounds(0.0f, r8, r10, 1.0f, new float[5], 0);
        this.min = Float.intBitsToFloat((int) (r11.packedValue >> 32));
        this.max = Float.intBitsToFloat((int) (r11.packedValue & 4294967295L));
    }

    @Override // com.obric.common.oea.foundation.animation.token.Easing
    public float transform(float r5) {
        if (r5 > 0.0f) goto L5;
        return r5;
    L5:
        if (r5 >= 1.0f) goto L17;
        float r0 = OEasingKt.findFirstCubicRoot(0.0f - r5, this.f12a - r5, this.c - r5, 1.0f - r5);
        if (Float.isNaN(r0) == false) goto L9;
        throwNoSolution(r5);
    L9:
        float r6 = OEasingKt.evaluateCubic(this.b, this.d, r0);
        float r1 = this.min;
        float r4 = this.max;
        if (r6 >= r1) goto L13;
        r6 = r1;
    L13:
        if (r6 > r4) goto L15;
        return r6;
    L15:
        return r4;
    L17:
        return r5;
    }

    private final void throwNoSolution(float r5) {
        throw new IllegalArgumentException("The cubic curve with parameters (" + this.f12a + ", " + this.b + ", " + this.c + ", " + this.d + ") has no solution at " + r5);
    }

    public boolean equals(Object r3) {
        if ((r3 instanceof CubicBezierEasing) == false) goto L13;
        CubicBezierEasing r4 = (CubicBezierEasing) r3;
        if (this.f12a != r4.f12a) goto L13;
        if (this.b != r4.b) goto L13;
        if (this.c != r4.c) goto L13;
        if (this.d != r4.d) goto L13;
        return true;
    L13:
        return false;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.f12a) * 31) + Float.hashCode(this.b)) * 31) + Float.hashCode(this.c)) * 31) + Float.hashCode(this.d);
    }

    public String toString() {
        return "CubicBezierEasing(a=" + this.f12a + ", b=" + this.b + ", c=" + this.c + ", d=" + this.d + ')';
    }
}
