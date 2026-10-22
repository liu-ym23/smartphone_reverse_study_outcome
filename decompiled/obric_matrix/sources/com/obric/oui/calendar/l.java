package com.obric.oui.calendar;

import androidx.annotation.NonNull;
import org.threeten.bp.Period;

/* JADX INFO: loaded from: classes2.dex */
class l extends d<m> {

    public static class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CalendarDay f10909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f10910b;

        public a(@NonNull CalendarDay r3, @NonNull CalendarDay r4) {
            this.f10909a = CalendarDay.b(r3.h(), r3.g(), 1);
            this.f10910b = a(r4) + 1;
        }

        @Override // com.obric.oui.calendar.f
        public int a(CalendarDay r2) {
            return (int) Period.between(this.f10909a.e().withDayOfMonth(1), r2.e().withDayOfMonth(1)).toTotalMonths();
        }

        @Override // com.obric.oui.calendar.f
        public int getCount() {
            return this.f10910b;
        }

        @Override // com.obric.oui.calendar.f
        public CalendarDay getItem(int r3) {
            return CalendarDay.d(this.f10909a.e().plusMonths(r3));
        }
    }

    l(MaterialCalendarView r1) {
        super(r1);
    }

    protected m D(int r4) {
        return new m(this.f10876b, f(r4), this.f10876b.getFirstDayOfWeek(), this.s);
    }

    protected int E(m r1) {
        CalendarDay r2 = r1.y();
        return g().a(r2);
    }

    @Override // com.obric.oui.calendar.d
    protected f b(CalendarDay r1, CalendarDay r2) {
        return new a(r1, r2);
    }

    @Override // com.obric.oui.calendar.d
    protected /* bridge */ /* synthetic */ e c(int r1) {
        return D(r1);
    }

    @Override // com.obric.oui.calendar.d
    protected /* bridge */ /* synthetic */ int k(e r1) {
        return E((m) r1);
    }

    @Override // com.obric.oui.calendar.d
    protected boolean n(Object r1) {
        return r1 instanceof m;
    }
}
