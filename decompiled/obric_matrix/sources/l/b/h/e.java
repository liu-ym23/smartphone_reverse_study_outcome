package l.b.h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {
    public static int a(byte[] r2, int r3) {
        int r0 = r2[r3] << 24;
        int r4 = r3 + 1;
        int r1 = r0 | ((r2[r4] & 255) << 16);
        int r5 = r4 + 1;
        int r6 = r1 | ((r2[r5] & 255) << 8);
        return (r2[r5 + 1] & 255) | r6;
    }

    public static long b(byte[] r4, int r5) {
        int r0 = a(r4, r5);
        long r6 = ((long) a(r4, r5 + 4)) & 4294967295L;
        return r6 | ((((long) r0) & 4294967295L) << 32);
    }

    public static void c(int r1, byte[] r2, int r3) {
        r2[r3] = (byte) (r1 >>> 24);
        int r4 = r3 + 1;
        r2[r4] = (byte) (r1 >>> 16);
        int r5 = r4 + 1;
        r2[r5] = (byte) (r1 >>> 8);
        r2[r5 + 1] = (byte) r1;
    }

    public static void d(int r1, byte[] r2, int r3) {
        r2[r3] = (byte) r1;
        int r4 = r3 + 1;
        r2[r4] = (byte) (r1 >>> 8);
        int r5 = r4 + 1;
        r2[r5] = (byte) (r1 >>> 16);
        r2[r5 + 1] = (byte) (r1 >>> 24);
    }

    public static int e(byte[] r2, int r3) {
        int r0 = r2[r3] & 255;
        int r4 = r3 + 1;
        int r1 = r0 | ((r2[r4] & 255) << 8);
        int r5 = r4 + 1;
        int r6 = r1 | ((r2[r5] & 255) << 16);
        return (r2[r5 + 1] << 24) | r6;
    }

    public static long f(byte[] r5, int r6) {
        int r0 = e(r5, r6);
        return ((((long) e(r5, r6 + 4)) & 4294967295L) << 32) | (((long) r0) & 4294967295L);
    }

    public static short g(byte[] r1, int r2) {
        int r0 = r1[r2] & 255;
        return (short) (((r1[r2 + 1] & 255) << 8) | r0);
    }

    public static void h(long r2, byte[] r4, int r5) {
        c((int) (r2 >>> 32), r4, r5);
        c((int) (r2 & 4294967295L), r4, r5 + 4);
    }

    public static void i(long r2, byte[] r4, int r5) {
        d((int) (4294967295L & r2), r4, r5);
        d((int) (r2 >>> 32), r4, r5 + 4);
    }

    public static void j(long[] r3, int r4, int r5, byte[] r6, int r7) {
        int r0 = 0;
    L3:
        if (r0 >= r5) goto L5;
        i(r3[r4 + r0], r6, r7);
        r7 = r7 + 8;
        r0 = r0 + 1;
        goto L3
    }

    public static void k(short r1, byte[] r2, int r3) {
        r2[r3] = (byte) (r1 >>> 8);
        r2[r3 + 1] = (byte) r1;
    }

    public static void l(short r1, byte[] r2, int r3) {
        r2[r3] = (byte) r1;
        r2[r3 + 1] = (byte) (r1 >>> 8);
    }
}
