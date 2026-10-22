package com.bytedance.securityserver.network;

import com.bytedance.securityserver.trustcircle.account.EnvBridgeImpl;

/* JADX INFO: loaded from: classes.dex */
public class NetworkConfig {
    public static volatile NetworkConfig b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EnvBridgeImpl f55a;

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
}
