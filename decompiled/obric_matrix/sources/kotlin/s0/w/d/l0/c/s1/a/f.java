package kotlin.s0.w.d.l0.c.s1.a;

import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.e.b.q;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f19086c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<?> f19087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.e.b.c0.a f19088b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final f a(Class<?> r3) {
            o.f(r3, "klass");
            kotlin.s0.w.d.l0.e.b.c0.b r2 = new kotlin.s0.w.d.l0.e.b.c0.b();
            c.f19084a.b(r3, r2);
            kotlin.s0.w.d.l0.e.b.c0.a r4 = r2.m();
            kotlin.n0.d.g r1 = null;
            if (r4 != null) goto L6;
            return null;
        L6:
            return new f(r3, r4, r1);
        }
    }

    static {
        f19086c = new a(null);
    }

    private f(Class<?> r1, kotlin.s0.w.d.l0.e.b.c0.a r2) {
        this.f19087a = r1;
        this.f19088b = r2;
    }

    public /* synthetic */ f(Class r1, kotlin.s0.w.d.l0.e.b.c0.a r2, kotlin.n0.d.g r3) {
        this(r1, r2);
    }

    @Override // kotlin.s0.w.d.l0.e.b.q
    public kotlin.s0.w.d.l0.e.b.c0.a a() {
        return this.f19088b;
    }

    @Override // kotlin.s0.w.d.l0.e.b.q
    public void b(q.c r1, byte[] r2) {
        o.f(r1, "visitor");
        c.f19084a.b(this.f19087a, r1);
    }

    @Override // kotlin.s0.w.d.l0.e.b.q
    public void c(q.d r1, byte[] r2) {
        o.f(r1, "visitor");
        c.f19084a.i(this.f19087a, r1);
    }

    public final Class<?> d() {
        return this.f19087a;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof f) == true) goto L5;
    L7:
        return false;
    L5:
        if (o.a(this.f19087a, ((f) r2).f19087a) == false) goto L7;
        return true;
    }

    @Override // kotlin.s0.w.d.l0.e.b.q
    public kotlin.s0.w.d.l0.g.b f() {
        return kotlin.s0.w.d.l0.c.s1.b.d.a(this.f19087a);
    }

    @Override // kotlin.s0.w.d.l0.e.b.q
    public String getLocation() {
        StringBuilder r0 = new StringBuilder();
        String r1 = this.f19087a.getName();
        o.e(r1, "klass.name");
        r0.append(kotlin.u0.k.v(r1, '.', '/', false, 4, null));
        r0.append(".class");
        return r0.toString();
    }

    public int hashCode() {
        return this.f19087a.hashCode();
    }

    public String toString() {
        return f.class.getName() + ": " + this.f19087a;
    }
}
