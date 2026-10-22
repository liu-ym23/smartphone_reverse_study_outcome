package com.obric.search.api.schema.intf;

import com.obric.search.api.document.intf.IDocument;
import com.obric.search.api.remove.intf.IRemoveSpec;
import com.obric.search.api.search.intf.ISearchSpec;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: ISearchEngineSchemaExecutor.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003H&J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/obric/search/api/schema/intf/ISearchEngineSchemaExecutor;", "", "getDocumentsId", "", "", "searchSpec", "Lcom/obric/search/api/search/intf/ISearchSpec;", "putDocuments", "", "list", "Lcom/obric/search/api/document/intf/IDocument;", "removeDocuments", "removeSpec", "Lcom/obric/search/api/remove/intf/IRemoveSpec;", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface ISearchEngineSchemaExecutor {
    List<Long> getDocumentsId(ISearchSpec r1);

    boolean putDocuments(List<? extends IDocument> r1);

    boolean removeDocuments(IRemoveSpec r1);
}
