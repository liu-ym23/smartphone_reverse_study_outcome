package kotlin.s0.w.d.l0.e.a.l0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a0;
import kotlin.i0.m0;
import kotlin.i0.r;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.q1.z;
import kotlin.s0.w.d.l0.e.a.n0.u;
import kotlin.s0.w.d.l0.e.b.p;
import kotlin.s0.w.d.l0.e.b.w;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends z {
    static final /* synthetic */ kotlin.s0.l<Object>[] r = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final u f19430l;
    private final kotlin.s0.w.d.l0.e.a.l0.g m;
    private final kotlin.s0.w.d.l0.m.i n;
    private final d o;
    private final kotlin.s0.w.d.l0.m.i<List<kotlin.s0.w.d.l0.g.c>> p;
    private final kotlin.s0.w.d.l0.c.o1.g q;

    static final class a extends q implements kotlin.n0.c.a<Map<String, ? extends kotlin.s0.w.d.l0.e.b.q>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ h f19431f;

        a(h r1) {
            this.f19431f = r1;
            super(0);
        }

        public final Map<String, kotlin.s0.w.d.l0.e.b.q> a() {
            w r0 = h.F0(this.f19431f).a().o();
            String r1 = this.f19431f.e().b();
            o.e(r1, "fqName.asString()");
            List<String> r2 = r0.a(r1);
            h r5 = this.f19431f;
            ArrayList r3 = new ArrayList();
            Iterator<T> r4 = r2.iterator();
        L4:
            if (r4.hasNext() == false) goto L12;
            String r6 = (String) r4.next();
            kotlin.s0.w.d.l0.g.b r7 = kotlin.s0.w.d.l0.g.b.m(kotlin.s0.w.d.l0.k.u.d.d(r6).e());
            o.e(r7, "topLevel(JvmClassName.by…velClassMaybeWithDollars)");
            kotlin.s0.w.d.l0.e.b.q r8 = p.b(h.F0(r5).a().j(), r7);
            if (r8 == null) goto L8;
            kotlin.u r9 = a0.a(r6, r8);
        L9:
            if (r9 == null) goto L4;
            r3.add(r9);
            goto L4
        L8:
            r9 = null;
            goto L9
        L12:
            return m0.q(r3);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Map<String, ? extends kotlin.s0.w.d.l0.e.b.q> invoke() {
            return a();
        }
    }

    static final class b extends q implements kotlin.n0.c.a<HashMap<kotlin.s0.w.d.l0.k.u.d, kotlin.s0.w.d.l0.k.u.d>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ h f19432f;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f19433a = null;

            static {
                int[] r0 = new int[kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a.values().length];
                r0[kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a.n.ordinal()] = 1;
                r0[kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a.f19735k.ordinal()] = 2;
                f19433a = r0;
            }
        }

        b(h r1) {
            this.f19432f = r1;
            super(0);
        }

        public final HashMap<kotlin.s0.w.d.l0.k.u.d, kotlin.s0.w.d.l0.k.u.d> a() {
            HashMap<kotlin.s0.w.d.l0.k.u.d, kotlin.s0.w.d.l0.k.u.d> r0 = new HashMap();
            Iterator<Map.Entry<String, kotlin.s0.w.d.l0.e.b.q>> r5 = this.f19432f.N0().entrySet().iterator();
        L4:
            if (r5.hasNext() == false) goto L15;
            Map.Entry<String, kotlin.s0.w.d.l0.e.b.q> r1 = r5.next();
            String r2 = r1.getKey();
            kotlin.s0.w.d.l0.e.b.q r3 = r1.getValue();
            kotlin.s0.w.d.l0.k.u.d r4 = kotlin.s0.w.d.l0.k.u.d.d(r2);
            o.e(r4, "byInternalName(partInternalName)");
            kotlin.s0.w.d.l0.e.b.c0.a r6 = r3.a();
            kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a r7 = r6.c();
            int r8 = a.f19433a[r7.ordinal()];
            if (r8 != 1) goto L8;
            String r9 = r6.e();
            if (r9 == null) goto L4;
            kotlin.s0.w.d.l0.k.u.d r10 = kotlin.s0.w.d.l0.k.u.d.d(r9);
            o.e(r10, "byInternalName(header.mu…: continue@kotlinClasses)");
            r0.put(r4, r10);
            goto L4
        L8:
            if (r8 != 2) goto L4;
            r0.put(r4, r4);
            goto L4
        L15:
            return r0;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ HashMap<kotlin.s0.w.d.l0.k.u.d, kotlin.s0.w.d.l0.k.u.d> invoke() {
            return a();
        }
    }

    static final class c extends q implements kotlin.n0.c.a<List<? extends kotlin.s0.w.d.l0.g.c>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ h f19434f;

        c(h r1) {
            this.f19434f = r1;
            super(0);
        }

        public final List<kotlin.s0.w.d.l0.g.c> a() {
            Collection<u> r2 = h.L0(this.f19434f).z();
            ArrayList r0 = new ArrayList(r.q(r2, 10));
            Iterator<T> r3 = r2.iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            r0.add(((u) r3.next()).e());
            goto L4
        L6:
            return r0;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ List<? extends kotlin.s0.w.d.l0.g.c> invoke() {
            return a();
        }
    }

    static {
        r = new kotlin.s0.l[]{e0.g(new y(e0.b(h.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), e0.g(new y(e0.b(h.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};
    }

    public h(kotlin.s0.w.d.l0.e.a.l0.g r9, u r10) {
        o.f(r9, "outerContext");
        o.f(r10, "jPackage");
        super(r9.d(), r10.e());
        this.f19430l = r10;
        kotlin.s0.w.d.l0.e.a.l0.g r11 = kotlin.s0.w.d.l0.e.a.l0.a.d(r9, this, null, 0, 6, null);
        this.m = r11;
        this.n = r11.e().d(new a(this));
        this.o = new d(r11, r10, this);
        this.p = r11.e().c(new c(this), r.g());
        if (r11.a().i().b() == false) goto L5;
        kotlin.s0.w.d.l0.c.o1.g r12 = kotlin.s0.w.d.l0.c.o1.g.f18919b.b();
    L6:
        this.q = r12;
        r11.e().d(new b(this));
        return;
    L5:
        r12 = kotlin.s0.w.d.l0.e.a.l0.e.a(r11, r10);
        goto L6
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.e.a.l0.g F0(h r0) {
        return r0.m;
    }

    public static final /* synthetic */ u L0(h r0) {
        return r0.f19430l;
    }

    public final kotlin.s0.w.d.l0.c.e M0(kotlin.s0.w.d.l0.e.a.n0.g r2) {
        o.f(r2, "jClass");
        return this.o.j().O(r2);
    }

    public final Map<String, kotlin.s0.w.d.l0.e.b.q> N0() {
        return (Map) kotlin.s0.w.d.l0.m.m.a(this.n, this, r[0]);
    }

    public d O0() {
        return this.o;
    }

    public final List<kotlin.s0.w.d.l0.g.c> P0() {
        return this.p.invoke();
    }

    @Override // kotlin.s0.w.d.l0.c.o1.b, kotlin.s0.w.d.l0.c.o1.a
    public kotlin.s0.w.d.l0.c.o1.g getAnnotations() {
        return this.q;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.z, kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.p
    public a1 getSource() {
        return new kotlin.s0.w.d.l0.e.b.r(this);
    }

    @Override // kotlin.s0.w.d.l0.c.l0
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.k.w.h q() {
        return O0();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.z, kotlin.s0.w.d.l0.c.q1.j
    public String toString() {
        return "Lazy Java package fragment: " + e() + " of module " + this.m.a().m();
    }
}
