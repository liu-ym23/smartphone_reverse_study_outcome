package com.bytedance.securityserver.adapter.assistant;

import android.security.aiassistant.guard.AssistantSecurityGuardStub;
import com.bytedance.securityserver.adapter.api.ISecurityGuard;

/* JADX INFO: loaded from: classes.dex */
public class AssistantSecurityGuardAdapter implements ISecurityGuard {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AssistantSecurityGuardStub f47a;

    public AssistantSecurityGuardAdapter(AssistantSecurityGuardStub r1) {
        this.f47a = r1;
    }

    @Override // com.bytedance.securityserver.adapter.api.ISecurityGuard
    public final void a(String r1, String r2) {
        this.f47a.updatePolicyFile(r1, r2);
    }

    @Override // com.bytedance.securityserver.adapter.api.ISecurityGuard
    public final String b(String r1) {
        return this.f47a.getSecurityPolicy(r1);
    }

    @Override // com.bytedance.securityserver.adapter.api.ISecurityGuard
    public final void c(String r1, String r2) {
        this.f47a.updateMinPerPolicy(r1, r2);
    }
}
