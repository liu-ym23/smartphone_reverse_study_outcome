package com.obric.oui.calendar.format;

import com.obric.oui.calendar.CalendarDay;

/* JADX INFO: loaded from: classes4.dex */
public interface TitleFormatter {
    public static final TitleFormatter DEFAULT = null;
    public static final String DEFAULT_FORMAT = "LLLL yyyy";

    CharSequence format(CalendarDay r1);

    static {
        DEFAULT = new DateFormatTitleFormatter();
    }
}
