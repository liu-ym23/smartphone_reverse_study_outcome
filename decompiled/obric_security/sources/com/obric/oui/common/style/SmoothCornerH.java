package com.obric.oui.common.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import com.obric.common.oea.foundation.graphics.smoothcorner.SmoothCornerHelper;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: SmoothCornerH.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J.\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014J\u0018\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u0014H\u0002J\u0018\u0010 \u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0012H\u0002J0\u0010 \u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0014H\u0002J(\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$2\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&H\u0007J@\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&H\u0007J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0012H\u0002J(\u0010'\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0014H\u0002J\u0010\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/obric/oui/common/style/SmoothCornerH;", "", "()V", "TAG", "", "isDeviceSupport", "", "roundCornerHelper", "Lcom/obric/common/oea/foundation/graphics/smoothcorner/SmoothCornerHelper;", "smoothCornerHelper0", "smoothCornerHelper1", "smoothCornerHelper2", "useSystemSmoothCorner", "addRoundRect", "", "path", "Landroid/graphics/Path;", "rect", "Landroid/graphics/RectF;", "radius", "", "radii", "", "dir", "Landroid/graphics/Path$Direction;", "buildPath", "left", "top", "right", "bottom", "decideImpl", "minDimension", "decideValidCornerRadius", "rectF", "drawRoundRect", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "getMinDimension", "setUseSystemSmoothCorner", "use", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SmoothCornerH {
    public static final SmoothCornerH INSTANCE = null;
    private static final String TAG = "SmoothCornerH";
    public static final boolean isDeviceSupport = false;
    private static final SmoothCornerHelper roundCornerHelper = null;
    private static final SmoothCornerHelper smoothCornerHelper0 = null;
    private static final SmoothCornerHelper smoothCornerHelper1 = null;
    private static final SmoothCornerHelper smoothCornerHelper2 = null;
    private static boolean useSystemSmoothCorner;

    private SmoothCornerH() {
    }

    static {
        INSTANCE = new SmoothCornerH();
        smoothCornerHelper0 = new SmoothCornerHelper();
        SmoothCornerHelper r0 = new SmoothCornerHelper();
        r0.setCurveType(SmoothCornerHelper.Companion.CurveType.BASIC);
        roundCornerHelper = r0;
        SmoothCornerHelper r1 = new SmoothCornerHelper();
        r1.setCurveType(SmoothCornerHelper.Companion.CurveType.SKETCH);
        smoothCornerHelper1 = r1;
        SmoothCornerHelper r2 = new SmoothCornerHelper();
        r2.setCurveType(SmoothCornerHelper.Companion.CurveType.QUADRATIC_CAPSULE);
        smoothCornerHelper2 = r2;
        isDeviceSupport = !TextUtils.equals("HUAWEI", Build.BRAND);
        useSystemSmoothCorner = true;
    }

    @JvmStatic
    public static final void setUseSystemSmoothCorner(boolean r0) {
        useSystemSmoothCorner = r0;
    }

    @JvmStatic
    public static final void drawRoundRect(Canvas r2, RectF r3, float r4, Paint r5) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        Intrinsics.checkNotNullParameter(r3, "rectF");
        Intrinsics.checkNotNullParameter(r5, "paint");
        SmoothCornerH r0 = INSTANCE;
        float r6 = r0.decideValidCornerRadius(r4, r3);
        r0.decideImpl(r6, r0.getMinDimension(r3)).drawRoundRect(r2, r3, r6, r5);
    }

    @JvmStatic
    public static final void drawRoundRect(Canvas r9, float r10, float r11, float r12, float r13, float r14, Paint r15) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        Intrinsics.checkNotNullParameter(r15, "paint");
        SmoothCornerH r0 = INSTANCE;
        float r8 = r0.decideValidCornerRadius(r14, r10, r11, r12, r13);
        r0.decideImpl(r8, r0.getMinDimension(r10, r11, r12, r13)).drawRoundRect(r9, r15, r10, r11, r12, r13, r8);
    }

    public static /* synthetic */ void addRoundRect$default(SmoothCornerH r0, Path r1, RectF r2, float[] r3, Path.Direction r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = Path.Direction.CW;
    L5:
        r0.addRoundRect(r1, r2, r3, r4);
    }

    public final void addRoundRect(Path r2, RectF r3, float[] r4, Path.Direction r5) {
        Intrinsics.checkNotNullParameter(r2, "path");
        Intrinsics.checkNotNullParameter(r3, "rect");
        Intrinsics.checkNotNullParameter(r4, "radii");
        Intrinsics.checkNotNullParameter(r5, "dir");
        if (SmoothCornerHKt.access$isAllSameValue(r4) == false) goto L5;
        r2.addPath(buildPath(r3, r4[0]));
        return;
    L5:
        r2.addRoundRect(r3, r4, r5);
    }

    public final void addRoundRect(Path r2, RectF r3, float r4) {
        Intrinsics.checkNotNullParameter(r2, "path");
        Intrinsics.checkNotNullParameter(r3, "rect");
        r2.addPath(buildPath(r3, r4));
    }

    public final Path buildPath(float r8, float r9, float r10, float r11, float r12) {
        float r6 = decideValidCornerRadius(r12, r8, r9, r10, r11);
        return decideImpl(r6, getMinDimension(r8, r9, r10, r11)).buildPath(r8, r9, r10, r11, r6);
    }

    public final Path buildPath(RectF r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "rect");
        float r4 = decideValidCornerRadius(r3, r2);
        SmoothCornerHelper r1 = decideImpl(r4, getMinDimension(r2));
        Rect r0 = new Rect();
        r2.roundOut(r0);
        return r1.buildPath(r0, r4);
    }

    private final float decideValidCornerRadius(float r3, RectF r4) {
        if (r4.isEmpty() == false) goto L7;
        L.e(TAG, "decideValidCornerRadius: rectF is empty");
        return 0.0f;
    L7:
        return RangesKt.coerceAtLeast(Math.min(r3, getMinDimension(r4) / 2.0f), 0.0f);
    }

    private final float decideValidCornerRadius(float r1, float r2, float r3, float r4, float r5) {
        return RangesKt.coerceAtLeast(Math.min(r1, getMinDimension(r2, r3, r4, r5) / 2.0f), 0.0f);
    }

    private final SmoothCornerHelper decideImpl(float r2, float r3) {
        if (useSystemSmoothCorner == true) goto L5;
        SmoothCornerHelper r1 = smoothCornerHelper0;
        if (r1.canDraw(r2, r3) == true) goto L14;
        SmoothCornerHelper r4 = smoothCornerHelper1;
        if (r4.canDraw(r2, r3) == false) goto L13;
        return r4;
    L13:
        return smoothCornerHelper2;
    L14:
        return r1;
    L5:
        return roundCornerHelper;
    }

    private final float getMinDimension(float r1, float r2, float r3, float r4) {
        return Math.min(Math.abs(r3 - r1), Math.abs(r4 - r2));
    }

    private final float getMinDimension(RectF r1) {
        return Math.min(r1.width(), r1.height());
    }
}
