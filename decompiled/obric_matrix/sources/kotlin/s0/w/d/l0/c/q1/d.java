package kotlin.s0.w.d.l0.c.q1;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.e1;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.n.n1;
import kotlin.s0.w.d.l0.n.q1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d extends k implements e1 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.c.u f18978j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<? extends f1> f18979k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final c f18980l;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.n.t1.g, kotlin.s0.w.d.l0.n.m0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f18981f;

        a(d r1) {
            this.f18981f = r1;
            super(1);
        }

        public final kotlin.s0.w.d.l0.n.m0 a(kotlin.s0.w.d.l0.n.t1.g r1) {
            kotlin.s0.w.d.l0.c.h r0 = r1.f(this.f18981f);
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.s();
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.n.m0 invoke(kotlin.s0.w.d.l0.n.t1.g r1) {
            return a(r1);
        }
    }

    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.l<q1, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f18982f;

        b(d r1) {
            this.f18982f = r1;
            super(1);
        }

        public final Boolean a(q1 r4) {
            kotlin.n0.d.o.e(r4, WsConstants.KEY_CONNECTION_TYPE);
            boolean r1 = true;
            if (kotlin.s0.w.d.l0.n.g0.a(r4) == true) goto L12;
            d r3 = this.f18982f;
            kotlin.s0.w.d.l0.c.h r5 = r4.O0().d();
            if ((r5 instanceof f1) == true) goto L7;
        L9:
            boolean r6 = false;
        L10:
            if (r6 == false) goto L12;
        L14:
            return Boolean.valueOf(r1);
        L7:
            if (kotlin.n0.d.o.a(((f1) r5).c(), r3) == true) goto L9;
            r6 = true;
        L12:
            r1 = false;
            goto L14
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(q1 r1) {
            return a(r1);
        }
    }

    public static final class c implements kotlin.s0.w.d.l0.n.e1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f18983a;

        c(d r1) {
            this.f18983a = r1;
        }

        @Override // kotlin.s0.w.d.l0.n.e1
        public Collection<kotlin.s0.w.d.l0.n.e0> a() {
            Collection<kotlin.s0.w.d.l0.n.e0> r1 = g().g0().O0().a();
            kotlin.n0.d.o.e(r1, "declarationDescriptor.un…pe.constructor.supertypes");
            return r1;
        }

        @Override // kotlin.s0.w.d.l0.n.e1
        public kotlin.s0.w.d.l0.n.e1 c(kotlin.s0.w.d.l0.n.t1.g r2) {
            kotlin.n0.d.o.f(r2, "kotlinTypeRefiner");
            return this;
        }

        @Override // kotlin.s0.w.d.l0.n.e1
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.h d() {
            return g();
        }

        @Override // kotlin.s0.w.d.l0.n.e1
        public boolean e() {
            return true;
        }

        public e1 g() {
            return this.f18983a;
        }

        @Override // kotlin.s0.w.d.l0.n.e1
        public List<f1> getParameters() {
            return this.f18983a.N0();
        }

        @Override // kotlin.s0.w.d.l0.n.e1
        public kotlin.s0.w.d.l0.b.h o() {
            return kotlin.s0.w.d.l0.k.t.a.f(g());
        }

        public String toString() {
            return "[typealias " + g().getName().b() + ']';
        }
    }

    public d(kotlin.s0.w.d.l0.c.m r2, kotlin.s0.w.d.l0.c.o1.g r3, kotlin.s0.w.d.l0.g.f r4, a1 r5, kotlin.s0.w.d.l0.c.u r6) {
        kotlin.n0.d.o.f(r2, "containingDeclaration");
        kotlin.n0.d.o.f(r3, "annotations");
        kotlin.n0.d.o.f(r4, "name");
        kotlin.n0.d.o.f(r5, "sourceElement");
        kotlin.n0.d.o.f(r6, "visibilityImpl");
        super(r2, r3, r4, r5);
        this.f18978j = r6;
        this.f18980l = new c(this);
    }

    @Override // kotlin.s0.w.d.l0.c.q1.k
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.p A0() {
        return L0();
    }

    @Override // kotlin.s0.w.d.l0.c.d0
    public boolean E0() {
        return false;
    }

    protected final kotlin.s0.w.d.l0.n.m0 F0() {
        kotlin.s0.w.d.l0.c.e r0 = r();
        if (r0 == null) goto L6;
        kotlin.s0.w.d.l0.k.w.h r1 = r0.D0();
        if (r1 == null) goto L6;
    L7:
        kotlin.s0.w.d.l0.n.m0 r2 = n1.t(this, r1, new a(this));
        kotlin.n0.d.o.e(r2, "@OptIn(TypeRefinement::c…s)?.defaultType\n        }");
        return r2;
    L6:
        r1 = kotlin.s0.w.d.l0.k.w.h.b.f20650b;
        goto L7
    }

    @Override // kotlin.s0.w.d.l0.c.m
    public <R, D> R K(kotlin.s0.w.d.l0.c.o<R, D> r2, D r3) {
        kotlin.n0.d.o.f(r2, "visitor");
        return r2.e(this, r3);
    }

    @Override // kotlin.s0.w.d.l0.c.d0
    public boolean L() {
        return false;
    }

    public e1 L0() {
        kotlin.s0.w.d.l0.c.p r1 = super.A0();
        kotlin.n0.d.o.d(r1, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeAliasDescriptor");
        return (e1) r1;
    }

    @Override // kotlin.s0.w.d.l0.c.i
    public boolean M() {
        return n1.c(g0(), new b(this));
    }

    public final Collection<i0> M0() {
        kotlin.s0.w.d.l0.c.e r0 = r();
        if (r0 == null) goto L5;
        Collection<kotlin.s0.w.d.l0.c.d> r1 = r0.m();
        kotlin.n0.d.o.e(r1, "classDescriptor.constructors");
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L8:
        if (r3.hasNext() == false) goto L12;
        kotlin.s0.w.d.l0.c.d r4 = (kotlin.s0.w.d.l0.c.d) r3.next();
        j0.a r5 = j0.N;
        kotlin.s0.w.d.l0.m.n r6 = h0();
        kotlin.n0.d.o.e(r4, "it");
        i0 r7 = r5.b(r6, this, r4);
        if (r7 == null) goto L8;
        r2.add(r7);
        goto L8
    L12:
        return r2;
    L5:
        return kotlin.i0.r.g();
    }

    protected abstract List<f1> N0();

    public final void O0(List<? extends f1> r2) {
        kotlin.n0.d.o.f(r2, "declaredTypeParameters");
        this.f18979k = r2;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.h a() {
        return L0();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.m a() {
        return L0();
    }

    @Override // kotlin.s0.w.d.l0.c.q, kotlin.s0.w.d.l0.c.d0
    public kotlin.s0.w.d.l0.c.u getVisibility() {
        return this.f18978j;
    }

    protected abstract kotlin.s0.w.d.l0.m.n h0();

    @Override // kotlin.s0.w.d.l0.c.d0
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.h
    public kotlin.s0.w.d.l0.n.e1 k() {
        return this.f18980l;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.j
    public String toString() {
        return "typealias " + getName().b();
    }

    @Override // kotlin.s0.w.d.l0.c.i
    public List<f1> u() {
        List r0 = this.f18979k;
        if (r0 == null) goto L5;
        return r0;
    L5:
        kotlin.n0.d.o.v("declaredTypeParametersImpl");
        throw null;
    }
}
