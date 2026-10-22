package com.bytedance.apm6.memory;

import android.os.Process;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes.dex */
class Tools {
    Tools() {
    }

    static long getVmSize() {
        int r2 = 0;
        String[] r0 = getStringFromFile(String.format("/proc/%s/status", new Object[]{Integer.valueOf(Process.myPid())})).trim().split(IOUtils.LINE_SEPARATOR_UNIX);     // Catch: Exception -> L20
        int r1 = r0.length;     // Catch: Exception -> L20
    L5:
        if (r2 >= r1) goto L14;
        String r6 = r0[r2];     // Catch: Exception -> L20
        if (r6.startsWith("VmSize") == false) goto L12;
        Matcher r5 = Pattern.compile("\\d+").matcher(r6);     // Catch: Exception -> L20
        if (r5.find() == false) goto L12;
        return Long.parseLong(r5.group());
    L12:
        r2 = r2 + 1;     // Catch: Exception -> L20
        goto L5
    L14:
        if (r0.length <= 12) goto L19;
        Matcher r3 = Pattern.compile("\\d+").matcher(r0[12]);     // Catch: Exception -> L20
        if (r3.find() == false) goto L19;
        return Long.parseLong(r3.group());
    L19:
        return -1;
    }

    private static String getStringFromFile(String r2) throws Exception {
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

    private static String convertStreamToString(InputStream r4) throws Exception {
        StringBuilder r0 = new StringBuilder();
        BufferedReader r1 = null;
        BufferedReader r2 = new BufferedReader(new InputStreamReader(r4));     // Catch: Throwable -> L12
    L16:
        String r5 = r2.readLine();     // Catch: Throwable -> L10
        if (r5 == null) goto L8;
        r0.append(r5).append('\n');     // Catch: Throwable -> L10
        goto L16
    L8:
        r2.close();
        return r0.toString();
    L10:
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
}
