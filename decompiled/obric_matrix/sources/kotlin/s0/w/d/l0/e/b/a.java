package kotlin.s0.w.d.l0.e.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.n.e0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<A, C> extends kotlin.s0.w.d.l0.e.b.b<A, C0521a<? extends A, ? extends C>> implements kotlin.s0.w.d.l0.l.b.c<A, C> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.g<q, C0521a<A, C>> f19665b;

    /* JADX INFO: renamed from: kotlin.s0.w.d.l0.e.b.a$a, reason: collision with other inner class name */
    public static final class C0521a<A, C> extends kotlin.s0.w.d.l0.e.b.b.a<A> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<t, List<A>> f19666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<t, C> f19667b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Map<t, C> f19668c;

        /* JADX WARN: Multi-variable type inference failed */
        public C0521a(Map<t, ? extends List<? extends A>> r2, Map<t, ? extends C> r3, Map<t, ? extends C> r4) {
            kotlin.n0.d.o.f(r2, "memberAnnotations");
            kotlin.n0.d.o.f(r3, "propertyConstants");
            kotlin.n0.d.o.f(r4, "annotationParametersDefaultValues");
            this.f19666a = r2;
            this.f19667b = r3;
            this.f19668c = r4;
        }

        @Override // kotlin.s0.w.d.l0.e.b.b.a
        public Map<t, List<A>> a() {
            return this.f19666a;
        }

        public final Map<t, C> b() {
            return this.f19668c;
        }

        public final Map<t, C> c() {
            return this.f19667b;
        }
    }

    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.p<C0521a<? extends A, ? extends C>, t, C> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f19669f = null;

        static {
            f19669f = new b();
        }

        b() {
            super(2);
        }

        public final C a(C0521a<? extends A, ? extends C> r1, t r2) {
            kotlin.n0.d.o.f(r1, "$this$loadConstantFromProperty");
            kotlin.n0.d.o.f(r2, "it");
            return r1.b().get(r2);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(Object r1, t r2) {
            return a((C0521a) r1, r2);
        }
    }

    public static final class c implements q.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a<A, C> f19670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ HashMap<t, List<A>> f19671b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ q f19672c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ HashMap<t, C> f19673d;

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.e.b.a$c$a, reason: collision with other inner class name */
        public final class C0522a extends b implements q.e {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ c f19674d;

            public C0522a(c r2, t r3) {
                kotlin.n0.d.o.f(r3, "signature");
                this.f19674d = r2;
                super(r2, r3);
            }

            @Override // kotlin.s0.w.d.l0.e.b.q.e
            public q.a c(int r3, kotlin.s0.w.d.l0.g.b r4, a1 r5) {
                kotlin.n0.d.o.f(r4, "classId");
                kotlin.n0.d.o.f(r5, "source");
                t r6 = t.f19794b.e(d(), r3);
                List<A> r0 = this.f19674d.f19671b.get(r6);
                if (r0 != null) goto L6;
                r0 = new ArrayList();
                this.f19674d.f19671b.put(r6, r0);
            L6:
                return this.f19674d.f19670a.y(r4, r5, r0);
            }
        }

        public class b implements q.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final t f19675a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final ArrayList<A> f19676b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ c f19677c;

            public b(c r2, t r3) {
                kotlin.n0.d.o.f(r3, "signature");
                this.f19677c = r2;
                this.f19675a = r3;
                this.f19676b = new ArrayList();
            }

            @Override // kotlin.s0.w.d.l0.e.b.q.c
            public void a() {
                if ((!this.f19676b.isEmpty()) == false) goto L6;
                this.f19677c.f19671b.put(this.f19675a, this.f19676b);
                return;
            }

            @Override // kotlin.s0.w.d.l0.e.b.q.c
            public q.a b(kotlin.s0.w.d.l0.g.b r2, a1 r3) {
                kotlin.n0.d.o.f(r2, "classId");
                kotlin.n0.d.o.f(r3, "source");
                return this.f19677c.f19670a.y(r2, r3, this.f19676b);
            }

            protected final t d() {
                return this.f19675a;
            }
        }

        c(a<A, C> r1, HashMap<t, List<A>> r2, q r3, HashMap<t, C> r4, HashMap<t, C> r5) {
            this.f19670a = r1;
            this.f19671b = r2;
            this.f19672c = r3;
            this.f19673d = r5;
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.d
        public q.c a(kotlin.s0.w.d.l0.g.f r3, String r4, Object r5) {
            kotlin.n0.d.o.f(r3, "name");
            kotlin.n0.d.o.f(r4, "desc");
            t.a r0 = t.f19794b;
            String r6 = r3.b();
            kotlin.n0.d.o.e(r6, "name.asString()");
            t r7 = r0.a(r6, r4);
            if (r5 == null) goto L8;
            C r8 = this.f19670a.G(r4, r5);
            if (r8 == null) goto L8;
            this.f19673d.put(r7, r8);
        L8:
            return new b(this, r7);
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.d
        public q.e b(kotlin.s0.w.d.l0.g.f r4, String r5) {
            kotlin.n0.d.o.f(r4, "name");
            kotlin.n0.d.o.f(r5, "desc");
            t.a r1 = t.f19794b;
            String r6 = r4.b();
            kotlin.n0.d.o.e(r6, "name.asString()");
            return new C0522a(this, r1.d(r6, r5));
        }
    }

    static final class d extends kotlin.n0.d.q implements kotlin.n0.c.p<C0521a<? extends A, ? extends C>, t, C> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final d f19678f = null;

        static {
            f19678f = new d();
        }

        d() {
            super(2);
        }

        public final C a(C0521a<? extends A, ? extends C> r1, t r2) {
            kotlin.n0.d.o.f(r1, "$this$loadConstantFromProperty");
            kotlin.n0.d.o.f(r2, "it");
            return r1.c().get(r2);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(Object r1, t r2) {
            return a((C0521a) r1, r2);
        }
    }

    static final class e extends kotlin.n0.d.q implements kotlin.n0.c.l<q, C0521a<? extends A, ? extends C>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a<A, C> f19679f;

        e(a<A, C> r1) {
            this.f19679f = r1;
            super(1);
        }

        public final C0521a<A, C> a(q r2) {
            kotlin.n0.d.o.f(r2, "kotlinClass");
            return a.C(this.f19679f, r2);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Object invoke(q r1) {
            return a(r1);
        }
    }

    public a(kotlin.s0.w.d.l0.m.n r2, o r3) {
        kotlin.n0.d.o.f(r2, "storageManager");
        kotlin.n0.d.o.f(r3, "kotlinClassFinder");
        super(r3);
        this.f19665b = r2.h(new e(this));
    }

    public static final /* synthetic */ C0521a C(a r0, q r1) {
        return r0.F(r1);
    }

    private final C0521a<A, C> F(q r11) {
        HashMap r6 = new HashMap();
        HashMap r7 = new HashMap();
        HashMap r8 = new HashMap();
        r11.c(new c(this, r6, r11, r8, r7), q(r11));
        return new C0521a(r6, r7, r8);
    }

    private final C H(kotlin.s0.w.d.l0.l.b.z r11, kotlin.s0.w.d.l0.f.n r12, kotlin.s0.w.d.l0.l.b.b r13, e0 r14, kotlin.n0.c.p<? super C0521a<? extends A, ? extends C>, ? super t, ? extends C> r15) {
        q r0 = o(r11, v(r11, true, true, kotlin.s0.w.d.l0.f.z.b.A.g(r12.a0()), kotlin.s0.w.d.l0.f.a0.b.i.f(r12)));
        if (r0 != null) goto L5;
        return null;
    L5:
        boolean r9 = r0.a().d().d(g.f19762b.a());
        t r16 = r(r12, r11.b(), r11.d(), r13, r9);
        if (r16 != null) goto L8;
        return null;
    L8:
        C r17 = r15.invoke(this.f19665b.invoke(r0), r16);
        if (r17 != null) goto L12;
        return null;
    L12:
        if (kotlin.s0.w.d.l0.b.o.d(r14) == true) goto L14;
        return r17;
    L14:
        return I(r17);
    }

    protected C0521a<A, C> D(q r2) {
        kotlin.n0.d.o.f(r2, "binaryClass");
        return this.f19665b.invoke(r2);
    }

    protected final boolean E(kotlin.s0.w.d.l0.g.b r3, Map<kotlin.s0.w.d.l0.g.f, ? extends kotlin.s0.w.d.l0.k.r.g<?>> r4) {
        kotlin.n0.d.o.f(r3, "annotationClassId");
        kotlin.n0.d.o.f(r4, "arguments");
        if (kotlin.n0.d.o.a(r3, kotlin.s0.w.d.l0.a.f18663a.a()) == true) goto L5;
        return false;
    L5:
        kotlin.s0.w.d.l0.k.r.g<?> r5 = r4.get(kotlin.s0.w.d.l0.g.f.k("value"));
        kotlin.s0.w.d.l0.k.r.q.b.C0561b r1 = null;
        if ((r5 instanceof kotlin.s0.w.d.l0.k.r.q) == false) goto L8;
        kotlin.s0.w.d.l0.k.r.q r6 = (kotlin.s0.w.d.l0.k.r.q) r5;
    L9:
        if (r6 != null) goto L11;
        return false;
    L11:
        kotlin.s0.w.d.l0.k.r.q.b r7 = r6.b();
        if ((r7 instanceof kotlin.s0.w.d.l0.k.r.q.b.C0561b) == false) goto L14;
        r1 = (kotlin.s0.w.d.l0.k.r.q.b.C0561b) r7;
    L14:
        if (r1 != null) goto L17;
        return false;
    L17:
        return w(r1.b());
    L8:
        r6 = null;
        goto L9
    }

    protected abstract C G(String r1, Object r2);

    protected abstract C I(C r1);

    @Override // kotlin.s0.w.d.l0.l.b.c
    public C e(kotlin.s0.w.d.l0.l.b.z r8, kotlin.s0.w.d.l0.f.n r9, e0 r10) {
        kotlin.n0.d.o.f(r8, "container");
        kotlin.n0.d.o.f(r9, "proto");
        kotlin.n0.d.o.f(r10, "expectedType");
        return H(r8, r9, kotlin.s0.w.d.l0.l.b.b.f20696g, r10, d.f19678f);
    }

    @Override // kotlin.s0.w.d.l0.l.b.c
    public C k(kotlin.s0.w.d.l0.l.b.z r8, kotlin.s0.w.d.l0.f.n r9, e0 r10) {
        kotlin.n0.d.o.f(r8, "container");
        kotlin.n0.d.o.f(r9, "proto");
        kotlin.n0.d.o.f(r10, "expectedType");
        return H(r8, r9, kotlin.s0.w.d.l0.l.b.b.f20697h, r10, b.f19669f);
    }

    @Override // kotlin.s0.w.d.l0.e.b.b
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.e.b.b.a p(q r1) {
        return D(r1);
    }
}
