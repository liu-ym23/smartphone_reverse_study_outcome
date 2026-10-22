package com.bytedance.apm.g0.i;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashMap<String, Integer> f1595a;

    static {
        f1595a = new HashMap();
        a();
    }

    private static void a() {
        b("xx", 12334);
    }

    public static void b(String r1, int r2) {
        f1595a.put(r1, Integer.valueOf(r2));
    }

    public static Integer c(String r1) {
        return f1595a.get(r1);
    }
}
