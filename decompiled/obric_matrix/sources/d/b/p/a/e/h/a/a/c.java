package d.b.p.a.e.h.a.a;

import d.b.p.a.d.h;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends b implements InvocationHandler {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Map<String, b> f14258j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected static final Map<Class<?>, Class<?>> f14259k = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected HashMap<String, b> f14260f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected Object f14261g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected boolean f14262h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f14263i;

    static {
        f14258j = new HashMap();
        HashMap r0 = new HashMap();
        f14259k = r0;
        r0.put(Boolean.class, Boolean.TYPE);
        r0.put(Byte.class, Byte.TYPE);
        r0.put(Character.class, Character.TYPE);
        r0.put(Short.class, Short.TYPE);
        r0.put(Integer.class, Integer.TYPE);
        r0.put(Long.class, Long.TYPE);
        r0.put(Double.class, Double.TYPE);
        r0.put(Float.class, Float.TYPE);
    }

    public c() {
        this.f14260f = new HashMap();
        this.f14262h = true;
    }

    protected static void c(String r1, b r2) {
        f14258j.put(r1, r2);
    }

    private Object f(Method r1, Object r2) {
        if (r2 == null) goto L4;
        return r2;
    L4:
        Class<?> r0 = r1.getReturnType();
        if (r0 != null) goto L7;
        return null;
    L7:
        if (r0.isPrimitive() == true) goto L12;
        r0 = f14259k.get(r0);
        if (r0 != null) goto L12;
        return null;
    L12:
        if (r0 != Boolean.TYPE) goto L16;
        return Boolean.FALSE;
    L16:
        if (r0 != Void.TYPE) goto L19;
        return new Object();
    L19:
        return 0;
    }

    @Override // d.b.p.a.e.h.a.a.b
    public Object a(Object r2, Method r3, Object[] r4, Object r5) {
        b r0 = d(r3.getName());
        if (r0 != null) goto L7;
        super.a(r2, r3, r4, r5);
        return r5;
    L7:
        return r0.a(r2, r3, r4, r5);
    }

    @Override // d.b.p.a.e.h.a.a.b
    public Object b(Object r2, Method r3, Object[] r4) {
        b r0 = d(r3.getName());
        if (r0 == null) goto L6;
        return r0.b(r2, r3, r4);
    L6:
        return super.b(r2, r3, r4);
    }

    protected b d(String r2) {
        b r0 = f14258j.get(r2);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.f14260f.get(r2);
    }

    public Object e() {
        return this.f14261g;
    }

    protected boolean g(Method r1) {
        return true;
    }

    public void h(Object r2) {
        this.f14263i = true;
        this.f14261g = r2;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object r3, Method r4, Object[] r5) {
        if (this.f14263i == false) goto L32;
        if (r4.isAccessible() == true) goto L8;
        r4.setAccessible(true);
    L8:
        if (this.f14262h == false) goto L10;
        Object r6 = null;
        r6 = b(this.f14261g, r4, r5);     // Catch: Throwable -> L14
    L16:
        if (r6 == null) goto L37;
    L35:
        r6 = a(this.f14261g, r4, r5, r6);     // Catch: Throwable -> L27
    L30:
        return f(r4, r6);
    L27:
        th = move-exception;
        h.c("afterInvokeError.", th.toString());
        goto L30
    L37:
        r6 = r4.invoke(this.f14261g, r5);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        if (g(r4) == false) goto L24;
        h.c("MethodProxyError.", th.toString());
        goto L35
    L24:
        throw new RuntimeException(th);
    L14:
        th = move-exception;
        h.c("beforeInvoke", th.toString());
        goto L16
    L10:
        return r4.invoke(this.f14261g, r5);
    L32:
        throw new IllegalStateException("setTarget must be invoked before this invoke");
    }
}
