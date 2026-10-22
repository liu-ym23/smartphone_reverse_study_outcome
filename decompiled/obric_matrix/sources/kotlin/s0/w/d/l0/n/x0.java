package kotlin.s0.w.d.l0.n;

/* JADX INFO: loaded from: classes2.dex */
public interface x0 {

    public static final class a implements x0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f21192a = null;

        static {
            f21192a = new a();
        }

        private a() {
        }

        @Override // kotlin.s0.w.d.l0.n.x0
        public void a(kotlin.s0.w.d.l0.c.o1.c r1) {
            kotlin.n0.d.o.f(r1, "annotation");
        }

        @Override // kotlin.s0.w.d.l0.n.x0
        public void b(kotlin.s0.w.d.l0.c.e1 r1, kotlin.s0.w.d.l0.c.f1 r2, e0 r3) {
            kotlin.n0.d.o.f(r1, "typeAlias");
            kotlin.n0.d.o.f(r3, "substitutedArgument");
        }

        @Override // kotlin.s0.w.d.l0.n.x0
        public void c(l1 r1, e0 r2, e0 r3, kotlin.s0.w.d.l0.c.f1 r4) {
            kotlin.n0.d.o.f(r1, "substitutor");
            kotlin.n0.d.o.f(r2, "unsubstitutedArgument");
            kotlin.n0.d.o.f(r3, "argument");
            kotlin.n0.d.o.f(r4, "typeParameter");
        }

        @Override // kotlin.s0.w.d.l0.n.x0
        public void d(kotlin.s0.w.d.l0.c.e1 r1) {
            kotlin.n0.d.o.f(r1, "typeAlias");
        }
    }

    void a(kotlin.s0.w.d.l0.c.o1.c r1);

    void b(kotlin.s0.w.d.l0.c.e1 r1, kotlin.s0.w.d.l0.c.f1 r2, e0 r3);

    void c(l1 r1, e0 r2, e0 r3, kotlin.s0.w.d.l0.c.f1 r4);

    void d(kotlin.s0.w.d.l0.c.e1 r1);
}
