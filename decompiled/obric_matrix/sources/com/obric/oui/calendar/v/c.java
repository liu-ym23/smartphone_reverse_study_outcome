package com.obric.oui.calendar.v;

import androidx.annotation.NonNull;
import com.obric.oui.calendar.CalendarDay;
import java.util.Locale;
import org.threeten.bp.format.DateTimeFormatter;

/* JADX INFO: loaded from: classes2.dex */
public class c implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DateTimeFormatter f10927b;

    public c() {
        this(DateTimeFormatter.ofPattern("d", Locale.getDefault()));
    }

    public c(@NonNull DateTimeFormatter r1) {
        this.f10927b = r1;
    }

    @Override // com.obric.oui.calendar.v.e
    @NonNull
    public String a(@NonNull CalendarDay r1) {
        return this.f10927b.format(r1.e());
    }
}
