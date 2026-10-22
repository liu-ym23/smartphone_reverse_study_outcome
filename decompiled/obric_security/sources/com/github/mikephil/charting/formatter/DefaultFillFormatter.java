package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultFillFormatter implements IFillFormatter {
    public DefaultFillFormatter() {
    }

    @Override // com.github.mikephil.charting.formatter.IFillFormatter
    public float getFillLinePosition(ILineDataSet r4, LineDataProvider r5) {
        float r3 = r5.getYChartMax();
        float r0 = r5.getYChartMin();
        LineData r6 = r5.getLineData();
        if (r4.getYMax() <= 0.0f) goto L8;
        if (r4.getYMin() >= 0.0f) goto L8;
        return 0.0f;
    L8:
        if (r6.getYMax() <= 0.0f) goto L11;
        r3 = 0.0f;
    L11:
        if (r6.getYMin() >= 0.0f) goto L14;
        r0 = 0.0f;
    L14:
        if (r4.getYMin() < 0.0f) goto L17;
        return r0;
    L17:
        return r3;
    }
}
