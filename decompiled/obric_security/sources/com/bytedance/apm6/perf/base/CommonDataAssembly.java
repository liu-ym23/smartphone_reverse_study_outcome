package com.bytedance.apm6.perf.base;

import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.data.type.PerfData;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CommonDataAssembly {
    public CommonDataAssembly() {
    }

    public static void wrapPerfException(JSONObject r3, String r4) throws JSONException {
        r3.put("timestamp", System.currentTimeMillis());
        r3.put(CommonKey.KEY_CRASH_TIME, System.currentTimeMillis());
        r3.put("is_main_process", ApmContext.isMainProcess());
        r3.put("process_name", ApmContext.getCurrentProcessName());
        r3.put("event_type", r4);
        r3.put("scene", ActivityLifeObserver.getInstance().getTopActivityClassName());
    }

    public static void wrapPerfStatus(PerfData r5) {
        String r1 = PerfFilterManager.getInstance().getSceneString();
        JSONObject r2 = r5.extraStatus;
        if (r2 != null) goto L14;
        r2 = new JSONObject();
    L14:
        if (TextUtils.isEmpty(r1) == false) goto L8;
        r1 = ActivityLifeObserver.getInstance().getTopActivityClassName();     // Catch: JSONException -> L13
    L8:
        r2.put("scene", r1);     // Catch: JSONException -> L13
        r2.put("process_name", ApmContext.getCurrentProcessName());     // Catch: JSONException -> L13
        r2.put("is_main_process", ApmContext.isMainProcess());     // Catch: JSONException -> L13
        if (r2.isNull(CommonKey.KEY_IS_FRONT) == false) goto L11;
        r2.put(CommonKey.KEY_IS_FRONT, ActivityLifeObserver.getInstance().isForeground());     // Catch: JSONException -> L13
    L11:
        r5.extraStatus = r2;     // Catch: JSONException -> L13
        return;
    }

    public static void wrapFilters(PerfData r1, boolean r2) {
        r1.appendFilters(PerfFilterManager.getInstance().getPerfFiltersJson(r2));
    }
}
