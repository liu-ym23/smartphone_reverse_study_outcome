package com.obric.oui.calendar;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import java.util.Collection;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ViewConstructor"})
class u extends e {
    public u(@NonNull MaterialCalendarView r1, CalendarDay r2, DayOfWeek r3, boolean r4) {
        super(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.calendar.e
    protected void b(Collection<g> r4, LocalDate r5) {
        int r0 = 0;
    L4:
        if (r0 >= 7) goto L6;
        a(r4, r5);
        r5 = r5.plusDays(1);
        r0 = r0 + 1;
        goto L4
    }

    @Override // com.obric.oui.calendar.e
    protected int h() {
        if (this.n == false) goto L5;
        return 2;
    L5:
        return 1;
    }

    @Override // com.obric.oui.calendar.e
    protected boolean j(CalendarDay r1) {
        return true;
    }
}
