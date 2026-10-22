package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ContextScope implements CoroutineScope {
    public final CoroutineContext b;

    public ContextScope(CoroutineContext r1) {
        this.b = r1;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext A() {
        return this.b;
    }

    public final String toString() {
        return "CoroutineScope(coroutineContext=" + this.b + ')';
    }
}
