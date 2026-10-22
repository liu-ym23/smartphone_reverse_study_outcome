package d.b.p.a.h;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object[] f14307a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class<?>[] f14308b = null;

    static {
        f14307a = new Object[0];
        f14308b = new Class[0];
    }

    public static Class<?>[] a(Class<?>[] r1) {
        if (r1 == null) goto L7;
        if (r1.length == 0) goto L7;
        return r1;
    L7:
        return f14308b;
    }

    public static Object[] b(Object[] r1) {
        if (r1 == null) goto L7;
        if (r1.length == 0) goto L7;
        return r1;
    L7:
        return f14307a;
    }

    public static Class<?>[] c(Object... r3) {
        if (r3 == null) goto L15;
        if (r3.length == 0) goto L15;
        Class<?>[] r0 = new Class[r3.length];
        int r1 = 0;
    L7:
        if (r1 >= r3.length) goto L13;
        if (r3[r1] != null) goto L11;
        Class<?> r2 = null;
    L12:
        r0[r1] = r2;
        r1 = r1 + 1;
        goto L7
    L11:
        r2 = r3[r1].getClass();
        goto L12
    L13:
        return r0;
    L15:
        return f14308b;
    }
}
