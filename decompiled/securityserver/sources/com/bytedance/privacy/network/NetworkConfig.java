package com.bytedance.privacy.network;

import com.bytedance.privacy.bridge.IEnvBridge;

/* JADX INFO: loaded from: classes.dex */
public class NetworkConfig {
    public static volatile NetworkConfig b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IEnvBridge f12a;

    public static NetworkConfig a() {
        if (b != null) goto L16;
        monitor-enter(NetworkConfig.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L11;
        b = new NetworkConfig();     // Catch: Throwable -> L9
    L11:
        monitor-exit(NetworkConfig.class);     // Catch: Throwable -> L9
    L16:
        return b;
    }

    public final boolean b() {
        IEnvBridge r0 = this.f12a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a();
    }
}
