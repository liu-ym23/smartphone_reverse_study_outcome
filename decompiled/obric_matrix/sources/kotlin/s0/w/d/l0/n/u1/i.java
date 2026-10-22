package kotlin.s0.w.d.l0.n.u1;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.e1;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f21154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String[] f21155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f21156c;

    public i(j r5, String... r6) {
        o.f(r5, "kind");
        o.f(r6, "formatParams");
        this.f21154a = r5;
        this.f21155b = r6;
        String r0 = b.f21130l.b();
        String r7 = r5.b();
        Object[] r8 = Arrays.copyOf(r6, r6.length);
        String r9 = String.format(r7, Arrays.copyOf(r8, r8.length));
        o.e(r9, "format(this, *args)");
        String r10 = String.format(r0, Arrays.copyOf(new Object[]{r9}, 1));
        o.e(r10, "format(this, *args)");
        this.f21156c = r10;
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public Collection<e0> a() {
        return r.g();
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public e1 c(kotlin.s0.w.d.l0.n.t1.g r2) {
        o.f(r2, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public kotlin.s0.w.d.l0.c.h d() {
        return k.f21165a.h();
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public boolean e() {
        return false;
    }

    public final j g() {
        return this.f21154a;
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public List<f1> getParameters() {
        return r.g();
    }

    public final String h(int r1) {
        return this.f21155b[r1];
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public kotlin.s0.w.d.l0.b.h o() {
        return kotlin.s0.w.d.l0.b.e.f18673g.a();
    }

    public String toString() {
        return this.f21156c;
    }
}
