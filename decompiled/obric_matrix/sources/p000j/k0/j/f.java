package p000j.k0.j;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
class f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<?> f18101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f18102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Class[] f18103c;

    f(Class<?> r1, String r2, Class... r3) {
        this.f18101a = r1;
        this.f18102b = r2;
        this.f18103c = r3;
    }

    private Method a(Class<?> r4) {
        String r0 = this.f18102b;
        if (r0 == null) goto L13;
        Method r5 = b(r4, r0, this.f18103c);
        if (r5 == null) goto L12;
        Class<?> r3 = this.f18101a;
        if (r3 == null) goto L12;
        if (r3.isAssignableFrom(r5.getReturnType()) == true) goto L12;
        return null;
    L12:
        return r5;
    L13:
        return null;
    }

    private static Method b(Class<?> r1, String r2, Class[] r3) {
        Method r4 = r1.getMethod(r2, r3);     // Catch: NoSuchMethodException -> L11
        if ((r4.getModifiers() & 1) != 0) goto L9;
        return null;
    L9:
        return r4;
    L17:
        return null;
    }

    public Object c(T r3, Object... r4) {
        Method r0 = a(r3.getClass());
        if (r0 == null) goto L10;
        return r0.invoke(r3, r4);
    L6:
        e = move-exception;
        AssertionError r5 = new AssertionError("Unexpectedly could not call: " + r0);
        r5.initCause(e);
        throw r5;
    L10:
        throw new AssertionError("Method " + this.f18102b + " not supported for object " + r3);
    }

    public Object d(T r2, Object... r3) {
        Method r1 = a(r2.getClass());
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.invoke(r2, r3);
    L7:
        return null;
    }

    public Object e(T r1, Object... r2) {
        return d(r1, r2);
    L4:
        e = move-exception;
        Throwable r0 = e.getTargetException();
        if ((r0 instanceof RuntimeException) == true) goto L8;
        AssertionError r3 = new AssertionError("Unexpected exception");
        r3.initCause(r0);
        throw r3;
    L8:
        throw ((RuntimeException) r0);
    }

    public Object f(T r1, Object... r2) {
        return c(r1, r2);
    L4:
        e = move-exception;
        Throwable r0 = e.getTargetException();
        if ((r0 instanceof RuntimeException) == true) goto L8;
        AssertionError r3 = new AssertionError("Unexpected exception");
        r3.initCause(r0);
        throw r3;
    L8:
        throw ((RuntimeException) r0);
    }

    public boolean g(T r1) {
        if (a(r1.getClass()) == null) goto L5;
        return true;
    L5:
        return false;
    }
}
