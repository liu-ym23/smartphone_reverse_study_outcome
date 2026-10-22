package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
abstract enum BloomFilterStrategies extends Enum<BloomFilterStrategies> implements BloomFilter.Strategy {
    private static final /* synthetic */ BloomFilterStrategies[] $VALUES = null;
    public static final BloomFilterStrategies MURMUR128_MITZ_32 = null;
    public static final BloomFilterStrategies MURMUR128_MITZ_64 = null;

    static final class LockFreeBitArray {
        private static final int LONG_ADDRESSABLE_BITS = 6;
        private final LongAddable bitCount;
        final AtomicLongArray data;

        LockFreeBitArray(long r5) {
            if (r5 <= 0) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkArgument(r0, "data length is zero!");
            this.data = new AtomicLongArray(Ints.checkedCast(LongMath.divide(r5, 64, RoundingMode.CEILING)));
            this.bitCount = LongAddables.create();
            return;
        L5:
            r0 = false;
            goto L6
        }

        LockFreeBitArray(long[] r7) {
            int r1 = 0;
            if (r7.length <= 0) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkArgument(r0, "data length is zero!");
            this.data = new AtomicLongArray(r7);
            this.bitCount = LongAddables.create();
            int r2 = r7.length;
            long r3 = 0;
        L7:
            if (r1 >= r2) goto L9;
            r3 = r3 + ((long) Long.bitCount(r7[r1]));
            r1 = r1 + 1;
            goto L7
        L9:
            this.bitCount.add(r3);
            return;
        L5:
            r0 = false;
            goto L6
        }

        boolean set(long r11) {
            if (get(r11) == false) goto L5;
            return false;
        L5:
            int r0 = (int) (r11 >>> 6);
            long r12 = 1 << ((int) r11);
        L6:
            long r6 = this.data.get(r0);
            long r8 = r6 | r12;
            if (r6 == r8) goto L8;
            if (this.data.compareAndSet(r0, r6, r8) == false) goto L6;
            this.bitCount.increment();
            return true;
        L8:
            return false;
        }

        boolean get(long r5) {
            long r0 = this.data.get((int) (r5 >>> 6));
            if (((1 << ((int) r5)) & r0) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public static long[] toPlainArray(AtomicLongArray r5) {
            int r0 = r5.length();
            long[] r1 = new long[r0];
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L5;
            r1[r2] = r5.get(r2);
            r2 = r2 + 1;
            goto L3
        L5:
            return r1;
        }

        long bitSize() {
            return ((long) this.data.length()) * 64;
        }

        long bitCount() {
            return this.bitCount.sum();
        }

        LockFreeBitArray copy() {
            return new LockFreeBitArray(toPlainArray(this.data));
        }

        void putAll(LockFreeBitArray r19) {
            if (this.data.length() != r19.data.length()) goto L5;
            boolean r2 = true;
        L6:
            Preconditions.checkArgument(r2, "BitArrays must be of equal length (%s != %s)", this.data.length(), r19.data.length());
            int r3 = 0;
        L8:
            if (r3 >= this.data.length()) goto L19;
            long r6 = r19.data.get(r3);
        L10:
            long r14 = this.data.get(r3);
            long r16 = r14 | r6;
            if (r14 == r16) goto L12;
            if (this.data.compareAndSet(r3, r14, r16) == false) goto L10;
            boolean r4 = true;
        L16:
            if (r4 == false) goto L18;
            this.bitCount.add(Long.bitCount(r16) - Long.bitCount(r14));
        L18:
            r3 = r3 + 1;
            goto L8
        L12:
            r4 = false;
            goto L16
        L19:
            return;
        L5:
            r2 = false;
            goto L6
        }

        public boolean equals(@CheckForNull Object r2) {
            if ((r2 instanceof LockFreeBitArray) == true) goto L5;
            return false;
        L5:
            return Arrays.equals(toPlainArray(this.data), toPlainArray(((LockFreeBitArray) r2).data));
        }

        public int hashCode() {
            return Arrays.hashCode(toPlainArray(this.data));
        }
    }

    private static /* synthetic */ BloomFilterStrategies[] $values() {
        return new BloomFilterStrategies[]{MURMUR128_MITZ_32, MURMUR128_MITZ_64};
    }

    public static BloomFilterStrategies valueOf(String r1) {
        return (BloomFilterStrategies) Enum.valueOf(BloomFilterStrategies.class, r1);
    }

    public static BloomFilterStrategies[] values() {
        return (BloomFilterStrategies[]) $VALUES.clone();
    }

    private BloomFilterStrategies(String r1, int r2) {
        super(r1, r2);
    }

    /* synthetic */ BloomFilterStrategies(String r1, int r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    static {
        final String r1 = "MURMUR128_MITZ_32";
        final int r2 = 0;
        MURMUR128_MITZ_32 = new AnonymousClass1(r1, r2);
        final String r3 = "MURMUR128_MITZ_64";
        final int r4 = 1;
        MURMUR128_MITZ_64 = new AnonymousClass2(r3, r4);
        $VALUES = $values();
    }
}
