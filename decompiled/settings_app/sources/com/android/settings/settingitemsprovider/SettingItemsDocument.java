package com.android.settings.settingitemsprovider;

import android.content.ContentValues;
import com.obric.search.api.document.intf.IFullTextSearchDocument;

/* JADX INFO: loaded from: classes2.dex */
public class SettingItemsDocument implements IFullTextSearchDocument {
    private final String mAlias;
    private final long mId;
    private final String mName;

    @Override // com.obric.search.api.document.intf.IDocument
    public String getSchemaName() {
        return SearchEngine.SCHEMA_NAME;
    }

    SettingItemsDocument(long r1, String r3, String r4) {
        this.mId = r1;
        this.mName = r3;
        this.mAlias = r4;
    }

    @Override // com.obric.search.api.document.intf.IDocument
    public long getId() {
        return this.mId;
    }

    @Override // com.obric.search.api.document.intf.IFullTextSearchDocument
    public ContentValues toContentValues() {
        ContentValues r0 = new ContentValues();
        r0.put("name", this.mName);
        return r0;
    }
}
