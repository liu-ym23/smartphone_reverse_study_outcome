package com.obric.oui.calendar.format;

import com.obric.oui.calendar.CalendarDay;

/* JADX INFO: loaded from: classes4.dex */
public interface DayFormatter {
    public static final DayFormatter DEFAULT = null;
    public static final String DEFAULT_FORMAT = "d";

    String format(CalendarDay r1);

    static {
        DEFAULT = new DateFormatDayFormatter();
    }
}
