package com.google.android.material.datepicker;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.icu.text.DateFormat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
class UtcDates {
    static final String UTC = "UTC";
    static AtomicReference<TimeSource> timeSourceRef;

    static {
        timeSourceRef = new AtomicReference();
    }

    private UtcDates() {
    }

    public static long canonicalYearMonthDay(long r1) {
        Calendar r0 = getUtcCalendar();
        r0.setTimeInMillis(r1);
        return getDayCopy(r0).getTimeInMillis();
    }

    private static int findCharactersInDateFormatPattern(@NonNull String r2, @NonNull String r3, int r4, int r5) {
    L2:
        if (r5 < 0) goto L17;
        if (r5 >= r2.length()) goto L17;
        if (r3.indexOf(r2.charAt(r5)) != (-1)) goto L17;
        if (r2.charAt(r5) != '\'') goto L16;
    L9:
        r5 = r5 + r4;
        if (r5 < 0) goto L16;
        if (r5 >= r2.length()) goto L16;
        if (r2.charAt(r5) != '\'') goto L9;
    L16:
        r5 = r5 + r4;
    L17:
        return r5;
    }

    @TargetApi(24)
    public static DateFormat getAbbrMonthDayFormat(Locale r1) {
        return getAndroidFormat("MMMd", r1);
    }

    @TargetApi(24)
    public static DateFormat getAbbrMonthWeekdayDayFormat(Locale r1) {
        return getAndroidFormat("MMMEd", r1);
    }

    @TargetApi(24)
    private static DateFormat getAndroidFormat(String r0, Locale r1) {
        DateFormat r2 = DateFormat.getInstanceForSkeleton(r0, r1);
        r2.setTimeZone(getUtcAndroidTimeZone());
        return r2;
    }

    public static Calendar getDayCopy(Calendar r4) {
        Calendar r5 = getUtcCalendarOf(r4);
        Calendar r0 = getUtcCalendar();
        r0.set(r5.get(1), r5.get(2), r5.get(5));
        return r0;
    }

    private static java.text.DateFormat getFormat(int r0, Locale r1) {
        java.text.DateFormat r2 = java.text.DateFormat.getDateInstance(r0, r1);
        r2.setTimeZone(getTimeZone());
        return r2;
    }

    public static java.text.DateFormat getFullFormat() {
        return getFullFormat(Locale.getDefault());
    }

    public static java.text.DateFormat getMediumFormat() {
        return getMediumFormat(Locale.getDefault());
    }

    public static java.text.DateFormat getMediumNoYear() {
        return getMediumNoYear(Locale.getDefault());
    }

    public static SimpleDateFormat getSimpleFormat(String r1) {
        return getSimpleFormat(r1, Locale.getDefault());
    }

    public static SimpleDateFormat getTextInputFormat() {
        SimpleDateFormat r1 = new SimpleDateFormat(((SimpleDateFormat) java.text.DateFormat.getDateInstance(3, Locale.getDefault())).toLocalizedPattern().replaceAll("\\s+", ""), Locale.getDefault());
        r1.setTimeZone(getTimeZone());
        r1.setLenient(false);
        return r1;
    }

    public static String getTextInputHint(Resources r3, SimpleDateFormat r4) {
        String r5 = r4.toLocalizedPattern();
        String r0 = r3.getString(R.string.mtrl_picker_text_input_year_abbr);
        String r1 = r3.getString(R.string.mtrl_picker_text_input_month_abbr);
        return r5.replaceAll("d", r3.getString(R.string.mtrl_picker_text_input_day_abbr)).replaceAll("M", r1).replaceAll("y", r0);
    }

    public static TimeSource getTimeSource() {
        TimeSource r0 = timeSourceRef.get();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return TimeSource.system();
    }

    private static TimeZone getTimeZone() {
        return TimeZone.getTimeZone(UTC);
    }

    public static Calendar getTodayCalendar() {
        Calendar r0 = getTimeSource().now();
        r0.set(11, 0);
        r0.set(12, 0);
        r0.set(13, 0);
        r0.set(14, 0);
        r0.setTimeZone(getTimeZone());
        return r0;
    }

    @TargetApi(24)
    private static android.icu.util.TimeZone getUtcAndroidTimeZone() {
        return android.icu.util.TimeZone.getTimeZone(UTC);
    }

    public static Calendar getUtcCalendar() {
        return getUtcCalendarOf(null);
    }

    public static Calendar getUtcCalendarOf(@Nullable Calendar r3) {
        Calendar r0 = Calendar.getInstance(getTimeZone());
        if (r3 != null) goto L5;
        r0.clear();
    L6:
        return r0;
    L5:
        r0.setTimeInMillis(r3.getTimeInMillis());
        goto L6
    }

    @TargetApi(24)
    public static DateFormat getYearAbbrMonthDayFormat(Locale r1) {
        return getAndroidFormat("yMMMd", r1);
    }

    @TargetApi(24)
    public static DateFormat getYearAbbrMonthWeekdayDayFormat(Locale r1) {
        return getAndroidFormat("yMMMEd", r1);
    }

    public static SimpleDateFormat getYearMonthFormat() {
        return getYearMonthFormat(Locale.getDefault());
    }

    @NonNull
    private static String removeYearFromDateFormatPattern(@NonNull String r5) {
        int r0 = findCharactersInDateFormatPattern(r5, "yY", 1, 0);
        if (r0 < r5.length()) goto L5;
        return r5;
    L5:
        String r1 = "EMd";
        int r3 = findCharactersInDateFormatPattern(r5, "EMd", 1, r0);
        if (r3 >= r5.length()) goto L9;
        r1 = "EMd,";
    L9:
        return r5.replace(r5.substring(findCharactersInDateFormatPattern(r5, r1, -1, r0) + 1, r3), " ").trim();
    }

    public static void setTimeSource(@Nullable TimeSource r1) {
        timeSourceRef.set(r1);
    }

    public static java.text.DateFormat getFullFormat(Locale r1) {
        return getFormat(0, r1);
    }

    public static java.text.DateFormat getMediumFormat(Locale r1) {
        return getFormat(2, r1);
    }

    public static java.text.DateFormat getMediumNoYear(Locale r1) {
        SimpleDateFormat r2 = (SimpleDateFormat) getMediumFormat(r1);
        r2.applyPattern(removeYearFromDateFormatPattern(r2.toPattern()));
        return r2;
    }

    private static SimpleDateFormat getSimpleFormat(String r1, Locale r2) {
        SimpleDateFormat r0 = new SimpleDateFormat(r1, r2);
        r0.setTimeZone(getTimeZone());
        return r0;
    }

    private static SimpleDateFormat getYearMonthFormat(Locale r1) {
        return getSimpleFormat("LLLL, yyyy", r1);
    }
}
