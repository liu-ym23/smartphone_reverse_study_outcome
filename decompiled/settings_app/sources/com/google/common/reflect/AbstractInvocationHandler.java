package com.google.common.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractInvocationHandler implements InvocationHandler {
    private static final Object[] NO_ARGS = null;

    @CheckForNull
    protected abstract Object handleInvocation(Object r1, Method r2, Object[] r3) throws Throwable;

    public AbstractInvocationHandler() {
    }

    static {
        NO_ARGS = new Object[0];
    }

    @Override // java.lang.reflect.InvocationHandler
    @CheckForNull
    public final Object invoke(Object r5, Method r6, @CheckForNull Object[] r7) throws Throwable {
        if (r7 != null) goto L5;
        r7 = NO_ARGS;
    L5:
        if (r7.length == 0) goto L7;
    L10:
        boolean r1 = true;
        if (r7.length != 1) goto L32;
        if (r6.getName().equals("equals") == false) goto L32;
        if (r6.getParameterTypes()[0] != Object.class) goto L32;
        Object r8 = r7[0];
        if (r8 == null) goto L19;
        if (r5 != r8) goto L24;
        return true;
    L24:
        if (isProxyOfSameInterfaces(r8, r5.getClass()) == true) goto L26;
    L28:
        r1 = false;
    L30:
        return Boolean.valueOf(r1);
    L26:
        if (equals(Proxy.getInvocationHandler(r8)) == false) goto L28;
    L19:
        return false;
    L32:
        if (r7.length != 0) goto L38;
        if (r6.getName().equals("toString") == false) goto L38;
        return toString();
    L38:
        return handleInvocation(r5, r6, r7);
    L7:
        if (r6.getName().equals("hashCode") == false) goto L10;
        return Integer.valueOf(hashCode());
    }

    public boolean equals(@CheckForNull Object r1) {
        return super.equals(r1);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    private static boolean isProxyOfSameInterfaces(Object r1, Class<?> r2) {
        if (r2.isInstance(r1) == false) goto L5;
    L10:
        return true;
    L5:
        if (Proxy.isProxyClass(r1.getClass()) == true) goto L7;
    L9:
        return false;
    L7:
        if (Arrays.equals(r1.getClass().getInterfaces(), r2.getInterfaces()) == false) goto L9;
        goto L9
    }
}
