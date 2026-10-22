package com.github.mikephil.charting.utils;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Transformer {
    private Matrix mMBuffer1;
    private Matrix mMBuffer2;
    protected Matrix mMatrixOffset;
    protected Matrix mMatrixValueToPx;
    protected Matrix mPixelToValueMatrixBuffer;
    protected ViewPortHandler mViewPortHandler;
    float[] ptsBuffer;
    protected float[] valuePointsForGenerateTransformedValuesBubble;
    protected float[] valuePointsForGenerateTransformedValuesCandle;
    protected float[] valuePointsForGenerateTransformedValuesLine;
    protected float[] valuePointsForGenerateTransformedValuesScatter;

    public Transformer(ViewPortHandler r3) {
        this.mMatrixValueToPx = new Matrix();
        this.mMatrixOffset = new Matrix();
        this.valuePointsForGenerateTransformedValuesScatter = new float[1];
        this.valuePointsForGenerateTransformedValuesBubble = new float[1];
        this.valuePointsForGenerateTransformedValuesLine = new float[1];
        this.valuePointsForGenerateTransformedValuesCandle = new float[1];
        this.mPixelToValueMatrixBuffer = new Matrix();
        this.ptsBuffer = new float[2];
        this.mMBuffer1 = new Matrix();
        this.mMBuffer2 = new Matrix();
        this.mViewPortHandler = r3;
    }

    public void prepareMatrixValuePx(float r3, float r4, float r5, float r6) {
        float r0 = this.mViewPortHandler.contentWidth() / r4;
        float r7 = this.mViewPortHandler.contentHeight() / r5;
        if (Float.isInfinite(r0) == false) goto L6;
        r0 = 0.0f;
    L6:
        if (Float.isInfinite(r7) == false) goto L8;
        r7 = 0.0f;
    L8:
        this.mMatrixValueToPx.reset();
        this.mMatrixValueToPx.postTranslate(-r3, -r6);
        this.mMatrixValueToPx.postScale(r0, -r7);
    }

    public void prepareMatrixOffset(boolean r3) {
        this.mMatrixOffset.reset();
        if (r3 == true) goto L5;
        this.mMatrixOffset.postTranslate(this.mViewPortHandler.offsetLeft(), this.mViewPortHandler.getChartHeight() - this.mViewPortHandler.offsetBottom());
        return;
    L5:
        this.mMatrixOffset.setTranslate(this.mViewPortHandler.offsetLeft(), -this.mViewPortHandler.offsetTop());
        this.mMatrixOffset.postScale(1.0f, -1.0f);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.github.mikephil.charting.data.Entry] */
    public float[] generateTransformedValuesScatter(IScatterDataSet r4, float r5, float r6, int r7, int r8) {
        int r9 = ((int) (((r8 - r7) * r5) + 1.0f)) * 2;
        if (this.valuePointsForGenerateTransformedValuesScatter.length == r9) goto L5;
        this.valuePointsForGenerateTransformedValuesScatter = new float[r9];
    L5:
        float[] r10 = this.valuePointsForGenerateTransformedValuesScatter;
        int r0 = 0;
    L6:
        if (r0 >= r9) goto L12;
        ?? r1 = r4.getEntryForIndex((r0 / 2) + r7);
        if (r1 == 0) goto L10;
        r10[r0] = r1.getX();
        r10[r0 + 1] = r1.getY() * r6;
    L11:
        r0 = r0 + 2;
        goto L6
    L10:
        r10[r0] = 0.0f;
        r10[r0 + 1] = 0.0f;
        goto L11
    L12:
        getValueToPixelMatrix().mapPoints(r10);
        return r10;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.github.mikephil.charting.data.Entry] */
    public float[] generateTransformedValuesBubble(IBubbleDataSet r5, float r6, int r7, int r8) {
        int r9 = ((r8 - r7) + 1) * 2;
        if (this.valuePointsForGenerateTransformedValuesBubble.length == r9) goto L5;
        this.valuePointsForGenerateTransformedValuesBubble = new float[r9];
    L5:
        float[] r0 = this.valuePointsForGenerateTransformedValuesBubble;
        int r1 = 0;
    L6:
        if (r1 >= r9) goto L12;
        ?? r2 = r5.getEntryForIndex((r1 / 2) + r7);
        if (r2 == 0) goto L10;
        r0[r1] = r2.getX();
        r0[r1 + 1] = r2.getY() * r6;
    L11:
        r1 = r1 + 2;
        goto L6
    L10:
        r0[r1] = 0.0f;
        r0[r1 + 1] = 0.0f;
        goto L11
    L12:
        getValueToPixelMatrix().mapPoints(r0);
        return r0;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.github.mikephil.charting.data.Entry] */
    public float[] generateTransformedValuesLine(ILineDataSet r4, float r5, float r6, int r7, int r8) {
        int r9 = (((int) ((r8 - r7) * r5)) + 1) * 2;
        if (this.valuePointsForGenerateTransformedValuesLine.length == r9) goto L5;
        this.valuePointsForGenerateTransformedValuesLine = new float[r9];
    L5:
        float[] r10 = this.valuePointsForGenerateTransformedValuesLine;
        int r0 = 0;
    L6:
        if (r0 >= r9) goto L12;
        ?? r1 = r4.getEntryForIndex((r0 / 2) + r7);
        if (r1 == 0) goto L10;
        r10[r0] = r1.getX();
        r10[r0 + 1] = r1.getY() * r6;
    L11:
        r0 = r0 + 2;
        goto L6
    L10:
        r10[r0] = 0.0f;
        r10[r0 + 1] = 0.0f;
        goto L11
    L12:
        getValueToPixelMatrix().mapPoints(r10);
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public float[] generateTransformedValuesCandle(ICandleDataSet r4, float r5, float r6, int r7, int r8) {
        int r9 = ((int) (((r8 - r7) * r5) + 1.0f)) * 2;
        if (this.valuePointsForGenerateTransformedValuesCandle.length == r9) goto L5;
        this.valuePointsForGenerateTransformedValuesCandle = new float[r9];
    L5:
        float[] r10 = this.valuePointsForGenerateTransformedValuesCandle;
        int r0 = 0;
    L6:
        if (r0 >= r9) goto L12;
        CandleEntry r1 = (CandleEntry) r4.getEntryForIndex((r0 / 2) + r7);
        if (r1 == null) goto L10;
        r10[r0] = r1.getX();
        r10[r0 + 1] = r1.getHigh() * r6;
    L11:
        r0 = r0 + 2;
        goto L6
    L10:
        r10[r0] = 0.0f;
        r10[r0 + 1] = 0.0f;
        goto L11
    L12:
        getValueToPixelMatrix().mapPoints(r10);
        return r10;
    }

    public void pathValueToPixel(Path r2) {
        r2.transform(this.mMatrixValueToPx);
        r2.transform(this.mViewPortHandler.getMatrixTouch());
        r2.transform(this.mMatrixOffset);
    }

    public void pathValuesToPixel(List<Path> r3) {
        int r0 = 0;
    L4:
        if (r0 >= r3.size()) goto L6;
        pathValueToPixel(r3.get(r0));
        r0 = r0 + 1;
        goto L4
    }

    public void pointValuesToPixel(float[] r2) {
        this.mMatrixValueToPx.mapPoints(r2);
        this.mViewPortHandler.getMatrixTouch().mapPoints(r2);
        this.mMatrixOffset.mapPoints(r2);
    }

    public void rectValueToPixel(RectF r2) {
        this.mMatrixValueToPx.mapRect(r2);
        this.mViewPortHandler.getMatrixTouch().mapRect(r2);
        this.mMatrixOffset.mapRect(r2);
    }

    public void rectToPixelPhase(RectF r2, float r3) {
        r2.top *= r3;
        r2.bottom *= r3;
        this.mMatrixValueToPx.mapRect(r2);
        this.mViewPortHandler.getMatrixTouch().mapRect(r2);
        this.mMatrixOffset.mapRect(r2);
    }

    public void rectToPixelPhaseHorizontal(RectF r2, float r3) {
        r2.left *= r3;
        r2.right *= r3;
        this.mMatrixValueToPx.mapRect(r2);
        this.mViewPortHandler.getMatrixTouch().mapRect(r2);
        this.mMatrixOffset.mapRect(r2);
    }

    public void rectValueToPixelHorizontal(RectF r2) {
        this.mMatrixValueToPx.mapRect(r2);
        this.mViewPortHandler.getMatrixTouch().mapRect(r2);
        this.mMatrixOffset.mapRect(r2);
    }

    public void rectValueToPixelHorizontal(RectF r2, float r3) {
        r2.left *= r3;
        r2.right *= r3;
        this.mMatrixValueToPx.mapRect(r2);
        this.mViewPortHandler.getMatrixTouch().mapRect(r2);
        this.mMatrixOffset.mapRect(r2);
    }

    public void rectValuesToPixel(List<RectF> r3) {
        Matrix r2 = getValueToPixelMatrix();
        int r0 = 0;
    L4:
        if (r0 >= r3.size()) goto L6;
        r2.mapRect(r3.get(r0));
        r0 = r0 + 1;
        goto L4
    }

    public void pixelsToValue(float[] r3) {
        Matrix r0 = this.mPixelToValueMatrixBuffer;
        r0.reset();
        this.mMatrixOffset.invert(r0);
        r0.mapPoints(r3);
        this.mViewPortHandler.getMatrixTouch().invert(r0);
        r0.mapPoints(r3);
        this.mMatrixValueToPx.invert(r0);
        r0.mapPoints(r3);
    }

    public MPPointD getValuesByTouchPoint(float r3, float r4) {
        MPPointD r0 = MPPointD.getInstance(0.0d, 0.0d);
        getValuesByTouchPoint(r3, r4, r0);
        return r0;
    }

    public void getValuesByTouchPoint(float r3, float r4, MPPointD r5) {
        float[] r0 = this.ptsBuffer;
        r0[0] = r3;
        r0[1] = r4;
        pixelsToValue(r0);
        r5.x = this.ptsBuffer[0];
        r5.y = this.ptsBuffer[1];
    }

    public MPPointD getPixelForValues(float r3, float r4) {
        float[] r0 = this.ptsBuffer;
        r0[0] = r3;
        r0[1] = r4;
        pointValuesToPixel(r0);
        float[] r2 = this.ptsBuffer;
        return MPPointD.getInstance(r2[0], r2[1]);
    }

    public Matrix getValueMatrix() {
        return this.mMatrixValueToPx;
    }

    public Matrix getOffsetMatrix() {
        return this.mMatrixOffset;
    }

    public Matrix getValueToPixelMatrix() {
        this.mMBuffer1.set(this.mMatrixValueToPx);
        this.mMBuffer1.postConcat(this.mViewPortHandler.mMatrixTouch);
        this.mMBuffer1.postConcat(this.mMatrixOffset);
        return this.mMBuffer1;
    }

    public Matrix getPixelToValueMatrix() {
        getValueToPixelMatrix().invert(this.mMBuffer2);
        return this.mMBuffer2;
    }
}
