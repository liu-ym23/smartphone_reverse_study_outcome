package com.obric.oui.calendar.v;

import com.obric.oui.calendar.CalendarDay;
import org.threeten.bp.format.DateTimeFormatter;

/* JADX INFO: loaded from: classes2.dex */
public class d implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DateTimeFormatter f10928b;

    public d() {
        this(DateTimeFormatter.ofPattern("LLLL yyyy"));
    }

    public d(DateTimeFormatter r1) {
        this.f10928b = r1;
    }

    @Override // com.obric.oui.calendar.v.g
    public CharSequence a(CalendarDay r1) {
        return this.f10928b.format(r1.e());
    }
}
