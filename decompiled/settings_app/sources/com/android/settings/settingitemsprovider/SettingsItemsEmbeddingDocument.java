package com.android.settings.settingitemsprovider;

import com.obric.search.sdk.embedding.document.IEmbeddingSearchTextDocument;

/* JADX INFO: loaded from: classes2.dex */
public class SettingsItemsEmbeddingDocument implements IEmbeddingSearchTextDocument {
    private final String mEmbeddingText;
    private final long mId;

    @Override // com.obric.search.api.document.intf.IDocument
    public String getSchemaName() {
        return SearchEngine.EMBEDDING_SCHEMA_NAME;
    }

    SettingsItemsEmbeddingDocument(long r1, String r3) {
        this.mId = r1;
        this.mEmbeddingText = r3;
    }

    @Override // com.obric.search.sdk.embedding.document.IEmbeddingSearchTextDocument
    public String toRawEmbeddingTextData() {
        return this.mEmbeddingText;
    }

    @Override // com.obric.search.api.document.intf.IDocument
    public long getId() {
        return this.mId;
    }
}
