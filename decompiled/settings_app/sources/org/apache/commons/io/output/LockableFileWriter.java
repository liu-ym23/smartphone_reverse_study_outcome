package org.apache.commons.io.output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes6.dex */
public class LockableFileWriter extends Writer {
    private static final String LCK = ".lck";
    static /* synthetic */ Class class$org$apache$commons$io$output$LockableFileWriter;
    private final File lockFile;
    private final Writer out;

    public LockableFileWriter(String r3) throws IOException {
        this(r3, false, null);
    }

    public LockableFileWriter(String r2, boolean r3) throws IOException {
        this(r2, r3, null);
    }

    public LockableFileWriter(String r2, boolean r3, String r4) throws IOException {
        this(new File(r2), r3, r4);
    }

    public LockableFileWriter(File r3) throws IOException {
        this(r3, false, null);
    }

    public LockableFileWriter(File r2, boolean r3) throws IOException {
        this(r2, r3, null);
    }

    public LockableFileWriter(File r2, boolean r3, String r4) throws IOException {
        this(r2, null, r3, r4);
    }

    public LockableFileWriter(File r3, String r4) throws IOException {
        this(r3, r4, false, null);
    }

    public LockableFileWriter(File r4, String r5, boolean r6, String r7) throws IOException {
        File r8 = r4.getAbsoluteFile();
        if (r8.getParentFile() == null) goto L6;
        FileUtils.forceMkdir(r8.getParentFile());
    L6:
        if (r8.isDirectory() == true) goto L12;
        if (r7 != null) goto L9;
        r7 = System.getProperty("java.io.tmpdir");
    L9:
        File r0 = new File(r7);
        FileUtils.forceMkdir(r0);
        testLockDir(r0);
        this.lockFile = new File(r0, new StringBuffer().append(r8.getName()).append(LCK).toString());
        createLock();
        this.out = initWriter(r8, r5, r6);
        return;
    L12:
        throw new IOException("File specified is a directory");
    }

    private void testLockDir(File r3) throws IOException {
        if (r3.exists() == false) goto L10;
        if (r3.canWrite() == false) goto L8;
        return;
    L8:
        throw new IOException(new StringBuffer("Could not write to lockDir: ").append(r3.getAbsolutePath()).toString());
    L10:
        throw new IOException(new StringBuffer("Could not find lockDir: ").append(r3.getAbsolutePath()).toString());
    }

    static /* synthetic */ Class class$(String r1) {
        return Class.forName(r1);
    L4:
        e = move-exception;
        throw new NoClassDefFoundError(e.getMessage());
    }

    private void createLock() throws IOException {
        Class r1 = class$org$apache$commons$io$output$LockableFileWriter;
        if (r1 != null) goto L5;
        r1 = class$("org.apache.commons.io.output.LockableFileWriter");
        class$org$apache$commons$io$output$LockableFileWriter = r1;
    L5:
        monitor-enter(r1);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.lockFile.createNewFile() == false) goto L12;
        this.lockFile.deleteOnExit();     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L12:
        throw new IOException(new StringBuffer("Can't write file, lock ").append(this.lockFile.getAbsolutePath()).append(" exists").toString());     // Catch: Throwable -> L13
    }

    private Writer initWriter(File r5, String r6, boolean r7) throws IOException {
        boolean r0 = r5.exists();
        if (r6 != null) goto L5;
        OutputStreamWriter r8 = new FileWriter(r5.getAbsolutePath(), r7);     // Catch: RuntimeException -> L13 IOException -> L19
    L25:
        return r8;
    L5:
        FileOutputStream r2 = new FileOutputStream(r5.getAbsolutePath(), r7);     // Catch: RuntimeException -> L13 IOException -> L19
        r8 = new OutputStreamWriter(r2, r6);     // Catch: RuntimeException -> L9 IOException -> L11
        goto L25
    L11:
        e = e;
    L21:
        IOUtils.closeQuietly(null);
        IOUtils.closeQuietly(r2);
        this.lockFile.delete();
        if (r0 == true) goto L24;
        r5.delete();
    L24:
        throw e;
    L9:
        e = e;
    L15:
        IOUtils.closeQuietly(null);
        IOUtils.closeQuietly(r2);
        this.lockFile.delete();
        if (r0 == true) goto L18;
        r5.delete();
    L18:
        throw e;
    L19:
        e = e;
        r2 = null;
    L13:
        e = e;
        r2 = null;
        goto L15
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();     // Catch: Throwable -> L5
        this.lockFile.delete();
        return;
    L5:
        th = move-exception;
        this.lockFile.delete();
        throw th;
    }

    @Override // java.io.Writer
    public void write(int r1) throws IOException {
        this.out.write(r1);
    }

    @Override // java.io.Writer
    public void write(char[] r1) throws IOException {
        this.out.write(r1);
    }

    @Override // java.io.Writer
    public void write(char[] r1, int r2, int r3) throws IOException {
        this.out.write(r1, r2, r3);
    }

    @Override // java.io.Writer
    public void write(String r1) throws IOException {
        this.out.write(r1);
    }

    @Override // java.io.Writer
    public void write(String r1, int r2, int r3) throws IOException {
        this.out.write(r1, r2, r3);
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }
}
