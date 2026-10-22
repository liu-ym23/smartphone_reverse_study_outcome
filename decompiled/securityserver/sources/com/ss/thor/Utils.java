package com.ss.thor;

import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class Utils {
    private static final int FALSE = 2;
    private static final int TRUE = 1;
    private static final int UNKNOWN = 3;
    private static int isOppo = 3;
    private static int isSamsung = 3;
    private static int isSihi = 3;

    public Utils() {
    }

    public static boolean isOppo() {
        int r0 = isOppo;
        if (r0 == 3) goto L7;
        if (r0 == 1) goto L6;
        return false;
    L6:
        return true;
    L7:
        String r1 = Build.BRAND;
        if (TextUtils.isEmpty(r1) == false) goto L10;
    L12:
        int r2 = 2;
    L13:
        isOppo = r2;
        if (r2 == 1) goto L16;
        return false;
    L16:
        return true;
    L10:
        if (r1.toLowerCase().contains("oppo") == false) goto L12;
        r2 = 1;
        goto L13
    }

    public static boolean isSamsung() {
        int r0 = isSamsung;
        if (r0 == 3) goto L7;
        if (r0 == 1) goto L6;
        return false;
    L6:
        return true;
    L7:
        String r1 = Build.BRAND;
        if (TextUtils.isEmpty(r1) == false) goto L10;
    L12:
        int r2 = 2;
    L13:
        isSamsung = r2;
        if (r2 == 1) goto L16;
        return false;
    L16:
        return true;
    L10:
        if (r1.toLowerCase().contains("samsung") == false) goto L12;
        r2 = 1;
        goto L13
    }

    public static boolean isSihi() {
        int r0 = isSihi;
        if (r0 == 3) goto L7;
        if (r0 == 1) goto L6;
        return false;
    L6:
        return true;
    L7:
        String r1 = Build.HARDWARE;
        if (TextUtils.isEmpty(r1) == false) goto L10;
    L14:
        int r2 = 2;
    L15:
        isSihi = r2;
        if (r2 == 1) goto L18;
        return false;
    L18:
        return true;
    L10:
        if (r1.toLowerCase().contains("hi") == false) goto L12;
    L13:
        r2 = 1;
        goto L15
    L12:
        if (r1.toLowerCase().contains("kirin") == false) goto L14;
        goto L13
    }
}
