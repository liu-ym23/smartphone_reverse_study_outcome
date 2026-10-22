package com.bytedance.apm6.commonevent.config;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class CommonEventConfig {
    private Set<String> sampledLogType;
    private Set<String> sampledService;

    public CommonEventConfig(Set<String> r1, Set<String> r2) {
        this.sampledService = r1;
        this.sampledLogType = r2;
    }

    public boolean isSampledService(String r1) {
        Set<String> r0 = this.sampledService;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.contains(r1) == false) goto L7;
        return true;
    }

    public boolean isSampledLogType(String r1) {
        Set<String> r0 = this.sampledLogType;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.contains(r1) == false) goto L7;
        return true;
    }

    public String toString() {
        return "CommonEventConfig{sampledService=" + this.sampledService + ", sampledLogType=" + this.sampledLogType + '}';
    }
}
