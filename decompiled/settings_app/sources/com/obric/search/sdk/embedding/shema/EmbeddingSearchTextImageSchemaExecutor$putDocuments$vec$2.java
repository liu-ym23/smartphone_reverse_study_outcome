package com.obric.search.sdk.embedding.shema;

import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.search.api.document.intf.IDocument;
import com.obric.search.sdk.embedding.document.IEmbeddingSearchImageDocument;
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

/* JADX INFO: compiled from: EmbeddingSearchTextImageSchemaExecutor.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0014\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.search.sdk.embedding.shema.EmbeddingSearchTextImageSchemaExecutor$putDocuments$vec$2", f = "EmbeddingSearchTextImageSchemaExecutor.kt", i = {}, l = {131}, m = "invokeSuspend", n = {}, s = {})
final class EmbeddingSearchTextImageSchemaExecutor$putDocuments$vec$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super float[]>, Object> {
    final /* synthetic */ IDocument $item;
    final /* synthetic */ IBaseModel $model;
    int label;
    final /* synthetic */ EmbeddingSearchTextImageSchemaExecutor this$0;

    EmbeddingSearchTextImageSchemaExecutor$putDocuments$vec$2(IDocument r1, EmbeddingSearchTextImageSchemaExecutor r2, IBaseModel r3, Continuation<? super EmbeddingSearchTextImageSchemaExecutor$putDocuments$vec$2> r4) {
        this.$item = r1;
        this.this$0 = r2;
        this.$model = r3;
        super(2, r4);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new EmbeddingSearchTextImageSchemaExecutor$putDocuments$vec$2(this.$item, this.this$0, this.$model, r4);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super float[]> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r1, Continuation<? super float[]> r2) {
        return ((EmbeddingSearchTextImageSchemaExecutor$putDocuments$vec$2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
        Object r7 = ((Result) r6).m1517unboximpl();
    L12:
        if (Result.m1514isFailureimpl(r7) == false) goto L14;
        r7 = null;
    L14:
        float[] r8 = (float[]) r7;
        ((IEmbeddingSearchImageDocument) this.$item).afterEmbedding();
        return r8;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        ((IEmbeddingSearchImageDocument) this.$item).beforeEmbedding();
        this.label = 1;
        r7 = EmbeddingSearchTextImageSchemaExecutor.m1470access$image2Vec0E7RQCE(this.this$0, ((IEmbeddingSearchImageDocument) this.$item).toRawEmbeddingImageFilePath(), this.$model, this);
        if (r7 != r0) goto L12;
        return r0;
    }
}
