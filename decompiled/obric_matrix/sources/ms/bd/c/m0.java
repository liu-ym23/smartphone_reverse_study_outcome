package ms.bd.c;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
final class m0 extends b.a {
    m0() {
    }

    @Override // ms.bd.c.b.a
    public Object b(int r7, long r8, String r10, Object r11) {
        File r9 = new File(a.a().c().getFilesDir(), (String) m.a(16777217, 0, 0, "3b9979", new byte[]{108, 109, 89, 73, 9, 58, 49}));
        if (r9.exists() == true) goto L6;
        r9.mkdirs();
    L6:
        return r9.getAbsolutePath();
    }
}
