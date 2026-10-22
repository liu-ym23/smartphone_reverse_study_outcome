package com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject;

import com.bytedance.platform.godzilla.common.Logger;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class MethodProxy extends MethodDelegate implements InvocationHandler {
    private static final Map<String, MethodDelegate> METHOD_DELEGATE_MAP = null;
    protected static final Map<Class<?>, Class<?>> WRAPPER_PRIMITIVE_MAP = null;
    private boolean mCalled;
    protected HashMap<String, MethodDelegate> mDelegateMethods;
    protected boolean mEnable;
    protected Object mProxy;
    protected Object mTarget;

    static {
        METHOD_DELEGATE_MAP = new HashMap();
        HashMap r0 = new HashMap();
        WRAPPER_PRIMITIVE_MAP = r0;
        r0.put(Boolean.class, Boolean.TYPE);
        r0.put(Byte.class, Byte.TYPE);
        r0.put(Character.class, Character.TYPE);
        r0.put(Short.class, Short.TYPE);
        r0.put(Integer.class, Integer.TYPE);
        r0.put(Long.class, Long.TYPE);
        r0.put(Double.class, Double.TYPE);
        r0.put(Float.class, Float.TYPE);
    }

    public MethodProxy() {
        this.mDelegateMethods = new HashMap();
        this.mEnable = true;
    }

    public static void addMethodDelegate(String r1, MethodDelegate r2) {
        METHOD_DELEGATE_MAP.put(r1, r2);
    }

    private Object invokeResult(Method r1, Object r2) {
        if (r2 == null) goto L4;
        return r2;
    L4:
        Class<?> r0 = r1.getReturnType();
        if (r0 != null) goto L7;
        return null;
    L7:
        if (r0.isPrimitive() == true) goto L12;
        r0 = WRAPPER_PRIMITIVE_MAP.get(r0);
        if (r0 != null) goto L12;
        return null;
    L12:
        if (r0 != Boolean.TYPE) goto L16;
        return Boolean.FALSE;
    L16:
        if (r0 != Void.TYPE) goto L19;
        return new Object();
    L19:
        return 0;
    }

    @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodDelegate
    public Object afterInvoke(Object r2, Method r3, Object[] r4, Object r5) {
        MethodDelegate r0 = findMethodDelegate(r3.getName());
        if (r0 == null) goto L6;
        return r0.afterInvoke(r2, r3, r4, r5);
    L6:
        return super.afterInvoke(r2, r3, r4, r5);
    }

    @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodDelegate
    public Object beforeInvoke(Object r2, Method r3, Object[] r4) {
        MethodDelegate r0 = findMethodDelegate(r3.getName());
        if (r0 == null) goto L6;
        return r0.beforeInvoke(r2, r3, r4);
    L6:
        return super.beforeInvoke(r2, r3, r4);
    }

    public MethodDelegate findMethodDelegate(String r2) {
        MethodDelegate r0 = METHOD_DELEGATE_MAP.get(r2);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.mDelegateMethods.get(r2);
    }

    public Object getTarget() {
        return this.mTarget;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object r3, Method r4, Object[] r5) {
        if (this.mCalled == false) goto L31;
        if (r4.isAccessible() == true) goto L8;
        r4.setAccessible(true);
    L8:
        if (this.mEnable == false) goto L10;
        Object r6 = beforeInvoke(this.mTarget, r4, r5);     // Catch: Throwable -> L13
    L15:
        if (r6 == null) goto L36;
    L34:
        r6 = afterInvoke(this.mTarget, r4, r5, r6);     // Catch: Throwable -> L26
    L29:
        return invokeResult(r4, r6);
    L26:
        th = move-exception;
        Logger.e("afterInvokeError.", th.toString());
        goto L29
    L36:
        r6 = r4.invoke(this.mTarget, r5);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        if (isCatchInvokeThrowable(r4) == false) goto L23;
        Logger.e("MethodProxyError.", th.toString());
        goto L34
    L23:
        throw new RuntimeException(th);
    L13:
        th = move-exception;
        Logger.e("beforeInvoke", th.toString());
        r6 = null;
        goto L15
    L10:
        return r4.invoke(this.mTarget, r5);
    L31:
        throw new IllegalStateException("setTarget must be invoked before this invoke");
    }

    public boolean isCatchInvokeThrowable(Method r1) {
        return true;
    }

    public abstract void onInstall();

    public void setEnable(boolean r1) {
        this.mEnable = r1;
    }

    public void setProxy(Object r1) {
        this.mProxy = r1;
    }

    public void setTarget(Object r2) {
        this.mCalled = true;
        this.mTarget = r2;
    }
}
