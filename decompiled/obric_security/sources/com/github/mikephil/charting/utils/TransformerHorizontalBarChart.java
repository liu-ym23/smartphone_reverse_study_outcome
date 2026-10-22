package com.github.mikephil.charting.utils;

/* JADX INFO: loaded from: classes2.dex */
public class TransformerHorizontalBarChart extends Transformer {
    public TransformerHorizontalBarChart(ViewPortHandler r1) {
        super(r1);
    }

    @Override // com.github.mikephil.charting.utils.Transformer
    public void prepareMatrixOffset(boolean r4) {
        this.mMatrixOffset.reset();
        if (r4 == true) goto L5;
        this.mMatrixOffset.postTranslate(this.mViewPortHandler.offsetLeft(), this.mViewPortHandler.getChartHeight() - this.mViewPortHandler.offsetBottom());
        return;
    L5:
        this.mMatrixOffset.setTranslate(-(this.mViewPortHandler.getChartWidth() - this.mViewPortHandler.offsetRight()), this.mViewPortHandler.getChartHeight() - this.mViewPortHandler.offsetBottom());
        this.mMatrixOffset.postScale(-1.0f, 1.0f);
    }
}
