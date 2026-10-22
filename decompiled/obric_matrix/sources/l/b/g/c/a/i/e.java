package l.b.g.c.a.i;

import l.b.a.o;

/* JADX INFO: loaded from: classes2.dex */
class e {
    static o a(String r3) {
        if (r3.equals("SHA-256") == false) goto L7;
        return l.b.a.o2.a.f21649c;
    L7:
        if (r3.equals("SHA-512") == false) goto L11;
        return l.b.a.o2.a.f21651e;
    L11:
        if (r3.equals("SHAKE128") == false) goto L15;
        return l.b.a.o2.a.f21658l;
    L15:
        if (r3.equals("SHAKE256") == false) goto L19;
        return l.b.a.o2.a.m;
    L19:
        throw new IllegalArgumentException("unrecognized digest: " + r3);
    }
}
