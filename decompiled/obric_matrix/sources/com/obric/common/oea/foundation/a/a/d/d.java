package com.obric.common.oea.foundation.a.a.d;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f8174b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RectF f8175a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final void a(Path r9, e r10, float r11, float r12, float r13) {
            o.f(r9, "$this$arcTo");
            o.f(r10, "arcCenter");
            r9.arcTo(r10.c() - r11, r10.d() - r11, r10.c() + r11, r10.d() + r11, r12, r13 - r12, false);
        }
    }

    static {
        f8174b = new a(null);
    }

    public d() {
        this.f8175a = new RectF();
    }

    public static /* synthetic */ void e(d r17, Canvas r18, Paint r19, float r20, float r21, float r22, float r23, float r24, float r25, float r26, boolean r27, boolean r28, boolean r29, boolean r30, int r31, Object r32) {
        if (r32 != null) goto L23;
        if ((r31 & 512) == 0) goto L7;
        boolean r13 = true;
    L9:
        if ((r31 & 1024) == 0) goto L11;
        boolean r14 = true;
    L13:
        if ((r31 & 2048) == 0) goto L15;
        boolean r15 = true;
    L17:
        if ((r31 & 4096) == 0) goto L19;
        boolean r16 = true;
    L20:
        r17.d(r18, r19, r20, r21, r22, r23, r24, r25, r26, r13, r14, r15, r16);
        return;
    L19:
        r16 = r30;
        goto L20
    L15:
        r15 = r29;
        goto L17
    L11:
        r14 = r28;
        goto L13
    L7:
        r13 = r27;
        goto L9
    L23:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawAndroidRoundRect");
    }

    public abstract Path a(float r1, float r2, float r3, float r4, float r5);

    public final Path b(float r9, float r10, float r11, float r12, float r13) {
        Path r8 = new Path();
        r8.addRoundRect(r9, r10, r11, r12, r13, r13, Path.Direction.CW);
        r8.close();
        return r8;
    }

    public boolean c(float r1, float r2) {
        return true;
    }

    public final void d(Canvas r11, Paint r12, float r13, float r14, float r15, float r16, float r17, float r18, float r19, boolean r20, boolean r21, boolean r22, boolean r23) {
        o.f(r11, "canvas");
        o.f(r12, "paint");
        float r7 = r17 - r15;
        float r8 = r18 - r16;
        this.f8175a.set(r15, r16, r17, r18);
        r11.drawRoundRect(this.f8175a, r19, r19, r12);
        if (r20 == true) goto L5;
        float r6 = 2;
        float r9 = r7 / r6;
        float r10 = r8 / r6;
        r11.drawRect(0.0f, 0.0f, r9, r10, r12);
        Path r4 = new Path();
        r4.moveTo(0.0f, r10);
        r4.lineTo(0.0f, 0.0f);
        r4.lineTo(r9, 0.0f);
        r11.drawPath(r4, r12);
    L5:
        if (r21 == true) goto L7;
        float r5 = 2;
        float r24 = r7 / r5;
        float r25 = r8 / r5;
        r11.drawRect(r24, 0.0f, r7, r25, r12);
        Path r26 = new Path();
        r26.moveTo(r24, 0.0f);
        r26.lineTo(r7, 0.0f);
        r26.lineTo(r7, r25);
        r11.drawPath(r26, r12);
    L7:
        if (r22 == true) goto L9;
        float r27 = 2;
        float r28 = r8 / r27;
        float r29 = r7 / r27;
        r11.drawRect(0.0f, r28, r29, r8, r12);
        Path r30 = new Path();
        r30.moveTo(0.0f, r28);
        r30.lineTo(0.0f, r8);
        r30.lineTo(r29, r8);
        r11.drawPath(r30, r12);
    L9:
        if (r23 == true) goto L12;
        float r0 = 2;
        float r3 = r7 / r0;
        float r1 = r8 / r0;
        r11.drawRect(r3, r1, r7, r8, r12);
        Path r31 = new Path();
        r31.moveTo(r3, r8);
        r31.lineTo(r7, r8);
        r31.lineTo(r7, r1);
        r11.drawPath(r31, r12);
        return;
    }

    public final void f(Canvas r7, Paint r8, float r9, float r10, float r11, float r12, float r13) {
        o.f(r7, "canvas");
        o.f(r8, "paint");
        r7.drawPath(a(r9, r10, r11, r12, r13), r8);
    }
}
