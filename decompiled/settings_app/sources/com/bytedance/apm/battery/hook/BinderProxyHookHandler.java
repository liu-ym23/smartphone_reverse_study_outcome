package com.bytedance.apm.battery.hook;

import android.os.IBinder;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes3.dex */
public class BinderProxyHookHandler implements InvocationHandler {
    private static final String TAG = "BinderProxyHookHandler";
    IBinder base;
    IBinder hook;
    IHookService hookService;
    Class<?> iInterface;
    Class<?> stub;

    public BinderProxyHookHandler(IBinder r2, IHookService r3) {
        this.base = r2;
        this.hookService = r3;
        String r4 = r3.getInterfaceName();     // Catch: ClassNotFoundException -> L5
        this.stub = Class.forName(r4 + "$Stub");     // Catch: ClassNotFoundException -> L5
        this.iInterface = Class.forName(r4);     // Catch: ClassNotFoundException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public BinderProxyHookHandler setHook(IBinder r1) {
        this.hook = r1;
        return this;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object r4, Method r5, Object[] r6) throws Throwable {
        if ("queryLocalInterface".equals(r5.getName()) == false) goto L7;
        return Proxy.newProxyInstance(r4.getClass().getClassLoader(), new Class[]{this.iInterface}, new BinderHookHandler(this.base, this.stub, this.hookService, this.hook));
    L7:
        return r5.invoke(this.base, r6);
    }
}
