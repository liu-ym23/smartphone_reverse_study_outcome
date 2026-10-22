package com.obric.search.sdk.embedding;

import com.obric.search.api.OSearchEngine;
import com.obric.search.api.schema.impl.EmbeddingSearchTextSchemaExecutor;
import com.obric.search.api.schema.intf.ISearchEngineSchemaExecutor;
import com.obric.search.common.log.RuntimeLogger;
import com.obric.search.sdk.embedding.exception.EmbeddingSearchException;
import com.obric.search.sdk.embedding.search.EmbeddingSearchSpec;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OSearchEngineExt.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a$\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003*\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u001a2\u0010\n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u00030\u000b*\u00020\u00072\u0006\u0010\b\u001a\u00020\tø\u0001\u0000¢\u0006\u0002\u0010\f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"TAG", "", "getDocumentsIdAndDistance", "", "Lkotlin/Pair;", "", "", "Lcom/obric/search/api/OSearchEngine;", "searchSpec", "Lcom/obric/search/sdk/embedding/search/EmbeddingSearchSpec;", "getDocumentsIdAndDistanceAndStatus", "Lkotlin/Result;", "(Lcom/obric/search/api/OSearchEngine;Lcom/obric/search/sdk/embedding/search/EmbeddingSearchSpec;)Ljava/lang/Object;", "embeddingPlugin_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class OSearchEngineExtKt {
    private static final String TAG = "OSearchEngineExt";

    public static final List<Pair<Long, Double>> getDocumentsIdAndDistance(OSearchEngine r1, EmbeddingSearchSpec r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "searchSpec");
        ISearchEngineSchemaExecutor r3 = r1.getExecutor(r2.getSchemaName());
        if (r3 != null) goto L5;
    L9:
        RuntimeLogger.INSTANCE.error(TAG, "getDocumentsIdAndDistance executor type error.");
        return CollectionsKt.emptyList();
    L5:
        if ((r3 instanceof EmbeddingSearchTextSchemaExecutor) == false) goto L9;
        return ((EmbeddingSearchTextSchemaExecutor) r3).getDocumentsIdAndDistance(r2);
    }

    public static final Object getDocumentsIdAndDistanceAndStatus(OSearchEngine r1, EmbeddingSearchSpec r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "searchSpec");
        ISearchEngineSchemaExecutor r3 = r1.getExecutor(r2.getSchemaName());
        if (r3 != null) goto L5;
    L9:
        RuntimeLogger.INSTANCE.error(TAG, "getDocumentsIdAndDistance executor type error.");
        Result.Companion r4 = Result.Companion;
        return Result.m1508constructorimpl(ResultKt.createFailure(new EmbeddingSearchException(EmbeddingSearchException.GET_EXECUTOR_ERROR, "Executor type error!")));
    L5:
        if ((r3 instanceof EmbeddingSearchTextSchemaExecutor) == false) goto L9;
        return ((EmbeddingSearchTextSchemaExecutor) r3).m1468getDocumentsIdAndDistanceAndStatusIoAF18A(r2);
    }
}
