package com.obric.common.oea.foundation.graphics.smoothcorner.impl;

import android.graphics.Path;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SketchSmoothCornerImpl extends ISmoothCornerImpl {
    public final float b;
    public final float c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ControlPoint f148d;

    public SketchSmoothCornerImpl() {
        this.b = 128.19f;
        this.c = 83.62f;
        this.f148d = new ControlPoint(67.45f, 51.16f, 34.86f, 22.07f, 13.36f, 4.64f);
    }

    @Override // com.obric.common.oea.foundation.graphics.smoothcorner.impl.ISmoothCornerImpl
    public final Path a(float r58, float r59, float r60, float r61, float r62) {
        Path r11 = new Path();
        float r1 = r60 - r58;
        float r2 = r61 - r59;
        float r3 = Math.min(r1, r2);
        if (r62 == 0.0f) goto L17;
        if (r62 >= (r3 * 0.5f)) goto L17;
        float r4 = r62 / (r3 / 2.0f);
        float r12 = 1.0f;
        if (r4 <= 0.5f) goto L10;
        float r5 = 1.0f - (Math.min(1.0f, (r4 - 0.5f) / 0.4f) * 0.13877845f);
    L12:
        if (r4 <= 0.6f) goto L14;
        r12 = 1.0f + (Math.min(1.0f, (r4 - 0.6f) / 0.3f) * 0.042454004f);
    L14:
        float r6 = r62 / 100.0f;
        float r7 = (this.b * r6) * r5;
        float r8 = (this.c * r6) * r12;
        ControlPoint r0 = this.f148d;
        float r13 = r0.f143a * r6;
        float r14 = r0.b * r6;
        float r15 = r0.c * r6;
        float r16 = r0.f144d * r6;
        float r9 = r0.e * r6;
        float r10 = r6 * r0.f;
        float r17 = (r1 / 2.0f) + r58;
        float r18 = r60 - r7;
        float r19 = Math.max(r17, r18);
        float r110 = r60 - r8;
        float r111 = r60 - r13;
        float r21 = r60 - r14;
        float r23 = r60 - r15;
        float r25 = r60 - r16;
        float r27 = r60 - r9;
        float r29 = r60 - r10;
        float r31 = r59 + r8;
        float r20 = r2 / 2.0f;
        float r112 = Math.min(r20, r7) + r59;
        float r22 = r20 + r59;
        float r24 = r61 - r7;
        float r113 = Math.max(r22, r24);
        float r32 = r61 - r8;
        float r39 = Math.max(r17, r18);
        float r26 = r58 + r7;
        float r114 = Math.min(r17, r26);
        float r40 = r58 + r8;
        float r43 = r58 + r14;
        float r45 = r58 + r15;
        float r47 = r58 + r16;
        float r49 = r58 + r9;
        float r51 = r58 + r10;
        float r28 = Math.max(r22, r24);
        float r30 = Math.min(r22, r59 + r7);
        float r56 = Math.min(r17, r26);
        r11.moveTo(r17, r59);
        r11.lineTo(r19, r59);
        r11.cubicTo(r110, r59, r111, r59 + r10, r21, r59 + r9);
        r11.cubicTo(r23, r59 + r16, r25, r59 + r15, r27, r59 + r14);
        r11.cubicTo(r29, r59 + r13, r60, r31, r60, r112);
        r11.lineTo(r60, r113);
        r11.cubicTo(r60, r32, r29, r61 - r13, r27, r61 - r14);
        r11.cubicTo(r25, r61 - r15, r23, r61 - r16, r21, r61 - r9);
        r11.cubicTo(r111, r61 - r10, r110, r61, r39, r61);
        r11.lineTo(r114, r61);
        r11.cubicTo(r40, r61, r58 + r13, r61 - r10, r43, r61 - r9);
        r11.cubicTo(r45, r61 - r16, r47, r61 - r15, r49, r61 - r14);
        r11.cubicTo(r51, r61 - r13, r58, r32, r58, r28);
        r11.lineTo(r58, r30);
        r11.cubicTo(r58, r31, r51, r59 + r13, r49, r14 + r59);
        r11.cubicTo(r47, r15 + r59, r45, r16 + r59, r43, r59 + r9);
        r11.cubicTo(r13 + r58, r59 + r10, r40, r59, r56, r59);
        r11.close();
        return r11;
    L10:
        r5 = 1.0f;
    L17:
        return ISmoothCornerImpl.b(r58, r59, r60, r61, r62);
    }

    @Override // com.obric.common.oea.foundation.graphics.smoothcorner.impl.ISmoothCornerImpl
    public final boolean c(float r1, float r2) {
        if (r1 >= (r2 * 0.5f)) goto L5;
        return true;
    L5:
        return false;
    }
}
