package com.obric.search.api.migration;

import com.obric.search.api.schema.impl.FullTextSearchSchema;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AddFullTextSearchSchemaAction.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/search/api/migration/AddFullTextSearchSchemaAction;", "Lcom/obric/search/api/migration/IMigrationAction;", "schemaList", "", "Lcom/obric/search/api/schema/impl/FullTextSearchSchema;", "(Ljava/util/List;)V", "getSchemaList", "()Ljava/util/List;", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AddFullTextSearchSchemaAction implements IMigrationAction {
    private final List<FullTextSearchSchema> schemaList;

    public AddFullTextSearchSchemaAction(List<FullTextSearchSchema> r2) {
        Intrinsics.checkNotNullParameter(r2, "schemaList");
        this.schemaList = r2;
    }

    public final List<FullTextSearchSchema> getSchemaList() {
        return this.schemaList;
    }
}
