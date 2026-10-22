package com.monitor.cloudmessage.internal.data.stat;

import com.monitor.cloudmessage.internal.data.IDataProvider;
import com.monitor.cloudmessage.utils.SystemUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SystemInfoDataProvider implements IDataProvider<JSONObject> {
    public SystemInfoDataProvider() {
    }

    @Override // com.monitor.cloudmessage.internal.data.IDataProvider
    public /* bridge */ /* synthetic */ JSONObject provideData() {
        return provideData2();
    }

    @Override // com.monitor.cloudmessage.internal.data.IDataProvider
    /* JADX INFO: renamed from: provideData, reason: avoid collision after fix types in other method */
    public JSONObject provideData2() {
        JSONObject r0 = new JSONObject();
        r0.put("used_memory", SystemUtils.getUseMemory() + "MB");     // Catch: JSONException -> L8
        r0.put("total_memory", SystemUtils.getTotalMemory() + "MB");     // Catch: JSONException -> L8
        r0.put("sd_all_size", SystemUtils.getSDCardMemory()[0] + "MB");     // Catch: JSONException -> L8
        r0.put("sd_avail_size", SystemUtils.getSDCardMemory()[1] + "MB");     // Catch: JSONException -> L8
        String r8 = "";
        String[] r1 = SystemUtils.getCpuInfo();     // Catch: JSONException -> L8
        int r2 = r1.length;     // Catch: JSONException -> L8
        int r3 = 0;
    L4:
        if (r3 >= r2) goto L6;
        r8 = r8 + r1[r3] + "  ";     // Catch: JSONException -> L8
        r3 = r3 + 1;     // Catch: JSONException -> L8
        goto L4
    L6:
        r0.put("cpu_info", r8);     // Catch: JSONException -> L8
        r0.put("kernel_version", SystemUtils.getVersion()[0]);     // Catch: JSONException -> L8
        r0.put("firmware_version", SystemUtils.getVersion()[1]);     // Catch: JSONException -> L8
        r0.put("model", SystemUtils.getVersion()[2]);     // Catch: JSONException -> L8
        r0.put("system_version", SystemUtils.getVersion()[3]);     // Catch: JSONException -> L8
    L7:
        return r0;
    }
}
