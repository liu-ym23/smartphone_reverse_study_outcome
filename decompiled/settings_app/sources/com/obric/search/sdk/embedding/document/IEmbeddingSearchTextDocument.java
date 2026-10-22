package com.obric.search.sdk.embedding.document;

import com.obric.search.api.document.intf.IDocument;
import kotlin.Metadata;

/* JADX INFO: compiled from: IEmbeddingSearchTextDocument.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/search/sdk/embedding/document/IEmbeddingSearchTextDocument;", "Lcom/obric/search/api/document/intf/IDocument;", "toRawEmbeddingTextData", "", "embeddingPlugin_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IEmbeddingSearchTextDocument extends IDocument {
    String toRawEmbeddingTextData();
}
