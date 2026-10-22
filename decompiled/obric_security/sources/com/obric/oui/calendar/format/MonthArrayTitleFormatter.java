package com.obric.oui.calendar.format;

import android.text.SpannableStringBuilder;
import com.obric.oui.calendar.CalendarDay;

/* JADX INFO: loaded from: classes3.dex */
public class MonthArrayTitleFormatter implements TitleFormatter {
    private final CharSequence[] monthLabels;

    public MonthArrayTitleFormatter(CharSequence[] r3) {
        if (r3 == null) goto L11;
        if (r3.length < 12) goto L9;
        this.monthLabels = r3;
        return;
    L9:
        throw new IllegalArgumentException("Label array is too short");
    L11:
        throw new IllegalArgumentException("Label array cannot be null");
    }

    @Override // com.obric.oui.calendar.format.TitleFormatter
    public CharSequence format(CalendarDay r3) {
        return new SpannableStringBuilder().append(this.monthLabels[r3.getMonth() - 1]).append(" ").append(String.valueOf(r3.getYear()));
    }
}
