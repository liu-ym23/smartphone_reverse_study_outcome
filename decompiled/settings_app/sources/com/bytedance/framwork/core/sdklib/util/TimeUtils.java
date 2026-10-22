package com.bytedance.framwork.core.sdklib.util;

import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
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
        return r1.getTimeInMillis() / 1000;
    }

    public static long getYesterdayEnd() {
        Date r0 = new Date();
        Calendar r1 = Calendar.getInstance();
        r1.setTime(r0);
        r1.add(5, -1);
        r1.set(11, 23);
        r1.set(12, 59);
        r1.set(13, 59);
        return r1.getTimeInMillis() / 1000;
    }

    public static long getNDayAgoStart(int r4) {
        Date r0 = new Date();
        Calendar r1 = Calendar.getInstance();
        r1.setTime(r0);
        r1.add(5, -r4);
        r1.set(11, 23);
        r1.set(12, 59);
        r1.set(13, 59);
        return r1.getTimeInMillis() / 1000;
    }
}
