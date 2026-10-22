package ms.bd.c;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class o1 extends b.a {
    o1() {
    }

    @Override // ms.bd.c.b.a
    protected Object b(int r1, long r2, String r4, Object r5) {
        x4 r0 = x4.c();     // Catch: Exception -> L10
        if (r0.l() == false) goto L8;
        JSONObject r3 = r0.i();     // Catch: Exception -> L10
        if (r3 == null) goto L13;
        return r3.toString();
    L13:
        return "";
    L8:
        return "";
    L14:
        return "";
    }
}
