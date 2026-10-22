package kotlin.s0.w.d.l0.l.b;

import java.util.Iterator;
import java.util.Set;
import kotlin.i0.t0;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.l0;
import kotlin.s0.w.d.l0.c.m0;
import kotlin.s0.w.d.l0.c.o0;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f20820c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<kotlin.s0.w.d.l0.g.b> f20821d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f20822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.n0.c.l<a, kotlin.s0.w.d.l0.c.e> f20823b;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.g.b f20824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final g f20825b;

        public a(kotlin.s0.w.d.l0.g.b r2, g r3) {
            kotlin.n0.d.o.f(r2, "classId");
            this.f20824a = r2;
            this.f20825b = r3;
        }

        public final g a() {
            return this.f20825b;
        }

        public final kotlin.s0.w.d.l0.g.b b() {
            return this.f20824a;
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof a) == true) goto L5;
        L7:
            return false;
        L5:
            if (kotlin.n0.d.o.a(this.f20824a, ((a) r2).f20824a) == false) goto L7;
            return true;
        }

        public int hashCode() {
            return this.f20824a.hashCode();
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.n0.d.g r1) {
            this();
        }

        public final Set<kotlin.s0.w.d.l0.g.b> a() {
            return i.b();
        }
    }

    static final class c extends kotlin.n0.d.q implements kotlin.n0.c.l<a, kotlin.s0.w.d.l0.c.e> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ i f20826f;

        c(i r1) {
            this.f20826f = r1;
            super(1);
        }

        public final kotlin.s0.w.d.l0.c.e a(a r2) {
            kotlin.n0.d.o.f(r2, "key");
            return i.a(this.f20826f, r2);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.e invoke(a r1) {
            return a(r1);
        }
    }

    static {
        f20820c = new b(null);
        f20821d = t0.a(kotlin.s0.w.d.l0.g.b.m(kotlin.s0.w.d.l0.b.k.a.f18721d.l()));
    }

    public i(k r2) {
        kotlin.n0.d.o.f(r2, "components");
        this.f20822a = r2;
        this.f20823b = r2.u().i(new c(this));
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.c.e a(i r0, a r1) {
        return r0.c(r1);
    }

    public static final /* synthetic */ Set b() {
        return f20821d;
    }

    private final kotlin.s0.w.d.l0.c.e c(a r13) {
        kotlin.s0.w.d.l0.g.b r0 = r13.b();
        Iterator<kotlin.s0.w.d.l0.c.p1.b> r1 = this.f20822a.k().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        kotlin.s0.w.d.l0.c.e r2 = r1.next().c(r0);
        if (r2 == null) goto L4;
        return r2;
    L9:
        if (f20821d.contains(r0) == false) goto L11;
        return null;
    L11:
        g r14 = r13.a();
        if (r14 != null) goto L16;
        r14 = this.f20822a.e().a(r0);
        if (r14 != null) goto L16;
        return null;
    L16:
        kotlin.s0.w.d.l0.f.z.c r3 = r14.a();
        kotlin.s0.w.d.l0.f.c r10 = r14.b();
        kotlin.s0.w.d.l0.f.z.a r11 = r14.c();
        a1 r15 = r14.d();
        kotlin.s0.w.d.l0.g.b r4 = r0.g();
        if (r4 == null) goto L28;
        kotlin.s0.w.d.l0.c.e r12 = e(this, r4, null, 2, null);
        if ((r12 instanceof kotlin.s0.w.d.l0.l.b.g0.d) == false) goto L21;
        kotlin.s0.w.d.l0.l.b.g0.d r16 = (kotlin.s0.w.d.l0.l.b.g0.d) r12;
    L22:
        if (r16 != null) goto L24;
        return null;
    L24:
        kotlin.s0.w.d.l0.g.f r5 = r0.j();
        kotlin.n0.d.o.e(r5, "classId.shortClassName");
        if (r16.h1(r5) == true) goto L27;
        return null;
    L27:
        m r17 = r16.b1();
    L46:
        return new kotlin.s0.w.d.l0.l.b.g0.d(r17, r10, r3, r11, r15);
    L21:
        r16 = null;
        goto L22
    L28:
        m0 r6 = this.f20822a.r();
        kotlin.s0.w.d.l0.g.c r7 = r0.h();
        kotlin.n0.d.o.e(r7, "classId.packageFqName");
        Iterator<T> r8 = o0.c(r6, r7).iterator();
    L30:
        if (r8.hasNext() == false) goto L40;
        Object r9 = r8.next();
        l0 r18 = (l0) r9;
        if ((r18 instanceof p) == false) goto L37;
        kotlin.s0.w.d.l0.g.f r19 = r0.j();
        kotlin.n0.d.o.e(r19, "classId.shortClassName");
        if (((p) r18).L0(r19) == true) goto L37;
        boolean r20 = false;
    L38:
        if (r20 == false) goto L30;
    L41:
        l0 r21 = (l0) r9;
        if (r21 != null) goto L44;
        return null;
    L44:
        k r22 = this.f20822a;
        kotlin.s0.w.d.l0.f.t r110 = r10.h1();
        kotlin.n0.d.o.e(r110, "classProto.typeTable");
        kotlin.s0.w.d.l0.f.z.g r23 = new kotlin.s0.w.d.l0.f.z.g(r110);
        kotlin.s0.w.d.l0.f.z.h.a r111 = kotlin.s0.w.d.l0.f.z.h.f20249b;
        kotlin.s0.w.d.l0.f.w r24 = r10.j1();
        kotlin.n0.d.o.e(r24, "classProto.versionRequirementTable");
        r17 = r22.a(r21, r3, r23, r111.a(r24), r11, null);
    L37:
        r20 = true;
        goto L38
    L40:
        r9 = null;
        goto L41
    }

    public static /* synthetic */ kotlin.s0.w.d.l0.c.e e(i r0, kotlin.s0.w.d.l0.g.b r1, g r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.d(r1, r2);
    }

    public final kotlin.s0.w.d.l0.c.e d(kotlin.s0.w.d.l0.g.b r2, g r3) {
        kotlin.n0.d.o.f(r2, "classId");
        return this.f20823b.invoke(new a(r2, r3));
    }
}
