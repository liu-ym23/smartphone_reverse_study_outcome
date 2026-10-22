package com.bytedance.apm6.memory;

import a.a;
import android.os.Process;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
class Tools {
    public Tools() {
    }

    private static String convertStreamToString(InputStream r4) {
        StringBuilder r0 = new StringBuilder();
        BufferedReader r1 = null;
        BufferedReader r2 = new BufferedReader(new InputStreamReader(r4));     // Catch: Throwable -> L12
    L18:
        String r5 = r2.readLine();     // Catch: Throwable -> L8
        if (r5 == null) goto L10;
        r0.append(r5);     // Catch: Throwable -> L8
        r0.append('\n');     // Catch: Throwable -> L8
        goto L18
    L10:
        r2.close();
        return r0.toString();
    L8:
        th = th;
        r1 = r2;
    L13:
        if (r1 == null) goto L15;
        r1.close();
    L15:
        throw th;
    L12:
        th = th;
        goto L13
    }

    private static String getStringFromFile(String r2) {
        FileInputStream r1 = new FileInputStream(new File(r2));     // Catch: Throwable -> L9
        String r3 = convertStreamToString(r1);     // Catch: Throwable -> L7
        r1.close();
        return r3;
    L7:
        Throwable th = th;
    L11:
        if (r1 == null) goto L13;
        r1.close();
    L13:
        throw th;
    L9:
        th = move-exception;
        r1 = null;
        th = th;
        goto L11
    }

    public static long getVmSize() {
        String[] r0 = getStringFromFile(a.f(Process.myPid(), "/proc/", "/status")).trim().split("\n");     // Catch: Exception -> L21
        int r3 = r0.length;     // Catch: Exception -> L21
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L15;
        String r6 = r0[r4];     // Catch: Exception -> L21
        if (r6.startsWith("VmSize") == false) goto L13;
        Matcher r5 = Pattern.compile("\\d+").matcher(r6);     // Catch: Exception -> L21
        if (r5.find() == false) goto L13;
        return Long.parseLong(r5.group());
    L13:
        r4 = r4 + 1;     // Catch: Exception -> L21
        goto L6
    L15:
        if (r0.length <= 12) goto L20;
        Matcher r1 = Pattern.compile("\\d+").matcher(r0[12]);     // Catch: Exception -> L21
        if (r1.find() == false) goto L20;
        return Long.parseLong(r1.group());
    L20:
        return -1;
    }
}
