package com.bytedance.monitor.collector;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f5222a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f5223b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f5224c = false;

    static {
    }

    public static String a(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L8;
        int r0 = r2.indexOf("at ") + 3;
        int r1 = r2.indexOf(40);
        if (r0 < r1) goto L7;
        return "unknownMethodName";
    L7:
        return r2.substring(r0, r1);
    L8:
        return "unknownMethodName";
    }

    public static String b(String r9) {
        if (TextUtils.isEmpty(r9) == false) goto L43;
        return "unknown message";
    L43:
        String[] r3 = r9.split(":");     // Catch: Throwable -> L40
        if (r3.length != 2) goto L10;
        String r4 = r3[1];     // Catch: Throwable -> L40
    L12:
        if (r9.contains("{") == true) goto L14;
    L17:
        String r5 = r9;
    L19:
        if (r9.contains("@") == false) goto L24;
        String[] r2 = r9.split("@");     // Catch: Throwable -> L38
        if (r2.length <= 1) goto L24;
        r9 = r2[0];     // Catch: Throwable -> L38
    L24:
        if (r9.contains("(") == false) goto L34;
        if (r9.contains(")") == false) goto L34;
        if (r9.endsWith(" null") == true) goto L34;
        String[] r6 = r9.split("\\(");     // Catch: Throwable -> L38
        if (r6.length <= 1) goto L32;
        r9 = r6[1];     // Catch: Throwable -> L38
    L32:
        r9 = r9.replace(")", "");     // Catch: Throwable -> L38
    L34:
        if (r9.startsWith(" ") == false) goto L36;
        r9 = r9.replace(" ", "");     // Catch: Throwable -> L38
    L36:
        return r9 + r4;
    L39:
        return r5;
    L14:
        if (r9.contains("}") == false) goto L17;
        r5 = r9.split("\\{")[0];     // Catch: Throwable -> L40
        r9 = r5 + r9.split("\\}")[1];     // Catch: Throwable -> L38
        goto L19
    L10:
        r4 = "";
    L45:
        return r9;
    }

    public static String c(StackTraceElement[] r7) {
        if (r7 != null) goto L5;
        return "Invalid Stack\n";
    L5:
        StringBuilder r0 = new StringBuilder();
        int r1 = r7.length;
        int r2 = 0;
        int r3 = 0;
    L6:
        if (r2 >= r1) goto L12;
        StackTraceElement r4 = r7[r2];
        r3 = r3 + 1;
        r0.append("\tat " + r4.getClassName());
        r0.append(".");
        r0.append(r4.getMethodName());
        r0.append("(");
        r0.append(r4.getFileName());
        r0.append(":");
        r0.append(r4.getLineNumber());
        r0.append(")\n");
        if (r3 > 40) goto L12;
        r2 = r2 + 1;
    L12:
        return r0.toString();
    }

    public static String d(StackTraceElement[] r7) {
        if (r7 != null) goto L5;
        return "Invalid Stack\n";
    L5:
        StringBuilder r0 = new StringBuilder();
        int r1 = r7.length;
        int r2 = 0;
        int r3 = 0;
    L6:
        if (r2 >= r1) goto L12;
        StackTraceElement r4 = r7[r2];
        r3 = r3 + 1;
        r0.append("\\tat " + r4.getClassName());
        r0.append(".");
        r0.append(r4.getMethodName());
        r0.append("(");
        r0.append(r4.getFileName());
        r0.append(":");
        r0.append(r4.getLineNumber());
        r0.append(")\\n");
        if (r3 > 40) goto L12;
        r2 = r2 + 1;
    L12:
        return r0.toString();
    }
}
