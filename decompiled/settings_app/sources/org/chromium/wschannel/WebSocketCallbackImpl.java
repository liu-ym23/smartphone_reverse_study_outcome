package org.chromium.wschannel;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.ttnet.org.chromium.net.TTWebsocketConnection;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
final class WebSocketCallbackImpl extends TTWebsocketConnection.Callback {
    private static final String TAG = "CronetFrontierConnection";
    private IWsChannelClient mClient;

    private static int cronetToWsStateAdapter(int r1) {
        if (r1 != (-1)) goto L5;
        return 0;
    L5:
        if (r1 == 0) goto L13;
        if (r1 != 1) goto L14;
        return 6;
    L14:
        return r1;
    L13:
        return 1;
    }

    public WebSocketCallbackImpl(IWsChannelClient r1) {
        this.mClient = r1;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
    public void onMessageReceived(TTWebsocketConnection r1, ByteBuffer r2, int r3) throws Exception {
        byte[] r4 = new byte[r2.capacity()];
        r2.get(r4);     // Catch: Throwable -> L5
        this.mClient.onMessage(r4);     // Catch: Throwable -> L5
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
    public void onConnectionStateChanged(TTWebsocketConnection r3, int r4, String r5) {
        int r6 = cronetToWsStateAdapter(r4);
        if (Logger.debug() == false) goto L8;
        Logger.d(TAG, "WS onConnectionStateChanged state:" + r6 + " url:" + r5);
    L8:
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L7
        r7.put("type", 1);     // Catch: Throwable -> L7
        r7.put("state", r6);     // Catch: Throwable -> L7
        r7.put("url", r5);     // Catch: Throwable -> L7
        this.mClient.onConnection(r7);     // Catch: Throwable -> L7
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
    public void onConnectionError(TTWebsocketConnection r3, int r4, String r5, String r6) {
        int r7 = cronetToWsStateAdapter(r4);
        if (Logger.debug() == false) goto L8;
        Logger.d(TAG, "WS onConnectionError state:" + r7 + " url:" + r5 + " error:" + r6);
    L8:
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L7
        r8.put("type", 0);     // Catch: Throwable -> L7
        r8.put("state", r7);     // Catch: Throwable -> L7
        r8.put("url", r5);     // Catch: Throwable -> L7
        r8.put("error", r6);     // Catch: Throwable -> L7
        this.mClient.onConnection(r8);     // Catch: Throwable -> L7
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
    public void onTrafficChanged(TTWebsocketConnection r8, String r9, long r10, long r12, boolean r14) {
        TrafficChangedObservable.inst().onTrafficChanged(r9, r10, r12, r14);     // Catch: Throwable -> L4
        return;
    }
}
