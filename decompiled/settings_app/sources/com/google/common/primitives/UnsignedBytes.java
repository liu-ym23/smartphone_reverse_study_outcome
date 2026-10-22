package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class UnsignedBytes {
    public static final byte MAX_POWER_OF_TWO = -128;
    public static final byte MAX_VALUE = -1;
    private static final int UNSIGNED_MASK = 255;

    static class LexicographicalComparatorHolder {
        static final Comparator<byte[]> BEST_COMPARATOR = null;
        static final String UNSAFE_COMPARATOR_NAME = null;

        static final enum PureJavaComparator extends Enum<PureJavaComparator> implements Comparator<byte[]> {
            private static final /* synthetic */ PureJavaComparator[] $VALUES = null;
            public static final PureJavaComparator INSTANCE = null;

            @Override // java.lang.Enum
            public String toString() {
                return "UnsignedBytes.lexicographicalComparator() (pure Java version)";
            }

            private static /* synthetic */ PureJavaComparator[] $values() {
                return new PureJavaComparator[]{INSTANCE};
            }

            private PureJavaComparator(String r1, int r2) {
                super(r1, r2);
            }

            public static PureJavaComparator valueOf(String r1) {
                return (PureJavaComparator) Enum.valueOf(PureJavaComparator.class, r1);
            }

            public static PureJavaComparator[] values() {
                return (PureJavaComparator[]) $VALUES.clone();
            }

            @Override // java.util.Comparator
            public /* bridge */ /* synthetic */ int compare(byte[] r1, byte[] r2) {
                return compare2(r1, r2);
            }

            static {
                INSTANCE = new PureJavaComparator("INSTANCE", 0);
                $VALUES = $values();
            }

            /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
            public int compare2(byte[] r4, byte[] r5) {
                int r3 = Math.min(r4.length, r5.length);
                int r0 = 0;
            L3:
                if (r0 >= r3) goto L9;
                int r1 = UnsignedBytes.compare(r4[r0], r5[r0]);
                if (r1 != 0) goto L6;
                r0 = r0 + 1;
                goto L3
            L6:
                return r1;
            L9:
                return r4.length - r5.length;
            }
        }

        static final enum UnsafeComparator extends Enum<UnsafeComparator> implements Comparator<byte[]> {
            private static final /* synthetic */ UnsafeComparator[] $VALUES = null;
            static final boolean BIG_ENDIAN = false;
            static final int BYTE_ARRAY_BASE_OFFSET = 0;
            public static final UnsafeComparator INSTANCE = null;
            static final Unsafe theUnsafe = null;

            @Override // java.lang.Enum
            public String toString() {
                return "UnsignedBytes.lexicographicalComparator() (sun.misc.Unsafe version)";
            }

            private static /* synthetic */ UnsafeComparator[] $values() {
                return new UnsafeComparator[]{INSTANCE};
            }

            public static UnsafeComparator valueOf(String r1) {
                return (UnsafeComparator) Enum.valueOf(UnsafeComparator.class, r1);
            }

            public static UnsafeComparator[] values() {
                return (UnsafeComparator[]) $VALUES.clone();
            }

            @Override // java.util.Comparator
            public /* bridge */ /* synthetic */ int compare(byte[] r1, byte[] r2) {
                return compare2(r1, r2);
            }

            private UnsafeComparator(String r1, int r2) {
                super(r1, r2);
            }

            static {
                INSTANCE = new UnsafeComparator("INSTANCE", 0);
                $VALUES = $values();
                BIG_ENDIAN = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
                Unsafe r0 = getUnsafe();
                theUnsafe = r0;
                int r2 = r0.arrayBaseOffset(byte[].class);
                BYTE_ARRAY_BASE_OFFSET = r2;
                if ("64".equals(System.getProperty("sun.arch.data.model")) == false) goto L10;
                if ((r2 % 8) != 0) goto L10;
                if (r0.arrayIndexScale(byte[].class) != 1) goto L10;
                return;
            L10:
                throw new Error();
            }

            private static Unsafe getUnsafe() {
                return Unsafe.getUnsafe();
            L4:
                return (Unsafe) AccessController.doPrivileged(new AnonymousClass1());
            L6:
                e = move-exception;
                throw new RuntimeException("Could not initialize intrinsics", e.getCause());
            }

            /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
            public int compare2(byte[] r11, byte[] r12) {
                int r10 = Math.min(r11.length, r12.length);
                int r0 = r10 & (-8);
                int r1 = 0;
            L3:
                if (r1 >= r0) goto L13;
                Unsafe r2 = theUnsafe;
                int r3 = BYTE_ARRAY_BASE_OFFSET;
                long r6 = r1;
                long r4 = r2.getLong(r11, ((long) r3) + r6);
                long r5 = r2.getLong(r12, ((long) r3) + r6);
                if (r4 != r5) goto L7;
                r1 = r1 + 8;
                goto L3
            L7:
                if (BIG_ENDIAN == true) goto L9;
                int r13 = Long.numberOfTrailingZeros(r4 ^ r5) & (-8);
                return ((int) ((r4 >>> r13) & 255)) - ((int) (255 & (r5 >>> r13)));
            L9:
                return UnsignedLongs.compare(r4, r5);
            L13:
                if (r1 >= r10) goto L19;
                int r7 = UnsignedBytes.compare(r11[r1], r12[r1]);
                if (r7 != 0) goto L16;
                r1 = r1 + 1;
                goto L13
            L16:
                return r7;
            L19:
                return r11.length - r12.length;
            }
        }

        LexicographicalComparatorHolder() {
        }

        static {
            UNSAFE_COMPARATOR_NAME = String.valueOf(LexicographicalComparatorHolder.class.getName()).concat("$UnsafeComparator");
            BEST_COMPARATOR = getBestComparator();
        }

        static Comparator<byte[]> getBestComparator() {
            return (Comparator) ((Object[]) Objects.requireNonNull(Class.forName(UNSAFE_COMPARATOR_NAME).getEnumConstants()))[0];
        L5:
            return UnsignedBytes.lexicographicalComparatorJavaImpl();
        }
    }

    private static byte flip(byte r0) {
        return (byte) (r0 ^ 128);
    }

    public static int toInt(byte r0) {
        return r0 & 255;
    }

    private UnsignedBytes() {
    }

    public static byte checkedCast(long r4) {
        if ((r4 >> 8) != 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "out of range: %s", r4);
        return (byte) r4;
    L5:
        r0 = false;
        goto L6
    }

    public static byte saturatedCast(long r3) {
        if (r3 <= toInt((byte) -1)) goto L6;
        return -1;
    L6:
        if (r3 >= 0) goto L10;
        return 0;
    L10:
        return (byte) r3;
    }

    public static int compare(byte r0, byte r1) {
        return toInt(r0) - toInt(r1);
    }

    public static byte min(byte... r3) {
        int r2 = 1;
        if (r3.length <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        int r1 = toInt(r3[0]);
    L8:
        if (r2 >= r3.length) goto L14;
        int r4 = toInt(r3[r2]);
        if (r4 >= r1) goto L12;
        r1 = r4;
    L12:
        r2 = r2 + 1;
        goto L8
    L14:
        return (byte) r1;
    L5:
        r0 = false;
        goto L6
    }

    public static byte max(byte... r3) {
        int r2 = 1;
        if (r3.length <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        int r1 = toInt(r3[0]);
    L8:
        if (r2 >= r3.length) goto L14;
        int r4 = toInt(r3[r2]);
        if (r4 <= r1) goto L12;
        r1 = r4;
    L12:
        r2 = r2 + 1;
        goto L8
    L14:
        return (byte) r1;
    L5:
        r0 = false;
        goto L6
    }

    public static String toString(byte r1) {
        return toString(r1, 10);
    }

    public static String toString(byte r2, int r3) {
        if (r3 >= 2) goto L5;
    L7:
        boolean r0 = false;
    L8:
        Preconditions.checkArgument(r0, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", r3);
        return Integer.toString(toInt(r2), r3);
    L5:
        if (r3 > 36) goto L7;
        r0 = true;
        goto L8
    }

    public static byte parseUnsignedByte(String r1) {
        return parseUnsignedByte(r1, 10);
    }

    public static byte parseUnsignedByte(String r2, int r3) {
        int r4 = Integer.parseInt((String) Preconditions.checkNotNull(r2), r3);
        if ((r4 >> 8) != 0) goto L7;
        return (byte) r4;
    L7:
        throw new NumberFormatException(new StringBuilder(25).append("out of range: ").append(r4).toString());
    }

    public static String join(String r4, byte... r5) {
        Preconditions.checkNotNull(r4);
        if (r5.length != 0) goto L6;
        return "";
    L6:
        StringBuilder r0 = new StringBuilder(r5.length * (r4.length() + 3));
        r0.append(toInt(r5[0]));
        int r1 = 1;
    L8:
        if (r1 >= r5.length) goto L11;
        r0.append(r4).append(toString(r5[r1]));
        r1 = r1 + 1;
        goto L8
    L11:
        return r0.toString();
    }

    public static Comparator<byte[]> lexicographicalComparator() {
        return LexicographicalComparatorHolder.BEST_COMPARATOR;
    }

    static Comparator<byte[]> lexicographicalComparatorJavaImpl() {
        return LexicographicalComparatorHolder.PureJavaComparator.INSTANCE;
    }

    public static void sort(byte[] r2) {
        Preconditions.checkNotNull(r2);
        sort(r2, 0, r2.length);
    }

    public static void sort(byte[] r2, int r3, int r4) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkPositionIndexes(r3, r4, r2.length);
        int r0 = r3;
    L3:
        if (r0 >= r4) goto L5;
        r2[r0] = flip(r2[r0]);
        r0 = r0 + 1;
        goto L3
    L5:
        Arrays.sort(r2, r3, r4);
    L6:
        if (r3 >= r4) goto L8;
        r2[r3] = flip(r2[r3]);
        r3 = r3 + 1;
        goto L6
    }

    public static void sortDescending(byte[] r2) {
        Preconditions.checkNotNull(r2);
        sortDescending(r2, 0, r2.length);
    }

    public static void sortDescending(byte[] r2, int r3, int r4) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkPositionIndexes(r3, r4, r2.length);
        int r0 = r3;
    L3:
        if (r0 >= r4) goto L5;
        r2[r0] = (byte) (r2[r0] ^ 127);
        r0 = r0 + 1;
        goto L3
    L5:
        Arrays.sort(r2, r3, r4);
    L6:
        if (r3 >= r4) goto L8;
        r2[r3] = (byte) (r2[r3] ^ 127);
        r3 = r3 + 1;
        goto L6
    }
}
