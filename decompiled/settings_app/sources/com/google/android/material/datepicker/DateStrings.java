package com.google.android.material.datepicker;

import android.text.format.DateUtils;
import androidx.core.util.Pair;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
class DateStrings {
    private DateStrings() {
    }

    static String getYearMonth(long r2) {
        return DateUtils.formatDateTime(null, r2, 8228);
    }

    static String getYearMonthDay(long r1) {
        return getYearMonthDay(r1, Locale.getDefault());
    }

    static String getYearMonthDay(long r1, Locale r3) {
        return UtcDates.getYearAbbrMonthDayFormat(r3).format(new Date(r1));
    }

    static String getMonthDay(long r1) {
        return getMonthDay(r1, Locale.getDefault());
    }

    static String getMonthDay(long r1, Locale r3) {
        return UtcDates.getAbbrMonthDayFormat(r3).format(new Date(r1));
    }

    static String getMonthDayOfWeekDay(long r1) {
        return getMonthDayOfWeekDay(r1, Locale.getDefault());
    }

    static String getMonthDayOfWeekDay(long r1, Locale r3) {
        return UtcDates.getAbbrMonthWeekdayDayFormat(r3).format(new Date(r1));
    }

    static String getYearMonthDayOfWeekDay(long r1) {
        return getYearMonthDayOfWeekDay(r1, Locale.getDefault());
    }

    static String getYearMonthDayOfWeekDay(long r1, Locale r3) {
        return UtcDates.getYearAbbrMonthWeekdayDayFormat(r3).format(new Date(r1));
    }

    static String getDateString(long r1) {
        return getDateString(r1, null);
    }

    static String getDateString(long r2, SimpleDateFormat r4) {
        Calendar r0 = UtcDates.getTodayCalendar();
        Calendar r1 = UtcDates.getUtcCalendar();
        r1.setTimeInMillis(r2);
        if (r4 == null) goto L7;
        return r4.format(new Date(r2));
    L7:
        if (r0.get(1) != r1.get(1)) goto L11;
        return getMonthDay(r2);
    L11:
        return getYearMonthDay(r2);
    }

    static Pair<String, String> getDateRangeString(Long r1, Long r2) {
        return getDateRangeString(r1, r2, null);
    }

    static Pair<String, String> getDateRangeString(Long r5, Long r6, SimpleDateFormat r7) {
        if (r5 != null) goto L7;
        if (r6 != null) goto L7;
        return Pair.create(null, null);
    L7:
        if (r5 == null) goto L9;
        if (r6 == null) goto L12;
        Calendar r0 = UtcDates.getTodayCalendar();
        Calendar r1 = UtcDates.getUtcCalendar();
        r1.setTimeInMillis(r5.longValue());
        Calendar r2 = UtcDates.getUtcCalendar();
        r2.setTimeInMillis(r6.longValue());
        if (r7 == null) goto L18;
        Date r3 = new Date(r5.longValue());
        Date r8 = new Date(r6.longValue());
        return Pair.create(r7.format(r3), r7.format(r8));
    L18:
        if (r1.get(1) != r2.get(1)) goto L26;
        if (r1.get(1) != r0.get(1)) goto L24;
        return Pair.create(getMonthDay(r5.longValue(), Locale.getDefault()), getMonthDay(r6.longValue(), Locale.getDefault()));
    L24:
        return Pair.create(getMonthDay(r5.longValue(), Locale.getDefault()), getYearMonthDay(r6.longValue(), Locale.getDefault()));
    L26:
        return Pair.create(getYearMonthDay(r5.longValue(), Locale.getDefault()), getYearMonthDay(r6.longValue(), Locale.getDefault()));
    L12:
        return Pair.create(getDateString(r5.longValue(), r7), null);
    L9:
        return Pair.create(null, getDateString(r6.longValue(), r7));
    }
}
