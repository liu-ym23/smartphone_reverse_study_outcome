package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class ThrowingCollector implements FlowCollector<Object> {
    public final Throwable b;

    public ThrowingCollector(Throwable r1) {
        this.b = r1;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object d(Object r1, Continuation r2) {
        throw this.b;
    }
}
