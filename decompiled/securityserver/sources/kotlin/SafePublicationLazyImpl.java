package kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class SafePublicationLazyImpl<T> implements Lazy<T>, Serializable {
    public static final AtomicReferenceFieldUpdater e = null;
    public volatile Function0 b;
    public volatile Object c;

    @Metadata
    public static final class Companion {
    }

    static {
        e = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "c");
    }

    @Override // kotlin.Lazy
    public final Object getValue() {
        Object r0 = this.c;
        UNINITIALIZED_VALUE r1 = UNINITIALIZED_VALUE.f329a;
        if (r0 == r1) goto L5;
        return r0;
    L5:
        Function0 r2 = this.b;
        if (r2 == null) goto L12;
        Object r3 = r2.invoke();
        if (e.compareAndSet(this, r1, r3) == false) goto L12;
        this.b = null;
        return r3;
    L12:
        return this.c;
    }

    public final String toString() {
        if (this.c != UNINITIALIZED_VALUE.f329a) goto L7;
        return "Lazy value not initialized yet.";
    L7:
        return String.valueOf(getValue());
    }
}
