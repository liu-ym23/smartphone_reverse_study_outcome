package com.bytedance.securityserver.adapter.obric;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.securityserver.adapter.api.ISecretAddResult;
import com.bytedance.securityserver.adapter.api.ISecretData;
import com.bytedance.securityserver.adapter.api.ISecretDataManager;
import com.bytedance.securityserver.adapter.api.ISecretQueryResult;
import com.obric.security.secretdata.AddResult;
import com.obric.security.secretdata.QueryResult;
import com.obric.security.secretdata.SecretDataManager;

/* JADX INFO: loaded from: classes.dex */
public class ObricSecretDataManagerAdapter implements ISecretDataManager {
    @Override // com.bytedance.securityserver.adapter.api.ISecretDataManager
    public final ISecretData a() {
        return new ObricSecretDataAdapter();
    }

    @Override // com.bytedance.securityserver.adapter.api.ISecretDataManager
    public final ISecretQueryResult b(Context r2, Bundle r3) {
        QueryResult r1 = SecretDataManager.getInstance().queryData(r2, "oaid", r3);
        if (r1 != null) goto L7;
        return null;
    L7:
        return new ObricSecretQueryResultAdapter(r1);
    }

    @Override // com.bytedance.securityserver.adapter.api.ISecretDataManager
    public final ISecretAddResult c(Context r1, ISecretData r2, Bundle r3) {
        AddResult r0 = SecretDataManager.getInstance().addData(r1, ((ObricSecretDataAdapter) r2).f50a, r3);
        if (r0 != null) goto L7;
        return null;
    L7:
        return new ObricSecretAddResultAdapter(r0);
    }

    @Override // com.bytedance.securityserver.adapter.api.ISecretDataManager
    public final int d(Context r1, ISecretData r2, Bundle r3) {
        return SecretDataManager.getInstance().updateData(r1, ((ObricSecretDataAdapter) r2).f50a, r3);
    }
}
