package com.ss.android.m.a.a;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes2.dex */
class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Field f12178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Field f12179b;

    l() {
    }

    static Object a(Object r3) {
    L16:
        e = move-exception;
        e.printStackTrace();
        return null;
    L3:
        if (f12178a != null) goto L15;
        monitor-enter(l.class);     // Catch: Exception -> L16
    L11:
        th = move-exception;
        throw th;     // Catch: Exception -> L16
    L7:
        if (f12178a != null) goto L9;
        f12178a = r3.getClass().getDeclaredField("callable");     // Catch: Throwable -> L11
        f12178a.setAccessible(true);     // Catch: Throwable -> L11
    L9:
        monitor-exit(l.class);     // Catch: Throwable -> L11
    L15:
        return f12178a.get(r3);
    }

    static Object b(Object r3) {
    L16:
        e = move-exception;
        e.printStackTrace();
        return null;
    L3:
        if (f12179b != null) goto L15;
        monitor-enter(l.class);     // Catch: Exception -> L16
    L11:
        th = move-exception;
        throw th;     // Catch: Exception -> L16
    L7:
        if (f12179b != null) goto L9;
        f12179b = r3.getClass().getDeclaredField("task");     // Catch: Throwable -> L11
        f12179b.setAccessible(true);     // Catch: Throwable -> L11
    L9:
        monitor-exit(l.class);     // Catch: Throwable -> L11
    L15:
        return f12179b.get(r3);
    }

    static String c(StackTraceElement[] r5) {
        if (r5 != null) goto L4;
        return "";
    L4:
        if (r5.length <= 0) goto L18;
        StringBuilder r0 = new StringBuilder();
        int r1 = r5.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L12;
        StackTraceElement r3 = r5[r2];
        if (g(r3) == true) goto L10;
        r0.append("\tat ");
        r0.append(r3.getClassName());
        r0.append(".");
        r0.append(r3.getMethodName());
        r0.append("(");
        r0.append(r3.getFileName());
        r0.append(":");
        r0.append(r3.getLineNumber());
        r0.append(")\n");
    L10:
        r2 = r2 + 1;
        goto L6
    L12:
        return r0.toString();
    L18:
        return "";
    }

    static String d(Object r9) {
        if (h(r9) == false) goto L8;
        Object r0 = a(r9);
        if (r0 == null) goto L8;
        r9 = r0;
    L8:
        if (i(r9) == false) goto L12;
        Object r1 = b(r9);
        if (r1 == null) goto L12;
        r9 = r1;
    L12:
        StringBuilder r2 = new StringBuilder();
        if (f(r9.getClass()) == true) goto L18;
        String r3 = r9.toString();
        int r5 = r3.indexOf("@");
        if (r5 <= 0) goto L17;
        r3 = r3.substring(0, r5);
    L17:
        r2.append(r3);
        r2.append(",");
    L18:
        Field[] r4 = r9.getClass().getDeclaredFields();
        int r6 = r4.length;     // Catch: Exception -> L30
        int r7 = 0;
    L20:
        if (r7 >= r6) goto L33;
        Field r8 = r4[r7];     // Catch: Exception -> L30
        r8.setAccessible(true);     // Catch: Exception -> L30
        Object r10 = r8.get(r9);     // Catch: Exception -> L30
        if (r10 == null) goto L29;
        Class<?> r11 = r10.getClass();     // Catch: Exception -> L30
        if (f(r11) == true) goto L29;
        String r12 = r11.getName();     // Catch: Exception -> L30
        int r13 = r12.indexOf("@");     // Catch: Exception -> L30
        if (r13 <= 0) goto L28;
        r12 = r12.substring(0, r13);     // Catch: Exception -> L30
    L28:
        r2.append(r12);     // Catch: Exception -> L30
        r2.append(",");     // Catch: Exception -> L30
    L29:
        r7 = r7 + 1;
    L33:
        return r2.toString().replaceAll("class ", "");
    L30:
        e = move-exception;
        e.printStackTrace();
        goto L33
    }

    static String e(Throwable r2) {
        if (r2 == null) goto L10;
        StringWriter r0 = new StringWriter();
        PrintWriter r1 = new PrintWriter(r0);
        r2.printStackTrace(r1);     // Catch: Throwable -> L7
        String r3 = r0.toString();     // Catch: Throwable -> L7
        r1.close();
        return r3;
    L7:
        th = move-exception;
        r1.close();
        throw th;
    L10:
        return "";
    }

    private static boolean f(Class r2) {
        String r0 = r2.getName();
        if ("java.lang.Integer".equals(r0) == false) goto L5;
    L32:
        return true;
    L5:
        if ("java.lang.Boolean".equals(r0) == true) goto L32;
        if ("java.lang.Long".equals(r0) == true) goto L32;
        if ("java.lang.Float".equals(r0) == true) goto L32;
        if ("java.lang.Double".equals(r0) == true) goto L32;
        if ("java.lang.String".equals(r0) == true) goto L32;
        if ("sun.misc.Unsafe".equals(r0) == true) goto L32;
        if ("c.g".equals(r0) == true) goto L32;
        if ("java.util.ArrayList".equals(r0) == true) goto L32;
        if (r0.contains("android.os.Handler") == true) goto L32;
        if (r0.contains("com.bytedance.common.utility.collection.WeakHandler") == true) goto L32;
        if (r0.contains("java.util.concurrent.Executors$RunnableAdapter") == true) goto L32;
        if (r0.contains("bolts.Task") == true) goto L32;
        if (r2.isPrimitive() == true) goto L32;
        return false;
    }

    static boolean g(StackTraceElement r3) {
        if (r3 != null) goto L5;
        return true;
    L5:
        String r1 = r3.getClassName();
        if (r1.contains("libcore.io") == false) goto L8;
        return true;
    L8:
        if (r1.contains("com.tencent.matrix.iocanary") == false) goto L10;
        return true;
    L10:
        if (r1.contains("java.io") == false) goto L12;
        return true;
    L12:
        if (r1.contains("android.database.sqlite") == false) goto L14;
        return true;
    L14:
        if (r1.contains("android.database.AbstractCursor") == false) goto L16;
        return true;
    L16:
        if (r1.contains("dalvik.system") == false) goto L18;
        return true;
    L18:
        if (r1.contains("android.os") == false) goto L20;
        return true;
    L20:
        if (r1.contains("com.ss.android.ugc.conan") == false) goto L22;
        return true;
    L22:
        if (r1.contains("com.lody.whale") == true) goto L38;
        String r4 = r3.getMethodName();
        if (r4.equals("getThreadStackTrace") == false) goto L26;
        return true;
    L26:
        if (r4.equals("getStackTrace") == true) goto L40;
        return false;
    L40:
        return true;
    L38:
        return true;
    }

    static boolean h(Object r0) {
        return r0 instanceof FutureTask;
    }

    static boolean i(Object r1) {
        return "java.util.concurrent.Executors$RunnableAdapter".equals(r1.getClass().getName());
    }
}
