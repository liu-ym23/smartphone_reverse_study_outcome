package kotlin;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0088\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lkotlin/UnsafeLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class g0<T> implements h<T>, Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private kotlin.n0.c.a<? extends T> f18325f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Object f18326g;

    public g0(kotlin.n0.c.a<? extends T> r2) {
        kotlin.n0.d.o.f(r2, "initializer");
        this.f18325f = r2;
        this.f18326g = d0.f18318a;
    }

    public boolean a() {
        if (this.f18326g == d0.f18318a) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.h
    public T getValue() {
        if (this.f18326g != d0.f18318a) goto L6;
        kotlin.n0.c.a<? extends T> r0 = this.f18325f;
        kotlin.n0.d.o.c(r0);
        this.f18326g = r0.invoke();
        this.f18325f = null;
    L6:
        return (T) this.f18326g;
    }

    public String toString() {
        if (a() == true) goto L7;
        return "Lazy value not initialized yet.";
    L7:
        return String.valueOf(getValue());
    }
}
