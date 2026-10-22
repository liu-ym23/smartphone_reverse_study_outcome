package com.obric.oui.calendar.format;

import com.obric.oui.calendar.CalendarDay;
import org.threeten.bp.format.DateTimeFormatter;

/* JADX INFO: loaded from: classes4.dex */
public class DateFormatTitleFormatter implements TitleFormatter {
    private final DateTimeFormatter dateFormat;

    public DateFormatTitleFormatter() {
        this(DateTimeFormatter.ofPattern(TitleFormatter.DEFAULT_FORMAT));
    }

    public DateFormatTitleFormatter(DateTimeFormatter r1) {
        this.dateFormat = r1;
    }

    @Override // com.obric.oui.calendar.format.TitleFormatter
    public CharSequence format(CalendarDay r1) {
        return this.dateFormat.format(r1.getDate());
    }
}
