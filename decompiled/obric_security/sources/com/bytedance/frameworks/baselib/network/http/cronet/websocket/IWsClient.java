package com.bytedance.frameworks.baselib.network.http.cronet.websocket;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface IWsClient {
    boolean isConnected();

    void onParameterChange(Map<String, String> r1, Map<String, String> r2, List<String> r3, boolean r4, boolean r5);

    void openConnection(Map<String, String> r1, Map<String, String> r2, List<String> r3, boolean r4, boolean r5);

    boolean sendMessage(byte[] r1, int r2) throws Exception;

    void stopConnection();
}
