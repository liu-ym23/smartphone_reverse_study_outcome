package com.bytedance.apm6.hub.config;

import com.bytedance.apm6.hub.config.internal.ConfigConstants;
import com.bytedance.apm6.hub.config.internal.ConfigManager;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.apm6.memory.MemoryCollector;
import com.bytedance.apm6.memory.config.MemoryConfig;
import com.bytedance.apm6.memory.config.MemoryConfigService;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.log.Logger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MemoryConfigManager implements MemoryConfigService {
    private static final String PERF_KEY_COLLECT_INTERVAL = "collect_interval";
    private static final String PERF_MEMORY_REACHTOP_RATE = "reach_top_memory_rate";
    private MemoryConfig config;

    public MemoryConfigManager() {
        ConfigManager.getInstance().init();
        ConfigManager.getInstance().registerConfigListener(new AnonymousClass1(this));
    }

    public static /* synthetic */ void access$000(MemoryConfigManager r0, JSONObject r1, boolean r2) {
        r0.parseConfig(r1, r2);
    }

    private void parseConfig(JSONObject r10, boolean r11) {
        JSONObject r12 = r10.optJSONObject("performance_modules");
        if (r12 != null) goto L5;
        return;
    L5:
        JSONObject r13 = r12.optJSONObject("memory");
        if (r13 != null) goto L8;
        return;
    L8:
        long r1 = r13.optLong("collect_interval", 120);
        double r3 = r13.optDouble("reach_top_memory_rate", 0.8d);
        if (r13.optInt("enable_upload", 0) != 1) goto L11;
        boolean r7 = true;
    L13:
        if (r13.optInt(SlardarSettingsConstants.PERF_MEMORY_CLOSE_COLLECT) == 1) goto L15;
        boolean r8 = true;
    L16:
        this.config = new MemoryConfig(r1, r3, false, false, r7, r8);
        if (ApmBaseContext.isDebugMode() == false) goto L19;
        Logger.d(ConfigConstants.LOG_TAG, "parsed MemoryConfig=" + this.config);
    L19:
        MemoryCollector.getInstance().updateConfig(getConfig());
        return;
    L15:
        r8 = false;
        goto L16
    L11:
        r7 = false;
        goto L13
    }

    @Override // com.bytedance.apm6.memory.config.MemoryConfigService
    public MemoryConfig getConfig() {
        return this.config;
    }
}
