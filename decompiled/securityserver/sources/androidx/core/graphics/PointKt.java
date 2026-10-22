package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.PointF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class PointKt {
    public static final int component1(@NotNull Point r1) {
        Intrinsics.g(r1, "$this$component1");
        return r1.x;
    }

    public static final int component2(@NotNull Point r1) {
        Intrinsics.g(r1, "$this$component2");
        return r1.y;
    }

    @NotNull
    public static final Point minus(@NotNull Point r2, @NotNull Point r3) {
        Intrinsics.g(r2, "$this$minus");
        Intrinsics.g(r3, "p");
        Point r0 = new Point(r2.x, r2.y);
        r0.offset(-r3.x, -r3.y);
        return r0;
    }

    @NotNull
    public static final Point plus(@NotNull Point r2, @NotNull Point r3) {
        Intrinsics.g(r2, "$this$plus");
        Intrinsics.g(r3, "p");
        Point r0 = new Point(r2.x, r2.y);
        r0.offset(r3.x, r3.y);
        return r0;
    }

    @NotNull
    public static final Point toPoint(@NotNull PointF r2) {
        Intrinsics.g(r2, "$this$toPoint");
        return new Point((int) r2.x, (int) r2.y);
    }

    @NotNull
    public static final PointF toPointF(@NotNull Point r1) {
        Intrinsics.g(r1, "$this$toPointF");
        return new PointF(r1);
    }

    @NotNull
    public static final Point unaryMinus(@NotNull Point r2) {
        Intrinsics.g(r2, "$this$unaryMinus");
        return new Point(-r2.x, -r2.y);
    }

    public static final float component1(@NotNull PointF r1) {
        Intrinsics.g(r1, "$this$component1");
        return r1.x;
    }

    public static final float component2(@NotNull PointF r1) {
        Intrinsics.g(r1, "$this$component2");
        return r1.y;
    }

    @NotNull
    public static final PointF unaryMinus(@NotNull PointF r2) {
        Intrinsics.g(r2, "$this$unaryMinus");
        return new PointF(-r2.x, -r2.y);
    }

    @NotNull
    public static final PointF minus(@NotNull PointF r2, @NotNull PointF r3) {
        Intrinsics.g(r2, "$this$minus");
        Intrinsics.g(r3, "p");
        PointF r0 = new PointF(r2.x, r2.y);
        r0.offset(-r3.x, -r3.y);
        return r0;
    }

    @NotNull
    public static final PointF plus(@NotNull PointF r2, @NotNull PointF r3) {
        Intrinsics.g(r2, "$this$plus");
        Intrinsics.g(r3, "p");
        PointF r0 = new PointF(r2.x, r2.y);
        r0.offset(r3.x, r3.y);
        return r0;
    }

    @NotNull
    public static final Point minus(@NotNull Point r2, int r3) {
        Intrinsics.g(r2, "$this$minus");
        Point r0 = new Point(r2.x, r2.y);
        int r4 = -r3;
        r0.offset(r4, r4);
        return r0;
    }

    @NotNull
    public static final Point plus(@NotNull Point r2, int r3) {
        Intrinsics.g(r2, "$this$plus");
        Point r0 = new Point(r2.x, r2.y);
        r0.offset(r3, r3);
        return r0;
    }

    @NotNull
    public static final PointF minus(@NotNull PointF r2, float r3) {
        Intrinsics.g(r2, "$this$minus");
        PointF r0 = new PointF(r2.x, r2.y);
        float r4 = -r3;
        r0.offset(r4, r4);
        return r0;
    }

    @NotNull
    public static final PointF plus(@NotNull PointF r2, float r3) {
        Intrinsics.g(r2, "$this$plus");
        PointF r0 = new PointF(r2.x, r2.y);
        r0.offset(r3, r3);
        return r0;
    }
}
