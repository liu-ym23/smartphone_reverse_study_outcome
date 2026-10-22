package com.ss.android.larksso;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f12046a = null;

    static {
        f12046a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static List<String> a(Context r3, String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L14;
        return null;
    L14:
        PackageInfo r5 = r3.getPackageManager().getPackageInfo(r4, 64);     // Catch: PackageManager.NameNotFoundException -> L13
        ArrayList r6 = new ArrayList();
        Signature[] r7 = r5.signatures;
        if (r7 == null) goto L12;
        int r0 = r7.length;
        int r1 = 0;
    L9:
        if (r1 >= r0) goto L11;
        r6.add(b(r7[r1].toByteArray()));
        r1 = r1 + 1;
        goto L9
    L11:
        return r6;
    L12:
        return null;
    }

    public static String b(byte[] r7) {
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
        char[] r6 = f12046a;     // Catch: Exception -> L8
        r1[r3] = r6[(r4 >>> 4) & 15];     // Catch: Exception -> L8
        r3 = r5 + 1;     // Catch: Exception -> L8
        r1[r5] = r6[r4 & 15];     // Catch: Exception -> L8
        r2 = r2 + 1;     // Catch: Exception -> L8
        goto L4
    L6:
        return new String(r1);
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static boolean c(Context r2, String r3, String r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
    L19:
        return false;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L19;
        if (r2 == null) goto L19;
        List<String> r5 = a(r2, r3);
        if (r5 == null) goto L19;
        if (r5.size() <= 0) goto L19;
        Iterator<String> r6 = r5.iterator();
    L14:
        if (r6.hasNext() == false) goto L19;
        if (r4.equalsIgnoreCase(r6.next()) == false) goto L14;
        return true;
    }
}
