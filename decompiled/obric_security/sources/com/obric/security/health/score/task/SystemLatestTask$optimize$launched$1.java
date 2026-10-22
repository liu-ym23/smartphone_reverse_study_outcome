package com.obric.security.health.score.task;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.obric.security.health.score.HealthScoreLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SystemLatestTask.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.obric.security.health.score.task.SystemLatestTask$optimize$launched$1", f = "SystemLatestTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SystemLatestTask$optimize$launched$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Context $context;
    private /* synthetic */ Object L$0;
    int label;

    SystemLatestTask$optimize$launched$1(Context r1, Continuation r2) {
        this.$context = r1;
        super(2, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "completion");
        SystemLatestTask$optimize$launched$1 r0 = new SystemLatestTask$optimize$launched$1(this.$context, r3);
        r0.L$0 = r2;
        return r0;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return ((SystemLatestTask$optimize$launched$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r4);
        CoroutineScope r5 = (CoroutineScope) this.L$0;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L10
        Intent r7 = new Intent();     // Catch: Throwable -> L10
        SystemLatestTask.access$Companion();     // Catch: Throwable -> L10
        SystemLatestTask.access$Companion();     // Catch: Throwable -> L10
        r7.setClassName("com.obric.updater", "com.obric.updater.UpdatesCheck");     // Catch: Throwable -> L10
        r7.setAction("android.intent.action.MAIN");     // Catch: Throwable -> L10
        if ((this.$context instanceof Activity) == true) goto L8;
        r7.addFlags(268435456);     // Catch: Throwable -> L10
    L8:
        this.$context.startActivity(r7);     // Catch: Throwable -> L10
        Object r3 = Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r8 = Result.m777exceptionOrNullimpl(r3);
        if (r8 == null) goto L16;
        HealthScoreLog r0 = HealthScoreLog.INSTANCE;
        SystemLatestTask.access$Companion();
        r0.e("SystemLatestTask", "launchUpdaterSettingsFailed", r8);
    L16:
        return Boxing.boxBoolean(Result.m781isSuccessimpl(r3));
    L10:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r3 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L12
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
