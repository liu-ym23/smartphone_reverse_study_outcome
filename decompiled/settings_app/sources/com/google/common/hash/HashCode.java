package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedInts;
import java.io.Serializable;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class HashCode {
    private static final char[] hexDigits = null;

    private static final class BytesHashCode extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;
        final byte[] bytes;

        BytesHashCode(byte[] r1) {
            this.bytes = (byte[]) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.hash.HashCode
        public int bits() {
            return this.bytes.length * 8;
        }

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            return (byte[]) this.bytes.clone();
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            byte[] r0 = this.bytes;
            if (r0.length < 4) goto L5;
            boolean r1 = true;
        L6:
            Preconditions.checkState(r1, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", r0.length);
            byte[] r5 = this.bytes;
            return ((r5[3] & 255) << 24) | (((r5[0] & 255) | ((r5[1] & 255) << 8)) | ((r5[2] & 255) << 16));
        L5:
            r1 = false;
            goto L6
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            byte[] r0 = this.bytes;
            if (r0.length < 8) goto L5;
            boolean r1 = true;
        L6:
            Preconditions.checkState(r1, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", r0.length);
            return padToLong();
        L5:
            r1 = false;
            goto L6
        }

        @Override // com.google.common.hash.HashCode
        public long padToLong() {
            long r0 = this.bytes[0] & 255;
            int r2 = 1;
        L4:
            if (r2 >= Math.min(this.bytes.length, 8)) goto L6;
            r0 = r0 | ((((long) this.bytes[r2]) & 255) << (r2 * 8));
            r2 = r2 + 1;
            goto L4
        L6:
            return r0;
        }

        @Override // com.google.common.hash.HashCode
        void writeBytesToImpl(byte[] r2, int r3, int r4) {
            System.arraycopy(this.bytes, 0, r2, r3, r4);
        }

        @Override // com.google.common.hash.HashCode
        byte[] getBytesInternal() {
            return this.bytes;
        }

        @Override // com.google.common.hash.HashCode
        boolean equalsSameBits(HashCode r7) {
            if (this.bytes.length == r7.getBytesInternal().length) goto L5;
            return false;
        L5:
            boolean r3 = true;
            int r1 = 0;
        L6:
            byte[] r4 = this.bytes;
            if (r1 >= r4.length) goto L13;
            if (r4[r1] != r7.getBytesInternal()[r1]) goto L11;
            boolean r5 = true;
        L12:
            r3 = r3 & r5;
            r1 = r1 + 1;
            goto L6
        L11:
            r5 = false;
            goto L12
        L13:
            return r3;
        }
    }

    private static final class IntHashCode extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;
        final int hash;

        @Override // com.google.common.hash.HashCode
        public int bits() {
            return 32;
        }

        IntHashCode(int r1) {
            this.hash = r1;
        }

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            int r3 = this.hash;
            return new byte[]{(byte) r3, (byte) (r3 >> 8), (byte) (r3 >> 16), (byte) (r3 >> 24)};
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            return this.hash;
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            throw new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
        }

        @Override // com.google.common.hash.HashCode
        public long padToLong() {
            return UnsignedInts.toLong(this.hash);
        }

        @Override // com.google.common.hash.HashCode
        void writeBytesToImpl(byte[] r5, int r6, int r7) {
            int r0 = 0;
        L3:
            if (r0 >= r7) goto L5;
            r5[r6 + r0] = (byte) (this.hash >> (r0 * 8));
            r0 = r0 + 1;
            goto L3
        }

        @Override // com.google.common.hash.HashCode
        boolean equalsSameBits(HashCode r1) {
            if (this.hash != r1.asInt()) goto L5;
            return true;
        L5:
            return false;
        }
    }

    private static final class LongHashCode extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;
        final long hash;

        @Override // com.google.common.hash.HashCode
        public int bits() {
            return 64;
        }

        LongHashCode(long r1) {
            this.hash = r1;
        }

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            long r2 = this.hash;
            return new byte[]{(byte) r2, (byte) (r2 >> 8), (byte) (r2 >> 16), (byte) (r2 >> 24), (byte) (r2 >> 32), (byte) (r2 >> 40), (byte) (r2 >> 48), (byte) (r2 >> 56)};
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            return (int) this.hash;
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            return this.hash;
        }

        @Override // com.google.common.hash.HashCode
        public long padToLong() {
            return this.hash;
        }

        @Override // com.google.common.hash.HashCode
        void writeBytesToImpl(byte[] r6, int r7, int r8) {
            int r0 = 0;
        L3:
            if (r0 >= r8) goto L5;
            r6[r7 + r0] = (byte) (this.hash >> (r0 * 8));
            r0 = r0 + 1;
            goto L3
        }

        @Override // com.google.common.hash.HashCode
        boolean equalsSameBits(HashCode r3) {
            if (this.hash != r3.asLong()) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public abstract byte[] asBytes();

    public abstract int asInt();

    public abstract long asLong();

    public abstract int bits();

    abstract boolean equalsSameBits(HashCode r1);

    public abstract long padToLong();

    abstract void writeBytesToImpl(byte[] r1, int r2, int r3);

    HashCode() {
    }

    public int writeBytesTo(byte[] r3, int r4, int r5) {
        int r6 = Ints.min(new int[]{r5, bits() / 8});
        Preconditions.checkPositionIndexes(r4, r4 + r6, r3.length);
        writeBytesToImpl(r3, r4, r6);
        return r6;
    }

    byte[] getBytesInternal() {
        return asBytes();
    }

    public static HashCode fromInt(int r1) {
        return new IntHashCode(r1);
    }

    public static HashCode fromLong(long r1) {
        return new LongHashCode(r1);
    }

    public static HashCode fromBytes(byte[] r2) {
        boolean r1 = true;
        if (r2.length >= 1) goto L6;
        r1 = false;
    L6:
        Preconditions.checkArgument(r1, "A HashCode must contain at least 1 byte.");
        return fromBytesNoCopy((byte[]) r2.clone());
    }

    static HashCode fromBytesNoCopy(byte[] r1) {
        return new BytesHashCode(r1);
    }

    public static HashCode fromString(String r5) {
        boolean r1 = true;
        int r2 = 0;
        if (r5.length() < 2) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "input string (%s) must have at least 2 characters", r5);
        if ((r5.length() % 2) == 0) goto L10;
        r1 = false;
    L10:
        Preconditions.checkArgument(r1, "input string (%s) must have an even number of characters", r5);
        byte[] r3 = new byte[r5.length() / 2];
    L12:
        if (r2 >= r5.length()) goto L15;
        r3[r2 / 2] = (byte) ((decode(r5.charAt(r2)) << 4) + decode(r5.charAt(r2 + 1)));
        r2 = r2 + 2;
        goto L12
    L15:
        return fromBytesNoCopy(r3);
    L5:
        r0 = false;
        goto L6
    }

    private static int decode(char r3) {
        if (r3 < '0') goto L9;
        if (r3 > '9') goto L9;
        return r3 - '0';
    L9:
        if (r3 < 'a') goto L15;
        if (r3 > 'f') goto L15;
        return (r3 - 'a') + 10;
    L15:
        throw new IllegalArgumentException(new StringBuilder(32).append("Illegal hexadecimal character: ").append(r3).toString());
    }

    public final boolean equals(@CheckForNull Object r4) {
        if ((r4 instanceof HashCode) == false) goto L10;
        HashCode r5 = (HashCode) r4;
        if (bits() == r5.bits()) goto L7;
        return false;
    L7:
        if (equalsSameBits(r5) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public final int hashCode() {
        if (bits() >= 32) goto L5;
        byte[] r4 = getBytesInternal();
        int r0 = r4[0] & 255;
        int r1 = 1;
    L8:
        if (r1 >= r4.length) goto L10;
        r0 = r0 | ((r4[r1] & 255) << (r1 * 8));
        r1 = r1 + 1;
        goto L8
    L10:
        return r0;
    L5:
        return asInt();
    }

    public final String toString() {
        byte[] r6 = getBytesInternal();
        StringBuilder r0 = new StringBuilder(r6.length * 2);
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        byte r3 = r6[r2];
        char[] r4 = hexDigits;
        r0.append(r4[(r3 >> 4) & 15]).append(r4[r3 & 15]);
        r2 = r2 + 1;
        goto L3
    L6:
        return r0.toString();
    }

    static {
        hexDigits = "0123456789abcdef".toCharArray();
    }
}
