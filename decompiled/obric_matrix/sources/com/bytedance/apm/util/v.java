package com.bytedance.apm.util;

/* JADX INFO: loaded from: classes.dex */
public class v {
    public static String a(Object[] r3, char r4, int r5, int r6) {
        if (r3 != null) goto L5;
        return null;
    L5:
        int r0 = r6 - r5;
        if (r0 > 0) goto L9;
        return "";
    L9:
        StringBuilder r1 = new StringBuilder(r0 * 16);
        int r2 = r5;
    L10:
        if (r2 >= r6) goto L18;
        if (r2 <= r5) goto L14;
        r1.append(r4);
    L14:
        if (r3[r2] == null) goto L16;
        r1.append(r3[r2]);
    L16:
        r2 = r2 + 1;
        goto L10
    L18:
        return r1.toString();
    }
}
