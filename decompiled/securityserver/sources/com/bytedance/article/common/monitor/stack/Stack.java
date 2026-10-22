package com.bytedance.article.common.monitor.stack;

import a.a;
import androidx.annotation.NonNull;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class Stack {
    private static final String CAUSE_CAPTION = "Caused by: ";
    private static final int END_STACK_COUNT = 128;
    private static final int MAX_STACK_COUNT = 256;
    private static final String SUPPRESSED_CAPTION = "Suppressed: ";

    private Stack() {
    }

    /* JADX WARN: Unreachable blocks removed: 3, instructions: 3 */
    @NonNull
    public static String getExceptionStack(@NonNull Throwable r2) {
        StringWriter r0 = new StringWriter();
        PrintWriter r1 = new PrintWriter(r0);
        printStackTrace(r2, r1);     // Catch: Throwable -> L6
        String r3 = r0.toString();     // Catch: Throwable -> L6
        r1.close();
        return r3;
    L7:
        r1.close();
        return "";
    }

    private static boolean isStackOverFlowError(Throwable r3) {
        int r1 = 0;
    L3:
        if (r3 == null) goto L12;
        if ((r3 instanceof StackOverflowError) == true) goto L6;
        if (r1 > 20) goto L10;
        r3 = r3.getCause();
        r1 = r1 + 1;
        goto L3
    L10:
        return false;
    L6:
        return true;
    L12:
        return false;
    }

    private static void printEnclosedStackTrace(Throwable r9, PrintWriter r10, StackTraceElement[] r11, String r12, String r13, Set<Throwable> r14, int r15) {
        if (r14.contains(r9) == false) goto L5;
        r10.println("\t[CIRCULAR REFERENCE:" + r9 + "]");
        return;
    L5:
        r14.add(r9);
        StackTraceElement[] r16 = r9.getStackTrace();
        if (r16.length <= r15) goto L8;
        boolean r0 = true;
    L9:
        r10.println(r13 + r12 + r9);
        int r17 = r16.length;
        int r2 = 0;
        int r3 = 0;
    L11:
        if (r2 >= r17) goto L17;
        StackTraceElement r5 = r16[r2];
        if (r0 == false) goto L16;
        if (r3 <= r15) goto L16;
        r10.println("\t... skip " + ((r16.length - r3) - (r15 / 2)) + " lines");
    L16:
        r10.println("\tat " + r5);
        r3 = r3 + 1;
        r2 = r2 + 1;
    L17:
        if (r0 == false) goto L22;
        int r18 = r16.length - (r15 / 2);
    L20:
        if (r18 >= r16.length) goto L22;
        r10.println("\tat " + r16[r18]);
        r18 = r18 + 1;
    L22:
        Throwable[] r19 = r9.getSuppressed();
        int r7 = r19.length;
        int r8 = 0;
    L24:
        if (r8 >= r7) goto L30;
        Throwable r1 = r19[r8];
        String r4 = a.j(r13, "\t");
        int r6 = r15 / 2;
        if (r6 <= 10) goto L28;
        int r20 = r6;
    L29:
        printEnclosedStackTrace(r1, r10, r16, SUPPRESSED_CAPTION, r4, r14, r20);
        r8 = r8 + 1;
        goto L24
    L28:
        r20 = 10;
        goto L29
    L30:
        Throwable r21 = r9.getCause();
        if (r21 == null) goto L47;
        int r110 = r15 / 2;
        if (r110 <= 10) goto L35;
        int r22 = r110;
    L36:
        printEnclosedStackTrace(r21, r10, r16, CAUSE_CAPTION, r13, r14, r22);
        return;
    L35:
        r22 = 10;
        goto L36
    L47:
        return;
    L8:
        r0 = false;
        goto L9
    }

    private static void printStackTrace(Throwable r12, PrintWriter r13) {
        if (r12 == null) goto L36;
        if (r13 == null) goto L38;
        Set r0 = Collections.newSetFromMap(new IdentityHashMap());
        r0.add(r12);
        r13.println(r12);
        StackTraceElement[] r8 = r12.getStackTrace();
        if (r8.length <= 384) goto L8;
        boolean r1 = true;
    L9:
        int r2 = r8.length;
        int r4 = 0;
        int r5 = 0;
    L11:
        if (r4 >= r2) goto L18;
        StackTraceElement r7 = r8[r4];
        if (r1 == false) goto L17;
        if (r5 <= 256) goto L17;
        StringBuilder r3 = new StringBuilder("\t... skip ");
        r3.append((r8.length - r5) - 128);
        r3.append(" lines");
        r13.println(r3.toString());
    L17:
        r13.println("\tat " + r7);
        r5 = r5 + 1;
        r4 = r4 + 1;
    L18:
        if (r1 == false) goto L23;
        int r6 = r8.length - 128;
    L21:
        if (r6 >= r8.length) goto L23;
        r13.println("\tat " + r8[r6]);
        r6 = r6 + 1;
    L23:
        Throwable[] r9 = r12.getSuppressed();
        int r10 = r9.length;
        int r11 = 0;
    L24:
        if (r11 >= r10) goto L26;
        printEnclosedStackTrace(r9[r11], r13, r8, SUPPRESSED_CAPTION, "\t", r0, 128);
        r11 = r11 + 1;
        goto L24
    L26:
        Throwable r14 = r12.getCause();
        if (r14 == null) goto L37;
        printEnclosedStackTrace(r14, r13, r8, CAUSE_CAPTION, "", r0, 128);
        return;
    L37:
        return;
    L8:
        r1 = false;
        goto L9
    L38:
        return;
    }
}
