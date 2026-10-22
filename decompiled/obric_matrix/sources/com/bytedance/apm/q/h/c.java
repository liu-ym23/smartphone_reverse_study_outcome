package com.bytedance.apm.q.h;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes.dex */
public class c implements InvocationHandler {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object f1742f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b f1743g;

    class a implements InvocationHandler {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object f1744f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ c f1745g;

        a(c r1, Object r2) {
            this.f1745g = r1;
            this.f1744f = r2;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r3, Method r4, Object[] r5) {
            c.a(this.f1745g).invoke(r3, r4, r5);     // Catch: Throwable -> L4
        L7:
            return r4.invoke(this.f1744f, r5);
        L4:
            th = move-exception;
            com.bytedance.apm.x.a.a("APM-Battery", "hookServiceImpl invoke failed: " + th.getMessage());
            goto L7
        }
    }

    public c(Object r1, b r2) {
        this.f1742f = r1;
        this.f1743g = r2;
    }

    static /* synthetic */ b a(c r0) {
        return r0.f1743g;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object r7, Method r8, Object[] r9) {
    L11:
        th = move-exception;
        com.bytedance.apm.x.a.a("APM-Battery", "ServiceFetcher getService hook failed: " + th.getMessage());
    L14:
        return r8.invoke(this.f1742f, r9);
    L3:
        if ("getService".equals(r8.getName()) == false) goto L14;
        Object r10 = r8.invoke(this.f1742f, r9);     // Catch: Throwable -> L11
        Field r0 = r10.getClass().getDeclaredField("mService");     // Catch: Throwable -> L11
        r0.setAccessible(true);     // Catch: Throwable -> L11
        Object r2 = r0.get(r10);     // Catch: Throwable -> L11
        String r3 = r2.getClass().getName();     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r3) == false) goto L7;
    L10:
        return r10;
    L7:
        if (r3.startsWith(this.f1743g.c()) == false) goto L10;
        r0.set(r10, Proxy.newProxyInstance(r2.getClass().getClassLoader(), new Class[]{Class.forName(this.f1743g.c())}, new a(this, r2)));     // Catch: Throwable -> L11
        goto L10
    }
}
