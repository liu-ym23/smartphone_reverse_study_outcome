package d.c.i.s;

import android.graphics.Matrix;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d.c.c.d.e<Integer> f16527a = null;

    static {
        f16527a = d.c.c.d.e.a(new Integer[]{2, 7, 4, 5});
    }

    public static int a(int r1) {
        return Math.max(1, 8 / r1);
    }

    public static float b(d.c.i.f.f r2, int r3, int r4) {
        if (r2 != null) goto L5;
        return 1.0f;
    L5:
        float r5 = r3;
        float r6 = r4;
        float r0 = Math.max(r2.f16021a / r5, r2.f16022b / r6);
        float r1 = r5 * r0;
        float r7 = r2.f16023c;
        if (r1 <= r7) goto L9;
        r0 = r7 / r5;
    L9:
        if ((r6 * r0) > r7) goto L11;
        return r0;
    L11:
        return r7 / r6;
    }

    private static int c(d.c.i.l.e r2) {
        int r0 = r2.S();
        if (r0 == 90) goto L11;
        if (r0 == 180) goto L11;
        if (r0 == 270) goto L11;
        return 0;
    L11:
        return r2.S();
    }

    public static int d(d.c.i.f.g r3, d.c.i.l.e r4) {
        int r5 = r4.E();
        d.c.c.d.e<Integer> r0 = f16527a;
        int r6 = r0.indexOf(Integer.valueOf(r5));
        if (r6 < 0) goto L10;
        int r1 = 0;
        if (r3.g() == true) goto L8;
        r1 = r3.e();
    L8:
        return r0.get((r6 + (r1 / 90)) % r0.size()).intValue();
    L10:
        throw new IllegalArgumentException("Only accepts inverted exif orientations");
    }

    public static int e(d.c.i.f.g r1, d.c.i.l.e r2) {
        if (r1.f() == true) goto L6;
        return 0;
    L6:
        int r3 = c(r2);
        if (r1.g() == false) goto L10;
        return r3;
    L10:
        return (r3 + r1.e()) % 360;
    }

    public static int f(d.c.i.f.g r4, d.c.i.f.f r5, d.c.i.l.e r6, boolean r7) {
        if (r7 == true) goto L5;
        return 8;
    L5:
        if (r5 != null) goto L7;
        return 8;
    L7:
        int r8 = e(r4, r6);
        boolean r2 = false;
        if (f16527a.contains(Integer.valueOf(r6.E())) == false) goto L10;
        int r9 = d(r4, r6);
    L12:
        if (r8 != 90) goto L14;
    L19:
        r2 = true;
    L20:
        if (r2 == false) goto L22;
        int r10 = r6.M();
    L23:
        if (r2 == false) goto L25;
        int r11 = r6.Y();
    L26:
        int r12 = k(b(r5, r10, r11), r5.f16024d);
        if (r12 <= 8) goto L29;
        return 8;
    L29:
        if (r12 >= 1) goto L32;
        return 1;
    L32:
        return r12;
    L25:
        r11 = r6.M();
        goto L26
    L22:
        r10 = r6.Y();
        goto L23
    L14:
        if (r8 == 270) goto L19;
        if (r9 == 5) goto L19;
        if (r9 != 7) goto L20;
    L10:
        r9 = 0;
        goto L12
    }

    public static Matrix g(d.c.i.l.e r2, d.c.i.f.g r3) {
        if (f16527a.contains(Integer.valueOf(r2.E())) == true) goto L10;
        int r4 = e(r3, r2);
        if (r4 == 0) goto L8;
        Matrix r5 = new Matrix();
        r5.setRotate(r4);
        return r5;
    L8:
        return null;
    L10:
        return h(d(r3, r2));
    }

    private static Matrix h(int r4) {
        Matrix r0 = new Matrix();
        if (r4 != 2) goto L5;
        r0.setScale(-1.0f, 1.0f);
    L17:
        return r0;
    L5:
        if (r4 != 7) goto L7;
        float r5 = -90.0f;
    L14:
        r0.setRotate(r5);
        r0.postScale(-1.0f, 1.0f);
        goto L17
    L7:
        if (r4 != 4) goto L9;
        r5 = 180.0f;
        goto L14
    L9:
        if (r4 == 5) goto L12;
        return null;
    L12:
        r5 = 90.0f;
        goto L14
    }

    public static boolean i(int r0) {
        switch(r0) {
            case 1: goto L5;
            case 2: goto L5;
            case 3: goto L5;
            case 4: goto L5;
            case 5: goto L5;
            case 6: goto L5;
            case 7: goto L5;
            case 8: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        return true;
    }

    public static boolean j(int r1) {
        if (r1 >= 0) goto L4;
    L8:
        return false;
    L4:
        if (r1 > 270) goto L8;
        if ((r1 % 90) != 0) goto L8;
        return true;
    }

    public static int k(float r1, float r2) {
        return (int) (r2 + (r1 * 8.0f));
    }
}
