package kotlin.s0.w.d.l0.e.a.j0;

import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.z0;
import kotlin.s0.w.d.l0.e.a.n0.l;
import kotlin.s0.w.d.l0.e.a.n0.n;
import kotlin.s0.w.d.l0.e.a.n0.q;

/* JADX INFO: loaded from: classes2.dex */
public interface g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f19318a = null;

    static class a implements g {
        a() {
        }

        private static /* synthetic */ void f(int r3) {
            Object[] r0 = new Object[3];
            switch(r3) {
                case 1: goto L9;
                case 2: goto L8;
                case 3: goto L7;
                case 4: goto L8;
                case 5: goto L6;
                case 6: goto L8;
                case 7: goto L5;
                case 8: goto L8;
                default: goto L4;
            };
        L4:
            r0[0] = "fqName";
        L10:
            r0[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1";
            switch(r3) {
                case 1: goto L16;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L13;
                default: goto L12;
            };
        L12:
            r0[2] = "getClassResolvedFromSource";
        L18:
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r0));
        L13:
            r0[2] = "recordClass";
            goto L18
        L14:
            r0[2] = "recordField";
            goto L18
        L15:
            r0[2] = "recordConstructor";
            goto L18
        L16:
            r0[2] = "recordMethod";
            goto L18
        L5:
            r0[0] = "javaClass";
            goto L10
        L6:
            r0[0] = "field";
            goto L10
        L7:
            r0[0] = "element";
            goto L10
        L8:
            r0[0] = "descriptor";
            goto L10
        L9:
            r0[0] = "member";
            goto L10
        }

        @Override // kotlin.s0.w.d.l0.e.a.j0.g
        public kotlin.s0.w.d.l0.c.e a(kotlin.s0.w.d.l0.g.c r1) {
            if (r1 == null) goto L5;
            return null;
        L5:
            f(0);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.e.a.j0.g
        public void b(l r1, kotlin.s0.w.d.l0.c.l r2) {
            if (r1 == null) goto L8;
            if (r2 == null) goto L6;
            return;
        L6:
            f(4);
            throw null;
        L8:
            f(3);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.e.a.j0.g
        public void c(kotlin.s0.w.d.l0.e.a.n0.g r1, kotlin.s0.w.d.l0.c.e r2) {
            if (r1 == null) goto L8;
            if (r2 == null) goto L6;
            return;
        L6:
            f(8);
            throw null;
        L8:
            f(7);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.e.a.j0.g
        public void d(n r1, u0 r2) {
            if (r1 == null) goto L8;
            if (r2 == null) goto L6;
            return;
        L6:
            f(6);
            throw null;
        L8:
            f(5);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.e.a.j0.g
        public void e(q r1, z0 r2) {
            if (r1 == null) goto L8;
            if (r2 == null) goto L6;
            return;
        L6:
            f(2);
            throw null;
        L8:
            f(1);
            throw null;
        }
    }

    static {
        f19318a = new a();
    }

    kotlin.s0.w.d.l0.c.e a(kotlin.s0.w.d.l0.g.c r1);

    void b(l r1, kotlin.s0.w.d.l0.c.l r2);

    void c(kotlin.s0.w.d.l0.e.a.n0.g r1, kotlin.s0.w.d.l0.c.e r2);

    void d(n r1, u0 r2);

    void e(q r1, z0 r2);
}
