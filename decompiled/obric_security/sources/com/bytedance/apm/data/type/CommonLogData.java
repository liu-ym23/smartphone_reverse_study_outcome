package com.bytedance.apm.data.type;

import com.bytedance.apm.data.ITypeData;
import com.bytedance.apm.samplers.SamplerHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CommonLogData implements ITypeData {
    public boolean isSaveDBImmediate;
    public JSONObject logJson;
    public String logType;

    @Override // com.bytedance.apm.data.ITypeData
    public String getTypeLabel() {
        return "common_log";
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isUploadImmediately() {
        return false;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean supportFetch() {
        return true;
    }

    public CommonLogData(String r1, JSONObject r2, boolean r3) {
        this.logType = r1;
        this.logJson = r2;
        this.isSaveDBImmediate = r3;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public JSONObject packLog() {
        JSONObject r0 = this.logJson;
        if (r0 != null) goto L10;
        return null;
    L10:
        r0.put("log_type", this.logType);     // Catch: JSONException -> L9
    L6:
        return this.logJson;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSampled(JSONObject r1) {
        return SamplerHelper.getLogTypeSwitch(this.logType);
    }

    @Override // com.bytedance.apm.data.ITypeData
    public String getSubTypeLabel() {
        return this.logType;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSaveImmediately() {
        return this.isSaveDBImmediate;
    }
}
