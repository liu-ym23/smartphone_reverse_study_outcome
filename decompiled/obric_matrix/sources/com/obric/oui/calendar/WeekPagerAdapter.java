package com.obric.oui.calendar;

import androidx.annotation.NonNull;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.WeekFields;

/* JADX INFO: loaded from: classes2.dex */
public class WeekPagerAdapter extends d<u> {

    public static class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CalendarDay f10867a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f10868b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final DayOfWeek f10869c;

        public a(@NonNull CalendarDay r1, @NonNull CalendarDay r2, DayOfWeek r3) {
            this.f10869c = r3;
            this.f10867a = b(r1);
            this.f10868b = a(r2) + 1;
        }

        private CalendarDay b(@NonNull CalendarDay r3) {
            return CalendarDay.d(r3.e().with(WeekFields.of(this.f10869c, 1).dayOfWeek(), 1));
        }

        @Override // com.obric.oui.calendar.f
        public int a(CalendarDay r4) {
            WeekFields r0 = WeekFields.of(this.f10869c, 1);
            LocalDate r5 = r4.e().with(r0.dayOfWeek(), 1);
            return (int) ChronoUnit.WEEKS.between(this.f10867a.e(), r5);
        }

        @Override // com.obric.oui.calendar.f
        public int getCount() {
            return this.f10868b;
        }

        @Override // com.obric.oui.calendar.f
        public CalendarDay getItem(int r3) {
            return CalendarDay.d(this.f10867a.e().plusWeeks(r3));
        }
    }

    public WeekPagerAdapter(MaterialCalendarView r1) {
        super(r1);
    }

    protected u D(int r4) {
        return new u(this.f10876b, f(r4), this.f10876b.getFirstDayOfWeek(), this.s);
    }

    protected int E(u r1) {
        CalendarDay r2 = r1.g();
        return g().a(r2);
    }

    @Override // com.obric.oui.calendar.d
    protected f b(CalendarDay r2, CalendarDay r3) {
        return new a(r2, r3, this.f10876b.getFirstDayOfWeek());
    }

    @Override // com.obric.oui.calendar.d
    protected /* bridge */ /* synthetic */ e c(int r1) {
        return D(r1);
    }

    @Override // com.obric.oui.calendar.d
    protected /* bridge */ /* synthetic */ int k(e r1) {
        return E((u) r1);
    }

    @Override // com.obric.oui.calendar.d
    protected boolean n(Object r1) {
        return r1 instanceof u;
    }
}
