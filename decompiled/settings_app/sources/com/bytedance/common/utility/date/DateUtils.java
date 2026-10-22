package com.bytedance.common.utility.date;

import android.content.Context;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class DateUtils implements DateDef {
    private static final SimpleDateFormat DAY_FORMAT = null;
    private static final SimpleDateFormat YEAR_FORMAT = null;

    static {
        YEAR_FORMAT = new SimpleDateFormat(com.bytedance.android.standard.tools.date.DateUtils.PATTERN_YEAR);
        DAY_FORMAT = new SimpleDateFormat(com.bytedance.android.standard.tools.date.DateUtils.PATTERN_DAY);
    }

    private DateUtils() {
    }

    public static String getDateString(Context r0, long r1) {
        return com.bytedance.android.standard.tools.date.DateUtils.getDateString(r0, r1);
    }

    public static boolean isCurrentYear(long r0) {
        return com.bytedance.android.standard.tools.date.DateUtils.isCurrentYear(r0);
    }
}
