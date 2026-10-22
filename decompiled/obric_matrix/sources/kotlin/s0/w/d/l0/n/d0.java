package kotlin.s0.w.d.l0.n;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class d0 implements e1, kotlin.s0.w.d.l0.n.w1.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e0 f20950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedHashSet<e0> f20951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f20952c;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.n.t1.g, m0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d0 f20953f;

        a(d0 r1) {
            this.f20953f = r1;
            super(1);
        }

        public final m0 a(kotlin.s0.w.d.l0.n.t1.g r2) {
            kotlin.n0.d.o.f(r2, "kotlinTypeRefiner");
            return this.f20953f.l(r2).h();
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ m0 invoke(kotlin.s0.w.d.l0.n.t1.g r1) {
            return a(r1);
        }
    }

    public static final class b<T> implements Comparator {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.l f20954f;

        public b(kotlin.n0.c.l r1) {
            this.f20954f = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            e0 r5 = (e0) r3;
            kotlin.n0.c.l r0 = this.f20954f;
            kotlin.n0.d.o.e(r5, "it");
            String r6 = r0.invoke(r5).toString();
            e0 r7 = (e0) r4;
            kotlin.n0.c.l r2 = this.f20954f;
            kotlin.n0.d.o.e(r7, "it");
            return kotlin.j0.a.a(r6, r2.invoke(r7).toString());
        }
    }

    static final class c extends kotlin.n0.d.q implements kotlin.n0.c.l<e0, String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f20955f = null;

        static {
            f20955f = new c();
        }

        c() {
            super(1);
        }

        public final String a(e0 r1) {
            kotlin.n0.d.o.f(r1, "it");
            return r1.toString();
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ String invoke(e0 r1) {
            return a(r1);
        }
    }

    static final class d extends kotlin.n0.d.q implements kotlin.n0.c.l<e0, CharSequence> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.l<e0, Object> f20956f;

        /* JADX WARN: Multi-variable type inference failed */
        d(kotlin.n0.c.l<? super e0, ? extends Object> r1) {
            this.f20956f = r1;
            super(1);
        }

        public final CharSequence a(e0 r2) {
            kotlin.n0.c.l<e0, Object> r1 = this.f20956f;
            kotlin.n0.d.o.e(r2, "it");
            return r1.invoke(r2).toString();
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ CharSequence invoke(e0 r1) {
            return a(r1);
        }
    }

    public d0(Collection<? extends e0> r2) {
        kotlin.n0.d.o.f(r2, "typesToIntersect");
        r2.isEmpty();
        LinkedHashSet<e0> r0 = new LinkedHashSet(r2);
        this.f20951b = r0;
        this.f20952c = r0.hashCode();
    }

    private d0(Collection<? extends e0> r1, e0 r2) {
        this(r1);
        this.f20950a = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String k(d0 r0, kotlin.n0.c.l r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = c.f20955f;
    L6:
        return r0.j(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public Collection<e0> a() {
        return this.f20951b;
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public /* bridge */ /* synthetic */ e1 c(kotlin.s0.w.d.l0.n.t1.g r1) {
        return l(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public kotlin.s0.w.d.l0.c.h d() {
        return null;
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public boolean e() {
        return false;
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L6;
        return true;
    L6:
        if ((r2 instanceof d0) == true) goto L10;
        return false;
    L10:
        return kotlin.n0.d.o.a(this.f20951b, ((d0) r2).f20951b);
    }

    public final kotlin.s0.w.d.l0.k.w.h g() {
        return kotlin.s0.w.d.l0.k.w.n.f20660c.a("member scope for intersection type", this.f20951b);
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public List<kotlin.s0.w.d.l0.c.f1> getParameters() {
        return kotlin.i0.r.g();
    }

    public final m0 h() {
        return f0.k(a1.f20943g.h(), this, kotlin.i0.r.g(), false, g(), new a(this));
    }

    public int hashCode() {
        return this.f20952c;
    }

    public final e0 i() {
        return this.f20950a;
    }

    public final String j(kotlin.n0.c.l<? super e0, ? extends Object> r11) {
        kotlin.n0.d.o.f(r11, "getProperTypeRelatedToStringify");
        return kotlin.i0.r.Z(kotlin.i0.r.s0(this.f20951b, new b(r11)), " & ", "{", "}", 0, null, new d(r11), 24, null);
    }

    public d0 l(kotlin.s0.w.d.l0.n.t1.g r5) {
        kotlin.n0.d.o.f(r5, "kotlinTypeRefiner");
        Collection<e0> r0 = a();
        ArrayList r1 = new ArrayList(kotlin.i0.r.q(r0, 10));
        Iterator<T> r2 = r0.iterator();
        boolean r3 = false;
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(((e0) r2.next()).Q0(r5));
        r3 = true;
        goto L4
    L6:
        d0 r4 = null;
        e0 r6 = null;
        if (r3 == false) goto L13;
        e0 r7 = i();
        if (r7 == null) goto L12;
        r6 = r7.Q0(r5);
    L12:
        r4 = new d0(r1).m(r6);
    L13:
        if (r4 != null) goto L16;
        return this;
    L16:
        return r4;
    }

    public final d0 m(e0 r2) {
        return new d0(this.f20951b, r2);
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public kotlin.s0.w.d.l0.b.h o() {
        kotlin.s0.w.d.l0.b.h r1 = this.f20951b.iterator().next().O0().o();
        kotlin.n0.d.o.e(r1, "intersectedTypes.iterato…xt().constructor.builtIns");
        return r1;
    }

    public String toString() {
        return k(this, null, 1, null);
    }
}
