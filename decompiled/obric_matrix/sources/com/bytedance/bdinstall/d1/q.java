package com.bytedance.bdinstall.d1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final p f2741a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, Object> f2742b = null;

    static {
        f2741a = new p();
        f2742b = new ConcurrentHashMap();
    }

    public static Object a(String r2) {
        Map<String, Object> r0 = f2742b;
        Object r1 = r0.get(r2);
        if (r1 == null) goto L5;
        return r1;
    L5:
        String r3 = f2741a.a(r2);
        if (r3 == null) goto L8;
        r0.put(r2, r3);
    L8:
        return r3;
    }
}
