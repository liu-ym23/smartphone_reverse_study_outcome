package ms.bd.c;

import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes2.dex */
final class y0 extends b.a {
    y0() {
    }

    @Override // ms.bd.c.b.a
    public Object b(int r7, long r8, String r10, Object r11) {
        Boolean r6 = Boolean.FALSE;
        TelephonyManager r9 = (TelephonyManager) a.a().c().getApplicationContext().getSystemService((String) m.a(16777217, 0, 0, "a12aa7", new byte[]{96, 59, 78, 27, 91}));
        if (r9 != null) goto L5;
        return r6;
    L5:
        if (r9.getSimState() == 5) goto L8;
        return r6;
    L8:
        return Boolean.TRUE;
    }
}
