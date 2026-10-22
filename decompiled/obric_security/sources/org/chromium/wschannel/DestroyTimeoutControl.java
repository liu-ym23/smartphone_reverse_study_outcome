package org.chromium.wschannel;

import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class DestroyTimeoutControl {
    private static final String DESTROY_TIME_OUT_MILLS = "destroy_timeout_millis";
    private static final String FALLBACK_TIMEOUT_MILLS = "fallback_timeout_mills";
    private static final int FALL_BACK_SECONDS = 10;
    private static final long MIN_TIMEOUT_MILLS = 1000;
    private static final String PP_ERROR_MSG = "\\\"internal_error\\\":67";
    private static final String PP_QUIC_ERROR_CODE = "\"error_code\":-356";
    private static final String PP_TLS_ERROR_CODE = "\"error_code\":-193";
    private static final String TAG = "CronetFrontierConnection";
    private static final String WS_ERROR_CODE = "\\\"net_error\\\":-7";
    private static final String WS_ERROR_MSG = "WebSocket opening handshake timed out";
    private static long sDestroyDeltaMillis = 100;
    private static volatile boolean sEnabled;
    private volatile boolean mFallbackToWebsocket;
    private long mPrivateProtocolTimeout;
    private long mWebsocketTimeout;

    static {
    }

    public DestroyTimeoutControl(Map<String, Object> r12, boolean r13) {
        this.mFallbackToWebsocket = true;
        if (NetworkParams.getDestroyDeltaMillis() <= 0) goto L5;
        sDestroyDeltaMillis = NetworkParams.getDestroyDeltaMillis();
        long r5 = getConfigTimeoutMilliSeconds(r12, DESTROY_TIME_OUT_MILLS, 0);
        if (r5 < 1000) goto L11;
        sEnabled = true;
        if (r13 == false) goto L20;
        this.mWebsocketTimeout = r5 - sDestroyDeltaMillis;
        if (Logger.debug() == false) goto L39;
        Logger.d(TAG, "Destroy ws timeout: " + this.mWebsocketTimeout);
        return;
    L39:
        return;
    L20:
        long r14 = getConfigTimeoutMilliSeconds(r12, FALLBACK_TIMEOUT_MILLS, WorkRequest.MIN_BACKOFF_MILLIS);
        if (Logger.debug() == false) goto L24;
        Logger.d(TAG, "fallback timeout:" + r14 + " destroy timeout:" + r5);
    L24:
        if (r14 < r5) goto L30;
        this.mFallbackToWebsocket = false;
        if (Logger.debug() == false) goto L28;
        Logger.d(TAG, "Disable fallback to websocket, fallback >= destroy timeout");
    L28:
        this.mPrivateProtocolTimeout = r5 - sDestroyDeltaMillis;
        return;
    L30:
        long r7 = sDestroyDeltaMillis;
        this.mPrivateProtocolTimeout = r14 - r7;
        long r6 = (r5 - r14) - r7;
        this.mWebsocketTimeout = r6;
        if (r6 < 0) goto L33;
        return;
    L33:
        if (Logger.debug() == false) goto L35;
        Logger.d(TAG, "Disable fallback to websocket, timeout <= 0:" + this.mWebsocketTimeout);
    L35:
        this.mFallbackToWebsocket = false;
        return;
    L11:
        if (Logger.debug() == false) goto L38;
        Logger.d(TAG, "Destroy timeout disable: " + r5);
        return;
    L38:
        return;
    L5:
        if (Logger.debug() == false) goto L37;
        Logger.d(TAG, "Destroy delta disable: " + NetworkParams.getDestroyDeltaMillis());
        return;
    }

    public boolean shouldFallbackToWebSocket() {
        if (sEnabled == true) goto L7;
        return true;
    L7:
        return this.mFallbackToWebsocket;
    }

    public long getPrivateProtocolTimeout() {
        if (sEnabled == true) goto L7;
        return 0;
    L7:
        return this.mPrivateProtocolTimeout;
    }

    public long getWebsocketTimeout() {
        if (sEnabled == true) goto L7;
        return 0;
    L7:
        return this.mWebsocketTimeout;
    }

    private static long getConfigTimeoutMilliSeconds(Map<String, Object> r1, String r2, long r3) {
        Map r4 = (Map) r1.get(WsConstants.KEY_HEADERS);
        if (r4 != null) goto L5;
        return r3;
    L5:
        if (r4.isEmpty() == false) goto L8;
        return r3;
    L8:
        if (r4.containsKey(r2) == true) goto L10;
        return r3;
    L10:
        String r5 = (String) r4.get(r2);
        if (TextUtils.isEmpty(r5) == false) goto L18;
        return r3;
    L18:
        int r6 = Integer.valueOf(r5).intValue();     // Catch: Exception -> L17
        if (r6 > 0) goto L16;
        return r3;
    L16:
        return r6;
    L23:
        return r3;
    }

    public static boolean isConnectionTimeout(String r2, boolean r3) {
        if (sEnabled == true) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r2) == false) goto L8;
        return false;
    L8:
        if (r3 == false) goto L16;
        if (r2.contains(WS_ERROR_CODE) == true) goto L12;
        return false;
    L12:
        if (r2.contains(WS_ERROR_MSG) == true) goto L14;
        return false;
    L14:
        return true;
    L16:
        if (r2.contains(PP_TLS_ERROR_CODE) == true) goto L22;
        if (r2.contains(PP_QUIC_ERROR_CODE) == true) goto L20;
        return false;
    L20:
        if (r2.contains(PP_ERROR_MSG) == true) goto L22;
        return false;
    L22:
        return true;
    }
}
