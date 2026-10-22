package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleableRes;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class TypedArrayKt {
    private static final void checkAttribute(@NotNull TypedArray r0, @StyleableRes int r1) {
        if (r0.hasValue(r1) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Attribute not defined in set.");
    }

    public static final boolean getBooleanOrThrow(@NotNull TypedArray r1, @StyleableRes int r2) {
        Intrinsics.g(r1, "$this$getBooleanOrThrow");
        checkAttribute(r1, r2);
        return r1.getBoolean(r2, false);
    }

    @ColorInt
    public static final int getColorOrThrow(@NotNull TypedArray r1, @StyleableRes int r2) {
        Intrinsics.g(r1, "$this$getColorOrThrow");
        checkAttribute(r1, r2);
        return r1.getColor(r2, 0);
    }

    @NotNull
    public static final ColorStateList getColorStateListOrThrow(@NotNull TypedArray r1, @StyleableRes int r2) {
        Intrinsics.g(r1, "$this$getColorStateListOrThrow");
        checkAttribute(r1, r2);
        ColorStateList r3 = r1.getColorStateList(r2);
        if (r3 == null) goto L6;
        return r3;
    L6:
        throw new IllegalStateException("Attribute value was not a color or color state list.".toString());
    }

    public static final float getDimensionOrThrow(@NotNull TypedArray r1, @StyleableRes int r2) {
        Intrinsics.g(r1, "$this$getDimensionOrThrow");
        checkAttribute(r1, r2);
        return r1.getDimension(r2, 0.0f);
    }

    @Dimension
    public static final int getDimensionPixelOffsetOrThrow(@NotNull TypedArray r1, @StyleableRes int r2) {
        Intrinsics.g(r1, "$this$getDimensionPixelOffsetOrThrow");
        checkAttribute(r1, r2);
        return r1.getDimensionPixelOffset(r2, 0);
    }

    @Dimension
    public static final int getDimensionPixelSizeOrThrow(@NotNull TypedArray r1, @StyleableRes int r2) {
        Intrinsics.g(r1, "$this$getDimensionPixelSizeOrThrow");
        checkAttribute(r1, r2);
        return r1.getDimensionPixelSize(r2, 0);
    }

    @NotNull
    public static final Drawable getDrawableOrThrow(@NotNull TypedArray r1, @StyleableRes int r2) {
        Intrinsics.g(r1, "$this$getDrawableOrThrow");
        checkAttribute(r1, r2);
        Drawable r3 = r1.getDrawable(r2);
        if (r3 == null) goto L5;
        return r3;
    L5:
        Intrinsics.k();
        throw null;
    }

    public static final float getFloatOrThrow(@NotNull TypedArray r1, @StyleableRes int r2) {
        Intrinsics.g(r1, "$this$getFloatOrThrow");
        checkAttribute(r1, r2);
        return r1.getFloat(r2, 0.0f);
    }

    @RequiresApi(26)
    @NotNull
    public static final Typeface getFontOrThrow(@NotNull TypedArray r1, @StyleableRes int r2) {
        Intrinsics.g(r1, "$this$getFontOrThrow");
        checkAttribute(r1, r2);
        Typeface r3 = r1.getFont(r2);
        if (r3 == null) goto L5;
        return r3;
    L5:
        Intrinsics.k();
        throw null;
    }

    public static final int getIntOrThrow(@NotNull TypedArray r1, @StyleableRes int r2) {
        Intrinsics.g(r1, "$this$getIntOrThrow");
        checkAttribute(r1, r2);
        return r1.getInt(r2, 0);
    }

    public static final int getIntegerOrThrow(@NotNull TypedArray r1, @StyleableRes int r2) {
        Intrinsics.g(r1, "$this$getIntegerOrThrow");
        checkAttribute(r1, r2);
        return r1.getInteger(r2, 0);
    }

    @AnyRes
    public static final int getResourceIdOrThrow(@NotNull TypedArray r1, @StyleableRes int r2) {
        Intrinsics.g(r1, "$this$getResourceIdOrThrow");
        checkAttribute(r1, r2);
        return r1.getResourceId(r2, 0);
    }

    @NotNull
    public static final String getStringOrThrow(@NotNull TypedArray r1, @StyleableRes int r2) {
        Intrinsics.g(r1, "$this$getStringOrThrow");
        checkAttribute(r1, r2);
        String r3 = r1.getString(r2);
        if (r3 == null) goto L6;
        return r3;
    L6:
        throw new IllegalStateException("Attribute value could not be coerced to String.".toString());
    }

    @NotNull
    public static final CharSequence[] getTextArrayOrThrow(@NotNull TypedArray r1, @StyleableRes int r2) {
        Intrinsics.g(r1, "$this$getTextArrayOrThrow");
        checkAttribute(r1, r2);
        CharSequence[] r3 = r1.getTextArray(r2);
        Intrinsics.b(r3, "getTextArray(index)");
        return r3;
    }

    @NotNull
    public static final CharSequence getTextOrThrow(@NotNull TypedArray r1, @StyleableRes int r2) {
        Intrinsics.g(r1, "$this$getTextOrThrow");
        checkAttribute(r1, r2);
        CharSequence r3 = r1.getText(r2);
        if (r3 == null) goto L6;
        return r3;
    L6:
        throw new IllegalStateException("Attribute value could not be coerced to CharSequence.".toString());
    }

    public static final <R> R use(@NotNull TypedArray r1, @NotNull Function1<? super TypedArray, ? extends R> r2) {
        Intrinsics.g(r1, "$this$use");
        Intrinsics.g(r2, "block");
        R r3 = (R) r2.invoke(r1);
        r1.recycle();
        return r3;
    }
}
