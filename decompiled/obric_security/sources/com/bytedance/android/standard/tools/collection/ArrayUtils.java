package com.bytedance.android.standard.tools.collection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ArrayUtils {
    private static final int CACHE_SIZE = 73;
    private static final Object[] EMPTY = null;
    private static Object[] sCache;

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

    private ArrayUtils() {
    }

    public static long[] toLongArray(List<Long> r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        long[] r0 = new long[r4.size()];
        int r1 = 0;
    L7:
        if (r1 >= r4.size()) goto L9;
        r0[r1] = r4.get(r1).longValue();
        r1 = r1 + 1;
        goto L7
    L9:
        return r0;
    }

    public static List<Long> toList(long[] r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
        int r1 = r5.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        r0.add(Long.valueOf(r5[r2]));
        r2 = r2 + 1;
        goto L6
    L8:
        return r0;
    }

    public static <T> T[] combineArray(T[] r3, T[] r4) {
        T[] r0 = (T[]) copyOfRange(r3, 0, r3.length + r4.length);
        System.arraycopy(r4, 0, r0, r3.length, r4.length);
        return r0;
    }

    public static <T> T[] insert(T[] r3, int r4, T r5) {
        T[] r0 = (T[]) ((Object[]) Array.newInstance(r3.getClass().getComponentType(), r3.length + 1));
        int r1 = 0;
    L4:
        if (r1 >= r0.length) goto L11;
        if (r1 >= r4) goto L7;
        T r2 = r3[r1];
    L10:
        r0[r1] = r2;
        r1 = r1 + 1;
        goto L4
    L7:
        if (r1 != r4) goto L9;
        r2 = r5;
        goto L10
    L9:
        r2 = r3[r1 - 1];
        goto L10
    L11:
        return r0;
    }

    public static <T> T[] copyOfRange(T[] r2, int r3, int r4) {
        int r0 = r2.length;
        if (r3 > r4) goto L11;
        if (r3 < 0) goto L9;
        if (r3 > r0) goto L9;
        int r5 = r4 - r3;
        int r1 = Math.min(r5, r0 - r3);
        T[] r6 = (T[]) ((Object[]) Array.newInstance(r2.getClass().getComponentType(), r5));
        System.arraycopy(r2, r3, r6, 0, r1);
        return r6;
    L9:
        throw new ArrayIndexOutOfBoundsException();
    L11:
        throw new IllegalArgumentException();
    }

    static {
        EMPTY = new Object[0];
        sCache = new Object[73];
    }

    public static int idealBooleanArraySize(int r0) {
        return idealByteArraySize(r0);
    }

    public static int idealShortArraySize(int r0) {
        return idealByteArraySize(r0 * 2) / 2;
    }

    public static int idealCharArraySize(int r0) {
        return idealByteArraySize(r0 * 2) / 2;
    }

    public static int idealIntArraySize(int r0) {
        return idealByteArraySize(r0 * 4) / 4;
    }

    public static int idealFloatArraySize(int r0) {
        return idealByteArraySize(r0 * 4) / 4;
    }

    public static int idealObjectArraySize(int r0) {
        return idealByteArraySize(r0 * 4) / 4;
    }

    public static int idealLongArraySize(int r0) {
        return idealByteArraySize(r0 * 8) / 8;
    }

    public static boolean equals(byte[] r5, byte[] r6, int r7) {
        if (r7 < 0) goto L23;
        if (r5 != r6) goto L7;
        return true;
    L7:
        if (r5 == null) goto L21;
        if (r6 == null) goto L21;
        if (r5.length < r7) goto L21;
        if (r6.length < r7) goto L21;
        int r2 = 0;
    L15:
        if (r2 >= r7) goto L20;
        if (r5[r2] != r6[r2]) goto L18;
        r2 = r2 + 1;
        goto L15
    L18:
        return false;
    L20:
        return true;
    L21:
        return false;
    L23:
        throw new IllegalArgumentException();
    }

    public static <T> T[] emptyArray(Class<T> r3) {
        if (r3 == Object.class) goto L5;
        int r0 = ((System.identityHashCode(r3) / 8) & Integer.MAX_VALUE) % 73;
        Object r1 = sCache[r0];
        if (r1 != null) goto L9;
    L10:
        r1 = Array.newInstance(r3, 0);
        sCache[r0] = r1;
    L12:
        return (T[]) ((Object[]) r1);
    L9:
        if (r1.getClass().getComponentType() == r3) goto L12;
    L5:
        return (T[]) EMPTY;
    }

    public static <T> boolean contains(T[] r0, T r1) {
        if (indexOf(r0, r1) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public static <T> int indexOf(T[] r2, T r3) {
        int r0 = 0;
    L4:
        if (r0 >= r2.length) goto L14;
        T r1 = r2[r0];
        if (r1 != null) goto L13;
        if (r3 == null) goto L8;
        if (r3 == null) goto L13;
        if (r1.equals(r3) == false) goto L13;
        return r0;
    L8:
        return r0;
    L13:
        r0 = r0 + 1;
        goto L4
    L14:
        return -1;
    }

    public static <T> boolean containsAll(T[] r4, T[] r5) {
        int r0 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (contains(r4, r5[r2]) == false) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public static boolean contains(int[] r4, int r5) {
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r4[r2] == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static long total(long[] r6) {
        int r0 = r6.length;
        long r1 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1 = r1 + r6[r3];
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    public static <T> T[] appendElement(Class<T> r3, T[] r4, T r5) {
        int r0 = 0;
        if (r4 == null) goto L5;
        int r1 = r4.length;
        T[] r6 = (T[]) ((Object[]) Array.newInstance(r3, r1 + 1));
        System.arraycopy(r4, 0, r6, 0, r1);
        r0 = r1;
    L6:
        r6[r0] = r5;
        return r6;
    L5:
        r6 = (T[]) ((Object[]) Array.newInstance(r3, 1));
        goto L6
    }

    public static <T> T[] removeElement(Class<T> r4, T[] r5, T r6) {
        if (r5 == null) goto L14;
        int r0 = r5.length;
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L14;
        if (r5[r2] == r6) goto L8;
        r2 = r2 + 1;
        goto L4
    L8:
        if (r0 != 1) goto L11;
        return null;
    L11:
        T[] r7 = (T[]) ((Object[]) Array.newInstance(r4, r0 - 1));
        System.arraycopy(r5, 0, r7, 0, r2);
        System.arraycopy(r5, r2 + 1, r7, r2, (r0 - r2) - 1);
        return r7;
    L14:
        return r5;
    }

    public static int[] appendInt(int[] r4, int r5) {
        if (r4 == null) goto L5;
        int r1 = r4.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L12;
        if (r4[r2] == r5) goto L10;
        r2 = r2 + 1;
        goto L7
    L10:
        return r4;
    L12:
        int[] r3 = new int[r1 + 1];
        System.arraycopy(r4, 0, r3, 0, r1);
        r3[r1] = r5;
        return r3;
    L5:
        return new int[]{r5};
    }

    public static int[] removeInt(int[] r4, int r5) {
        if (r4 != null) goto L5;
        return null;
    L5:
        int r0 = r4.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L16;
        if (r4[r2] == r5) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        int r6 = r0 - 1;
        int[] r3 = new int[r6];
        if (r2 <= 0) goto L12;
        System.arraycopy(r4, 0, r3, 0, r2);
    L12:
        if (r2 >= r6) goto L14;
        System.arraycopy(r4, r2 + 1, r3, r2, (r0 - r2) - 1);
    L14:
        return r3;
    L16:
        return r4;
    }
}
