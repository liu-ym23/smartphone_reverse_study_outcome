package com.obric.oui.calendar;

import org.threeten.bp.Period;

/* JADX INFO: loaded from: classes2.dex */
class MonthPagerAdapter extends CalendarPagerAdapter<MonthView> {

    public static class Monthly implements DateRangeIndex {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CalendarDay f188a;
        public final int b;

        public Monthly(CalendarDay r4, CalendarDay r5) {
            this.f188a = new CalendarDay(r4.e(), r4.d(), 1);
            this.b = a(r5) + 1;
        }

        @Override // com.obric.oui.calendar.DateRangeIndex
        public final int a(CalendarDay r2) {
            return (int) Period.between(this.f188a.b().withDayOfMonth(1), r2.b().withDayOfMonth(1)).toTotalMonths();
        }

        @Override // com.obric.oui.calendar.DateRangeIndex
        public final int getCount() {
            return this.b;
        }

        @Override // com.obric.oui.calendar.DateRangeIndex
        public final CalendarDay getItem(int r3) {
            return CalendarDay.a(this.f188a.b().plusMonths(r3));
        }
    }

    public MonthPagerAdapter(MaterialCalendarView r1) {
        super(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public final DateRangeIndex b(CalendarDay r1, CalendarDay r2) {
        return new Monthly(r1, r2);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public final CalendarPagerView c(int r4) {
        CalendarDay r5 = this.k.getItem(r4);
        MaterialCalendarView r1 = this.b;
        return new MonthView(r1, r5, r1.getFirstDayOfWeek(), this.s);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public final int j(CalendarPagerView r1) {
        CalendarDay r2 = ((MonthView) r1).j;
        return this.k.a(r2);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public final boolean m(Object r1) {
        return r1 instanceof MonthView;
    }
}
