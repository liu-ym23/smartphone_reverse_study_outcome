package com.obric.search.sdk.embedding.shema;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: EmbeddingSearchTextImageSchemaExecutor.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.search.sdk.embedding.shema.EmbeddingSearchTextImageSchemaExecutor", f = "EmbeddingSearchTextImageSchemaExecutor.kt", i = {0}, l = {47}, m = "image2Vec-0E7RQCE", n = {"this"}, s = {"L$0"})
final class EmbeddingSearchTextImageSchemaExecutor$image2Vec$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EmbeddingSearchTextImageSchemaExecutor this$0;

    EmbeddingSearchTextImageSchemaExecutor$image2Vec$1(EmbeddingSearchTextImageSchemaExecutor r1, Continuation<? super EmbeddingSearchTextImageSchemaExecutor$image2Vec$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        Object r1 = EmbeddingSearchTextImageSchemaExecutor.m1470access$image2Vec0E7RQCE(this.this$0, null, null, this);
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r1;
    L6:
        return Result.m1507boximpl(r1);
    }
}
