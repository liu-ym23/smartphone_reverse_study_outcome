package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.AbstractFlow", f = "Flow.kt", l = {212}, m = "collect")
final class AbstractFlow$collect$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public final /* synthetic */ AbstractFlow j;
    public FlowCollector k;
    public SafeCollector l;

    public AbstractFlow$collect$1(AbstractFlow r1, Continuation r2) {
        this.j = r1;
        super(r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r2) {
        this.f = r2;
        this.i |= Integer.MIN_VALUE;
        return this.j.a(null, this);
    }
}
