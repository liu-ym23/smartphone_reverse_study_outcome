package com.bytedance.bdlocation.trace;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface LocationTraceListener {
    void onTraceFinish(String r1, JSONObject r2, JSONObject r3, JSONObject r4);
}
