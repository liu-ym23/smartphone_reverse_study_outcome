package com.obric.oui.calendar;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import java.util.Collection;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ViewConstructor"})
class m extends e {
    public m(@NonNull MaterialCalendarView r1, CalendarDay r2, DayOfWeek r3, boolean r4) {
        super(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.calendar.e
    protected void b(Collection<g> r6, LocalDate r7) {
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

    @Override // com.obric.oui.calendar.e
    protected int h() {
        if (this.n == false) goto L5;
        return 7;
    L5:
        return 6;
    }

    @Override // com.obric.oui.calendar.e
    protected boolean j(CalendarDay r1) {
        if (r1.g() != g().g()) goto L5;
        return true;
    L5:
        return false;
    }

    public CalendarDay y() {
        return g();
    }
}
