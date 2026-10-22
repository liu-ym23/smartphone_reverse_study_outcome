package com.obric.oui.calendar.format;

import com.obric.oui.calendar.CalendarDay;
import java.util.Locale;
import org.threeten.bp.format.DateTimeFormatter;

/* JADX INFO: loaded from: classes4.dex */
public class DateFormatDayFormatter implements DayFormatter {
    private final DateTimeFormatter dateFormat;

    public DateFormatDayFormatter() {
        this(DateTimeFormatter.ofPattern("d", Locale.getDefault()));
    }

    public DateFormatDayFormatter(DateTimeFormatter r1) {
        this.dateFormat = r1;
    }

    @Override // com.obric.oui.calendar.format.DayFormatter
    public String format(CalendarDay r1) {
        return this.dateFormat.format(r1.getDate());
    }
}
