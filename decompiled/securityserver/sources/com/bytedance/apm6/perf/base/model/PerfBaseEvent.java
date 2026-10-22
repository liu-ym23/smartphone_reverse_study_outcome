package com.bytedance.apm6.perf.base.model;

import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.util.JsonUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class PerfBaseEvent implements Monitorable {
    protected static final String KEY_IS_FRONT = "is_front";
    protected static final String KEY_IS_MAIN_PROCESS = "is_main_process";
    protected static final String KEY_PROCESS_NAME = "process_name";
    protected final String KEY_EXTRA_STATUS;
    protected final String KEY_EXTRA_VALUES;
    protected final String KEY_FILTERS;
    protected final String KEY_LOG_TYPE;
    protected final String KEY_SCENE;
    protected final String KEY_SERVICE;
    private JSONObject logExtr;

    public PerfBaseEvent() {
        this.KEY_LOG_TYPE = "log_type";
        this.KEY_EXTRA_STATUS = CommonKey.KEY_EXTRA_STATUS;
        this.KEY_EXTRA_VALUES = CommonKey.KEY_EXTRA_VALUES;
        this.KEY_FILTERS = "filters";
        this.KEY_SERVICE = "service";
        this.KEY_SCENE = "scene";
    }

    public JSONObject createRootJSONObject() {
        return new JSONObject();
    }

    public JSONObject getExtraStatus() {
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L4
        r2.put("scene", PerfFilterManager.getInstance().getSceneString());     // Catch: Throwable -> L4
        r2.put("process_name", ApmContext.getCurrentProcessName());     // Catch: Throwable -> L4
        r2.put("is_main_process", ApmContext.isMainProcess());     // Catch: Throwable -> L4
        return r2;
    L4:
        return null;
    }

    public abstract JSONObject getExtraValues();

    public abstract JSONObject getFilters();

    @Override // com.bytedance.apm6.monitor.Monitorable
    public String getLogType() {
        return "performance_monitor";
    }

    public abstract String getServiceName();

    @Override // com.bytedance.apm6.monitor.Monitorable
    public JSONObject toJsonObject() {
    L16:
        return null;
    L3:
        if (this.logExtr != null) goto L5;
        this.logExtr = createRootJSONObject();     // Catch: JSONException -> L16
    L5:
        this.logExtr.put("log_type", "performance_monitor");     // Catch: JSONException -> L16
        this.logExtr.put("service", getServiceName());     // Catch: JSONException -> L16
        JSONObject r0 = getExtraValues();     // Catch: JSONException -> L16
        if (JsonUtils.isEmpty(r0) == true) goto L8;
        this.logExtr.put(CommonKey.KEY_EXTRA_VALUES, r0);     // Catch: JSONException -> L16
    L8:
        JSONObject r1 = getExtraStatus();     // Catch: JSONException -> L16
        if (JsonUtils.isEmpty(r1) == true) goto L11;
        this.logExtr.put(CommonKey.KEY_EXTRA_STATUS, r1);     // Catch: JSONException -> L16
    L11:
        JSONObject r2 = getFilters();     // Catch: JSONException -> L16
        if (JsonUtils.isEmpty(r2) == true) goto L14;
        this.logExtr.put("filters", r2);     // Catch: JSONException -> L16
    L14:
        return this.logExtr;
    }
}
