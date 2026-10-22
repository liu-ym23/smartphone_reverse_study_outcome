package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
@ElementTypesAreNonnullByDefault
final class SipHashFunction extends AbstractHashFunction implements Serializable {
    static final HashFunction SIP_HASH_24 = null;
    private static final long serialVersionUID = 0;
    private final int c;
    private final int d;
    private final long k0;
    private final long k1;

    private static final class SipHasher extends AbstractStreamingHasher {
        private static final int CHUNK_SIZE = 8;
        private long b;
        private final int c;
        private final int d;
        private long finalM;
        private long v0;
        private long v1;
        private long v2;
        private long v3;

        SipHasher(int r3, int r4, long r5, long r7) {
            super(8);
            this.b = 0;
            this.finalM = 0;
            this.c = r3;
            this.d = r4;
            this.v0 = 8317987319222330741L ^ r5;
            this.v1 = 7237128888997146477L ^ r7;
            this.v2 = 7816392313619706465L ^ r5;
            this.v3 = 8387220255154660723L ^ r7;
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void process(ByteBuffer r5) {
            this.b += 8;
            processM(r5.getLong());
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void processRemaining(ByteBuffer r8) {
            this.b += (long) r8.remaining();
            int r0 = 0;
        L4:
            if (r8.hasRemaining() == false) goto L6;
            this.finalM ^= (((long) r8.get()) & 255) << r0;
            r0 = r0 + 8;
            goto L4
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected HashCode makeHash() {
            long r0 = this.finalM ^ (this.b << 56);
            this.finalM = r0;
            processM(r0);
            this.v2 ^= 255;
            sipRound(this.d);
            return HashCode.fromLong(((this.v0 ^ this.v1) ^ this.v2) ^ this.v3);
        }

        private void processM(long r3) {
            this.v3 ^= r3;
            sipRound(this.c);
            this.v0 = r3 ^ this.v0;
        }

        private void sipRound(int r9) {
            int r0 = 0;
        L3:
            if (r0 >= r9) goto L5;
            long r1 = this.v0;
            long r3 = this.v1;
            this.v0 = r1 + r3;
            this.v2 += this.v3;
            this.v1 = Long.rotateLeft(r3, 13);
            long r2 = Long.rotateLeft(this.v3, 16);
            long r4 = this.v1;
            long r5 = this.v0;
            this.v1 = r4 ^ r5;
            this.v3 = r2 ^ this.v2;
            long r6 = Long.rotateLeft(r5, 32);
            long r7 = this.v2;
            long r8 = this.v1;
            this.v2 = r7 + r8;
            this.v0 = r6 + this.v3;
            this.v1 = Long.rotateLeft(r8, 17);
            long r10 = Long.rotateLeft(this.v3, 21);
            long r11 = this.v1;
            long r12 = this.v2;
            this.v1 = r11 ^ r12;
            this.v3 = r10 ^ this.v0;
            this.v2 = Long.rotateLeft(r12, 32);
            r0 = r0 + 1;
            goto L3
        }
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    static {
        SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    }

    SipHashFunction(int r5, int r6, long r7, long r9) {
        boolean r0 = true;
        if (r5 <= 0) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkArgument(r2, "The number of SipRound iterations (c=%s) during Compression must be positive.", r5);
        if (r6 > 0) goto L10;
        r0 = false;
    L10:
        Preconditions.checkArgument(r0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", r6);
        this.c = r5;
        this.d = r6;
        this.k0 = r7;
        this.k1 = r9;
        return;
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new SipHasher(this.c, this.d, this.k0, this.k1);
    }

    public String toString() {
        int r0 = this.c;
        int r1 = this.d;
        long r2 = this.k0;
        long r4 = this.k1;
        return new StringBuilder(81).append("Hashing.sipHash").append(r0).append(r1).append("(").append(r2).append(", ").append(r4).append(")").toString();
    }

    public boolean equals(@CheckForNull Object r7) {
        if ((r7 instanceof SipHashFunction) == false) goto L14;
        SipHashFunction r8 = (SipHashFunction) r7;
        if (this.c == r8.c) goto L7;
        return false;
    L7:
        if (this.d == r8.d) goto L9;
        return false;
    L9:
        if (this.k0 == r8.k0) goto L11;
        return false;
    L11:
        if (this.k1 != r8.k1) goto L18;
        return true;
    L18:
        return false;
    L14:
        return false;
    }

    public int hashCode() {
        return (int) ((((long) ((getClass().hashCode() ^ this.c) ^ this.d)) ^ this.k0) ^ this.k1);
    }
}
