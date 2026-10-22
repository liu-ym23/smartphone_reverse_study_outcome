package com.android.settings;

import com.obric.olog.OLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class WriteSystemFileUtils {
    private static final String TAG = "WriteSystemFileUtils";

    public WriteSystemFileUtils() {
    }

    public static boolean writeSysFile(String r4, String r5) {
        OLog.d(TAG, "writeSysFile " + r4 + " as " + r5);
        File r0 = new File(r4);
        if (r0.exists() == true) goto L7;
        OLog.e(TAG, "sys file is not exist: ");
        return false;
    L7:
        if (r0.canWrite() == true) goto L10;
        OLog.e(TAG, "sys file is exist, but can not write.");
        return false;
    L10:
        if (r5 != null) goto L51;
        r5 = "";
    L51:
        FileOutputStream r3 = new FileOutputStream(r0);     // Catch: Throwable -> L25 IOException -> L27
        r3.write(r5.getBytes());     // Catch: Throwable -> L21 IOException -> L23
        r3.flush();     // Catch: Throwable -> L21 IOException -> L23
        r3.close();     // Catch: IOException -> L17
        return true;
    L17:
        e = move-exception;
        e.printStackTrace();
        return true;
    L23:
        IOException e = e;
    L29:
        OLog.e(TAG, "writeSysFile catch IOException: ", e);     // Catch: Throwable -> L21
        e.printStackTrace();     // Catch: Throwable -> L21
        if (r3 != null) goto L42;
    L35:
        return false;
    L42:
        r3.close();     // Catch: IOException -> L33
    L33:
        e = move-exception;
        e.printStackTrace();
    L21:
        Throwable th = th;
    L36:
        if (r3 != null) goto L46;
    L41:
        throw th;
    L46:
        r3.close();     // Catch: IOException -> L39
    L39:
        e = move-exception;
        e.printStackTrace();
        goto L41
    L27:
        e = move-exception;
        r3 = null;
        e = e;
    L25:
        th = move-exception;
        r3 = null;
        th = th;
        goto L36
    }
}
