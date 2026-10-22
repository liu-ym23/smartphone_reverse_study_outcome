package kotlin.s0.w.d.l0.k.w.o;

import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.m0;

/* JADX INFO: loaded from: classes2.dex */
public class e implements f, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.c.e f20670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.c.e f20671b;

    public e(kotlin.s0.w.d.l0.c.e r2, e r3) {
        o.f(r2, "classDescriptor");
        this.f20670a = r2;
        this.f20671b = r2;
    }

    @Override // kotlin.s0.w.d.l0.k.w.o.f
    public /* bridge */ /* synthetic */ e0 b() {
        return c();
    }

    public m0 c() {
        m0 r1 = this.f20670a.s();
        o.e(r1, "classDescriptor.defaultType");
        return r1;
    }

    public boolean equals(Object r3) {
        kotlin.s0.w.d.l0.c.e r2 = this.f20670a;
        kotlin.s0.w.d.l0.c.e r1 = null;
        if ((r3 instanceof e) == false) goto L5;
        e r4 = (e) r3;
    L6:
        if (r4 == null) goto L9;
        r1 = r4.f20670a;
    L9:
        return o.a(r2, r1);
    L5:
        r4 = null;
        goto L6
    }

    public int hashCode() {
        return this.f20670a.hashCode();
    }

    @Override // kotlin.s0.w.d.l0.k.w.o.h
    public final kotlin.s0.w.d.l0.c.e r() {
        return this.f20670a;
    }

    public String toString() {
        return "Class{" + c() + '}';
    }
}
