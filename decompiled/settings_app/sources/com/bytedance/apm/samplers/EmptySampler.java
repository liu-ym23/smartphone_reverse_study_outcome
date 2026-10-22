package com.bytedance.apm.samplers;

/* JADX INFO: loaded from: classes3.dex */
public class EmptySampler implements ISampleCheck {
    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getLogTypeSwitch(String r1) {
        return false;
    }

    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getMetricSwitch(String r1) {
        return false;
    }

    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getPerfAllowSwitch(String r1) {
        return false;
    }

    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getPerfFpsAllowSwitch(String r1, String r2) {
        return false;
    }

    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getPerfSecondStageSwitch(String r1) {
        return false;
    }

    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getServiceSwitch(String r1) {
        return false;
    }

    public EmptySampler() {
    }
}
