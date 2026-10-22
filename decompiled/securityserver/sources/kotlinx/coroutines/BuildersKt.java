package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class BuildersKt {
    public static Job a(CoroutineScope r1, CoroutineStart r2, Function2 r3, int r4) {
        EmptyCoroutineContext r0 = EmptyCoroutineContext.b;
        if ((r4 & 2) == 0) goto L5;
        r2 = CoroutineStart.b;
    L5:
        CoroutineContext r5 = CoroutineContextKt.a(r1, r0);
        r2.getClass();
        if (r2 != CoroutineStart.c) goto L8;
        AbstractCoroutine r6 = new LazyStandaloneCoroutine(r5, r3);
    L9:
        r6.y0(r2, r6, r3);
        return r6;
    L8:
        r6 = new StandaloneCoroutine(r5, true);
        goto L9
    }
}
