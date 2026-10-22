package com.bytedance.watson.assist.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public class SystemProperties {
    private static Method sysPropGet;
    private static Method sysPropGetInt;
    private static Method sysPropGetLong;
    private static Method sysPropSet;

    static {
        Method[] r0 = Class.forName("android.os.SystemProperties").getMethods();     // Catch: ClassNotFoundException -> L17
        int r1 = r0.length;     // Catch: ClassNotFoundException -> L17
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L28;
        Method r3 = r0[r2];     // Catch: ClassNotFoundException -> L17
        String r4 = r3.getName();     // Catch: ClassNotFoundException -> L17
        if (r4.equals("get") == false) goto L8;
        sysPropGet = r3;     // Catch: ClassNotFoundException -> L17
    L16:
        r2 = r2 + 1;
        goto L3
    L8:
        if (r4.equals("set") == false) goto L11;
        sysPropSet = r3;     // Catch: ClassNotFoundException -> L17
        goto L16
    L11:
        if (r4.equals("getLong") == false) goto L14;
        sysPropGetLong = r3;     // Catch: ClassNotFoundException -> L17
        goto L16
    L14:
        if (r4.equals("getInt") == false) goto L16;
        sysPropGetInt = r3;     // Catch: ClassNotFoundException -> L17
        goto L16
    L28:
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
    }

    private SystemProperties() {
    }

    public static String get(String r3, String r4) {
        Method r0 = sysPropGet;
        if (r0 != null) goto L15;
        return r4;
    L15:
        return (String) r0.invoke(null, new Object[]{r3, r4});
    L10:
        e = move-exception;
        e.printStackTrace();
    L14:
        return r4;
    L12:
        e = move-exception;
        e.printStackTrace();
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public static long getLong(String r3, long r4) {
        Method r0 = sysPropGetLong;
        if (r0 != null) goto L15;
        return r4;
    L15:
        return ((Long) r0.invoke(null, new Object[]{r3, Long.valueOf(r4)})).longValue();
    L10:
        e = move-exception;
        e.printStackTrace();
    L14:
        return r4;
    L12:
        e = move-exception;
        e.printStackTrace();
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public static int getInt(String r3, int r4) {
        Method r0 = sysPropGetInt;
        if (r0 != null) goto L15;
        return r4;
    L15:
        return ((Integer) r0.invoke(null, new Object[]{r3, Integer.valueOf(r4)})).intValue();
    L10:
        e = move-exception;
        e.printStackTrace();
    L14:
        return r4;
    L12:
        e = move-exception;
        e.printStackTrace();
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public static void set(String r3, String r4) {
        sysPropSet.invoke(null, new Object[]{r3, r4});     // Catch: InvocationTargetException -> L4 IllegalAccessException -> L6 IllegalArgumentException -> L8
    L15:
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
