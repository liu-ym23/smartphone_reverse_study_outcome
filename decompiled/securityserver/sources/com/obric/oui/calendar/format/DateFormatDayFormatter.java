package com.obric.oui.calendar.format;

import com.obric.oui.calendar.CalendarDay;
import java.util.Locale;
import org.threeten.bp.format.DateTimeFormatter;

/* JADX INFO: loaded from: classes2.dex */
public class DateFormatDayFormatter implements DayFormatter {
    public final DateTimeFormatter b;

    public DateFormatDayFormatter() {
        this.b = DateTimeFormatter.ofPattern("d", Locale.getDefault());
    }

    @Override // com.obric.oui.calendar.format.DayFormatter
    public final String a(CalendarDay r1) {
        return this.b.format(r1.b());
    }
}
