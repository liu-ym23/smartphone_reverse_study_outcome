package kotlin.s0.w.d.l0.o;

import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class d<T> extends c<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object[] f21208f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f21209g;

    public static final class a extends kotlin.i0.b<T> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f21210h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ d<T> f21211i;

        a(d<T> r1) {
            this.f21211i = r1;
            this.f21210h = -1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.i0.b
        protected void b() {
        L2:
            int r0 = this.f21210h + 1;
            this.f21210h = r0;
            if (r0 >= d.c(this.f21211i).length) goto L7;
            if (d.c(this.f21211i)[this.f21210h] == null) goto L2;
        L7:
            if (this.f21210h < d.c(this.f21211i).length) goto L9;
            c();
            return;
        L9:
            Object r1 = d.c(this.f21211i)[this.f21210h];
            kotlin.n0.d.o.d(r1, "null cannot be cast to non-null type T of org.jetbrains.kotlin.util.ArrayMapImpl");
            e(r1);
        }
    }

    static {
    }

    public d() {
        this(new Object[20], 0);
    }

    private d(Object[] r2, int r3) {
        super(null);
        this.f21208f = r2;
        this.f21209g = r3;
    }

    public static final /* synthetic */ Object[] c(d r0) {
        return r0.f21208f;
    }

    private final void g(int r3) {
        Object[] r0 = this.f21208f;
        if (r0.length > r3) goto L6;
        Object[] r4 = Arrays.copyOf(r0, r0.length * 2);
        kotlin.n0.d.o.e(r4, "copyOf(this, newSize)");
        this.f21208f = r4;
        return;
    }

    @Override // kotlin.s0.w.d.l0.o.c
    public int a() {
        return this.f21209g;
    }

    @Override // kotlin.s0.w.d.l0.o.c
    public void b(int r2, T r3) {
        kotlin.n0.d.o.f(r3, "value");
        g(r2);
        if (this.f21208f[r2] != null) goto L5;
        this.f21209g = a() + 1;
    L5:
        this.f21208f[r2] = r3;
    }

    @Override // kotlin.s0.w.d.l0.o.c
    public T get(int r1) {
        return (T) kotlin.i0.i.B(this.f21208f, r1);
    }

    @Override // kotlin.s0.w.d.l0.o.c, java.lang.Iterable
    public Iterator<T> iterator() {
        return new a(this);
    }
}
