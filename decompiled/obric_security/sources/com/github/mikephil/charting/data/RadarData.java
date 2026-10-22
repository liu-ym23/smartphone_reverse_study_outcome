package com.github.mikephil.charting.data;

import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RadarData extends ChartData<IRadarDataSet> {
    private List<String> mLabels;

    public RadarData() {
    }

    public RadarData(List<IRadarDataSet> r1) {
        super(r1);
    }

    public RadarData(IRadarDataSet... r1) {
        super(r1);
    }

    public void setLabels(List<String> r1) {
        this.mLabels = r1;
    }

    public void setLabels(String... r1) {
        this.mLabels = Arrays.asList(r1);
    }

    public List<String> getLabels() {
        return this.mLabels;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.github.mikephil.charting.data.Entry] */
    @Override // com.github.mikephil.charting.data.ChartData
    public Entry getEntryForHighlight(Highlight r2) {
        return getDataSetByIndex(r2.getDataSetIndex()).getEntryForIndex((int) r2.getX());
    }
}
