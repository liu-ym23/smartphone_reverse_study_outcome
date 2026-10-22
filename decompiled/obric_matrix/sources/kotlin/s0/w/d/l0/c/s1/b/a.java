package kotlin.s0.w.d.l0.c.s1.b;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f19099a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static C0506a f19100b;

    /* JADX INFO: renamed from: kotlin.s0.w.d.l0.c.s1.b.a$a, reason: collision with other inner class name */
    public static final class C0506a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f19101a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f19102b;

        public C0506a(Method r1, Method r2) {
            this.f19101a = r1;
            this.f19102b = r2;
        }

        public final Method a() {
            return this.f19102b;
        }

        public final Method b() {
            return this.f19101a;
        }
    }

    static {
        f19099a = new a();
    }

    private a() {
    }

    private final C0506a a(Object r4) {
        Class<?> r3 = r4.getClass();
        return new C0506a(r3.getMethod("getType", new Class[0]), r3.getMethod("getAccessor", new Class[0]));
    L6:
        return new C0506a(null, null);
    }

    private final C0506a b(Object r2) {
        C0506a r0 = f19100b;
        if (r0 != null) goto L6;
        C0506a r1 = a(r2);
        f19100b = r1;
        return r1;
    L6:
        return r0;
    }

    public final Method c(Object r2) {
        kotlin.n0.d.o.f(r2, "recordComponent");
        Method r1 = b(r2).a();
        if (r1 != null) goto L6;
        return null;
    L6:
        Object r3 = r1.invoke(r2, new Object[0]);
        kotlin.n0.d.o.d(r3, "null cannot be cast to non-null type java.lang.reflect.Method");
        return (Method) r3;
    }

    public final Class<?> d(Object r2) {
        kotlin.n0.d.o.f(r2, "recordComponent");
        Method r1 = b(r2).b();
        if (r1 != null) goto L6;
        return null;
    L6:
        Object r3 = r1.invoke(r2, new Object[0]);
        kotlin.n0.d.o.d(r3, "null cannot be cast to non-null type java.lang.Class<*>");
        return (Class) r3;
    }
}
