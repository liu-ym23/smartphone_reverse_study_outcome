package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class CharStreams {
    private static final int DEFAULT_BUF_SIZE = 2048;

    private static final class NullWriter extends Writer {
        private static final NullWriter INSTANCE = null;

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(char r1) {
            return this;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(@CheckForNull CharSequence r1) {
            return this;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return "CharStreams.nullWriter()";
        }

        @Override // java.io.Writer
        public void write(int r1) {
        }

        private NullWriter() {
        }

        static /* synthetic */ NullWriter access$000() {
            return INSTANCE;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public /* bridge */ /* synthetic */ Appendable append(char r1) throws IOException {
            return append(r1);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public /* bridge */ /* synthetic */ Appendable append(@CheckForNull CharSequence r1) throws IOException {
            return append(r1);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public /* bridge */ /* synthetic */ Appendable append(@CheckForNull CharSequence r1, int r2, int r3) throws IOException {
            return append(r1, r2, r3);
        }

        static {
            INSTANCE = new NullWriter();
        }

        @Override // java.io.Writer
        public void write(char[] r1) {
            Preconditions.checkNotNull(r1);
        }

        @Override // java.io.Writer
        public void write(char[] r1, int r2, int r3) {
            Preconditions.checkPositionIndexes(r2, r3 + r2, r1.length);
        }

        @Override // java.io.Writer
        public void write(String r1) {
            Preconditions.checkNotNull(r1);
        }

        @Override // java.io.Writer
        public void write(String r1, int r2, int r3) {
            Preconditions.checkPositionIndexes(r2, r3 + r2, r1.length());
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(@CheckForNull CharSequence r1, int r2, int r3) {
            if (r1 != null) goto L4;
            int r4 = 4;
        L5:
            Preconditions.checkPositionIndexes(r2, r3, r4);
            return this;
        L4:
            r4 = r1.length();
            goto L5
        }
    }

    static CharBuffer createBuffer() {
        return CharBuffer.allocate(2048);
    }

    private CharStreams() {
    }

    public static long copy(Readable r5, Appendable r6) throws IOException {
        if ((r5 instanceof Reader) == true) goto L5;
        Preconditions.checkNotNull(r5);
        Preconditions.checkNotNull(r6);
        CharBuffer r0 = createBuffer();
        long r1 = 0;
    L12:
        if (r5.read(r0) == (-1)) goto L14;
        Java8Compatibility.flip(r0);
        r6.append(r0);
        r1 = r1 + ((long) r0.remaining());
        Java8Compatibility.clear(r0);
        goto L12
    L14:
        return r1;
    L5:
        if ((r6 instanceof StringBuilder) == false) goto L9;
        return copyReaderToBuilder((Reader) r5, (StringBuilder) r6);
    L9:
        return copyReaderToWriter((Reader) r5, asWriter(r6));
    }

    static long copyReaderToBuilder(Reader r5, StringBuilder r6) throws IOException {
        Preconditions.checkNotNull(r5);
        Preconditions.checkNotNull(r6);
        char[] r0 = new char[2048];
        long r1 = 0;
    L3:
        int r3 = r5.read(r0);
        if (r3 == (-1)) goto L6;
        r6.append(r0, 0, r3);
        r1 = r1 + ((long) r3);
        goto L3
    L6:
        return r1;
    }

    static long copyReaderToWriter(Reader r5, Writer r6) throws IOException {
        Preconditions.checkNotNull(r5);
        Preconditions.checkNotNull(r6);
        char[] r0 = new char[2048];
        long r1 = 0;
    L3:
        int r3 = r5.read(r0);
        if (r3 == (-1)) goto L6;
        r6.write(r0, 0, r3);
        r1 = r1 + ((long) r3);
        goto L3
    L6:
        return r1;
    }

    public static String toString(Readable r0) throws IOException {
        return toStringBuilder(r0).toString();
    }

    private static StringBuilder toStringBuilder(Readable r2) throws IOException {
        StringBuilder r0 = new StringBuilder();
        if ((r2 instanceof Reader) == false) goto L5;
        copyReaderToBuilder((Reader) r2, r0);
    L6:
        return r0;
    L5:
        copy(r2, r0);
        goto L6
    }

    public static List<String> readLines(Readable r2) throws IOException {
        ArrayList r0 = new ArrayList();
        LineReader r1 = new LineReader(r2);
    L3:
        String r3 = r1.readLine();
        if (r3 == null) goto L6;
        r0.add(r3);
        goto L3
    L6:
        return r0;
    }

    @ParametricNullness
    public static <T> T readLines(Readable r1, LineProcessor<T> r2) throws IOException {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        LineReader r0 = new LineReader(r1);
    L3:
        String r3 = r0.readLine();
        if (r3 == null) goto L8;
        if (r2.processLine(r3) == true) goto L3;
    L8:
        return r2.getResult();
    }

    public static long exhaust(Readable r7) throws IOException {
        CharBuffer r0 = createBuffer();
        long r1 = 0;
    L3:
        long r3 = r7.read(r0);
        if (r3 == (-1)) goto L6;
        r1 = r1 + r3;
        Java8Compatibility.clear(r0);
        goto L3
    L6:
        return r1;
    }

    public static void skipFully(Reader r4, long r5) throws IOException {
        Preconditions.checkNotNull(r4);
    L4:
        if (r5 <= 0) goto L10;
        long r2 = r4.skip(r5);
        if (r2 == 0) goto L9;
        r5 = r5 - r2;
        goto L4
    L9:
        throw new EOFException();
    }

    public static Writer nullWriter() {
        return NullWriter.access$000();
    }

    public static Writer asWriter(Appendable r1) {
        if ((r1 instanceof Writer) == false) goto L7;
        return (Writer) r1;
    L7:
        return new AppendableWriter(r1);
    }
}
