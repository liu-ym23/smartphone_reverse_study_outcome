package kotlin.s0.w.d;

import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes2.dex */
public class c0 {

    public static class a<T> extends c<T> implements kotlin.n0.c.a<T> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final kotlin.n0.c.a<T> f18503g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private volatile SoftReference<Object> f18504h;

        public a(T r2, kotlin.n0.c.a<T> r3) {
            if (r3 == null) goto L8;
            this.f18504h = null;
            this.f18503g = r3;
            if (r2 == null) goto L10;
            this.f18504h = new SoftReference(a(r2));
            return;
        L10:
            return;
        L8:
            d(0);
            throw null;
        }

        private static /* synthetic */ void d(int r2) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal", "<init>"}));
        }

        @Override // kotlin.s0.w.d.c0.c, kotlin.n0.c.a
        public T invoke() {
            SoftReference<Object> r0 = this.f18504h;
            if (r0 == null) goto L8;
            Object r1 = r0.get();
            if (r1 == null) goto L8;
            return c(r1);
        L8:
            T r2 = this.f18503g.invoke();
            this.f18504h = new SoftReference(a(r2));
            return r2;
        }
    }

    public static class b<T> extends c<T> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final kotlin.n0.c.a<T> f18505g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private volatile Object f18506h;

        public b(kotlin.n0.c.a<T> r2) {
            if (r2 == null) goto L6;
            this.f18506h = null;
            this.f18505g = r2;
            return;
        L6:
            d(0);
            throw null;
        }

        private static /* synthetic */ void d(int r2) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazyVal", "<init>"}));
        }

        @Override // kotlin.s0.w.d.c0.c, kotlin.n0.c.a
        public T invoke() {
            Object r0 = this.f18506h;
            if (r0 != null) goto L5;
            T r1 = this.f18505g.invoke();
            this.f18506h = a(r1);
            return r1;
        L5:
            return c(r0);
        }
    }

    public static abstract class c<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final Object f18507f = null;

        static class a {
            a() {
            }
        }

        static {
            f18507f = new a();
        }

        public c() {
        }

        protected Object a(T r1) {
            if (r1 == null) goto L4;
            return r1;
        L4:
            return f18507f;
        }

        public final T b(Object r1, Object r2) {
            return invoke();
        }

        /* JADX WARN: Multi-variable type inference failed */
        protected T c(Object r1) {
            if (r1 != f18507f) goto L6;
            return null;
        L6:
            return r1;
        }

        public abstract T invoke();
    }

    private static /* synthetic */ void a(int r3) {
        Object[] r0 = new Object[3];
        r0[0] = "initializer";
        r0[1] = "kotlin/reflect/jvm/internal/ReflectProperties";
        if (r3 == 1) goto L6;
        if (r3 == 2) goto L6;
        r0[2] = "lazy";
    L8:
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r0));
    L6:
        r0[2] = "lazySoft";
        goto L8
    }

    public static <T> b<T> b(kotlin.n0.c.a<T> r1) {
        if (r1 != null) goto L4;
        a(0);
        throw null;
    L4:
        return new b(r1);
    }

    public static <T> a<T> c(T r1, kotlin.n0.c.a<T> r2) {
        if (r2 != null) goto L4;
        a(1);
        throw null;
    L4:
        return new a(r1, r2);
    }

    public static <T> a<T> d(kotlin.n0.c.a<T> r1) {
        if (r1 != null) goto L5;
        a(2);
        throw null;
    L5:
        return c(null, r1);
    }
}
