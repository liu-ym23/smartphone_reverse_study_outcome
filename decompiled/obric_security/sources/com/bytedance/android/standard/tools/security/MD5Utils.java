package com.bytedance.android.standard.tools.security;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import tmsdk.common.tcc.DeepCleanSAFEngine;

/* JADX INFO: loaded from: classes.dex */
public final class MD5Utils {
    protected static char[] sHexDigits;

    private MD5Utils() {
    }

    static {
        sHexDigits = new char[]{DeepCleanSAFEngine.DetailPath.KEY, DeepCleanSAFEngine.DetailPath.DETAIL_PATH, DeepCleanSAFEngine.DetailPath.FILENAME, DeepCleanSAFEngine.DetailPath.FILESIZE, DeepCleanSAFEngine.DetailPath.CTIME, DeepCleanSAFEngine.DetailPath.MTIME, DeepCleanSAFEngine.DetailPath.ATIME, DeepCleanSAFEngine.DetailPath.IMPORTANT, '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static String getMD5String(String r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return getMD5String(r0.getBytes());
    }

    public static String getMD5String(byte[] r5) {
        byte[] r6 = MessageDigest.getInstance("MD5").digest(r5);     // Catch: NoSuchAlgorithmException -> L8
        StringBuffer r0 = new StringBuffer();     // Catch: NoSuchAlgorithmException -> L8
        int r1 = 0;
    L4:
        if (r1 >= r6.length) goto L6;
        byte r2 = r6[r1];     // Catch: NoSuchAlgorithmException -> L8
        r0.append(sHexDigits[(r2 & 240) >> 4]);     // Catch: NoSuchAlgorithmException -> L8
        r0.append(sHexDigits[r2 & 15]);     // Catch: NoSuchAlgorithmException -> L8
        r1 = r1 + 1;     // Catch: NoSuchAlgorithmException -> L8
        goto L4
    L6:
        return r0.toString();
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String getFileMD5(File r7) {
        if (r7.isFile() == true) goto L5;
        return "";
    L5:
        byte[] r2 = new byte[1024];
        BufferedInputStream r3 = null;
        MessageDigest r4 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L19 Exception -> L21
        BufferedInputStream r5 = new BufferedInputStream(new FileInputStream(r7));     // Catch: Throwable -> L19 Exception -> L21
    L41:
        int r6 = r5.read(r2, 0, 1024);     // Catch: Throwable -> L15 Exception -> L17
        if (r6 == (-1)) goto L38;
        r4.update(r2, 0, r6);     // Catch: Throwable -> L15 Exception -> L17
    L38:
        r5.close();     // Catch: IOException -> L29
    L14:
        return byteArrayToHex(r4.digest());
    L17:
        e = e;
        r3 = r5;
    L22:
        e.printStackTrace();     // Catch: Throwable -> L19
        if (r3 != null) goto L32;
    L25:
        return "";
    L32:
        r3.close();     // Catch: IOException -> L31
    L15:
        th = th;
        r3 = r5;
    L26:
        if (r3 != null) goto L36;
    L28:
        throw th;
    L36:
        r3.close();     // Catch: IOException -> L30
    L21:
        e = e;
    L19:
        th = th;
        goto L26
    }

    public static String byteArrayToHex(byte[] r8) {
        if (r8 != null) goto L4;
        return "";
    L4:
        if (r8.length <= 0) goto L14;
        char[] r0 = {DeepCleanSAFEngine.DetailPath.KEY, DeepCleanSAFEngine.DetailPath.DETAIL_PATH, DeepCleanSAFEngine.DetailPath.FILENAME, DeepCleanSAFEngine.DetailPath.FILESIZE, DeepCleanSAFEngine.DetailPath.CTIME, DeepCleanSAFEngine.DetailPath.MTIME, DeepCleanSAFEngine.DetailPath.ATIME, DeepCleanSAFEngine.DetailPath.IMPORTANT, '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] r1 = new char[r8.length * 2];
        int r2 = r8.length;
        int r3 = 0;
        int r4 = 0;
    L7:
        if (r3 >= r2) goto L10;
        byte r5 = r8[r3];
        int r6 = r4 + 1;
        r1[r4] = r0[(r5 >>> 4) & 15];
        r4 = r6 + 1;
        r1[r6] = r0[r5 & 15];
        r3 = r3 + 1;
        goto L7
    L10:
        return new String(r1);
    L14:
        return "";
    }

    public static String getStrMD5(String r2) {
        return byteArrayToHex(MessageDigest.getInstance("MD5").digest(r2.getBytes("UTF-8")));
    L4:
        e = move-exception;
        e.printStackTrace();
        return "";
    }
}
