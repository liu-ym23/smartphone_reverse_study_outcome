package kotlin.s0.w.d.l0.c;

import java.util.List;
import java.util.Map;
import kotlin.s0.w.d.l0.n.w1.k;

/* JADX INFO: loaded from: classes2.dex */
public final class i0<Type extends kotlin.s0.w.d.l0.n.w1.k> extends h1<Type> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<kotlin.u<kotlin.s0.w.d.l0.g.f, Type>> f18876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<kotlin.s0.w.d.l0.g.f, Type> f18877b;

    /* JADX WARN: Multi-variable type inference failed */
    public i0(List<? extends kotlin.u<kotlin.s0.w.d.l0.g.f, ? extends Type>> r3) {
        kotlin.n0.d.o.f(r3, "underlyingPropertyNamesToTypes");
        super(null);
        this.f18876a = r3;
        Map<kotlin.s0.w.d.l0.g.f, Type> r4 = kotlin.i0.m0.q(a());
        if (r4.size() != a().size()) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        this.f18877b = r4;
        return;
    L10:
        throw new IllegalArgumentException("Some properties have the same names".toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // kotlin.s0.w.d.l0.c.h1
    public List<kotlin.u<kotlin.s0.w.d.l0.g.f, Type>> a() {
        return this.f18876a;
    }
}
