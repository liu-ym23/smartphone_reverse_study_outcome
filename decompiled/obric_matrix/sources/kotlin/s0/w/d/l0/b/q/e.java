package kotlin.s0.w.d.l0.b.q;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.i0.r;
import kotlin.i0.t0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.l;
import kotlin.s0.w.d.l0.b.k;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.e0;
import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.c.l0;
import kotlin.s0.w.d.l0.c.m;
import kotlin.s0.w.d.l0.m.n;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements kotlin.s0.w.d.l0.c.p1.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f18787d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final /* synthetic */ l<Object>[] f18788e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final kotlin.s0.w.d.l0.g.c f18789f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final kotlin.s0.w.d.l0.g.f f18790g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final kotlin.s0.w.d.l0.g.b f18791h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h0 f18792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.n0.c.l<h0, m> f18793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.i f18794c;

    static final class a extends q implements kotlin.n0.c.l<h0, kotlin.s0.w.d.l0.b.b> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f18795f = null;

        static {
            f18795f = new a();
        }

        a() {
            super(1);
        }

        public final kotlin.s0.w.d.l0.b.b a(h0 r3) {
            o.f(r3, "module");
            List<l0> r2 = r3.N(e.g()).G();
            ArrayList r4 = new ArrayList();
            Iterator<T> r5 = r2.iterator();
        L4:
            if (r5.hasNext() == false) goto L9;
            Object r0 = r5.next();
            if ((r0 instanceof kotlin.s0.w.d.l0.b.b) == false) goto L4;
            r4.add(r0);
            goto L4
        L9:
            return (kotlin.s0.w.d.l0.b.b) r.P(r4);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.b.b invoke(h0 r1) {
            return a(r1);
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.n0.d.g r1) {
            this();
        }

        public final kotlin.s0.w.d.l0.g.b a() {
            return e.d();
        }
    }

    static final class c extends q implements kotlin.n0.c.a<kotlin.s0.w.d.l0.c.q1.h> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f18796f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ n f18797g;

        c(e r1, n r2) {
            this.f18796f = r1;
            this.f18797g = r2;
            super(0);
        }

        public final kotlin.s0.w.d.l0.c.q1.h a() {
            kotlin.s0.w.d.l0.c.q1.h r9 = new kotlin.s0.w.d.l0.c.q1.h((m) e.f(this.f18796f).invoke(e.h(this.f18796f)), e.e(), e0.f18863j, kotlin.s0.w.d.l0.c.f.f18866g, r.d(e.h(this.f18796f).o().i()), a1.f18847a, false, this.f18797g);
            r9.L0(new kotlin.s0.w.d.l0.b.q.a(this.f18797g, r9), t0.b(), null);
            return r9;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.q1.h invoke() {
            return a();
        }
    }

    static {
        f18788e = new l[]{kotlin.n0.d.e0.g(new y(kotlin.n0.d.e0.b(e.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;"))};
        f18787d = new b(null);
        f18789f = k.f18715k;
        kotlin.s0.w.d.l0.g.d r0 = k.a.f18721d;
        kotlin.s0.w.d.l0.g.f r1 = r0.i();
        o.e(r1, "cloneable.shortName()");
        f18790g = r1;
        kotlin.s0.w.d.l0.g.b r2 = kotlin.s0.w.d.l0.g.b.m(r0.l());
        o.e(r2, "topLevel(StandardNames.FqNames.cloneable.toSafe())");
        f18791h = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(n r2, h0 r3, kotlin.n0.c.l<? super h0, ? extends m> r4) {
        o.f(r2, "storageManager");
        o.f(r3, "moduleDescriptor");
        o.f(r4, "computeContainingDeclaration");
        this.f18792a = r3;
        this.f18793b = r4;
        this.f18794c = r2.d(new c(this, r2));
    }

    public /* synthetic */ e(n r1, h0 r2, kotlin.n0.c.l r3, int r4, kotlin.n0.d.g r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = a.f18795f;
    L5:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.g.b d() {
        return f18791h;
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.g.f e() {
        return f18790g;
    }

    public static final /* synthetic */ kotlin.n0.c.l f(e r0) {
        return r0.f18793b;
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.g.c g() {
        return f18789f;
    }

    public static final /* synthetic */ h0 h(e r0) {
        return r0.f18792a;
    }

    private final kotlin.s0.w.d.l0.c.q1.h i() {
        return (kotlin.s0.w.d.l0.c.q1.h) kotlin.s0.w.d.l0.m.m.a(this.f18794c, this, f18788e[0]);
    }

    @Override // kotlin.s0.w.d.l0.c.p1.b
    public Collection<kotlin.s0.w.d.l0.c.e> a(kotlin.s0.w.d.l0.g.c r2) {
        o.f(r2, "packageFqName");
        if (o.a(r2, f18789f) == false) goto L6;
        return t0.a(i());
    L6:
        return t0.b();
    }

    @Override // kotlin.s0.w.d.l0.c.p1.b
    public boolean b(kotlin.s0.w.d.l0.g.c r1, kotlin.s0.w.d.l0.g.f r2) {
        o.f(r1, "packageFqName");
        o.f(r2, "name");
        if (o.a(r2, f18790g) == true) goto L5;
    L7:
        return false;
    L5:
        if (o.a(r1, f18789f) == false) goto L7;
        return true;
    }

    @Override // kotlin.s0.w.d.l0.c.p1.b
    public kotlin.s0.w.d.l0.c.e c(kotlin.s0.w.d.l0.g.b r2) {
        o.f(r2, "classId");
        if (o.a(r2, f18791h) == true) goto L7;
        return null;
    L7:
        return i();
    }
}
