package ms.bd.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;

/* JADX INFO: loaded from: classes2.dex */
final class f1 extends b.a {
    f1() {
    }

    @Override // ms.bd.c.b.a
    public Object b(int r1, long r2, String r4, Object r5) {
        Context r0 = a.a().c();
        PackageManager r3 = r0.getPackageManager();
        String r6 = r0.getPackageName();
        if (r4 != null) goto L5;
    L7:
        r4 = r6;
    L8:
        Signature[] r7 = r3.getPackageInfo(r4, 64).signatures;
        if (r7 != null) goto L11;
    L13:
        return null;
    L11:
        if (r7.length <= 0) goto L13;
        return r7[0].toByteArray();
    L5:
        if (r4.isEmpty() == true) goto L7;
        goto L7
    }
}
