package xt;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.f;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static final void a(Continuation r5, kotlinx.coroutines.a r10) {
        Continuation r11 = IntrinsicsKt.intercepted(r5);     // Catch: Throwable -> L4
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L4
        f.h(Result.m124constructorimpl(Unit.INSTANCE), r11);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r10.resumeWith(Result.m124constructorimpl(ResultKt.createFailure(th)));
        throw th;
    }

    public static final void b(Function2 r5, Object r10, Continuation r11) {
        Continuation r12 = IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(r5, r10, r11));     // Catch: Throwable -> L4
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L4
        f.h(Result.m124constructorimpl(Unit.INSTANCE), r12);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r11.resumeWith(Result.m124constructorimpl(ResultKt.createFailure(th)));
        throw th;
    }
}
