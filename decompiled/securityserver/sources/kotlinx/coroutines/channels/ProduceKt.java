package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ProduceKt {
    public static ProducerCoroutine a(CoroutineScope r3, int r4, Function2 r5, int r6) {
        EmptyCoroutineContext r0 = EmptyCoroutineContext.b;
        if ((r6 & 2) == 0) goto L5;
        r4 = 0;
    L5:
        BufferOverflow r7 = BufferOverflow.b;
        CoroutineStart r1 = CoroutineStart.b;
        AbstractChannel r8 = ChannelKt.a(r4, r7, 4);
        ProducerCoroutine r9 = new ProducerCoroutine(CoroutineContextKt.a(r3, r0), r8);
        r9.y0(r1, r9, r5);
        return r9;
    }
}
