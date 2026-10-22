package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* JADX INFO: loaded from: classes2.dex */
@FlowPreview
@Metadata
public abstract class AbstractFlow<T> implements Flow<T>, CancellableFlow<T> {
    @Override // kotlinx.coroutines.flow.Flow
    public final Object a(FlowCollector r5, Continuation r6) {
        if ((r6 instanceof AbstractFlow$collect$1) == false) goto L7;
        AbstractFlow$collect$1 r0 = (AbstractFlow$collect$1) r6;
        int r1 = r0.i;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.i = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.f;
        CoroutineSingletons r2 = CoroutineSingletons.b;
        int r3 = r0.i;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        SafeCollector r4 = r0.l;
        ResultKt.b(r7);     // Catch: Throwable -> L14
    L23:
        r4.j();
        return Unit.f330a;
    L14:
        th = th;
    L28:
        r4.j();
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.b(r7);
        CoroutineContext r8 = r0.c;
        Intrinsics.c(r8);
        SafeCollector r9 = new SafeCollector(r5, r8);
        r0.getClass();     // Catch: Throwable -> L26
        r0.k = r5;     // Catch: Throwable -> L26
        r0.l = r9;     // Catch: Throwable -> L26
        r0.i = 1;     // Catch: Throwable -> L26
        if (c(r9, r0) != r2) goto L22;
        return r2;
    L22:
        r4 = r9;
    L26:
        th = th;
        r4 = r9;
    L7:
        r0 = new AbstractFlow$collect$1(this, r6);
        goto L8
    }

    public abstract Object c(SafeCollector r1, Continuation r2);
}
