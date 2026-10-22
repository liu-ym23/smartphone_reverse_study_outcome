package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.sequences.SequenceScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class DebugCoroutineInfoImpl {
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0048 -> B:21:0x0059). Please report as a decompilation issue!!! */
    public final /* synthetic */ Object a(SequenceScope r7, Continuation r8) {
        if ((r8 instanceof DebugCoroutineInfoImpl$yieldFrames$1) == false) goto L7;
        DebugCoroutineInfoImpl$yieldFrames$1 r0 = (DebugCoroutineInfoImpl$yieldFrames$1) r8;
        int r1 = r0.e;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.e = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.c;
        CoroutineSingletons r2 = CoroutineSingletons.b;
        int r3 = r0.e;
        Unit r4 = Unit.f330a;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        CoroutineStackFrame r6 = r0.k;
        SequenceScope r10 = r0.j;
        DebugCoroutineInfoImpl r5 = r0.i;
        ResultKt.b(r9);
        SequenceScope r11 = r10;
        DebugCoroutineInfoImpl r12 = r5;
    L21:
        r6 = r6.e();
        if (r6 != null) goto L15;
        return r4;
    L15:
        if (r6 != null) goto L17;
        return r4;
    L17:
        StackTraceElement r13 = r6.w();
        if (r13 == null) goto L21;
        r0.i = r12;
        r0.j = r11;
        r0.k = r6;
        r0.getClass();
        r0.e = 1;
        r11.a(r13, r0);
        return r2;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.b(r9);
        r12 = this;
        r6 = null;
        r11 = r7;
    L7:
        r0 = new DebugCoroutineInfoImpl$yieldFrames$1(this, r8);
        goto L8
    }

    public final String toString() {
        throw null;
    }
}
