package ms.bd.c;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
final class h1 extends b.a {
    h1() {
    }

    @Override // ms.bd.c.b.a
    public Object b(int r1, long r2, String r4, Object r5) {
        Context r0 = a.a().c();
        String[] r6 = (String[]) r5;
        if (r0 == null) goto L16;
        if (r4 == null) goto L17;
        if (r6 != null) goto L7;
        return null;
    L7:
        if ((r6.length % 2) != 0) goto L19;
        Intent r3 = new Intent(r4);
        r3.setPackage(r0.getPackageName());
        int r7 = 0;
    L10:
        if (r7 >= r6.length) goto L12;
        r3.putExtra(r6[r7], r6[r7 + 1]);
        r7 = r7 + 2;
        goto L10
    L12:
        r0.sendBroadcast(r3);
        return null;
    L19:
        return null;
    L17:
        return null;
    L16:
        return null;
    }
}
