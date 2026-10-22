package com.obric.safecheck.data;

import com.obric.safecheck.database.entity.PkgSignItem;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ParsedPkgData extends ParsedData<PkgSignItem> {
    List<PkgSignItem> pkgSign;

    public ParsedPkgData() {
        this.pkgSign = new ArrayList();
    }

    @Override // com.obric.safecheck.data.ParsedData
    public int getCount() {
        List<PkgSignItem> r0 = this.pkgSign;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    @Override // com.obric.safecheck.data.ParsedData
    public List<PkgSignItem> getItems() {
        return this.pkgSign;
    }
}
