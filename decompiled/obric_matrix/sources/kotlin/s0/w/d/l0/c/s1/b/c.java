package kotlin.s0.w.d.l0.c.s1.b;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f19114a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f19115b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f19116a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f19117b;

        public a(Method r1, Method r2) {
            this.f19116a = r1;
            this.f19117b = r2;
        }

        public final Method a() {
            return this.f19117b;
        }

        public final Method b() {
            return this.f19116a;
        }
    }

    static {
        f19114a = new c();
    }

    private c() {
    }

    public final a a(Member r4) {
        kotlin.n0.d.o.f(r4, "member");
        Class<?> r3 = r4.getClass();
        Method r5 = r3.getMethod("getParameters", new Class[0]);     // Catch: NoSuchMethodException -> L6
        return new a(r5, d.e(r3).loadClass("java.lang.reflect.Parameter").getMethod("getName", new Class[0]));
    L7:
        return new a(null, null);
    }

    public final List<String> b(Member r7) {
        kotlin.n0.d.o.f(r7, "member");
        a r0 = f19115b;
        if (r0 != null) goto L15;
        monitor-enter(this);
        c r1 = f19114a;     // Catch: Throwable -> L12
        a r2 = f19115b;     // Catch: Throwable -> L12
        if (r2 != null) goto L9;
        r0 = r1.a(r7);     // Catch: Throwable -> L12
        f19115b = r0;     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        goto L15
    L9:
        r0 = r2;
    L12:
        th = move-exception;
        throw th;
    L15:
        Method r6 = r0.b();
        if (r6 != null) goto L18;
        return null;
    L18:
        Method r3 = r0.a();
        if (r3 != null) goto L21;
        return null;
    L21:
        Object r8 = r6.invoke(r7, new Object[0]);
        kotlin.n0.d.o.d(r8, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] r9 = (Object[]) r8;
        ArrayList r10 = new ArrayList(r9.length);
        int r4 = r9.length;
        int r5 = 0;
    L22:
        if (r5 >= r4) goto L24;
        Object r11 = r3.invoke(r9[r5], new Object[0]);
        kotlin.n0.d.o.d(r11, "null cannot be cast to non-null type kotlin.String");
        r10.add((String) r11);
        r5 = r5 + 1;
        goto L22
    L24:
        return r10;
    }
}
