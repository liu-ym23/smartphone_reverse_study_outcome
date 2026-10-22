package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class InlineList<E> {
    public final boolean equals(Object r1) {
        if ((r1 instanceof InlineList) == false) goto L7;
        ((InlineList) r1).getClass();
        if (Intrinsics.a(null, null) == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "InlineList(holder=null)";
    }
}
