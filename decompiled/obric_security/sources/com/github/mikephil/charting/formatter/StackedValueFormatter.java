package com.github.mikephil.charting.formatter;

import com.bytedance.librarian.LibrarianImpl;
import com.github.mikephil.charting.data.BarEntry;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes2.dex */
public class StackedValueFormatter extends ValueFormatter {
    private boolean mDrawWholeStack;
    private DecimalFormat mFormat;
    private String mSuffix;

    public StackedValueFormatter(boolean r2, String r3, int r4) {
        this.mDrawWholeStack = r2;
        this.mSuffix = r3;
        StringBuffer r5 = new StringBuffer();
        int r6 = 0;
    L3:
        if (r6 >= r4) goto L7;
        if (r6 != 0) goto L6;
        r5.append(LibrarianImpl.Constants.DOT);
    L6:
        r5.append("0");
        r6 = r6 + 1;
        goto L3
    L7:
        this.mFormat = new DecimalFormat("###,###,###,##0" + r5.toString());
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String getBarStackedLabel(float r4, BarEntry r5) {
        if (this.mDrawWholeStack == true) goto L13;
        float[] r0 = r5.getYVals();
        if (r0 == null) goto L13;
        if (r0[r0.length - 1] == r4) goto L9;
        return "";
    L9:
        return this.mFormat.format(r5.getY()) + this.mSuffix;
    L13:
        return this.mFormat.format(r4) + this.mSuffix;
    }
}
