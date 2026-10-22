package org.chromium.wschannel;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.ttnet.org.chromium.net.NetError;
import com.ttnet.org.chromium.net.impl.CronetFrontierClient;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class c implements CronetFrontierClient.IConnectionCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IWsChannelClient f22697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f22698b;

    public c(IWsChannelClient r1, a r2) {
        this.f22697a = r1;
        this.f22698b = r2;
    }

    private static int a(int r3) {
        if (r3 == 2) goto L10;
        if (r3 == 3) goto L12;
        if (r3 == 4) goto L11;
        return r3;
    L11:
        return 3;
    L12:
        return 2;
    L10:
        return 4;
    }

    private boolean b(int r3) {
        if (this.f22698b.F() == true) goto L6;
        return false;
    L6:
        if (r3 == 2) goto L12;
        if (r3 == 3) goto L12;
        if (r3 == 4) goto L12;
    L18:
        return false;
    L12:
        if (this.f22698b.z() == false) goto L18;
        if (Logger.debug() == false) goto L19;
        Logger.d("CronetFrontierConnection", "Wait fallback task running and ignore state:" + r3);
        return true;
    L19:
        return true;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IConnectionCallback
    public void onConnectionError(int r6, String r7, String r8) {
        int r9 = a(r6);
        if (Logger.debug() == false) goto L6;
        Logger.d("CronetFrontierConnection", "PP onConnectionError state:" + r9 + " url:" + r7 + " error:" + r8);
    L6:
        if (b(r9) == false) goto L16;
        return;
    L16:
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L15
        r0.put(WsConstants.KEY_CONNECTION_TYPE, 0);     // Catch: Throwable -> L15
        r0.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, 1);     // Catch: Throwable -> L15
        r0.put(WsConstants.KEY_CONNECTION_STATE, r9);     // Catch: Throwable -> L15
        r0.put(WsConstants.KEY_CONNECTION_URL, r7);     // Catch: Throwable -> L15
        r0.put(WsConstants.KEY_CONNECTION_ERROR, r8);     // Catch: Throwable -> L15
        if (b.d(r8, false) == false) goto L13;
        r0.put(WsConstants.ERROR_CODE, NetError.ERR_TTNET_REQUEST_TIMED_OUT);     // Catch: Throwable -> L15
        if (Logger.debug() == false) goto L13;
        Logger.d("CronetFrontierConnection", "PP connection timeout.");     // Catch: Throwable -> L15
    L13:
        this.f22697a.onConnection(r0);     // Catch: Throwable -> L15
        return;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IConnectionCallback
    public void onConnectionStateChanged(int r4, String r5) {
        int r6 = a(r4);
        if (Logger.debug() == false) goto L6;
        Logger.d("CronetFrontierConnection", "PP onConnectionStateChanged state:" + r6 + " url:" + r5);
    L6:
        if (r6 != 4) goto L9;
        this.f22698b.N(false);
    L9:
        if (b(r6) == false) goto L14;
        return;
    L14:
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L13
        r0.put(WsConstants.KEY_CONNECTION_TYPE, 1);     // Catch: Throwable -> L13
        r0.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, 1);     // Catch: Throwable -> L13
        r0.put(WsConstants.KEY_CONNECTION_STATE, r6);     // Catch: Throwable -> L13
        r0.put(WsConstants.KEY_CONNECTION_URL, r5);     // Catch: Throwable -> L13
        this.f22697a.onConnection(r0);     // Catch: Throwable -> L13
        return;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IConnectionCallback
    public void onTrafficChanged(String r8, long r9, long r11, boolean r13) {
        d.a().c(r8, r9, r11, r13);     // Catch: Throwable -> L4
        return;
    }
}
