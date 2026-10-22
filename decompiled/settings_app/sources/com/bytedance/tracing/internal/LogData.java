package com.bytedance.tracing.internal;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class LogData {
    private final Map<String, String> fields;
    private final String message;
    private final long timestamp;

    public LogData(long r1, String r3, Map<String, String> r4) {
        this.timestamp = r1;
        this.message = r3;
        this.fields = r4;
    }

    public JSONObject toJson() {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L8
        r0.put("timestamp", this.timestamp);     // Catch: JSONException -> L8
        r0.put("message", this.message);     // Catch: JSONException -> L8
        Map<String, String> r1 = this.fields;     // Catch: JSONException -> L8
        if (r1 != null) goto L5;
    L7:
        return r0;
    L5:
        if (r1.size() <= 0) goto L7;
        r0.put(TracingConstants.KEY_FIELDS, new JSONObject(this.fields));     // Catch: JSONException -> L8
    L8:
        return null;
    }
}
