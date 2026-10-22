package kotlin.s0.w.d.l0.m;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.f0;

/* JADX INFO: loaded from: classes2.dex */
public class f implements kotlin.s0.w.d.l0.m.n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f20911d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final kotlin.s0.w.d.l0.m.n f20912e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final kotlin.s0.w.d.l0.m.k f20913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterfaceC0574f f20914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f20915c;

    static class a extends f {
        a(String r2, InterfaceC0574f r3, kotlin.s0.w.d.l0.m.k r4) {
            super(r2, r3, r4, null);
        }

        private static /* synthetic */ void j(int r7) {
            if (r7 == 1) goto L5;
            String r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L7:
            if (r7 == 1) goto L9;
            int r3 = 3;
        L10:
            Object[] r4 = new Object[r3];
            if (r7 == 1) goto L13;
            r4[0] = "source";
        L15:
            if (r7 == 1) goto L17;
            r4[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
        L18:
            if (r7 == 1) goto L20;
            r4[2] = "recursionDetectedDefault";
        L20:
            String r2 = String.format(r1, r4);
            if (r7 == 1) goto L24;
            throw new IllegalArgumentException(r2);
        L24:
            throw new IllegalStateException(r2);
        L17:
            r4[1] = "recursionDetectedDefault";
            goto L18
        L13:
            r4[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
            goto L15
        L9:
            r3 = 2;
            goto L10
        L5:
            r1 = "@NotNull method %s.%s must not return null";
            goto L7
        }

        @Override // kotlin.s0.w.d.l0.m.f
        protected <K, V> o<V> p(String r1, K r2) {
            if (r1 == null) goto L9;
            o<V> r3 = o.a();
            if (r3 == null) goto L7;
            return r3;
        L7:
            j(1);
            throw null;
        L9:
            j(0);
            throw null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class b<T> extends j<T> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ Object f20916i;

        b(f r1, f r2, kotlin.n0.c.a r3, Object r4) {
            this.f20916i = r4;
            super(r2, r3);
        }

        private static /* synthetic */ void a(int r2) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$4", "recursionDetected"}));
        }

        @Override // kotlin.s0.w.d.l0.m.f.h
        protected o<T> c(boolean r1) {
            o<T> r0 = o.d(this.f20916i);
            if (r0 == null) goto L5;
            return r0;
        L5:
            a(0);
            throw null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class c<T> extends k<T> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.l f20917j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.l f20918k;

        c(f r1, f r2, kotlin.n0.c.a r3, kotlin.n0.c.l r4, kotlin.n0.c.l r5) {
            this.f20917j = r4;
            this.f20918k = r5;
            super(r2, r3);
        }

        private static /* synthetic */ void a(int r6) {
            if (r6 == 2) goto L5;
            String r1 = "@NotNull method %s.%s must not return null";
        L6:
            if (r6 == 2) goto L8;
            int r2 = 2;
        L9:
            Object[] r3 = new Object[r2];
            if (r6 == 2) goto L12;
            r3[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
        L14:
            if (r6 == 2) goto L16;
            r3[1] = "recursionDetected";
        L17:
            if (r6 != 2) goto L20;
            r3[2] = "doPostCompute";
        L20:
            String r4 = String.format(r1, r3);
            if (r6 == 2) goto L24;
            throw new IllegalStateException(r4);
        L24:
            throw new IllegalArgumentException(r4);
        L16:
            r3[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
            goto L17
        L12:
            r3[0] = "value";
            goto L14
        L8:
            r2 = 3;
            goto L9
        L5:
            r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            goto L6
        }

        @Override // kotlin.s0.w.d.l0.m.f.h
        protected o<T> c(boolean r3) {
            kotlin.n0.c.l r0 = this.f20917j;
            if (r0 != null) goto L9;
            o<T> r2 = super.c(r3);
            if (r2 == null) goto L7;
            return r2;
        L7:
            a(0);
            throw null;
        L9:
            o<T> r4 = o.d(r0.invoke(Boolean.valueOf(r3)));
            if (r4 == null) goto L12;
            return r4;
        L12:
            a(1);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.m.f.i
        protected void d(T r1) {
            if (r1 == null) goto L5;
            this.f20918k.invoke(r1);
            return;
        L5:
            a(2);
            throw null;
        }
    }

    private static class d<K, V> extends e<K, V> implements kotlin.s0.w.d.l0.m.a<K, V> {
        static {
        }

        private d(f r2, ConcurrentMap<g<K, V>, Object> r3) {
            a r0 = null;
            if (r2 == null) goto L9;
            if (r3 == null) goto L7;
            super(r2, r3, r0);
            return;
        L7:
            b(1);
            throw null;
        L9:
            b(0);
            throw null;
        }

        /* synthetic */ d(f r1, ConcurrentMap r2, a r3) {
            this(r1, r2);
        }

        private static /* synthetic */ void b(int r8) {
            if (r8 == 3) goto L5;
            String r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L7:
            if (r8 == 3) goto L9;
            int r3 = 3;
        L10:
            Object[] r4 = new Object[r3];
            if (r8 == 1) goto L17;
            if (r8 == 2) goto L16;
            if (r8 == 3) goto L15;
            r4[0] = "storageManager";
        L19:
            if (r8 == 3) goto L21;
            r4[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
        L22:
            if (r8 == 2) goto L25;
            if (r8 == 3) goto L26;
            r4[2] = "<init>";
        L26:
            String r2 = String.format(r1, r4);
            if (r8 == 3) goto L30;
            throw new IllegalArgumentException(r2);
        L30:
            throw new IllegalStateException(r2);
        L25:
            r4[2] = "computeIfAbsent";
            goto L26
        L21:
            r4[1] = "computeIfAbsent";
            goto L22
        L15:
            r4[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            goto L19
        L16:
            r4[0] = "computation";
            goto L19
        L17:
            r4[0] = "map";
            goto L19
        L9:
            r3 = 2;
            goto L10
        L5:
            r1 = "@NotNull method %s.%s must not return null";
            goto L7
        }

        @Override // kotlin.s0.w.d.l0.m.f.e, kotlin.s0.w.d.l0.m.a
        public V a(K r2, kotlin.n0.c.a<? extends V> r3) {
            if (r3 == null) goto L9;
            V r1 = (V) super.a(r2, r3);
            if (r1 == null) goto L7;
            return r1;
        L7:
            b(3);
            throw null;
        L9:
            b(2);
            throw null;
        }
    }

    private static class e<K, V> extends l<g<K, V>, V> implements kotlin.s0.w.d.l0.m.b<K, V> {

        class a implements kotlin.n0.c.l<g<K, V>, V> {
            a() {
            }

            public V a(g<K, V> r1) {
                return (V) g.a(r1).invoke();
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ Object invoke(Object r1) {
                return a((g) r1);
            }
        }

        private e(f r2, ConcurrentMap<g<K, V>, Object> r3) {
            if (r2 == null) goto L9;
            if (r3 == null) goto L7;
            super(r2, r3, new a());
            return;
        L7:
            b(1);
            throw null;
        L9:
            b(0);
            throw null;
        }

        /* synthetic */ e(f r1, ConcurrentMap r2, a r3) {
            this(r1, r2);
        }

        private static /* synthetic */ void b(int r5) {
            Object[] r0 = new Object[3];
            if (r5 == 1) goto L7;
            if (r5 == 2) goto L6;
            r0[0] = "storageManager";
        L8:
            r0[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction";
            if (r5 == 2) goto L11;
            r0[2] = "<init>";
        L13:
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r0));
        L11:
            r0[2] = "computeIfAbsent";
            goto L13
        L6:
            r0[0] = "computation";
            goto L8
        L7:
            r0[0] = "map";
            goto L8
        }

        public V a(K r2, kotlin.n0.c.a<? extends V> r3) {
            if (r3 != null) goto L4;
            b(2);
            throw null;
        L4:
            return invoke(new g(r2, r3));
        }
    }

    /* JADX INFO: renamed from: kotlin.s0.w.d.l0.m.f$f, reason: collision with other inner class name */
    public interface InterfaceC0574f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final InterfaceC0574f f20919a = null;

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.m.f$f$a */
        static class a implements InterfaceC0574f {
            a() {
            }

            private static /* synthetic */ void b(int r2) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"throwable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$ExceptionHandlingStrategy$1", "handleException"}));
            }

            @Override // kotlin.s0.w.d.l0.m.f.InterfaceC0574f
            public RuntimeException a(Throwable r1) {
                if (r1 != null) goto L6;
                b(0);
                throw null;
            L6:
                kotlin.s0.w.d.l0.p.c.b(r1);
                throw null;
            }
        }

        static {
            f20919a = new a();
        }

        RuntimeException a(Throwable r1);
    }

    private static class g<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final K f20920a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final kotlin.n0.c.a<? extends V> f20921b;

        public g(K r1, kotlin.n0.c.a<? extends V> r2) {
            this.f20920a = r1;
            this.f20921b = r2;
        }

        static /* synthetic */ kotlin.n0.c.a a(g r0) {
            return r0.f20921b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L14:
            return false;
        L8:
            if (g.class != r5.getClass()) goto L14;
            if (this.f20920a.equals(((g) r5).f20920a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            return this.f20920a.hashCode();
        }
    }

    private static class h<T> implements kotlin.s0.w.d.l0.m.j<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final f f20922f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final kotlin.n0.c.a<? extends T> f20923g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private volatile Object f20924h;

        public h(f r2, kotlin.n0.c.a<? extends T> r3) {
            if (r2 == null) goto L9;
            if (r3 == null) goto L7;
            this.f20924h = n.f20929f;
            this.f20922f = r2;
            this.f20923g = r3;
            return;
        L7:
            a(1);
            throw null;
        L9:
            a(0);
            throw null;
        }

        private static /* synthetic */ void a(int r8) {
            if (r8 == 2) goto L6;
            if (r8 == 3) goto L6;
            String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L7:
            if (r8 == 2) goto L10;
            if (r8 == 3) goto L10;
            int r3 = 3;
        L11:
            Object[] r4 = new Object[r3];
            if (r8 == 1) goto L17;
            if (r8 == 2) goto L16;
            if (r8 == 3) goto L16;
            r4[0] = "storageManager";
        L18:
            if (r8 == 2) goto L22;
            if (r8 == 3) goto L21;
            r4[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
        L23:
            if (r8 == 2) goto L26;
            if (r8 == 3) goto L26;
            r4[2] = "<init>";
        L26:
            String r5 = String.format(r2, r4);
            if (r8 == 2) goto L31;
            if (r8 == 3) goto L31;
            throw new IllegalArgumentException(r5);
        L31:
            throw new IllegalStateException(r5);
        L21:
            r4[1] = "renderDebugInformation";
            goto L23
        L22:
            r4[1] = "recursionDetected";
        L16:
            r4[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            goto L18
        L17:
            r4[0] = "computable";
        L10:
            r3 = 2;
        L6:
            r2 = "@NotNull method %s.%s must not return null";
            goto L7
        }

        protected void b(T r1) {
        }

        protected o<T> c(boolean r2) {
            o<T> r1 = this.f20922f.p("in a lazy value", null);
            if (r1 == null) goto L5;
            return r1;
        L5:
            a(2);
            throw null;
        }

        public boolean e() {
            if (this.f20924h != n.f20929f) goto L5;
        L7:
            return false;
        L5:
            if (this.f20924h == n.f20930g) goto L7;
            return true;
        }

        @Override // kotlin.n0.c.a
        public T invoke() {
            T r0 = (T) this.f20924h;
            if ((r0 instanceof n) == true) goto L6;
            kotlin.s0.w.d.l0.p.g.f(r0);
            return r0;
        L6:
            this.f20922f.f20913a.b();
            T r1 = (T) this.f20924h;
            if ((r1 instanceof n) == true) goto L12;
            kotlin.s0.w.d.l0.p.g.f(r1);     // Catch: Throwable -> L36
        L10:
            this.f20922f.f20913a.a();
            return r1;
        L12:
            n r2 = n.f20930g;     // Catch: Throwable -> L36
            if (r1 != r2) goto L18;
            this.f20924h = n.f20931h;     // Catch: Throwable -> L36
            o<T> r3 = c(true);     // Catch: Throwable -> L36
            if (r3.c() == true) goto L18;
            r1 = r3.b();     // Catch: Throwable -> L36
        L18:
            if (r1 != n.f20931h) goto L22;
            o<T> r4 = c(false);     // Catch: Throwable -> L36
            if (r4.c() == true) goto L22;
            r1 = r4.b();     // Catch: Throwable -> L36
        L22:
            this.f20924h = r2;     // Catch: Throwable -> L36
            r1 = this.f20923g.invoke();     // Catch: Throwable -> L25
            b(r1);     // Catch: Throwable -> L25
            this.f20924h = r1;     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            if (kotlin.s0.w.d.l0.p.c.a(th) == false) goto L29;
            this.f20924h = n.f20929f;     // Catch: Throwable -> L36
            throw th;     // Catch: Throwable -> L36
        L29:
            if (this.f20924h != n.f20930g) goto L31;
            this.f20924h = kotlin.s0.w.d.l0.p.g.c(th);     // Catch: Throwable -> L36
        L31:
            f.k(this.f20922f).a(th);     // Catch: Throwable -> L36
            throw null;
        L36:
            th = move-exception;
            this.f20922f.f20913a.a();
            throw th;
        }
    }

    private static abstract class i<T> extends h<T> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private volatile kotlin.s0.w.d.l0.m.l<T> f20925i;

        public i(f r2, kotlin.n0.c.a<? extends T> r3) {
            if (r2 == null) goto L9;
            if (r3 == null) goto L7;
            super(r2, r3);
            this.f20925i = null;
            return;
        L7:
            a(1);
            throw null;
        L9:
            a(0);
            throw null;
        }

        private static /* synthetic */ void a(int r3) {
            Object[] r0 = new Object[3];
            if (r3 == 1) goto L5;
            r0[0] = "storageManager";
        L6:
            r0[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValueWithPostCompute";
            r0[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r0));
        L5:
            r0[0] = "computable";
            goto L6
        }

        @Override // kotlin.s0.w.d.l0.m.f.h
        protected final void b(T r2) {
            this.f20925i = new kotlin.s0.w.d.l0.m.l(r2);
            d(r2);     // Catch: Throwable -> L6
            this.f20925i = null;
            return;
        L6:
            th = move-exception;
            this.f20925i = null;
            throw th;
        }

        protected abstract void d(T r1);

        @Override // kotlin.s0.w.d.l0.m.f.h, kotlin.n0.c.a
        public T invoke() {
            kotlin.s0.w.d.l0.m.l<T> r0 = this.f20925i;
            if (r0 == null) goto L9;
            if (r0.b() == false) goto L9;
            return r0.a();
        L9:
            return (T) super.invoke();
        }
    }

    private static class j<T> extends h<T> implements kotlin.s0.w.d.l0.m.i<T> {
        static {
        }

        public j(f r2, kotlin.n0.c.a<? extends T> r3) {
            if (r2 == null) goto L9;
            if (r3 == null) goto L7;
            super(r2, r3);
            return;
        L7:
            a(1);
            throw null;
        L9:
            a(0);
            throw null;
        }

        private static /* synthetic */ void a(int r7) {
            if (r7 == 2) goto L5;
            String r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L6:
            if (r7 == 2) goto L8;
            int r2 = 3;
        L9:
            Object[] r3 = new Object[r2];
            if (r7 == 1) goto L14;
            if (r7 == 2) goto L13;
            r3[0] = "storageManager";
        L15:
            if (r7 == 2) goto L17;
            r3[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
        L18:
            if (r7 == 2) goto L20;
            r3[2] = "<init>";
        L20:
            String r4 = String.format(r1, r3);
            if (r7 == 2) goto L24;
            throw new IllegalArgumentException(r4);
        L24:
            throw new IllegalStateException(r4);
        L17:
            r3[1] = "invoke";
            goto L18
        L13:
            r3[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            goto L15
        L14:
            r3[0] = "computable";
            goto L15
        L8:
            r2 = 2;
            goto L9
        L5:
            r1 = "@NotNull method %s.%s must not return null";
            goto L6
        }

        @Override // kotlin.s0.w.d.l0.m.f.h, kotlin.n0.c.a
        public T invoke() {
            T r0 = (T) super.invoke();
            if (r0 == null) goto L5;
            return r0;
        L5:
            a(2);
            throw null;
        }
    }

    private static abstract class k<T> extends i<T> implements kotlin.s0.w.d.l0.m.i<T> {
        static {
        }

        public k(f r2, kotlin.n0.c.a<? extends T> r3) {
            if (r2 == null) goto L9;
            if (r3 == null) goto L7;
            super(r2, r3);
            return;
        L7:
            a(1);
            throw null;
        L9:
            a(0);
            throw null;
        }

        private static /* synthetic */ void a(int r7) {
            if (r7 == 2) goto L5;
            String r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L6:
            if (r7 == 2) goto L8;
            int r2 = 3;
        L9:
            Object[] r3 = new Object[r2];
            if (r7 == 1) goto L14;
            if (r7 == 2) goto L13;
            r3[0] = "storageManager";
        L15:
            if (r7 == 2) goto L17;
            r3[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
        L18:
            if (r7 == 2) goto L20;
            r3[2] = "<init>";
        L20:
            String r4 = String.format(r1, r3);
            if (r7 == 2) goto L24;
            throw new IllegalArgumentException(r4);
        L24:
            throw new IllegalStateException(r4);
        L17:
            r3[1] = "invoke";
            goto L18
        L13:
            r3[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            goto L15
        L14:
            r3[0] = "computable";
            goto L15
        L8:
            r2 = 2;
            goto L9
        L5:
            r1 = "@NotNull method %s.%s must not return null";
            goto L6
        }

        @Override // kotlin.s0.w.d.l0.m.f.i, kotlin.s0.w.d.l0.m.f.h, kotlin.n0.c.a
        public T invoke() {
            T r0 = (T) super.invoke();
            if (r0 == null) goto L5;
            return r0;
        L5:
            a(2);
            throw null;
        }
    }

    private static class l<K, V> implements kotlin.s0.w.d.l0.m.h<K, V> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final f f20926f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final ConcurrentMap<K, Object> f20927g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final kotlin.n0.c.l<? super K, ? extends V> f20928h;

        public l(f r2, ConcurrentMap<K, Object> r3, kotlin.n0.c.l<? super K, ? extends V> r4) {
            if (r2 == null) goto L12;
            if (r3 == null) goto L10;
            if (r4 == null) goto L8;
            this.f20926f = r2;
            this.f20927g = r3;
            this.f20928h = r4;
            return;
        L8:
            b(2);
            throw null;
        L10:
            b(1);
            throw null;
        L12:
            b(0);
            throw null;
        }

        private static /* synthetic */ void b(int r9) {
            if (r9 == 3) goto L6;
            if (r9 == 4) goto L6;
            String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L8:
            if (r9 == 3) goto L11;
            if (r9 == 4) goto L11;
            int r4 = 3;
        L12:
            Object[] r5 = new Object[r4];
            if (r9 == 1) goto L20;
            if (r9 == 2) goto L19;
            if (r9 == 3) goto L18;
            if (r9 == 4) goto L18;
            r5[0] = "storageManager";
        L21:
            if (r9 == 3) goto L25;
            if (r9 == 4) goto L24;
            r5[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
        L26:
            if (r9 == 3) goto L29;
            if (r9 == 4) goto L29;
            r5[2] = "<init>";
        L29:
            String r3 = String.format(r2, r5);
            if (r9 == 3) goto L34;
            if (r9 == 4) goto L34;
            throw new IllegalArgumentException(r3);
        L34:
            throw new IllegalStateException(r3);
        L24:
            r5[1] = "raceCondition";
            goto L26
        L25:
            r5[1] = "recursionDetected";
        L18:
            r5[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            goto L21
        L19:
            r5[0] = "compute";
            goto L21
        L20:
            r5[0] = "map";
        L11:
            r4 = 2;
        L6:
            r2 = "@NotNull method %s.%s must not return null";
            goto L8
        }

        private AssertionError c(K r4, Object r5) {
            AssertionError r0 = new AssertionError("Race condition detected on input " + r4 + ". Old value is " + r5 + " under " + this.f20926f);
            f.l(r0);
            return r0;
        }

        protected o<V> d(K r1, boolean r2) {
            o<V> r0 = this.f20926f.p("", r1);
            if (r0 == null) goto L5;
            return r0;
        L5:
            b(3);
            throw null;
        }

        @Override // kotlin.n0.c.l
        public V invoke(K r6) {
            Object r0 = this.f20927g.get(r6);
            if (r0 != null) goto L5;
        L8:
            this.f20926f.f20913a.b();
            Object r1 = this.f20927g.get(r6);     // Catch: Throwable -> L48
            n r2 = n.f20930g;     // Catch: Throwable -> L48
            if (r1 != r2) goto L17;
            r1 = n.f20931h;     // Catch: Throwable -> L48
            o<V> r3 = d(r6, true);     // Catch: Throwable -> L48
            if (r3.c() == true) goto L17;
        L13:
            V r7 = r3.b();     // Catch: Throwable -> L48
        L14:
            this.f20926f.f20913a.a();
            return r7;
        L17:
            if (r1 != n.f20931h) goto L21;
            r3 = d(r6, false);     // Catch: Throwable -> L48
            if (r3.c() == false) goto L13;
        L21:
            if (r1 == null) goto L54;
            r7 = (V) kotlin.s0.w.d.l0.p.g.d(r1);
            goto L14
        L54:
            this.f20927g.put(r6, r2);     // Catch: Throwable -> L33
            V r4 = this.f20928h.invoke(r6);     // Catch: Throwable -> L33
            Object r5 = this.f20927g.put(r6, kotlin.s0.w.d.l0.p.g.b(r4));     // Catch: Throwable -> L33
            if (r5 != r2) goto L29;
            this.f20926f.f20913a.a();
            return r4;
        L29:
            AssertionError r8 = c(r6, r5);     // Catch: Throwable -> L33
            throw r8;     // Catch: Throwable -> L31
        L31:
            th = th;
        L36:
            if (kotlin.s0.w.d.l0.p.c.a(th) == true) goto L46;
            if (th == r8) goto L44;
            Object r9 = this.f20927g.put(r6, kotlin.s0.w.d.l0.p.g.c(th));     // Catch: Throwable -> L48
            if (r9 != n.f20930g) goto L41;
            f.k(this.f20926f).a(th);     // Catch: Throwable -> L48
            throw null;
        L41:
            throw c(r6, r9);     // Catch: Throwable -> L48
        L44:
            f.k(this.f20926f).a(th);     // Catch: Throwable -> L48
            throw null;
        L46:
            this.f20927g.remove(r6);     // Catch: Throwable -> L48
            throw th;     // Catch: Throwable -> L48
        L33:
            th = th;
            r8 = null;
        L48:
            th = move-exception;
            this.f20926f.f20913a.a();
            throw th;
        L5:
            if (r0 == n.f20930g) goto L8;
            return (V) kotlin.s0.w.d.l0.p.g.d(r0);
        }

        @Override // kotlin.s0.w.d.l0.m.h
        public boolean k(K r1) {
            Object r0 = this.f20927g.get(r1);
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0 == n.f20930g) goto L7;
            return true;
        }
    }

    private static class m<K, V> extends l<K, V> implements kotlin.s0.w.d.l0.m.g<K, V> {
        static {
        }

        public m(f r2, ConcurrentMap<K, Object> r3, kotlin.n0.c.l<? super K, ? extends V> r4) {
            if (r2 == null) goto L12;
            if (r3 == null) goto L10;
            if (r4 == null) goto L8;
            super(r2, r3, r4);
            return;
        L8:
            b(2);
            throw null;
        L10:
            b(1);
            throw null;
        L12:
            b(0);
            throw null;
        }

        private static /* synthetic */ void b(int r8) {
            if (r8 == 3) goto L5;
            String r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L7:
            if (r8 == 3) goto L9;
            int r3 = 3;
        L10:
            Object[] r4 = new Object[r3];
            if (r8 == 1) goto L17;
            if (r8 == 2) goto L16;
            if (r8 == 3) goto L15;
            r4[0] = "storageManager";
        L18:
            if (r8 == 3) goto L20;
            r4[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
        L21:
            if (r8 == 3) goto L23;
            r4[2] = "<init>";
        L23:
            String r2 = String.format(r1, r4);
            if (r8 == 3) goto L27;
            throw new IllegalArgumentException(r2);
        L27:
            throw new IllegalStateException(r2);
        L20:
            r4[1] = "invoke";
            goto L21
        L15:
            r4[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            goto L18
        L16:
            r4[0] = "compute";
            goto L18
        L17:
            r4[0] = "map";
            goto L18
        L9:
            r3 = 2;
            goto L10
        L5:
            r1 = "@NotNull method %s.%s must not return null";
            goto L7
        }

        @Override // kotlin.s0.w.d.l0.m.f.l, kotlin.n0.c.l
        public V invoke(K r1) {
            V r0 = (V) super.invoke(r1);
            if (r0 == null) goto L5;
            return r0;
        L5:
            b(3);
            throw null;
        }
    }

    private static final enum n extends Enum<n> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final n f20929f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final n f20930g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final n f20931h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ n[] f20932i = null;

        static {
            n r0 = new n("NOT_COMPUTED", 0);
            f20929f = r0;
            n r1 = new n("COMPUTING", 1);
            f20930g = r1;
            n r3 = new n("RECURSION_WAS_DETECTED", 2);
            f20931h = r3;
            f20932i = new n[]{r0, r1, r3};
        }

        private n(String r1, int r2) {
            super(r1, r2);
        }

        public static n valueOf(String r1) {
            return (n) Enum.valueOf(n.class, r1);
        }

        public static n[] values() {
            return (n[]) f20932i.clone();
        }
    }

    private static class o<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final T f20933a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f20934b;

        static {
        }

        private o(T r1, boolean r2) {
            this.f20933a = r1;
            this.f20934b = r2;
        }

        public static <T> o<T> a() {
            return new o(null, true);
        }

        public static <T> o<T> d(T r2) {
            return new o(r2, false);
        }

        public T b() {
            return this.f20933a;
        }

        public boolean c() {
            return this.f20934b;
        }

        public String toString() {
            if (c() == false) goto L6;
            return "FALL_THROUGH";
        L6:
            return String.valueOf(this.f20933a);
        }
    }

    static {
        f20911d = kotlin.u0.k.F0(f.class.getCanonicalName(), ".", "");
        f20912e = new a("NO_LOCKS", InterfaceC0574f.f20919a, kotlin.s0.w.d.l0.m.e.f20910b);
    }

    public f(String r2) {
        this(r2, null, null);
    }

    public f(String r3, Runnable r4, kotlin.n0.c.l<InterruptedException, f0> r5) {
        this(r3, InterfaceC0574f.f20919a, kotlin.s0.w.d.l0.m.k.f20935a.a(r4, r5));
    }

    private f(String r2, InterfaceC0574f r3, kotlin.s0.w.d.l0.m.k r4) {
        if (r2 == null) goto L12;
        if (r3 == null) goto L10;
        if (r4 == null) goto L8;
        this.f20913a = r4;
        this.f20914b = r3;
        this.f20915c = r2;
        return;
    L8:
        j(6);
        throw null;
    L10:
        j(5);
        throw null;
    L12:
        j(4);
        throw null;
    }

    /* synthetic */ f(String r1, InterfaceC0574f r2, kotlin.s0.w.d.l0.m.k r3, a r4) {
        this(r1, r2, r3);
    }

    private static /* synthetic */ void j(int r13) {
        if (r13 == 10) goto L8;
        if (r13 == 13) goto L8;
        if (r13 == 20) goto L8;
        if (r13 == 37) goto L8;
        String r4 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L10:
        if (r13 == 10) goto L15;
        if (r13 == 13) goto L15;
        if (r13 == 20) goto L15;
        if (r13 == 37) goto L15;
        int r7 = 3;
    L16:
        Object[] r8 = new Object[r7];
        if (r13 == 1) goto L34;
        if (r13 == 3) goto L34;
        if (r13 == 5) goto L34;
        if (r13 == 6) goto L33;
        switch(r13) {
            case 8: goto L34;
            case 9: goto L32;
            case 10: goto L31;
            case 11: goto L32;
            case 12: goto L30;
            case 13: goto L31;
            case 14: goto L32;
            case 15: goto L29;
            case 16: goto L32;
            case 17: goto L30;
            case 18: goto L29;
            case 19: goto L32;
            case 20: goto L31;
            case 21: goto L32;
            case 22: goto L29;
            case 23: goto L28;
            case 24: goto L28;
            case 25: goto L30;
            case 26: goto L28;
            case 27: goto L30;
            case 28: goto L28;
            case 29: goto L27;
            case 30: goto L28;
            case 31: goto L28;
            case 32: goto L28;
            case 33: goto L27;
            case 34: goto L28;
            case 35: goto L26;
            case 36: goto L25;
            case 37: goto L31;
            default: goto L24;
        };
    L24:
        r8[0] = "debugText";
    L36:
        if (r13 == 10) goto L43;
        if (r13 == 13) goto L43;
        if (r13 == 20) goto L42;
        if (r13 == 37) goto L41;
        r8[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
    L44:
        switch(r13) {
            case 4: goto L58;
            case 5: goto L58;
            case 6: goto L58;
            case 7: goto L57;
            case 8: goto L57;
            case 9: goto L56;
            case 10: goto L59;
            case 11: goto L56;
            case 12: goto L56;
            case 13: goto L59;
            case 14: goto L56;
            case 15: goto L56;
            case 16: goto L56;
            case 17: goto L56;
            case 18: goto L56;
            case 19: goto L55;
            case 20: goto L59;
            case 21: goto L55;
            case 22: goto L55;
            case 23: goto L54;
            case 24: goto L54;
            case 25: goto L54;
            case 26: goto L53;
            case 27: goto L53;
            case 28: goto L52;
            case 29: goto L52;
            case 30: goto L51;
            case 31: goto L50;
            case 32: goto L49;
            case 33: goto L49;
            case 34: goto L48;
            case 35: goto L47;
            case 36: goto L46;
            case 37: goto L59;
            default: goto L45;
        };
    L45:
        r8[2] = "createWithExceptionHandling";
        goto L59
    L46:
        r8[2] = "sanitizeStackTrace";
        goto L59
    L47:
        r8[2] = "recursionDetectedDefault";
        goto L59
    L48:
        r8[2] = "compute";
        goto L59
    L49:
        r8[2] = "createNullableLazyValueWithPostCompute";
        goto L59
    L50:
        r8[2] = "createRecursionTolerantNullableLazyValue";
        goto L59
    L51:
        r8[2] = "createNullableLazyValue";
        goto L59
    L52:
        r8[2] = "createLazyValueWithPostCompute";
        goto L59
    L53:
        r8[2] = "createRecursionTolerantLazyValue";
        goto L59
    L54:
        r8[2] = "createLazyValue";
        goto L59
    L55:
        r8[2] = "createMemoizedFunctionWithNullableValues";
        goto L59
    L56:
        r8[2] = "createMemoizedFunction";
        goto L59
    L57:
        r8[2] = "replaceExceptionHandling";
        goto L59
    L58:
        r8[2] = "<init>";
    L59:
        String r5 = String.format(r4, r8);
        if (r13 == 10) goto L66;
        if (r13 == 13) goto L66;
        if (r13 == 20) goto L66;
        if (r13 == 37) goto L66;
        throw new IllegalArgumentException(r5);
    L66:
        throw new IllegalStateException(r5);
    L41:
        r8[1] = "sanitizeStackTrace";
        goto L44
    L42:
        r8[1] = "createMemoizedFunctionWithNullableValues";
    L43:
        r8[1] = "createMemoizedFunction";
        goto L44
    L25:
        r8[0] = "throwable";
        goto L36
    L26:
        r8[0] = "source";
        goto L36
    L27:
        r8[0] = "postCompute";
        goto L36
    L28:
        r8[0] = "computable";
        goto L36
    L29:
        r8[0] = "map";
        goto L36
    L30:
        r8[0] = "onRecursiveCall";
        goto L36
    L31:
        r8[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
        goto L36
    L32:
        r8[0] = "compute";
        goto L36
    L33:
        r8[0] = "lock";
    L34:
        r8[0] = "exceptionHandlingStrategy";
    L15:
        r7 = 2;
    L8:
        r4 = "@NotNull method %s.%s must not return null";
        goto L10
    }

    static /* synthetic */ InterfaceC0574f k(f r0) {
        return r0.f20914b;
    }

    static /* synthetic */ Throwable l(Throwable r0) {
        q(r0);
        return r0;
    }

    private static <K> ConcurrentMap<K, Object> m() {
        return new ConcurrentHashMap(3, 1.0f, 2);
    }

    private static <T extends Throwable> T q(T r7) {
        if (r7 == null) goto L15;
        StackTraceElement[] r1 = r7.getStackTrace();
        int r2 = r1.length;
        int r3 = -1;
        int r4 = 0;
    L5:
        if (r4 >= r2) goto L10;
        if (r1[r4].getClassName().startsWith(f20911d) == false) goto L8;
        r4 = r4 + 1;
        goto L5
    L8:
        r3 = r4;
    L10:
        List r5 = Arrays.asList(r1).subList(r3, r2);
        r7.setStackTrace((StackTraceElement[]) r5.toArray(new StackTraceElement[r5.size()]));
        if (r7 == null) goto L13;
        return r7;
    L13:
        j(37);
        throw null;
    L15:
        j(36);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.m.n
    public <K, V> kotlin.s0.w.d.l0.m.b<K, V> a() {
        return new e(this, m(), null);
    }

    @Override // kotlin.s0.w.d.l0.m.n
    public <K, V> kotlin.s0.w.d.l0.m.a<K, V> b() {
        return new d(this, m(), null);
    }

    @Override // kotlin.s0.w.d.l0.m.n
    public <T> kotlin.s0.w.d.l0.m.i<T> c(kotlin.n0.c.a<? extends T> r2, T r3) {
        if (r2 == null) goto L9;
        if (r3 != null) goto L6;
        j(27);
        throw null;
    L6:
        return new b(this, this, r2, r3);
    L9:
        j(26);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.m.n
    public <T> kotlin.s0.w.d.l0.m.i<T> d(kotlin.n0.c.a<? extends T> r2) {
        if (r2 != null) goto L4;
        j(23);
        throw null;
    L4:
        return new j(this, r2);
    }

    @Override // kotlin.s0.w.d.l0.m.n
    public <T> T e(kotlin.n0.c.a<? extends T> r3) {
        if (r3 == null) goto L14;
        this.f20913a.b();
        T r4 = r3.invoke();     // Catch: Throwable -> L8
        this.f20913a.a();
        return r4;
    L8:
        th = move-exception;
        this.f20914b.a(th);     // Catch: Throwable -> L11
        throw null;
    L11:
        th = move-exception;
        this.f20913a.a();
        throw th;
    L14:
        j(34);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.m.n
    public <T> kotlin.s0.w.d.l0.m.j<T> f(kotlin.n0.c.a<? extends T> r2) {
        if (r2 != null) goto L4;
        j(30);
        throw null;
    L4:
        return new h(this, r2);
    }

    @Override // kotlin.s0.w.d.l0.m.n
    public <T> kotlin.s0.w.d.l0.m.i<T> g(kotlin.n0.c.a<? extends T> r8, kotlin.n0.c.l<? super Boolean, ? extends T> r9, kotlin.n0.c.l<? super T, f0> r10) {
        if (r8 == null) goto L9;
        if (r10 != null) goto L6;
        j(29);
        throw null;
    L6:
        return new c(this, this, r8, r9, r10);
    L9:
        j(28);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.m.n
    public <K, V> kotlin.s0.w.d.l0.m.g<K, V> h(kotlin.n0.c.l<? super K, ? extends V> r3) {
        if (r3 == null) goto L9;
        kotlin.s0.w.d.l0.m.g<K, V> r2 = n(r3, m());
        if (r2 == null) goto L7;
        return r2;
    L7:
        j(10);
        throw null;
    L9:
        j(9);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.m.n
    public <K, V> kotlin.s0.w.d.l0.m.h<K, V> i(kotlin.n0.c.l<? super K, ? extends V> r3) {
        if (r3 == null) goto L9;
        kotlin.s0.w.d.l0.m.h<K, V> r2 = o(r3, m());
        if (r2 == null) goto L7;
        return r2;
    L7:
        j(20);
        throw null;
    L9:
        j(19);
        throw null;
    }

    public <K, V> kotlin.s0.w.d.l0.m.g<K, V> n(kotlin.n0.c.l<? super K, ? extends V> r2, ConcurrentMap<K, Object> r3) {
        if (r2 == null) goto L9;
        if (r3 != null) goto L6;
        j(15);
        throw null;
    L6:
        return new m(this, r3, r2);
    L9:
        j(14);
        throw null;
    }

    public <K, V> kotlin.s0.w.d.l0.m.h<K, V> o(kotlin.n0.c.l<? super K, ? extends V> r2, ConcurrentMap<K, Object> r3) {
        if (r2 == null) goto L9;
        if (r3 != null) goto L6;
        j(22);
        throw null;
    L6:
        return new l(this, r3, r2);
    L9:
        j(21);
        throw null;
    }

    protected <K, V> o<V> p(String r4, K r5) {
        if (r4 == null) goto L9;
        StringBuilder r1 = new StringBuilder();
        r1.append("Recursion detected ");
        r1.append(r4);
        if (r5 != null) goto L6;
        String r6 = "";
    L7:
        r1.append(r6);
        r1.append(" under ");
        r1.append(this);
        AssertionError r0 = new AssertionError(r1.toString());
        q(r0);
        throw r0;
    L6:
        r6 = "on input: " + r5;
        goto L7
    L9:
        j(35);
        throw null;
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " (" + this.f20915c + ")";
    }
}
