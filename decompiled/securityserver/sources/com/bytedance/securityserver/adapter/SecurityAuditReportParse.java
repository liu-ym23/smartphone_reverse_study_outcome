package com.bytedance.securityserver.adapter;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.securityserver.adapter.api.ISecurityAuditReportResult;
import com.bytedance.securityserver.robotspolicy.RobotsPolicyContract;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class SecurityAuditReportParse implements ISecurityAuditReportResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f39a;
    public final String b;
    public final long c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f40d;

    public SecurityAuditReportParse(String r7) {
        this.f39a = r7;
        JSONObject r1 = null;
        if (TextUtils.isEmpty(r7) == false) goto L41;
    L9:
        String r8 = "";
        if (r1 == null) goto L23;
        String r0 = r1.optString("batch_id", "");
        if (TextUtils.isEmpty(r0) == false) goto L16;
        r0 = r1.optString("batchId", "");
    L16:
        if (TextUtils.isEmpty(r0) == true) goto L18;
    L22:
        r8 = r0;
        goto L23
    L18:
        if (r1.has("block_seq") == false) goto L22;
        long r2 = r1.optLong("block_seq", -1);
        if (r2 < 0) goto L22;
        r8 = String.valueOf(r2);
    L23:
        this.b = r8;
        long r3 = System.currentTimeMillis();
        if (r1 != null) goto L27;
    L30:
        this.c = r3;
        if (r1 != null) goto L34;
        int r4 = 1;
    L37:
        this.f40d = r4;
        if (r1 == null) goto L43;
        r1.optBoolean("success", true);
        return;
    L43:
        return;
    L34:
        if (r1.has(RobotsPolicyContract.COL_VERSION) == false) goto L36;
        r4 = r1.optInt(RobotsPolicyContract.COL_VERSION, 1);
        goto L37
    L36:
        r4 = r1.optInt("report_version", 1);
        goto L37
    L27:
        if (r1.has("report_time") == false) goto L29;
        r3 = r1.optLong("report_time", r3);
        goto L30
    L29:
        r3 = r1.optLong("reportTime", r3);
        goto L30
    L41:
        r1 = new JSONObject(r7);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        Log.w("AuditReportParse", "parse report json failed", th);
        goto L9
    }

    @Override // com.bytedance.securityserver.adapter.api.ISecurityAuditReportResult
    public final String a() {
        return this.b;
    }

    @Override // com.bytedance.securityserver.adapter.api.ISecurityAuditReportResult
    public final int b() {
        return this.f40d;
    }

    @Override // com.bytedance.securityserver.adapter.api.ISecurityAuditReportResult
    public final long c() {
        return this.c;
    }
}
