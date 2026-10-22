package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.subtle.RewindableReadableByteChannel;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.security.GeneralSecurityException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class ReadableByteChannelDecrypter implements ReadableByteChannel {
    byte[] associatedData;
    ReadableByteChannel attemptingChannel;
    RewindableReadableByteChannel ciphertextChannel;
    ReadableByteChannel matchingChannel;
    Deque<StreamingAead> remainingPrimitives;

    public ReadableByteChannelDecrypter(List<StreamingAead> allPrimitives, ReadableByteChannel ciphertextChannel, final byte[] associatedData) {
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
        this.ciphertextChannel = new RewindableReadableByteChannel(ciphertextChannel);
        this.associatedData = (byte[]) associatedData.clone();
    }

    private synchronized ReadableByteChannel nextAttemptingChannel() throws IOException {
        monitor-enter(this);
    L15:
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.remainingPrimitives.isEmpty() == true) goto L11;
        StreamingAead r0 = this.remainingPrimitives.removeFirst();     // Catch: Throwable -> L12
        ReadableByteChannel r1 = r0.newDecryptingChannel(this.ciphertextChannel, this.associatedData);     // Catch: GeneralSecurityException -> L9 Throwable -> L12
    L7:
        monitor-exit(this);
        return r1;
    L9:
        this.ciphertextChannel.rewind();     // Catch: Throwable -> L12
        goto L15
    L11:
        throw new IOException("No matching key found for the ciphertext in the stream.");     // Catch: Throwable -> L12
    }

    @Override // java.nio.channels.ReadableByteChannel
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
        ReadableByteChannel r0 = this.matchingChannel;     // Catch: Throwable -> L25
        if (r0 == null) goto L14;
        int r4 = r0.read(dst);     // Catch: Throwable -> L25
        monitor-exit(this);
        return r4;
    L14:
        if (this.attemptingChannel != null) goto L29;
        this.attemptingChannel = nextAttemptingChannel();     // Catch: Throwable -> L25
    L29:
        int r1 = this.attemptingChannel.read(dst);     // Catch: IOException -> L23 Throwable -> L25
        if (r1 == 0) goto L18;
        this.matchingChannel = this.attemptingChannel;     // Catch: IOException -> L23 Throwable -> L25
        this.attemptingChannel = null;     // Catch: IOException -> L23 Throwable -> L25
        this.ciphertextChannel.disableRewinding();     // Catch: IOException -> L23 Throwable -> L25
    L21:
        monitor-exit(this);
        return r1;
    L18:
        monitor-exit(this);
        return 0;
    L23:
        this.ciphertextChannel.rewind();     // Catch: Throwable -> L25
        this.attemptingChannel = nextAttemptingChannel();     // Catch: Throwable -> L25
        goto L29
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
