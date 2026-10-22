package org.apache.commons.io.output;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes6.dex */
public class DeferredFileOutputStream extends ThresholdingOutputStream {
    private boolean closed;
    private OutputStream currentOutputStream;
    private ByteArrayOutputStream memoryOutputStream;
    private File outputFile;

    public DeferredFileOutputStream(int r1, File r2) {
        super(r1);
        this.closed = false;
        this.outputFile = r2;
        ByteArrayOutputStream r3 = new ByteArrayOutputStream();
        this.memoryOutputStream = r3;
        this.currentOutputStream = r3;
    }

    @Override // org.apache.commons.io.output.ThresholdingOutputStream
    protected OutputStream getStream() throws IOException {
        return this.currentOutputStream;
    }

    @Override // org.apache.commons.io.output.ThresholdingOutputStream
    protected void thresholdReached() throws IOException {
        FileOutputStream r0 = new FileOutputStream(this.outputFile);
        this.memoryOutputStream.writeTo(r0);
        this.currentOutputStream = r0;
        this.memoryOutputStream = null;
    }

    public boolean isInMemory() {
        return !isThresholdExceeded();
    }

    public byte[] getData() {
        ByteArrayOutputStream r0 = this.memoryOutputStream;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.toByteArray();
    }

    public File getFile() {
        return this.outputFile;
    }

    @Override // org.apache.commons.io.output.ThresholdingOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        this.closed = true;
    }

    public void writeTo(OutputStream r2) throws IOException {
        if (this.closed == false) goto L15;
        if (isInMemory() == false) goto L7;
        this.memoryOutputStream.writeTo(r2);
        return;
    L7:
        FileInputStream r0 = new FileInputStream(this.outputFile);
        IOUtils.copy(r0, r2);     // Catch: Throwable -> L11
        IOUtils.closeQuietly(r0);
        return;
    L11:
        th = move-exception;
        IOUtils.closeQuietly(r0);
        throw th;
    L15:
        throw new IOException("Stream not closed");
    }
}
