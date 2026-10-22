package kotlin.s0.w.d.l0.c.s1.b;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends p implements kotlin.s0.w.d.l0.e.a.n0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Annotation f19127a;

    public e(Annotation r2) {
        kotlin.n0.d.o.f(r2, "annotation");
        this.f19127a = r2;
    }

    public final Annotation R() {
        return this.f19127a;
    }

    public l S() {
        return new l(kotlin.n0.a.b(kotlin.n0.a.a(this.f19127a)));
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof e) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f19127a != ((e) r2).f19127a) goto L7;
        return true;
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.a
    public kotlin.s0.w.d.l0.g.b f() {
        return d.a(kotlin.n0.a.b(kotlin.n0.a.a(this.f19127a)));
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.a
    public boolean g() {
        return kotlin.s0.w.d.l0.e.a.n0.a.C0517a.b(this);
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.a
    public Collection<kotlin.s0.w.d.l0.e.a.n0.b> getArguments() {
        Method[] r0 = kotlin.n0.a.b(kotlin.n0.a.a(this.f19127a)).getDeclaredMethods();
        kotlin.n0.d.o.e(r0, "annotation.annotationClass.java.declaredMethods");
        ArrayList r1 = new ArrayList(r0.length);
        int r2 = r0.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        Method r5 = r0[r4];
        f.a r6 = f.f19128b;
        Object r7 = r5.invoke(this.f19127a, new Object[0]);
        kotlin.n0.d.o.e(r7, "method.invoke(annotation)");
        r1.add(r6.a(r7, kotlin.s0.w.d.l0.g.f.k(r5.getName())));
        r4 = r4 + 1;
        goto L3
    L5:
        return r1;
    }

    public int hashCode() {
        return System.identityHashCode(this.f19127a);
    }

    public String toString() {
        return e.class.getName() + ": " + this.f19127a;
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.a
    public boolean u() {
        return kotlin.s0.w.d.l0.e.a.n0.a.C0517a.a(this);
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.a
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.e.a.n0.g y() {
        return S();
    }
}
