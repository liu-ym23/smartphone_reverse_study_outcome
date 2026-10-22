package com.bytedance.securityserver.adapter.obric;

import com.bytedance.securityserver.adapter.api.IUDIDResult;
import com.obric.security.keymanager.UDIDManagerResult;

/* JADX INFO: loaded from: classes.dex */
public class ObricUDIDResultAdapter implements IUDIDResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UDIDManagerResult f53a;

    public ObricUDIDResultAdapter(UDIDManagerResult r1) {
        this.f53a = r1;
    }

    @Override // com.bytedance.securityserver.adapter.api.IUDIDResult
    public final int a() {
        return this.f53a.getResultCode();
    }

    @Override // com.bytedance.securityserver.adapter.api.IUDIDResult
    public final String b() {
        return this.f53a.getUDIDValue();
    }
}
