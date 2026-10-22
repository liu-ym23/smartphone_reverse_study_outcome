package com.bytedance.common.wschannel.server;

import com.bytedance.common.wschannel.app.IWsApp;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface IWsChannelSaver {
    Map<Integer, IWsApp> loadWsChannels();

    void saveWsChannels(Map<Integer, IWsApp> r1);
}
