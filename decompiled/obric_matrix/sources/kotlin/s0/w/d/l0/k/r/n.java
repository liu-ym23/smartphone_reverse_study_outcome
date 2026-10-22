package kotlin.s0.w.d.l0.k.r;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.n.a1;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.e1;
import kotlin.s0.w.d.l0.n.f0;
import kotlin.s0.w.d.l0.n.i1;
import kotlin.s0.w.d.l0.n.k1;
import kotlin.s0.w.d.l0.n.m0;
import kotlin.s0.w.d.l0.n.r1;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements e1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f20573f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f20574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h0 f20575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<e0> f20576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final m0 f20577d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlin.h f20578e;

    public static final class a {

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.k.r.n$a$a, reason: collision with other inner class name */
        private static final enum EnumC0560a extends Enum<EnumC0560a> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final EnumC0560a f20579f = null;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final EnumC0560a f20580g = null;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private static final /* synthetic */ EnumC0560a[] f20581h = null;

            static {
                f20579f = new EnumC0560a("COMMON_SUPER_TYPE", 0);
                f20580g = new EnumC0560a("INTERSECTION_TYPE", 1);
                f20581h = a();
            }

            private EnumC0560a(String r1, int r2) {
                super(r1, r2);
            }

            private static final /* synthetic */ EnumC0560a[] a() {
                return new EnumC0560a[]{f20579f, f20580g};
            }

            public static EnumC0560a valueOf(String r1) {
                return (EnumC0560a) Enum.valueOf(EnumC0560a.class, r1);
            }

            public static EnumC0560a[] values() {
                return (EnumC0560a[]) f20581h.clone();
            }
        }

        public /* synthetic */ class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f20582a = null;

            static {
                int[] r0 = new int[EnumC0560a.values().length];
                r0[EnumC0560a.f20579f.ordinal()] = 1;
                r0[EnumC0560a.f20580g.ordinal()] = 2;
                f20582a = r0;
            }
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        private final m0 a(Collection<? extends m0> r3, EnumC0560a r4) {
            if (r3.isEmpty() == false) goto L6;
            return null;
        L6:
            Iterator<T> r2 = r3.iterator();
            if (r2.hasNext() == false) goto L15;
            Object r5 = r2.next();
        L10:
            if (r2.hasNext() == false) goto L13;
            m0 r0 = (m0) r2.next();
            a r1 = n.f20573f;
            r5 = r1.e((m0) r5, r0, r4);
            goto L10
        L13:
            return (m0) r5;
        L15:
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }

        private final m0 c(n r7, n r8, EnumC0560a r9) {
            int r6 = b.f20582a[r9.ordinal()];
            if (r6 != 1) goto L5;
            Set r10 = kotlin.i0.r.V(r7.k(), r8.k());
        L10:
            long r1 = n.i(r7);
            h0 r3 = n.g(r7);
            n r11 = new n(r1, r3, r10, null);
            return f0.e(a1.f20943g.h(), r11, false);
        L5:
            if (r6 != 2) goto L8;
            r10 = kotlin.i0.r.E0(r7.k(), r8.k());
            goto L10
        L8:
            throw new kotlin.m();
        }

        private final m0 d(n r1, m0 r2) {
            if (r1.k().contains(r2) == true) goto L7;
            return null;
        L7:
            return r2;
        }

        private final m0 e(m0 r6, m0 r7, EnumC0560a r8) {
            if (r6 == null) goto L17;
            if (r7 == null) goto L21;
            e1 r1 = r6.O0();
            e1 r2 = r7.O0();
            boolean r3 = r1 instanceof n;
            if (r3 == true) goto L9;
        L11:
            if (r3 == false) goto L14;
            return d((n) r1, r7);
        L14:
            if ((r2 instanceof n) == true) goto L16;
            return null;
        L16:
            return d((n) r2, r6);
        L9:
            if ((r2 instanceof n) == false) goto L11;
            return c((n) r1, (n) r2, r8);
        L21:
            return null;
        L17:
            return null;
        }

        public final m0 b(Collection<? extends m0> r2) {
            kotlin.n0.d.o.f(r2, "types");
            return a(r2, EnumC0560a.f20580g);
        }
    }

    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.a<List<m0>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ n f20583f;

        b(n r1) {
            this.f20583f = r1;
            super(0);
        }

        public final List<m0> a() {
            m0 r1 = this.f20583f.o().x().s();
            kotlin.n0.d.o.e(r1, "builtIns.comparable.defaultType");
            List<m0> r0 = kotlin.i0.r.m(new m0[]{k1.f(r1, kotlin.i0.r.d(new i1(r1.f21066i, n.h(this.f20583f))), null, 2, null)});
            if (n.j(this.f20583f) == true) goto L5;
            r0.add(this.f20583f.o().L());
        L5:
            return r0;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ List<m0> invoke() {
            return a();
        }
    }

    static final class c extends kotlin.n0.d.q implements kotlin.n0.c.l<e0, CharSequence> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f20584f = null;

        static {
            f20584f = new c();
        }

        c() {
            super(1);
        }

        public final CharSequence a(e0 r1) {
            kotlin.n0.d.o.f(r1, "it");
            return r1.toString();
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ CharSequence invoke(e0 r1) {
            return a(r1);
        }
    }

    static {
        f20573f = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private n(long r3, h0 r5, Set<? extends e0> r6) {
        this.f20577d = f0.e(a1.f20943g.h(), this, false);
        this.f20578e = kotlin.i.b(new b(this));
        this.f20574a = r3;
        this.f20575b = r5;
        this.f20576c = r6;
    }

    public /* synthetic */ n(long r1, h0 r3, Set r4, kotlin.n0.d.g r5) {
        this(r1, r3, r4);
    }

    public static final /* synthetic */ h0 g(n r0) {
        return r0.f20575b;
    }

    public static final /* synthetic */ m0 h(n r0) {
        return r0.f20577d;
    }

    public static final /* synthetic */ long i(n r2) {
        return r2.f20574a;
    }

    public static final /* synthetic */ boolean j(n r0) {
        return r0.m();
    }

    private final List<e0> l() {
        return (List) this.f20578e.getValue();
    }

    private final boolean m() {
        Collection<e0> r0 = t.a(this.f20575b);
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L18;
        if ((!this.f20576c.contains((e0) r1.next())) == true) goto L9;
        return false;
    L18:
        return true;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return true;
    }

    private final String n() {
        return '[' + kotlin.i0.r.Z(this.f20576c, ",", null, null, 0, null, c.f20584f, 30, null) + ']';
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public Collection<e0> a() {
        return l();
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public e1 c(kotlin.s0.w.d.l0.n.t1.g r2) {
        kotlin.n0.d.o.f(r2, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public kotlin.s0.w.d.l0.c.h d() {
        return null;
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public boolean e() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public List<f1> getParameters() {
        return kotlin.i0.r.g();
    }

    public final Set<e0> k() {
        return this.f20576c;
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public kotlin.s0.w.d.l0.b.h o() {
        return this.f20575b.o();
    }

    public String toString() {
        return "IntegerLiteralType" + n();
    }
}
