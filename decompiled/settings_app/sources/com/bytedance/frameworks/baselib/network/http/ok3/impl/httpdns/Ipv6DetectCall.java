package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.Ipv6ConnectionManager;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public class Ipv6DetectCall implements Callable<Void> {
    public Ipv6DetectCall() {
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Void call() throws Exception {
        return call2();
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public Void call2() {
        Ipv6ConnectionManager.detectIpv6Reachable();
        return null;
    }
}
