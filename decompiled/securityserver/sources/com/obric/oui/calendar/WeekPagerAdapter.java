package com.obric.oui.calendar;

import java.util.Collections;
import java.util.List;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.WeekFields;

/* JADX INFO: loaded from: classes2.dex */
public class WeekPagerAdapter extends CalendarPagerAdapter<WeekView> {

    public static class Weekly implements DateRangeIndex {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CalendarDay f191a;
        public final int b;
        public final DayOfWeek c;

        public Weekly(CalendarDay r1, CalendarDay r2, DayOfWeek r3) {
            this.c = r3;
            this.f191a = b(r1);
            this.b = a(r2) + 1;
        }

        @Override // com.obric.oui.calendar.DateRangeIndex
        public final int a(CalendarDay r4) {
            WeekFields r0 = WeekFields.of(this.c, 1);
            LocalDate r5 = r4.b().with(r0.dayOfWeek(), 1);
            return (int) ChronoUnit.WEEKS.between(this.f191a.b(), r5);
        }

        public final CalendarDay b(CalendarDay r3) {
            return CalendarDay.a(r3.b().with(WeekFields.of(this.c, 1).dayOfWeek(), 1));
        }

        @Override // com.obric.oui.calendar.DateRangeIndex
        public final int getCount() {
            return this.b;
        }

        @Override // com.obric.oui.calendar.DateRangeIndex
        public final CalendarDay getItem(int r3) {
            return CalendarDay.a(this.f191a.b().plusWeeks(r3));
        }
    }

    public WeekPagerAdapter(MaterialCalendarView r1) {
        super(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public final DateRangeIndex b(CalendarDay r2, CalendarDay r3) {
        return new Weekly(r2, r3, this.b.getFirstDayOfWeek());
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public final CalendarPagerView c(int r4) {
        CalendarDay r5 = this.k.getItem(r4);
        MaterialCalendarView r1 = this.b;
        return new WeekView(r1, r5, r1.getFirstDayOfWeek(), this.s);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public final CalendarDay f(int r1) {
        return this.k.getItem(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public final List g() {
        return Collections.unmodifiableList(this.l);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.k.getCount();
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public final int h() {
        return this.h;
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public final int j(CalendarPagerView r1) {
        CalendarDay r2 = ((WeekView) r1).j;
        return this.k.a(r2);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public final boolean m(Object r1) {
        return r1 instanceof WeekView;
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public final void x(boolean r1) {
        this.s = r1;
    }
}
