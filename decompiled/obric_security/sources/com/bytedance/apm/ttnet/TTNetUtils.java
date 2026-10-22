package com.bytedance.apm.ttnet;

import android.text.TextUtils;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.obric.netdetect.Modules.HttpProbe.HttpProbeResult;
import com.ttnet.org.chromium.net.impl.NetworkExceptionImpl;
import com.ttnet.org.chromium.net.impl.QuicExceptionImpl;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class TTNetUtils {
    public static final String TAG = "TTNetUtils";
    private static Map<String, Map<String, Integer>> errorMap;

    public TTNetUtils() {
    }

    static {
        errorMap = new HashMap();
    }

    private static void buildError() {
        if (errorMap.isEmpty() == false) goto L6;
        HashMap r0 = new HashMap();
        r0.put(" Bad Request", 101);
        r0.put(" Connection timed out", 102);
        r0.put(" Forbidden", 103);
        r0.put(" Gateway Time-out", 104);
        r0.put(" Internal Server Error", 105);
        r0.put(" Not Found", 106);
        r0.put(" Request Time-out", 107);
        r0.put(" Request-URI Too Large", 108);
        errorMap.put(HttpResponseException.class.getSimpleName(), r0);
        HashMap r1 = new HashMap();
        r1.put("ERR_ABORTED", 301);
        r1.put("ERR_ADDRESS_UNREACHABLE", 302);
        r1.put("ERR_CERT_AUTHORITY_INVALID", 303);
        r1.put("ERR_CERT_COMMON_NAME_INVALID", 304);
        r1.put("ERR_CERT_DATE_INVALID", 305);
        r1.put("ERR_CONNECTION_ABORTED", 306);
        r1.put("ERR_CONNECTION_CLOSED", 307);
        r1.put("ERR_CONNECTION_REFUSED", 308);
        r1.put("ERR_CONNECTION_RESET", 309);
        r1.put("ERR_CONNECTION_TIMED_OUT", 310);
        r1.put("ERR_EMPTY_RESPONSE", 311);
        r1.put("ERR_HTTP2_PING_FAILED", 312);
        r1.put("ERR_INCOMPLETE_CHUNKED_ENCODING", 313);
        r1.put("ERR_INTERNET_DISCONNECTED", 314);
        r1.put("ERR_NAME_NOT_RESOLVED", 315);
        r1.put("ERR_NETWORK_ACCESS_DENIED", 316);
        r1.put("ERR_PROXY_CONNECTION_FAILED", 317);
        r1.put("ERR_SOCKET_NOT_CONNECTED", 318);
        r1.put("ERR_SSL_BAD_RECORD_MAC_ALERT", 319);
        r1.put("ERR_SSL_PROTOCOL_ERROR", 320);
        r1.put("ERR_TIMED_OUT", 321);
        r1.put("ERR_TTNET_APP_TIMED_OUT", 322);
        r1.put("ERR_TTNET_APP_UPLOAD_EXCEPTION", 323);
        r1.put("ERR_TUNNEL_CONNECTION_FAILED", 324);
        errorMap.put(NetworkExceptionImpl.class.getSimpleName(), r1);
        HashMap r2 = new HashMap();
        r2.put("ERR_NETWORK_CHANGED", 401);
        errorMap.put(QuicExceptionImpl.class.getSimpleName(), r2);
        HashMap r3 = new HashMap();
        r3.put(" Unexpected end of ZLIB input stream", 501);
        errorMap.put(EOFException.class.getSimpleName(), r3);
        HashMap r4 = new HashMap();
        r4.put(" unexpected end of stream on Connection", 601);
        r4.put(" Unexpected request usage", 602);
        errorMap.put(IOException.class.getSimpleName(), r4);
        HashMap r5 = new HashMap();
        r5.put("Cronet internal request fail", 701);
        errorMap.put(Exception.class.getSimpleName(), r5);
        HashMap r6 = new HashMap();
        r6.put(" Content received is less than Content-Length", 801);
        r6.put(" expected bytes but received", 802);
        r6.put(" unexpected end of stream", 803);
        errorMap.put(ProtocolException.class.getSimpleName(), r6);
        HashMap r7 = new HashMap();
        r7.put(" Connection closed by peer", 901);
        r7.put(" Read error", 902);
        r7.put(" SSL handshake aborted", 903);
        errorMap.put(SSLException.class.getSimpleName(), r7);
        HashMap r8 = new HashMap();
        r8.put(" Connection closed by peer", 1001);
        r8.put(" Handshake failed", 1002);
        r8.put(" SSL handshake aborted", 1003);
        errorMap.put(SSLHandshakeException.class.getSimpleName(), r8);
        HashMap r9 = new HashMap();
        r9.put(" Hostname not verified", 1101);
        errorMap.put(SSLPeerUnverifiedException.class.getSimpleName(), r9);
        HashMap r10 = new HashMap();
        r10.put(" Read error", 1201);
        errorMap.put(SSLProtocolException.class.getSimpleName(), r10);
        return;
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
        return HttpProbeResult.FAILED_RESPONSE_CODE;
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
}
