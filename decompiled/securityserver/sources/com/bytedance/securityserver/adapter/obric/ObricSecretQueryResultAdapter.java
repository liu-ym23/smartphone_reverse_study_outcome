package com.bytedance.securityserver.adapter.obric;

import com.bytedance.securityserver.adapter.api.ISecretQueryResult;
import com.obric.security.secretdata.QueryResult;
import com.obric.security.secretdata.SecretData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ObricSecretQueryResultAdapter implements ISecretQueryResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final QueryResult f51a;

    public ObricSecretQueryResultAdapter(QueryResult r1) {
        this.f51a = r1;
    }

    @Override // com.bytedance.securityserver.adapter.api.ISecretQueryResult
    public final int a() {
        return this.f51a.getResultCode();
    }

    @Override // com.bytedance.securityserver.adapter.api.ISecretQueryResult
    public final ArrayList b() {
        List r3 = this.f51a.getDataList();
        if (r3 != null) goto L6;
        return null;
    L6:
        ArrayList r0 = new ArrayList(r3.size());
        Iterator r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r0.add(new ObricSecretDataAdapter((SecretData) r4.next()));
        goto L8
    L10:
        return r0;
    }
}
