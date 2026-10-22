package com.bytedance.privacy.pseudoid;

import com.bytedance.privacy.f.e;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static String a(String r1, String r2, String r3) {
        String r4 = r1 + "_" + r2 + r3;
        if (com.bytedance.privacy.e.b.a().c() == true) goto L5;
        return r4;
    L5:
        return r4 + "_boe";
    }

    public static String b(String r1, String r2) {
        return e.c(a(r1, r2, "_did"));
    }

    public static String c(String r1, String r2) {
        return e.c(a(r1, r2, "_rpdid"));
    }

    public static String d(String r1, String r2) {
        return e.c(a(r1, r2, "_rpuid"));
    }
}
