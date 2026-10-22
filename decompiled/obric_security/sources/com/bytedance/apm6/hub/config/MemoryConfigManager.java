package com.bytedance.apm6.hub.config;

import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.hub.config.internal.ConfigConstants;
import com.bytedance.apm6.hub.config.internal.ConfigManager;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.apm6.memory.MemoryCollector;
import com.bytedance.apm6.memory.config.MemoryConfig;
import com.bytedance.apm6.memory.config.MemoryConfigService;
import com.bytedance.apm6.util.log.Logger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MemoryConfigManager implements MemoryConfigService {
    private static final String PERF_KEY_COLLECT_INTERVAL = "collect_interval";
    private static final String PERF_MEMORY_REACHTOP_RATE = "reach_top_memory_rate";
    private MemoryConfig config;

    static /* synthetic */ void access$000(MemoryConfigManager r0, JSONObject r1, boolean r2) {
        r0.parseConfig(r1, r2);
    }

    public MemoryConfigManager() {
        ConfigManager.getInstance().init();
        ConfigManager.getInstance().registerConfigListener(new AnonymousClass1(this));
    }

    @Override // com.bytedance.apm6.memory.config.MemoryConfigService
    public MemoryConfig getConfig() {
        return this.config;
    }

    private void parseConfig(JSONObject r11, boolean r12) {
        JSONObject r13 = r11.optJSONObject("performance_modules");
        if (r13 != null) goto L5;
        return;
    L5:
        JSONObject r14 = r13.optJSONObject("memory");
        if (r14 != null) goto L8;
        return;
    L8:
        long r1 = r14.optLong("collect_interval", 120);
        double r3 = r14.optDouble("reach_top_memory_rate", 0.8d);
        boolean r8 = true;
        if (r14.optInt("enable_upload", 0) != 1) goto L11;
        boolean r9 = true;
    L13:
        if (r14.optInt(SlardarSettingsConstants.PERF_MEMORY_CLOSE_COLLECT) != 1) goto L16;
        r8 = false;
    L16:
        this.config = new MemoryConfig(r1, r3, false, false, r9, r8);
        if (ApmContext.isDebugMode() == false) goto L19;
        Logger.d(ConfigConstants.LOG_TAG, "parsed MemoryConfig=" + this.config);
    L19:
        MemoryCollector.getInstance().updateConfig(getConfig());
        return;
    L11:
        r9 = false;
        goto L13
    }
}
