package com.bytedance.monitor.util;

import com.bytedance.monitor.util.jni.JavaCalls;
import java.io.Closeable;
import java.io.File;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes.dex */
public class IoUtil {
    private IoUtil() {
    }

    public static boolean mkdir(String r1) {
        return new File(r1).mkdirs();
    }

    public static void safeClose(Closeable r0) {
        if (r0 == null) goto L8;
        r0.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public static void setPermissions(String r1, int r2) {
        JavaCalls.callStaticMethod("android.os.FileUtils", "setPermissions", new Object[]{r1, Integer.valueOf(r2), -1, -1});
    }

    public static void safeClose(ZipFile r0) {
        if (r0 != null) goto L7;
        return;
    L7:
        r0.close();     // Catch: Throwable -> L6
        return;
    }
}
