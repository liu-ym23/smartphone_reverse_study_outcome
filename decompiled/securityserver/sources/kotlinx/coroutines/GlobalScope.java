package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class GlobalScope implements CoroutineScope {
    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext A() {
        return EmptyCoroutineContext.b;
    }
}
