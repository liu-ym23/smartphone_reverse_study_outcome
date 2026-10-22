package com.google.crypto.tink.subtle;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
class StreamingAeadDecryptingChannel implements ReadableByteChannel {
    private static final int PLAINTEXT_SEGMENT_EXTRA_SIZE = 16;
    private final byte[] associatedData;
    private ReadableByteChannel ciphertextChannel;
    private ByteBuffer ciphertextSegment;
    private final int ciphertextSegmentSize;
    private final StreamSegmentDecrypter decrypter;
    private boolean definedState;
    private boolean endOfCiphertext;
    private boolean endOfPlaintext;
    private final int firstCiphertextSegmentSize;
    private ByteBuffer header;
    private boolean headerRead;
    private ByteBuffer plaintextSegment;
    private int segmentNr;

    public StreamingAeadDecryptingChannel(NonceBasedStreamingAead streamAead, ReadableByteChannel ciphertextChannel, byte[] associatedData) throws GeneralSecurityException, IOException {
        this.decrypter = streamAead.newStreamSegmentDecrypter();
        this.ciphertextChannel = ciphertextChannel;
        this.header = ByteBuffer.allocate(streamAead.getHeaderLength());
        this.associatedData = Arrays.copyOf(associatedData, associatedData.length);
        int r3 = streamAead.getCiphertextSegmentSize();
        this.ciphertextSegmentSize = r3;
        ByteBuffer r4 = ByteBuffer.allocate(r3 + 1);
        this.ciphertextSegment = r4;
        r4.limit(0);
        this.firstCiphertextSegmentSize = r3 - streamAead.getCiphertextOffset();
        ByteBuffer r2 = ByteBuffer.allocate(streamAead.getPlaintextSegmentSize() + 16);
        this.plaintextSegment = r2;
        r2.limit(0);
        this.headerRead = false;
        this.endOfCiphertext = false;
        this.endOfPlaintext = false;
        this.segmentNr = 0;
        this.definedState = true;
    }

    private void readSomeCiphertext(ByteBuffer buffer) throws IOException {
    L2:
        int r0 = this.ciphertextChannel.read(buffer);
        if (r0 <= 0) goto L7;
        if (buffer.remaining() > 0) goto L2;
    L7:
        if (r0 != (-1)) goto L13;
        this.endOfCiphertext = true;
        return;
    }

    private boolean tryReadHeader() throws IOException {
        if (this.endOfCiphertext == true) goto L15;
        readSomeCiphertext(this.header);
        if (this.header.remaining() <= 0) goto L8;
        return false;
    L8:
        this.header.flip();
        this.decrypter.init(this.header, this.associatedData);     // Catch: GeneralSecurityException -> L11
        this.headerRead = true;     // Catch: GeneralSecurityException -> L11
        return true;
    L11:
        e = move-exception;
        setUndefinedState();
        throw new IOException(e);
    L15:
        throw new IOException("Ciphertext is too short");
    }

    private void setUndefinedState() {
        this.definedState = false;
        this.plaintextSegment.limit(0);
    }

    private boolean tryLoadSegment() throws IOException {
        if (this.endOfCiphertext == true) goto L5;
        readSomeCiphertext(this.ciphertextSegment);
    L5:
        byte r1 = 0;
        if (this.ciphertextSegment.remaining() <= 0) goto L11;
        if (this.endOfCiphertext == true) goto L11;
        return false;
    L11:
        if (this.endOfCiphertext == true) goto L13;
        ByteBuffer r0 = this.ciphertextSegment;
        r1 = r0.get(r0.position() - 1);
        ByteBuffer r2 = this.ciphertextSegment;
        r2.position(r2.position() - 1);
    L13:
        this.ciphertextSegment.flip();
        this.plaintextSegment.clear();
        this.decrypter.decryptSegment(this.ciphertextSegment, this.segmentNr, this.endOfCiphertext, this.plaintextSegment);     // Catch: GeneralSecurityException -> L19
        this.segmentNr++;
        this.plaintextSegment.flip();
        this.ciphertextSegment.clear();
        if (this.endOfCiphertext == true) goto L18;
        this.ciphertextSegment.clear();
        this.ciphertextSegment.limit(this.ciphertextSegmentSize + 1);
        this.ciphertextSegment.put(r1);
    L18:
        return true;
    L19:
        e = move-exception;
        setUndefinedState();
        throw new IOException(e.getMessage() + "\n" + toString() + "\nsegmentNr:" + this.segmentNr + " endOfCiphertext:" + this.endOfCiphertext, e);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer dst) throws IOException {
        monitor-enter(this);
    L43:
        th = move-exception;
        throw th;
    L4:
        if (this.definedState == false) goto L42;
        if (this.headerRead == true) goto L15;
        if (tryReadHeader() == true) goto L12;
        monitor-exit(this);
        return 0;
    L12:
        this.ciphertextSegment.clear();     // Catch: Throwable -> L43
        this.ciphertextSegment.limit(this.firstCiphertextSegmentSize + 1);     // Catch: Throwable -> L43
    L15:
        if (this.endOfPlaintext == false) goto L18;
        monitor-exit(this);
        return -1;
    L18:
        int r0 = dst.position();     // Catch: Throwable -> L43
    L20:
        if (dst.remaining() <= 0) goto L33;
        if (this.plaintextSegment.remaining() != 0) goto L30;
        if (this.endOfCiphertext == true) goto L25;
        if (tryLoadSegment() == true) goto L30;
    L25:
        this.endOfPlaintext = true;     // Catch: Throwable -> L43
    L30:
        if (this.plaintextSegment.remaining() <= dst.remaining()) goto L31;
        int r3 = dst.remaining();     // Catch: Throwable -> L43
        ByteBuffer r4 = this.plaintextSegment.duplicate();     // Catch: Throwable -> L43
        r4.limit(r4.position() + r3);     // Catch: Throwable -> L43
        dst.put(r4);     // Catch: Throwable -> L43
        ByteBuffer r5 = this.plaintextSegment;     // Catch: Throwable -> L43
        r5.position(r5.position() + r3);     // Catch: Throwable -> L43
        goto L20
    L31:
        dst.put(this.plaintextSegment);     // Catch: Throwable -> L43
    L33:
        int r7 = dst.position() - r0;     // Catch: Throwable -> L43
        if (r7 == 0) goto L36;
    L39:
        monitor-exit(this);
        return r7;
    L36:
        if (this.endOfPlaintext == false) goto L39;
        monitor-exit(this);
        return -1;
    L42:
        throw new IOException("This StreamingAeadDecryptingChannel is in an undefined state");     // Catch: Throwable -> L43
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        monitor-enter(this);
        this.ciphertextChannel.close();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.nio.channels.Channel
    public synchronized boolean isOpen() {
        monitor-enter(this);
        boolean r0 = this.ciphertextChannel.isOpen();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized String toString() {
        monitor-enter(this);
        StringBuilder r4 = new StringBuilder("StreamingAeadDecryptingChannel\nsegmentNr:");     // Catch: Throwable -> L7
        r4.append(this.segmentNr).append("\nciphertextSegmentSize:").append(this.ciphertextSegmentSize).append("\nheaderRead:").append(this.headerRead).append("\nendOfCiphertext:").append(this.endOfCiphertext).append("\nendOfPlaintext:").append(this.endOfPlaintext).append("\ndefinedState:").append(this.definedState).append("\nHeader position:").append(this.header.position()).append(" limit:").append(this.header.position()).append("\nciphertextSgement position:").append(this.ciphertextSegment.position()).append(" limit:").append(this.ciphertextSegment.limit()).append("\nplaintextSegment position:").append(this.plaintextSegment.position()).append(" limit:").append(this.plaintextSegment.limit());     // Catch: Throwable -> L7
        String r0 = r4.toString();     // Catch: Throwable -> L7
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }
}
