package com.bytedance.privacy.f;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static void a(String r1, String r2, int r3) {
        b(r1, r2);
        if (r2.length() > r3) goto L6;
        return;
    L6:
        throw new com.bytedance.privacy.c.a(r1 + " exceeds max length " + r3, -3);
    }

    public static void b(String r1, String r2) {
        c(r1, r2);
        if (r2.isEmpty() == true) goto L6;
        return;
    L6:
        throw new com.bytedance.privacy.c.a(r1 + " is empty", -3);
    }

    public static void c(String r1, Object r2) {
        if (r2 == null) goto L5;
        return;
    L5:
        throw new com.bytedance.privacy.c.a(r1 + " is null", -2);
    }
}
