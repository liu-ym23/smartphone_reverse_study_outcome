package kotlin.k0;

import kotlin.Metadata;
import kotlin.n0.c.p;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)V", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class a implements g.b {
    private final g.c<?> key;

    public a(g.c<?> r2) {
        o.f(r2, "key");
        this.key = r2;
    }

    @Override // kotlin.k0.g
    public <R> R fold(R r1, p<? super R, ? super g.b, ? extends R> r2) {
        return (R) g.b.a.a(this, r1, r2);
    }

    @Override // kotlin.k0.g.b, kotlin.k0.g
    public <E extends g.b> E get(g.c<E> r1) {
        return (E) g.b.a.b(this, r1);
    }

    @Override // kotlin.k0.g.b
    public g.c<?> getKey() {
        return this.key;
    }

    @Override // kotlin.k0.g
    public g minusKey(g.c<?> r1) {
        return g.b.a.c(this, r1);
    }

    @Override // kotlin.k0.g
    public g plus(g r1) {
        return g.b.a.d(this, r1);
    }
}
