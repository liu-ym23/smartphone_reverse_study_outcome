package kotlin.s0.w.d.l0.e.b;

import java.util.List;
import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.c.k0;
import kotlin.s0.w.d.l0.c.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f19758b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.l.b.k f19759a;

    public static final class a {

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.e.b.e$a$a, reason: collision with other inner class name */
        public static final class C0531a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final e f19760a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final g f19761b;

            public C0531a(e r2, g r3) {
                kotlin.n0.d.o.f(r2, "deserializationComponentsForJava");
                kotlin.n0.d.o.f(r3, "deserializedDescriptorResolver");
                this.f19760a = r2;
                this.f19761b = r3;
            }

            public final e a() {
                return this.f19760a;
            }

            public final g b() {
                return this.f19761b;
            }
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final C0531a a(o r26, o r27, kotlin.s0.w.d.l0.e.a.o r28, String r29, kotlin.s0.w.d.l0.l.b.r r30, kotlin.s0.w.d.l0.e.a.m0.b r31) {
            kotlin.n0.d.o.f(r26, "kotlinClassFinder");
            kotlin.n0.d.o.f(r27, "jvmBuiltInsKotlinClassFinder");
            kotlin.n0.d.o.f(r28, "javaClassFinder");
            kotlin.n0.d.o.f(r29, "moduleName");
            kotlin.n0.d.o.f(r30, "errorReporter");
            kotlin.n0.d.o.f(r31, "javaSourceElementFactory");
            kotlin.s0.w.d.l0.m.f r1 = new kotlin.s0.w.d.l0.m.f("DeserializationComponentsForJava.ModuleData");
            kotlin.s0.w.d.l0.b.q.f r12 = new kotlin.s0.w.d.l0.b.q.f(r1, kotlin.s0.w.d.l0.b.q.f.a.f18802f);
            kotlin.s0.w.d.l0.g.f r0 = kotlin.s0.w.d.l0.g.f.n('<' + r29 + '>');
            kotlin.n0.d.o.e(r0, "special(\"<$moduleName>\")");
            kotlin.s0.w.d.l0.c.q1.x r11 = new kotlin.s0.w.d.l0.c.q1.x(r0, r1, r12, null, null, null, 56, null);
            r12.D0(r11);
            r12.I0(r11, true);
            g r10 = new g();
            kotlin.s0.w.d.l0.e.a.l0.j r8 = new kotlin.s0.w.d.l0.e.a.l0.j();
            k0 r7 = new k0(r1, r11);
            kotlin.s0.w.d.l0.e.a.l0.f r9 = f.c(r28, r11, r1, r7, r26, r10, r30, r31, r8, null, 512, null);
            e r13 = f.a(r11, r1, r7, r9, r26, r10, r30);
            r10.l(r13);
            kotlin.s0.w.d.l0.e.a.j0.g r2 = kotlin.s0.w.d.l0.e.a.j0.g.f19318a;
            kotlin.n0.d.o.e(r2, "EMPTY");
            kotlin.s0.w.d.l0.k.u.c r14 = new kotlin.s0.w.d.l0.k.u.c(r9, r2);
            r8.c(r14);
            kotlin.s0.w.d.l0.b.q.h r17 = new kotlin.s0.w.d.l0.b.q.h(r1, r27, r11, r7, r12.H0(), r12.H0(), kotlin.s0.w.d.l0.l.b.l.a.f20842a, kotlin.s0.w.d.l0.n.t1.l.f21099b.a(), new kotlin.s0.w.d.l0.k.v.b(r1, kotlin.i0.r.g()));
            r11.Z0(new kotlin.s0.w.d.l0.c.q1.x[]{r11});
            r11.T0(new kotlin.s0.w.d.l0.c.q1.i(kotlin.i0.r.j(new p0[]{r14.a(), r17}), "CompositeProvider@RuntimeModuleData for " + r11));
            return new C0531a(r13, r10);
        }
    }

    static {
        f19758b = new a(null);
    }

    public e(kotlin.s0.w.d.l0.m.n r27, h0 r28, kotlin.s0.w.d.l0.l.b.l r29, h r30, c r31, kotlin.s0.w.d.l0.e.a.l0.f r32, k0 r33, kotlin.s0.w.d.l0.l.b.r r34, kotlin.s0.w.d.l0.d.b.c r35, kotlin.s0.w.d.l0.l.b.j r36, kotlin.s0.w.d.l0.n.t1.l r37, kotlin.s0.w.d.l0.n.v1.a r38) {
        kotlin.n0.d.o.f(r27, "storageManager");
        kotlin.n0.d.o.f(r28, "moduleDescriptor");
        kotlin.n0.d.o.f(r29, "configuration");
        kotlin.n0.d.o.f(r30, "classDataFinder");
        kotlin.n0.d.o.f(r31, "annotationAndConstantLoader");
        kotlin.n0.d.o.f(r32, "packageFragmentProvider");
        kotlin.n0.d.o.f(r33, "notFoundClasses");
        kotlin.n0.d.o.f(r34, "errorReporter");
        kotlin.n0.d.o.f(r35, "lookupTracker");
        kotlin.n0.d.o.f(r36, "contractDeserializer");
        kotlin.n0.d.o.f(r37, "kotlinTypeChecker");
        kotlin.n0.d.o.f(r38, "typeAttributeTranslators");
        kotlin.s0.w.d.l0.b.h r0 = r28.o();
        if ((r0 instanceof kotlin.s0.w.d.l0.b.q.f) == false) goto L5;
        kotlin.s0.w.d.l0.b.q.f r1 = (kotlin.s0.w.d.l0.b.q.f) r0;
    L6:
        kotlin.s0.w.d.l0.l.b.v.a r10 = kotlin.s0.w.d.l0.l.b.v.a.f20864a;
        i r11 = i.f19772a;
        List r17 = kotlin.i0.r.g();
        if (r1 == null) goto L11;
        kotlin.s0.w.d.l0.c.p1.a r16 = r1.H0();
        if (r16 == null) goto L11;
    L12:
        kotlin.s0.w.d.l0.c.p1.a r23 = r16;
        if (r1 == null) goto L17;
        kotlin.s0.w.d.l0.c.p1.c r2 = r1.H0();
        if (r2 == null) goto L17;
    L18:
        this.f19759a = new kotlin.s0.w.d.l0.l.b.k(r27, r28, r29, r30, r31, r32, r10, r34, r35, r11, r17, r33, r36, r23, r2, kotlin.s0.w.d.l0.f.a0.b.i.f19890a.a(), r37, new kotlin.s0.w.d.l0.k.v.b(r27, kotlin.i0.r.g()), null, r38.a(), 262144, null);
        return;
    L17:
        r2 = kotlin.s0.w.d.l0.c.p1.c.b.f18948a;
    L11:
        r16 = kotlin.s0.w.d.l0.c.p1.a.C0502a.f18946a;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public final kotlin.s0.w.d.l0.l.b.k a() {
        return this.f19759a;
    }
}
