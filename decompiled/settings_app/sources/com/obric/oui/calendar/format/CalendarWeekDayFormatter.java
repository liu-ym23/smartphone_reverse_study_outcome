package com.obric.oui.calendar.format;

import java.util.Locale;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.format.TextStyle;

/* JADX INFO: loaded from: classes4.dex */
public final class CalendarWeekDayFormatter implements WeekDayFormatter {
    public CalendarWeekDayFormatter() {
    }

    @Override // com.obric.oui.calendar.format.WeekDayFormatter
    public CharSequence format(DayOfWeek r2) {
        return r2.getDisplayName(TextStyle.SHORT, Locale.getDefault());
    }
}
