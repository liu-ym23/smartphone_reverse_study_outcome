package com.google.common.hash;

import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class FarmHashFingerprint64 extends AbstractNonStreamingHashFunction {
    static final HashFunction FARMHASH_FINGERPRINT_64 = null;
    private static final long K0 = -4348849565147123417L;
    private static final long K1 = -5435081209227447693L;
    private static final long K2 = -7286425919675154353L;

    private static long hashLength16(long r3, long r5, long r7) {
        long r4 = (r3 ^ r5) * r7;
        long r6 = ((r4 ^ (r4 >>> 47)) ^ r5) * r7;
        return (r6 ^ (r6 >>> 47)) * r7;
    }

    private static long shiftMix(long r2) {
        return r2 ^ (r2 >>> 47);
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    public String toString() {
        return "Hashing.farmHashFingerprint64()";
    }

    FarmHashFingerprint64() {
    }

    static {
        FARMHASH_FINGERPRINT_64 = new FarmHashFingerprint64();
    }

    @Override // com.google.common.hash.AbstractNonStreamingHashFunction, com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] r2, int r3, int r4) {
        Preconditions.checkPositionIndexes(r3, r3 + r4, r2.length);
        return HashCode.fromLong(fingerprint(r2, r3, r4));
    }

    static long fingerprint(byte[] r1, int r2, int r3) {
        if (r3 > 32) goto L11;
        if (r3 > 16) goto L9;
        return hashLength0to16(r1, r2, r3);
    L9:
        return hashLength17to32(r1, r2, r3);
    L11:
        if (r3 > 64) goto L15;
        return hashLength33To64(r1, r2, r3);
    L15:
        return hashLength65Plus(r1, r2, r3);
    }

    private static void weakHashLength32WithSeeds(byte[] r6, int r7, long r8, long r10, long[] r12) {
        long r0 = LittleEndianByteArray.load64(r6, r7);
        long r2 = LittleEndianByteArray.load64(r6, r7 + 8);
        long r4 = LittleEndianByteArray.load64(r6, r7 + 16);
        long r9 = LittleEndianByteArray.load64(r6, r7 + 24);
        long r11 = r8 + r0;
        long r3 = (r2 + r11) + r4;
        long r13 = Long.rotateRight((r10 + r11) + r9, 21) + Long.rotateRight(r3, 44);
        r12[0] = r3 + r9;
        r12[1] = r13 + r11;
    }

    private static long hashLength0to16(byte[] r12, int r13, int r14) {
        if (r14 < 8) goto L7;
        long r9 = ((long) (r14 * 2)) + K2;
        long r3 = LittleEndianByteArray.load64(r12, r13) + K2;
        long r15 = LittleEndianByteArray.load64(r12, (r13 + r14) - 8);
        return hashLength16((Long.rotateRight(r15, 37) * r9) + r3, (Long.rotateRight(r3, 25) + r15) * r9, r9);
    L7:
        if (r14 >= 4) goto L9;
        if (r14 > 0) goto L12;
        return K2;
    L12:
        return shiftMix((((long) ((r12[r13] & 255) + ((r12[(r14 >> 1) + r13] & 255) << 8))) * K2) ^ (((long) (r14 + ((r12[r13 + (r14 - 1)] & 255) << 2))) * K0)) * K2;
    L9:
        return hashLength16(((long) r14) + ((((long) LittleEndianByteArray.load32(r12, r13)) & 4294967295L) << 3), ((long) LittleEndianByteArray.load32(r12, (r13 + r14) - 4)) & 4294967295L, ((long) (r14 * 2)) + K2);
    }

    private static long hashLength17to32(byte[] r17, int r18, int r19) {
        long r9 = ((long) (r19 * 2)) + K2;
        long r1 = LittleEndianByteArray.load64(r17, r18) * K1;
        long r5 = LittleEndianByteArray.load64(r17, r18 + 8);
        int r7 = r18 + r19;
        long r11 = LittleEndianByteArray.load64(r17, r7 - 8) * r9;
        return hashLength16((LittleEndianByteArray.load64(r17, r7 - 16) * K2) + (Long.rotateRight(r1 + r5, 43) + Long.rotateRight(r11, 30)), (r1 + Long.rotateRight(r5 + K2, 18)) + r11, r9);
    }

    private static long hashLength33To64(byte[] r20, int r21, int r22) {
        long r1 = ((long) (r22 * 2)) + K2;
        long r11 = LittleEndianByteArray.load64(r20, r21) * K2;
        long r5 = LittleEndianByteArray.load64(r20, r21 + 8);
        int r13 = r21 + r22;
        long r7 = LittleEndianByteArray.load64(r20, r13 - 8) * r1;
        long r14 = (Long.rotateRight(r11 + r5, 43) + Long.rotateRight(r7, 30)) + (LittleEndianByteArray.load64(r20, r13 - 16) * K2);
        long r6 = hashLength16(r14, r7 + (Long.rotateRight(r5 + K2, 18) + r11), r1);
        long r8 = LittleEndianByteArray.load64(r20, r21 + 16) * r1;
        long r9 = LittleEndianByteArray.load64(r20, r21 + 24);
        long r15 = (r14 + LittleEndianByteArray.load64(r20, r13 - 32)) * r1;
        return hashLength16(((r6 + LittleEndianByteArray.load64(r20, r13 - 24)) * r1) + (Long.rotateRight(r8 + r9, 43) + Long.rotateRight(r15, 30)), (r8 + Long.rotateRight(r9 + r11, 18)) + r15, r1);
    }

    private static long hashLength65Plus(byte[] r24, int r25, int r26) {
        long r0 = shiftMix(-7956866745689871395L) * K2;
        long[] r8 = new long[2];
        long[] r9 = new long[2];
        long r2 = 95310865018149119L + LittleEndianByteArray.load64(r24, r25);
        int r4 = r26 - 1;
        int r11 = r25 + ((r4 / 64) * 64);
        int r12 = r4 & 63;
        int r13 = (r11 + r12) - 63;
        long r5 = 2480279821605975764L;
        int r14 = r25;
    L3:
        long r3 = Long.rotateRight(((r2 + r5) + r8[0]) + LittleEndianByteArray.load64(r24, r14 + 8), 37) * K1;
        long r6 = Long.rotateRight((r5 + r8[1]) + LittleEndianByteArray.load64(r24, r14 + 48), 42) * K1;
        long r18 = r3 ^ r9[1];
        long r20 = r6 + (r8[0] + LittleEndianByteArray.load64(r24, r14 + 40));
        long r22 = Long.rotateRight(r0 + r9[0], 33) * K1;
        weakHashLength32WithSeeds(r24, r14, r8[1] * K1, r18 + r9[0], r8);
        weakHashLength32WithSeeds(r24, r14 + 32, r22 + r9[1], r20 + LittleEndianByteArray.load64(r24, r14 + 16), r9);
        r14 = r14 + 64;
        if (r14 == r11) goto L5;
        r0 = r18;
        r5 = r20;
        r2 = r22;
        goto L3
    L5:
        long r16 = ((r18 & 255) << 1) + K1;
        long r1 = r9[0] + ((long) r12);
        r9[0] = r1;
        long r7 = r8[0] + r1;
        r8[0] = r7;
        r9[0] = r9[0] + r7;
        long r10 = Long.rotateRight(((r22 + r20) + r8[0]) + LittleEndianByteArray.load64(r24, r13 + 8), 37) * r16;
        long r15 = Long.rotateRight((r20 + r8[1]) + LittleEndianByteArray.load64(r24, r13 + 48), 42) * r16;
        long r21 = r10 ^ (r9[1] * 9);
        long r17 = r15 + ((r8[0] * 9) + LittleEndianByteArray.load64(r24, r13 + 40));
        long r19 = Long.rotateRight(r18 + r9[0], 33) * r16;
        weakHashLength32WithSeeds(r24, r13, r8[1] * r16, r21 + r9[0], r8);
        weakHashLength32WithSeeds(r24, r13 + 32, r19 + r9[1], LittleEndianByteArray.load64(r24, r13 + 16) + r17, r9);
        return hashLength16((hashLength16(r8[0], r9[0], r16) + (shiftMix(r17) * K0)) + r21, hashLength16(r8[1], r9[1], r16) + r19, r16);
    }
}
