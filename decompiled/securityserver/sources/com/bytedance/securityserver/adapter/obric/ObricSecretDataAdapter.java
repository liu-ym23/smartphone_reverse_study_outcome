package com.bytedance.securityserver.adapter.obric;

import com.bytedance.securityserver.adapter.api.ISecretData;
import com.obric.security.secretdata.SecretData;

/* JADX INFO: loaded from: classes.dex */
public class ObricSecretDataAdapter implements ISecretData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SecretData f50a;

    public ObricSecretDataAdapter() {
        this.f50a = new SecretData();
    }

    @Override // com.bytedance.securityserver.adapter.api.ISecretData
    public final void a(String r1) {
        this.f50a.privateData = r1;
    }

    @Override // com.bytedance.securityserver.adapter.api.ISecretData
    public final void b() {
        this.f50a.alias = "oaid";
    }

    @Override // com.bytedance.securityserver.adapter.api.ISecretData
    public final String c() {
        return this.f50a.privateData;
    }

    @Override // com.bytedance.securityserver.adapter.api.ISecretData
    public final void d() {
        this.f50a.dataType = "device_oaid";
    }

    public ObricSecretDataAdapter(SecretData r1) {
        this.f50a = r1;
    }
}
