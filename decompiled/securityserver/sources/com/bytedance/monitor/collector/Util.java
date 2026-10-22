package com.bytedance.monitor.collector;

import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;

/* JADX INFO: loaded from: classes.dex */
public class Util {
    private static final String INVALID_STACK = "Invalid Stack\n";
    public static boolean enable = false;
    public static boolean enableLooperObserver = false;

    private Util() {
    }

    public static String getTopMethodName(String r2) {
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

    public static String parseMessageKey(String r9) {
        if (TextUtils.isEmpty(r9) == false) goto L42;
        return "unknown message";
    L42:
        String[] r3 = r9.split(":");     // Catch: Throwable -> L39
        if (r3.length != 2) goto L10;
        String r4 = r3[1];     // Catch: Throwable -> L39
    L12:
        if (r9.contains("{") == true) goto L14;
    L18:
        String r5 = r9;
    L20:
        if (r9.contains("@") == false) goto L25;
        String[] r2 = r9.split("@");     // Catch: Throwable -> L17
        if (r2.length <= 1) goto L25;
        r9 = r2[0];     // Catch: Throwable -> L17
    L25:
        if (r9.contains("(") == false) goto L35;
        if (r9.contains(")") == false) goto L35;
        if (r9.endsWith(" null") == true) goto L35;
        String[] r6 = r9.split("\\(");     // Catch: Throwable -> L17
        if (r6.length <= 1) goto L33;
        r9 = r6[1];     // Catch: Throwable -> L17
    L33:
        r9 = r9.replace(")", "");     // Catch: Throwable -> L17
    L35:
        if (r9.startsWith(" ") == false) goto L37;
        r9 = r9.replace(" ", "");     // Catch: Throwable -> L17
    L37:
        return r9 + r4;
    L44:
        return r5;
    L14:
        if (r9.contains("}") == false) goto L18;
        r5 = r9.split("\\{")[0];     // Catch: Throwable -> L39
        r9 = r5 + r9.split("\\}")[1];     // Catch: Throwable -> L17
        goto L20
    L10:
        r4 = "";
    L45:
        return r9;
    }

    public static String stackToString(StackTraceElement[] r7) {
        if (r7 != null) goto L5;
        return INVALID_STACK;
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
        r0.append(LibrarianImpl.Constants.DOT);
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

    public static String stackToStringWithESC(StackTraceElement[] r7) {
        if (r7 != null) goto L5;
        return INVALID_STACK;
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
        r0.append(LibrarianImpl.Constants.DOT);
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

    public static String stackToString(StackTraceElement[] r8, String r9) {
        if (r8 != null) goto L5;
        return INVALID_STACK;
    L5:
        StringBuilder r0 = new StringBuilder();
        int r1 = r8.length;
        int r2 = 0;
        int r3 = 0;
        boolean r4 = false;
    L6:
        if (r2 >= r1) goto L17;
        StackTraceElement r5 = r8[r2];
        r3 = r3 + 1;
        if (r4 == false) goto L10;
        r0.append("at " + r5.getClassName());
        r0.append(LibrarianImpl.Constants.DOT);
        r0.append(r5.getMethodName());
        r0.append("(");
        r0.append(r5.getFileName());
        r0.append(":");
        r0.append(r5.getLineNumber());
        r0.append(")\n");
        if (r3 > 40) goto L17;
    L15:
        r2 = r2 + 1;
        goto L6
    L10:
        if (r5.getMethodName().equals(r9) == false) goto L15;
        r4 = true;
    L17:
        return r0.toString();
    }
}
