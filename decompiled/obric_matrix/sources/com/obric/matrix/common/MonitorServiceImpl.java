package com.obric.matrix.common;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.c;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mpaas.monitor.IMonitorService;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016JP\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016JP\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016¨\u0006\u0016"}, d2 = {"Lcom/obric/matrix/common/MonitorServiceImpl;", "Lcom/bytedance/mpaas/monitor/IMonitorService;", "()V", "getLogTypeSwitch", "", WsConstants.KEY_CONNECTION_TYPE, "", "monitorApiError", "", TypedValues.TransitionType.S_DURATION, "", "sendTime", "sendUrl", "sendIp", "traceCode", "status", "", "netStatus", "extJson", "Lorg/json/JSONObject;", "monitorSLA", "sendDuration", "common_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MonitorServiceImpl implements IMonitorService {
    public MonitorServiceImpl() {
    }

    @Override // com.bytedance.mpaas.monitor.IMonitorService
    public boolean getLogTypeSwitch(String r1) {
        return c.f(r1);
    }

    @Override // com.bytedance.mpaas.monitor.IMonitorService
    public void monitorApiError(long r10, long r12, String r14, String r15, String r16, int r17, int r18, JSONObject r19) {
        c.g(r10, r12, r14, r15, r16, r17, r19);
    }

    @Override // com.bytedance.mpaas.monitor.IMonitorService
    public void monitorSLA(long r10, long r12, String r14, String r15, String r16, int r17, int r18, JSONObject r19) {
        c.n(r10, r12, r14, r15, r16, r17, r19);
    }
}
