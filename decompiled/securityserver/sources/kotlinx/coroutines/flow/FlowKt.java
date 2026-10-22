package kotlinx.coroutines.flow;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FlowKt {

    @Metadata
    public final /* synthetic */ class WhenMappings {
        static {
            int[] r0 = new int[SharingCommand.values().length];
            r0[0] = 1;
            r0[1] = 2;
            r0[2] = 3;
        }
    }

    public static final Serializable a(FlowCollector r4, Continuation r5) {
        if ((r5 instanceof FlowKt__ErrorsKt$catchImpl$1) == false) goto L7;
        FlowKt__ErrorsKt$catchImpl$1 r0 = (FlowKt__ErrorsKt$catchImpl$1) r5;
        int r1 = r0.i;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.i = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.f;
        int r2 = r0.i;
        Throwable r3 = null;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        Ref.ObjectRef r7 = r0.l;
        ResultKt.b(r6);     // Catch: Throwable -> L14
    L52:
        return r3;
    L14:
        th = move-exception;
        r3 = th;
    L23:
        Throwable r8 = (Throwable) r7.b;
        if (r8 == null) goto L34;
        boolean r9 = DebugKt.b;
        if (r9 == false) goto L29;
        r8 = StackTraceRecoveryKt.d(r8);
    L29:
        if (r9 == true) goto L31;
        Throwable r10 = r3;
    L33:
        if (r8.equals(r10) == false) goto L34;
        throw r3;
    L31:
        r10 = StackTraceRecoveryKt.d(r3);
    L34:
        CoroutineContext r11 = r0.c;
        Intrinsics.c(r11);
        Job r12 = (Job) r11.f(Job.g);
        if (r12 == null) goto L52;
        if (r12.isCancelled() == false) goto L52;
        Throwable r13 = r12.q();
        if (r13 == null) goto L52;
        boolean r14 = DebugKt.b;
        if (r14 == false) goto L45;
        r13 = StackTraceRecoveryKt.d(r13);
    L45:
        if (r14 == true) goto L47;
        Object r15 = r3;
    L49:
        if (r13.equals(r15) == false) goto L52;
        throw r3;
    L47:
        r15 = StackTraceRecoveryKt.d(r3);
        goto L49
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.b(r6);
        Ref.ObjectRef r16 = new Ref.ObjectRef();
        r16.b = null;
        r0.j = null;     // Catch: Throwable -> L21
        r0.k = r4;     // Catch: Throwable -> L21
        r0.l = r16;     // Catch: Throwable -> L21
        r0.m = null;     // Catch: Throwable -> L21
        r0.i = 1;     // Catch: Throwable -> L21
        throw null;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        r3 = th;
        r7 = r16;
    L7:
        r0 = new FlowKt__ErrorsKt$catchImpl$1(r5);
        goto L8
    }

    public static final Object b(FlowCollector r1, ReceiveChannel r2, Continuation r3) {
        Object r4 = FlowKt__ChannelsKt.a(r1, r2, true, r3);
        if (r4 != CoroutineSingletons.b) goto L6;
        return r4;
    L6:
        return Unit.f330a;
    }
}
