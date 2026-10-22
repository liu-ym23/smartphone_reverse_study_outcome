package com.obric.aikernel.phx.core.conn;

import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.core.log.AIKLog;
import cz.msebera.android.httpclient.message.TokenParser;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: ServiceConnector.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.phx.core.conn.ServiceConnector$getService$2$1$2", f = "ServiceConnector.kt", i = {0, 0}, l = {151}, m = "invokeSuspend", n = {"$this$launch", "timeout"}, s = {"L$0", "J$0"})
final class ServiceConnector$getService$2$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Deferred<AIKBinder> $task;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    ServiceConnector$getService$2$1$2(Deferred<? extends AIKBinder> r1, Continuation<? super ServiceConnector$getService$2$1$2> r2) {
        this.$task = r1;
        super(2, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        ServiceConnector$getService$2$1$2 r0 = new ServiceConnector$getService$2$1$2(this.$task, r3);
        r0.L$0 = r2;
        return r0;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
        return ((ServiceConnector$getService$2$1$2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r3 = true;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        long r4 = this.J$0;
        CoroutineScope r5 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r7);
    L12:
        Deferred<AIKBinder> r8 = this.$task;
        if (r8 != null) goto L15;
    L17:
        r3 = false;
    L18:
        Deferred<AIKBinder> r9 = this.$task;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L25
        if (r3 == false) goto L23;
        if (r9 == null) goto L23;
        r9.cancel(new CancellationException("connectTask timeout by " + r4));     // Catch: Throwable -> L25
    L23:
        Object r10 = Result.m1508constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L27:
        AIKLog.INSTANCE.i("ServiceConnector", "cancel active:" + r3 + TokenParser.SP + this.$task + " success:" + Result.m1515isSuccessimpl(r10) + " exception:" + Result.m1511exceptionOrNullimpl(r10));
        return Unit.INSTANCE;
    L25:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r10 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L27
    L15:
        if (r8.isActive() != true) goto L17;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        this.L$0 = (CoroutineScope) this.L$0;
        this.J$0 = 30000;
        this.label = 1;
        if (DelayKt.delay(30000, this) != r1) goto L11;
        return r1;
    L11:
        r4 = 30000;
        goto L12
    }
}
