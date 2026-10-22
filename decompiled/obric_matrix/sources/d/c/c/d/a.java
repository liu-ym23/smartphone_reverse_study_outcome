package d.c.c.d;

import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static long a(InputStream r5, OutputStream r6) {
        i.g(r5);
        i.g(r6);
        byte[] r0 = new byte[4096];
        long r1 = 0;
    L3:
        int r3 = r5.read(r0);
        if (r3 == (-1)) goto L5;
        r6.write(r0, 0, r3);
        r1 = r1 + ((long) r3);
        goto L3
    L5:
        return r1;
    }

    public static int b(InputStream r3, byte[] r4, int r5, int r6) {
        i.g(r3);
        i.g(r4);
        if (r6 < 0) goto L12;
        int r0 = 0;
    L5:
        if (r0 >= r6) goto L10;
        int r1 = r3.read(r4, r5 + r0, r6 - r0);
        if (r1 == (-1)) goto L10;
        r0 = r0 + r1;
    L10:
        return r0;
    L12:
        throw new IndexOutOfBoundsException("len is negative");
    }
}
