package kotlin.s0.w.d.l0.n.y1;

import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.t1.e;

/* JADX INFO: loaded from: classes2.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f1 f21201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e0 f21202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e0 f21203c;

    public c(f1 r2, e0 r3, e0 r4) {
        o.f(r2, "typeParameter");
        o.f(r3, "inProjection");
        o.f(r4, "outProjection");
        this.f21201a = r2;
        this.f21202b = r3;
        this.f21203c = r4;
    }

    public final e0 a() {
        return this.f21202b;
    }

    public final e0 b() {
        return this.f21203c;
    }

    public final f1 c() {
        return this.f21201a;
    }

    public final boolean d() {
        return e.f21078a.d(this.f21202b, this.f21203c);
    }
}
