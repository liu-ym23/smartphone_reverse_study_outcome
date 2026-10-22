package kotlin.s0.w.d.l0.n;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class a1 extends kotlin.s0.w.d.l0.o.e<y0<?>, y0<?>> implements Iterable<y0<?>>, kotlin.n0.d.l0.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f20943g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final a1 f20944h = null;

    public static final class a extends kotlin.s0.w.d.l0.o.s<y0<?>, y0<?>> {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public static final /* synthetic */ Collection f(a r0) {
            return r0.e();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.s0.w.d.l0.o.s
        public <T extends y0<?>> int b(ConcurrentHashMap<kotlin.s0.d<? extends y0<?>>, Integer> r1, kotlin.s0.d<T> r2, kotlin.n0.c.l<? super kotlin.s0.d<? extends y0<?>>, Integer> r3) {
            kotlin.n0.d.o.f(r1, "<this>");
            kotlin.n0.d.o.f(r2, "kClass");
            kotlin.n0.d.o.f(r3, "compute");
            Integer r0 = r1.get(r2);
            if (r0 != null) goto L15;
            monitor-enter(r1);
            Integer r4 = r1.get(r2);     // Catch: Throwable -> L11
            if (r4 != null) goto L8;
            Integer r5 = r3.invoke(r2);     // Catch: Throwable -> L11
            r1.putIfAbsent(r2, Integer.valueOf(r5.intValue()));     // Catch: Throwable -> L11
            r4 = r5;     // Catch: Throwable -> L11
        L8:
            kotlin.n0.d.o.e(r4, "this[kClass] ?: compute(…putIfAbsent(kClass, it) }");     // Catch: Throwable -> L11
            int r6 = r4.intValue();     // Catch: Throwable -> L11
            monitor-exit(r1);
            return r6;
        L11:
            th = move-exception;
            throw th;
        L15:
            return r0.intValue();
        }

        public final a1 g(List<? extends y0<?>> r2) {
            kotlin.n0.d.o.f(r2, "attributes");
            if (r2.isEmpty() == false) goto L6;
            return h();
        L6:
            return new a1(r2, null);
        }

        public final a1 h() {
            return a1.g();
        }
    }

    static {
        f20943g = new a(null);
        f20944h = new a1(kotlin.i0.r.g());
    }

    private a1(List<? extends y0<?>> r3) {
        Iterator<? extends y0<?>> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        y0<?> r0 = r4.next();
        c(r0.b(), r0);
        goto L4
    }

    public /* synthetic */ a1(List r1, kotlin.n0.d.g r2) {
        this(r1);
    }

    private a1(y0<?> r1) {
        this(kotlin.i0.r.d(r1));
    }

    public static final /* synthetic */ a1 g() {
        return f20944h;
    }

    @Override // kotlin.s0.w.d.l0.o.a
    protected kotlin.s0.w.d.l0.o.s<y0<?>, y0<?>> b() {
        return f20943g;
    }

    public final a1 l(a1 r6) {
        kotlin.n0.d.o.f(r6, "other");
        if (isEmpty() == true) goto L5;
    L7:
        ArrayList r0 = new ArrayList();
        Iterator r1 = a.f(f20943g).iterator();
    L9:
        if (r1.hasNext() == false) goto L18;
        int r2 = ((Number) r1.next()).intValue();
        y0<?> r3 = a().get(r2);
        y0<?> r4 = r6.a().get(r2);
        if (r3 != null) goto L15;
        if (r4 == null) goto L14;
        y0 r5 = r4.a(r3);
    L16:
        kotlin.s0.w.d.l0.p.a.a(r0, r5);
        goto L9
    L14:
        r5 = null;
        goto L16
    L15:
        r5 = r3.a(r4);
        goto L16
    L18:
        return f20943g.g(r0);
    L5:
        if (r6.isEmpty() == false) goto L7;
        return this;
    }

    public final boolean m(y0<?> r2) {
        kotlin.n0.d.o.f(r2, "attribute");
        int r3 = f20943g.d(r2.b());
        if (a().get(r3) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final a1 n(a1 r6) {
        kotlin.n0.d.o.f(r6, "other");
        if (isEmpty() == true) goto L5;
    L7:
        ArrayList r0 = new ArrayList();
        Iterator r1 = a.f(f20943g).iterator();
    L9:
        if (r1.hasNext() == false) goto L18;
        int r2 = ((Number) r1.next()).intValue();
        y0<?> r3 = a().get(r2);
        y0<?> r4 = r6.a().get(r2);
        if (r3 != null) goto L15;
        if (r4 == null) goto L14;
        y0 r5 = r4.c(r3);
    L16:
        kotlin.s0.w.d.l0.p.a.a(r0, r5);
        goto L9
    L14:
        r5 = null;
        goto L16
    L15:
        r5 = r3.c(r4);
        goto L16
    L18:
        return f20943g.g(r0);
    L5:
        if (r6.isEmpty() == false) goto L7;
        return this;
    }

    public final a1 o(y0<?> r2) {
        kotlin.n0.d.o.f(r2, "attribute");
        if (m(r2) == false) goto L6;
        return this;
    L6:
        if (isEmpty() == true) goto L8;
        List<? extends y0<?>> r1 = kotlin.i0.r.l0(kotlin.i0.r.z0(this), r2);
        return f20943g.g(r1);
    L8:
        return new a1(r2);
    }

    public final a1 p(y0<?> r5) {
        kotlin.n0.d.o.f(r5, "attribute");
        if (isEmpty() == false) goto L5;
        return this;
    L5:
        kotlin.s0.w.d.l0.o.c<y0<?>> r0 = a();
        ArrayList r1 = new ArrayList();
        Iterator<y0<?>> r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L12;
        y0<?> r3 = r2.next();
        if ((!kotlin.n0.d.o.a(r3, r5)) == false) goto L7;
        r1.add(r3);
        goto L7
    L12:
        if (r1.size() != a().a()) goto L15;
        return this;
    L15:
        return f20943g.g(r1);
    }
}
