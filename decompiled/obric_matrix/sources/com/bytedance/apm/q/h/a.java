package com.bytedance.apm.q.h;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, b> f1741a;

    public a() {
        this.f1741a = new HashMap();
    }

    public void a(String r1, b r2) {
        this.f1741a.put(r1, r2);
    }

    public void b() {
        if (this.f1741a.size() != 0) goto L5;
        return;
    L5:
        Class<?> r0 = Class.forName("android.app.SystemServiceRegistry");
        Field r1 = r0.getDeclaredField("SYSTEM_SERVICE_FETCHERS");
        r1.setAccessible(true);
        Map r2 = (Map) r1.get(null);
        Iterator<Map.Entry<String, b>> r10 = this.f1741a.entrySet().iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        Map.Entry<String, b> r3 = r10.next();
        String r4 = r3.getKey();
        b r5 = r3.getValue();
        Object r6 = r2.get(r4);
        r2.put(r4, Proxy.newProxyInstance(r0.getClassLoader(), new Class[]{Class.forName("android.app.SystemServiceRegistry$ServiceFetcher")}, new c(r6, r5)));
        goto L7
    }
}
