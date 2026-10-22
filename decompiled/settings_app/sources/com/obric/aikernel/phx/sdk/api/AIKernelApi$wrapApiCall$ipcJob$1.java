package com.obric.aikernel.phx.sdk.api;

import android.icu.lang.UCharacter;
import androidx.exifinterface.media.ExifInterface;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.phx.compat.ParamsCompat;
import com.obric.aikernel.sdk.config.RequestParams;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: AIKernelApi.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi$wrapApiCall$ipcJob$1", f = "AIKernelApi.kt", i = {}, l = {225, UCharacter.UnicodeBlock.ELBASAN_ID}, m = "invokeSuspend", n = {}, s = {})
final class AIKernelApi$wrapApiCall$ipcJob$1<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
    final /* synthetic */ Function1<Continuation<? super T>, Object> $block;
    final /* synthetic */ RequestParams $params;
    Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    AIKernelApi$wrapApiCall$ipcJob$1(RequestParams r1, Function1<? super Continuation<? super T>, ? extends Object> r2, Continuation<? super AIKernelApi$wrapApiCall$ipcJob$1> r3) {
        this.$params = r1;
        this.$block = r2;
        super(2, r3);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AIKernelApi$wrapApiCall$ipcJob$1(this.$params, this.$block, r3);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Object r2) {
        return invoke(r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super T> r2) {
        return ((AIKernelApi$wrapApiCall$ipcJob$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L13;
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L9;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L22
    L20:
        Object r6 = Result.m1508constructorimpl(r7);     // Catch: Throwable -> L22
    L24:
        Throwable r8 = Result.m1511exceptionOrNullimpl(r6);
        if (r8 == null) goto L28;
        AIKLog.INSTANCE.w(AIKernelApi.TAG, "asyncTransact got exception: " + r8);
    L28:
        if (Result.m1514isFailureimpl(r6) == false) goto L31;
        return null;
    L31:
        return r6;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        Function1<Continuation<? super T>, Object> r2 = (Function1) this.L$0;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L22
    L17:
        this.L$0 = null;     // Catch: Throwable -> L22
        this.label = 2;     // Catch: Throwable -> L22
        r7 = r2.invoke(this);     // Catch: Throwable -> L22
        if (r7 != r0) goto L20;
        return r0;
    L13:
        ResultKt.throwOnFailure(r7);
        RequestParams r9 = this.$params;
        r2 = this.$block;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L22
        ParamsCompat r10 = ParamsCompat.INSTANCE;     // Catch: Throwable -> L22
        this.L$0 = r2;     // Catch: Throwable -> L22
        this.label = 1;     // Catch: Throwable -> L22
        if (r10.startCompat(r9, this) != r0) goto L17;
        return r0;
    L22:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r6 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L24
    }
}
