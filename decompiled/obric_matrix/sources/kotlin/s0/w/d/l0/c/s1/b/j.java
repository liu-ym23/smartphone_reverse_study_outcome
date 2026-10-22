package kotlin.s0.w.d.l0.c.s1.b;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends f implements kotlin.s0.w.d.l0.e.a.n0.e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object[] f19131c;

    public j(kotlin.s0.w.d.l0.g.f r2, Object[] r3) {
        kotlin.n0.d.o.f(r3, "values");
        super(r2, null);
        this.f19131c = r3;
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.e
    public List<f> e() {
        Object[] r6 = this.f19131c;
        ArrayList r0 = new ArrayList(r6.length);
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        Object r3 = r6[r2];
        f.a r4 = f.f19128b;
        kotlin.n0.d.o.c(r3);
        r0.add(r4.a(r3, null));
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }
}
