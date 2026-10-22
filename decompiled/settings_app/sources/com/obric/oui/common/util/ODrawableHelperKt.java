package com.obric.oui.common.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ODrawableHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0003\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\u0001\u001a\u001c\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003¨\u0006\u000b"}, d2 = {"covertToTinted", "Landroid/graphics/drawable/Drawable;", "tintColor", "", "createTintBlackColorFilter", "Landroid/graphics/ColorMatrixColorFilter;", "drawableToBitmap", "Landroid/graphics/Bitmap;", "scaleDrawable", "w", "h", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ODrawableHelperKt {
    public static final Drawable covertToTinted(Drawable r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Drawable r3 = DrawableCompat.wrap(r1).mutate();
        Intrinsics.checkNotNullExpressionValue(r3, "wrap(this).mutate()");
        DrawableCompat.setTint(r3, r2);
        return r3;
    }

    public static final ColorMatrixColorFilter createTintBlackColorFilter(int r5) {
        return new ColorMatrixColorFilter(new float[]{1.0f, 0.0f, 0.0f, 0.0f, Color.red(r5), 0.0f, 1.0f, 0.0f, 0.0f, Color.green(r5), 0.0f, 0.0f, 1.0f, 0.0f, Color.blue(r5), 0.0f, 0.0f, 0.0f, (Color.alpha(r5) * 1.0f) / 255, 0.0f});
    }

    public static final Drawable scaleDrawable(Drawable r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        int r4 = r8.getIntrinsicWidth();
        int r5 = r8.getIntrinsicHeight();
        Bitmap r1 = drawableToBitmap(r8);
        Matrix r6 = new Matrix();
        r6.postScale(r9 / r4, r10 / r5);
        return new BitmapDrawable(null, Bitmap.createBitmap(r1, 0, 0, r4, r5, r6, true));
    }

    public static final Bitmap drawableToBitmap(Drawable r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        int r0 = r5.getIntrinsicWidth();
        int r1 = r5.getIntrinsicHeight();
        if (r5.getOpacity() == (-1)) goto L5;
        Bitmap.Config r2 = Bitmap.Config.ARGB_8888;
    L6:
        Bitmap r3 = Bitmap.createBitmap(r0, r1, r2);
        Canvas r4 = new Canvas(r3);
        r5.setBounds(0, 0, r0, r1);
        r5.draw(r4);
        Intrinsics.checkNotNullExpressionValue(r3, "bitmap");
        return r3;
    L5:
        r2 = Bitmap.Config.RGB_565;
        goto L6
    }
}
