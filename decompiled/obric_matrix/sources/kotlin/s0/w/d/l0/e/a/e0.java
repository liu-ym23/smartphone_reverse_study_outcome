package kotlin.s0.w.d.l0.e.a;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class e0 {
    public static final List<kotlin.s0.w.d.l0.g.f> a(kotlin.s0.w.d.l0.g.f r2) {
        kotlin.n0.d.o.f(r2, "name");
        String r0 = r2.b();
        kotlin.n0.d.o.e(r0, "name.asString()");
        if (z.c(r0) == false) goto L7;
        return kotlin.i0.r.k(b(r2));
    L7:
        if (z.d(r0) == false) goto L11;
        return f(r2);
    L11:
        return g.f19258a.b(r2);
    }

    public static final kotlin.s0.w.d.l0.g.f b(kotlin.s0.w.d.l0.g.f r7) {
        kotlin.n0.d.o.f(r7, "methodName");
        kotlin.s0.w.d.l0.g.f r0 = e(r7, "get", false, null, 12, null);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return e(r7, "is", false, null, 8, null);
    }

    public static final kotlin.s0.w.d.l0.g.f c(kotlin.s0.w.d.l0.g.f r6, boolean r7) {
        kotlin.n0.d.o.f(r6, "methodName");
        if (r7 == false) goto L5;
        String r8 = "is";
    L7:
        return e(r6, "set", false, r8, 4, null);
    L5:
        r8 = null;
        goto L7
    }

    private static final kotlin.s0.w.d.l0.g.f d(kotlin.s0.w.d.l0.g.f r6, String r7, boolean r8, String r9) {
        if (r6.l() == false) goto L5;
        return null;
    L5:
        String r0 = r6.g();
        kotlin.n0.d.o.e(r0, "methodName.identifier");
        boolean r3 = false;
        if (kotlin.u0.k.A(r0, r7, false, 2, null) == true) goto L9;
        return null;
    L9:
        if (r0.length() != r7.length()) goto L11;
        return null;
    L11:
        char r2 = r0.charAt(r7.length());
        if ('a' <= r2) goto L14;
    L16:
        if (r3 == false) goto L18;
        return null;
    L18:
        if (r9 != null) goto L20;
        if (r8 == true) goto L23;
        return r6;
    L23:
        String r10 = kotlin.s0.w.d.l0.o.u.a.c(kotlin.u0.k.g0(r0, r7), true);
        if (kotlin.s0.w.d.l0.g.f.m(r10) == true) goto L27;
        return null;
    L27:
        return kotlin.s0.w.d.l0.g.f.k(r10);
    L20:
        return kotlin.s0.w.d.l0.g.f.k(r9 + kotlin.u0.k.g0(r0, r7));
    L14:
        if (r2 >= '{') goto L16;
        r3 = true;
        goto L16
    }

    static /* synthetic */ kotlin.s0.w.d.l0.g.f e(kotlin.s0.w.d.l0.g.f r0, String r1, boolean r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r2 = true;
    L6:
        if ((r4 & 8) == 0) goto L9;
        r3 = null;
    L9:
        return d(r0, r1, r2, r3);
    }

    public static final List<kotlin.s0.w.d.l0.g.f> f(kotlin.s0.w.d.l0.g.f r3) {
        kotlin.n0.d.o.f(r3, "methodName");
        return kotlin.i0.r.l(new kotlin.s0.w.d.l0.g.f[]{c(r3, false), c(r3, true)});
    }
}
