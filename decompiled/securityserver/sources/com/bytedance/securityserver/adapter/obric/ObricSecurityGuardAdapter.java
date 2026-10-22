package com.bytedance.securityserver.adapter.obric;

import android.security.obric.guard.ObricSecurityGuardStub;
import com.bytedance.securityserver.adapter.api.ISecurityGuard;

/* JADX INFO: loaded from: classes.dex */
public class ObricSecurityGuardAdapter implements ISecurityGuard {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObricSecurityGuardStub f52a;

    public ObricSecurityGuardAdapter(ObricSecurityGuardStub r1) {
        this.f52a = r1;
    }

    @Override // com.bytedance.securityserver.adapter.api.ISecurityGuard
    public final void a(String r1, String r2) {
        this.f52a.updatePolicyFile(r1, r2);
    }

    @Override // com.bytedance.securityserver.adapter.api.ISecurityGuard
    public final String b(String r1) {
        return this.f52a.getSecurityPolicy(r1);
    }

    @Override // com.bytedance.securityserver.adapter.api.ISecurityGuard
    public final void c(String r1, String r2) {
        this.f52a.updateMinPerPolicy(r1, r2);
    }
}
