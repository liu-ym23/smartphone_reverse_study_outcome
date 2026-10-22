package kotlin.s0.w.d.l0.n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m implements e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f21045a;

    public m() {
    }

    private final boolean h(kotlin.s0.w.d.l0.c.h r1) {
        if (kotlin.s0.w.d.l0.n.u1.k.m(r1) == false) goto L5;
    L7:
        return false;
    L5:
        if (kotlin.s0.w.d.l0.k.d.E(r1) == true) goto L7;
        return true;
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public abstract kotlin.s0.w.d.l0.c.h d();

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof e1) == true) goto L9;
        return false;
    L9:
        if (r4.hashCode() == hashCode()) goto L11;
        return false;
    L11:
        e1 r5 = (e1) r4;
        if (r5.getParameters().size() == getParameters().size()) goto L14;
        return false;
    L14:
        kotlin.s0.w.d.l0.c.h r0 = d();
        kotlin.s0.w.d.l0.c.h r6 = r5.d();
        if (r6 != null) goto L18;
        return false;
    L18:
        if (h(r0) == true) goto L20;
    L24:
        return false;
    L20:
        if (h(r6) == false) goto L24;
        return i(r6);
    }

    protected final boolean g(kotlin.s0.w.d.l0.c.h r3, kotlin.s0.w.d.l0.c.h r4) {
        kotlin.n0.d.o.f(r3, "first");
        kotlin.n0.d.o.f(r4, "second");
        if (kotlin.n0.d.o.a(r3.getName(), r4.getName()) == true) goto L5;
        return false;
    L5:
        kotlin.s0.w.d.l0.c.m r2 = r3.c();
        kotlin.s0.w.d.l0.c.m r5 = r4.c();
    L7:
        if (r2 == null) goto L31;
        if (r5 == null) goto L31;
        if ((r2 instanceof kotlin.s0.w.d.l0.c.h0) == true) goto L12;
        if ((r5 instanceof kotlin.s0.w.d.l0.c.h0) == true) goto L15;
        if ((r2 instanceof kotlin.s0.w.d.l0.c.l0) == true) goto L19;
        if ((r5 instanceof kotlin.s0.w.d.l0.c.l0) == true) goto L26;
        if (kotlin.n0.d.o.a(r2.getName(), r5.getName()) == false) goto L29;
        r2 = r2.c();
        r5 = r5.c();
        goto L7
    L29:
        return false;
    L26:
        return false;
    L19:
        if ((r5 instanceof kotlin.s0.w.d.l0.c.l0) == true) goto L21;
        return false;
    L21:
        if (kotlin.n0.d.o.a(((kotlin.s0.w.d.l0.c.l0) r2).e(), ((kotlin.s0.w.d.l0.c.l0) r5).e()) == true) goto L23;
        return false;
    L23:
        return true;
    L15:
        return false;
    L12:
        return r5 instanceof kotlin.s0.w.d.l0.c.h0;
    L31:
        return true;
    }

    public int hashCode() {
        int r0 = this.f21045a;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        kotlin.s0.w.d.l0.c.h r1 = d();
        if (h(r1) == false) goto L8;
        int r2 = kotlin.s0.w.d.l0.k.d.m(r1).hashCode();
    L9:
        this.f21045a = r2;
        return r2;
    L8:
        r2 = System.identityHashCode(this);
        goto L9
    }

    protected abstract boolean i(kotlin.s0.w.d.l0.c.h r1);
}
