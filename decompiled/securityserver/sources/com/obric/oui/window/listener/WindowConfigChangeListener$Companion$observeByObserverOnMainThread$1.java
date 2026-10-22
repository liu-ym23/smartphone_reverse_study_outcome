package com.obric.oui.window.listener;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "com.obric.oui.window.listener.WindowConfigChangeListener$Companion$observeByObserverOnMainThread$1", f = "WindowConfigChangeListener.kt", l = {}, m = "invokeSuspend")
final class WindowConfigChangeListener$Companion$observeByObserverOnMainThread$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation f(Object r1, Continuation r2) {
        Intrinsics.f(r2, "completion");
        throw null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r1) {
        ResultKt.b(r1);
        ConcurrentHashMap r0 = WindowConfigChangeListener.f320a;
        throw null;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        WindowConfigChangeListener$Companion$observeByObserverOnMainThread$1 r0 = (WindowConfigChangeListener$Companion$observeByObserverOnMainThread$1) f(r1, (Continuation) r2);
        Unit r3 = Unit.f330a;
        r0.i(r3);
        return r3;
    }
}
