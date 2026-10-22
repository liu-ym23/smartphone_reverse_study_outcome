package com.android.launcher3.icons;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import androidx.core.internal.view.SupportMenu;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class IconNormalizer {
    private static final float BOUND_RATIO_MARGIN = 0.05f;
    private static final float CIRCLE_AREA_BY_RECT = 0.7853982f;
    private static final boolean DEBUG = false;
    public static final float ICON_VISIBLE_AREA_FACTOR = 0.92f;
    private static final float LINEAR_SCALE_SLOPE = 0.040449437f;
    private static final float MAX_CIRCLE_AREA_FACTOR = 0.6597222f;
    private static final float MAX_SQUARE_AREA_FACTOR = 0.6510417f;
    private static final int MIN_VISIBLE_ALPHA = 40;
    private static final float PIXEL_DIFF_PERCENTAGE_THRESHOLD = 0.005f;
    private static final float SCALE_NOT_INITIALIZED = 0.0f;
    private static final String TAG = "IconNormalizer";
    private final RectF mAdaptiveIconBounds;
    private float mAdaptiveIconScale;
    private final Bitmap mBitmap;
    private final Rect mBounds;
    private final Canvas mCanvas;
    private boolean mEnableShapeDetection;
    private final float[] mLeftBorder;
    private final Matrix mMatrix;
    private final int mMaxSize;
    private final Paint mPaintMaskShape;
    private final Paint mPaintMaskShapeOutline;
    private final byte[] mPixels;
    private final float[] mRightBorder;
    private final Path mShapePath;

    IconNormalizer(Context r3, int r4, boolean r5) {
        int r6 = r4 * 2;
        this.mMaxSize = r6;
        Bitmap r0 = Bitmap.createBitmap(r6, r6, Bitmap.Config.ALPHA_8);
        this.mBitmap = r0;
        this.mCanvas = new Canvas(r0);
        this.mPixels = new byte[r6 * r6];
        this.mLeftBorder = new float[r6];
        this.mRightBorder = new float[r6];
        this.mBounds = new Rect();
        this.mAdaptiveIconBounds = new RectF();
        Paint r7 = new Paint();
        this.mPaintMaskShape = r7;
        r7.setColor(SupportMenu.CATEGORY_MASK);
        r7.setStyle(Paint.Style.FILL);
        r7.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));
        Paint r8 = new Paint();
        this.mPaintMaskShapeOutline = r8;
        r8.setStrokeWidth(r3.getResources().getDisplayMetrics().density * 2.0f);
        r8.setStyle(Paint.Style.STROKE);
        r8.setColor(-16777216);
        r8.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.mShapePath = new Path();
        this.mMatrix = new Matrix();
        this.mAdaptiveIconScale = 0.0f;
        this.mEnableShapeDetection = r5;
    }

    private static float getScale(float r2, float r3, float r4) {
        float r5 = r2 / r3;
        if (r5 >= CIRCLE_AREA_BY_RECT) goto L5;
        float r6 = MAX_CIRCLE_AREA_FACTOR;
    L6:
        float r7 = r2 / r4;
        if (r7 > r6) goto L9;
        return 1.0f;
    L9:
        return (float) Math.sqrt(r6 / r7);
    L5:
        r6 = ((1.0f - r5) * LINEAR_SCALE_SLOPE) + MAX_SQUARE_AREA_FACTOR;
        goto L6
    }

    public static float normalizeAdaptiveIcon(Drawable r8, int r9, RectF r10) {
        Rect r0 = new Rect(r8.getBounds());
        r8.setBounds(0, 0, r9, r9);
        Path r2 = ((AdaptiveIconDrawable) r8).getIconMask();
        Region r3 = new Region();
        r3.setPath(r2, new Region(0, 0, r9, r9));
        Rect r1 = r3.getBounds();
        int r4 = GraphicsUtils.getArea(r3);
        if (r10 == null) goto L5;
        float r5 = r9;
        r10.set(r1.left / r5, r1.top / r5, 1.0f - (r1.right / r5), 1.0f - (r1.bottom / r5));
    L5:
        r8.setBounds(r0);
        float r11 = r4;
        return getScale(r11, r11, r9 * r9);
    }

    private boolean isShape(Path r4) {
        if (Math.abs((this.mBounds.width() / this.mBounds.height()) - 1.0f) <= BOUND_RATIO_MARGIN) goto L6;
        return false;
    L6:
        this.mMatrix.reset();
        this.mMatrix.setScale(this.mBounds.width(), this.mBounds.height());
        this.mMatrix.postTranslate(this.mBounds.left, this.mBounds.top);
        r4.transform(this.mMatrix, this.mShapePath);
        this.mCanvas.drawPath(this.mShapePath, this.mPaintMaskShape);
        this.mCanvas.drawPath(this.mShapePath, this.mPaintMaskShapeOutline);
        return isTransparentBitmap();
    }

    private boolean isTransparentBitmap() {
        ByteBuffer r0 = ByteBuffer.wrap(this.mPixels);
        r0.rewind();
        this.mBitmap.copyPixelsToBuffer(r0);
        int r1 = this.mBounds.top;
        int r2 = this.mMaxSize;
        int r3 = r1 * r2;
        int r4 = r2 - this.mBounds.right;
        int r5 = 0;
    L4:
        if (r1 >= this.mBounds.bottom) goto L14;
        int r6 = r3 + this.mBounds.left;
        int r7 = this.mBounds.left;
    L7:
        if (r7 >= this.mBounds.right) goto L12;
        if ((this.mPixels[r6] & 255) <= 40) goto L11;
        r5 = r5 + 1;
    L11:
        r6 = r6 + 1;
        r7 = r7 + 1;
        goto L7
    L12:
        r3 = r6 + r4;
        r1 = r1 + 1;
        goto L4
    L14:
        if ((r5 / (this.mBounds.width() * this.mBounds.height())) >= PIXEL_DIFF_PERCENTAGE_THRESHOLD) goto L21;
        return true;
    L21:
        return false;
    }

    public synchronized float getScale(Drawable r17, RectF r18, Path r19, boolean[] r20) {
        monitor-enter(this);
    L73:
        th = move-exception;
        throw th;
    L5:
        if ((r17 instanceof AdaptiveIconDrawable) == true) goto L7;
        int r4 = r17.getIntrinsicWidth();     // Catch: Throwable -> L73
        int r6 = r17.getIntrinsicHeight();     // Catch: Throwable -> L73
        if (r4 <= 0) goto L22;
        if (r6 <= 0) goto L22;
        int r7 = this.mMaxSize;     // Catch: Throwable -> L73
        if (r4 > r7) goto L21;
        if (r6 > r7) goto L21;
    L30:
        int r8 = 0;
        this.mBitmap.eraseColor(0);     // Catch: Throwable -> L73
        r17.setBounds(0, 0, r4, r6);     // Catch: Throwable -> L73
        r17.draw(this.mCanvas);     // Catch: Throwable -> L73
        ByteBuffer r0 = ByteBuffer.wrap(this.mPixels);     // Catch: Throwable -> L73
        r0.rewind();     // Catch: Throwable -> L73
        this.mBitmap.copyPixelsToBuffer(r0);     // Catch: Throwable -> L73
        int r1 = this.mMaxSize;     // Catch: Throwable -> L73
        int r9 = r1 + 1;     // Catch: Throwable -> L73
        int r2 = r1 - r4;     // Catch: Throwable -> L73
        int r10 = 0;
        int r14 = 0;
        int r11 = -1;
        int r12 = -1;
        int r13 = -1;
    L31:
        if (r10 >= r6) goto L48;
        int r15 = r8;
        int r5 = -1;
        int r16 = -1;
    L33:
        if (r15 >= r4) goto L41;
        if ((this.mPixels[r14] & 255) <= 40) goto L40;
        if (r5 != (-1)) goto L39;
        r5 = r15;
    L39:
        r16 = r15;
    L40:
        r14 = r14 + 1;     // Catch: Throwable -> L73
        r15 = r15 + 1;     // Catch: Throwable -> L73
        goto L33
    L41:
        r14 = r14 + r2;     // Catch: Throwable -> L73
        this.mLeftBorder[r10] = r5;     // Catch: Throwable -> L73
        this.mRightBorder[r10] = r16;     // Catch: Throwable -> L73
        if (r5 == (-1)) goto L46;
        if (r11 != (-1)) goto L45;
        r11 = r10;
    L45:
        int r3 = Math.min(r9, r5);     // Catch: Throwable -> L73
        r12 = Math.max(r12, r16);     // Catch: Throwable -> L73
        r9 = r3;
        r13 = r10;
    L46:
        r10 = r10 + 1;     // Catch: Throwable -> L73
        r8 = 0;
        goto L31
    L48:
        if (r11 == (-1)) goto L71;
        if (r12 == (-1)) goto L71;
        convertToConvexArray(this.mLeftBorder, 1, r11, r13);     // Catch: Throwable -> L73
        convertToConvexArray(this.mRightBorder, -1, r11, r13);     // Catch: Throwable -> L73
        int r21 = 0;
        float r22 = 0.0f;
    L52:
        if (r21 >= r6) goto L58;
        float r23 = this.mLeftBorder[r21];     // Catch: Throwable -> L73
        if (r23 <= (-1.0f)) goto L57;
        r22 = r22 + ((this.mRightBorder[r21] - r23) + 1.0f);     // Catch: Throwable -> L73
    L57:
        r21 = r21 + 1;     // Catch: Throwable -> L73
        goto L52
    L58:
        this.mBounds.left = r9;     // Catch: Throwable -> L73
        this.mBounds.right = r12;     // Catch: Throwable -> L73
        this.mBounds.top = r11;     // Catch: Throwable -> L73
        this.mBounds.bottom = r13;     // Catch: Throwable -> L73
        if (r18 == null) goto L62;
        float r24 = r4;
        float r110 = r6;
        r18.set(this.mBounds.left / r24, this.mBounds.top / r110, 1.0f - (this.mBounds.right / r24), 1.0f - (this.mBounds.bottom / r110));     // Catch: Throwable -> L73
    L62:
        if (r20 != null) goto L64;
    L68:
        float r25 = getScale(r22, ((r13 + 1) - r11) * ((r12 + 1) - r9), r4 * r6);     // Catch: Throwable -> L73
        monitor-exit(this);
        return r25;
    L64:
        if (this.mEnableShapeDetection == false) goto L68;
        if (r20.length <= 0) goto L68;
        r20[0] = isShape(r19);     // Catch: Throwable -> L73
    L71:
        monitor-exit(this);
        return 1.0f;
    L21:
        int r26 = Math.max(r4, r6);     // Catch: Throwable -> L73
        int r27 = this.mMaxSize;     // Catch: Throwable -> L73
        r4 = (r4 * r27) / r26;     // Catch: Throwable -> L73
        r6 = (r27 * r6) / r26;     // Catch: Throwable -> L73
    L22:
        if (r4 > 0) goto L24;
    L25:
        r4 = this.mMaxSize;     // Catch: Throwable -> L73
    L26:
        if (r6 > 0) goto L28;
    L29:
        r6 = this.mMaxSize;     // Catch: Throwable -> L73
        goto L30
    L28:
        if (r6 <= this.mMaxSize) goto L30;
    L24:
        if (r4 <= this.mMaxSize) goto L26;
    L7:
        if (this.mAdaptiveIconScale != 0.0f) goto L9;
        this.mAdaptiveIconScale = normalizeAdaptiveIcon(r17, this.mMaxSize, this.mAdaptiveIconBounds);     // Catch: Throwable -> L73
    L9:
        if (r18 == null) goto L11;
        r18.set(this.mAdaptiveIconBounds);     // Catch: Throwable -> L73
    L11:
        float r28 = this.mAdaptiveIconScale;     // Catch: Throwable -> L73
        monitor-exit(this);
        return r28;
    }

    private static void convertToConvexArray(float[] r8, int r9, int r10, int r11) {
        float[] r0 = new float[r8.length - 1];
        int r1 = r10 + 1;
        int r2 = -1;
        float r4 = Float.MAX_VALUE;
    L3:
        if (r1 > r11) goto L20;
        float r5 = r8[r1];
        if (r5 <= (-1.0f)) goto L19;
        if (r4 != Float.MAX_VALUE) goto L10;
        r2 = r10;
    L15:
        r4 = (r8[r1] - r8[r2]) / (r1 - r2);
        int r6 = r2;
    L16:
        if (r6 >= r1) goto L18;
        r0[r6] = r4;
        r8[r6] = r8[r2] + ((r6 - r2) * r4);
        r6 = r6 + 1;
        goto L16
    L18:
        r2 = r1;
        goto L19
    L10:
        float r7 = ((r5 - r8[r2]) / (r1 - r2)) - r4;
        float r12 = r9;
        if ((r7 * r12) >= 0.0f) goto L15;
    L12:
        if (r2 <= r10) goto L15;
        r2 = r2 - 1;
        if (((((r8[r1] - r8[r2]) / (r1 - r2)) - r0[r2]) * r12) < 0.0f) goto L12;
    L19:
        r1 = r1 + 1;
        goto L3
    }

    public static int getNormalizedCircleSize(int r4) {
        return (int) Math.round(Math.sqrt(((double) (((r4 * r4) * MAX_CIRCLE_AREA_FACTOR) * 4.0f)) / 3.141592653589793d));
    }
}
