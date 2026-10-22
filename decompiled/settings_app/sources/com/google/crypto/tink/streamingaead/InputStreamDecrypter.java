package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.StreamingAead;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class InputStreamDecrypter extends InputStream {
    byte[] associatedData;
    boolean attemptedMatching;
    InputStream ciphertextStream;
    InputStream matchingStream;
    List<StreamingAead> primitives;

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public InputStreamDecrypter(List<StreamingAead> primitives, InputStream ciphertextStream, final byte[] associatedData) {
        this.attemptedMatching = false;
        this.matchingStream = null;
        this.primitives = primitives;
        if (ciphertextStream.markSupported() == false) goto L5;
        this.ciphertextStream = ciphertextStream;
    L6:
        this.ciphertextStream.mark(Integer.MAX_VALUE);
        this.associatedData = (byte[]) associatedData.clone();
        return;
    L5:
        this.ciphertextStream = new BufferedInputStream(ciphertextStream);
        goto L6
    }

    private void rewind() throws IOException {
        this.ciphertextStream.reset();
    }

    private void disableRewinding() throws IOException {
        this.ciphertextStream.mark(0);
    }

    @Override // java.io.InputStream
    public synchronized int available() throws IOException {
        monitor-enter(this);
        InputStream r0 = this.matchingStream;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        monitor-exit(this);
        return 0;
    L8:
        int r1 = r0.available();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        monitor-enter(this);
        byte[] r1 = new byte[1];     // Catch: Throwable -> L13
        if (read(r1) != 1) goto L10;
        int r0 = r1[0] & 255;
        monitor-exit(this);
        return r0;
    L10:
        monitor-exit(this);
        return -1;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] b) throws IOException {
        monitor-enter(this);
        int r3 = read(b, 0, b.length);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] b, int offset, int len) throws IOException {
        monitor-enter(this);
        if (len != 0) goto L34;
        monitor-exit(this);
        return 0;
    L34:
        InputStream r0 = this.matchingStream;     // Catch: Throwable -> L31
        if (r0 == null) goto L13;
        int r5 = r0.read(b, offset, len);     // Catch: Throwable -> L31
        monitor-exit(this);
        return r5;
    L13:
        if (this.attemptedMatching == true) goto L30;
        this.attemptedMatching = true;     // Catch: Throwable -> L31
        Iterator<StreamingAead> r1 = this.primitives.iterator();     // Catch: Throwable -> L31
    L16:
        if (r1.hasNext() == false) goto L28;
        StreamingAead r2 = r1.next();     // Catch: Throwable -> L31
        InputStream r3 = r2.newDecryptingStream(this.ciphertextStream, this.associatedData);     // Catch: GeneralSecurityException -> L25 IOException -> L26 Throwable -> L31
        int r4 = r3.read(b, offset, len);     // Catch: GeneralSecurityException -> L25 IOException -> L26 Throwable -> L31
        if (r4 == 0) goto L24;
        this.matchingStream = r3;     // Catch: GeneralSecurityException -> L25 IOException -> L26 Throwable -> L31
        disableRewinding();     // Catch: GeneralSecurityException -> L25 IOException -> L26 Throwable -> L31
        monitor-exit(this);
        return r4;
    L24:
        throw new IOException("Could not read bytes from the ciphertext stream");     // Catch: GeneralSecurityException -> L25 IOException -> L26 Throwable -> L31
    L26:
        rewind();     // Catch: Throwable -> L31
    L25:
        rewind();     // Catch: Throwable -> L31
        goto L16
    L28:
        throw new IOException("No matching key found for the ciphertext in the stream.");     // Catch: Throwable -> L31
    L30:
        throw new IOException("No matching key found for the ciphertext in the stream.");     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        monitor-enter(this);
        this.ciphertextStream.close();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
