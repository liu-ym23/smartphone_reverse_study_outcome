package ms.bd.c;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
final class m1 extends b.a {
    m1() {
    }

    @Override // ms.bd.c.b.a
    protected Object b(int r7, long r8, String r10, Object r11) {
        if (e4.i() == 1) goto L13;
        Object r6 = m.a(16777217, 0, 0, "c3af07", new byte[]{34});
    L6:
        return (String) r6;
    L13:
        e0.e();     // Catch: Throwable -> L12
    L9:
        if (TextUtils.isEmpty(null) == false) goto L11;
        r6 = m.a(16777217, 0, 0, "f6b6b5", new byte[]{39});
        goto L6
    L11:
        throw null;
    }
}
