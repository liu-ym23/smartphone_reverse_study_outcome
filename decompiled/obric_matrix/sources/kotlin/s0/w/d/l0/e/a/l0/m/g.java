package kotlin.s0.w.d.l0.e.a.l0.m;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.a0;
import kotlin.h;
import kotlin.i;
import kotlin.i0.r;
import kotlin.i0.t0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.g1;
import kotlin.s0.w.d.l0.n.l1;
import kotlin.s0.w.d.l0.n.m0;
import kotlin.s0.w.d.l0.n.r1;
import kotlin.s0.w.d.l0.n.u1.j;
import kotlin.s0.w.d.l0.n.u1.k;
import kotlin.u;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.f f19515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f19516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f19517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.g<a, e0> f19518d;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final f1 f19519a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f19520b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.e.a.l0.m.a f19521c;

        public a(f1 r2, boolean r3, kotlin.s0.w.d.l0.e.a.l0.m.a r4) {
            o.f(r2, "typeParameter");
            o.f(r4, "typeAttr");
            this.f19519a = r2;
            this.f19520b = r3;
            this.f19521c = r4;
        }

        public final kotlin.s0.w.d.l0.e.a.l0.m.a a() {
            return this.f19521c;
        }

        public final f1 b() {
            return this.f19519a;
        }

        public final boolean c() {
            return this.f19520b;
        }

        public boolean equals(Object r4) {
            if ((r4 instanceof a) == true) goto L5;
            return false;
        L5:
            a r5 = (a) r4;
            if (o.a(r5.f19519a, this.f19519a) == true) goto L8;
            return false;
        L8:
            if (r5.f19520b == this.f19520b) goto L10;
            return false;
        L10:
            if (r5.f19521c.d() == this.f19521c.d()) goto L12;
            return false;
        L12:
            if (r5.f19521c.e() == this.f19521c.e()) goto L14;
            return false;
        L14:
            if (r5.f19521c.g() == this.f19521c.g()) goto L16;
            return false;
        L16:
            if (o.a(r5.f19521c.c(), this.f19521c.c()) == false) goto L24;
            return true;
        L24:
            return false;
        }

        public int hashCode() {
            int r0 = this.f19519a.hashCode();
            int r1 = r0 + ((r0 * 31) + (this.f19520b ? 1 : 0));
            int r2 = r1 + ((r1 * 31) + this.f19521c.d().hashCode());
            int r3 = r2 + ((r2 * 31) + this.f19521c.e().hashCode());
            int r4 = r3 + ((r3 * 31) + (this.f19521c.g() ? 1 : 0));
            int r5 = r4 * 31;
            m0 r6 = this.f19521c.c();
            if (r6 == null) goto L5;
            int r7 = r6.hashCode();
        L7:
            return r4 + (r5 + r7);
        L5:
            r7 = 0;
            goto L7
        }

        public String toString() {
            return "DataToEraseUpperBound(typeParameter=" + this.f19519a + ", isRaw=" + this.f19520b + ", typeAttr=" + this.f19521c + ')';
        }
    }

    static final class b extends q implements kotlin.n0.c.a<kotlin.s0.w.d.l0.n.u1.h> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f19522f;

        b(g r1) {
            this.f19522f = r1;
            super(0);
        }

        public final kotlin.s0.w.d.l0.n.u1.h a() {
            return k.d(j.B0, new String[]{this.f19522f.toString()});
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.n.u1.h invoke() {
            return a();
        }
    }

    static final class c extends q implements l<a, e0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f19523f;

        c(g r1) {
            this.f19523f = r1;
            super(1);
        }

        public final e0 a(a r3) {
            return g.a(this.f19523f, r3.b(), r3.c(), r3.a());
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ e0 invoke(a r1) {
            return a(r1);
        }
    }

    public g(e r3) {
        kotlin.s0.w.d.l0.m.f r0 = new kotlin.s0.w.d.l0.m.f("Type parameter upper bound erasion results");
        this.f19515a = r0;
        this.f19516b = i.b(new b(this));
        if (r3 != null) goto L5;
        r3 = new e(this);
    L5:
        this.f19517c = r3;
        kotlin.s0.w.d.l0.m.g<a, e0> r4 = r0.h(new c(this));
        o.e(r4, "storage.createMemoizedFu… isRaw, typeAttr) }\n    }");
        this.f19518d = r4;
    }

    public /* synthetic */ g(e r1, int r2, kotlin.n0.d.g r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public static final /* synthetic */ e0 a(g r0, f1 r1, boolean r2, kotlin.s0.w.d.l0.e.a.l0.m.a r3) {
        return r0.d(r1, r2, r3);
    }

    private final e0 b(kotlin.s0.w.d.l0.e.a.l0.m.a r1) {
        m0 r2 = r1.c();
        if (r2 == null) goto L7;
        e0 r3 = kotlin.s0.w.d.l0.n.x1.a.w(r2);
        if (r3 == null) goto L7;
        return r3;
    L7:
        return e();
    }

    private final e0 d(f1 r9, boolean r10, kotlin.s0.w.d.l0.e.a.l0.m.a r11) {
        Set<f1> r0 = r11.f();
        if (r0 != null) goto L5;
    L8:
        m0 r1 = r9.s();
        o.e(r1, "typeParameter.defaultType");
        Set<f1> r2 = kotlin.s0.w.d.l0.n.x1.a.f(r1, r0);
        LinkedHashMap r3 = new LinkedHashMap(kotlin.r0.e.c(kotlin.i0.m0.d(r.q(r2, 10)), 16));
        Iterator<T> r4 = r2.iterator();
    L10:
        if (r4.hasNext() == false) goto L23;
        f1 r5 = (f1) r4.next();
        if (r0 != null) goto L14;
    L17:
        e r6 = this.f19517c;
        if (r10 == false) goto L20;
        kotlin.s0.w.d.l0.e.a.l0.m.a r7 = r11;
    L21:
        e0 r8 = c(r5, r10, r11.j(r9));
        o.e(r8, "getErasedUpperBound(it, …Parameter(typeParameter))");
        g1 r12 = r6.j(r5, r7, r8);
    L22:
        u r13 = a0.a(r5.k(), r12);
        r3.put(r13.c(), r13.d());
        goto L10
    L20:
        r7 = r11.i(kotlin.s0.w.d.l0.e.a.l0.m.b.f19492f);
        goto L21
    L14:
        if (r0.contains(r5) == false) goto L17;
        r12 = d.b(r5, r11);
        goto L22
    L23:
        l1 r14 = l1.g(kotlin.s0.w.d.l0.n.f1.a.e(kotlin.s0.w.d.l0.n.f1.f21004b, r3, false, 2, null));
        o.e(r14, "create(TypeConstructorSu…rsMap(erasedUpperBounds))");
        List<e0> r15 = r9.getUpperBounds();
        o.e(r15, "typeParameter.upperBounds");
        e0 r16 = (e0) r.P(r15);
        if ((r16.O0().d() instanceof kotlin.s0.w.d.l0.c.e) == false) goto L28;
        String r17 = "firstUpperBound";
    L26:
        o.e(r16, r17);
        return kotlin.s0.w.d.l0.n.x1.a.v(r16, r14, r3, r1.f21067j, r11.f());
    L28:
        Set<f1> r18 = r11.f();
        if (r18 != null) goto L31;
        r18 = t0.a(this);
    L31:
        kotlin.s0.w.d.l0.c.h r19 = r16.O0().d();
    L32:
        o.d(r19, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        f1 r20 = (f1) r19;
        if (r18.contains(r20) == true) goto L39;
        List<e0> r21 = r20.getUpperBounds();
        o.e(r21, "current.upperBounds");
        r16 = (e0) r.P(r21);
        if ((r16.O0().d() instanceof kotlin.s0.w.d.l0.c.e) == true) goto L36;
        r19 = r16.O0().d();
        goto L32
    L36:
        r17 = "nextUpperBound";
        goto L26
    L39:
        return b(r11);
    L5:
        if (r0.contains(r9.a()) == false) goto L8;
        return b(r11);
    }

    private final kotlin.s0.w.d.l0.n.u1.h e() {
        return (kotlin.s0.w.d.l0.n.u1.h) this.f19516b.getValue();
    }

    public final e0 c(f1 r2, boolean r3, kotlin.s0.w.d.l0.e.a.l0.m.a r4) {
        o.f(r2, "typeParameter");
        o.f(r4, "typeAttr");
        return this.f19518d.invoke(new a(r2, r3, r4));
    }
}
