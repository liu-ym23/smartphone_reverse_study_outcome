package com.obric.oui.calendar;

import android.annotation.SuppressLint;
import java.util.ArrayList;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ViewConstructor"})
class MonthView extends CalendarPagerView {
    public MonthView(MaterialCalendarView r2, CalendarDay r3, DayOfWeek r4) {
        super(r2, r3, r4, true);
    }

    @Override // com.obric.oui.calendar.CalendarPagerView
    public final void b(ArrayList r6, LocalDate r7) {
        int r1 = 0;
    L4:
        if (r1 >= 6) goto L10;
        int r2 = 0;
    L7:
        if (r2 >= 7) goto L9;
        a(r6, r7);
        r7 = r7.plusDays(1);
        r2 = r2 + 1;
        goto L7
    L9:
        r1 = r1 + 1;
        goto L4
    }

    @Override // com.obric.oui.calendar.CalendarPagerView
    public final int d() {
        if (this.m == false) goto L5;
        return 7;
    L5:
        return 6;
    }

    @Override // com.obric.oui.calendar.CalendarPagerView
    public final boolean e(CalendarDay r1) {
        if (r1.d() != this.j.d()) goto L5;
        return true;
    L5:
        return false;
    }
}
