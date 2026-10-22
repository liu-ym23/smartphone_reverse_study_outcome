package com.bytedance.securityserver.adapter.assistant;

import com.aiassistant.security.secretdata.SecretData;
import com.bytedance.securityserver.adapter.api.ISecretData;

/* JADX INFO: loaded from: classes.dex */
public class AssistantSecretDataAdapter implements ISecretData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SecretData f45a;

    public AssistantSecretDataAdapter() {
        this.f45a = new SecretData();
    }

    @Override // com.bytedance.securityserver.adapter.api.ISecretData
    public final void a(String r1) {
        this.f45a.privateData = r1;
    }

    @Override // com.bytedance.securityserver.adapter.api.ISecretData
    public final void b() {
        this.f45a.alias = "oaid";
    }

    @Override // com.bytedance.securityserver.adapter.api.ISecretData
    public final String c() {
        return this.f45a.privateData;
    }

    @Override // com.bytedance.securityserver.adapter.api.ISecretData
    public final void d() {
        this.f45a.dataType = "device_oaid";
    }

    public AssistantSecretDataAdapter(SecretData r1) {
        this.f45a = r1;
    }
}
