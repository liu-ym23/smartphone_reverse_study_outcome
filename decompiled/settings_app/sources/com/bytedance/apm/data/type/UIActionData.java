package com.bytedance.apm.data.type;

import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.data.ITypeData;
import com.bytedance.apm.samplers.SamplerHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class UIActionData implements ITypeData {
    public String action;
    public JSONObject context;
    public JSONObject extraJson;
    public String page;

    @Override // com.bytedance.apm.data.ITypeData
    public String getSubTypeLabel() {
        return "ui_action";
    }

    @Override // com.bytedance.apm.data.ITypeData
    public String getTypeLabel() {
        return "ui_action";
    }

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

    public UIActionData(String r1, String r2, JSONObject r3, JSONObject r4) {
        this.action = r1;
        this.page = r2;
        this.context = r3;
        this.extraJson = r4;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public JSONObject packLog() {
    L7:
        return null;
    L3:
        if (this.extraJson != null) goto L5;
        this.extraJson = new JSONObject();     // Catch: JSONException -> L7
    L5:
        this.extraJson.put("log_type", "ui_action");     // Catch: JSONException -> L7
        this.extraJson.put("action", this.action);     // Catch: JSONException -> L7
        this.extraJson.put("page", this.page);     // Catch: JSONException -> L7
        this.extraJson.put("context", this.context);     // Catch: JSONException -> L7
        return this.extraJson;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSampled(JSONObject r1) {
        return SamplerHelper.getPerfAllowSwitch(SlardarSettingsConsts.PERF_KEY_UI);
    }
}
