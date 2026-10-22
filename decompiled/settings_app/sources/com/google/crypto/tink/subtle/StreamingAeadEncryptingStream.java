package com.google.crypto.tink.subtle;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
class StreamingAeadEncryptingStream extends FilterOutputStream {
    ByteBuffer ctBuffer;
    private StreamSegmentEncrypter encrypter;
    boolean open;
    private int plaintextSegmentSize;
    ByteBuffer ptBuffer;

    public StreamingAeadEncryptingStream(NonceBasedStreamingAead streamAead, OutputStream ciphertextChannel, byte[] associatedData) throws GeneralSecurityException, IOException {
        super(ciphertextChannel);
        this.encrypter = streamAead.newStreamSegmentEncrypter(associatedData);
        int r2 = streamAead.getPlaintextSegmentSize();
        this.plaintextSegmentSize = r2;
        this.ptBuffer = ByteBuffer.allocate(r2);
        this.ctBuffer = ByteBuffer.allocate(streamAead.getCiphertextSegmentSize());
        this.ptBuffer.limit(this.plaintextSegmentSize - streamAead.getCiphertextOffset());
        ByteBuffer r1 = this.encrypter.getHeader();
        byte[] r3 = new byte[r1.remaining()];
        r1.get(r3);
        this.out.write(r3);
        this.open = true;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int b) throws IOException {
        write(new byte[]{(byte) b});
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] pt, int offset, int length) throws IOException {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (this.open == false) goto L18;
    L6:
        if (length <= this.ptBuffer.remaining()) goto L14;
        int r0 = this.ptBuffer.remaining();     // Catch: Throwable -> L19
        ByteBuffer r1 = ByteBuffer.wrap(pt, offset, r0);     // Catch: Throwable -> L19
        offset = offset + r0;
        length = length - r0;
        this.ptBuffer.flip();     // Catch: GeneralSecurityException -> L11 Throwable -> L19
        this.ctBuffer.clear();     // Catch: GeneralSecurityException -> L11 Throwable -> L19
        this.encrypter.encryptSegment(this.ptBuffer, r1, false, this.ctBuffer);     // Catch: GeneralSecurityException -> L11 Throwable -> L19
        this.ctBuffer.flip();     // Catch: Throwable -> L19
        this.out.write(this.ctBuffer.array(), this.ctBuffer.position(), this.ctBuffer.remaining());     // Catch: Throwable -> L19
        this.ptBuffer.clear();     // Catch: Throwable -> L19
        this.ptBuffer.limit(this.plaintextSegmentSize);     // Catch: Throwable -> L19
        goto L6
    L11:
        e = move-exception;
        throw new IOException(e);     // Catch: Throwable -> L19
    L14:
        this.ptBuffer.put(pt, offset, length);     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L18:
        throw new IOException("Trying to write to closed stream");     // Catch: Throwable -> L19
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.open == true) goto L18;
        monitor-exit(this);
        return;
    L18:
        this.ptBuffer.flip();     // Catch: GeneralSecurityException -> L12 Throwable -> L15
        this.ctBuffer.clear();     // Catch: GeneralSecurityException -> L12 Throwable -> L15
        this.encrypter.encryptSegment(this.ptBuffer, true, this.ctBuffer);     // Catch: GeneralSecurityException -> L12 Throwable -> L15
        this.ctBuffer.flip();     // Catch: Throwable -> L15
        this.out.write(this.ctBuffer.array(), this.ctBuffer.position(), this.ctBuffer.remaining());     // Catch: Throwable -> L15
        this.open = false;     // Catch: Throwable -> L15
        super.close();     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L12:
        e = move-exception;
        throw new IOException("ptBuffer.remaining():" + this.ptBuffer.remaining() + " ctBuffer.remaining():" + this.ctBuffer.remaining(), e);     // Catch: Throwable -> L15
    }
}
