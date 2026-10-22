package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TintTypedArray;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MaterialResources {
    private static final float FONT_SCALE_1_3 = 1.3f;
    private static final float FONT_SCALE_2_0 = 2.0f;

    private MaterialResources() {
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Context r1, @NonNull TypedArray r2, @StyleableRes int r3) {
        if (r2.hasValue(r3) == false) goto L10;
        int r0 = r2.getResourceId(r3, 0);
        if (r0 == 0) goto L10;
        ColorStateList r4 = AppCompatResources.getColorStateList(r1, r0);
        if (r4 == null) goto L10;
        return r4;
    L10:
        if (Build.VERSION.SDK_INT > 15) goto L16;
        int r5 = r2.getColor(r3, -1);
        if (r5 == (-1)) goto L16;
        return ColorStateList.valueOf(r5);
    L16:
        return r2.getColorStateList(r3);
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Context r1, @NonNull TintTypedArray r2, @StyleableRes int r3) {
        if (r2.hasValue(r3) == false) goto L10;
        int r0 = r2.getResourceId(r3, 0);
        if (r0 == 0) goto L10;
        ColorStateList r4 = AppCompatResources.getColorStateList(r1, r0);
        if (r4 == null) goto L10;
        return r4;
    L10:
        if (Build.VERSION.SDK_INT > 15) goto L16;
        int r5 = r2.getColor(r3, -1);
        if (r5 == (-1)) goto L16;
        return ColorStateList.valueOf(r5);
    L16:
        return r2.getColorStateList(r3);
    }

    public static int getDimensionPixelSize(@NonNull Context r3, @NonNull TypedArray r4, @StyleableRes int r5, int r6) {
        TypedValue r0 = new TypedValue();
        if (r4.getValue(r5, r0) == false) goto L10;
        if (r0.type != 2) goto L10;
        TypedArray r7 = r3.getTheme().obtainStyledAttributes(new int[]{r0.data});
        int r8 = r7.getDimensionPixelSize(0, r6);
        r7.recycle();
        return r8;
    L10:
        return r4.getDimensionPixelSize(r5, r6);
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Context r1, @NonNull TypedArray r2, @StyleableRes int r3) {
        if (r2.hasValue(r3) == false) goto L10;
        int r0 = r2.getResourceId(r3, 0);
        if (r0 == 0) goto L10;
        Drawable r4 = AppCompatResources.getDrawable(r1, r0);
        if (r4 == null) goto L10;
        return r4;
    L10:
        return r2.getDrawable(r3);
    }

    @StyleableRes
    static int getIndexWithValue(@NonNull TypedArray r0, @StyleableRes int r1, @StyleableRes int r2) {
        if (r0.hasValue(r1) == false) goto L5;
        return r1;
    L5:
        return r2;
    }

    @Nullable
    public static TextAppearance getTextAppearance(@NonNull Context r1, @NonNull TypedArray r2, @StyleableRes int r3) {
        if (r2.hasValue(r3) == false) goto L8;
        int r4 = r2.getResourceId(r3, 0);
        if (r4 != 0) goto L7;
        return null;
    L7:
        return new TextAppearance(r1, r4);
    L8:
        return null;
    }

    public static boolean isFontScaleAtLeast1_3(@NonNull Context r1) {
        if (r1.getResources().getConfiguration().fontScale < FONT_SCALE_1_3) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isFontScaleAtLeast2_0(@NonNull Context r1) {
        if (r1.getResources().getConfiguration().fontScale < FONT_SCALE_2_0) goto L5;
        return true;
    L5:
        return false;
    }
}
