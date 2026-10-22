package com.obric.common.oea.foundation.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import com.obric.common.oea.foundation.a.a.d.d;
import com.obric.common.oea.foundation.a.a.d.f;
import com.obric.common.oea.foundation.a.a.d.g;
import com.obric.common.oea.foundation.a.a.d.h;
import java.util.List;
import kotlin.i0.r;
import kotlin.m;
import kotlin.n0.d.o;
import kotlin.r0.e;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<Integer> f8164b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f8165a;

    static {
        f8164b = r.z0(e.l(new kotlin.r0.d(8, 48), 2));
    }

    public c() {
        new com.obric.common.oea.foundation.b.c();
        this.f8165a = new g(0.0f, 1, null);
    }

    private final com.obric.common.oea.foundation.a.a.d.e f(float r2, float r3, float r4, float r5) {
        float r1 = r2 - r3;
        float r0 = r4 - r5;
        return new com.obric.common.oea.foundation.a.a.d.e(((r3 + r2) / 2.0f) - (r1 / 2.0f), ((r5 + r4) / 2.0f) - (r0 / 2.0f));
    }

    public final Path a(float r7, float r8, float r9, float r10, float r11) {
        return this.f8165a.a(r7, r8, r9, r10, r11);
    }

    public final Path b(Rect r8, float r9) {
        o.f(r8, "rect");
        return a(r8.left, r8.top, r8.right, r8.bottom, r9);
    }

    public final boolean c(float r1, float r2) {
        return this.f8165a.c(r1, r2);
    }

    public final void d(Canvas r19, Paint r20, float r21, float r22, float r23, float r24, float r25) {
        o.f(r19, "canvas");
        o.f(r20, "paint");
        if (r25 >= 0.0f) goto L5;
        com.obric.common.oea.foundation.b.b.c(com.obric.common.oea.foundation.b.b.f8188c, "SmoothCornerHelper", "invalid radius: " + r25, null, 4, null);
        float r9 = 0.0f;
    L6:
        com.obric.common.oea.foundation.a.a.d.e r1 = f(r23, r21, r24, r22);
        float r10 = r1.a();
        float r11 = r1.b();
        float r2 = Math.min(r23 - r21, r24 - r22) / 2;
        d r0 = this.f8165a;
        if (r9 <= r2) goto L9;
        d.e(r0, r19, r20, r10, r11, r21, r22, r23, r24, r9, false, false, false, false, 7680, null);
        return;
    L9:
        r0.f(r19, r20, r21, r22, r23, r24, r9);
        return;
    L5:
        r9 = r25;
        goto L6
    }

    public final void e(Canvas r10, RectF r11, float r12, Paint r13) {
        o.f(r10, "canvas");
        o.f(r11, "rect");
        o.f(r13, "paint");
        if (r11.isEmpty() == false) goto L6;
        com.obric.common.oea.foundation.b.b.c(com.obric.common.oea.foundation.b.b.f8188c, "SmoothCornerHelper", "empty rect: " + r11, null, 4, null);
        return;
    L6:
        d(r10, r13, r11.left, r11.top, r11.right, r11.bottom, r12);
    }

    public final void g(a r2) {
        o.f(r2, "curveType");
        h(r2, -1.0f);
    }

    public final void h(a r4, float r5) {
        o.f(r4, "curveType");
        com.obric.common.oea.foundation.b.b.f8188c.a("SmoothCornerHelper", "setCurveType: " + r4);
        int r6 = b.f8163a[r4.ordinal()];
        if (r6 != 1) goto L5;
        d r7 = new com.obric.common.oea.foundation.a.a.d.a();
    L24:
        this.f8165a = r7;
        return;
    L5:
        if (r6 == 2) goto L18;
        if (r6 != 3) goto L9;
        r7 = new h();
        goto L24
    L9:
        if (r6 != 4) goto L11;
        r7 = new com.obric.common.oea.foundation.a.a.d.c();
        goto L24
    L11:
        if (r6 != 5) goto L14;
        r7 = new f();
        goto L24
    L14:
        throw new m();
    L18:
        if (r5 > 0) goto L20;
    L22:
        r7 = new g(0.0f, 1, null);
        goto L24
    L20:
        if (r5 > 0.5f) goto L22;
        r7 = new g(r5);
        goto L24
    }
}
