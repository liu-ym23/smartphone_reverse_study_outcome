package com.bytedance.common.wschannel.channel;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public interface IWsChannelDepend {
    int getNetworkType(Context r1);

    void loadLibrary(Context r1, String r2);

    void loggerD(String r1, String r2);

    boolean loggerDebug();

    void setAdapter(IWsChannelDepend r1);
}
