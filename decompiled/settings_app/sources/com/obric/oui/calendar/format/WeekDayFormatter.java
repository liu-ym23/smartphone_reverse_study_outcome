package com.obric.oui.calendar.format;

import org.threeten.bp.DayOfWeek;

/* JADX INFO: loaded from: classes4.dex */
public interface WeekDayFormatter {
    public static final WeekDayFormatter DEFAULT = null;

    CharSequence format(DayOfWeek r1);

    static {
        DEFAULT = new CalendarWeekDayFormatter();
    }
}
