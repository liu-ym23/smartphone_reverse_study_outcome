package d.c.c.k;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static int a(int r0, int r1) {
        return ((r0 + 31) * 31) + r1;
    }

    public static int b(int r0, int r1, int r2) {
        return ((((r0 + 31) * 31) + r1) * 31) + r2;
    }

    public static int c(int r0, int r1, int r2, int r3, int r4, int r5) {
        return ((((((((((r0 + 31) * 31) + r1) * 31) + r2) * 31) + r3) * 31) + r4) * 31) + r5;
    }

    public static int d(Object r1, Object r2) {
        int r0 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        if (r2 == null) goto L10;
        r0 = r2.hashCode();
    L10:
        return a(r3, r0);
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public static int e(Object r7, Object r8, Object r9, Object r10, Object r11, Object r12) {
        int r0 = 0;
        if (r7 != null) goto L5;
        int r1 = 0;
    L6:
        if (r8 != null) goto L8;
        int r2 = 0;
    L9:
        if (r9 != null) goto L11;
        int r3 = 0;
    L12:
        if (r10 != null) goto L14;
        int r4 = 0;
    L15:
        if (r11 != null) goto L17;
        int r5 = 0;
    L18:
        if (r12 == null) goto L22;
        r0 = r12.hashCode();
    L22:
        return c(r1, r2, r3, r4, r5, r0);
    L17:
        r5 = r11.hashCode();
        goto L18
    L14:
        r4 = r10.hashCode();
        goto L15
    L11:
        r3 = r9.hashCode();
        goto L12
    L8:
        r2 = r8.hashCode();
        goto L9
    L5:
        r1 = r7.hashCode();
        goto L6
    }
}
