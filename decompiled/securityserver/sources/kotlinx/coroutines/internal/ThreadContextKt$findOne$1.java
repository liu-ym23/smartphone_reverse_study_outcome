package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.ThreadContextElement;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ThreadContextKt$findOne$1 extends Lambda implements Function2<ThreadContextElement<?>, CoroutineContext.Element, ThreadContextElement<?>> {
    public static final ThreadContextKt$findOne$1 b = null;

    static {
        b = new ThreadContextKt$findOne$1(2);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        ThreadContextElement r3 = (ThreadContextElement) r1;
        CoroutineContext.Element r4 = (CoroutineContext.Element) r2;
        if (r3 == null) goto L6;
        return r3;
    L6:
        if ((r4 instanceof ThreadContextElement) == true) goto L9;
        r4 = null;
    L9:
        return (ThreadContextElement) r4;
    }
}
