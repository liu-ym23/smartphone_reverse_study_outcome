package kotlinx.coroutines.flow;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final /* synthetic */ class FlowKt__EmittersKt {
    public static final Object a(FlowCollector r4, Throwable r5, Continuation r6) {
        if ((r6 instanceof FlowKt__EmittersKt$invokeSafely$1) == false) goto L7;
        FlowKt__EmittersKt$invokeSafely$1 r0 = (FlowKt__EmittersKt$invokeSafely$1) r6;
        int r1 = r0.i;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.i = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.f;
        int r2 = r0.i;
        if (r2 == 0) goto L19;
        if (r2 != 1) goto L18;
        Throwable r8 = r0.l;
        ResultKt.b(r7);     // Catch: Throwable -> L15
        return Unit.f330a;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.b(r7);
        r0.j = r4;     // Catch: Throwable -> L15
        r0.k = null;     // Catch: Throwable -> L15
        r0.l = r5;     // Catch: Throwable -> L15
        r0.i = 1;     // Catch: Throwable -> L15
        throw null;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        if (r5 == null) goto L25;
        if (r5 == th) goto L25;
        ExceptionsKt.a(th, r5);
    L25:
        throw th;
    L7:
        r0 = new FlowKt__EmittersKt$invokeSafely$1(r6);
        goto L8
    }
}
