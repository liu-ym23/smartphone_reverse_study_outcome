package com.bytedance.apm.impl;

import android.content.Context;
import androidx.annotation.Keep;
import com.bytedance.services.apm.api.EventConfig;
import com.bytedance.services.apm.api.IApmAgent;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class ApmAgentServiceImpl implements IApmAgent {
    public ApmAgentServiceImpl() {
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorCommonLog(String r1, JSONObject r2) {
        com.bytedance.apm.c.h(r1, r2);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorDuration(String r1, JSONObject r2, JSONObject r3) {
        com.bytedance.apm.c.j(r1, r2, r3);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorEvent(EventConfig r2) {
        com.bytedance.apm.config.d.b r1 = com.bytedance.apm.config.d.a();
        r1.l(r2.getServiceName());
        r1.m(r2.getStatus());
        r1.i(r2.getCategory());
        r1.k(r2.getMetric());
        r1.j(r2.getExtraLog());
        r1.h(r2.isUploadImmediate());
        com.bytedance.apm.c.k(r1.g());
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorEvent(String r1, JSONObject r2, JSONObject r3, JSONObject r4) {
        com.bytedance.apm.c.l(r1, r2, r3, r4);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorExceptionLog(String r1, JSONObject r2) {
        com.bytedance.apm.c.m(r1, r2);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorLog(String r1, JSONObject r2) {
        com.bytedance.apm.c.h(r1, r2);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorStatusAndDuration(String r1, int r2, JSONObject r3, JSONObject r4) {
        com.bytedance.apm.c.o(r1, r2, r3, r4);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorStatusRate(String r1, int r2, JSONObject r3) {
        com.bytedance.apm.c.p(r1, r2, r3);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void reportLegacyMonitorLog(Context r7, long r8, long r10, boolean r12) {
        com.bytedance.apm.c.u(com.bytedance.apm.d.h(), r8, r10, r12);
    }
}
