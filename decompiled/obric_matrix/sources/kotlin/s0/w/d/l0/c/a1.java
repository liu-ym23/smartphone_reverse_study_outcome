package kotlin.s0.w.d.l0.c;

/* JADX INFO: loaded from: classes2.dex */
public interface a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a1 f18847a = null;

    static class a implements a1 {
        a() {
        }

        private static /* synthetic */ void d(int r2) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/SourceElement$1", "getContainingFile"}));
        }

        @Override // kotlin.s0.w.d.l0.c.a1
        public b1 a() {
            b1 r0 = b1.f18854a;
            if (r0 == null) goto L5;
            return r0;
        L5:
            d(0);
            throw null;
        }

        public String toString() {
            return "NO_SOURCE";
        }
    }

    static {
        f18847a = new a();
    }

    b1 a();
}
