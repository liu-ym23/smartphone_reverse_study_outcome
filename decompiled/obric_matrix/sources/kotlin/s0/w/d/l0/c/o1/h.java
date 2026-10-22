package kotlin.s0.w.d.l0.c.o1;

import java.util.Iterator;
import java.util.List;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<c> f18922f;

    /* JADX WARN: Multi-variable type inference failed */
    public h(List<? extends c> r2) {
        o.f(r2, "annotations");
        this.f18922f = r2;
    }

    @Override // kotlin.s0.w.d.l0.c.o1.g
    public c i(kotlin.s0.w.d.l0.g.c r1) {
        return g.b.a(this, r1);
    }

    @Override // kotlin.s0.w.d.l0.c.o1.g
    public boolean isEmpty() {
        return this.f18922f.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<c> iterator() {
        return this.f18922f.iterator();
    }

    @Override // kotlin.s0.w.d.l0.c.o1.g
    public boolean k(kotlin.s0.w.d.l0.g.c r1) {
        return g.b.b(this, r1);
    }

    public String toString() {
        return this.f18922f.toString();
    }
}
