package com.android.launcher3.icons;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import androidx.core.graphics.PathParser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class GraphicsUtils {
    private static final float MASK_SIZE = 100.0f;
    private static final String TAG = "GraphicsUtils";
    public static Runnable sOnNewBitmapRunnable;

    static /* synthetic */ void lambda$static$0() {
    }

    public static int setColorAlphaBound(int r1, int r2) {
        if (r2 >= 0) goto L5;
        r2 = 0;
    L8:
        return (r1 & 16777215) | (r2 << 24);
    L5:
        if (r2 <= 255) goto L8;
        r2 = 255;
        goto L8
    }

    public GraphicsUtils() {
    }

    static {
        sOnNewBitmapRunnable = new GraphicsUtils$$ExternalSyntheticLambda0();
    }

    public static byte[] flattenBitmap(Bitmap r3) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(getExpectedBitmapSize(r3));
        r3.compress(Bitmap.CompressFormat.PNG, 100, r0);     // Catch: IOException -> L5
        r0.flush();     // Catch: IOException -> L5
        r0.close();     // Catch: IOException -> L5
        return r0.toByteArray();
    L5:
        Log.w(TAG, "Could not write bitmap");
        return null;
    }

    static int getExpectedBitmapSize(Bitmap r1) {
        return (r1.getWidth() * r1.getHeight()) * 4;
    }

    public static int getArea(Region r4) {
        RegionIterator r0 = new RegionIterator(r4);
        Rect r5 = new Rect();
        int r1 = 0;
    L4:
        if (r0.next(r5) == false) goto L6;
        r1 = r1 + (r5.width() * r5.height());
        goto L4
    L6:
        return r1;
    }

    public static void noteNewBitmapCreated() {
        sOnNewBitmapRunnable.run();
    }

    public static Path getShapePath(Context r3, int r4) {
        if (IconProvider.CONFIG_ICON_MASK_RES_ID == 0) goto L10;
        Path r5 = PathParser.createPathFromPathData(r3.getString(IconProvider.CONFIG_ICON_MASK_RES_ID));
        if (r5 == null) goto L10;
        float r6 = r4;
        if (r6 == MASK_SIZE) goto L9;
        Matrix r1 = new Matrix();
        float r7 = r6 / MASK_SIZE;
        r1.setScale(r7, r7);
        r5.transform(r1);
    L9:
        return r5;
    L10:
        AdaptiveIconDrawable r8 = new AdaptiveIconDrawable(new ColorDrawable(-16777216), new ColorDrawable(-16777216));
        r8.setBounds(0, 0, r4, r4);
        return new Path(r8.getIconMask());
    }

    public static int getAttrColor(Context r2, int r3) {
        TypedArray r4 = r2.obtainStyledAttributes(new int[]{r3});
        int r5 = r4.getColor(0, 0);
        r4.recycle();
        return r5;
    }

    public static float getFloat(Context r2, int r3, float r4) {
        TypedArray r5 = r2.obtainStyledAttributes(new int[]{r3});
        float r6 = r5.getFloat(0, r4);
        r5.recycle();
        return r6;
    }
}
