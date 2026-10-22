package com.obric.oui.stepper;

import android.text.InputFilter;
import android.text.Spanned;

/* JADX INFO: loaded from: classes2.dex */
public class InputFilterMinMax implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f286a;
    public int b;
    public FilterListener c;

    public interface FilterListener {
        void a(int r1);
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r1, int r2, int r3, Spanned r4, int r5, int r6) {
        int r7 = Integer.parseInt(r4.toString() + r1.toString());     // Catch: NumberFormatException -> L18
        int r8 = this.f286a;     // Catch: NumberFormatException -> L18
        int r9 = this.b;     // Catch: NumberFormatException -> L18
        boolean r10 = false;
        if (r9 <= r8) goto L7;
        if (r7 < r8) goto L10;
        if (r7 > r9) goto L10;
    L6:
        r10 = true;
    L10:
        if (r10 == false) goto L13;
        return null;
    L13:
        FilterListener r0 = this.c;     // Catch: NumberFormatException -> L18
        if (r0 == null) goto L21;
        r0.a(r7);     // Catch: NumberFormatException -> L18
        return "";
    L21:
        return "";
    L7:
        if (r7 < r9) goto L10;
        if (r7 > r8) goto L10;
    L22:
        return "";
    }
}
