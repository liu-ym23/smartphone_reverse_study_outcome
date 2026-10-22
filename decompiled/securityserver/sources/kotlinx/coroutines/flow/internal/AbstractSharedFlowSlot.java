package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class AbstractSharedFlowSlot<F> {
    public abstract boolean a(AbstractSharedFlow r1);

    public abstract Continuation[] b(AbstractSharedFlow r1);
}
