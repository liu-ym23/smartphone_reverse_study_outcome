package kotlin.s0.w.d.l0.c;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final g0<c0> f18853a = null;

    static {
        f18853a = new g0("InvalidModuleNotifier");
    }

    public static final void a(h0 r3) {
        kotlin.n0.d.o.f(r3, "<this>");
        c0 r0 = (c0) r3.I0(f18853a);
        if (r0 == null) goto L5;
        r0.a(r3);
        kotlin.f0 r1 = kotlin.f0.f18324a;
    L6:
        if (r1 == null) goto L9;
        return;
    L9:
        throw new a0("Accessing invalid module descriptor " + r3);
    L5:
        r1 = null;
        goto L6
    }
}
