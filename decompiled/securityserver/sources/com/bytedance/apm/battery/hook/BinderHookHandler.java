package com.bytedance.apm.battery.hook;

import android.annotation.TargetApi;
import android.os.IBinder;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class BinderHookHandler implements InvocationHandler {
    private static final String TAG = "BinderHookHandler";
    private Object base;
    private IHookService hookService;
    private IBinder mHooked;

    public BinderHookHandler(IBinder r4, Class<?> r5, IHookService r6, IBinder r7) {
        this.mHooked = null;
        this.base = r5.getDeclaredMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{r4});     // Catch: Exception -> L5
        this.hookService = r6;     // Catch: Exception -> L5
        this.mHooked = r7;     // Catch: Exception -> L5
        return;
    }

    @Override // java.lang.reflect.InvocationHandler
    @TargetApi(11)
    public Object invoke(Object r3, Method r4, Object[] r5) {
        if (this.mHooked != null) goto L5;
    L8:
        this.hookService.invoke(r3, r4, r5);
        return r4.invoke(this.base, r5);
    L5:
        if (r4.getName().equals("asBinder") == false) goto L8;
        return this.mHooked;
    }

    public void setHooked(IBinder r1) {
        this.mHooked = r1;
    }
}
