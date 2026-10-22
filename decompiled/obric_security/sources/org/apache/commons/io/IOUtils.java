package org.apache.commons.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.output.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class IOUtils {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final char DIR_SEPARATOR = 0;
    public static final char DIR_SEPARATOR_UNIX = '/';
    public static final char DIR_SEPARATOR_WINDOWS = '\\';
    public static final String LINE_SEPARATOR = null;
    public static final String LINE_SEPARATOR_UNIX = "\n";
    public static final String LINE_SEPARATOR_WINDOWS = "\r\n";

    static {
        DIR_SEPARATOR = File.separatorChar;
        StringWriter r0 = new StringWriter(4);
        new PrintWriter(r0).println();
        LINE_SEPARATOR = r0.toString();
    }

    public IOUtils() {
    }

    public static void closeQuietly(Reader r0) {
        if (r0 == null) goto L8;
        r0.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    public static void closeQuietly(Writer r0) {
        if (r0 == null) goto L8;
        r0.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    public static void closeQuietly(InputStream r0) {
        if (r0 == null) goto L8;
        r0.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    public static void closeQuietly(OutputStream r0) {
        if (r0 == null) goto L8;
        r0.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    public static byte[] toByteArray(InputStream r1) throws IOException {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        copy(r1, r0);
        return r0.toByteArray();
    }

    public static byte[] toByteArray(Reader r1) throws IOException {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        copy(r1, r0);
        return r0.toByteArray();
    }

    public static byte[] toByteArray(Reader r1, String r2) throws IOException {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        copy(r1, r0, r2);
        return r0.toByteArray();
    }

    public static byte[] toByteArray(String r0) throws IOException {
        return r0.getBytes();
    }

    public static char[] toCharArray(InputStream r1) throws IOException {
        CharArrayWriter r0 = new CharArrayWriter();
        copy(r1, r0);
        return r0.toCharArray();
    }

    public static char[] toCharArray(InputStream r1, String r2) throws IOException {
        CharArrayWriter r0 = new CharArrayWriter();
        copy(r1, r0, r2);
        return r0.toCharArray();
    }

    public static char[] toCharArray(Reader r1) throws IOException {
        CharArrayWriter r0 = new CharArrayWriter();
        copy(r1, r0);
        return r0.toCharArray();
    }

    public static String toString(InputStream r1) throws IOException {
        StringWriter r0 = new StringWriter();
        copy(r1, r0);
        return r0.toString();
    }

    public static String toString(InputStream r1, String r2) throws IOException {
        StringWriter r0 = new StringWriter();
        copy(r1, r0, r2);
        return r0.toString();
    }

    public static String toString(Reader r1) throws IOException {
        StringWriter r0 = new StringWriter();
        copy(r1, r0);
        return r0.toString();
    }

    public static String toString(byte[] r1) throws IOException {
        return new String(r1);
    }

    public static String toString(byte[] r1, String r2) throws IOException {
        if (r2 != null) goto L6;
        return new String(r1);
    L6:
        return new String(r1, r2);
    }

    public static List readLines(InputStream r1) throws IOException {
        return readLines(new InputStreamReader(r1));
    }

    public static List readLines(InputStream r1, String r2) throws IOException {
        if (r2 != null) goto L6;
        return readLines(r1);
    L6:
        return readLines(new InputStreamReader(r1, r2));
    }

    public static List readLines(Reader r2) throws IOException {
        BufferedReader r0 = new BufferedReader(r2);
        ArrayList r3 = new ArrayList();
        String r1 = r0.readLine();
    L3:
        if (r1 == null) goto L5;
        r3.add(r1);
        r1 = r0.readLine();
        goto L3
    L5:
        return r3;
    }

    public static LineIterator lineIterator(Reader r1) {
        return new LineIterator(r1);
    }

    public static LineIterator lineIterator(InputStream r1, String r2) throws IOException {
        if (r2 != null) goto L4;
        InputStreamReader r3 = new InputStreamReader(r1);
    L6:
        return new LineIterator(r3);
    L4:
        r3 = new InputStreamReader(r1, r2);
        goto L6
    }

    public static InputStream toInputStream(String r1) {
        return new ByteArrayInputStream(r1.getBytes());
    }

    public static InputStream toInputStream(String r0, String r1) throws IOException {
        if (r1 == null) goto L4;
        byte[] r2 = r0.getBytes(r1);
    L6:
        return new ByteArrayInputStream(r2);
    L4:
        r2 = r0.getBytes();
        goto L6
    }

    public static void write(byte[] r0, OutputStream r1) throws IOException {
        if (r0 == null) goto L5;
        r1.write(r0);
        return;
    }

    public static void write(byte[] r1, Writer r2) throws IOException {
        if (r1 == null) goto L5;
        r2.write(new String(r1));
        return;
    }

    public static void write(byte[] r1, Writer r2, String r3) throws IOException {
        if (r1 == null) goto L7;
        if (r3 != null) goto L5;
        write(r1, r2);
        return;
    L5:
        r2.write(new String(r1, r3));
        return;
    }

    public static void write(char[] r0, Writer r1) throws IOException {
        if (r0 == null) goto L5;
        r1.write(r0);
        return;
    }

    public static void write(char[] r1, OutputStream r2) throws IOException {
        if (r1 == null) goto L5;
        r2.write(new String(r1).getBytes());
        return;
    }

    public static void write(char[] r1, OutputStream r2, String r3) throws IOException {
        if (r1 == null) goto L7;
        if (r3 != null) goto L5;
        write(r1, r2);
        return;
    L5:
        r2.write(new String(r1).getBytes(r3));
        return;
    }

    public static void write(String r0, Writer r1) throws IOException {
        if (r0 == null) goto L5;
        r1.write(r0);
        return;
    }

    public static void write(String r0, OutputStream r1) throws IOException {
        if (r0 == null) goto L5;
        r1.write(r0.getBytes());
        return;
    }

    public static void write(String r0, OutputStream r1, String r2) throws IOException {
        if (r0 == null) goto L7;
        if (r2 != null) goto L5;
        write(r0, r1);
        return;
    L5:
        r1.write(r0.getBytes(r2));
        return;
    }

    public static void write(StringBuffer r0, Writer r1) throws IOException {
        if (r0 == null) goto L5;
        r1.write(r0.toString());
        return;
    }

    public static void write(StringBuffer r0, OutputStream r1) throws IOException {
        if (r0 == null) goto L5;
        r1.write(r0.toString().getBytes());
        return;
    }

    public static void write(StringBuffer r0, OutputStream r1, String r2) throws IOException {
        if (r0 == null) goto L7;
        if (r2 != null) goto L5;
        write(r0, r1);
        return;
    L5:
        r1.write(r0.toString().getBytes(r2));
        return;
    }

    public static void writeLines(Collection r1, String r2, OutputStream r3) throws IOException {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r2 != null) goto L6;
        r2 = LINE_SEPARATOR;
    L6:
        Iterator r4 = r1.iterator();
    L8:
        if (r4.hasNext() == false) goto L13;
        Object r0 = r4.next();
        if (r0 == null) goto L12;
        r3.write(r0.toString().getBytes());
    L12:
        r3.write(r2.getBytes());
        goto L8
    }

    public static void writeLines(Collection r1, String r2, OutputStream r3, String r4) throws IOException {
        if (r4 != null) goto L4;
        writeLines(r1, r2, r3);
        return;
    L4:
        if (r1 != null) goto L6;
        return;
    L6:
        if (r2 != null) goto L8;
        r2 = LINE_SEPARATOR;
    L8:
        Iterator r5 = r1.iterator();
    L10:
        if (r5.hasNext() == false) goto L19;
        Object r0 = r5.next();
        if (r0 == null) goto L14;
        r3.write(r0.toString().getBytes(r4));
    L14:
        r3.write(r2.getBytes(r4));
        goto L10
    }

    public static void writeLines(Collection r1, String r2, Writer r3) throws IOException {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r2 != null) goto L6;
        r2 = LINE_SEPARATOR;
    L6:
        Iterator r4 = r1.iterator();
    L8:
        if (r4.hasNext() == false) goto L13;
        Object r0 = r4.next();
        if (r0 == null) goto L12;
        r3.write(r0.toString());
    L12:
        r3.write(r2);
        goto L8
    }

    public static int copy(InputStream r2, OutputStream r3) throws IOException {
        long r4 = copyLarge(r2, r3);
        if (r4 <= 2147483647L) goto L7;
        return -1;
    L7:
        return (int) r4;
    }

    public static long copyLarge(InputStream r5, OutputStream r6) throws IOException {
        byte[] r0 = new byte[4096];
        long r1 = 0;
    L3:
        int r3 = r5.read(r0);
        if ((-1) == r3) goto L6;
        r6.write(r0, 0, r3);
        r1 = r1 + ((long) r3);
        goto L3
    L6:
        return r1;
    }

    public static void copy(InputStream r1, Writer r2) throws IOException {
        copy(new InputStreamReader(r1), r2);
    }

    public static void copy(InputStream r1, Writer r2, String r3) throws IOException {
        if (r3 != null) goto L4;
        copy(r1, r2);
        return;
    L4:
        copy(new InputStreamReader(r1, r3), r2);
    }

    public static int copy(Reader r2, Writer r3) throws IOException {
        long r4 = copyLarge(r2, r3);
        if (r4 <= 2147483647L) goto L7;
        return -1;
    L7:
        return (int) r4;
    }

    public static long copyLarge(Reader r5, Writer r6) throws IOException {
        char[] r0 = new char[4096];
        long r1 = 0;
    L3:
        int r3 = r5.read(r0);
        if ((-1) == r3) goto L6;
        r6.write(r0, 0, r3);
        r1 = r1 + ((long) r3);
        goto L3
    L6:
        return r1;
    }

    public static void copy(Reader r1, OutputStream r2) throws IOException {
        OutputStreamWriter r0 = new OutputStreamWriter(r2);
        copy(r1, r0);
        r0.flush();
    }

    public static void copy(Reader r1, OutputStream r2, String r3) throws IOException {
        if (r3 != null) goto L4;
        copy(r1, r2);
        return;
    L4:
        OutputStreamWriter r0 = new OutputStreamWriter(r2, r3);
        copy(r1, r0);
        r0.flush();
    }

    public static boolean contentEquals(InputStream r3, InputStream r4) throws IOException {
        if ((r3 instanceof BufferedInputStream) == true) goto L6;
        r3 = new BufferedInputStream(r3);
    L6:
        if ((r4 instanceof BufferedInputStream) == true) goto L8;
        r4 = new BufferedInputStream(r4);
    L8:
        int r0 = r3.read();
    L10:
        if ((-1) == r0) goto L16;
        if (r0 != r4.read()) goto L13;
        r0 = r3.read();
        goto L10
    L13:
        return false;
    L16:
        if (r4.read() != (-1)) goto L21;
        return true;
    L21:
        return false;
    }

    public static boolean contentEquals(Reader r3, Reader r4) throws IOException {
        if ((r3 instanceof BufferedReader) == true) goto L6;
        r3 = new BufferedReader(r3);
    L6:
        if ((r4 instanceof BufferedReader) == true) goto L8;
        r4 = new BufferedReader(r4);
    L8:
        int r0 = r3.read();
    L10:
        if ((-1) == r0) goto L16;
        if (r0 != r4.read()) goto L13;
        r0 = r3.read();
        goto L10
    L13:
        return false;
    L16:
        if (r4.read() != (-1)) goto L21;
        return true;
    L21:
        return false;
    }
}
