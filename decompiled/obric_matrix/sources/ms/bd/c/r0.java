package ms.bd.c;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
final class r0 extends b.a {
    r0() {
    }

    @Override // ms.bd.c.b.a
    public Object b(int r1, long r2, String r4, Object r5) {
        Context r0 = a.a().c();
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.getPackageName();
    }
}
