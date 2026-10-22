package kotlin.s0.w.d.l0.e.a.l0.l;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.i0.m0;
import kotlin.i0.r;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.c.x;
import kotlin.s0.w.d.l0.e.a.a0;
import kotlin.s0.w.d.l0.k.r.s;
import kotlin.s0.w.d.l0.n.g0;
import kotlin.s0.w.d.l0.n.r1;
import kotlin.u;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements kotlin.s0.w.d.l0.c.o1.c, kotlin.s0.w.d.l0.e.a.k0.g {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final /* synthetic */ kotlin.s0.l<Object>[] f19400i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.e.a.l0.g f19401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.e.a.n0.a f19402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.j f19403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.i f19404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.e.a.m0.a f19405e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.i f19406f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f19407g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f19408h;

    static final class a extends q implements kotlin.n0.c.a<Map<kotlin.s0.w.d.l0.g.f, ? extends kotlin.s0.w.d.l0.k.r.g<?>>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f19409f;

        a(e r1) {
            this.f19409f = r1;
            super(0);
        }

        public final Map<kotlin.s0.w.d.l0.g.f, kotlin.s0.w.d.l0.k.r.g<?>> a() {
            Collection<kotlin.s0.w.d.l0.e.a.n0.b> r0 = e.f(this.f19409f).getArguments();
            e r4 = this.f19409f;
            ArrayList r1 = new ArrayList();
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L15;
            kotlin.s0.w.d.l0.e.a.n0.b r3 = (kotlin.s0.w.d.l0.e.a.n0.b) r2.next();
            kotlin.s0.w.d.l0.g.f r5 = r3.getName();
            if (r5 != null) goto L8;
            r5 = a0.f19205b;
        L8:
            kotlin.s0.w.d.l0.k.r.g r6 = e.h(r4, r3);
            if (r6 == null) goto L11;
            u r7 = kotlin.a0.a(r5, r6);
        L12:
            if (r7 == null) goto L4;
            r1.add(r7);
            goto L4
        L11:
            r7 = null;
            goto L12
        L15:
            return m0.q(r1);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Map<kotlin.s0.w.d.l0.g.f, ? extends kotlin.s0.w.d.l0.k.r.g<?>> invoke() {
            return a();
        }
    }

    static final class b extends q implements kotlin.n0.c.a<kotlin.s0.w.d.l0.g.c> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f19410f;

        b(e r1) {
            this.f19410f = r1;
            super(0);
        }

        public final kotlin.s0.w.d.l0.g.c a() {
            kotlin.s0.w.d.l0.g.b r0 = e.f(this.f19410f).f();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.b();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.g.c invoke() {
            return a();
        }
    }

    static final class c extends q implements kotlin.n0.c.a<kotlin.s0.w.d.l0.n.m0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f19411f;

        c(e r1) {
            this.f19411f = r1;
            super(0);
        }

        public final kotlin.s0.w.d.l0.n.m0 a() {
            kotlin.s0.w.d.l0.g.c r0 = this.f19411f.e();
            if (r0 == null) goto L5;
            kotlin.s0.w.d.l0.c.e r1 = kotlin.s0.w.d.l0.b.q.d.f(kotlin.s0.w.d.l0.b.q.d.f18786a, r0, e.d(this.f19411f).d().o(), null, 4, null);
            if (r1 != null) goto L15;
            kotlin.s0.w.d.l0.e.a.n0.g r2 = e.f(this.f19411f).y();
            if (r2 == null) goto L11;
            r1 = e.d(this.f19411f).a().n().a(r2);
        L12:
            if (r1 != null) goto L15;
            r1 = e.c(this.f19411f, r0);
            goto L15
        L11:
            r1 = null;
        L15:
            return r1.s();
        L5:
            return kotlin.s0.w.d.l0.n.u1.k.d(kotlin.s0.w.d.l0.n.u1.j.K0, new String[]{e.f(this.f19411f).toString()});
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.n.m0 invoke() {
            return a();
        }
    }

    static {
        f19400i = new kotlin.s0.l[]{e0.g(new y(e0.b(e.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), e0.g(new y(e0.b(e.class), WsConstants.KEY_CONNECTION_TYPE, "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), e0.g(new y(e0.b(e.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    }

    public e(kotlin.s0.w.d.l0.e.a.l0.g r3, kotlin.s0.w.d.l0.e.a.n0.a r4, boolean r5) {
        o.f(r3, "c");
        o.f(r4, "javaAnnotation");
        this.f19401a = r3;
        this.f19402b = r4;
        this.f19403c = r3.e().f(new b(this));
        this.f19404d = r3.e().d(new c(this));
        this.f19405e = r3.a().t().a(r4);
        this.f19406f = r3.e().d(new a(this));
        this.f19407g = r4.g();
        if (r4.u() == true) goto L7;
        if (r5 == true) goto L7;
        boolean r6 = false;
    L8:
        this.f19408h = r6;
        return;
    L7:
        r6 = true;
        goto L8
    }

    public /* synthetic */ e(kotlin.s0.w.d.l0.e.a.l0.g r1, kotlin.s0.w.d.l0.e.a.n0.a r2, boolean r3, int r4, kotlin.n0.d.g r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.c.e c(e r0, kotlin.s0.w.d.l0.g.c r1) {
        return r0.i(r1);
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.e.a.l0.g d(e r0) {
        return r0.f19401a;
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.e.a.n0.a f(e r0) {
        return r0.f19402b;
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.k.r.g h(e r0, kotlin.s0.w.d.l0.e.a.n0.b r1) {
        return r0.m(r1);
    }

    private final kotlin.s0.w.d.l0.c.e i(kotlin.s0.w.d.l0.g.c r3) {
        h0 r0 = this.f19401a.d();
        kotlin.s0.w.d.l0.g.b r4 = kotlin.s0.w.d.l0.g.b.m(r3);
        o.e(r4, "topLevel(fqName)");
        return x.c(r0, r4, this.f19401a.a().b().d().q());
    }

    private final kotlin.s0.w.d.l0.k.r.g<?> m(kotlin.s0.w.d.l0.e.a.n0.b r3) {
        if ((r3 instanceof kotlin.s0.w.d.l0.e.a.n0.o) == false) goto L6;
        return kotlin.s0.w.d.l0.k.r.h.f20566a.c(((kotlin.s0.w.d.l0.e.a.n0.o) r3).getValue());
    L6:
        if ((r3 instanceof kotlin.s0.w.d.l0.e.a.n0.m) == false) goto L9;
        kotlin.s0.w.d.l0.e.a.n0.m r4 = (kotlin.s0.w.d.l0.e.a.n0.m) r3;
        return p(r4.b(), r4.d());
    L9:
        if ((r3 instanceof kotlin.s0.w.d.l0.e.a.n0.e) == false) goto L15;
        kotlin.s0.w.d.l0.e.a.n0.e r5 = (kotlin.s0.w.d.l0.e.a.n0.e) r3;
        kotlin.s0.w.d.l0.g.f r0 = r5.getName();
        if (r0 != null) goto L13;
        r0 = a0.f19205b;
    L13:
        o.e(r0, "argument.name ?: DEFAULT_ANNOTATION_MEMBER_NAME");
        return o(r0, r5.e());
    L15:
        if ((r3 instanceof kotlin.s0.w.d.l0.e.a.n0.c) == false) goto L18;
        return n(((kotlin.s0.w.d.l0.e.a.n0.c) r3).a());
    L18:
        if ((r3 instanceof kotlin.s0.w.d.l0.e.a.n0.h) == true) goto L26;
        return null;
    L26:
        return q(((kotlin.s0.w.d.l0.e.a.n0.h) r3).c());
    }

    private final kotlin.s0.w.d.l0.k.r.g<?> n(kotlin.s0.w.d.l0.e.a.n0.a r9) {
        return new kotlin.s0.w.d.l0.k.r.a(new e(this.f19401a, r9, false, 4, null));
    }

    private final kotlin.s0.w.d.l0.k.r.g<?> o(kotlin.s0.w.d.l0.g.f r4, List<? extends kotlin.s0.w.d.l0.e.a.n0.b> r5) {
        kotlin.s0.w.d.l0.n.m0 r0 = k();
        o.e(r0, WsConstants.KEY_CONNECTION_TYPE);
        if (g0.a(r0) == false) goto L6;
        return null;
    L6:
        kotlin.s0.w.d.l0.c.e r1 = kotlin.s0.w.d.l0.k.t.a.e(this);
        o.c(r1);
        j1 r6 = kotlin.s0.w.d.l0.e.a.j0.a.b(r4, r1);
        if (r6 == null) goto L10;
        kotlin.s0.w.d.l0.n.e0 r7 = r6.b();
        if (r7 == null) goto L10;
    L11:
        o.e(r7, "DescriptorResolverUtils.…GUMENT)\n                )");
        ArrayList r2 = new ArrayList(r.q(r5, 10));
        Iterator<T> r8 = r5.iterator();
    L13:
        if (r8.hasNext() == false) goto L19;
        kotlin.s0.w.d.l0.k.r.g<?> r3 = m((kotlin.s0.w.d.l0.e.a.n0.b) r8.next());
        if (r3 != null) goto L17;
        r3 = new s();
    L17:
        r2.add(r3);
        goto L13
    L19:
        return kotlin.s0.w.d.l0.k.r.h.f20566a.b(r2, r7);
    L10:
        r7 = this.f19401a.a().m().o().l(r1.f21065h, kotlin.s0.w.d.l0.n.u1.k.d(kotlin.s0.w.d.l0.n.u1.j.J0, new String[0]));
        goto L11
    }

    private final kotlin.s0.w.d.l0.k.r.g<?> p(kotlin.s0.w.d.l0.g.b r1, kotlin.s0.w.d.l0.g.f r2) {
        if (r1 == null) goto L7;
        if (r2 != null) goto L6;
        return null;
    L6:
        return new kotlin.s0.w.d.l0.k.r.j(r1, r2);
    L7:
        return null;
    }

    private final kotlin.s0.w.d.l0.k.r.g<?> q(kotlin.s0.w.d.l0.e.a.n0.x r6) {
        return kotlin.s0.w.d.l0.k.r.q.f20588b.a(this.f19401a.g().o(r6, kotlin.s0.w.d.l0.e.a.l0.m.d.d(kotlin.s0.w.d.l0.e.a.j0.k.f19333g, false, null, 3, null)));
    }

    @Override // kotlin.s0.w.d.l0.c.o1.c
    public Map<kotlin.s0.w.d.l0.g.f, kotlin.s0.w.d.l0.k.r.g<?>> a() {
        return (Map) kotlin.s0.w.d.l0.m.m.a(this.f19406f, this, f19400i[2]);
    }

    @Override // kotlin.s0.w.d.l0.c.o1.c
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.n.e0 b() {
        return k();
    }

    @Override // kotlin.s0.w.d.l0.c.o1.c
    public kotlin.s0.w.d.l0.g.c e() {
        return (kotlin.s0.w.d.l0.g.c) kotlin.s0.w.d.l0.m.m.b(this.f19403c, this, f19400i[0]);
    }

    @Override // kotlin.s0.w.d.l0.e.a.k0.g
    public boolean g() {
        return this.f19407g;
    }

    @Override // kotlin.s0.w.d.l0.c.o1.c
    public /* bridge */ /* synthetic */ a1 getSource() {
        return j();
    }

    public kotlin.s0.w.d.l0.e.a.m0.a j() {
        return this.f19405e;
    }

    public kotlin.s0.w.d.l0.n.m0 k() {
        return (kotlin.s0.w.d.l0.n.m0) kotlin.s0.w.d.l0.m.m.a(this.f19404d, this, f19400i[1]);
    }

    public final boolean l() {
        return this.f19408h;
    }

    public String toString() {
        return kotlin.s0.w.d.l0.j.c.s(kotlin.s0.w.d.l0.j.c.f20438b, this, null, 2, null);
    }
}
