package com.bytedance.apm.battery.hook;

import android.text.TextUtils;
import com.bytedance.apm.battery.config.Constants;
import com.bytedance.apm.logging.ApmAlogHelper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes3.dex */
public class ServiceFetcherProxyHandler implements InvocationHandler {
    private Object cachedServiceFetcher;
    private IHookService hookServiceImpl;

    static /* synthetic */ IHookService access$000(ServiceFetcherProxyHandler r0) {
        return r0.hookServiceImpl;
    }

    public ServiceFetcherProxyHandler(Object r1, IHookService r2) {
        this.cachedServiceFetcher = r1;
        this.hookServiceImpl = r2;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object r7, Method r8, Object[] r9) throws Throwable {
    L11:
        th = move-exception;
        ApmAlogHelper.e(Constants.TAG_BATTERY, "ServiceFetcher getService hook failed: " + th.getMessage());
    L14:
        return r8.invoke(this.cachedServiceFetcher, r9);
    L3:
        if ("getService".equals(r8.getName()) == false) goto L14;
        Object r10 = r8.invoke(this.cachedServiceFetcher, r9);     // Catch: Throwable -> L11
        Field r0 = r10.getClass().getDeclaredField("mService");     // Catch: Throwable -> L11
        r0.setAccessible(true);     // Catch: Throwable -> L11
        final Object r2 = r0.get(r10);     // Catch: Throwable -> L11
        String r3 = r2.getClass().getName();     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r3) == false) goto L7;
    L10:
        return r10;
    L7:
        if (r3.startsWith(this.hookServiceImpl.getInterfaceName()) == false) goto L10;
        r0.set(r10, Proxy.newProxyInstance(r2.getClass().getClassLoader(), new Class[]{Class.forName(this.hookServiceImpl.getInterfaceName())}, new AnonymousClass1(this, r2)));     // Catch: Throwable -> L11
        goto L10
    }
}
