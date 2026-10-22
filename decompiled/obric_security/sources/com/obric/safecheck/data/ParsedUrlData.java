package com.obric.safecheck.data;

import com.obric.safecheck.database.entity.UrlDomainItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: ParsedUrlData.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/safecheck/data/ParsedUrlData;", "Lcom/obric/safecheck/data/ParsedData;", "Lcom/obric/safecheck/database/entity/UrlDomainItem;", "()V", "urlDomainItems", "", "getCount", "", "getItems", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class ParsedUrlData extends ParsedData<UrlDomainItem> {
    private List<UrlDomainItem> urlDomainItems;

    public ParsedUrlData() {
        this.urlDomainItems = new ArrayList();
    }

    @Override // com.obric.safecheck.data.ParsedData
    public List<UrlDomainItem> getItems() {
        List<UrlDomainItem> r0 = this.urlDomainItems;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.safecheck.data.ParsedData
    public int getCount() {
        List<UrlDomainItem> r0 = this.urlDomainItems;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }
}
