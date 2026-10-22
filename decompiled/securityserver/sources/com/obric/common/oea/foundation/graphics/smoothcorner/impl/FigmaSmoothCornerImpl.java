package com.obric.common.oea.foundation.graphics.smoothcorner.impl;

import android.graphics.Path;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FigmaSmoothCornerImpl extends ISmoothCornerImpl {
    public final double b;
    public final float c;

    public FigmaSmoothCornerImpl() {
        this.b = 0.017453292519943295d;
        this.c = 0.6f;
    }

    @Override // com.obric.common.oea.foundation.graphics.smoothcorner.impl.ISmoothCornerImpl
    public final Path a(float r43, float r44, float r45, float r46, float r47) {
        float r1 = r45 - r43;
        float r2 = Math.min(r1, r46 - r44);
        Path r12 = new Path();
        if (r47 == 0.0f) goto L14;
        if (r47 >= (0.5f * r2)) goto L14;
        float r5 = this.c;
        float r4 = Math.min(r2 / 2.0f, (r5 + 1.0f) * r47);
        float r3 = r2 / 4.0f;
        if (r47 <= r3) goto L10;
        float r13 = 1.0f - ((r47 - r3) / r3);
        float r16 = (1.0f - (r5 * r13)) * 90;
        float r6 = (45 * r5) * r13;
    L11:
        float r14 = (90 - r16) / 2.0f;
        double r7 = this.b;
        double r15 = ((double) r6) * r7;
        float r0 = (float) Math.tan(r15);
        float r8 = ((float) Math.tan(((double) (r14 / 2.0f)) * r7)) * r47;
        float r9 = (float) (Math.sqrt(2.0d) * (Math.sin(((double) (r16 / 2.0f)) * r7) * ((double) r47)));
        float r10 = r8 * ((float) Math.cos(r15));
        float r11 = r10 * r0;
        float r17 = ((r4 - r9) - ((r0 + 1.0f) * r10)) / 3.0f;
        float r18 = r45 - r4;
        float r19 = r4 - (r17 * 2.0f);
        float r110 = r45 - r19;
        float r20 = r19 - r17;
        float r111 = r45 - r20;
        float r21 = r20 - r10;
        float r112 = r44 + r11;
        float r113 = r45 - r47;
        float r114 = r44 + r47;
        float r25 = r44 + r20;
        float r26 = r44 + r19;
        float r22 = r44 + r4;
        float r23 = r46 - r4;
        float r28 = r46 - r19;
        float r29 = r46 - r20;
        float r24 = r46 - r47;
        float r34 = r46 - r11;
        float r27 = r4 + r43;
        float r35 = r43 + r19;
        float r36 = r43 + r20;
        float r30 = r43 + r47;
        float r31 = r11 + r43;
        r12.moveTo((r1 / 2.0f) + r43, r44);
        r12.lineTo(r18, r44);
        r12.cubicTo(r110, r44, r111, r44, r45 - r21, r112);
        ISmoothCornerImpl.Companion.a(r12, new Point(r113, r114), r47, r14 + 270.0f, 360.0f - r14);
        r12.cubicTo(r45, r25, r45, r26, r45, r22);
        r12.lineTo(r45, r23);
        r12.cubicTo(r45, r28, r45, r29, r45 - r11, r46 - r21);
        ISmoothCornerImpl.Companion.a(r12, new Point(r113, r24), r47, r14, 90.0f - r14);
        r12.cubicTo(r111, r46, r110, r46, r18, r46);
        r12.lineTo(r27, r46);
        r12.cubicTo(r35, r46, r36, r46, r43 + r21, r34);
        ISmoothCornerImpl.Companion.a(r12, new Point(r30, r24), r47, 90.0f + r14, 180.0f - r14);
        r12.cubicTo(r43, r29, r43, r28, r43, r23);
        r12.lineTo(r43, r22);
        r12.cubicTo(r43, r26, r43, r25, r31, r44 + r21);
        ISmoothCornerImpl.Companion.a(r12, new Point(r30, r114), r47, r14 + 180.0f, 270.0f - r14);
        r12.cubicTo(r36, r44, r35, r44, r27, r44);
        r12.close();
        return r12;
    L10:
        r16 = (1.0f - r5) * 90;
        r6 = 45 * r5;
    L14:
        return ISmoothCornerImpl.b(r43, r44, r45, r46, r47);
    }

    @Override // com.obric.common.oea.foundation.graphics.smoothcorner.impl.ISmoothCornerImpl
    public final boolean c(float r1, float r2) {
        if (r1 >= (r2 * 0.5f)) goto L5;
        return true;
    L5:
        return false;
    }
}
