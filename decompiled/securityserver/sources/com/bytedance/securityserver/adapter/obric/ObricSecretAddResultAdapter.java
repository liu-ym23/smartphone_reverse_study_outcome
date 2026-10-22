package com.bytedance.securityserver.adapter.obric;

import com.bytedance.securityserver.adapter.api.ISecretAddResult;
import com.obric.security.secretdata.AddResult;

/* JADX INFO: loaded from: classes.dex */
public class ObricSecretAddResultAdapter implements ISecretAddResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AddResult f49a;

    public ObricSecretAddResultAdapter(AddResult r1) {
        this.f49a = r1;
    }

    @Override // com.bytedance.securityserver.adapter.api.ISecretAddResult
    public final int a() {
        return this.f49a.getResultCode();
    }
}
