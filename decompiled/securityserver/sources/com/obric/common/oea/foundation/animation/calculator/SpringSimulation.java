package com.obric.common.oea.foundation.animation.calculator;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SpringSimulation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f109a;
    public boolean b;
    public double c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f110d;
    public double e;
    public float f;
    public float g;

    public final Motion a(float r17, float r18, long r19) {
        if (this.b == false) goto L6;
    L16:
        double r4 = r19 / 1000.0d;
        float r2 = r17 - this.g;
        float r6 = this.f;
        if (r6 <= 1) goto L20;
        double r3 = r2;
        double r7 = this.f110d;
        double r10 = r18;
        double r12 = this.c;
        double r8 = r3 - (((r7 * r3) - r10) / (r7 - r12));
        double r5 = ((r3 * r7) - r10) / (r7 - r12);
        double r11 = (Math.exp(this.c * r4) * r5) + (Math.exp(r7 * r4) * r8);
        double r9 = this.f110d;
        double r13 = Math.exp(r9 * r4) * (r8 * r9);
        double r14 = this.c;
        double r15 = (Math.exp(r14 * r4) * (r5 * r14)) + r13;
    L23:
        long r16 = Float.floatToRawIntBits((float) (r11 + ((double) this.g)));
        return new Motion((((long) Float.floatToRawIntBits((float) r15)) & 4294967295L) | (r16 << 32));
    L20:
        if (r6 != 1.0f) goto L22;
        double r20 = this.f109a;
        double r1 = r2;
        double r110 = (r20 * r1) + ((double) r18);
        double r21 = (r110 * r4) + r1;
        double r22 = Math.exp((-r20) * r4) * r21;
        double r23 = Math.exp((-this.f109a) * r4) * r21;
        double r24 = this.f109a;
        r15 = (Math.exp((-r24) * r4) * r110) + (r23 * (-r24));
        r11 = r22;
        goto L23
    L22:
        double r25 = ((double) 1) / this.e;
        double r111 = this.f109a;
        double r26 = r2;
        double r27 = (((((double) r6) * r111) * r26) + ((double) r18)) * r25;
        double r28 = Math.exp((((double) (-r6)) * r111) * r4) * ((Math.sin(this.e * r4) * r27) + (Math.cos(this.e * r4) * r26));
        double r112 = this.f109a;
        float r29 = this.f;
        double r113 = ((-r112) * r28) * ((double) r29);
        double r30 = Math.exp((((double) (-r29)) * r112) * r4);
        double r114 = this.e;
        double r31 = Math.sin(r114 * r4) * ((-r114) * r26);
        double r115 = this.e;
        r15 = (((Math.cos(r115 * r4) * (r27 * r115)) + r31) * r30) + r113;
        r11 = r28;
        goto L23
    L6:
        if (this.g == Float.MAX_VALUE) goto L26;
        float r32 = this.f;
        double r33 = r32;
        double r34 = r33 * r33;
        float r35 = 1;
        if (r32 <= r35) goto L11;
        double r36 = this.f109a;
        double r37 = r34 - ((double) 1);
        this.c = (Math.sqrt(r37) * r36) + (((double) (-r32)) * r36);
        double r38 = -this.f;
        double r39 = this.f109a;
        this.f110d = (r38 * r39) - (Math.sqrt(r37) * r39);
    L15:
        this.b = true;
        goto L16
    L11:
        if (r32 < 0) goto L15;
        if (r32 >= r35) goto L15;
        this.e = Math.sqrt(((double) 1) - r34) * this.f109a;
        goto L15
    L26:
        throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }
}
