package com.bytedance.common.utility;

import android.content.Context;
import android.content.pm.Signature;
import android.util.DisplayMetrics;
import java.io.File;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public final class SignUtils {
    private static final int POS_0 = 0;
    private static final int POS_1 = 1;
    private static final int POS_2 = 2;
    private static final int POS_3 = 3;
    private static final int POS_NUM = 4;

    private SignUtils() {
    }

    public static boolean checkSignature(Context r8, String r9) {
        Signature[] r10 = getApkSignatures(r8, r9);
        if (r10 != null) goto L5;
        return true;
    L5:
        Signature[] r11 = getAppSignatures(r8);
        if (r11 != null) goto L8;
        return true;
    L8:
        int r1 = r11.length;
        int r3 = 0;
    L9:
        if (r3 >= r1) goto L17;
        Signature r4 = r11[r3];
        int r5 = r10.length;
        int r6 = 0;
    L11:
        if (r6 >= r5) goto L16;
        if (r4.equals(r10[r6]) == true) goto L14;
        r6 = r6 + 1;
        goto L11
    L14:
        return true;
    L16:
        r3 = r3 + 1;
        goto L9
    L17:
        return false;
    }

    public static Signature[] getAppSignatures(Context r2) {
        return r2.getPackageManager().getPackageInfo(r2.getPackageName(), 64).signatures;
    L4:
        e = move-exception;
        Logger.w("SignUtils", "failed to get package signatures: " + e);
        return null;
    }

    public static Signature[] getApkSignatures(Context r2, String r3) {
        Signature[] r4 = r2.getPackageManager().getPackageArchiveInfo(r3, 64).signatures;     // Catch: Exception -> L4
    L6:
        if (r4 == null) goto L8;
        return r4;
    L8:
        return getApkSignaturesCompatible(r3);
    L4:
        e = move-exception;
        Logger.w("SignUtils", "failed to get package signatures: " + e);
        r4 = null;
        goto L6
    }

    public static byte[] getApkSignature(String r3) {
        Signature[] r4 = getApkSignaturesCompatible(r3);     // Catch: Exception -> L8
        if (r4 != null) goto L6;
        return null;
    L6:
        return r4[0].toByteArray();
    L8:
        e = move-exception;
        Logger.w("SignUtils", "failed to get package signatures: " + e);
        return null;
    }

    private static Signature[] getApkSignaturesCompatible(String r8) {
        Class<?> r0 = Class.forName("android.content.pm.PackageParser");     // Catch: Throwable -> L5
        Class[] r2 = new Class[1];     // Catch: Throwable -> L5
        Object[] r3 = new Object[1];     // Catch: Throwable -> L5
        Object r4 = r0.newInstance();     // Catch: Throwable -> L5
        new DisplayMetrics().setToDefaults();     // Catch: Throwable -> L5
        Method r5 = r0.getDeclaredMethod("parsePackage", new Class[]{File.class, Integer.TYPE});     // Catch: Throwable -> L5
        r5.setAccessible(true);     // Catch: Throwable -> L5
        Object r6 = r5.invoke(r4, new Object[]{new File(r8), 64});     // Catch: Throwable -> L5
        r0.getDeclaredMethod("collectCertificates", new Class[]{r6.getClass(), Integer.TYPE}).invoke(r4, new Object[]{r6, 64});     // Catch: Throwable -> L5
        return (Signature[]) r6.getClass().getDeclaredField("mSignatures").get(r6);
    L5:
        th = move-exception;
        th.printStackTrace();
        return null;
    }
}
