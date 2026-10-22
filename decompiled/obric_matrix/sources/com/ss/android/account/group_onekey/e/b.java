package com.ss.android.account.group_onekey.e;

import android.annotation.SuppressLint;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f11781a = null;

    static {
        f11781a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    @SuppressLint({"[ByDesign7.2]WeakEncryptionOrHashingAlgorithm"})
    public static String a(byte[] r7) {
        MessageDigest r0 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L8
        r0.update(r7);     // Catch: Exception -> L8
        byte[] r8 = r0.digest();     // Catch: Exception -> L8
        char[] r1 = new char[32];     // Catch: Exception -> L8
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= 16) goto L6;
        byte r4 = r8[r2];     // Catch: Exception -> L8
        int r5 = r3 + 1;     // Catch: Exception -> L8
        char[] r6 = f11781a;     // Catch: Exception -> L8
        r1[r3] = r6[(r4 >>> 4) & 15];     // Catch: Exception -> L8
        r3 = r5 + 1;     // Catch: Exception -> L8
        r1[r5] = r6[r4 & 15];     // Catch: Exception -> L8
        r2 = r2 + 1;     // Catch: Exception -> L8
        goto L4
    L6:
        return new String(r1);
    L8:
        return null;
    }
}
