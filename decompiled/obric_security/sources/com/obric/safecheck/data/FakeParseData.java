package com.obric.safecheck.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: FakeParseData.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/safecheck/data/FakeParseData;", "Lcom/obric/safecheck/data/ParsedData;", "Lcom/obric/safecheck/data/Directory;", "()V", "getCount", "", "getItems", "", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class FakeParseData extends ParsedData<Directory> {
    @Override // com.obric.safecheck.data.ParsedData
    public int getCount() {
        return 0;
    }

    public FakeParseData() {
    }

    @Override // com.obric.safecheck.data.ParsedData
    public List<Directory> getItems() {
        return CollectionsKt.emptyList();
    }
}
