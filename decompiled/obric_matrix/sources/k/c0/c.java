package k.c0;

import k.w;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final int a(int[] r2, int r3, int r4, int r5) {
        o.g(r2, "$this$binarySearch");
        int r6 = r5 - 1;
    L3:
        if (r4 > r6) goto L11;
        int r0 = (r4 + r6) >>> 1;
        int r1 = r2[r0];
        if (r1 < r3) goto L6;
        if (r1 <= r3) goto L9;
        r6 = r0 - 1;
        goto L3
    L9:
        return r0;
    L6:
        r4 = r0 + 1;
        goto L3
    L11:
        return (-r4) - 1;
    }

    public static final int b(w r2, int r3) {
        o.g(r2, "$this$segment");
        int r4 = a(r2.H(), r3 + 1, 0, r2.I().length);
        if (r4 < 0) goto L6;
        return r4;
    L6:
        return ~r4;
    }
}
