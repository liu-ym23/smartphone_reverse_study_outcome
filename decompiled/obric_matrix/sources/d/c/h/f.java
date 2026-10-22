package d.c.h;

import d.c.c.d.i;

/* JADX INFO: loaded from: classes.dex */
public class f {
    public static byte[] a(String r2) {
        i.g(r2);
        return r2.getBytes("ASCII");
    L5:
        e = move-exception;
        throw new RuntimeException("ASCII not found!", e);
    }

    public static int b(byte[] r8, int r9, byte[] r10, int r11) {
        i.g(r8);
        i.g(r10);
        if (r11 <= r9) goto L5;
        return -1;
    L5:
        int r1 = 0;
        byte r2 = r10[0];
        int r12 = r9 - r11;
    L6:
        if (r1 > r12) goto L23;
        int r4 = 1;
        if (r8[r1] == r2) goto L14;
    L9:
        r1 = r1 + 1;
        if (r1 > r12) goto L14;
        if (r8[r1] != r2) goto L9;
    L14:
        if (r1 > r12) goto L22;
        int r3 = r1 + 1;
        int r5 = (r3 + r11) - 1;
    L16:
        if (r3 >= r5) goto L20;
        if (r8[r3] != r10[r4]) goto L20;
        r3 = r3 + 1;
        r4 = r4 + 1;
    L20:
        if (r3 != r5) goto L22;
        return r1;
    L22:
        r1 = r1 + 1;
        goto L6
    L23:
        return -1;
    }

    public static boolean c(byte[] r4, byte[] r5) {
        i.g(r4);
        i.g(r5);
        if (r5.length <= r4.length) goto L5;
        return false;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= r5.length) goto L12;
        if (r4[r0] != r5[r0]) goto L10;
        r0 = r0 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }
}
