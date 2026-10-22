package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.utils.ColorTemplate;

/* JADX INFO: loaded from: classes2.dex */
public class LegendEntry {
    public Legend.LegendForm form;
    public int formColor;
    public DashPathEffect formLineDashEffect;
    public float formLineWidth;
    public float formSize;
    public String label;

    public LegendEntry() {
        this.form = Legend.LegendForm.DEFAULT;
        this.formSize = Float.NaN;
        this.formLineWidth = Float.NaN;
        this.formLineDashEffect = null;
        this.formColor = ColorTemplate.COLOR_NONE;
    }

    public LegendEntry(String r2, Legend.LegendForm r3, float r4, float r5, DashPathEffect r6, int r7) {
        Legend.LegendForm r0 = Legend.LegendForm.DEFAULT;
        this.label = r2;
        this.form = r3;
        this.formSize = r4;
        this.formLineWidth = r5;
        this.formLineDashEffect = r6;
        this.formColor = r7;
    }
}
