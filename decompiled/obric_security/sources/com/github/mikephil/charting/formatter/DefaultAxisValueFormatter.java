package com.github.mikephil.charting.formatter;

import com.bytedance.librarian.LibrarianImpl;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultAxisValueFormatter extends ValueFormatter {
    protected int digits;
    protected DecimalFormat mFormat;

    public DefaultAxisValueFormatter(int r4) {
        this.digits = r4;
        StringBuffer r0 = new StringBuffer();
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L7;
        if (r1 != 0) goto L6;
        r0.append(LibrarianImpl.Constants.DOT);
    L6:
        r0.append("0");
        r1 = r1 + 1;
        goto L3
    L7:
        this.mFormat = new DecimalFormat("###,###,###,##0" + r0.toString());
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String getFormattedValue(float r3) {
        return this.mFormat.format(r3);
    }

    public int getDecimalDigits() {
        return this.digits;
    }
}
