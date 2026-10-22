package com.obric.oui.texteffects.render;

import android.graphics.BlendMode;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.Xfermode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: CanvasTextLayerRenderer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\bJ\u0092\u0001\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00142\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\"0!2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&J|\u0010'\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010*\u001a\u00020+2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/obric/oui/texteffects/render/CanvasTextLayerRenderer;", "", "()V", "dstInXfermode", "Landroid/graphics/PorterDuffXfermode;", "leftToRightMaskShader", "Landroid/graphics/LinearGradient;", "reusableLayerPaint", "Landroid/graphics/Paint;", "reusableMaskMatrix", "Landroid/graphics/Matrix;", "reusableMaskPaint", "rightToLeftMaskShader", "buildLayerPaintForCurrentBlend", "sourcePaint", "drawClippedWholeText", "", "canvas", "Landroid/graphics/Canvas;", "layerLeft", "", "layerRight", "layerPaint", "paint", "cache", "Lcom/obric/oui/texteffects/render/TextLayoutCache;", "drawX", "baselineY", "clipLeft", "clipRight", "layerHeight", "blurPx", "blurMaskFilterProvider", "Lkotlin/Function1;", "Landroid/graphics/BlurMaskFilter;", "originalBlendMode", "Landroid/graphics/BlendMode;", "originalXfermode", "Landroid/graphics/Xfermode;", "drawScanGradientAlphaText", "startX", "endX", "leftToRight", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CanvasTextLayerRenderer {
    public static final CanvasTextLayerRenderer INSTANCE = null;
    private static final PorterDuffXfermode dstInXfermode = null;
    private static final LinearGradient leftToRightMaskShader = null;
    private static final Paint reusableLayerPaint = null;
    private static final Matrix reusableMaskMatrix = null;
    private static final Paint reusableMaskPaint = null;
    private static final LinearGradient rightToLeftMaskShader = null;

    private CanvasTextLayerRenderer() {
    }

    static {
        INSTANCE = new CanvasTextLayerRenderer();
        PorterDuffXfermode r0 = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        dstInXfermode = r0;
        reusableLayerPaint = new Paint();
        Paint r1 = new Paint();
        r1.setXfermode(r0);
        reusableMaskPaint = r1;
        reusableMaskMatrix = new Matrix();
        leftToRightMaskShader = new LinearGradient(0.0f, 0.0f, 1.0f, 0.0f, -1, 16777215, Shader.TileMode.CLAMP);
        rightToLeftMaskShader = new LinearGradient(0.0f, 0.0f, 1.0f, 0.0f, 16777215, -1, Shader.TileMode.CLAMP);
    }

    public final Paint buildLayerPaintForCurrentBlend(Paint r3) {
        Intrinsics.checkNotNullParameter(r3, "sourcePaint");
        Paint r2 = reusableLayerPaint;
        r2.reset();
        boolean r1 = true;
        if (r3.getBlendMode() == null) goto L6;
        r2.setBlendMode(r3.getBlendMode());
    L9:
        if (r1 == true) goto L13;
        return null;
    L13:
        return r2;
    L6:
        if (r3.getXfermode() == null) goto L8;
        r2.setXfermode(r3.getXfermode());
        goto L9
    L8:
        r1 = false;
        goto L9
    }

    public final void drawClippedWholeText(Canvas r16, float r17, float r18, Paint r19, Paint r20, TextLayoutCache r21, float r22, float r23, float r24, float r25, float r26, float r27, Function1<? super Float, ? extends BlurMaskFilter> r28, BlendMode r29, Xfermode r30) {
        Intrinsics.checkNotNullParameter(r16, "canvas");
        Intrinsics.checkNotNullParameter(r20, "paint");
        Intrinsics.checkNotNullParameter(r21, "cache");
        Intrinsics.checkNotNullParameter(r28, "blurMaskFilterProvider");
        if (r25 > r24) goto L5;
        return;
    L5:
        int r14 = r16.saveLayer(r17, 0.0f, r18, r26, r19);
        r20.setBlendMode(null);     // Catch: Throwable -> L9
        r20.setXfermode(null);     // Catch: Throwable -> L9
        r20.setMaskFilter(r28.invoke(Float.valueOf(r27)));     // Catch: Throwable -> L9
        r16.clipRect(r24, 0.0f, r25, r26);     // Catch: Throwable -> L9
        r16.drawText(r21.getChars(), 0, r21.getChars().length, r22, r23, r20);     // Catch: Throwable -> L9
        r16.restoreToCount(r14);
        r20.setBlendMode(r29);
        r20.setXfermode(r30);
        return;
    L9:
        th = move-exception;
        r16.restoreToCount(r14);
        r20.setBlendMode(r29);
        r20.setXfermode(r30);
        throw th;
    }

    public final void drawScanGradientAlphaText(Canvas r15, float r16, float r17, Paint r18, Paint r19, TextLayoutCache r20, float r21, float r22, float r23, float r24, float r25, boolean r26, BlendMode r27, Xfermode r28) {
        Intrinsics.checkNotNullParameter(r15, "canvas");
        Intrinsics.checkNotNullParameter(r19, "paint");
        Intrinsics.checkNotNullParameter(r20, "cache");
        int r12 = r15.saveLayer(r16, 0.0f, r17, r25, r18);
        r19.setBlendMode(null);     // Catch: Throwable -> L10
        r19.setXfermode(null);     // Catch: Throwable -> L10
        r19.setMaskFilter(null);     // Catch: Throwable -> L10
        r15.drawText(r20.getChars(), 0, r20.getChars().length, r21, r22, r19);     // Catch: Throwable -> L10
        if (r26 == false) goto L6;
        LinearGradient r1 = leftToRightMaskShader;     // Catch: Throwable -> L10
    L7:
        Matrix r2 = reusableMaskMatrix;     // Catch: Throwable -> L10
        r2.reset();     // Catch: Throwable -> L10
        r2.setScale(RangesKt.coerceAtLeast(r24 - r23, 0.001f), 1.0f);     // Catch: Throwable -> L10
        r2.postTranslate(r23, 0.0f);     // Catch: Throwable -> L10
        r1.setLocalMatrix(r2);     // Catch: Throwable -> L10
        Paint r0 = reusableMaskPaint;     // Catch: Throwable -> L10
        r0.setShader(r1);     // Catch: Throwable -> L10
        r15.drawRect(r16, 0.0f, r17, r25, r0);     // Catch: Throwable -> L10
        r0.setShader(null);
        r15.restoreToCount(r12);
        r19.setBlendMode(r27);
        r19.setXfermode(r28);
        return;
    L6:
        r1 = rightToLeftMaskShader;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        reusableMaskPaint.setShader(null);
        r15.restoreToCount(r12);
        r19.setBlendMode(r27);
        r19.setXfermode(r28);
        throw th;
    }
}
