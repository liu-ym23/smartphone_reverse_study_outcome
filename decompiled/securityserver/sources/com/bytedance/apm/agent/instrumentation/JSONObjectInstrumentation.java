package com.bytedance.apm.agent.instrumentation;

import com.bytedance.apm.agent.tracing.TraceMachine;
import com.bytedance.apm.constant.AgentConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class JSONObjectInstrumentation {
    private static final String TAG = "JSONInstrumentation";

    public JSONObjectInstrumentation() {
    }

    public static JSONObject init(String r3) {
        TraceMachine.enterMethod("JSONObject", "init", AgentConstants.TRACE_TYPE_JSON);
        JSONObject r0 = new JSONObject(r3);
        TraceMachine.exitMethod();
        return r0;
    }
}
