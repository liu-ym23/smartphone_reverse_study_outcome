package kotlin.s0.w.d.l0.c.s1.b;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.s0.w.d.l0.c.n1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class t extends p implements h, v, kotlin.s0.w.d.l0.e.a.n0.q {
    public t() {
    }

    @Override // kotlin.s0.w.d.l0.c.s1.b.v
    public int D() {
        return U().getModifiers();
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.e.a.n0.g P() {
        return T();
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.s
    public boolean Q() {
        return v.a.d(this);
    }

    public e R(kotlin.s0.w.d.l0.g.c r1) {
        return h.a.a(this, r1);
    }

    public List<e> S() {
        return h.a.b(this);
    }

    public l T() {
        Class<?> r2 = U().getDeclaringClass();
        kotlin.n0.d.o.e(r2, "member.declaringClass");
        return new l(r2);
    }

    public abstract Member U();

    protected final List<kotlin.s0.w.d.l0.e.a.n0.b0> V(Type[] r12, Annotation[][] r13, boolean r14) {
        kotlin.n0.d.o.f(r12, "parameterTypes");
        kotlin.n0.d.o.f(r13, "parameterAnnotations");
        ArrayList r0 = new ArrayList(r12.length);
        List<String> r1 = c.f19114a.b(U());
        if (r1 == null) goto L5;
        int r3 = r1.size() - r12.length;
    L6:
        int r4 = r12.length;
        int r5 = 0;
    L7:
        if (r5 >= r4) goto L22;
        z r6 = z.f19158a.a(r12[r5]);
        if (r1 == null) goto L15;
        String r7 = (String) kotlin.i0.r.S(r1, r5 + r3);
        if (r7 == null) goto L14;
    L16:
        if (r14 == true) goto L18;
    L20:
        boolean r8 = false;
    L21:
        r0.add(new b0(r6, r13[r5], r7, r8));
        r5 = r5 + 1;
        goto L7
    L18:
        if (r5 != kotlin.i0.i.z(r12)) goto L20;
        r8 = true;
        goto L21
    L14:
        throw new IllegalStateException(("No parameter with index " + r5 + '+' + r3 + " (name=" + getName() + " type=" + r6 + ") in " + this).toString());
    L15:
        r7 = null;
        goto L16
    L22:
        return r0;
    L5:
        r3 = 0;
        goto L6
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof t) == true) goto L5;
    L7:
        return false;
    L5:
        if (kotlin.n0.d.o.a(U(), ((t) r2).U()) == false) goto L7;
        return true;
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.d
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return S();
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.t
    public kotlin.s0.w.d.l0.g.f getName() {
        String r0 = U().getName();
        if (r0 == null) goto L5;
        kotlin.s0.w.d.l0.g.f r1 = kotlin.s0.w.d.l0.g.f.k(r0);
    L6:
        if (r1 == null) goto L8;
        return r1;
    L8:
        return kotlin.s0.w.d.l0.g.h.f20275b;
    L5:
        r1 = null;
        goto L6
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.s
    public n1 getVisibility() {
        return v.a.a(this);
    }

    public int hashCode() {
        return U().hashCode();
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.d
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.e.a.n0.a i(kotlin.s0.w.d.l0.g.c r1) {
        return R(r1);
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.s
    public boolean isAbstract() {
        return v.a.b(this);
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.s
    public boolean isFinal() {
        return v.a.c(this);
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.d
    public boolean l() {
        return h.a.c(this);
    }

    public String toString() {
        return getClass().getName() + ": " + U();
    }

    @Override // kotlin.s0.w.d.l0.c.s1.b.h
    public AnnotatedElement v() {
        Member r1 = U();
        kotlin.n0.d.o.d(r1, "null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
        return (AnnotatedElement) r1;
    }
}
