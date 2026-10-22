package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.HttpEntity;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes5.dex */
class IOUtils {
    IOUtils() {
    }

    static void consume(HttpEntity r1) throws IOException {
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.isStreaming() == false) goto L10;
        InputStream r2 = r1.getContent();
        if (r2 == null) goto L11;
        r2.close();
        return;
    L11:
        return;
    }

    static void copy(InputStream r3, OutputStream r4) throws IOException {
        byte[] r0 = new byte[2048];
    L3:
        int r1 = r3.read(r0);
        if (r1 == (-1)) goto L6;
        r4.write(r0, 0, r1);
        goto L3
    }

    static void closeSilently(Closeable r0) {
        r0.close();     // Catch: IOException -> L4
        return;
    }

    static void copyAndClose(InputStream r1, OutputStream r2) throws IOException {
        copy(r1, r2);     // Catch: IOException -> L4
        r1.close();     // Catch: IOException -> L4
        r2.close();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        closeSilently(r1);
        closeSilently(r2);
        throw e;
    }

    static void copyFile(File r8, File r9) throws IOException {
        RandomAccessFile r0 = new RandomAccessFile(r8, "r");
        RandomAccessFile r10 = new RandomAccessFile(r9, "rw");
        FileChannel r11 = r0.getChannel();     // Catch: IOException -> L11
        FileChannel r1 = r10.getChannel();     // Catch: IOException -> L11
        r11.transferTo(0, r0.length(), r1);     // Catch: IOException -> L8
        r11.close();     // Catch: IOException -> L8
        r1.close();     // Catch: IOException -> L8
        r0.close();     // Catch: IOException -> L11
        r10.close();     // Catch: IOException -> L11
        return;
    L8:
        e = move-exception;
        closeSilently(r11);     // Catch: IOException -> L11
        closeSilently(r1);     // Catch: IOException -> L11
        throw e;     // Catch: IOException -> L11
    L11:
        e = move-exception;
        closeSilently(r0);
        closeSilently(r10);
        throw e;
    }
}
