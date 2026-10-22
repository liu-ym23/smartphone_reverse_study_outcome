package com.bytedance.apm.data.type;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.ExceptionConsts;
import com.bytedance.apm.data.ITypeData;
import com.bytedance.apm.samplers.SamplerHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ExceptionLogData implements ITypeData {
    private String eventType;
    private boolean forceSampled;
    private JSONObject logJson;
    private long time;

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSaveImmediately() {
        return false;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isUploadImmediately() {
        return false;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean supportFetch() {
        return true;
    }

    public ExceptionLogData(String r3, JSONObject r4) {
        this(r3, r4, System.currentTimeMillis());
    }

    public ExceptionLogData(String r1, JSONObject r2, long r3) {
        this.eventType = r1;
        this.logJson = r2;
        this.time = r3;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public JSONObject packLog() {
        JSONObject r0 = this.logJson;
        if (r0 != null) goto L17;
        return null;
    L17:
        r0.put("timestamp", this.time);     // Catch: JSONException -> L15
        this.logJson.put(CommonKey.KEY_CRASH_TIME, this.time);     // Catch: JSONException -> L15
        this.logJson.put("is_main_process", ApmContext.isMainProcess());     // Catch: JSONException -> L15
        this.logJson.put("process_name", ApmContext.getCurrentProcessName());     // Catch: JSONException -> L15
        this.logJson.put("log_type", this.eventType);     // Catch: JSONException -> L15
        if (ApmContext.getAppLaunchStartTimestamp() <= ApmContext.getStartId()) goto L8;
    L10:
        this.logJson.put(ExceptionConsts.KEY_APP_START_TIME, ApmContext.getStartId());     // Catch: JSONException -> L15
    L16:
        goto L12
    L8:
        if (ApmContext.getAppLaunchStartTimestamp() == 0) goto L10;
        this.logJson.put(ExceptionConsts.KEY_APP_START_TIME, ApmContext.getAppLaunchStartTimestamp());     // Catch: JSONException -> L15
    L12:
        return this.logJson;
    }

    public void forceSample() {
        this.forceSampled = true;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSampled(JSONObject r1) {
        if (this.forceSampled == false) goto L5;
    L8:
        return true;
    L5:
        if (SamplerHelper.getPerfSecondStageSwitch(this.eventType) == true) goto L8;
        return false;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public String getTypeLabel() {
        return this.eventType;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public String getSubTypeLabel() {
        return this.eventType;
    }

    public long crashTime() {
        return this.time;
    }

    public JSONObject getLogJson() {
        return this.logJson;
    }

    public String toString() {
        return "ExceptionLogData{eventType='" + this.eventType + "', logJson=" + this.logJson + ", forceSampled=" + this.forceSampled + ", time=" + this.time + '}';
    }
}
