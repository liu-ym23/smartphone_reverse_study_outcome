package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class BitmapKt {
    @NotNull
    public static final Bitmap applyCanvas(@NotNull Bitmap r1, @NotNull Function1<? super Canvas, Unit> r2) {
        Intrinsics.g(r1, "$this$applyCanvas");
        Intrinsics.g(r2, "block");
        r2.invoke(new Canvas(r1));
        return r1;
    }

    public static final boolean contains(@NotNull Bitmap r2, @NotNull Point r3) {
        Intrinsics.g(r2, "$this$contains");
        Intrinsics.g(r3, "p");
        int r0 = r3.x;
        if (r0 >= 0) goto L5;
    L11:
        return false;
    L5:
        if (r0 >= r2.getWidth()) goto L11;
        int r4 = r3.y;
        if (r4 < 0) goto L11;
        if (r4 >= r2.getHeight()) goto L11;
        return true;
    }

    @NotNull
    public static final Bitmap createBitmap(int r1, int r2, @NotNull Bitmap.Config r3) {
        Intrinsics.g(r3, "config");
        Bitmap r4 = Bitmap.createBitmap(r1, r2, r3);
        Intrinsics.b(r4, "Bitmap.createBitmap(width, height, config)");
        return r4;
    }

    @NotNull
    public static /* synthetic */ Bitmap createBitmap$default(int r0, int r1, Bitmap.Config r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L5;
        r2 = Bitmap.Config.ARGB_8888;
    L5:
        Intrinsics.g(r2, "config");
        Bitmap r5 = Bitmap.createBitmap(r0, r1, r2);
        Intrinsics.b(r5, "Bitmap.createBitmap(width, height, config)");
        return r5;
    }

    public static final int get(@NotNull Bitmap r1, int r2, int r3) {
        Intrinsics.g(r1, "$this$get");
        return r1.getPixel(r2, r3);
    }

    @NotNull
    public static final Bitmap scale(@NotNull Bitmap r1, int r2, int r3, boolean r4) {
        Intrinsics.g(r1, "$this$scale");
        Bitmap r5 = Bitmap.createScaledBitmap(r1, r2, r3, r4);
        Intrinsics.b(r5, "Bitmap.createScaledBitma…s, width, height, filter)");
        return r5;
    }

    @NotNull
    public static /* synthetic */ Bitmap scale$default(Bitmap r0, int r1, int r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = true;
    L5:
        Intrinsics.g(r0, "$this$scale");
        Bitmap r6 = Bitmap.createScaledBitmap(r0, r1, r2, r3);
        Intrinsics.b(r6, "Bitmap.createScaledBitma…s, width, height, filter)");
        return r6;
    }

    public static final void set(@NotNull Bitmap r1, int r2, int r3, @ColorInt int r4) {
        Intrinsics.g(r1, "$this$set");
        r1.setPixel(r2, r3, r4);
    }

    public static final boolean contains(@NotNull Bitmap r4, @NotNull PointF r5) {
        Intrinsics.g(r4, "$this$contains");
        Intrinsics.g(r5, "p");
        float r0 = r5.x;
        float r2 = 0;
        if (r0 >= r2) goto L5;
        return false;
    L5:
        if (r0 >= r4.getWidth()) goto L13;
        float r6 = r5.y;
        if (r6 >= r2) goto L9;
        return false;
    L9:
        if (r6 >= r4.getHeight()) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    }

    @RequiresApi(26)
    @NotNull
    public static final Bitmap createBitmap(int r1, int r2, @NotNull Bitmap.Config r3, boolean r4, @NotNull ColorSpace r5) {
        Intrinsics.g(r3, "config");
        Intrinsics.g(r5, "colorSpace");
        Bitmap r6 = Bitmap.createBitmap(r1, r2, r3, r4, r5);
        Intrinsics.b(r6, "Bitmap.createBitmap(widt…ig, hasAlpha, colorSpace)");
        return r6;
    }

    @RequiresApi(26)
    @NotNull
    public static /* synthetic */ Bitmap createBitmap$default(int r0, int r1, Bitmap.Config r2, boolean r3, ColorSpace r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r2 = Bitmap.Config.ARGB_8888;
    L6:
        if ((r5 & 8) == 0) goto L9;
        r3 = true;
    L9:
        if ((r5 & 16) == 0) goto L11;
        r4 = ColorSpace.get(ColorSpace.Named.SRGB);
        Intrinsics.b(r4, "ColorSpace.get(ColorSpace.Named.SRGB)");
    L11:
        Intrinsics.g(r2, "config");
        Intrinsics.g(r4, "colorSpace");
        Bitmap r7 = Bitmap.createBitmap(r0, r1, r2, r3, r4);
        Intrinsics.b(r7, "Bitmap.createBitmap(widt…ig, hasAlpha, colorSpace)");
        return r7;
    }
}
