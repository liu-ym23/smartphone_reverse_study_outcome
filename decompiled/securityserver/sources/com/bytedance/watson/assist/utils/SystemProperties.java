package com.bytedance.watson.assist.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class SystemProperties {
    private static Method sysPropGet;
    private static Method sysPropGetInt;
    private static Method sysPropGetLong;
    private static Method sysPropSet;

    static {
        Method[] r0 = Class.forName("android.os.SystemProperties").getMethods();     // Catch: ClassNotFoundException -> L7
        int r1 = r0.length;     // Catch: ClassNotFoundException -> L7
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L29;
        Method r3 = r0[r2];     // Catch: ClassNotFoundException -> L7
        String r4 = r3.getName();     // Catch: ClassNotFoundException -> L7
        if (r4.equals("get") == false) goto L10;
        sysPropGet = r3;     // Catch: ClassNotFoundException -> L7
    L18:
        r2 = r2 + 1;
        goto L3
    L10:
        if (r4.equals("set") == false) goto L13;
        sysPropSet = r3;     // Catch: ClassNotFoundException -> L7
        goto L18
    L13:
        if (r4.equals("getLong") == false) goto L16;
        sysPropGetLong = r3;     // Catch: ClassNotFoundException -> L7
        goto L18
    L16:
        if (r4.equals("getInt") == false) goto L18;
        sysPropGetInt = r3;     // Catch: ClassNotFoundException -> L7
        goto L18
    L29:
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    private SystemProperties() {
    }

    public static String get(String r2, String r3) {
        Method r0 = sysPropGet;
        if (r0 != null) goto L17;
        return r3;
    L17:
        return (String) r0.invoke(null, new Object[]{r2, r3});
    L9:
        e = move-exception;
        e.printStackTrace();
    L16:
        return r3;
    L11:
        e = move-exception;
        e.printStackTrace();
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    public static int getInt(String r2, int r3) {
        Method r0 = sysPropGetInt;
        if (r0 != null) goto L17;
        return r3;
    L17:
        return ((Integer) r0.invoke(null, new Object[]{r2, Integer.valueOf(r3)})).intValue();
    L9:
        e = move-exception;
        e.printStackTrace();
    L16:
        return r3;
    L11:
        e = move-exception;
        e.printStackTrace();
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    public static long getLong(String r2, long r3) {
        Method r0 = sysPropGetLong;
        if (r0 != null) goto L17;
        return r3;
    L17:
        return ((Long) r0.invoke(null, new Object[]{r2, Long.valueOf(r3)})).longValue();
    L9:
        e = move-exception;
        e.printStackTrace();
    L16:
        return r3;
    L11:
        e = move-exception;
        e.printStackTrace();
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    public static void set(String r1, String r2) {
        sysPropSet.invoke(null, new Object[]{r1, r2});     // Catch: InvocationTargetException -> L4 IllegalAccessException -> L6 IllegalArgumentException -> L8
    L18:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
