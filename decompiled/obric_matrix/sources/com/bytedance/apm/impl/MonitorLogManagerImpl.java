package com.bytedance.apm.impl;

import com.bytedance.services.apm.api.IMonitorLogManager;
import com.bytedance.services.apm.api.IMonitorLogQueryCallback;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MonitorLogManagerImpl implements IMonitorLogManager {
    public MonitorLogManagerImpl() {
    }

    @Override // com.bytedance.services.apm.api.IMonitorLogManager
    public void deleteLegacyLogByIds(String r1, String r2) {
    }

    @Override // com.bytedance.services.apm.api.IMonitorLogManager
    public void getLegacyLog(long r1, long r3, String r5, IMonitorLogQueryCallback r6) {
    }

    @Override // com.bytedance.services.apm.api.IMonitorLogManager
    public List<JSONObject> getRecentUiActionRecords() {
        return com.bytedance.apm.t.e.a.b().c();
    }
}
