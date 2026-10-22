package com.obric.search.sdk.embedding.shema;

import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.search.api.schema.intf.ISearchEngineSchemaContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EmbeddingSearchSchemaContext.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/search/sdk/embedding/shema/EmbeddingSearchSchemaContext;", "Lcom/obric/search/api/schema/intf/ISearchEngineSchemaContext;", "aiKernelManager", "Lcom/obric/aikernel/phx/sdk/AIKernelManager;", "(Lcom/obric/aikernel/phx/sdk/AIKernelManager;)V", "getAiKernelManager", "()Lcom/obric/aikernel/phx/sdk/AIKernelManager;", "embeddingPlugin_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EmbeddingSearchSchemaContext implements ISearchEngineSchemaContext {
    private final AIKernelManager aiKernelManager;

    public EmbeddingSearchSchemaContext(AIKernelManager r2) {
        Intrinsics.checkNotNullParameter(r2, "aiKernelManager");
        this.aiKernelManager = r2;
    }

    public final AIKernelManager getAiKernelManager() {
        return this.aiKernelManager;
    }
}
