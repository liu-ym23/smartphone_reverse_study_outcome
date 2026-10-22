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

    public void hookService() throws Exception {
        if (this.hookServiceMap.size() != 0) goto L5;
        return;
    L5:
        Class<?> r0 = Class.forName("android.os.ServiceManager");
        Method r2 = r0.getDeclaredMethod("getService", new Class[]{String.class});
        Field r3 = r0.getDeclaredField("sCache");
        r3.setAccessible(true);
        Map r4 = (Map) r3.get(null);
        Iterator<Map.Entry<String, IHookService>> r12 = this.hookServiceMap.entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        Map.Entry<String, IHookService> r6 = r12.next();
        String r7 = r6.getKey();
        IHookService r8 = r6.getValue();
        IBinder r9 = (IBinder) r2.invoke(null, new Object[]{r7});
        BinderProxyHookHandler r11 = new BinderProxyHookHandler(r9, r8);
        IBinder r10 = (IBinder) Proxy.newProxyInstance(r0.getClassLoader(), new Class[]{IBinder.class}, r11);
        r11.setHook(r10);
        r4.put(r7, r10);
        goto L7
    }

    public void addHook(String r1, IHookService r2) {
        this.hookServiceMap.put(r1, r2);
    }
}
