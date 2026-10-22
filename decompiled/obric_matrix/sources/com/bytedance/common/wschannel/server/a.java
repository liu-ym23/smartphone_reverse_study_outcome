package com.bytedance.common.wschannel.server;

import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.model.SocketState;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Map<Integer, IWsApp> f3711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Map<Integer, IWsChannelClient> f3712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Map<Integer, SocketState> f3713c;

    a() {
        this.f3711a = new ConcurrentHashMap();
        this.f3712b = new ConcurrentHashMap();
        this.f3713c = new ConcurrentHashMap();
    }
}
