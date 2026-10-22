package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.ValueOrClosed;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final /* synthetic */ class FlowKt__ChannelsKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v1, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00a7 -> B:14:0x0031). Please report as a decompilation issue!!! */
    public static final Object a(FlowCollector r8, ReceiveChannel r9, boolean r10, Continuation r11) {
        if ((r11 instanceof FlowKt__ChannelsKt$emitAllImpl$1) == false) goto L7;
        FlowKt__ChannelsKt$emitAllImpl$1 r0 = (FlowKt__ChannelsKt$emitAllImpl$1) r11;
        int r1 = r0.i;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.i = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f;
        CoroutineSingletons r2 = CoroutineSingletons.b;
        int r3 = r0.i;
        if (r3 == 0) goto L22;
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L18;
        Throwable r13 = r0.l;
        boolean r14 = r0.n;
        ReceiveChannel r15 = r0.k;
        FlowCollector r4 = r0.j;
        ResultKt.b(r12);     // Catch: Throwable -> L15
    L14:
        Throwable r16 = r13;
        r8 = r4;
        ReceiveChannel r6 = r15;
        ?? r17 = r14;
        r9 = r6;
    L54:
        r0.j = r8;     // Catch: Throwable -> L47
        r0.k = r9;     // Catch: Throwable -> L47
        r0.n = r17;     // Catch: Throwable -> L47
        r0.l = r16;     // Catch: Throwable -> L47
        r0.m = r8;     // Catch: Throwable -> L47
        r0.i = 1;     // Catch: Throwable -> L47
        Object r5 = r9.G(r0);     // Catch: Throwable -> L47
        if (r5 != r2) goto L26;
        return r2;
    L26:
        r4 = r8;
        r13 = r16;
        r12 = r5;
        ?? r7 = r17;
        r15 = r9;
        r14 = r7 == true ? 1 : 0;
    L28:
        if ((r12 instanceof ValueOrClosed.Closed) == false) goto L41;
        if ((r12 instanceof ValueOrClosed.Closed) == false) goto L39;
        Throwable r18 = ((ValueOrClosed.Closed) r12).f389a;     // Catch: Throwable -> L15
        if (r18 != null) goto L37;
        if (r14 == false) goto L36;
        ChannelsKt.a(r15, r13);
    L36:
        return Unit.f330a;
    L37:
        throw r18;     // Catch: Throwable -> L15
    L39:
        throw new IllegalStateException("Channel was not closed".toString());     // Catch: Throwable -> L15
    L41:
        if ((r12 instanceof ValueOrClosed.Closed) == true) goto L46;
        r0.j = r4;     // Catch: Throwable -> L15
        r0.k = r15;     // Catch: Throwable -> L15
        r0.n = r14;     // Catch: Throwable -> L15
        r0.l = r13;     // Catch: Throwable -> L15
        r0.m = r12;     // Catch: Throwable -> L15
        r0.i = 2;     // Catch: Throwable -> L15
        if (r4.d(r12, r0) != r2) goto L14;
        return r2;
    L46:
        throw new IllegalStateException("Channel was closed".toString());     // Catch: Throwable -> L15
    L47:
        th = th;
        ?? r19 = r17;
        r10 = r9;
        r9 = r19 == true ? 1 : 0;
    L57:
        throw th;     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        if (r9 == null) goto L53;
        ChannelsKt.a(r10, th);
    L53:
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        FlowCollector r20 = (FlowCollector) r0.m;
        r13 = r0.l;
        r14 = r0.n;
        r15 = r0.k;
        r4 = r0.j;
        ResultKt.b(r12);     // Catch: Throwable -> L15
        goto L28
    L22:
        ResultKt.b(r12);
        r16 = null;
        r17 = r10;
    L15:
        th = th;
    L7:
        r0 = new FlowKt__ChannelsKt$emitAllImpl$1(r11);
        goto L8
    }
}
