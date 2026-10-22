package com.bytedance.common.wschannel.channel;

import android.content.Context;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface IWsChannelClient {
    void destroy();

    void init(Context r1, IWsChannelClient r2);

    boolean isConnected();

    void onAppStateChanged(int r1);

    void onConnection(JSONObject r1);

    void onMessage(WsChannelMsg r1);

    void onMessage(byte[] r1);

    void onNetworkStateChanged(int r1);

    void onParameterChange(Map<String, Object> r1, List<String> r2);

    void onServiceConnectEvent(int r1, boolean r2, String r3);

    void openConnection(Map<String, Object> r1, List<String> r2);

    boolean privateProtocolEnabled();

    boolean privateProtocolProxyEnabled();

    void registerService(int r1);

    boolean sendMessage(WsChannelMsg r1);

    boolean sendMessage(byte[] r1);

    void stopConnection();

    void unregisterService(int r1);
}
