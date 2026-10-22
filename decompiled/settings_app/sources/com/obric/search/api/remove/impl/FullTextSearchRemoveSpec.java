package com.obric.search.api.remove.impl;

import com.obric.search.api.document.intf.IDocument;
import com.obric.search.api.remove.intf.IRemoveSpec;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FullTextSearchRemoveSpec.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/search/api/remove/impl/FullTextSearchRemoveSpec;", "Lcom/obric/search/api/remove/intf/IRemoveSpec;", "schemaName", "", "list", "", "Lcom/obric/search/api/document/intf/IDocument;", "removeAll", "", "(Ljava/lang/String;Ljava/util/List;Z)V", "getList", "()Ljava/util/List;", "getRemoveAll", "()Z", "getSchemaName", "()Ljava/lang/String;", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FullTextSearchRemoveSpec implements IRemoveSpec {
    private final List<IDocument> list;
    private final boolean removeAll;
    private final String schemaName;

    public FullTextSearchRemoveSpec(String r8) {
        Intrinsics.checkNotNullParameter(r8, "schemaName");
        this(r8, null, false, 6, null);
    }

    public FullTextSearchRemoveSpec(String r8, List<? extends IDocument> r9) {
        Intrinsics.checkNotNullParameter(r8, "schemaName");
        Intrinsics.checkNotNullParameter(r9, "list");
        this(r8, r9, false, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FullTextSearchRemoveSpec(String r2, List<? extends IDocument> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "schemaName");
        Intrinsics.checkNotNullParameter(r3, "list");
        this.schemaName = r2;
        this.list = r3;
        this.removeAll = r4;
    }

    @Override // com.obric.search.api.remove.intf.IRemoveSpec
    public String getSchemaName() {
        return this.schemaName;
    }

    public /* synthetic */ FullTextSearchRemoveSpec(String r1, List r2, boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = CollectionsKt.emptyList();
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = false;
    L8:
        this(r1, r2, r3);
    }

    public final List<IDocument> getList() {
        return this.list;
    }

    public final boolean getRemoveAll() {
        return this.removeAll;
    }
}
