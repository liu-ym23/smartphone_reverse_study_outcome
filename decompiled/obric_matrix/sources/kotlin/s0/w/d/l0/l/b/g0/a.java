package kotlin.s0.w.d.l0.l.b.g0;

import java.util.Iterator;
import java.util.List;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.y;

/* JADX INFO: loaded from: classes2.dex */
public class a implements kotlin.s0.w.d.l0.c.o1.g {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final /* synthetic */ kotlin.s0.l<Object>[] f20729g = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.i f20730f;

    static {
        f20729g = new kotlin.s0.l[]{e0.g(new y(e0.b(a.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    }

    public a(kotlin.s0.w.d.l0.m.n r2, kotlin.n0.c.a<? extends List<? extends kotlin.s0.w.d.l0.c.o1.c>> r3) {
        o.f(r2, "storageManager");
        o.f(r3, "compute");
        this.f20730f = r2.d(r3);
    }

    private final List<kotlin.s0.w.d.l0.c.o1.c> a() {
        return (List) kotlin.s0.w.d.l0.m.m.a(this.f20730f, this, f20729g[0]);
    }

    @Override // kotlin.s0.w.d.l0.c.o1.g
    public kotlin.s0.w.d.l0.c.o1.c i(kotlin.s0.w.d.l0.g.c r1) {
        return kotlin.s0.w.d.l0.c.o1.g.b.a(this, r1);
    }

    @Override // kotlin.s0.w.d.l0.c.o1.g
    public boolean isEmpty() {
        return a().isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<kotlin.s0.w.d.l0.c.o1.c> iterator() {
        return a().iterator();
    }

    @Override // kotlin.s0.w.d.l0.c.o1.g
    public boolean k(kotlin.s0.w.d.l0.g.c r1) {
        return kotlin.s0.w.d.l0.c.o1.g.b.b(this, r1);
    }
}
