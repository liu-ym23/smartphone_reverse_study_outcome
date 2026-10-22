package com.google.crypto.tink.subtle;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.WritableByteChannel;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
class StreamingAeadEncryptingChannel implements WritableByteChannel {
    private WritableByteChannel ciphertextChannel;
    ByteBuffer ctBuffer;
    private StreamSegmentEncrypter encrypter;
    boolean open;
    private int plaintextSegmentSize;
    ByteBuffer ptBuffer;

    public StreamingAeadEncryptingChannel(NonceBasedStreamingAead streamAead, WritableByteChannel ciphertextChannel, byte[] associatedData) throws GeneralSecurityException, IOException {
        this.open = true;
        this.ciphertextChannel = ciphertextChannel;
        this.encrypter = streamAead.newStreamSegmentEncrypter(associatedData);
        int r5 = streamAead.getPlaintextSegmentSize();
        this.plaintextSegmentSize = r5;
        ByteBuffer r6 = ByteBuffer.allocate(r5);
        this.ptBuffer = r6;
        r6.limit(this.plaintextSegmentSize - streamAead.getCiphertextOffset());
        ByteBuffer r3 = ByteBuffer.allocate(streamAead.getCiphertextSegmentSize());
        this.ctBuffer = r3;
        r3.put(this.encrypter.getHeader());
        this.ctBuffer.flip();
        ciphertextChannel.write(this.ctBuffer);
    }

    @Override // java.nio.channels.WritableByteChannel
    public synchronized int write(ByteBuffer pt) throws IOException {
        monitor-enter(this);
    L32:
        th = move-exception;
        throw th;
    L4:
        if (this.open == false) goto L31;
        if (this.ctBuffer.remaining() <= 0) goto L8;
        this.ciphertextChannel.write(this.ctBuffer);     // Catch: Throwable -> L32
    L8:
        int r0 = pt.position();     // Catch: Throwable -> L32
    L10:
        if (pt.remaining() <= this.ptBuffer.remaining()) goto L26;
        if (this.ctBuffer.remaining() > 0) goto L14;
        int r1 = this.ptBuffer.remaining();     // Catch: Throwable -> L32
        ByteBuffer r2 = pt.slice();     // Catch: Throwable -> L32
        r2.limit(r1);     // Catch: Throwable -> L32
        pt.position(pt.position() + r1);     // Catch: Throwable -> L32
        this.ptBuffer.flip();     // Catch: GeneralSecurityException -> L23 Throwable -> L32
        this.ctBuffer.clear();     // Catch: GeneralSecurityException -> L23 Throwable -> L32
        if (r2.remaining() == 0) goto L21;
        this.encrypter.encryptSegment(this.ptBuffer, r2, false, this.ctBuffer);     // Catch: GeneralSecurityException -> L23 Throwable -> L32
    L22:
        this.ctBuffer.flip();     // Catch: Throwable -> L32
        this.ciphertextChannel.write(this.ctBuffer);     // Catch: Throwable -> L32
        this.ptBuffer.clear();     // Catch: Throwable -> L32
        this.ptBuffer.limit(this.plaintextSegmentSize);     // Catch: Throwable -> L32
        goto L10
    L21:
        this.encrypter.encryptSegment(this.ptBuffer, false, this.ctBuffer);     // Catch: GeneralSecurityException -> L23 Throwable -> L32
        goto L22
    L23:
        e = move-exception;
        throw new IOException(e);     // Catch: Throwable -> L32
    L14:
        int r7 = pt.position() - r0;
        monitor-exit(this);
        return r7;
    L26:
        this.ptBuffer.put(pt);     // Catch: Throwable -> L32
        int r8 = pt.position() - r0;
        monitor-exit(this);
        return r8;
    L31:
        throw new ClosedChannelException();     // Catch: Throwable -> L32
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        monitor-enter(this);
    L29:
        th = move-exception;
        throw th;
    L4:
        if (this.open == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.ctBuffer.remaining() > 0) goto L10;
        this.ctBuffer.clear();     // Catch: GeneralSecurityException -> L26 Throwable -> L29
        this.ptBuffer.flip();     // Catch: GeneralSecurityException -> L26 Throwable -> L29
        this.encrypter.encryptSegment(this.ptBuffer, true, this.ctBuffer);     // Catch: GeneralSecurityException -> L26 Throwable -> L29
        this.ctBuffer.flip();     // Catch: Throwable -> L29
    L17:
        if (this.ctBuffer.remaining() <= 0) goto L23;
        if (this.ciphertextChannel.write(this.ctBuffer) > 0) goto L17;
        throw new IOException("Failed to write ciphertext before closing");     // Catch: Throwable -> L29
    L23:
        this.ciphertextChannel.close();     // Catch: Throwable -> L29
        this.open = false;     // Catch: Throwable -> L29
        monitor-exit(this);
        return;
    L26:
        e = move-exception;
        throw new IOException(e);     // Catch: Throwable -> L29
    L10:
        if (this.ciphertextChannel.write(this.ctBuffer) > 0) goto L8;
        throw new IOException("Failed to write ciphertext before closing");     // Catch: Throwable -> L29
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.open;
    }
}
