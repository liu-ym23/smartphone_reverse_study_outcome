package com.obric.oui.common.style;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import androidx.appcompat.content.res.AppCompatResources;

/* JADX INFO: loaded from: classes3.dex */
public class OUIDrawableHelper {
    public OUIDrawableHelper() {
    }

    public static Drawable getVectorDrawable(Context r0, int r1) {
        return AppCompatResources.getDrawable(r0, r1);
    L4:
        return null;
    }

    public static Bitmap vectorDrawableToBitmap(Context r4, int r5) {
        Drawable r6 = getVectorDrawable(r4, r5);
        if (r6 == null) goto L6;
        Bitmap r7 = Bitmap.createBitmap(r6.getIntrinsicWidth(), r6.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas r0 = new Canvas(r7);
        r6.setBounds(0, 0, r0.getWidth(), r0.getHeight());
        r6.draw(r0);
        return r7;
    L6:
        return null;
    }

    public static GradientDrawable createColorWithCornerRadiusDrawable(int r2, float r3, float r4, float r5, float r6) {
        GradientDrawable r0 = new GradientDrawable();
        r0.setColor(r2);
        r0.setCornerRadii(new float[]{r3, r3, r4, r4, r5, r5, r6, r6});
        return r0;
    }
}
