package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class SynchronizedLazyImpl<T> implements Lazy<T>, Serializable {
    public Function0 b;
    public volatile Object c;
    public final Object e;

    public SynchronizedLazyImpl(Function0 r2) {
        Intrinsics.f(r2, "initializer");
        this.b = r2;
        this.c = UNINITIALIZED_VALUE.f329a;
        this.e = this;
    }

    @Override // kotlin.Lazy
    public final Object getValue() {
        Object r0 = this.c;
        UNINITIALIZED_VALUE r1 = UNINITIALIZED_VALUE.f329a;
        if (r0 == r1) goto L5;
        return r0;
    L5:
        Object r2 = this.e;
        monitor-enter(r2);
        Object r3 = this.c;     // Catch: Throwable -> L13
        if (r3 != r1) goto L11;
        Function0 r4 = this.b;     // Catch: Throwable -> L13
        Intrinsics.c(r4);     // Catch: Throwable -> L13
        r3 = r4.invoke();     // Catch: Throwable -> L13
        this.c = r3;     // Catch: Throwable -> L13
        this.b = null;     // Catch: Throwable -> L13
    L11:
        monitor-exit(r2);
        return r3;
    L13:
        th = move-exception;
        throw th;
    }

    public final String toString() {
        if (this.c != UNINITIALIZED_VALUE.f329a) goto L7;
        return "Lazy value not initialized yet.";
    L7:
        return String.valueOf(getValue());
    }
}
