package com.bytedance.ttnet.retrofit;

import android.text.TextUtils;
import com.bytedance.android.standard.tools.date.DateUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class RequestDelayHelper {
    private static final String TAG = "RequestDelayHelper";
    private static final String ZERO_TIME_STRING = "00:00:00";

    public RequestDelayHelper() {
    }

    public static int getRandomDelayTime(int r3) {
        return new Random(UUID.randomUUID().hashCode()).nextInt(r3);
    }

    public static boolean isInDelayAPIList(String r3, Set<String> r4) {
        if (StringUtils.isEmpty(r3) == false) goto L5;
        return false;
    L5:
        if (r4 == null) goto L18;
        Iterator<String> r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L18;
        String r0 = r5.next();
        if (TextUtils.isEmpty(r0) == true) goto L8;
        if (r3.startsWith(r0) == false) goto L8;
        if (Logger.debug() == false) goto L25;
        Logger.d(TAG, "app delay, matched, rule is " + r0 + " request path is " + r3);
        return true;
    L25:
        return true;
    L18:
        return false;
    }

    public static boolean isInDelayTimeRange(String r8, String r9) {
        if (StringUtils.isEmpty(r8) == false) goto L5;
    L29:
        return false;
    L5:
        if (StringUtils.isEmpty(r9) == true) goto L29;
        SimpleDateFormat r1 = new SimpleDateFormat(DateUtils.PATTERN_HOUR);     // Catch: Throwable -> L14
        Date r10 = r1.parse(r8);     // Catch: Throwable -> L14
        Date r11 = r1.parse(r9);     // Catch: Throwable -> L14
        long r3 = System.currentTimeMillis();     // Catch: Throwable -> L14
        Date r5 = new Date(r3);     // Catch: Throwable -> L14
        r11.setDate(r5.getDate());     // Catch: Throwable -> L14
        r11.setMonth(r5.getMonth());     // Catch: Throwable -> L14
        r11.setYear(r5.getYear());     // Catch: Throwable -> L14
        r10.setDate(r5.getDate());     // Catch: Throwable -> L14
        r10.setMonth(r5.getMonth());     // Catch: Throwable -> L14
        r10.setYear(r5.getYear());     // Catch: Throwable -> L14
        if (r10.before(r11) == true) goto L10;
        Date r6 = r1.parse(ZERO_TIME_STRING);     // Catch: Throwable -> L14
        Date r0 = r1.parse(ZERO_TIME_STRING);     // Catch: Throwable -> L14
        r0.setDate(r5.getDate());     // Catch: Throwable -> L14
        r0.setMonth(r5.getMonth());     // Catch: Throwable -> L14
        r0.setYear(r5.getYear());     // Catch: Throwable -> L14
        Calendar r2 = Calendar.getInstance();     // Catch: Throwable -> L14
        r2.setTime(r5);     // Catch: Throwable -> L14
        r2.add(5, 1);     // Catch: Throwable -> L14
        Date r4 = r2.getTime();     // Catch: Throwable -> L14
        r6.setDate(r4.getDate());     // Catch: Throwable -> L14
        r6.setMonth(r4.getMonth());     // Catch: Throwable -> L14
        r6.setYear(r4.getYear());     // Catch: Throwable -> L14
        if (r3 < r0.getTime()) goto L22;
        if (r3 > r11.getTime()) goto L22;
    L27:
        return true;
    L22:
        if (r3 >= r10.getTime()) goto L25;
        return false;
    L25:
        if (r3 < r6.getTime()) goto L27;
        return false;
    L10:
        if (r3 >= r10.getTime()) goto L12;
        return false;
    L12:
        if (r3 <= r11.getTime()) goto L32;
        return false;
    L32:
        return true;
    L14:
        th = move-exception;
        th.printStackTrace();
        goto L29
    }
}
