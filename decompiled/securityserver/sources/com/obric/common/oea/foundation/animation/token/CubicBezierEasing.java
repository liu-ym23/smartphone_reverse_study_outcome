package com.obric.common.oea.foundation.animation.token;

import a.a;
import com.obric.common.oea.foundation.animation.util.FloatFloatPair;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CubicBezierEasing implements Easing {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f127a;
    public final float b;
    public final float c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f128d;

    public CubicBezierEasing(float r25, float r26, float r27, float r28) {
        this.f127a = r25;
        this.b = r26;
        this.c = r27;
        this.f128d = r28;
        float[] r0 = new float[5];
        int r4 = OEasingKt.f129a;
        float r5 = (r26 - 0.0f) * 3.0f;
        float r7 = (r28 - r26) * 3.0f;
        float r9 = (1.0f - r28) * 3.0f;
        double r10 = r5;
        double r12 = r7;
        double r14 = r9;
        double r18 = r12 * 2.0d;
        double r20 = (r10 - r18) + r14;
        int r6 = 0;
        if (r20 == 0.0d) goto L13;
        double r15 = -Math.sqrt((r12 * r12) - (r14 * r10));
        double r11 = (-r10) + r12;
        int r13 = OEasingKt.a((float) ((-(r15 + r11)) / r20), r0, 0);
        int r16 = OEasingKt.a((float) ((r15 - r11) / r20), r0, r13) + r13;
        if (r16 <= 1) goto L16;
        float r17 = r0[0];
        float r19 = r0[1];
        if (r17 <= r19) goto L10;
        r0[0] = r19;
        r0[1] = r17;
        goto L16
    L10:
        if (r17 != r19) goto L16;
        r16 = r16 - 1;
    L16:
        float r110 = (r7 - r5) * 2.0f;
        int r8 = OEasingKt.a((-r110) / (((r9 - r7) * 2.0f) - r110), r0, r16) + r16;
        float r21 = Math.min(0.0f, 1.0f);
        float r111 = Math.max(0.0f, 1.0f);
    L17:
        if (r6 >= r8) goto L19;
        float r112 = r0[r6];
        float r113 = (((((((((r26 - r28) * 3.0f) + 1.0f) - 0.0f) * r112) + (((r28 - (r26 * 2.0f)) + 0.0f) * 3.0f)) * r112) + r5) * r112) + 0.0f;
        r21 = Math.min(r21, r113);
        r111 = Math.max(r111, r113);
        r6 = r6 + 1;
        goto L17
    L19:
        long r1 = new FloatFloatPair(r21, r111).f130a;
        Float.intBitsToFloat((int) (r1 >> 32));
        Float.intBitsToFloat((int) (r1 & 4294967295L));
        return;
    L13:
        if (r12 == r14) goto L15;
        r16 = OEasingKt.a((float) ((r18 - r14) / (r18 - (r14 * 2.0d))), r0, 0);
        goto L16
    L15:
        r16 = 0;
        goto L16
    }

    public final boolean equals(Object r3) {
        if ((r3 instanceof CubicBezierEasing) == false) goto L13;
        CubicBezierEasing r4 = (CubicBezierEasing) r3;
        float r0 = r4.f127a;
        if (this.f127a != r0) goto L13;
        if (this.b != r4.b) goto L13;
        if (this.c != r4.c) goto L13;
        if (this.f128d != r4.f128d) goto L13;
        return true;
    L13:
        return false;
    }

    public final int hashCode() {
        int r0 = Float.hashCode(this.f127a) * 31;
        int r1 = a.b(this.b, r0, 31);
        int r2 = a.b(this.c, r1, 31);
        return Float.hashCode(this.f128d) + r2;
    }

    public final String toString() {
        return "CubicBezierEasing(a=" + this.f127a + ", b=" + this.b + ", c=" + this.c + ", d=" + this.f128d + ')';
    }
}
