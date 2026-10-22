package androidx.core.graphics;

import android.graphics.Color;
import android.graphics.ColorSpace;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ColorKt {
    public static final int component1(@ColorInt int r0) {
        return (r0 >> 24) & 255;
    }

    public static final int component2(@ColorInt int r0) {
        return (r0 >> 16) & 255;
    }

    public static final int component3(@ColorInt int r0) {
        return (r0 >> 8) & 255;
    }

    public static final int component4(@ColorInt int r0) {
        return r0 & 255;
    }

    @RequiresApi(26)
    public static final long convertTo(@ColorInt int r1, @NotNull ColorSpace.Named r2) {
        Intrinsics.g(r2, "colorSpace");
        return Color.convert(r1, ColorSpace.get(r2));
    }

    public static final int getAlpha(@ColorInt int r0) {
        return (r0 >> 24) & 255;
    }

    public static final int getBlue(@ColorInt int r0) {
        return r0 & 255;
    }

    @RequiresApi(26)
    @NotNull
    public static final ColorSpace getColorSpace(long r0) {
        ColorSpace r1 = Color.colorSpace(r0);
        Intrinsics.b(r1, "Color.colorSpace(this)");
        return r1;
    }

    public static final int getGreen(@ColorInt int r0) {
        return (r0 >> 8) & 255;
    }

    @RequiresApi(26)
    public static final float getLuminance(@ColorInt int r0) {
        return Color.luminance(r0);
    }

    public static final int getRed(@ColorInt int r0) {
        return (r0 >> 16) & 255;
    }

    @RequiresApi(26)
    public static final boolean isSrgb(long r0) {
        return Color.isSrgb(r0);
    }

    @RequiresApi(26)
    public static final boolean isWideGamut(long r0) {
        return Color.isWideGamut(r0);
    }

    @RequiresApi(26)
    @NotNull
    public static final Color plus(@NotNull Color r1, @NotNull Color r2) {
        Intrinsics.g(r1, "$this$plus");
        Intrinsics.g(r2, "c");
        Color r3 = ColorUtils.compositeColors(r2, r1);
        Intrinsics.b(r3, "ColorUtils.compositeColors(c, this)");
        return r3;
    }

    @RequiresApi(26)
    @NotNull
    public static final Color toColor(@ColorInt int r1) {
        Color r2 = Color.valueOf(r1);
        Intrinsics.b(r2, "Color.valueOf(this)");
        return r2;
    }

    @ColorInt
    @RequiresApi(26)
    public static final int toColorInt(long r0) {
        return Color.toArgb(r0);
    }

    @RequiresApi(26)
    public static final long toColorLong(@ColorInt int r2) {
        return Color.pack(r2);
    }

    @RequiresApi(26)
    public static final float component1(@NotNull Color r1) {
        Intrinsics.g(r1, "$this$component1");
        return r1.getComponent(0);
    }

    @RequiresApi(26)
    public static final float component2(@NotNull Color r1) {
        Intrinsics.g(r1, "$this$component2");
        return r1.getComponent(1);
    }

    @RequiresApi(26)
    public static final float component3(@NotNull Color r1) {
        Intrinsics.g(r1, "$this$component3");
        return r1.getComponent(2);
    }

    @RequiresApi(26)
    public static final float component4(@NotNull Color r1) {
        Intrinsics.g(r1, "$this$component4");
        return r1.getComponent(3);
    }

    @RequiresApi(26)
    public static final long convertTo(@ColorInt int r1, @NotNull ColorSpace r2) {
        Intrinsics.g(r2, "colorSpace");
        return Color.convert(r1, r2);
    }

    @RequiresApi(26)
    public static final float getAlpha(long r0) {
        return Color.alpha(r0);
    }

    @RequiresApi(26)
    public static final float getBlue(long r0) {
        return Color.blue(r0);
    }

    @RequiresApi(26)
    public static final float getGreen(long r0) {
        return Color.green(r0);
    }

    @RequiresApi(26)
    public static final float getLuminance(long r0) {
        return Color.luminance(r0);
    }

    @RequiresApi(26)
    public static final float getRed(long r0) {
        return Color.red(r0);
    }

    @RequiresApi(26)
    @NotNull
    public static final Color toColor(long r0) {
        Color r1 = Color.valueOf(r0);
        Intrinsics.b(r1, "Color.valueOf(this)");
        return r1;
    }

    @ColorInt
    public static final int toColorInt(@NotNull String r1) {
        Intrinsics.g(r1, "$this$toColorInt");
        return Color.parseColor(r1);
    }

    @RequiresApi(26)
    public static final float component1(long r0) {
        return Color.red(r0);
    }

    @RequiresApi(26)
    public static final float component2(long r0) {
        return Color.green(r0);
    }

    @RequiresApi(26)
    public static final float component3(long r0) {
        return Color.blue(r0);
    }

    @RequiresApi(26)
    public static final float component4(long r0) {
        return Color.alpha(r0);
    }

    @RequiresApi(26)
    public static final long convertTo(long r1, @NotNull ColorSpace.Named r3) {
        Intrinsics.g(r3, "colorSpace");
        return Color.convert(r1, ColorSpace.get(r3));
    }

    @RequiresApi(26)
    public static final long convertTo(long r1, @NotNull ColorSpace r3) {
        Intrinsics.g(r3, "colorSpace");
        return Color.convert(r1, r3);
    }

    @RequiresApi(26)
    public static final Color convertTo(@NotNull Color r1, @NotNull ColorSpace.Named r2) {
        Intrinsics.g(r1, "$this$convertTo");
        Intrinsics.g(r2, "colorSpace");
        return r1.convert(ColorSpace.get(r2));
    }

    @RequiresApi(26)
    public static final Color convertTo(@NotNull Color r1, @NotNull ColorSpace r2) {
        Intrinsics.g(r1, "$this$convertTo");
        Intrinsics.g(r2, "colorSpace");
        return r1.convert(r2);
    }
}
