package h.a;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/UndispatchedMarker;", "Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext$Key;", "()V", "key", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class b3 implements kotlin.k0.g.b, kotlin.k0.g.c<b3> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b3 f17183f = null;

    static {
        f17183f = new b3();
    }

    private b3() {
    }

    @Override // kotlin.k0.g
    public <R> R fold(R r1, kotlin.n0.c.p<? super R, ? super kotlin.k0.g.b, ? extends R> r2) {
        return (R) kotlin.k0.g.b.a.a(this, r1, r2);
    }

    @Override // kotlin.k0.g.b, kotlin.k0.g
    public <E extends kotlin.k0.g.b> E get(kotlin.k0.g.c<E> r1) {
        return (E) kotlin.k0.g.b.a.b(this, r1);
    }

    @Override // kotlin.k0.g.b
    public kotlin.k0.g.c<?> getKey() {
        return this;
    }

    @Override // kotlin.k0.g
    public kotlin.k0.g minusKey(kotlin.k0.g.c<?> r1) {
        return kotlin.k0.g.b.a.c(this, r1);
    }

    @Override // kotlin.k0.g
    public kotlin.k0.g plus(kotlin.k0.g r1) {
        return kotlin.k0.g.b.a.d(this, r1);
    }
}
