package com.obric.common.oea.foundation.a.a.d;

import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f8178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f8179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f8180e;

    public f() {
        this.f8178c = 0.585786f;
        this.f8179d = 0.292893f;
        this.f8180e = 1.175f;
    }

    private final Path g(float r17, float r18, float r19, float r20, float r21, float r22) {
        float r5 = this.f8178c * r21;
        float r0 = this.f8179d * r21;
        float r7 = r17 + r22;
        e r6 = new e(r7, r18);
        float r9 = 2.0f * r21;
        RectF r8 = new RectF(r17, r18, r17 + r9, r20);
        RectF r10 = new RectF(r19 - r9, r18, r19, r20);
        float r11 = r19 - r22;
        e r12 = new e(r11, r18);
        float r13 = r19 - r5;
        e r14 = new e(r13, r18);
        e r15 = new e(r19 - r0, r18 + r0);
        float r3 = r20 - r0;
        e r16 = new e(r13, r20);
        e r110 = new e(r11, r20);
        e r111 = new e(r7, r20);
        float r23 = r5 + r17;
        e r24 = new e(r23, r20);
        e r4 = new e(r0 + r17, r3);
        e r1 = new e(r23, r18);
        e r2 = new e(r7, r18);
        Path r25 = new Path();
        r25.moveTo(r6.c(), r6.d());
        r25.lineTo(r12.c(), r12.d());
        r25.quadTo(r14.c(), r14.d(), r15.c(), r15.d());
        r25.arcTo(r10, -45.0f, 90.0f);
        r25.quadTo(r16.c(), r16.d(), r110.c(), r110.d());
        r25.lineTo(r111.c(), r111.d());
        r25.quadTo(r24.c(), r24.d(), r4.c(), r4.d());
        r25.arcTo(r8, 135.0f, 90.0f);
        r25.quadTo(r1.c(), r1.d(), r2.c(), r2.d());
        r25.close();
        return r25;
    }

    private final Path h(float r17, float r18, float r19, float r20, float r21, float r22) {
        float r5 = this.f8178c * r21;
        float r0 = this.f8179d * r21;
        float r7 = r18 + r22;
        e r6 = new e(r19, r7);
        float r9 = 2.0f * r21;
        RectF r8 = new RectF(r17, r18, r19, r18 + r9);
        RectF r10 = new RectF(r17, r20 - r9, r19, r20);
        float r11 = r20 - r22;
        e r12 = new e(r19, r11);
        float r13 = r20 - r5;
        e r14 = new e(r19, r13);
        e r15 = new e(r19 - r0, r20 - r0);
        e r16 = new e(r17, r13);
        e r110 = new e(r17, r11);
        e r111 = new e(r17, r7);
        float r23 = r5 + r18;
        e r24 = new e(r17, r23);
        e r1 = new e(r17 + r0, r0 + r18);
        e r2 = new e(r19, r23);
        e r3 = new e(r19, r7);
        Path r4 = new Path();
        r4.moveTo(r6.c(), r6.d());
        r4.lineTo(r12.c(), r12.d());
        r4.quadTo(r14.c(), r14.d(), r15.c(), r15.d());
        r4.arcTo(r10, 45.0f, 90.0f);
        r4.quadTo(r16.c(), r16.d(), r110.c(), r110.d());
        r4.lineTo(r111.c(), r111.d());
        r4.quadTo(r24.c(), r24.d(), r1.c(), r1.d());
        r4.arcTo(r8, 225.0f, 90.0f);
        r4.quadTo(r2.c(), r2.d(), r3.c(), r3.d());
        r4.close();
        return r4;
    }

    @Override // com.obric.common.oea.foundation.a.a.d.d
    public Path a(float r9, float r10, float r11, float r12, float r13) {
        float r1 = r11 - r9;
        float r2 = r12 - r10;
        float r3 = Math.min(r1, r2);
        float r4 = Math.max(r1, r2);
        if (r13 == 0.0f) goto L22;
        float r5 = r3 * 0.5f;
        if (r13 != r5) goto L22;
        if (r13 != r5) goto L13;
        if (r1 != r2) goto L13;
        return b(r9, r10, r11, r12, r13);
    L13:
        if (r1 <= r2) goto L15;
        boolean r6 = true;
    L16:
        float r7 = kotlin.r0.e.e(r13, r5);
        float r8 = Math.min(this.f8180e * r7, r4 * 0.5f);
        if (r6 == false) goto L20;
        return g(r9, r10, r11, r12, r7, r8);
    L20:
        return h(r9, r10, r11, r12, r7, r8);
    L15:
        r6 = false;
    L22:
        return b(r9, r10, r11, r12, r13);
    }

    @Override // com.obric.common.oea.foundation.a.a.d.d
    public boolean c(float r1, float r2) {
        if (r1 != (r2 * 0.5f)) goto L5;
        return true;
    L5:
        return false;
    }
}
