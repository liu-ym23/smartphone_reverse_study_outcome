package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ChannelsKt {
    public static final void a(ReceiveChannel r2, Throwable r3) {
        CancellationException r0 = null;
        Throwable r1 = null;
        if (r3 != null) goto L5;
    L12:
        r2.a(r0);
        return;
    L5:
        if ((r3 instanceof CancellationException) == false) goto L8;
        r1 = r3;
    L8:
        r0 = (CancellationException) r1;
        if (r0 != null) goto L12;
        r0 = new CancellationException("Channel was consumed, consumer had failed");
        r0.initCause(r3);
        goto L12
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0043: MOVE (r14 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:16:0x0043 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00bb -> B:48:0x0073). Please report as a decompilation issue!!! */
    public static final Object b(ReceiveChannel r12, ProducerScope r13, Continuation r14) {
        if ((r14 instanceof ChannelsKt__Channels_commonKt$toChannel$1) == false) goto L7;
        ChannelsKt__Channels_commonKt$toChannel$1 r0 = (ChannelsKt__Channels_commonKt$toChannel$1) r14;
        int r1 = r0.i;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.i = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.f;
        CoroutineSingletons r2 = CoroutineSingletons.b;
        int r3 = r0.i;
        if (r3 != 0) goto L47;
        ResultKt.b(r15);
        ChannelIterator r5 = r12.iterator();     // Catch: Throwable -> L39
        ChannelsKt__Channels_commonKt$toChannel$1 r6 = r0;
        Throwable r7 = null;
        ReceiveChannel r16 = r12;
        ReceiveChannel r4 = r16;
        SendChannel r8 = r13;
        ReceiveChannel r17 = r4;
    L48:
        r6.j = r12;     // Catch: Throwable -> L35
        r6.k = r8;     // Catch: Throwable -> L35
        r6.l = r17;     // Catch: Throwable -> L35
        r6.m = r16;     // Catch: Throwable -> L35
        r6.n = r7;     // Catch: Throwable -> L35
        r6.o = r4;     // Catch: Throwable -> L35
        r6.p = r5;     // Catch: Throwable -> L35
        r6.i = 1;     // Catch: Throwable -> L35
        Object r9 = r5.a(r6);     // Catch: Throwable -> L35
        if (r9 == r2) goto L52;
        ChannelIterator r10 = r5;
        ReceiveChannel r11 = r12;
        ChannelIterator r18 = r10;
        ChannelsKt__Channels_commonKt$toChannel$1 r19 = r6;
        ReceiveChannel r20 = r17;
        ReceiveChannel r110 = r4;
        r0 = r19;
        Throwable r111 = r7;
        SendChannel r21 = r8;
        Throwable r22 = r111;
    L30:
        if (((Boolean) r9).booleanValue() == false) goto L37;
        Object r23 = r18.next();     // Catch: Throwable -> L35
        r0.j = r11;     // Catch: Throwable -> L35
        r0.k = r21;     // Catch: Throwable -> L35
        r0.l = r20;     // Catch: Throwable -> L35
        r0.m = r16;     // Catch: Throwable -> L35
        r0.n = r22;     // Catch: Throwable -> L35
        r0.o = r110;     // Catch: Throwable -> L35
        r0.p = r18;     // Catch: Throwable -> L35
        r0.q = r23;     // Catch: Throwable -> L35
        r0.r = r23;     // Catch: Throwable -> L35
        r0.i = 2;     // Catch: Throwable -> L35
        if (r21.I(r23, r0) == r2) goto L53;
        ReceiveChannel r24 = r11;
        r5 = r18;
        r12 = r24;
        ChannelsKt__Channels_commonKt$toChannel$1 r112 = r0;
        r4 = r110;
        r17 = r20;
        r6 = r112;
        SendChannel r113 = r21;
        r7 = r22;
        r8 = r113;
        goto L48
    L53:
        return r2;
    L37:
        a(r16, r22);
        return r21;
    L52:
        return r2;
    L35:
        th = th;
    L45:
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        a(r16, th);
        throw th;
    L39:
        th = move-exception;
        r16 = r12;
        th = th;
        goto L45
    L47:
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L18;
        ChannelIterator r114 = r0.p;
        ReceiveChannel r115 = r0.o;
        Throwable r25 = r0.n;
        ReceiveChannel r26 = r0.m;
        ReceiveChannel r27 = r0.l;
        SendChannel r28 = r0.k;
        ReceiveChannel r29 = r0.j;
        ResultKt.b(r15);     // Catch: Throwable -> L15
        r16 = r26;
        r5 = r114;
        r12 = r29;
        ChannelsKt__Channels_commonKt$toChannel$1 r30 = r0;
        r4 = r115;
        r17 = r27;
        r6 = r30;
        r7 = r25;
        r8 = r28;
        goto L48
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r18 = r0.p;
        r110 = r0.o;
        r22 = r0.n;
        ReceiveChannel r31 = r0.m;
        r20 = r0.l;
        r21 = r0.k;
        ReceiveChannel r32 = r0.j;
        ResultKt.b(r15);     // Catch: Throwable -> L15
        r9 = r15;
        r16 = r31;
        r11 = r32;
    L15:
        th = th;
        r16 = r5;
    L7:
        r0 = new ChannelsKt__Channels_commonKt$toChannel$1(r14);
        goto L8
    }
}
