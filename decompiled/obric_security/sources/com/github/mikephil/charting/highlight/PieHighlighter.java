package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;

/* JADX INFO: loaded from: classes2.dex */
public class PieHighlighter extends PieRadarHighlighter<PieChart> {
    public PieHighlighter(PieChart r1) {
        super(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.highlight.PieRadarHighlighter
    protected Highlight getClosestHighlight(int r10, float r11, float r12) {
        IPieDataSet r9 = ((PieData) ((PieChart) this.mChart).getData()).getDataSet();
        return new Highlight(r10, r9.getEntryForIndex(r10).getY(), r11, r12, 0, r9.getAxisDependency());
    }
}
