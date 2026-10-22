package d.c.i.p;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class q {
    static float a(d.c.i.f.g r7, @Nullable d.c.i.f.f r8, d.c.i.l.e r9) {
        d.c.c.d.i.b(d.c.i.l.e.n0(r9));
        if (r8 != null) goto L5;
        return 1.0f;
    L5:
        if (r8.f16022b > 0) goto L7;
        return 1.0f;
    L7:
        if (r8.f16021a > 0) goto L9;
        return 1.0f;
    L9:
        if (r9.Y() != 0) goto L11;
        return 1.0f;
    L11:
        if (r9.M() == 0) goto L33;
        int r10 = c(r7, r9);
        if (r10 != 90) goto L16;
    L19:
        boolean r11 = true;
    L20:
        if (r11 == false) goto L22;
        int r0 = r9.M();
    L23:
        if (r11 == false) goto L25;
        int r12 = r9.Y();
    L26:
        float r13 = r8.f16021a / r0;
        float r3 = r8.f16022b / r12;
        float r4 = Math.max(r13, r3);
        d.c.c.e.a.x("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f", new Object[]{Integer.valueOf(r8.f16021a), Integer.valueOf(r8.f16022b), Integer.valueOf(r0), Integer.valueOf(r12), Float.valueOf(r13), Float.valueOf(r3), Float.valueOf(r4)});
        return r4;
    L25:
        r12 = r9.M();
        goto L26
    L22:
        r0 = r9.Y();
        goto L23
    L16:
        if (r10 == 270) goto L19;
        r11 = false;
        goto L20
    L33:
        return 1.0f;
    }

    public static int b(d.c.i.f.g r2, @Nullable d.c.i.f.f r3, d.c.i.l.e r4, int r5) {
        if (d.c.i.l.e.n0(r4) == true) goto L6;
        return 1;
    L6:
        float r6 = a(r2, r3, r4);
        if (r4.N() != d.c.h.c.f15819a) goto L9;
        int r7 = e(r6);
    L10:
        int r0 = Math.max(r4.M(), r4.Y());
        if (r3 == null) goto L13;
        float r8 = r3.f16023c;
    L15:
        if ((r0 / r7) <= r8) goto L20;
        if (r4.N() == d.c.h.c.f15819a) goto L18;
        r7 = r7 + 1;
        goto L15
    L18:
        r7 = r7 * 2;
        goto L15
    L20:
        return r7;
    L13:
        r8 = r5;
        goto L15
    L9:
        r7 = d(r6);
        goto L10
    }

    private static int c(d.c.i.f.g r1, d.c.i.l.e r2) {
        boolean r0 = false;
        if (r1.g() == true) goto L5;
        return 0;
    L5:
        int r3 = r2.S();
        if (r3 != 0) goto L8;
    L13:
        r0 = true;
    L14:
        d.c.c.d.i.b(r0);
        return r3;
    L8:
        if (r3 == 90) goto L13;
        if (r3 == 180) goto L13;
        if (r3 != 270) goto L14;
        goto L13
    }

    static int d(float r8) {
        if (r8 <= 0.6666667f) goto L5;
        return 1;
    L5:
        int r0 = 2;
    L6:
        double r2 = r0;
        if (((1.0d / r2) + ((1.0d / (Math.pow(r2, 2.0d) - r2)) * 0.3333333432674408d)) <= r8) goto L9;
        r0 = r0 + 1;
        goto L6
    L9:
        return r0 - 1;
    }

    static int e(float r6) {
        if (r6 <= 0.6666667f) goto L6;
        return 1;
    L6:
        int r0 = 2;
    L7:
        int r3 = r0 * 2;
        double r1 = 1.0d / ((double) r3);
        if ((r1 + (0.3333333432674408d * r1)) <= r6) goto L9;
        r0 = r3;
        goto L7
    L9:
        return r0;
    }
}
