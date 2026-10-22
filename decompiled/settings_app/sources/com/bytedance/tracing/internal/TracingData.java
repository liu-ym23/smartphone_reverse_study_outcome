package com.bytedance.tracing.internal;

import com.bytedance.apm.data.ITypeData;
import com.bytedance.apm.launch.LaunchCommon;
import com.bytedance.apm.samplers.SamplerHelper;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class TracingData implements ITypeData {
    private final boolean isErrorTag;
    private final JSONObject jsonObject;
    private final String serviceName;
    private final String subType;

    @Override // com.bytedance.apm.data.ITypeData
    public String getTypeLabel() {
        return "tracing";
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
        return false;
    }

    public TracingData(JSONObject r1, String r2, boolean r3, String r4) {
        this.jsonObject = r1;
        this.serviceName = r2;
        this.isErrorTag = r3;
        this.subType = r4;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public JSONObject packLog() {
        return this.jsonObject;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSampled(JSONObject r2) {
        if (LaunchCommon.LAUNCH_TASK_TRACING_SERVICE_NAME.equals(this.serviceName) == false) goto L7;
        return SamplerHelper.getPerfAllowSwitch("start_trace");
    L7:
        if (TraceSettings.getInstance().isErrorOrSampleHit(this.isErrorTag, this.serviceName) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public String getSubTypeLabel() {
        return this.subType;
    }
}
