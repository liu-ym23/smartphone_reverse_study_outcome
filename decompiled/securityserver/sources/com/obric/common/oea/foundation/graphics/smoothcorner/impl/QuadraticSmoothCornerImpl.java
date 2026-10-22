package com.obric.common.oea.foundation.graphics.smoothcorner.impl;

import android.graphics.Path;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class QuadraticSmoothCornerImpl extends ISmoothCornerImpl {
    public final float b;
    public final float c;

    public /* synthetic */ QuadraticSmoothCornerImpl() {
        this(0.375f);
    }

    @Override // com.obric.common.oea.foundation.graphics.smoothcorner.impl.ISmoothCornerImpl
    public final Path a(float r4, float r5, float r6, float r7, float r8) {
        float r0 = Math.min(r6 - r4, r7 - r5);
        if (r8 == 0.0f) goto L10;
        if (r8 >= (this.c * r0)) goto L10;
        float r3 = Math.min(r0 / 2.0f, r8 * this.b);
        float r9 = r5 + r3;
        float r1 = r7 - r3;
        float r2 = r6 - r3;
        float r10 = r3 + r4;
        Path r11 = new Path();
        r11.moveTo(r6, r9);
        r11.lineTo(r6, r1);
        r11.quadTo(r6, r7, r2, r7);
        r11.lineTo(r10, r7);
        r11.quadTo(r4, r7, r4, r1);
        r11.lineTo(r4, r9);
        r11.quadTo(r4, r5, r10, r5);
        r11.lineTo(r2, r5);
        r11.quadTo(r6, r5, r6, r9);
        r11.close();
        return r11;
    L10:
        return ISmoothCornerImpl.b(r4, r5, r6, r7, r8);
    }

    @Override // com.obric.common.oea.foundation.graphics.smoothcorner.impl.ISmoothCornerImpl
    public final boolean c(float r1, float r2) {
        if (r1 >= (this.c * r2)) goto L5;
        return true;
    L5:
        return false;
    }

    public QuadraticSmoothCornerImpl(float r1) {
        this.c = r1;
        this.b = 1.175f;
    }
}
