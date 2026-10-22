package com.bytedance.blockframework.framework.async;

import com.bytedance.blockframework.framework.config.BlockInit;
import com.bytedance.blockframework.framework.performance.ThreadProcessor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: AsyncBaseBlock.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "DATA", "MODEL", "Lcom/bytedance/blockframework/framework/core/IBlockModel;", "it", "Lkotlin/Function0;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class AsyncBaseBlock$bindModel$3$1$1 extends Lambda implements Function1<Function0<? extends Unit>, Unit> {
    public static final AsyncBaseBlock$bindModel$3$1$1 INSTANCE = null;

    public static /* synthetic */ void $r8$lambda$3BeHRbbByfQptZiVs1VNj5GweS4(Function0 r0) {
        invoke$lambda$2(r0);
    }

    static {
        INSTANCE = new AsyncBaseBlock$bindModel$3$1$1();
    }

    AsyncBaseBlock$bindModel$3$1$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> r1) {
        invoke2(r1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        ThreadProcessor.INSTANCE.main().post(new AsyncBaseBlock$bindModel$3$1$1$$ExternalSyntheticLambda0(r2));
    }

    private static final void invoke$lambda$2(Function0 r1) {
        Intrinsics.checkNotNullParameter(r1, "$it");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        r1.invoke();     // Catch: Throwable -> L5
        Object r2 = Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r3 = Result.m777exceptionOrNullimpl(r2);
        if (r3 == null) goto L13;
        BlockInit.INSTANCE.recordException(r3);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
