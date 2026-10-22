package com.bytedance.securityserver.adapter.obric;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.securityserver.adapter.SecurityAuditReportParse;
import com.bytedance.securityserver.adapter.api.ISecurityAuditReportManager;
import com.obric.security.audit.SecurityAuditManager;

/* JADX INFO: loaded from: classes.dex */
public class ObricSecurityAuditReportManagerAdapter implements ISecurityAuditReportManager {
    @Override // com.bytedance.securityserver.adapter.api.ISecurityAuditReportManager
    public final int a(String r2) {
        return SecurityAuditManager.confirmUploadSuccess(r2);
    L4:
        e = move-exception;
        Log.e("ObricAuditReportAdapter", "confirmUploadSuccess failed", e);
        return 100;
    }

    @Override // com.bytedance.securityserver.adapter.api.ISecurityAuditReportManager
    public final int b(String r2) {
        return SecurityAuditManager.confirmUploadFailure(r2, 1, "SecurityServer encrypt/upload failed");
    L5:
        e = move-exception;
        Log.e("ObricAuditReportAdapter", "confirmUploadFailure failed", e);
        return 100;
    }

    @Override // com.bytedance.securityserver.adapter.api.ISecurityAuditReportManager
    public final int c() {
        return SecurityAuditManager.getPendingUploadCount();
    L4:
        e = move-exception;
        Log.e("ObricAuditReportAdapter", "getPendingUploadCount failed", e);
        return 0;
    }

    @Override // com.bytedance.securityserver.adapter.api.ISecurityAuditReportManager
    public final SecurityAuditReportParse d() {
        String r3 = SecurityAuditManager.getPendingUploadReport(1000, 0);     // Catch: Exception -> L8
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return null;
    L6:
        return new SecurityAuditReportParse(r3);
    L8:
        e = move-exception;
        Log.e("ObricAuditReportAdapter", "getPendingUploadReport failed", e);
        return null;
    }
}
