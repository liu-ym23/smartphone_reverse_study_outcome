package kotlin.s0.w.d.l0.p;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f21294a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f21295b = false;

    static class a {
        a() {
        }

        public String toString() {
            return "NULL_VALUE";
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Throwable f21296a;

        private b(Throwable r1) {
            if (r1 == null) goto L5;
            this.f21296a = r1;
            return;
        L5:
            a(0);
            throw null;
        }

        /* synthetic */ b(Throwable r1, a r2) {
            this(r1);
        }

        private static /* synthetic */ void a(int r7) {
            if (r7 == 1) goto L5;
            String r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L7:
            if (r7 == 1) goto L9;
            int r3 = 3;
        L10:
            Object[] r4 = new Object[r3];
            if (r7 == 1) goto L13;
            r4[0] = "throwable";
        L14:
            if (r7 == 1) goto L16;
            r4[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
        L17:
            if (r7 == 1) goto L19;
            r4[2] = "<init>";
        L19:
            String r2 = String.format(r1, r4);
            if (r7 == 1) goto L23;
            throw new IllegalArgumentException(r2);
        L23:
            throw new IllegalStateException(r2);
        L16:
            r4[1] = "getThrowable";
            goto L17
        L13:
            r4[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
            goto L14
        L9:
            r3 = 2;
            goto L10
        L5:
            r1 = "@NotNull method %s.%s must not return null";
            goto L7
        }

        public Throwable b() {
            Throwable r0 = this.f21296a;
            if (r0 == null) goto L5;
            return r0;
        L5:
            a(1);
            throw null;
        }

        public String toString() {
            return this.f21296a.toString();
        }
    }

    public static class c extends RuntimeException {
        public c(Throwable r2) {
            super("Rethrow stored exception", r2);
        }
    }

    static {
        f21294a = new a();
    }

    private static /* synthetic */ void a(int r8) {
        if (r8 == 1) goto L6;
        if (r8 == 2) goto L6;
        String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r8 == 1) goto L11;
        if (r8 == 2) goto L11;
        int r4 = 3;
    L12:
        Object[] r5 = new Object[r4];
        if (r8 == 1) goto L18;
        if (r8 == 2) goto L18;
        if (r8 == 3) goto L17;
        r5[0] = "value";
    L19:
        if (r8 == 1) goto L22;
        if (r8 == 2) goto L22;
        r5[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
    L23:
        if (r8 == 1) goto L31;
        if (r8 == 2) goto L31;
        if (r8 != 3) goto L27;
        r5[2] = "escapeThrowable";
        goto L31
    L27:
        if (r8 == 4) goto L29;
        r5[2] = "unescapeNull";
        goto L31
    L29:
        r5[2] = "unescapeExceptionOrNull";
    L31:
        String r3 = String.format(r2, r5);
        if (r8 == 1) goto L36;
        if (r8 == 2) goto L36;
        throw new IllegalArgumentException(r3);
    L36:
        throw new IllegalStateException(r3);
    L22:
        r5[1] = "escapeNull";
        goto L23
    L17:
        r5[0] = "throwable";
    L18:
        r5[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
    L11:
        r4 = 2;
    L6:
        r2 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    public static <V> Object b(V r1) {
        if (r1 != null) goto L9;
        Object r2 = f21294a;
        if (r2 == null) goto L7;
        return r2;
    L7:
        a(1);
        throw null;
    L9:
        if (r1 == null) goto L11;
        return r1;
    L11:
        a(2);
        throw null;
    }

    public static Object c(Throwable r2) {
        a r0 = null;
        if (r2 != null) goto L5;
        a(3);
        throw null;
    L5:
        return new b(r2, r0);
    }

    public static <V> V d(Object r0) {
        if (r0 == null) goto L5;
        f(r0);
        return (V) e(r0);
    L5:
        a(4);
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <V> V e(Object r2) {
        if (r2 != 0) goto L5;
        a(0);
        throw null;
    L5:
        if (r2 != f21294a) goto L7;
        return null;
    L7:
        return r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <V> V f(Object r1) {
        if ((r1 instanceof b) == false) goto L12;
        Throwable r2 = ((b) r1).b();
        if (f21295b == true) goto L7;
    L10:
        kotlin.s0.w.d.l0.p.c.b(r2);
        throw null;
    L7:
        if (kotlin.s0.w.d.l0.p.c.a(r2) == false) goto L10;
        throw new c(r2);
    L12:
        return r1;
    }
}
