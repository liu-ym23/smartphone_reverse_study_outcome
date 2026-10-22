package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class UnsafeLazyImpl<T> implements Lazy<T>, Serializable {
    public Function0 b;
    public Object c;

    @Override // kotlin.Lazy
    public final Object getValue() {
        if (this.c != UNINITIALIZED_VALUE.f329a) goto L6;
        Function0 r0 = this.b;
        Intrinsics.c(r0);
        this.c = r0.invoke();
        this.b = null;
    L6:
        return this.c;
    }

    public final String toString() {
        if (this.c != UNINITIALIZED_VALUE.f329a) goto L7;
        return "Lazy value not initialized yet.";
    L7:
        return String.valueOf(getValue());
    }
}
