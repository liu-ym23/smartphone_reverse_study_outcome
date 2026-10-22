package com.obric.oui.calendar;

import androidx.core.text.TextUtilsCompat;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
class LocalUtils {
    private LocalUtils() {
    }

    static boolean isRTL() {
        if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
