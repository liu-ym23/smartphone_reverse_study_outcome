package com.android.setupwizardlib.span;

import android.text.Spannable;

/* JADX INFO: loaded from: classes.dex */
public class SpanHelper {
    public SpanHelper() {
    }

    public static void replaceSpan(Spannable r2, Object r3, Object r4) {
        int r0 = r2.getSpanStart(r3);
        int r1 = r2.getSpanEnd(r3);
        r2.removeSpan(r3);
        r2.setSpan(r4, r0, r1, 0);
    }
}
