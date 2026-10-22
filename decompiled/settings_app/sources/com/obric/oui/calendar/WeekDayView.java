package com.obric.oui.calendar;

import android.content.Context;
import android.graphics.Typeface;
import androidx.appcompat.widget.AppCompatTextView;
import com.obric.oui.calendar.format.WeekDayFormatter;
import org.threeten.bp.DayOfWeek;

/* JADX INFO: loaded from: classes4.dex */
class WeekDayView extends AppCompatTextView {
    private DayOfWeek dayOfWeek;
    private WeekDayFormatter formatter;

    public WeekDayView(Context r3, DayOfWeek r4) {
        super(r3);
        this.formatter = WeekDayFormatter.DEFAULT;
        setGravity(17);
        setTextAlignment(4);
        setTextSize(12.0f);
        setTypeface(Typeface.create(Typeface.DEFAULT, 400, false));
        setDayOfWeek(r4);
    }

    public void setWeekDayFormatter(WeekDayFormatter r1) {
        if (r1 != null) goto L4;
        r1 = WeekDayFormatter.DEFAULT;
    L4:
        this.formatter = r1;
        setDayOfWeek(this.dayOfWeek);
    }

    public void setDayOfWeek(DayOfWeek r2) {
        this.dayOfWeek = r2;
        setText(this.formatter.format(r2));
    }
}
