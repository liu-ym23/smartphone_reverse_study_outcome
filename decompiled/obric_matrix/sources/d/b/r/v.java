package d.b.r;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile CopyOnWriteArrayList<d.b.r.j0.a> f14586k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Method, z<?>> f14587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<Method, Object> f14588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.b.r.h0.a.InterfaceC0388a f14589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final h f14590d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<f.a> f14591e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<c.a> f14592f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f14593g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Executor f14594h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List<d.b.r.j0.a> f14595i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final d.b.r.g0.a f14596j;

    class a implements InvocationHandler {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final s f14597f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Object[] f14598g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Class f14599h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ v f14600i;

        a(v r1, Class r2) {
            this.f14600i = r1;
            this.f14599h = r2;
            this.f14597f = s.g();
            this.f14598g = new Object[0];
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r3, Method r4, Object[] r5) {
            if (r4.getDeclaringClass() != Object.class) goto L7;
            return r4.invoke(this, r5);
        L7:
            if (this.f14597f.i(r4) == true) goto L14;
            z<?> r6 = this.f14600i.j(r4);
            if (r5 != null) goto L13;
            r5 = this.f14598g;
        L13:
            return r6.a(r5);
        L14:
            this.f14597f.h(r4, this.f14599h, r3, r5);
            throw null;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final s f14601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private d.b.r.h0.a.InterfaceC0388a f14602b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private h f14603c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<d.b.r.j0.a> f14604d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List<f.a> f14605e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final List<c.a> f14606f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Executor f14607g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Executor f14608h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f14609i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private d.b.r.g0.a f14610j;

        static {
        }

        public b() {
            this(s.g());
        }

        b(s r2) {
            this.f14604d = new CopyOnWriteArrayList();
            this.f14605e = new ArrayList();
            this.f14606f = new ArrayList();
            this.f14601a = r2;
        }

        public b a(c.a r3) {
            List<c.a> r0 = this.f14606f;
            f0.a(r3, "factory == null");
            r0.add(r3);
            return this;
        }

        public b b(f.a r3) {
            List<f.a> r0 = this.f14605e;
            f0.a(r3, "factory == null");
            r0.add(r3);
            return this;
        }

        public b c(d.b.r.j0.a r2) {
            f0.a(r2, "interceptor == null");
            List<d.b.r.j0.a> r0 = this.f14604d;
            r0.add(r2);
            return this;
        }

        public v d() {
            if (this.f14603c == null) goto L26;
            if (this.f14602b == null) goto L24;
            if (this.f14607g == null) goto L22;
            Executor r0 = this.f14608h;
            if (r0 != null) goto L11;
            r0 = this.f14601a.b();
        L11:
            Executor r8 = r0;
            ArrayList r6 = new ArrayList(this.f14606f);
            r6.addAll(this.f14601a.a(r8));
            ArrayList r5 = new ArrayList((this.f14605e.size() + 1) + this.f14601a.d());
            r5.add(new d.b.r.a());
            r5.addAll(this.f14605e);
            r5.addAll(this.f14601a.c());
            if (v.a() == null) goto L20;
            Iterator r1 = v.a().iterator();
        L15:
            if (r1.hasNext() == false) goto L20;
            d.b.r.j0.a r2 = (d.b.r.j0.a) r1.next();
            if (this.f14604d.contains(r2) == true) goto L15;
            this.f14604d.add(r2);
        L20:
            return new v(this.f14603c, this.f14602b, this.f14604d, r5, r6, this.f14607g, r8, this.f14609i, this.f14610j);
        L22:
            throw new IllegalStateException("HttpExecutor may not be null.");
        L24:
            throw new IllegalStateException("ClientProvider may not be null.");
        L26:
            throw new IllegalStateException("Endpoint may not be null.");
        }

        public b e(d.b.r.h0.a.InterfaceC0388a r2) {
            f0.a(r2, "provider == null");
            g(r2);
            return this;
        }

        public b f(Executor r2) {
            f0.a(r2, "httpExecutor == null");
            this.f14607g = r2;
            return this;
        }

        public b g(d.b.r.h0.a.InterfaceC0388a r2) {
            f0.a(r2, "provider == null");
            this.f14602b = r2;
            return this;
        }

        public b h(String r2) {
            if (r2 == null) goto L8;
            if (r2.trim().length() == 0) goto L8;
            this.f14603c = i.a(r2);
            return this;
        L8:
            throw new NullPointerException("Endpoint may not be blank.");
        }
    }

    v(h r1, d.b.r.h0.a.InterfaceC0388a r2, List<d.b.r.j0.a> r3, List<f.a> r4, List<c.a> r5, Executor r6, Executor r7, boolean r8, d.b.r.g0.a r9) {
        this.f14587a = new ConcurrentHashMap();
        this.f14588b = new ConcurrentHashMap();
        this.f14590d = r1;
        this.f14589c = r2;
        this.f14595i = r3;
        this.f14591e = Collections.unmodifiableList(r4);
        this.f14592f = Collections.unmodifiableList(r5);
        this.f14594h = r6;
        this.f14593g = r8;
        this.f14596j = r9;
    }

    static /* synthetic */ CopyOnWriteArrayList a() {
        return f14586k;
    }

    private void f(Class<?> r6) {
        s r0 = s.g();
        Method[] r7 = r6.getDeclaredMethods();
        int r1 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        Method r3 = r7[r2];
        if (r0.i(r3) == true) goto L9;
        if (Modifier.isStatic(r3.getModifiers()) == true) goto L9;
        j(r3);
    L9:
        r2 = r2 + 1;
        goto L3
    }

    public static void s(CopyOnWriteArrayList<d.b.r.j0.a> r0) {
        f14586k = r0;
    }

    public d.b.r.g0.a b() {
        return this.f14596j;
    }

    public c<?, ?> c(Type r2, Annotation[] r3) {
        return l(null, r2, r3);
    }

    public d.b.r.h0.a.InterfaceC0388a d() {
        return this.f14589c;
    }

    public <T> T e(Class<T> r4) {
        f0.y(r4);
        if (this.f14593g == false) goto L6;
        f(r4);
    L6:
        return (T) Proxy.newProxyInstance(r4.getClassLoader(), new Class[]{r4}, new a(this, r4));
    }

    public <T> f<T, d.b.r.h0.b> g(Type r4, Annotation[] r5) {
        f0.a(r4, "type == null");
        f0.a(r5, "annotations == null");
        int r0 = this.f14591e.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        f<T, d.b.r.h0.b> r2 = (f<T, d.b.r.h0.b>) this.f14591e.get(r1).a(r4, r5, this);
        if (r2 != null) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L9:
        throw new IllegalArgumentException("Could not locate header converter");
    }

    public Executor h() {
        return this.f14594h;
    }

    public List<d.b.r.j0.a> i() {
        return this.f14595i;
    }

    z<?> j(Method r4) {
        if (w.a() == true) goto L5;
        z<?> r0 = this.f14587a.get(r4);
        if (r0 != null) goto L9;
        Map<Method, z<?>> r1 = this.f14587a;
        monitor-enter(r1);
        z<?> r2 = this.f14587a.get(r4);     // Catch: Throwable -> L19
        if (r2 != null) goto L17;
        r2 = z.b(this, r4, new y(false));     // Catch: Throwable -> L19
        this.f14587a.put(r4, r2);     // Catch: Throwable -> L19
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L19
        return r2;
    L19:
        th = move-exception;
        throw th;
    L9:
        if ((r0 instanceof m) == false) goto L11;
        ((m) r0).f14475a.c(new y(true));
    L11:
        return r0;
    L5:
        return k(r4);
    }

    z<?> k(Method r4) {
        Object r0 = this.f14588b.get(r4);
        if ((r0 instanceof z) == true) goto L5;
        if (r0 != null) goto L22;
        Object r1 = new Object();
        monitor-enter(r1);
        r0 = this.f14588b.putIfAbsent(r4, r1);     // Catch: Throwable -> L19
        if (r0 != null) goto L17;
        z<?> r2 = z.b(this, r4, new y(false));     // Catch: Throwable -> L19
        this.f14588b.put(r4, r2);     // Catch: Throwable -> L19
        monitor-exit(r1);     // Catch: Throwable -> L19
        return r2;
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    L22:
        monitor-enter(r0);
        z<?> r3 = (z) this.f14588b.get(r4);     // Catch: Throwable -> L26
        monitor-exit(r0);     // Catch: Throwable -> L26
        return r3;
    L26:
        th = move-exception;
        throw th;
    L5:
        if ((r0 instanceof m) == false) goto L8;
        ((m) r0).f14475a.c(new y(true));
    L8:
        return (z) r0;
    }

    public c<?, ?> l(c.a r5, Type r6, Annotation[] r7) {
        f0.a(r6, "returnType == null");
        f0.a(r7, "annotations == null");
        int r0 = this.f14592f.indexOf(r5) + 1;
        int r1 = this.f14592f.size();
        int r2 = r0;
    L3:
        if (r2 >= r1) goto L8;
        c<?, ?> r3 = this.f14592f.get(r2).a(r6, r7, this);
        if (r3 != null) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        StringBuilder r8 = new StringBuilder("Could not locate call adapter for ");
        r8.append(r6);
        r8.append(".\n");
        if (r5 == null) goto L14;
        r8.append("  Skipped:");
        int r9 = 0;
    L11:
        if (r9 >= r0) goto L13;
        r8.append("\n   * ");
        r8.append(this.f14592f.get(r9).getClass().getName());
        r9 = r9 + 1;
        goto L11
    L13:
        r8.append('\n');
    L14:
        r8.append("  Tried:");
        int r10 = this.f14592f.size();
    L15:
        if (r0 >= r10) goto L18;
        r8.append("\n   * ");
        r8.append(this.f14592f.get(r0).getClass().getName());
        r0 = r0 + 1;
        goto L15
    L18:
        throw new IllegalArgumentException(r8.toString());
    }

    public <T> f<T, d.b.r.k0.j> m(f.a r5, Type r6, Annotation[] r7, Annotation[] r8) {
        f0.a(r6, "type == null");
        f0.a(r7, "parameterAnnotations == null");
        f0.a(r8, "methodAnnotations == null");
        int r0 = this.f14591e.indexOf(r5) + 1;
        int r1 = this.f14591e.size();
        int r2 = r0;
    L3:
        if (r2 >= r1) goto L8;
        f<T, d.b.r.k0.j> r3 = (f<T, d.b.r.k0.j>) this.f14591e.get(r2).c(r6, r7, r8, this);
        if (r3 != null) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        StringBuilder r9 = new StringBuilder("Could not locate RequestBody converter for ");
        r9.append(r6);
        r9.append(".\n");
        if (r5 == null) goto L14;
        r9.append("  Skipped:");
        int r10 = 0;
    L11:
        if (r10 >= r0) goto L13;
        r9.append("\n   * ");
        r9.append(this.f14591e.get(r10).getClass().getName());
        r10 = r10 + 1;
        goto L11
    L13:
        r9.append('\n');
    L14:
        r9.append("  Tried:");
        int r11 = this.f14591e.size();
    L15:
        if (r0 >= r11) goto L18;
        r9.append("\n   * ");
        r9.append(this.f14591e.get(r0).getClass().getName());
        r0 = r0 + 1;
        goto L15
    L18:
        throw new IllegalArgumentException(r9.toString());
    }

    public <T> f<d.b.r.k0.i, T> n(f.a r5, Type r6, Annotation[] r7) {
        f0.a(r6, "type == null");
        f0.a(r7, "annotations == null");
        int r0 = this.f14591e.indexOf(r5) + 1;
        int r1 = this.f14591e.size();
        int r2 = r0;
    L3:
        if (r2 >= r1) goto L8;
        f<d.b.r.k0.i, T> r3 = (f<d.b.r.k0.i, T>) this.f14591e.get(r2).d(r6, r7, this);
        if (r3 != null) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        StringBuilder r8 = new StringBuilder("Could not locate TypedInput converter for ");
        r8.append(r6);
        r8.append(".\n");
        if (r5 == null) goto L14;
        r8.append("  Skipped:");
        int r9 = 0;
    L11:
        if (r9 >= r0) goto L13;
        r8.append("\n   * ");
        r8.append(this.f14591e.get(r9).getClass().getName());
        r9 = r9 + 1;
        goto L11
    L13:
        r8.append('\n');
    L14:
        r8.append("  Tried:");
        int r10 = this.f14591e.size();
    L15:
        if (r0 >= r10) goto L18;
        r8.append("\n   * ");
        r8.append(this.f14591e.get(r0).getClass().getName());
        r0 = r0 + 1;
        goto L15
    L18:
        throw new IllegalArgumentException(r8.toString());
    }

    public <T> f<T, Object> o(Type r4, Annotation[] r5) {
        f0.a(r4, "type == null");
        f0.a(r5, "annotations == null");
        int r0 = this.f14591e.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        f<T, Object> r2 = (f<T, Object>) this.f14591e.get(r1).b(r4, r5, this);
        if (r2 != null) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L9:
        throw new IllegalArgumentException("Could not locate object converter");
    }

    public <T> f<T, d.b.r.k0.j> p(Type r2, Annotation[] r3, Annotation[] r4) {
        return m(null, r2, r3, r4);
    }

    public <T> f<d.b.r.k0.i, T> q(Type r2, Annotation[] r3) {
        return n(null, r2, r3);
    }

    public h r() {
        return this.f14590d;
    }

    public <T> f<T, String> t(Type r4, Annotation[] r5) {
        f0.a(r4, "type == null");
        f0.a(r5, "annotations == null");
        int r0 = this.f14591e.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        f<T, String> r2 = (f<T, String>) this.f14591e.get(r1).e(r4, r5, this);
        if (r2 != null) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L9:
        return d.b.r.a.h.f14327a;
    }
}
