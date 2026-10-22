package com.bytedance.apm.agent.tracing;

import com.bytedance.apm.agent.logging.AgentLog;
import com.bytedance.apm.agent.logging.AgentLogManager;
import com.bytedance.apm.constant.AgentConstants;
import com.bytedance.apm.util.ThreadUtils;
import java.util.HashSet;
import java.util.Stack;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TraceMachine {
    private static final String TAG = "TraceMachine";
    private static AgentLog log;
    private static HashSet<String> sMethodSet;
    private static ThreadLocal<Stack<Trace>> traceStackThreadLocal;

    static {
        traceStackThreadLocal = new ThreadLocal();
        sMethodSet = new HashSet(32);
        log = AgentLogManager.getAgentLog();
    }

    public TraceMachine() {
    }

    public static void enterMethod(String r8, String r9, String r10, String r11) {
        Trace r7 = new Trace(r8, r9, r10, System.currentTimeMillis(), r11);
        if (traceStackThreadLocal.get() != null) goto L5;
        Stack<Trace> r12 = new Stack();
        r12.push(r7);
        traceStackThreadLocal.set(r12);
        return;
    L5:
        traceStackThreadLocal.get().push(r7);
    }

    public static void exitMethod() {
        exitMethod("");
    }

    @Deprecated
    private static void handleCost(Trace r9) {
        long r1 = r9.entryTime;     // Catch: Exception -> L8
        long r3 = r9.exitTime;     // Catch: Exception -> L8
        long r5 = r3 - r1;     // Catch: Exception -> L8
        if (r5 <= 0) goto L21;
        JSONObject r7 = new JSONObject();     // Catch: Exception -> L8
        r7.put(AgentConstants.BEGIN_TIME, r1);     // Catch: Exception -> L8
        r7.put("end_time", r3);     // Catch: Exception -> L8
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L8
        if ("page_load".equals(r9.traceType) == false) goto L10;
        r2.put(r9.methodName, r5);     // Catch: Exception -> L8
    L11:
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L8
        if ("page_load".equals(r9.traceType) == false) goto L14;
        r4.put("scene", r9.scene);     // Catch: Exception -> L8
        r4.put("is_first", !sMethodSet.contains(r9.className + r9.methodName));     // Catch: Exception -> L8
        sMethodSet.add(r9.className + r9.methodName);     // Catch: Exception -> L8
    L15:
        r7.put("extra_data", r9.extraData);     // Catch: Exception -> L8
        return;
    L14:
        r4.put("is_main", ThreadUtils.isMainThread());     // Catch: Exception -> L8
        goto L15
    L10:
        r2.put(r9.className + "#" + r9.methodName, r5);     // Catch: Exception -> L8
        goto L11
    L21:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    public static void exitMethod(String r3) {
        if (traceStackThreadLocal.get() != null) goto L5;
        return;
    L5:
        Stack<Trace> r0 = traceStackThreadLocal.get();
        if (r0.isEmpty() == true) goto L9;
        Trace r1 = r0.pop();
        r1.setExitTime(System.currentTimeMillis());
        r1.setExtraData(r3);
        handleCost(r1);
        return;
    }

    public static void enterMethod(String r0, String r1, String r2) {
        enterMethod(r0, r0, r1, r2);
    }
}
