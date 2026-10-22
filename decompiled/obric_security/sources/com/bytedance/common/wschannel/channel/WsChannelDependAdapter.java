package com.bytedance.common.wschannel.channel;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.tools.SafelyLibraryLoader;

/* JADX INFO: loaded from: classes.dex */
public class WsChannelDependAdapter implements IWsChannelDepend {
    public static WsChannelDependAdapter INSTANCE;

    @Override // com.bytedance.common.wschannel.channel.IWsChannelDepend
    public void setAdapter(IWsChannelDepend r1) {
    }

    static {
        INSTANCE = new WsChannelDependAdapter();
    }

    private WsChannelDependAdapter() {
    }

    public static WsChannelDependAdapter inst() {
        return INSTANCE;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelDepend
    public boolean loggerDebug() {
        return Logger.debug();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelDepend
    public void loggerD(String r1, String r2) {
        Logger.d(r1, r2);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelDepend
    public void loadLibrary(Context r1, String r2) {
        SafelyLibraryLoader.loadLibrary(r1, r2);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelDepend
    public int getNetworkType(Context r1) {
        return NetworkUtils.getNetworkType(r1).getValue();
    }
}
