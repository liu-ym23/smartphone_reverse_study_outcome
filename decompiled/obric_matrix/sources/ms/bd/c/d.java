package ms.bd.c;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
final class d extends b.a {
    d() {
    }

    @Override // ms.bd.c.b.a
    public Object b(int r7, long r8, String r10, Object r11) {
        Context r6 = a.a().c();     // Catch: Throwable -> L4
        return r6.getPackageManager().getPackageInfo(r6.getPackageName(), 0).versionName;
    L4:
        String r9 = (String) m.a(16777217, 0, 0, "d18b20", new byte[]{124, 58});
        return "";
    }
}
