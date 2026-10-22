package l.b.g.d.a;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    static {
        BigInteger.valueOf(0);
        BigInteger.valueOf(1);
        BigInteger.valueOf(2);
        BigInteger.valueOf(4);
    }

    public static int a(int r1) {
        if (r1 != 0) goto L5;
        return 1;
    L5:
        if (r1 >= 0) goto L7;
        r1 = -r1;
    L7:
        int r0 = 0;
    L8:
        if (r1 <= 0) goto L10;
        r0 = r0 + 1;
        r1 = r1 >>> 8;
        goto L8
    L10:
        return r0;
    }
}
