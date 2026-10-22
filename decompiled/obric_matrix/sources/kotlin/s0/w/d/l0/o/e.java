package kotlin.s0.w.d.l0.o;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e<K, T> extends a<K, T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private c<T> f21212f;

    public e() {
        i r0 = i.f21224f;
        kotlin.n0.d.o.d(r0, "null cannot be cast to non-null type org.jetbrains.kotlin.util.ArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
        this(r0);
    }

    protected e(c<T> r2) {
        kotlin.n0.d.o.f(r2, "arrayMap");
        this.f21212f = r2;
    }

    @Override // kotlin.s0.w.d.l0.o.a
    protected final c<T> a() {
        return this.f21212f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final void c(kotlin.s0.d<? extends K> r4, T r5) {
        kotlin.n0.d.o.f(r4, "tClass");
        kotlin.n0.d.o.f(r5, "value");
        int r6 = b().d(r4);
        int r0 = this.f21212f.a();
        if (r0 != 0) goto L5;
        this.f21212f = new o(r5, r6);
        return;
    L5:
        if (r0 != 1) goto L12;
        c<T> r1 = this.f21212f;
        kotlin.n0.d.o.d(r1, "null cannot be cast to non-null type org.jetbrains.kotlin.util.OneElementArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
        o r2 = (o) r1;
        if (r2.c() != r6) goto L11;
        this.f21212f = new o(r5, r6);
        return;
    L11:
        d r3 = new d();
        this.f21212f = r3;
        r3.b(r2.c(), r2.g());
    L12:
        this.f21212f.b(r6, r5);
    }
}
