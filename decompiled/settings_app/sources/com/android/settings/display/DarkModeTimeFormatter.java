package com.android.settings.display;

import android.content.Context;
import java.text.DateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
public class DarkModeTimeFormatter {
    private final Context mContext;
    private final DateFormat mFormatter;

    public DarkModeTimeFormatter(Context r1) {
        this.mContext = r1;
        DateFormat r2 = android.text.format.DateFormat.getTimeFormat(r1);
        this.mFormatter = r2;
        r2.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public String of(LocalTime r4) {
        Calendar r0 = Calendar.getInstance();
        r0.setTimeZone(this.mFormatter.getTimeZone());
        r0.set(11, r4.getHour());
        r0.set(12, r4.getMinute());
        r0.set(13, 0);
        r0.set(14, 0);
        return this.mFormatter.format(r0.getTime());
    }

    public boolean is24HourFormat() {
        return android.text.format.DateFormat.is24HourFormat(this.mContext);
    }
}
