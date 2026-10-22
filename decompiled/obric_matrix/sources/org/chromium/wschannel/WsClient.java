package org.chromium.wschannel;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.baselib.network.http.cronet.websocket.IMessageReceiveListener;
import com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.TTWebsocketConnection;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import org.chromium.CronetClient;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class WsClient implements IWsClient {
    private static final String TAG = "WsClient";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private static CronetEngine mCronetEngine;
    private a mCallback;
    private IMessageReceiveListener mListener;
    private TTWebsocketConnection mWebsocketConnection;

    class a extends TTWebsocketConnection.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ WsClient f22675a;

        a(WsClient r1) {
            this.f22675a = r1;
        }

        @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
        public void onConnectionError(TTWebsocketConnection r2, int r3, String r4, String r5) {
            JSONObject r6 = new JSONObject();     // Catch: Throwable -> L6
            r6.put(WsConstants.KEY_CONNECTION_URL, r4);     // Catch: Throwable -> L6
            r6.put(WsConstants.KEY_CONNECTION_ERROR, r5);     // Catch: Throwable -> L6
            if (WsClient.access$000(this.f22675a) == null) goto L9;
            WsClient.access$000(this.f22675a).onConnection(r3, r4, r6);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }

        @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
        public void onConnectionStateChanged(TTWebsocketConnection r3, int r4, String r5) {
            JSONObject r6 = new JSONObject();     // Catch: Throwable -> L6
            r6.put(WsConstants.KEY_CONNECTION_STATE, WsClient.access$100(this.f22675a, r4));     // Catch: Throwable -> L6
            r6.put(WsConstants.KEY_CONNECTION_URL, r5);     // Catch: Throwable -> L6
            if (WsClient.access$000(this.f22675a) == null) goto L9;
            WsClient.access$000(this.f22675a).onConnection(r4, r5, r6);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }

        @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
        public void onFeedbackLog(TTWebsocketConnection r1, String r2) {
            if (WsClient.access$000(this.f22675a) == null) goto L6;
            WsClient.access$000(this.f22675a).onFeedBackLog(r2);
            return;
        }

        @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
        public void onMessageReceived(TTWebsocketConnection r2, ByteBuffer r3, int r4) {
            byte[] r5 = new byte[r3.capacity()];
            if (r4 != 1) goto L5;
        L12:
            r3.get(r5);     // Catch: Throwable -> L11
            if (WsClient.access$000(this.f22675a) == null) goto L14;
            WsClient.access$000(this.f22675a).onMessage(r5, r4);     // Catch: Throwable -> L11
            return;
        L14:
            return;
        L15:
            return;
        L5:
            if (r4 == 2) goto L12;
            r4 = 0;
            goto L12
        }

        @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
        public void onTrafficChanged(TTWebsocketConnection r8, String r9, long r10, long r12, boolean r14) {
            d.a().c(r9, r10, r12, r14);     // Catch: Throwable -> L4
            return;
        }
    }

    public WsClient(IMessageReceiveListener r2) {
        this.mCallback = new a(this);
        if (mCronetEngine != null) goto L5;
        mCronetEngine = getCronetEngine();
    L5:
        this.mListener = r2;
    }

    static /* synthetic */ IMessageReceiveListener access$000(WsClient r0) {
        return r0.mListener;
    }

    static /* synthetic */ int access$100(WsClient r0, int r1) {
        return r0.cronetToWsStateAdapter(r1);
    }

    private int cronetToWsStateAdapter(int r2) {
        if (r2 == (-1)) goto L9;
        if (r2 == 0) goto L12;
        if (r2 != 1) goto L13;
        return 5;
    L13:
        return r2;
    L12:
        return 1;
    L9:
        return 0;
    }

    private CronetEngine getCronetEngine() {
        if (Logger.debug() == false) goto L13;
        Logger.d(TAG, "Init cronet engine");
    L13:
        loadCronetKernel();     // Catch: Throwable -> L7
    L12:
        return CronetClient.getCronetEngine();
    L7:
        th = move-exception;
        th.printStackTrace();
        if (Logger.debug() == false) goto L12;
        Logger.d(TAG, "TTNet init failed, cronet engine is null.");
        goto L12
    }

    private static void loadCronetKernel() {
        Object r0 = Class.forName(TTNET_INIT_CLASS).newInstance();
        Reflect.on(r0).call("getInitCompletedLatch");
        Reflect.on(r0).call("preInitCronetKernel");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient
    public boolean isConnected() {
        TTWebsocketConnection r0 = this.mWebsocketConnection;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isConnected();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient
    public void onParameterChange(Map<String, String> r2, Map<String, String> r3, List<String> r4, boolean r5, boolean r6) {
        TTWebsocketConnection r0 = this.mWebsocketConnection;
        if (r0 == null) goto L5;
        r0.stopConnection();
        this.mWebsocketConnection.destroyConnection();
    L5:
        openConnection(r2, r3, r4, r5, r6);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient
    public void openConnection(Map<String, String> r4, Map<String, String> r5, List<String> r6, boolean r7, boolean r8) {
        if (r6 == null) goto L20;
        if (r6.size() <= 0) goto L20;
        if (Logger.debug() == false) goto L8;
        Logger.d(TAG, "openConnection url:" + r6.get(0));
    L8:
        TTWebsocketConnection.Builder r0 = mCronetEngine.newWebsocketConnectionBuilder(this.mCallback, Executors.newSingleThreadExecutor());
        r0.setUrlList(r6);
        if (r4 != null) goto L11;
    L13:
        if (r5 != null) goto L15;
    L17:
        r0.setSharedConnection(r7);
        r0.useFrontierProtocol(r8);
        TTWebsocketConnection r9 = r0.build();
        this.mWebsocketConnection = r9;
        r9.startConnection();
        return;
    L15:
        if (r5.isEmpty() == true) goto L17;
        r0.setCustomizedHeaders(r5);
        goto L17
    L11:
        if (r4.isEmpty() == true) goto L13;
        r0.setCustomizedParams(r4);
    L20:
        throw new IllegalArgumentException("urls size <= 0 !!!");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient
    public boolean sendMessage(byte[] r3, int r4) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "sendMessage data:" + r3);
    L6:
        if (this.mWebsocketConnection != null) goto L10;
        return false;
    L10:
        if (r4 != 2) goto L12;
        ByteBuffer r5 = ByteBuffer.allocateDirect(r3.length);
        r5.put(r3);
        this.mWebsocketConnection.asyncSendBinary(r5);
    L14:
        return true;
    L12:
        if (r4 != 1) goto L16;
        this.mWebsocketConnection.asyncSendText(new String(r3, "UTF-8"));
        goto L14
    L16:
        throw new IllegalArgumentException("Unsupported message type: " + r4);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient
    public void stopConnection() {
        TTWebsocketConnection r0 = this.mWebsocketConnection;
        if (r0 == null) goto L6;
        r0.stopConnection();
        this.mWebsocketConnection.destroyConnection();
        return;
    }
}
