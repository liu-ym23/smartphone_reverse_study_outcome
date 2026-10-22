package com.bytedance.apm6;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm6.hub.config.MemoryConfigManager;
import com.bytedance.apm6.memory.config.MemoryConfig;

/* JADX INFO: loaded from: classes.dex */
class DefaultMemoryConfigService extends MemoryConfigManager {
    public DefaultMemoryConfigService() {
    }

    @Override // com.bytedance.apm6.hub.config.MemoryConfigManager, com.bytedance.apm6.memory.config.MemoryConfigService
    public MemoryConfig getConfig() {
        MemoryConfig r1 = super.getConfig();
        if (r1 == null) goto L5;
        r1.setRealTimeMemEnable(ApmContext.isDeviceInfoOnPerfDataEnabled());
        r1.setStopWhenBackground(ApmContext.isStopWhenBackground());
    L5:
        return r1;
    }
}
