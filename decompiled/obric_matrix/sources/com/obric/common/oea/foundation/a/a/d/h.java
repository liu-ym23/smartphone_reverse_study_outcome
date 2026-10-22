package com.obric.common.oea.foundation.a.a.d;

import android.graphics.Path;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f8183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f8184d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f8185e;

    public h() {
        this.f8183c = 128.19f;
        this.f8184d = 83.62f;
        this.f8185e = new b(67.45f, 51.16f, 34.86f, 22.07f, 13.36f, 4.64f);
    }

    @Override // com.obric.common.oea.foundation.a.a.d.d
    public Path a(float r46, float r47, float r48, float r49, float r50) {
        Path r7 = new Path();
        float r5 = r48 - r46;
        float r6 = r49 - r47;
        float r8 = Math.min(r5, r6);
        if (r50 == 0.0f) goto L17;
        if (r50 >= (r8 * 0.5f)) goto L17;
        float r9 = r50 / (r8 / 2.0f);
        float r12 = 1.0f;
        if (r9 <= 0.5f) goto L10;
        float r10 = 1.0f - (Math.min(1.0f, (r9 - 0.5f) / 0.4f) * 0.13877845f);
    L12:
        if (r9 <= 0.6f) goto L14;
        r12 = 1.0f + (Math.min(1.0f, (r9 - 0.6f) / 0.3f) * 0.042454004f);
    L14:
        float r11 = r50 / 100.0f;
        float r13 = (this.f8183c * r11) * r10;
        float r14 = (this.f8184d * r11) * r12;
        b r19 = new b(r11 * this.f8185e.e(), r11 * this.f8185e.d(), r11 * this.f8185e.c(), r11 * this.f8185e.f(), r11 * this.f8185e.a(), r11 * this.f8185e.b());
        float r15 = (r5 / 2.0f) + r46;
        e r0 = new e(r15, r47);
        float r16 = r48 - r13;
        e r17 = new e(Math.max(r15, r16), r47);
        float r18 = r48 - r14;
        e r110 = new e(r18, r47);
        e r111 = new e(r48 - r19.e(), r47 + r19.b());
        e r112 = new e(r48 - r19.d(), r47 + r19.a());
        e r113 = new e(r48 - r19.c(), r47 + r19.f());
        e r114 = new e(r48 - r19.f(), r47 + r19.c());
        e r115 = new e(r48 - r19.a(), r47 + r19.d());
        e r116 = new e(r48 - r19.b(), r47 + r19.e());
        float r117 = r47 + r14;
        e r118 = new e(r48, r117);
        float r20 = r6 / 2.0f;
        e r119 = new e(r48, r47 + Math.min(r20, r13));
        float r21 = r20 + r47;
        float r120 = r49 - r13;
        e r121 = new e(r48, Math.max(r21, r120));
        float r122 = r49 - r14;
        e r22 = new e(r48, r122);
        e r23 = new e(r48 - r19.b(), r49 - r19.e());
        e r24 = new e(r48 - r19.a(), r49 - r19.d());
        e r25 = new e(r48 - r19.f(), r49 - r19.c());
        e r26 = new e(r48 - r19.c(), r49 - r19.f());
        e r27 = new e(r48 - r19.d(), r49 - r19.a());
        e r28 = new e(r48 - r19.e(), r49 - r19.b());
        e r3 = new e(r18, r49);
        e r123 = new e(Math.max(r15, r16), r49);
        float r1 = r46 + r13;
        e r124 = new e(Math.min(r15, r1), r49);
        float r29 = r14 + r46;
        e r4 = new e(r29, r49);
        e r125 = new e(r46 + r19.e(), r49 - r19.b());
        e r126 = new e(r19.d() + r46, r49 - r19.a());
        e r127 = new e(r19.c() + r46, r49 - r19.f());
        e r128 = new e(r19.f() + r46, r49 - r19.c());
        e r129 = new e(r19.a() + r46, r49 - r19.d());
        e r130 = new e(r19.b() + r46, r49 - r19.e());
        e r30 = new e(r46, r122);
        e r131 = new e(r46, Math.max(r21, r120));
        e r132 = new e(r46, Math.min(r21, r47 + r13));
        e r133 = new e(r46, r117);
        e r134 = new e(r19.b() + r46, r19.e() + r47);
        e r31 = new e(r19.a() + r46, r47 + r19.d());
        e r32 = new e(r19.f() + r46, r47 + r19.c());
        e r33 = new e(r19.c() + r46, r47 + r19.f());
        e r34 = new e(r19.d() + r46, r47 + r19.a());
        e r35 = new e(r46 + r19.e(), r19.b() + r47);
        e r36 = new e(r29, r47);
        e r37 = new e(Math.min(r15, r1), r47);
        r7.moveTo(r0.c(), r0.d());
        r7.lineTo(r17.c(), r17.d());
        r7.cubicTo(r110.c(), r110.d(), r111.c(), r111.d(), r112.c(), r112.d());
        r7.cubicTo(r113.c(), r113.d(), r114.c(), r114.d(), r115.c(), r115.d());
        r7.cubicTo(r116.c(), r116.d(), r118.c(), r118.d(), r119.c(), r119.d());
        r7.lineTo(r121.c(), r121.d());
        r7.cubicTo(r22.c(), r22.d(), r23.c(), r23.d(), r24.c(), r24.d());
        r7.cubicTo(r25.c(), r25.d(), r26.c(), r26.d(), r27.c(), r27.d());
        r7.cubicTo(r28.c(), r28.d(), r3.c(), r3.d(), r123.c(), r123.d());
        r7.lineTo(r124.c(), r124.d());
        r7.cubicTo(r4.c(), r4.d(), r125.c(), r125.d(), r126.c(), r126.d());
        r7.cubicTo(r127.c(), r127.d(), r128.c(), r128.d(), r129.c(), r129.d());
        r7.cubicTo(r130.c(), r130.d(), r30.c(), r30.d(), r131.c(), r131.d());
        r7.lineTo(r132.c(), r132.d());
        r7.cubicTo(r133.c(), r133.d(), r134.c(), r134.d(), r31.c(), r31.d());
        r7.cubicTo(r32.c(), r32.d(), r33.c(), r33.d(), r34.c(), r34.d());
        r7.cubicTo(r35.c(), r35.d(), r36.c(), r36.d(), r37.c(), r37.d());
        r7.close();
        return r7;
    L10:
        r10 = 1.0f;
    L17:
        return b(r46, r47, r48, r49, r50);
    }

    @Override // com.obric.common.oea.foundation.a.a.d.d
    public boolean c(float r1, float r2) {
        if (r1 >= (r2 * 0.5f)) goto L5;
        return true;
    L5:
        return false;
    }
}
