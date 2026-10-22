package com.android.settingslib.utils;

import android.content.Context;
import android.icu.text.DisplayContext;
import android.icu.text.MeasureFormat;
import android.icu.text.MessageFormat;
import android.icu.text.RelativeDateTimeFormatter;
import android.icu.util.Measure;
import android.icu.util.MeasureUnit;
import android.icu.util.TimeUnit;
import android.icu.util.ULocale;
import android.text.SpannableStringBuilder;
import android.text.style.TtsSpan;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class StringUtil {
    private static final int LIMITED_TIME_UNIT_COUNT = 2;
    public static final int SECONDS_PER_DAY = 86400;
    public static final int SECONDS_PER_HOUR = 3600;
    public static final int SECONDS_PER_MINUTE = 60;

    public StringUtil() {
    }

    public static CharSequence formatElapsedTime(Context r7, double r8, boolean r10, boolean r11) {
        SpannableStringBuilder r0 = new SpannableStringBuilder();
        int r9 = (int) Math.floor(r8 / 1000.0d);
        if (r10 == true) goto L6;
        r9 = r9 + 30;
    L6:
        if (r9 < 86400) goto L8;
        int r2 = r9 / SECONDS_PER_DAY;
        r9 = r9 - (SECONDS_PER_DAY * r2);
    L10:
        if (r9 < 3600) goto L12;
        int r12 = r9 / SECONDS_PER_HOUR;
        r9 = r9 - (r12 * SECONDS_PER_HOUR);
    L14:
        if (r9 < 60) goto L16;
        int r3 = r9 / 60;
        r9 = r9 - (r3 * 60);
    L17:
        ArrayList r4 = new ArrayList(4);
        if (r2 <= 0) goto L20;
        r4.add(new Measure(Integer.valueOf(r2), MeasureUnit.DAY));
    L20:
        if (r12 <= 0) goto L22;
        r4.add(new Measure(Integer.valueOf(r12), MeasureUnit.HOUR));
    L22:
        if (r3 <= 0) goto L24;
        r4.add(new Measure(Integer.valueOf(r3), MeasureUnit.MINUTE));
    L24:
        if (r10 == false) goto L28;
        if (r9 <= 0) goto L28;
        r4.add(new Measure(Integer.valueOf(r9), MeasureUnit.SECOND));
    L28:
        if (r4.size() == 0) goto L30;
    L34:
        if (r11 == true) goto L36;
    L38:
        Measure[] r13 = (Measure[]) r4.toArray(new Measure[r4.size()]);
        r0.append(MeasureFormat.getInstance(r7.getResources().getConfiguration().locale, MeasureFormat.FormatWidth.SHORT).formatMeasures(r13));
        if (r13.length == 1) goto L41;
    L43:
        return r0;
    L41:
        if (MeasureUnit.MINUTE.equals(r13[0].getUnit()) == false) goto L43;
        r0.setSpan(new TtsSpan.MeasureBuilder().setNumber(r3).setUnit("minute").build(), 0, r0.length(), 33);
        goto L43
    L36:
        if (r4.size() <= 2) goto L38;
        r4.subList(2, r4.size()).clear();
        goto L38
    L30:
        if (r10 == false) goto L32;
        TimeUnit r14 = MeasureUnit.SECOND;
    L33:
        r4.add(new Measure(0, r14));
        goto L34
    L32:
        r14 = MeasureUnit.MINUTE;
        goto L33
    L16:
        r3 = 0;
        goto L17
    L12:
        r12 = 0;
        goto L14
    L8:
        r2 = 0;
        goto L10
    }

    public static CharSequence formatRelativeTime(Context r2, double r3, boolean r5, RelativeDateTimeFormatter.Style r6) {
        int r4 = (int) Math.floor(r3 / 1000.0d);
        if (r5 == false) goto L9;
        if (r4 >= 120) goto L9;
        return r2.getResources().getString(com.android.settingslib.R.string.time_unit_just_now);
    L9:
        if (r4 >= 7200) goto L12;
        RelativeDateTimeFormatter.RelativeUnit r7 = RelativeDateTimeFormatter.RelativeUnit.MINUTES;
        int r8 = (r4 + 30) / 60;
    L16:
        return RelativeDateTimeFormatter.getInstance(ULocale.forLocale(r2.getResources().getConfiguration().locale), null, r6, DisplayContext.CAPITALIZATION_FOR_MIDDLE_OF_SENTENCE).format(r8, RelativeDateTimeFormatter.Direction.LAST, r7);
    L12:
        if (r4 >= 172800) goto L14;
        r7 = RelativeDateTimeFormatter.RelativeUnit.HOURS;
        r8 = (r4 + 1800) / SECONDS_PER_HOUR;
        goto L16
    L14:
        r7 = RelativeDateTimeFormatter.RelativeUnit.DAYS;
        r8 = (r4 + 43200) / SECONDS_PER_DAY;
        goto L16
    }

    @Deprecated
    public static CharSequence formatRelativeTime(Context r1, double r2, boolean r4) {
        return formatRelativeTime(r1, r2, r4, RelativeDateTimeFormatter.Style.LONG);
    }

    public static String getIcuPluralsString(Context r1, int r2, int r3) {
        MessageFormat r0 = new MessageFormat(r1.getResources().getString(r3), Locale.getDefault());
        HashMap r4 = new HashMap();
        r4.put("count", Integer.valueOf(r2));
        return r0.format(r4);
    }

    public static String getIcuPluralsString(Context r1, Map<String, Object> r2, int r3) {
        return new MessageFormat(r1.getResources().getString(r3), Locale.getDefault()).format(r2);
    }
}
