package com.obric.search.sdk.embedding.search;

import com.android.settings.DataUsageFragment;
import com.android.settings.search.IndexDatabaseHelper;
import com.obric.search.api.search.intf.ISearchSpec;
import com.obric.search.sdk.embedding.query.EmbeddingSearchQuery;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EmbeddingSearchSpec.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/obric/search/sdk/embedding/search/EmbeddingSearchSpec;", "Lcom/obric/search/api/search/intf/ISearchSpec;", "schemaName", "", IndexDatabaseHelper.SavedQueriesColums.QUERY, "Lcom/obric/search/sdk/embedding/query/EmbeddingSearchQuery;", DataUsageFragment.INTENT_EXTRA_LIMIT, "", "filter", "Lcom/obric/search/sdk/embedding/search/IEmbeddingSearchFilter;", "(Ljava/lang/String;Lcom/obric/search/sdk/embedding/query/EmbeddingSearchQuery;ILcom/obric/search/sdk/embedding/search/IEmbeddingSearchFilter;)V", "getFilter", "()Lcom/obric/search/sdk/embedding/search/IEmbeddingSearchFilter;", "getLimit", "()I", "getQuery", "()Lcom/obric/search/sdk/embedding/query/EmbeddingSearchQuery;", "getSchemaName", "()Ljava/lang/String;", "embeddingPlugin_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EmbeddingSearchSpec implements ISearchSpec {
    private final IEmbeddingSearchFilter filter;
    private final int limit;
    private final EmbeddingSearchQuery query;
    private final String schemaName;

    public EmbeddingSearchSpec(String r2, EmbeddingSearchQuery r3, int r4, IEmbeddingSearchFilter r5) {
        Intrinsics.checkNotNullParameter(r2, "schemaName");
        Intrinsics.checkNotNullParameter(r3, IndexDatabaseHelper.SavedQueriesColums.QUERY);
        this.schemaName = r2;
        this.query = r3;
        this.limit = r4;
        this.filter = r5;
    }

    public /* synthetic */ EmbeddingSearchSpec(String r1, EmbeddingSearchQuery r2, int r3, IEmbeddingSearchFilter r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        this(r1, r2, r3, r4);
    }

    @Override // com.obric.search.api.search.intf.ISearchSpec
    public String getSchemaName() {
        return this.schemaName;
    }

    public final EmbeddingSearchQuery getQuery() {
        return this.query;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final IEmbeddingSearchFilter getFilter() {
        return this.filter;
    }
}
