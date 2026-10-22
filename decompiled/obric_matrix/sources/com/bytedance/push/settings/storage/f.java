package com.bytedance.push.settings.storage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, e> f5514a;

    static {
        f5514a = new ConcurrentHashMap();
        b(new a());
    }

    public static e a(String r1) {
        return f5514a.get(r1);
    }

    public static void b(e r2) {
        f5514a.put(r2.a(), r2);
    }
}
