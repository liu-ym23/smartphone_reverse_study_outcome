package kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u0000 \u0013*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004:\u0001\u0013B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0088\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lkotlin/SafePublicationLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "final", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class x<T> implements h<T>, Serializable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater<x<?>, Object> f21460h = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile kotlin.n0.c.a<? extends T> f21461f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile Object f21462g;

    static {
        f21460h = AtomicReferenceFieldUpdater.newUpdater(x.class, Object.class, "g");
    }

    public x(kotlin.n0.c.a<? extends T> r2) {
        kotlin.n0.d.o.f(r2, "initializer");
        this.f21461f = r2;
        this.f21462g = d0.f18318a;
    }

    public boolean a() {
        if (this.f21462g == d0.f18318a) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.h
    public T getValue() {
        T r0 = (T) this.f21462g;
        d0 r1 = d0.f18318a;
        if (r0 == r1) goto L5;
        return r0;
    L5:
        kotlin.n0.c.a<? extends T> r2 = this.f21461f;
        if (r2 == null) goto L12;
        T r3 = r2.invoke();
        if (f21460h.compareAndSet(this, r1, r3) == false) goto L12;
        this.f21461f = null;
        return r3;
    L12:
        return (T) this.f21462g;
    }

    public String toString() {
        if (a() == true) goto L7;
        return "Lazy value not initialized yet.";
    L7:
        return String.valueOf(getValue());
    }
}
