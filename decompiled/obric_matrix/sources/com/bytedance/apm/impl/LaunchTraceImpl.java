package com.bytedance.apm.impl;

import com.bytedance.services.apm.api.ILaunchTrace;

/* JADX INFO: loaded from: classes.dex */
public class LaunchTraceImpl implements ILaunchTrace {
    public LaunchTraceImpl() {
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void cancelTrace() {
        com.bytedance.apm.g0.c.a();
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void endSpan(String r1, String r2) {
        com.bytedance.apm.g0.c.b(r1, r2);
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void endTrace(int r1, String r2, long r3) {
        com.bytedance.apm.g0.c.c(r1, r2, r3);
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void startSpan(String r1, String r2) {
        com.bytedance.apm.g0.c.h(r1, r2);
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void startTrace() {
        com.bytedance.apm.g0.c.i();
    }
}
