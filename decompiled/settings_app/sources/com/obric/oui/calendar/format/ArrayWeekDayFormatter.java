package com.obric.oui.calendar.format;

import org.threeten.bp.DayOfWeek;

/* JADX INFO: loaded from: classes4.dex */
public class ArrayWeekDayFormatter implements WeekDayFormatter {
    private final CharSequence[] weekDayLabels;

    public ArrayWeekDayFormatter(CharSequence[] r3) {
        if (r3 == null) goto L11;
        if (r3.length != 7) goto L9;
        this.weekDayLabels = r3;
        return;
    L9:
        throw new IllegalArgumentException("Array must contain exactly 7 elements");
    L11:
        throw new IllegalArgumentException("Cannot be null");
    }

    @Override // com.obric.oui.calendar.format.WeekDayFormatter
    public CharSequence format(DayOfWeek r1) {
        return this.weekDayLabels[r1.getValue() - 1];
    }
}
