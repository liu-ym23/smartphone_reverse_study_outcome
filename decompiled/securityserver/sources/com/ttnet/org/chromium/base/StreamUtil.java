package com.ttnet.org.chromium.base;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes2.dex */
public class StreamUtil {
    public StreamUtil() {
    }

    public static void closeQuietly(Closeable r0) {
        if (r0 != null) goto L7;
        return;
    L7:
        r0.close();     // Catch: IOException -> L6
        return;
    }

    public static void closeQuietly(ZipFile r0) {
        if (r0 != null) goto L7;
        return;
    L7:
        r0.close();     // Catch: IOException -> L6
        return;
    }
}
