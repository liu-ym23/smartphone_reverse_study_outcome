package com.bytedance.privacy.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class PrivacyUtils {
    public static String a(String r5) {
        byte[] r6 = r5.getBytes(StandardCharsets.UTF_8);
        int r1 = 0;
        MessageDigest r0 = MessageDigest.getInstance("SHA-256");     // Catch: Exception -> L5
        r0.update(r6);     // Catch: Exception -> L5
        byte[] r7 = r0.digest();     // Catch: Exception -> L5
    L6:
        StringBuilder r2 = new StringBuilder();
        int r3 = r7.length;
    L7:
        if (r1 >= r3) goto L10;
        r2.append(String.format("%02x", new Object[]{Byte.valueOf(r7[r1])}));
        r1 = r1 + 1;
        goto L7
    L10:
        return r2.toString();
    L5:
        LogUtils.b("PrivacyUtils", "SHA256 failed.");
        r7 = new byte[0];
        goto L6
    }
}
