package com.obric.search.api.document.intf;

import android.content.ContentValues;
import kotlin.Metadata;

/* JADX INFO: compiled from: IFullTextSearchDocument.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/obric/search/api/document/intf/IFullTextSearchDocument;", "Lcom/obric/search/api/document/intf/IDocument;", "toContentValues", "Landroid/content/ContentValues;", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IFullTextSearchDocument extends IDocument {

    /* JADX INFO: compiled from: IFullTextSearchDocument.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static ContentValues toContentValues(IFullTextSearchDocument r0) {
            return new ContentValues();
        }
    }

    ContentValues toContentValues();
}
