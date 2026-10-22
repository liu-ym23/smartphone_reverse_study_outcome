package d.c.c.k;

import d.c.c.d.i;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static long a(InputStream r7, long r8) {
        i.g(r7);
        if (r8 < 0) goto L5;
        boolean r2 = true;
    L6:
        i.b(r2);
        long r3 = r8;
    L8:
        if (r3 <= 0) goto L21;
        long r4 = r7.skip(r3);
        if (r4 > 0) goto L11;
        if (r7.read() == (-1)) goto L16;
        r4 = 1;
        goto L11
    L16:
        return r8 - r3;
    L11:
        r3 = r3 - r4;
        goto L8
    L21:
        return r8;
    L5:
        r2 = false;
        goto L6
    }
}
