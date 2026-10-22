package com.obric.common.oea.foundation.a.a.d;

import android.graphics.Path;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final double f8172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f8173d;

    public c() {
        this.f8172c = 0.017453292519943295d;
        this.f8173d = 0.6f;
    }

    @Override // com.obric.common.oea.foundation.a.a.d.d
    public Path a(float r51, float r52, float r53, float r54, float r55) {
        float r5 = r53 - r51;
        float r7 = Math.min(r5, r54 - r52);
        Path r15 = new Path();
        if (r55 == 0.0f) goto L14;
        if (r55 >= (0.5f * r7)) goto L14;
        float r9 = Math.min(r7 / 2.0f, (this.f8173d + 1.0f) * r55);
        float r8 = r7 / 4.0f;
        if (r55 <= r8) goto L10;
        float r14 = this.f8173d;
        float r10 = 1.0f - ((r55 - r8) / r8);
        float r11 = 90 * (1.0f - (r14 * r10));
        float r12 = 45 * r14;
    L11:
        float r16 = (90 - r11) / 2.0f;
        double r13 = r12 * r10;
        float r17 = (float) Math.tan(this.f8172c * r13);
        float r18 = ((float) Math.tan(((double) (r16 / 2.0f)) * this.f8172c)) * r55;
        float r3 = (float) ((Math.sin(((double) (r11 / 2.0f)) * this.f8172c) * ((double) r55)) * Math.sqrt(2.0d));
        float r19 = r18 * ((float) Math.cos(r13 * this.f8172c));
        float r0 = r19 * r17;
        float r4 = ((r9 - r3) - ((r17 + 1.0f) * r19)) / 3.0f;
        e r20 = new e(r51 + (r5 / 2.0f), r52);
        float r110 = r53 - r9;
        e r6 = new e(r110, r52);
        float r21 = r9 - (r4 * 2.0f);
        float r111 = r53 - r21;
        e r112 = new e(r111, r52);
        float r22 = r21 - r4;
        float r113 = r53 - r22;
        e r114 = new e(r113, r52);
        float r23 = r22 - r19;
        e r115 = new e(r53 - r23, r52 + r0);
        float r116 = r53 - r55;
        float r117 = r52 + r55;
        float r24 = r52 + r23;
        float r25 = r52 + r22;
        e r118 = new e(r53, r25);
        float r26 = r52 + r21;
        e r119 = new e(r53, r26);
        float r27 = r52 + r9;
        e r120 = new e(r53, r27);
        float r28 = r54 - r9;
        e r121 = new e(r53, r28);
        float r29 = r54 - r21;
        e r122 = new e(r53, r29);
        float r30 = r54 - r22;
        e r123 = new e(r53, r30);
        e r31 = new e(r53 - r0, r54 - r23);
        float r124 = r54 - r55;
        e r32 = new e(r113, r54);
        e r125 = new e(r111, r54);
        e r126 = new e(r110, r54);
        float r127 = r9 + r51;
        e r128 = new e(r127, r54);
        float r33 = r21 + r51;
        e r34 = new e(r33, r54);
        float r35 = r22 + r51;
        e r36 = new e(r35, r54);
        e r2 = new e(r23 + r51, r54 - r0);
        float r37 = r51 + r55;
        e r129 = new e(r51, r30);
        e r38 = new e(r51, r29);
        e r39 = new e(r51, r28);
        e r40 = new e(r51, r27);
        e r41 = new e(r51, r26);
        e r42 = new e(r51, r25);
        e r43 = new e(r0 + r51, r24);
        e r1 = new e(r35, r52);
        e r44 = new e(r33, r52);
        e r45 = new e(r127, r52);
        r15.moveTo(r20.c(), r20.d());
        r15.lineTo(r6.c(), r6.d());
        r15.cubicTo(r112.c(), r112.d(), r114.c(), r114.d(), r115.c(), r115.d());
        d.a r130 = d.f8174b;
        r130.a(r15, new e(r116, r117), r55, r16 + 270.0f, 360.0f - r16);
        r15.cubicTo(r118.c(), r118.d(), r119.c(), r119.d(), r120.c(), r120.d());
        r15.lineTo(r121.c(), r121.d());
        r15.cubicTo(r122.c(), r122.d(), r123.c(), r123.d(), r31.c(), r31.d());
        r130.a(r15, new e(r116, r124), r55, r16, 90.0f - r16);
        r15.cubicTo(r32.c(), r32.d(), r125.c(), r125.d(), r126.c(), r126.d());
        r15.lineTo(r128.c(), r128.d());
        r15.cubicTo(r34.c(), r34.d(), r36.c(), r36.d(), r2.c(), r2.d());
        r130.a(r15, new e(r37, r124), r55, r16 + 90.0f, 180.0f - r16);
        r15.cubicTo(r129.c(), r129.d(), r38.c(), r38.d(), r39.c(), r39.d());
        r15.lineTo(r40.c(), r40.d());
        r15.cubicTo(r41.c(), r41.d(), r42.c(), r42.d(), r43.c(), r43.d());
        r130.a(r15, new e(r37, r117), r55, r16 + 180.0f, 270.0f - r16);
        r15.cubicTo(r1.c(), r1.d(), r44.c(), r44.d(), r45.c(), r45.d());
        r15.close();
        return r15;
    L10:
        r10 = this.f8173d;
        r11 = 90 * (1.0f - r10);
        r12 = 45;
    L14:
        return b(r51, r52, r53, r54, r55);
    }

    @Override // com.obric.common.oea.foundation.a.a.d.d
    public boolean c(float r1, float r2) {
        if (r1 >= (r2 * 0.5f)) goto L5;
        return true;
    L5:
        return false;
    }
}
