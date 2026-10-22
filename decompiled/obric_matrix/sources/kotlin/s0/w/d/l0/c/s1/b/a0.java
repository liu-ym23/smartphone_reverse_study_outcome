package kotlin.s0.w.d.l0.c.s1.b;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 extends p implements h, kotlin.s0.w.d.l0.e.a.n0.y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TypeVariable<?> f19103a;

    public a0(TypeVariable<?> r2) {
        kotlin.n0.d.o.f(r2, "typeVariable");
        this.f19103a = r2;
    }

    public e R(kotlin.s0.w.d.l0.g.c r1) {
        return h.a.a(this, r1);
    }

    public List<e> S() {
        return h.a.b(this);
    }

    public List<n> T() {
        Type[] r5 = this.f19103a.getBounds();
        kotlin.n0.d.o.e(r5, "typeVariable.bounds");
        ArrayList r0 = new ArrayList(r5.length);
        int r1 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.add(new n(r5[r2]));
        r2 = r2 + 1;
        goto L3
    L5:
        n r6 = (n) kotlin.i0.r.q0(r0);
        if (r6 == null) goto L8;
        Type r7 = r6.R();
    L10:
        if (kotlin.n0.d.o.a(r7, Object.class) == true) goto L12;
        return r0;
    L12:
        return kotlin.i0.r.g();
    L8:
        r7 = null;
        goto L10
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof a0) == true) goto L5;
    L7:
        return false;
    L5:
        if (kotlin.n0.d.o.a(this.f19103a, ((a0) r2).f19103a) == false) goto L7;
        return true;
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.d
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return S();
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.t
    public kotlin.s0.w.d.l0.g.f getName() {
        kotlin.s0.w.d.l0.g.f r1 = kotlin.s0.w.d.l0.g.f.k(this.f19103a.getName());
        kotlin.n0.d.o.e(r1, "identifier(typeVariable.name)");
        return r1;
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.y
    public /* bridge */ /* synthetic */ Collection getUpperBounds() {
        return T();
    }

    public int hashCode() {
        return this.f19103a.hashCode();
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.d
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.e.a.n0.a i(kotlin.s0.w.d.l0.g.c r1) {
        return R(r1);
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.d
    public boolean l() {
        return h.a.c(this);
    }

    public String toString() {
        return a0.class.getName() + ": " + this.f19103a;
    }

    @Override // kotlin.s0.w.d.l0.c.s1.b.h
    public AnnotatedElement v() {
        TypeVariable<?> r1 = this.f19103a;
        if ((r1 instanceof AnnotatedElement) == true) goto L7;
        return null;
    L7:
        return (AnnotatedElement) r1;
    }
}
