package com.obric.oui.icon;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class IconUtils {
    public static LayerDrawable a(Context r6, int r7, Drawable r8) {
        Intrinsics.f(r6, "context");
        Resources r0 = r6.getResources();
        Intrinsics.e(r0, "context.resources");
        int r1 = (int) (1.33f * r0.getDisplayMetrics().density);
        GradientDrawable r2 = new GradientDrawable();
        r2.setShape(1);
        r2.setStroke(r1, r7);
        r2.setColor(0);
        if ((r8 instanceof BitmapDrawable) == false) goto L5;
        Bitmap r9 = ((BitmapDrawable) r8).getBitmap();
        Intrinsics.e(r9, "drawable.bitmap");
    L12:
        RoundedBitmapDrawable r10 = RoundedBitmapDrawableFactory.create(r6.getResources(), r9);
        r10.setCircular(true);
        return new LayerDrawable(new Drawable[]{r10, r2});
    L5:
        Resources r3 = r6.getResources();
        Intrinsics.e(r3, "context.resources");
        float r4 = r3.getDisplayMetrics().density;
        int r5 = r8.getIntrinsicWidth();
        if (r5 >= 1) goto L8;
        r5 = 1;
    L8:
        int r11 = r8.getIntrinsicHeight();
        if (r11 >= 1) goto L11;
        r11 = 1;
    L11:
        Bitmap r12 = Bitmap.createBitmap(r5, r11, Bitmap.Config.ARGB_8888);
        Canvas r13 = new Canvas(r12);
        r8.setBounds(0, 0, r13.getWidth(), r13.getHeight());
        r8.draw(r13);
        Intrinsics.e(r12, "bitmap");
        r9 = r12;
        goto L12
    }
}
