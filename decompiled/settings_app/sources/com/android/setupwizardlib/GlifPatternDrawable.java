package com.android.setupwizardlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes.dex */
public class GlifPatternDrawable extends Drawable {
    private static final int[] ATTRS_PRIMARY_COLOR = null;
    private static final float COLOR_ALPHA = 0.8f;
    private static final int COLOR_ALPHA_INT = 204;
    private static final float MAX_CACHED_BITMAP_SCALE = 1.5f;
    private static final int NUM_PATHS = 7;
    private static final float SCALE_FOCUS_X = 0.146f;
    private static final float SCALE_FOCUS_Y = 0.228f;
    private static final float VIEWBOX_HEIGHT = 768.0f;
    private static final float VIEWBOX_WIDTH = 1366.0f;
    private static SoftReference<Bitmap> bitmapCache;
    private static int[] patternLightness;
    private static Path[] patternPaths;
    private int color;
    private final Paint tempPaint;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
    }

    static {
        ATTRS_PRIMARY_COLOR = new int[]{android.R.attr.colorPrimary};
    }

    public static GlifPatternDrawable getDefault(Context r2) {
        TypedArray r3 = r2.obtainStyledAttributes(ATTRS_PRIMARY_COLOR);
        int r0 = r3.getColor(0, -16777216);
        r3.recycle();
        return new GlifPatternDrawable(r0);
    }

    public static void invalidatePattern() {
        bitmapCache = null;
    }

    public GlifPatternDrawable(int r3) {
        this.tempPaint = new Paint(1);
        setColor(r3);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r9) {
        Rect r0 = getBounds();
        int r1 = r0.width();
        int r2 = r0.height();
        SoftReference<Bitmap> r3 = bitmapCache;
        Bitmap r4 = null;
        if (r3 == null) goto L5;
        Bitmap r5 = r3.get();
    L6:
        if (r5 == null) goto L16;
        int r6 = r5.getWidth();
        int r7 = r5.getHeight();
        if (r1 > r6) goto L10;
    L12:
        if (r2 <= r7) goto L16;
        if (r7 >= 1152.0f) goto L16;
    L17:
        if (r4 != null) goto L19;
        this.tempPaint.reset();
        r4 = createBitmapCache(r1, r2);
        bitmapCache = new SoftReference(r4);
        this.tempPaint.reset();
    L19:
        r9.save();
        r9.clipRect(r0);
        scaleCanvasToBounds(r9, r4, r0);
        r9.drawColor(-16777216);
        this.tempPaint.setColor(-1);
        r9.drawBitmap(r4, 0.0f, 0.0f, this.tempPaint);
        r9.drawColor(this.color);
        r9.restore();
        return;
    L10:
        if (r6 >= 2049.0f) goto L12;
    L16:
        r4 = r5;
        goto L17
    L5:
        r5 = null;
        goto L6
    }

    public Bitmap createBitmapCache(int r3, int r4) {
        float r5 = Math.min(MAX_CACHED_BITMAP_SCALE, Math.max(r3 / VIEWBOX_WIDTH, r4 / VIEWBOX_HEIGHT));
        Bitmap r6 = Bitmap.createBitmap((int) (VIEWBOX_WIDTH * r5), (int) (VIEWBOX_HEIGHT * r5), Bitmap.Config.ALPHA_8);
        renderOnCanvas(new Canvas(r6), r5);
        return r6;
    }

    private void renderOnCanvas(Canvas r13, float r14) {
        r13.save();
        r13.scale(r14, r14);
        this.tempPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        int r0 = 0;
        if (patternPaths != null) goto L5;
        Path[] r15 = new Path[7];
        patternPaths = r15;
        patternLightness = new int[]{10, 40, 51, 66, 91, 112, 130};
        Path r2 = new Path();
        r15[0] = r2;
        r2.moveTo(1029.4f, 357.5f);
        r2.lineTo(VIEWBOX_WIDTH, 759.1f);
        r2.lineTo(VIEWBOX_WIDTH, 0.0f);
        r2.lineTo(1137.7f, 0.0f);
        r2.close();
        Path[] r3 = patternPaths;
        Path r10 = new Path();
        r3[1] = r10;
        r10.moveTo(1138.1f, 0.0f);
        r10.rLineTo(-144.8f, VIEWBOX_HEIGHT);
        r10.rLineTo(372.7f, 0.0f);
        r10.rLineTo(0.0f, -524.0f);
        r10.cubicTo(1290.7f, 121.6f, 1219.2f, 41.1f, 1178.7f, 0.0f);
        r10.close();
        Path[] r4 = patternPaths;
        Path r11 = new Path();
        r4[2] = r11;
        r11.moveTo(949.8f, VIEWBOX_HEIGHT);
        r11.rCubicTo(92.6f, -170.6f, 213.0f, -440.3f, 269.4f, -768.0f);
        r11.lineTo(585.0f, 0.0f);
        r11.rLineTo(2.1f, 766.0f);
        r11.close();
        Path[] r5 = patternPaths;
        Path r12 = new Path();
        r5[3] = r12;
        r12.moveTo(471.1f, VIEWBOX_HEIGHT);
        r12.rMoveTo(704.5f, 0.0f);
        r12.cubicTo(1123.6f, 563.3f, 1027.4f, 275.2f, 856.2f, 0.0f);
        r12.lineTo(476.4f, 0.0f);
        r12.rLineTo(-5.3f, VIEWBOX_HEIGHT);
        r12.close();
        Path[] r6 = patternPaths;
        Path r16 = new Path();
        r6[4] = r16;
        r16.moveTo(323.1f, VIEWBOX_HEIGHT);
        r16.moveTo(777.5f, VIEWBOX_HEIGHT);
        r16.cubicTo(661.9f, 348.8f, 427.2f, 21.4f, 401.2f, 25.4f);
        r16.lineTo(323.1f, VIEWBOX_HEIGHT);
        r16.close();
        Path[] r7 = patternPaths;
        Path r17 = new Path();
        r7[5] = r17;
        r17.moveTo(178.44286f, 766.8571f);
        r17.lineTo(308.7f, VIEWBOX_HEIGHT);
        r17.cubicTo(381.7f, 604.6f, 481.6f, 344.3f, 562.2f, 0.0f);
        r17.lineTo(0.0f, 0.0f);
        r17.close();
        Path[] r8 = patternPaths;
        Path r18 = new Path();
        r8[6] = r18;
        r18.moveTo(146.0f, 0.0f);
        r18.lineTo(0.0f, 0.0f);
        r18.lineTo(0.0f, VIEWBOX_HEIGHT);
        r18.lineTo(394.2f, VIEWBOX_HEIGHT);
        r18.cubicTo(327.7f, 475.3f, 228.5f, 201.0f, 146.0f, 0.0f);
        r18.close();
    L5:
        if (r0 >= 7) goto L7;
        this.tempPaint.setColor(patternLightness[r0] << 24);
        r13.drawPath(patternPaths[r0], this.tempPaint);
        r0 = r0 + 1;
        goto L5
    L7:
        r13.restore();
        this.tempPaint.reset();
    }

    public void scaleCanvasToBounds(Canvas r5, Bitmap r6, Rect r7) {
        int r4 = r6.getWidth();
        int r8 = r6.getHeight();
        float r9 = r4;
        float r0 = r7.width() / r9;
        float r10 = r8;
        float r11 = r7.height() / r10;
        r5.scale(r0, r11);
        if (r11 <= r0) goto L6;
        r5.scale(r11 / r0, 1.0f, r9 * SCALE_FOCUS_X, 0.0f);
        return;
    L6:
        if (r0 <= r11) goto L10;
        r5.scale(1.0f, r0 / r11, 0.0f, r10 * SCALE_FOCUS_Y);
        return;
    }

    public void setColor(int r4) {
        this.color = Color.argb(204, Color.red(r4), Color.green(r4), Color.blue(r4));
        invalidateSelf();
    }

    public int getColor() {
        return Color.argb(255, Color.red(this.color), Color.green(this.color), Color.blue(this.color));
    }
}
