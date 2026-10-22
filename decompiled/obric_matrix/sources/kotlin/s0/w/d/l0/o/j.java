package kotlin.s0.w.d.l0.o;

import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.c.y;
import kotlin.s0.w.d.l0.n.e0;

/* JADX INFO: loaded from: classes2.dex */
final class j implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f21225a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f21226b = "second parameter must be of type KProperty<*> or its supertype";

    static {
        f21225a = new j();
    }

    private j() {
    }

    @Override // kotlin.s0.w.d.l0.o.f
    public String a(y r1) {
        return f.a.a(this, r1);
    }

    @Override // kotlin.s0.w.d.l0.o.f
    public boolean b(y r2) {
        kotlin.n0.d.o.f(r2, "functionDescriptor");
        j1 r1 = r2.h().get(1);
        kotlin.s0.w.d.l0.b.j.b r3 = kotlin.s0.w.d.l0.b.j.f18698d;
        kotlin.n0.d.o.e(r1, "secondParameter");
        e0 r4 = r3.a(kotlin.s0.w.d.l0.k.t.a.l(r1));
        if (r4 == null) goto L5;
        e0 r5 = r1.b();
        kotlin.n0.d.o.e(r5, "secondParameter.type");
        return kotlin.s0.w.d.l0.n.x1.a.o(r4, kotlin.s0.w.d.l0.n.x1.a.s(r5));
    L5:
        return false;
    }

    @Override // kotlin.s0.w.d.l0.o.f
    public String getDescription() {
        return f21226b;
    }
}
