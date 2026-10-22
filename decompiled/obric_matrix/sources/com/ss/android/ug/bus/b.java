package com.ss.android.ug.bus;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<Class, a> f12326a;

    static {
        f12326a = new ConcurrentHashMap();
    }

    public static <T extends a> T a(Class<T> r1) {
        return (T) f12326a.get(r1);
    }

    public static <T extends a> void b(Class<T> r1, a r2) {
        if (r2 == null) goto L5;
        f12326a.put(r1, r2);
        return;
    }
}
