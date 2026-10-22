package com.obric.search.api.schema.impl;

import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.search.sdk.embedding.search.EmbeddingSearchSpec;
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

/* JADX INFO: compiled from: EmbeddingSearchTextSchemaExecutor.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.search.api.schema.impl.EmbeddingSearchTextSchemaExecutor$getDBResult$word2VecRes$1", f = "EmbeddingSearchTextSchemaExecutor.kt", i = {}, l = {195}, m = "invokeSuspend", n = {}, s = {})
final class EmbeddingSearchTextSchemaExecutor$getDBResult$word2VecRes$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends float[]>>, Object> {
    final /* synthetic */ IBaseModel $model;
    final /* synthetic */ EmbeddingSearchSpec $searchSpec;
    int label;
    final /* synthetic */ EmbeddingSearchTextSchemaExecutor this$0;

    EmbeddingSearchTextSchemaExecutor$getDBResult$word2VecRes$1(EmbeddingSearchTextSchemaExecutor r1, EmbeddingSearchSpec r2, IBaseModel r3, Continuation<? super EmbeddingSearchTextSchemaExecutor$getDBResult$word2VecRes$1> r4) {
        this.this$0 = r1;
        this.$searchSpec = r2;
        this.$model = r3;
        super(2, r4);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new EmbeddingSearchTextSchemaExecutor$getDBResult$word2VecRes$1(this.this$0, this.$searchSpec, this.$model, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Result<? extends float[]>> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r1, Continuation<? super Result<float[]>> r2) {
        return ((EmbeddingSearchTextSchemaExecutor$getDBResult$word2VecRes$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
        Object r5 = ((Result) r6).m1517unboximpl();
    L12:
        return Result.m1507boximpl(r5);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        this.label = 1;
        r5 = this.this$0.m1469word2Vec0E7RQCE(this.$searchSpec.getQuery().getValue(), this.$model, this);
        if (r5 != r0) goto L12;
        return r0;
    }
}
