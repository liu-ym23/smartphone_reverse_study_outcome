package com.obric.oui.calendar.format;

import org.threeten.bp.DayOfWeek;

/* JADX INFO: loaded from: classes2.dex */
public interface WeekDayFormatter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CalendarWeekDayFormatter f194a = null;

    static {
        f194a = new CalendarWeekDayFormatter();
    }

    CharSequence a(DayOfWeek r1);
}
