package kotlin.t0;

import com.bytedance.common.wschannel.WsConstants;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.v;
import kotlin.w;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\t\u0010\u0018\u001a\u00020\u0019H\u0096\u0002J\u000e\u0010\u001a\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001bJ\r\u0010\u001c\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001bJ\u001e\u0010\u001d\u001a\u00020\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u001fH\u0016ø\u0001\u0000¢\u0006\u0002\u0010 J\u0019\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010#J\u001f\u0010$\u001a\u00020\u00052\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010&R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0012\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lkotlin/sequences/SequenceBuilderIterator;", "T", "Lkotlin/sequences/SequenceScope;", "", "Lkotlin/coroutines/Continuation;", "", "()V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "nextIterator", "nextStep", "getNextStep", "()Lkotlin/coroutines/Continuation;", "setNextStep", "(Lkotlin/coroutines/Continuation;)V", "nextValue", "Ljava/lang/Object;", WsConstants.KEY_CONNECTION_STATE, "", "Lkotlin/sequences/State;", "exceptionalState", "", "hasNext", "", "next", "()Ljava/lang/Object;", "nextNotReady", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "yield", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "yieldAll", "iterator", "(Ljava/util/Iterator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class i<T> extends j<T> implements Iterator<T>, kotlin.k0.d<f0>, kotlin.n0.d.l0.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f21404f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private T f21405g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Iterator<? extends T> f21406h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private kotlin.k0.d<? super f0> f21407i;

    public i() {
    }

    private final Throwable g() {
        int r0 = this.f21404f;
        if (r0 == 4) goto L9;
        if (r0 == 5) goto L11;
        return new IllegalStateException("Unexpected state of the iterator: " + this.f21404f);
    L11:
        return new IllegalStateException("Iterator has failed.");
    L9:
        return new NoSuchElementException();
    }

    private final T p() {
        if (hasNext() == false) goto L7;
        return next();
    L7:
        throw new NoSuchElementException();
    }

    @Override // kotlin.t0.j
    public Object b(T r1, kotlin.k0.d<? super f0> r2) {
        this.f21405g = r1;
        this.f21404f = 3;
        this.f21407i = r2;
        Object r0 = kotlin.k0.i.b.c();
        if (r0 != kotlin.k0.i.b.c()) goto L6;
        kotlin.k0.j.a.h.c(r2);
    L6:
        if (r0 != kotlin.k0.i.b.c()) goto L9;
        return r0;
    L9:
        return f0.f18324a;
    }

    @Override // kotlin.t0.j
    public Object e(Iterator<? extends T> r2, kotlin.k0.d<? super f0> r3) {
        if (r2.hasNext() == false) goto L5;
        this.f21406h = r2;
        this.f21404f = 2;
        this.f21407i = r3;
        Object r1 = kotlin.k0.i.b.c();
        if (r1 != kotlin.k0.i.b.c()) goto L10;
        kotlin.k0.j.a.h.c(r3);
    L10:
        if (r1 != kotlin.k0.i.b.c()) goto L13;
        return r1;
    L13:
        return f0.f18324a;
    L5:
        return f0.f18324a;
    }

    @Override // kotlin.k0.d
    public kotlin.k0.g getContext() {
        return kotlin.k0.h.f18399f;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
    L2:
        int r0 = this.f21404f;
        if (r0 == 0) goto L21;
        if (r0 != 1) goto L6;
        Iterator<? extends T> r1 = this.f21406h;
        kotlin.n0.d.o.c(r1);
        if (r1.hasNext() == true) goto L18;
        this.f21406h = null;
        goto L21
    L18:
        this.f21404f = 2;
        return true;
    L6:
        if (r0 != 2) goto L8;
    L15:
        return true;
    L8:
        if (r0 == 3) goto L15;
        if (r0 != 4) goto L14;
        return false;
    L14:
        throw g();
    L21:
        this.f21404f = 5;
        kotlin.k0.d<? super f0> r2 = this.f21407i;
        kotlin.n0.d.o.c(r2);
        this.f21407i = null;
        v.a r3 = v.f21457g;
        f0 r4 = f0.f18324a;
        v.b(r4);
        r2.resumeWith(r4);
        goto L2
    }

    @Override // java.util.Iterator
    public T next() {
        int r0 = this.f21404f;
        if (r0 == 0) goto L17;
        if (r0 == 1) goto L17;
        if (r0 != 2) goto L9;
        this.f21404f = 1;
        Iterator<? extends T> r3 = this.f21406h;
        kotlin.n0.d.o.c(r3);
        return r3.next();
    L9:
        if (r0 != 3) goto L13;
        this.f21404f = 0;
        T r1 = this.f21405g;
        this.f21405g = null;
        return r1;
    L13:
        throw g();
    L17:
        return p();
    }

    public final void r(kotlin.k0.d<? super f0> r1) {
        this.f21407i = r1;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // kotlin.k0.d
    public void resumeWith(Object r1) {
        w.b(r1);
        this.f21404f = 4;
    }
}
