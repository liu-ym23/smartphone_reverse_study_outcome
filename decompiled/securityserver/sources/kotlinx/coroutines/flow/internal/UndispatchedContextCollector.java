package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class UndispatchedContextCollector<T> implements FlowCollector<T> {
    public final Object b;
    public final Function2 c;
    public final CoroutineContext e;

    public UndispatchedContextCollector(FlowCollector r2, CoroutineContext r3) {
        this.e = r3;
        this.b = ThreadContextKt.b(r3);
        this.c = new UndispatchedContextCollector$emitRef$1(r2, null);
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object d(Object r3, Continuation r4) {
        Function2 r0 = this.c;
        Object r2 = ChannelFlowKt.a(this.e, r3, this.b, r0, r4);
        if (r2 != CoroutineSingletons.b) goto L6;
        return r2;
    L6:
        return Unit.f330a;
    }
}
