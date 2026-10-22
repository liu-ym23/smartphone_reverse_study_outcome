package kotlin;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004¨\u0006\t"}, d2 = {"lazy", "Lkotlin/Lazy;", "T", "initializer", "Lkotlin/Function0;", "lock", "", "mode", "Lkotlin/LazyThreadSafetyMode;", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/LazyKt")
class j {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18390a = null;

        static {
            int[] r0 = new int[l.values().length];
            r0[l.f18417f.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[l.f18418g.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[l.f18419h.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f18390a = r0;
        }
    }

    public static <T> h<T> a(l r2, kotlin.n0.c.a<? extends T> r3) {
        kotlin.n0.d.o.f(r2, "mode");
        kotlin.n0.d.o.f(r3, "initializer");
        int r4 = a.f18390a[r2.ordinal()];
        if (r4 == 1) goto L12;
        if (r4 == 2) goto L14;
        if (r4 != 3) goto L9;
        return new g0(r3);
    L9:
        throw new m();
    L14:
        return new x(r3);
    L12:
        return new y(r3, null, 2, null);
    }

    public static <T> h<T> b(kotlin.n0.c.a<? extends T> r3) {
        kotlin.n0.d.o.f(r3, "initializer");
        return new y(r3, null, 2, null);
    }
}
