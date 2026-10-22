package com.monitor.cloudmessage.internal.file.generator;

import a.a;
import android.content.Context;
import android.text.TextUtils;
import com.monitor.cloudmessage.utils.FileUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class MonitorLogFileGenerator {
    public MonitorLogFileGenerator() {
    }

    public static File generateFile(Context r4, String r5, String r6) {
        BufferedWriter r1 = null;
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        String r7 = FileUtils.getCloudMsgDir(r4).getAbsolutePath();
        StringBuilder r0 = a.q(r7);
        r0.append(File.separator);
        r0.append(r6);
        r0.append(".txt");
        String r8 = r0.toString();
        File r2 = new File(r7);     // Catch: Throwable -> L9 IOException -> L11
        if (r2.exists() == true) goto L13;
        r2.mkdirs();     // Catch: Throwable -> L9 IOException -> L11
    L13:
        FileWriter r9 = new FileWriter(r8);     // Catch: Throwable -> L9 IOException -> L11
    L62:
        BufferedWriter r3 = new BufferedWriter(r9);     // Catch: Throwable -> L27 IOException -> L29
    L64:
        r3.write(r5);     // Catch: Throwable -> L22 IOException -> L25
        r3.close();     // Catch: IOException -> L18
        r9.close();     // Catch: IOException -> L18
    L21:
        return new File(r8);
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L21
    L25:
        e = e;
    L26:
        IOException r10 = e;
        FileWriter r11 = r9;
        e = r10;
    L58:
        e.printStackTrace();     // Catch: Throwable -> L41
        if (r3 != null) goto L54;
    L36:
        if (r11 == null) goto L40;
        r11.close();     // Catch: IOException -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
    L40:
        return null;
    L54:
        r3.close();     // Catch: IOException -> L34
    L41:
        th = th;
        r1 = r3;
    L43:
        if (r1 != null) goto L52;
    L47:
        if (r11 == null) goto L51;
        r11.close();     // Catch: IOException -> L45
    L45:
        e = move-exception;
        e.printStackTrace();
    L51:
        throw th;
    L52:
        r1.close();     // Catch: IOException -> L45
    L22:
        th = th;
        r1 = r3;
    L24:
        Throwable r12 = th;
        r11 = r9;
        th = r12;
    L29:
        e = e;
        r3 = null;
    L27:
        th = th;
    L11:
        e = e;
        r11 = null;
        r3 = null;
    L9:
        th = th;
        r11 = null;
        goto L43
    }
}
