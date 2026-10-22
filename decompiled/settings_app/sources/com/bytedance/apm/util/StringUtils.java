package com.bytedance.apm.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class StringUtils {
    public StringUtils() {
    }

    public static String slurp(InputStream r4) throws IOException {
        char[] r0 = new char[8192];
        StringBuilder r1 = new StringBuilder();
        BufferedReader r2 = new BufferedReader(new InputStreamReader(r4));
    L3:
        int r5 = r2.read(r0);
        if (r5 < 0) goto L6;
        r1.append(r0, 0, r5);
        goto L3
    L6:
        return r1.toString();
    }

    public static String join(Set<String> r2, char r3) {
        if (r2 != null) goto L6;
        return "";
    L6:
        return join(r2.toArray(), r3, 0, r2.size());
    }

    public static String join(Object[] r3, char r4, int r5, int r6) {
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
        if (r2 <= r5) goto L13;
        r1.append(r4);
    L13:
        Object r7 = r3[r2];
        if (r7 == null) goto L16;
        r1.append(r7);
    L16:
        r2 = r2 + 1;
        goto L10
    L18:
        return r1.toString();
    }
}
