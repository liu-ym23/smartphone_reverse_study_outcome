package ms.bd.c;

import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
final class l1 extends b.a {
    l1() {
    }

    @Override // ms.bd.c.b.a
    protected Object b(int r2, long r3, String r5, Object r6) {
        Throwable r1 = q4.b().c();
        if (r1 != null) goto L5;
        return null;
    L5:
        StackTraceElement[] r4 = r1.getStackTrace();
        if (r4.length >= 4) goto L8;
        return null;
    L8:
        ArrayList r7 = new ArrayList();
        int r8 = 1;
    L9:
        if (r8 >= 4) goto L17;
        if (r4[r8] == null) goto L16;
        if (TextUtils.isEmpty(r4[r8].getClassName()) == true) goto L16;
        Class<?> r9 = Class.forName(r4[r8].getClassName());
        r7.addAll(q4.b().a(r9, r4[r8].getMethodName()));
    L16:
        r8 = r8 + 1;
        goto L9
    L17:
        return r7;
    }
}
