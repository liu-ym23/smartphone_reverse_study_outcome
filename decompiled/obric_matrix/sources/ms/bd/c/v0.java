package ms.bd.c;

import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
final class v0 extends b.a {
    v0() {
    }

    @Override // ms.bd.c.b.a
    public Object b(int r7, long r8, String r10, Object r11) {
        Locale r6 = a.a().c().getResources().getConfiguration().locale;     // Catch: Throwable -> L7
        String r9 = r6.getLanguage();     // Catch: Throwable -> L7
        String r12 = r6.getCountry();     // Catch: Throwable -> L7
        StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L7
        r13.append(r9);     // Catch: Throwable -> L7
        r13.append((String) m.a(16777217, 0, 0, "a85a3b", new byte[]{79}));     // Catch: Throwable -> L7
        r13.append(r12);     // Catch: Throwable -> L7
        String r14 = r13.toString();     // Catch: Throwable -> L7
    L9:
        return r4.a(r14);
    L7:
        r14 = null;
        goto L9
    }
}
