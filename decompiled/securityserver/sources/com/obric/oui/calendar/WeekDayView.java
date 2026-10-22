package com.obric.oui.calendar;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.appcompat.widget.AppCompatTextView;
import com.obric.oui.calendar.format.WeekDayFormatter;
import org.threeten.bp.DayOfWeek;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ViewConstructor"})
class WeekDayView extends AppCompatTextView {
    public WeekDayFormatter b;
    public DayOfWeek c;

    public WeekDayView(Context r1, DayOfWeek r2) {
        super(r1);
        this.b = WeekDayFormatter.f194a;
        setGravity(17);
        setTextAlignment(4);
        this.c = r2;
        setText(this.b.a(r2));
    }
}
