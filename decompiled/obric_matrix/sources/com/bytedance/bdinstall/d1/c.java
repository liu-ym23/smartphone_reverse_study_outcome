package com.bytedance.bdinstall.d1;

import java.security.MessageDigest;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f2730a = null;

    static {
        f2730a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static String a(byte[] r2) {
        if (r2 != null) goto L11;
    L9:
        return null;
    L11:
        if (r2.length == 0) goto L9;
        MessageDigest r1 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L10
        r1.update(r2);     // Catch: Exception -> L10
        return b(r1.digest());
    }

    public static String b(byte[] r2) {
        Objects.requireNonNull(r2, "bytes is null");
        return c(r2, 0, r2.length);
    }

    public static String c(byte[] r9, int r10, int r11) {
        Objects.requireNonNull(r9, "bytes is null");
        if (r10 < 0) goto L12;
        if ((r10 + r11) > r9.length) goto L12;
        int r0 = r11 * 2;
        char[] r1 = new char[r0];
        int r3 = 0;
        int r4 = 0;
    L7:
        if (r3 >= r11) goto L10;
        int r5 = r9[r3 + r10] & 255;
        int r6 = r4 + 1;
        char[] r7 = f2730a;
        r1[r4] = r7[r5 >> 4];
        r4 = r6 + 1;
        r1[r6] = r7[r5 & 15];
        r3 = r3 + 1;
        goto L7
    L10:
        return new String(r1, 0, r0);
    L12:
        throw new IndexOutOfBoundsException();
    }
}
