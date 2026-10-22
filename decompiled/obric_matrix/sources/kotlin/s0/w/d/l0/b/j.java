package kotlin.s0.w.d.l0.b;

import java.util.List;
import kotlin.i0.r;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.c.k0;
import kotlin.s0.w.d.l0.c.x;
import kotlin.s0.w.d.l0.n.a1;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.f0;
import kotlin.s0.w.d.l0.n.s0;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f18698d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final /* synthetic */ kotlin.s0.l<Object>[] f18699e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k0 f18700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.h f18701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f18702c;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f18703a;

        public a(int r1) {
            this.f18703a = r1;
        }

        public final kotlin.s0.w.d.l0.c.e a(j r2, kotlin.s0.l<?> r3) {
            kotlin.n0.d.o.f(r2, "types");
            kotlin.n0.d.o.f(r3, "property");
            return j.a(r2, kotlin.s0.w.d.l0.o.u.a.a(r3.getName()), this.f18703a);
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.n0.d.g r1) {
            this();
        }

        public final e0 a(h0 r4) {
            kotlin.n0.d.o.f(r4, "module");
            kotlin.s0.w.d.l0.c.e r3 = x.a(r4, k.a.T);
            if (r3 != null) goto L6;
            return null;
        L6:
            a1 r5 = a1.f20943g.h();
            List<f1> r1 = r3.k().getParameters();
            kotlin.n0.d.o.e(r1, "kPropertyClass.typeConstructor.parameters");
            Object r2 = r.o0(r1);
            kotlin.n0.d.o.e(r2, "kPropertyClass.typeConstructor.parameters.single()");
            return f0.g(r5, r3, r.d(new s0((f1) r2)));
        }
    }

    static final class c extends q implements kotlin.n0.c.a<kotlin.s0.w.d.l0.k.w.h> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ h0 f18704f;

        c(h0 r1) {
            this.f18704f = r1;
            super(0);
        }

        public final kotlin.s0.w.d.l0.k.w.h a() {
            return this.f18704f.N(k.f18712h).q();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.k.w.h invoke() {
            return a();
        }
    }

    static {
        f18699e = new kotlin.s0.l[]{kotlin.n0.d.e0.g(new y(kotlin.n0.d.e0.b(j.class), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), kotlin.n0.d.e0.g(new y(kotlin.n0.d.e0.b(j.class), "kProperty", "getKProperty()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), kotlin.n0.d.e0.g(new y(kotlin.n0.d.e0.b(j.class), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), kotlin.n0.d.e0.g(new y(kotlin.n0.d.e0.b(j.class), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), kotlin.n0.d.e0.g(new y(kotlin.n0.d.e0.b(j.class), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), kotlin.n0.d.e0.g(new y(kotlin.n0.d.e0.b(j.class), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), kotlin.n0.d.e0.g(new y(kotlin.n0.d.e0.b(j.class), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), kotlin.n0.d.e0.g(new y(kotlin.n0.d.e0.b(j.class), "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"))};
        f18698d = new b(null);
    }

    public j(h0 r2, k0 r3) {
        kotlin.n0.d.o.f(r2, "module");
        kotlin.n0.d.o.f(r3, "notFoundClasses");
        this.f18700a = r3;
        this.f18701b = kotlin.i.a(kotlin.l.f18418g, new c(r2));
        this.f18702c = new a(1);
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.c.e a(j r0, String r1, int r2) {
        return r0.b(r1, r2);
    }

    private final kotlin.s0.w.d.l0.c.e b(String r3, int r4) {
        kotlin.s0.w.d.l0.g.f r5 = kotlin.s0.w.d.l0.g.f.k(r3);
        kotlin.n0.d.o.e(r5, "identifier(className)");
        kotlin.s0.w.d.l0.c.h r0 = d().f(r5, kotlin.s0.w.d.l0.d.b.d.m);
        if ((r0 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L5;
        kotlin.s0.w.d.l0.c.e r1 = (kotlin.s0.w.d.l0.c.e) r0;
    L6:
        if (r1 == null) goto L8;
        return r1;
    L8:
        return this.f18700a.d(new kotlin.s0.w.d.l0.g.b(k.f18712h, r5), r.d(Integer.valueOf(r4)));
    L5:
        r1 = null;
        goto L6
    }

    private final kotlin.s0.w.d.l0.k.w.h d() {
        return (kotlin.s0.w.d.l0.k.w.h) this.f18701b.getValue();
    }

    public final kotlin.s0.w.d.l0.c.e c() {
        return this.f18702c.a(this, f18699e[0]);
    }
}
