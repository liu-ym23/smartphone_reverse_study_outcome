package com.bytedance.android.standard.tools.date;

import android.content.Context;
import com.bytedance.android.standard.tools.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public final class DateUtils implements DateDef {
    private static final SimpleDateFormat DAY_FORMAT = null;
    public static final String PATTERN_DAY = "MM-dd HH:mm";
    public static final String PATTERN_HOUR = "HH:mm:ss";
    public static final String PATTERN_YEAR = "yyyy-MM-dd";
    private static final SimpleDateFormat YEAR_FORMAT = null;

    static {
        YEAR_FORMAT = new SimpleDateFormat(PATTERN_YEAR);
        DAY_FORMAT = new SimpleDateFormat(PATTERN_DAY);
    }

    private DateUtils() {
    }

    public static String getDateString(Context r3, long r4) {
        if (isCurrentYear(r4) == true) goto L7;
        return YEAR_FORMAT.format(Long.valueOf(r4));
    L7:
        if (android.text.format.DateUtils.isToday(r4) == false) goto L9;
        long r0 = System.currentTimeMillis() - r4;
        if (r0 < 3600000) goto L15;
        return r3.getString(R.string.hours_ago, new Object[]{Long.valueOf(r0 / 3600000)});
    L15:
        if (r0 < 60000) goto L19;
        return r3.getString(R.string.minutes_ago, new Object[]{Long.valueOf(r0 / 60000)});
    L19:
        return r3.getString(R.string.just_now);
    L9:
        return DAY_FORMAT.format(Long.valueOf(r4));
    }

    public static boolean isCurrentYear(long r3) {
        Calendar r0 = Calendar.getInstance();
        r0.setTimeInMillis(r3);
        int r4 = r0.get(1);
        r0.setTimeInMillis(System.currentTimeMillis());
        if (r4 == r0.get(1)) goto L7;
        return false;
    L7:
        return true;
    }

    public static String timestampToDate(long r1, String r3) {
        r3.getClass();
        if (r3.equals(PATTERN_DAY) == false) goto L5;
        SimpleDateFormat r0 = DAY_FORMAT;
    L10:
        return r0.format(new Date(r1));
    L5:
        if (r3.equals(PATTERN_YEAR) == true) goto L7;
        r0 = new SimpleDateFormat(r3);
        goto L10
    L7:
        r0 = YEAR_FORMAT;
        goto L10
    }
}
