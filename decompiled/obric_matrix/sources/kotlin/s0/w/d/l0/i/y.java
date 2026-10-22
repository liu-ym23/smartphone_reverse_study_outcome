package kotlin.s0.w.d.l0.i;

/* JADX INFO: loaded from: classes2.dex */
final class y {
    private static int a(int r1) {
        if (r1 <= (-12)) goto L6;
        return -1;
    L6:
        return r1;
    }

    private static int b(int r1, int r2) {
        if (r1 <= (-12)) goto L5;
    L8:
        return -1;
    L5:
        if (r2 > (-65)) goto L8;
        return r1 ^ (r2 << 8);
    }

    private static int c(int r1, int r2, int r3) {
        if (r1 <= (-12)) goto L5;
    L9:
        return -1;
    L5:
        if (r2 > (-65)) goto L9;
        if (r3 > (-65)) goto L9;
        return (r1 ^ (r2 << 8)) ^ (r3 << 16);
    }

    private static int d(byte[] r3, int r4, int r5) {
        byte r0 = r3[r4 - 1];
        int r6 = r5 - r4;
        if (r6 == 0) goto L15;
        if (r6 == 1) goto L13;
        if (r6 != 2) goto L11;
        return c(r0, r3[r4], r3[r4 + 1]);
    L11:
        throw new AssertionError();
    L13:
        return b(r0, r3[r4]);
    L15:
        return a(r0);
    }

    public static boolean e(byte[] r2) {
        return f(r2, 0, r2.length);
    }

    public static boolean f(byte[] r0, int r1, int r2) {
        if (h(r0, r1, r2) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static int g(int r6, byte[] r7, int r8, int r9) {
        if (r6 == 0) goto L55;
        if (r8 < r9) goto L5;
        return r6;
    L5:
        byte r0 = (byte) r6;
        if (r0 >= (-32)) goto L15;
        if (r0 < (-62)) goto L13;
        int r10 = r8 + 1;
        if (r7[r8] > (-65)) goto L13;
    L12:
        r8 = r10;
    L13:
        return -1;
    L15:
        if (r0 >= (-16)) goto L33;
        byte r11 = (byte) (~(r6 >> 8));
        if (r11 != 0) goto L23;
        int r12 = r8 + 1;
        byte r13 = r7[r8];
        if (r12 >= r9) goto L21;
        r8 = r12;
        r11 = r13;
        goto L23
    L21:
        return b(r0, r13);
    L23:
        if (r11 <= (-65)) goto L25;
    L32:
        return -1;
    L25:
        if (r0 != (-32)) goto L28;
        if (r11 < (-96)) goto L32;
    L28:
        if (r0 != (-19)) goto L30;
        if (r11 >= (-96)) goto L32;
    L30:
        r10 = r8 + 1;
        if (r7[r8] <= (-65)) goto L12;
    L33:
        byte r1 = (byte) (~(r6 >> 8));
        byte r4 = 0;
        if (r1 != 0) goto L40;
        int r14 = r8 + 1;
        r1 = r7[r8];
        if (r14 >= r9) goto L38;
        r8 = r14;
    L41:
        if (r4 != 0) goto L47;
        int r15 = r8 + 1;
        r4 = r7[r8];
        if (r15 >= r9) goto L45;
        r8 = r15;
        goto L47
    L45:
        return c(r0, r1, r4);
    L47:
        if (r1 <= (-65)) goto L49;
    L53:
        return -1;
    L49:
        if ((((r0 << 28) + (r1 + 112)) >> 30) != 0) goto L53;
        if (r4 > (-65)) goto L53;
        r10 = r8 + 1;
        if (r7[r8] <= (-65)) goto L12;
    L38:
        return b(r0, r1);
    L40:
        r4 = (byte) (r6 >> 16);
    L55:
        return h(r7, r8, r9);
    }

    public static int h(byte[] r1, int r2, int r3) {
    L2:
        if (r2 >= r3) goto L6;
        if (r1[r2] < 0) goto L6;
        r2 = r2 + 1;
    L6:
        if (r2 < r3) goto L9;
        return 0;
    L9:
        return i(r1, r2, r3);
    }

    private static int i(byte[] r6, int r7, int r8) {
    L2:
        if (r7 >= r8) goto L3;
        int r0 = r7 + 1;
        byte r9 = r6[r7];
        if (r9 >= 0) goto L46;
        if (r9 < (-32)) goto L9;
        if (r9 < (-16)) goto L19;
        if (r0 >= (r8 - 2)) goto L36;
        int r1 = r0 + 1;
        byte r2 = r6[r0];
        if (r2 > (-65)) goto L45;
        if ((((r9 << 28) + (r2 + 112)) >> 30) != 0) goto L45;
        int r10 = r1 + 1;
        if (r6[r1] > (-65)) goto L45;
        r0 = r10 + 1;
        if (r6[r10] <= (-65)) goto L46;
    L45:
        return -1;
    L36:
        return d(r6, r0, r8);
    L19:
        if (r0 >= (r8 - 1)) goto L21;
        int r4 = r0 + 1;
        byte r3 = r6[r0];
        if (r3 > (-65)) goto L32;
        if (r9 != (-32)) goto L28;
        if (r3 < (-96)) goto L32;
    L28:
        if (r9 != (-19)) goto L30;
        if (r3 >= (-96)) goto L32;
    L30:
        r7 = r4 + 1;
        if (r6[r4] <= (-65)) goto L2;
    L32:
        return -1;
    L21:
        return d(r6, r0, r8);
    L9:
        if (r0 >= r8) goto L10;
        if (r9 < (-62)) goto L15;
        r7 = r0 + 1;
        if (r6[r0] <= (-65)) goto L2;
    L15:
        return -1;
    L10:
        return r9;
    L46:
        r7 = r0;
        goto L2
    L3:
        return 0;
    }
}
