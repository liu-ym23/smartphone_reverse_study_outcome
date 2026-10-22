package com.google.crypto.tink.subtle;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
class StreamingAeadDecryptingStream extends FilterInputStream {
    private static final int PLAINTEXT_SEGMENT_EXTRA_SIZE = 16;
    private final byte[] aad;
    private final ByteBuffer ciphertextSegment;
    private final int ciphertextSegmentSize;
    private final StreamSegmentDecrypter decrypter;
    private boolean decryptionErrorOccured;
    private boolean endOfCiphertext;
    private boolean endOfPlaintext;
    private final int firstCiphertextSegmentSize;
    private final int headerLength;
    private boolean headerRead;
    private final ByteBuffer plaintextSegment;
    private int segmentNr;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public StreamingAeadDecryptingStream(NonceBasedStreamingAead streamAead, InputStream ciphertextStream, byte[] associatedData) throws GeneralSecurityException, IOException {
        super(ciphertextStream);
        this.decrypter = streamAead.newStreamSegmentDecrypter();
        this.headerLength = streamAead.getHeaderLength();
        this.aad = Arrays.copyOf(associatedData, associatedData.length);
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
        this.decryptionErrorOccured = false;
    }

    private void readHeader() throws IOException {
        if (this.headerRead == true) goto L22;
        ByteBuffer r0 = ByteBuffer.allocate(this.headerLength);
    L6:
        if (r0.remaining() <= 0) goto L15;
        int r1 = this.in.read(r0.array(), r0.position(), r0.remaining());
        if (r1 == (-1)) goto L13;
        if (r1 == 0) goto L12;
        r0.position(r0.position() + r1);
        goto L6
    L12:
        throw new IOException("Could not read bytes from the ciphertext stream");
    L13:
        setDecryptionErrorOccured();
        throw new IOException("Ciphertext is too short");
    L15:
        r0.flip();
        this.decrypter.init(r0, this.aad);     // Catch: GeneralSecurityException -> L19
        this.headerRead = true;
        return;
    L19:
        e = move-exception;
        throw new IOException(e);
    L22:
        setDecryptionErrorOccured();
        throw new IOException("Decryption failed.");
    }

    private void setDecryptionErrorOccured() {
        this.decryptionErrorOccured = true;
        this.plaintextSegment.limit(0);
    }

    private void loadSegment() throws IOException {
    L3:
        if (this.endOfCiphertext == true) goto L17;
        if (this.ciphertextSegment.remaining() <= 0) goto L17;
        int r0 = this.in.read(this.ciphertextSegment.array(), this.ciphertextSegment.position(), this.ciphertextSegment.remaining());
        if (r0 > 0) goto L8;
        if (r0 == (-1)) goto L11;
        if (r0 != 0) goto L3;
        throw new IOException("Could not read bytes from the ciphertext stream");
    L11:
        this.endOfCiphertext = true;
        goto L3
    L8:
        ByteBuffer r1 = this.ciphertextSegment;
        r1.position(r1.position() + r0);
    L17:
        if (this.endOfCiphertext == true) goto L19;
        ByteBuffer r2 = this.ciphertextSegment;
        byte r3 = r2.get(r2.position() - 1);
        ByteBuffer r4 = this.ciphertextSegment;
        r4.position(r4.position() - 1);
    L20:
        this.ciphertextSegment.flip();
        this.plaintextSegment.clear();
        this.decrypter.decryptSegment(this.ciphertextSegment, this.segmentNr, this.endOfCiphertext, this.plaintextSegment);     // Catch: GeneralSecurityException -> L26
        this.segmentNr++;
        this.plaintextSegment.flip();
        this.ciphertextSegment.clear();
        if (this.endOfCiphertext == true) goto L42;
        this.ciphertextSegment.clear();
        this.ciphertextSegment.limit(this.ciphertextSegmentSize + 1);
        this.ciphertextSegment.put(r3);
        return;
    L42:
        return;
    L26:
        e = move-exception;
        setDecryptionErrorOccured();
        throw new IOException(e.getMessage() + "\n" + toString() + "\nsegmentNr:" + this.segmentNr + " endOfCiphertext:" + this.endOfCiphertext, e);
    L19:
        r3 = 0;
        goto L20
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        byte[] r1 = new byte[1];
        int r3 = read(r1, 0, 1);
        if (r3 != 1) goto L7;
        return r1[0] & 255;
    L7:
        if (r3 != (-1)) goto L10;
        return r3;
    L10:
        throw new IOException("Reading failed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] dst) throws IOException {
        return read(dst, 0, dst.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] dst, int offset, int length) throws IOException {
        monitor-enter(this);
    L31:
        th = move-exception;
        throw th;
    L4:
        if (this.decryptionErrorOccured == true) goto L30;
        if (this.headerRead == true) goto L10;
        readHeader();     // Catch: Throwable -> L31
        this.ciphertextSegment.clear();     // Catch: Throwable -> L31
        this.ciphertextSegment.limit(this.firstCiphertextSegmentSize + 1);     // Catch: Throwable -> L31
    L10:
        if (this.endOfPlaintext == false) goto L13;
        monitor-exit(this);
        return -1;
    L13:
        int r0 = 0;
    L14:
        if (r0 >= length) goto L22;
        if (this.plaintextSegment.remaining() != 0) goto L21;
        if (this.endOfCiphertext == true) goto L19;
        loadSegment();     // Catch: Throwable -> L31
        goto L21
    L19:
        this.endOfPlaintext = true;     // Catch: Throwable -> L31
    L21:
        int r3 = Math.min(this.plaintextSegment.remaining(), length - r0);     // Catch: Throwable -> L31
        this.plaintextSegment.get(dst, r0 + offset, r3);     // Catch: Throwable -> L31
        r0 = r0 + r3;     // Catch: Throwable -> L31
    L22:
        if (r0 == 0) goto L24;
    L27:
        monitor-exit(this);
        return r0;
    L24:
        if (this.endOfPlaintext == false) goto L27;
        monitor-exit(this);
        return -1;
    L30:
        throw new IOException("Decryption failed.");     // Catch: Throwable -> L31
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        monitor-enter(this);
        super.close();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        monitor-enter(this);
        int r0 = this.plaintextSegment.remaining();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int readlimit) {
        monitor-enter(this);
        monitor-exit(this);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long n) throws IOException {
        long r0 = this.ciphertextSegmentSize;
        if (n > 0) goto L5;
        return 0;
    L5:
        int r1 = (int) Math.min(r0, n);
        byte[] r2 = new byte[r1];
        long r4 = n;
    L7:
        if (r4 <= 0) goto L13;
        int r6 = read(r2, 0, (int) Math.min(r1, r4));
        if (r6 <= 0) goto L13;
        r4 = r4 - ((long) r6);
    L13:
        return n - r4;
    }

    public synchronized String toString() {
        monitor-enter(this);
        StringBuilder r3 = new StringBuilder("StreamingAeadDecryptingStream\nsegmentNr:");     // Catch: Throwable -> L7
        r3.append(this.segmentNr).append("\nciphertextSegmentSize:").append(this.ciphertextSegmentSize).append("\nheaderRead:").append(this.headerRead).append("\nendOfCiphertext:").append(this.endOfCiphertext).append("\nendOfPlaintext:").append(this.endOfPlaintext).append("\ndecryptionErrorOccured:").append(this.decryptionErrorOccured).append("\nciphertextSgement position:").append(this.ciphertextSegment.position()).append(" limit:").append(this.ciphertextSegment.limit()).append("\nplaintextSegment position:").append(this.plaintextSegment.position()).append(" limit:").append(this.plaintextSegment.limit());     // Catch: Throwable -> L7
        String r0 = r3.toString();     // Catch: Throwable -> L7
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }
}
