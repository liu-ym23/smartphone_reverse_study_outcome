package androidx.core.content.res;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
final class GrowingArrayUtils {
    private GrowingArrayUtils() {
    }

    public static <T> T[] append(T[] r2, int r3, T r4) {
        if ((r3 + 1) <= r2.length) goto L5;
        Object[] r0 = (Object[]) Array.newInstance(r2.getClass().getComponentType(), growSize(r3));
        System.arraycopy(r2, 0, r0, 0, r3);
        r2 = (T[]) r0;
    L5:
        r2[r3] = r4;
        return r2;
    }

    public static int growSize(int r1) {
        if (r1 > 4) goto L6;
        return 8;
    L6:
        return r1 * 2;
    }

    public static <T> T[] insert(T[] r2, int r3, int r4, T r5) {
        if ((r3 + 1) > r2.length) goto L6;
        System.arraycopy(r2, r4, r2, r4 + 1, r3 - r4);
        r2[r4] = r5;
        return r2;
    L6:
        T[] r6 = (T[]) ((Object[]) Array.newInstance(r2.getClass().getComponentType(), growSize(r3)));
        System.arraycopy(r2, 0, r6, 0, r4);
        r6[r4] = r5;
        System.arraycopy(r2, r4, r6, r4 + 1, r2.length - r4);
        return r6;
    }

    public static int[] append(int[] r2, int r3, int r4) {
        if ((r3 + 1) <= r2.length) goto L5;
        int[] r0 = new int[growSize(r3)];
        System.arraycopy(r2, 0, r0, 0, r3);
        r2 = r0;
    L5:
        r2[r3] = r4;
        return r2;
    }

    public static int[] insert(int[] r2, int r3, int r4, int r5) {
        if ((r3 + 1) > r2.length) goto L6;
        System.arraycopy(r2, r4, r2, r4 + 1, r3 - r4);
        r2[r4] = r5;
        return r2;
    L6:
        int[] r6 = new int[growSize(r3)];
        System.arraycopy(r2, 0, r6, 0, r4);
        r6[r4] = r5;
        System.arraycopy(r2, r4, r6, r4 + 1, r2.length - r4);
        return r6;
    }

    public static long[] append(long[] r2, int r3, long r4) {
        if ((r3 + 1) <= r2.length) goto L5;
        long[] r0 = new long[growSize(r3)];
        System.arraycopy(r2, 0, r0, 0, r3);
        r2 = r0;
    L5:
        r2[r3] = r4;
        return r2;
    }

    public static boolean[] append(boolean[] r2, int r3, boolean r4) {
        if ((r3 + 1) <= r2.length) goto L5;
        boolean[] r0 = new boolean[growSize(r3)];
        System.arraycopy(r2, 0, r0, 0, r3);
        r2 = r0;
    L5:
        r2[r3] = r4;
        return r2;
    }

    public static long[] insert(long[] r2, int r3, int r4, long r5) {
        if ((r3 + 1) > r2.length) goto L6;
        System.arraycopy(r2, r4, r2, r4 + 1, r3 - r4);
        r2[r4] = r5;
        return r2;
    L6:
        long[] r6 = new long[growSize(r3)];
        System.arraycopy(r2, 0, r6, 0, r4);
        r6[r4] = r5;
        System.arraycopy(r2, r4, r6, r4 + 1, r2.length - r4);
        return r6;
    }

    public static boolean[] insert(boolean[] r2, int r3, int r4, boolean r5) {
        if ((r3 + 1) > r2.length) goto L6;
        System.arraycopy(r2, r4, r2, r4 + 1, r3 - r4);
        r2[r4] = r5;
        return r2;
    L6:
        boolean[] r6 = new boolean[growSize(r3)];
        System.arraycopy(r2, 0, r6, 0, r4);
        r6[r4] = r5;
        System.arraycopy(r2, r4, r6, r4 + 1, r2.length - r4);
        return r6;
    }
}
