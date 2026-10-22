package com.obric.oui.calendar;

import java.util.Collection;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: classes4.dex */
class MonthView extends CalendarPagerView {
    private int weekCount;

    public MonthView(MaterialCalendarView r1, CalendarDay r2, DayOfWeek r3, boolean r4) {
        super(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.calendar.CalendarPagerView
    protected void buildDayViews(Collection<DayView> r6, LocalDate r7) {
        this.weekCount = getWeekCount();
        int r1 = 0;
    L4:
        if (r1 >= this.weekCount) goto L10;
        int r2 = 0;
    L7:
        if (r2 >= 7) goto L9;
        addDayView(r6, r7);
        r7 = r7.plusDays(1);
        r2 = r2 + 1;
        goto L7
    L9:
        r1 = r1 + 1;
        goto L4
    }

    public CalendarDay getMonth() {
        return getFirstViewDay();
    }

    @Override // com.obric.oui.calendar.CalendarPagerView
    protected boolean isDayEnabled(CalendarDay r1) {
        if (r1.getMonth() != getFirstViewDay().getMonth()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.calendar.CalendarPagerView
    protected int getRows() {
        boolean r0 = this.showWeekDays;
        int r1 = this.weekCount;
        if (r0 == true) goto L5;
        return r1;
    L5:
        return r1 + 1;
    }

    private int getWeekCount() {
        return getWeekCountForMonth(getMonth().getDate(), getFirstDayOfWeek(), MaterialCalendarView.showOtherMonths(this.showOtherDates));
    }
}
