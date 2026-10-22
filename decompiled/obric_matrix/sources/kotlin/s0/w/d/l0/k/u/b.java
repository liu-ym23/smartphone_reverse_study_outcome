package kotlin.s0.w.d.l0.k.u;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.b.k;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.h;
import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.c.m;
import kotlin.s0.w.d.l0.c.t;
import kotlin.s0.w.d.l0.n.e0;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static final boolean a(kotlin.s0.w.d.l0.c.e r1) {
        return o.a(kotlin.s0.w.d.l0.k.t.a.h(r1), k.f18711g);
    }

    public static final boolean b(m r1) {
        o.f(r1, "<this>");
        if (kotlin.s0.w.d.l0.k.f.b(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (a((kotlin.s0.w.d.l0.c.e) r1) == true) goto L7;
        return true;
    }

    public static final boolean c(e0 r2) {
        o.f(r2, "<this>");
        h r3 = r2.O0().d();
        if (r3 == null) goto L8;
        if (b(r3) != true) goto L8;
        return true;
    L8:
        return false;
    }

    private static final boolean d(e0 r1) {
        h r2 = r1.O0().d();
        if ((r2 instanceof f1) == false) goto L5;
        f1 r3 = (f1) r2;
    L6:
        if (r3 != null) goto L10;
        return false;
    L10:
        return e(kotlin.s0.w.d.l0.n.x1.a.i(r3));
    L5:
        r3 = null;
        goto L6
    }

    private static final boolean e(e0 r1) {
        if (c(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (d(r1) == true) goto L8;
        return false;
    }

    public static final boolean f(kotlin.s0.w.d.l0.c.b r3) {
        o.f(r3, "descriptor");
        if ((r3 instanceof kotlin.s0.w.d.l0.c.d) == false) goto L5;
        kotlin.s0.w.d.l0.c.d r4 = (kotlin.s0.w.d.l0.c.d) r3;
    L7:
        if (r4 != null) goto L10;
        return false;
    L10:
        if (t.g(r4.getVisibility()) == false) goto L12;
        return false;
    L12:
        kotlin.s0.w.d.l0.c.e r1 = r4.A();
        o.e(r1, "constructorDescriptor.constructedClass");
        if (kotlin.s0.w.d.l0.k.f.b(r1) == false) goto L16;
        return false;
    L16:
        if (kotlin.s0.w.d.l0.k.d.G(r4.A()) == false) goto L18;
        return false;
    L18:
        List<j1> r5 = r4.h();
        o.e(r5, "constructorDescriptor.valueParameters");
        if ((r5 instanceof Collection) == true) goto L21;
    L23:
        Iterator<T> r6 = r5.iterator();
    L25:
        if (r6.hasNext() == false) goto L34;
        e0 r2 = ((j1) r6.next()).b();
        o.e(r2, "it.type");
        if (e(r2) == false) goto L25;
        return true;
    L34:
        return false;
    L21:
        if (r5.isEmpty() == false) goto L23;
        return false;
    L5:
        r4 = null;
        goto L7
    }
}
