package com.bytedanceos.security.reflect;

import bytedanceos.util.LogTag;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class ReflectHelper {
    private static final String LOGTAG = "ReflectHelper";

    public ReflectHelper() {
    }

    public static Object newObject(String className, Class[] argTypes, Object[] args) {
        Class<?> r1 = Class.forName(className);     // Catch: Exception -> L10
        if (args != null) goto L5;
    L8:
        Object r2 = r1.newInstance();     // Catch: Exception -> L10
    L12:
        return r2;
    L5:
        if (args.length == 0) goto L8;
        r2 = r1.getDeclaredConstructor(argTypes).newInstance(args);     // Catch: Exception -> L10
    L10:
        return null;
    }

    public static Object invokeMethod(Object obj, String method, Class[] argTypes, Object[] args) {
        if (obj == null) goto L23;
        if (method == null) goto L25;
        if ((obj instanceof String) == false) goto L9;
        Method r3 = Class.forName((String) obj).getDeclaredMethod(method, argTypes);     // Catch: Exception -> L20
        Object r4 = null;
    L10:
        if (r3 != null) goto L12;
        return null;
    L12:
        if (r3.isAccessible() == true) goto L14;
        boolean r5 = true;
        r3.setAccessible(true);     // Catch: Exception -> L20
    L15:
        Object r6 = r3.invoke(r4, args);     // Catch: Exception -> L20
        if (r5 == false) goto L19;
        r3.setAccessible(false);     // Catch: Exception -> L20
    L19:
        return r6;
    L14:
        r5 = false;
        goto L15
    L9:
        Method r7 = obj.getClass().getDeclaredMethod(method, argTypes);     // Catch: Exception -> L20
        r4 = obj;
        r3 = r7;
    L26:
        return null;
    L25:
        return null;
    L23:
        return null;
    }

    public static Object invokeProxyMethod(String proxyClassName, String method, Object obj, Class[] proxyArgTypes, Object[] args) {
        if (proxyClassName == null) goto L27;
        if (method == null) goto L27;
        Object r0 = null;
        int r1 = 0;
        Method r4 = Class.forName(proxyClassName).getDeclaredMethod(method, proxyArgTypes);     // Catch: Exception -> L15
        if (r4 != null) goto L8;
    L25:
        return r0;
    L8:
        if (r4.isAccessible() == true) goto L10;
        boolean r6 = true;
        r4.setAccessible(true);     // Catch: Exception -> L15
    L11:
        r0 = r4.invoke(obj, args);     // Catch: Exception -> L15
        if (r6 == false) goto L25;
        r4.setAccessible(false);     // Catch: Exception -> L15
        goto L25
    L10:
        r6 = false;
    L15:
        e = move-exception;
        StringBuilder r5 = new StringBuilder(e.toString());
        r5.append(":[");
    L18:
        if (r1 >= args.length) goto L22;
        if (r1 <= 0) goto L21;
        r5.append(", ");
    L21:
        r5.append(args[r1].toString());
        r1 = r1 + 1;
        goto L18
    L22:
        r5.append("]@");
        r5.append(proxyClassName);
        LogTag.e(LOGTAG, r5.toString());
        if ((e instanceof InvocationTargetException) == false) goto L25;
        LogTag.e(LOGTAG, "Target exception", ((InvocationTargetException) e).getTargetException());
    L27:
        throw new IllegalArgumentException("Object and Method must be supplied.");
    }

    public static Object getStaticVariable(String className, String fieldName) {
        Object r0 = null;
        Field r3 = Class.forName(className).getDeclaredField(fieldName);     // Catch: Exception -> L13
        if (r3 == null) goto L12;
        if (r3.isAccessible() == true) goto L8;
        r3.setAccessible(true);     // Catch: Exception -> L13
        boolean r4 = true;
    L9:
        r3.setAccessible(true);     // Catch: Exception -> L13
        r0 = r3.get(null);     // Catch: Exception -> L13
        if (r4 == false) goto L12;
        r3.setAccessible(false);     // Catch: Exception -> L13
        goto L12
    L8:
        r4 = false;
    L12:
        return r0;
    }

    public static Object getVariable(Object obj, String fieldName) {
        Object r0 = null;
        Field r5 = obj.getClass().getDeclaredField(fieldName);     // Catch: Exception -> L13
        if (r5 == null) goto L12;
        if (r5.isAccessible() == true) goto L8;
        r5.setAccessible(true);     // Catch: Exception -> L13
        boolean r1 = true;
    L9:
        r5.setAccessible(true);     // Catch: Exception -> L13
        r0 = r5.get(obj);     // Catch: Exception -> L13
        if (r1 == false) goto L12;
        r5.setAccessible(false);     // Catch: Exception -> L13
        goto L12
    L8:
        r1 = false;
    L12:
        return r0;
    }

    public static void setForceHideKeyguard() {
        Object r0 = Class.forName("android.app.ActivityManager").getMethod("getService", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L4
        r0.getClass().getMethod("setForceHideKeyguard", new Class[]{Long.TYPE}).invoke(r0, new Object[]{1200});     // Catch: Exception -> L4
        return;
    }
}
