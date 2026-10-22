package com.obric.oui.calendar;

import org.threeten.bp.Period;

/* JADX INFO: loaded from: classes4.dex */
class MonthPagerAdapter extends CalendarPagerAdapter<MonthView> {

    public static class Monthly implements DateRangeIndex {
        private final int count;
        private final CalendarDay min;

        public Monthly(CalendarDay r3, CalendarDay r4) {
            this.min = CalendarDay.from(r3.getYear(), r3.getMonth(), 1);
            this.count = indexOf(r4) + 1;
        }

        @Override // com.obric.oui.calendar.DateRangeIndex
        public int getCount() {
            return this.count;
        }

        @Override // com.obric.oui.calendar.DateRangeIndex
        public int indexOf(CalendarDay r2) {
            return (int) Period.between(this.min.getDate().withDayOfMonth(1), r2.getDate().withDayOfMonth(1)).toTotalMonths();
        }

        @Override // com.obric.oui.calendar.DateRangeIndex
        public CalendarDay getItem(int r3) {
            return CalendarDay.from(this.min.getDate().plusMonths(r3));
        }
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    protected /* bridge */ /* synthetic */ CalendarPagerView createView(int r1) {
        return createView(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    protected /* bridge */ /* synthetic */ int indexOf(CalendarPagerView r1) {
        return indexOf((MonthView) r1);
    }

    MonthPagerAdapter(MaterialCalendarView r1) {
        super(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    protected MonthView createView(int r4) {
        return new MonthView(this.mcv, getItem(r4), this.mcv.getFirstDayOfWeek(), this.showWeekDays);
    }

    protected int indexOf(MonthView r1) {
        CalendarDay r2 = r1.getMonth();
        return getRangeIndex().indexOf(r2);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    protected boolean isInstanceOfView(Object r1) {
        return r1 instanceof MonthView;
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    protected DateRangeIndex createRangeIndex(CalendarDay r1, CalendarDay r2) {
        return new Monthly(r1, r2);
    }
}
