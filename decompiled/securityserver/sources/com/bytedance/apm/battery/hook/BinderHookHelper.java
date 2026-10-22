package com.bytedance.apm.battery.hook;

import android.os.IBinder;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class BinderHookHelper {
    private Map<String, IHookService> hookServiceMap;

    public BinderHookHelper() {
        this.hookServiceMap = new HashMap();
    }

    public void addHook(String r1, IHookService r2) {
        this.hookServiceMap.put(r1, r2);
    }

    public void hookService() {
        if (this.hookServiceMap.size() != 0) goto L5;
        return;
    L5:
        Class<?> r0 = Class.forName("android.os.ServiceManager");
        Method r1 = r0.getDeclaredMethod("getService", new Class[]{String.class});
        Field r2 = r0.getDeclaredField("sCache");
        r2.setAccessible(true);
        Map r3 = (Map) r2.get(null);
        Iterator<Map.Entry<String, IHookService>> r10 = this.hookServiceMap.entrySet().iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        Map.Entry<String, IHookService> r4 = r10.next();
        String r5 = r4.getKey();
        IHookService r6 = r4.getValue();
        IBinder r7 = (IBinder) r1.invoke(null, new Object[]{r5});
        BinderProxyHookHandler r9 = new BinderProxyHookHandler(r7, r6);
        IBinder r8 = (IBinder) Proxy.newProxyInstance(r0.getClassLoader(), new Class[]{IBinder.class}, r9);
        r9.setHook(r8);
        r3.put(r5, r8);
        goto L7
    }
}
