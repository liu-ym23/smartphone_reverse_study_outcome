package ms.bd.c;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
final class e extends b.a {
    e() {
    }

    @Override // ms.bd.c.b.a
    public Object b(int r7, long r8, String r10, Object r11) {
        Context r9 = a.a().c();     // Catch: Throwable -> L7
        return r9.getPackageManager().getApplicationInfo(r9.getPackageName(), 128).metaData.getString((String) m.a(16777217, 0, 0, "0d1dae", new byte[]{18, 85, 125, 38, 123, 64, 0, 108, 79, 26, 30, 72, 99, 61, 123}));
    L7:
        String r6 = (String) m.a(16777217, 0, 0, "eb27d0", new byte[]{125, 105});
        return "";
    }
}
