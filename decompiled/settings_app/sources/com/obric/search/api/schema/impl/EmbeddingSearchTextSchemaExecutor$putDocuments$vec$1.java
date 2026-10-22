package com.obric.search.api.schema.impl;

import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.search.api.document.intf.IDocument;
import com.obric.search.sdk.embedding.document.IEmbeddingSearchTextDocument;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0014\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.search.api.schema.impl.EmbeddingSearchTextSchemaExecutor$putDocuments$vec$1", f = "EmbeddingSearchTextSchemaExecutor.kt", i = {}, l = {146}, m = "invokeSuspend", n = {}, s = {})
final class EmbeddingSearchTextSchemaExecutor$putDocuments$vec$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super float[]>, Object> {
    final /* synthetic */ IDocument $item;
    final /* synthetic */ IBaseModel $model;
    int label;
    final /* synthetic */ EmbeddingSearchTextSchemaExecutor this$0;

    EmbeddingSearchTextSchemaExecutor$putDocuments$vec$1(EmbeddingSearchTextSchemaExecutor r1, IDocument r2, IBaseModel r3, Continuation<? super EmbeddingSearchTextSchemaExecutor$putDocuments$vec$1> r4) {
        this.this$0 = r1;
        this.$item = r2;
        this.$model = r3;
        super(2, r4);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new EmbeddingSearchTextSchemaExecutor$putDocuments$vec$1(this.this$0, this.$item, this.$model, r4);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super float[]> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r1, Continuation<? super float[]> r2) {
        return ((EmbeddingSearchTextSchemaExecutor$putDocuments$vec$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
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
        if (Result.m1514isFailureimpl(r5) == false) goto L15;
        return null;
    L15:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        this.label = 1;
        r5 = this.this$0.m1469word2Vec0E7RQCE(((IEmbeddingSearchTextDocument) this.$item).toRawEmbeddingTextData(), this.$model, this);
        if (r5 != r0) goto L12;
        return r0;
    }
}
