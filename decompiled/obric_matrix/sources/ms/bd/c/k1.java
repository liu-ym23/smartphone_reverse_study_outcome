package ms.bd.c;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class k1 extends b.a {
    k1() {
    }

    @Override // ms.bd.c.b.a
    protected Object b(int r1, long r2, String r4, Object r5) {
        Throwable r0 = q4.b().c();
        if (r0 != null) goto L5;
        return "";
    L5:
        return Arrays.toString(r0.getStackTrace());
    }
}
