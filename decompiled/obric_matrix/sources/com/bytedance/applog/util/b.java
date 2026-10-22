package com.bytedance.applog.util;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static SimpleDateFormat a() {
        return b("yyyy-MM-dd");
    }

    public static SimpleDateFormat b(String r2) {
        SimpleDateFormat r0 = new SimpleDateFormat(r2, Locale.US);
        r0.setTimeZone(TimeZone.getTimeZone("UTC+8"));
        return r0;
    }
}
