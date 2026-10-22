package com.bytedance.privacy.f;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5371a = "e";

    static {
    }

    public static String a(byte[] r6) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r6.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L6;
        r0.append(String.format("%02x", new Object[]{Byte.valueOf(r6[r3])}));
        r3 = r3 + 1;
        goto L3
    L6:
        return r0.toString();
    }

    public static byte[] b(byte[] r0, String r1) {
        MessageDigest r2 = MessageDigest.getInstance(r1);     // Catch: Exception -> L4
        r2.update(r0);     // Catch: Exception -> L4
        return r2.digest();
    L4:
        b.b(f5371a, "SHA256 failed.");
        return new byte[0];
    }

    public static String c(String r1) {
        return a(b(r1.getBytes(StandardCharsets.UTF_8), "SHA-256"));
    }
}
