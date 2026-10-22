package com.bytedance.apm.sampler;

import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.apm.perf.PerfConfigManager;
import com.bytedance.apm.samplers.ISampleCheck;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSampler implements ISampleCheck {
    public DefaultSampler() {
    }

    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getLogTypeSwitch(String r1) {
        return ApmDelegate.getInstance().getLogTypeSwitch(r1);
    }

    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getServiceSwitch(String r1) {
        return ApmDelegate.getInstance().getServiceNameSwitch(r1);
    }

    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getMetricSwitch(String r1) {
        return ApmDelegate.getInstance().getMetricsTypeSwitch(r1);
    }

    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getPerfAllowSwitch(String r1) {
        return PerfConfigManager.getInstance().getPerfAllowSwitch(r1);
    }

    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getPerfFpsAllowSwitch(String r1, String r2) {
        return PerfConfigManager.getInstance().getPerfFpsAllowSwitch(r1, r2);
    }

    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getPerfSecondStageSwitch(String r1) {
        return PerfConfigManager.getInstance().getPerfSecondStageSwitch(r1);
    }
}
