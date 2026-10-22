package org.chromium.wschannel;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.ttnet.org.chromium.net.impl.CronetFrontierClient;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
final class PrivateProtocolCallbackImpl implements CronetFrontierClient.IConnectionCallback {
    private static final String TAG = "CronetFrontierConnection";
    private IWsChannelClient mClient;
    private CronetFrontierConnection mConnection;

    private static int privateProtocolStateAdapter(int r3) {
        if (r3 == 2) goto L11;
        if (r3 == 3) goto L13;
        if (r3 == 4) goto L12;
        return r3;
    L12:
        return 3;
    L13:
        return 2;
    L11:
        return 4;
    }

    public PrivateProtocolCallbackImpl(IWsChannelClient r1, CronetFrontierConnection r2) {
        this.mClient = r1;
        this.mConnection = r2;
    }

    private boolean shouldIgnoreStateCallback(int r3) {
        if (this.mConnection.privateProtocolProxyEnabled() == true) goto L6;
        return false;
    L6:
        if (r3 == 2) goto L12;
        if (r3 == 3) goto L12;
        if (r3 == 4) goto L12;
    L18:
        return false;
    L12:
        if (this.mConnection.isFallbackTaskRunning() == false) goto L18;
        if (Logger.debug() == false) goto L19;
        Logger.d(TAG, "Wait fallback task running and ignore state:" + r3);
        return true;
    L19:
        return true;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IConnectionCallback
    public void onConnectionStateChanged(int r4, String r5) {
        int r6 = privateProtocolStateAdapter(r4);
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "PP onConnectionStateChanged state:" + r6 + " url:" + r5);
    L6:
        if (r6 != 4) goto L9;
        this.mConnection.setFirstStreamReady(false);
    L9:
        if (shouldIgnoreStateCallback(r6) == false) goto L14;
        return;
    L14:
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L13
        r0.put("type", 1);     // Catch: Throwable -> L13
        r0.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, 1);     // Catch: Throwable -> L13
        r0.put("state", r6);     // Catch: Throwable -> L13
        r0.put("url", r5);     // Catch: Throwable -> L13
        this.mClient.onConnection(r0);     // Catch: Throwable -> L13
        return;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IConnectionCallback
    public void onConnectionError(int r4, String r5, String r6) {
        int r7 = privateProtocolStateAdapter(r4);
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "PP onConnectionError state:" + r7 + " url:" + r5 + " error:" + r6);
    L6:
        if (shouldIgnoreStateCallback(r7) == false) goto L11;
        return;
    L11:
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L10
        r0.put("type", 0);     // Catch: Throwable -> L10
        r0.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, 1);     // Catch: Throwable -> L10
        r0.put("state", r7);     // Catch: Throwable -> L10
        r0.put("url", r5);     // Catch: Throwable -> L10
        r0.put("error", r6);     // Catch: Throwable -> L10
        this.mClient.onConnection(r0);     // Catch: Throwable -> L10
        return;
    }

    public static String extractConnectionId(String r1) {
        return new JSONObject(r1).optString("connection_id");
    L4:
        return "";
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IConnectionCallback
    public void onTrafficChanged(String r8, long r9, long r11, boolean r13) {
        TrafficChangedObservable.inst().onTrafficChanged(r8, r9, r11, r13);     // Catch: Throwable -> L4
        return;
    }
}
