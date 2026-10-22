package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlinx.coroutines.channels.ProducerCoroutine;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class FlowProduceCoroutine<T> extends ProducerCoroutine<T> {
    @Override // kotlinx.coroutines.JobSupport
    public final boolean S(Throwable r2) {
        if ((r2 instanceof ChildCancelledException) == false) goto L7;
        return true;
    L7:
        return O(r2);
    }
}
