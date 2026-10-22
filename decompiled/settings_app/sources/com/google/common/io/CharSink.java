package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class CharSink {
    public abstract Writer openStream() throws IOException;

    protected CharSink() {
    }

    public Writer openBufferedStream() throws IOException {
        Writer r1 = openStream();
        if ((r1 instanceof BufferedWriter) == false) goto L6;
        return (BufferedWriter) r1;
    L6:
        return new BufferedWriter(r1);
    }

    public void write(CharSequence r2) throws IOException {
        Preconditions.checkNotNull(r2);
        Closer r0 = Closer.create();
        Writer r1 = (Writer) r0.register(openStream());     // Catch: Throwable -> L6
        r1.append(r2);     // Catch: Throwable -> L6
        r1.flush();     // Catch: Throwable -> L6
        r0.close();
        return;
    L6:
        th = move-exception;
    L9:
        th = move-exception;
        r0.close();
        throw th;
    L8:
        throw r0.rethrow(th);     // Catch: Throwable -> L9
    }

    public void writeLines(Iterable<? extends CharSequence> r2) throws IOException {
        writeLines(r2, System.getProperty("line.separator"));
    }

    public void writeLines(Iterable<? extends CharSequence> r1, String r2) throws IOException {
        writeLines(r1.iterator(), r2);
    }

    public void writeLines(Stream<? extends CharSequence> r2) throws IOException {
        writeLines(r2, System.getProperty("line.separator"));
    }

    public void writeLines(Stream<? extends CharSequence> r1, String r2) throws IOException {
        writeLines(r1.iterator(), r2);
    }

    private void writeLines(Iterator<? extends CharSequence> r2, String r3) throws IOException {
        Preconditions.checkNotNull(r3);
        Writer r1 = openBufferedStream();
    L17:
    L10:
        th = move-exception;
        if (r1 != null) goto L19;
    L16:
        throw th;
    L19:
        r1.close();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.addSuppressed(th);
        goto L16
    L4:
        if (r2.hasNext() == false) goto L7;
        r1.append(r2.next()).append(r3);     // Catch: Throwable -> L10
        goto L17
    L7:
        if (r1 == null) goto L23;
        r1.close();
        return;
    }

    public long writeFrom(Readable r4) throws IOException {
        Preconditions.checkNotNull(r4);
        Closer r0 = Closer.create();
        Writer r3 = (Writer) r0.register(openStream());     // Catch: Throwable -> L6
        long r1 = CharStreams.copy(r4, r3);     // Catch: Throwable -> L6
        r3.flush();     // Catch: Throwable -> L6
        r0.close();
        return r1;
    L6:
        th = move-exception;
    L9:
        th = move-exception;
        r0.close();
        throw th;
    L8:
        throw r0.rethrow(th);     // Catch: Throwable -> L9
    }
}
