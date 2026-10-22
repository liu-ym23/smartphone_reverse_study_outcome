package com.bytedance.common.wschannel.server;

import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.model.SocketState;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
final class ChannelKeeper {
    Map<Integer, SocketState> mChannelState;
    Map<Integer, IWsApp> mWsAppMap;
    Map<Integer, IWsChannelClient> mWsChannelClientMap;

    public ChannelKeeper() {
        this.mWsAppMap = new ConcurrentHashMap();
        this.mWsChannelClientMap = new ConcurrentHashMap();
        this.mChannelState = new ConcurrentHashMap();
    }
}
