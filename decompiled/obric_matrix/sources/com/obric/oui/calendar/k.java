package com.obric.oui.calendar;

import androidx.core.text.TextUtilsCompat;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
class k {
    static boolean a() {
        if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
