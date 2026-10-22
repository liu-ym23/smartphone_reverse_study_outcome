package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FlowKt__CollectKt$collectIndexed$2 implements FlowCollector<Object> {
    public int b;

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object d(Object r1, Continuation r2) {
        int r3 = this.b;
        this.b = r3 + 1;
        if (r3 < 0) goto L5;
        new Integer(r3);
        throw null;
    L5:
        throw new ArithmeticException("Index overflow has happened");
    }
}
