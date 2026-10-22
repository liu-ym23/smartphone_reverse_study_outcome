package com.obric.oui.calendar.format;

import android.text.SpannableStringBuilder;
import com.obric.oui.calendar.CalendarDay;

/* JADX INFO: loaded from: classes2.dex */
public class MonthArrayTitleFormatter implements TitleFormatter {
    public final CharSequence[] b;

    public MonthArrayTitleFormatter(CharSequence[] r3) {
        if (r3 == null) goto L11;
        if (r3.length < 12) goto L9;
        this.b = r3;
        return;
    L9:
        throw new IllegalArgumentException("Label array is too short");
    L11:
        throw new IllegalArgumentException("Label array cannot be null");
    }

    @Override // com.obric.oui.calendar.format.TitleFormatter
    public final CharSequence a(CalendarDay r3) {
        return new SpannableStringBuilder().append(this.b[r3.d() - 1]).append(" ").append(String.valueOf(r3.e()));
    }
}
