package com.github.mikephil.charting.formatter;

import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public class IndexAxisValueFormatter extends ValueFormatter {
    private int mValueCount;
    private String[] mValues;

    public IndexAxisValueFormatter() {
        this.mValues = new String[0];
        this.mValueCount = 0;
    }

    public IndexAxisValueFormatter(String[] r3) {
        this.mValues = new String[0];
        this.mValueCount = 0;
        if (r3 == null) goto L6;
        setValues(r3);
        return;
    }

    public IndexAxisValueFormatter(Collection<String> r3) {
        this.mValues = new String[0];
        this.mValueCount = 0;
        if (r3 == null) goto L6;
        setValues((String[]) r3.toArray(new String[r3.size()]));
        return;
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String getFormattedValue(float r3) {
        int r0 = Math.round(r3);
        if (r0 >= 0) goto L5;
        return "";
    L5:
        if (r0 < this.mValueCount) goto L7;
        return "";
    L7:
        if (r0 == ((int) r3)) goto L10;
        return "";
    L10:
        return this.mValues[r0];
    }

    public String[] getValues() {
        return this.mValues;
    }

    public void setValues(String[] r1) {
        if (r1 != null) goto L4;
        r1 = new String[0];
    L4:
        this.mValues = r1;
        this.mValueCount = r1.length;
    }
}
