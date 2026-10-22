package kotlin.s0.w.d.l0.e.a.n0;

/* JADX INFO: loaded from: classes2.dex */
public final class p {
    private static final boolean a(r r2) {
        b0 r3 = (b0) kotlin.i0.r.q0(r2.h());
        j r0 = null;
        if (r3 == null) goto L5;
        x r4 = r3.b();
    L7:
        if ((r4 instanceof j) == false) goto L10;
        r0 = (j) r4;
    L10:
        if (r0 != null) goto L12;
        return false;
    L12:
        i r1 = r0.d();
        if ((r1 instanceof g) == false) goto L20;
        kotlin.s0.w.d.l0.g.c r5 = ((g) r1).e();
        if (r5 != null) goto L17;
        return false;
    L17:
        if (kotlin.n0.d.o.a(r5.b(), "java.lang.Object") == false) goto L22;
        return true;
    L22:
        return false;
    L20:
        return false;
    L5:
        r4 = null;
        goto L7
    }

    private static final boolean b(r r3) {
        String r0 = r3.getName().b();
        int r1 = r0.hashCode();
        if (r1 == (-1776922004)) goto L17;
        if (r1 == (-1295482945)) goto L13;
        if (r1 == 147696667) goto L10;
    L19:
        return false;
    L10:
        if (r0.equals("hashCode") == false) goto L19;
    L22:
        return r3.h().isEmpty();
    L13:
        if (r0.equals("equals") == false) goto L19;
        return a(r3);
    L17:
        if (r0.equals("toString") == false) goto L19;
        goto L19
    }

    public static final boolean c(q r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        if (r1.P().H() == true) goto L5;
    L9:
        return false;
    L5:
        if ((r1 instanceof r) == false) goto L9;
        if (b((r) r1) == false) goto L9;
        return true;
    }
}
