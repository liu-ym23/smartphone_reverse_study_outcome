package kotlin;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u001f\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\bH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0088\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lkotlin/SynchronizedLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "lock", "", "(Lkotlin/jvm/functions/Function0;Ljava/lang/Object;)V", "_value", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class y<T> implements h<T>, Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private kotlin.n0.c.a<? extends T> f21463f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile Object f21464g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Object f21465h;

    public y(kotlin.n0.c.a<? extends T> r2, Object r3) {
        kotlin.n0.d.o.f(r2, "initializer");
        this.f21463f = r2;
        this.f21464g = d0.f18318a;
        if (r3 != null) goto L5;
        r3 = this;
    L5:
        this.f21465h = r3;
    }

    public /* synthetic */ y(kotlin.n0.c.a r1, Object r2, int r3, kotlin.n0.d.g r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public boolean a() {
        if (this.f21464g == d0.f18318a) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.h
    public T getValue() {
        T r0 = (T) this.f21464g;
        d0 r1 = d0.f18318a;
        if (r0 == r1) goto L5;
        return r0;
    L5:
        Object r2 = this.f21465h;
        monitor-enter(r2);
        T r3 = (T) this.f21464g;
        if (r3 != r1) goto L11;
        kotlin.n0.c.a<? extends T> r4 = this.f21463f;     // Catch: Throwable -> L13
        kotlin.n0.d.o.c(r4);     // Catch: Throwable -> L13
        r3 = r4.invoke();     // Catch: Throwable -> L13
        this.f21464g = r3;     // Catch: Throwable -> L13
        this.f21463f = null;     // Catch: Throwable -> L13
    L11:
        monitor-exit(r2);
        return r3;
    L13:
        th = move-exception;
        throw th;
    }

    public String toString() {
        if (a() == true) goto L7;
        return "Lazy value not initialized yet.";
    L7:
        return String.valueOf(getValue());
    }
}
