package com.bumptech.glide.disklrucache;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
final class Util {
    static final Charset US_ASCII = null;
    static final Charset UTF_8 = null;

    static {
        US_ASCII = Charset.forName("US-ASCII");
        UTF_8 = Charset.forName("UTF-8");
    }

    private Util() {
    }

    static String readFully(Reader r4) throws IOException {
        StringWriter r0 = new StringWriter();     // Catch: Throwable -> L9
        char[] r1 = new char[1024];     // Catch: Throwable -> L9
    L3:
        int r2 = r4.read(r1);     // Catch: Throwable -> L9
        if (r2 == (-1)) goto L6;
        r0.write(r1, 0, r2);     // Catch: Throwable -> L9
        goto L3
    L6:
        String r3 = r0.toString();     // Catch: Throwable -> L9
        r4.close();
        return r3;
    L9:
        th = move-exception;
        r4.close();
        throw th;
    }

    static void deleteContents(File r4) throws IOException {
        File[] r0 = r4.listFiles();
        if (r0 == null) goto L16;
        int r5 = r0.length;
        int r1 = 0;
    L5:
        if (r1 >= r5) goto L14;
        File r2 = r0[r1];
        if (r2.isDirectory() == false) goto L10;
        deleteContents(r2);
    L10:
        if (r2.delete() == false) goto L13;
        r1 = r1 + 1;
        goto L5
    L13:
        throw new IOException("failed to delete file: " + r2);
    L14:
        return;
    L16:
        throw new IOException("not a readable directory: " + r4);
    }

    static void closeQuietly(Closeable r0) {
        if (r0 != null) goto L9;
        return;
    L9:
        r0.close();     // Catch: RuntimeException -> L5 Exception -> L8
        goto L12
    L11:
        return;
    L5:
        e = move-exception;
        throw e;
    }
}
