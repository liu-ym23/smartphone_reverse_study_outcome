package com.google.common.hash;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
@ElementTypesAreNonnullByDefault
final class Murmur3_32HashFunction extends AbstractHashFunction implements Serializable {
    private static final int C1 = -862048943;
    private static final int C2 = 461845907;
    private static final int CHUNK_SIZE = 4;
    static final HashFunction GOOD_FAST_HASH_32 = null;
    static final HashFunction MURMUR3_32 = null;
    static final HashFunction MURMUR3_32_FIXED = null;
    private static final long serialVersionUID = 0;
    private final int seed;
    private final boolean supplementaryPlaneFix;

    private static final class Murmur3_32Hasher extends AbstractHasher {
        private long buffer;
        private int h1;
        private boolean isDone;
        private int length;
        private int shift;

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public /* bridge */ /* synthetic */ PrimitiveSink putByte(byte r1) {
            return putByte(r1);
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public /* bridge */ /* synthetic */ PrimitiveSink putBytes(ByteBuffer r1) {
            return putBytes(r1);
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public /* bridge */ /* synthetic */ PrimitiveSink putBytes(byte[] r1, int r2, int r3) {
            return putBytes(r1, r2, r3);
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public /* bridge */ /* synthetic */ PrimitiveSink putChar(char r1) {
            return putChar(r1);
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public /* bridge */ /* synthetic */ PrimitiveSink putInt(int r1) {
            return putInt(r1);
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public /* bridge */ /* synthetic */ PrimitiveSink putLong(long r1) {
            return putLong(r1);
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public /* bridge */ /* synthetic */ PrimitiveSink putString(CharSequence r1, Charset r2) {
            return putString(r1, r2);
        }

        Murmur3_32Hasher(int r1) {
            this.h1 = r1;
            this.length = 0;
            this.isDone = false;
        }

        private void update(int r5, long r6) {
            long r0 = this.buffer;
            int r2 = this.shift;
            long r7 = ((r6 & 4294967295L) << r2) | r0;
            this.buffer = r7;
            int r3 = r2 + (r5 * 8);
            this.shift = r3;
            this.length += r5;
            if (r3 < 32) goto L6;
            this.h1 = Murmur3_32HashFunction.access$100(this.h1, Murmur3_32HashFunction.access$000((int) r7));
            this.buffer >>>= 32;
            this.shift -= 32;
            return;
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putByte(byte r3) {
            update(1, r3 & 255);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putBytes(byte[] r5, int r6, int r7) {
            Preconditions.checkPositionIndexes(r6, r6 + r7, r5.length);
            int r0 = 0;
        L3:
            int r1 = r0 + 4;
            if (r1 > r7) goto L6;
            update(4, Murmur3_32HashFunction.access$200(r5, r0 + r6));
            r0 = r1;
        L6:
            if (r0 >= r7) goto L8;
            putByte(r5[r6 + r0]);
            r0 = r0 + 1;
            goto L6
        L8:
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putBytes(ByteBuffer r4) {
            ByteOrder r0 = r4.order();
            r4.order(ByteOrder.LITTLE_ENDIAN);
        L4:
            if (r4.remaining() < 4) goto L7;
            putInt(r4.getInt());
        L7:
            if (r4.hasRemaining() == false) goto L9;
            putByte(r4.get());
            goto L7
        L9:
            r4.order(r0);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putInt(int r4) {
            update(4, r4);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putLong(long r4) {
            update(4, (int) r4);
            update(4, r4 >>> 32);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putChar(char r4) {
            update(2, r4);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putString(CharSequence r10, Charset r11) {
            if (Charsets.UTF_8.equals(r11) == false) goto L34;
            int r0 = r10.length();
            int r1 = 0;
        L5:
            int r2 = r1 + 4;
            if (r2 > r0) goto L13;
            char r5 = r10.charAt(r1);
            char r6 = r10.charAt(r1 + 1);
            char r7 = r10.charAt(r1 + 2);
            char r8 = r10.charAt(r1 + 3);
            if (r5 >= 128) goto L13;
            if (r6 >= 128) goto L13;
            if (r7 >= 128) goto L13;
            if (r8 >= 128) goto L13;
            update(4, (((r6 << '\b') | r5) | (r7 << 16)) | (r8 << 24));
            r1 = r2;
        L13:
            if (r1 >= r0) goto L32;
            char r3 = r10.charAt(r1);
            if (r3 >= 128) goto L18;
            update(1, r3);
        L31:
            r1 = r1 + 1;
            goto L13
        L18:
            if (r3 >= 2048) goto L21;
            update(2, Murmur3_32HashFunction.access$300(r3));
            goto L31
        L21:
            if (r3 >= 55296) goto L23;
        L30:
            update(3, Murmur3_32HashFunction.access$400(r3));
            goto L31
        L23:
            if (r3 > 57343) goto L30;
            int r9 = Character.codePointAt(r10, r1);
            if (r9 == r3) goto L27;
            r1 = r1 + 1;
            update(4, Murmur3_32HashFunction.access$500(r9));
            goto L31
        L27:
            putBytes(r10.subSequence(r1, r0).toString().getBytes(r11));
            return this;
        L32:
            return this;
        L34:
            return super.putString(r10, r11);
        }

        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            Preconditions.checkState(!this.isDone);
            this.isDone = true;
            int r0 = this.h1 ^ Murmur3_32HashFunction.access$000((int) this.buffer);
            this.h1 = r0;
            return Murmur3_32HashFunction.access$600(r0, this.length);
        }
    }

    private static long charToThreeUtf8Bytes(char r4) {
        return ((((long) (r4 >>> '\f')) | 224) | ((long) ((((r4 >>> 6) & 63) | 128) << 8))) | ((long) (((r4 & '?') | 128) << 16));
    }

    private static long charToTwoUtf8Bytes(char r4) {
        return (((long) (r4 >>> 6)) | 192) | ((long) (((r4 & '?') | 128) << 8));
    }

    private static long codePointToFourUtf8Bytes(int r7) {
        return (((((long) (r7 >>> 18)) | 240) | ((((long) ((r7 >>> 12) & 63)) | 128) << 8)) | ((((long) ((r7 >>> 6) & 63)) | 128) << 16)) | ((((long) (r7 & 63)) | 128) << 24);
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 32;
    }

    static /* synthetic */ int access$000(int r0) {
        return mixK1(r0);
    }

    static /* synthetic */ int access$100(int r0, int r1) {
        return mixH1(r0, r1);
    }

    static /* synthetic */ int access$200(byte[] r0, int r1) {
        return getIntLittleEndian(r0, r1);
    }

    static /* synthetic */ long access$300(char r2) {
        return charToTwoUtf8Bytes(r2);
    }

    static /* synthetic */ long access$400(char r2) {
        return charToThreeUtf8Bytes(r2);
    }

    static /* synthetic */ long access$500(int r2) {
        return codePointToFourUtf8Bytes(r2);
    }

    static /* synthetic */ HashCode access$600(int r0, int r1) {
        return fmix(r0, r1);
    }

    static {
        MURMUR3_32 = new Murmur3_32HashFunction(0, false);
        MURMUR3_32_FIXED = new Murmur3_32HashFunction(0, true);
        GOOD_FAST_HASH_32 = new Murmur3_32HashFunction(Hashing.GOOD_FAST_HASH_SEED, true);
    }

    Murmur3_32HashFunction(int r1, boolean r2) {
        this.seed = r1;
        this.supplementaryPlaneFix = r2;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new Murmur3_32Hasher(this.seed);
    }

    public String toString() {
        int r2 = this.seed;
        return new StringBuilder(31).append("Hashing.murmur3_32(").append(r2).append(")").toString();
    }

    public boolean equals(@CheckForNull Object r4) {
        if ((r4 instanceof Murmur3_32HashFunction) == false) goto L10;
        Murmur3_32HashFunction r5 = (Murmur3_32HashFunction) r4;
        if (this.seed == r5.seed) goto L7;
        return false;
    L7:
        if (this.supplementaryPlaneFix != r5.supplementaryPlaneFix) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public int hashCode() {
        int r0 = getClass().hashCode();
        return this.seed ^ r0;
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashInt(int r1) {
        int r2 = mixK1(r1);
        return fmix(mixH1(this.seed, r2), 4);
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashLong(long r3) {
        int r0 = (int) r3;
        int r4 = mixK1(r0);
        return fmix(mixH1(mixH1(this.seed, r4), mixK1((int) (r3 >>> 32))), 8);
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashUnencodedChars(CharSequence r5) {
        int r4 = this.seed;
        int r1 = 1;
    L4:
        if (r1 >= r5.length()) goto L7;
        r4 = mixH1(r4, mixK1(r5.charAt(r1 - 1) | (r5.charAt(r1) << 16)));
        r1 = r1 + 2;
        goto L4
    L7:
        if ((r5.length() & 1) != 1) goto L10;
        r4 = r4 ^ mixK1(r5.charAt(r5.length() - 1));
    L10:
        return fmix(r4, r5.length() * 2);
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashString(CharSequence r12, Charset r13) {
        if (Charsets.UTF_8.equals(r13) == false) goto L42;
        int r0 = r12.length();
        int r1 = this.seed;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
    L5:
        int r5 = r3 + 4;
        if (r5 > r0) goto L13;
        char r7 = r12.charAt(r3);
        char r8 = r12.charAt(r3 + 1);
        char r9 = r12.charAt(r3 + 2);
        char r10 = r12.charAt(r3 + 3);
        if (r7 >= 128) goto L13;
        if (r8 >= 128) goto L13;
        if (r9 >= 128) goto L13;
        if (r10 >= 128) goto L13;
        r1 = mixH1(r1, mixK1((((r8 << '\b') | r7) | (r9 << 16)) | (r10 << 24)));
        r4 = r4 + 4;
        r3 = r5;
    L13:
        long r11 = 0;
    L14:
        if (r3 >= r0) goto L40;
        char r6 = r12.charAt(r3);
        if (r6 >= 128) goto L19;
        r11 = r11 | (((long) r6) << r2);
        r2 = r2 + 8;
        r4 = r4 + 1;
    L36:
        if (r2 < 32) goto L38;
        r1 = mixH1(r1, mixK1((int) r11));
        r11 = r11 >>> 32;
        r2 = r2 - 32;
    L38:
        r3 = r3 + 1;
        goto L14
    L19:
        if (r6 >= 2048) goto L22;
        r11 = r11 | (charToTwoUtf8Bytes(r6) << r2);
        r2 = r2 + 16;
        r4 = r4 + 2;
        goto L36
    L22:
        if (r6 >= 55296) goto L24;
    L34:
        r11 = r11 | (charToThreeUtf8Bytes(r6) << r2);
        r2 = r2 + 24;
        r4 = r4 + 3;
        goto L36
    L24:
        if (r6 > 57343) goto L34;
        int r14 = Character.codePointAt(r12, r3);
        if (r14 == r6) goto L29;
        r3 = r3 + 1;
        r11 = r11 | (codePointToFourUtf8Bytes(r14) << r2);
        if (this.supplementaryPlaneFix == false) goto L33;
        r2 = r2 + 32;
    L33:
        r4 = r4 + 4;
        goto L36
    L29:
        return hashBytes(r12.toString().getBytes(r13));
    L40:
        return fmix(mixK1((int) r11) ^ r1, r4);
    L42:
        return hashBytes(r12.toString().getBytes(r13));
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] r5, int r6, int r7) {
        Preconditions.checkPositionIndexes(r6, r6 + r7, r5.length);
        int r4 = this.seed;
        int r0 = 0;
        int r1 = 0;
    L3:
        int r2 = r1 + 4;
        if (r2 > r7) goto L6;
        r4 = mixH1(r4, mixK1(getIntLittleEndian(r5, r1 + r6)));
        r1 = r2;
        goto L3
    L6:
        int r3 = r1;
        int r8 = 0;
    L7:
        if (r3 >= r7) goto L10;
        r0 = r0 ^ (UnsignedBytes.toInt(r5[r6 + r3]) << r8);
        r3 = r3 + 1;
        r8 = r8 + 8;
        goto L7
    L10:
        return fmix(r4 ^ mixK1(r0), r7);
    }

    private static int getIntLittleEndian(byte[] r3, int r4) {
        return Ints.fromBytes(r3[r4 + 3], r3[r4 + 2], r3[r4 + 1], r3[r4]);
    }

    private static int mixK1(int r1) {
        return Integer.rotateLeft(r1 * C1, 15) * C2;
    }

    private static int mixH1(int r0, int r1) {
        return (Integer.rotateLeft(r0 ^ r1, 13) * 5) - 430675100;
    }

    private static HashCode fmix(int r0, int r1) {
        int r2 = r0 ^ r1;
        int r3 = (r2 ^ (r2 >>> 16)) * (-2048144789);
        int r4 = (r3 ^ (r3 >>> 13)) * (-1028477387);
        return HashCode.fromInt(r4 ^ (r4 >>> 16));
    }
}
