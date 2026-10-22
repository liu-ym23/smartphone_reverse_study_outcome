package com.google.crypto.tink.subtle;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.SeekableByteChannel;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
class StreamingAeadSeekableDecryptingChannel implements SeekableByteChannel {
    private static final int PLAINTEXT_SEGMENT_EXTRA_SIZE = 16;
    private final byte[] aad;
    private final SeekableByteChannel ciphertextChannel;
    private final long ciphertextChannelSize;
    private final int ciphertextOffset;
    private final ByteBuffer ciphertextSegment;
    private final int ciphertextSegmentSize;
    private int currentSegmentNr;
    private final StreamSegmentDecrypter decrypter;
    private final int firstSegmentOffset;
    private final ByteBuffer header;
    private boolean headerRead;
    private boolean isCurrentSegmentDecrypted;
    private boolean isopen;
    private final int lastCiphertextSegmentSize;
    private final int numberOfSegments;
    private long plaintextPosition;
    private final ByteBuffer plaintextSegment;
    private final int plaintextSegmentSize;
    private long plaintextSize;

    public StreamingAeadSeekableDecryptingChannel(NonceBasedStreamingAead streamAead, SeekableByteChannel ciphertext, byte[] associatedData) throws IOException, GeneralSecurityException {
        this.decrypter = streamAead.newStreamSegmentDecrypter();
        this.ciphertextChannel = ciphertext;
        this.header = ByteBuffer.allocate(streamAead.getHeaderLength());
        int r0 = streamAead.getCiphertextSegmentSize();
        this.ciphertextSegmentSize = r0;
        this.ciphertextSegment = ByteBuffer.allocate(r0);
        int r1 = streamAead.getPlaintextSegmentSize();
        this.plaintextSegmentSize = r1;
        this.plaintextSegment = ByteBuffer.allocate(r1 + 16);
        this.plaintextPosition = 0;
        this.headerRead = false;
        this.currentSegmentNr = -1;
        this.isCurrentSegmentDecrypted = false;
        long r2 = ciphertext.size();
        this.ciphertextChannelSize = r2;
        this.aad = Arrays.copyOf(associatedData, associatedData.length);
        this.isopen = ciphertext.isOpen();
        int r10 = (int) (r2 / ((long) r0));
        int r11 = (int) (r2 % ((long) r0));
        int r3 = streamAead.getCiphertextOverhead();
        if (r11 <= 0) goto L9;
        this.numberOfSegments = r10 + 1;
        if (r11 < r3) goto L8;
        this.lastCiphertextSegmentSize = r11;
    L10:
        int r12 = streamAead.getCiphertextOffset();
        this.ciphertextOffset = r12;
        int r9 = r12 - streamAead.getHeaderLength();
        this.firstSegmentOffset = r9;
        if (r9 < 0) goto L19;
        long r4 = (((long) this.numberOfSegments) * ((long) r3)) + ((long) r12);
        if (r4 > r2) goto L17;
        this.plaintextSize = r2 - r4;
        return;
    L17:
        throw new IOException("Ciphertext is too short");
    L19:
        throw new IOException("Invalid ciphertext offset or header length");
    L8:
        throw new IOException("Invalid ciphertext size");
    L9:
        this.numberOfSegments = r10;
        this.lastCiphertextSegmentSize = r0;
        goto L10
    }

    public synchronized String toString() {
        monitor-enter(this);
        StringBuilder r5 = new StringBuilder("StreamingAeadSeekableDecryptingChannel\nciphertextChannel");     // Catch: Throwable -> L11
        String r3 = "position:" + this.ciphertextChannel.position();     // Catch: IOException -> L7 Throwable -> L11
    L8:
        r5.append(r3).append("\nciphertextChannelSize:").append(this.ciphertextChannelSize).append("\nplaintextSize:").append(this.plaintextSize).append("\nciphertextSegmentSize:").append(this.ciphertextSegmentSize).append("\nnumberOfSegments:").append(this.numberOfSegments).append("\nheaderRead:").append(this.headerRead).append("\nplaintextPosition:").append(this.plaintextPosition).append("\nHeader position:").append(this.header.position()).append(" limit:").append(this.header.position()).append("\ncurrentSegmentNr:").append(this.currentSegmentNr).append("\nciphertextSgement position:").append(this.ciphertextSegment.position()).append(" limit:").append(this.ciphertextSegment.limit()).append("\nisCurrentSegmentDecrypted:").append(this.isCurrentSegmentDecrypted).append("\nplaintextSegment position:").append(this.plaintextSegment.position()).append(" limit:").append(this.plaintextSegment.limit());     // Catch: Throwable -> L11
        String r0 = r5.toString();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r0;
    L7:
        r3 = "position: n/a";
    L11:
        th = move-exception;
        throw th;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public synchronized long position() {
        monitor-enter(this);
        long r0 = this.plaintextPosition;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public synchronized SeekableByteChannel position(long newPosition) {
        monitor-enter(this);
        this.plaintextPosition = newPosition;     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    private boolean tryReadHeader() throws IOException {
        this.ciphertextChannel.position(this.header.position() + this.firstSegmentOffset);
        this.ciphertextChannel.read(this.header);
        if (this.header.remaining() <= 0) goto L6;
        return false;
    L6:
        this.header.flip();
        this.decrypter.init(this.header, this.aad);     // Catch: GeneralSecurityException -> L9
        this.headerRead = true;     // Catch: GeneralSecurityException -> L9
        return true;
    L9:
        e = move-exception;
        throw new IOException(e);
    }

    private int getSegmentNr(long plaintextPosition) {
        return (int) ((plaintextPosition + ((long) this.ciphertextOffset)) / ((long) this.plaintextSegmentSize));
    }

    private boolean tryLoadSegment(int segmentNr) throws IOException {
        if (segmentNr < 0) goto L34;
        int r0 = this.numberOfSegments;
        if (segmentNr >= r0) goto L34;
        if (segmentNr != (r0 - 1)) goto L8;
        boolean r1 = true;
    L10:
        if (segmentNr == this.currentSegmentNr) goto L12;
        int r5 = this.ciphertextSegmentSize;
        long r3 = ((long) segmentNr) * ((long) r5);
        if (r1 == false) goto L17;
        r5 = this.lastCiphertextSegmentSize;
    L17:
        if (segmentNr != 0) goto L19;
        int r4 = this.ciphertextOffset;
        r5 = r5 - r4;
        r3 = r4;
    L19:
        this.ciphertextChannel.position(r3);
        this.ciphertextSegment.clear();
        this.ciphertextSegment.limit(r5);
        this.currentSegmentNr = segmentNr;
        this.isCurrentSegmentDecrypted = false;
    L21:
        if (this.ciphertextSegment.remaining() <= 0) goto L24;
        this.ciphertextChannel.read(this.ciphertextSegment);
    L24:
        if (this.ciphertextSegment.remaining() <= 0) goto L26;
        return false;
    L26:
        this.ciphertextSegment.flip();
        this.plaintextSegment.clear();
        this.decrypter.decryptSegment(this.ciphertextSegment, segmentNr, r1, this.plaintextSegment);     // Catch: GeneralSecurityException -> L30
        this.plaintextSegment.flip();
        this.isCurrentSegmentDecrypted = true;
        return true;
    L30:
        e = move-exception;
        this.currentSegmentNr = -1;
        throw new IOException("Failed to decrypt", e);
    L12:
        if (this.isCurrentSegmentDecrypted == false) goto L21;
        return true;
    L8:
        r1 = false;
    L34:
        throw new IOException("Invalid position");
    }

    private boolean reachedEnd() {
        if (this.isCurrentSegmentDecrypted == true) goto L5;
    L9:
        return false;
    L5:
        if (this.currentSegmentNr != (this.numberOfSegments - 1)) goto L9;
        if (this.plaintextSegment.remaining() != 0) goto L9;
        return true;
    }

    public synchronized int read(ByteBuffer dst, long start) throws IOException {
        monitor-enter(this);
        long r0 = position();     // Catch: Throwable -> L11
        position(start);     // Catch: Throwable -> L8
        int r3 = read(dst);     // Catch: Throwable -> L8
        position(r0);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r3;
    L8:
        th = move-exception;
        position(r0);     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer dst) throws IOException {
        monitor-enter(this);
    L39:
        th = move-exception;
        throw th;
    L4:
        if (this.isopen == false) goto L38;
        if (this.headerRead == false) goto L8;
    L12:
        int r0 = dst.position();     // Catch: Throwable -> L39
    L14:
        if (dst.remaining() <= 0) goto L28;
        long r1 = this.plaintextPosition;     // Catch: Throwable -> L39
        if (r1 >= this.plaintextSize) goto L28;
        int r2 = getSegmentNr(r1);     // Catch: Throwable -> L39
        if (r2 != 0) goto L21;
        long r3 = this.plaintextPosition;     // Catch: Throwable -> L39
    L20:
        int r4 = (int) r3;     // Catch: Throwable -> L39
        if (tryLoadSegment(r2) == false) goto L28;
        this.plaintextSegment.position(r4);     // Catch: Throwable -> L39
        if (this.plaintextSegment.remaining() <= dst.remaining()) goto L26;
        int r5 = dst.remaining();     // Catch: Throwable -> L39
        ByteBuffer r6 = this.plaintextSegment.duplicate();     // Catch: Throwable -> L39
        r6.limit(r6.position() + r5);     // Catch: Throwable -> L39
        dst.put(r6);     // Catch: Throwable -> L39
        this.plaintextPosition += (long) r5;     // Catch: Throwable -> L39
        ByteBuffer r7 = this.plaintextSegment;     // Catch: Throwable -> L39
        r7.position(r7.position() + r5);     // Catch: Throwable -> L39
        goto L14
    L26:
        this.plaintextPosition += (long) this.plaintextSegment.remaining();     // Catch: Throwable -> L39
        dst.put(this.plaintextSegment);     // Catch: Throwable -> L39
        goto L14
    L21:
        r3 = (this.plaintextPosition + ((long) this.ciphertextOffset)) % ((long) this.plaintextSegmentSize);     // Catch: Throwable -> L39
    L28:
        int r8 = dst.position() - r0;     // Catch: Throwable -> L39
        if (r8 == 0) goto L31;
    L35:
        monitor-exit(this);
        return r8;
    L31:
        if (reachedEnd() == false) goto L35;
        monitor-exit(this);
        return -1;
    L8:
        if (tryReadHeader() == true) goto L12;
        monitor-exit(this);
        return 0;
    L38:
        throw new ClosedChannelException();     // Catch: Throwable -> L39
    }

    @Override // java.nio.channels.SeekableByteChannel
    public long size() {
        return this.plaintextSize;
    }

    public synchronized long verifiedSize() throws IOException {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (tryLoadSegment(this.numberOfSegments - 1) == false) goto L9;
        long r0 = this.plaintextSize;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r0;
    L9:
        throw new IOException("could not verify the size");     // Catch: Throwable -> L10
    }

    @Override // java.nio.channels.SeekableByteChannel
    public SeekableByteChannel truncate(long size) throws NonWritableChannelException {
        throw new NonWritableChannelException();
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.WritableByteChannel
    public int write(ByteBuffer src) throws NonWritableChannelException {
        throw new NonWritableChannelException();
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        monitor-enter(this);
        this.ciphertextChannel.close();     // Catch: Throwable -> L6
        this.isopen = false;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.nio.channels.Channel
    public synchronized boolean isOpen() {
        monitor-enter(this);
        boolean r0 = this.isopen;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }
}
