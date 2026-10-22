package com.monitor.cloudmessage.internal.file.generator;

import a.a;
import android.content.Context;
import com.monitor.cloudmessage.utils.FileUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class StatFileGenerator {
    public StatFileGenerator() {
    }

    public static File generateFile(Context r5, JSONObject r6) {
        BufferedWriter r0 = null;
        if (r6 != null) goto L5;
        return null;
    L5:
        String r7 = FileUtils.getCloudMsgDir(r5).getAbsolutePath();
        String r1 = a.o(a.q(r7), File.separator, "stats.txt");
        File r2 = new File(r7);     // Catch: Throwable -> L9 IOException -> L11
        if (r2.exists() == true) goto L13;
        r2.mkdirs();     // Catch: Throwable -> L9 IOException -> L11
    L13:
        FileWriter r8 = new FileWriter(r1);     // Catch: Throwable -> L9 IOException -> L11
    L64:
        BufferedWriter r3 = new BufferedWriter(r8);     // Catch: Throwable -> L27 IOException -> L29
        r3.write(r6.toString());     // Catch: Throwable -> L22 IOException -> L25
        r3.close();     // Catch: IOException -> L18
        r8.close();     // Catch: IOException -> L18
    L21:
        return new File(r1);
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L21
    L25:
        e = e;
    L26:
        IOException r4 = e;
        FileWriter r9 = r8;
        e = r4;
    L54:
        e.printStackTrace();     // Catch: Throwable -> L41
        if (r3 != null) goto L52;
    L36:
        if (r9 == null) goto L40;
        r9.close();     // Catch: IOException -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
    L40:
        return null;
    L52:
        r3.close();     // Catch: IOException -> L34
    L41:
        th = th;
        r0 = r3;
    L43:
        if (r0 != null) goto L58;
    L47:
        if (r9 == null) goto L51;
        r9.close();     // Catch: IOException -> L45
    L45:
        e = move-exception;
        e.printStackTrace();
    L51:
        throw th;
    L58:
        r0.close();     // Catch: IOException -> L45
    L22:
        th = th;
        r0 = r3;
    L24:
        Throwable r10 = th;
        r9 = r8;
        th = r10;
        goto L43
    L29:
        e = e;
        r3 = null;
    L27:
        th = th;
    L11:
        e = e;
        r9 = null;
        r3 = null;
    L9:
        th = th;
        r9 = null;
        goto L43
    }
}
