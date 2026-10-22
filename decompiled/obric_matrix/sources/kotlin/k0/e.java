package kotlin.k0;

import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ(\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0005H\u0096\u0002¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\bH&J\u0014\u0010\u000b\u001a\u00020\f2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016J\u0014\u0010\r\u001a\u00020\u000e2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¨\u0006\u0010"}, d2 = {"Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlin/coroutines/CoroutineContext$Element;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "interceptContinuation", "Lkotlin/coroutines/Continuation;", "T", "continuation", "minusKey", "Lkotlin/coroutines/CoroutineContext;", "releaseInterceptedContinuation", "", "Key", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface e extends g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f18396a = null;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public static <E extends g.b> E a(e r2, g.c<E> r3) {
            o.f(r3, "key");
            if ((r3 instanceof kotlin.k0.b) == false) goto L11;
            kotlin.k0.b r4 = (kotlin.k0.b) r3;
            if (r4.a(r2.getKey()) == false) goto L15;
            E r5 = (E) r4.b(r2);
            if ((r5 instanceof g.b) == true) goto L9;
            return null;
        L9:
            return r5;
        L15:
            return null;
        L11:
            if (e.f18396a != r3) goto L14;
            o.d(r2, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
            return r2;
        L14:
            return null;
        }

        public static g b(e r1, g.c<?> r2) {
            o.f(r2, "key");
            if ((r2 instanceof kotlin.k0.b) == false) goto L11;
            kotlin.k0.b r3 = (kotlin.k0.b) r2;
            if (r3.a(r1.getKey()) == true) goto L7;
            return r1;
        L7:
            if (r3.b(r1) != null) goto L9;
            return r1;
        L9:
            return h.f18399f;
        L11:
            if (e.f18396a == r2) goto L13;
            return r1;
        L13:
            return h.f18399f;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/coroutines/ContinuationInterceptor$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlin/coroutines/ContinuationInterceptor;", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements g.c<e> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final /* synthetic */ b f18397f = null;

        static {
            f18397f = new b();
        }

        private b() {
        }
    }

    static {
        f18396a = b.f18397f;
    }

    <T> d<T> interceptContinuation(d<? super T> r1);

    void releaseInterceptedContinuation(d<?> r1);
}
