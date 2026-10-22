package kotlin.s0.w.d.l0.g;

import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f20274a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f20275b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f20276c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f20277d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f f20278e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f20279f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f f20280g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final f f20281h = null;

    static {
        f20274a = new h();
        f r0 = f.n("<no name provided>");
        o.e(r0, "special(\"<no name provided>\")");
        f20275b = r0;
        o.e(f.n("<root package>"), "special(\"<root package>\")");
        f r1 = f.k("Companion");
        o.e(r1, "identifier(\"Companion\")");
        f20276c = r1;
        f r2 = f.k("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");
        o.e(r2, "identifier(\"no_name_in_P…_4cd0_b7f5_b46aa3cd5d40\")");
        f20277d = r2;
        o.e(f.n("<anonymous>"), "special(ANONYMOUS_STRING)");
        o.e(f.n("<unary>"), "special(\"<unary>\")");
        f r3 = f.n("<this>");
        o.e(r3, "special(\"<this>\")");
        f20278e = r3;
        f r4 = f.n("<init>");
        o.e(r4, "special(\"<init>\")");
        f20279f = r4;
        o.e(f.n("<iterator>"), "special(\"<iterator>\")");
        o.e(f.n("<destruct>"), "special(\"<destruct>\")");
        f r5 = f.n("<local>");
        o.e(r5, "special(\"<local>\")");
        f20280g = r5;
        o.e(f.n("<unused var>"), "special(\"<unused var>\")");
        f r6 = f.n("<set-?>");
        o.e(r6, "special(\"<set-?>\")");
        f20281h = r6;
    }

    private h() {
    }

    public static final f b(f r1) {
        if (r1 == null) goto L7;
        if (r1.l() == true) goto L7;
        return r1;
    L7:
        return f20277d;
    }

    public final boolean a(f r3) {
        o.f(r3, "name");
        String r2 = r3.b();
        o.e(r2, "name.asString()");
        if (r2.length() <= 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L11;
        if (r3.l() == true) goto L11;
        return true;
    L11:
        return false;
    L5:
        r4 = false;
        goto L6
    }
}
