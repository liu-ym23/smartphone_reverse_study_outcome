package kotlin.s0.w.d.l0.e.a.o0;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q f19603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<q> f19604b;

    /* JADX WARN: Multi-variable type inference failed */
    public k() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public k(q r2, List<q> r3) {
        kotlin.n0.d.o.f(r3, "parametersInfo");
        this.f19603a = r2;
        this.f19604b = r3;
    }

    public /* synthetic */ k(q r1, List r2, int r3, kotlin.n0.d.g r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = kotlin.i0.r.g();
    L8:
        this(r1, r2);
    }

    public final List<q> a() {
        return this.f19604b;
    }

    public final q b() {
        return this.f19603a;
    }
}
