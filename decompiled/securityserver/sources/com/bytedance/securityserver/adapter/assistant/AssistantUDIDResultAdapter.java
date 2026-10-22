package com.bytedance.securityserver.adapter.assistant;

import com.aiassistant.security.keymanager.UDIDManagerResult;
import com.bytedance.securityserver.adapter.api.IUDIDResult;

/* JADX INFO: loaded from: classes.dex */
public class AssistantUDIDResultAdapter implements IUDIDResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UDIDManagerResult f48a;

    public AssistantUDIDResultAdapter(UDIDManagerResult r1) {
        this.f48a = r1;
    }

    @Override // com.bytedance.securityserver.adapter.api.IUDIDResult
    public final int a() {
        return this.f48a.getResultCode();
    }

    @Override // com.bytedance.securityserver.adapter.api.IUDIDResult
    public final String b() {
        return this.f48a.getUDIDValue();
    }
}
