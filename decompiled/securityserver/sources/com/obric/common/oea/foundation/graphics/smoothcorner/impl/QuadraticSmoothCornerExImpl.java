package com.obric.common.oea.foundation.graphics.smoothcorner.impl;

import android.graphics.Path;
import android.graphics.RectF;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class QuadraticSmoothCornerExImpl extends ISmoothCornerImpl {
    public final float b;
    public final float c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f147d;

    public QuadraticSmoothCornerExImpl() {
        this.b = 0.585786f;
        this.c = 0.292893f;
        this.f147d = 1.175f;
    }

    @Override // com.obric.common.oea.foundation.graphics.smoothcorner.impl.ISmoothCornerImpl
    public final Path a(float r9, float r10, float r11, float r12, float r13) {
        float r0 = r11 - r9;
        float r1 = r12 - r10;
        float r2 = Math.min(r0, r1);
        float r3 = Math.max(r0, r1);
        if (r13 == 0.0f) goto L25;
        float r4 = r2 * 0.5f;
        if (r13 != r4) goto L25;
        if (r13 != r4) goto L13;
        if (r0 != r1) goto L13;
        return ISmoothCornerImpl.b(r9, r10, r11, r12, r13);
    L13:
        if (r0 <= r1) goto L15;
        boolean r5 = true;
    L17:
        if (r13 <= r4) goto L19;
        r13 = r4;
    L19:
        float r6 = Math.min(this.f147d * r13, r3 * 0.5f);
        float r7 = this.c;
        float r8 = this.b;
        if (r5 == false) goto L22;
        float r14 = r8 * r13;
        float r15 = r7 * r13;
        float r16 = r9 + r6;
        float r17 = r13 * 2.0f;
        RectF r18 = new RectF(r9, r10, r9 + r17, r12);
        RectF r19 = new RectF(r11 - r17, r10, r11, r12);
        float r110 = r11 - r6;
        float r20 = r11 - r14;
        float r111 = r11 - r15;
        float r21 = r10 + r15;
        float r22 = r12 - r15;
        float r23 = r14 + r9;
        float r24 = r9 + r15;
        Path r25 = new Path();
        r25.moveTo(r16, r10);
        r25.lineTo(r110, r10);
        r25.quadTo(r20, r10, r111, r21);
        r25.arcTo(r19, -45.0f, 90.0f);
        r25.quadTo(r20, r12, r110, r12);
        r25.lineTo(r16, r12);
        r25.quadTo(r23, r12, r24, r22);
        r25.arcTo(r18, 135.0f, 90.0f);
        r25.quadTo(r23, r10, r16, r10);
        r25.close();
        return r25;
    L22:
        float r26 = r8 * r13;
        float r27 = r7 * r13;
        float r28 = r10 + r6;
        float r112 = r13 * 2.0f;
        RectF r29 = new RectF(r9, r10, r11, r10 + r112);
        RectF r30 = new RectF(r9, r12 - r112, r11, r12);
        float r113 = r12 - r6;
        float r31 = r12 - r26;
        float r32 = r11 - r27;
        float r114 = r12 - r27;
        float r33 = r9 + r27;
        float r34 = r26 + r10;
        float r115 = r10 + r27;
        Path r35 = new Path();
        r35.moveTo(r11, r28);
        r35.lineTo(r11, r113);
        r35.quadTo(r11, r31, r32, r114);
        r35.arcTo(r30, 45.0f, 90.0f);
        r35.quadTo(r9, r31, r9, r113);
        r35.lineTo(r9, r28);
        r35.quadTo(r9, r34, r33, r115);
        r35.arcTo(r29, 225.0f, 90.0f);
        r35.quadTo(r11, r34, r11, r28);
        r35.close();
        return r35;
    L15:
        r5 = false;
    L25:
        return ISmoothCornerImpl.b(r9, r10, r11, r12, r13);
    }

    @Override // com.obric.common.oea.foundation.graphics.smoothcorner.impl.ISmoothCornerImpl
    public final boolean c(float r1, float r2) {
        if (r1 != (r2 * 0.5f)) goto L5;
        return true;
    L5:
        return false;
    }
}
