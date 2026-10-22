package com.bytedance.feedbackerlib.m;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f4291a = null;

    static {
        f4291a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    @Nullable
    public static String a(@NonNull Context r5) {
        PackageManager r0 = r5.getPackageManager();
        if (r0 != null) goto L25;
        return null;
    L25:
        int r2 = Build.VERSION.SDK_INT;     // Catch: PackageManager.NameNotFoundException -> L22
        if (r2 < 28) goto L8;
        PackageInfo r6 = r0.getPackageInfo(r5.getPackageName(), 134217728);     // Catch: PackageManager.NameNotFoundException -> L22
    L9:
        if (r2 < 28) goto L14;
        SigningInfo r7 = r6.signingInfo;     // Catch: PackageManager.NameNotFoundException -> L22
        if (r7 != null) goto L13;
        return null;
    L13:
        Signature[] r8 = r7.getSigningCertificateHistory();     // Catch: PackageManager.NameNotFoundException -> L22
    L15:
        if (r8 != null) goto L17;
    L21:
        return null;
    L17:
        if (r8.length <= 0) goto L21;
        return c(r8[0]);
    L14:
        r8 = r6.signatures;     // Catch: PackageManager.NameNotFoundException -> L22
        goto L15
    L8:
        r6 = r0.getPackageInfo(r5.getPackageName(), 64);     // Catch: PackageManager.NameNotFoundException -> L22
    L22:
        e = move-exception;
        c.a("MD5Utils", "getPackageInfo failed!", e);
        return null;
    }

    @Nullable
    public static String b(@NonNull InputStream r5) {
        MessageDigest r0 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L8
        byte[] r2 = new byte[8192];     // Catch: Exception -> L8
    L3:
        int r4 = r5.read(r2, 0, 8192);     // Catch: Exception -> L8
        if (r4 <= 0) goto L6;
        r0.update(r2, 0, r4);     // Catch: Exception -> L8
        goto L3
    L6:
        return e(r0.digest());
    L8:
        return null;
    }

    @Nullable
    public static String c(@NonNull Signature r3) {
        byte[] r4 = r3.toByteArray();
        byte[] r5 = MessageDigest.getInstance("MD5").digest(r4);     // Catch: NoSuchAlgorithmException -> L8
        if (r5 != null) goto L7;
        return null;
    L7:
        return d(r5);
    L8:
        e = move-exception;
        c.a("MD5Utils", "get MessageDigest instance failed!", e);
        return null;
    }

    @NonNull
    public static String d(@NonNull byte[] r10) {
        int r0 = r10.length;
        int r1 = (r0 * 3) - 1;
        char[] r2 = new char[r1];
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r4 >= r0) goto L9;
        int r6 = r10[r4] & 255;
        int r7 = r5 + 1;
        char[] r8 = f4291a;
        r2[r5] = r8[r6 >> 4];
        r5 = r7 + 1;
        r2[r7] = r8[r6 & 15];
        if (r5 >= r1) goto L7;
        r2[r5] = ':';
        r5 = r5 + 1;
    L7:
        r4 = r4 + 1;
        goto L3
    L9:
        return String.valueOf(r2, 0, r1);
    }

    @NonNull
    private static String e(@NonNull byte[] r2) {
        return f(r2, 0, r2.length);
    }

    @NonNull
    private static String f(@NonNull byte[] r9, int r10, int r11) {
        if (r10 < 0) goto L11;
        if ((r10 + r11) > r9.length) goto L11;
        int r0 = r11 * 2;
        char[] r1 = new char[r0];
        int r3 = 0;
        int r4 = 0;
    L6:
        if (r3 >= r11) goto L9;
        int r5 = r9[r10 + r3] & 255;
        int r6 = r4 + 1;
        char[] r7 = f4291a;
        r1[r4] = r7[r5 >> 4];
        r4 = r6 + 1;
        r1[r6] = r7[r5 & 15];
        r3 = r3 + 1;
        goto L6
    L9:
        return String.valueOf(r1, 0, r0);
    L11:
        throw new IndexOutOfBoundsException();
    }
}
