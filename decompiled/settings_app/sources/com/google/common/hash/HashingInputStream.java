package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class HashingInputStream extends FilterInputStream {
    private final Hasher hasher;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int r1) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public HashingInputStream(HashFunction r1, InputStream r2) {
        super((InputStream) Preconditions.checkNotNull(r2));
        this.hasher = (Hasher) Preconditions.checkNotNull(r1.newHasher());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int r0 = this.in.read();
        if (r0 == (-1)) goto L5;
        this.hasher.putByte((byte) r0);
    L5:
        return r0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r2, int r3, int r4) throws IOException {
        int r5 = this.in.read(r2, r3, r4);
        if (r5 == (-1)) goto L5;
        this.hasher.putBytes(r2, r3, r5);
    L5:
        return r5;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new IOException("reset not supported");
    }

    public HashCode hash() {
        return this.hasher.hash();
    }
}
