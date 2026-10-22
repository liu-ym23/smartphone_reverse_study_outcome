package androidx.collection;

/* JADX INFO: loaded from: classes.dex */
class ContainerHelpers {
    static final int[] EMPTY_INTS = null;
    static final long[] EMPTY_LONGS = null;
    static final Object[] EMPTY_OBJECTS = null;

    public static int idealByteArraySize(int r2) {
        int r0 = 4;
    L4:
        if (r0 >= 32) goto L9;
        int r1 = (1 << r0) - 12;
        if (r2 <= r1) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r1;
    L9:
        return r2;
    }

    static {
        EMPTY_INTS = new int[0];
        EMPTY_LONGS = new long[0];
        EMPTY_OBJECTS = new Object[0];
    }

    public static int idealIntArraySize(int r0) {
        return idealByteArraySize(r0 * 4) / 4;
    }

    public static int idealLongArraySize(int r0) {
        return idealByteArraySize(r0 * 8) / 8;
    }

    public static boolean equal(Object r0, Object r1) {
        if (r0 == r1) goto L8;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.equals(r1) == false) goto L7;
    L8:
        return true;
    }

    static int binarySearch(int[] r3, int r4, int r5) {
        int r6 = r4 - 1;
        int r0 = 0;
    L3:
        if (r0 > r6) goto L11;
        int r1 = (r0 + r6) >>> 1;
        int r2 = r3[r1];
        if (r2 < r5) goto L6;
        if (r2 <= r5) goto L9;
        r6 = r1 - 1;
        goto L3
    L9:
        return r1;
    L6:
        r0 = r1 + 1;
        goto L3
    L11:
        return ~r0;
    }

    static int binarySearch(long[] r4, int r5, long r6) {
        int r7 = r5 - 1;
        int r0 = 0;
    L3:
        if (r0 > r7) goto L11;
        int r1 = (r0 + r7) >>> 1;
        long r2 = r4[r1];
        if (r2 < r6) goto L6;
        if (r2 <= r6) goto L9;
        r7 = r1 - 1;
        goto L3
    L9:
        return r1;
    L6:
        r0 = r1 + 1;
        goto L3
    L11:
        return ~r0;
    }

    private ContainerHelpers() {
    }
}
