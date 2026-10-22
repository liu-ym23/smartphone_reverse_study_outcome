package com.bytedance.apm.ttnet;

import a.a;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.util.HttpStatus;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.ss.android.common.ApiConstants;
import java.io.EOFException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class TTNetUtils {
    public static final String TAG = "TTNetUtils";
    private static Map<String, Map<String, Integer>> errorMap;

    static {
        errorMap = new HashMap();
    }

    public TTNetUtils() {
    }

    private static void buildError() {
        if (errorMap.isEmpty() == false) goto L6;
        HashMap r0 = new HashMap();
        a.v(101, r0, " Bad Request", HttpStatus.SC_PROCESSING, " Connection timed out");
        a.v(103, r0, " Forbidden", 104, " Gateway Time-out");
        a.v(ApiConstants.OP_ERROR_SESSION_EXPIRE, r0, " Internal Server Error", ApiConstants.OP_ERROR_NAME_EXISTED, " Not Found");
        a.v(ApiConstants.OP_ERROR_INVALID_NAME, r0, " Request Time-out", 108, " Request-URI Too Large");
        errorMap.put("HttpResponseException", r0);
        HashMap r1 = new HashMap();
        a.v(301, r1, "ERR_ABORTED", 302, "ERR_ADDRESS_UNREACHABLE");
        a.v(303, r1, "ERR_CERT_AUTHORITY_INVALID", 304, "ERR_CERT_COMMON_NAME_INVALID");
        a.v(305, r1, "ERR_CERT_DATE_INVALID", 306, "ERR_CONNECTION_ABORTED");
        a.v(307, r1, "ERR_CONNECTION_CLOSED", 308, "ERR_CONNECTION_REFUSED");
        a.v(309, r1, "ERR_CONNECTION_RESET", 310, "ERR_CONNECTION_TIMED_OUT");
        a.v(311, r1, "ERR_EMPTY_RESPONSE", 312, "ERR_HTTP2_PING_FAILED");
        a.v(313, r1, "ERR_INCOMPLETE_CHUNKED_ENCODING", 314, "ERR_INTERNET_DISCONNECTED");
        a.v(315, r1, "ERR_NAME_NOT_RESOLVED", TypedValues.AttributesType.TYPE_PATH_ROTATE, "ERR_NETWORK_ACCESS_DENIED");
        a.v(TypedValues.AttributesType.TYPE_EASING, r1, "ERR_PROXY_CONNECTION_FAILED", TypedValues.AttributesType.TYPE_PIVOT_TARGET, "ERR_SOCKET_NOT_CONNECTED");
        a.v(319, r1, "ERR_SSL_BAD_RECORD_MAC_ALERT", 320, "ERR_SSL_PROTOCOL_ERROR");
        a.v(321, r1, "ERR_TIMED_OUT", 322, "ERR_TTNET_APP_TIMED_OUT");
        a.v(323, r1, "ERR_TTNET_APP_UPLOAD_EXCEPTION", 324, "ERR_TUNNEL_CONNECTION_FAILED");
        errorMap.put("NetworkExceptionImpl", r1);
        HashMap r2 = new HashMap();
        r2.put("ERR_NETWORK_CHANGED", 401);
        errorMap.put("QuicExceptionImpl", r2);
        HashMap r3 = new HashMap();
        r3.put(" Unexpected end of ZLIB input stream", 501);
        errorMap.put("EOFException", r3);
        HashMap r4 = new HashMap();
        a.v(601, r4, " unexpected end of stream on Connection", TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE, " Unexpected request usage");
        errorMap.put("IOException", r4);
        HashMap r5 = new HashMap();
        r5.put("Cronet internal request fail", Integer.valueOf(TypedValues.TransitionType.TYPE_FROM));
        errorMap.put("Exception", r5);
        HashMap r6 = new HashMap();
        a.v(801, r6, " Content received is less than Content-Length", 802, " expected bytes but received");
        r6.put(" unexpected end of stream", 803);
        errorMap.put("ProtocolException", r6);
        HashMap r7 = new HashMap();
        a.v(TypedValues.Custom.TYPE_FLOAT, r7, " Connection closed by peer", TypedValues.Custom.TYPE_COLOR, " Read error");
        r7.put(" SSL handshake aborted", Integer.valueOf(TypedValues.Custom.TYPE_STRING));
        errorMap.put("SSLException", r7);
        HashMap r8 = new HashMap();
        a.v(1001, r8, " Connection closed by peer", 1002, " Handshake failed");
        r8.put(" SSL handshake aborted", 1003);
        errorMap.put("SSLHandshakeException", r8);
        HashMap r9 = new HashMap();
        r9.put(" Hostname not verified", 1101);
        errorMap.put("SSLPeerUnverifiedException", r9);
        HashMap r10 = new HashMap();
        r10.put(" Read error", 1201);
        errorMap.put("SSLProtocolException", r10);
        return;
    }

    public static int getSubStatus(Throwable r5) {
        int r0 = -1;
        if (r5 != null) goto L5;
        return -1;
    L5:
        buildError();
        String r1 = r5.getMessage();
        if (TextUtils.isEmpty(r1) == false) goto L8;
        return -1;
    L8:
        int r2 = r1.indexOf(44);
        if (r2 <= 0) goto L11;
        r1 = r1.substring(0, r2);
    L11:
        Map<String, Integer> r3 = errorMap.get(r5.getClass().getSimpleName());
        if (r3 != null) goto L14;
    L23:
        if (r0 < 0) goto L25;
        return r0;
    L25:
        if ((r5 instanceof HttpResponseException) == false) goto L28;
        return 199;
    L28:
        if ((r5 instanceof EOFException) == false) goto L31;
        return 599;
    L31:
        if ((r5 instanceof IOException) == false) goto L40;
        return 699;
    L40:
        return r0;
    L14:
        if (r3.isEmpty() == true) goto L23;
        Iterator<Map.Entry<String, Integer>> r4 = r3.entrySet().iterator();
    L17:
        if (r4.hasNext() == false) goto L23;
        Map.Entry<String, Integer> r6 = r4.next();
        if (r1.contains(r6.getKey()) == false) goto L17;
        Integer r7 = r6.getValue();
        if (r7 == null) goto L23;
        r0 = r7.intValue();
        goto L23
    }

    public static void updateNetAllExtraInfo(HttpRequestInfo r0, JSONObject r1) {
        updateRequestInfo(r0, r1);
    }

    public static void updateNetErrorExtraInfo(HttpRequestInfo r1, Throwable r2, JSONObject r3) {
        if (r3 == null) goto L5;
        if (r2 == null) goto L5;
        r3.put(SlardarSettingsConsts.EXT_SUBSTATUS, getSubStatus(r2));     // Catch: Throwable -> L7
    L5:
        updateRequestInfo(r1, r3);
    }

    private static void updateRequestInfo(HttpRequestInfo r2, JSONObject r3) {
        if (r3 == null) goto L9;
        if (r2 == null) goto L10;
        r3.put(SlardarSettingsConsts.EXT_REQUEST_HEADER, r2.requestHeaders);     // Catch: Throwable -> L6
        r3.put(SlardarSettingsConsts.EXT_RESPONSE_HEADER, r2.responseHeaders);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L10:
        return;
    }
}
