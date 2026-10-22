package com.google.common.collect;

import com.google.common.base.Objects;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class CompactHashing {
    private static final int BYTE_MASK = 255;
    private static final int BYTE_MAX_SIZE = 256;
    static final int DEFAULT_SIZE = 3;
    static final int HASH_TABLE_BITS_MASK = 31;
    private static final int HASH_TABLE_BITS_MAX_BITS = 5;
    static final int MAX_SIZE = 1073741823;
    private static final int MIN_HASH_TABLE_SIZE = 4;
    static final int MODIFICATION_COUNT_INCREMENT = 32;
    private static final int SHORT_MASK = 65535;
    private static final int SHORT_MAX_SIZE = 65536;
    static final byte UNSET = 0;

    static int getHashPrefix(int r0, int r1) {
        return r0 & (~r1);
    }

    static int getNext(int r0, int r1) {
        return r0 & r1;
    }

    static int maskCombine(int r1, int r2, int r3) {
        return (r1 & (~r3)) | (r2 & r3);
    }

    static int newCapacity(int r1) {
        if (r1 >= 32) goto L5;
        int r0 = 4;
    L7:
        return r0 * (r1 + 1);
    L5:
        r0 = 2;
        goto L7
    }

    private CompactHashing() {
    }

    static int tableSize(int r2) {
        return Math.max(4, Hashing.closedTableSize(r2 + 1, 1.0d));
    }

    static Object createTable(int r3) {
        if (r3 < 2) goto L19;
        if (r3 > 1073741824) goto L19;
        if (Integer.highestOneBit(r3) != r3) goto L19;
        if (r3 > 256) goto L13;
        return new byte[r3];
    L13:
        if (r3 > 65536) goto L17;
        return new short[r3];
    L17:
        return new int[r3];
    L19:
        throw new IllegalArgumentException(new StringBuilder(52).append("must be power of 2 between 2^1 and 2^30: ").append(r3).toString());
    }

    static void tableClear(Object r2) {
        if ((r2 instanceof byte[]) == false) goto L6;
        Arrays.fill((byte[]) r2, (byte) 0);
        return;
    L6:
        if ((r2 instanceof short[]) == false) goto L8;
        Arrays.fill((short[]) r2, 0);
        return;
    L8:
        Arrays.fill((int[]) r2, 0);
    }

    static int tableGet(Object r1, int r2) {
        if ((r1 instanceof byte[]) == false) goto L7;
        return ((byte[]) r1)[r2] & 255;
    L7:
        if ((r1 instanceof short[]) == false) goto L11;
        return ((short[]) r1)[r2] & 65535;
    L11:
        return ((int[]) r1)[r2];
    }

    static void tableSet(Object r1, int r2, int r3) {
        if ((r1 instanceof byte[]) == false) goto L6;
        ((byte[]) r1)[r2] = (byte) r3;
        return;
    L6:
        if ((r1 instanceof short[]) == false) goto L8;
        ((short[]) r1)[r2] = (short) r3;
        return;
    L8:
        ((int[]) r1)[r2] = r3;
    }

    static int remove(@CheckForNull Object r8, @CheckForNull Object r9, int r10, Object r11, int[] r12, Object[] r13, @CheckForNull Object[] r14) {
        int r0 = Hashing.smearedHash(r8);
        int r1 = r0 & r10;
        int r2 = tableGet(r11, r1);
        if (r2 != 0) goto L5;
        return -1;
    L5:
        int r3 = getHashPrefix(r0, r10);
        int r4 = -1;
    L6:
        int r5 = r2 - 1;
        int r6 = r12[r5];
        if (getHashPrefix(r6, r10) == r3) goto L9;
    L18:
        int r7 = getNext(r6, r10);
        if (r7 == 0) goto L20;
        r4 = r5;
        r2 = r7;
        goto L6
    L20:
        return -1;
    L9:
        if (Objects.equal(r8, r13[r5]) == false) goto L18;
        if (r14 == null) goto L13;
        if (Objects.equal(r9, r14[r5]) == false) goto L18;
    L13:
        int r15 = getNext(r6, r10);
        if (r4 != (-1)) goto L16;
        tableSet(r11, r1, r15);
    L17:
        return r5;
    L16:
        r12[r4] = maskCombine(r12[r4], r15, r10);
        goto L17
    }
}
