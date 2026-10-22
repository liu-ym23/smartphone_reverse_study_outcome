package org.apache.commons.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;

/* JADX INFO: loaded from: classes5.dex */
public class CopyUtils {
    private static final int DEFAULT_BUFFER_SIZE = 4096;

    public CopyUtils() {
    }

    public static void copy(byte[] r0, OutputStream r1) throws IOException {
        r1.write(r0);
    }

    public static void copy(byte[] r1, Writer r2) throws IOException {
        copy(new ByteArrayInputStream(r1), r2);
    }

    public static void copy(byte[] r1, Writer r2, String r3) throws IOException {
        copy(new ByteArrayInputStream(r1), r2, r3);
    }

    public static int copy(InputStream r5, OutputStream r6) throws IOException {
        byte[] r0 = new byte[4096];
        int r2 = 0;
    L3:
        int r3 = r5.read(r0);
        if ((-1) == r3) goto L6;
        r6.write(r0, 0, r3);
        r2 = r2 + r3;
        goto L3
    L6:
        return r2;
    }

    public static int copy(Reader r5, Writer r6) throws IOException {
        char[] r0 = new char[4096];
        int r2 = 0;
    L3:
        int r3 = r5.read(r0);
        if ((-1) == r3) goto L6;
        r6.write(r0, 0, r3);
        r2 = r2 + r3;
        goto L3
    L6:
        return r2;
    }

    public static void copy(InputStream r1, Writer r2) throws IOException {
        copy(new InputStreamReader(r1), r2);
    }

    public static void copy(InputStream r1, Writer r2, String r3) throws IOException {
        copy(new InputStreamReader(r1, r3), r2);
    }

    public static void copy(Reader r1, OutputStream r2) throws IOException {
        OutputStreamWriter r0 = new OutputStreamWriter(r2);
        copy(r1, r0);
        r0.flush();
    }

    public static void copy(String r1, OutputStream r2) throws IOException {
        StringReader r0 = new StringReader(r1);
        OutputStreamWriter r3 = new OutputStreamWriter(r2);
        copy(r0, r3);
        r3.flush();
    }

    public static void copy(String r0, Writer r1) throws IOException {
        r1.write(r0);
    }
}
