package kotlin.s0.w.d.l0.e.a.j0;

import java.util.Collections;
import java.util.List;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.e.a.n0.r;
import kotlin.s0.w.d.l0.n.e0;

/* JADX INFO: loaded from: classes2.dex */
public interface j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f19325a = null;

    static class a implements j {
        a() {
        }

        private static /* synthetic */ void c(int r3) {
            Object[] r0 = new Object[3];
            switch(r3) {
                case 1: goto L10;
                case 2: goto L9;
                case 3: goto L8;
                case 4: goto L7;
                case 5: goto L6;
                case 6: goto L5;
                default: goto L4;
            };
        L4:
            r0[0] = "method";
        L11:
            r0[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1";
            if (r3 != 5) goto L14;
        L16:
            r0[2] = "reportSignatureErrors";
        L18:
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r0));
        L14:
            if (r3 == 6) goto L16;
            r0[2] = "resolvePropagatedSignature";
            goto L18
        L5:
            r0[0] = "signatureErrors";
            goto L11
        L6:
            r0[0] = "descriptor";
            goto L11
        L7:
            r0[0] = "typeParameters";
            goto L11
        L8:
            r0[0] = "valueParameters";
            goto L11
        L9:
            r0[0] = "returnType";
            goto L11
        L10:
            r0[0] = "owner";
            goto L11
        }

        @Override // kotlin.s0.w.d.l0.e.a.j0.j
        public b a(r r8, kotlin.s0.w.d.l0.c.e r9, e0 r10, e0 r11, List<j1> r12, List<f1> r13) {
            if (r8 == null) goto L18;
            if (r9 == null) goto L16;
            if (r10 == null) goto L14;
            if (r12 == null) goto L12;
            if (r13 != null) goto L9;
            c(4);
            throw null;
        L9:
            return new b(r10, r11, r12, r13, Collections.emptyList(), false);
        L12:
            c(3);
            throw null;
        L14:
            c(2);
            throw null;
        L16:
            c(1);
            throw null;
        L18:
            c(0);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.e.a.j0.j
        public void b(kotlin.s0.w.d.l0.c.b r1, List<String> r2) {
            if (r1 == null) goto L9;
            if (r2 != null) goto L8;
            c(6);
            throw null;
        L8:
            throw new UnsupportedOperationException("Should not be called");
        L9:
            c(5);
            throw null;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e0 f19326a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final e0 f19327b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<j1> f19328c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<f1> f19329d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List<String> f19330e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f19331f;

        public b(e0 r2, e0 r3, List<j1> r4, List<f1> r5, List<String> r6, boolean r7) {
            if (r2 == null) goto L15;
            if (r4 == null) goto L13;
            if (r5 == null) goto L11;
            if (r6 == null) goto L9;
            this.f19326a = r2;
            this.f19327b = r3;
            this.f19328c = r4;
            this.f19329d = r5;
            this.f19330e = r6;
            this.f19331f = r7;
            return;
        L9:
            a(3);
            throw null;
        L11:
            a(2);
            throw null;
        L13:
            a(1);
            throw null;
        L15:
            a(0);
            throw null;
        }

        private static /* synthetic */ void a(int r10) {
            if (r10 == 4) goto L8;
            if (r10 == 5) goto L8;
            if (r10 == 6) goto L8;
            if (r10 == 7) goto L8;
            String r4 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L10:
            if (r10 == 4) goto L15;
            if (r10 == 5) goto L15;
            if (r10 == 6) goto L15;
            if (r10 == 7) goto L15;
            int r6 = 3;
        L16:
            Object[] r7 = new Object[r6];
            switch(r10) {
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L19;
                case 6: goto L19;
                case 7: goto L19;
                default: goto L18;
            };
        L18:
            r7[0] = "returnType";
        L24:
            if (r10 == 4) goto L32;
            if (r10 == 5) goto L31;
            if (r10 == 6) goto L30;
            if (r10 == 7) goto L29;
            r7[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
        L33:
            if (r10 == 4) goto L38;
            if (r10 == 5) goto L38;
            if (r10 == 6) goto L38;
            if (r10 == 7) goto L38;
            r7[2] = "<init>";
        L38:
            String r5 = String.format(r4, r7);
            if (r10 == 4) goto L45;
            if (r10 == 5) goto L45;
            if (r10 == 6) goto L45;
            if (r10 == 7) goto L45;
            throw new IllegalArgumentException(r5);
        L45:
            throw new IllegalStateException(r5);
        L29:
            r7[1] = "getErrors";
            goto L33
        L30:
            r7[1] = "getTypeParameters";
            goto L33
        L31:
            r7[1] = "getValueParameters";
            goto L33
        L32:
            r7[1] = "getReturnType";
            goto L33
        L19:
            r7[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
            goto L24
        L20:
            r7[0] = "signatureErrors";
            goto L24
        L21:
            r7[0] = "typeParameters";
            goto L24
        L22:
            r7[0] = "valueParameters";
        L15:
            r6 = 2;
        L8:
            r4 = "@NotNull method %s.%s must not return null";
            goto L10
        }

        public List<String> b() {
            List<String> r0 = this.f19330e;
            if (r0 == null) goto L5;
            return r0;
        L5:
            a(7);
            throw null;
        }

        public e0 c() {
            return this.f19327b;
        }

        public e0 d() {
            e0 r0 = this.f19326a;
            if (r0 == null) goto L5;
            return r0;
        L5:
            a(4);
            throw null;
        }

        public List<f1> e() {
            List<f1> r0 = this.f19329d;
            if (r0 == null) goto L5;
            return r0;
        L5:
            a(6);
            throw null;
        }

        public List<j1> f() {
            List<j1> r0 = this.f19328c;
            if (r0 == null) goto L5;
            return r0;
        L5:
            a(5);
            throw null;
        }

        public boolean g() {
            return this.f19331f;
        }
    }

    static {
        f19325a = new a();
    }

    b a(r r1, kotlin.s0.w.d.l0.c.e r2, e0 r3, e0 r4, List<j1> r5, List<f1> r6);

    void b(kotlin.s0.w.d.l0.c.b r1, List<String> r2);
}
