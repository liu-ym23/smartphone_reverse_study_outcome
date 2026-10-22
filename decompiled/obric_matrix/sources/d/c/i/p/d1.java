package d.c.i.p;

/* JADX INFO: loaded from: classes2.dex */
public final class d1 {
    public static int a(int r1) {
        return (int) (r1 * 1.3333334f);
    }

    public static boolean b(int r3, int r4, d.c.i.f.f r5) {
        int r6 = a(r3);
        if (r5 != null) goto L12;
        if (r6 < 2048.0f) goto L10;
        if (a(r4) < 2048) goto L10;
        return true;
    L10:
        return false;
    L12:
        if (r6 < r5.f16021a) goto L17;
        if (a(r4) < r5.f16022b) goto L17;
        return true;
    L17:
        return false;
    }

    public static boolean c(d.c.i.l.e r2, d.c.i.f.f r3) {
        if (r2 != null) goto L5;
        return false;
    L5:
        int r0 = r2.S();
        if (r0 != 90) goto L8;
    L12:
        int r1 = r2.M();
        int r4 = r2.Y();
    L11:
        return b(r1, r4, r3);
    L8:
        if (r0 == 270) goto L12;
        r1 = r2.Y();
        r4 = r2.M();
        goto L11
    }
}
