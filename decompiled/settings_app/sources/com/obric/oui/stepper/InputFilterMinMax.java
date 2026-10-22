package com.obric.oui.stepper;

import android.text.InputFilter;
import android.text.Spanned;

/* JADX INFO: loaded from: classes5.dex */
public class InputFilterMinMax implements InputFilter {
    private FilterListener filterListener;
    private int max;
    private int min;

    interface FilterListener {
        void onBeyondLimit(int r1);
    }

    private boolean isInRange(int r2, int r3, int r4) {
        if (r3 <= r2) goto L7;
        if (r4 < r2) goto L11;
        if (r4 > r3) goto L11;
        return true;
    L11:
        return false;
    L7:
        if (r4 < r3) goto L11;
        if (r4 > r2) goto L11;
        return true;
    }

    public InputFilterMinMax(int r1, int r2, FilterListener r3) {
        this.min = r1;
        this.max = r2;
        this.filterListener = r3;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence r1, int r2, int r3, Spanned r4, int r5, int r6) {
        int r7 = Integer.parseInt(r4.toString() + r1.toString());     // Catch: NumberFormatException -> L11
        if (isInRange(this.min, this.max, r7) == false) goto L6;
        return null;
    L6:
        FilterListener r0 = this.filterListener;     // Catch: NumberFormatException -> L11
        if (r0 == null) goto L14;
        r0.onBeyondLimit(r7);     // Catch: NumberFormatException -> L11
        return "";
    L14:
        return "";
    L15:
        return "";
    }
}
