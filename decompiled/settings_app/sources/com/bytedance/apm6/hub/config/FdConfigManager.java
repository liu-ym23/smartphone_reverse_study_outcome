package com.bytedance.apm6.hub.config;

import com.bytedance.apm6.fd.Constants;
import com.bytedance.apm6.fd.FdCollector;
import com.bytedance.apm6.fd.config.FdConfig;
import com.bytedance.apm6.fd.config.IFdConfigService;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.hub.config.internal.ConfigManager;
import com.bytedance.apm6.util.log.Logger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class FdConfigManager implements IFdConfigService {
    private static final String PERF_FD_KEY_COUNT_THRESHOLD = "fd_count_threshold";
    private static final String PERF_KEY_FD = "fd";
    private FdConfig config;

    static /* synthetic */ void access$000(FdConfigManager r0, JSONObject r1, boolean r2) {
        r0.parseConfig(r1, r2);
    }

    public FdConfigManager() {
        if (ApmContext.isDebugMode() == false) goto L5;
        Logger.d(Constants.TAG, "FdConfigManager:");
    L5:
        ConfigManager.getInstance().init();
        ConfigManager.getInstance().registerConfigListener(new AnonymousClass1(this));
    }

    private void parseConfig(JSONObject r11, boolean r12) {
        JSONObject r13 = r11.optJSONObject("performance_modules");
        if (ApmContext.isDebugMode() == false) goto L5;
        Logger.d(Constants.TAG, "parseConfig:" + r13);
    L5:
        if (r13 != null) goto L7;
        return;
    L7:
        JSONObject r14 = r13.optJSONObject("fd");
        if (r14 != null) goto L11;
        return;
    L11:
        if (ApmContext.isDebugMode() == false) goto L14;
        Logger.d(Constants.TAG, "parseConfig:" + r14);
    L14:
        if (r14.optInt("enable_upload", 0) != 1) goto L16;
        boolean r9 = true;
    L17:
        long r5 = r14.optInt("fd_count_threshold", 800);
        long r15 = r14.optLong("collect_interval", 10) * 60000;
        if (r15 >= 10) goto L20;
        r15 = 600000;
    L20:
        FdConfig r16 = new FdConfig(r5, r15, r9);
        if (ApmContext.isDebugMode() == false) goto L23;
        Logger.d(Constants.TAG, "parseConfig:" + r16);
    L23:
        this.config = r16;
        FdCollector.getInstance().updateConfig(r16);
        return;
    L16:
        r9 = false;
        goto L17
    }

    @Override // com.bytedance.apm6.fd.config.IFdConfigService
    public FdConfig getConfig() {
        return this.config;
    }
}
