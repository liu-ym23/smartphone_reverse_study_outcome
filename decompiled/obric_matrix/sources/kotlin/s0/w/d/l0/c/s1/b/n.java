package kotlin.s0.w.d.l0.c.s1.b;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends z implements kotlin.s0.w.d.l0.e.a.n0.j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Type f19146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.e.a.n0.i f19147c;

    public n(Type r3) {
        kotlin.n0.d.o.f(r3, "reflectType");
        this.f19146b = r3;
        Type r4 = R();
        if ((r4 instanceof Class) == false) goto L6;
        kotlin.s0.w.d.l0.e.a.n0.i r0 = new l((Class) r4);
    L11:
        this.f19147c = r0;
        return;
    L6:
        if ((r4 instanceof TypeVariable) == false) goto L9;
        r0 = new a0((TypeVariable) r4);
        goto L11
    L9:
        if ((r4 instanceof ParameterizedType) == false) goto L14;
        Type r5 = ((ParameterizedType) r4).getRawType();
        kotlin.n0.d.o.d(r5, "null cannot be cast to non-null type java.lang.Class<*>");
        r0 = new l((Class) r5);
        goto L11
    L14:
        throw new IllegalStateException("Not a classifier type (" + r4.getClass() + "): " + r4);
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.j
    public List<kotlin.s0.w.d.l0.e.a.n0.x> F() {
        List<Type> r3 = d.c(R());
        z.a r0 = z.f19158a;
        ArrayList r1 = new ArrayList(kotlin.i0.r.q(r3, 10));
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r1.add(r0.a((Type) r4.next()));
        goto L4
    L6:
        return r1;
    }

    @Override // kotlin.s0.w.d.l0.c.s1.b.z
    public Type R() {
        return this.f19146b;
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.j
    public kotlin.s0.w.d.l0.e.a.n0.i d() {
        return this.f19147c;
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.d
    public Collection<kotlin.s0.w.d.l0.e.a.n0.a> getAnnotations() {
        return kotlin.i0.r.g();
    }

    @Override // kotlin.s0.w.d.l0.c.s1.b.z, kotlin.s0.w.d.l0.e.a.n0.d
    public kotlin.s0.w.d.l0.e.a.n0.a i(kotlin.s0.w.d.l0.g.c r1) {
        kotlin.n0.d.o.f(r1, "fqName");
        return null;
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.d
    public boolean l() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.j
    public String o() {
        return R().toString();
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.j
    public boolean w() {
        Type r3 = R();
        if ((r3 instanceof Class) == false) goto L12;
        TypeVariable[] r4 = ((Class) r3).getTypeParameters();
        kotlin.n0.d.o.e(r4, "getTypeParameters()");
        if (r4.length != 0) goto L7;
        boolean r5 = true;
    L9:
        if ((!r5) == true) goto L11;
        return false;
    L11:
        return true;
    L7:
        r5 = false;
        goto L9
    L12:
        return false;
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.j
    public String x() {
        throw new UnsupportedOperationException("Type not found: " + R());
    }
}
