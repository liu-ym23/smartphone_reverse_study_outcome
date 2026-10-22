package com.obric.oui.calendar.format;

import java.util.Locale;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.format.TextStyle;

/* JADX INFO: loaded from: classes2.dex */
public final class CalendarWeekDayFormatter implements WeekDayFormatter {
    @Override // com.obric.oui.calendar.format.WeekDayFormatter
    public final CharSequence a(DayOfWeek r2) {
        return r2.getDisplayName(TextStyle.SHORT, Locale.getDefault());
    }
}
