package com.obric.search.sdk.embedding.document;

import android.net.Uri;
import com.obric.search.api.document.intf.IDocument;
import kotlin.Metadata;

/* JADX INFO: compiled from: IEmbeddingSearchImageDocument.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/obric/search/sdk/embedding/document/IEmbeddingSearchImageDocument;", "Lcom/obric/search/api/document/intf/IDocument;", "afterEmbedding", "", "beforeEmbedding", "toRawEmbeddingImageFilePath", "Landroid/net/Uri;", "embeddingPlugin_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IEmbeddingSearchImageDocument extends IDocument {
    void afterEmbedding();

    void beforeEmbedding();

    Uri toRawEmbeddingImageFilePath();
}
