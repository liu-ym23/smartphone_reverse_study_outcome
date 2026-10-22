package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class RectKt {
    @SuppressLint({"CheckResult"})
    @NotNull
    public static final Rect and(@NotNull Rect r1, @NotNull Rect r2) {
        Intrinsics.g(r1, "$this$and");
        Intrinsics.g(r2, "r");
        Rect r0 = new Rect(r1);
        r0.intersect(r2);
        return r0;
    }

    public static final int component1(@NotNull Rect r1) {
        Intrinsics.g(r1, "$this$component1");
        return r1.left;
    }

    public static final int component2(@NotNull Rect r1) {
        Intrinsics.g(r1, "$this$component2");
        return r1.top;
    }

    public static final int component3(@NotNull Rect r1) {
        Intrinsics.g(r1, "$this$component3");
        return r1.right;
    }

    public static final int component4(@NotNull Rect r1) {
        Intrinsics.g(r1, "$this$component4");
        return r1.bottom;
    }

    public static final boolean contains(@NotNull Rect r1, @NotNull Point r2) {
        Intrinsics.g(r1, "$this$contains");
        Intrinsics.g(r2, "p");
        return r1.contains(r2.x, r2.y);
    }

    @NotNull
    public static final Region minus(@NotNull Rect r1, @NotNull Rect r2) {
        Intrinsics.g(r1, "$this$minus");
        Intrinsics.g(r2, "r");
        Region r0 = new Region(r1);
        r0.op(r2, Region.Op.DIFFERENCE);
        return r0;
    }

    @NotNull
    public static final Rect or(@NotNull Rect r1, @NotNull Rect r2) {
        Intrinsics.g(r1, "$this$or");
        Intrinsics.g(r2, "r");
        Rect r0 = new Rect(r1);
        r0.union(r2);
        return r0;
    }

    @NotNull
    public static final Rect plus(@NotNull Rect r1, @NotNull Rect r2) {
        Intrinsics.g(r1, "$this$plus");
        Intrinsics.g(r2, "r");
        Rect r0 = new Rect(r1);
        r0.union(r2);
        return r0;
    }

    @NotNull
    public static final Rect toRect(@NotNull RectF r1) {
        Intrinsics.g(r1, "$this$toRect");
        Rect r0 = new Rect();
        r1.roundOut(r0);
        return r0;
    }

    @NotNull
    public static final RectF toRectF(@NotNull Rect r1) {
        Intrinsics.g(r1, "$this$toRectF");
        return new RectF(r1);
    }

    @NotNull
    public static final Region toRegion(@NotNull Rect r1) {
        Intrinsics.g(r1, "$this$toRegion");
        return new Region(r1);
    }

    @NotNull
    public static final RectF transform(@NotNull RectF r1, @NotNull Matrix r2) {
        Intrinsics.g(r1, "$this$transform");
        Intrinsics.g(r2, "m");
        r2.mapRect(r1);
        return r1;
    }

    @NotNull
    public static final Region xor(@NotNull Rect r1, @NotNull Rect r2) {
        Intrinsics.g(r1, "$this$xor");
        Intrinsics.g(r2, "r");
        Region r0 = new Region(r1);
        r0.op(r2, Region.Op.XOR);
        return r0;
    }

    public static final float component1(@NotNull RectF r1) {
        Intrinsics.g(r1, "$this$component1");
        return r1.left;
    }

    public static final float component2(@NotNull RectF r1) {
        Intrinsics.g(r1, "$this$component2");
        return r1.top;
    }

    public static final float component3(@NotNull RectF r1) {
        Intrinsics.g(r1, "$this$component3");
        return r1.right;
    }

    public static final float component4(@NotNull RectF r1) {
        Intrinsics.g(r1, "$this$component4");
        return r1.bottom;
    }

    public static final boolean contains(@NotNull RectF r1, @NotNull PointF r2) {
        Intrinsics.g(r1, "$this$contains");
        Intrinsics.g(r2, "p");
        return r1.contains(r2.x, r2.y);
    }

    @NotNull
    public static final Region toRegion(@NotNull RectF r1) {
        Intrinsics.g(r1, "$this$toRegion");
        Rect r0 = new Rect();
        r1.roundOut(r0);
        return new Region(r0);
    }

    @SuppressLint({"CheckResult"})
    @NotNull
    public static final RectF and(@NotNull RectF r1, @NotNull RectF r2) {
        Intrinsics.g(r1, "$this$and");
        Intrinsics.g(r2, "r");
        RectF r0 = new RectF(r1);
        r0.intersect(r2);
        return r0;
    }

    @NotNull
    public static final Rect minus(@NotNull Rect r1, int r2) {
        Intrinsics.g(r1, "$this$minus");
        Rect r0 = new Rect(r1);
        int r3 = -r2;
        r0.offset(r3, r3);
        return r0;
    }

    @NotNull
    public static final RectF or(@NotNull RectF r1, @NotNull RectF r2) {
        Intrinsics.g(r1, "$this$or");
        Intrinsics.g(r2, "r");
        RectF r0 = new RectF(r1);
        r0.union(r2);
        return r0;
    }

    @NotNull
    public static final RectF plus(@NotNull RectF r1, @NotNull RectF r2) {
        Intrinsics.g(r1, "$this$plus");
        Intrinsics.g(r2, "r");
        RectF r0 = new RectF(r1);
        r0.union(r2);
        return r0;
    }

    @NotNull
    public static final Region xor(@NotNull RectF r1, @NotNull RectF r2) {
        Intrinsics.g(r1, "$this$xor");
        Intrinsics.g(r2, "r");
        Rect r0 = new Rect();
        r1.roundOut(r0);
        Region r3 = new Region(r0);
        Rect r4 = new Rect();
        r2.roundOut(r4);
        r3.op(r4, Region.Op.XOR);
        return r3;
    }

    @NotNull
    public static final RectF minus(@NotNull RectF r1, float r2) {
        Intrinsics.g(r1, "$this$minus");
        RectF r0 = new RectF(r1);
        float r3 = -r2;
        r0.offset(r3, r3);
        return r0;
    }

    @NotNull
    public static final Rect plus(@NotNull Rect r1, int r2) {
        Intrinsics.g(r1, "$this$plus");
        Rect r0 = new Rect(r1);
        r0.offset(r2, r2);
        return r0;
    }

    @NotNull
    public static final Rect minus(@NotNull Rect r1, @NotNull Point r2) {
        Intrinsics.g(r1, "$this$minus");
        Intrinsics.g(r2, "xy");
        Rect r0 = new Rect(r1);
        r0.offset(-r2.x, -r2.y);
        return r0;
    }

    @NotNull
    public static final RectF plus(@NotNull RectF r1, float r2) {
        Intrinsics.g(r1, "$this$plus");
        RectF r0 = new RectF(r1);
        r0.offset(r2, r2);
        return r0;
    }

    @NotNull
    public static final RectF minus(@NotNull RectF r1, @NotNull PointF r2) {
        Intrinsics.g(r1, "$this$minus");
        Intrinsics.g(r2, "xy");
        RectF r0 = new RectF(r1);
        r0.offset(-r2.x, -r2.y);
        return r0;
    }

    @NotNull
    public static final Rect plus(@NotNull Rect r1, @NotNull Point r2) {
        Intrinsics.g(r1, "$this$plus");
        Intrinsics.g(r2, "xy");
        Rect r0 = new Rect(r1);
        r0.offset(r2.x, r2.y);
        return r0;
    }

    @NotNull
    public static final Region minus(@NotNull RectF r1, @NotNull RectF r2) {
        Intrinsics.g(r1, "$this$minus");
        Intrinsics.g(r2, "r");
        Rect r0 = new Rect();
        r1.roundOut(r0);
        Region r3 = new Region(r0);
        Rect r4 = new Rect();
        r2.roundOut(r4);
        r3.op(r4, Region.Op.DIFFERENCE);
        return r3;
    }

    @NotNull
    public static final RectF plus(@NotNull RectF r1, @NotNull PointF r2) {
        Intrinsics.g(r1, "$this$plus");
        Intrinsics.g(r2, "xy");
        RectF r0 = new RectF(r1);
        r0.offset(r2.x, r2.y);
        return r0;
    }
}
