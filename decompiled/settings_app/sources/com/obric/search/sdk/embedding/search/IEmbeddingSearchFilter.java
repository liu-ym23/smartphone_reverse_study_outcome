package com.obric.search.sdk.embedding.search;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: compiled from: IEmbeddingSearchFilter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0006\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u00032\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003H&¨\u0006\b"}, d2 = {"Lcom/obric/search/sdk/embedding/search/IEmbeddingSearchFilter;", "", "filter", "", "Lkotlin/Pair;", "", "", "list", "embeddingPlugin_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IEmbeddingSearchFilter {
    List<Pair<Long, Double>> filter(List<Pair<Long, Double>> r1);
}
