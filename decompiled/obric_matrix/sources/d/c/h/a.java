package d.c.h;

import d.c.c.d.i;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static boolean a(d r2, InputStream r3) {
    L34:
        return true;
    L4:
        if (r2 != c.f15819a) goto L6;
        return false;
    L6:
        if (r2 != c.f15824f) goto L8;
        return false;
    L8:
        if (r2 != c.f15826h) goto L11;
        return false;
    L11:
        if (r2 != c.f15830l) goto L13;
    L31:
        return true;
    L13:
        if (r2 == c.f15821c) goto L31;
        if (r2 == c.f15829k) goto L31;
        if (r2 == c.f15822d) goto L31;
        if (r2 == c.f15823e) goto L31;
        if (r2 == c.f15827i) goto L31;
        if (r2 != c.f15820b) goto L28;
        return c(r3);
    L28:
        if (r2 != c.f15828j) goto L31;
        return b(r3);
    }

    private static boolean b(InputStream r2) {
        int r0 = e.d().e();
        byte[] r1 = new byte[r0];
        d(r0, r2, r1);
        return d.c.c.l.c.d(r1, 0);
    }

    private static boolean c(InputStream r2) {
        byte[] r1 = new byte[29];
        d(29, r2, r1);
        byte r3 = r1[25];
        if (r3 != 4) goto L5;
    L8:
        return true;
    L5:
        if (r3 == 6) goto L8;
        return false;
    }

    private static int d(int r2, InputStream r3, byte[] r4) {
        i.g(r3);
        i.g(r4);
        if (r4.length < r2) goto L5;
        boolean r0 = true;
    L6:
        i.b(r0);
        if (r3.markSupported() == false) goto L15;
        r3.mark(r2);     // Catch: Throwable -> L11
        int r5 = d.c.c.d.a.b(r3, r4, 0, r2);     // Catch: Throwable -> L11
        r3.reset();
        return r5;
    L11:
        th = move-exception;
        r3.reset();
        throw th;
    L15:
        return d.c.c.d.a.b(r3, r4, 0, r2);
    L5:
        r0 = false;
        goto L6
    }
}
