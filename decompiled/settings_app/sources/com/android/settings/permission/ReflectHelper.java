package com.android.settings.permission;

import com.obric.olog.OLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class ReflectHelper {
    private static final String TAG = "ReflectHelper";

    public ReflectHelper() {
    }

    public static Object newObject(String r1, Class[] r2, Object[] r3) {
        Class<?> r4 = Class.forName(r1);     // Catch: Throwable -> L10
        if (r3 != null) goto L5;
    L8:
        Object r5 = r4.newInstance();     // Catch: Throwable -> L10
    L13:
        return r5;
    L5:
        if (r3.length == 0) goto L8;
        r5 = r4.getDeclaredConstructor(r2).newInstance(r3);     // Catch: Throwable -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static Object invokeMethod(Object r3, String r4, Class[] r5, Object[] r6) {
        if (r3 == null) goto L22;
        if (r4 == null) goto L22;
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    L7:
        if ((r3 instanceof String) == false) goto L9;
        Method r7 = Class.forName((String) r3).getDeclaredMethod(r4, r5);     // Catch: Throwable -> L20
        Object r8 = null;
    L10:
        if (r7 != null) goto L12;
        return null;
    L12:
        if (r7.isAccessible() == true) goto L14;
        boolean r9 = true;
        r7.setAccessible(true);     // Catch: Throwable -> L20
    L15:
        Object r10 = r7.invoke(r8, r6);     // Catch: Throwable -> L20
        if (r9 == false) goto L19;
        r7.setAccessible(false);     // Catch: Throwable -> L20
    L19:
        return r10;
    L14:
        r9 = false;
        goto L15
    L9:
        Method r11 = r3.getClass().getDeclaredMethod(r4, r5);     // Catch: Throwable -> L20
        r8 = r3;
        r7 = r11;
    L22:
        return null;
    }

    public static Object invokeProxyMethod(String r3, String r4, Object r5, Class[] r6, Object[] r7) {
        if (r3 == null) goto L25;
        if (r4 == null) goto L25;
        Object r0 = null;
        int r1 = 0;
        Method r8 = Class.forName(r3).getDeclaredMethod(r4, r6);     // Catch: Throwable -> L15
        if (r8 != null) goto L8;
    L23:
        return r0;
    L8:
        if (r8.isAccessible() == true) goto L10;
        boolean r9 = true;
        r8.setAccessible(true);     // Catch: Throwable -> L15
    L11:
        r0 = r8.invoke(r5, r7);     // Catch: Throwable -> L15
        if (r9 == false) goto L23;
        r8.setAccessible(false);     // Catch: Throwable -> L15
        goto L23
    L10:
        r9 = false;
    L15:
        e = move-exception;
        StringBuilder r10 = new StringBuilder(e.toString());
        r10.append(":[");
    L18:
        if (r1 >= r7.length) goto L22;
        if (r1 <= 0) goto L21;
        r10.append(", ");
    L21:
        r10.append(r7[r1].toString());
        r1 = r1 + 1;
        goto L18
    L22:
        r10.append("]@");
        r10.append(r3);
        OLog.e(TAG, r10.toString());
    L25:
        throw new IllegalArgumentException("Object and Method must be supplied.");
    }

    public static Object getStaticVariable(String r3, String r4) {
        Object r0 = null;
        Field r5 = Class.forName(r3).getDeclaredField(r4);     // Catch: Throwable -> L13
        if (r5 != null) goto L6;
    L15:
        return r0;
    L6:
        if (r5.isAccessible() == true) goto L8;
        r5.setAccessible(true);     // Catch: Throwable -> L13
        boolean r6 = true;
    L9:
        r5.setAccessible(true);     // Catch: Throwable -> L13
        r0 = r5.get(null);     // Catch: Throwable -> L13
        if (r6 == false) goto L15;
        r5.setAccessible(false);     // Catch: Throwable -> L13
        goto L15
    L8:
        r6 = false;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    public static Object getVariable(Object r4, String r5) {
        Object r0 = null;
        Field r6 = r4.getClass().getDeclaredField(r5);     // Catch: Throwable -> L13
        if (r6 != null) goto L6;
    L15:
        return r0;
    L6:
        if (r6.isAccessible() == true) goto L8;
        r6.setAccessible(true);     // Catch: Throwable -> L13
        boolean r1 = true;
    L9:
        r6.setAccessible(true);     // Catch: Throwable -> L13
        r0 = r6.get(r4);     // Catch: Throwable -> L13
        if (r1 == false) goto L15;
        r6.setAccessible(false);     // Catch: Throwable -> L13
        goto L15
    L8:
        r1 = false;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }
}
