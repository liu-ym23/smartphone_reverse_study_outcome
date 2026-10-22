package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;

/* JADX INFO: loaded from: classes3.dex */
class MaxInputValidator implements InputFilter {
    private int max;

    public MaxInputValidator(int r1) {
        this.max = r1;
    }

    public void setMax(int r1) {
        this.max = r1;
    }

    public int getMax() {
        return this.max;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence r2, int r3, int r4, Spanned r5, int r6, int r7) {
        StringBuilder r0 = new StringBuilder(r5);     // Catch: NumberFormatException -> L8
        r0.replace(r6, r7, r2.subSequence(r3, r4).toString());     // Catch: NumberFormatException -> L8
        if (Integer.parseInt(r0.toString()) > this.max) goto L6;
        return null;
    L6:
        return "";
    L11:
        return "";
    }
}
