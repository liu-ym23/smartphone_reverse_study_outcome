package kotlinx.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class UndispatchedKt {
    public static final void a(Object r1, Continuation r2, Function2 r3) {
        Intrinsics.f(r2, "completion");
        TypeIntrinsics.b(2, r3);     // Catch: Throwable -> L7
        Object r4 = r3.mo7invoke(r1, r2);     // Catch: Throwable -> L7
        if (r4 == CoroutineSingletons.b) goto L12;
        r2.k(r4);
        return;
    L12:
        return;
    L7:
        th = move-exception;
        r2.k(ResultKt.a(th));
    }

    public static final Object b(ScopeCoroutine r2, ScopeCoroutine r3, Function2 r4) {
        r2.f0((Job) r2.e.f(Job.g));
        TypeIntrinsics.b(2, r4);     // Catch: Throwable -> L5
        Object r5 = r4.mo7invoke(r3, r2);     // Catch: Throwable -> L5
    L7:
        CoroutineSingletons r6 = CoroutineSingletons.b;
        if (r5 == r6) goto L28;
        Object r7 = r2.h0(r5);
        if (r7 != JobSupportKt.b) goto L14;
        return r6;
    L14:
        if ((r7 instanceof CompletedExceptionally) == false) goto L23;
        Throwable r8 = ((CompletedExceptionally) r7).f364a;
        if (DebugKt.b == false) goto L26;
        Continuation r9 = r2.f;
        if ((r9 instanceof CoroutineStackFrame) == true) goto L21;
        throw r8;
    L21:
        throw StackTraceRecoveryKt.a(r8, (CoroutineStackFrame) r9);
    L26:
        throw r8;
    L23:
        return JobSupportKt.a(r7);
    L28:
        return r6;
    L5:
        th = move-exception;
        r5 = new CompletedExceptionally(th, false);
        goto L7
    }
}
