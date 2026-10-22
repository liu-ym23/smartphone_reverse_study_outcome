package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.StreamingAead;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.SeekableByteChannel;
import java.security.GeneralSecurityException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class SeekableByteChannelDecrypter implements SeekableByteChannel {
    byte[] associatedData;
    SeekableByteChannel attemptingChannel;
    long cachedPosition;
    SeekableByteChannel ciphertextChannel;
    SeekableByteChannel matchingChannel;
    Deque<StreamingAead> remainingPrimitives;
    long startingPosition;

    public SeekableByteChannelDecrypter(List<StreamingAead> allPrimitives, SeekableByteChannel ciphertextChannel, final byte[] associatedData) throws IOException {
        this.attemptingChannel = null;
        this.matchingChannel = null;
        this.remainingPrimitives = new ArrayDeque();
        Iterator<StreamingAead> r3 = allPrimitives.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        StreamingAead r0 = r3.next();
        this.remainingPrimitives.add(r0);
        goto L4
    L6:
        this.ciphertextChannel = ciphertextChannel;
        this.cachedPosition = -1;
        this.startingPosition = ciphertextChannel.position();
        this.associatedData = (byte[]) associatedData.clone();
    }

    private synchronized SeekableByteChannel nextAttemptingChannel() throws IOException {
        monitor-enter(this);
    L19:
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.remainingPrimitives.isEmpty() == true) goto L12;
        this.ciphertextChannel.position(this.startingPosition);     // Catch: Throwable -> L13
        StreamingAead r0 = this.remainingPrimitives.removeFirst();     // Catch: Throwable -> L13
        SeekableByteChannel r1 = r0.newSeekableDecryptingChannel(this.ciphertextChannel, this.associatedData);     // Catch: GeneralSecurityException -> L16 Throwable -> L13
        long r2 = this.cachedPosition;     // Catch: GeneralSecurityException -> L16 Throwable -> L13
        if (r2 < 0) goto L9;
        r1.position(r2);     // Catch: GeneralSecurityException -> L16 Throwable -> L13
    L9:
        monitor-exit(this);
        return r1;
    L12:
        throw new IOException("No matching key found for the ciphertext in the stream.");     // Catch: Throwable -> L13
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer dst) throws IOException {
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (dst.remaining() != 0) goto L8;
        monitor-exit(this);
        return 0;
    L8:
        SeekableByteChannel r0 = this.matchingChannel;     // Catch: Throwable -> L25
        if (r0 == null) goto L14;
        int r4 = r0.read(dst);     // Catch: Throwable -> L25
        monitor-exit(this);
        return r4;
    L14:
        if (this.attemptingChannel != null) goto L28;
        this.attemptingChannel = nextAttemptingChannel();     // Catch: Throwable -> L25
    L28:
        int r1 = this.attemptingChannel.read(dst);     // Catch: IOException -> L23 Throwable -> L25
        if (r1 == 0) goto L18;
        this.matchingChannel = this.attemptingChannel;     // Catch: IOException -> L23 Throwable -> L25
        this.attemptingChannel = null;     // Catch: IOException -> L23 Throwable -> L25
    L21:
        monitor-exit(this);
        return r1;
    L18:
        monitor-exit(this);
        return 0;
    L23:
        this.attemptingChannel = nextAttemptingChannel();     // Catch: Throwable -> L25
        goto L28
    }

    @Override // java.nio.channels.SeekableByteChannel
    public synchronized SeekableByteChannel position(long newPosition) throws IOException {
        monitor-enter(this);
        SeekableByteChannel r0 = this.matchingChannel;     // Catch: Throwable -> L15
        if (r0 == null) goto L7;
        r0.position(newPosition);     // Catch: Throwable -> L15
    L11:
        monitor-exit(this);
        return this;
    L7:
        if (newPosition < 0) goto L14;
        this.cachedPosition = newPosition;     // Catch: Throwable -> L15
        SeekableByteChannel r1 = this.attemptingChannel;     // Catch: Throwable -> L15
        if (r1 == null) goto L11;
        r1.position(newPosition);     // Catch: Throwable -> L15
        goto L11
    L14:
        throw new IllegalArgumentException("Position must be non-negative");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public synchronized long position() throws IOException {
        monitor-enter(this);
        SeekableByteChannel r0 = this.matchingChannel;     // Catch: Throwable -> L11
        if (r0 == null) goto L8;
        long r1 = r0.position();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    L8:
        long r2 = this.cachedPosition;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r2;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public synchronized long size() throws IOException {
        monitor-enter(this);
        SeekableByteChannel r0 = this.matchingChannel;     // Catch: Throwable -> L10
        if (r0 == null) goto L9;
        long r1 = r0.size();     // Catch: Throwable -> L10
        monitor-exit(this);
        return r1;
    L9:
        throw new IOException("Cannot determine size before first read()-call.");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public SeekableByteChannel truncate(long size) throws IOException {
        throw new NonWritableChannelException();
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.WritableByteChannel
    public int write(ByteBuffer src) throws IOException {
        throw new NonWritableChannelException();
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
}
