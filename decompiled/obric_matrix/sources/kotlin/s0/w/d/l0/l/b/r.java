package kotlin.s0.w.d.l0.l.b;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f20858a = null;

    static class a implements r {
        a() {
        }

        private static /* synthetic */ void c(int r4) {
            Object[] r0 = new Object[3];
            if (r4 == 1) goto L5;
            r0[0] = "descriptor";
        L6:
            r0[1] = "kotlin/reflect/jvm/internal/impl/serialization/deserialization/ErrorReporter$1";
            if (r4 == 2) goto L9;
            r0[2] = "reportIncompleteHierarchy";
        L11:
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r0));
        L9:
            r0[2] = "reportCannotInferVisibility";
            goto L11
        L5:
            r0[0] = "unresolvedSuperClasses";
            goto L6
        }

        @Override // kotlin.s0.w.d.l0.l.b.r
        public void a(kotlin.s0.w.d.l0.c.b r1) {
            if (r1 == null) goto L4;
            return;
        L4:
            c(2);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.l.b.r
        public void b(kotlin.s0.w.d.l0.c.e r1, List<String> r2) {
            if (r1 == null) goto L8;
            if (r2 == null) goto L6;
            return;
        L6:
            c(1);
            throw null;
        L8:
            c(0);
            throw null;
        }
    }

    static {
        f20858a = new a();
    }

    void a(kotlin.s0.w.d.l0.c.b r1);

    void b(kotlin.s0.w.d.l0.c.e r1, List<String> r2);
}
