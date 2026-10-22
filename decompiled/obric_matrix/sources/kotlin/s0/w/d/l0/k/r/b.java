package kotlin.s0.w.d.l0.k.r;

import java.util.List;
import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.n.e0;

/* JADX INFO: loaded from: classes2.dex */
public class b extends g<List<? extends g<?>>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.n0.c.l<h0, e0> f20562b;

    /* JADX WARN: Multi-variable type inference failed */
    public b(List<? extends g<?>> r2, kotlin.n0.c.l<? super h0, ? extends e0> r3) {
        kotlin.n0.d.o.f(r2, "value");
        kotlin.n0.d.o.f(r3, "computeType");
        super(r2);
        this.f20562b = r3;
    }

    @Override // kotlin.s0.w.d.l0.k.r.g
    public e0 a(h0 r2) {
        kotlin.n0.d.o.f(r2, "module");
        e0 r1 = this.f20562b.invoke(r2);
        if (kotlin.s0.w.d.l0.b.h.c0(r1) == false) goto L5;
    L7:
        return r1;
    L5:
        if (kotlin.s0.w.d.l0.b.h.p0(r1) == true) goto L7;
        kotlin.s0.w.d.l0.b.h.C0(r1);
        goto L7
    }
}
