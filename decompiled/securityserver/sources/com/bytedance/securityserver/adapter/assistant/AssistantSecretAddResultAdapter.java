package com.bytedance.securityserver.adapter.assistant;

import com.aiassistant.security.secretdata.AddResult;
import com.bytedance.securityserver.adapter.api.ISecretAddResult;

/* JADX INFO: loaded from: classes.dex */
public class AssistantSecretAddResultAdapter implements ISecretAddResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AddResult f44a;

    public AssistantSecretAddResultAdapter(AddResult r1) {
        this.f44a = r1;
    }

    @Override // com.bytedance.securityserver.adapter.api.ISecretAddResult
    public final int a() {
        return this.f44a.getResultCode();
    }
}
