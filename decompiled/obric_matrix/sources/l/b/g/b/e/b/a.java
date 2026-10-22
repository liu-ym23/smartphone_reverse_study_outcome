package l.b.g.b.e.b;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static byte[] a(short[] r3) {
        byte[] r0 = new byte[r3.length];
        int r1 = 0;
    L4:
        if (r1 >= r3.length) goto L6;
        r0[r1] = (byte) r3[r1];
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static short[] b(byte[] r3) {
        short[] r0 = new short[r3.length];
        int r1 = 0;
    L4:
        if (r1 >= r3.length) goto L6;
        r0[r1] = (short) (r3[r1] & 255);
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static byte[][] c(short[][] r6) {
        byte[][] r0 = (byte[][]) Array.newInstance(byte.class, new int[]{r6.length, r6[0].length});
        int r2 = 0;
    L4:
        if (r2 >= r6.length) goto L10;
        int r3 = 0;
    L7:
        if (r3 >= r6[0].length) goto L9;
        r0[r2][r3] = (byte) r6[r2][r3];
        r3 = r3 + 1;
        goto L7
    L9:
        r2 = r2 + 1;
        goto L4
    L10:
        return r0;
    }

    public static short[][] d(byte[][] r6) {
        short[][] r0 = (short[][]) Array.newInstance(short.class, new int[]{r6.length, r6[0].length});
        int r2 = 0;
    L4:
        if (r2 >= r6.length) goto L10;
        int r3 = 0;
    L7:
        if (r3 >= r6[0].length) goto L9;
        r0[r2][r3] = (short) (r6[r2][r3] & 255);
        r3 = r3 + 1;
        goto L7
    L9:
        r2 = r2 + 1;
        goto L4
    L10:
        return r0;
    }

    public static byte[][][] e(short[][][] r7) {
        byte[][][] r0 = (byte[][][]) Array.newInstance(byte.class, new int[]{r7.length, r7[0].length, r7[0][0].length});
        int r2 = 0;
    L4:
        if (r2 >= r7.length) goto L14;
        int r3 = 0;
    L7:
        if (r3 >= r7[0].length) goto L13;
        int r4 = 0;
    L10:
        if (r4 >= r7[0][0].length) goto L12;
        r0[r2][r3][r4] = (byte) r7[r2][r3][r4];
        r4 = r4 + 1;
        goto L10
    L12:
        r3 = r3 + 1;
        goto L7
    L13:
        r2 = r2 + 1;
        goto L4
    L14:
        return r0;
    }

    public static short[][][] f(byte[][][] r7) {
        short[][][] r0 = (short[][][]) Array.newInstance(short.class, new int[]{r7.length, r7[0].length, r7[0][0].length});
        int r2 = 0;
    L4:
        if (r2 >= r7.length) goto L14;
        int r3 = 0;
    L7:
        if (r3 >= r7[0].length) goto L13;
        int r4 = 0;
    L10:
        if (r4 >= r7[0][0].length) goto L12;
        r0[r2][r3][r4] = (short) (r7[r2][r3][r4] & 255);
        r4 = r4 + 1;
        goto L10
    L12:
        r3 = r3 + 1;
        goto L7
    L13:
        r2 = r2 + 1;
        goto L4
    L14:
        return r0;
    }

    public static int[] g(byte[] r3) {
        int[] r0 = new int[r3.length];
        int r1 = 0;
    L4:
        if (r1 >= r3.length) goto L6;
        r0[r1] = r3[r1] & 255;
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static byte[] h(int[] r3) {
        byte[] r0 = new byte[r3.length];
        int r1 = 0;
    L4:
        if (r1 >= r3.length) goto L6;
        r0[r1] = (byte) r3[r1];
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static boolean i(short[] r6, short[] r7) {
        if (r6.length == r7.length) goto L5;
        return false;
    L5:
        int r0 = r6.length - 1;
        boolean r3 = true;
    L6:
        if (r0 < 0) goto L12;
        if (r6[r0] != r7[r0]) goto L10;
        boolean r4 = true;
    L11:
        r3 = r3 & r4;
        r0 = r0 - 1;
        goto L6
    L10:
        r4 = false;
        goto L11
    L12:
        return r3;
    }

    public static boolean j(short[][] r4, short[][] r5) {
        if (r4.length == r5.length) goto L6;
        return false;
    L6:
        boolean r1 = true;
        int r0 = r4.length - 1;
    L7:
        if (r0 < 0) goto L9;
        r1 = r1 & i(r4[r0], r5[r0]);
        r0 = r0 - 1;
        goto L7
    L9:
        return r1;
    }

    public static boolean k(short[][][] r4, short[][][] r5) {
        if (r4.length == r5.length) goto L6;
        return false;
    L6:
        boolean r1 = true;
        int r0 = r4.length - 1;
    L7:
        if (r0 < 0) goto L9;
        r1 = r1 & j(r4[r0], r5[r0]);
        r0 = r0 - 1;
        goto L7
    L9:
        return r1;
    }
}
