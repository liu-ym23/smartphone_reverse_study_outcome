package com.obric.search.api.schema.impl;

import com.obric.search.api.schema.intf.ISearchEngineSchemaContext;
import com.obric.search.storage.sqlite.SQLiteSearchEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FullTextSearchSchemaContext.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/search/api/schema/impl/FullTextSearchSchemaContext;", "Lcom/obric/search/api/schema/intf/ISearchEngineSchemaContext;", "sqLiteSearchEngine", "Lcom/obric/search/storage/sqlite/SQLiteSearchEngine;", "(Lcom/obric/search/storage/sqlite/SQLiteSearchEngine;)V", "getSqLiteSearchEngine", "()Lcom/obric/search/storage/sqlite/SQLiteSearchEngine;", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FullTextSearchSchemaContext implements ISearchEngineSchemaContext {
    private final SQLiteSearchEngine sqLiteSearchEngine;

    public FullTextSearchSchemaContext(SQLiteSearchEngine r2) {
        Intrinsics.checkNotNullParameter(r2, "sqLiteSearchEngine");
        this.sqLiteSearchEngine = r2;
    }

    public final SQLiteSearchEngine getSqLiteSearchEngine() {
        return this.sqLiteSearchEngine;
    }
}
