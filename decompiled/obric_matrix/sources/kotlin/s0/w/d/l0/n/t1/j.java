package kotlin.s0.w.d.l0.n.t1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.e1;
import kotlin.s0.w.d.l0.n.g1;
import kotlin.s0.w.d.l0.n.q1;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements kotlin.s0.w.d.l0.k.q.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g1 f21088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private kotlin.n0.c.a<? extends List<? extends q1>> f21089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j f21090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f1 f21091d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlin.h f21092e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private q1 f21093f;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.a<List<? extends q1>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ List<q1> f21094f;

        /* JADX WARN: Multi-variable type inference failed */
        a(List<? extends q1> r1) {
            this.f21094f = r1;
            super(0);
        }

        public final List<q1> a() {
            return this.f21094f;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ List<? extends q1> invoke() {
            return a();
        }
    }

    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.a<List<? extends q1>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ j f21095f;

        b(j r1) {
            this.f21095f = r1;
            super(0);
        }

        public final List<q1> a() {
            kotlin.n0.c.a r0 = j.g(this.f21095f);
            if (r0 != null) goto L7;
            return null;
        L7:
            return (List) r0.invoke();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ List<? extends q1> invoke() {
            return a();
        }
    }

    static final class c extends kotlin.n0.d.q implements kotlin.n0.c.a<List<? extends q1>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ List<q1> f21096f;

        /* JADX WARN: Multi-variable type inference failed */
        c(List<? extends q1> r1) {
            this.f21096f = r1;
            super(0);
        }

        public final List<q1> a() {
            return this.f21096f;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ List<? extends q1> invoke() {
            return a();
        }
    }

    static final class d extends kotlin.n0.d.q implements kotlin.n0.c.a<List<? extends q1>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ j f21097f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ g f21098g;

        d(j r1, g r2) {
            this.f21097f = r1;
            this.f21098g = r2;
            super(0);
        }

        public final List<q1> a() {
            List<q1> r0 = this.f21097f.i();
            g r3 = this.f21098g;
            ArrayList r1 = new ArrayList(kotlin.i0.r.q(r0, 10));
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            r1.add(((q1) r2.next()).T0(r3));
            goto L4
        L6:
            return r1;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ List<? extends q1> invoke() {
            return a();
        }
    }

    public j(g1 r9, List<? extends q1> r10, j r11) {
        kotlin.n0.d.o.f(r9, "projection");
        kotlin.n0.d.o.f(r10, "supertypes");
        this(r9, new a(r10), r11, null, 8, null);
    }

    public /* synthetic */ j(g1 r1, List r2, j r3, int r4, kotlin.n0.d.g r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }

    public j(g1 r2, kotlin.n0.c.a<? extends List<? extends q1>> r3, j r4, f1 r5) {
        kotlin.n0.d.o.f(r2, "projection");
        this.f21088a = r2;
        this.f21089b = r3;
        this.f21090c = r4;
        this.f21091d = r5;
        this.f21092e = kotlin.i.a(kotlin.l.f18418g, new b(this));
    }

    public /* synthetic */ j(g1 r2, kotlin.n0.c.a r3, j r4, f1 r5, int r6, kotlin.n0.d.g r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = null;
    L11:
        this(r2, r3, r4, r5);
    }

    public static final /* synthetic */ kotlin.n0.c.a g(j r0) {
        return r0.f21089b;
    }

    private final List<q1> h() {
        return (List) this.f21092e.getValue();
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public /* bridge */ /* synthetic */ Collection a() {
        return i();
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public /* bridge */ /* synthetic */ e1 c(g r1) {
        return k(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public kotlin.s0.w.d.l0.c.h d() {
        return null;
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public boolean e() {
        return false;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 == null) goto L8;
        Class<?> r2 = r4.getClass();
    L10:
        if (kotlin.n0.d.o.a(j.class, r2) == true) goto L12;
        return false;
    L12:
        kotlin.n0.d.o.d(r4, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
        j r5 = (j) r4;
        j r1 = this.f21090c;
        if (r1 == null) goto L16;
        j this = r1;
    L16:
        j r3 = r5.f21090c;
        if (r3 == null) goto L20;
        r5 = r3;
    L20:
        if (this != r5) goto L23;
        return true;
    L23:
        return false;
    L8:
        r2 = null;
        goto L10
    }

    @Override // kotlin.s0.w.d.l0.k.q.a.b
    public g1 f() {
        return this.f21088a;
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public List<f1> getParameters() {
        return kotlin.i0.r.g();
    }

    public int hashCode() {
        j r0 = this.f21090c;
        if (r0 == null) goto L6;
        return r0.hashCode();
    L6:
        return super.hashCode();
    }

    public List<q1> i() {
        List r0 = kotlin.i0.r.c();
        q1 r1 = this.f21093f;
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        List<q1> r2 = h();
        if (r2 == null) goto L9;
        r0.addAll(r2);
    L9:
        return kotlin.i0.r.a(r0);
    }

    public final void j(q1 r2, List<? extends q1> r3) {
        kotlin.n0.d.o.f(r3, "boundSupertypes");
        kotlin.n0.c.a<? extends List<? extends q1>> r0 = this.f21089b;
        this.f21093f = r2;
        this.f21089b = new c(r3);
    }

    public j k(g r4) {
        kotlin.n0.d.o.f(r4, "kotlinTypeRefiner");
        g1 r0 = f().c(r4);
        kotlin.n0.d.o.e(r0, "projection.refine(kotlinTypeRefiner)");
        if (this.f21089b == null) goto L5;
        d r1 = new d(this, r4);
    L6:
        j r5 = this.f21090c;
        if (r5 != null) goto L10;
        r5 = this;
    L10:
        return new j(r0, r1, r5, this.f21091d);
    L5:
        r1 = null;
        goto L6
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public kotlin.s0.w.d.l0.b.h o() {
        e0 r1 = f().b();
        kotlin.n0.d.o.e(r1, "projection.type");
        return kotlin.s0.w.d.l0.n.x1.a.h(r1);
    }

    public String toString() {
        return "CapturedType(" + f() + ')';
    }
}
