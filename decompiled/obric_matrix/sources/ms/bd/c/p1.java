package ms.bd.c;

import android.net.ConnectivityManager;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
final class p1 extends b.a {
    p1() {
    }

    @Override // ms.bd.c.b.a
    protected Object b(int r8, long r9, String r11, Object r12) {
        if (Build.VERSION.SDK_INT < 23) goto L17;
        ConnectivityManager r7 = (ConnectivityManager) a.a().c().getSystemService((String) m.a(16777217, 0, 0, "bf852d", new byte[]{112, 107, 69, 79, 8, 112, 117, 78, 127, 108, 103, 125}));     // Catch: Throwable -> L18
        if (r7.getNetworkCapabilities(r7.getActiveNetwork()).hasTransport(4) == false) goto L13;
        Object r10 = m.a(16777217, 0, 0, "43cfa3", new byte[]{116});     // Catch: Throwable -> L18
    L14:
        return (String) r10;
    L13:
        r10 = m.a(16777217, 0, 0, "ea9c3c", new byte[]{36});     // Catch: Throwable -> L18
    L17:
        return (String) m.a(16777217, 0, 0, "021200", new byte[]{113});
    }
}
