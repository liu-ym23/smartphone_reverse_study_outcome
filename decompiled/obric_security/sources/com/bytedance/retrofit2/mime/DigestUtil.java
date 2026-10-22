package com.bytedance.retrofit2.mime;

import java.io.InputStream;
import java.security.MessageDigest;
import tmsdk.common.tcc.DeepCleanSAFEngine;

/* JADX INFO: loaded from: classes.dex */
public class DigestUtil {
    private static final char[] DIGITS_UPPER = null;
    private static final int STREAM_BUFFER_LENGTH = 1024;

    public DigestUtil() {
    }

    static {
        DIGITS_UPPER = new char[]{DeepCleanSAFEngine.DetailPath.KEY, DeepCleanSAFEngine.DetailPath.DETAIL_PATH, DeepCleanSAFEngine.DetailPath.FILENAME, DeepCleanSAFEngine.DetailPath.FILESIZE, DeepCleanSAFEngine.DetailPath.CTIME, DeepCleanSAFEngine.DetailPath.MTIME, DeepCleanSAFEngine.DetailPath.ATIME, DeepCleanSAFEngine.DetailPath.IMPORTANT, '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    private static char[] encodeHex(byte[] r8) {
        int r0 = r8.length;
        char[] r1 = new char[r0 << 1];
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L5;
        int r4 = r3 + 1;
        char[] r5 = DIGITS_UPPER;
        byte r6 = r8[r2];
        r1[r3] = r5[(r6 & 240) >>> 4];
        r3 = r4 + 1;
        r1[r4] = r5[r6 & 15];
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public static String md5Hex(byte[] r2) {
        return new String(encodeHex(MessageDigest.getInstance("MD5").digest(r2)));
    L4:
        return null;
    }

    public static String md5Hex(InputStream r6) {
        MessageDigest r0 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L8
        byte[] r2 = new byte[1024];     // Catch: Throwable -> L8
        int r4 = r6.read(r2, 0, 1024);     // Catch: Throwable -> L8
    L4:
        if (r4 <= (-1)) goto L6;
        r0.update(r2, 0, r4);     // Catch: Throwable -> L8
        r4 = r6.read(r2, 0, 1024);     // Catch: Throwable -> L8
        goto L4
    L6:
        return new String(encodeHex(r0.digest()));
    L8:
        return null;
    }
}
