package kotlin.s0.w.d.l0.c.s1.b;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f19104a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f19105b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f19106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f19107b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Method f19108c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Method f19109d;

        public a(Method r1, Method r2, Method r3, Method r4) {
            this.f19106a = r1;
            this.f19107b = r2;
            this.f19108c = r3;
            this.f19109d = r4;
        }

        public final Method a() {
            return this.f19107b;
        }

        public final Method b() {
            return this.f19109d;
        }

        public final Method c() {
            return this.f19108c;
        }

        public final Method d() {
            return this.f19106a;
        }
    }

    static {
        f19104a = new b();
    }

    private b() {
    }

    private final a a() {
        return new a(Class.class.getMethod("isSealed", new Class[0]), Class.class.getMethod("getPermittedSubclasses", new Class[0]), Class.class.getMethod("isRecord", new Class[0]), Class.class.getMethod("getRecordComponents", new Class[0]));
    L6:
        return new a(null, null, null, null);
    }

    private final a b() {
        a r0 = f19105b;
        if (r0 != null) goto L6;
        a r1 = a();
        f19105b = r1;
        return r1;
    L6:
        return r0;
    }

    public final Class<?>[] c(Class<?> r2) {
        kotlin.n0.d.o.f(r2, "clazz");
        Method r1 = b().a();
        if (r1 != null) goto L6;
        return null;
    L6:
        Object r3 = r1.invoke(r2, new Object[0]);
        kotlin.n0.d.o.d(r3, "null cannot be cast to non-null type kotlin.Array<java.lang.Class<*>>");
        return (Class[]) r3;
    }

    public final Object[] d(Class<?> r2) {
        kotlin.n0.d.o.f(r2, "clazz");
        Method r1 = b().b();
        if (r1 != null) goto L7;
        return null;
    L7:
        return (Object[]) r1.invoke(r2, new Object[0]);
    }

    public final Boolean e(Class<?> r2) {
        kotlin.n0.d.o.f(r2, "clazz");
        Method r1 = b().c();
        if (r1 != null) goto L6;
        return null;
    L6:
        Object r3 = r1.invoke(r2, new Object[0]);
        kotlin.n0.d.o.d(r3, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean) r3;
    }

    public final Boolean f(Class<?> r2) {
        kotlin.n0.d.o.f(r2, "clazz");
        Method r1 = b().d();
        if (r1 != null) goto L6;
        return null;
    L6:
        Object r3 = r1.invoke(r2, new Object[0]);
        kotlin.n0.d.o.d(r3, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean) r3;
    }
}
