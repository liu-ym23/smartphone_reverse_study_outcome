package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@PublishedApi
public final class ThreadLocalKey implements CoroutineContext.Key<ThreadLocalElement<?>> {
    public final boolean equals(Object r1) {
        if (this != r1) goto L4;
        return true;
    L4:
        if ((r1 instanceof ThreadLocalKey) == false) goto L8;
        ((ThreadLocalKey) r1).getClass();
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
        return "ThreadLocalKey(threadLocal=null)";
    }
}
