package l.b.a.u2.f;

import java.util.Enumeration;
import java.util.Hashtable;
import l.b.a.g1;
import l.b.a.o;
import l.b.a.s;
import l.b.a.u2.e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements e {
    public a() {
    }

    private int g(l.b.a.e r1) {
        return c.d(r1).hashCode();
    }

    public static Hashtable h(Hashtable r4) {
        Hashtable r0 = new Hashtable();
        Enumeration r1 = r4.keys();
    L4:
        if (r1.hasMoreElements() == false) goto L6;
        Object r2 = r1.nextElement();
        r0.put(r2, r4.get(r2));
        goto L4
    L6:
        return r0;
    }

    private boolean j(boolean r5, l.b.a.u2.b r6, l.b.a.u2.b[] r7) {
        if (r5 == false) goto L13;
        int r8 = r7.length - 1;
    L5:
        if (r8 < 0) goto L23;
        if (r7[r8] == null) goto L12;
        if (k(r6, r7[r8]) == false) goto L12;
        r7[r8] = null;
        return true;
    L12:
        r8 = r8 - 1;
    L23:
        return false;
    L13:
        int r9 = 0;
    L15:
        if (r9 == r7.length) goto L23;
        if (r7[r9] == null) goto L22;
        if (k(r6, r7[r9]) == false) goto L22;
        r7[r9] = null;
        return true;
    L22:
        r9 = r9 + 1;
        goto L15
    }

    @Override // l.b.a.u2.e
    public boolean a(l.b.a.u2.c r6, l.b.a.u2.c r7) {
        l.b.a.u2.b[] r8 = r6.n();
        l.b.a.u2.b[] r9 = r7.n();
        if (r8.length == r9.length) goto L6;
        return false;
    L6:
        if (r8[0].n() != null) goto L8;
    L10:
        boolean r0 = false;
    L11:
        int r3 = 0;
    L13:
        if (r3 == r8.length) goto L18;
        if (j(r0, r8[r3], r9) == false) goto L16;
        r3 = r3 + 1;
        goto L13
    L16:
        return false;
    L18:
        return true;
    L8:
        if (r9[0].n() == null) goto L10;
        r0 = !r8[0].n().o().r(r9[0].n().o());
        goto L11
    }

    @Override // l.b.a.u2.e
    public int d(l.b.a.u2.c r7) {
        l.b.a.u2.b[] r8 = r7.n();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 == r8.length) goto L13;
        if (r8[r1].q() == false) goto L11;
        l.b.a.u2.a[] r3 = r8[r1].p();
        int r4 = 0;
    L9:
        if (r4 == r3.length) goto L12;
        r2 = (r2 ^ r3[r4].o().hashCode()) ^ g(r3[r4].p());
        r4 = r4 + 1;
    L12:
        r1 = r1 + 1;
        goto L4
    L11:
        r2 = (r2 ^ r8[r1].n().o().hashCode()) ^ g(r8[r1].n().p());
        goto L12
    L13:
        return r2;
    }

    @Override // l.b.a.u2.e
    public l.b.a.e e(o r5, String r6) {
        if (r6.length() == 0) goto L11;
        if (r6.charAt(0) != '#') goto L11;
        return c.p(r6, 1);
    L9:
        throw new s("can't recode value for oid " + r5.A());
    L11:
        if (r6.length() == 0) goto L16;
        if (r6.charAt(0) != '\\') goto L16;
        r6 = r6.substring(1);
    L16:
        return i(r5, r6);
    }

    protected l.b.a.e i(o r1, String r2) {
        return new g1(r2);
    }

    protected boolean k(l.b.a.u2.b r1, l.b.a.u2.b r2) {
        return c.j(r1, r2);
    }
}
