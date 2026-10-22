package com.bytedance.apm.battery.hook;

import android.os.IBinder;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public class BinderHookHandler implements InvocationHandler {
    private static final String TAG = "BinderHookHandler";
    private Object base;
    private IHookService hookService;
    private IBinder mHooked;

    BinderHookHandler(IBinder r7, Class<?> r8, IHookService r9, IBinder r10) {
        this.mHooked = null;
        this.base = r8.getDeclaredMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{r7});     // Catch: Exception -> L5
        this.hookService = r9;     // Catch: Exception -> L5
        this.mHooked = r10;     // Catch: Exception -> L5
        return;
    }

    public void setHooked(IBinder r1) {
        this.mHooked = r1;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object r3, Method r4, Object[] r5) throws Throwable {
        if (this.mHooked != null) goto L5;
    L8:
        this.hookService.invoke(r3, r4, r5);
        return r4.invoke(this.base, r5);
    L5:
        if (r4.getName().equals("asBinder") == false) goto L8;
        return this.mHooked;
    }
}
