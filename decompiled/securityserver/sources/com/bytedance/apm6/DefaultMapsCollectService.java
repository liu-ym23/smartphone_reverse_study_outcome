package com.bytedance.apm6;

import com.bytedance.apm.npth.NpthUtil;
import com.bytedance.apm6.memory.IMapsCollectService;

/* JADX INFO: loaded from: classes.dex */
class DefaultMapsCollectService implements IMapsCollectService {
    public DefaultMapsCollectService() {
    }

    @Override // com.bytedance.apm6.memory.IMapsCollectService
    public void start() {
        NpthUtil.startMonitor();
    }

    @Override // com.bytedance.apm6.memory.IMapsCollectService
    public void stop() {
    }
}
