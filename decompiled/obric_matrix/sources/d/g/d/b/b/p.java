package d.g.d.b.b;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.obric.common.oea.foundation.a.a.c f16815a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.obric.common.oea.foundation.a.a.c f16816b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final com.obric.common.oea.foundation.a.a.c f16817c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f16818d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final p f16819e = null;

    static {
        f16819e = new p();
        f16815a = new com.obric.common.oea.foundation.a.a.c();
        com.obric.common.oea.foundation.a.a.c r0 = new com.obric.common.oea.foundation.a.a.c();
        r0.g(com.obric.common.oea.foundation.a.a.a.f8158g);
        f16816b = r0;
        com.obric.common.oea.foundation.a.a.c r1 = new com.obric.common.oea.foundation.a.a.c();
        r1.g(com.obric.common.oea.foundation.a.a.a.f8161j);
        f16817c = r1;
        f16818d = !TextUtils.equals("HUAWEI", Build.BRAND);
    }

    private p() {
    }

    private final com.obric.common.oea.foundation.a.a.c e(float r2, float r3) {
        com.obric.common.oea.foundation.a.a.c r1 = f16815a;
        if (r1.c(r2, r3) == true) goto L10;
        com.obric.common.oea.foundation.a.a.c r4 = f16816b;
        if (r4.c(r2, r3) == false) goto L9;
        return r4;
    L9:
        return f16817c;
    L10:
        return r1;
    }

    private final float f(float r1, float r2, float r3, float r4, float r5) {
        return kotlin.r0.e.b(Math.min(r1, i(r2, r3, r4, r5) / 2.0f), 0.0f);
    }

    private final float g(float r3, RectF r4) {
        if (r4.isEmpty() == false) goto L7;
        d.g.d.f.f.b.b("SmoothCornerH", "decideValidCornerRadius: rectF is empty");
        return 0.0f;
    L7:
        return kotlin.r0.e.b(Math.min(r3, j(r4) / 2.0f), 0.0f);
    }

    private final float i(float r1, float r2, float r3, float r4) {
        return Math.min(Math.abs(r3 - r1), Math.abs(r4 - r2));
    }

    private final float j(RectF r1) {
        return Math.min(r1.width(), r1.height());
    }

    public final void a(Path r2, RectF r3, float r4) {
        kotlin.n0.d.o.f(r2, "path");
        kotlin.n0.d.o.f(r3, "rect");
        r2.addPath(d(r3, r4));
    }

    public final void b(Path r2, RectF r3, float[] r4, Path.Direction r5) {
        kotlin.n0.d.o.f(r2, "path");
        kotlin.n0.d.o.f(r3, "rect");
        kotlin.n0.d.o.f(r4, "radii");
        kotlin.n0.d.o.f(r5, "dir");
        if (q.a(r4) == false) goto L5;
        r2.addPath(d(r3, r4[0]));
        return;
    L5:
        r2.addRoundRect(r3, r4, r5);
    }

    public final Path c(float r8, float r9, float r10, float r11, float r12) {
        float r6 = f(r12, r8, r9, r10, r11);
        return e(r6, i(r8, r9, r10, r11)).a(r8, r9, r10, r11, r6);
    }

    public final Path d(RectF r2, float r3) {
        kotlin.n0.d.o.f(r2, "rect");
        float r4 = g(r3, r2);
        com.obric.common.oea.foundation.a.a.c r1 = e(r4, j(r2));
        Rect r0 = new Rect();
        r2.roundOut(r0);
        return r1.b(r0, r4);
    }

    public final void h(Canvas r2, RectF r3, float r4, Paint r5) {
        kotlin.n0.d.o.f(r2, "canvas");
        kotlin.n0.d.o.f(r3, "rectF");
        kotlin.n0.d.o.f(r5, "paint");
        float r6 = g(r4, r3);
        e(r6, j(r3)).e(r2, r3, r6, r5);
    }
}
