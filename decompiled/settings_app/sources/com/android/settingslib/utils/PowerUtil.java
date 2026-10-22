package com.android.settingslib.utils;

import android.content.Context;
import android.icu.text.DateFormat;
import android.icu.text.MeasureFormat;
import android.icu.util.Measure;
import android.icu.util.MeasureUnit;
import android.text.TextUtils;
import java.time.Instant;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class PowerUtil {
    private static final long FIFTEEN_MINUTES_MILLIS = 0;
    private static final long ONE_DAY_MILLIS = 0;
    private static final long ONE_HOUR_MILLIS = 0;
    private static final long ONE_MIN_MILLIS = 0;
    private static final long SEVEN_MINUTES_MILLIS = 0;
    private static final long TWO_DAYS_MILLIS = 0;

    public static long convertMsToUs(long r2) {
        return r2 * 1000;
    }

    public PowerUtil() {
    }

    static {
        SEVEN_MINUTES_MILLIS = TimeUnit.MINUTES.toMillis(7);
        FIFTEEN_MINUTES_MILLIS = TimeUnit.MINUTES.toMillis(15);
        ONE_DAY_MILLIS = TimeUnit.DAYS.toMillis(1);
        TWO_DAYS_MILLIS = TimeUnit.DAYS.toMillis(2);
        ONE_HOUR_MILLIS = TimeUnit.HOURS.toMillis(1);
        ONE_MIN_MILLIS = TimeUnit.MINUTES.toMillis(1);
    }

    public static String getBatteryRemainingShortStringFormatted(Context r2, long r3) {
        if (r3 > 0) goto L7;
        return null;
    L7:
        if (r3 > ONE_DAY_MILLIS) goto L11;
        return getRegularTimeRemainingShortString(r2, r3);
    L11:
        return getMoreThanOneDayShortString(r2, r3, com.android.settingslib.R.string.power_remaining_duration_only_short);
    }

    public static String getBatteryTipStringFormatted(Context r3, long r4) {
        if (r4 > 0) goto L7;
        return null;
    L7:
        if (r4 > ONE_DAY_MILLIS) goto L11;
        return r3.getString(com.android.settingslib.R.string.power_suggestion_battery_run_out, new Object[]{getDateTimeStringFromMs(r3, r4)});
    L11:
        return getMoreThanOneDayShortString(r3, r4, com.android.settingslib.R.string.power_remaining_only_more_than_subtext);
    }

    private static String getUnderFifteenString(Context r4, CharSequence r5, String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L6;
        return r4.getString(com.android.settingslib.R.string.power_remaining_less_than_duration_only, new Object[]{r5});
    L6:
        return r4.getString(com.android.settingslib.R.string.power_remaining_less_than_duration, new Object[]{r5, r6});
    }

    private static String getMoreThanOneDayString(Context r2, long r3, String r5, boolean r6) {
        CharSequence r4 = StringUtil.formatElapsedTime(r2, roundTimeToNearestThreshold(r3, ONE_HOUR_MILLIS), false, true);
        if (TextUtils.isEmpty(r5) == false) goto L9;
        if (r6 == false) goto L6;
        int r7 = com.android.settingslib.R.string.power_remaining_duration_only_enhanced;
    L8:
        return r2.getString(r7, new Object[]{r4});
    L6:
        r7 = com.android.settingslib.R.string.power_remaining_duration_only;
        goto L8
    L9:
        if (r6 == false) goto L11;
        int r8 = com.android.settingslib.R.string.power_discharging_duration_enhanced;
    L13:
        return r2.getString(r8, new Object[]{r4, r5});
    L11:
        r8 = com.android.settingslib.R.string.power_discharging_duration;
        goto L13
    }

    private static String getMoreThanOneDayShortString(Context r2, long r3, int r5) {
        return r2.getString(r5, new Object[]{StringUtil.formatElapsedTime(r2, roundTimeToNearestThreshold(r3, ONE_HOUR_MILLIS), false, false)});
    }

    private static String getMoreThanTwoDaysString(Context r7, String r8) {
        MeasureFormat r0 = MeasureFormat.getInstance(r7.getResources().getConfiguration().getLocales().get(0), MeasureFormat.FormatWidth.SHORT);
        Measure r2 = new Measure(2, MeasureUnit.DAY);
        if (TextUtils.isEmpty(r8) == false) goto L6;
        return r7.getString(com.android.settingslib.R.string.power_remaining_only_more_than_subtext, new Object[]{r0.formatMeasures(new Measure[]{r2})});
    L6:
        return r7.getString(com.android.settingslib.R.string.power_remaining_more_than_subtext, new Object[]{r0.formatMeasures(new Measure[]{r2}), r8});
    }

    private static String getRegularTimeRemainingString(Context r2, long r3, String r5, boolean r6) {
        CharSequence r4 = StringUtil.formatElapsedTime(r2, r3, false, true);
        if (TextUtils.isEmpty(r5) == false) goto L9;
        if (r6 == false) goto L6;
        int r7 = com.android.settingslib.R.string.power_remaining_duration_only_enhanced;
    L8:
        return r2.getString(r7, new Object[]{r4});
    L6:
        r7 = com.android.settingslib.R.string.power_remaining_duration_only;
        goto L8
    L9:
        if (r6 == false) goto L11;
        int r8 = com.android.settingslib.R.string.power_discharging_duration_enhanced;
    L13:
        return r2.getString(r8, new Object[]{r4, r5});
    L11:
        r8 = com.android.settingslib.R.string.power_discharging_duration;
        goto L13
    }

    private static CharSequence getDateTimeStringFromMs(Context r2, long r3) {
        long r4 = roundTimeToNearestThreshold(System.currentTimeMillis() + r3, FIFTEEN_MINUTES_MILLIS);
        return DateFormat.getInstanceForSkeleton(android.text.format.DateFormat.getTimeFormatString(r2)).format(Date.from(Instant.ofEpochMilli(r4)));
    }

    private static String getRegularTimeRemainingShortString(Context r2, long r3) {
        String r4 = DateFormat.getInstanceForSkeleton(android.text.format.DateFormat.getTimeFormatString(r2)).format(Date.from(Instant.ofEpochMilli(roundTimeToNearestThreshold(System.currentTimeMillis() + r3, FIFTEEN_MINUTES_MILLIS))));
        return r2.getString(com.android.settingslib.R.string.power_discharge_by_only_short, new Object[]{r4});
    }

    public static long convertUsToMs(long r2) {
        return r2 / 1000;
    }

    public static long roundTimeToNearestThreshold(long r4, long r6) {
        long r5 = Math.abs(r4);
        long r7 = Math.abs(r6);
        long r0 = r5 % r7;
        if (r0 >= (r7 / 2)) goto L7;
        return r5 - r0;
    L7:
        return (r5 - r0) + r7;
    }

    public static String getTargetTimeShortString(Context r2, long r3, long r5) {
        long r6 = r5 + r3;
        long r0 = FIFTEEN_MINUTES_MILLIS;
        if (r3 < r0) goto L6;
        r6 = roundUpTimeToNextThreshold(r6, r0);
    L6:
        return DateFormat.getInstanceForSkeleton(android.text.format.DateFormat.getTimeFormatString(r2)).format(Date.from(Instant.ofEpochMilli(r6)));
    }

    private static long roundUpTimeToNextThreshold(long r2, long r4) {
        long r3 = Math.abs(r2);
        long r5 = Math.abs(r4);
        return (((r3 + r5) - 1) / r5) * r5;
    }
}
