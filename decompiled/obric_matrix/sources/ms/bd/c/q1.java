package ms.bd.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/* JADX INFO: loaded from: classes2.dex */
final class q1 extends b.a {
    q1() {
    }

    @Override // ms.bd.c.b.a
    public Object b(int r1, long r2, String r4, Object r5) {
        Context r0 = a.a().c();
        ApplicationInfo r3 = r0.getPackageManager().getApplicationInfo(r0.getPackageName(), 0);
        String r6 = r3.sourceDir;
        if (r6 == null) goto L6;
        return r6;
    L6:
        return r3.publicSourceDir;
    }
}
