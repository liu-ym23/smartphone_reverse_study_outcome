package com.obric.oui.calendar;

import android.annotation.SuppressLint;
import java.util.ArrayList;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ViewConstructor"})
class WeekView extends CalendarPagerView {
    @Override // com.obric.oui.calendar.CalendarPagerView
    public final void b(ArrayList r4, LocalDate r5) {
        int r0 = 0;
    L4:
        if (r0 >= 7) goto L6;
        a(r4, r5);
        r5 = r5.plusDays(1);
        r0 = r0 + 1;
        goto L4
    }

    @Override // com.obric.oui.calendar.CalendarPagerView
    public final int d() {
        if (this.m == false) goto L5;
        return 2;
    L5:
        return 1;
    }

    @Override // com.obric.oui.calendar.CalendarPagerView
    public final boolean e(CalendarDay r1) {
        return true;
    }
}
