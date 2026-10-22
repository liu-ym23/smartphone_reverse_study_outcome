package com.obric.oui.common.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.obric.common.oea.foundation.graphics.smoothcorner.SmoothCornerHelper;
import com.obric.common.oea.foundation.util.OEALogger;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SmoothCornerH {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SmoothCornerHelper f206a = null;
    public static final SmoothCornerHelper b = null;
    public static final SmoothCornerHelper c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f207d = false;

    static {
        f206a = new SmoothCornerHelper();
        SmoothCornerHelper r0 = new SmoothCornerHelper();
        r0.b(SmoothCornerHelper.Companion.CurveType.b);
        b = r0;
        SmoothCornerHelper r1 = new SmoothCornerHelper();
        r1.b(SmoothCornerHelper.Companion.CurveType.c);
        c = r1;
        f207d = !TextUtils.equals("HUAWEI", Build.BRAND);
    }

    public static void a(Path r1, RectF r2, float r3) {
        Intrinsics.f(r1, ApmTrafficStats.KEY_PATH);
        Intrinsics.f(r2, "rect");
        r1.addPath(c(r2, r3));
    }

    public static void b(Path r5, RectF r6, float[] r7, Path.Direction r8) {
        Intrinsics.f(r5, ApmTrafficStats.KEY_PATH);
        Intrinsics.f(r6, "rect");
        Intrinsics.f(r7, "radii");
        Intrinsics.f(r8, "dir");
        if (r7.length == 0) goto L10;
        float r0 = r7[0];
        int r2 = r7.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L10;
        float r4 = r7[r3];
        r3 = r3 + 1;
        if (r4 == r0) goto L6;
        r5.addRoundRect(r6, r7, r8);
        return;
    L10:
        r5.addPath(c(r6, r7[0]));
    }

    public static Path c(RectF r7, float r8) {
        Intrinsics.f(r7, "rect");
        float r6 = e(r7, r8);
        SmoothCornerHelper r9 = d(r6, Math.min(r7.width(), r7.height()));
        Rect r0 = new Rect();
        r7.roundOut(r0);
        r9.getClass();
        return r9.f142a.a(r0.left, r0.top, r0.right, r0.bottom, r6);
    }

    public static SmoothCornerHelper d(float r2, float r3) {
        SmoothCornerHelper r0 = f206a;
        if (r0.f142a.c(r2, r3) == true) goto L10;
        SmoothCornerHelper r1 = b;
        if (r1.f142a.c(r2, r3) == false) goto L9;
        return r1;
    L9:
        return c;
    L10:
        return r0;
    }

    public static float e(RectF r2, float r3) {
        if (r2.isEmpty() == false) goto L6;
        L.b("SmoothCornerH", "decideValidCornerRadius: rectF is empty");
        return 0.0f;
    L6:
        float r4 = Math.min(r3, Math.min(r2.width(), r2.height()) / 2.0f);
        if (r4 >= 0.0f) goto L10;
        return 0.0f;
    L10:
        return r4;
    }

    public static final void f(Canvas r9, RectF r10, float r11, Paint r12) {
        Intrinsics.f(r9, "canvas");
        Intrinsics.f(r10, "rectF");
        Intrinsics.f(r12, "paint");
        float r8 = e(r10, r11);
        SmoothCornerHelper r1 = d(r8, Math.min(r10.width(), r10.height()));
        r1.getClass();
        if (r10.isEmpty() == false) goto L5;
        OEALogger.b("empty rect: " + r10);
        return;
    L5:
        r1.a(r9, r12, r10.left, r10.top, r10.right, r10.bottom, r8);
    }
}
