package com.ss.android.agilelogger.utils;

/* JADX INFO: loaded from: classes2.dex */
public class StringUtils {
    public StringUtils() {
    }

    public static boolean isEmpty(String r0) {
        if (r0 != null) goto L4;
        return true;
    L4:
        if (r0.length() == 0) goto L10;
        return false;
    L10:
        return true;
    }
}
