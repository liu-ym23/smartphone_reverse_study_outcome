package com.obric.common.oea.foundation.graphics.smoothcorner;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.obric.common.oea.foundation.util.OEALogger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: SmoothCornerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J*\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J0\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0010H\u0002J\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u000eH\u0002J0\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0002J(\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"H\u0007J@\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"H\u0007J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u000eH\u0002J(\u0010#\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0002J\u0010\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/common/oea/foundation/graphics/smoothcorner/SmoothCornerAdapter;", "", "()V", "TAG", "", "smoothCornerHelper0", "Lcom/obric/common/oea/foundation/graphics/smoothcorner/SmoothCornerHelper;", "smoothCornerHelper1", "smoothCornerHelper2", "addRoundRect", "", "path", "Landroid/graphics/Path;", "rect", "Landroid/graphics/RectF;", "radius", "", "radii", "", "dir", "Landroid/graphics/Path$Direction;", "buildPath", "left", "top", "right", "bottom", "decideImpl", "minDimension", "decideValidCornerRadius", "rectF", "drawRoundRect", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "getMinDimension", "setDefaultImpl", "impl", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class SmoothCornerAdapter {
    public static final SmoothCornerAdapter INSTANCE = null;
    private static final String TAG = "SmoothCornerAdapter";
    private static SmoothCornerHelper smoothCornerHelper0;
    private static final SmoothCornerHelper smoothCornerHelper1 = null;
    private static final SmoothCornerHelper smoothCornerHelper2 = null;

    static {
        INSTANCE = new SmoothCornerAdapter();
        smoothCornerHelper0 = new SmoothCornerHelper();
        SmoothCornerHelper r0 = new SmoothCornerHelper();
        r0.setCurveType(SmoothCornerHelper.Companion.CurveType.SKETCH);
        smoothCornerHelper1 = r0;
        SmoothCornerHelper r1 = new SmoothCornerHelper();
        r1.setCurveType(SmoothCornerHelper.Companion.CurveType.QUADRATIC_CAPSULE);
        smoothCornerHelper2 = r1;
    }

    private SmoothCornerAdapter() {
    }

    @JvmStatic
    public static final void setDefaultImpl(SmoothCornerHelper r1) {
        Intrinsics.checkNotNullParameter(r1, "impl");
        smoothCornerHelper0 = r1;
    }

    @JvmStatic
    public static final void drawRoundRect(Canvas r2, RectF r3, float r4, Paint r5) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        Intrinsics.checkNotNullParameter(r3, "rectF");
        Intrinsics.checkNotNullParameter(r5, "paint");
        SmoothCornerAdapter r0 = INSTANCE;
        float r6 = r0.decideValidCornerRadius(r4, r3);
        r0.decideImpl(r6, r0.getMinDimension(r3)).drawRoundRect(r2, r3, r6, r5);
    }

    @JvmStatic
    public static final void drawRoundRect(Canvas r9, float r10, float r11, float r12, float r13, float r14, Paint r15) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        Intrinsics.checkNotNullParameter(r15, "paint");
        SmoothCornerAdapter r0 = INSTANCE;
        float r8 = r0.decideValidCornerRadius(r14, r10, r11, r12, r13);
        r0.decideImpl(r8, r0.getMinDimension(r10, r11, r12, r13)).drawRoundRect(r9, r15, r10, r11, r12, r13, r8);
    }

    public static /* synthetic */ void addRoundRect$default(Path r0, RectF r1, float[] r2, Path.Direction r3, int r4, Object r5) {
        if ((r4 & 8) == 0) goto L5;
        r3 = Path.Direction.CW;
    L5:
        addRoundRect(r0, r1, r2, r3);
    }

    @JvmStatic
    public static final void addRoundRect(Path r1, RectF r2, float[] r3, Path.Direction r4) {
        Intrinsics.checkNotNullParameter(r1, "path");
        Intrinsics.checkNotNullParameter(r2, "rect");
        Intrinsics.checkNotNullParameter(r3, "radii");
        Intrinsics.checkNotNullParameter(r4, "dir");
        if (SmoothCornerAdapterKt.access$isAllSameValue(r3) == false) goto L5;
        r1.addPath(buildPath(r2, r3[0]));
        return;
    L5:
        r1.addRoundRect(r2, r3, r4);
    }

    @JvmStatic
    public static final void addRoundRect(Path r1, RectF r2, float r3) {
        Intrinsics.checkNotNullParameter(r1, "path");
        Intrinsics.checkNotNullParameter(r2, "rect");
        r1.addPath(buildPath(r2, r3));
    }

    @JvmStatic
    public static final Path buildPath(float r7, float r8, float r9, float r10, float r11) {
        SmoothCornerAdapter r6 = INSTANCE;
        float r5 = r6.decideValidCornerRadius(r11, r7, r8, r9, r10);
        return r6.decideImpl(r5, r6.getMinDimension(r7, r8, r9, r10)).buildPath(r7, r8, r9, r10, r5);
    }

    @JvmStatic
    public static final Path buildPath(RectF r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "rect");
        SmoothCornerAdapter r0 = INSTANCE;
        float r4 = r0.decideValidCornerRadius(r3, r2);
        return r0.decideImpl(r4, r0.getMinDimension(r2)).buildPath(r2, r4);
    }

    private final float decideValidCornerRadius(float r9, RectF r10) {
        if (r10.isEmpty() == false) goto L7;
        OEALogger.e$default(OEALogger.INSTANCE, TAG, "decideValidCornerRadius: rectF is empty", null, 4, null);
        return 0.0f;
    L7:
        return RangesKt.coerceAtLeast(Math.min(r9, getMinDimension(r10) / 2.0f), 0.0f);
    }

    private final float decideValidCornerRadius(float r1, float r2, float r3, float r4, float r5) {
        return RangesKt.coerceAtLeast(Math.min(r1, getMinDimension(r2, r3, r4, r5) / 2.0f), 0.0f);
    }

    private final SmoothCornerHelper decideImpl(float r1, float r2) {
        if (smoothCornerHelper0.canDraw(r1, r2) == true) goto L10;
        SmoothCornerHelper r0 = smoothCornerHelper1;
        if (r0.canDraw(r1, r2) == false) goto L9;
        return r0;
    L9:
        return smoothCornerHelper2;
    L10:
        return smoothCornerHelper0;
    }

    private final float getMinDimension(float r1, float r2, float r3, float r4) {
        return Math.min(Math.abs(r3 - r1), Math.abs(r4 - r2));
    }

    private final float getMinDimension(RectF r1) {
        return Math.min(r1.width(), r1.height());
    }
}
