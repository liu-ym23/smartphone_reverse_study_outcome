package h.a.f3;

import h.a.t2;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J(\u0010\f\u001a\u0004\u0018\u0001H\r\"\b\b\u0001\u0010\r*\u00020\u000e2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\r0\bH\u0096\u0002¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0010\u001a\u00020\u00112\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016J\u001d\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0015\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u001aR\u0018\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/internal/ThreadLocalElement;", "T", "Lkotlinx/coroutines/ThreadContextElement;", "value", "threadLocal", "Ljava/lang/ThreadLocal;", "(Ljava/lang/Object;Ljava/lang/ThreadLocal;)V", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "Ljava/lang/Object;", "get", "E", "Lkotlin/coroutines/CoroutineContext$Element;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "Lkotlin/coroutines/CoroutineContext;", "restoreThreadContext", "", "context", "oldState", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "toString", "", "updateThreadContext", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class k0<T> implements t2<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final T f17391f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ThreadLocal<T> f17392g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final kotlin.k0.g.c<?> f17393h;

    public k0(T r1, ThreadLocal<T> r2) {
        this.f17391f = r1;
        this.f17392g = r2;
        this.f17393h = new l0(r2);
    }

    @Override // h.a.t2
    public void Q(kotlin.k0.g r1, T r2) {
        this.f17392g.set(r2);
    }

    @Override // h.a.t2
    public T d0(kotlin.k0.g r2) {
        T r3 = this.f17392g.get();
        this.f17392g.set(this.f17391f);
        return r3;
    }

    @Override // kotlin.k0.g
    public <R> R fold(R r1, kotlin.n0.c.p<? super R, ? super kotlin.k0.g.b, ? extends R> r2) {
        return (R) t2.a.a(this, r1, r2);
    }

    @Override // kotlin.k0.g.b, kotlin.k0.g
    public <E extends kotlin.k0.g.b> E get(kotlin.k0.g.c<E> r2) {
        if (kotlin.n0.d.o.a(getKey(), r2) == true) goto L7;
        return null;
    L7:
        return this;
    }

    @Override // kotlin.k0.g.b
    public kotlin.k0.g.c<?> getKey() {
        return this.f17393h;
    }

    @Override // kotlin.k0.g
    public kotlin.k0.g minusKey(kotlin.k0.g.c<?> r2) {
        if (kotlin.n0.d.o.a(getKey(), r2) == true) goto L5;
        return this;
    L5:
        return kotlin.k0.h.f18399f;
    }

    @Override // kotlin.k0.g
    public kotlin.k0.g plus(kotlin.k0.g r1) {
        return t2.a.b(this, r1);
    }

    public String toString() {
        return "ThreadLocal(value=" + this.f17391f + ", threadLocal = " + this.f17392g + ')';
    }
}
