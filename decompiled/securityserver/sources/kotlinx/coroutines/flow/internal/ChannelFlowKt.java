package kotlinx.coroutines.flow.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ChannelFlowKt {
    public static final Object a(CoroutineContext r2, Object r3, Object r4, Function2 r5, Continuation r6) {
        Object r7 = ThreadContextKt.c(r2, r4);
        StackFrameContinuation r0 = new StackFrameContinuation(r6, r2);     // Catch: Throwable -> L10
        if (r5 == null) goto L13;
        TypeIntrinsics.b(2, r5);     // Catch: Throwable -> L10
        Object r8 = r5.mo7invoke(r3, r0);     // Catch: Throwable -> L10
        ThreadContextKt.a(r2, r7);
        if (r8 != CoroutineSingletons.b) goto L9;
        Intrinsics.f(r6, TypedValues.AttributesType.S_FRAME);
    L9:
        return r8;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        ThreadContextKt.a(r2, r7);
        throw th;
    }
}
