package com.bytedanceos.security.invokeHistory;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
public class InvokeHistoryUtils {
    public static final Comparator<InvokeHistoryActivity.InvokeRecord> NUMBER_COMPARATOR = null;
    public static final long ONE_DAY_MILLIS = 86400000;
    public static final Comparator<InvokeHistoryActivity.InvokeRecord> TIME_COMPARATOR = null;

    public InvokeHistoryUtils() {
    }

    public static long getBeginOfToday() {
        Date r0 = new Date();
        Calendar r1 = Calendar.getInstance();
        r1.setTimeZone(TimeZone.getDefault());
        r1.setTime(r0);
        r1.set(11, 0);
        r1.set(13, 1);
        r1.set(12, 0);
        r1.set(14, 0);
        return r1.getTimeInMillis();
    }

    static {
        TIME_COMPARATOR = new AnonymousClass1();
        NUMBER_COMPARATOR = new AnonymousClass2();
    }
}
