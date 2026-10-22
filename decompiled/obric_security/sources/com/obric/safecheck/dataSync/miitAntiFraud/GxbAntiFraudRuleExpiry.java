package com.obric.safecheck.dataSync.miitAntiFraud;

import com.obric.safecheck.database.entity.GxbAntiFraudRuleItem;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public final class GxbAntiFraudRuleExpiry {
    private static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final int MILLIS_TIMESTAMP_LENGTH = 13;
    private static final int SECONDS_TIMESTAMP_LENGTH = 10;

    private GxbAntiFraudRuleExpiry() {
    }

    public static boolean isExpired(GxbAntiFraudRuleItem rule) {
        if (rule != null) goto L4;
    L6:
        return false;
    L4:
        if (isExpired(rule.getDisposeTime(), System.currentTimeMillis()) == false) goto L6;
        return true;
    }

    public static boolean isExpired(String disposeTime, long nowMillis) {
        Long r2 = parseDisposeTimeMillis(disposeTime);
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (nowMillis <= r2.longValue()) goto L7;
        return true;
    }

    public static Long parseDisposeTimeMillis(String disposeTime) {
        if (disposeTime != null) goto L5;
        return null;
    L5:
        String r4 = disposeTime.trim();
        if (r4.isEmpty() == false) goto L8;
        return null;
    L8:
        Long r1 = parseNumericTimestamp(r4);
        if (r1 == null) goto L14;
        return r1;
    L14:
        SimpleDateFormat r2 = new SimpleDateFormat(DATE_TIME_PATTERN, Locale.US);     // Catch: ParseException -> L13
        r2.setLenient(false);     // Catch: ParseException -> L13
        return Long.valueOf(r2.parse(r4).getTime());
    L13:
        return null;
    }

    private static Long parseNumericTimestamp(String value) {
        if (value.startsWith("-") == false) goto L5;
        String r0 = value.substring(1);
    L7:
        if (r0.isEmpty() == false) goto L9;
        return null;
    L9:
        int r1 = 0;
    L11:
        if (r1 < r0.length()) goto L13;
        long r3 = Long.parseLong(value);     // Catch: NumberFormatException -> L25
        if (r0.length() != 10) goto L21;
        return Long.valueOf(r3 * 1000);
    L21:
        if (r0.length() != 13) goto L24;
        return Long.valueOf(r3);
    L24:
        return null;
    L13:
        if (Character.isDigit(r0.charAt(r1)) == false) goto L14;
        r1 = r1 + 1;
        goto L11
    L14:
        return null;
    L5:
        r0 = value;
        goto L7
    }
}
