package l.b.g.d.a;

/* JADX INFO: loaded from: classes2.dex */
public final class j {
    public static int a(int r1) {
        int r0 = -1;
    L3:
        if (r1 == 0) goto L5;
        r0 = r0 + 1;
        r1 = r1 >>> 1;
        goto L3
    L5:
        return r0;
    }

    public static int b(int r1, int r2) {
    L2:
        int r0 = r2;
        int r3 = r1;
        r1 = r0;
        if (r1 == 0) goto L5;
        r2 = e(r3, r1);
        goto L2
    L5:
        return r3;
    }

    public static boolean c(int r6) {
        if (r6 != 0) goto L5;
        return false;
    L5:
        int r1 = a(r6) >>> 1;
        int r3 = 2;
        int r4 = 0;
    L6:
        if (r4 >= r1) goto L11;
        r3 = d(r3, r3, r6);
        if (b(r3 ^ 2, r6) != 1) goto L9;
        r4 = r4 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    public static int d(int r4, int r5, int r6) {
        int r7 = e(r4, r6);
        int r8 = e(r5, r6);
        int r0 = 0;
        if (r8 == 0) goto L12;
        int r1 = 1 << a(r6);
    L5:
        if (r7 == 0) goto L12;
        if (((byte) (r7 & 1)) != 1) goto L9;
        r0 = r0 ^ r8;
    L9:
        r7 = r7 >>> 1;
        r8 = r8 << 1;
        if (r8 < r1) goto L5;
        r8 = r8 ^ r6;
    L12:
        return r0;
    }

    public static int e(int r2, int r3) {
        if (r3 != 0) goto L6;
        System.err.println("Error: to be divided by 0");
        return 0;
    L6:
        if (a(r2) < a(r3)) goto L8;
        r2 = r2 ^ (r3 << (a(r2) - a(r3)));
        goto L6
    L8:
        return r2;
    }
}
