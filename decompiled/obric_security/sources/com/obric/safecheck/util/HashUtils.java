package com.obric.safecheck.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.UByte;
import tmsdk.common.tcc.DeepCleanSAFEngine;

/* JADX INFO: loaded from: classes4.dex */
public class HashUtils {
    public HashUtils() {
    }

    public static String computeCombinedHashMd5(String pkg, String tmd5, String tsha1, String tsha256) {
        if (pkg != null) goto L6;
        pkg = "";
    L6:
        if (tmd5 != null) goto L9;
        tmd5 = "";
    L9:
        if (tsha1 != null) goto L12;
        tsha1 = "";
    L12:
        if (tsha256 != null) goto L26;
        tsha256 = "";
    L26:
        byte[] r3 = MessageDigest.getInstance("MD5").digest((pkg + "|||" + tmd5 + "|||" + tsha1 + "|||" + tsha256).getBytes(StandardCharsets.UTF_8));     // Catch: NoSuchAlgorithmException -> L24
        StringBuilder r4 = new StringBuilder();     // Catch: NoSuchAlgorithmException -> L24
        int r5 = r3.length;     // Catch: NoSuchAlgorithmException -> L24
        int r6 = 0;
    L17:
        if (r6 >= r5) goto L22;
        String r0 = Integer.toHexString(r3[r6] & UByte.MAX_VALUE);     // Catch: NoSuchAlgorithmException -> L24
        if (r0.length() != 1) goto L21;
        r4.append(DeepCleanSAFEngine.DetailPath.KEY);     // Catch: NoSuchAlgorithmException -> L24
    L21:
        r4.append(r0);     // Catch: NoSuchAlgorithmException -> L24
        r6 = r6 + 1;     // Catch: NoSuchAlgorithmException -> L24
        goto L17
    L22:
        return r4.toString();
    L24:
        return null;
    }
}
