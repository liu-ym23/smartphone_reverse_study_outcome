package kotlin.s0.w.d.l0.e.b;

import java.util.Iterator;
import java.util.List;
import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.c.x0;
import kotlin.s0.w.d.l0.c.z0;
import kotlin.s0.w.d.l0.e.a.g0;
import kotlin.s0.w.d.l0.n.e0;

/* JADX INFO: loaded from: classes2.dex */
public final class v {
    private static final void a(StringBuilder r0, e0 r1) {
        r0.append(g(r1));
    }

    public static final String b(kotlin.s0.w.d.l0.c.y r3, boolean r4, boolean r5) {
        kotlin.n0.d.o.f(r3, "<this>");
        StringBuilder r0 = new StringBuilder();
        if (r5 == true) goto L5;
    L9:
        r0.append("(");
        x0 r6 = r3.m0();
        if (r6 == null) goto L12;
        e0 r7 = r6.b();
        kotlin.n0.d.o.e(r7, "it.type");
        a(r0, r7);
    L12:
        Iterator<j1> r8 = r3.h().iterator();
    L14:
        if (r8.hasNext() == false) goto L16;
        e0 r1 = r8.next().b();
        kotlin.n0.d.o.e(r1, "parameter.type");
        a(r0, r1);
        goto L14
    L16:
        r0.append(")");
        if (r4 == true) goto L19;
    L22:
        String r9 = r0.toString();
        kotlin.n0.d.o.e(r9, "StringBuilder().apply(builderAction).toString()");
        return r9;
    L19:
        if (d.c(r3) == false) goto L21;
        r0.append("V");
        goto L22
    L21:
        e0 r10 = r3.getReturnType();
        kotlin.n0.d.o.c(r10);
        a(r0, r10);
        goto L22
    L5:
        if ((r3 instanceof kotlin.s0.w.d.l0.c.l) == false) goto L7;
        String r11 = "<init>";
    L8:
        r0.append(r11);
        goto L9
    L7:
        r11 = r3.getName().b();
        kotlin.n0.d.o.e(r11, "name.asString()");
        goto L8
    }

    public static /* synthetic */ String c(kotlin.s0.w.d.l0.c.y r1, boolean r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = true;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = true;
    L9:
        return b(r1, r2, r3);
    }

    public static final String d(kotlin.s0.w.d.l0.c.a r5) {
        kotlin.n0.d.o.f(r5, "<this>");
        x r0 = x.f19797a;
        if (kotlin.s0.w.d.l0.k.d.E(r5) == false) goto L5;
        return null;
    L5:
        kotlin.s0.w.d.l0.c.m r1 = r5.c();
        if ((r1 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L8;
        kotlin.s0.w.d.l0.c.e r2 = (kotlin.s0.w.d.l0.c.e) r1;
    L9:
        if (r2 != null) goto L12;
        return null;
    L12:
        if (r2.getName().l() == false) goto L14;
        return null;
    L14:
        kotlin.s0.w.d.l0.c.a r6 = r5.a();
        if ((r6 instanceof z0) == false) goto L17;
        z0 r7 = (z0) r6;
    L18:
        if (r7 != null) goto L21;
        return null;
    L21:
        return u.a(r0, r2, c(r7, false, false, 3, null));
    L17:
        r7 = null;
        goto L18
    L8:
        r2 = null;
        goto L9
    }

    public static final boolean e(kotlin.s0.w.d.l0.c.a r5) {
        kotlin.n0.d.o.f(r5, "f");
        if ((r5 instanceof kotlin.s0.w.d.l0.c.y) == true) goto L5;
        return false;
    L5:
        kotlin.s0.w.d.l0.c.y r0 = (kotlin.s0.w.d.l0.c.y) r5;
        if (kotlin.n0.d.o.a(r0.getName().b(), "remove") == true) goto L8;
        return false;
    L8:
        if (r0.h().size() == 1) goto L10;
        return false;
    L10:
        if (g0.h((kotlin.s0.w.d.l0.c.b) r5) == true) goto L37;
        List<j1> r6 = r0.a().h();
        kotlin.n0.d.o.e(r6, "f.original.valueParameters");
        e0 r7 = ((j1) kotlin.i0.r.o0(r6)).b();
        kotlin.n0.d.o.e(r7, "f.original.valueParameters.single().type");
        l r8 = g(r7);
        kotlin.s0.w.d.l0.k.u.e r4 = null;
        if ((r8 instanceof l.d) == false) goto L15;
        l.d r9 = (l.d) r8;
    L16:
        if (r9 == null) goto L19;
        r4 = r9.i();
    L19:
        if (r4 == kotlin.s0.w.d.l0.k.u.e.n) goto L21;
        return false;
    L21:
        kotlin.s0.w.d.l0.c.y r10 = kotlin.s0.w.d.l0.e.a.f.k(r0);
        if (r10 != null) goto L24;
        return false;
    L24:
        List<j1> r1 = r10.a().h();
        kotlin.n0.d.o.e(r1, "overridden.original.valueParameters");
        e0 r2 = ((j1) kotlin.i0.r.o0(r1)).b();
        kotlin.n0.d.o.e(r2, "overridden.original.valueParameters.single().type");
        l r3 = g(r2);
        kotlin.s0.w.d.l0.c.m r11 = r10.c();
        kotlin.n0.d.o.e(r11, "overridden.containingDeclaration");
        if (kotlin.n0.d.o.a(kotlin.s0.w.d.l0.k.t.a.i(r11), kotlin.s0.w.d.l0.b.k.a.L.j()) == true) goto L27;
        return false;
    L27:
        if ((r3 instanceof l.c) == true) goto L29;
        return false;
    L29:
        if (kotlin.n0.d.o.a(((l.c) r3).i(), "java/lang/Object") == true) goto L31;
        return false;
    L31:
        return true;
    L15:
        r9 = null;
        goto L16
    L37:
        return false;
    }

    public static final String f(kotlin.s0.w.d.l0.c.e r3) {
        kotlin.n0.d.o.f(r3, "<this>");
        kotlin.s0.w.d.l0.b.q.c r0 = kotlin.s0.w.d.l0.b.q.c.f18771a;
        kotlin.s0.w.d.l0.g.d r1 = kotlin.s0.w.d.l0.k.t.a.h(r3).j();
        kotlin.n0.d.o.e(r1, "fqNameSafe.toUnsafe()");
        kotlin.s0.w.d.l0.g.b r2 = r0.n(r1);
        if (r2 == null) goto L7;
        String r4 = kotlin.s0.w.d.l0.k.u.d.b(r2).f();
        kotlin.n0.d.o.e(r4, "byClassId(it).internalName");
        return r4;
    L7:
        return d.b(r3, null, 2, null);
    }

    public static final l g(e0 r9) {
        kotlin.n0.d.o.f(r9, "<this>");
        return (l) d.e(r9, n.f19788a, a0.m, z.f19799a, null, null, 32, null);
    }
}
