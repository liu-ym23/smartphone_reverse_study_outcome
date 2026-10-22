package com.obric.common.oea.foundation.a.a.d;

import android.graphics.Path;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f8181c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f8182d;

    public g(float r1) {
        this.f8182d = r1;
        this.f8181c = 1.175f;
    }

    public /* synthetic */ g(float r1, int r2, kotlin.n0.d.g r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 0.375f;
    L5:
        this(r1);
    }

    @Override // com.obric.common.oea.foundation.a.a.d.d
    public Path a(float r10, float r11, float r12, float r13, float r14) {
        float r0 = Math.min(r12 - r10, r13 - r11);
        if (r14 == 0.0f) goto L10;
        if (r14 >= (this.f8182d * r0)) goto L10;
        float r9 = Math.min(r0 / 2.0f, r14 * this.f8181c);
        float r1 = r11 + r9;
        e r15 = new e(r12, r1);
        float r2 = r13 - r9;
        e r3 = new e(r12, r2);
        e r4 = new e(r12, r13);
        float r5 = r12 - r9;
        e r6 = new e(r5, r13);
        float r16 = r9 + r10;
        e r7 = new e(r16, r13);
        e r8 = new e(r10, r13);
        e r17 = new e(r10, r2);
        e r18 = new e(r10, r1);
        e r19 = new e(r10, r11);
        e r110 = new e(r16, r11);
        e r20 = new e(r5, r11);
        e r21 = new e(r12, r11);
        e r111 = new e(r12, r1);
        Path r112 = new Path();
        r112.moveTo(r15.c(), r15.d());
        r112.lineTo(r3.c(), r3.d());
        r112.quadTo(r4.c(), r4.d(), r6.c(), r6.d());
        r112.lineTo(r7.c(), r7.d());
        r112.quadTo(r8.c(), r8.d(), r17.c(), r17.d());
        r112.lineTo(r18.c(), r18.d());
        r112.quadTo(r19.c(), r19.d(), r110.c(), r110.d());
        r112.lineTo(r20.c(), r20.d());
        r112.quadTo(r21.c(), r21.d(), r111.c(), r111.d());
        r112.close();
        return r112;
    L10:
        return b(r10, r11, r12, r13, r14);
    }

    @Override // com.obric.common.oea.foundation.a.a.d.d
    public boolean c(float r1, float r2) {
        if (r1 >= (this.f8182d * r2)) goto L5;
        return true;
    L5:
        return false;
    }
}
