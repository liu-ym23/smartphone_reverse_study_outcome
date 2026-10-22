package com.bytedance.securityserver.adapter;

import android.util.Log;
import com.bytedance.securityserver.adapter.api.ITeaReportBridge;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class OceanTeaReportBridge implements ITeaReportBridge {
    @Override // com.bytedance.securityserver.adapter.api.ITeaReportBridge
    public final void a(JSONObject r3) {
        MatrixTeaManager.Companion.getInstance().onEvent("security_audit_report_result", r3);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        if (th.getMessage() != null) goto L9;
        String r4 = th.getClass().getSimpleName();
    L10:
        Log.e("OceanTeaReportBridge", "onEvent failed: " + r4);
        throw new IllegalStateException("Ocean Tea onEvent failed", th);
    L9:
        r4 = th.getMessage();
        goto L10
    }

    @Override // com.bytedance.securityserver.adapter.api.ITeaReportBridge
    public final boolean isInitialized() {
        MatrixTeaManager.Companion r0 = MatrixTeaManager.Companion;     // Catch: Throwable -> L9
        if (r0.isInited() == false) goto L12;
        if (r0.getInstance() == null) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }
}
