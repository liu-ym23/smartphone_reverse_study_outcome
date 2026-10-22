package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CoroutineName extends AbstractCoroutineContextElement {
    public static final Key c = null;

    @Metadata
    public static final class Key implements CoroutineContext.Key<CoroutineName> {
    }

    static {
        c = new Key();
    }

    public final boolean equals(Object r1) {
        if (this != r1) goto L4;
        return true;
    L4:
        if ((r1 instanceof CoroutineName) == false) goto L8;
        ((CoroutineName) r1).getClass();
        if (Intrinsics.a(null, null) == true) goto L13;
        return false;
    L13:
        return true;
    L8:
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "CoroutineName(null)";
    }
}
