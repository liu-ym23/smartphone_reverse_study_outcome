package com.obric.oui.calendar.format;

import com.obric.oui.calendar.CalendarDay;
import org.threeten.bp.format.DateTimeFormatter;

/* JADX INFO: loaded from: classes2.dex */
public class DateFormatTitleFormatter implements TitleFormatter {
    public final DateTimeFormatter b;

    public DateFormatTitleFormatter() {
        this.b = DateTimeFormatter.ofPattern("LLLL yyyy");
    }

    @Override // com.obric.oui.calendar.format.TitleFormatter
    public final CharSequence a(CalendarDay r1) {
        return this.b.format(r1.b());
    }
}
