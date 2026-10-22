package com.obric.common.oea.foundation.graphics.smoothcorner.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;

/* JADX INFO: loaded from: classes4.dex */
public class SmoothRoundRectUtils {
    private static final float BEZIER_A = 0.58578646f;
    private static final float BEZIER_AD = 0.95000005f;
    private static final float BEZIER_D = 0.36421356f;
    private static final float BEZIER_OFFSET = 0.29289323f;
    private static final float CORNER = 150.0f;
    private static final int CORNER_SIZE = 250;
    private static final int IMAGE_SIZE = 1024;
    private static final float SMOOTHNESS = 0.6f;
    private static final float SMOOTHNESS_STEP = 0.04f;
    private static Paint mCapsulePaint;
    private static Paint mRoundRectPaint;

    public SmoothRoundRectUtils() {
    }

    public static Bitmap makeCapsuleStencil() {
        Bitmap r0 = Bitmap.createBitmap(1024, 1024, Bitmap.Config.ARGB_8888);
        Canvas r9 = new Canvas(r0);
        Paint r10 = new Paint();
        r10.setAntiAlias(true);
        r10.setColor(-16777216);
        int r12 = Math.round(4.0f);
        int r1 = 0;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L8;
        int r15 = r1;
        int r8 = 0;
    L5:
        if (r8 >= r12) goto L7;
        drawRightTopRect(r9, r8 * 250, r14 * 250, 5.0f, CORNER, (r15 * CORNER) * SMOOTHNESS_STEP, 90.0f, r10);
        r15 = r15 + 1;
        r8 = r8 + 1;
        goto L5
    L7:
        r14 = r14 + 1;
        r1 = r15;
        goto L3
    L8:
        return r0;
    }

    public static Bitmap makeRoundRectStencil() {
        Bitmap r0 = Bitmap.createBitmap(250, 250, Bitmap.Config.ARGB_8888);
        Canvas r1 = new Canvas(r0);
        Paint r8 = new Paint();
        r8.setAntiAlias(true);
        r8.setColor(-16777216);
        drawRightTopRect(r1, 0.0f, 0.0f, 5.0f, CORNER, 90.0f, 90.0f, r8);
        return r0;
    }

    public static void drawCapsuleCorner(Canvas r17, Rect r18, float r19, Paint r20) {
        if (mCapsulePaint != null) goto L6;
        if (r20 != null) goto L6;
        mCapsulePaint = new Paint();
        mCapsulePaint.setShader(new BitmapShader(makeCapsuleStencil(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        mCapsulePaint.setBlendMode(BlendMode.DST_IN);
    L6:
        if (r20 != null) goto L8;
        Paint r2 = mCapsulePaint;
    L9:
        float r3 = r18.left;
        float r4 = r18.top;
        float r5 = r18.right;
        float r6 = r18.bottom;
        float r7 = r18.width() / 2.0f;
        float r1 = Math.min(r19, Math.min(r7, r18.height() / 2.0f));
        float r8 = calculateExtension(r1, r7, 0.6f);
        int r10 = Math.round(r8 / (r1 * SMOOTHNESS_STEP));
        float r11 = ((r10 * SMOOTHNESS_STEP) + 1.0f) * CORNER;
        int r12 = Math.round(4.0f);
        float r13 = ((r10 % r12) * 250) + 5.0f;
        float r14 = (r10 / r12) * 250;
        float r9 = (r8 + r1) / r11;
        float r15 = (r1 + (0.6f * r1)) / 240.0f;
        float r16 = r11 * r9;
        float r110 = r15 * 240.0f;
        RectF r111 = new RectF(0.0f, 0.0f, r16, r110);
        Matrix r21 = new Matrix();
        r21.reset();
        float r22 = -r13;
        float r23 = -r14;
        r21.setTranslate(r22, r23);
        r21.postScale(r9, r15);
        r2.getShader().setLocalMatrix(r21);
        r17.save();
        float r24 = r5 - r16;
        r17.translate(r24, r4);
        r17.drawRect(r111, r2);
        r17.restore();
        r21.reset();
        r21.setScale(-1.0f, 1.0f);
        float r112 = r13 + r11;
        r21.postTranslate(r112, r23);
        r21.postScale(r9, r15);
        r2.getShader().setLocalMatrix(r21);
        r17.save();
        r17.translate(r3, r4);
        r17.drawRect(r111, r2);
        r17.restore();
        r21.reset();
        r21.setScale(1.0f, -1.0f);
        float r113 = r14 + 240.0f;
        r21.postTranslate(r22, r113);
        r21.postScale(r9, r15);
        r2.getShader().setLocalMatrix(r21);
        r17.save();
        float r25 = r6 - r110;
        r17.translate(r24, r25);
        r17.drawRect(r111, r2);
        r17.restore();
        r21.reset();
        r21.setScale(-1.0f, -1.0f);
        r21.postTranslate(r112, r113);
        r21.postScale(r9, r15);
        r2.getShader().setLocalMatrix(r21);
        r17.save();
        r17.translate(r3, r25);
        r17.drawRect(r111, r2);
        r17.restore();
        return;
    L8:
        r2 = r20;
        goto L9
    }

    public static void drawRoundRectCorner(Canvas r12, Rect r13, float r14, Paint r15) {
        if (mRoundRectPaint != null) goto L6;
        if (r15 != null) goto L6;
        mRoundRectPaint = new Paint();
        mRoundRectPaint.setShader(new BitmapShader(makeRoundRectStencil(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        mRoundRectPaint.setBlendMode(BlendMode.DST_IN);
    L6:
        if (r15 != null) goto L8;
        r15 = mRoundRectPaint;
    L8:
        float r0 = r13.left;
        float r1 = r13.top;
        float r2 = r13.right;
        float r3 = r13.bottom;
        float r16 = Math.min(r14, Math.min((r13.width() / 2.0f) / 1.6f, (r13.height() / 2.0f) / 1.6f));
        float r17 = (r16 + (0.6f * r16)) / 240.0f;
        float r5 = r17 * 240.0f;
        RectF r4 = new RectF(0.0f, 0.0f, r5, r5);
        Matrix r6 = new Matrix();
        r6.reset();
        r6.setTranslate(-5.0f, -0.0f);
        r6.postScale(r17, r17);
        r15.getShader().setLocalMatrix(r6);
        r12.save();
        float r7 = r2 - r5;
        r12.translate(r7, r1);
        r12.drawRect(r4, r15);
        r12.restore();
        r6.reset();
        r6.setScale(-1.0f, 1.0f);
        r6.postTranslate(245.0f, -0.0f);
        r6.postScale(r17, r17);
        r15.getShader().setLocalMatrix(r6);
        r12.save();
        r12.translate(r0, r1);
        r12.drawRect(r4, r15);
        r12.restore();
        r6.reset();
        r6.setScale(1.0f, -1.0f);
        r6.postTranslate(-5.0f, 240.0f);
        r6.postScale(r17, r17);
        r15.getShader().setLocalMatrix(r6);
        r12.save();
        float r8 = r3 - r5;
        r12.translate(r7, r8);
        r12.drawRect(r4, r15);
        r12.restore();
        r6.reset();
        r6.setScale(-1.0f, -1.0f);
        r6.postTranslate(245.0f, 240.0f);
        r6.postScale(r17, r17);
        r15.getShader().setLocalMatrix(r6);
        r12.save();
        r12.translate(r0, r8);
        r12.drawRect(r4, r15);
        r12.restore();
    }

    public static void drawSmoothRoundRect(Canvas r8, RectF r9, float r10, Paint r11, float r12) {
        drawSmoothRoundRect(r8, r9.left, r9.top, r9.right, r9.bottom, r10, r11, r12);
    }

    public static void drawRightTopRect(Canvas r8, float r9, float r10, float r11, float r12, float r13, float r14, Paint r15) {
        r8.save();
        r8.translate(r9, r10);
        float r16 = (r12 + r13) + r11;
        float r17 = r14 + r12;
        float r18 = r11 + r17;
        Path r19 = new Path();
        r19.reset();
        r19.moveTo(r16, r18);
        r19.lineTo(r16, r17);
        float r110 = BEZIER_AD * r12;
        float r7 = r12 * BEZIER_A;
        float r6 = r12 * BEZIER_OFFSET;
        r19.cubicTo(r16, r110, r16, r7, r16 - r6, r6);
        r19.cubicTo(r16 - r7, 0.0f, r16 - r110, 0.0f, (r16 - r12) - r13, 0.0f);
        r19.lineTo(0.0f, 0.0f);
        r19.lineTo(0.0f, r18);
        r19.close();
        r8.drawPath(r19, r15);
        r8.restore();
    }

    public static void drawSmoothRoundRect(Canvas r1, RectF r2, float r3, Paint r4) {
        drawSmoothRoundRect(r1, r2, r3, r4, 0.6f);
    }

    public static void drawSmoothRoundRect(Canvas r8, float r9, float r10, float r11, float r12, float r13, Paint r14, float r15) {
        float r1 = r11 - r9;
        float r2 = r12 - r10;
        if (r1 > 0.0f) goto L5;
        return;
    L5:
        if (r2 <= 0.0f) goto L10;
        Path r16 = new Path();
        r8.save();
        r8.translate(r9, r10);
        drawSmoothRoundRectPath(r16, r1, r2, r13, r13, r13, r13, r15);
        r8.drawPath(r16, r14);
        r8.restore();
        return;
    }

    public static void drawSmoothRoundRect(Canvas r8, float r9, float r10, float r11, float r12, float r13, Paint r14) {
        drawSmoothRoundRect(r8, r9, r10, r11, r12, r13, r14, 0.6f);
    }

    public static void drawSmoothRoundRect(Canvas r11, RectF r12, float r13, float r14, float r15, float r16, Paint r17, float r18) {
        drawSmoothRoundRect(r11, r12.left, r12.top, r12.right, r12.bottom, r13, r14, r15, r16, r17, r18);
    }

    public static void drawSmoothRoundRect(Canvas r8, RectF r9, float r10, float r11, float r12, float r13, Paint r14) {
        drawSmoothRoundRect(r8, r9, r10, r11, r12, r13, r14, 0.6f);
    }

    public static void drawSmoothRoundRect(Canvas r9, float r10, float r11, float r12, float r13, float r14, float r15, float r16, float r17, Paint r18, float r19) {
        float r1 = r12 - r10;
        float r2 = r13 - r11;
        if (r1 > 0.0f) goto L5;
        return;
    L5:
        if (r2 <= 0.0f) goto L10;
        Path r8 = new Path();
        r9.save();
        r9.translate(r10, r11);
        drawSmoothRoundRectPath(r8, r1, r2, r14, r15, r16, r17, r19);
        r9.drawPath(r8, r18);
        r9.restore();
        return;
    }

    public static void drawSmoothRoundRect(Canvas r11, float r12, float r13, float r14, float r15, float r16, float r17, float r18, float r19, Paint r20) {
        drawSmoothRoundRect(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, 0.6f);
    }

    public static void drawSmoothRoundRectPath(Path r8, float r9, float r10, float r11) {
        drawSmoothRoundRectPath(r8, r9, r10, r11, r11, r11, r11, 0.6f);
    }

    public static void drawSmoothRoundRectPath(Path r28, float r29, float r30, float r31, float r32, float r33, float r34, float r35) {
        float r2 = r29 / 2.0f;
        float r1 = r30 / 2.0f;
        float r11 = clamp(r31, 0.0f, Math.min(r2, r1));
        float r12 = clamp(r32, 0.0f, Math.min(r2, r1));
        float r13 = clamp(r33, 0.0f, Math.min(r2, r1));
        float r14 = clamp(r34, 0.0f, Math.min(r2, r1));
        if (r11 <= 0.0f) goto L5;
    L12:
        float r15 = calculateExtension(r11, r2, r35);
        float r16 = calculateExtension(r11, r1, r35);
        float r17 = calculateExtension(r12, r2, r35);
        float r3 = calculateExtension(r12, r1, r35);
        float r18 = calculateExtension(r13, r2, r35);
        float r4 = calculateExtension(r13, r1, r35);
        float r19 = calculateExtension(r14, r2, r35);
        float r20 = calculateExtension(r14, r1, r35);
        r28.reset();
        float r6 = (r30 - r13) - r4;
        r28.moveTo(r29, r6);
        r28.lineTo(r29, r3 + r12);
        if (r12 <= 0.0f) goto L15;
        float r24 = r12 * BEZIER_AD;
        float r25 = r12 * BEZIER_A;
        float r26 = r12 * BEZIER_OFFSET;
        r28.cubicTo(r29, r24, r29, r25, r29 - r26, r26);
        r28.cubicTo(r29 - r25, 0.0f, r29 - r24, 0.0f, (r29 - r12) - r17, 0.0f);
    L16:
        r28.lineTo(r15 + r11, 0.0f);
        if (r11 <= 0.0f) goto L19;
        float r110 = r11 * BEZIER_AD;
        float r111 = r11 * BEZIER_A;
        float r7 = r11 * BEZIER_OFFSET;
        r28.cubicTo(r110, 0.0f, r111, 0.0f, r7, r7);
        r28.cubicTo(0.0f, r111, 0.0f, r110, 0.0f, r11 + r16);
    L20:
        r28.lineTo(0.0f, (r30 - r14) - r20);
        if (r14 <= 0.0f) goto L23;
        float r112 = r14 * BEZIER_AD;
        float r113 = r14 * BEZIER_A;
        float r5 = r14 * BEZIER_OFFSET;
        r28.cubicTo(0.0f, r30 - r112, 0.0f, r30 - r113, r5, r30 - r5);
        r28.cubicTo(r113, r30, r112, r30, r14 + r19, r30);
    L24:
        r28.lineTo((r29 - r13) - r18, r30);
        if (r13 <= 0.0f) goto L27;
        float r23 = BEZIER_AD * r13;
        float r22 = BEZIER_A * r13;
        float r114 = r13 * BEZIER_OFFSET;
        r28.cubicTo(r29 - r23, r30, r29 - r22, r30, r29 - r114, r30 - r114);
        r28.cubicTo(r29, r30 - r22, r29, r30 - r23, r29, r6);
    L28:
        r28.close();
        return;
    L27:
        r28.lineTo(r29, r30);
        goto L28
    L23:
        r28.lineTo(0.0f, r30);
        goto L24
    L19:
        r28.lineTo(0.0f, 0.0f);
        goto L20
    L15:
        r28.lineTo(r29, 0.0f);
        goto L16
    L5:
        if (r12 > 0.0f) goto L12;
        if (r13 > 0.0f) goto L12;
        if (r14 > 0.0f) goto L12;
        r28.reset();
        r28.addRect(0.0f, 0.0f, r29, r30, Path.Direction.CW);
    }

    private static float clamp(float r0, float r1, float r2) {
        return Math.max(r1, Math.min(r0, r2));
    }

    private static float calculateExtension(float r0, float r1, float r2) {
        return Math.min(r2 * r0, r1 - r0);
    }
}
