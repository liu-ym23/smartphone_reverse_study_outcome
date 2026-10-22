package com.google.common.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class FileBackedOutputStream extends OutputStream {

    @CheckForNull
    private File file;
    private final int fileThreshold;

    @CheckForNull
    private MemoryOutput memory;
    private OutputStream out;

    @CheckForNull
    private final File parentDirectory;
    private final boolean resetOnFinalize;
    private final ByteSource source;

    private static class MemoryOutput extends ByteArrayOutputStream {
        private MemoryOutput() {
        }

        /* synthetic */ MemoryOutput(AnonymousClass1 r1) {
            this();
        }

        byte[] getBuffer() {
            return this.buf;
        }

        int getCount() {
            return this.count;
        }
    }

    static /* synthetic */ InputStream access$100(FileBackedOutputStream r0) throws IOException {
        return r0.openInputStream();
    }

    @CheckForNull
    synchronized File getFile() {
        monitor-enter(this);
        File r0 = this.file;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public FileBackedOutputStream(int r2) {
        this(r2, false);
    }

    public FileBackedOutputStream(int r2, boolean r3) {
        this(r2, r3, null);
    }

    private FileBackedOutputStream(int r1, boolean r2, @CheckForNull File r3) {
        this.fileThreshold = r1;
        this.resetOnFinalize = r2;
        this.parentDirectory = r3;
        MemoryOutput r4 = new MemoryOutput(null);
        this.memory = r4;
        this.out = r4;
        if (r2 == false) goto L5;
        this.source = new AnonymousClass1(this);
        return;
    L5:
        this.source = new AnonymousClass2(this);
    }

    public ByteSource asByteSource() {
        return this.source;
    }

    private synchronized InputStream openInputStream() throws IOException {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.file == null) goto L8;
        FileInputStream r0 = new FileInputStream(this.file);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r0;
    L8:
        Objects.requireNonNull(this.memory);     // Catch: Throwable -> L11
        ByteArrayInputStream r1 = new ByteArrayInputStream(this.memory.getBuffer(), 0, this.memory.getCount());     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    }

    public synchronized void reset() throws IOException {
        monitor-enter(this);
        AnonymousClass1 r0 = null;
        close();     // Catch: Throwable -> L20
        MemoryOutput r1 = this.memory;     // Catch: Throwable -> L18
        if (r1 != null) goto L8;
        this.memory = new MemoryOutput(r0);     // Catch: Throwable -> L18
    L9:
        this.out = this.memory;     // Catch: Throwable -> L18
        File r2 = this.file;     // Catch: Throwable -> L18
        if (r2 == null) goto L16;
        this.file = null;     // Catch: Throwable -> L18
        if (r2.delete() == true) goto L16;
        String r3 = String.valueOf(r2);     // Catch: Throwable -> L18
        throw new IOException(new StringBuilder(String.valueOf(r3).length() + 18).append("Could not delete: ").append(r3).toString());     // Catch: Throwable -> L18
    L16:
        monitor-exit(this);
        return;
    L8:
        r1.reset();     // Catch: Throwable -> L18
        goto L9
    L20:
        th = move-exception;
        if (this.memory != null) goto L24;
        this.memory = new MemoryOutput(r0);     // Catch: Throwable -> L18
    L25:
        this.out = this.memory;     // Catch: Throwable -> L18
        File r4 = this.file;     // Catch: Throwable -> L18
        if (r4 == null) goto L31;
        this.file = null;     // Catch: Throwable -> L18
        if (r4.delete() == true) goto L31;
        String r5 = String.valueOf(r4);     // Catch: Throwable -> L18
        throw new IOException(new StringBuilder(String.valueOf(r5).length() + 18).append("Could not delete: ").append(r5).toString());     // Catch: Throwable -> L18
    L31:
        throw th;     // Catch: Throwable -> L18
    L24:
        this.memory.reset();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    @Override // java.io.OutputStream
    public synchronized void write(int r2) throws IOException {
        monitor-enter(this);
        update(1);     // Catch: Throwable -> L7
        this.out.write(r2);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] r3) throws IOException {
        monitor-enter(this);
        write(r3, 0, r3.length);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] r2, int r3, int r4) throws IOException {
        monitor-enter(this);
        update(r4);     // Catch: Throwable -> L6
        this.out.write(r2, r3, r4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        monitor-enter(this);
        this.out.close();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public synchronized void flush() throws IOException {
        monitor-enter(this);
        this.out.flush();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void update(int r6) throws IOException {
        MemoryOutput r0 = this.memory;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0.getCount() + r6) <= this.fileThreshold) goto L17;
        File r7 = File.createTempFile("FileBackedOutputStream", null, this.parentDirectory);
        if (this.resetOnFinalize == false) goto L15;
        r7.deleteOnExit();
    L15:
        FileOutputStream r1 = new FileOutputStream(r7);     // Catch: IOException -> L11
        r1.write(this.memory.getBuffer(), 0, this.memory.getCount());     // Catch: IOException -> L11
        r1.flush();     // Catch: IOException -> L11
        this.out = r1;     // Catch: IOException -> L11
        this.file = r7;
        this.memory = null;
        return;
    L11:
        e = move-exception;
        r7.delete();
        throw e;
    }
}
