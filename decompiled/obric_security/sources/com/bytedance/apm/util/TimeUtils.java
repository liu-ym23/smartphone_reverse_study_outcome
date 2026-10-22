package com.bytedance.apm.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class TimeUtils {
    public TimeUtils() {
    }

    public static long getYesterdayStart() {
        Date r0 = new Date();
        Calendar r1 = Calendar.getInstance();
        r1.setTime(r0);
        r1.add(5, -1);
        r1.set(11, 0);
        r1.set(12, 0);
        r1.set(13, 0);
        return r1.getTimeInMillis();
    }

    public static long getYesterdayEnd() {
        Date r0 = new Date();
        Calendar r1 = Calendar.getInstance();
        r1.setTime(r0);
        r1.add(5, -1);
        r1.set(11, 23);
        r1.set(12, 59);
        r1.set(13, 59);
        return r1.getTimeInMillis();
    }

    public static long getNDayAgoStart(int r2) {
        Date r0 = new Date();
        Calendar r1 = Calendar.getInstance();
        r1.setTime(r0);
        r1.add(5, -r2);
        r1.set(11, 23);
        r1.set(12, 59);
        r1.set(13, 59);
        return r1.getTimeInMillis();
    }

    public static String getCurrentFormatTime() {
        Date r0 = new Date(System.currentTimeMillis());
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(r0);
    }
}
