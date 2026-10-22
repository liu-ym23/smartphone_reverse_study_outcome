package h.a;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\nH&J\u001c\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\nH\u0017J \u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\u0004\b\u0000\u0010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\rJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J\u0011\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0000H\u0087\u0002J\u0012\u0010\u0017\u001a\u00020\u00052\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\rJ\b\u0010\u0018\u001a\u00020\u0019H\u0016¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/ContinuationInterceptor;", "()V", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatchYield", "interceptContinuation", "Lkotlin/coroutines/Continuation;", "T", "continuation", "isDispatchNeeded", "", "limitedParallelism", "parallelism", "", "plus", "other", "releaseInterceptedContinuation", "toString", "", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class g0 extends kotlin.k0.a implements kotlin.k0.e {
    public static final a Key = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineDispatcher$Key;", "Lkotlin/coroutines/AbstractCoroutineContextKey;", "Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a extends kotlin.k0.b<kotlin.k0.e, g0> {

        /* JADX INFO: renamed from: h.a.g0$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/CoroutineDispatcher;", "it", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class C0460a extends kotlin.n0.d.q implements kotlin.n0.c.l<kotlin.k0.g.b, g0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final C0460a f17437f = null;

            static {
                f17437f = new C0460a();
            }

            C0460a() {
                super(1);
            }

            public final g0 a(kotlin.k0.g.b r1) {
                if ((r1 instanceof g0) == true) goto L7;
                return null;
            L7:
                return (g0) r1;
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ g0 invoke(kotlin.k0.g.b r1) {
                return a(r1);
            }
        }

        private a() {
            super(kotlin.k0.e.f18396a, C0460a.f17437f);
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }
    }

    static {
        Key = new a(null);
    }

    public g0() {
        super(kotlin.k0.e.f18396a);
    }

    public abstract void dispatch(kotlin.k0.g r1, Runnable r2);

    public void dispatchYield(kotlin.k0.g r1, Runnable r2) {
        dispatch(r1, r2);
    }

    @Override // kotlin.k0.a, kotlin.k0.g.b, kotlin.k0.g
    public <E extends kotlin.k0.g.b> E get(kotlin.k0.g.c<E> r1) {
        return (E) kotlin.k0.e.a.a(this, r1);
    }

    @Override // kotlin.k0.e
    public final <T> kotlin.k0.d<T> interceptContinuation(kotlin.k0.d<? super T> r2) {
        return new h.a.f3.i(this, r2);
    }

    public boolean isDispatchNeeded(kotlin.k0.g r1) {
        return true;
    }

    public g0 limitedParallelism(int r2) {
        h.a.f3.p.a(r2);
        return new h.a.f3.o(this, r2);
    }

    @Override // kotlin.k0.a, kotlin.k0.g
    public kotlin.k0.g minusKey(kotlin.k0.g.c<?> r1) {
        return kotlin.k0.e.a.b(this, r1);
    }

    public final g0 plus(g0 r1) {
        return r1;
    }

    @Override // kotlin.k0.e
    public final void releaseInterceptedContinuation(kotlin.k0.d<?> r1) {
        ((h.a.f3.i) r1).t();
    }

    public String toString() {
        return r0.a(this) + '@' + r0.b(this);
    }
}
