package org.chromium.wschannel;

import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.frameworks.baselib.network.http.util.AsyncIOTaskManager;
import com.bytedance.frameworks.baselib.network.http.util.AsyncTask;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.keva.KevaImpl;
import com.bytedanceos.securitycenter.appBgBatteryControl.AppBgBatteryControlDataHelper;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.TTWebsocketConnection;
import com.ttnet.org.chromium.net.impl.CronetFrontierClient;
import com.ttnet.org.chromium.net.impl.TTServiceInfo;
import java.net.CookieHandler;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.chromium.CronetAppProviderManager;
import org.chromium.CronetClient;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class CronetFrontierConnection {
    private static final String CLIENT_KEY_MANAGER_CLASS = "com.bytedance.ttnet.clientkey.ClientKeyManager";
    private static final String FALLBACK_TIMEOUT_MILLS = "fallback_timeout_mills";
    private static final String FALLBACK_WEBSOCKET_TASK_ID = null;
    private static final int FALL_BACK_SECONDS = 10;
    private static final int FALL_BACK_WEBSOCKET = 1;
    private static final String LOG_TYPE = "private_protocol";
    private static final int MAX_RETRY_COUNT = 3;
    private static final String METHOD_ID_HEADER = "method_id";
    private static final String MSG_ID_HEADER = "msg_id";
    private static final String MSG_SERVER_TIMING_HEADER = "server_timing";
    private static final String PAYLOAD_ENCODING_HEADER = "payload_encoding";
    private static final String PAYLOAD_TYPE_HEADER = "payload_type";
    private static final String PING_INTERVAL_HEADER = "ttnet_heartbeat_interval";
    private static final int PRIVATE_PROTOCOL_PROXY_DEFAULT_SERVICE_ID = 1;
    private static final int SHARED_STREAM_SERVICE_ID = 9000;
    private static final String TAG = "CronetFrontierConnection";
    private static final String TIME_OUT_HEADER = "ttnet_timeout_millis";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private static volatile int sChannelID = 0;
    private static CronetEngine sCronetEngine = null;
    private static boolean sDisableFallbackTask = false;
    private static volatile AtomicInteger sFirstConnection = null;
    public static CronetFrontierClient.TransportMode sMode = null;
    private static volatile String sPrivateProtocolUrl = "";
    private Map<Integer, Boolean> mAllServiceBuildInfo;
    private volatile int mAppState;
    private WebSocketCallbackImpl mCallback;
    private DestroyTimeoutControl mDestroyTimeoutControl;
    private CronetFrontierClient mFrontierClient;
    private AtomicBoolean mIsFallbackTaskRunning;
    private volatile boolean mIsFirstStreamReady;
    private int mPingInterval;
    private final AtomicInteger mRetryAttempts;
    private boolean mSharedConnection;
    private int mTimeOut;
    private final AtomicBoolean mUsePrivateProtocol;
    private final AtomicBoolean mUsePrivateProtocolProxy;
    private TTWebsocketConnection mWebsocketConnection;
    private IWsChannelClient mWsChannelClient;

    final class FallbackWebSocketTask extends AsyncTask {
        private final Map<String, Object> mConfigMap;
        private final List<String> mUrls;
        final /* synthetic */ CronetFrontierConnection this$0;

        public FallbackWebSocketTask(CronetFrontierConnection r1, long r2, Map<String, Object> r4, List<String> r5) {
            this.this$0 = r1;
            super(r2, CronetFrontierConnection.access$800());
            this.mConfigMap = r4;
            this.mUrls = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CronetFrontierConnection.access$500(this.this$0) == false) goto L6;
            CronetFrontierConnection.access$900(this.this$0).set(0);
            CronetFrontierConnection.access$1000(this.this$0).set(false);
            return;
        L6:
            int r0 = CronetFrontierConnection.access$900(this.this$0).incrementAndGet();
            if (Logger.debug() == false) goto L9;
            Logger.d(CronetFrontierConnection.TAG, "Fallback to websocket connection, retry attempts:" + r0);
        L9:
            this.this$0.destroyConnection();
            CronetFrontierConnection.access$1100(this.this$0, this.mConfigMap, this.mUrls);
            JSONObject r1 = new JSONObject();     // Catch: JSONException -> L12
            r1.put(ICronetClient.KEY_RETRY_ATTEMPTS, r0);     // Catch: JSONException -> L12
            r1.put(AppBgBatteryControlDataHelper.ItemColumns.REASON, "connect timeout fallback");     // Catch: JSONException -> L12
            CronetFrontierConnection.access$1200(this.this$0, r1, 1);     // Catch: JSONException -> L12
            return;
        L12:
            e = move-exception;
            e.printStackTrace();
        }
    }

    class ServiceMessageReceiverImpl implements CronetFrontierClient.IServiceMessageReceiver {
        final /* synthetic */ CronetFrontierConnection this$0;

        ServiceMessageReceiverImpl(CronetFrontierConnection r1) {
            this.this$0 = r1;
        }

        @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IServiceMessageReceiver
        public void onServiceReady(int r6, String r7) {
            if (Logger.debug() == false) goto L6;
            Logger.d(CronetFrontierConnection.TAG, "onServiceReady ServiceId:" + r6 + " log info:" + r7);
        L6:
            if (CronetFrontierConnection.access$000(this.this$0) == true) goto L16;
            CronetFrontierConnection.access$002(this.this$0, true);
            if (CronetFrontierConnection.access$100(this.this$0) == null) goto L16;
            if (CronetFrontierConnection.access$200(this.this$0) == (-1)) goto L16;
            CronetFrontierClient r8 = CronetFrontierConnection.access$100(this.this$0);
            if (CronetFrontierConnection.access$200(this.this$0) != 1) goto L14;
            boolean r3 = true;
        L15:
            r8.reportAppStateChange(r3);
            goto L16
        L14:
            r3 = false;
        L16:
            CronetFrontierConnection.access$300(this.this$0).put(Integer.valueOf(r6), true);
            if (this.this$0.isFallbackTaskRunning() == true) goto L19;
        L26:
            CronetFrontierConnection.access$700(this.this$0).onServiceConnectEvent(r6, true, "");
            return;
        L19:
            if (CronetFrontierConnection.access$400(this.this$0).get() == false) goto L26;
            if (CronetFrontierConnection.access$500(this.this$0) == false) goto L26;
            JSONObject r9 = new JSONObject();     // Catch: Throwable -> L28
            r9.put("type", 1);     // Catch: Throwable -> L28
            r9.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, 1);     // Catch: Throwable -> L28
            r9.put("state", 4);     // Catch: Throwable -> L28
            r9.put("url", CronetFrontierConnection.access$600());     // Catch: Throwable -> L28
            if (Logger.debug() == false) goto L25;
            Logger.d(CronetFrontierConnection.TAG, "PP onConnectionStateChanged state: 4 url:" + CronetFrontierConnection.access$600());     // Catch: Throwable -> L28
        L25:
            CronetFrontierConnection.access$700(this.this$0).onConnection(r9);     // Catch: Throwable -> L28
            goto L26
        }

        @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IServiceMessageReceiver
        public void onError(int r3, int r4, String r5) {
            if (Logger.debug() == false) goto L5;
            Logger.d(CronetFrontierConnection.TAG, "onError ServiceId:" + r3 + " error code:" + r4 + " info:" + r5);
        L5:
            CronetFrontierConnection.access$700(this.this$0).onServiceConnectEvent(r3, false, "");
        }

        @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IServiceMessageReceiver
        public void onReceivedMessage(int r7, Map<String, String> r8, byte[] r9) {
            if (CronetFrontierConnection.access$400(this.this$0).get() == false) goto L10;
            if (Logger.debug() == false) goto L7;
            Logger.d(CronetFrontierConnection.TAG, "proxy onReceivedMessage service id:" + r7 + " data length:" + r9.length);
        L7:
            CronetFrontierConnection.access$700(this.this$0).onMessage(r9);
            return;
        L10:
            if (Logger.debug() == false) goto L12;
            Logger.d(CronetFrontierConnection.TAG, "onReceivedMessage service id:" + r7 + " data length:" + r9.length);
        L12:
            WsChannelMsg r0 = new WsChannelMsg();
            r0.setService(r7);
            ArrayList r10 = new ArrayList();
            Iterator<Map.Entry<String, String>> r11 = r8.entrySet().iterator();
        L14:
            if (r11.hasNext() == false) goto L39;
            Map.Entry<String, String> r1 = r11.next();
            if (TextUtils.isEmpty(r1.getKey()) == true) goto L14;
            if (TextUtils.isEmpty(r1.getValue()) == true) goto L14;
            if (r1.getKey().equals(CronetFrontierConnection.METHOD_ID_HEADER) == false) goto L27;
            r0.setMethod(Integer.valueOf(r1.getValue()).intValue());     // Catch: NumberFormatException -> L24
        L24:
            e = move-exception;
            Logger.e(CronetFrontierConnection.TAG, "method_id is not valid: " + r1.getValue());
            e.printStackTrace();
            goto L14
        L27:
            if (r1.getKey().equalsIgnoreCase(CronetFrontierConnection.PAYLOAD_ENCODING_HEADER) == true) goto L28;
            if (r1.getKey().equalsIgnoreCase(CronetFrontierConnection.PAYLOAD_TYPE_HEADER) == true) goto L31;
            if (r1.getKey().equalsIgnoreCase(CronetFrontierConnection.MSG_ID_HEADER) == true) goto L34;
            if (r1.getKey().equalsIgnoreCase(CronetFrontierConnection.MSG_SERVER_TIMING_HEADER) == true) goto L37;
            WsChannelMsg.MsgHeader r3 = new WsChannelMsg.MsgHeader();
            r3.setKey(r1.getKey());
            r3.setValue(r1.getValue());
            r10.add(r3);
            goto L14
        L37:
            r0.setServerTiming(r1.getValue());
            goto L14
        L34:
            r0.setMsgId(r1.getValue());
            goto L14
        L31:
            r0.setPayloadType(r1.getValue());
            goto L14
        L28:
            r0.setPayloadEncoding(r1.getValue());
            goto L14
        L39:
            r0.setMsgHeaders(r10);
            r0.setPayload(r9);
            if (r0.getPayloadEncoding() != null) goto L43;
            r0.setPayloadEncoding("");
        L43:
            if (r0.getPayloadType() != null) goto L46;
            r0.setPayloadType("");
        L46:
            if (Logger.debug() == false) goto L48;
            Logger.d(CronetFrontierConnection.TAG, "onReceivedMessage:" + r0);
        L48:
            CronetFrontierConnection.access$700(this.this$0).onMessage(r0);
        }

        @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IServiceMessageReceiver
        public void onReceivedAck(int r1, long r2, String r4, Boolean r5) {
            if (Logger.debug() == false) goto L6;
            Logger.d(CronetFrontierConnection.TAG, "onReceivedAck serviceId:" + r1 + " messageId:" + r2 + " logInfo:" + r4);
            return;
        }
    }

    public void registerService(int r1) {
    }

    public void unregisterService(int r1) {
    }

    static /* synthetic */ boolean access$000(CronetFrontierConnection r0) {
        return r0.mIsFirstStreamReady;
    }

    static /* synthetic */ boolean access$002(CronetFrontierConnection r0, boolean r1) {
        r0.mIsFirstStreamReady = r1;
        return r1;
    }

    static /* synthetic */ CronetFrontierClient access$100(CronetFrontierConnection r0) {
        return r0.mFrontierClient;
    }

    static /* synthetic */ AtomicBoolean access$1000(CronetFrontierConnection r0) {
        return r0.mIsFallbackTaskRunning;
    }

    static /* synthetic */ void access$1100(CronetFrontierConnection r0, Map r1, List r2) {
        r0.startConnectionWithWebSocket(r1, r2);
    }

    static /* synthetic */ void access$1200(CronetFrontierConnection r0, JSONObject r1, int r2) throws JSONException {
        r0.reportPrivateProtocolRelatedLog(r1, r2);
    }

    static /* synthetic */ int access$200(CronetFrontierConnection r0) {
        return r0.mAppState;
    }

    static /* synthetic */ Map access$300(CronetFrontierConnection r0) {
        return r0.mAllServiceBuildInfo;
    }

    static /* synthetic */ AtomicBoolean access$400(CronetFrontierConnection r0) {
        return r0.mUsePrivateProtocolProxy;
    }

    static /* synthetic */ boolean access$500(CronetFrontierConnection r0) {
        return r0.isAllServiceConnected();
    }

    static /* synthetic */ String access$600() {
        return sPrivateProtocolUrl;
    }

    static /* synthetic */ IWsChannelClient access$700(CronetFrontierConnection r0) {
        return r0.mWsChannelClient;
    }

    static /* synthetic */ String access$800() {
        return FALLBACK_WEBSOCKET_TASK_ID;
    }

    static /* synthetic */ AtomicInteger access$900(CronetFrontierConnection r0) {
        return r0.mRetryAttempts;
    }

    static {
        FALLBACK_WEBSOCKET_TASK_ID = UUID.randomUUID().toString();
        sDisableFallbackTask = false;
        sMode = CronetFrontierClient.TransportMode.QUIC;
        sFirstConnection = new AtomicInteger(0);
        sChannelID = -1;
    }

    public CronetFrontierConnection(IWsChannelClient r3) {
        this.mUsePrivateProtocol = new AtomicBoolean(false);
        this.mUsePrivateProtocolProxy = new AtomicBoolean(false);
        this.mRetryAttempts = new AtomicInteger(0);
        this.mPingInterval = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
        this.mTimeOut = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
        this.mAllServiceBuildInfo = new ConcurrentHashMap();
        this.mIsFallbackTaskRunning = new AtomicBoolean(false);
        this.mAppState = -1;
        this.mIsFirstStreamReady = false;
        this.mSharedConnection = true;
        this.mWsChannelClient = r3;
        this.mCallback = new WebSocketCallbackImpl(this.mWsChannelClient);
        loadCronetKernel();     // Catch: Throwable -> L5
    L9:
        sCronetEngine = CronetClient.getCronetEngine();
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        if (Logger.debug() == false) goto L9;
        Logger.d(TAG, "TTNet init failed, cronet engine is null.");
        goto L9
    }

    private static void loadCronetKernel() throws Exception {
        Object r0 = Class.forName(TTNET_INIT_CLASS).newInstance();
        Reflect.on(r0).call("getInitCompletedLatch");
        Reflect.on(r0).call("preInitCronetKernel");
    }

    private Map<String, String> getClientKeyHeaders() {
        return (Map) Class.forName(CLIENT_KEY_MANAGER_CLASS).getMethod("getClientKeyHeaders", new Class[0]).invoke(null, new Object[0]);
    L5:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    private void startConnectionWithWebSocket(Map<String, Object> r11, List<String> r12) {
        this.mUsePrivateProtocol.set(false);
        this.mUsePrivateProtocolProxy.set(false);
        if (sFirstConnection.incrementAndGet() <= 1) goto L5;
        this.mSharedConnection = false;
    L5:
        Object r2 = r11.get(WsConstants.KEY_CHANNEL_ID);
        if (r2 != null) goto L8;
        int r3 = -1;
    L10:
        if (sChannelID != (-1)) goto L15;
        if (r3 <= 0) goto L15;
        if (sFirstConnection.get() != 1) goto L15;
        sChannelID = r3;
    L15:
        TTWebsocketConnection.Builder r5 = sCronetEngine.newWebsocketConnectionBuilder(this.mCallback, Executors.newSingleThreadExecutor());
        r5.setUrlList(r12);     // Catch: Throwable -> L63
        r5.setAppKey(String.valueOf(r11.get(WsConstants.KEY_APP_KEY)));     // Catch: Throwable -> L63
        r5.setFpid(((Integer) r11.get(WsConstants.KEY_FPID)).intValue());     // Catch: Throwable -> L63
        r5.setAppVersion(((Integer) r11.get("app_version")).intValue());     // Catch: Throwable -> L63
        r5.setAppId(((Integer) r11.get("aid")).intValue());     // Catch: Throwable -> L63
        r5.setDeviceId(Long.parseLong((String) r11.get("device_id")));     // Catch: Throwable -> L63
        r5.setInstallId(Long.parseLong((String) r11.get(WsConstants.KEY_INSTALL_ID)));     // Catch: Throwable -> L63
        if (r3 > 0) goto L19;
    L21:
        r5.setSharedConnection(false);     // Catch: Throwable -> L63
        if (r11.containsKey("sid") == false) goto L24;
        r5.setSessionId((String) r11.get("sid"));     // Catch: Throwable -> L63
    L24:
        String r13 = (String) r11.get(WsConstants.KEY_EXTRA);     // Catch: Throwable -> L63
        HashMap r1 = new HashMap();     // Catch: Throwable -> L63
        if (TextUtils.isEmpty(r13) == true) goto L66;
        String[] r14 = r13.split("&");     // Catch: Throwable -> L63
        int r4 = r14.length;     // Catch: Throwable -> L63
        int r6 = 0;
    L27:
        if (r6 >= r4) goto L66;
        String r7 = r14[r6];     // Catch: Throwable -> L63
        if (TextUtils.isEmpty(r7) == true) goto L33;
        String[] r8 = r7.split("=");     // Catch: Throwable -> L63
        if (r8.length != 2) goto L33;
        r1.put(r8[0], r8[1]);     // Catch: Throwable -> L63
    L33:
        r6 = r6 + 1;
    L66:
        HashMap r15 = new HashMap();     // Catch: Throwable -> L50
        Map<String, String> r9 = getClientKeyHeaders();     // Catch: Throwable -> L50
        if (Logger.debug() == false) goto L37;
        Logger.d(TAG, "Client key: " + r9);     // Catch: Throwable -> L50
    L37:
        if (r9 != null) goto L39;
    L41:
        Map r16 = (Map) r11.get(WsConstants.KEY_HEADERS);     // Catch: Throwable -> L50
        if (r16 == null) goto L47;
        if (r16.isEmpty() == true) goto L47;
        r15.putAll(r16);     // Catch: Throwable -> L50
    L47:
        if (r15.isEmpty() == true) goto L52;
        r5.setCustomizedHeaders(r15);     // Catch: Throwable -> L50
    L52:
        DestroyTimeoutControl r17 = this.mDestroyTimeoutControl;     // Catch: Throwable -> L63
        if (r17 != null) goto L55;
    L60:
        r5.setCustomizedParams(r1);     // Catch: Throwable -> L63
        TTWebsocketConnection r18 = r5.build();
        this.mWebsocketConnection = r18;
        r18.startConnection();
        return;
    L55:
        if (r17.getWebsocketTimeout() <= 0) goto L60;
        long r19 = this.mDestroyTimeoutControl.getWebsocketTimeout();     // Catch: Throwable -> L63
        if (Logger.debug() == false) goto L59;
        Logger.d(TAG, "WS destroy timeout:" + r19);     // Catch: Throwable -> L63
    L59:
        r1.put(TIME_OUT_HEADER, String.valueOf(r19));     // Catch: Throwable -> L63
        goto L60
    L39:
        if (r9.isEmpty() == true) goto L41;
        r15.putAll(r9);     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L63
        goto L52
    L19:
        if (r3 != sChannelID) goto L21;
        this.mSharedConnection = true;     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        th.printStackTrace();
        throw new IllegalArgumentException("configMap contain err params !!!");
    L8:
        r3 = ((Integer) r2).intValue();
        goto L10
    }

    private void parseExtraParamsForPrivateProtocol(String r8, HashMap<String, String> r9) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return;
    L5:
        String[] r10 = r8.split("&");
        int r0 = r10.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L28;
        String r3 = r10[r2];
        if (TextUtils.isEmpty(r3) == true) goto L27;
        String[] r4 = r3.split("=");
        if (r4.length != 2) goto L27;
        if (TextUtils.isEmpty(r4[0]) == true) goto L27;
        if (TextUtils.isEmpty(r4[1]) == true) goto L27;
        if (r4[0].equals(PING_INTERVAL_HEADER) == false) goto L21;
        this.mPingInterval = Integer.valueOf(r4[1]).intValue() * 1000;     // Catch: NumberFormatException -> L29
        goto L27
    L21:
        if (r4[0].equals(TIME_OUT_HEADER) == false) goto L25;
        this.mTimeOut = Integer.valueOf(r4[1]).intValue();     // Catch: NumberFormatException -> L29
        goto L27
    L25:
        if (this.mUsePrivateProtocolProxy.get() == true) goto L27;
        r9.put(r4[0], r4[1]);
    L27:
        r2 = r2 + 1;
        goto L6
    }

    private static void mergeServiceId(Map<String, Object> r2, List<Integer> r3) {
        ArrayList r4 = (ArrayList) r2.get(WsConstants.KEY_SERVICE_ID_LIST);
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.size() == 0) goto L19;
        Iterator r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L20;
        int r0 = ((Integer) r5.next()).intValue();
        if (r3.contains(Integer.valueOf(r0)) == true) goto L9;
        r3.add(Integer.valueOf(r0));
        goto L9
    L20:
        return;
    }

    private void startConnectionWithPrivateProtocol(Map<String, Object> r20, URI r21) {
        int r3 = r21.getPort();
        String r4 = r21.getPath();
        String r5 = r21.getQuery();
        if (r3 > 0) goto L5;
        r3 = 443;
    L5:
        int r9 = r3;
        if (Logger.debug() == false) goto L8;
        Logger.d(TAG, "PP connection host:" + r21.getHost() + ":" + r9 + r4 + "?" + r5);
    L8:
        CronetFrontierClient.TransportMode r6 = covertTransportMode(((Integer) r20.get(WsConstants.KEY_TRANSPORT_MODE)).intValue());
        sMode = r6;
        ArrayList r14 = new ArrayList();
        if (this.mUsePrivateProtocolProxy.get() == false) goto L11;
        r14.add(1);
    L12:
        HashMap<String, String> r12 = new HashMap();
        String r11 = (String) r20.get(WsConstants.KEY_EXTRA);
        parseExtraParamsForPrivateProtocol(r11, r12);
        Map<String, String> r7 = getClientKeyHeaders();     // Catch: Throwable -> L34
        if (Logger.debug() == false) goto L16;
        Logger.d(TAG, "PP client key: " + r7);     // Catch: Throwable -> L34
    L16:
        if (r7 != null) goto L18;
    L20:
        Map<? extends String, ? extends String> r0 = (Map) r20.get(WsConstants.KEY_HEADERS);     // Catch: Throwable -> L34
        if (r0 == null) goto L26;
        if (r0.isEmpty() == true) goto L26;
        r12.putAll(r0);     // Catch: Throwable -> L34
    L26:
        if (privateProtocolProxyEnabled() == false) goto L36;
        String r1 = MySelfChannelImpl.getDefaultUserAgent();     // Catch: Throwable -> L34
        if (TextUtils.isEmpty(r1) == true) goto L30;
        r12.put("user-agent", r1);     // Catch: Throwable -> L34
    L30:
        String r2 = getCookieHeader(r21);     // Catch: Throwable -> L34
        if (TextUtils.isEmpty(r2) == true) goto L36;
        r12.put(BaseHttpRequestInfo.KEY_COOKIE, r2);     // Catch: Throwable -> L34
    L36:
        this.mAllServiceBuildInfo.clear();
        DestroyTimeoutControl r8 = this.mDestroyTimeoutControl;
        if (r8 != null) goto L39;
    L44:
        CronetFrontierClient.Builder r10 = CronetFrontierClient.Builder.create(((Integer) r20.get("aid")).intValue(), ((Integer) r20.get(WsConstants.KEY_FPID)).intValue(), r21.getHost(), r9, Integer.toString(((Integer) r20.get("app_version")).intValue()), (String) r20.get("device_id"), (String) r20.get(WsConstants.KEY_APP_KEY)).pingInterval(this.mPingInterval).timeout(this.mTimeOut).transportMode(r6).headers(r12).callback(new PrivateProtocolCallbackImpl(this.mWsChannelClient, this));
        if (this.mUsePrivateProtocolProxy.get() == false) goto L51;
        r10.proxy(true);
        String r13 = constructQueryForProxyMode(r5, r11, r20.get(WsConstants.KEY_INSTALL_ID));
        if (Logger.debug() == false) goto L49;
        String r15 = TAG;
        Logger.d(r15, "PP connection real query:" + r13 + " path:" + r4);
    L50:
        r10.query(r13);
        r10.path(r4);
    L52:
        r10.uniqueServiceIdList(r14);
        this.mFrontierClient = r10.build();
        if (Logger.debug() == false) goto L55;
        Logger.d(r15, "Register serviceIdList: " + r14 + " mode:" + r6);
    L55:
        Iterator r16 = r14.iterator();
    L57:
        if (r16.hasNext() == false) goto L59;
        Integer r17 = (Integer) r16.next();
        registerServiceById(r17.intValue(), null, null);
        this.mAllServiceBuildInfo.put(r17, false);
        goto L57
    L59:
        return;
    L49:
        r15 = TAG;
        goto L50
    L51:
        r15 = TAG;
        goto L52
    L39:
        if (r8.getPrivateProtocolTimeout() <= 0) goto L44;
        int r18 = (int) this.mDestroyTimeoutControl.getPrivateProtocolTimeout();
        if (Logger.debug() == false) goto L43;
        Logger.d(TAG, "PP destroy timeout:" + r18);
    L43:
        this.mTimeOut = r18;
        goto L44
    L18:
        if (r7.isEmpty() == true) goto L20;
        r12.putAll(r7);     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        th.printStackTrace();
        goto L36
    L11:
        r14.add(9000);
        mergeServiceId(r20, r14);
        goto L12
    }

    private static String constructQueryForProxyMode(String r3, String r4, Object r5) {
        StringBuilder r1 = new StringBuilder();
        if (TextUtils.isEmpty(r3) == true) goto L6;
        r1.append(r3);
    L6:
        if (TextUtils.isEmpty(r4) == false) goto L8;
    L18:
        long r6 = Long.parseLong((String) r5);     // Catch: Exception -> L17
        if (r1.length() <= 0) goto L14;
        r1.append("&");     // Catch: Exception -> L17
    L14:
        r1.append("iid=" + r6);     // Catch: Exception -> L17
    L16:
        return r1.toString();
    L8:
        if (r1.length() <= 0) goto L10;
        r1.append("&");
    L10:
        r1.append(r4);
        goto L18
    }

    private static String getCookieHeader(URI r5) {
        HashMap r0 = new HashMap();
        StringBuilder r1 = new StringBuilder();
        Map<String, List<String>> r2 = null;
        CookieHandler r3 = CookieHandler.getDefault();     // Catch: Exception -> L25
        if (r3 == null) goto L6;
        r2 = r3.get(r5, r0);     // Catch: Exception -> L25
    L6:
        if (r2 == null) goto L24;
        if (r2.size() <= 0) goto L24;
        Iterator<Map.Entry<String, List<String>>> r6 = r2.entrySet().iterator();
    L11:
        if (r6.hasNext() == false) goto L24;
        Map.Entry<String, List<String>> r4 = r6.next();
        if (BaseHttpRequestInfo.KEY_COOKIE.equalsIgnoreCase(r4.getKey()) == false) goto L11;
        if (r4.getValue().isEmpty() == true) goto L11;
        Iterator<String> r7 = r4.getValue().iterator();
        int r8 = 0;
    L18:
        if (r7.hasNext() == false) goto L11;
        String r9 = r7.next();
        if (r8 <= 0) goto L22;
        r1.append("; ");
    L22:
        r1.append(r9);
        r8 = r8 + 1;
    L24:
        return r1.toString();
    L25:
        return null;
    }

    private CronetFrontierClient.TransportMode covertTransportMode(int r4) {
        if (r4 == 3) goto L5;
        if (r4 == 4) goto L5;
    L6:
        if (r4 == 1) goto L13;
        if (r4 == 2) goto L13;
        if (r4 == 4) goto L13;
        return CronetFrontierClient.TransportMode.QUIC;
    L13:
        return CronetFrontierClient.TransportMode.TLS;
    L5:
        this.mUsePrivateProtocolProxy.set(true);
        goto L6
    }

    public void setFirstStreamReady(boolean r1) {
        this.mIsFirstStreamReady = r1;
    }

    private void registerServiceById(int r3, ByteBuffer r4, String[] r5) {
        if (this.mFrontierClient == null) goto L6;
        TTServiceInfo r0 = new TTServiceInfo(r3, new ServiceMessageReceiverImpl(this));
        this.mFrontierClient.registerService(r0, r4, r5);
        return;
    }

    private boolean isAllServiceConnected() {
        if (this.mAllServiceBuildInfo.isEmpty() == false) goto L5;
        return false;
    L5:
        Iterator<Map.Entry<Integer, Boolean>> r2 = this.mAllServiceBuildInfo.entrySet().iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        if (r2.next().getValue().booleanValue() == true) goto L7;
        return false;
    L11:
        return true;
    }

    private URI parsePrivateProtocolUrl(Map<String, Object> r4) {
        String r5 = (String) r4.get(WsConstants.KEY_PRIVATE_PROTOCOL_URL);
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        sPrivateProtocolUrl = r5;
        if (r5.startsWith("wss:") == false) goto L10;
        r5 = "https:" + r5.substring(4);     // Catch: Throwable -> L14
    L12:
        return UrlUtils.safeCreateUri(r5);
    L10:
        if (r5.startsWith("ws:") == false) goto L12;
        r5 = "http:" + r5.substring(3);     // Catch: Throwable -> L14
    L17:
        return null;
    }

    private boolean canUsePrivateProtocol(Map<String, Object> r4) {
        if (NetworkParams.isPrivateProtocolEnabled() == false) goto L12;
        if (this.mRetryAttempts.get() >= 3) goto L12;
        Object r3 = r4.get(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE);
        if (r3 != null) goto L10;
        return false;
    L10:
        return ((Boolean) r3).booleanValue();
    L12:
        if (Logger.debug() == false) goto L14;
        Logger.d(TAG, "Retry attempts:" + this.mRetryAttempts.get() + ",tnc enabled:" + NetworkParams.isPrivateProtocolEnabled());
    L14:
        return false;
    }

    public void startConnection(Map<String, Object> r11, List<String> r12) {
        if (r12 == null) goto L39;
        if (r12.size() <= 0) goto L39;
        boolean r1 = false;
        if (Logger.debug() == false) goto L8;
        Logger.d(TAG, "openConnection url:" + r12.get(0));
    L8:
        if (r11 == null) goto L37;
        if (r11.isEmpty() == true) goto L37;
        destroyConnection();
        if (canUsePrivateProtocol(r11) == true) goto L15;
        this.mDestroyTimeoutControl = new DestroyTimeoutControl(r11, true);
        startConnectionWithWebSocket(r11, r12);
        return;
    L15:
        URI r0 = parsePrivateProtocolUrl(r11);
        if (r0 != null) goto L19;
        this.mDestroyTimeoutControl = new DestroyTimeoutControl(r11, true);
        startConnectionWithWebSocket(r11, r12);
        return;
    L19:
        this.mDestroyTimeoutControl = new DestroyTimeoutControl(r11, false);
        Object r4 = r11.get(WsConstants.KEY_DISABLE_FALLBACK_WEBSOCKET);
        if (r4 == null) goto L23;
        r1 = ((Boolean) r4).booleanValue();
    L23:
        if (Logger.debug() == false) goto L26;
        Logger.d(TAG, "DisableFallbackTask:" + sDisableFallbackTask + " DisableFallbackWS:" + r1);
    L26:
        if (sDisableFallbackTask == true) goto L34;
        if (r1 == true) goto L34;
        if (this.mDestroyTimeoutControl.shouldFallbackToWebSocket() == false) goto L34;
        long r6 = getFallbackTimeoutSeconds(r11);
        if (Logger.debug() == false) goto L33;
        Logger.d(TAG, "Fallback to websocket timeout:" + r6);
    L33:
        AsyncIOTaskManager.getInstance().postTask(new FallbackWebSocketTask(this, r6, r11, r12));
        this.mIsFallbackTaskRunning.set(true);
    L34:
        this.mUsePrivateProtocol.set(true);
        startConnectionWithPrivateProtocol(r11, r0);
        return;
    L37:
        throw new IllegalArgumentException("configMap is empty !!!");
    L39:
        throw new IllegalArgumentException("urls size <= 0 !!!");
    }

    private long getFallbackTimeoutSeconds(Map<String, Object> r4) {
        Map r3 = (Map) r4.get(WsConstants.KEY_HEADERS);
        if (r3 != null) goto L5;
        return WorkRequest.MIN_BACKOFF_MILLIS;
    L5:
        if (r3.isEmpty() == false) goto L8;
        return WorkRequest.MIN_BACKOFF_MILLIS;
    L8:
        if (r3.containsKey(FALLBACK_TIMEOUT_MILLS) == true) goto L10;
        return WorkRequest.MIN_BACKOFF_MILLIS;
    L10:
        String r5 = (String) r3.get(FALLBACK_TIMEOUT_MILLS);
        if (TextUtils.isEmpty(r5) == false) goto L18;
        return WorkRequest.MIN_BACKOFF_MILLIS;
    L18:
        int r6 = Integer.valueOf(r5).intValue();     // Catch: Exception -> L17
        if (r6 > 0) goto L16;
        return WorkRequest.MIN_BACKOFF_MILLIS;
    L16:
        return r6;
    L23:
        return WorkRequest.MIN_BACKOFF_MILLIS;
    }

    public boolean isFallbackTaskRunning() {
        return this.mIsFallbackTaskRunning.get();
    }

    public static void disableFallbackToWebSocket(boolean r0) {
        sDisableFallbackTask = r0;
    }

    public boolean privateProtocolEnabled() {
        return this.mUsePrivateProtocol.get();
    }

    public boolean privateProtocolProxyEnabled() {
        return this.mUsePrivateProtocolProxy.get();
    }

    public void stopConnection() {
        disconnectConnection();
    }

    public void destroyConnection() {
        disconnectConnection();
    }

    private void disconnectConnection() {
        TTWebsocketConnection r0 = this.mWebsocketConnection;
        if (r0 == null) goto L5;
        r0.stopConnection();
        this.mWebsocketConnection.destroyConnection();
    L5:
        CronetFrontierClient r1 = this.mFrontierClient;
        if (r1 == null) goto L9;
        r1.destroy();
        AsyncIOTaskManager.getInstance().removeTaskById(FALLBACK_WEBSOCKET_TASK_ID);
        this.mIsFallbackTaskRunning.set(false);
        return;
    }

    public boolean isConnected() {
        if (this.mUsePrivateProtocol.get() == false) goto L9;
        CronetFrontierClient r0 = this.mFrontierClient;
        if (r0 == null) goto L9;
        return r0.isConnected();
    L9:
        if (this.mUsePrivateProtocol.get() == true) goto L14;
        TTWebsocketConnection r1 = this.mWebsocketConnection;
        if (r1 != null) goto L13;
        return false;
    L13:
        return r1.isConnected();
    L14:
        return false;
    }

    public boolean sendMessageWithWebSocket(byte[] r3) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "WS sendMessage data:" + r3);
    L6:
        if (this.mWebsocketConnection != null) goto L9;
        return false;
    L9:
        ByteBuffer r0 = ByteBuffer.allocateDirect(r3.length);
        r0.put(r3);
        this.mWebsocketConnection.asyncSendBinary(r0);
        return true;
    }

    private void reportAppStateChange(List<WsChannelMsg.MsgHeader> r4) {
        Iterator<WsChannelMsg.MsgHeader> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L32;
        WsChannelMsg.MsgHeader r0 = r5.next();
        if (r0 == null) goto L4;
        if (WsConstants.APP_STATE_BACKGROUND_KEY.equals(r0.getKey()) == false) goto L4;
        String r6 = r0.getValue();
        boolean r1 = false;
        if (r6.equals("1") == false) goto L13;
        this.mAppState = 1;
    L16:
        if (this.mIsFirstStreamReady == true) goto L18;
        return;
    L18:
        if (this.mAppState == (-1)) goto L31;
        CronetFrontierClient r7 = this.mFrontierClient;
        if (this.mAppState != 1) goto L22;
        r1 = true;
    L22:
        r7.reportAppStateChange(r1);
        return;
    L31:
        return;
    L13:
        if (r6.equals("0") == false) goto L16;
        this.mAppState = 0;
        goto L16
    }

    public boolean sendMessageWithPrivateProtocolProxy(byte[] r4) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "PP proxy sendMessage data:" + r4.toString());
    L5:
        CronetFrontierClient r0 = this.mFrontierClient;
        if (r0 == null) goto L14;
        if (r4 != null) goto L10;
        return false;
    L10:
        if (r0.isServiceExisted(1) == true) goto L12;
        registerServiceById(1, null, null);
    L12:
        ByteBuffer r1 = ByteBuffer.allocateDirect(r4.length);
        r1.put(r4);
        this.mFrontierClient.sendMessage(1, null, r1);
        return true;
    L14:
        return false;
    }

    public boolean sendMessageWithPrivateProtocol(WsChannelMsg r6) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "PP sendMessage data:" + r6.toString());
    L6:
        if (this.mFrontierClient == null) goto L19;
        if (r6 == null) goto L21;
        int r0 = r6.getService();
        if (r0 == 9000) goto L12;
    L15:
        String[] r2 = constructMessageMetaInfo(r6);
        ByteBuffer r4 = ByteBuffer.allocateDirect(r6.getPayload().length);
        r4.put(r6.getPayload());
        this.mFrontierClient.sendMessage(r0, r2, r4);
        if (Logger.debug() == false) goto L18;
        Logger.d(TAG, "PP sendMessage serviceId:" + r0);
    L18:
        return true;
    L12:
        if (r6.getMethod() != 4) goto L15;
        reportAppStateChange(r6.getMsgHeaders());
        return true;
    L21:
        return false;
    L19:
        return false;
    }

    private void reportPrivateProtocolRelatedLog(JSONObject r3, int r4) throws JSONException {
        if (r3 != null) goto L4;
        return;
    L4:
        r3.put("report_type", r4);
        r3.put("report_time", System.currentTimeMillis());
        if (Logger.debug() == false) goto L7;
        Logger.d(TAG, "report log:" + r3.toString());
    L7:
        CronetAppProviderManager.inst().sendAppMonitorEvent(r3.toString(), LOG_TYPE);
    }

    private static String[] constructMessageMetaInfo(WsChannelMsg r4) {
        ArrayList r0 = new ArrayList();
        r0.add(METHOD_ID_HEADER);
        r0.add(String.valueOf(r4.getMethod()));
        if (TextUtils.isEmpty(r4.getPayloadType()) == true) goto L6;
        r0.add(PAYLOAD_TYPE_HEADER);
        r0.add(r4.getPayloadType());
    L6:
        if (TextUtils.isEmpty(r4.getPayloadEncoding()) == true) goto L9;
        r0.add(PAYLOAD_ENCODING_HEADER);
        r0.add(r4.getPayloadEncoding());
    L9:
        if (r4.getMsgHeaders() == null) goto L11;
        Iterator<WsChannelMsg.MsgHeader> r5 = r4.getMsgHeaders().iterator();
    L14:
        if (r5.hasNext() == false) goto L21;
        WsChannelMsg.MsgHeader r1 = r5.next();
        if (TextUtils.isEmpty(r1.getKey()) == true) goto L14;
        if (TextUtils.isEmpty(r1.getValue()) == true) goto L14;
        r0.add(r1.getKey());
        r0.add(r1.getValue());
        goto L14
    L21:
        return (String[]) r0.toArray(new String[0]);
    L11:
        return (String[]) r0.toArray(new String[0]);
    }
}
