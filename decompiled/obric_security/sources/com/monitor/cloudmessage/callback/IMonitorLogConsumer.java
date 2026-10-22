package com.monitor.cloudmessage.callback;

import com.bytedance.services.apm.api.IMonitorLogQueryCallback;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface IMonitorLogConsumer {
    void handleLogData(long r1, long r3, String r5, IMonitorLogQueryCallback r6);

    void notifyLogDataConsumed(String r1, String r2);

    String[] parseLogType(JSONObject r1);
}
