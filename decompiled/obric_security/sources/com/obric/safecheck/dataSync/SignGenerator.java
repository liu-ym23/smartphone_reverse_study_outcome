package com.obric.safecheck.dataSync;

import com.obric.safecheck.util.serviceutil.EncryptPhoneToMd5Kt;

/* JADX INFO: loaded from: classes4.dex */
public class SignGenerator {
    private static final String FIXED_PREFIX = "qgHFXDxGLGcCU";
    private static final String FIXED_SUFFIX = "qgHFXDxGLGcCU";

    public SignGenerator() {
    }

    public static String generateSignSource(String dateTime) {
        return "qgHFXDxGLGcCU" + String.format("date_time%s", new Object[]{dateTime}) + "qgHFXDxGLGcCU";
    }

    public static String generateFinalSign(String dateTime, boolean toUpperCase) {
        String r0 = EncryptPhoneToMd5Kt.calculateMD5(generateSignSource(dateTime));
        if (toUpperCase == true) goto L5;
        return r0;
    L5:
        return r0.toUpperCase();
    }
}
