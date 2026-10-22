package com.bytedance.tracing.internal;

import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class TraceSettings implements IConfigListener {
    private static volatile TraceSettings singleton;
    private JSONObject allowJsonList;
    private boolean enable;
    private JSONObject errorJsonList;
    private boolean settingReady;

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onReady() {
    }

    private TraceSettings() {
        this.enable = true;
    }

    public static TraceSettings getInstance() {
        if (singleton != null) goto L15;
        monitor-enter(TraceSettings.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (singleton != null) goto L9;
        singleton = new TraceSettings();     // Catch: Throwable -> L11
        ((IConfigManager) ServiceManager.getService(IConfigManager.class)).registerConfigListener(singleton);     // Catch: Throwable -> L11
    L9:
        monitor-exit(TraceSettings.class);     // Catch: Throwable -> L11
    L15:
        return singleton;
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onRefresh(JSONObject r3, boolean r4) {
        this.enable = JsonUtils.optBoolean(r3, "tracing", SlardarSettingsConsts.SETTING_TRACING_ENABLE, true);
        if (this.settingReady == true) goto L6;
        this.allowJsonList = JsonUtils.optJSONObject(r3, "tracing", SlardarSettingsConsts.SETTING_TRACING_ALLOW_LIST);
        this.errorJsonList = JsonUtils.optJSONObject(r3, "tracing", SlardarSettingsConsts.SETTING_TRACING_ERROR_LIST);
        this.settingReady = true;
        return;
    }

    public int isErrorOrSampleHit(boolean r9, String r10) {
        int r1 = 0;
        if (this.enable == true) goto L6;
        return 0;
    L6:
        if (r9 == false) goto L12;
        JSONObject r11 = this.errorJsonList;
        if (r11 != null) goto L10;
    L11:
        r1 = 16;
        goto L12
    L10:
        if (r11.optDouble(r10, -1.0d) > 0.0d) goto L11;
    L12:
        JSONObject r8 = this.allowJsonList;
        if (r8 != null) goto L15;
        return r1;
    L15:
        if (r8.optDouble(r10, -1.0d) > 0.0d) goto L17;
        return r1;
    L17:
        return r1 | 1;
    }

    public double getSampleRate(String r4) {
        JSONObject r3 = this.allowJsonList;
        if (r3 != null) goto L5;
        return 0.0d;
    L5:
        double r5 = r3.optDouble(r4);
        if (Double.isNaN(r5) == false) goto L8;
        return 0.0d;
    L8:
        return r5;
    }
}
