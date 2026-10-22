package kotlin.s0.w.d.l0.c.o1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final g f18931f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f18932g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final kotlin.n0.c.l<kotlin.s0.w.d.l0.g.c, Boolean> f18933h;

    public l(g r2, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.c, Boolean> r3) {
        o.f(r2, "delegate");
        o.f(r3, "fqNameFilter");
        this(r2, false, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(g r2, boolean r3, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.c, Boolean> r4) {
        o.f(r2, "delegate");
        o.f(r4, "fqNameFilter");
        this.f18931f = r2;
        this.f18932g = r3;
        this.f18933h = r4;
    }

    private final boolean a(c r1) {
        kotlin.s0.w.d.l0.g.c r2 = r1.e();
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (this.f18933h.invoke(r2).booleanValue() == false) goto L7;
        return true;
    }

    @Override // kotlin.s0.w.d.l0.c.o1.g
    public c i(kotlin.s0.w.d.l0.g.c r2) {
        o.f(r2, "fqName");
        if (this.f18933h.invoke(r2).booleanValue() == true) goto L7;
        return null;
    L7:
        return this.f18931f.i(r2);
    }

    @Override // kotlin.s0.w.d.l0.c.o1.g
    public boolean isEmpty() {
        g r0 = this.f18931f;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<c> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L6;
        if (a(r1.next()) == false) goto L9;
        boolean r2 = true;
    L14:
        if (this.f18932g == false) goto L19;
        if (r2 == true) goto L23;
        return true;
    L23:
        return false;
    L19:
        return r2;
    L6:
        r2 = false;
        goto L14
    L5:
        if (((Collection) r0).isEmpty() == false) goto L7;
        goto L6
    }

    @Override // java.lang.Iterable
    public Iterator<c> iterator() {
        g r0 = this.f18931f;
        ArrayList r1 = new ArrayList();
        Iterator<c> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        c r3 = r2.next();
        if (a(r3) == false) goto L4;
        r1.add(r3);
        goto L4
    L9:
        return r1.iterator();
    }

    @Override // kotlin.s0.w.d.l0.c.o1.g
    public boolean k(kotlin.s0.w.d.l0.g.c r2) {
        o.f(r2, "fqName");
        if (this.f18933h.invoke(r2).booleanValue() == true) goto L7;
        return false;
    L7:
        return this.f18931f.k(r2);
    }
}
