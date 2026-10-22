package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.ThreadContextElement;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ThreadContextKt$restoreState$1 extends Lambda implements Function2<ThreadState, CoroutineContext.Element, ThreadState> {
    public static final ThreadContextKt$restoreState$1 b = null;

    static {
        b = new ThreadContextKt$restoreState$1(2);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r2, Object r3) {
        ThreadState r4 = (ThreadState) r2;
        CoroutineContext.Element r5 = (CoroutineContext.Element) r3;
        if ((r5 instanceof ThreadContextElement) == false) goto L5;
        CoroutineContext r1 = r4.c;
        int r6 = r4.b;
        r4.b = r6 + 1;
        ((ThreadContextElement) r5).D(r4.f431a[r6]);
    L5:
        return r4;
    }
}
