package com.github.mikephil.charting.formatter;

import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes2.dex */
public class LargeValueFormatter extends ValueFormatter {
    private DecimalFormat mFormat;
    private int mMaxLength;
    private String[] mSuffix;
    private String mText;

    public int getDecimalDigits() {
        return 0;
    }

    public LargeValueFormatter() {
        this.mSuffix = new String[]{"", "k", "m", "b", "t"};
        this.mMaxLength = 5;
        this.mText = "";
        this.mFormat = new DecimalFormat("###E00");
    }

    public LargeValueFormatter(String r1) {
        this();
        this.mText = r1;
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String getFormattedValue(float r4) {
        return makePretty(r4) + this.mText;
    }

    public void setAppendix(String r1) {
        this.mText = r1;
    }

    public void setSuffix(String[] r1) {
        this.mSuffix = r1;
    }

    public void setMaxLength(int r1) {
        this.mMaxLength = r1;
    }

    private String makePretty(double r3) {
        String r4 = this.mFormat.format(r3);
        int r5 = Character.getNumericValue(r4.charAt(r4.length() - 1));
        String r6 = r4.replaceAll("E[0-9][0-9]", this.mSuffix[Integer.valueOf(Character.getNumericValue(r4.charAt(r4.length() - 2)) + "" + r5).intValue() / 3]);
    L4:
        if (r6.length() > this.mMaxLength) goto L9;
        if (r6.matches("[0-9]+\\.[a-z]") == true) goto L9;
        return r6;
    L9:
        r6 = r6.substring(0, r6.length() - 2) + r6.substring(r6.length() - 1);
        goto L4
    }
}
