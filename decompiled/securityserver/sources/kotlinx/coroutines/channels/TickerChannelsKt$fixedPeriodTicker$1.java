package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.EventLoop_commonKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.TickerChannelsKt", f = "TickerChannels.kt", l = {84, 88, 94, 96}, m = "fixedPeriodTicker")
final class TickerChannelsKt$fixedPeriodTicker$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public long j;
    public long k;
    public long l;
    public long m;
    public SendChannel n;

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x011e -> B:45:0x0123). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r27) {
        TickerChannelsKt$fixedPeriodTicker$1 r0 = this;
        r0.f = r27;
        r0.i |= Integer.MIN_VALUE;
        SendChannel r1 = null;
        if ((r0 instanceof TickerChannelsKt$fixedPeriodTicker$1) == false) goto L7;
        int r2 = r0.i;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r0.i = r2 - Integer.MIN_VALUE;
    L8:
        Object r3 = r0.f;
        CoroutineSingletons r4 = CoroutineSingletons.b;
        int r5 = r0.i;
        long r6 = 0;
        if (r5 == 0) goto L20;
        if (r5 == 1) goto L19;
        if (r5 == 2) goto L18;
        if (r5 == 3) goto L17;
        if (r5 != 4) goto L16;
        long r10 = r0.m;
        long r12 = r0.l;
        r1 = r0.n;
        long r14 = r0.k;
        long r7 = r0.j;
        ResultKt.b(r3);
    L45:
        long r22 = r10;
        long r11 = r14;
        long r15 = r22;
        long r24 = r7;
        long r8 = r12;
        long r13 = r24;
    L46:
        r6 = 0;
    L25:
        long r9 = r8 + r15;
        Unit r16 = Unit.f330a;
        r0.j = r13;
        r0.k = r11;
        r0.n = r1;
        r0.l = r9;
        r0.m = r15;
        r0.i = 2;
        if (r1.I(r16, r0) == r4) goto L44;
        long r23 = r11;
        r10 = r15;
        r14 = r23;
        r7 = r13;
        r12 = r9;
    L29:
        long r17 = System.nanoTime();
        long r18 = r12 - r17;
        if (r18 >= r6) goto L33;
        r18 = r6;
    L33:
        if (r18 == r6) goto L35;
    L41:
        r0.j = r7;
        r0.k = r14;
        r0.n = r1;
        r0.l = r12;
        r0.m = r10;
        r0.i = 4;
        if (DelayKt.a(r18 / 1000000, r0) != r4) goto L45;
    L35:
        if (r10 == r6) goto L41;
        long r19 = r10 - ((r17 - r12) % r10);
        long r20 = r17 + r19;
        r0.j = r7;
        r0.k = r14;
        r0.n = r1;
        r0.l = r20;
        r0.m = r10;
        r0.i = 3;
        if (DelayKt.a(r19 / 1000000, r0) == r4) goto L44;
        long r110 = r14;
        r13 = r7;
        r15 = r10;
        r8 = r20;
        r11 = r110;
    L44:
        return CoroutineSingletons.b;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        long r21 = r0.m;
        long r111 = r0.l;
        r1 = r0.n;
        long r112 = r0.k;
        long r113 = r0.j;
        ResultKt.b(r3);
        r13 = r113;
        r15 = r21;
        r8 = r111;
        r11 = r112;
        goto L46
    L18:
        long r25 = r0.m;
        long r114 = r0.l;
        r1 = r0.n;
        long r115 = r0.k;
        long r116 = r0.j;
        ResultKt.b(r3);
        r7 = r116;
        r14 = r115;
        r12 = r114;
        r10 = r25;
        goto L29
    L19:
        r8 = r0.l;
        r1 = r0.n;
        r11 = r0.k;
        r13 = r0.j;
        ResultKt.b(r3);
    L24:
        r15 = EventLoop_commonKt.a(r13);
        goto L25
    L20:
        ResultKt.b(r3);
        r8 = System.nanoTime() + EventLoop_commonKt.a(0);
        r0.j = 0;
        r0.k = 0;
        r0.n = null;
        r0.l = r8;
        r0.i = 1;
        if (DelayKt.a(0, r0) == r4) goto L44;
        r11 = 0;
        r13 = 0;
    L7:
        r0 = new TickerChannelsKt$fixedPeriodTicker$1(r0);
        goto L8
    }
}
