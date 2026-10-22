package kotlin.s0.w.d.l0.c;

import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface y extends b {

    public interface a<D extends y> {
        a<D> a();

        a<D> b(List<j1> r1);

        D build();

        a<D> c(e0 r1);

        a<D> d(x0 r1);

        a<D> e();

        a<D> f(kotlin.s0.w.d.l0.n.e0 r1);

        a<D> g(b r1);

        a<D> h();

        a<D> i(boolean r1);

        a<D> j(x0 r1);

        a<D> k(kotlin.s0.w.d.l0.n.j1 r1);

        a<D> l(List<f1> r1);

        <V> a<D> m(kotlin.s0.w.d.l0.c.a.InterfaceC0500a<V> r1, V r2);

        a<D> n(u r1);

        a<D> o(m r1);

        a<D> p();

        a<D> q(b.a r1);

        a<D> r(kotlin.s0.w.d.l0.c.o1.g r1);

        a<D> s(kotlin.s0.w.d.l0.g.f r1);

        a<D> t();
    }

    boolean C0();

    boolean P();

    @Override // kotlin.s0.w.d.l0.c.b, kotlin.s0.w.d.l0.c.a, kotlin.s0.w.d.l0.c.m
    y a();

    @Override // kotlin.s0.w.d.l0.c.n, kotlin.s0.w.d.l0.c.m
    m c();

    y d(kotlin.s0.w.d.l0.n.l1 r1);

    y d0();

    @Override // kotlin.s0.w.d.l0.c.b, kotlin.s0.w.d.l0.c.a
    Collection<? extends y> f();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    boolean isSuspend();

    a<? extends y> t();

    boolean w0();
}
