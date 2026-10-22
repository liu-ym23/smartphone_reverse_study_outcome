package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes2.dex */
@InternalCoroutinesApi
@Metadata
public final class SendingCollector<T> implements FlowCollector<T> {
    public final SendChannel b;

    public SendingCollector(SendChannel r1) {
        this.b = r1;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object d(Object r1, Continuation r2) {
        Object r0 = this.b.I(r1, r2);
        if (r0 != CoroutineSingletons.b) goto L6;
        return r0;
    L6:
        return Unit.f330a;
    }
}
