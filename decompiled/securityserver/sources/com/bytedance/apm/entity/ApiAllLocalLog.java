package com.bytedance.apm.entity;

import com.bytedance.apm.constant.TrafficConsts;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ApiAllLocalLog extends LocalLog {
    public int front;
    public int hitRules;
    public int net;
    public long sid;
    public long trafficValue;

    public ApiAllLocalLog() {
    }

    @Override // com.bytedance.apm.entity.LocalLog
    public LocalLog setData(JSONObject r6) {
        this.front = r6.optInt("front");
        this.sid = r6.optLong("sid");
        this.net = r6.optInt("network_type");
        this.hitRules = r6.optInt("hit_rules");
        long r3 = r6.optLong(TrafficConsts.KEY_SENT_BYTES, 0);
        this.trafficValue = r6.optLong(TrafficConsts.KEY_RECEIVED_BYTES, 0) + r3;
        return super.setData(r6);
    }

    public ApiAllLocalLog(long r1, String r3, long r4, JSONObject r6) {
        super(r1, r3, r4, r6);
    }

    public ApiAllLocalLog(long r1, String r3, long r4, String r6) {
        super(r1, r3, r4, r6);
    }
}
